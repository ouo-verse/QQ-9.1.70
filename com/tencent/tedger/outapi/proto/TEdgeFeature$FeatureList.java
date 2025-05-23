package com.tencent.tedger.outapi.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.rmonitor.base.config.data.k;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class TEdgeFeature$FeatureList extends MessageMicro<TEdgeFeature$FeatureList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18}, new String[]{k.FEATURES_KEY}, new Object[]{null}, TEdgeFeature$FeatureList.class);
    public final PBRepeatMessageField<TEdgeFeature$Feature> features = PBField.initRepeatMessage(TEdgeFeature$Feature.class);
}
