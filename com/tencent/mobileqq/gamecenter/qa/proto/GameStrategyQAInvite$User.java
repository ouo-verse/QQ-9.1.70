package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQAInvite$User extends MessageMicro<GameStrategyQAInvite$User> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 80}, new String[]{"title_type", "uin", "avatar", "nick", "title", "describe", "encoded_uin", "expire_at"}, new Object[]{0, 0L, "", "", "", "", "", 0L}, GameStrategyQAInvite$User.class);
    public final PBEnumField title_type = PBField.initEnum(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField avatar = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField describe = PBField.initString("");
    public final PBStringField encoded_uin = PBField.initString("");
    public final PBInt64Field expire_at = PBField.initInt64(0);
}
