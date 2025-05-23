package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$GetUserRoleGroupReq extends MessageMicro<INTERFACE$GetUserRoleGroupReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"guild_openid"}, new Object[]{""}, INTERFACE$GetUserRoleGroupReq.class);
    public final PBStringField guild_openid = PBField.initString("");
}
