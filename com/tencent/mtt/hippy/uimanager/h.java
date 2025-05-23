package com.tencent.mtt.hippy.uimanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mtt.hippy.dom.node.NodeProps;

/* compiled from: P */
/* loaded from: classes20.dex */
public class h {

    /* renamed from: c, reason: collision with root package name */
    private static final int f337689c = ViewConfiguration.getTapTimeout();

    /* renamed from: d, reason: collision with root package name */
    private static final int f337690d = ViewConfiguration.getTouchSlop();

    /* renamed from: b, reason: collision with root package name */
    final a f337692b;

    /* renamed from: e, reason: collision with root package name */
    private Handler f337693e;

    /* renamed from: a, reason: collision with root package name */
    boolean f337691a = false;

    /* renamed from: f, reason: collision with root package name */
    private float f337694f = 0.0f;

    /* renamed from: g, reason: collision with root package name */
    private float f337695g = 0.0f;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void handle(String str, float f16, float f17);

        boolean needHandle(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final h f337696a;

        /* renamed from: b, reason: collision with root package name */
        private final a f337697b;

        public b(h hVar) {
            super(Looper.getMainLooper());
            this.f337696a = hVar;
            this.f337697b = hVar.b();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 == 2) {
                    this.f337697b.handle(NodeProps.ON_PRESS_OUT, -1.0f, -1.0f);
                }
            } else {
                this.f337697b.handle(NodeProps.ON_PRESS_IN, -1.0f, -1.0f);
                this.f337696a.f337691a = true;
            }
        }
    }

    public h(a aVar) {
        this.f337692b = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a b() {
        return this.f337692b;
    }

    public Handler a() {
        if (this.f337693e == null) {
            this.f337693e = new b(this);
        }
        return this.f337693e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00fe, code lost:
    
        if (r8.f337692b.needHandle(com.tencent.mtt.hippy.dom.node.NodeProps.ON_PRESS_OUT) != false) goto L57;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        boolean z16 = false;
        if (action == 0) {
            if (this.f337692b.needHandle(NodeProps.ON_PRESS_IN)) {
                this.f337691a = false;
                this.f337694f = motionEvent.getX();
                this.f337695g = motionEvent.getY();
                a().sendEmptyMessageDelayed(1, f337689c);
                z16 = true;
            } else {
                this.f337691a = true;
            }
            if (this.f337692b.needHandle(NodeProps.ON_TOUCH_DOWN)) {
                this.f337692b.handle(NodeProps.ON_TOUCH_DOWN, motionEvent.getX(), motionEvent.getY());
                z16 = true;
            }
            if (!z16 && this.f337692b.needHandle("onTouchMove")) {
                z16 = true;
            }
            if (!z16 && this.f337692b.needHandle("onTouchEnd")) {
                z16 = true;
            }
            if (!z16 && this.f337692b.needHandle("onTouchCancel")) {
                return true;
            }
        } else {
            if (action == 1) {
                if (this.f337692b.needHandle("onTouchEnd")) {
                    this.f337692b.handle("onTouchEnd", motionEvent.getX(), motionEvent.getY());
                    z16 = true;
                }
                if (!this.f337691a || !this.f337692b.needHandle(NodeProps.ON_PRESS_OUT)) {
                    if (!this.f337691a) {
                    }
                }
                this.f337692b.handle(NodeProps.ON_PRESS_OUT, motionEvent.getX(), motionEvent.getY());
                return true;
            }
            if (action == 2) {
                if (this.f337692b.needHandle("onTouchMove")) {
                    this.f337692b.handle("onTouchMove", motionEvent.getX(), motionEvent.getY());
                    z16 = true;
                }
                if (!z16 && this.f337692b.needHandle("onTouchEnd")) {
                    z16 = true;
                }
                if (!z16 && this.f337692b.needHandle("onTouchCancel")) {
                    z16 = true;
                }
                if (!this.f337691a) {
                    float abs = Math.abs(motionEvent.getX() - this.f337694f);
                    float abs2 = Math.abs(motionEvent.getY() - this.f337695g);
                    int i3 = f337690d;
                    if (abs > i3 || abs2 > i3) {
                        a().removeMessages(1);
                        this.f337691a = true;
                    }
                }
            } else if (action == 3 || action == 4) {
                if (this.f337692b.needHandle("onTouchCancel")) {
                    this.f337692b.handle("onTouchCancel", motionEvent.getX(), motionEvent.getY());
                    z16 = true;
                }
                if (!this.f337691a || !this.f337692b.needHandle(NodeProps.ON_PRESS_OUT)) {
                    if (!this.f337691a && this.f337692b.needHandle(NodeProps.ON_PRESS_OUT)) {
                        if (a().hasMessages(1)) {
                            a().removeMessages(1);
                        }
                        a().sendEmptyMessageDelayed(2, f337689c);
                        return true;
                    }
                }
                this.f337692b.handle(NodeProps.ON_PRESS_OUT, motionEvent.getX(), motionEvent.getY());
                return true;
            }
        }
        return z16;
    }
}
