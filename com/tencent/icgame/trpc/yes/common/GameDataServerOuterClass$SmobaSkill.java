package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class GameDataServerOuterClass$SmobaSkill extends MessageMicro<GameDataServerOuterClass$SmobaSkill> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"name", "desc"}, new Object[]{"", ""}, GameDataServerOuterClass$SmobaSkill.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
}
