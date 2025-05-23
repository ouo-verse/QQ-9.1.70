package com.tencent.luggage.wxa.lj;

import android.view.View;
import com.tencent.luggage.wxa.lj.k;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class r implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final View.OnClickListener f133552a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ic.g f133553b;

    public r(View.OnClickListener onClickListener, com.tencent.luggage.wxa.ic.g runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        this.f133552a = onClickListener;
        this.f133553b = runtime;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int b16 = k.b.NONE.b();
        if (this.f133553b.I().f().e()) {
            m c16 = this.f133553b.I().f().c();
            Intrinsics.checkNotNull(c16);
            b16 |= c16.f();
        }
        if (this.f133553b.I().c().b() != Integer.MIN_VALUE) {
            b16 |= k.b(this.f133553b.I().c().b()).b();
        }
        if (this.f133553b.I().g().a() && this.f133553b.I().c().a() != Integer.MIN_VALUE) {
            b16 |= k.a(this.f133553b.I().c().a()).b();
        }
        this.f133553b.g(b16);
        View.OnClickListener onClickListener = this.f133552a;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }
}
