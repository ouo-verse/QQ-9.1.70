package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StSearchFeedInfo extends MessageMicro<FeedCloudRead$StSearchFeedInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 50}, new String[]{"feedList", "attachInfo", "feedJumpUrl", "isOver", "isJumpTagSearch", "feedAds"}, new Object[]{null, "", "", 0, Boolean.FALSE, null}, FeedCloudRead$StSearchFeedInfo.class);
    public final PBRepeatMessageField<FeedCloudMeta$StFeed> feedList = PBField.initRepeatMessage(FeedCloudMeta$StFeed.class);
    public final PBStringField attachInfo = PBField.initString("");
    public final PBStringField feedJumpUrl = PBField.initString("");
    public final PBInt32Field isOver = PBField.initInt32(0);
    public final PBBoolField isJumpTagSearch = PBField.initBool(false);
    public final PBRepeatMessageField<FeedCloudRead$FeedAdInfo> feedAds = PBField.initRepeatMessage(FeedCloudRead$FeedAdInfo.class);
}
