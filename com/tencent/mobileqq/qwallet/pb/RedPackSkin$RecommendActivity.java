package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class RedPackSkin$RecommendActivity extends MessageMicro<RedPackSkin$RecommendActivity> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"text", "img", "url", "url_desc", "logo", "disclosure"}, new Object[]{"", "", "", "", "", null}, RedPackSkin$RecommendActivity.class);
    public final PBStringField text = PBField.initString("");
    public final PBStringField img = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBStringField url_desc = PBField.initString("");
    public final PBStringField logo = PBField.initString("");
    public RedPackSkin$Disclosure disclosure = new RedPackSkin$Disclosure();
}
