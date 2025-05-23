package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudWrite$PushBoxBasic extends MessageMicro<FeedCloudWrite$PushBoxBasic> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"feed_id", "auth_uin", "drawBoxInfo", "pushBoxViewInfo"}, new Object[]{"", "", null, null}, FeedCloudWrite$PushBoxBasic.class);
    public final PBStringField feed_id = PBField.initString("");
    public final PBStringField auth_uin = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudWrite$PushBoxBasicDrawInfo> drawBoxInfo = PBField.initRepeatMessage(FeedCloudWrite$PushBoxBasicDrawInfo.class);
    public FeedCloudMeta$PushBoxViewInfo pushBoxViewInfo = new FeedCloudMeta$PushBoxViewInfo();
}
