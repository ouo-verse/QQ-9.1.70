package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class GameDataServerOuterClass$GetUserSmobaRoleListRsp extends MessageMicro<GameDataServerOuterClass$GetUserSmobaRoleListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"role_list", "openid"}, new Object[]{null, ""}, GameDataServerOuterClass$GetUserSmobaRoleListRsp.class);
    public final PBRepeatMessageField<GameDataServerOuterClass$SmobaGameRoleAbsInfo> role_list = PBField.initRepeatMessage(GameDataServerOuterClass$SmobaGameRoleAbsInfo.class);
    public final PBStringField openid = PBField.initString("");
}
