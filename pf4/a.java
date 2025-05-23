package pf4;

import android.app.Activity;
import com.tencent.timi.game.api.live.playtogether.PlayTogetherStatus;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\u000eH'J\b\u0010\u0010\u001a\u00020\u0004H&\u00a8\u0006\u0011"}, d2 = {"Lpf4/a;", "", "Lpf4/e;", "l", "", "a", "b", "Landroid/app/Activity;", "ctx", "Lpf4/b;", "playTogetherPanelListener", "d", "Lpf4/h;", "c", "", "e", "destroy", "timi-game-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public interface a {
    void a(@NotNull e l3);

    void b(@NotNull e l3);

    @NotNull
    PlayTogetherTeamInfo c();

    void d(@NotNull Activity ctx, @Nullable b playTogetherPanelListener);

    void destroy();

    @PlayTogetherStatus
    int e();
}
