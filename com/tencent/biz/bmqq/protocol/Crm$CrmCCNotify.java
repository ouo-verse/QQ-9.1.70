package com.tencent.biz.bmqq.protocol;

import com.tencent.luggage.wxa.rf.f;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class Crm$CrmCCNotify extends MessageMicro<Crm$CrmCCNotify> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48, 58, 66, 72, 82, 90, 98, 106, 112, 122, 130, 138, 226, 338, f.CTRL_INDEX}, new String[]{"crm_flag", "crm_alloc_kfext", "str_wx_openid", "bytes_video_uuid", "crm_user_type", "uint64_real_uin", "str_client_headurl", "str_client_nickname", "uint64_pubacc_id", "str_publicacc_name", "light_talk_msg", "msg_linktext_withOepenAIO", "msg_c2c_action_report", "uint32_IsTipsMode", "svr_cc_msg_flag", "qidian_group_msg", "str_visitId", "msg_gray_msg", "str_check_id", "str_ext_nick_name"}, new Object[]{0, null, "", ByteStringMicro.EMPTY, 0, 0L, "", "", 0L, "", null, null, null, 0, null, null, "", null, "", ""}, Crm$CrmCCNotify.class);
    public final PBUInt32Field crm_flag = PBField.initUInt32(0);
    public Crm$CrmAllocKfext crm_alloc_kfext = new MessageMicro<Crm$CrmAllocKfext>() { // from class: com.tencent.biz.bmqq.protocol.Crm$CrmAllocKfext
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 48, 58}, new String[]{"int32_flag", "crm_msg_flag", "crm_msg", "uint64_alloc_from_uin", "uint64_alloc_to_uin", "uint32_track_right", "str_add_tips"}, new Object[]{0, 0, ByteStringMicro.EMPTY, 0L, 0L, 0, ""}, Crm$CrmAllocKfext.class);
        public final PBInt32Field int32_flag = PBField.initInt32(0);
        public final PBUInt32Field crm_msg_flag = PBField.initUInt32(0);
        public final PBBytesField crm_msg = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt64Field uint64_alloc_from_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_alloc_to_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_track_right = PBField.initUInt32(0);
        public final PBStringField str_add_tips = PBField.initString("");
    };
    public final PBStringField str_wx_openid = PBField.initString("");
    public final PBBytesField bytes_video_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field crm_user_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_real_uin = PBField.initUInt64(0);
    public final PBStringField str_client_headurl = PBField.initString("");
    public final PBStringField str_client_nickname = PBField.initString("");
    public final PBUInt64Field uint64_pubacc_id = PBField.initUInt64(0);
    public final PBStringField str_publicacc_name = PBField.initString("");
    public Crm$LightTalkMsg light_talk_msg = new MessageMicro<Crm$LightTalkMsg>() { // from class: com.tencent.biz.bmqq.protocol.Crm$LightTalkMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 48, 56, 64, 72, 82, 90, 96}, new String[]{"bytes_cuin", "uint64_virtual_uin", "str_mobile_number", "uint32_model_type", "uint32_call_type", "uint32_call_result", "uint64_start_timestap", "uint64_end_timestap", "uint64_duration", "str_client_headurl", "str_client_nickname", "uint32_mobile_source"}, new Object[]{ByteStringMicro.EMPTY, 0L, "", 0, 0, 0, 0L, 0L, 0L, "", "", 0}, Crm$LightTalkMsg.class);
        public final PBBytesField bytes_cuin = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt64Field uint64_virtual_uin = PBField.initUInt64(0);
        public final PBStringField str_mobile_number = PBField.initString("");
        public final PBUInt32Field uint32_model_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_call_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_call_result = PBField.initUInt32(0);
        public final PBUInt64Field uint64_start_timestap = PBField.initUInt64(0);
        public final PBUInt64Field uint64_end_timestap = PBField.initUInt64(0);
        public final PBUInt64Field uint64_duration = PBField.initUInt64(0);
        public final PBStringField str_client_headurl = PBField.initString("");
        public final PBStringField str_client_nickname = PBField.initString("");
        public final PBUInt32Field uint32_mobile_source = PBField.initUInt32(0);
    };
    public Crm$LinkTextWithOpenAIOAction msg_linktext_withOepenAIO = new MessageMicro<Crm$LinkTextWithOpenAIOAction>() { // from class: com.tencent.biz.bmqq.protocol.Crm$LinkTextWithOpenAIOAction
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint64_uin", "str_link_text", "str_attach_content"}, new Object[]{0L, "", ""}, Crm$LinkTextWithOpenAIOAction.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBStringField str_link_text = PBField.initString("");
        public final PBStringField str_attach_content = PBField.initString("");
    };
    public Crm$C2CActionReport msg_c2c_action_report = new MessageMicro<Crm$C2CActionReport>() { // from class: com.tencent.biz.bmqq.protocol.Crm$C2CActionReport
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"str_action_content"}, new Object[]{""}, Crm$C2CActionReport.class);
        public final PBStringField str_action_content = PBField.initString("");
    };
    public final PBUInt32Field uint32_IsTipsMode = PBField.initUInt32(0);
    public Crm$SvrCCMsgFlag svr_cc_msg_flag = new MessageMicro<Crm$SvrCCMsgFlag>() { // from class: com.tencent.biz.bmqq.protocol.Crm$SvrCCMsgFlag
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_type", "str_text_msg"}, new Object[]{0, ""}, Crm$SvrCCMsgFlag.class);
        public final PBUInt32Field uint32_type = PBField.initUInt32(0);
        public final PBStringField str_text_msg = PBField.initString("");
    };
    public Crm$QidianGroupMsg qidian_group_msg = new Crm$QidianGroupMsg();
    public final PBStringField str_visitId = PBField.initString("");
    public Crm$GrayMsg msg_gray_msg = new Crm$GrayMsg();
    public final PBStringField str_check_id = PBField.initString("");
    public final PBStringField str_ext_nick_name = PBField.initString("");
}
