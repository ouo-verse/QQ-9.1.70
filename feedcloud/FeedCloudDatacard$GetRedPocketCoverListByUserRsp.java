package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes28.dex */
public final class FeedCloudDatacard$GetRedPocketCoverListByUserRsp extends MessageMicro<FeedCloudDatacard$GetRedPocketCoverListByUserRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"covers", "number"}, new Object[]{null, null}, FeedCloudDatacard$GetRedPocketCoverListByUserRsp.class);
    public final PBRepeatMessageField<FeedCloudDatacard$RedPocketCoverQQInfo> covers = PBField.initRepeatMessage(FeedCloudDatacard$RedPocketCoverQQInfo.class);
    public FeedCloudDatacard$GetRedPocketNumberRsp number = new FeedCloudDatacard$GetRedPocketNumberRsp();
}
