package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$UserAndLikeTips extends MessageMicro<FeedCloudRead$UserAndLikeTips> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{QCircleAlphaUserReporter.KEY_USER, "text", "is_force", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_IS_HIGHLIGHT, "is_thanked"}, new Object[]{null, "", 0, 0, Boolean.FALSE}, FeedCloudRead$UserAndLikeTips.class);
    public FeedCloudMeta$StUser user = new FeedCloudMeta$StUser();
    public final PBStringField text = PBField.initString("");
    public final PBUInt32Field is_force = PBField.initUInt32(0);
    public final PBUInt32Field is_highlight = PBField.initUInt32(0);
    public final PBBoolField is_thanked = PBField.initBool(false);
}
