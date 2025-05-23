package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* loaded from: classes28.dex */
public final class FeedCloudActivityLandingPage$ActivityRankInfo extends MessageMicro<FeedCloudActivityLandingPage$ActivityRankInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 58, 64}, new String[]{QCircleAlphaUserReporter.KEY_USER, "start_date", "end_date", "play_count", "rank_level", "feed_count", "feed_item", IQzoneWebViewPluginHelper.EXTRA_FAMOUS_IS_FOLLOWED}, new Object[]{null, 0L, 0L, 0L, 0, 0, null, Boolean.FALSE}, FeedCloudActivityLandingPage$ActivityRankInfo.class);
    public FeedCloudMeta$StUser user = new FeedCloudMeta$StUser();
    public final PBInt64Field start_date = PBField.initInt64(0);
    public final PBInt64Field end_date = PBField.initInt64(0);
    public final PBInt64Field play_count = PBField.initInt64(0);
    public final PBInt32Field rank_level = PBField.initInt32(0);
    public final PBInt32Field feed_count = PBField.initInt32(0);
    public FeedCloudMeta$StFeedAbstract feed_item = new FeedCloudMeta$StFeedAbstract();
    public final PBBoolField is_followed = PBField.initBool(false);
}
