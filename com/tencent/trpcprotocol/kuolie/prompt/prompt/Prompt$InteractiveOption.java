package com.tencent.trpcprotocol.kuolie.prompt.prompt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes38.dex */
public final class Prompt$InteractiveOption extends MessageMicro<Prompt$InteractiveOption> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"interactive_id", "content"}, new Object[]{0, ""}, Prompt$InteractiveOption.class);
    public final PBUInt32Field interactive_id = PBField.initUInt32(0);
    public final PBStringField content = PBField.initString("");
}
