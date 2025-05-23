package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class INTERFACE$StFirstPage extends MessageMicro<INTERFACE$StFirstPage> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"pagePath", "subPkgName"}, new Object[]{"", ""}, INTERFACE$StFirstPage.class);
    public final PBStringField pagePath = PBField.initString("");
    public final PBStringField subPkgName = PBField.initString("");
}
