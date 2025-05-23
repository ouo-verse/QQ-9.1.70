package com.tencent.trpcprotocol.kuolie.emoji_path.emoji_path;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class EmojiPath$EmojiPathReq extends MessageMicro<EmojiPath$EmojiPathReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"s_ids"}, new Object[]{""}, EmojiPath$EmojiPathReq.class);
    public final PBRepeatField<String> s_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
}
