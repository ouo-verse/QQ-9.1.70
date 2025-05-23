package com.tencent.trpcprotocol.kuolie.voice_match.voice_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class voiceMatch$CheckIfAbleVoiceMatchRsp extends MessageMicro<voiceMatch$CheckIfAbleVoiceMatchRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42}, new String[]{"code", "msg", "result_type", "dialog_config", "loading_tips"}, new Object[]{0, "", 0, null, ""}, voiceMatch$CheckIfAbleVoiceMatchRsp.class);
    public final PBEnumField code = PBField.initEnum(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f381585msg = PBField.initString("");
    public final PBEnumField result_type = PBField.initEnum(0);
    public voiceMatch$DialogConfig dialog_config = new voiceMatch$DialogConfig();
    public final PBRepeatField<String> loading_tips = PBField.initRepeat(PBStringField.__repeatHelper__);
}
