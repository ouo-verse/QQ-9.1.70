package com.tencent.luggage.wxa.gh;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.nb.a;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a extends k0 {
        private static final int CTRL_INDEX = 137;
        public static final String NAME = "onLongPress";
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b extends k0 {
        private static final int CTRL_INDEX = -2;
        public static final String NAME = "onTouchCancel";
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c extends k0 {
        private static final int CTRL_INDEX = -2;
        public static final String NAME = "onTouchStart";
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class d extends k0 {
        private static final int CTRL_INDEX = -2;
        public static final String NAME = "onTouchMove";
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.gh.e$e, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6244e extends k0 {
        private static final int CTRL_INDEX = -2;
        public static final String NAME = "onTouchEnd";
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public int f126742a;

        /* renamed from: b, reason: collision with root package name */
        public float f126743b;

        /* renamed from: c, reason: collision with root package name */
        public float f126744c;

        public f() {
        }

        public void a(int i3, float f16, float f17) {
            this.f126742a = i3;
            this.f126743b = f16;
            this.f126744c = f17;
        }

        public String toString() {
            return a().toString();
        }

        public f(int i3, float f16, float f17) {
            this.f126742a = i3;
            this.f126743b = f16;
            this.f126744c = f17;
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.f126742a);
                jSONObject.put(HippyTKDListViewAdapter.X, com.tencent.luggage.wxa.tk.g.b(this.f126743b));
                jSONObject.put("y", com.tencent.luggage.wxa.tk.g.b(this.f126744c));
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    public static void a(com.tencent.luggage.wxa.xd.d dVar, View view, a.c cVar) {
        if (dVar != null && view != null && cVar != null) {
            view.setOnTouchListener(new com.tencent.luggage.wxa.gh.d(dVar, cVar));
        } else {
            w.d("MicroMsg.ViewMotionHelper", "setOnTouchListener failed, page or view or keyValueSet is null.");
        }
    }

    public static boolean b(View view) {
        if (view == null) {
            return false;
        }
        for (ViewParent parent = view.getParent(); parent != null && (parent instanceof ViewGroup); parent = parent.getParent()) {
            if (((ViewGroup) parent).shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(View view, float f16, float f17) {
        return f16 >= 0.0f && f17 >= 0.0f && f16 <= ((float) view.getWidth()) && f17 <= ((float) view.getHeight());
    }

    public static boolean a(View view, float f16, float f17, float f18) {
        float f19 = -f18;
        return f16 >= f19 && f17 >= f19 && f16 < ((float) view.getWidth()) + f18 && f17 < ((float) view.getHeight()) + f18;
    }

    public static f a(View view) {
        view.getLocationOnScreen(new int[2]);
        return new f(0, r0[0], r0[1]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(ViewGroup viewGroup, MotionEvent motionEvent) {
        int childCount = viewGroup.getChildCount();
        int pointerId = viewGroup.isMotionEventSplittingEnabled() ? 1 << motionEvent.getPointerId(motionEvent.getActionIndex()) : -1;
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            View childAt = viewGroup.getChildAt(i3);
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            if (AppBrandViewMotionCompat.a(childAt) && AppBrandViewMotionCompat.a(viewGroup, x16, y16, childAt, null) && childAt.isDuplicateParentStateEnabled()) {
                a(viewGroup, motionEvent, false, childAt, pointerId);
                if ((childAt instanceof com.tencent.luggage.wxa.ee.f) && ((com.tencent.luggage.wxa.ee.f) childAt).a()) {
                    return;
                }
            }
        }
    }

    public static boolean a(ViewGroup viewGroup, MotionEvent motionEvent, boolean z16, View view, int i3) {
        MotionEvent obtain;
        if (view == null) {
            w.e("MicroMsg.ViewMotionHelper", "child is null.");
            return false;
        }
        int action = motionEvent.getAction();
        if (!z16 && action != 3) {
            int a16 = AppBrandViewMotionCompat.a(motionEvent);
            int i16 = i3 & a16;
            if (i16 == 0) {
                w.e("MicroMsg.ViewMotionHelper", "newPointerIdBits is 0.");
                return false;
            }
            boolean c16 = AppBrandViewMotionCompat.c(view);
            if (i16 != a16) {
                MotionEvent a17 = AppBrandViewMotionCompat.a(motionEvent, i16);
                obtain = a17 == null ? MotionEvent.obtain(motionEvent) : a17;
            } else {
                if (c16) {
                    float scrollX = viewGroup.getScrollX() - view.getLeft();
                    float scrollY = viewGroup.getScrollY() - view.getTop();
                    motionEvent.offsetLocation(scrollX, scrollY);
                    boolean dispatchTouchEvent = view.dispatchTouchEvent(motionEvent);
                    motionEvent.offsetLocation(-scrollX, -scrollY);
                    return dispatchTouchEvent;
                }
                obtain = MotionEvent.obtain(motionEvent);
            }
            obtain.offsetLocation(viewGroup.getScrollX() - view.getLeft(), viewGroup.getScrollY() - view.getTop());
            if (!c16) {
                obtain.transform(AppBrandViewMotionCompat.b(view));
            }
            boolean dispatchTouchEvent2 = view.dispatchTouchEvent(obtain);
            obtain.recycle();
            return dispatchTouchEvent2;
        }
        motionEvent.setAction(3);
        boolean dispatchTouchEvent3 = view.dispatchTouchEvent(motionEvent);
        motionEvent.setAction(action);
        return dispatchTouchEvent3;
    }
}
