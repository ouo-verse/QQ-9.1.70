package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes28.dex */
public final class FeedCloudRead$GetHotTagRankPageRsp extends MessageMicro<FeedCloudRead$GetHotTagRankPageRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"extInfo", "items", "isFinish", "feedAttachInfo"}, new Object[]{null, null, 0, ""}, FeedCloudRead$GetHotTagRankPageRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<FeedCloudRead$HotTagRankItem> items = PBField.initRepeatMessage(FeedCloudRead$HotTagRankItem.class);
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public final PBStringField feedAttachInfo = PBField.initString("");
}
