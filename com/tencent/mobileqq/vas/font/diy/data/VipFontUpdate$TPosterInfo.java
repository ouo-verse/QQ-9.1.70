package com.tencent.mobileqq.vas.font.diy.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes20.dex */
public final class VipFontUpdate$TPosterInfo extends MessageMicro<VipFontUpdate$TPosterInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"i32_font_id", "str_img_url", "str_tag_url"}, new Object[]{0, "", ""}, VipFontUpdate$TPosterInfo.class);
    public final PBInt32Field i32_font_id = PBField.initInt32(0);
    public final PBStringField str_img_url = PBField.initString("");
    public final PBStringField str_tag_url = PBField.initString("");
}
