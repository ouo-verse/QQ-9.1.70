package com.tencent.tedger.outapi.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class TEdgeFeature$Feature extends MessageMicro<TEdgeFeature$Feature> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"feature_name", "feature_values"}, new Object[]{"", null}, TEdgeFeature$Feature.class);
    public final PBStringField feature_name = PBField.initString("");
    public final PBRepeatMessageField<TEdgeFeature$FeatureValue> feature_values = PBField.initRepeatMessage(TEdgeFeature$FeatureValue.class);
}
