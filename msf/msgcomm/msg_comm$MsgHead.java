package msf.msgcomm;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import tencent.im.msg.im_msg_head$InstCtrl;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class msg_comm$MsgHead extends MessageMicro<msg_comm$MsgHead> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 66, 74, 80, 88, 96, 106, 114, 120, 130, 136, 146, 154, 162, 170, 176, 184, 192, 202, 210, 216, 224}, new String[]{ShortVideoConstants.FROM_UIN, "to_uin", QQHealthReportApiImpl.MSG_TYPE_KEY, "c2c_cmd", "msg_seq", ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME, "msg_uid", "c2c_tmp_msg_head", "group_info", "from_appid", "from_instid", "user_active", "discuss_info", "from_nick", "auth_uin", "auth_nick", "msg_flag", "auth_remark", "group_name", "mutiltrans_head", "msg_inst_ctrl", "public_account_group_send_flag", "wseq_in_c2c_msghead", "cpid", "ext_group_key_info", "multi_compatible_text", "auth_sex", "is_src_msg"}, new Object[]{0L, 0L, 0, 0, 0, 0, 0L, null, null, 0, 0, 0, null, "", 0L, "", 0, "", "", null, null, 0, 0, 0L, null, "", 0, Boolean.FALSE}, msg_comm$MsgHead.class);
    public final PBUInt64Field from_uin = PBField.initUInt64(0);
    public final PBUInt64Field to_uin = PBField.initUInt64(0);
    public final PBUInt32Field msg_type = PBField.initUInt32(0);
    public final PBUInt32Field c2c_cmd = PBField.initUInt32(0);
    public final PBUInt32Field msg_seq = PBField.initUInt32(0);
    public final PBUInt32Field msg_time = PBField.initUInt32(0);
    public final PBUInt64Field msg_uid = PBField.initUInt64(0);
    public msg_comm$C2CTmpMsgHead c2c_tmp_msg_head = new msg_comm$C2CTmpMsgHead();
    public msg_comm$GroupInfo group_info = new msg_comm$GroupInfo();
    public final PBUInt32Field from_appid = PBField.initUInt32(0);
    public final PBUInt32Field from_instid = PBField.initUInt32(0);
    public final PBUInt32Field user_active = PBField.initUInt32(0);
    public msg_comm$DiscussInfo discuss_info = new msg_comm$DiscussInfo();
    public final PBStringField from_nick = PBField.initString("");
    public final PBUInt64Field auth_uin = PBField.initUInt64(0);
    public final PBStringField auth_nick = PBField.initString("");
    public final PBUInt32Field msg_flag = PBField.initUInt32(0);
    public final PBStringField auth_remark = PBField.initString("");
    public final PBStringField group_name = PBField.initString("");
    public msg_comm$MutilTransHead mutiltrans_head = new msg_comm$MutilTransHead();
    public im_msg_head$InstCtrl msg_inst_ctrl = new im_msg_head$InstCtrl();
    public final PBUInt32Field public_account_group_send_flag = PBField.initUInt32(0);
    public final PBUInt32Field wseq_in_c2c_msghead = PBField.initUInt32(0);
    public final PBUInt64Field cpid = PBField.initUInt64(0);
    public msg_comm$ExtGroupKeyInfo ext_group_key_info = new MessageMicro<msg_comm$ExtGroupKeyInfo>() { // from class: msf.msgcomm.msg_comm$ExtGroupKeyInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"cur_max_seq", "cur_time", "operate_by_parents", "bytes_ext_group_info"}, new Object[]{0, 0L, 0, ByteStringMicro.EMPTY}, msg_comm$ExtGroupKeyInfo.class);
        public final PBUInt32Field cur_max_seq = PBField.initUInt32(0);
        public final PBUInt64Field cur_time = PBField.initUInt64(0);
        public final PBUInt32Field operate_by_parents = PBField.initUInt32(0);
        public final PBBytesField bytes_ext_group_info = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public final PBStringField multi_compatible_text = PBField.initString("");
    public final PBUInt32Field auth_sex = PBField.initUInt32(0);
    public final PBBoolField is_src_msg = PBField.initBool(false);
}
