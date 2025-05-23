package com.tencent.mobileqq.weiyun;

import android.app.Application;
import android.content.SharedPreferences;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.SosoInterface;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.weiyun.api.IWeiyunApi;
import com.tencent.mobileqq.weiyun.api.IWeiyunHelper;
import com.tencent.mobileqq.weiyun.api.impl.WeiyunApiImpl;
import com.tencent.mobileqq.weiyun.model.a;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$DiskFileBatchDownloadMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$DiskFileBatchDownloadMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$DiskFileDownloadRspItem;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$DiskPicBackupReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$DiskPicBackupRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$DiskSimpleFileItem;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$FileExtInfo;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$QqSdkFileUploadMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$QqSdkFileUploadMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$WeiyunTrialCouponUseMsgReq;
import com.tencent.mobileqq.weiyun.sdk.upload.WyUploadJob;
import com.tencent.mobileqq.weiyun.utils.g;
import com.tencent.mobileqq.weiyun.utils.h;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.weiyun.transmission.ErrorCode;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.WeiyunTransmissionStatus;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadJobContext;
import com.tencent.weiyun.transmission.upload.UploadManager;
import com.tencent.weiyun.transmission.upload.UploadType;
import com.tencent.weiyun.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class TransmissionHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f315103a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f315104b;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements INetEventHandler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetEventHandler
        public void onNetChangeEvent(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else {
                WeiyunTransmissionStatus.getInstance().onReceiveNetChanged(z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements y43.d {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes20.dex */
        class a implements x43.a<WeiyunPB$DiskFileBatchDownloadMsgRsp> {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.weiyun.model.a f315108a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ y43.a f315109b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f315110c;

            a(com.tencent.mobileqq.weiyun.model.a aVar, y43.a aVar2, int i3) {
                this.f315108a = aVar;
                this.f315109b = aVar2;
                this.f315110c = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, b.this, aVar, aVar2, Integer.valueOf(i3));
                }
            }

            @Override // x43.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(int i3, String str, WeiyunPB$DiskFileBatchDownloadMsgRsp weiyunPB$DiskFileBatchDownloadMsgRsp) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, weiyunPB$DiskFileBatchDownloadMsgRsp);
                } else {
                    this.f315109b.a(this.f315108a, false, i3, str);
                }
            }

            @Override // x43.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onSuccess(WeiyunPB$DiskFileBatchDownloadMsgRsp weiyunPB$DiskFileBatchDownloadMsgRsp) {
                WeiyunPB$DiskFileDownloadRspItem weiyunPB$DiskFileDownloadRspItem;
                String str;
                PBRepeatMessageField<WeiyunPB$DiskFileDownloadRspItem> pBRepeatMessageField;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) weiyunPB$DiskFileBatchDownloadMsgRsp);
                    return;
                }
                if (weiyunPB$DiskFileBatchDownloadMsgRsp != null && (pBRepeatMessageField = weiyunPB$DiskFileBatchDownloadMsgRsp.file_list) != null) {
                    Iterator<WeiyunPB$DiskFileDownloadRspItem> it = pBRepeatMessageField.get().iterator();
                    while (it.hasNext()) {
                        weiyunPB$DiskFileDownloadRspItem = it.next();
                        if (weiyunPB$DiskFileDownloadRspItem != null && TextUtils.equals(weiyunPB$DiskFileDownloadRspItem.file_id.get(), this.f315108a.f315158e)) {
                            break;
                        }
                    }
                }
                weiyunPB$DiskFileDownloadRspItem = null;
                if (weiyunPB$DiskFileDownloadRspItem == null) {
                    this.f315109b.a(this.f315108a, false, ErrorCode.CMD_RECV_EMPTY_BODY, HardCodeUtil.qqStr(R.string.u8u));
                    return;
                }
                String str2 = weiyunPB$DiskFileDownloadRspItem.cookie_name.get();
                String str3 = weiyunPB$DiskFileDownloadRspItem.cookie_value.get();
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    str = str2 + '=' + str3;
                } else {
                    str = "";
                }
                this.f315108a.c(weiyunPB$DiskFileDownloadRspItem.server_name.get(), weiyunPB$DiskFileDownloadRspItem.server_port.get(), str, weiyunPB$DiskFileDownloadRspItem.download_url.get(), weiyunPB$DiskFileDownloadRspItem.video_url.get(), "0");
                if (this.f315110c == 0) {
                    a.b bVar = this.f315108a.G;
                    bVar.f315166h = com.tencent.mobileqq.weiyun.sdk.download.a.c(bVar.f315166h);
                }
                this.f315109b.a(this.f315108a, true, 0, null);
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // y43.d
        public void a(com.tencent.mobileqq.weiyun.model.a aVar, int i3, y43.a aVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, aVar, Integer.valueOf(i3), aVar2);
                return;
            }
            WeiyunPB$DiskSimpleFileItem weiyunPB$DiskSimpleFileItem = new WeiyunPB$DiskSimpleFileItem();
            weiyunPB$DiskSimpleFileItem.file_id.set(aVar.f315158e);
            String str = aVar.D;
            if (str != null) {
                weiyunPB$DiskSimpleFileItem.pdir_key.set(com.tencent.mobileqq.weiyun.utils.e.b(str));
            }
            weiyunPB$DiskSimpleFileItem.filename.set(aVar.f315159f);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(weiyunPB$DiskSimpleFileItem);
            WeiyunPB$DiskFileBatchDownloadMsgReq weiyunPB$DiskFileBatchDownloadMsgReq = new WeiyunPB$DiskFileBatchDownloadMsgReq();
            weiyunPB$DiskFileBatchDownloadMsgReq.file_list.set(arrayList);
            weiyunPB$DiskFileBatchDownloadMsgReq.download_type.set(i3);
            PBBoolField pBBoolField = weiyunPB$DiskFileBatchDownloadMsgReq.need_thumb;
            if (i3 == 1) {
                z16 = true;
            }
            pBBoolField.set(z16);
            if (!TextUtils.isEmpty(aVar.C) && TextUtils.isDigitsOnly(aVar.C)) {
                weiyunPB$DiskFileBatchDownloadMsgReq.file_owner.set(Long.parseLong(aVar.C));
            }
            ((IWeiyunApi) QRoute.api(IWeiyunApi.class)).fetchDownloadAddress(weiyunPB$DiskFileBatchDownloadMsgReq, new a(aVar, aVar2, i3));
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class c implements y43.c {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // y43.c
        public void a(String str, long j3, com.tencent.mobileqq.weiyun.model.c cVar, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Long.valueOf(j3), cVar, Boolean.valueOf(z16));
                return;
            }
            if (z16) {
                if (cVar.f315182d == 5) {
                    h.b(str, "actFileWyDown", cVar, false, j3);
                } else if (cVar.f315182d == 4) {
                    h.b(str, "actFileWyDown", cVar, true, j3);
                }
            }
        }

        @Override // y43.c
        public void b(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class d implements UploadManager.IUploadStatusListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.weiyun.transmission.upload.UploadManager.IUploadStatusListener
        public void onUploadJobAdded(String str, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Long.valueOf(j3));
            }
        }

        @Override // com.tencent.weiyun.transmission.upload.UploadManager.IUploadStatusListener
        public void onUploadStatusChanged(String str, long j3, UploadJobContext.StatusInfo statusInfo, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Long.valueOf(j3), statusInfo, Boolean.valueOf(z16));
                return;
            }
            if (z16) {
                if (statusInfo.state == 6) {
                    h.c(str, "actFileWyUp", statusInfo, false, j3);
                } else if (statusInfo.state == 5) {
                    h.c(str, "actFileWyUp", statusInfo, true, j3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class e implements WeiyunTransmissionGlobal.HostInterface {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final String f315112a;

        /* compiled from: P */
        /* loaded from: classes20.dex */
        class a implements x43.a<WeiyunPB$DiskPicBackupRsp> {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ WeiyunTransmissionGlobal.UploadServerInfoCallback f315113a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ UploadFile f315114b;

            a(WeiyunTransmissionGlobal.UploadServerInfoCallback uploadServerInfoCallback, UploadFile uploadFile) {
                this.f315113a = uploadServerInfoCallback;
                this.f315114b = uploadFile;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, e.this, uploadServerInfoCallback, uploadFile);
                }
            }

            @Override // x43.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(int i3, String str, WeiyunPB$DiskPicBackupRsp weiyunPB$DiskPicBackupRsp) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, weiyunPB$DiskPicBackupRsp);
                } else {
                    this.f315113a.onResult(this.f315114b, false, i3, str);
                }
            }

            @Override // x43.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onSuccess(WeiyunPB$DiskPicBackupRsp weiyunPB$DiskPicBackupRsp) {
                PBStringField pBStringField;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) weiyunPB$DiskPicBackupRsp);
                    return;
                }
                if (weiyunPB$DiskPicBackupRsp == null) {
                    this.f315113a.onResult(this.f315114b, false, ErrorCode.CMD_RECV_EMPTY_BODY, HardCodeUtil.qqStr(R.string.u8v));
                    return;
                }
                ByteStringMicro byteStringMicro = weiyunPB$DiskPicBackupRsp.pdir_key.get();
                ByteStringMicro byteStringMicro2 = weiyunPB$DiskPicBackupRsp.ppdir_key.get();
                if (byteStringMicro != null) {
                    this.f315114b.pDirKey = com.tencent.mobileqq.weiyun.utils.e.a(byteStringMicro);
                }
                if (byteStringMicro2 != null) {
                    this.f315114b.pPDirKey = com.tencent.mobileqq.weiyun.utils.e.a(byteStringMicro2);
                }
                if (!TextUtils.isEmpty(weiyunPB$DiskPicBackupRsp.backup_path.get())) {
                    this.f315114b.pDirName = weiyunPB$DiskPicBackupRsp.backup_path.get();
                }
                UploadFile uploadFile = this.f315114b;
                boolean z16 = weiyunPB$DiskPicBackupRsp.file_exist.get();
                String str = weiyunPB$DiskPicBackupRsp.file_id.get();
                String str2 = weiyunPB$DiskPicBackupRsp.server_name.get();
                if (WeiyunTransmissionGlobal.getInstance().isNativeUpload()) {
                    pBStringField = weiyunPB$DiskPicBackupRsp.inside_upload_ip;
                } else {
                    pBStringField = weiyunPB$DiskPicBackupRsp.outside_upload_ip;
                }
                uploadFile.setServerInfo(z16, str, str2, pBStringField.get(), weiyunPB$DiskPicBackupRsp.server_port.get(), Utils.bytes2HexStr(weiyunPB$DiskPicBackupRsp.check_key.get().toByteArray()).toLowerCase(), weiyunPB$DiskPicBackupRsp.channel_count.get(), Integer.toString(weiyunPB$DiskPicBackupRsp.file_version.get()));
                this.f315113a.onResult(this.f315114b, true, 0, null);
                com.tencent.mobileqq.weiyun.utils.c.i(MobileQQ.sMobileQQ, String.valueOf(e.this.getCurrentUin()), "upload_coupon_count", String.valueOf(weiyunPB$DiskPicBackupRsp.coupon_count.get()));
            }
        }

        /* compiled from: P */
        /* loaded from: classes20.dex */
        class b implements x43.a<WeiyunPB$QqSdkFileUploadMsgRsp> {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ WeiyunTransmissionGlobal.UploadServerInfoCallback f315116a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ UploadFile f315117b;

            b(WeiyunTransmissionGlobal.UploadServerInfoCallback uploadServerInfoCallback, UploadFile uploadFile) {
                this.f315116a = uploadServerInfoCallback;
                this.f315117b = uploadFile;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, e.this, uploadServerInfoCallback, uploadFile);
                }
            }

            @Override // x43.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(int i3, String str, WeiyunPB$QqSdkFileUploadMsgRsp weiyunPB$QqSdkFileUploadMsgRsp) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, weiyunPB$QqSdkFileUploadMsgRsp);
                } else {
                    this.f315116a.onResult(this.f315117b, false, i3, str);
                }
            }

            @Override // x43.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onSuccess(WeiyunPB$QqSdkFileUploadMsgRsp weiyunPB$QqSdkFileUploadMsgRsp) {
                String a16;
                String a17;
                PBStringField pBStringField;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) weiyunPB$QqSdkFileUploadMsgRsp);
                    return;
                }
                if (weiyunPB$QqSdkFileUploadMsgRsp == null) {
                    this.f315116a.onResult(this.f315117b, false, ErrorCode.CMD_RECV_EMPTY_BODY, HardCodeUtil.qqStr(R.string.u8w));
                    return;
                }
                ByteStringMicro byteStringMicro = weiyunPB$QqSdkFileUploadMsgRsp.pdir_key.get();
                ByteStringMicro byteStringMicro2 = weiyunPB$QqSdkFileUploadMsgRsp.ppdir_key.get();
                if (byteStringMicro == null) {
                    a16 = null;
                } else {
                    a16 = com.tencent.mobileqq.weiyun.utils.e.a(byteStringMicro);
                }
                if (byteStringMicro2 == null) {
                    a17 = null;
                } else {
                    a17 = com.tencent.mobileqq.weiyun.utils.e.a(byteStringMicro2);
                }
                if (a16 != null && TextUtils.isEmpty(this.f315117b.pDirKey)) {
                    this.f315117b.pDirKey = a16;
                }
                if (byteStringMicro2 != null && TextUtils.isEmpty(this.f315117b.pPDirKey)) {
                    this.f315117b.pPDirKey = a17;
                }
                ((IWeiyunHelper) QRoute.api(IWeiyunHelper.class)).saveDefaultUploadDirKey(a17, a16);
                UploadFile uploadFile = this.f315117b;
                boolean z16 = weiyunPB$QqSdkFileUploadMsgRsp.file_exist.get();
                String str = weiyunPB$QqSdkFileUploadMsgRsp.file_id.get();
                String str2 = weiyunPB$QqSdkFileUploadMsgRsp.server_name.get();
                if (WeiyunTransmissionGlobal.getInstance().isNativeUpload()) {
                    pBStringField = weiyunPB$QqSdkFileUploadMsgRsp.inside_upload_ip;
                } else {
                    pBStringField = weiyunPB$QqSdkFileUploadMsgRsp.outside_upload_ip;
                }
                uploadFile.setServerInfo(z16, str, str2, pBStringField.get(), weiyunPB$QqSdkFileUploadMsgRsp.server_port.get(), Utils.bytes2HexStr(weiyunPB$QqSdkFileUploadMsgRsp.check_key.get().toByteArray()).toLowerCase(), weiyunPB$QqSdkFileUploadMsgRsp.channel_count.get(), Integer.toString(weiyunPB$QqSdkFileUploadMsgRsp.file_version.get()));
                this.f315116a.onResult(this.f315117b, true, 0, null);
            }
        }

        e(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            } else {
                this.f315112a = str;
            }
        }

        @Override // com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.HostInterface
        public void fetchUploadServerInfo(UploadFile uploadFile, UploadType uploadType, WeiyunTransmissionGlobal.UploadServerInfoCallback uploadServerInfoCallback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, uploadFile, uploadType, uploadServerInfoCallback);
                return;
            }
            WeiyunApiImpl weiyunApiImpl = (WeiyunApiImpl) QRoute.api(IWeiyunApi.class);
            int i3 = uploadFile.cmdType;
            if (i3 == 1) {
                WeiyunPB$DiskPicBackupReq weiyunPB$DiskPicBackupReq = new WeiyunPB$DiskPicBackupReq();
                String str = uploadFile.fileName;
                if (str != null) {
                    weiyunPB$DiskPicBackupReq.filename.set(str);
                }
                weiyunPB$DiskPicBackupReq.file_exist_option.set(uploadType.ordinal());
                weiyunPB$DiskPicBackupReq.upload_type.set(0);
                weiyunPB$DiskPicBackupReq.auto_create_user.set(false);
                weiyunPB$DiskPicBackupReq.auto_flag.set(uploadFile.autoBackupFlag);
                weiyunPB$DiskPicBackupReq.backup_dir_name.set(DeviceInfoMonitor.getModel());
                if (uploadFile.isCompress && !TextUtils.isEmpty(uploadFile.compressedPath)) {
                    String str2 = uploadFile.compressedSha;
                    if (str2 != null) {
                        weiyunPB$DiskPicBackupReq.file_sha.set(com.tencent.mobileqq.weiyun.utils.e.b(str2));
                    }
                    weiyunPB$DiskPicBackupReq.file_size.set(uploadFile.compressedSize);
                    weiyunPB$DiskPicBackupReq.first_256k_crc.set((int) com.tencent.mobileqq.weiyun.utils.a.a(uploadFile.compressedPath, 262144L));
                } else {
                    String str3 = uploadFile.sha;
                    if (str3 != null) {
                        weiyunPB$DiskPicBackupReq.file_sha.set(com.tencent.mobileqq.weiyun.utils.e.b(str3));
                    }
                    weiyunPB$DiskPicBackupReq.file_size.set(uploadFile.fileSize);
                    weiyunPB$DiskPicBackupReq.first_256k_crc.set((int) com.tencent.mobileqq.weiyun.utils.a.a(uploadFile.localPath, 262144L));
                }
                if (!TextUtils.isEmpty(uploadFile.mimeType)) {
                    WeiyunPB$FileExtInfo weiyunPB$FileExtInfo = new WeiyunPB$FileExtInfo();
                    weiyunPB$FileExtInfo.take_time.set(uploadFile.takenTime);
                    weiyunPB$FileExtInfo.latitude.set(uploadFile.latitude);
                    weiyunPB$FileExtInfo.longitude.set(uploadFile.longitude);
                    if (uploadFile.mimeType.startsWith("image")) {
                        weiyunPB$FileExtInfo.group_id.set(1);
                    } else {
                        uploadFile.mimeType.startsWith("video");
                    }
                    weiyunPB$DiskPicBackupReq.ext_info.set(weiyunPB$FileExtInfo);
                }
                weiyunApiImpl.fetchBackupAddress(weiyunPB$DiskPicBackupReq, new a(uploadServerInfoCallback, uploadFile));
                return;
            }
            if (i3 == 0) {
                WeiyunPB$QqSdkFileUploadMsgReq weiyunPB$QqSdkFileUploadMsgReq = new WeiyunPB$QqSdkFileUploadMsgReq();
                String str4 = uploadFile.fileName;
                if (str4 != null) {
                    weiyunPB$QqSdkFileUploadMsgReq.filename.set(str4);
                }
                weiyunPB$QqSdkFileUploadMsgReq.file_exist_option.set(uploadType.ordinal());
                weiyunPB$QqSdkFileUploadMsgReq.upload_type.set(0);
                weiyunPB$QqSdkFileUploadMsgReq.auto_create_user.set(false);
                weiyunPB$QqSdkFileUploadMsgReq.pdir_key.set(com.tencent.mobileqq.weiyun.utils.e.b(uploadFile.pDirKey));
                weiyunPB$QqSdkFileUploadMsgReq.ppdir_key.set(com.tencent.mobileqq.weiyun.utils.e.b(uploadFile.pPDirKey));
                weiyunPB$QqSdkFileUploadMsgReq.use_mutil_channel.set(WeiyunTransmissionGlobal.getInstance().isNativeUpload());
                if (uploadFile.isCompress && !TextUtils.isEmpty(uploadFile.compressedPath)) {
                    String str5 = uploadFile.compressedSha;
                    if (str5 != null) {
                        weiyunPB$QqSdkFileUploadMsgReq.file_sha.set(com.tencent.mobileqq.weiyun.utils.e.b(str5));
                    }
                    weiyunPB$QqSdkFileUploadMsgReq.file_size.set(uploadFile.compressedSize);
                } else {
                    String str6 = uploadFile.sha;
                    if (str6 != null) {
                        weiyunPB$QqSdkFileUploadMsgReq.file_sha.set(com.tencent.mobileqq.weiyun.utils.e.b(str6));
                    }
                    weiyunPB$QqSdkFileUploadMsgReq.file_size.set(uploadFile.fileSize);
                }
                if (!TextUtils.isEmpty(uploadFile.mimeType)) {
                    WeiyunPB$FileExtInfo weiyunPB$FileExtInfo2 = new WeiyunPB$FileExtInfo();
                    weiyunPB$FileExtInfo2.take_time.set(uploadFile.takenTime);
                    weiyunPB$FileExtInfo2.latitude.set(uploadFile.latitude);
                    weiyunPB$FileExtInfo2.longitude.set(uploadFile.longitude);
                    if (uploadFile.mimeType.startsWith("image")) {
                        weiyunPB$FileExtInfo2.group_id.set(1);
                    } else {
                        uploadFile.mimeType.startsWith("video");
                    }
                    weiyunPB$QqSdkFileUploadMsgReq.ext_info.set(weiyunPB$FileExtInfo2);
                }
                weiyunApiImpl.fetchUploadAddress(weiyunPB$QqSdkFileUploadMsgReq, new b(uploadServerInfoCallback, uploadFile));
            }
        }

        @Override // com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.HostInterface
        public int getCurrentIsp() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return 0;
        }

        @Override // com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.HostInterface
        public String getCurrentUid() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f315112a + MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
        }

        @Override // com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.HostInterface
        public long getCurrentUin() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            return MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin();
        }

        @Override // com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.HostInterface
        public NetworkInfo getRecentNetworkInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (NetworkInfo) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return AppNetConnInfo.getRecentNetworkInfo();
        }

        @Override // com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.HostInterface
        public SharedPreferences getSharedPreferences(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (SharedPreferences) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, i3);
            }
            return BaseApplication.getContext().getSharedPreferences(str, i3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19162);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f315104b = false;
        }
    }

    public static com.tencent.mobileqq.weiyun.model.a a(String str, String str2, String str3, long j3, int i3, String str4, String str5) {
        String str6;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str4)) {
            return null;
        }
        if (TextUtils.isEmpty(str3)) {
            str6 = "0";
        } else {
            str6 = str3;
        }
        return com.tencent.mobileqq.weiyun.model.a.b(10, str, str2, str6, j3, i3, MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), str4, str5);
    }

    public static UploadFile b(String str, UploadFile.UploadBatch uploadBatch, int i3) {
        if (TextUtils.isEmpty(str) || uploadBatch == null || i3 < 0) {
            return null;
        }
        String[] defaultUploadDirKey = ((IWeiyunHelper) QRoute.api(IWeiyunHelper.class)).getDefaultUploadDirKey();
        UploadFile createUploadFile = UploadFile.createUploadFile(0, MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), "QQ", defaultUploadDirKey[1], defaultUploadDirKey[0], str, false, uploadBatch, i3);
        createUploadFile.autoBackupFlag = false;
        return createUploadFile;
    }

    public static UploadFile c(String str, UploadFile.UploadBatch uploadBatch, int i3) {
        if (TextUtils.isEmpty(str) || uploadBatch == null || i3 < 0) {
            return null;
        }
        String model = DeviceInfoMonitor.getModel();
        UploadFile createUploadFile = UploadFile.createUploadFile(1, MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), model, model, model, str, false, uploadBatch, i3);
        createUploadFile.autoBackupFlag = false;
        return createUploadFile;
    }

    private static String d() {
        if (f315103a == null) {
            f315103a = "V1_AND_WY_VersionName_" + TransFileUtil.getVersionCode() + "_ChannelId_B";
        }
        return f315103a;
    }

    public static void e(Application application, boolean z16) {
        String str;
        if (f315104b) {
            return;
        }
        WeiyunTransmissionGlobal.AppInfo appInfo = new WeiyunTransmissionGlobal.AppInfo(d(), 1000269, MimeHelper.MIME_TYPE_MOBILEQQ, TransFileUtil.getVersionCode(), 0, "unknown");
        WeiyunTransmissionGlobal weiyunTransmissionGlobal = WeiyunTransmissionGlobal.getInstance();
        if (z16) {
            str = "weiyun_";
        } else {
            str = SosoInterface.PRE;
        }
        weiyunTransmissionGlobal.initTransmission(appInfo, application, new e(str), g.a());
        WeiyunTransmissionGlobal.getInstance().getUploadManager().setSpareUploader(new WyUploadJob());
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            WeiyunTransmissionStatus.getInstance().setTranOnlyWifi(0, true, peekAppRuntime.getAccount());
            WeiyunTransmissionStatus.getInstance().setLoginStatus(0, peekAppRuntime.getAccount());
        }
        AppNetConnInfo.registerNetChangeReceiver(null, new a());
        com.tencent.mobileqq.weiyun.sdk.download.c.u().x(new b(), application);
        com.tencent.mobileqq.weiyun.sdk.download.c.u().i(new c());
        WeiyunTransmissionGlobal.getInstance().getUploadManager().addGlobalObserver(new d());
        f315104b = true;
    }

    public static void f(boolean z16, long j3) {
        ThreadManagerV2.excute(new Runnable(z16, j3) { // from class: com.tencent.mobileqq.weiyun.TransmissionHelper.5
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f315105d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ long f315106e;

            {
                this.f315105d = z16;
                this.f315106e = j3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Long.valueOf(j3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    WeiyunTransmissionStatus.getInstance().setLoginStatus(!this.f315105d ? 1 : 0, Long.toString(this.f315106e));
                    ((IWeiyunHelper) QRoute.api(IWeiyunHelper.class)).clearDefaultUploadDirKey();
                }
            }
        }, 16, null, false);
    }

    public static void g(int i3) {
        new BaseThread(new Runnable(i3) { // from class: com.tencent.mobileqq.weiyun.TransmissionHelper.6
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f315107d;

            {
                this.f315107d = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, i3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                WeiyunPB$WeiyunTrialCouponUseMsgReq weiyunPB$WeiyunTrialCouponUseMsgReq = new WeiyunPB$WeiyunTrialCouponUseMsgReq();
                weiyunPB$WeiyunTrialCouponUseMsgReq.business_id.set("upload_speed_up");
                ((IWeiyunApi) QRoute.api(IWeiyunApi.class)).trialTransferCoupon(weiyunPB$WeiyunTrialCouponUseMsgReq, null);
                int i16 = this.f315107d;
                if (i16 > 0) {
                    MobileQQ mobileQQ = MobileQQ.sMobileQQ;
                    com.tencent.mobileqq.weiyun.utils.c.i(mobileQQ, String.valueOf(mobileQQ.waitAppRuntime(null).getLongAccountUin()), "upload_coupon_count", String.valueOf(i16 - 1));
                }
            }
        }).start();
    }
}
