package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StDoBatchShareFeedReq extends MessageMicro<FeedCloudWrite$StDoBatchShareFeedReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"feedID", "targets", "text"}, new Object[]{"", null, ""}, FeedCloudWrite$StDoBatchShareFeedReq.class);
    public final PBStringField feedID = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudWrite$ShareTarget> targets = PBField.initRepeatMessage(FeedCloudWrite$ShareTarget.class);
    public final PBStringField text = PBField.initString("");
}
