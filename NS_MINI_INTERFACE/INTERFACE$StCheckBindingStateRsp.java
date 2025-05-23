package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StCheckBindingStateRsp extends MessageMicro<INTERFACE$StCheckBindingStateRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"bindingState", "msg"}, new Object[]{0, ""}, INTERFACE$StCheckBindingStateRsp.class);
    public final PBEnumField bindingState = PBField.initEnum(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f24958msg = PBField.initString("");
}
