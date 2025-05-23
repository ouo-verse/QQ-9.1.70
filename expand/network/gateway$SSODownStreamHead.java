package expand.network;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class gateway$SSODownStreamHead extends MessageMicro<gateway$SSODownStreamHead> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"code", "msg"}, new Object[]{0, ""}, gateway$SSODownStreamHead.class);
    public final PBEnumField code = PBField.initEnum(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f397369msg = PBField.initString("");
}
