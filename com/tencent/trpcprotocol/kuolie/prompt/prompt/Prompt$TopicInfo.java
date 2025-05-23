package com.tencent.trpcprotocol.kuolie.prompt.prompt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes38.dex */
public final class Prompt$TopicInfo extends MessageMicro<Prompt$TopicInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"color", "topic_name"}, new Object[]{0, ""}, Prompt$TopicInfo.class);
    public final PBUInt32Field color = PBField.initUInt32(0);
    public final PBStringField topic_name = PBField.initString("");
}
