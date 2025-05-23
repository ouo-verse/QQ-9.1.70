package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloBattleQsmOuterClass$YoloQSMSchema extends MessageMicro<YoloBattleQsmOuterClass$YoloQSMSchema> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"schemas"}, new Object[]{null}, YoloBattleQsmOuterClass$YoloQSMSchema.class);
    public final PBRepeatMessageField<YoloBattleQsmOuterClass$YoloQSMOneSchema> schemas = PBField.initRepeatMessage(YoloBattleQsmOuterClass$YoloQSMOneSchema.class);
}
