package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class GameDataServerOuterClass$CreateCFMGroupTeamRsp extends MessageMicro<GameDataServerOuterClass$CreateCFMGroupTeamRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"team_id"}, new Object[]{""}, GameDataServerOuterClass$CreateCFMGroupTeamRsp.class);
    public final PBStringField team_id = PBField.initString("");
}
