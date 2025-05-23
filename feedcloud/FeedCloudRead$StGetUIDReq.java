package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetUIDReq extends MessageMicro<FeedCloudRead$StGetUIDReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uidScence", "userId"}, new Object[]{0, ""}, FeedCloudRead$StGetUIDReq.class);
    public final PBInt32Field uidScence = PBField.initInt32(0);
    public final PBStringField userId = PBField.initString("");
}
