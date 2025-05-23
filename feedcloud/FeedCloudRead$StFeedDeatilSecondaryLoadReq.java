package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StFeedDeatilSecondaryLoadReq extends MessageMicro<FeedCloudRead$StFeedDeatilSecondaryLoadReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, new String[]{"feed", "source", "extInfo", "mask"}, new Object[]{null, 0, null, 1}, FeedCloudRead$StFeedDeatilSecondaryLoadReq.class);
    public FeedCloudMeta$StFeed feed = new FeedCloudMeta$StFeed();
    public final PBInt32Field source = PBField.initInt32(0);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatField<Integer> mask = PBField.initRepeat(PBEnumField.__repeatHelper__);
}
