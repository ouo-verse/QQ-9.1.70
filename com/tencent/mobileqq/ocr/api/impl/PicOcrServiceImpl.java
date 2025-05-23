package com.tencent.mobileqq.ocr.api.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gallery.picocr.c;
import com.tencent.mobileqq.gallery.picocr.d;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo;
import com.tencent.mobileqq.ocr.api.IPicOcrService;
import com.tencent.mobileqq.ocr.e;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.bw;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import mqq.app.AppRuntime;
import tencent.im.msg.im_msg_body$RichText;

/* loaded from: classes16.dex */
public class PicOcrServiceImpl implements IPicOcrService {
    static IPatchRedirector $redirector_ = null;
    public static final int CACHE_SIZE = 10;
    public static final String TAG = "PicOcrServiceImpl";
    boolean addHandler;
    private AppInterface mApp;
    protected ITransFileController mFileController;
    private com.tencent.mobileqq.ocr.req.a mReqContext;
    private HashMap<String, c> mResultCache;
    protected TransProcessorHandler mTransProcessorHandler;
    protected String uin;

    /* loaded from: classes16.dex */
    class a extends TransProcessorHandler {
        static IPatchRedirector $redirector_;

        a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PicOcrServiceImpl.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            PicOcrHandler picOcrHandler;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            FileMsg fileMsg = (FileMsg) message.obj;
            if (fileMsg != null && fileMsg.commandId == 76) {
                int i3 = message.what;
                if (i3 != 1001) {
                    if (i3 != 1008) {
                        switch (i3) {
                            case 1003:
                                if (QLog.isColorLevel()) {
                                    QLog.d(PicOcrServiceImpl.TAG, 2, "handleMessage success resId:" + fileMsg.serverPath);
                                    return;
                                }
                                return;
                            case 1004:
                                if (QLog.isColorLevel()) {
                                    QLog.d(PicOcrServiceImpl.TAG, 2, "handleMessage upload cancel:" + fileMsg.serverPath);
                                    return;
                                }
                                return;
                            case 1005:
                                if (QLog.isColorLevel()) {
                                    QLog.d(PicOcrServiceImpl.TAG, 2, "handleMessage upload error:" + fileMsg.serverPath);
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                    Bdh_extinfo.CommFileExtRsp commFileExtRsp = new Bdh_extinfo.CommFileExtRsp();
                    byte[] bArr = fileMsg.bdhExtendInfo;
                    String str = "";
                    if (bArr != null) {
                        try {
                            commFileExtRsp.mergeFrom(bArr);
                            if (commFileExtRsp.bytes_download_url.has()) {
                                str = commFileExtRsp.bytes_download_url.get().toStringUtf8();
                            }
                        } catch (Exception unused) {
                            QLog.i(PicOcrServiceImpl.TAG, 2, "extRsp.mergeFrom(file.bdhExtendInfo) failed!");
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(PicOcrServiceImpl.TAG, 2, "handleMessage finished resId:" + fileMsg.serverPath + ", url:" + str);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        PicOcrServiceImpl.this.mReqContext.f254776l = str;
                        if (PicOcrServiceImpl.this.mApp != null && (picOcrHandler = (PicOcrHandler) PicOcrServiceImpl.this.mApp.getBusinessHandler(PicOcrHandler.f254691d)) != null) {
                            picOcrHandler.F2(PicOcrServiceImpl.this.mReqContext.f254776l, PicOcrServiceImpl.this.mReqContext.f254775k, PicOcrServiceImpl.this.mReqContext.f254770f, PicOcrServiceImpl.this.mReqContext.f254771g, PicOcrServiceImpl.this.mReqContext.f254766b, (int) PicOcrServiceImpl.this.mReqContext.f254769e, PicOcrServiceImpl.this.mReqContext.f254773i, PicOcrServiceImpl.this.mReqContext.f254774j, PicOcrServiceImpl.this.mReqContext.f254772h, PicOcrServiceImpl.this.mReqContext.f254765a);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i(PicOcrServiceImpl.TAG, 2, "handleMessage start!");
                }
            }
        }
    }

    public PicOcrServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mResultCache = new HashMap<>();
        this.addHandler = false;
        this.mTransProcessorHandler = new a(ThreadManagerV2.getSubThreadLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0142  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void tryCompressIfNeeded(com.tencent.mobileqq.gallery.picocr.a aVar, com.tencent.mobileqq.ocr.req.a aVar2) {
        int i3;
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i16 = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(aVar2.f254767c, options);
        int i17 = options.outWidth;
        int i18 = options.outHeight;
        File file = new File(aVar2.f254767c);
        long length = file.length();
        if (length < 6750000) {
            aVar2.f254769e = file.length();
            aVar2.f254773i = options.outWidth;
            aVar2.f254774j = options.outHeight;
            aVar2.f254771g = aVar2.f254770f;
            aVar2.f254768d = aVar2.f254767c;
        } else {
            if (length > 13500000) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            options.inSampleSize = i3;
            options.inJustDecodeBounds = false;
            Bitmap d16 = d.d(aVar2.f254767c, options, 1, 4);
            if (d16 != null) {
                int[] iArr = new int[2];
                String b16 = d.b(d16, aVar2.f254767c, iArr);
                aVar2.f254768d = b16;
                if (FileUtils.fileExistsAndNotEmpty(b16)) {
                    aVar2.f254773i = iArr[0];
                    aVar2.f254774j = iArr[1];
                    aVar2.f254769e = new File(aVar2.f254768d).length();
                    aVar2.f254771g = d.a(aVar2.f254768d);
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("param_length", (file.length() / 1024) + "");
                    hashMap.put("param_width", String.valueOf(i17));
                    hashMap.put("param_height", String.valueOf(i18));
                    hashMap.put("param_size", (i17 * i18) + "");
                    hashMap.put("param_complength", (aVar2.f254769e / 1024) + "");
                    hashMap.put("param_compwidth", String.valueOf(aVar2.f254773i));
                    hashMap.put("param_compheight", String.valueOf(aVar2.f254774j));
                    hashMap.put("param_compsize", (aVar2.f254773i * aVar2.f254774j) + "");
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actPicOcrCompressInfo", true, 0L, 0L, hashMap, "");
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, "tryCompressIfNeeded:" + aVar2.f() + ", oriLength:" + (file.length() / 1024) + ", oriSize:[" + i17 + "*" + i18 + "]");
                    }
                    HashMap<String, String> hashMap2 = new HashMap<>();
                    hashMap2.put("param_type", i16 + "");
                    hashMap2.put("param_length", (file.length() / 1024) + "");
                    hashMap2.put("param_width", String.valueOf(i17));
                    hashMap2.put("param_height", String.valueOf(i18));
                    hashMap2.put("param_size", (i17 * i18) + "");
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actPicOcrCompressType", true, 0L, 0L, hashMap2, "");
                }
            }
        }
        i16 = 0;
        if (QLog.isColorLevel()) {
        }
        HashMap<String, String> hashMap22 = new HashMap<>();
        hashMap22.put("param_type", i16 + "");
        hashMap22.put("param_length", (file.length() / 1024) + "");
        hashMap22.put("param_width", String.valueOf(i17));
        hashMap22.put("param_height", String.valueOf(i18));
        hashMap22.put("param_size", (i17 * i18) + "");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actPicOcrCompressType", true, 0L, 0L, hashMap22, "");
    }

    public c getCacheOcrResult(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (c) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        if (!TextUtils.isEmpty(str) && this.mResultCache.containsKey(str)) {
            return this.mResultCache.get(str);
        }
        return null;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        this.mFileController = (ITransFileController) appRuntime.getRuntimeService(ITransFileController.class, "");
        if (appRuntime instanceof AppInterface) {
            this.mApp = (AppInterface) appRuntime;
        }
        this.uin = bw.a();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        ITransFileController iTransFileController = this.mFileController;
        if (iTransFileController != null) {
            iTransFileController.removeHandle(this.mTransProcessorHandler);
            this.mTransProcessorHandler = null;
        }
    }

    @Override // com.tencent.mobileqq.ocr.api.IPicOcrService
    public void putOcrResult(String str, c cVar) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) cVar);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.mResultCache.size() >= 10) {
            Iterator<String> it = this.mResultCache.keySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    str2 = it.next();
                    if (!str2.equals(str)) {
                        break;
                    }
                } else {
                    str2 = "";
                    break;
                }
            }
            this.mResultCache.remove(str2);
        }
        if (!TextUtils.isEmpty(str) && cVar != null) {
            this.mResultCache.put(str, cVar);
        }
    }

    @Override // com.tencent.mobileqq.ocr.api.IPicOcrService
    public void requestOcr(com.tencent.mobileqq.ocr.req.a aVar, com.tencent.mobileqq.gallery.picocr.a aVar2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar, (Object) aVar2);
        } else {
            ThreadManagerV2.excute(new Runnable(aVar, aVar2) { // from class: com.tencent.mobileqq.ocr.api.impl.PicOcrServiceImpl.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ com.tencent.mobileqq.ocr.req.a f254700d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ com.tencent.mobileqq.gallery.picocr.a f254701e;

                {
                    this.f254700d = aVar;
                    this.f254701e = aVar2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, PicOcrServiceImpl.this, aVar, aVar2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    c cacheOcrResult;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (TextUtils.isEmpty(this.f254700d.f254770f) || this.f254700d.f254772h) {
                        com.tencent.mobileqq.ocr.req.a aVar3 = this.f254700d;
                        aVar3.f254770f = d.a(aVar3.f254767c);
                        this.f254700d.f254772h = false;
                    }
                    if (PicOcrServiceImpl.this.mResultCache.isEmpty() || (cacheOcrResult = PicOcrServiceImpl.this.getCacheOcrResult(this.f254700d.f254770f)) == null) {
                        PicOcrServiceImpl.this.tryCompressIfNeeded(this.f254701e, this.f254700d);
                        if (this.f254700d.a()) {
                            PicOcrServiceImpl.this.uploadOcrPic(this.f254701e, this.f254700d);
                            this.f254701e.b();
                            return;
                        } else {
                            this.f254701e.onUpdate(100, false, new c());
                            return;
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.e(PicOcrServiceImpl.TAG, 2, "requestOcr cacheRsp:" + cacheOcrResult.toString());
                    }
                    this.f254701e.c(cacheOcrResult);
                }
            }, 64, null, true);
        }
    }

    public void uploadOcrPic(com.tencent.mobileqq.gallery.picocr.a aVar, com.tencent.mobileqq.ocr.req.a aVar2) {
        boolean z16;
        String str;
        TransProcessorHandler transProcessorHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar, (Object) aVar2);
            return;
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "uploadOcrPic NetWork exception!");
            }
            aVar.onUpdate(100, false, new c());
            return;
        }
        this.mReqContext = aVar2;
        if (!this.addHandler && (transProcessorHandler = this.mTransProcessorHandler) != null && this.mFileController != null) {
            transProcessorHandler.addFilter(BDHCommonUploadProcessor.class);
            this.mFileController.addHandle(this.mTransProcessorHandler);
            this.addHandler = true;
        }
        aVar2.f254775k = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "uploadOcrPic:" + aVar2.f());
        }
        String str2 = aVar2.f254768d;
        if (str2 != null && !str2.equalsIgnoreCase(aVar2.f254767c) && (str = e.f254755a) != null && str2.startsWith(str)) {
            z16 = true;
        } else {
            z16 = false;
        }
        ad adVar = new ad(aVar, z16, str2, aVar2) { // from class: com.tencent.mobileqq.ocr.api.impl.PicOcrServiceImpl.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.gallery.picocr.a f254694d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ boolean f254695e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f254696f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.ocr.req.a f254697h;

            {
                this.f254694d = aVar;
                this.f254695e = z16;
                this.f254696f = str2;
                this.f254697h = aVar2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, PicOcrServiceImpl.this, aVar, Boolean.valueOf(z16), str2, aVar2);
                }
            }

            @Override // com.tencent.mobileqq.pic.ad
            public MessageRecord g(im_msg_body$RichText im_msg_body_richtext) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (MessageRecord) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) im_msg_body_richtext);
                }
                return null;
            }

            @Override // com.tencent.mobileqq.pic.ad
            public void q(ad.a aVar3) {
                String str3;
                com.tencent.mobileqq.gallery.picocr.a aVar4;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) aVar3);
                    return;
                }
                if (aVar3 != null) {
                    int i3 = aVar3.f258597a;
                    if (QLog.isColorLevel()) {
                        QLog.d(PicOcrServiceImpl.TAG, 2, "upCallBack res:" + i3);
                    }
                    if (-1 == i3 && (aVar4 = this.f254694d) != null) {
                        aVar4.onUpdate(100, false, new c());
                    }
                    if (-1 == i3 || i3 == 0) {
                        if (this.f254695e) {
                            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.ocr.api.impl.PicOcrServiceImpl.2.1
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    FileUtils.deleteFile(AnonymousClass2.this.f254696f);
                                    if (QLog.isColorLevel()) {
                                        QLog.d(PicOcrServiceImpl.TAG, 2, "delete compress path: " + AnonymousClass2.this.f254696f);
                                    }
                                }
                            }, 64, null, true);
                        }
                        HashMap<String, String> hashMap = new HashMap<>();
                        if (i3 == 0) {
                            str3 = "0";
                        } else {
                            str3 = "1";
                        }
                        hashMap.put("param_upload", str3);
                        hashMap.put("param_md5", this.f254697h.f254770f);
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actUploadProcessState", true, 0L, 0L, hashMap, "");
                    }
                }
            }

            @Override // com.tencent.mobileqq.pic.ad
            public void r(ad.a aVar3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) aVar3);
                }
            }
        };
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mFileType = 24;
        transferRequest.mCommandId = 76;
        transferRequest.mRichTag = "picorcupload";
        transferRequest.mUpCallBack = adVar;
        transferRequest.mLocalPath = aVar2.f254768d;
        String str3 = this.uin;
        transferRequest.mSelfUin = str3;
        transferRequest.mPeerUin = str3;
        transferRequest.mUniseq = aVar2.f254775k;
        transferRequest.mIsUp = true;
        Bdh_extinfo.CommFileExtReq commFileExtReq = new Bdh_extinfo.CommFileExtReq();
        commFileExtReq.uint32_action_type.set(0);
        commFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString()));
        transferRequest.mExtentionInfo = commFileExtReq.toByteArray();
        ITransFileController iTransFileController = this.mFileController;
        if (iTransFileController != null) {
            iTransFileController.transferAsync(transferRequest);
        }
    }
}
