package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetPrePullFeedListForRedTouchReq extends MessageMicro<FeedCloudRead$StGetPrePullFeedListForRedTouchReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"extInfo", "feedRedTouchTrans", "getFeedListReq", "getFeedListReqs"}, new Object[]{null, null, ByteStringMicro.EMPTY, null}, FeedCloudRead$StGetPrePullFeedListForRedTouchReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<FeedCloudMeta$FeedRedTouchTransInfo> feedRedTouchTrans = PBField.initRepeatMessage(FeedCloudMeta$FeedRedTouchTransInfo.class);
    public final PBBytesField getFeedListReq = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<FeedCloudCommon$BytesEntry> getFeedListReqs = PBField.initRepeatMessage(FeedCloudCommon$BytesEntry.class);
}
