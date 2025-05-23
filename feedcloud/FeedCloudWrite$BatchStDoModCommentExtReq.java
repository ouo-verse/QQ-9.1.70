package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$BatchStDoModCommentExtReq extends MessageMicro<FeedCloudWrite$BatchStDoModCommentExtReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rptStDoModCommentExtReq"}, new Object[]{null}, FeedCloudWrite$BatchStDoModCommentExtReq.class);
    public final PBRepeatMessageField<FeedCloudWrite$StDoModCommentExtReq> rptStDoModCommentExtReq = PBField.initRepeatMessage(FeedCloudWrite$StDoModCommentExtReq.class);
}
