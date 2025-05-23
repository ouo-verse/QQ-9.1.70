package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StSearchKuikly extends MessageMicro<FeedCloudRead$StSearchKuikly> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"page_name", "bundle_name", "ext", "high", "business_id"}, new Object[]{"", "", "", 0, ""}, FeedCloudRead$StSearchKuikly.class);
    public final PBStringField page_name = PBField.initString("");
    public final PBStringField bundle_name = PBField.initString("");
    public final PBStringField ext = PBField.initString("");
    public final PBInt32Field high = PBField.initInt32(0);
    public final PBStringField business_id = PBField.initString("");
}
