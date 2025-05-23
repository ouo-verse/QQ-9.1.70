package com.tencent.luggage.wxa.ol;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.EditText;
import com.tencent.luggage.wxa.gh.e;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class x0 {

    /* renamed from: a, reason: collision with root package name */
    public final EditText f136968a;

    /* renamed from: b, reason: collision with root package name */
    public final String f136969b;

    /* renamed from: c, reason: collision with root package name */
    public final float f136970c;

    /* renamed from: d, reason: collision with root package name */
    public e.f f136971d;

    /* renamed from: e, reason: collision with root package name */
    public MotionEvent f136972e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f136973f = false;

    /* renamed from: g, reason: collision with root package name */
    public final Runnable f136974g = new a();

    /* renamed from: h, reason: collision with root package name */
    public final Runnable f136975h = new b();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            x0.this.f136973f = true;
            com.tencent.luggage.wxa.tn.w.e(x0.this.f136969b, "[apptouch] pendingCheckForTap run, pointerDown TRUE");
            x0 x0Var = x0.this;
            x0Var.f136968a.postDelayed(x0Var.f136975h, ViewConfiguration.getLongPressTimeout());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!x0.this.f136973f) {
                return;
            }
            e.f a16 = com.tencent.luggage.wxa.gh.e.a(x0.this.f136968a);
            if (x0.this.f136971d != null && Math.abs(x0.this.f136971d.f126743b - a16.f126743b) <= 1.0f && Math.abs(x0.this.f136971d.f126744c - a16.f126744c) <= 1.0f) {
                if (x0.this.f136972e != null) {
                    x0.this.f136973f = false;
                    x0 x0Var = x0.this;
                    x0Var.f136968a.removeCallbacks(x0Var.f136974g);
                    return;
                }
                return;
            }
            com.tencent.luggage.wxa.tn.w.e(x0.this.f136969b, "check long press timeout, but view has moved.");
        }
    }

    public x0(EditText editText) {
        this.f136968a = editText;
        this.f136969b = "MicroMsg.AppBrand.InputFakeTapEventEmitter" + String.format(Locale.US, "[%s]", editText.toString());
        this.f136970c = (float) ViewConfiguration.get(editText.getContext()).getScaledTouchSlop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean a(MotionEvent motionEvent) {
        com.tencent.luggage.wxa.ll.a.a(this.f136969b, "processTouchEvent", motionEvent);
        EditText editText = this.f136968a;
        int actionIndex = motionEvent.getActionIndex();
        float x16 = motionEvent.getX(actionIndex);
        float y16 = motionEvent.getY(actionIndex);
        boolean z16 = false;
        if (motionEvent.getActionMasked() != 0 && this.f136972e == null) {
            com.tencent.luggage.wxa.tn.w.e(this.f136969b, "[textscroll] no pointer down before, just return");
            a();
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f136972e = MotionEvent.obtain(motionEvent);
            this.f136971d = com.tencent.luggage.wxa.gh.e.a(editText);
            boolean b16 = com.tencent.luggage.wxa.gh.e.b(editText);
            editText.removeCallbacks(this.f136974g);
            if (b16) {
                editText.postDelayed(this.f136974g, ViewConfiguration.getTapTimeout());
            } else {
                this.f136974g.run();
            }
        } else {
            if (actionMasked == 1) {
                com.tencent.luggage.wxa.tn.w.g(this.f136969b, "[apptouch] ACTION_UP, pointerDown %B", Boolean.valueOf(this.f136973f));
                if (this.f136973f && this.f136972e != null) {
                    e.f a16 = com.tencent.luggage.wxa.gh.e.a(this.f136968a);
                    e.f fVar = this.f136971d;
                    if (fVar != null && Math.abs(fVar.f126743b - a16.f126743b) <= 1.0f && Math.abs(this.f136971d.f126744c - a16.f126744c) <= 1.0f) {
                        if (!a(this.f136972e, motionEvent)) {
                            com.tencent.luggage.wxa.tn.w.e(this.f136969b, "[apptouch] check tap on ACTION_UP exceed tap scope");
                        } else {
                            ((q0) editText).a(x16, y16);
                        }
                    } else {
                        com.tencent.luggage.wxa.tn.w.e(this.f136969b, "[apptouch] check tap on ACTION_UP, but view has moved.");
                    }
                }
                a();
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    a();
                }
            } else if (!com.tencent.luggage.wxa.gh.e.a(editText, x16, y16, this.f136970c) || !a(this.f136972e, motionEvent)) {
                this.f136973f = false;
                editText.removeCallbacks(this.f136974g);
                editText.removeCallbacks(this.f136975h);
            }
            EditText editText2 = this.f136968a;
            boolean a17 = z0.a(editText2, editText2.getText(), motionEvent) | z16;
            com.tencent.luggage.wxa.ll.a.a(this.f136969b, "[textscroll] handled | " + a17, motionEvent);
            return a17;
        }
        z16 = true;
        EditText editText22 = this.f136968a;
        boolean a172 = z0.a(editText22, editText22.getText(), motionEvent) | z16;
        com.tencent.luggage.wxa.ll.a.a(this.f136969b, "[textscroll] handled | " + a172, motionEvent);
        return a172;
    }

    public final void a() {
        this.f136973f = false;
        this.f136968a.removeCallbacks(this.f136974g);
        this.f136968a.removeCallbacks(this.f136975h);
        this.f136971d = null;
        MotionEvent motionEvent = this.f136972e;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.f136972e = null;
        }
    }

    public final boolean a(MotionEvent motionEvent, MotionEvent motionEvent2) {
        float x16 = motionEvent.getX(motionEvent.getActionIndex());
        float y16 = motionEvent.getY(motionEvent.getActionIndex());
        float x17 = motionEvent2.getX(motionEvent2.getActionIndex());
        float y17 = motionEvent2.getY(motionEvent2.getActionIndex());
        com.tencent.luggage.wxa.tn.w.g(this.f136969b, "[apptouch] checkTapArea touchSlop %f, X[%f:%f], Y[%f:%f], [%s : %s]", Float.valueOf(this.f136970c), Float.valueOf(x16), Float.valueOf(x17), Float.valueOf(y16), Float.valueOf(y17), com.tencent.luggage.wxa.ll.a.a(motionEvent), com.tencent.luggage.wxa.ll.a.a(motionEvent2));
        return Math.abs(y17 - y16) <= this.f136970c && Math.abs(x17 - x16) <= this.f136970c;
    }
}
