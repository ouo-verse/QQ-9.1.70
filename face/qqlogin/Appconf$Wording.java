package face.qqlogin;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class Appconf$Wording extends MessageMicro<Appconf$Wording> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"serviceType", "Text"}, new Object[]{0, ""}, Appconf$Wording.class);
    public final PBInt32Field serviceType = PBField.initInt32(0);
    public final PBStringField Text = PBField.initString("");
}
