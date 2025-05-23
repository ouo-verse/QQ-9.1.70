package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StRecReason extends MessageMicro<FeedCloudRead$StRecReason> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"textColor", "bgColor", "text"}, new Object[]{"", "", ""}, FeedCloudRead$StRecReason.class);
    public final PBStringField textColor = PBField.initString("");
    public final PBStringField bgColor = PBField.initString("");
    public final PBStringField text = PBField.initString("");
}
