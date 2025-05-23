package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class weather$NowcastingNode extends MessageMicro<weather$NowcastingNode> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 21}, new String[]{"timestamp", "value"}, new Object[]{0, Float.valueOf(0.0f)}, weather$NowcastingNode.class);
    public final PBUInt32Field timestamp = PBField.initUInt32(0);
    public final PBFloatField value = PBField.initFloat(0.0f);
}
