package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StRecReasonInfo extends MessageMicro<FeedCloudRead$StRecReasonInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"uid", "reason"}, new Object[]{"", null}, FeedCloudRead$StRecReasonInfo.class);
    public final PBStringField uid = PBField.initString("");
    public FeedCloudRead$StRecReason reason = new FeedCloudRead$StRecReason();
}
