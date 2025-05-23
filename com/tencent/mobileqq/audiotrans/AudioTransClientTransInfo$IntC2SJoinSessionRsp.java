package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class AudioTransClientTransInfo$IntC2SJoinSessionRsp extends MessageMicro<AudioTransClientTransInfo$IntC2SJoinSessionRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_heartbeat_duration", "uint32_combine_num"}, new Object[]{0, 0}, AudioTransClientTransInfo$IntC2SJoinSessionRsp.class);
    public final PBUInt32Field uint32_heartbeat_duration = PBField.initUInt32(0);
    public final PBUInt32Field uint32_combine_num = PBField.initUInt32(0);
}
