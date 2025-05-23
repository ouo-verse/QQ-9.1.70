package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* loaded from: classes28.dex */
public final class FeedCloudRead$PopStUserInfo extends MessageMicro<FeedCloudRead$PopStUserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{QCircleAlphaUserReporter.KEY_USER, "desc", "keyword"}, new Object[]{null, "", ""}, FeedCloudRead$PopStUserInfo.class);
    public FeedCloudMeta$StUser user = new FeedCloudMeta$StUser();
    public final PBStringField desc = PBField.initString("");
    public final PBStringField keyword = PBField.initString("");
}
