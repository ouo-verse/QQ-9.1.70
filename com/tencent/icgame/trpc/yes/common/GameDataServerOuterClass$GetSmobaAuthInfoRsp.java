package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class GameDataServerOuterClass$GetSmobaAuthInfoRsp extends MessageMicro<GameDataServerOuterClass$GetSmobaAuthInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"auth_desc", "is_auth"}, new Object[]{"", Boolean.FALSE}, GameDataServerOuterClass$GetSmobaAuthInfoRsp.class);
    public final PBRepeatField<String> auth_desc = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBBoolField is_auth = PBField.initBool(false);
}
