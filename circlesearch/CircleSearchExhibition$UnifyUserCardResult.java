package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$UnifyUserCardResult extends MessageMicro<CircleSearchExhibition$UnifyUserCardResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{QCircleAlphaUserReporter.KEY_USER, "feeds"}, new Object[]{null, null}, CircleSearchExhibition$UnifyUserCardResult.class);
    public FeedCloudMeta$StUser user = new FeedCloudMeta$StUser();
    public final PBRepeatMessageField<FeedCloudMeta$StFeed> feeds = PBField.initRepeatMessage(FeedCloudMeta$StFeed.class);
}
