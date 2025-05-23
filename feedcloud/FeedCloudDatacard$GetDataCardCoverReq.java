package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudDatacard$GetDataCardCoverReq extends MessageMicro<FeedCloudDatacard$GetDataCardCoverReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"user_id", "device_info", "qua"}, new Object[]{"", "", ""}, FeedCloudDatacard$GetDataCardCoverReq.class);
    public final PBStringField user_id = PBField.initString("");
    public final PBStringField device_info = PBField.initString("");
    public final PBStringField qua = PBField.initString("");
}
