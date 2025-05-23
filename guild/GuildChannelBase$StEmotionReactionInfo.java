package guild;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GuildChannelBase$StEmotionReactionInfo extends MessageMicro<GuildChannelBase$StEmotionReactionInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"id", "emoji_reaction_list", "total_like_count"}, new Object[]{"", null, 0L}, GuildChannelBase$StEmotionReactionInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f403412id = PBField.initString("");
    public final PBRepeatMessageField<GuildChannelBase$StEmojiReaction> emoji_reaction_list = PBField.initRepeatMessage(GuildChannelBase$StEmojiReaction.class);
    public final PBUInt64Field total_like_count = PBField.initUInt64(0);
}
