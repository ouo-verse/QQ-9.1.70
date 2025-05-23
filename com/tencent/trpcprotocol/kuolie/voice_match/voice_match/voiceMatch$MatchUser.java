package com.tencent.trpcprotocol.kuolie.voice_match.voice_match;

import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class voiceMatch$MatchUser extends MessageMicro<voiceMatch$MatchUser> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42}, new String[]{"open_id", INetChannelCallback.KEY_TINY_ID, "nickname", "avatar", "tiny_id_str"}, new Object[]{"", 0L, "", "", ""}, voiceMatch$MatchUser.class);
    public final PBStringField open_id = PBField.initString("");
    public final PBUInt64Field tiny_id = PBField.initUInt64(0);
    public final PBStringField nickname = PBField.initString("");
    public final PBStringField avatar = PBField.initString("");
    public final PBStringField tiny_id_str = PBField.initString("");
}
