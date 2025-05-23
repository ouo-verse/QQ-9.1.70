package com.tencent.mobileqq.avifcodec.config.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class AvifCodecConfig$CodecConfigRsp extends MessageMicro<AvifCodecConfig$CodecConfigRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"ability"}, new Object[]{null}, AvifCodecConfig$CodecConfigRsp.class);
    public final PBRepeatMessageField<AvifCodecConfig$Ability> ability = PBField.initRepeatMessage(AvifCodecConfig$Ability.class);
}
