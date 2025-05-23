package jf1;

import android.view.View;
import android.view.ViewTreeObserver;
import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u0006B\u0019\b\u0002\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\r\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Ljf1/c;", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "Landroid/view/View$OnAttachStateChangeListener;", "", "onPreDraw", "", "a", "Landroid/view/View;", "v", "onViewAttachedToWindow", "onViewDetachedFromWindow", "d", "Landroid/view/View;", "fromView", "e", "toView", "Landroid/view/ViewTreeObserver;", "f", "Landroid/view/ViewTreeObserver;", "mViewTreeObserver", "", h.F, UserInfo.SEX_FEMALE, "latestTranslationY", "<init>", "(Landroid/view/View;Landroid/view/View;)V", "i", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View fromView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View toView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ViewTreeObserver mViewTreeObserver;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float latestTranslationY;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Ljf1/c$a;", "", "Landroid/view/View;", "from", "to", "Ljf1/c;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: jf1.c$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final c a(@NotNull View from, @NotNull View to5) {
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(to5, "to");
            c cVar = new c(from, to5, null);
            from.getViewTreeObserver().addOnPreDrawListener(cVar);
            from.addOnAttachStateChangeListener(cVar);
            return cVar;
        }

        Companion() {
        }
    }

    public /* synthetic */ c(View view, View view2, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, view2);
    }

    public final void a() {
        if (this.mViewTreeObserver.isAlive()) {
            this.mViewTreeObserver.removeOnPreDrawListener(this);
        } else {
            this.fromView.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.fromView.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        boolean z16;
        float translationY = this.fromView.getTranslationY();
        if (this.latestTranslationY == translationY) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            this.latestTranslationY = translationY;
            this.toView.setTranslationY(translationY);
        }
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(@NotNull View v3) {
        Intrinsics.checkNotNullParameter(v3, "v");
        ViewTreeObserver viewTreeObserver = v3.getViewTreeObserver();
        Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "v.viewTreeObserver");
        this.mViewTreeObserver = viewTreeObserver;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(@NotNull View v3) {
        Intrinsics.checkNotNullParameter(v3, "v");
        a();
    }

    c(View view, View view2) {
        this.fromView = view;
        this.toView = view2;
        this.latestTranslationY = view.getTranslationY();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "fromView.viewTreeObserver");
        this.mViewTreeObserver = viewTreeObserver;
    }
}
