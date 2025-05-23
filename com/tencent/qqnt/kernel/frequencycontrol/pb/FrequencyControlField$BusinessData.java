package com.tencent.qqnt.kernel.frequencycontrol.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FrequencyControlField$BusinessData extends MessageMicro<FrequencyControlField$BusinessData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"type", "data"}, new Object[]{0, ByteStringMicro.EMPTY}, FrequencyControlField$BusinessData.class);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBBytesField data = PBField.initBytes(ByteStringMicro.EMPTY);
}
