package guild;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GuildChannelBase$SimpleChannelInfo extends MessageMicro<GuildChannelBase$SimpleChannelInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"channel_id", "name", "hidden_post_channel"}, new Object[]{0L, "", 0}, GuildChannelBase$SimpleChannelInfo.class);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBStringField name = PBField.initString("");
    public final PBUInt32Field hidden_post_channel = PBField.initUInt32(0);
}
