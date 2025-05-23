package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class INTERFACE$StPublicAccount extends MessageMicro<INTERFACE$StPublicAccount> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"id", "name", "icon", "desc"}, new Object[]{"", "", "", ""}, INTERFACE$StPublicAccount.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f24966id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
}
