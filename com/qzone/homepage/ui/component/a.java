package com.qzone.homepage.ui.component;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.qzone.homepage.ui.component.b;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private HandlerC0392a f47702a;

    /* renamed from: b, reason: collision with root package name */
    private b f47703b;

    /* renamed from: c, reason: collision with root package name */
    private b.C0393b f47704c;

    public a(Context context) {
        b();
    }

    private void b() {
        this.f47702a = new HandlerC0392a(Looper.getMainLooper());
        this.f47703b = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f47703b != null && this.f47704c != null) {
            QZLog.d("QzoneCmShowController", 1, "start playPassivePraise");
            this.f47703b.a(this.f47704c);
        } else {
            QZLog.d("QzoneCmShowController", 1, "playPassivePraise data = null stop");
        }
    }

    public void c() {
        HandlerC0392a handlerC0392a = this.f47702a;
        if (handlerC0392a != null) {
            handlerC0392a.removeCallbacksAndMessages(null);
        }
    }

    public void f(b.C0393b c0393b) {
        this.f47704c = c0393b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.qzone.homepage.ui.component.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public class HandlerC0392a extends Handler {
        public HandlerC0392a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1) {
                a.this.g();
            }
        }
    }

    public static void i(ArrayList<String> arrayList) {
    }

    public void d() {
    }

    public void e() {
    }

    public static void h(ArrayList<String> arrayList, int[] iArr) {
    }
}
