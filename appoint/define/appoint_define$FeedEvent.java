package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class appoint_define$FeedEvent extends MessageMicro<appoint_define$FeedEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 58, 64}, new String[]{"uint64_event_id", "uint32_time", "uint32_eventtype", "msg_user_info", "msg_feed_info", "str_event_tips", "msg_comment", "uint64_cancel_event_id"}, new Object[]{0L, 0, 0, null, null, "", null, 0L}, appoint_define$FeedEvent.class);
    public final PBUInt64Field uint64_event_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_eventtype = PBField.initUInt32(0);
    public appoint_define$StrangerInfo msg_user_info = new appoint_define$StrangerInfo();
    public appoint_define$FeedInfo msg_feed_info = new appoint_define$FeedInfo();
    public final PBStringField str_event_tips = PBField.initString("");
    public appoint_define$FeedComment msg_comment = new appoint_define$FeedComment();
    public final PBUInt64Field uint64_cancel_event_id = PBField.initUInt64(0);
}
