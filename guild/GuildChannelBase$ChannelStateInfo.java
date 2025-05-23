package guild;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GuildChannelBase$ChannelStateInfo extends MessageMicro<GuildChannelBase$ChannelStateInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"state", "priority"}, new Object[]{0, 0}, GuildChannelBase$ChannelStateInfo.class);
    public final PBUInt32Field state = PBField.initUInt32(0);
    public final PBUInt32Field priority = PBField.initUInt32(0);
}
