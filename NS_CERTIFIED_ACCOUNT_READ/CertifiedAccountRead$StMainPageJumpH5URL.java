package NS_CERTIFIED_ACCOUNT_READ;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class CertifiedAccountRead$StMainPageJumpH5URL extends MessageMicro<CertifiedAccountRead$StMainPageJumpH5URL> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"pushSetURL", "pushListURL", "editPageURL"}, new Object[]{"", "", ""}, CertifiedAccountRead$StMainPageJumpH5URL.class);
    public final PBStringField pushSetURL = PBField.initString("");
    public final PBStringField pushListURL = PBField.initString("");
    public final PBStringField editPageURL = PBField.initString("");
}
