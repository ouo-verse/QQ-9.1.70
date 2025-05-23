package com.tencent.mobileqq.filemanageraux.core;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.weiyun.api.IWeiyunApi;
import com.tencent.mobileqq.weiyun.api.IWeiyunHelper;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.mobileqq.weiyun.api.IWeiyunUploadDownloadService;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$AioPicAndVideoCopyToWeiyunMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$AioPicAndVideoCopyToWeiyunMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$CrossBidProxyCopyFileToOtherBidMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$CrossBidProxyCopyFileToOtherBidMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$DiskDirFileBatchDeleteExMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$DiskDirFileBatchDeleteExMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$DiskFileDocDownloadAbsMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$DiskFileDocDownloadAbsMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$DiskSimpleFileItem;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$FileItem;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$LibInfoListGetMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$LibInfoListGetMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$PicVideo2QcloudItem;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$PwdQueryMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$PwdVerifyMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$PwdVerifyMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$WeiyunShareAddFromMobileQQMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$WeiyunShareAddFromMobileQQMsgRsp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IMsgConverterUtilsApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.util.Pair;
import com.tencent.weiyun.transmission.ErrorCode;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadManager;
import com.tencent.weiyun.utils.NetworkUtils;
import com.tencent.weiyun.utils.Utils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f209567f;

    /* renamed from: a, reason: collision with root package name */
    private final QQAppInterface f209568a;

    /* renamed from: b, reason: collision with root package name */
    private LinkedHashMap<String, WeiYunFileInfo> f209569b;

    /* renamed from: c, reason: collision with root package name */
    private int f209570c;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f209571d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f209572e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements x43.a<WeiyunPB$DiskFileDocDownloadAbsMsgRsp> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // x43.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(int i3, String str, WeiyunPB$DiskFileDocDownloadAbsMsgRsp weiyunPB$DiskFileDocDownloadAbsMsgRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, weiyunPB$DiskFileDocDownloadAbsMsgRsp);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "get weiyun file PreviewAddress onFailed,errCode[" + i3 + "],errMsg[" + str + "]");
            }
            b.this.f209568a.getFileManagerNotifyCenter().b(false, 278, new Object[]{Integer.valueOf(i3), str, "", "", "", "", 0});
        }

        @Override // x43.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(WeiyunPB$DiskFileDocDownloadAbsMsgRsp weiyunPB$DiskFileDocDownloadAbsMsgRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) weiyunPB$DiskFileDocDownloadAbsMsgRsp);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "get weiyun file PreviewAddress onSucceed");
            }
            b.this.f209568a.getFileManagerNotifyCenter().b(true, 278, new Object[]{0, "", com.tencent.mobileqq.weiyun.utils.e.a(weiyunPB$DiskFileDocDownloadAbsMsgRsp.downloadkey.get()), weiyunPB$DiskFileDocDownloadAbsMsgRsp.cookie.get(), weiyunPB$DiskFileDocDownloadAbsMsgRsp.downloadip.get(), weiyunPB$DiskFileDocDownloadAbsMsgRsp.downloaddns.get(), Integer.valueOf(weiyunPB$DiskFileDocDownloadAbsMsgRsp.downloadport.get())});
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanageraux.core.b$b, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public class C7590b implements x43.a<WeiyunPB$WeiyunShareAddFromMobileQQMsgRsp> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.weiyun.a f209574a;

        C7590b(com.tencent.mobileqq.weiyun.a aVar) {
            this.f209574a = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) aVar);
            }
        }

        @Override // x43.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(int i3, String str, WeiyunPB$WeiyunShareAddFromMobileQQMsgRsp weiyunPB$WeiyunShareAddFromMobileQQMsgRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, weiyunPB$WeiyunShareAddFromMobileQQMsgRsp);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getShareLink onFailed: errorCode[" + i3 + "], errorMsg[" + str + "]");
            }
            com.tencent.mobileqq.weiyun.a aVar = this.f209574a;
            if (aVar != null) {
                aVar.onError(i3, str);
            }
        }

        @Override // x43.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(WeiyunPB$WeiyunShareAddFromMobileQQMsgRsp weiyunPB$WeiyunShareAddFromMobileQQMsgRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) weiyunPB$WeiyunShareAddFromMobileQQMsgRsp);
                return;
            }
            QLog.i("WeiYunLogicCenter<FileAssistant>", 1, "getShareLink succeed");
            com.tencent.mobileqq.weiyun.a aVar = this.f209574a;
            if (aVar != null) {
                aVar.onSuccess(weiyunPB$WeiyunShareAddFromMobileQQMsgRsp.raw_url.get());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements x43.a<WeiyunPB$PwdQueryMsgRsp> {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // x43.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(int i3, String str, WeiyunPB$PwdQueryMsgRsp weiyunPB$PwdQueryMsgRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, weiyunPB$PwdQueryMsgRsp);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "queryNeedVerifyPwd, onFailed. errorCode[" + i3 + "],errorMsg[" + str + "]");
            }
            b.this.f209568a.getFileManagerNotifyCenter().b(false, 44, new Object[]{Integer.valueOf(i3), str, null});
        }

        @Override // x43.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(WeiyunPB$PwdQueryMsgRsp weiyunPB$PwdQueryMsgRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) weiyunPB$PwdQueryMsgRsp);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "queryNeedVerifyPwd, onSucceed  need pwd[" + weiyunPB$PwdQueryMsgRsp.pwd_open.get() + "]");
            }
            ((IWeiyunApi) QRoute.api(IWeiyunApi.class)).setPwdQueried(b.this.f209568a.getApplication().getApplicationContext(), true);
            if (weiyunPB$PwdQueryMsgRsp.pwd_open.get()) {
                ((IWeiyunApi) QRoute.api(IWeiyunApi.class)).setPwdOpened(b.this.f209568a.getApplication().getApplicationContext(), true);
            }
            b.this.f209568a.getFileManagerNotifyCenter().b(true, 44, new Object[]{0, null, Boolean.valueOf(weiyunPB$PwdQueryMsgRsp.pwd_open.get())});
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d implements x43.a<WeiyunPB$PwdVerifyMsgRsp> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f209577a;

        d(String str) {
            this.f209577a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) str);
            }
        }

        @Override // x43.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(int i3, String str, WeiyunPB$PwdVerifyMsgRsp weiyunPB$PwdVerifyMsgRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, weiyunPB$PwdVerifyMsgRsp);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "verifyPwd, onFailed. errorCode[" + i3 + "],errorMsg[" + str + "]");
            }
            b.this.f209568a.getFileManagerNotifyCenter().b(false, 45, new Object[]{Integer.valueOf(i3), str, null});
        }

        @Override // x43.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(WeiyunPB$PwdVerifyMsgRsp weiyunPB$PwdVerifyMsgRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) weiyunPB$PwdVerifyMsgRsp);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "verifyPwd, onSucceed");
            }
            if (!TextUtils.isEmpty(this.f209577a)) {
                ((IWeiyunApi) QRoute.api(IWeiyunApi.class)).savePwdMd5(b.this.f209568a.getApplication().getApplicationContext(), this.f209577a);
            }
            ((IWeiyunApi) QRoute.api(IWeiyunApi.class)).setPwdVerified(b.this.f209568a.getApplication().getApplicationContext(), true);
            b.this.f209568a.getFileManagerNotifyCenter().b(true, 45, new Object[]{0, null, weiyunPB$PwdVerifyMsgRsp.cs_sig.get()});
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class e implements x43.a<WeiyunPB$LibInfoListGetMsgRsp> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f209579a;

        e(String str) {
            this.f209579a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) str);
            }
        }

        @Override // x43.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(int i3, String str, WeiyunPB$LibInfoListGetMsgRsp weiyunPB$LibInfoListGetMsgRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, weiyunPB$LibInfoListGetMsgRsp);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "queryWeiyunFileList onFailed: errcode[" + i3 + "], errmsg[" + str + "]");
            }
            b.this.f209568a.getFileManagerNotifyCenter().b(false, 31, new Object[]{Integer.valueOf(i3), str, this.f209579a});
        }

        @Override // x43.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(WeiyunPB$LibInfoListGetMsgRsp weiyunPB$LibInfoListGetMsgRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) weiyunPB$LibInfoListGetMsgRsp);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "queryWeiyunFileList onSucceed, num[" + weiyunPB$LibInfoListGetMsgRsp.FileItem_items.size() + "]");
            }
            ArrayList arrayList = new ArrayList();
            for (WeiyunPB$FileItem weiyunPB$FileItem : weiyunPB$LibInfoListGetMsgRsp.FileItem_items.get()) {
                WeiYunFileInfo weiYunFileInfo = new WeiYunFileInfo();
                weiYunFileInfo.f209607i = weiyunPB$FileItem.file_mtime.get();
                weiYunFileInfo.f209606h = weiyunPB$FileItem.file_size.get();
                weiYunFileInfo.f209608m = weiyunPB$FileItem.ext_info.from_source.get();
                weiYunFileInfo.f209603d = weiyunPB$FileItem.file_id.get();
                weiYunFileInfo.f209604e = com.tencent.mobileqq.weiyun.utils.e.a(weiyunPB$FileItem.pdir_key.get());
                weiYunFileInfo.f209605f = weiyunPB$FileItem.filename.get();
                weiYunFileInfo.F = weiyunPB$FileItem.ext_info.cookie_name.get();
                weiYunFileInfo.G = weiyunPB$FileItem.ext_info.cookie_value.get();
                weiYunFileInfo.E = weiyunPB$FileItem.ext_info.thumb_url.get();
                weiYunFileInfo.C = weiyunPB$FileItem.ext_info.weiyun_host.get();
                weiYunFileInfo.D = weiyunPB$FileItem.ext_info.weiyun_port.get();
                weiYunFileInfo.I = com.tencent.mobileqq.weiyun.utils.e.a(weiyunPB$FileItem.file_md5.get());
                weiYunFileInfo.J = com.tencent.mobileqq.weiyun.utils.e.a(weiyunPB$FileItem.file_sha.get());
                if (!b.this.f209569b.containsKey(weiYunFileInfo.f209603d)) {
                    b.this.f209569b.put(weiYunFileInfo.f209603d, weiYunFileInfo);
                    arrayList.add(weiYunFileInfo);
                }
            }
            FileManagerNotifyCenter fileManagerNotifyCenter = b.this.f209568a.getFileManagerNotifyCenter();
            Object[] objArr = new Object[6];
            boolean z16 = false;
            objArr[0] = this.f209579a;
            if (weiyunPB$LibInfoListGetMsgRsp.finish_flag.get() == 1) {
                z16 = true;
            }
            objArr[1] = Boolean.valueOf(z16);
            objArr[2] = Integer.valueOf(weiyunPB$LibInfoListGetMsgRsp.FileItem_items.size());
            objArr[3] = weiyunPB$LibInfoListGetMsgRsp.server_version.get();
            objArr[4] = arrayList;
            objArr[5] = Integer.valueOf(b.this.f209570c);
            fileManagerNotifyCenter.b(true, 31, objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class f implements x43.a<WeiyunPB$CrossBidProxyCopyFileToOtherBidMsgRsp> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.weiyun.a f209581a;

        f(com.tencent.mobileqq.weiyun.a aVar) {
            this.f209581a = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) aVar);
            }
        }

        @Override // x43.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(int i3, String str, WeiyunPB$CrossBidProxyCopyFileToOtherBidMsgRsp weiyunPB$CrossBidProxyCopyFileToOtherBidMsgRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, weiyunPB$CrossBidProxyCopyFileToOtherBidMsgRsp);
                return;
            }
            QLog.i("WeiYunLogicCenter<FileAssistant>", 1, "sendWeiYun2Dataline onFailed: errcode[" + i3 + "], errmsg[" + str + "]");
            com.tencent.mobileqq.weiyun.a aVar = this.f209581a;
            if (aVar != null) {
                aVar.onError(i3, str);
            }
        }

        @Override // x43.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(WeiyunPB$CrossBidProxyCopyFileToOtherBidMsgRsp weiyunPB$CrossBidProxyCopyFileToOtherBidMsgRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) weiyunPB$CrossBidProxyCopyFileToOtherBidMsgRsp);
                return;
            }
            String str = new String(weiyunPB$CrossBidProxyCopyFileToOtherBidMsgRsp.dst_path.get().toByteArray());
            if (str.length() < 1) {
                QLog.e("WeiYunLogicCenter<FileAssistant>", 1, "=_= ^! [CS Replay]sendWeiYun2Dataline onSucceed,But uuid is null!!!");
                com.tencent.mobileqq.weiyun.a aVar = this.f209581a;
                if (aVar != null) {
                    aVar.onError(-3, "copyFileToOtherBid_fail");
                    return;
                }
                return;
            }
            QLog.i("WeiYunLogicCenter<FileAssistant>", 1, "=_= ^ [CS Replay] sendWeiYun2Dataline onSucceed, Uuid[" + str + "]");
            com.tencent.mobileqq.weiyun.a aVar2 = this.f209581a;
            if (aVar2 != null) {
                aVar2.onSuccess(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class g implements x43.a<WeiyunPB$AioPicAndVideoCopyToWeiyunMsgRsp> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.weiyun.a f209583a;

        g(com.tencent.mobileqq.weiyun.a aVar) {
            this.f209583a = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) aVar);
            }
        }

        @Override // x43.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(int i3, String str, WeiyunPB$AioPicAndVideoCopyToWeiyunMsgRsp weiyunPB$AioPicAndVideoCopyToWeiyunMsgRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, weiyunPB$AioPicAndVideoCopyToWeiyunMsgRsp);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "saveAioMedia2Weiyun Failed errorCode=" + i3 + "; errorMsg=" + str);
            }
            com.tencent.mobileqq.weiyun.a aVar = this.f209583a;
            if (aVar != null) {
                aVar.onError(i3, str);
            }
        }

        @Override // x43.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(WeiyunPB$AioPicAndVideoCopyToWeiyunMsgRsp weiyunPB$AioPicAndVideoCopyToWeiyunMsgRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) weiyunPB$AioPicAndVideoCopyToWeiyunMsgRsp);
                return;
            }
            QLog.d("WeiYunLogicCenter<FileAssistant>", 1, "saveAioMedia2Weiyun Success");
            com.tencent.mobileqq.weiyun.a aVar = this.f209583a;
            if (aVar != null) {
                aVar.onSuccess(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class h implements y43.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f209585a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f209586b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f209587c;

        h(String str, int i3, Object obj) {
            this.f209585a = str;
            this.f209586b = i3;
            this.f209587c = obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, b.this, str, Integer.valueOf(i3), obj);
            }
        }

        @Override // y43.b
        public void onDownloadFinished(String str, String str2, boolean z16, String str3, int i3) {
            boolean z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, Boolean.valueOf(z16), str3, Integer.valueOf(i3));
                return;
            }
            if (z16 && str != null && !TextUtils.isEmpty(str2) && new File(str2).exists()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                if (QLog.isColorLevel()) {
                    QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "getWeiYunThumb onSucceed. filePath[" + str2 + "]");
                }
                b.this.f209568a.getFileManagerNotifyCenter().b(true, 39, new Object[]{this.f209585a, Integer.valueOf(this.f209586b), str2, this.f209587c});
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getWeiYunThumb onFailed: errcode[" + i3 + "], errmsg[" + str3 + "]");
            }
        }

        @Override // y43.b
        public void onDownloadProgress(String str, long j3, float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Long.valueOf(j3), Float.valueOf(f16));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class i implements y43.e {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // y43.e
        public void h(long j3, float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), Float.valueOf(f16));
            }
        }

        @Override // y43.e
        public void i(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                b.this.f209571d = true;
                b.this.f209572e = false;
                ((IWeiyunUploadDownloadService) QRoute.api(IWeiyunUploadDownloadService.class)).initTransmission(b.this.f209568a.getApplication(), true);
                WeiyunTransmissionGlobal.getInstance().getUploadManager().loadLibFromPath(str);
                ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).registerSoFilePath(BaseApplication.context.getBaseContext(), str);
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        }

        @Override // y43.e
        public void onLoadFailed(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                b.this.f209572e = false;
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class j implements x43.a<WeiyunPB$DiskDirFileBatchDeleteExMsgRsp> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeiYunFileInfo f209590a;

        j(WeiYunFileInfo weiYunFileInfo) {
            this.f209590a = weiYunFileInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) weiYunFileInfo);
            }
        }

        @Override // x43.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(int i3, String str, WeiyunPB$DiskDirFileBatchDeleteExMsgRsp weiyunPB$DiskDirFileBatchDeleteExMsgRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, weiyunPB$DiskDirFileBatchDeleteExMsgRsp);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "deleteWeiYunFile, onFailed  strFileId[" + this.f209590a.f209603d + "]strFileName[" + this.f209590a.f209605f + "]errorCode[" + i3 + "],errorMsg[" + str + "]");
            }
            FileManagerNotifyCenter fileManagerNotifyCenter = b.this.f209568a.getFileManagerNotifyCenter();
            WeiYunFileInfo weiYunFileInfo = this.f209590a;
            fileManagerNotifyCenter.b(false, 20, new Object[]{Integer.valueOf(i3), str, weiYunFileInfo.f209603d, weiYunFileInfo.f209605f, Boolean.FALSE});
        }

        @Override // x43.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(WeiyunPB$DiskDirFileBatchDeleteExMsgRsp weiyunPB$DiskDirFileBatchDeleteExMsgRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) weiyunPB$DiskDirFileBatchDeleteExMsgRsp);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "deleteWeiYunFile, onSucceed  strFileId[" + this.f209590a.f209603d + "]strFileName[" + this.f209590a.f209605f + "]");
            }
            FileManagerNotifyCenter fileManagerNotifyCenter = b.this.f209568a.getFileManagerNotifyCenter();
            WeiYunFileInfo weiYunFileInfo = this.f209590a;
            fileManagerNotifyCenter.b(true, 20, new Object[]{0, null, weiYunFileInfo.f209603d, weiYunFileInfo.f209605f, Boolean.FALSE});
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71925);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
        } else {
            f209567f = false;
        }
    }

    public b(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f209568a = qQAppInterface;
        if (f209567f) {
            ((IWeiyunHelper) QRoute.api(IWeiyunHelper.class)).shutdownWySystem();
        }
        ((IWeiyunHelper) QRoute.api(IWeiyunHelper.class)).startWySystem();
        f209567f = true;
    }

    private void B(WeiyunPB$AioPicAndVideoCopyToWeiyunMsgReq weiyunPB$AioPicAndVideoCopyToWeiyunMsgReq, com.tencent.mobileqq.weiyun.a aVar) {
        ((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).startSave2Weiyun();
        ((IWeiyunApi) QRoute.api(IWeiyunApi.class)).saveAioPicVideo2Weiyun(weiyunPB$AioPicAndVideoCopyToWeiyunMsgReq, new g(aVar));
    }

    private boolean G(WeiyunPB$WeiyunShareAddFromMobileQQMsgReq weiyunPB$WeiyunShareAddFromMobileQQMsgReq, FileManagerEntity fileManagerEntity) {
        t tVar;
        String currentAccountUin;
        int fileSrcCloudType = FileManagerUtil.getFileSrcCloudType(fileManagerEntity);
        if (fileSrcCloudType == 2) {
            weiyunPB$WeiyunShareAddFromMobileQQMsgReq.source.set(1);
            weiyunPB$WeiyunShareAddFromMobileQQMsgReq.file.setHasFlag(true);
            weiyunPB$WeiyunShareAddFromMobileQQMsgReq.file.file_id.set(fileManagerEntity.WeiYunFileId);
            if (!TextUtils.isEmpty(fileManagerEntity.WeiYunDirKey)) {
                weiyunPB$WeiyunShareAddFromMobileQQMsgReq.file.pdir_key.set(com.tencent.mobileqq.weiyun.utils.e.b(fileManagerEntity.WeiYunDirKey));
            }
        } else {
            int i3 = 3;
            if (fileSrcCloudType == 1) {
                weiyunPB$WeiyunShareAddFromMobileQQMsgReq.source.set(2);
                PBUInt64Field pBUInt64Field = weiyunPB$WeiyunShareAddFromMobileQQMsgReq.src_uin;
                if (fileManagerEntity.peerType == 3000) {
                    currentAccountUin = fileManagerEntity.peerUin;
                } else {
                    currentAccountUin = this.f209568a.getCurrentAccountUin();
                }
                pBUInt64Field.set(Long.parseLong(currentAccountUin));
                PBUInt32Field pBUInt32Field = weiyunPB$WeiyunShareAddFromMobileQQMsgReq.src_appid;
                if (fileManagerEntity.peerType == 3000) {
                    i3 = 106;
                }
                pBUInt32Field.set(i3);
                if (!TextUtils.isEmpty(fileManagerEntity.Uuid)) {
                    weiyunPB$WeiyunShareAddFromMobileQQMsgReq.src_full_path.set(ByteStringMicro.copyFrom(fileManagerEntity.Uuid.getBytes()));
                }
                weiyunPB$WeiyunShareAddFromMobileQQMsgReq.file_size.set(fileManagerEntity.fileSize);
                if (!TextUtils.isEmpty(fileManagerEntity.fileName)) {
                    weiyunPB$WeiyunShareAddFromMobileQQMsgReq.file_name.set(fileManagerEntity.fileName);
                }
                if (!TextUtils.isEmpty(fileManagerEntity.strFileSHA)) {
                    weiyunPB$WeiyunShareAddFromMobileQQMsgReq.file_sha.set(fileManagerEntity.strFileSHA);
                }
            } else if (fileSrcCloudType == 4) {
                weiyunPB$WeiyunShareAddFromMobileQQMsgReq.source.set(3);
                try {
                    tVar = TroopFileUtils.n(this.f209568a, fileManagerEntity);
                } catch (Throwable th5) {
                    QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "getShareLink : get troop file info error", th5);
                    tVar = null;
                }
                if (tVar != null && !TextUtils.isEmpty(tVar.f294985s)) {
                    weiyunPB$WeiyunShareAddFromMobileQQMsgReq.src_uin.set(tVar.f294971e);
                    weiyunPB$WeiyunShareAddFromMobileQQMsgReq.src_appid.set(tVar.f294988v);
                    weiyunPB$WeiyunShareAddFromMobileQQMsgReq.src_full_path.set(ByteStringMicro.copyFrom(tVar.f294985s.getBytes()));
                    weiyunPB$WeiyunShareAddFromMobileQQMsgReq.file_size.set(tVar.f294976j);
                    if (!TextUtils.isEmpty(tVar.f294987u)) {
                        weiyunPB$WeiyunShareAddFromMobileQQMsgReq.file_name.set(tVar.f294987u);
                    }
                    if (!TextUtils.isEmpty(tVar.f294986t)) {
                        weiyunPB$WeiyunShareAddFromMobileQQMsgReq.file_sha.set(tVar.f294986t);
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getShareLink : troop file info is invalid");
                    }
                    return false;
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getShareLink : unsupported cloudType:" + fileSrcCloudType);
                }
                return false;
            }
        }
        return true;
    }

    private boolean H(WeiyunPB$WeiyunShareAddFromMobileQQMsgReq weiyunPB$WeiyunShareAddFromMobileQQMsgReq, long j3, String str, boolean z16, boolean z17) {
        if (j3 > 0) {
            weiyunPB$WeiyunShareAddFromMobileQQMsgReq.weiyun_share_auth_info.expired_time.set((int) (j3 / 1000));
            weiyunPB$WeiyunShareAddFromMobileQQMsgReq.weiyun_share_auth_info.setHasFlag(true);
        }
        if (!TextUtils.isEmpty(str)) {
            weiyunPB$WeiyunShareAddFromMobileQQMsgReq.pass_word.set(str);
            weiyunPB$WeiyunShareAddFromMobileQQMsgReq.weiyun_share_auth_info.pass_word.set(str);
            weiyunPB$WeiyunShareAddFromMobileQQMsgReq.weiyun_share_auth_info.setHasFlag(true);
        }
        weiyunPB$WeiyunShareAddFromMobileQQMsgReq.enable_qq_add_friend.set(z16);
        weiyunPB$WeiyunShareAddFromMobileQQMsgReq.qr_flag.set(z17 ? 1 : 0);
        return true;
    }

    private int h(boolean z16, int i3) {
        if (z16) {
            if (ao.r(i3)) {
                return 3;
            }
            return 4;
        }
        if (ao.r(i3)) {
            return 1;
        }
        return 2;
    }

    private int i(int i3) {
        if (ao.r(i3)) {
            return 0;
        }
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 3000) {
            return 2;
        }
        return 3;
    }

    private String j(AIOMsgItem aIOMsgItem) {
        PicElement picElement;
        boolean z16;
        MsgElement firstTypeElement = aIOMsgItem.getFirstTypeElement(2);
        if (firstTypeElement == null || (picElement = firstTypeElement.getPicElement()) == null) {
            return "";
        }
        if (aIOMsgItem.getMsgRecord().getChatType() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return com.tencent.mobileqq.richmediabrowser.utils.c.p(picElement.getFileName(), picElement.getMd5HexStr());
        }
        return picElement.getFileUuid();
    }

    private WeiyunPB$PicVideo2QcloudItem l(MessageForPic messageForPic) {
        WeiyunPB$PicVideo2QcloudItem weiyunPB$PicVideo2QcloudItem = new WeiyunPB$PicVideo2QcloudItem();
        weiyunPB$PicVideo2QcloudItem.bool_auto_create_user.set(true);
        if (!TextUtils.isEmpty(messageForPic.uuid)) {
            weiyunPB$PicVideo2QcloudItem.str_file_id.set(messageForPic.uuid);
        }
        weiyunPB$PicVideo2QcloudItem.uint64_file_id.set(messageForPic.groupFileID);
        if (!TextUtils.isEmpty(messageForPic.uuid)) {
            weiyunPB$PicVideo2QcloudItem.str_file_name.set(messageForPic.uuid);
        }
        if (!TextUtils.isEmpty(messageForPic.md5)) {
            weiyunPB$PicVideo2QcloudItem.str_file_md5.set(messageForPic.md5);
        }
        weiyunPB$PicVideo2QcloudItem.uint32_bid.set(h(false, messageForPic.istroop));
        weiyunPB$PicVideo2QcloudItem.uint32_chat_type.set(i(messageForPic.istroop));
        weiyunPB$PicVideo2QcloudItem.uint32_user_type.set(messageForPic.issend);
        if (!TextUtils.isEmpty(messageForPic.frienduin)) {
            weiyunPB$PicVideo2QcloudItem.str_dst_id.set(messageForPic.frienduin);
        }
        if (!TextUtils.isEmpty(messageForPic.senderuin)) {
            weiyunPB$PicVideo2QcloudItem.str_src_id.set(messageForPic.senderuin);
        }
        weiyunPB$PicVideo2QcloudItem.image_type.set(messageForPic.imageType);
        weiyunPB$PicVideo2QcloudItem.uint64_file_size.set(messageForPic.size);
        String str = messageForPic.rawMsgUrl;
        if (str != null) {
            weiyunPB$PicVideo2QcloudItem.raw_url.set(str);
        }
        return weiyunPB$PicVideo2QcloudItem;
    }

    private WeiyunPB$PicVideo2QcloudItem m(MessageForShortVideo messageForShortVideo) {
        WeiyunPB$PicVideo2QcloudItem weiyunPB$PicVideo2QcloudItem = new WeiyunPB$PicVideo2QcloudItem();
        weiyunPB$PicVideo2QcloudItem.bool_auto_create_user.set(true);
        if (!TextUtils.isEmpty(messageForShortVideo.uuid)) {
            weiyunPB$PicVideo2QcloudItem.str_file_id.set(messageForShortVideo.uuid);
        }
        if (!TextUtils.isEmpty(messageForShortVideo.md5)) {
            weiyunPB$PicVideo2QcloudItem.str_file_md5.set(messageForShortVideo.md5);
        }
        if (!TextUtils.isEmpty(messageForShortVideo.videoFileName)) {
            weiyunPB$PicVideo2QcloudItem.str_file_name.set(messageForShortVideo.videoFileName);
        }
        weiyunPB$PicVideo2QcloudItem.uint32_bid.set(h(true, messageForShortVideo.istroop));
        weiyunPB$PicVideo2QcloudItem.uint32_chat_type.set(i(messageForShortVideo.istroop));
        weiyunPB$PicVideo2QcloudItem.uint32_user_type.set(messageForShortVideo.issend);
        if (!TextUtils.isEmpty(messageForShortVideo.frienduin)) {
            weiyunPB$PicVideo2QcloudItem.str_dst_id.set(messageForShortVideo.frienduin);
        }
        if (!TextUtils.isEmpty(messageForShortVideo.senderuin)) {
            weiyunPB$PicVideo2QcloudItem.str_src_id.set(messageForShortVideo.senderuin);
        }
        weiyunPB$PicVideo2QcloudItem.uint64_file_size.set(messageForShortVideo.videoFileSize);
        return weiyunPB$PicVideo2QcloudItem;
    }

    private WeiyunPB$PicVideo2QcloudItem n(AIOMsgItem aIOMsgItem, int i3) {
        MessageForMixedMsg messageForMixedMsg;
        List<MessageRecord> list;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if ((peekAppRuntime instanceof QQAppInterface) && com.tencent.mobileqq.aio.utils.d.E(aIOMsgItem)) {
            ChatMessage convertToChatMessage = ((IMsgConverterUtilsApi) QRoute.api(IMsgConverterUtilsApi.class)).convertToChatMessage(peekAppRuntime, aIOMsgItem.getMsgRecord());
            if (!(convertToChatMessage instanceof MessageForMixedMsg) || (list = (messageForMixedMsg = (MessageForMixedMsg) convertToChatMessage).msgElemList) == null || list.size() < i3) {
                return null;
            }
            return q(messageForMixedMsg.msgElemList.get(i3));
        }
        QLog.i("WeiYunLogicCenter<FileAssistant>", 1, "msgItem is not mixMsgItem");
        return null;
    }

    private WeiyunPB$PicVideo2QcloudItem o(AIOMsgItem aIOMsgItem) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if ((peekAppRuntime instanceof QQAppInterface) && com.tencent.mobileqq.aio.utils.d.L(aIOMsgItem)) {
            ChatMessage convertToChatMessage = ((IMsgConverterUtilsApi) QRoute.api(IMsgConverterUtilsApi.class)).convertToChatMessage(peekAppRuntime, aIOMsgItem.getMsgRecord());
            if (!(convertToChatMessage instanceof MessageForPic)) {
                return null;
            }
            MessageForPic messageForPic = (MessageForPic) convertToChatMessage;
            messageForPic.uuid = j(aIOMsgItem);
            messageForPic.md5 = messageForPic.md5.toUpperCase();
            return l(messageForPic);
        }
        QLog.i("WeiYunLogicCenter<FileAssistant>", 1, "getQcloudItemForNTPic faild because mApp is wrong or msg is not picture");
        return null;
    }

    private WeiyunPB$PicVideo2QcloudItem p(AIOMsgItem aIOMsgItem) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if ((peekAppRuntime instanceof QQAppInterface) && aIOMsgItem.getMsgRecord().getMsgType() == 7) {
            ChatMessage convertToChatMessage = ((IMsgConverterUtilsApi) QRoute.api(IMsgConverterUtilsApi.class)).convertToChatMessage(peekAppRuntime, aIOMsgItem.getMsgRecord());
            if (!(convertToChatMessage instanceof MessageForShortVideo)) {
                return null;
            }
            return m((MessageForShortVideo) convertToChatMessage);
        }
        QLog.i("WeiYunLogicCenter<FileAssistant>", 1, "getQcloudItemForNTVideo faild because mApp is wrong or msg is not video");
        return null;
    }

    private WeiyunPB$PicVideo2QcloudItem q(MessageRecord messageRecord) {
        if (messageRecord instanceof MessageForShortVideo) {
            return m((MessageForShortVideo) messageRecord);
        }
        if (messageRecord instanceof MessageForPic) {
            return l((MessageForPic) messageRecord);
        }
        return null;
    }

    @Nullable
    private String t(String str, String str2, int i3, boolean z16, Object obj) {
        String str3;
        if (QLog.isColorLevel()) {
            QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "getWeiYunThumb : strFileId[" + str + "], thumbUrl[" + str2 + "], WeiYunThumbnailType[" + i3 + "]");
        }
        if (str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
            if (!str2.startsWith("http")) {
                return str2;
            }
            Pair<Pair<String, String>, Long> genThumbInfo = ((IWeiyunHelper) QRoute.api(IWeiyunHelper.class)).genThumbInfo(str2, i3, z16);
            if (genThumbInfo != null) {
                File file = new File(((IWeiyunHelper) QRoute.api(IWeiyunHelper.class)).getDefaultThumbPath(), Long.toString(genThumbInfo.second.longValue()));
                str3 = file.getAbsolutePath();
                if (file.exists()) {
                    return str3;
                }
            } else {
                str3 = null;
            }
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                this.f209568a.getFileManagerNotifyCenter().b(false, 39, new Object[]{str, obj});
                if (QLog.isColorLevel()) {
                    QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getWeiYunThumb : network error");
                }
                return null;
            }
            h hVar = new h(str, i3, obj);
            if (str3 != null) {
                IWeiyunUploadDownloadService iWeiyunUploadDownloadService = (IWeiyunUploadDownloadService) QRoute.api(IWeiyunUploadDownloadService.class);
                Pair<String, String> pair = genThumbInfo.first;
                iWeiyunUploadDownloadService.downloadImage(pair.first, str3, pair.second, hVar);
            }
            return null;
        }
        this.f209568a.getFileManagerNotifyCenter().b(false, 39, new Object[]{str, obj});
        if (QLog.isColorLevel()) {
            QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getWeiYunThumb : fileID or thumbUrl error");
        }
        return null;
    }

    private void w() {
        if (!((IWeiyunHelper) QRoute.api(IWeiyunHelper.class)).checkSOExists(this.f209568a.getApplication())) {
            if (NetworkUtils.isWifiAvailable(this.f209568a.getApplication())) {
                this.f209572e = true;
                ((IWeiyunHelper) QRoute.api(IWeiyunHelper.class)).downloadSo(this.f209568a.getApplication(), new i());
                return;
            }
            return;
        }
        this.f209571d = true;
        ((IWeiyunUploadDownloadService) QRoute.api(IWeiyunUploadDownloadService.class)).initTransmission(this.f209568a.getApplication(), true);
        File uploadSoFile = ((IWeiyunHelper) QRoute.api(IWeiyunHelper.class)).getUploadSoFile(this.f209568a.getApplication());
        if (uploadSoFile != null) {
            WeiyunTransmissionGlobal.getInstance().getUploadManager().loadLibFromPath(uploadSoFile.getAbsolutePath());
        }
    }

    public void A(ChatMessage chatMessage, com.tencent.mobileqq.weiyun.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) chatMessage, (Object) aVar);
            return;
        }
        WeiyunPB$AioPicAndVideoCopyToWeiyunMsgReq weiyunPB$AioPicAndVideoCopyToWeiyunMsgReq = new WeiyunPB$AioPicAndVideoCopyToWeiyunMsgReq();
        ArrayList arrayList = new ArrayList(1);
        if (chatMessage instanceof MessageForPic) {
            arrayList.add(l((MessageForPic) chatMessage));
        } else if (chatMessage instanceof MessageForShortVideo) {
            arrayList.add(m((MessageForShortVideo) chatMessage));
        }
        weiyunPB$AioPicAndVideoCopyToWeiyunMsgReq.pic_video_2qcloud_list.set(arrayList);
        B(weiyunPB$AioPicAndVideoCopyToWeiyunMsgReq, aVar);
    }

    public void C(List<MessageForPic> list, List<MessageForShortVideo> list2, com.tencent.mobileqq.weiyun.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, list, list2, aVar);
            return;
        }
        WeiyunPB$AioPicAndVideoCopyToWeiyunMsgReq weiyunPB$AioPicAndVideoCopyToWeiyunMsgReq = new WeiyunPB$AioPicAndVideoCopyToWeiyunMsgReq();
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            Iterator<MessageForPic> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(l(it.next()));
            }
        }
        if (list2 != null && list2.size() > 0) {
            Iterator<MessageForShortVideo> it5 = list2.iterator();
            while (it5.hasNext()) {
                arrayList.add(m(it5.next()));
            }
        }
        weiyunPB$AioPicAndVideoCopyToWeiyunMsgReq.pic_video_2qcloud_list.set(arrayList);
        B(weiyunPB$AioPicAndVideoCopyToWeiyunMsgReq, aVar);
    }

    public void D(AIOMsgItem aIOMsgItem, int i3, com.tencent.mobileqq.weiyun.a aVar) {
        WeiyunPB$PicVideo2QcloudItem p16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, aIOMsgItem, Integer.valueOf(i3), aVar);
            return;
        }
        WeiyunPB$AioPicAndVideoCopyToWeiyunMsgReq weiyunPB$AioPicAndVideoCopyToWeiyunMsgReq = new WeiyunPB$AioPicAndVideoCopyToWeiyunMsgReq();
        ArrayList arrayList = new ArrayList(1);
        if (com.tencent.mobileqq.aio.utils.d.E(aIOMsgItem)) {
            WeiyunPB$PicVideo2QcloudItem n3 = n(aIOMsgItem, i3);
            if (n3 != null) {
                arrayList.add(n3);
            }
        } else if (com.tencent.mobileqq.aio.utils.d.L(aIOMsgItem)) {
            WeiyunPB$PicVideo2QcloudItem o16 = o(aIOMsgItem);
            if (o16 != null) {
                arrayList.add(o16);
            }
        } else if (aIOMsgItem.getMsgRecord().getMsgType() == 7 && (p16 = p(aIOMsgItem)) != null) {
            arrayList.add(p16);
        }
        if (arrayList.isEmpty()) {
            QLog.i("WeiYunLogicCenter<FileAssistant>", 1, "picture and video request is empty");
        } else {
            weiyunPB$AioPicAndVideoCopyToWeiyunMsgReq.pic_video_2qcloud_list.set(arrayList);
            B(weiyunPB$AioPicAndVideoCopyToWeiyunMsgReq, aVar);
        }
    }

    public void E(List<AIOMsgItem> list, com.tencent.mobileqq.weiyun.a aVar) {
        WeiyunPB$PicVideo2QcloudItem p16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) list, (Object) aVar);
            return;
        }
        WeiyunPB$AioPicAndVideoCopyToWeiyunMsgReq weiyunPB$AioPicAndVideoCopyToWeiyunMsgReq = new WeiyunPB$AioPicAndVideoCopyToWeiyunMsgReq();
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 1) {
            for (AIOMsgItem aIOMsgItem : list) {
                if (com.tencent.mobileqq.aio.utils.d.L(aIOMsgItem)) {
                    WeiyunPB$PicVideo2QcloudItem o16 = o(aIOMsgItem);
                    if (o16 != null) {
                        arrayList.add(o16);
                    }
                } else if (aIOMsgItem.getMsgRecord().getMsgType() == 7 && (p16 = p(aIOMsgItem)) != null) {
                    arrayList.add(p16);
                }
            }
        }
        if (arrayList.isEmpty()) {
            QLog.i("WeiYunLogicCenter<FileAssistant>", 1, "picture and video request is empty");
        } else {
            weiyunPB$AioPicAndVideoCopyToWeiyunMsgReq.pic_video_2qcloud_list.set(arrayList);
            B(weiyunPB$AioPicAndVideoCopyToWeiyunMsgReq, aVar);
        }
    }

    public void F(WeiYunFileInfo weiYunFileInfo, com.tencent.mobileqq.weiyun.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) weiYunFileInfo, (Object) aVar);
            return;
        }
        if (weiYunFileInfo == null) {
            QLog.e("WeiYunLogicCenter<FileAssistant>", 1, "=_= ^! [CS Send]sendWeiYun2Dataline : entity is null");
            return;
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            if (aVar != null) {
                aVar.onError(-1, "no_network");
                return;
            }
            return;
        }
        QLog.i("WeiYunLogicCenter<FileAssistant>", 1, "=_= ^ [CS Send]sendWeiYun2Dataline, WeiYunFileId[" + weiYunFileInfo.f209603d + "], fileName[" + weiYunFileInfo.f209605f + "], fileSize[" + weiYunFileInfo.f209606h + "], nWeiYunSrcType[" + weiYunFileInfo.f209608m);
        if (!TextUtils.isEmpty(weiYunFileInfo.f209603d) && !TextUtils.isEmpty(weiYunFileInfo.f209605f)) {
            WeiyunPB$CrossBidProxyCopyFileToOtherBidMsgReq weiyunPB$CrossBidProxyCopyFileToOtherBidMsgReq = new WeiyunPB$CrossBidProxyCopyFileToOtherBidMsgReq();
            String str = weiYunFileInfo.f209605f;
            if (str != null) {
                weiyunPB$CrossBidProxyCopyFileToOtherBidMsgReq.file_name.set(str);
            }
            weiyunPB$CrossBidProxyCopyFileToOtherBidMsgReq.file_size.set(weiYunFileInfo.f209606h);
            String str2 = weiYunFileInfo.J;
            if (str2 != null) {
                weiyunPB$CrossBidProxyCopyFileToOtherBidMsgReq.file_sha.set(com.tencent.mobileqq.weiyun.utils.e.b(str2));
            }
            String str3 = weiYunFileInfo.I;
            if (str3 != null) {
                weiyunPB$CrossBidProxyCopyFileToOtherBidMsgReq.file_md5.set(com.tencent.mobileqq.weiyun.utils.e.b(str3));
            } else {
                weiyunPB$CrossBidProxyCopyFileToOtherBidMsgReq.file_md5.set(com.tencent.mobileqq.weiyun.utils.e.b(""));
            }
            String str4 = weiYunFileInfo.f209603d;
            if (str4 != null) {
                weiyunPB$CrossBidProxyCopyFileToOtherBidMsgReq.src_file_id.set(str4);
            }
            String str5 = weiYunFileInfo.f209604e;
            if (str5 != null) {
                weiyunPB$CrossBidProxyCopyFileToOtherBidMsgReq.src_pdir_key.set(com.tencent.mobileqq.weiyun.utils.e.b(str5));
            }
            weiyunPB$CrossBidProxyCopyFileToOtherBidMsgReq.src_bid.set(25);
            weiyunPB$CrossBidProxyCopyFileToOtherBidMsgReq.src_uin.set(this.f209568a.getLongAccountUin());
            weiyunPB$CrossBidProxyCopyFileToOtherBidMsgReq.src_group.set(this.f209568a.getLongAccountUin());
            weiyunPB$CrossBidProxyCopyFileToOtherBidMsgReq.dst_bid.set(38);
            weiyunPB$CrossBidProxyCopyFileToOtherBidMsgReq.dst_uin.set(this.f209568a.getLongAccountUin());
            weiyunPB$CrossBidProxyCopyFileToOtherBidMsgReq.user_type.set(0);
            ((IWeiyunApi) QRoute.api(IWeiyunApi.class)).copyFileToOtherBid(weiyunPB$CrossBidProxyCopyFileToOtherBidMsgReq, new f(aVar));
            return;
        }
        QLog.i("WeiYunLogicCenter<FileAssistant>", 1, "sendWeiYun2Dataline onFailed: weiyunID is null[" + TextUtils.isEmpty(weiYunFileInfo.f209603d) + "], fileName is Null[" + TextUtils.isEmpty(weiYunFileInfo.f209605f) + "]");
        if (aVar != null) {
            aVar.onError(-2, "no_weiyunid_or_filename");
        }
    }

    public com.tencent.mobileqq.filemanageraux.core.d I(String str, Object obj, UploadManager.IUploadStatusListener iUploadStatusListener) {
        String upload;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (com.tencent.mobileqq.filemanageraux.core.d) iPatchRedirector.redirect((short) 17, this, str, obj, iUploadStatusListener);
        }
        if (!this.f209571d && !this.f209572e) {
            w();
        }
        if (str == null) {
            if (QLog.isColorLevel()) {
                QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "uploadWeiYunFile strPath is null");
            }
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "uploadWeiYunFile, strPath[" + str + "]");
        }
        UploadFile createUploadFile = ((IWeiyunUploadDownloadService) QRoute.api(IWeiyunUploadDownloadService.class)).createUploadFile(str, UploadFile.createUploadBatch(1, null), 1);
        if (createUploadFile == null) {
            upload = null;
        } else {
            upload = WeiyunTransmissionGlobal.getInstance().getUploadManager().upload(createUploadFile, false, true, iUploadStatusListener);
        }
        if (TextUtils.isEmpty(upload)) {
            if (QLog.isColorLevel()) {
                QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "uploadWeiYunFile create upload task failed!");
            }
            return null;
        }
        return new com.tencent.mobileqq.filemanageraux.core.d(upload, obj, true, iUploadStatusListener, null);
    }

    public void J(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "verifyPwd");
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            if (QLog.isColorLevel()) {
                QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "verifyPwd : network error");
            }
            this.f209568a.getFileManagerNotifyCenter().b(false, 45, new Object[]{0, BaseApplication.getContext().getString(R.string.f171137ci2)});
        } else {
            WeiyunPB$PwdVerifyMsgReq weiyunPB$PwdVerifyMsgReq = new WeiyunPB$PwdVerifyMsgReq();
            String bytes2HexStr = Utils.bytes2HexStr(Utils.str2Md5(str));
            weiyunPB$PwdVerifyMsgReq.pwd_md5.set(com.tencent.mobileqq.weiyun.utils.e.b(bytes2HexStr));
            ((IWeiyunApi) QRoute.api(IWeiyunApi.class)).checkPwd(weiyunPB$PwdVerifyMsgReq, new d(bytes2HexStr));
        }
    }

    public void f(WeiYunFileInfo weiYunFileInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) weiYunFileInfo);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "deleteWeiYunFile, strFileId[" + weiYunFileInfo.f209603d + "],strFileName[" + weiYunFileInfo.f209605f + "]");
        }
        ((IWeiyunApi) QRoute.api(IWeiyunApi.class)).addDeletingCloudFile(weiYunFileInfo.f209603d, weiYunFileInfo);
        WeiyunPB$DiskSimpleFileItem weiyunPB$DiskSimpleFileItem = new WeiyunPB$DiskSimpleFileItem();
        weiyunPB$DiskSimpleFileItem.file_id.set(weiYunFileInfo.f209603d);
        String str = weiYunFileInfo.f209604e;
        if (str != null) {
            weiyunPB$DiskSimpleFileItem.pdir_key.set(com.tencent.mobileqq.weiyun.utils.e.b(str));
        }
        weiyunPB$DiskSimpleFileItem.filename.set(weiYunFileInfo.f209605f);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(weiyunPB$DiskSimpleFileItem);
        WeiyunPB$DiskDirFileBatchDeleteExMsgReq weiyunPB$DiskDirFileBatchDeleteExMsgReq = new WeiyunPB$DiskDirFileBatchDeleteExMsgReq();
        weiyunPB$DiskDirFileBatchDeleteExMsgReq.file_list.set(arrayList);
        ((IWeiyunApi) QRoute.api(IWeiyunApi.class)).batchDelete(weiyunPB$DiskDirFileBatchDeleteExMsgReq, new j(weiYunFileInfo));
    }

    public com.tencent.mobileqq.filemanageraux.core.d g(FileManagerEntity fileManagerEntity, Object obj, y43.c cVar) {
        String download;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (com.tencent.mobileqq.filemanageraux.core.d) iPatchRedirector.redirect((short) 16, this, fileManagerEntity, obj, cVar);
        }
        if (fileManagerEntity == null) {
            if (QLog.isColorLevel()) {
                QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "downLoadWeiYunFile entity is null");
            }
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "downLoadWeiYunFile, fileId[" + fileManagerEntity.WeiYunFileId + "], fileName[" + fileManagerEntity.fileName + "], fileSize[" + fileManagerEntity.fileSize + "],modifyTime[" + fileManagerEntity.lastTime + "]");
        }
        if (TextUtils.isEmpty(fileManagerEntity.WeiYunDirKey)) {
            Pair<String, String> T0 = FileTransferHandler.T0(fileManagerEntity.WeiYunFileId);
            if (T0 == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "downLoadWeiYunFile dirKey is null");
                }
                return null;
            }
            fileManagerEntity.WeiYunDirKey = T0.first;
            fileManagerEntity.WeiYunFileId = T0.second;
        }
        if (fileManagerEntity.nWeiYunSrcType == 2) {
            str = ((IWeiyunUploadDownloadService) QRoute.api(IWeiyunUploadDownloadService.class)).downloadShare(fileManagerEntity.strLargeThumPath, fileManagerEntity.strThumbPath, fileManagerEntity.WeiYunDirKey, fileManagerEntity.WeiYunFileId, cVar);
        } else {
            com.tencent.mobileqq.weiyun.model.a createDownloadFile = ((IWeiyunUploadDownloadService) QRoute.api(IWeiyunUploadDownloadService.class)).createDownloadFile(fileManagerEntity.WeiYunFileId, fileManagerEntity.fileName, fileManagerEntity.strFileSHA, fileManagerEntity.fileSize, 0, fileManagerEntity.WeiYunDirKey, fileManagerEntity.strLargeThumPath);
            if (createDownloadFile == null) {
                download = null;
            } else {
                download = ((IWeiyunUploadDownloadService) QRoute.api(IWeiyunUploadDownloadService.class)).download(createDownloadFile, ((IWeiyunHelper) QRoute.api(IWeiyunHelper.class)).getDefaultDownloadPath(), true, cVar);
            }
            if (TextUtils.isEmpty(download)) {
                if (QLog.isColorLevel()) {
                    QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "create download task failed!");
                }
                return null;
            }
            str = download;
        }
        return new com.tencent.mobileqq.filemanageraux.core.d(str, obj, false, null, cVar);
    }

    public void k(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            WeiyunPB$DiskFileDocDownloadAbsMsgReq weiyunPB$DiskFileDocDownloadAbsMsgReq = new WeiyunPB$DiskFileDocDownloadAbsMsgReq();
            weiyunPB$DiskFileDocDownloadAbsMsgReq.file_id.set(str);
            weiyunPB$DiskFileDocDownloadAbsMsgReq.pdir_key.set(com.tencent.mobileqq.weiyun.utils.e.b(str2));
            ((IWeiyunApi) QRoute.api(IWeiyunApi.class)).fetchPreviewAddress(weiyunPB$DiskFileDocDownloadAbsMsgReq, new a());
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "get weiyun file PreviewAddress onFailed, fileId[" + str + "],dirKey[" + str2 + "]");
        }
        this.f209568a.getFileManagerNotifyCenter().b(false, 278, new Object[]{Integer.valueOf(ErrorCode.TRAN_INVALID_PARAMETER), HardCodeUtil.qqStr(R.string.vkv), "", "", "", "", 0});
    }

    public void r(FileManagerEntity fileManagerEntity, long j3, String str, boolean z16, boolean z17, com.tencent.mobileqq.weiyun.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, fileManagerEntity, Long.valueOf(j3), str, Boolean.valueOf(z16), Boolean.valueOf(z17), aVar);
            return;
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            if (aVar != null) {
                aVar.onError(2, "");
            }
            if (QLog.isColorLevel()) {
                QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getShareLink : network error");
                return;
            }
            return;
        }
        WeiyunPB$WeiyunShareAddFromMobileQQMsgReq weiyunPB$WeiyunShareAddFromMobileQQMsgReq = new WeiyunPB$WeiyunShareAddFromMobileQQMsgReq();
        if (H(weiyunPB$WeiyunShareAddFromMobileQQMsgReq, j3, str, z16, z17) && G(weiyunPB$WeiyunShareAddFromMobileQQMsgReq, fileManagerEntity)) {
            ((IWeiyunApi) QRoute.api(IWeiyunApi.class)).getShareLink(weiyunPB$WeiyunShareAddFromMobileQQMsgReq, new C7590b(aVar));
        } else if (aVar != null) {
            aVar.onError(13, "");
        }
    }

    public String s(String str, String str2, int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, this, str, str2, Integer.valueOf(i3), obj);
        }
        return t(str, str2, i3, false, obj);
    }

    public String u(String str, String str2, int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, this, str, str2, Integer.valueOf(i3), obj);
        }
        return t(str, str2, i3, true, obj);
    }

    public boolean v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        return ((IWeiyunApi) QRoute.api(IWeiyunApi.class)).isPwdQueried();
    }

    public FileManagerEntity x(FileManagerEntity fileManagerEntity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (FileManagerEntity) iPatchRedirector.redirect((short) 8, (Object) this, (Object) fileManagerEntity, (Object) str);
        }
        if (fileManagerEntity == null) {
            if (QLog.isColorLevel()) {
                QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "insertOfflineFile2WeiYunEntity : entity is null!");
            }
            FileManagerUtil.printStack();
            return null;
        }
        if (str == null) {
            if (QLog.isColorLevel()) {
                QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "insertOfflineFile2WeiYunEntity : fromUin is null!");
            }
            FileManagerUtil.printStack();
            return null;
        }
        FileManagerEntity fileManagerEntity2 = new FileManagerEntity();
        fileManagerEntity2.copyFrom(fileManagerEntity);
        fileManagerEntity2.nSessionId = FileManagerUtil.genSessionId().longValue();
        fileManagerEntity2.uniseq = -1L;
        fileManagerEntity2.nOpType = 4;
        fileManagerEntity2.peerNick = FileManagerUtil.getPeerNick(this.f209568a, str, null, fileManagerEntity.peerType);
        fileManagerEntity2.peerType = fileManagerEntity.peerType;
        fileManagerEntity2.peerUin = str;
        if (fileManagerEntity.peerType == 3000) {
            fileManagerEntity2.selfUin = fileManagerEntity.peerUin;
        } else {
            fileManagerEntity2.selfUin = this.f209568a.getAccount();
        }
        fileManagerEntity2.srvTime = com.tencent.mobileqq.service.message.e.K0() * 1000;
        fileManagerEntity2.status = 2;
        this.f209568a.getFileManagerDataCenter().t(fileManagerEntity2);
        if (QLog.isColorLevel()) {
            QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "insertWeiYun2OfflineEntity FileManagerEntity:" + FileManagerUtil.printFileManagerEntityInfo(fileManagerEntity2));
        }
        return fileManagerEntity2;
    }

    public void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "queryNeedVerifyPwd");
        }
        ((IWeiyunApi) QRoute.api(IWeiyunApi.class)).queryPwd(new c());
    }

    public void z(int i3, String str, int i16, int i17, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i18 = 5;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17), str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "queryWeiyunFileList, categoryId[" + str + "], offset[" + i16 + "], count[" + i17 + "], version[" + str2 + "]");
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            this.f209568a.getFileManagerNotifyCenter().b(false, 31, new Object[]{0, "network error", str});
            if (QLog.isColorLevel()) {
                QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "queryWeiyunFileList : network error");
                return;
            }
            return;
        }
        if (i16 == 0) {
            LinkedHashMap<String, WeiYunFileInfo> linkedHashMap = this.f209569b;
            if (linkedHashMap != null) {
                linkedHashMap.clear();
            }
            this.f209569b = new LinkedHashMap<>();
            this.f209570c = 0;
        } else if (this.f209569b == null) {
            if (QLog.isColorLevel()) {
                QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "queryWeiyunFileList : start not from zero?!");
                return;
            }
            return;
        }
        this.f209570c++;
        QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "categoryId : " + str);
        if ("document".equals(str)) {
            i18 = 1;
        } else if ("picture".equals(str)) {
            i18 = 2;
        } else if ("video".equals(str)) {
            i18 = 4;
        } else if ("music".equals(str)) {
            i18 = 3;
        }
        WeiyunPB$LibInfoListGetMsgReq weiyunPB$LibInfoListGetMsgReq = new WeiyunPB$LibInfoListGetMsgReq();
        weiyunPB$LibInfoListGetMsgReq.lib_id.set(i18);
        weiyunPB$LibInfoListGetMsgReq.load_type.set(1);
        PBStringField pBStringField = weiyunPB$LibInfoListGetMsgReq.local_version;
        if (str2 == null) {
            str2 = "";
        }
        pBStringField.set(str2);
        weiyunPB$LibInfoListGetMsgReq.count.set(i17);
        weiyunPB$LibInfoListGetMsgReq.scene_id.set(i3);
        ((IWeiyunApi) QRoute.api(IWeiyunApi.class)).getCategoryFileList(weiyunPB$LibInfoListGetMsgReq, new e(str));
    }
}
