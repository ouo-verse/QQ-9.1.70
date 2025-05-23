package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* loaded from: classes28.dex */
public final class FeedCloudRead$StSearchMixPageUserInfo extends MessageMicro<FeedCloudRead$StSearchMixPageUserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"extInfo", QCircleAlphaUserReporter.KEY_USER, "attachInfo", "feeds"}, new Object[]{null, null, "", null}, FeedCloudRead$StSearchMixPageUserInfo.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public FeedCloudMeta$StUser user = new FeedCloudMeta$StUser();
    public final PBStringField attachInfo = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudMeta$StFeed> feeds = PBField.initRepeatMessage(FeedCloudMeta$StFeed.class);
}
