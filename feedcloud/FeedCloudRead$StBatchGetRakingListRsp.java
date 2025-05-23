package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StBatchGetRakingListRsp extends MessageMicro<FeedCloudRead$StBatchGetRakingListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "singleRsp"}, new Object[]{null, null}, FeedCloudRead$StBatchGetRakingListRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<FeedCloudRead$StGetRankingListRsp> singleRsp = PBField.initRepeatMessage(FeedCloudRead$StGetRankingListRsp.class);
}
