package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StBatchGetRakingListReq extends MessageMicro<FeedCloudRead$StBatchGetRakingListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "singleReq"}, new Object[]{null, null}, FeedCloudRead$StBatchGetRakingListReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<FeedCloudRead$StGetRankingListReq> singleReq = PBField.initRepeatMessage(FeedCloudRead$StGetRankingListReq.class);
}
