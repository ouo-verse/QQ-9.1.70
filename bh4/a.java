package bh4;

import android.view.View;
import com.tencent.luggage.wxa.c8.c;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0007H&J\n\u0010\n\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000bH&\u00a8\u0006\u0010"}, d2 = {"Lbh4/a;", "", "Landroid/view/View;", "getView", "", "destroy", "a", "", "onBackEvent", "d", "b", "", c.G, "onPageSelected", "yesGameId", "g", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public interface a {
    void a();

    @Nullable
    View b();

    boolean d();

    void destroy();

    void g(int yesGameId);

    @NotNull
    View getView();

    boolean onBackEvent();

    void onPageSelected(int pos);
}
