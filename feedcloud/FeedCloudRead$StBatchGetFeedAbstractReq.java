package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StBatchGetFeedAbstractReq extends MessageMicro<FeedCloudRead$StBatchGetFeedAbstractReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42}, new String[]{"feedIndex", "mask", "source", "extInfo", "readControll"}, new Object[]{null, 1, 0, null, null}, FeedCloudRead$StBatchGetFeedAbstractReq.class);
    public final PBRepeatMessageField<FeedCloudMeta$StFeedAbstract> feedIndex = PBField.initRepeatMessage(FeedCloudMeta$StFeedAbstract.class);
    public final PBRepeatField<Integer> mask = PBField.initRepeat(PBEnumField.__repeatHelper__);
    public final PBInt32Field source = PBField.initInt32(0);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public FeedCloudRead$StReadControll readControll = new FeedCloudRead$StReadControll();
}
