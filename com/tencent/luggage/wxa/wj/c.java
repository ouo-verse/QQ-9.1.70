package com.tencent.luggage.wxa.wj;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.luggage.wxa.wj.d;
import com.tencent.luggage.wxa.xd.m;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface c extends m, f, Comparable {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f144266a;
    }

    Context cloneContext();

    d createFullscreenHandler(d.a aVar);

    Context getContext();

    void getLocationInWindow(View view, int[] iArr);

    b getNavigationBar();

    e getOrientationHandler();

    Rect getSafeAreaInsets();

    DisplayMetrics getVDisplayMetrics();

    ViewGroup.LayoutParams getWindowLayoutParams(com.tencent.luggage.wxa.ic.g gVar);

    boolean isInMultiWindowMode();

    boolean runInStandaloneTask();

    void setSoftOrientation(String str);

    void setWindowBackgroundColor(int i3, com.tencent.luggage.wxa.ic.g gVar);

    void setWindowDescription(a aVar);

    void setWindowLayoutParams(h hVar, com.tencent.luggage.wxa.ic.g gVar);

    boolean shouldInLargeScreenCompatMode();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.wj.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6887c {

        /* renamed from: a, reason: collision with root package name */
        public int f144267a;

        /* renamed from: b, reason: collision with root package name */
        public int f144268b = 0;

        public static Activity a(Context context) {
            while (context instanceof ContextWrapper) {
                if (context instanceof Activity) {
                    return (Activity) context;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            return null;
        }

        public void b(Context context) {
            Activity a16 = a(context);
            if (a16 == null) {
                return;
            }
            com.tencent.luggage.wxa.po.b.b(a16.getWindow());
        }

        public String toString() {
            return "WindowStatusBar{height=" + this.f144267a + ", visibility=" + this.f144268b + '}';
        }

        public boolean a(Context context, boolean z16) {
            Activity a16 = a(context);
            if (a16 == null) {
                return false;
            }
            return com.tencent.luggage.wxa.lo.f.b(a16.getWindow(), z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f144262a;

        /* renamed from: b, reason: collision with root package name */
        public final Bitmap f144263b;

        /* renamed from: c, reason: collision with root package name */
        public final int f144264c;

        /* renamed from: d, reason: collision with root package name */
        public final int f144265d;

        public a(String str, Bitmap bitmap, int i3) {
            this.f144262a = str;
            this.f144263b = bitmap;
            this.f144264c = -1;
            this.f144265d = i3;
        }

        public Bitmap a() {
            return this.f144263b;
        }

        public int b() {
            return this.f144264c;
        }

        public String c() {
            return this.f144262a;
        }

        public int d() {
            return this.f144265d;
        }

        public a(String str) {
            this(str, null, 0);
        }
    }
}
