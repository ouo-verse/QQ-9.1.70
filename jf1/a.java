package jf1;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\b\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\b\u0010\u0007\u001a\u00020\u0004H\u0016R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Ljf1/a;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Landroid/view/View;", "view", "", "a", "b", "onGlobalLayout", "Lkotlin/Function1;", "d", "Lkotlin/jvm/functions/Function1;", "listener", "Landroid/view/ViewTreeObserver;", "e", "Landroid/view/ViewTreeObserver;", "viewTreeObserver", "f", "Landroid/view/View;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<View, Unit> listener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewTreeObserver viewTreeObserver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View view;

    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull Function1<? super View, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    public final void a(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.view != null) {
            b();
        }
        this.view = view;
        this.viewTreeObserver = view.getViewTreeObserver();
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    public final void b() {
        ViewTreeObserver viewTreeObserver;
        b.b(this.viewTreeObserver, this);
        View view = this.view;
        if (view != null) {
            viewTreeObserver = view.getViewTreeObserver();
        } else {
            viewTreeObserver = null;
        }
        b.b(viewTreeObserver, this);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        View view = this.view;
        if (view != null) {
            this.listener.invoke(view);
        }
    }
}
