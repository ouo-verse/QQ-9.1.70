package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class VaProfileGate$OidbFlagInfo extends MessageMicro<VaProfileGate$OidbFlagInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_fieled", "byets_value"}, new Object[]{0, ByteStringMicro.EMPTY}, VaProfileGate$OidbFlagInfo.class);
    public final PBUInt32Field uint32_fieled = PBField.initUInt32(0);
    public final PBBytesField byets_value = PBField.initBytes(ByteStringMicro.EMPTY);
}
