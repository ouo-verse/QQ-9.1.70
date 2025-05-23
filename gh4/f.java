package gh4;

import android.content.Context;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000bH&J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000bH&J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H&J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000bH&J \u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000bH&J\b\u0010\u001a\u001a\u00020\u0006H&J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0011\u001a\u00020\u0010H&\u00a8\u0006\u001d"}, d2 = {"Lgh4/f;", "Lmm4/a;", "Landroid/content/Context;", "context", "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "param", "", "openExpandHall", "Lgh4/a;", "lifeCycleListener", "V", "Lgh4/e;", "I0", "hall", "K2", "d2", "", "roomId", "Luh4/d;", "p", "z0", "", "errorCode", "", "errorMsg", "P2", "p1", "Lgh4/d;", "V0", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public interface f extends mm4.a {
    @Nullable
    e I0();

    void K2(@NotNull e hall);

    void P2(int errorCode, @NotNull String errorMsg, @NotNull e hall);

    void V(@NotNull a lifeCycleListener);

    @Nullable
    d V0(long roomId);

    void d2(@NotNull e hall);

    void openExpandHall(@NotNull Context context, @NotNull ExpandHallLaunchParam param);

    @Nullable
    uh4.d p(long roomId);

    void p1();

    void z0(long roomId, @NotNull e hall);
}
