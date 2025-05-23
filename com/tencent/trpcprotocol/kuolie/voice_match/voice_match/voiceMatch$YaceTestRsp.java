package com.tencent.trpcprotocol.kuolie.voice_match.voice_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class voiceMatch$YaceTestRsp extends MessageMicro<voiceMatch$YaceTestRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"ret_code"}, new Object[]{0}, voiceMatch$YaceTestRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
}
