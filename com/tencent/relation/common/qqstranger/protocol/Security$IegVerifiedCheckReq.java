package com.tencent.relation.common.qqstranger.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class Security$IegVerifiedCheckReq extends MessageMicro<Security$IegVerifiedCheckReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"source", "game"}, new Object[]{0, 0}, Security$IegVerifiedCheckReq.class);
    public final PBEnumField source = PBField.initEnum(0);
    public final PBEnumField game = PBField.initEnum(0);
}
