package bb2;

import android.view.MotionEvent;
import android.view.View;
import da2.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003J\b\u0010\u0005\u001a\u00020\u0004H&J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\b\u0010\tJ'\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016\u00a8\u0006\u0013"}, d2 = {"Lbb2/d;", "Lda2/b;", "T", "", "Landroid/view/View;", "d", "markerItemData", "", "g", "(Lda2/b;)V", "clickedData", "Lcom/tencent/mobileqq/nearbypro/part/a;", "host", "Landroid/view/MotionEvent;", "clickEvent", "e", "(Lda2/b;Lcom/tencent/mobileqq/nearbypro/part/a;Landroid/view/MotionEvent;)V", "f", h.F, "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface d<T extends da2.b> {
    @NotNull
    View d();

    void e(@NotNull T clickedData, @NotNull com.tencent.mobileqq.nearbypro.part.a host, @NotNull MotionEvent clickEvent);

    void f(@NotNull com.tencent.mobileqq.nearbypro.part.a host);

    void g(@NotNull T markerItemData);

    void h();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class a {
        public static <T extends da2.b> void a(@NotNull d<T> dVar, @NotNull com.tencent.mobileqq.nearbypro.part.a host) {
            Intrinsics.checkNotNullParameter(host, "host");
        }

        public static <T extends da2.b> void c(@NotNull d<T> dVar, @NotNull T clickedData, @NotNull com.tencent.mobileqq.nearbypro.part.a host, @NotNull MotionEvent clickEvent) {
            Intrinsics.checkNotNullParameter(clickedData, "clickedData");
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(clickEvent, "clickEvent");
        }

        public static <T extends da2.b> void b(@NotNull d<T> dVar) {
        }
    }
}
