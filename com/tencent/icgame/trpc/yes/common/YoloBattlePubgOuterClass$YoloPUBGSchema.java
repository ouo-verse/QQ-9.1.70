package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes7.dex */
public final class YoloBattlePubgOuterClass$YoloPUBGSchema extends MessageMicro<YoloBattlePubgOuterClass$YoloPUBGSchema> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"schemas"}, new Object[]{null}, YoloBattlePubgOuterClass$YoloPUBGSchema.class);
    public final PBRepeatMessageField<YoloBattlePubgOuterClass$YoloPUBGOneSchema> schemas = PBField.initRepeatMessage(YoloBattlePubgOuterClass$YoloPUBGOneSchema.class);
}
