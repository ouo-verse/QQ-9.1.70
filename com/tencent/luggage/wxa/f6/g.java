package com.tencent.luggage.wxa.f6;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.Display;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.f6.e;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mm.plugin.appbrand.platform.window.activity.WindowAndroidActivityImpl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g extends WindowAndroidActivityImpl {

    /* renamed from: k, reason: collision with root package name */
    public final Point f125392k;

    /* renamed from: l, reason: collision with root package name */
    public final int f125393l;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Display f125394a;

        public a(Display display) {
            this.f125394a = display;
        }

        @Override // com.tencent.luggage.wxa.f6.e.c
        public final DisplayMetrics a(DisplayMetrics displayMetrics, Configuration configuration) {
            Intrinsics.checkNotNullParameter(displayMetrics, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(configuration, "<anonymous parameter 1>");
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            this.f125394a.getMetrics(displayMetrics2);
            return displayMetrics2;
        }
    }

    public g(Point point, int i3, Context context) {
        this.f125392k = point;
        this.f125393l = i3;
        if (context == null) {
            if (i3 != 0) {
                DisplayManager displayManager = (DisplayManager) ContextCompat.getSystemService(z.c(), DisplayManager.class);
                Display display = displayManager != null ? displayManager.getDisplay(i3) : null;
                if (display != null) {
                    context = new e(z.c(), new a(display));
                } else {
                    context = z.c();
                }
            } else {
                context = z.c();
            }
        }
        com.tencent.luggage.wxa.mo.e eVar = (com.tencent.luggage.wxa.mo.e) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.mo.e.class);
        if (eVar != null) {
            Intrinsics.checkNotNull(context);
            ContextThemeWrapper b16 = eVar.b(context);
            if (b16 != null) {
                context = b16;
            }
        }
        a(j.a(context));
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.activity.WindowAndroidActivityImpl, com.tencent.luggage.wxa.wj.c
    public DisplayMetrics getVDisplayMetrics() {
        Display display;
        Point point = this.f125392k;
        if (point != null && point.x > 0 && point.y > 0) {
            DisplayMetrics dm5 = super.getVDisplayMetrics();
            Point point2 = this.f125392k;
            dm5.widthPixels = point2.x;
            dm5.heightPixels = point2.y;
            Intrinsics.checkNotNullExpressionValue(dm5, "dm");
            return dm5;
        }
        if (this.f125393l != 0) {
            Context c16 = z.c();
            Intrinsics.checkNotNullExpressionValue(c16, "getContext()");
            DisplayManager displayManager = (DisplayManager) ContextCompat.getSystemService(c16, DisplayManager.class);
            if (displayManager != null) {
                display = displayManager.getDisplay(this.f125393l);
            } else {
                display = null;
            }
            if (display != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                display.getMetrics(displayMetrics);
                return displayMetrics;
            }
            DisplayMetrics vDisplayMetrics = super.getVDisplayMetrics();
            Intrinsics.checkNotNullExpressionValue(vDisplayMetrics, "super.getVDisplayMetrics()");
            return vDisplayMetrics;
        }
        DisplayMetrics vDisplayMetrics2 = super.getVDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(vDisplayMetrics2, "super.getVDisplayMetrics()");
        return vDisplayMetrics2;
    }

    public final Point t() {
        return this.f125392k;
    }

    public /* synthetic */ g(Point point, int i3, Context context, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? null : point, (i16 & 2) != 0 ? 0 : i3, (i16 & 4) != 0 ? null : context);
    }
}
