package com.tencent.luggage.wxa.gh;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.luggage.wxa.gh.e;
import com.tencent.luggage.wxa.nb.a;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d implements View.OnTouchListener {

    /* renamed from: o, reason: collision with root package name */
    public static volatile View f126725o;

    /* renamed from: a, reason: collision with root package name */
    public Map f126726a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public boolean f126727b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f126728c;

    /* renamed from: d, reason: collision with root package name */
    public e.f f126729d;

    /* renamed from: e, reason: collision with root package name */
    public Runnable f126730e;

    /* renamed from: f, reason: collision with root package name */
    public a.c f126731f;

    /* renamed from: g, reason: collision with root package name */
    public int f126732g;

    /* renamed from: h, reason: collision with root package name */
    public float f126733h;

    /* renamed from: i, reason: collision with root package name */
    public MotionEvent f126734i;

    /* renamed from: j, reason: collision with root package name */
    public MotionEvent f126735j;

    /* renamed from: k, reason: collision with root package name */
    public e.f f126736k;

    /* renamed from: l, reason: collision with root package name */
    public e.f f126737l;

    /* renamed from: m, reason: collision with root package name */
    public View f126738m;

    /* renamed from: n, reason: collision with root package name */
    public com.tencent.luggage.wxa.xd.d f126739n;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f126740a;

        public a(com.tencent.luggage.wxa.xd.d dVar) {
            this.f126740a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.f126727b) {
                w.e("MicroMsg.OnTouchListenerImpl", "check long press timeout, but pressed is false or pointer is null.");
                return;
            }
            if (!ViewCompat.isAttachedToWindow(d.this.f126738m)) {
                w.e("MicroMsg.OnTouchListenerImpl", "check long press timeout, view removed");
                if (d.f126725o != null && d.f126725o.equals(d.this.f126738m)) {
                    View unused = d.f126725o = null;
                    return;
                }
                return;
            }
            e.f a16 = e.a(d.this.f126738m);
            if (Math.abs(d.this.f126729d.f126743b - a16.f126743b) <= 1.0f && Math.abs(d.this.f126729d.f126744c - a16.f126744c) <= 1.0f) {
                if (d.this.f126726a.size() != 1) {
                    w.e("MicroMsg.OnTouchListenerImpl", "check long press timeout, but more then one point.");
                    return;
                }
                if (Math.abs(d.this.f126736k.f126743b - d.this.f126737l.f126743b) <= d.this.f126733h && Math.abs(d.this.f126736k.f126744c - d.this.f126737l.f126744c) <= d.this.f126733h) {
                    w.g("MicroMsg.OnTouchListenerImpl", "check long press timeout, publish event(%s, %s, %s, %s).", Float.valueOf(d.this.f126736k.f126743b), Float.valueOf(d.this.f126737l.f126743b), Float.valueOf(d.this.f126736k.f126744c), Float.valueOf(d.this.f126737l.f126744c));
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("data", d.this.f126731f.a("data", ""));
                        jSONObject.put(WebRTCSDK.PRIVILEGE_TOUCH, d.this.f126736k.a());
                    } catch (JSONException unused2) {
                    }
                    if (!d.this.f126731f.a("disableScroll", false)) {
                        d dVar = d.this;
                        dVar.f126734i = MotionEvent.obtain(dVar.f126735j);
                        d.this.f126734i.setAction(0);
                        d.this.f126731f.b("fakeDownEvent", true);
                        d.this.f126738m.getParent().requestDisallowInterceptTouchEvent(true);
                        d.this.f126738m.setDuplicateParentStateEnabled(false);
                        d dVar2 = d.this;
                        dVar2.a(dVar2.f126738m, MotionEvent.obtain(d.this.f126734i));
                    }
                    d.this.a(this.f126740a, new e.a(), jSONObject.toString());
                    return;
                }
                w.g("MicroMsg.OnTouchListenerImpl", "check long press timeout, but point has moved(%s, %s, %s, %s).", Float.valueOf(d.this.f126736k.f126743b), Float.valueOf(d.this.f126737l.f126743b), Float.valueOf(d.this.f126736k.f126744c), Float.valueOf(d.this.f126737l.f126744c));
                return;
            }
            w.e("MicroMsg.OnTouchListenerImpl", "check long press timeout, but view has moved.");
        }
    }

    public d(com.tencent.luggage.wxa.xd.d dVar, a.c cVar) {
        com.tencent.luggage.wxa.er.a.a(dVar);
        com.tencent.luggage.wxa.er.a.a(cVar);
        this.f126731f = cVar;
        this.f126732g = dVar.getComponentId();
        this.f126739n = dVar;
        this.f126733h = ViewConfiguration.get(dVar.getContext()).getScaledTouchSlop();
        this.f126736k = new e.f();
        this.f126737l = new e.f();
        this.f126730e = new a(dVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a5, code lost:
    
        if (r3 != 6) goto L86;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        String str;
        String str2;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (f126725o != null && !f126725o.equals(view)) {
            w.e("MicroMsg.OnTouchListenerImpl", "onTouch, not current motion view");
            return false;
        }
        this.f126735j = motionEvent;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        motionEvent.getPointerCount();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float x16 = motionEvent.getX(actionIndex);
        float y16 = motionEvent.getY(actionIndex);
        if (actionMasked != 0 && !this.f126731f.c("isTouching") && !ViewCompat.isAttachedToWindow(view) && actionMasked != 3) {
            return false;
        }
        String a16 = this.f126731f.a("data", "");
        boolean a17 = this.f126731f.a("disableScroll", false);
        boolean a18 = this.f126731f.a("fakeDownEvent", false);
        boolean a19 = this.f126731f.a(NodeProps.ON_LONG_CLICK, false);
        this.f126728c = this.f126731f.a("enableLongClick", false);
        this.f126737l.a(pointerId, x16, y16);
        boolean z26 = a17 | a19;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked == 5) {
                            z18 = z26;
                            z16 = true;
                            z17 = false;
                        }
                    } else {
                        f126725o = null;
                        a(view, false, (e.f) null);
                        if (!a17 && !a19) {
                            view.setDuplicateParentStateEnabled(false);
                        } else {
                            view.getParent().requestDisallowInterceptTouchEvent(false);
                        }
                        this.f126731f.b("isTouching", false);
                        if (this.f126731f.a("disableScroll-nextState")) {
                            a.c cVar = this.f126731f;
                            cVar.b("disableScroll", cVar.a("disableScroll-nextState", a17));
                        }
                        if (ViewCompat.isAttachedToWindow(view)) {
                            JSONObject jSONObject = new JSONObject();
                            JSONArray jSONArray = new JSONArray();
                            try {
                                jSONObject.put("data", a16);
                                jSONObject.put("touches", jSONArray);
                            } catch (JSONException unused) {
                            }
                            for (e.f fVar : a(motionEvent)) {
                                jSONArray.mo162put(fVar.a());
                            }
                            a(this.f126739n, new e.b(), jSONObject.toString());
                        }
                        this.f126726a.clear();
                    }
                } else if (b(motionEvent)) {
                    if (this.f126726a.size() == 1 && this.f126727b && (Math.abs(this.f126736k.f126743b - this.f126737l.f126743b) > this.f126733h || Math.abs(this.f126736k.f126744c - this.f126737l.f126744c) > this.f126733h)) {
                        a(view, false, (e.f) null);
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    JSONArray jSONArray2 = new JSONArray();
                    try {
                        jSONObject2.put("data", a16);
                        jSONObject2.put("touches", jSONArray2);
                    } catch (JSONException unused2) {
                    }
                    e.f[] a26 = a(motionEvent);
                    if (a26 != null && a26.length > 0) {
                        for (e.f fVar2 : a26) {
                            jSONArray2.mo162put(fVar2.a());
                        }
                    }
                    if (this.f126726a.size() != 0) {
                        a(this.f126739n, new e.d(), jSONObject2.toString());
                    }
                }
                return z26;
            }
            if (!a17 && !a19) {
                z19 = false;
                view.setDuplicateParentStateEnabled(false);
            } else {
                z19 = false;
                view.getParent().requestDisallowInterceptTouchEvent(false);
            }
            f126725o = null;
            this.f126731f.b("isTouching", z19);
            if (this.f126731f.a("disableScroll-nextState")) {
                a.c cVar2 = this.f126731f;
                cVar2.b("disableScroll", cVar2.a("disableScroll-nextState", a17));
            }
            e.f fVar3 = (e.f) this.f126726a.remove(Integer.valueOf(pointerId));
            if (fVar3 != null) {
                a(view, false, (e.f) null);
                a(this.f126739n, fVar3, new e.C6244e(), a16);
            }
            return z26;
        }
        if (this.f126734i == null || motionEvent.getDownTime() == this.f126734i.getDownTime()) {
            str = "MicroMsg.OnTouchListenerImpl";
            str2 = "fakeDownEvent";
        } else {
            str2 = "fakeDownEvent";
            this.f126731f.b(str2, false);
            str = "MicroMsg.OnTouchListenerImpl";
            w.e(str, "try to handle fake event failed");
            a18 = false;
        }
        if (!a17 && !a18) {
            z16 = true;
            view.setDuplicateParentStateEnabled(true);
            z17 = false;
        } else {
            z16 = true;
            view.getParent().requestDisallowInterceptTouchEvent(true);
            z17 = false;
            view.setDuplicateParentStateEnabled(false);
            w.d(str, "onLongClick fake down event.");
        }
        if (a18) {
            this.f126731f.b(str2, z17);
            this.f126731f.b(NodeProps.ON_LONG_CLICK, z16);
            z18 = z16;
            a19 = z18;
        } else {
            f126725o = view;
            this.f126729d = e.a(view);
            this.f126736k.a(pointerId, x16, y16);
            z18 = z26;
        }
        this.f126731f.b("isTouching", z16);
        if (this.f126728c && !a19 && !this.f126726a.containsKey(Integer.valueOf(pointerId))) {
            view.postDelayed(this.f126730e, ViewConfiguration.getLongPressTimeout());
        }
        if (e.a(view, x16, y16)) {
            e.f fVar4 = new e.f(pointerId, x16, y16);
            if (actionMasked != 0 || a19) {
                z16 = z17;
            }
            a(view, z16, fVar4);
            boolean containsKey = this.f126726a.containsKey(Integer.valueOf(pointerId));
            this.f126726a.put(Integer.valueOf(pointerId), fVar4);
            if (!a18 && !containsKey) {
                a(this.f126739n, fVar4, new e.c(), a16);
                return z18;
            }
            return z18;
        }
        return z18;
    }

    public boolean b(MotionEvent motionEvent) {
        for (int i3 = 0; i3 < motionEvent.getPointerCount(); i3++) {
            float x16 = motionEvent.getX(i3);
            float y16 = motionEvent.getY(i3);
            e.f fVar = (e.f) this.f126726a.get(Integer.valueOf(motionEvent.getPointerId(i3)));
            if (fVar != null && (x16 != fVar.f126743b || y16 != fVar.f126744c)) {
                return true;
            }
        }
        return false;
    }

    public final void a(View view, MotionEvent motionEvent) {
        Object parent = view.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) parent;
            motionEvent.offsetLocation(-(viewGroup.getScrollX() - view.getX()), -(viewGroup.getScrollY() - view.getY()));
            a((View) parent, motionEvent);
            return;
        }
        view.dispatchTouchEvent(motionEvent);
    }

    public final void a(View view, boolean z16, e.f fVar) {
        this.f126738m = view;
        this.f126727b = z16;
        if (z16) {
            return;
        }
        this.f126731f.b("fakeDownEvent", false);
        this.f126731f.b(NodeProps.ON_LONG_CLICK, false);
        this.f126738m.removeCallbacks(this.f126730e);
        this.f126736k.a(-1, 0.0f, 0.0f);
        this.f126734i = null;
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar, e.f fVar, k0 k0Var, String str) {
        if (fVar == null || k0Var == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", str);
            jSONObject.put(WebRTCSDK.PRIVILEGE_TOUCH, fVar.a());
        } catch (JSONException unused) {
        }
        a(dVar, k0Var, jSONObject.toString());
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar, k0 k0Var, String str) {
        dVar.a(k0Var.getName(), str, (int[]) null);
    }

    public e.f[] a(MotionEvent motionEvent) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < motionEvent.getPointerCount(); i3++) {
            e.f fVar = (e.f) this.f126726a.get(Integer.valueOf(motionEvent.getPointerId(i3)));
            if (fVar != null) {
                fVar.f126743b = motionEvent.getX(i3);
                fVar.f126744c = motionEvent.getY(i3);
                arrayList.add(fVar);
            }
        }
        e.f[] fVarArr = new e.f[arrayList.size()];
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            fVarArr[i16] = (e.f) arrayList.get(i16);
        }
        return fVarArr;
    }
}
