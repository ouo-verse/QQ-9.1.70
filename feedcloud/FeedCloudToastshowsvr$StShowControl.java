package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudToastshowsvr$StShowControl extends MessageMicro<FeedCloudToastshowsvr$StShowControl> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"showPageType", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME}, new Object[]{0, null}, FeedCloudToastshowsvr$StShowControl.class);
    public final PBUInt32Field showPageType = PBField.initUInt32(0);
    public FeedCloudToastshowsvr$StShowTime showTime = new FeedCloudToastshowsvr$StShowTime();
}
