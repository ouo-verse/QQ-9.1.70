package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes28.dex */
public final class FeedCloudRead$StBatchGetFeedSharePanelRsp extends MessageMicro<FeedCloudRead$StBatchGetFeedSharePanelRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"share_info"}, new Object[]{null}, FeedCloudRead$StBatchGetFeedSharePanelRsp.class);
    public final PBRepeatMessageField<FeedCloudMeta$StShare> share_info = PBField.initRepeatMessage(FeedCloudMeta$StShare.class);
}
