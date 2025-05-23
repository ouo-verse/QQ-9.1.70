package com.tencent.trpcprotocol.kuolie.prompt.prompt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes38.dex */
public final class Prompt$GetVoiceLinkTopicRsp extends MessageMicro<Prompt$GetVoiceLinkTopicRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ret_code", "err_msg", "topic_infos"}, new Object[]{0, "", null}, Prompt$GetVoiceLinkTopicRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBRepeatMessageField<Prompt$TopicInfo> topic_infos = PBField.initRepeatMessage(Prompt$TopicInfo.class);
}
