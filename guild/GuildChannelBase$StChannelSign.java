package guild;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GuildChannelBase$StChannelSign extends MessageMicro<GuildChannelBase$StChannelSign> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 48}, new String[]{"guild_id", "channel_id", "url", "join_guild_sig", "channel_type"}, new Object[]{0L, 0L, "", ByteStringMicro.EMPTY, 0}, GuildChannelBase$StChannelSign.class);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBStringField url = PBField.initString("");
    public final PBBytesField join_guild_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field channel_type = PBField.initUInt32(0);
}
