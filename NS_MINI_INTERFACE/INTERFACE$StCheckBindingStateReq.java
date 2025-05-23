package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StCheckBindingStateReq extends MessageMicro<INTERFACE$StCheckBindingStateReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"appId", "uid", "bindType"}, new Object[]{"", "", 0}, INTERFACE$StCheckBindingStateReq.class);
    public final PBStringField appId = PBField.initString("");
    public final PBStringField uid = PBField.initString("");
    public final PBEnumField bindType = PBField.initEnum(0);
}
