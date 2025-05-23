package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes28.dex */
public final class FeedCloudWrite$StPublishFeedReq extends MessageMicro<FeedCloudWrite$StPublishFeedReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 50, 56}, new String[]{"extInfo", "feed", "busiReqData", "from", "src", "storeFeedExtInfo", "isSilent"}, new Object[]{null, null, ByteStringMicro.EMPTY, 0, 0, null, Boolean.FALSE}, FeedCloudWrite$StPublishFeedReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public FeedCloudMeta$StFeed feed = new FeedCloudMeta$StFeed();
    public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBInt32Field src = PBField.initInt32(0);
    public final PBRepeatMessageField<FeedCloudCommon$Entry> storeFeedExtInfo = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    public final PBBoolField isSilent = PBField.initBool(false);
}
