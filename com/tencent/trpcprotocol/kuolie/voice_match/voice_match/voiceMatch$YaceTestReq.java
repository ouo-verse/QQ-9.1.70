package com.tencent.trpcprotocol.kuolie.voice_match.voice_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class voiceMatch$YaceTestReq extends MessageMicro<voiceMatch$YaceTestReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"openid"}, new Object[]{""}, voiceMatch$YaceTestReq.class);
    public final PBStringField openid = PBField.initString("");
}
