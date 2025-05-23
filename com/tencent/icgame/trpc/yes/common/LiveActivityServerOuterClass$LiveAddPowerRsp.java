package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes7.dex */
public final class LiveActivityServerOuterClass$LiveAddPowerRsp extends MessageMicro<LiveActivityServerOuterClass$LiveAddPowerRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"seq_id"}, new Object[]{""}, LiveActivityServerOuterClass$LiveAddPowerRsp.class);
    public final PBStringField seq_id = PBField.initString("");
}
