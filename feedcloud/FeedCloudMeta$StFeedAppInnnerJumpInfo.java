package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StFeedAppInnnerJumpInfo extends MessageMicro<FeedCloudMeta$StFeedAppInnnerJumpInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"qq_group_id", "qq_group_message_id", "guild_id", "qq_group_source", "qq_group_flag"}, new Object[]{0L, 0L, 0L, 0, 0}, FeedCloudMeta$StFeedAppInnnerJumpInfo.class);
    public final PBUInt64Field qq_group_id = PBField.initUInt64(0);
    public final PBInt64Field qq_group_message_id = PBField.initInt64(0);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt32Field qq_group_source = PBField.initUInt32(0);
    public final PBUInt32Field qq_group_flag = PBField.initUInt32(0);
}
