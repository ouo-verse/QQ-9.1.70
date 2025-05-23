package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StDoSecurityReq extends MessageMicro<FeedCloudWrite$StDoSecurityReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, 56, 66}, new String[]{"extInfo", "feed", "comment", "reply", "from", QAdVrReport.ElementID.AD_POSTER, "src", QCircleDaTongConstant.ElementParamValue.BARRAGE}, new Object[]{null, null, null, null, 0, null, 0, null}, FeedCloudWrite$StDoSecurityReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public FeedCloudMeta$StFeed feed = new FeedCloudMeta$StFeed();
    public FeedCloudMeta$StComment comment = new FeedCloudMeta$StComment();
    public FeedCloudMeta$StReply reply = new FeedCloudMeta$StReply();
    public final PBInt32Field from = PBField.initInt32(0);
    public FeedCloudMeta$StUser poster = new FeedCloudMeta$StUser();
    public final PBInt32Field src = PBField.initInt32(0);
    public FeedCloudMeta$StBarrage barrage = new FeedCloudMeta$StBarrage();
}
