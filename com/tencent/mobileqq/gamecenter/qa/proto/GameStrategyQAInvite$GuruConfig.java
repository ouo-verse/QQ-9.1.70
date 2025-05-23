package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQAInvite$GuruConfig extends MessageMicro<GameStrategyQAInvite$GuruConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50}, new String[]{"enable", "title", "group_appid", "group_tag", "honor_link", "certification_link"}, new Object[]{Boolean.FALSE, "", 0, "", "", ""}, GameStrategyQAInvite$GuruConfig.class);
    public final PBBoolField enable = PBField.initBool(false);
    public final PBStringField title = PBField.initString("");
    public final PBUInt32Field group_appid = PBField.initUInt32(0);
    public final PBStringField group_tag = PBField.initString("");
    public final PBStringField honor_link = PBField.initString("");
    public final PBStringField certification_link = PBField.initString("");
}
