package com.qzone.component.banner;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Message;
import android.util.AttributeSet;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class Banner extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    protected a f46296d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f46297e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f46298f;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface a {
        boolean a(boolean z16, int i3, int i16);
    }

    public Banner(Context context) {
        super(context);
        this.f46297e = false;
        this.f46298f = false;
    }

    public boolean c() {
        a aVar = this.f46296d;
        return aVar != null && aVar.a(true, e(), d());
    }

    public abstract int d();

    public abstract int e();

    public void g() {
        a aVar = this.f46296d;
        if (aVar != null) {
            aVar.a(false, e(), d());
        }
    }

    public abstract void h(ViewStub viewStub);

    public abstract void i(boolean z16);

    public boolean j() {
        return true;
    }

    public boolean k() {
        return false;
    }

    public abstract boolean l();

    public void setDefaultLayoutParams() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ap8)));
    }

    public void setOnDisplayListener(a aVar) {
        this.f46296d = aVar;
    }

    public abstract void t(com.qzone.feed.business.model.a aVar);

    public Banner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f46297e = false;
        this.f46298f = false;
    }

    public void destroy() {
    }

    public void f(Message message) {
    }

    public void n(Configuration configuration) {
    }

    public void o(boolean z16) {
    }

    public void p() {
    }

    public void q() {
    }

    public void r() {
    }

    public void s(int i3) {
    }

    public void m(int i3, int i16, Intent intent) {
    }
}
