package com.tencent.mobileqq.partner.signin.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class GeneralSigninPB$Button extends MessageMicro<GeneralSigninPB$Button> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 26, 34, 42, 50, 58, 66}, new String[]{"text", "img_url", "color", "color_after_click", "color2", "color_after_click2", "text_after_click"}, new Object[]{"", "", "", "", "", "", ""}, GeneralSigninPB$Button.class);
    public final PBStringField text = PBField.initString("");
    public final PBStringField img_url = PBField.initString("");
    public final PBStringField color = PBField.initString("");
    public final PBStringField color_after_click = PBField.initString("");
    public final PBStringField color2 = PBField.initString("");
    public final PBStringField color_after_click2 = PBField.initString("");
    public final PBStringField text_after_click = PBField.initString("");
}
