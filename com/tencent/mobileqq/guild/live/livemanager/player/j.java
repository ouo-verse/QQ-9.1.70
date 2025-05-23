package com.tencent.mobileqq.guild.live.livemanager.player;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/live/livemanager/player/j;", "", "", "onFirstFrameCome", "", "width", "height", "onVideoSizeChanged", "onError", "onCurrentLoopEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface j {
    void onCurrentLoopEnd();

    void onError();

    void onFirstFrameCome();

    void onVideoSizeChanged(int width, int height);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class a {
        public static void a(@NotNull j jVar) {
        }

        public static void b(@NotNull j jVar) {
        }

        public static void c(@NotNull j jVar, int i3, int i16) {
        }
    }
}
