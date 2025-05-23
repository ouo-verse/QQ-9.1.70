package com.tencent.trpcprotocol.kuolie.emoji_path.emoji_path;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class EmojiPath$EmojiPathModel extends MessageMicro<EmojiPath$EmojiPathModel> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"s_id", "path"}, new Object[]{"", ""}, EmojiPath$EmojiPathModel.class);
    public final PBStringField s_id = PBField.initString("");
    public final PBStringField path = PBField.initString("");
}
