package com.tencent.mobileqq.pb;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class oidb_0xeb2 {
    public static final int ALL_PHONE = 0;
    public static final int AUTH_PHONE = 11;
    public static final int AUX_PHONE = 2;
    public static final int CFT_PHONE = 4;
    public static final int COMM_PHONE = 5;
    public static final int CONTACTS_PHONE = 3;
    public static final int MIBAO_PHONE = 1;
    public static final int PHONE_QQ_SETTING_PHONE = 1;
    public static final int PRECISION_PHONE = 7;
    public static final int PRE_MIBAO_PHONE = 12;
    public static final int PUB_NO_PHONE = 6;
    public static final int REG_PHONE = 10;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class ReqBody extends MessageMicro<ReqBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42}, new String[]{"enum_butype", "bytes_sig", "uint32_source", "uint32_country", "str_phone"}, new Object[]{0, ByteStringMicro.EMPTY, 0, 0, ""}, ReqBody.class);
        public final PBEnumField enum_butype = PBField.initEnum(0);
        public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_source = PBField.initUInt32(0);
        public final PBUInt32Field uint32_country = PBField.initUInt32(0);
        public final PBStringField str_phone = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class RspBody extends MessageMicro<RspBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 50, 58}, new String[]{"uint32_uin_num", "msg_uin_info", "bool_reach_limit", "uint32_seq", "str_unbind_url", "str_title", "str_subtitle"}, new Object[]{0, null, Boolean.FALSE, 0, "", "", ""}, RspBody.class);
        public final PBUInt32Field uint32_uin_num = PBField.initUInt32(0);
        public final PBRepeatMessageField<UinInfo> msg_uin_info = PBField.initRepeatMessage(UinInfo.class);
        public final PBBoolField bool_reach_limit = PBField.initBool(false);
        public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
        public final PBStringField str_unbind_url = PBField.initString("");
        public final PBStringField str_title = PBField.initString("");
        public final PBStringField str_subtitle = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class UinInfo extends MessageMicro<UinInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40}, new String[]{"str_mask_uin", "str_nick", "str_image_url", "bytes_encrypt_uin", "uint32_aux_phone_flag"}, new Object[]{"", "", "", ByteStringMicro.EMPTY, 0}, UinInfo.class);
        public final PBStringField str_mask_uin = PBField.initString("");
        public final PBStringField str_nick = PBField.initString("");
        public final PBStringField str_image_url = PBField.initString("");
        public final PBBytesField bytes_encrypt_uin = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_aux_phone_flag = PBField.initUInt32(0);
    }

    oidb_0xeb2() {
    }
}
