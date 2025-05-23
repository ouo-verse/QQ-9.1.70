package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$GetWXAppURLRequest extends MessageMicro<INTERFACE$GetWXAppURLRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"code", "codeType"}, new Object[]{"", 0}, INTERFACE$GetWXAppURLRequest.class);
    public final PBStringField code = PBField.initString("");
    public final PBInt32Field codeType = PBField.initInt32(0);
}
