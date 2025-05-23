package d1;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f392641a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f392642b = false;

    /* renamed from: c, reason: collision with root package name */
    @IdRes
    private int f392643c = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public b(a aVar) {
        this.f392641a = (View) aVar;
    }

    private void a() {
        ViewParent parent = this.f392641a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).dispatchDependentViewsChanged(this.f392641a);
        }
    }

    @IdRes
    public int b() {
        return this.f392643c;
    }

    public boolean c() {
        return this.f392642b;
    }

    public void d(@NonNull Bundle bundle) {
        this.f392642b = bundle.getBoolean("expanded", false);
        this.f392643c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.f392642b) {
            a();
        }
    }

    @NonNull
    public Bundle e() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.f392642b);
        bundle.putInt("expandedComponentIdHint", this.f392643c);
        return bundle;
    }

    public void f(@IdRes int i3) {
        this.f392643c = i3;
    }
}
