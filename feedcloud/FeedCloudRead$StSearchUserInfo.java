package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StSearchUserInfo extends MessageMicro<FeedCloudRead$StSearchUserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50}, new String[]{"userList", "attachInfo", "isOver", "userFeeds", "correction_info", "reason"}, new Object[]{null, "", 0, null, null, null}, FeedCloudRead$StSearchUserInfo.class);
    public final PBRepeatMessageField<FeedCloudMeta$StUser> userList = PBField.initRepeatMessage(FeedCloudMeta$StUser.class);
    public final PBStringField attachInfo = PBField.initString("");
    public final PBInt32Field isOver = PBField.initInt32(0);
    public final PBRepeatMessageField<FeedCloudRead$StUserFeedsInfo> userFeeds = PBField.initRepeatMessage(FeedCloudRead$StUserFeedsInfo.class);
    public FeedCloudRead$StCorrectionInfo correction_info = new FeedCloudRead$StCorrectionInfo();
    public final PBRepeatMessageField<FeedCloudRead$StRecReasonInfo> reason = PBField.initRepeatMessage(FeedCloudRead$StRecReasonInfo.class);
}
