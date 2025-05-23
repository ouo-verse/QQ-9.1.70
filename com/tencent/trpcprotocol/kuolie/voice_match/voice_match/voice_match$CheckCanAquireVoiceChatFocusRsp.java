package com.tencent.trpcprotocol.kuolie.voice_match.voice_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class voice_match$CheckCanAquireVoiceChatFocusRsp extends MessageMicro<voice_match$CheckCanAquireVoiceChatFocusRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"canAquire"}, new Object[]{Boolean.FALSE}, voice_match$CheckCanAquireVoiceChatFocusRsp.class);
    public final PBBoolField canAquire = PBField.initBool(false);
}
