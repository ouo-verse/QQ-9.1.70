package aw1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import aw1.k;

/* compiled from: P */
/* loaded from: classes14.dex */
public abstract class a<DATA> {

    /* renamed from: a, reason: collision with root package name */
    protected View f27041a;

    /* renamed from: b, reason: collision with root package name */
    protected k.a f27042b;

    public abstract void a(DATA data);

    public abstract void b();

    public View c(ViewGroup viewGroup) {
        this.f27041a = LayoutInflater.from(viewGroup.getContext()).inflate(e(), (ViewGroup) null);
        b();
        return this.f27041a;
    }

    @IdRes
    public abstract int d();

    @LayoutRes
    protected abstract int e();

    public void f(k.a aVar) {
        this.f27042b = aVar;
    }
}
