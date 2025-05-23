package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class weather$SearchRegionsRequest extends MessageMicro<weather$SearchRegionsRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"key", "offset", "count"}, new Object[]{"", 0, 0}, weather$SearchRegionsRequest.class);
    public final PBStringField key = PBField.initString("");
    public final PBUInt32Field offset = PBField.initUInt32(0);
    public final PBUInt32Field count = PBField.initUInt32(0);
}
