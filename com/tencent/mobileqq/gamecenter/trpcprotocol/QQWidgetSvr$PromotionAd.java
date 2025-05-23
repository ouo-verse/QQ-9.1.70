package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes12.dex */
public final class QQWidgetSvr$PromotionAd extends MessageMicro<QQWidgetSvr$PromotionAd> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42}, new String[]{"pic", "jump_url", "type", "appid", "id"}, new Object[]{"", "", 0, "", ""}, QQWidgetSvr$PromotionAd.class);
    public final PBStringField pic = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(0);
    public final PBStringField appid = PBField.initString("");

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f213228id = PBField.initString("");
}
