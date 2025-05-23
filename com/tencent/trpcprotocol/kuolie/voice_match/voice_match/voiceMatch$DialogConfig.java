package com.tencent.trpcprotocol.kuolie.voice_match.voice_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class voiceMatch$DialogConfig extends MessageMicro<voiceMatch$DialogConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"title", "body", "bg_pic", "jump_url"}, new Object[]{"", "", "", ""}, voiceMatch$DialogConfig.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField body = PBField.initString("");
    public final PBStringField bg_pic = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
}
