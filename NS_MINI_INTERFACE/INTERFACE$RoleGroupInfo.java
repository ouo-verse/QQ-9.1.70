package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$RoleGroupInfo extends MessageMicro<INTERFACE$RoleGroupInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"role_id", "role_name", "role_color"}, new Object[]{0L, "", 0L}, INTERFACE$RoleGroupInfo.class);
    public final PBUInt64Field role_id = PBField.initUInt64(0);
    public final PBStringField role_name = PBField.initString("");
    public final PBUInt64Field role_color = PBField.initUInt64(0);
}
