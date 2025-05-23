package com.tencent.luggage.wxa.kl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    public static final a f132643d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.h6.i f132644e = new com.tencent.luggage.wxa.h6.i(Boolean.FALSE);

    /* renamed from: a, reason: collision with root package name */
    public List f132645a;

    /* renamed from: b, reason: collision with root package name */
    public List f132646b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f132647c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ KProperty[] f132648a = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "isDebugEnable", "isDebugEnable()Z", 0))};

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return ((Boolean) f.f132644e.a(this, f132648a[0])).booleanValue();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            f.this.c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            f.this.c();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f132647c = true;
        b();
    }

    private final void b() {
        if (f132643d.a()) {
            setWillNotDraw(false);
            post(new b());
        }
    }

    public final void c() {
        if (!this.f132647c) {
            return;
        }
        this.f132647c = false;
        View findViewById = findViewById(R.id.s_g);
        View findViewById2 = findViewById(R.id.s_f);
        View findViewById3 = findViewById(R.id.s_9);
        if (findViewById != null && findViewById2 != null && findViewById3 != null) {
            Rect rect = new Rect();
            getHitRect(rect);
            Rect rect2 = new Rect();
            findViewById3.getHitRect(rect2);
            Rect rect3 = new Rect();
            findViewById.getHitRect(rect3);
            Rect rect4 = new Rect();
            findViewById2.getHitRect(rect4);
            rect4.offset(rect2.left, rect2.top);
            rect3.offset(rect2.left, rect2.top);
            int i3 = rect.right;
            int i16 = rect2.right;
            int i17 = i3 - i16;
            int i18 = rect2.top;
            int i19 = i18 - rect.top;
            int i26 = rect.bottom;
            int i27 = rect2.bottom;
            int i28 = i26 - i27;
            if (i17 > 0) {
                rect2.left -= i17;
                rect2.right = i16 + i17;
                rect3.left -= i17;
                rect4.right += i17;
            }
            if (i28 > 0) {
                rect2.bottom = i27 + i28;
                rect3.bottom += i28;
                rect4.bottom += i28;
            }
            if (i19 > 0) {
                rect2.top = i18 - i19;
                rect3.top -= i19;
                rect4.top -= i19;
            }
            if (this.f132645a == null) {
                this.f132645a = new ArrayList();
                if (f132643d.a()) {
                    this.f132646b = new ArrayList();
                }
            }
            if (f132643d.a()) {
                List list = this.f132646b;
                Intrinsics.checkNotNull(list);
                list.add(new Rect(rect3));
                List list2 = this.f132646b;
                Intrinsics.checkNotNull(list2);
                list2.add(new Rect(rect4));
                invalidate();
            }
            List list3 = this.f132645a;
            Intrinsics.checkNotNull(list3);
            list3.add(new TouchDelegate(rect3, findViewById));
            List list4 = this.f132645a;
            Intrinsics.checkNotNull(list4);
            list4.add(new TouchDelegate(rect4, findViewById2));
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        List<Rect> list;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (f132643d.a() && (list = this.f132646b) != null) {
            for (Rect rect : list) {
                canvas.save();
                canvas.clipRect(rect);
                canvas.drawColor(ContextCompat.getColor(getContext(), R.color.cyq));
                canvas.restore();
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (z16) {
            this.f132647c = true;
            List list = this.f132645a;
            if (list != null) {
                list.clear();
            }
            if (f132643d.a()) {
                List list2 = this.f132646b;
                if (list2 != null) {
                    list2.clear();
                    Unit unit = Unit.INSTANCE;
                    invalidate();
                }
                post(new c());
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        boolean onTouchEvent = super.onTouchEvent(event);
        if (!onTouchEvent) {
            c();
            List list = this.f132645a;
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (((TouchDelegate) it.next()).onTouchEvent(event)) {
                        return true;
                    }
                }
                return onTouchEvent;
            }
            return onTouchEvent;
        }
        return onTouchEvent;
    }
}
