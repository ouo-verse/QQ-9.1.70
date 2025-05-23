package et2;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0012J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\nH&J\b\u0010\u000e\u001a\u00020\rH&J\b\u0010\u000f\u001a\u00020\nH&J\b\u0010\u0010\u001a\u00020\nH&J\b\u0010\u0011\u001a\u00020\nH&J\b\u0010\u0012\u001a\u00020\nH&J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H&\u00a8\u0006\u0016"}, d2 = {"Let2/c;", "", "Landroid/view/View;", "getView", "Landroid/view/ViewGroup$LayoutParams;", "getLayoutParams", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Let2/c$a;", "callback", "", "d", "destroy", "Let2/b;", "c", "show", "hide", "pause", "a", "", "isMsgSelect", "b", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public interface c {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Let2/c$a;", "", "", "a", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public interface a {
        void a();
    }

    void a();

    void b(boolean isMsgSelect);

    @NotNull
    b c();

    void d(@Nullable com.tencent.aio.api.runtime.a aioContext, @NotNull a callback);

    void destroy();

    @NotNull
    ViewGroup.LayoutParams getLayoutParams();

    @Nullable
    View getView();

    void hide();

    void pause();

    void show();
}
