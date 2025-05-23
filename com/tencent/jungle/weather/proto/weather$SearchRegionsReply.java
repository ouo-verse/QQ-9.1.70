package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class weather$SearchRegionsReply extends MessageMicro<weather$SearchRegionsReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"regions", "totalCount"}, new Object[]{null, 0}, weather$SearchRegionsReply.class);
    public final PBRepeatMessageField<weather$AdministrativeRegion> regions = PBField.initRepeatMessage(weather$AdministrativeRegion.class);
    public final PBUInt32Field totalCount = PBField.initUInt32(0);
}
