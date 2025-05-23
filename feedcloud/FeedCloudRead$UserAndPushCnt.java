package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* loaded from: classes28.dex */
public final class FeedCloudRead$UserAndPushCnt extends MessageMicro<FeedCloudRead$UserAndPushCnt> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{QCircleAlphaUserReporter.KEY_USER, "push_cnt", "is_thanked"}, new Object[]{null, 0, Boolean.FALSE}, FeedCloudRead$UserAndPushCnt.class);
    public FeedCloudMeta$StUser user = new FeedCloudMeta$StUser();
    public final PBInt32Field push_cnt = PBField.initInt32(0);
    public final PBBoolField is_thanked = PBField.initBool(false);
}
