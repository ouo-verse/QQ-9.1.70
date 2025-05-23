package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetCircleRankListRsp extends MessageMicro<FeedCloudRead$StGetCircleRankListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"extInfo", "rankList", "startTime", "endTime"}, new Object[]{null, null, 0L, 0L}, FeedCloudRead$StGetCircleRankListRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<FeedCloudMeta$StCircleRankItem> rankList = PBField.initRepeatMessage(FeedCloudMeta$StCircleRankItem.class);
    public final PBInt64Field startTime = PBField.initInt64(0);
    public final PBInt64Field endTime = PBField.initInt64(0);
}
