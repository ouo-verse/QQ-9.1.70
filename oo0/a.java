package oo0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected Context f423245a;

    /* renamed from: b, reason: collision with root package name */
    protected ViewGroup f423246b;

    public a(Context context) {
        this.f423245a = context;
    }

    protected abstract int b();

    public View c() {
        if (this.f423246b == null) {
            ViewGroup viewGroup = (ViewGroup) e(this.f423245a);
            this.f423246b = viewGroup;
            h(viewGroup);
        }
        return this.f423246b;
    }

    public abstract int d();

    protected View e(Context context) {
        return LayoutInflater.from(context).inflate(b(), (ViewGroup) null);
    }

    protected abstract void h(@NonNull ViewGroup viewGroup);

    public void f() {
    }

    public void g() {
    }

    public void i() {
    }
}
