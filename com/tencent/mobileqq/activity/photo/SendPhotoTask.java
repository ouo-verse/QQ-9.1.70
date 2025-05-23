package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.shortvideo.SendVideoInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.guild.api.IGuildSpeechApi;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.pic.p;
import com.tencent.mobileqq.pic.v;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.richmedia.RichmediaService;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.utils.an;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SendByFile;
import com.tencent.mobileqq.utils.bm;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes10.dex */
public class SendPhotoTask implements Runnable {
    static IPatchRedirector $redirector_;
    int C;
    boolean D;
    int E;
    int F;
    boolean G;
    boolean H;
    Intent I;
    ArrayList<CompressInfo> J;
    long K;
    long L;
    int M;
    HashMap<String, PhotoSendParams> N;
    int P;
    String Q;

    /* renamed from: d, reason: collision with root package name */
    WeakReference<BaseActivity> f184128d;

    /* renamed from: e, reason: collision with root package name */
    Handler f184129e;

    /* renamed from: f, reason: collision with root package name */
    ArrayList<String> f184130f;

    /* renamed from: h, reason: collision with root package name */
    ArrayList<String> f184131h;

    /* renamed from: i, reason: collision with root package name */
    HashMap<Integer, SendVideoInfo> f184132i;

    /* renamed from: m, reason: collision with root package name */
    public String f184133m;

    public SendPhotoTask(BaseActivity baseActivity, Intent intent, Handler handler) {
        HashMap<String, PhotoSendParams> hashMap;
        ArrayList<String> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, baseActivity, intent, handler);
            return;
        }
        this.f184129e = null;
        this.D = true;
        this.G = false;
        this.J = new ArrayList<>();
        this.K = 0L;
        this.L = 0L;
        this.M = 2000;
        this.P = 0;
        this.f184128d = new WeakReference<>(baseActivity);
        this.f184129e = handler;
        this.I = baseActivity.getIntent();
        if (intent != null) {
            this.I = intent;
        }
        e(this.I);
        if (this.f184129e != null) {
            ArrayList<String> arrayList2 = this.f184130f;
            if ((arrayList2 != null && !arrayList2.isEmpty()) || (((hashMap = this.N) != null && !hashMap.isEmpty()) || ((arrayList = this.f184131h) != null && !arrayList.isEmpty()))) {
                this.f184129e.sendEmptyMessage(1);
            } else {
                this.f184129e.sendEmptyMessage(4);
            }
        }
    }

    private boolean n() {
        if (this.I.hasExtra("presend_handler")) {
            if (QLog.isColorLevel()) {
                QLog.d("SendPhotoTask", 2, "presendPic ,sendPhotoTask return directly!");
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean p(p pVar) {
        if (pVar.C.f258713h != 10014) {
            return false;
        }
        IGuildSpeechApi iGuildSpeechApi = (IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class);
        v vVar = pVar.C;
        boolean isNeedInterceptQrCode = iGuildSpeechApi.isNeedInterceptQrCode(vVar.C, vVar.f258715m);
        if (QLog.isColorLevel()) {
            QLog.i("SendPhotoTask", 1, "guildId: " + pVar.C.C + " isNeedInterceptQrCode:" + isNeedInterceptQrCode);
        }
        if (!isNeedInterceptQrCode) {
            return false;
        }
        ScannerResult decodeQQCodeFromFile = ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).decodeQQCodeFromFile(Uri.parse("file://" + new File(pVar.C.K).getAbsolutePath()), (Context) BaseApplication.getContext(), 3, false);
        if (QLog.isColorLevel()) {
            QLog.i("SendPhotoTask", 1, "guildId: " + pVar.C.C + " result:" + decodeQQCodeFromFile);
        }
        if (decodeQQCodeFromFile == null || (!decodeQQCodeFromFile.l() && !decodeQQCodeFromFile.j())) {
            return false;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.photo.SendPhotoTask.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SendPhotoTask.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    ((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).showInterceptQrCodeSendToast();
                }
            }
        });
        return true;
    }

    private boolean s() {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26 = !TextUtils.isEmpty(this.Q);
        HashMap<Integer, SendVideoInfo> hashMap = this.f184132i;
        if (hashMap != null && !hashMap.isEmpty()) {
            z16 = true;
        } else {
            z16 = false;
        }
        HashMap<String, PhotoSendParams> hashMap2 = this.N;
        if (hashMap2 != null && !hashMap2.isEmpty()) {
            z17 = true;
        } else {
            z17 = false;
        }
        ArrayList<String> arrayList = this.f184131h;
        if (arrayList != null && !arrayList.isEmpty()) {
            z18 = true;
        } else {
            z18 = false;
        }
        ArrayList<String> arrayList2 = this.f184130f;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            z19 = true;
        } else {
            z19 = false;
        }
        QLog.i("SendPhotoTask", 1, "isSendTextPicsMixed hasComment=" + z26 + ",hasVideo=" + z16 + ",hasQzonePhoto=" + z17 + ",hasSelectedFile=" + z18 + ",hasSelectedPhoto=" + z19);
        if (z26 && !z16 && !z17 && !z18 && z19) {
            return true;
        }
        return false;
    }

    private boolean t(int i3) {
        if (i3 != 1042 && i3 == 1054) {
            return true;
        }
        return false;
    }

    protected boolean a(p pVar, v vVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) pVar, (Object) vVar)).booleanValue();
        }
        if (!pVar.f(vVar)) {
            QLog.e("SendPhotoTask", 2, "sendPhotoTask. failed to bind the UpInfo to the sendReq");
            return false;
        }
        return true;
    }

    protected boolean b(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, i3)).booleanValue();
        }
        this.I.putExtra(PeakConstants.PHOTO_SEND_PATH, str);
        this.I.putExtra(PeakConstants.PHOTO_SEND_PATH_INDEX, i3);
        this.I.putExtra("delay_show_progress_time_in_ms", this.M);
        p createPicReq = ((IPicBus) QRoute.api(IPicBus.class)).createPicReq(2, this.C);
        createPicReq.I = this.I.getIntExtra("KEY_MSG_FORWARD_ID", -1);
        v g16 = g(this.C);
        if (!a(createPicReq, g16)) {
            return false;
        }
        if (this.D) {
            if (!m(g16)) {
                return false;
            }
        } else {
            g16.K = str;
        }
        g16.f258840z0.f258814k = MD5Utils.encodeFileHexStr(str);
        w(this.f184128d.get(), createPicReq);
        this.L = g16.D;
        return true;
    }

    protected boolean c(String str, Parcelable parcelable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str, (Object) parcelable)).booleanValue();
        }
        this.I.putExtra(PeakConstants.PHOTO_SEND_PATH, str);
        this.I.putExtra(PeakConstants.PHOTO_SEND_QZONE_PIC_PARAMS, parcelable);
        this.I.putExtra(PeakConstants.SEND_BUSINESS_TYPE, 1045);
        p createPicReq = ((IPicBus) QRoute.api(IPicBus.class)).createPicReq(2, 1045);
        v g16 = g(1045);
        if (!a(createPicReq, g16)) {
            return false;
        }
        if (g16 != null) {
            g16.K = null;
        }
        w(this.f184128d.get(), createPicReq);
        return true;
    }

    protected void d(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) intent);
            return;
        }
        com.tencent.mobileqq.activity.shortvideo.h hVar = new com.tencent.mobileqq.activity.shortvideo.h(this.f184128d.get(), intent);
        hVar.g();
        hVar.d();
    }

    protected void e(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        if (intent == null) {
            return;
        }
        this.C = intent.getIntExtra(PeakConstants.SEND_BUSINESS_TYPE, -1);
        this.D = intent.getBooleanExtra("PicContants.NEED_COMPRESS", true);
        this.E = intent.getIntExtra("uintype", 1003);
        this.G = intent.getBooleanExtra(PeakConstants.IS_WAIT_DEST_RESULT, false);
        this.H = intent.getBooleanExtra(PeakConstants.SEND_IN_BACKGROUND, false);
        this.f184130f = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        this.f184131h = this.I.getStringArrayListExtra(PeakConstants.PHOTO_PATHS_BY_FILE);
        this.f184132i = (HashMap) intent.getSerializableExtra(PeakConstants.VIDEO_INFO);
        this.f184133m = intent.getStringExtra("uin");
        this.P = intent.getIntExtra(PeakConstants.SEND_SIZE_SPEC, 0);
        this.F = intent.getIntExtra(ConfessInfo.KEY_CONFESS_TOPICID, 0);
        HashMap<String, PhotoSendParams> hashMap = (HashMap) intent.getSerializableExtra(PeakConstants.PHOTO_SEND_PIC_TYPE);
        this.N = hashMap;
        if (hashMap == null) {
            this.N = new HashMap<>();
        }
        this.Q = intent.getStringExtra(PeakConstants.SEND_COMMENT_CONTENT);
        if (QLog.isColorLevel()) {
            QLog.d("SendPhotoTask", 2, " sendPhotoTask(),  mBusiType :" + this.C + ", mNeedCompress:" + this.D + ", mCurType:" + this.E + ",mIsWaitForResult:" + this.G + ",picQualityType: " + this.P + ",mSendBackground = " + this.H + "mPaths :" + Arrays.toString(this.f184130f.toArray()) + ", PhotoTypeSize:" + this.N.size() + ",mCommentContent = " + this.Q);
        }
    }

    protected CompressInfo f(int i3, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (CompressInfo) iPatchRedirector.redirect((short) 19, (Object) this, i3, (Object) intent);
        }
        return ((IPicBus) QRoute.api(IPicBus.class)).createCompressInfo(i3, intent);
    }

    v g(int i3) {
        return ((IPicBus) QRoute.api(IPicBus.class)).createPicUploadInfo(i3, this.I);
    }

    protected ArrayList<Integer> h(CompressInfo compressInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (ArrayList) iPatchRedirector.redirect((short) 23, (Object) this, (Object) compressInfo);
        }
        return ((IPicUtil) QRoute.api(IPicUtil.class)).getSliceInfos(compressInfo.H);
    }

    protected void i() {
        BaseActivity baseActivity;
        QQAppInterface qQAppInterface;
        QQMessageFacade messageFacade;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (TextUtils.isEmpty(this.Q)) {
            return;
        }
        WeakReference<BaseActivity> weakReference = this.f184128d;
        if (weakReference != null) {
            baseActivity = weakReference.get();
        } else {
            baseActivity = null;
        }
        if (baseActivity == null || (qQAppInterface = baseActivity.app) == null || (messageFacade = qQAppInterface.getMessageFacade()) == null) {
            return;
        }
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        String str = this.f184133m;
        messageFacade.a(q.B(qQAppInterface, currentAccountUin, str, str, this.E, (byte) 1, (byte) 0, (short) 0, this.Q), null);
        com.tencent.mobileqq.activity.photo.aiocomment.d.b("0X800BEFA");
    }

    protected ArrayList<String> j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < this.f184130f.size(); i3++) {
            String str = this.f184130f.get(i3);
            if (q(str)) {
                QLog.e("SendPhotoTask", 2, "sendPhotoTask. path invalid,path:" + str);
            } else if (!o(i3, str) && !n() && b(str, i3)) {
                arrayList.add(str);
                if (QLog.isColorLevel()) {
                    QLog.d("SendPhotoTask", 2, "sendPhotoTask, send Photo : " + str);
                }
            }
        }
        if (arrayList.size() >= 5 && this.E == 1) {
            if (QLog.isColorLevel()) {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    QLog.d("SendPhotoTask", 2, "sendPhotoTask,  mSendPaths path=", it.next());
                }
                QLog.d("SendPhotoTask", 2, "sendPhotoTask,  lastMessageUniseq=", Long.valueOf(this.L));
            }
            y(arrayList);
        } else if (QLog.isColorLevel()) {
            QLog.d("SendPhotoTask", 2, "sendPhotoTask,  mSendPaths size=", Integer.valueOf(arrayList.size()));
        }
        return arrayList;
    }

    protected ArrayList<String> k() {
        BaseActivity baseActivity;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        WeakReference<BaseActivity> weakReference = this.f184128d;
        if (weakReference != null) {
            baseActivity = weakReference.get();
        } else {
            baseActivity = null;
        }
        if (baseActivity == null) {
            return new ArrayList<>();
        }
        QQAppInterface qQAppInterface = baseActivity.app;
        if (qQAppInterface == null) {
            return new ArrayList<>();
        }
        MixedMsgManager mixedMsgManager = (MixedMsgManager) qQAppInterface.getManager(QQManagerFactory.MIXED_MSG_MANAGER);
        if (mixedMsgManager == null) {
            return new ArrayList<>();
        }
        String str = this.f184133m;
        int i3 = this.E;
        ArrayList<String> arrayList = this.f184130f;
        if (this.P == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        mixedMsgManager.A(qQAppInterface, str, i3, arrayList, z16, this.Q, new ArrayList<>(), null, null);
        com.tencent.mobileqq.activity.photo.aiocomment.d.b("0X800BEFA");
        return this.f184130f;
    }

    protected ArrayList<String> l() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (ArrayList) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.N.size() > 0) {
            for (String str2 : this.N.keySet()) {
                PhotoSendParams photoSendParams = this.N.get(str2);
                if (!q(str2) && photoSendParams != null && !TextUtils.isEmpty(photoSendParams.rawMd5) && photoSendParams.fileSize > 0 && !TextUtils.isEmpty(photoSendParams.rawDownloadUrl)) {
                    if (c(str2, photoSendParams)) {
                        arrayList.add(str2);
                        if (QLog.isColorLevel()) {
                            QLog.i("SendPhotoTask", 2, "sendPhotoTask Qzone path:" + str2 + ", photoMd5:" + photoSendParams.rawMd5);
                        }
                    }
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("sendPhotoTask. path invalid, path:");
                    sb5.append(str2);
                    sb5.append(", params:");
                    if (photoSendParams != null) {
                        str = photoSendParams.toString();
                    } else {
                        str = "";
                    }
                    sb5.append(str);
                    QLog.e("SendPhotoTask", 2, sb5.toString());
                }
            }
        }
        return arrayList;
    }

    protected boolean m(v vVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) vVar)).booleanValue();
        }
        CompressInfo f16 = f(this.C, this.I);
        if (f16 == null) {
            QLog.e("SendPhotoTask", 2, "sendPhotoTask. compressInfo is null!");
            return false;
        }
        f16.S = this.E;
        f16.T = true;
        if (QLog.isColorLevel()) {
            QLog.d("SendPhotoTask", 2, "SendPhoto,compressInfo.uinType" + f16.S);
        }
        if (QLog.isColorLevel()) {
            QLog.d("SendPhotoTask", 2, "sendPhotoTask, compress start.compressInfo.src = " + f16.D);
        }
        x(f16);
        vVar.K = f16.H;
        if (QLog.isColorLevel()) {
            QLog.d("SendPhotoTask", 2, "sendPhotoTask,  compress finish, upInfo.localPath = " + vVar.K);
        }
        if (f16.L != 2 && r(f16.H)) {
            bm.a();
            try {
                ArrayList<Integer> h16 = h(f16);
                vVar.P = h16;
                if (h16 != null && QLog.isColorLevel()) {
                    QLog.d("peak_pgjpeg", 2, "@SendPhotoActivity.sendPhotoTask:" + vVar.P.toString());
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
                if (QLog.isColorLevel()) {
                    QLog.w("peak_pgjpeg", 2, "@ArrayIndexOutOfBoundsException occurred in PeakUtils.getSliceInfos\uff0c " + f16.H);
                }
            } catch (OutOfMemoryError unused2) {
                if (QLog.isColorLevel()) {
                    QLog.w("peak_pgjpeg", 2, "@OutOfMemoryError occurred in PeakUtils.getSliceInfos\uff0c " + f16.H + "'s size is " + FileUtils.getFileSizes(f16.H));
                }
            }
            bm.b("peak_pgjpeg", "@PeakUtils.getSliceInfos(" + f16.H + ")");
        }
        this.J.add(f16);
        if (f16.Q) {
            vVar.Q = 1;
            com.tencent.mobileqq.pic.f.b(vVar, "fixProtocolType", "sendReq.upInfo.protocolType");
        } else {
            vVar.Q = vVar.g();
        }
        return true;
    }

    protected boolean o(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, i3, (Object) str)).booleanValue();
        }
        HashMap<Integer, SendVideoInfo> hashMap = this.f184132i;
        if (hashMap != null && hashMap.get(Integer.valueOf(i3)) != null) {
            if (QLog.isColorLevel()) {
                QLog.d("SendPhotoTask", 2, "sendPhotoTask, send Video : " + str);
            }
            SendVideoInfo sendVideoInfo = this.f184132i.get(Integer.valueOf(i3));
            Intent intent = new Intent();
            intent.putExtra("file_send_path", str);
            intent.putExtra(ShortVideoConstants.FILE_SEND_SIZE, sendVideoInfo.fileSize);
            intent.putExtra(ShortVideoConstants.FILE_SEND_DURATION, sendVideoInfo.duration);
            intent.putExtra("uin", this.f184133m);
            intent.putExtra("uintype", this.E);
            intent.putExtra(ShortVideoConstants.FILE_SOURCE, ShortVideoConstants.FILE_SOURCE_ALBUM_FLOW);
            intent.putExtra(PeakConstants.SEND_IN_BACKGROUND, true);
            intent.putExtra(PeakConstants.SEND_SIZE_SPEC, this.P);
            d(intent);
            return true;
        }
        return false;
    }

    protected boolean q(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str)).booleanValue();
        }
        return !FileUtils.fileExistsAndNotEmpty(str);
    }

    protected boolean r(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, (Object) str)).booleanValue();
        }
        return ((IPicUtil) QRoute.api(IPicUtil.class)).isProgressiveJpeg(str);
    }

    @Override // java.lang.Runnable
    public void run() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.K > 0) {
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.SEND_PHOTO_IDLE_COST, false, this.K, 0L, null, "");
        }
        if (QLog.isColorLevel()) {
            QLog.d("SendPhotoTask", 2, "SendPhoto, current pid=" + Process.myPid() + "," + this.f184128d + ", idleCost" + this.K);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (t(this.C) && com.tencent.mobileqq.filemanager.fileassistant.util.h.k(this.f184133m)) {
            if (this.f184131h == null) {
                this.f184131h = new ArrayList<>();
            }
            this.f184131h.addAll(this.f184130f);
            this.f184130f = null;
        }
        if (s()) {
            k();
            Handler handler = this.f184129e;
            if (handler != null) {
                handler.sendEmptyMessage(2);
                return;
            }
            return;
        }
        i();
        ArrayList<String> arrayList = this.f184131h;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.d("SendPhotoTask", 2, "sendByFile, mFilePaths.size() : " + this.f184131h.size());
            }
            Bundle bundle = new Bundle();
            bundle.putInt("key_from_scene", 1);
            SendByFile.e(this.f184128d.get().app, this.f184131h, this.f184133m, this.E, bundle);
        }
        if (this.f184130f == null) {
            Handler handler2 = this.f184129e;
            if (handler2 != null) {
                handler2.sendEmptyMessage(2);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SendPhotoTask", 2, "sendPhotoTask, mPaths.size() : " + this.f184130f.size());
        }
        ArrayList<String> j3 = j();
        ArrayList<String> l3 = l();
        com.tencent.mobileqq.pic.f.d("PIC_TAG_COST", "launch req ", "time cost:" + (System.currentTimeMillis() - currentTimeMillis));
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.addAll(j3);
        arrayList2.addAll(l3);
        if (arrayList2.size() > 0) {
            this.I.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList2);
        }
        this.I.putExtra("param_selNum", arrayList2.size());
        if (this.P == 2) {
            int size = arrayList2.size();
            HashMap<Integer, SendVideoInfo> hashMap = this.f184132i;
            if (hashMap != null) {
                i3 = hashMap.size();
            } else {
                i3 = 0;
            }
            com.tencent.mobileqq.utils.e.o(size, i3);
        }
        Handler handler3 = this.f184129e;
        if (handler3 != null) {
            handler3.sendEmptyMessage(2);
        }
    }

    protected void u(p pVar, QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) pVar, (Object) qQAppInterface);
        } else {
            ((IPicBus) QRoute.api(IPicBus.class)).launch(pVar);
        }
    }

    protected void v(QQAppInterface qQAppInterface, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, qQAppInterface, str, str2);
        } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ((IOrderMediaMsgService) qQAppInterface.getRuntimeService(IOrderMediaMsgService.class)).enqueueMediaMsgByPath(str, str2);
        }
    }

    protected void w(BaseActivity baseActivity, p pVar) {
        QQAppInterface qQAppInterface;
        v vVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) baseActivity, (Object) pVar);
            return;
        }
        if (baseActivity != null && (qQAppInterface = baseActivity.app) != null) {
            if (pVar != null && (vVar = pVar.C) != null) {
                v(qQAppInterface, this.f184133m, vVar.K);
                if (p(pVar)) {
                    return;
                }
                u(pVar, baseActivity.app);
                try {
                    String[] strArr = new String[this.f184130f.size()];
                    this.f184130f.toArray(strArr);
                    boolean z16 = false;
                    boolean booleanExtra = baseActivity.getIntent().getBooleanExtra(PeakConstants.IS_FORWARD, false);
                    int i3 = -1;
                    if (booleanExtra) {
                        i3 = baseActivity.getIntent().getIntExtra(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, -1);
                    }
                    int i16 = i3;
                    v vVar2 = pVar.C;
                    if (vVar2 != null) {
                        int i17 = this.E;
                        if (vVar2.R == 2) {
                            z16 = true;
                        }
                        m.k(strArr, i17, z16, booleanExtra, i16, baseActivity.app);
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("SendPhotoTask", 2, "sendPhoto,sendReq is null,return!");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SendPhotoTask", 2, "sendPhoto,activity or app is null,return!");
        }
    }

    protected void x(CompressInfo compressInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) compressInfo);
        } else {
            RichmediaService.A(compressInfo);
        }
    }

    protected void y(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) list);
        } else if (this.f184128d.get() != null && this.f184128d.get().app != null) {
            an.a(this.f184128d.get().app, this.f184133m, this.f184128d.get().app.getCurrentUin(), list, this.L);
        }
    }
}
