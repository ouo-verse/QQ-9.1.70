package com.tencent.mobileqq.guild.live.livemanager.player;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J6\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bH&J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0011\u001a\u00020\u000eH&J\u001a\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/live/livemanager/player/l;", "", "", "streamUrl", "Lcom/tencent/mobileqq/guild/live/livemanager/player/GuildLivePlayerTag;", "playerTag", "", "scaleType", "", "isMute", "isUseTexture", "Landroid/view/View;", "c", "isLoop", "", "a", "b", "e", "Lcom/tencent/mobileqq/guild/live/livemanager/player/j;", "listener", "d", "f", "g", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface l {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class a {
        public static /* synthetic */ View a(l lVar, String str, GuildLivePlayerTag guildLivePlayerTag, int i3, boolean z16, boolean z17, int i16, Object obj) {
            int i17;
            boolean z18;
            boolean z19;
            if (obj == null) {
                if ((i16 & 4) != 0) {
                    i17 = 0;
                } else {
                    i17 = i3;
                }
                if ((i16 & 8) != 0) {
                    z18 = false;
                } else {
                    z18 = z16;
                }
                if ((i16 & 16) != 0) {
                    z19 = false;
                } else {
                    z19 = z17;
                }
                return lVar.c(str, guildLivePlayerTag, i17, z18, z19);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createAndPlay");
        }
    }

    void a(boolean isLoop, @NotNull GuildLivePlayerTag playerTag);

    void b(@NotNull GuildLivePlayerTag playerTag);

    @NotNull
    View c(@NotNull String streamUrl, @NotNull GuildLivePlayerTag playerTag, int scaleType, boolean isMute, boolean isUseTexture);

    void d(@NotNull GuildLivePlayerTag playerTag, @Nullable j listener);

    void e();

    boolean f(@NotNull GuildLivePlayerTag playerTag);

    boolean g(@NotNull GuildLivePlayerTag playerTag);
}
