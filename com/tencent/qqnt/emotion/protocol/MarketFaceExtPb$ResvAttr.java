package com.tencent.qqnt.emotion.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes24.dex */
public final class MarketFaceExtPb$ResvAttr extends MessageMicro<MarketFaceExtPb$ResvAttr> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 48, 56, 64, 74, 80, 88, 98, 106}, new String[]{"rpt_support_size", "uint32_source_type", "str_source_name", "str_source_jump_url", "str_source_type_name", "uint32_start_time", "uint32_end_time", "uint32_emoji_type", "rpt_apng_support_size", "uint32_has_ip_product", "uint32_voice_item_height_arr", "str_back_color", "str_volume_color"}, new Object[]{null, 0, "", "", "", 0, 0, 0, null, 0, 0, "", ""}, MarketFaceExtPb$ResvAttr.class);
    public final PBRepeatMessageField<MarketFaceExtPb$SupportSize> rpt_support_size = PBField.initRepeatMessage(MarketFaceExtPb$SupportSize.class);
    public final PBUInt32Field uint32_source_type = PBField.initUInt32(0);
    public final PBStringField str_source_name = PBField.initString("");
    public final PBStringField str_source_jump_url = PBField.initString("");
    public final PBStringField str_source_type_name = PBField.initString("");
    public final PBUInt32Field uint32_start_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_end_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_emoji_type = PBField.initUInt32(0);
    public final PBRepeatMessageField<MarketFaceExtPb$SupportSize> rpt_apng_support_size = PBField.initRepeatMessage(MarketFaceExtPb$SupportSize.class);
    public final PBUInt32Field uint32_has_ip_product = PBField.initUInt32(0);
    public final PBRepeatField<Integer> uint32_voice_item_height_arr = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBStringField str_back_color = PBField.initString("");
    public final PBStringField str_volume_color = PBField.initString("");
}
