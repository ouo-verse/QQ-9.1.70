package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$BatchStDoModCommentExtRsp extends MessageMicro<FeedCloudWrite$BatchStDoModCommentExtRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "modResults"}, new Object[]{null, null}, FeedCloudWrite$BatchStDoModCommentExtRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<FeedCloudWrite$ModResult> modResults = PBField.initRepeatMessage(FeedCloudWrite$ModResult.class);
}
