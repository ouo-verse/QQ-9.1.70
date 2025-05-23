package com.tencent.im.oidb.cmd0x6d1;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class cmd0x6d1$ReqBody extends MessageMicro<cmd0x6d1$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"invite_req_body", "uninvite_req_body", "deal_invite_req_body"}, new Object[]{null, null, null}, cmd0x6d1$ReqBody.class);
    public cmd0x6d1$InviteReqBody invite_req_body = new MessageMicro<cmd0x6d1$InviteReqBody>() { // from class: com.tencent.im.oidb.cmd0x6d1.cmd0x6d1$InviteReqBody
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_group_name;
        public final PBBytesField bytes_uin_nick;
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        public final PBRepeatField<Long> rpt_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        public final PBUInt32Field uint32_first_flag = PBField.initUInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42}, new String[]{"uint64_group_code", "rpt_uin_list", "uint32_first_flag", "bytes_uin_nick", "bytes_group_name"}, new Object[]{0L, 0L, 0, byteStringMicro, byteStringMicro}, cmd0x6d1$InviteReqBody.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_uin_nick = PBField.initBytes(byteStringMicro);
            this.bytes_group_name = PBField.initBytes(byteStringMicro);
        }
    };
    public cmd0x6d1$UninviteReqBody uninvite_req_body = new MessageMicro<cmd0x6d1$UninviteReqBody>() { // from class: com.tencent.im.oidb.cmd0x6d1.cmd0x6d1$UninviteReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint64_group_code", "uint64_uin", "str_id"}, new Object[]{0L, 0L, ""}, cmd0x6d1$UninviteReqBody.class);
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBStringField str_id = PBField.initString("");
    };
    public cmd0x6d1$DealInviteReqBody deal_invite_req_body = new cmd0x6d1$DealInviteReqBody();
    public final PBUInt32Field uint32_app_type = PBField.initUInt32(0);
}
