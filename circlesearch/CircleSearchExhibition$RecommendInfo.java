package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta$StRecommendInfo;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$RecommendInfo extends MessageMicro<CircleSearchExhibition$RecommendInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 42}, new String[]{"feed_id", "recommend_info"}, new Object[]{"", null}, CircleSearchExhibition$RecommendInfo.class);
    public final PBStringField feed_id = PBField.initString("");
    public FeedCloudMeta$StRecommendInfo recommend_info = new FeedCloudMeta$StRecommendInfo();
}
