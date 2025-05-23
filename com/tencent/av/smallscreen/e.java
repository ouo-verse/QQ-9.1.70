package com.tencent.av.smallscreen;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.av.smallscreen.SmallScreenRelativeLayout;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    protected String f74601a;

    /* renamed from: b, reason: collision with root package name */
    protected SmallScreenRelativeLayout f74602b = null;

    /* renamed from: c, reason: collision with root package name */
    protected i f74603c = null;

    /* renamed from: d, reason: collision with root package name */
    protected int f74604d;

    /* renamed from: e, reason: collision with root package name */
    protected int f74605e;

    /* renamed from: f, reason: collision with root package name */
    protected int f74606f;

    public void a(Context context, LayoutInflater layoutInflater, SmallScreenRelativeLayout.a aVar) {
        SmallScreenRelativeLayout smallScreenRelativeLayout = (SmallScreenRelativeLayout) layoutInflater.inflate(this.f74604d, (ViewGroup) null);
        this.f74602b = smallScreenRelativeLayout;
        smallScreenRelativeLayout.i();
        this.f74602b.setFloatListener(aVar);
        this.f74603c = new i(context, this.f74602b);
        this.f74602b.setIsRotateSize(true);
        this.f74602b.setSize(this.f74605e, this.f74606f);
        d(this.f74603c.c());
    }

    public boolean b() {
        return this.f74602b.getVisibility() == 0 && this.f74602b.c();
    }

    public void c() {
        this.f74603c.e();
        this.f74602b.j();
        this.f74603c = null;
        this.f74602b = null;
    }

    public void e(boolean z16, int i3) {
        boolean b16 = b();
        if (!z16) {
            if (b16) {
                this.f74602b.h();
                if (QLog.isDevelopLevel()) {
                    QLog.w(this.f74601a, 4, "showOrHide, hide toast view , tag[" + this.f74601a + "]");
                    return;
                }
                return;
            }
            return;
        }
        if (!this.f74603c.b()) {
            this.f74603c.d();
        }
        if (b16) {
            return;
        }
        this.f74602b.setCurPosition(i3);
        this.f74602b.l();
        if (QLog.isDevelopLevel()) {
            QLog.w(this.f74601a, 4, "showOrHide, show toast view , tag[" + this.f74601a + "]");
        }
    }

    public void f(BaseSmallScreenService baseSmallScreenService) {
        this.f74602b.setSize(this.f74605e, this.f74606f);
        this.f74602b.o();
    }

    public void d(WindowManager.LayoutParams layoutParams) {
        layoutParams.flags = 136;
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams.type = 2038;
        } else {
            layoutParams.type = SmallScreenUtils.H() ? 2005 : 2002;
        }
    }
}
