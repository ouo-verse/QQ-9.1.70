package com.tencent.qcircle.cooperation.config.debug;

import android.view.View;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected WeakReference<View> f342440a;

    public WeakReference<View> a() {
        return this.f342440a;
    }

    public abstract int b();

    public abstract String c();

    public abstract String d();

    public abstract String e();

    public void f(View view) {
        this.f342440a = new WeakReference<>(view);
    }

    public abstract void onClick(View view);
}
