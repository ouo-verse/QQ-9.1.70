package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetPrePullFeedListForRedTouchRsp extends MessageMicro<FeedCloudRead$StGetPrePullFeedListForRedTouchRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"extInfo", "getFeedListRsp", "getFeedListRsps", "shouldNotSendRedDot"}, new Object[]{null, ByteStringMicro.EMPTY, null, Boolean.FALSE}, FeedCloudRead$StGetPrePullFeedListForRedTouchRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBBytesField getFeedListRsp = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<FeedCloudCommon$BytesEntry> getFeedListRsps = PBField.initRepeatMessage(FeedCloudCommon$BytesEntry.class);
    public final PBBoolField shouldNotSendRedDot = PBField.initBool(false);
}
