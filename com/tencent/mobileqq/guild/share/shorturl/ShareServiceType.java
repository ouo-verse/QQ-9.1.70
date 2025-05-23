package com.tencent.mobileqq.guild.share.shorturl;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/share/shorturl/ShareServiceType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "FEED", "USER_PROFILE_QR", "USER_PROFILE", "GUILD_INVITE", "AUDIO", "LIVE", "SCHEDULE", "HOME", "AI_SHARE", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public enum ShareServiceType {
    FEED(7),
    USER_PROFILE_QR(8),
    USER_PROFILE(9),
    GUILD_INVITE(10),
    AUDIO(11),
    LIVE(12),
    SCHEDULE(13),
    HOME(14),
    AI_SHARE(15);

    private final int type;

    ShareServiceType(int i3) {
        this.type = i3;
    }

    public final int getType() {
        return this.type;
    }
}
