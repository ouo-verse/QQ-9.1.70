package com.tencent.biz.subscribe.baseUI;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class b<T> extends a<T> {

    /* renamed from: m, reason: collision with root package name */
    protected int f95715m;

    public b(Context context, boolean z16) {
        super(context, z16);
        this.f95715m = -1;
    }

    @Override // com.tencent.biz.subscribe.baseUI.a
    protected void c() {
        this.f95711e = l();
        o();
    }

    public void k(View view) {
        if (view != null && r()) {
            ((ViewGroup) this.f95711e).addView(view);
        }
    }

    protected abstract View l();

    /* JADX INFO: Access modifiers changed from: protected */
    public View m(int i3) {
        View view = this.f95711e;
        if (view != null) {
            return view.findViewById(i3);
        }
        return null;
    }

    protected abstract int n();

    protected abstract void o();

    public void p(ViewStub viewStub) {
        if (viewStub == null) {
            return;
        }
        int i3 = this.f95715m;
        if (i3 != -1) {
            q(viewStub, i3);
            return;
        }
        viewStub.setLayoutResource(n());
        this.f95711e = viewStub.inflate();
        if (n() == R.layout.bpa) {
            k(l());
        }
        o();
    }

    public void q(ViewStub viewStub, int i3) {
        if (viewStub != null) {
            viewStub.setLayoutResource(i3);
            this.f95711e = viewStub.inflate();
            o();
        }
    }

    protected boolean r() {
        View view = this.f95711e;
        if (view != null && (view instanceof ViewGroup)) {
            return true;
        }
        return false;
    }
}
