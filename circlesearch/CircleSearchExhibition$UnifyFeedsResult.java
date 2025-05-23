package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$UnifyFeedsResult extends MessageMicro<CircleSearchExhibition$UnifyFeedsResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"title", "feeds", "rank"}, new Object[]{"", null, 0}, CircleSearchExhibition$UnifyFeedsResult.class);
    public final PBStringField title = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudMeta$StFeed> feeds = PBField.initRepeatMessage(FeedCloudMeta$StFeed.class);
    public final PBInt32Field rank = PBField.initInt32(0);
}
