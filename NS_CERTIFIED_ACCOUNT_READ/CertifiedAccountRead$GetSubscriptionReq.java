package NS_CERTIFIED_ACCOUNT_READ;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountRead$GetSubscriptionReq extends MessageMicro<CertifiedAccountRead$GetSubscriptionReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uin", "page_id", "page_info"}, new Object[]{0L, 0, ""}, CertifiedAccountRead$GetSubscriptionReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBInt32Field page_id = PBField.initInt32(0);
    public final PBStringField page_info = PBField.initString("");
}
