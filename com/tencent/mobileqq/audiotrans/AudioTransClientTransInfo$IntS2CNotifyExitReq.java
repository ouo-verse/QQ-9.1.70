package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class AudioTransClientTransInfo$IntS2CNotifyExitReq extends MessageMicro<AudioTransClientTransInfo$IntS2CNotifyExitReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_reason"}, new Object[]{0}, AudioTransClientTransInfo$IntS2CNotifyExitReq.class);
    public final PBUInt32Field uint32_reason = PBField.initUInt32(0);
}
