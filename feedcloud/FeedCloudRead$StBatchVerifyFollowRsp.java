package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StBatchVerifyFollowRsp extends MessageMicro<FeedCloudRead$StBatchVerifyFollowRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"infos"}, new Object[]{null}, FeedCloudRead$StBatchVerifyFollowRsp.class);
    public final PBRepeatMessageField<FeedCloudMeta$StRelationInfo> infos = PBField.initRepeatMessage(FeedCloudMeta$StRelationInfo.class);
}
