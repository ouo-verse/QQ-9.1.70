package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class appoint_define$RecentFreshFeed extends MessageMicro<appoint_define$RecentFreshFeed> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"rpt_fresh_feed_info", "uint64_uid"}, new Object[]{null, 0L}, appoint_define$RecentFreshFeed.class);
    public final PBRepeatMessageField<appoint_define$FreshFeedInfo> rpt_fresh_feed_info = PBField.initRepeatMessage(appoint_define$FreshFeedInfo.class);
    public final PBUInt64Field uint64_uid = PBField.initUInt64(0);
}
