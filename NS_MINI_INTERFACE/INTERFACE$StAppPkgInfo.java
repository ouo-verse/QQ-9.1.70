package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class INTERFACE$StAppPkgInfo extends MessageMicro<INTERFACE$StAppPkgInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"name", "isMultiLogin", "isSupportPay"}, new Object[]{"", 0, 0}, INTERFACE$StAppPkgInfo.class);
    public final PBStringField name = PBField.initString("");
    public final PBInt32Field isMultiLogin = PBField.initInt32(0);
    public final PBInt32Field isSupportPay = PBField.initInt32(0);
}
