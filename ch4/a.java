package ch4;

import android.graphics.Rect;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0002H&J\b\u0010\t\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\u0006H&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\r\u001a\u00020\u0006H&J\b\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0011\u001a\u00020\u0010H&\u00a8\u0006\u0012"}, d2 = {"Lch4/a;", "", "", "keyword", "", "withHeightAnim", "", "f", "j", "updateUI", "e", "", "getState", "i", "", tl.h.F, "Landroid/graphics/Rect;", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: ch4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C0193a {
        public static /* synthetic */ void a(a aVar, String str, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = true;
                }
                aVar.f(str, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doSearch");
        }
    }

    @NotNull
    Rect c();

    void e();

    void f(@NotNull String keyword, boolean withHeightAnim);

    long getState();

    int h();

    void i();

    @NotNull
    String j();

    void updateUI();
}
