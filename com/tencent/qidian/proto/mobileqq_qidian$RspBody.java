package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class mobileqq_qidian$RspBody extends MessageMicro<mobileqq_qidian$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 8066, 8074, 8082, 8090, 8098, 8146}, new String[]{"uint32_sub_cmd", "msg_crm_common_head", "msg_wpa_assign_kfext_rsp", "msg_wpa_sigt_to_sigmsg_rsp", "msg_click_reply_cmd_action_rsp", "msg_subcmd_get_user_detail_info_rsp_body", "msg_get_account_type_rsp", "msg_get_business_mobile_rsp", "msg_verify_wpa_uin_and_key_rsp", "msg_check_mpqq_refuse_flag_rsp", "msg_get_customer_transfer_info_rsp", "msg_not_recv_qd_group_msg_rsp", "msg_get_navigation_menu_config_rsp_body", "msg_req_corpuin_wpa_rsp", "msg_get_corpuin_detail_info_rsp_body", "msg_click_eman_rsp", "msg_close_session_rsp", "msg_qidian_wpa_addfriend_rsp", "msg_get_qidian_group_info_rsp"}, new Object[]{0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, mobileqq_qidian$RspBody.class);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public mobileqq_qidian$CRMMsgHead msg_crm_common_head = new mobileqq_qidian$CRMMsgHead();
    public mobileqq_qidian$WpaAssignKfextRspBody msg_wpa_assign_kfext_rsp = new mobileqq_qidian$WpaAssignKfextRspBody();
    public mobileqq_qidian$WpaSigtToSigMsgRspBody msg_wpa_sigt_to_sigmsg_rsp = new mobileqq_qidian$WpaSigtToSigMsgRspBody();
    public mobileqq_qidian$ClickReplyCmdActionRspBody msg_click_reply_cmd_action_rsp = new mobileqq_qidian$ClickReplyCmdActionRspBody();
    public mobileqq_qidian$GetUserDetailInfoRspBody msg_subcmd_get_user_detail_info_rsp_body = new mobileqq_qidian$GetUserDetailInfoRspBody();
    public mobileqq_qidian$GetAccountTypeRspBody msg_get_account_type_rsp = new MessageMicro<mobileqq_qidian$GetAccountTypeRspBody>() { // from class: com.tencent.qidian.proto.mobileqq_qidian$GetAccountTypeRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"int32_result", "uint64_kfext_uin"}, new Object[]{0, 0L}, mobileqq_qidian$GetAccountTypeRspBody.class);
        public final PBInt32Field int32_result = PBField.initInt32(0);
        public final PBUInt64Field uint64_kfext_uin = PBField.initUInt64(0);
    };
    public mobileqq_qidian$GetBusinessMobileRsp msg_get_business_mobile_rsp = new MessageMicro<mobileqq_qidian$GetBusinessMobileRsp>() { // from class: com.tencent.qidian.proto.mobileqq_qidian$GetBusinessMobileRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_ret", "str_mobile"}, new Object[]{null, ""}, mobileqq_qidian$GetBusinessMobileRsp.class);
        public mobileqq_qidian$RetInfo msg_ret = new mobileqq_qidian$RetInfo();
        public final PBStringField str_mobile = PBField.initString("");
    };
    public mobileqq_qidian$VerifyWpaUinAndKeyRsp msg_verify_wpa_uin_and_key_rsp = new mobileqq_qidian$VerifyWpaUinAndKeyRsp();
    public mobileqq_qidian$CheckMpqqRefuseFlagRsp msg_check_mpqq_refuse_flag_rsp = new mobileqq_qidian$CheckMpqqRefuseFlagRsp();
    public mobileqq_qidian$GetCustomerTransferInfoRspBody msg_get_customer_transfer_info_rsp = new mobileqq_qidian$GetCustomerTransferInfoRspBody();
    public mobileqq_qidian$NotRecvQdGroupMsgRsp msg_not_recv_qd_group_msg_rsp = new mobileqq_qidian$NotRecvQdGroupMsgRsp();
    public mobileqq_qidian$GetNavigationMenuConfigRspBody msg_get_navigation_menu_config_rsp_body = new mobileqq_qidian$GetNavigationMenuConfigRspBody();
    public mobileqq_qidian$ReqCorpUinWpaRsp msg_req_corpuin_wpa_rsp = new mobileqq_qidian$ReqCorpUinWpaRsp();
    public mobileqq_qidian$GetCorpUinDetailInfoRspBody msg_get_corpuin_detail_info_rsp_body = new mobileqq_qidian$GetCorpUinDetailInfoRspBody();
    public mobileqq_qidian$ClickEManRspBody msg_click_eman_rsp = new mobileqq_qidian$ClickEManRspBody();
    public mobileqq_qidian$CloseSessionRspBody msg_close_session_rsp = new mobileqq_qidian$CloseSessionRspBody();
    public mobileqq_qidian$QidianWpaAddFriendRspBody msg_qidian_wpa_addfriend_rsp = new MessageMicro<mobileqq_qidian$QidianWpaAddFriendRspBody>() { // from class: com.tencent.qidian.proto.mobileqq_qidian$QidianWpaAddFriendRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_ret"}, new Object[]{null}, mobileqq_qidian$QidianWpaAddFriendRspBody.class);
        public mobileqq_qidian$RetInfo msg_ret = new mobileqq_qidian$RetInfo();
    };
    public mobileqq_qidian$GetQiDianGroupInfoRsp msg_get_qidian_group_info_rsp = new mobileqq_qidian$GetQiDianGroupInfoRsp();
}
