package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class EmosmPb$BqAssocInfo extends MessageMicro<EmosmPb$BqAssocInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 50, 58, 66, 74, 82, 88, 98, 106, 114}, new String[]{"u32_tab_id", "str_tab_name", "u32_tab_feetype", "i32_tab_type", "i32_tab_ringtype", "str_item_id", "str_item_name", "str_item_key", "rpt_str_item_keyword", "rpt_support_size", "uint32_emoji_type", "rpt_apng_support_size", "str_ipsite_url", "str_ipsite_name"}, new Object[]{0, "", 0, 0, 0, "", "", "", "", null, 0, null, "", ""}, EmosmPb$BqAssocInfo.class);
    public final PBUInt32Field u32_tab_id = PBField.initUInt32(0);
    public final PBStringField str_tab_name = PBField.initString("");
    public final PBUInt32Field u32_tab_feetype = PBField.initUInt32(0);
    public final PBInt32Field i32_tab_type = PBField.initInt32(0);
    public final PBInt32Field i32_tab_ringtype = PBField.initInt32(0);
    public final PBStringField str_item_id = PBField.initString("");
    public final PBStringField str_item_name = PBField.initString("");
    public final PBStringField str_item_key = PBField.initString("");
    public final PBRepeatField<String> rpt_str_item_keyword = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatMessageField<EmosmPb$SupportSize> rpt_support_size = PBField.initRepeatMessage(EmosmPb$SupportSize.class);
    public final PBUInt32Field uint32_emoji_type = PBField.initUInt32(0);
    public final PBRepeatMessageField<EmosmPb$SupportSize> rpt_apng_support_size = PBField.initRepeatMessage(EmosmPb$SupportSize.class);
    public final PBStringField str_ipsite_url = PBField.initString("");
    public final PBStringField str_ipsite_name = PBField.initString("");
}
