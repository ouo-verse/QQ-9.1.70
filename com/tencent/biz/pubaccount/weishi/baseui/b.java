package com.tencent.biz.pubaccount.weishi.baseui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi.util.x;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class b<T> extends AbsWsUI<T> {

    /* renamed from: m, reason: collision with root package name */
    protected int f80418m;

    public b(Context context) {
        super(context);
        this.f80418m = 1;
    }

    public View p(int i3) {
        View view = this.f80410e;
        if (view != null) {
            return view.findViewById(i3);
        }
        return null;
    }

    protected abstract int q();

    public void r(ViewStub viewStub) {
        viewStub.setLayoutResource(q());
        this.f80410e = viewStub.inflate();
        s();
    }

    protected abstract void s();

    protected boolean t() {
        View view = this.f80410e;
        return view != null && (view instanceof ViewGroup);
    }

    public void o(View view) {
        if (view != null && t()) {
            ((ViewGroup) this.f80410e).addView(view);
            return;
        }
        x.f("AbsWsUIGroup", view + " is not a viewGroup");
    }
}
