package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes28.dex */
public final class FeedCloudRead$StSearchMixPageTagInfo extends MessageMicro<FeedCloudRead$StSearchMixPageTagInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"extInfo", "tagInfo", "need_medal", "feeds"}, new Object[]{null, null, Boolean.FALSE, null}, FeedCloudRead$StSearchMixPageTagInfo.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public FeedCloudMeta$StTagInfo tagInfo = new FeedCloudMeta$StTagInfo();
    public final PBBoolField need_medal = PBField.initBool(false);
    public final PBRepeatMessageField<FeedCloudMeta$StFeed> feeds = PBField.initRepeatMessage(FeedCloudMeta$StFeed.class);
}
