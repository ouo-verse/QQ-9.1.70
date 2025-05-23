package com.qzone.module.personalitycomponent.coverWidget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityConfig;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public int f48929a = -1;

    /* renamed from: b, reason: collision with root package name */
    protected int f48930b = 0;

    /* renamed from: c, reason: collision with root package name */
    protected int f48931c = 0;

    /* renamed from: d, reason: collision with root package name */
    protected Context f48932d;

    /* renamed from: e, reason: collision with root package name */
    protected Handler f48933e;

    /* renamed from: f, reason: collision with root package name */
    protected int f48934f;

    /* renamed from: g, reason: collision with root package name */
    protected int f48935g;

    public b(Context context, Handler handler) {
        this.f48932d = context;
        this.f48933e = handler;
    }

    public void a() {
        Handler handler = this.f48933e;
        if (handler != null) {
            handler.removeMessages(PersonalityConfig.MSG_REFRESH_WIDGET);
        }
    }

    public abstract String b();

    public abstract View.OnClickListener c();

    public abstract int d();

    public abstract int e();

    public abstract int g();

    public int h(int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == 1073741824) {
            return size;
        }
        int d16 = d();
        this.f48935g = d16;
        return mode == Integer.MIN_VALUE ? Math.min(d16, size) : d16;
    }

    public int i(int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == 1073741824) {
            return size;
        }
        int e16 = e();
        this.f48934f = e16;
        return mode == Integer.MIN_VALUE ? Math.min(e16, size) : e16;
    }

    public boolean j() {
        return false;
    }

    public abstract void l(Canvas canvas);

    public void s() {
        Handler handler = this.f48933e;
        if (handler != null) {
            handler.sendEmptyMessage(PersonalityConfig.MSG_REFRESH_WIDGET);
        }
    }

    public void t() {
        Handler handler = this.f48933e;
        if (handler != null) {
            handler.sendEmptyMessage(PersonalityConfig.MSG_REQUEST_DRAW);
        }
    }

    public abstract void w(Object obj);

    public static b f(Context context, Handler handler, int i3) {
        if (i3 == 1) {
            return new QZoneWidgetLunarController(context, handler);
        }
        if (i3 == 2) {
            return new c(context, handler);
        }
        if (i3 == 3) {
            return new QZoneWidgetFlowerController(context, handler);
        }
        if (i3 == 4) {
            return new j(context, handler);
        }
        if (i3 != 1000) {
            return new QZoneWidgetWeatherController(context, handler);
        }
        return new QZoneWidgetQZoneVipController(context, handler);
    }

    public void k() {
    }

    public void m(String str) {
    }

    public void n() {
    }

    public void o() {
    }

    public void p() {
    }

    public void q() {
    }

    public void r() {
    }

    public void u() {
    }

    public void v(Drawable.Callback callback) {
    }
}
