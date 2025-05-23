package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetFeedListRsp extends MessageMicro<FeedCloudRead$StGetFeedListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50, 58, 64, 74}, new String[]{"extInfo", "vecFeed", "isFinish", QCircleAlphaUserReporter.KEY_USER, "adAttchInfo", "feedAttchInfo", "busiRspData", "isFirstLogin", "load_more_status"}, new Object[]{null, null, 0, null, "", "", ByteStringMicro.EMPTY, Boolean.FALSE, null}, FeedCloudRead$StGetFeedListRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<FeedCloudMeta$StFeed> vecFeed = PBField.initRepeatMessage(FeedCloudMeta$StFeed.class);
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public FeedCloudMeta$StUser user = new FeedCloudMeta$StUser();
    public final PBStringField adAttchInfo = PBField.initString("");
    public final PBStringField feedAttchInfo = PBField.initString("");
    public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBoolField isFirstLogin = PBField.initBool(false);
    public FeedCloudRead$LoadMoreFeedStatus load_more_status = new FeedCloudRead$LoadMoreFeedStatus();
}
