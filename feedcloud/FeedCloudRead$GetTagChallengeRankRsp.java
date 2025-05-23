package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$GetTagChallengeRankRsp extends MessageMicro<FeedCloudRead$GetTagChallengeRankRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"extInfo", "vecTagChallengeItem", "isFinish", "feedAttchInfo"}, new Object[]{null, null, 0, ""}, FeedCloudRead$GetTagChallengeRankRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<FeedCloudRead$TagChallengeRankItem> vecTagChallengeItem = PBField.initRepeatMessage(FeedCloudRead$TagChallengeRankItem.class);
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public final PBStringField feedAttchInfo = PBField.initString("");
}
