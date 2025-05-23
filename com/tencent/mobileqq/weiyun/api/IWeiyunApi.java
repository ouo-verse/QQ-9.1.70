package com.tencent.mobileqq.weiyun.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.core.f;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
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
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$PwdQueryMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$PwdVerifyMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$PwdVerifyMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$QqSdkFileUploadMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$QqSdkFileUploadMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$WeiyunShareAddFromMobileQQMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$WeiyunShareAddFromMobileQQMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$WeiyunTrialCouponUseMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$WeiyunTrialCouponUseMsgRsp;
import x43.a;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IWeiyunApi extends QRouteApi {
    public static final int FTN_BID_OFFLINE = 3;
    public static final int FTN_BID_WEIYUN = 25;

    void addDeletingCloudFile(String str, WeiYunFileInfo weiYunFileInfo);

    void batchDelete(WeiyunPB$DiskDirFileBatchDeleteExMsgReq weiyunPB$DiskDirFileBatchDeleteExMsgReq, a<WeiyunPB$DiskDirFileBatchDeleteExMsgRsp> aVar);

    void checkPwd(WeiyunPB$PwdVerifyMsgReq weiyunPB$PwdVerifyMsgReq, a<WeiyunPB$PwdVerifyMsgRsp> aVar);

    void checkPwdMd5(String str, a<WeiyunPB$PwdVerifyMsgRsp> aVar);

    void cleanPwdRecord(Context context, long j3);

    void copyFileToOtherBid(WeiyunPB$CrossBidProxyCopyFileToOtherBidMsgReq weiyunPB$CrossBidProxyCopyFileToOtherBidMsgReq, a<WeiyunPB$CrossBidProxyCopyFileToOtherBidMsgRsp> aVar);

    void fetchBackupAddress(WeiyunPB$DiskPicBackupReq weiyunPB$DiskPicBackupReq, a<WeiyunPB$DiskPicBackupRsp> aVar);

    void fetchDownloadAddress(WeiyunPB$DiskFileBatchDownloadMsgReq weiyunPB$DiskFileBatchDownloadMsgReq, a<WeiyunPB$DiskFileBatchDownloadMsgRsp> aVar);

    void fetchPreviewAddress(WeiyunPB$DiskFileDocDownloadAbsMsgReq weiyunPB$DiskFileDocDownloadAbsMsgReq, a<WeiyunPB$DiskFileDocDownloadAbsMsgRsp> aVar);

    void fetchUploadAddress(WeiyunPB$QqSdkFileUploadMsgReq weiyunPB$QqSdkFileUploadMsgReq, a<WeiyunPB$QqSdkFileUploadMsgRsp> aVar);

    void getCategoryFileList(WeiyunPB$LibInfoListGetMsgReq weiyunPB$LibInfoListGetMsgReq, a<WeiyunPB$LibInfoListGetMsgRsp> aVar);

    void getOfflineFileList(WeiyunPB$CrossBidProxyOfflineFileGetListMsgReq weiyunPB$CrossBidProxyOfflineFileGetListMsgReq, a<WeiyunPB$CrossBidProxyOfflineFileGetListMsgRsp> aVar);

    String getPwdMd5(Context context);

    void getShareLink(WeiyunPB$WeiyunShareAddFromMobileQQMsgReq weiyunPB$WeiyunShareAddFromMobileQQMsgReq, a<WeiyunPB$WeiyunShareAddFromMobileQQMsgRsp> aVar);

    f getWeiYunFilePreviewController(BaseQQAppInterface baseQQAppInterface, String str, String str2);

    void initPwdRecord(Context context);

    boolean isDeletingCloudFile(String str);

    boolean isPwdQueried();

    FileManagerEntity newEntityByWeiYunMiniAppParams(Bundle bundle);

    void queryPwd(a<WeiyunPB$PwdQueryMsgRsp> aVar);

    WeiYunFileInfo removeDeletedCloudFile(String str);

    void reportAlbumStatus(WeiyunPB$DiskAlbumStatusReportReq weiyunPB$DiskAlbumStatusReportReq, a<WeiyunPB$DiskAlbumStatusReportRsp> aVar);

    void saveAioPicVideo2Weiyun(WeiyunPB$AioPicAndVideoCopyToWeiyunMsgReq weiyunPB$AioPicAndVideoCopyToWeiyunMsgReq, a<WeiyunPB$AioPicAndVideoCopyToWeiyunMsgRsp> aVar);

    void savePwdMd5(Context context, String str);

    void setPwdOpened(Context context, boolean z16);

    void setPwdQueried(Context context, boolean z16);

    void setPwdVerified(Context context, boolean z16);

    void startWeiYunMiniApp(Context context, String str, int i3, MiniAppLaunchListener miniAppLaunchListener);

    void trialTransferCoupon(WeiyunPB$WeiyunTrialCouponUseMsgReq weiyunPB$WeiyunTrialCouponUseMsgReq, a<WeiyunPB$WeiyunTrialCouponUseMsgRsp> aVar);
}
