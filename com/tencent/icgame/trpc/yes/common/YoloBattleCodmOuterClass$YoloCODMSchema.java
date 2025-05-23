package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloBattleCodmOuterClass$YoloCODMSchema extends MessageMicro<YoloBattleCodmOuterClass$YoloCODMSchema> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"schemas"}, new Object[]{null}, YoloBattleCodmOuterClass$YoloCODMSchema.class);
    public final PBRepeatMessageField<YoloBattleCodmOuterClass$YoloCODMOneSchema> schemas = PBField.initRepeatMessage(YoloBattleCodmOuterClass$YoloCODMOneSchema.class);
}
