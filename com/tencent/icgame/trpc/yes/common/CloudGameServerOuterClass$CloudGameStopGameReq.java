package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class CloudGameServerOuterClass$CloudGameStopGameReq extends MessageMicro<CloudGameServerOuterClass$CloudGameStopGameReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uid"}, new Object[]{0L}, CloudGameServerOuterClass$CloudGameStopGameReq.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
}
