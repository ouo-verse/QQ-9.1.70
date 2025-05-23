package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class FeedsProtocol$TopicCfg extends MessageMicro<FeedsProtocol$TopicCfg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 50, 810}, new String[]{"topic_tag", "topic_desc", "topic_name", "topic_parti_num", "topic_type", "topic_pic_url", "jump_url"}, new Object[]{0, "", "", 0, 0, "", ""}, FeedsProtocol$TopicCfg.class);
    public final PBUInt32Field topic_tag = PBField.initUInt32(0);
    public final PBStringField topic_desc = PBField.initString("");
    public final PBStringField topic_name = PBField.initString("");
    public final PBUInt32Field topic_parti_num = PBField.initUInt32(0);
    public final PBUInt32Field topic_type = PBField.initUInt32(0);
    public final PBStringField topic_pic_url = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
}
