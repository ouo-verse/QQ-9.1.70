package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StDoBarrageRsp extends MessageMicro<FeedCloudWrite$StDoBarrageRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", QCircleDaTongConstant.ElementParamValue.BARRAGE}, new Object[]{null, null}, FeedCloudWrite$StDoBarrageRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public FeedCloudMeta$StBarrage barrage = new FeedCloudMeta$StBarrage();
}
