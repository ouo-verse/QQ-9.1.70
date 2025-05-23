package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class ConfigurationService$Config extends MessageMicro<ConfigurationService$Config> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42}, new String[]{"type", "version", "content_list", "msg_content_list", "msg_rich_info"}, new Object[]{0, 0, "", null, null}, ConfigurationService$Config.class);
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBInt32Field version = PBField.initInt32(0);
    public final PBRepeatField<String> content_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatMessageField<ConfigurationService$Content> msg_content_list = PBField.initRepeatMessage(ConfigurationService$Content.class);
    public ConfigurationService$RichInfo msg_rich_info = new MessageMicro<ConfigurationService$RichInfo>() { // from class: com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$RichInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"delay_time"}, new Object[]{0}, ConfigurationService$RichInfo.class);
        public final PBRepeatField<Integer> delay_time = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    };
}
