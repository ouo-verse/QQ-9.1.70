package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class mobileqq_qidian$ReqBody extends MessageMicro<mobileqq_qidian$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 8066, 8074, 8082, 8090, 8098, 8146}, new String[]{"uint32_sub_cmd", "msg_crm_common_head", "msg_wpa_assign_kfext_req", "msg_wpa_sigt_to_sigmsg_req", "msg_click_reply_cmd_action_req", "msg_get_user_detail_info_req", "msg_get_account_type_req", "msg_get_business_mobile_req", "msg_verify_wpa_uin_and_key_req", "msg_check_mpqq_refuse_flag_req", "msg_get_customer_transfer_info_req", "msg_not_recv_qd_group_msg_req", "msg_get_navigation_menu_config_req_body", "msg_req_corpuin_wpa_req", "msg_get_corpuin_detail_info_req_body", "msg_click_eman_req", "msg_close_session_req", "msg_qidian_wpa_addfriend_req", "msg_get_qidian_group_info_req"}, new Object[]{0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, mobileqq_qidian$ReqBody.class);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public mobileqq_qidian$CRMMsgHead msg_crm_common_head = new mobileqq_qidian$CRMMsgHead();
    public mobileqq_qidian$WpaAssignKfextReqBody msg_wpa_assign_kfext_req = new mobileqq_qidian$WpaAssignKfextReqBody();
    public mobileqq_qidian$WpaSigtToSigMsgReqBody msg_wpa_sigt_to_sigmsg_req = new mobileqq_qidian$WpaSigtToSigMsgReqBody();
    public mobileqq_qidian$ClickReplyCmdActionReqBody msg_click_reply_cmd_action_req = new mobileqq_qidian$ClickReplyCmdActionReqBody();
    public mobileqq_qidian$GetUserDetailInfoReqBody msg_get_user_detail_info_req = new mobileqq_qidian$GetUserDetailInfoReqBody();
    public mobileqq_qidian$GetAccountTypeReqBody msg_get_account_type_req = new MessageMicro<mobileqq_qidian$GetAccountTypeReqBody>() { // from class: com.tencent.qidian.proto.mobileqq_qidian$GetAccountTypeReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_kfext_uin"}, new Object[]{0L}, mobileqq_qidian$GetAccountTypeReqBody.class);
        public final PBUInt64Field uint64_kfext_uin = PBField.initUInt64(0);
    };
    public mobileqq_qidian$GetBusinessMobileReq msg_get_business_mobile_req = new MessageMicro<mobileqq_qidian$GetBusinessMobileReq>() { // from class: com.tencent.qidian.proto.mobileqq_qidian$GetBusinessMobileReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_cqquin", "uint64_extuin"}, new Object[]{0L, 0L}, mobileqq_qidian$GetBusinessMobileReq.class);
        public final PBUInt64Field uint64_cqquin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_extuin = PBField.initUInt64(0);
    };
    public mobileqq_qidian$VerifyWpaUinAndKeyReq msg_verify_wpa_uin_and_key_req = new MessageMicro<mobileqq_qidian$VerifyWpaUinAndKeyReq>() { // from class: com.tencent.qidian.proto.mobileqq_qidian$VerifyWpaUinAndKeyReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48}, new String[]{"uint64_dst_uin", "str_key", "str_json_info", "str_rkey", "uint32_terminal_type", "uint32_terminal_version"}, new Object[]{0L, "", "", "", 0, 0}, mobileqq_qidian$VerifyWpaUinAndKeyReq.class);
        public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0);
        public final PBStringField str_key = PBField.initString("");
        public final PBStringField str_json_info = PBField.initString("");
        public final PBStringField str_rkey = PBField.initString("");
        public final PBUInt32Field uint32_terminal_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_terminal_version = PBField.initUInt32(0);
    };
    public mobileqq_qidian$CheckMpqqRefuseFlagReq msg_check_mpqq_refuse_flag_req = new MessageMicro<mobileqq_qidian$CheckMpqqRefuseFlagReq>() { // from class: com.tencent.qidian.proto.mobileqq_qidian$CheckMpqqRefuseFlagReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_mpqq_uin", "uint64_qq_uin"}, new Object[]{0L, 0L}, mobileqq_qidian$CheckMpqqRefuseFlagReq.class);
        public final PBUInt64Field uint64_mpqq_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_qq_uin = PBField.initUInt64(0);
    };
    public mobileqq_qidian$GetCustomerTransferInfoReqBody msg_get_customer_transfer_info_req = new mobileqq_qidian$GetCustomerTransferInfoReqBody();
    public mobileqq_qidian$NotRecvQdGroupMsgReq msg_not_recv_qd_group_msg_req = new MessageMicro<mobileqq_qidian$NotRecvQdGroupMsgReq>() { // from class: com.tencent.qidian.proto.mobileqq_qidian$NotRecvQdGroupMsgReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_extuin", "uint64_kfuin", "uint64_taskid"}, new Object[]{0L, 0L, 0L}, mobileqq_qidian$NotRecvQdGroupMsgReq.class);
        public final PBUInt64Field uint64_extuin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_kfuin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_taskid = PBField.initUInt64(0);
    };
    public mobileqq_qidian$GetNavigationMenuConfigReqBody msg_get_navigation_menu_config_req_body = new mobileqq_qidian$GetNavigationMenuConfigReqBody();
    public mobileqq_qidian$ReqCorpUinWpaReq msg_req_corpuin_wpa_req = new mobileqq_qidian$ReqCorpUinWpaReq();
    public mobileqq_qidian$GetCorpUinDetailInfoReqBody msg_get_corpuin_detail_info_req_body = new mobileqq_qidian$GetCorpUinDetailInfoReqBody();
    public mobileqq_qidian$ClickEManReqBody msg_click_eman_req = new mobileqq_qidian$ClickEManReqBody();
    public mobileqq_qidian$CloseSessionReqBody msg_close_session_req = new MessageMicro<mobileqq_qidian$CloseSessionReqBody>() { // from class: com.tencent.qidian.proto.mobileqq_qidian$CloseSessionReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"msg_corp_report_info", "msg_ext_report_info", "uint32_close_session_time", "uint64_cqq_uin"}, new Object[]{null, null, 0, 0L}, mobileqq_qidian$CloseSessionReqBody.class);
        public mobileqq_qidian$CorpReportInfo msg_corp_report_info = new MessageMicro<mobileqq_qidian$CorpReportInfo>() { // from class: com.tencent.qidian.proto.mobileqq_qidian$CorpReportInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_kfuin", "uint64_kfaccount"}, new Object[]{0L, 0L}, mobileqq_qidian$CorpReportInfo.class);
            public final PBUInt64Field uint64_kfuin = PBField.initUInt64(0);
            public final PBUInt64Field uint64_kfaccount = PBField.initUInt64(0);
        };
        public mobileqq_qidian$ExtReportInfo msg_ext_report_info = new MessageMicro<mobileqq_qidian$ExtReportInfo>() { // from class: com.tencent.qidian.proto.mobileqq_qidian$ExtReportInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_ext_uin"}, new Object[]{0L}, mobileqq_qidian$ExtReportInfo.class);
            public final PBUInt64Field uint64_ext_uin = PBField.initUInt64(0);
        };
        public final PBUInt32Field uint32_close_session_time = PBField.initUInt32(0);
        public final PBUInt64Field uint64_cqq_uin = PBField.initUInt64(0);
    };
    public mobileqq_qidian$QidianWpaAddFriendReqBody msg_qidian_wpa_addfriend_req = new mobileqq_qidian$QidianWpaAddFriendReqBody();
    public mobileqq_qidian$GetQiDianGroupInfoReq msg_get_qidian_group_info_req = new mobileqq_qidian$GetQiDianGroupInfoReq();
}
