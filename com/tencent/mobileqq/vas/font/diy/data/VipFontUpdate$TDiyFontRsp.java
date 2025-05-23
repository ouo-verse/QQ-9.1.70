package com.tencent.mobileqq.vas.font.diy.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class VipFontUpdate$TDiyFontRsp extends MessageMicro<VipFontUpdate$TDiyFontRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_font_rsp_info"}, new Object[]{null}, VipFontUpdate$TDiyFontRsp.class);
    public final PBRepeatMessageField<TDiyFontRspInfo> rpt_font_rsp_info = PBField.initRepeatMessage(TDiyFontRspInfo.class);

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class TDiyFontRspInfo extends MessageMicro<TDiyFontRspInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"u64_uin", "i32_font_id", "u32_diy_font_timestamp", "str_diy_font_config"}, new Object[]{0L, 0, 0, ""}, TDiyFontRspInfo.class);
        public final PBUInt64Field u64_uin = PBField.initUInt64(0);
        public final PBInt32Field i32_font_id = PBField.initInt32(0);
        public final PBUInt32Field u32_diy_font_timestamp = PBField.initUInt32(0);
        public final PBStringField str_diy_font_config = PBField.initString("");
    }
}
