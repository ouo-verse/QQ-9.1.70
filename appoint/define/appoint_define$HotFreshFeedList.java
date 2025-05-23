package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class appoint_define$HotFreshFeedList extends MessageMicro<appoint_define$HotFreshFeedList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"rpt_msg_feeds", "uint32_update_time"}, new Object[]{null, 0}, appoint_define$HotFreshFeedList.class);
    public final PBRepeatMessageField<appoint_define$HotUserFeed> rpt_msg_feeds = PBField.initRepeatMessage(appoint_define$HotUserFeed.class);
    public final PBUInt32Field uint32_update_time = PBField.initUInt32(0);
}
