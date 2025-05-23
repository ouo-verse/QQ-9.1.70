package com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/ecommerce/card/view/g;", "", "", "onEnterRoom", "b", "Lbj4/a;", "vm", "setCardViewModel", "Ldj4/a;", "product", "c", "", "type", "", "pushMsg", "a", "onActivityCreate", "onActivityResume", "onActivityStop", "onActivityDestroy", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public interface g {
    void a(int type, @NotNull String pushMsg);

    void b();

    void c(@Nullable dj4.a product);

    void onActivityCreate();

    void onActivityDestroy();

    void onActivityResume();

    void onActivityStop();

    void onEnterRoom();

    void setCardViewModel(@NotNull bj4.a vm5);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes26.dex */
    public static final class a {
        public static void h(@NotNull g gVar, int i3, @NotNull String pushMsg) {
            Intrinsics.checkNotNullParameter(pushMsg, "pushMsg");
        }

        public static void a(@NotNull g gVar) {
        }

        public static void b(@NotNull g gVar) {
        }

        public static void c(@NotNull g gVar) {
        }

        public static void d(@NotNull g gVar) {
        }

        public static void e(@NotNull g gVar) {
        }

        public static void f(@NotNull g gVar) {
        }

        public static void g(@NotNull g gVar) {
        }

        public static void i(@NotNull g gVar, @Nullable dj4.a aVar) {
        }
    }
}
