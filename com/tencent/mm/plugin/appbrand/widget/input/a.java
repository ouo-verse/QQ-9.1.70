package com.tencent.mm.plugin.appbrand.widget.input;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a {

    /* renamed from: f, reason: collision with root package name */
    public static final int f152392f = ViewConfiguration.getLongPressTimeout();

    /* renamed from: b, reason: collision with root package name */
    public float f152394b;

    /* renamed from: c, reason: collision with root package name */
    public float f152395c;

    /* renamed from: e, reason: collision with root package name */
    public final b f152397e;

    /* renamed from: a, reason: collision with root package name */
    public final Handler f152393a = new HandlerC7065a(Looper.getMainLooper());

    /* renamed from: d, reason: collision with root package name */
    public boolean f152396d = false;

    /* compiled from: P */
    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class HandlerC7065a extends Handler {
        public HandlerC7065a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if ((i3 == 1 || i3 == 2) && a.this.a()) {
                sendMessageDelayed(Message.obtain(a.this.f152393a, 2), 50L);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface b {
        void a();

        void b();
    }

    public a(b bVar) {
        this.f152397e = bVar;
    }

    public boolean a(View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            view.setPressed(true);
            Handler handler = this.f152393a;
            handler.sendMessageDelayed(Message.obtain(handler, 1), f152392f);
            this.f152394b = motionEvent.getX();
            this.f152395c = motionEvent.getY();
        } else if (actionMasked == 1) {
            if (!this.f152396d && this.f152393a.hasMessages(1)) {
                this.f152397e.a();
            }
            a(view);
        } else if (actionMasked == 2) {
            int scaledTouchSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            float f16 = -scaledTouchSlop;
            if (f16 > x16 || x16 > view.getWidth() + scaledTouchSlop || f16 > y16 || y16 > view.getHeight() + scaledTouchSlop) {
                this.f152396d = true;
            }
        } else if (actionMasked == 3) {
            a(view);
        }
        return true;
    }

    public final void a(View view) {
        view.setPressed(false);
        this.f152396d = false;
        this.f152393a.removeMessages(1);
        this.f152393a.removeMessages(2);
    }

    public final boolean a() {
        if (this.f152396d) {
            return false;
        }
        this.f152397e.b();
        return true;
    }
}
