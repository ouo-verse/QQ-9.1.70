package com.tencent.luggage.wxa.uk;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.view.WindowMetrics;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public static final b0 f142653a = new b0();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f142654a;

        /* renamed from: b, reason: collision with root package name */
        public final int f142655b;

        public a(int i3, int i16) {
            this.f142654a = i3;
            this.f142655b = i16;
        }

        public final int a() {
            return this.f142655b;
        }

        public final int b() {
            return this.f142654a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f142654a == aVar.f142654a && this.f142655b == aVar.f142655b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f142654a * 31) + this.f142655b;
        }

        public String toString() {
            return "Size(width=" + this.f142654a + ", height=" + this.f142655b + ')';
        }
    }

    public static final boolean a(Context ctx, int i3, int i16) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        DisplayMetrics displayMetrics = ctx.getResources().getDisplayMetrics();
        return (ctx.getResources().getConfiguration().screenLayout & 15) >= 3 && Math.sqrt(Math.pow((double) (((float) i3) / displayMetrics.xdpi), 2.0d) + Math.pow((double) (((float) i16) / displayMetrics.ydpi), 2.0d)) >= 7.5d;
    }

    public static final boolean b(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        a a16 = a(ctx);
        DisplayMetrics displayMetrics = ctx.getResources().getDisplayMetrics();
        double sqrt = Math.sqrt(Math.pow(a16.b() / displayMetrics.xdpi, 2.0d) + Math.pow(a16.a() / displayMetrics.ydpi, 2.0d));
        if ((ctx.getResources().getConfiguration().screenLayout & 15) >= 3 && sqrt >= 7.0d) {
            return true;
        }
        return false;
    }

    public static final boolean c(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        a a16 = a(ctx);
        return a(ctx, a16.b(), a16.a());
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
    
        r3 = r0.getCurrentWindowMetrics();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
    
        r3 = r3.getBounds();
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
    
        r2 = r0.getCurrentWindowMetrics();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0018, code lost:
    
        r2 = r2.getBounds();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final a a(Context context) {
        int i3;
        Display defaultDisplay;
        WindowMetrics currentWindowMetrics;
        Rect bounds;
        WindowMetrics currentWindowMetrics2;
        Rect bounds2;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (Build.VERSION.SDK_INT >= 30) {
            int i16 = 0;
            int width = (windowManager == null || currentWindowMetrics2 == null || bounds2 == null) ? 0 : bounds2.width();
            if (windowManager != null && currentWindowMetrics != null && bounds != null) {
                i16 = bounds.height();
            }
            if (width != 0 && i16 != 0) {
                return new a(width, i16);
            }
        }
        Point point = new Point();
        if (windowManager != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
            defaultDisplay.getRealSize(point);
        }
        int i17 = point.x;
        if (i17 != 0 && (i3 = point.y) != 0) {
            return new a(i17, i3);
        }
        return new a(context.getResources().getDisplayMetrics().widthPixels, context.getResources().getDisplayMetrics().heightPixels);
    }
}
