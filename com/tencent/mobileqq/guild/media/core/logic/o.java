package com.tencent.mobileqq.guild.media.core.logic;

import com.tencent.live2.impl.V2TXLiveDefInner;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\"\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\rH&J\b\u0010\u0012\u001a\u00020\rH&J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\rH&J\"\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J2\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0002H&\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/o;", "", "", "enable", "Lcom/tencent/mobileqq/guild/media/core/i;", "cb", "", "i", "isMute", "c", "g", "", "userId", "", "volumeToMe", tl.h.F, "route", V2TXLiveDefInner.TXLivePropertyKey.kV2SetAudioRoute, "getAudioRoute", "modeType", "b", "tinyId", "bVoiceless", "e", "", "guildId", "channelId", "bAllow", "f", "audioIsOpen", "d", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface o {
    void b(int modeType);

    void c(boolean enable, boolean isMute, @Nullable com.tencent.mobileqq.guild.media.core.i cb5);

    void d(boolean audioIsOpen);

    void e(@NotNull String tinyId, boolean bVoiceless, @Nullable com.tencent.mobileqq.guild.media.core.i cb5);

    void f(long guildId, long channelId, long tinyId, boolean bAllow, @Nullable com.tencent.mobileqq.guild.media.core.i cb5);

    void g(boolean enable);

    int getAudioRoute();

    void h(@NotNull String userId, int volumeToMe);

    void i(boolean enable, @Nullable com.tencent.mobileqq.guild.media.core.i cb5);

    void setAudioRoute(int route);
}
