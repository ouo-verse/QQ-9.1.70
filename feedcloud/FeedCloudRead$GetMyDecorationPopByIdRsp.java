package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* loaded from: classes28.dex */
public final class FeedCloudRead$GetMyDecorationPopByIdRsp extends MessageMicro<FeedCloudRead$GetMyDecorationPopByIdRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{QCircleAlphaUserReporter.KEY_USER, "pendantDialog", "popInfo"}, new Object[]{null, null, 0}, FeedCloudRead$GetMyDecorationPopByIdRsp.class);
    public FeedCloudMeta$StUser user = new FeedCloudMeta$StUser();
    public FeedCloudMeta$CovenantLiteDialog pendantDialog = new FeedCloudMeta$CovenantLiteDialog();
    public final PBInt32Field popInfo = PBField.initInt32(0);
}
