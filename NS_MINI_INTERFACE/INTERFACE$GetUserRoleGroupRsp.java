package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$GetUserRoleGroupRsp extends MessageMicro<INTERFACE$GetUserRoleGroupRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"roles"}, new Object[]{null}, INTERFACE$GetUserRoleGroupRsp.class);
    public final PBRepeatMessageField<INTERFACE$RoleGroupInfo> roles = PBField.initRepeatMessage(INTERFACE$RoleGroupInfo.class);
}
