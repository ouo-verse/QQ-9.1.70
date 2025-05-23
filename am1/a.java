package am1;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\t"}, d2 = {"Lam1/a;", "", "Landroid/view/View;", "input", "", "a", "", "delayMillis", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: am1.a$a, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static final class C0049a {
        public static /* synthetic */ void a(a aVar, long j3, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    j3 = 0;
                }
                aVar.b(j3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showInputMethod");
        }
    }

    void a(@NotNull View input);

    void b(long delayMillis);
}
