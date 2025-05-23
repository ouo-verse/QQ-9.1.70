package com.tencent.luggage.wxa.il;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g extends FrameLayout {

    /* renamed from: f, reason: collision with root package name */
    public static final LinkedList f130694f = new LinkedList();

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.zj.b f130695a;

    /* renamed from: b, reason: collision with root package name */
    public b f130696b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f130697c;

    /* renamed from: d, reason: collision with root package name */
    public View f130698d;

    /* renamed from: e, reason: collision with root package name */
    public final Set f130699e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
    }

    public g(Context context) {
        super(b(context));
        this.f130696b = new b();
        this.f130699e = new HashSet();
        setWillNotDraw(false);
        this.f130695a = (com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.zj.b.class, true);
    }

    public static g a(Context context) {
        g gVar = (g) f130694f.pollFirst();
        return gVar != null ? gVar : new g(context);
    }

    public static Context b(Context context) {
        if (context != null && context.getApplicationContext() != null) {
            return context.getApplicationContext();
        }
        return z.c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (willNotDraw()) {
            return;
        }
        try {
            super.dispatchDraw(canvas);
        } catch (Exception e16) {
            w.a("Luggage.WXA.AppBrandRuntimeFrameLayout", e16, "", new Object[0]);
            if (e16 instanceof NullPointerException) {
                this.f130695a.a(1088L, 0L, 1L, false);
                throw e16;
            }
            this.f130695a.a(1088L, 1L, 1L, false);
            throw e16;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View view;
        if (this.f130697c && (view = this.f130698d) != null) {
            return view.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public com.tencent.luggage.wxa.wl.a getLuggageKeyboardNavKeyEventLocker() {
        return null;
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        Iterator it = this.f130699e.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f130699e.clear();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.f130696b.a(canvas, getContext());
        super.onDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        w.d("Luggage.WXA.AppBrandRuntimeFrameLayout", "onViewRemoved %s", view);
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        w.a("Luggage.WXA.AppBrandRuntimeFrameLayout", "removeAllViews stack = %s", Log.getStackTraceString(new Throwable()));
        super.removeAllViews();
    }

    public void setRoundCornerProvider(a aVar) {
        this.f130696b.getClass();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    public void a(View view) {
        this.f130697c = true;
        this.f130698d = view;
    }

    public void a() {
        this.f130697c = false;
        this.f130698d = null;
    }

    public void setLuggageKeyboardNavKeyEventLocker(com.tencent.luggage.wxa.wl.a aVar) {
    }

    public void setWxaHalfScreenGestureController(@Nullable k kVar) {
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public Rect f130700a = new Rect();

        /* renamed from: b, reason: collision with root package name */
        public RectF f130701b = new RectF();

        /* renamed from: c, reason: collision with root package name */
        public Path f130702c = new Path();

        public b() {
        }

        public void a(Canvas canvas, Context context) {
        }
    }
}
