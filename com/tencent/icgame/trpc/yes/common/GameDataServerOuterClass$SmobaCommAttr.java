package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class GameDataServerOuterClass$SmobaCommAttr extends MessageMicro<GameDataServerOuterClass$SmobaCommAttr> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"attr", "value"}, new Object[]{"", ""}, GameDataServerOuterClass$SmobaCommAttr.class);
    public final PBStringField attr = PBField.initString("");
    public final PBStringField value = PBField.initString("");
}
