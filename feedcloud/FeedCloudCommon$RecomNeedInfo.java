package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudCommon$RecomNeedInfo extends MessageMicro<FeedCloudCommon$RecomNeedInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"preloadFeeds", "unableExpoFeeds", "unreadAdsInfo"}, new Object[]{null, null, ByteStringMicro.EMPTY}, FeedCloudCommon$RecomNeedInfo.class);
    public final PBRepeatMessageField<FeedCloudCommon$RecomReed> preloadFeeds = PBField.initRepeatMessage(FeedCloudCommon$RecomReed.class);
    public final PBRepeatMessageField<FeedCloudCommon$RecomReed> unableExpoFeeds = PBField.initRepeatMessage(FeedCloudCommon$RecomReed.class);
    public final PBBytesField unreadAdsInfo = PBField.initBytes(ByteStringMicro.EMPTY);
}
