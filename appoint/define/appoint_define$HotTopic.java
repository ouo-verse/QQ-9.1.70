package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class appoint_define$HotTopic extends MessageMicro<appoint_define$HotTopic> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48, 58, 66, 74}, new String[]{"uint64_id", "str_title", "uint64_topic_type", "uint64_total", "uint64_times", "uint64_history_times", "str_bg_url", "str_url", "str_extra_info"}, new Object[]{0L, "", 0L, 0L, 0L, 0L, "", "", ""}, appoint_define$HotTopic.class);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0);
    public final PBStringField str_title = PBField.initString("");
    public final PBUInt64Field uint64_topic_type = PBField.initUInt64(0);
    public final PBUInt64Field uint64_total = PBField.initUInt64(0);
    public final PBUInt64Field uint64_times = PBField.initUInt64(0);
    public final PBUInt64Field uint64_history_times = PBField.initUInt64(0);
    public final PBStringField str_bg_url = PBField.initString("");
    public final PBStringField str_url = PBField.initString("");
    public final PBStringField str_extra_info = PBField.initString("");
}
