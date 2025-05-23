package com.tencent.mm.ui.widget.listview;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.tencent.luggage.wxa.lo.n;
import com.tencent.luggage.wxa.lo.o;

/* loaded from: classes9.dex */
public final class PullDownTouchController {

    /* renamed from: s, reason: collision with root package name */
    public static String f153411s = "MicroMsg.PullDownTouchController";

    /* renamed from: b, reason: collision with root package name */
    public float f153413b;

    /* renamed from: c, reason: collision with root package name */
    public float f153414c;

    /* renamed from: d, reason: collision with root package name */
    public int f153415d;

    /* renamed from: e, reason: collision with root package name */
    public int f153416e;

    /* renamed from: f, reason: collision with root package name */
    public int f153417f;

    /* renamed from: g, reason: collision with root package name */
    public Vibrator f153418g;

    /* renamed from: h, reason: collision with root package name */
    public VelocityTracker f153419h;

    /* renamed from: i, reason: collision with root package name */
    public PullDownListView f153420i;

    /* renamed from: j, reason: collision with root package name */
    public View f153421j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f153422k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f153423l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f153424m;

    /* renamed from: n, reason: collision with root package name */
    public MoveType f153425n;

    /* renamed from: o, reason: collision with root package name */
    public int f153426o;

    /* renamed from: p, reason: collision with root package name */
    public OnLongClickListener f153427p;

    /* renamed from: r, reason: collision with root package name */
    public Context f153429r;

    /* renamed from: a, reason: collision with root package name */
    public final int f153412a = 0;

    /* renamed from: q, reason: collision with root package name */
    public Handler f153428q = new Handler() { // from class: com.tencent.mm.ui.widget.listview.PullDownTouchController.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 0) {
                n.a(PullDownTouchController.f153411s, "MSG_STORY_LONG_PRESS_CHECK", new Object[0]);
                if (PullDownTouchController.this.f153427p != null) {
                    PullDownTouchController.this.f153427p.onLongClick();
                }
                PullDownTouchController.this.setLongPressed(true);
                PullDownTouchController.this.f153418g.vibrate(10L);
            }
        }
    };

    /* loaded from: classes9.dex */
    public enum MoveType {
        None,
        Normal,
        DragUp,
        DragDown
    }

    /* loaded from: classes9.dex */
    public interface OnLongClickListener {
        void onLongClick();
    }

    public PullDownTouchController(Context context) {
        this.f153429r = null;
        if (context == null) {
            return;
        }
        this.f153429r = context;
        this.f153418g = (Vibrator) context.getSystemService("vibrator");
        this.f153425n = MoveType.None;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(this.f153429r);
        if (viewConfiguration != null) {
            this.f153415d = ViewConfiguration.getLongPressTimeout();
            this.f153416e = viewConfiguration.getScaledTouchSlop();
            this.f153417f = o.a(this.f153429r, 30);
        }
    }

    public final float a(float f16) {
        return f16 / 15.0f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003a, code lost:
    
        if (r0 != 3) goto L77;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        PullDownListView pullDownListView;
        float f16;
        View view;
        PullDownListView pullDownListView2;
        MoveType moveType;
        boolean z16;
        n.a(f153411s, "dispatchTouchEvent " + motionEvent.getAction(), new Object[0]);
        if (this.f153419h == null) {
            this.f153419h = VelocityTracker.obtain();
        }
        this.f153419h.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    float f17 = rawX - this.f153414c;
                    float f18 = rawY - this.f153413b;
                    if (!this.f153424m) {
                        if (Math.abs(f17) <= this.f153416e && Math.abs(rawY - this.f153413b) <= this.f153416e) {
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        this.f153424m = z16;
                    }
                    float f19 = 0.0f;
                    if (this.f153424m) {
                        this.f153428q.removeMessages(0);
                        if (this.f153425n == MoveType.None) {
                            if (Math.abs(f18) > Math.abs(f17)) {
                                if (f18 < 0.0f) {
                                    moveType = MoveType.DragUp;
                                } else {
                                    moveType = MoveType.DragDown;
                                }
                            } else {
                                moveType = MoveType.Normal;
                            }
                            this.f153425n = moveType;
                        }
                    }
                    this.f153419h.computeCurrentVelocity(1000);
                    VelocityTracker velocityTracker = this.f153419h;
                    if (velocityTracker != null) {
                        f16 = velocityTracker.getXVelocity(this.f153426o);
                    } else {
                        f16 = 0.0f;
                    }
                    VelocityTracker velocityTracker2 = this.f153419h;
                    if (velocityTracker2 != null) {
                        f19 = velocityTracker2.getYVelocity(this.f153426o);
                    }
                    n.a(f153411s, "moveDirection " + this.f153425n + " deltaOverScrollY:" + f18 + " velocityX:" + f16 + " velocityY:" + f19, new Object[0]);
                    if (!this.f153423l) {
                        MoveType moveType2 = this.f153425n;
                        if (moveType2 == MoveType.DragUp) {
                            this.f153422k = true;
                            if (Math.abs(f18) > this.f153417f && Math.abs(f19) > Math.abs(f16) && (pullDownListView2 = this.f153420i) != null) {
                                pullDownListView2.dispatchTouchEvent(motionEvent);
                            }
                        } else if (moveType2 == MoveType.DragDown) {
                            this.f153422k = true;
                            if (this.f153420i != null && (view = this.f153421j) != null && view.getLayoutParams() != null) {
                                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f153421j.getLayoutParams();
                                marginLayoutParams.topMargin = (int) a(f18);
                                this.f153421j.setLayoutParams(marginLayoutParams);
                            }
                        }
                    }
                }
            }
            b();
            this.f153428q.removeMessages(0);
            if (!this.f153423l && this.f153422k) {
                MoveType moveType3 = this.f153425n;
                if (moveType3 == MoveType.DragUp) {
                    PullDownListView pullDownListView3 = this.f153420i;
                    if (pullDownListView3 != null) {
                        pullDownListView3.dispatchTouchEvent(motionEvent);
                    }
                } else if (moveType3 == MoveType.DragDown && (pullDownListView = this.f153420i) != null) {
                    pullDownListView.onResume();
                }
            }
        } else {
            this.f153426o = motionEvent.getPointerId(0);
            this.f153413b = motionEvent.getRawY();
            this.f153414c = motionEvent.getRawX();
            this.f153422k = false;
            this.f153423l = false;
            this.f153424m = false;
            this.f153425n = MoveType.None;
            this.f153428q.removeMessages(0);
            this.f153428q.sendEmptyMessageDelayed(0, this.f153415d);
            n.a(f153411s, "downX:" + this.f153414c + "  downY:" + this.f153413b, new Object[0]);
        }
        if (!this.f153423l && !this.f153422k) {
            return false;
        }
        return true;
    }

    public final boolean getConsumed() {
        return this.f153422k;
    }

    public final Context getContext() {
        return this.f153429r;
    }

    public final OnLongClickListener getOnLongClick() {
        return this.f153427p;
    }

    public final View getStoryView() {
        return this.f153421j;
    }

    public final View getWrapperView() {
        return this.f153420i;
    }

    public final boolean isLongPressed() {
        return this.f153423l;
    }

    public final void onDestroy() {
        this.f153420i = null;
        this.f153421j = null;
    }

    public final void setConsumed(boolean z16) {
        this.f153422k = z16;
    }

    public final void setLongPressed(boolean z16) {
        this.f153423l = z16;
    }

    public final void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        this.f153427p = onLongClickListener;
    }

    public final void setStoryView(View view) {
        this.f153421j = view;
    }

    public final void setWrapperView(View view) {
        if (view != null && (view instanceof PullDownListView)) {
            this.f153420i = (PullDownListView) view;
        }
    }

    public final void b() {
        VelocityTracker velocityTracker = this.f153419h;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.f153419h.recycle();
        }
        this.f153419h = null;
    }
}
