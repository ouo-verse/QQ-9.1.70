package NS_MINI_INTERFACE;

import com.tencent.mobileqq.mini.servlet.MiniAppGetPrivacyDetailServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class INTERFACE$PrivacyInfo extends MessageMicro<INTERFACE$PrivacyInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"name", "url", MiniAppGetPrivacyDetailServlet.KEY_AUTHORITY_NAME, MiniAppGetPrivacyDetailServlet.KEY_SERVICE_TERMS_NAME, MiniAppGetPrivacyDetailServlet.KEY_SERVICE_TERMS_URL}, new Object[]{"", "", "", "", ""}, INTERFACE$PrivacyInfo.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBStringField authority = PBField.initString("");
    public final PBStringField service_terms_name = PBField.initString("");
    public final PBStringField service_terms_url = PBField.initString("");
}
