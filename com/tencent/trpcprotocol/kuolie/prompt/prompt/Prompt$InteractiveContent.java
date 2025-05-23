package com.tencent.trpcprotocol.kuolie.prompt.prompt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes38.dex */
public final class Prompt$InteractiveContent extends MessageMicro<Prompt$InteractiveContent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"background", "head", "title", "content", "feed_id"}, new Object[]{"", "", "", "", ""}, Prompt$InteractiveContent.class);
    public final PBStringField background = PBField.initString("");
    public final PBStringField head = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public final PBStringField feed_id = PBField.initString("");
}
