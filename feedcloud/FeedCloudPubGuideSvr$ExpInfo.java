package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudPubGuideSvr$ExpInfo extends MessageMicro<FeedCloudPubGuideSvr$ExpInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"app_id", "exp_id"}, new Object[]{"", ""}, FeedCloudPubGuideSvr$ExpInfo.class);
    public final PBStringField app_id = PBField.initString("");
    public final PBStringField exp_id = PBField.initString("");
}
