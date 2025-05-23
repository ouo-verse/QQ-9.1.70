package ln4;

import com.tencent.timi.game.utils.IResultListener;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J&\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0014\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n0\tH&\u00a8\u0006\u000e"}, d2 = {"Lln4/b;", "", "Lln4/a;", "listener", "", "a", "c", "", "groupId", "Lcom/tencent/timi/game/utils/IResultListener;", "", "Lln4/c;", "callback", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public interface b {
    void a(@Nullable a listener);

    void b(long groupId, @NotNull IResultListener<List<c>> callback);

    void c(@Nullable a listener);
}
