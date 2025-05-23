package com.tencent.tedger.outapi.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class TEdgeEngine$TargetEmbedding extends MessageMicro<TEdgeEngine$TargetEmbedding> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 21}, new String[]{"target", "embedding"}, new Object[]{"", Float.valueOf(0.0f)}, TEdgeEngine$TargetEmbedding.class);
    public final PBStringField target = PBField.initString("");
    public final PBRepeatField<Float> embedding = PBField.initRepeat(PBFloatField.__repeatHelper__);
}
