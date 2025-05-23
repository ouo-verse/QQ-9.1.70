package feedcloud;

import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StBatchCallFollowRsp extends MessageMicro<FeedCloudWrite$StBatchCallFollowRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{ForwardMiniChooseFriendOption.RESULT_LIST}, new Object[]{null}, FeedCloudWrite$StBatchCallFollowRsp.class);
    public final PBRepeatMessageField<FeedCloudWrite$StCallFollowRsp> results = PBField.initRepeatMessage(FeedCloudWrite$StCallFollowRsp.class);
}
