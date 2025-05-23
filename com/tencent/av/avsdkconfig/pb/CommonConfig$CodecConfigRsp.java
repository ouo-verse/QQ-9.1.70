package com.tencent.av.avsdkconfig.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class CommonConfig$CodecConfigRsp extends MessageMicro<CommonConfig$CodecConfigRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"ability"}, new Object[]{null}, CommonConfig$CodecConfigRsp.class);
    public final PBRepeatMessageField<CommonConfig$Ability> ability = PBField.initRepeatMessage(CommonConfig$Ability.class);
}
