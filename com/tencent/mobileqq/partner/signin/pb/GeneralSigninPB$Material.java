package com.tencent.mobileqq.partner.signin.pb;

import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class GeneralSigninPB$Material extends MessageMicro<GeneralSigninPB$Material> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82}, new String[]{"background_image_url", QZoneAdTianshuFeedData.KEY_BUTTON_TEXT, "background_text", "theme_color", "label_text", "animation_url", "calendar_url", "signin_button", "remind_button", "share_button"}, new Object[]{"", "", "", "", "", "", "", null, null, null}, GeneralSigninPB$Material.class);
    public final PBStringField background_image_url = PBField.initString("");
    public final PBStringField button_text = PBField.initString("");
    public final PBStringField background_text = PBField.initString("");
    public final PBStringField theme_color = PBField.initString("");
    public final PBStringField label_text = PBField.initString("");
    public final PBStringField animation_url = PBField.initString("");
    public final PBStringField calendar_url = PBField.initString("");
    public GeneralSigninPB$Button signin_button = new GeneralSigninPB$Button();
    public GeneralSigninPB$Button remind_button = new GeneralSigninPB$Button();
    public GeneralSigninPB$Button share_button = new GeneralSigninPB$Button();
}
