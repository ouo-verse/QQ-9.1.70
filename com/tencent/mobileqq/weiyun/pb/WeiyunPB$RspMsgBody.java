package com.tencent.mobileqq.weiyun.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes20.dex */
public final class WeiyunPB$RspMsgBody extends MessageMicro<WeiyunPB$RspMsgBody> {
    public static final int AIOPICANDVIDEOCOPYTOWEIYUNMSGRSP_BODY_FIELD_NUMBER = 246001;
    public static final int CROSSBIDPROXYCOPYFILETOOTHERBIDMSGRSP_BODY_FIELD_NUMBER = 245700;
    public static final int CROSSBIDPROXYOFFLINEFILEGETLISTMSGRSP_BODY_FIELD_NUMBER = 245706;
    public static final int DISKALBUMSTATUSREPORTRSP_BODY_FIELD_NUMBER = 2804;
    public static final int DISKDIRFILEBATCHDELETEEXMSGRSP_BODY_FIELD_NUMBER = 2509;
    public static final int DISKFILEBATCHDOWNLOADMSGRSP_BODY_FIELD_NUMBER = 2402;
    public static final int DISKFILEDOCDOWNLOADABSMSGRSP_BODY_FIELD_NUMBER = 2414;
    public static final int DISKPICBACKUPRSP_BODY_FIELD_NUMBER = 2803;
    public static final int LIBINFOLISTGETMSGRSP_BODY_FIELD_NUMBER = 26113;
    public static final int PWDQUERYMSGRSP_BODY_FIELD_NUMBER = 11001;
    public static final int PWDVERIFYMSGRSP_BODY_FIELD_NUMBER = 11005;
    public static final int QQSDKFILEUPLOADMSGRSP_BODY_FIELD_NUMBER = 246000;
    public static final int WEIYUNSHAREADDFROMMOBILEQQMSGRSP_BODY_FIELD_NUMBER = 12103;
    public static final int WEIYUNTRIALCOUPONUSEMSGRSP_BODY_FIELD_NUMBER = 245520;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{19218, 19314, 20074, 22426, 22434, 88010, 88042, 96826, 208906, 1964162, 1965602, 1965650, 1968002, 1968010}, new String[]{"DiskFileBatchDownloadMsgRsp_body", "DiskFileDocDownloadAbsMsgRsp_body", "DiskDirFileBatchDeleteExMsgRsp_body", "DiskPicBackupRsp_body", "DiskAlbumStatusReportRsp_body", "PwdQueryMsgRsp_body", "PwdVerifyMsgRsp_body", "WeiyunShareAddFromMobileQQMsgRsp_body", "LibInfoListGetMsgRsp_body", "WeiyunTrialCouponUseMsgRsp_body", "CrossBidProxyCopyFileToOtherBidMsgRsp_body", "CrossBidProxyOfflineFileGetListMsgRsp_body", "QqSdkFileUploadMsgRsp_body", "AioPicAndVideoCopyToWeiyunMsgRsp_body"}, new Object[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null}, WeiyunPB$RspMsgBody.class);
    public WeiyunPB$LibInfoListGetMsgRsp LibInfoListGetMsgRsp_body = new WeiyunPB$LibInfoListGetMsgRsp();
    public WeiyunPB$DiskFileBatchDownloadMsgRsp DiskFileBatchDownloadMsgRsp_body = new WeiyunPB$DiskFileBatchDownloadMsgRsp();
    public WeiyunPB$DiskFileDocDownloadAbsMsgRsp DiskFileDocDownloadAbsMsgRsp_body = new WeiyunPB$DiskFileDocDownloadAbsMsgRsp();
    public WeiyunPB$DiskDirFileBatchDeleteExMsgRsp DiskDirFileBatchDeleteExMsgRsp_body = new MessageMicro<WeiyunPB$DiskDirFileBatchDeleteExMsgRsp>() { // from class: com.tencent.mobileqq.weiyun.pb.WeiyunPB$DiskDirFileBatchDeleteExMsgRsp
        public static final int DIR_LIST_FIELD_NUMBER = 3;
        public static final int FILE_LIST_FIELD_NUMBER = 4;
        public static final int FREED_INDEX_CNT_FIELD_NUMBER = 2;
        public static final int FREED_SPACE_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"freed_space", "freed_index_cnt", "dir_list", "file_list"}, new Object[]{0L, 0, null, null}, WeiyunPB$DiskDirFileBatchDeleteExMsgRsp.class);
        public final PBInt64Field freed_space = PBField.initInt64(0);
        public final PBUInt32Field freed_index_cnt = PBField.initUInt32(0);
        public final PBRepeatMessageField<WeiyunPB$DiskSimpleDirItemResult> dir_list = PBField.initRepeatMessage(WeiyunPB$DiskSimpleDirItemResult.class);
        public final PBRepeatMessageField<WeiyunPB$DiskSimpleFileItemResult> file_list = PBField.initRepeatMessage(WeiyunPB$DiskSimpleFileItemResult.class);
    };
    public WeiyunPB$DiskPicBackupRsp DiskPicBackupRsp_body = new WeiyunPB$DiskPicBackupRsp();
    public WeiyunPB$DiskAlbumStatusReportRsp DiskAlbumStatusReportRsp_body = new MessageMicro<WeiyunPB$DiskAlbumStatusReportRsp>() { // from class: com.tencent.mobileqq.weiyun.pb.WeiyunPB$DiskAlbumStatusReportRsp
        public static final int NEED_RED_TOUCH_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"need_red_touch"}, new Object[]{Boolean.FALSE}, WeiyunPB$DiskAlbumStatusReportRsp.class);
        public final PBBoolField need_red_touch = PBField.initBool(false);
    };
    public WeiyunPB$PwdQueryMsgRsp PwdQueryMsgRsp_body = new WeiyunPB$PwdQueryMsgRsp();
    public WeiyunPB$PwdVerifyMsgRsp PwdVerifyMsgRsp_body = new WeiyunPB$PwdVerifyMsgRsp();
    public WeiyunPB$CrossBidProxyCopyFileToOtherBidMsgRsp CrossBidProxyCopyFileToOtherBidMsgRsp_body = new WeiyunPB$CrossBidProxyCopyFileToOtherBidMsgRsp();
    public WeiyunPB$CrossBidProxyOfflineFileGetListMsgRsp CrossBidProxyOfflineFileGetListMsgRsp_body = new MessageMicro<WeiyunPB$CrossBidProxyOfflineFileGetListMsgRsp>() { // from class: com.tencent.mobileqq.weiyun.pb.WeiyunPB$CrossBidProxyOfflineFileGetListMsgRsp
        public static final int RPT_MSG_RECV_OFFLINE_FILE_FIELD_NUMBER = 1;
        public static final int RPT_MSG_SEND_OFFLINE_FILE_FIELD_NUMBER = 3;
        public static final int UINT32_RECV_FILE_TOTAL_FIELD_NUMBER = 2;
        public static final int UINT32_RECV_LIST_END_FIELD_NUMBER = 7;
        public static final int UINT32_SEND_FILE_TOTAL_FIELD_NUMBER = 4;
        public static final int UINT32_SEND_LIST_END_FIELD_NUMBER = 8;
        public static final int UINT64_TOT_LIMIT_FIELD_NUMBER = 5;
        public static final int UINT64_USED_LIMIT_FIELD_NUMBER = 6;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 48, 56, 64}, new String[]{"rpt_msg_recv_offline_file", "uint32_recv_file_total", "rpt_msg_send_offline_file", "uint32_send_file_total", "uint64_tot_limit", "uint64_used_limit", "uint32_recv_list_end", "uint32_send_list_end"}, new Object[]{null, 0, null, 0, 0L, 0L, 0, 0}, WeiyunPB$CrossBidProxyOfflineFileGetListMsgRsp.class);
        public final PBRepeatMessageField<WeiyunPB$OfflineFileInfo> rpt_msg_recv_offline_file = PBField.initRepeatMessage(WeiyunPB$OfflineFileInfo.class);
        public final PBUInt32Field uint32_recv_file_total = PBField.initUInt32(0);
        public final PBRepeatMessageField<WeiyunPB$OfflineFileInfo> rpt_msg_send_offline_file = PBField.initRepeatMessage(WeiyunPB$OfflineFileInfo.class);
        public final PBUInt32Field uint32_send_file_total = PBField.initUInt32(0);
        public final PBUInt64Field uint64_tot_limit = PBField.initUInt64(0);
        public final PBUInt64Field uint64_used_limit = PBField.initUInt64(0);
        public final PBUInt32Field uint32_recv_list_end = PBField.initUInt32(0);
        public final PBUInt32Field uint32_send_list_end = PBField.initUInt32(0);
    };
    public WeiyunPB$QqSdkFileUploadMsgRsp QqSdkFileUploadMsgRsp_body = new WeiyunPB$QqSdkFileUploadMsgRsp();
    public WeiyunPB$AioPicAndVideoCopyToWeiyunMsgRsp AioPicAndVideoCopyToWeiyunMsgRsp_body = new MessageMicro<WeiyunPB$AioPicAndVideoCopyToWeiyunMsgRsp>() { // from class: com.tencent.mobileqq.weiyun.pb.WeiyunPB$AioPicAndVideoCopyToWeiyunMsgRsp
        public static final int TASK_ID_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"task_id"}, new Object[]{""}, WeiyunPB$AioPicAndVideoCopyToWeiyunMsgRsp.class);
        public final PBStringField task_id = PBField.initString("");
    };
    public WeiyunPB$WeiyunTrialCouponUseMsgRsp WeiyunTrialCouponUseMsgRsp_body = new MessageMicro<WeiyunPB$WeiyunTrialCouponUseMsgRsp>() { // from class: com.tencent.mobileqq.weiyun.pb.WeiyunPB$WeiyunTrialCouponUseMsgRsp
        public static final int USER_STATICS_LEVEL_FIELD_NUMBER = 20;
        public static final int WEIYUN_VIP_FLAG_FIELD_NUMBER = 10;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 160}, new String[]{"weiyun_vip_flag", "user_statics_level"}, new Object[]{0, 0}, WeiyunPB$WeiyunTrialCouponUseMsgRsp.class);
        public final PBInt32Field weiyun_vip_flag = PBField.initInt32(0);
        public final PBInt32Field user_statics_level = PBField.initInt32(0);
    };
    public WeiyunPB$WeiyunShareAddFromMobileQQMsgRsp WeiyunShareAddFromMobileQQMsgRsp_body = new WeiyunPB$WeiyunShareAddFromMobileQQMsgRsp();
}
