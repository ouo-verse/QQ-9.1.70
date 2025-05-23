package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQAInvite$UserV2 extends MessageMicro<GameStrategyQAInvite$UserV2> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 26, 34, 42, 50, 58, 80}, new String[]{"title_type", "avatar", "nick", "title", "describe", "encoded_uin", "expire_at"}, new Object[]{0, "", "", "", "", "", 0L}, GameStrategyQAInvite$UserV2.class);
    public final PBEnumField title_type = PBField.initEnum(0);
    public final PBStringField avatar = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField describe = PBField.initString("");
    public final PBStringField encoded_uin = PBField.initString("");
    public final PBInt64Field expire_at = PBField.initInt64(0);
}
