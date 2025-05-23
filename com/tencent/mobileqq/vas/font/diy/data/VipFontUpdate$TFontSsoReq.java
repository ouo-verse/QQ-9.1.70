package com.tencent.mobileqq.vas.font.diy.data;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class VipFontUpdate$TFontSsoReq extends MessageMicro<VipFontUpdate$TFontSsoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 58, 66, 74, 82, 90, 98}, new String[]{"u32_cmd", "u64_seq", "i32_implat", "str_osver", "str_mqqver", "st_fresh_req", "st_md5_check_req", "st_poster_req", "st_check_req", "st_diyfont_req", "st_getposterfont_req", "st_setposterfont_req"}, new Object[]{0, 0L, 0, "", "", null, null, null, null, null, null, null}, VipFontUpdate$TFontSsoReq.class);
    public final PBUInt32Field u32_cmd = PBField.initUInt32(0);
    public final PBUInt64Field u64_seq = PBField.initUInt64(0);
    public final PBInt32Field i32_implat = PBField.initInt32(0);
    public final PBStringField str_osver = PBField.initString("");
    public final PBStringField str_mqqver = PBField.initString("");
    public VipFontUpdate$TFontFreshReq st_fresh_req = new MessageMicro<VipFontUpdate$TFontFreshReq>() { // from class: com.tencent.mobileqq.vas.font.diy.data.VipFontUpdate$TFontFreshReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 56, 64}, new String[]{"i32_local_font_id", "i32_cpu_freq", "i32_cpu_num", "i32_total_mem", "str_brand", "str_model", "i32_os_type", "i32_version"}, new Object[]{0, 0, 0, 0, "", "", 0, 0}, VipFontUpdate$TFontFreshReq.class);
        public final PBInt32Field i32_local_font_id = PBField.initInt32(0);
        public final PBInt32Field i32_cpu_freq = PBField.initInt32(0);
        public final PBInt32Field i32_cpu_num = PBField.initInt32(0);
        public final PBInt32Field i32_total_mem = PBField.initInt32(0);
        public final PBStringField str_brand = PBField.initString("");
        public final PBStringField str_model = PBField.initString("");
        public final PBInt32Field i32_os_type = PBField.initInt32(0);
        public final PBInt32Field i32_version = PBField.initInt32(0);
    };
    public VipFontUpdate$TFontMd5CheckReq st_md5_check_req = new MessageMicro<VipFontUpdate$TFontMd5CheckReq>() { // from class: com.tencent.mobileqq.vas.font.diy.data.VipFontUpdate$TFontMd5CheckReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_md5_info"}, new Object[]{null}, VipFontUpdate$TFontMd5CheckReq.class);
        public final PBRepeatMessageField<TMd5Info> rpt_md5_info = PBField.initRepeatMessage(TMd5Info.class);

        /* compiled from: P */
        /* loaded from: classes20.dex */
        public static final class TMd5Info extends MessageMicro<TMd5Info> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"i32_font_id", "bytes_md5"}, new Object[]{0, ByteStringMicro.EMPTY}, TMd5Info.class);
            public final PBInt32Field i32_font_id = PBField.initInt32(0);
            public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
        }
    };
    public VipFontUpdate$TPosterReq st_poster_req = new MessageMicro<VipFontUpdate$TPosterReq>() { // from class: com.tencent.mobileqq.vas.font.diy.data.VipFontUpdate$TPosterReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"i32_valid"}, new Object[]{0}, VipFontUpdate$TPosterReq.class);
        public final PBInt32Field i32_valid = PBField.initInt32(0);
    };
    public VipFontUpdate$TCheckReq st_check_req = new MessageMicro<VipFontUpdate$TCheckReq>() { // from class: com.tencent.mobileqq.vas.font.diy.data.VipFontUpdate$TCheckReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"i32_type", "i32_font_id", "str_message_test"}, new Object[]{0, 0, ""}, VipFontUpdate$TCheckReq.class);
        public final PBInt32Field i32_type = PBField.initInt32(0);
        public final PBInt32Field i32_font_id = PBField.initInt32(0);
        public final PBStringField str_message_test = PBField.initString("");
    };
    public VipFontUpdate$TDiyFontReq st_diyfont_req = new VipFontUpdate$TDiyFontReq();
    public VipFontUpdate$TGetPosterFontReq st_getposterfont_req = new MessageMicro<VipFontUpdate$TGetPosterFontReq>() { // from class: com.tencent.mobileqq.vas.font.diy.data.VipFontUpdate$TGetPosterFontReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"isgetrecommend"}, new Object[]{0}, VipFontUpdate$TGetPosterFontReq.class);
        public final PBInt32Field isgetrecommend = PBField.initInt32(0);
    };
    public VipFontUpdate$TSetPosterFontReq st_setposterfont_req = new MessageMicro<VipFontUpdate$TSetPosterFontReq>() { // from class: com.tencent.mobileqq.vas.font.diy.data.VipFontUpdate$TSetPosterFontReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"i32_font_id"}, new Object[]{0}, VipFontUpdate$TSetPosterFontReq.class);
        public final PBInt32Field i32_font_id = PBField.initInt32(0);
    };
}
