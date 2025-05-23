package com.tencent.mobileqq.guild.widget;

import com.tencent.mobileqq.R;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/GuildStateType;", "", "iconRes", "", "(Ljava/lang/String;II)V", "getIconRes", "()I", "NONE", "VOICE", "SCREEN_SHARE", "LIVE", "VOICE_GAME", "PLAY_TOGETHER", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public enum GuildStateType {
    NONE(0),
    VOICE(R.drawable.guild_aio_title_state_voice),
    SCREEN_SHARE(R.drawable.guild_aio_title_state_screenshare),
    LIVE(R.drawable.guild_aio_title_state_live),
    VOICE_GAME(R.drawable.guild_aio_title_state_game),
    PLAY_TOGETHER(R.drawable.guild_aio_title_state_game);

    private final int iconRes;

    GuildStateType(int i3) {
        this.iconRes = i3;
    }

    public final int getIconRes() {
        return this.iconRes;
    }
}
