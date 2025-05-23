package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetFeedDetailRsp extends MessageMicro<FeedCloudRead$StGetFeedDetailRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 58, 66, 72}, new String[]{"extInfo", "detailUrl", "feed", "vecRcmdFeed", "share", "isFinish", "adAttchInfo", "busiRspData", "isFirstLogin"}, new Object[]{null, "", null, null, null, 0, "", ByteStringMicro.EMPTY, Boolean.FALSE}, FeedCloudRead$StGetFeedDetailRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBStringField detailUrl = PBField.initString("");
    public FeedCloudMeta$StFeed feed = new FeedCloudMeta$StFeed();
    public final PBRepeatMessageField<FeedCloudMeta$StFeed> vecRcmdFeed = PBField.initRepeatMessage(FeedCloudMeta$StFeed.class);
    public FeedCloudMeta$StShare share = new FeedCloudMeta$StShare();
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public final PBStringField adAttchInfo = PBField.initString("");
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBoolField isFirstLogin = PBField.initBool(false);
}
