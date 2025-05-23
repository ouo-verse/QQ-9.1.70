package com.tencent.pb.profilecard;

import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class VaProfileGate$GetClmTipRsp extends MessageMicro<VaProfileGate$GetClmTipRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82}, new String[]{"pic_icon", "content_text", "content_text_color", QZoneAdTianshuFeedData.KEY_BUTTON_TEXT, "button_text_color", "button_bg", "pic_bg", "url", "clm_param", "pic_bg_diy"}, new Object[]{"", "", "", "", "", "", "", "", "", ""}, VaProfileGate$GetClmTipRsp.class);
    public final PBStringField pic_icon = PBField.initString("");
    public final PBStringField content_text = PBField.initString("");
    public final PBStringField content_text_color = PBField.initString("");
    public final PBStringField button_text = PBField.initString("");
    public final PBStringField button_text_color = PBField.initString("");
    public final PBStringField button_bg = PBField.initString("");
    public final PBStringField pic_bg = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBStringField clm_param = PBField.initString("");
    public final PBStringField pic_bg_diy = PBField.initString("");
}
