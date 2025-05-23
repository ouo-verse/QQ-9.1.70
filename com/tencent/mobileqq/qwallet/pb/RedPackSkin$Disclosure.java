package com.tencent.mobileqq.qwallet.pb;

import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class RedPackSkin$Disclosure extends MessageMicro<RedPackSkin$Disclosure> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"logo", "title", "sub_title", QZoneAdTianshuFeedData.KEY_BUTTON_TEXT, "button_href"}, new Object[]{"", "", "", "", ""}, RedPackSkin$Disclosure.class);
    public final PBStringField logo = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField sub_title = PBField.initString("");
    public final PBStringField button_text = PBField.initString("");
    public final PBStringField button_href = PBField.initString("");
}
