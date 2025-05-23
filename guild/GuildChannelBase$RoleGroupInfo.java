package guild;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GuildChannelBase$RoleGroupInfo extends MessageMicro<GuildChannelBase$RoleGroupInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"role_id", "name", "color"}, new Object[]{0L, "", 0}, GuildChannelBase$RoleGroupInfo.class);
    public final PBUInt64Field role_id = PBField.initUInt64(0);
    public final PBStringField name = PBField.initString("");
    public final PBUInt32Field color = PBField.initUInt32(0);
}
