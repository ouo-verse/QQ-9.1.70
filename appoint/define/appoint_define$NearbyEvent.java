package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class appoint_define$NearbyEvent extends MessageMicro<appoint_define$NearbyEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"uint32_eventtype", "msg_rankevent", "uint64_event_uin", "uint64_event_tinyid"}, new Object[]{0, null, 0L, 0L}, appoint_define$NearbyEvent.class);
    public final PBUInt32Field uint32_eventtype = PBField.initUInt32(0);
    public appoint_define$RankEvent msg_rankevent = new MessageMicro<appoint_define$RankEvent>() { // from class: appoint.define.appoint_define$RankEvent
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"uint32_listtype", "uint32_notifytype", "uint32_eventtime", "uint32_seq", "str_notify_tips"}, new Object[]{0, 0, 0, 0, ""}, appoint_define$RankEvent.class);
        public final PBUInt32Field uint32_listtype = PBField.initUInt32(0);
        public final PBUInt32Field uint32_notifytype = PBField.initUInt32(0);
        public final PBUInt32Field uint32_eventtime = PBField.initUInt32(0);
        public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
        public final PBStringField str_notify_tips = PBField.initString("");
    };
    public final PBUInt64Field uint64_event_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_event_tinyid = PBField.initUInt64(0);
}
