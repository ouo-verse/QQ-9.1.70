package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class GameDataServerOuterClass$SetSmobaDefaultRoleRsp extends MessageMicro<GameDataServerOuterClass$SetSmobaDefaultRoleRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"role_info", "openid"}, new Object[]{null, ""}, GameDataServerOuterClass$SetSmobaDefaultRoleRsp.class);
    public GameRoleOuterClass$SmobaGameRoleInfo role_info = new GameRoleOuterClass$SmobaGameRoleInfo();
    public final PBStringField openid = PBField.initString("");
}
