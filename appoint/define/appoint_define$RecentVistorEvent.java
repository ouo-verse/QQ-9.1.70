package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class appoint_define$RecentVistorEvent extends MessageMicro<appoint_define$RecentVistorEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_eventtype", "uint64_event_tinyid", "uint64_unread_count"}, new Object[]{0, 0L, 0}, appoint_define$RecentVistorEvent.class);
    public final PBUInt32Field uint32_eventtype = PBField.initUInt32(0);
    public final PBUInt64Field uint64_event_tinyid = PBField.initUInt64(0);
    public final PBUInt32Field uint64_unread_count = PBField.initUInt32(0);
}
