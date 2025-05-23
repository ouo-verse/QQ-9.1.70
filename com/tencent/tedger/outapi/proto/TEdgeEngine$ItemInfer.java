package com.tencent.tedger.outapi.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class TEdgeEngine$ItemInfer extends MessageMicro<TEdgeEngine$ItemInfer> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"targets"}, new Object[]{null}, TEdgeEngine$ItemInfer.class);
    public final PBRepeatMessageField<TEdgeEngine$TargetEmbedding> targets = PBField.initRepeatMessage(TEdgeEngine$TargetEmbedding.class);
}
