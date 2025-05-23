package com.tencent.mobileqq.guild.openentrance;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/openentrance/b;", "", "", "onVideoPlayStart", "d", "", "from", "e", "onFirstFrameCome", "f", "", "illegalState", "hasRunVideoAlphaAnim", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface b {
    void c(boolean illegalState, boolean hasRunVideoAlphaAnim);

    void d();

    void e(@NotNull String from);

    void f();

    void onFirstFrameCome();

    void onVideoPlayStart();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class a {
        public static void b(@NotNull b bVar, @NotNull String from) {
            Intrinsics.checkNotNullParameter(from, "from");
        }

        public static void c(@NotNull b bVar) {
        }

        public static void d(@NotNull b bVar) {
        }

        public static void a(@NotNull b bVar, boolean z16, boolean z17) {
        }
    }
}
