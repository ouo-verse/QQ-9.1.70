package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$GetOnLineStatusRsp extends MessageMicro<GameStrategyQA$GetOnLineStatusRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"is_online"}, new Object[]{Boolean.FALSE}, GameStrategyQA$GetOnLineStatusRsp.class);
    public final PBBoolField is_online = PBField.initBool(false);
}
