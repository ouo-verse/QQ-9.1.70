package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetCloudSealFeedRsp extends MessageMicro<FeedCloudRead$StGetCloudSealFeedRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"extInfo", "sealFeeds", "attachInfo", "sealClientInfo"}, new Object[]{null, null, "", ByteStringMicro.EMPTY}, FeedCloudRead$StGetCloudSealFeedRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<FeedCloudMeta$StFeed> sealFeeds = PBField.initRepeatMessage(FeedCloudMeta$StFeed.class);
    public final PBStringField attachInfo = PBField.initString("");
    public final PBBytesField sealClientInfo = PBField.initBytes(ByteStringMicro.EMPTY);
}
