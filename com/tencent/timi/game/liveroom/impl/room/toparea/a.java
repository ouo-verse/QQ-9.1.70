package com.tencent.timi.game.liveroom.impl.room.toparea;

import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\t\u001a\u00020\u0007H&J\u0012\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\nH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/toparea/a;", "", "", "roomId", "anchorId", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveFollowCallback;", "callback", "", "c", "preload", "", "needReport", "a", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.toparea.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C9953a {
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
            return true;
        }

        public static boolean e(@NotNull a aVar) {
            return true;
        }

        public static boolean f(@NotNull a aVar) {
            return false;
        }
    }

    void a(boolean needReport);

    boolean b();

    void c(long roomId, long anchorId, @Nullable IQQLiveFollowCallback callback);

    void preload();
}
