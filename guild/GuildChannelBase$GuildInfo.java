package guild;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GuildChannelBase$GuildInfo extends MessageMicro<GuildChannelBase$GuildInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"guild_id", "name", "join_time"}, new Object[]{0L, "", 0L}, GuildChannelBase$GuildInfo.class);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBStringField name = PBField.initString("");
    public final PBUInt64Field join_time = PBField.initUInt64(0);
}
