package com.tencent.icgame.game.liveroom.impl.room.toparea;

import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u0012\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/toparea/a;", "", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveFollowCallback;", "callback", "", "b", "preload", "", "needReport", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.icgame.game.liveroom.impl.room.toparea.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C5841a {
        public static /* synthetic */ void a(a aVar, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    z16 = true;
                }
                aVar.a(z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleFollowState");
        }

        public static boolean b(@NotNull a aVar) {
            return true;
        }

        public static boolean c(@NotNull a aVar) {
            return true;
        }

        public static boolean d(@NotNull a aVar) {
            return false;
        }
    }

    void a(boolean needReport);

    void b(@Nullable IQQLiveFollowCallback callback);

    void preload();
}
