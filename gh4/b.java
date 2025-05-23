package gh4;

import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "", "a", "b", "timi-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b {
    public static final int a(@NotNull ExpandHallLaunchParam expandHallLaunchParam) {
        Intrinsics.checkNotNullParameter(expandHallLaunchParam, "<this>");
        int i3 = expandHallLaunchParam.f376301d;
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2) {
            return 2;
        }
        if (i3 != 3) {
            return 1;
        }
        return 4;
    }

    public static final int b(@NotNull ExpandHallLaunchParam expandHallLaunchParam) {
        Intrinsics.checkNotNullParameter(expandHallLaunchParam, "<this>");
        int i3 = expandHallLaunchParam.f376301d;
        if (i3 == 1 || i3 != 2) {
            return 10005;
        }
        return 10004;
    }
}
