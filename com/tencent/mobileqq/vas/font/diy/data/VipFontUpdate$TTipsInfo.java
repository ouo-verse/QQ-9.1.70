package com.tencent.mobileqq.vas.font.diy.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class VipFontUpdate$TTipsInfo extends MessageMicro<VipFontUpdate$TTipsInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66}, new String[]{"i32_type", "str_msg", "str_title", "str_button", "str_url", "str_vip_type", "str_month", "str_aid"}, new Object[]{0, "", "", "", "", "", "", ""}, VipFontUpdate$TTipsInfo.class);
    public final PBInt32Field i32_type = PBField.initInt32(0);
    public final PBStringField str_msg = PBField.initString("");
    public final PBStringField str_title = PBField.initString("");
    public final PBStringField str_button = PBField.initString("");
    public final PBStringField str_url = PBField.initString("");
    public final PBStringField str_vip_type = PBField.initString("");
    public final PBStringField str_month = PBField.initString("");
    public final PBStringField str_aid = PBField.initString("");
}
