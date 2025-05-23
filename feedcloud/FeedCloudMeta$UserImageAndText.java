package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$UserImageAndText extends MessageMicro<FeedCloudMeta$UserImageAndText> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"text", "image", QCircleAlphaUserReporter.KEY_USER, QZoneDTLoginReporter.SCHEMA}, new Object[]{"", null, null, ""}, FeedCloudMeta$UserImageAndText.class);
    public final PBStringField text = PBField.initString("");
    public FeedCloudMeta$StImage image = new FeedCloudMeta$StImage();
    public FeedCloudMeta$StUser user = new FeedCloudMeta$StUser();
    public final PBStringField schema = PBField.initString("");
}
