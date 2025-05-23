package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$GuardInstruction extends MessageMicro<INTERFACE$GuardInstruction> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50, 57, 66}, new String[]{"type", "title", "msg", "url", "modal", "data", "ratio", "ruleName"}, new Object[]{0, "", "", "", 0, "", Double.valueOf(0.0d), ""}, INTERFACE$GuardInstruction.class);
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBStringField title = PBField.initString("");

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f24956msg = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBInt32Field modal = PBField.initInt32(0);
    public final PBStringField data = PBField.initString("");
    public final PBDoubleField ratio = PBField.initDouble(0.0d);
    public final PBStringField ruleName = PBField.initString("");
}
