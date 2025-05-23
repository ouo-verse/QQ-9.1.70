package c03;

import com.tencent.cachedrawable.dynamicdrawable.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&J\u001c\u0010\n\u001a\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\bH&J\b\u0010\u000b\u001a\u00020\u0002H&\u00a8\u0006\f"}, d2 = {"Lc03/a;", "", "", "restart", "stop", "Lcom/tencent/cachedrawable/dynamicdrawable/d$a;", "listener", "d", "Lkotlin/Function1;", "block", "setLoadedListener", "destroy", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public interface a {
    void d(@NotNull d.a listener);

    void destroy();

    void restart();

    void setLoadedListener(@NotNull Function1<? super a, Unit> block);

    void stop();
}
