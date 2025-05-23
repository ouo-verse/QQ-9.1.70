package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StHelperInfo extends MessageMicro<FeedCloudRead$StHelperInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{QCircleAlphaUserReporter.KEY_USER, "rocketNum"}, new Object[]{null, 0}, FeedCloudRead$StHelperInfo.class);
    public FeedCloudMeta$StUser user = new FeedCloudMeta$StUser();
    public final PBInt32Field rocketNum = PBField.initInt32(0);
}
