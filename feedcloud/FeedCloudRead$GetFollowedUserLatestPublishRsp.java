package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes28.dex */
public final class FeedCloudRead$GetFollowedUserLatestPublishRsp extends MessageMicro<FeedCloudRead$GetFollowedUserLatestPublishRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"items"}, new Object[]{null}, FeedCloudRead$GetFollowedUserLatestPublishRsp.class);
    public final PBRepeatMessageField<FeedCloudRead$FollowedUserItem> items = PBField.initRepeatMessage(FeedCloudRead$FollowedUserItem.class);
}
