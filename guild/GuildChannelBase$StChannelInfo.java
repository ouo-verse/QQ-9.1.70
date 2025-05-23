package guild;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GuildChannelBase$StChannelInfo extends MessageMicro<GuildChannelBase$StChannelInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 56, 64, 72}, new String[]{"sign", "name", "icon_url", "private_type", "guild_name", "hot_icon", "hot_index", "move_post_section", "is_square"}, new Object[]{null, "", "", 0, "", "", 0, 0, Boolean.FALSE}, GuildChannelBase$StChannelInfo.class);
    public GuildChannelBase$StChannelSign sign = new GuildChannelBase$StChannelSign();
    public final PBStringField name = PBField.initString("");
    public final PBStringField icon_url = PBField.initString("");
    public final PBEnumField private_type = PBField.initEnum(0);
    public final PBStringField guild_name = PBField.initString("");
    public final PBStringField hot_icon = PBField.initString("");
    public final PBUInt32Field hot_index = PBField.initUInt32(0);
    public final PBUInt32Field move_post_section = PBField.initUInt32(0);
    public final PBBoolField is_square = PBField.initBool(false);
}
