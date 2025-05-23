package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StDoBarrageReq extends MessageMicro<FeedCloudWrite$StDoBarrageReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40}, new String[]{"extInfo", "barrageType", QCircleDaTongConstant.ElementParamValue.BARRAGE, "feed", "src"}, new Object[]{null, 0, null, null, 0}, FeedCloudWrite$StDoBarrageReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBUInt32Field barrageType = PBField.initUInt32(0);
    public FeedCloudMeta$StBarrage barrage = new FeedCloudMeta$StBarrage();
    public FeedCloudMeta$StFeed feed = new FeedCloudMeta$StFeed();
    public final PBInt32Field src = PBField.initInt32(0);
}
