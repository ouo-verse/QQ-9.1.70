package com.tencent.mobileqq.weiyun.api.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.core.f;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weiyun.api.IWeiyunApi;
import com.tencent.mobileqq.weiyun.channel.d;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$AioPicAndVideoCopyToWeiyunMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$AioPicAndVideoCopyToWeiyunMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$CrossBidProxyCopyFileToOtherBidMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$CrossBidProxyCopyFileToOtherBidMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$CrossBidProxyOfflineFileGetListMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$CrossBidProxyOfflineFileGetListMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$DiskAlbumStatusReportReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$DiskAlbumStatusReportRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$DiskDirFileBatchDeleteExMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$DiskDirFileBatchDeleteExMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$DiskFileBatchDownloadMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$DiskFileBatchDownloadMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$DiskFileDocDownloadAbsMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$DiskFileDocDownloadAbsMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$DiskPicBackupReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$DiskPicBackupRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$LibInfoListGetMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$LibInfoListGetMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$MsgBody;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$PwdQueryMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$PwdQueryMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$PwdVerifyMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$PwdVerifyMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$QqSdkFileUploadMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$QqSdkFileUploadMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$ReqMsgBody;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$WeiyunShareAddFromMobileQQMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$WeiyunShareAddFromMobileQQMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$WeiyunTrialCouponUseMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$WeiyunTrialCouponUseMsgRsp;
import com.tencent.mobileqq.weiyun.utils.c;
import com.tencent.mobileqq.weiyun.utils.e;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class WeiyunApiImpl implements IWeiyunApi {
    static IPatchRedirector $redirector_;
    private static final AtomicBoolean[] PWD_RECORD;
    private static Map<String, WeiYunFileInfo> mMapDeletingCloudFiles;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19434);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 31)) {
            redirector.redirect((short) 31);
        } else {
            PWD_RECORD = new AtomicBoolean[]{new AtomicBoolean(false), new AtomicBoolean(false), new AtomicBoolean(false), new AtomicBoolean(false)};
            mMapDeletingCloudFiles = new HashMap();
        }
    }

    public WeiyunApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunApi
    public void addDeletingCloudFile(String str, WeiYunFileInfo weiYunFileInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str, (Object) weiYunFileInfo);
        } else {
            mMapDeletingCloudFiles.put(str, weiYunFileInfo);
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunApi
    public void batchDelete(WeiyunPB$DiskDirFileBatchDeleteExMsgReq weiyunPB$DiskDirFileBatchDeleteExMsgReq, x43.a<WeiyunPB$DiskDirFileBatchDeleteExMsgRsp> aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) weiyunPB$DiskDirFileBatchDeleteExMsgReq, (Object) aVar);
        } else {
            d.a().c(Integer.toString(2509), getReqBytes(2509, weiyunPB$DiskDirFileBatchDeleteExMsgReq), new a(2509, aVar));
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunApi
    public void checkPwd(WeiyunPB$PwdVerifyMsgReq weiyunPB$PwdVerifyMsgReq, x43.a<WeiyunPB$PwdVerifyMsgRsp> aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) weiyunPB$PwdVerifyMsgReq, (Object) aVar);
        } else {
            d.a().c(Integer.toString(11005), getReqBytes(11005, weiyunPB$PwdVerifyMsgReq), new a(11005, aVar));
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunApi
    public void checkPwdMd5(String str, x43.a<WeiyunPB$PwdVerifyMsgRsp> aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) str, (Object) aVar);
            return;
        }
        WeiyunPB$PwdVerifyMsgReq weiyunPB$PwdVerifyMsgReq = new WeiyunPB$PwdVerifyMsgReq();
        weiyunPB$PwdVerifyMsgReq.pwd_md5.set(e.b(str));
        checkPwd(weiyunPB$PwdVerifyMsgReq, aVar);
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunApi
    public void cleanPwdRecord(Context context, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, context, Long.valueOf(j3));
            return;
        }
        c.h(context, String.valueOf(j3), "key_pwd_queried");
        c.h(context, String.valueOf(j3), "key_pwd_has");
        c.h(context, String.valueOf(j3), "key_pwd_verified");
        AtomicBoolean[] atomicBooleanArr = PWD_RECORD;
        atomicBooleanArr[0].set(false);
        atomicBooleanArr[1].set(false);
        atomicBooleanArr[2].set(false);
        atomicBooleanArr[3].set(false);
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunApi
    public void copyFileToOtherBid(WeiyunPB$CrossBidProxyCopyFileToOtherBidMsgReq weiyunPB$CrossBidProxyCopyFileToOtherBidMsgReq, x43.a<WeiyunPB$CrossBidProxyCopyFileToOtherBidMsgRsp> aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) weiyunPB$CrossBidProxyCopyFileToOtherBidMsgReq, (Object) aVar);
        } else {
            d.a().c(Integer.toString(245700), getReqBytes(245700, weiyunPB$CrossBidProxyCopyFileToOtherBidMsgReq), new a(245700, aVar));
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunApi
    public void fetchBackupAddress(WeiyunPB$DiskPicBackupReq weiyunPB$DiskPicBackupReq, x43.a<WeiyunPB$DiskPicBackupRsp> aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) weiyunPB$DiskPicBackupReq, (Object) aVar);
        } else {
            d.a().c(Integer.toString(2803), getReqBytes(2803, weiyunPB$DiskPicBackupReq), new a(2803, aVar));
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunApi
    public void fetchDownloadAddress(WeiyunPB$DiskFileBatchDownloadMsgReq weiyunPB$DiskFileBatchDownloadMsgReq, x43.a<WeiyunPB$DiskFileBatchDownloadMsgRsp> aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) weiyunPB$DiskFileBatchDownloadMsgReq, (Object) aVar);
        } else {
            d.a().c(Integer.toString(2402), getReqBytes(2402, weiyunPB$DiskFileBatchDownloadMsgReq), new a(2402, aVar));
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunApi
    public void fetchPreviewAddress(WeiyunPB$DiskFileDocDownloadAbsMsgReq weiyunPB$DiskFileDocDownloadAbsMsgReq, x43.a<WeiyunPB$DiskFileDocDownloadAbsMsgRsp> aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) weiyunPB$DiskFileDocDownloadAbsMsgReq, (Object) aVar);
        } else {
            d.a().c(Integer.toString(2414), getReqBytes(2414, weiyunPB$DiskFileDocDownloadAbsMsgReq), new a(2414, aVar));
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunApi
    public void fetchUploadAddress(WeiyunPB$QqSdkFileUploadMsgReq weiyunPB$QqSdkFileUploadMsgReq, x43.a<WeiyunPB$QqSdkFileUploadMsgRsp> aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) weiyunPB$QqSdkFileUploadMsgReq, (Object) aVar);
        } else {
            d.a().c(Integer.toString(246000), getReqBytes(246000, weiyunPB$QqSdkFileUploadMsgReq), new a(246000, aVar));
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunApi
    public void getCategoryFileList(WeiyunPB$LibInfoListGetMsgReq weiyunPB$LibInfoListGetMsgReq, x43.a<WeiyunPB$LibInfoListGetMsgRsp> aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) weiyunPB$LibInfoListGetMsgReq, (Object) aVar);
        } else {
            d.a().c(Integer.toString(26113), getReqBytes(26113, weiyunPB$LibInfoListGetMsgReq), new a(26113, aVar));
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunApi
    public void getOfflineFileList(WeiyunPB$CrossBidProxyOfflineFileGetListMsgReq weiyunPB$CrossBidProxyOfflineFileGetListMsgReq, x43.a<WeiyunPB$CrossBidProxyOfflineFileGetListMsgRsp> aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) weiyunPB$CrossBidProxyOfflineFileGetListMsgReq, (Object) aVar);
        } else {
            d.a().c(Integer.toString(245706), getReqBytes(245706, weiyunPB$CrossBidProxyOfflineFileGetListMsgReq), new a(245706, aVar));
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunApi
    public String getPwdMd5(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this, (Object) context);
        }
        return c.a(context, String.valueOf(MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin()), "key_pwd_md5");
    }

    byte[] getReqBytes(int i3, Object obj) {
        if (obj == null) {
            return null;
        }
        WeiyunPB$MsgBody weiyunPB$MsgBody = new WeiyunPB$MsgBody();
        WeiyunPB$ReqMsgBody weiyunPB$ReqMsgBody = new WeiyunPB$ReqMsgBody();
        QLog.i("WeiyunApiImpl", 1, "call weiyun task cmd : " + i3);
        switch (i3) {
            case 2402:
                weiyunPB$ReqMsgBody.DiskFileBatchDownloadMsgReq_body.set((WeiyunPB$DiskFileBatchDownloadMsgReq) obj);
                break;
            case 2414:
                weiyunPB$ReqMsgBody.DiskFileDocDownloadAbsMsgReq_body.set((WeiyunPB$DiskFileDocDownloadAbsMsgReq) obj);
                break;
            case 2509:
                weiyunPB$ReqMsgBody.DiskDirFileBatchDeleteExMsgReq_body.set((WeiyunPB$DiskDirFileBatchDeleteExMsgReq) obj);
                break;
            case 2803:
                weiyunPB$ReqMsgBody.DiskPicBackupReq_body.set((WeiyunPB$DiskPicBackupReq) obj);
                break;
            case 2804:
                weiyunPB$ReqMsgBody.DiskAlbumStatusReportReq_body.set((WeiyunPB$DiskAlbumStatusReportReq) obj);
                break;
            case 11001:
                weiyunPB$ReqMsgBody.PwdQueryMsgReq_body.set((WeiyunPB$PwdQueryMsgReq) obj);
                break;
            case 11005:
                weiyunPB$ReqMsgBody.PwdVerifyMsgReq_body.set((WeiyunPB$PwdVerifyMsgReq) obj);
                break;
            case WeiyunPB$ReqMsgBody.WEIYUNSHAREADDFROMMOBILEQQMSGREQ_BODY_FIELD_NUMBER /* 12102 */:
                weiyunPB$ReqMsgBody.WeiyunShareAddFromMobileQQMsgReq_body.set((WeiyunPB$WeiyunShareAddFromMobileQQMsgReq) obj);
                break;
            case 26113:
                weiyunPB$ReqMsgBody.LibInfoListGetMsgReq_body.set((WeiyunPB$LibInfoListGetMsgReq) obj);
                break;
            case 245520:
                weiyunPB$ReqMsgBody.WeiyunTrialCouponUseMsgReq_body.set((WeiyunPB$WeiyunTrialCouponUseMsgReq) obj);
                break;
            case 245700:
                weiyunPB$ReqMsgBody.CrossBidProxyCopyFileToOtherBidMsgReq_body.set((WeiyunPB$CrossBidProxyCopyFileToOtherBidMsgReq) obj);
                break;
            case 245706:
                weiyunPB$ReqMsgBody.CrossBidProxyOfflineFileGetListMsgReq_body.set((WeiyunPB$CrossBidProxyOfflineFileGetListMsgReq) obj);
                break;
            case 246000:
                weiyunPB$ReqMsgBody.QqSdkFileUploadMsgReq_body.set((WeiyunPB$QqSdkFileUploadMsgReq) obj);
                break;
            case 246001:
                weiyunPB$ReqMsgBody.AioPicAndVideoCopyToWeiyunMsgReq_body.set((WeiyunPB$AioPicAndVideoCopyToWeiyunMsgReq) obj);
                break;
        }
        weiyunPB$MsgBody.ReqMsg_body = weiyunPB$ReqMsgBody;
        weiyunPB$ReqMsgBody.setHasFlag(true);
        weiyunPB$MsgBody.setHasFlag(true);
        return weiyunPB$MsgBody.toByteArray();
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunApi
    public void getShareLink(WeiyunPB$WeiyunShareAddFromMobileQQMsgReq weiyunPB$WeiyunShareAddFromMobileQQMsgReq, x43.a<WeiyunPB$WeiyunShareAddFromMobileQQMsgRsp> aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) weiyunPB$WeiyunShareAddFromMobileQQMsgReq, (Object) aVar);
        } else {
            d.a().c(Integer.toString(WeiyunPB$ReqMsgBody.WEIYUNSHAREADDFROMMOBILEQQMSGREQ_BODY_FIELD_NUMBER), getReqBytes(WeiyunPB$ReqMsgBody.WEIYUNSHAREADDFROMMOBILEQQMSGREQ_BODY_FIELD_NUMBER, weiyunPB$WeiyunShareAddFromMobileQQMsgReq), new a(WeiyunPB$ReqMsgBody.WEIYUNSHAREADDFROMMOBILEQQMSGREQ_BODY_FIELD_NUMBER, aVar));
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunApi
    public f getWeiYunFilePreviewController(BaseQQAppInterface baseQQAppInterface, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (f) iPatchRedirector.redirect((short) 30, this, baseQQAppInterface, str, str2);
        }
        return new com.tencent.mobileqq.filemanageraux.core.c(baseQQAppInterface, str, str2);
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunApi
    public void initPwdRecord(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) context);
        } else {
            ThreadManagerV2.executeOnSubThread(new Runnable(context) { // from class: com.tencent.mobileqq.weiyun.api.impl.WeiyunApiImpl.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Context f315125d;

                {
                    this.f315125d = context;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WeiyunApiImpl.this, (Object) context);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    long longAccountUin = MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin();
                    boolean b16 = c.b(this.f315125d, String.valueOf(longAccountUin), "key_pwd_queried", false);
                    boolean b17 = c.b(this.f315125d, String.valueOf(longAccountUin), "key_pwd_has", false);
                    boolean b18 = c.b(this.f315125d, String.valueOf(longAccountUin), "key_pwd_verified", false);
                    WeiyunApiImpl.PWD_RECORD[0].set(b16);
                    WeiyunApiImpl.PWD_RECORD[1].set(b17);
                    WeiyunApiImpl.PWD_RECORD[2].set(b18);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunApi
    public boolean isDeletingCloudFile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str)).booleanValue();
        }
        if (mMapDeletingCloudFiles.containsKey(str)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunApi
    public boolean isPwdQueried() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        return PWD_RECORD[0].get();
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunApi
    public FileManagerEntity newEntityByWeiYunMiniAppParams(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (FileManagerEntity) iPatchRedirector.redirect((short) 14, (Object) this, (Object) bundle);
        }
        FileManagerEntity fileManagerEntity = new FileManagerEntity();
        fileManagerEntity.nSessionId = ah.R().longValue();
        fileManagerEntity.setCloudType(2);
        fileManagerEntity.nOpType = 50;
        fileManagerEntity.bSend = false;
        fileManagerEntity.WeiYunFileId = (String) bundle.get("file_id");
        fileManagerEntity.fileName = (String) bundle.get("filename");
        fileManagerEntity.WeiYunDirKey = (String) bundle.get("pdir_key");
        return fileManagerEntity;
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunApi
    public void queryPwd(x43.a<WeiyunPB$PwdQueryMsgRsp> aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) aVar);
            return;
        }
        if (aVar == null) {
            return;
        }
        AtomicBoolean[] atomicBooleanArr = PWD_RECORD;
        if (atomicBooleanArr[0].get()) {
            WeiyunPB$PwdQueryMsgRsp weiyunPB$PwdQueryMsgRsp = new WeiyunPB$PwdQueryMsgRsp();
            if (atomicBooleanArr[1].get() && !atomicBooleanArr[2].get()) {
                weiyunPB$PwdQueryMsgRsp.pwd_open.set(true);
                aVar.onSuccess(weiyunPB$PwdQueryMsgRsp);
                return;
            } else {
                weiyunPB$PwdQueryMsgRsp.pwd_open.set(false);
                aVar.onSuccess(weiyunPB$PwdQueryMsgRsp);
                return;
            }
        }
        d.a().c(Integer.toString(11001), getReqBytes(11001, new WeiyunPB$PwdQueryMsgReq()), new a(11001, aVar));
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunApi
    public WeiYunFileInfo removeDeletedCloudFile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (WeiYunFileInfo) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        }
        return mMapDeletingCloudFiles.remove(str);
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunApi
    public void reportAlbumStatus(WeiyunPB$DiskAlbumStatusReportReq weiyunPB$DiskAlbumStatusReportReq, x43.a<WeiyunPB$DiskAlbumStatusReportRsp> aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) weiyunPB$DiskAlbumStatusReportReq, (Object) aVar);
        } else {
            d.a().c(Integer.toString(2804), getReqBytes(2804, weiyunPB$DiskAlbumStatusReportReq), new a(2804, aVar));
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunApi
    public void saveAioPicVideo2Weiyun(WeiyunPB$AioPicAndVideoCopyToWeiyunMsgReq weiyunPB$AioPicAndVideoCopyToWeiyunMsgReq, x43.a<WeiyunPB$AioPicAndVideoCopyToWeiyunMsgRsp> aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) weiyunPB$AioPicAndVideoCopyToWeiyunMsgReq, (Object) aVar);
        } else {
            d.a().c(Integer.toString(246001), getReqBytes(246001, weiyunPB$AioPicAndVideoCopyToWeiyunMsgReq), new a(246001, aVar));
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunApi
    public void savePwdMd5(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) context, (Object) str);
        } else {
            c.i(context, String.valueOf(MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin()), "key_pwd_md5", str);
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunApi
    public void setPwdOpened(Context context, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, context, Boolean.valueOf(z16));
            return;
        }
        AtomicBoolean[] atomicBooleanArr = PWD_RECORD;
        atomicBooleanArr[3].set(true);
        if (atomicBooleanArr[1].compareAndSet(!z16, z16)) {
            c.i(context, String.valueOf(MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin()), "key_pwd_has", Boolean.toString(z16));
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunApi
    public void setPwdQueried(Context context, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, context, Boolean.valueOf(z16));
            return;
        }
        AtomicBoolean[] atomicBooleanArr = PWD_RECORD;
        atomicBooleanArr[3].set(true);
        if (atomicBooleanArr[0].compareAndSet(!z16, z16)) {
            c.i(context, String.valueOf(MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin()), "key_pwd_queried", Boolean.toString(z16));
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunApi
    public void setPwdVerified(Context context, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, context, Boolean.valueOf(z16));
            return;
        }
        AtomicBoolean[] atomicBooleanArr = PWD_RECORD;
        atomicBooleanArr[3].set(true);
        if (atomicBooleanArr[2].compareAndSet(!z16, z16)) {
            c.i(context, String.valueOf(MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin()), "key_pwd_verified", Boolean.toString(z16));
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunApi
    public void startWeiYunMiniApp(Context context, String str, int i3, MiniAppLaunchListener miniAppLaunchListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, context, str, Integer.valueOf(i3), miniAppLaunchListener);
        } else {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(context, "mqqapi://miniapp/open?_ext=&_mappid=1107999468&_mvid=&_nq=&_path=&_q=&referer=2011&via=2011&_sig=31ba7125a22d3462e9dc4f8abff74d9e9c445cdd46e8ea446f39a839ebb110b4", 2011, miniAppLaunchListener);
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunApi
    public void trialTransferCoupon(WeiyunPB$WeiyunTrialCouponUseMsgReq weiyunPB$WeiyunTrialCouponUseMsgReq, x43.a<WeiyunPB$WeiyunTrialCouponUseMsgRsp> aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) weiyunPB$WeiyunTrialCouponUseMsgReq, (Object) aVar);
        } else {
            d.a().c(Integer.toString(245520), getReqBytes(245520, weiyunPB$WeiyunTrialCouponUseMsgReq), new a(245520, aVar));
        }
    }
}
