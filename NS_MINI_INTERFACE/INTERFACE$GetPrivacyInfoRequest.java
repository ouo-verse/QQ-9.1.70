package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class INTERFACE$GetPrivacyInfoRequest extends MessageMicro<INTERFACE$GetPrivacyInfoRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"appid", "privacy_api"}, new Object[]{"", ""}, INTERFACE$GetPrivacyInfoRequest.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField privacy_api = PBField.initString("");
}
