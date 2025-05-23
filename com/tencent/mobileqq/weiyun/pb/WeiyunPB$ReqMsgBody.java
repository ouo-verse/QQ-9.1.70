package com.tencent.mobileqq.weiyun.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes20.dex */
public final class WeiyunPB$ReqMsgBody extends MessageMicro<WeiyunPB$ReqMsgBody> {
    public static final int AIOPICANDVIDEOCOPYTOWEIYUNMSGREQ_BODY_FIELD_NUMBER = 246001;
    public static final int CROSSBIDPROXYCOPYFILETOOTHERBIDMSGREQ_BODY_FIELD_NUMBER = 245700;
    public static final int CROSSBIDPROXYOFFLINEFILEGETLISTMSGREQ_BODY_FIELD_NUMBER = 245706;
    public static final int DISKALBUMSTATUSREPORTREQ_BODY_FIELD_NUMBER = 2804;
    public static final int DISKDIRFILEBATCHDELETEEXMSGREQ_BODY_FIELD_NUMBER = 2509;
    public static final int DISKFILEBATCHDOWNLOADMSGREQ_BODY_FIELD_NUMBER = 2402;
    public static final int DISKFILEDOCDOWNLOADABSMSGREQ_BODY_FIELD_NUMBER = 2414;
    public static final int DISKPICBACKUPREQ_BODY_FIELD_NUMBER = 2803;
    public static final int LIBINFOLISTGETMSGREQ_BODY_FIELD_NUMBER = 26113;
    public static final int PWDQUERYMSGREQ_BODY_FIELD_NUMBER = 11001;
    public static final int PWDVERIFYMSGREQ_BODY_FIELD_NUMBER = 11005;
    public static final int QQSDKFILEUPLOADMSGREQ_BODY_FIELD_NUMBER = 246000;
    public static final int WEIYUNSHAREADDFROMMOBILEQQMSGREQ_BODY_FIELD_NUMBER = 12102;
    public static final int WEIYUNTRIALCOUPONUSEMSGREQ_BODY_FIELD_NUMBER = 245520;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{19218, 19314, 20074, 22426, 22434, 88010, 88042, 96818, 208906, 1964162, 1965602, 1965650, 1968002, 1968010}, new String[]{"DiskFileBatchDownloadMsgReq_body", "DiskFileDocDownloadAbsMsgReq_body", "DiskDirFileBatchDeleteExMsgReq_body", "DiskPicBackupReq_body", "DiskAlbumStatusReportReq_body", "PwdQueryMsgReq_body", "PwdVerifyMsgReq_body", "WeiyunShareAddFromMobileQQMsgReq_body", "LibInfoListGetMsgReq_body", "WeiyunTrialCouponUseMsgReq_body", "CrossBidProxyCopyFileToOtherBidMsgReq_body", "CrossBidProxyOfflineFileGetListMsgReq_body", "QqSdkFileUploadMsgReq_body", "AioPicAndVideoCopyToWeiyunMsgReq_body"}, new Object[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null}, WeiyunPB$ReqMsgBody.class);
    public WeiyunPB$LibInfoListGetMsgReq LibInfoListGetMsgReq_body = new WeiyunPB$LibInfoListGetMsgReq();
    public WeiyunPB$DiskFileBatchDownloadMsgReq DiskFileBatchDownloadMsgReq_body = new WeiyunPB$DiskFileBatchDownloadMsgReq();
    public WeiyunPB$DiskFileDocDownloadAbsMsgReq DiskFileDocDownloadAbsMsgReq_body = new WeiyunPB$DiskFileDocDownloadAbsMsgReq();
    public WeiyunPB$DiskDirFileBatchDeleteExMsgReq DiskDirFileBatchDeleteExMsgReq_body = new WeiyunPB$DiskDirFileBatchDeleteExMsgReq();
    public WeiyunPB$DiskPicBackupReq DiskPicBackupReq_body = new WeiyunPB$DiskPicBackupReq();
    public WeiyunPB$DiskAlbumStatusReportReq DiskAlbumStatusReportReq_body = new MessageMicro<WeiyunPB$DiskAlbumStatusReportReq>() { // from class: com.tencent.mobileqq.weiyun.pb.WeiyunPB$DiskAlbumStatusReportReq
        public static final int DURING_DAYS_FIELD_NUMBER = 2;
        public static final int NEW_PIC_NUMBER_FIELD_NUMBER = 1;
        public static final int NEW_USER_FIELD_NUMBER = 3;
        public static final int UNBAKED_PIC_NUMBER_FIELD_NUMBER = 4;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"new_pic_number", "during_days", "new_user", "unbaked_pic_number"}, new Object[]{0, 0, Boolean.FALSE, 0}, WeiyunPB$DiskAlbumStatusReportReq.class);
        public final PBUInt32Field new_pic_number = PBField.initUInt32(0);
        public final PBUInt32Field during_days = PBField.initUInt32(0);
        public final PBBoolField new_user = PBField.initBool(false);
        public final PBUInt32Field unbaked_pic_number = PBField.initUInt32(0);
    };
    public WeiyunPB$PwdQueryMsgReq PwdQueryMsgReq_body = new WeiyunPB$PwdQueryMsgReq();
    public WeiyunPB$PwdVerifyMsgReq PwdVerifyMsgReq_body = new WeiyunPB$PwdVerifyMsgReq();
    public WeiyunPB$CrossBidProxyCopyFileToOtherBidMsgReq CrossBidProxyCopyFileToOtherBidMsgReq_body = new WeiyunPB$CrossBidProxyCopyFileToOtherBidMsgReq();
    public WeiyunPB$CrossBidProxyOfflineFileGetListMsgReq CrossBidProxyOfflineFileGetListMsgReq_body = new MessageMicro<WeiyunPB$CrossBidProxyOfflineFileGetListMsgReq>() { // from class: com.tencent.mobileqq.weiyun.pb.WeiyunPB$CrossBidProxyOfflineFileGetListMsgReq
        public static final int UINT32_FTN_BID_FIELD_NUMBER = 10;
        public static final int UINT32_NUMBER_FIELD_NUMBER = 3;
        public static final int UINT32_OFFLINE_TYPE_FIELD_NUMBER = 1;
        public static final int UINT32_OFFSET_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 80}, new String[]{"uint32_offline_type", "uint32_offset", "uint32_number", "uint32_ftn_bid"}, new Object[]{0, 0, 0, 0}, WeiyunPB$CrossBidProxyOfflineFileGetListMsgReq.class);
        public final PBUInt32Field uint32_offline_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_offset = PBField.initUInt32(0);
        public final PBUInt32Field uint32_number = PBField.initUInt32(0);
        public final PBUInt32Field uint32_ftn_bid = PBField.initUInt32(0);
    };
    public WeiyunPB$QqSdkFileUploadMsgReq QqSdkFileUploadMsgReq_body = new WeiyunPB$QqSdkFileUploadMsgReq();
    public WeiyunPB$AioPicAndVideoCopyToWeiyunMsgReq AioPicAndVideoCopyToWeiyunMsgReq_body = new WeiyunPB$AioPicAndVideoCopyToWeiyunMsgReq();
    public WeiyunPB$WeiyunTrialCouponUseMsgReq WeiyunTrialCouponUseMsgReq_body = new WeiyunPB$WeiyunTrialCouponUseMsgReq();
    public WeiyunPB$WeiyunShareAddFromMobileQQMsgReq WeiyunShareAddFromMobileQQMsgReq_body = new WeiyunPB$WeiyunShareAddFromMobileQQMsgReq();
}
