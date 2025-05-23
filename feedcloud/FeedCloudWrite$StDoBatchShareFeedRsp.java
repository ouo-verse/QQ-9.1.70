package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StDoBatchShareFeedRsp extends MessageMicro<FeedCloudWrite$StDoBatchShareFeedRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"res"}, new Object[]{null}, FeedCloudWrite$StDoBatchShareFeedRsp.class);
    public final PBRepeatMessageField<FeedCloudWrite$ShareResult> res = PBField.initRepeatMessage(FeedCloudWrite$ShareResult.class);
}
