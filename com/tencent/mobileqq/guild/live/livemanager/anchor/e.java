package com.tencent.mobileqq.guild.live.livemanager.anchor;

import kotlin.Metadata;
import nf4.j;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J&\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&R\u0014\u0010\u0013\u001a\u00020\u00108&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00148&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/live/livemanager/anchor/e;", "Lcom/tencent/mobileqq/guild/live/livemanager/anchor/d;", "Lof4/a;", "cb", "", "c", "Lcom/tencent/mobileqq/guild/live/livemanager/anchor/b;", "gameLiveStartParams", "Lnf4/a;", "Lnf4/j;", "Lef4/a;", "loadingCb", "b", "Lkf4/a;", "guildIDInfo", h.F, "Lnf4/h;", "f", "()Lnf4/h;", "yesLiveApi", "", "a", "()Ljava/lang/String;", "openLiveChannelSchema", "i", "openLiveChannelShareSchema", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface e extends d {
    @NotNull
    String a();

    void b(@NotNull GameLiveStartParams gameLiveStartParams, @NotNull nf4.a<j> cb5, @NotNull ef4.a loadingCb);

    void c(@NotNull of4.a cb5);

    @NotNull
    nf4.h f();

    void h(@NotNull kf4.a guildIDInfo);

    @NotNull
    String i();
}
