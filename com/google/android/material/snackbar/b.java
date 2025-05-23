package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes2.dex */
class b {

    /* renamed from: e, reason: collision with root package name */
    private static b f34214e;

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final Object f34215a = new Object();

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final Handler f34216b = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private c f34217c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private c f34218d;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            if (message.what != 0) {
                return false;
            }
            b.this.d((c) message.obj);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.google.android.material.snackbar.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0238b {
        void b(int i3);

        void show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        final WeakReference<InterfaceC0238b> f34220a;

        /* renamed from: b, reason: collision with root package name */
        int f34221b;

        /* renamed from: c, reason: collision with root package name */
        boolean f34222c;

        boolean a(@Nullable InterfaceC0238b interfaceC0238b) {
            if (interfaceC0238b != null && this.f34220a.get() == interfaceC0238b) {
                return true;
            }
            return false;
        }
    }

    b() {
    }

    private boolean a(@NonNull c cVar, int i3) {
        InterfaceC0238b interfaceC0238b = cVar.f34220a.get();
        if (interfaceC0238b != null) {
            this.f34216b.removeCallbacksAndMessages(cVar);
            interfaceC0238b.b(i3);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b c() {
        if (f34214e == null) {
            f34214e = new b();
        }
        return f34214e;
    }

    private boolean f(InterfaceC0238b interfaceC0238b) {
        c cVar = this.f34217c;
        if (cVar != null && cVar.a(interfaceC0238b)) {
            return true;
        }
        return false;
    }

    private boolean g(InterfaceC0238b interfaceC0238b) {
        c cVar = this.f34218d;
        if (cVar != null && cVar.a(interfaceC0238b)) {
            return true;
        }
        return false;
    }

    private void l(@NonNull c cVar) {
        int i3 = cVar.f34221b;
        if (i3 == -2) {
            return;
        }
        if (i3 <= 0) {
            if (i3 == -1) {
                i3 = 1500;
            } else {
                i3 = 2750;
            }
        }
        this.f34216b.removeCallbacksAndMessages(cVar);
        Handler handler = this.f34216b;
        handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), i3);
    }

    private void m() {
        c cVar = this.f34218d;
        if (cVar != null) {
            this.f34217c = cVar;
            this.f34218d = null;
            InterfaceC0238b interfaceC0238b = cVar.f34220a.get();
            if (interfaceC0238b != null) {
                interfaceC0238b.show();
            } else {
                this.f34217c = null;
            }
        }
    }

    public void b(InterfaceC0238b interfaceC0238b, int i3) {
        synchronized (this.f34215a) {
            if (f(interfaceC0238b)) {
                a(this.f34217c, i3);
            } else if (g(interfaceC0238b)) {
                a(this.f34218d, i3);
            }
        }
    }

    void d(@NonNull c cVar) {
        synchronized (this.f34215a) {
            if (this.f34217c == cVar || this.f34218d == cVar) {
                a(cVar, 2);
            }
        }
    }

    public boolean e(InterfaceC0238b interfaceC0238b) {
        boolean z16;
        synchronized (this.f34215a) {
            if (!f(interfaceC0238b) && !g(interfaceC0238b)) {
                z16 = false;
            }
            z16 = true;
        }
        return z16;
    }

    public void h(InterfaceC0238b interfaceC0238b) {
        synchronized (this.f34215a) {
            if (f(interfaceC0238b)) {
                this.f34217c = null;
                if (this.f34218d != null) {
                    m();
                }
            }
        }
    }

    public void i(InterfaceC0238b interfaceC0238b) {
        synchronized (this.f34215a) {
            if (f(interfaceC0238b)) {
                l(this.f34217c);
            }
        }
    }

    public void j(InterfaceC0238b interfaceC0238b) {
        synchronized (this.f34215a) {
            if (f(interfaceC0238b)) {
                c cVar = this.f34217c;
                if (!cVar.f34222c) {
                    cVar.f34222c = true;
                    this.f34216b.removeCallbacksAndMessages(cVar);
                }
            }
        }
    }

    public void k(InterfaceC0238b interfaceC0238b) {
        synchronized (this.f34215a) {
            if (f(interfaceC0238b)) {
                c cVar = this.f34217c;
                if (cVar.f34222c) {
                    cVar.f34222c = false;
                    l(cVar);
                }
            }
        }
    }
}
