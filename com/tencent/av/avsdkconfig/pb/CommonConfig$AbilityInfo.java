package com.tencent.av.avsdkconfig.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class CommonConfig$AbilityInfo extends MessageMicro<CommonConfig$AbilityInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"min_width", "min_height", "max_width", "max_height", "feature_info"}, new Object[]{0L, 0L, 0L, 0L, null}, CommonConfig$AbilityInfo.class);
    public final PBUInt64Field min_width = PBField.initUInt64(0);
    public final PBUInt64Field min_height = PBField.initUInt64(0);
    public final PBUInt64Field max_width = PBField.initUInt64(0);
    public final PBUInt64Field max_height = PBField.initUInt64(0);
    public final PBRepeatMessageField<CommonConfig$FeatureInfo> feature_info = PBField.initRepeatMessage(CommonConfig$FeatureInfo.class);
}
