package com.tencent.mobileqq.activity.aio.stickerbubble;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQUIHapticManager;

/* compiled from: P */
/* loaded from: classes10.dex */
public class e implements GestureDetector.OnGestureListener, Handler.Callback {
    private static boolean Q = false;
    private static boolean R = false;
    private boolean C;
    private boolean D;
    private int E;
    private float G;
    private float H;
    private long I;
    private float J;
    private float K;
    private boolean L;
    protected boolean M;

    /* renamed from: d, reason: collision with root package name */
    private final d f179873d;

    /* renamed from: e, reason: collision with root package name */
    private final GestureDetector f179874e;

    /* renamed from: f, reason: collision with root package name */
    private final View f179875f;

    /* renamed from: i, reason: collision with root package name */
    private int f179877i;

    /* renamed from: m, reason: collision with root package name */
    private int f179878m;
    private int F = -1;
    private String N = "chat_item_for_sticker40";
    private boolean P = true;

    /* renamed from: h, reason: collision with root package name */
    private final Handler f179876h = new Handler(Looper.getMainLooper(), this);

    public e(d dVar, View view, boolean z16, boolean z17) {
        this.f179873d = dVar;
        this.f179875f = view;
        this.L = z16;
        this.M = z17;
        this.f179874e = new GestureDetector(view.getContext(), this);
        if (QLog.isColorLevel()) {
            QLog.d("StickerBubbleGesture", 2, "mIsSupportFeedBack = " + this.L);
        }
    }

    private void b() {
        if (this.D) {
            this.f179873d.i();
            this.D = false;
            this.C = false;
        }
    }

    private void c(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("StickerBubbleGesture", 2, "finishSendingAction: " + i3);
        }
        this.F = -1;
        this.f179873d.m(i3, this.E);
        this.f179876h.sendEmptyMessageDelayed(2, 3000L);
        this.D = true;
        Q = false;
    }

    private boolean e(MotionEvent motionEvent) {
        boolean z16 = false;
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            if (QLog.isColorLevel()) {
                QLog.d("StickerBubbleGesture", 2, "handleActionUp: " + motionEvent);
            }
            int i3 = this.F;
            if (i3 > -1) {
                c(i3);
                z16 = true;
            }
            this.f179873d.n();
        }
        return z16;
    }

    private boolean f(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2 && this.F > -1 && this.f179873d.l(motionEvent.getX(), motionEvent.getY())) {
            c(this.F);
            return true;
        }
        return false;
    }

    private void k() {
        int[] iArr = new int[2];
        this.f179875f.getLocationInWindow(iArr);
        this.f179877i = iArr[0];
        this.f179878m = iArr[1];
    }

    public void a() {
        this.f179873d.p();
    }

    public void d() {
        int i3 = this.F;
        if (i3 > -1) {
            c(i3);
        }
    }

    public boolean g(MotionEvent motionEvent) {
        boolean e16 = e(motionEvent);
        if (!e16) {
            e16 = f(motionEvent);
        }
        if (!e16) {
            if (this.M) {
                this.J = motionEvent.getX();
                this.K = motionEvent.getY();
            }
            if (this.P) {
                return this.f179874e.onTouchEvent(motionEvent);
            }
            return e16;
        }
        return e16;
    }

    public void h() {
        R = true;
        this.f179876h.removeCallbacksAndMessages(null);
        this.D = true;
        b();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0085  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 == 2) {
                b();
            }
        } else if (this.F == ((Integer) message.obj).intValue() && !R) {
            int i16 = this.E + 1;
            this.E = i16;
            if (i16 >= this.f179873d.f()) {
                c(this.F);
            } else {
                if (this.M) {
                    float f16 = this.J;
                    if (f16 != 0.0f) {
                        float f17 = f16 + this.f179877i;
                        float f18 = this.K + this.f179878m;
                        QLog.d("StickerBubbleGesture", 2, "touchX = " + f17 + "  touchY = " + f18);
                        this.f179873d.k(f17, f18, this.F, this.E);
                        if (this.L) {
                            QQUIHapticManager.playEffect(this.N, 2);
                        }
                        b();
                        if (this.E > 2 && !this.C) {
                            this.f179873d.g();
                            this.C = true;
                        }
                        this.f179876h.sendMessageDelayed(this.f179876h.obtainMessage(1, message.obj), 80L);
                    }
                }
                this.f179873d.k(this.G, this.H, this.F, this.E);
                if (this.L) {
                }
                b();
                if (this.E > 2) {
                    this.f179873d.g();
                    this.C = true;
                }
                this.f179876h.sendMessageDelayed(this.f179876h.obtainMessage(1, message.obj), 80L);
            }
        }
        return true;
    }

    public void i() {
        R = false;
        this.f179876h.removeCallbacksAndMessages(null);
        this.f179876h.sendMessage(this.f179876h.obtainMessage(1, Integer.valueOf(this.F)));
    }

    public void j(boolean z16) {
        this.P = z16;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (QLog.isColorLevel()) {
            QLog.d("StickerBubbleGesture", 2, "onDown: " + motionEvent);
        }
        this.f179873d.j(motionEvent.getX(), motionEvent.getY());
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
        int r16 = this.f179873d.r(motionEvent.getX(), motionEvent.getY());
        if (r16 >= 0 && !Q) {
            int i3 = this.F;
            if (i3 > -1) {
                c(i3);
            }
            this.F = r16;
            k();
            this.G = motionEvent.getX() + this.f179877i;
            float y16 = motionEvent.getY() + this.f179878m;
            this.H = y16;
            this.f179873d.k(this.G, y16, r16, 1);
            if (this.L) {
                QQUIHapticManager.playEffect(this.N, 2);
            } else if (QLog.isColorLevel()) {
                QLog.d("StickerBubbleGesture", 2, "onShowPress isTouchEffectSupport = " + this.L);
            }
            this.E = 1;
            this.f179876h.removeMessages(1);
            Q = true;
            this.f179876h.sendMessageDelayed(this.f179876h.obtainMessage(1, Integer.valueOf(r16)), 80L);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.I > 300) {
            int r16 = this.f179873d.r(motionEvent.getX(), motionEvent.getY());
            if (QLog.isColorLevel()) {
                QLog.d("StickerBubbleGesture", 2, "onSingleTapUp: " + motionEvent + " on idx: " + r16);
            }
            if (r16 > -1) {
                k();
                this.f179873d.k(motionEvent.getX() + this.f179877i, motionEvent.getY() + this.f179878m, r16, 1);
                if (this.L) {
                    QQUIHapticManager.playEffect(this.N, 2);
                } else if (QLog.isColorLevel()) {
                    QLog.d("StickerBubbleGesture", 2, "onSingleTapUp isTouchEffectSupport = " + this.L);
                }
                this.f179873d.m(r16, 1);
            }
            this.I = uptimeMillis;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }
}
