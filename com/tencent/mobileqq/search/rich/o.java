package com.tencent.mobileqq.search.rich;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class o implements h {

    /* renamed from: d, reason: collision with root package name */
    public f f283774d;

    /* renamed from: e, reason: collision with root package name */
    private RichNodeRootLayout f283775e;

    /* renamed from: f, reason: collision with root package name */
    private View f283776f;

    /* renamed from: h, reason: collision with root package name */
    private View f283777h;

    public o(f fVar, Context context) {
        this.f283774d = fVar;
        a(context);
    }

    public void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.b1v, (ViewGroup) null, false);
        this.f283775e = (RichNodeRootLayout) inflate.findViewById(R.id.root_layout);
        this.f283777h = inflate.findViewById(R.id.bmt);
        View n3 = n(context);
        this.f283776f = n3;
        if (n3 != null) {
            this.f283775e.addView(n3);
        }
    }

    @Override // sn2.c
    public TextView b() {
        return null;
    }

    @Override // sn2.c
    public TextView c() {
        return null;
    }

    @Override // sn2.c
    public TextView d() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.rich.h
    public void destroy() {
        o();
    }

    @Override // sn2.a
    public ImageView f() {
        return null;
    }

    @Override // sn2.c
    public ImageView g() {
        return null;
    }

    @Override // sn2.d
    public final View getView() {
        return this.f283775e;
    }

    @Override // sn2.c
    public View h(String str) {
        return null;
    }

    @Override // com.tencent.mobileqq.search.rich.h
    public f i() {
        return this.f283774d;
    }

    public View j() {
        return this.f283776f;
    }

    @Override // sn2.c
    public TextView k() {
        return null;
    }

    public String l() {
        f i3 = i();
        if (i3 != null) {
            return i3.getData();
        }
        return null;
    }

    public abstract View n(Context context);

    public void o() {
        this.f283774d = null;
        this.f283775e = null;
        this.f283776f = null;
        this.f283777h = null;
    }

    public void p(boolean z16) {
        View view = this.f283777h;
        if (view != null) {
            if (z16) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
        }
    }

    public void m(boolean z16) {
    }
}
