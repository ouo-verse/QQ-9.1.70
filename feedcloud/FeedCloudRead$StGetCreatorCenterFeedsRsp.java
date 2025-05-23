package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetCreatorCenterFeedsRsp extends MessageMicro<FeedCloudRead$StGetCreatorCenterFeedsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"feeds", "isOver", "totalcount"}, new Object[]{null, 0, 0}, FeedCloudRead$StGetCreatorCenterFeedsRsp.class);
    public final PBRepeatMessageField<FeedCloudMeta$StFeed> feeds = PBField.initRepeatMessage(FeedCloudMeta$StFeed.class);
    public final PBUInt32Field isOver = PBField.initUInt32(0);
    public final PBUInt32Field totalcount = PBField.initUInt32(0);
}
