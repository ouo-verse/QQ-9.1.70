package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class GameDataServerOuterClass$AgreeSmobaAuthReq extends MessageMicro<GameDataServerOuterClass$AgreeSmobaAuthReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uid", "a2_key", "sense"}, new Object[]{0L, ByteStringMicro.EMPTY, 0}, GameDataServerOuterClass$AgreeSmobaAuthReq.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBBytesField a2_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field sense = PBField.initInt32(0);
}
