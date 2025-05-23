package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes28.dex */
public final class FeedCloudDatacard$GetRedPocketCoverListByIDsRsp extends MessageMicro<FeedCloudDatacard$GetRedPocketCoverListByIDsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"covers"}, new Object[]{null}, FeedCloudDatacard$GetRedPocketCoverListByIDsRsp.class);
    public final PBRepeatMessageField<FeedCloudDatacard$RedPocketCoverQQInfo> covers = PBField.initRepeatMessage(FeedCloudDatacard$RedPocketCoverQQInfo.class);
}
