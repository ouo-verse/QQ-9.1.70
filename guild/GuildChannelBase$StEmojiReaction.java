package guild;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GuildChannelBase$StEmojiReaction extends MessageMicro<GuildChannelBase$StEmojiReaction> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField emoji_id = PBField.initString("");
    public final PBUInt64Field emoji_type = PBField.initUInt64(0);
    public final PBUInt64Field cnt = PBField.initUInt64(0);
    public final PBBoolField is_clicked = PBField.initBool(false);
    public final PBBoolField is_default_emoji = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 80008}, new String[]{"emoji_id", "emoji_type", "cnt", "is_clicked", "is_default_emoji"}, new Object[]{"", 0L, 0L, bool, bool}, GuildChannelBase$StEmojiReaction.class);
    }
}
