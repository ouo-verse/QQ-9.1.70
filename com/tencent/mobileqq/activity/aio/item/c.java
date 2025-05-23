package com.tencent.mobileqq.activity.aio.item;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    private static Handler f179447c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f179448d;

    /* renamed from: a, reason: collision with root package name */
    LinkedList<WeakReference<com.tencent.mobileqq.activity.aio.item.b>> f179449a;

    /* renamed from: b, reason: collision with root package name */
    WeakReference<com.tencent.mobileqq.activity.aio.item.b> f179450b;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj = message.obj;
            if (obj == null) {
                int i3 = message.what;
                if (i3 == 4) {
                    c.this.g();
                    return;
                } else {
                    if (i3 == 5) {
                        c.this.r(true);
                        return;
                    }
                    return;
                }
            }
            WeakReference weakReference = (WeakReference) obj;
            int i16 = message.what;
            if (i16 == 1) {
                c.this.h(weakReference);
            } else if (i16 == 2) {
                c.this.i(weakReference);
            } else if (i16 == 3) {
                c.this.j(weakReference);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final c f179452a = new c();
    }

    public c() {
        boolean k3 = k();
        f179448d = k3;
        if (!k3) {
            return;
        }
        this.f179449a = new LinkedList<>();
        f179447c = new a(Looper.getMainLooper());
    }

    public static void f() {
        if (!f179448d) {
            return;
        }
        Handler handler = f179447c;
        handler.sendMessage(handler.obtainMessage(4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        n("do clear");
        this.f179449a.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(WeakReference<com.tencent.mobileqq.activity.aio.item.b> weakReference) {
        if (weakReference == null) {
            m("doMoveToFirst node is null");
            return;
        }
        t(weakReference);
        m(String.format("doMoveToFirst: %h", weakReference.get()));
        if (!this.f179449a.isEmpty() && this.f179449a.getFirst() == weakReference) {
            m("doMoveToFirst node already in the first position");
            return;
        }
        if (this.f179449a.contains(weakReference)) {
            this.f179449a.remove(weakReference);
        }
        this.f179449a.addFirst(weakReference);
        r(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(WeakReference<com.tencent.mobileqq.activity.aio.item.b> weakReference) {
        if (weakReference == null) {
            m("doMoveToFirstInActive node is null");
            return;
        }
        m(String.format("doMoveToFirstInActive: %h", weakReference.get()));
        if (!this.f179449a.isEmpty() && this.f179449a.contains(weakReference)) {
            this.f179449a.remove(weakReference);
            WeakReference<com.tencent.mobileqq.activity.aio.item.b> weakReference2 = this.f179450b;
            if (weakReference2 == null) {
                this.f179449a.addLast(weakReference);
            } else {
                int indexOf = this.f179449a.indexOf(weakReference2);
                if (indexOf > 0) {
                    this.f179449a.add(indexOf, weakReference);
                }
            }
            this.f179450b = weakReference;
            r(false);
            return;
        }
        m("doMoveToFirstInActive node not in the list");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(WeakReference<com.tencent.mobileqq.activity.aio.item.b> weakReference) {
        if (weakReference == null) {
            m("doRemove node is null");
            return;
        }
        m(String.format("doRemove %h", weakReference.get()));
        t(weakReference);
        this.f179449a.remove(weakReference);
    }

    private boolean k() {
        d91.g arkPlatformConfig = ((IArkConfig) QRoute.api(IArkConfig.class)).getArkPlatformConfig();
        if (arkPlatformConfig != null && arkPlatformConfig.c() != null) {
            return arkPlatformConfig.c().f();
        }
        QLog.i("ArkApp.ArkAppContainerMRUUpdater", 1, "confBean.getConfig() get fail");
        return false;
    }

    public static c l() {
        return b.f179452a;
    }

    private static void n(String str) {
        QLog.i("ArkApp.ArkAppContainerMRUUpdater", 1, String.format(Locale.CHINA, str, new Object[0]));
    }

    public static void o(WeakReference<com.tencent.mobileqq.activity.aio.item.b> weakReference) {
        if (!f179448d) {
            return;
        }
        Handler handler = f179447c;
        handler.sendMessage(handler.obtainMessage(1, weakReference));
    }

    public static void p(WeakReference<com.tencent.mobileqq.activity.aio.item.b> weakReference) {
        if (!f179448d) {
            return;
        }
        Handler handler = f179447c;
        handler.sendMessage(handler.obtainMessage(2, weakReference));
    }

    public static void q(WeakReference<com.tencent.mobileqq.activity.aio.item.b> weakReference) {
        if (!f179448d) {
            return;
        }
        Handler handler = f179447c;
        handler.sendMessage(handler.obtainMessage(3, weakReference));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(boolean z16) {
        int i3;
        WeakReference<com.tencent.mobileqq.activity.aio.item.b> peekLast;
        if (this.f179449a.isEmpty()) {
            m("removeLast, list is empty");
            return;
        }
        int size = this.f179449a.size();
        if (z16) {
            i3 = size;
        } else {
            i3 = size - 10;
        }
        int i16 = 0;
        if (i3 <= 0) {
            i3 = 0;
        }
        int indexOf = this.f179449a.indexOf(this.f179450b);
        if (indexOf > 0) {
            i16 = size - indexOf;
        }
        if (i3 > i16) {
            i3 = i16;
        }
        m("removeLast, size = " + size + ", toBeRemovedCount = " + i3 + " , numOfInactive = " + i16);
        while (true) {
            int i17 = i3 - 1;
            if (i3 <= 0 || (peekLast = this.f179449a.peekLast()) == null) {
                break;
            }
            com.tencent.mobileqq.activity.aio.item.b bVar = peekLast.get();
            if (bVar != null) {
                n("destroy wrapper");
                bVar.doOnEvent(2);
                com.tencent.mobileqq.activity.aio.item.b.m(bVar);
                com.tencent.mobileqq.activity.aio.item.b.k(bVar);
            }
            j(peekLast);
            i3 = i17;
        }
        s();
    }

    private void t(WeakReference<com.tencent.mobileqq.activity.aio.item.b> weakReference) {
        WeakReference<com.tencent.mobileqq.activity.aio.item.b> weakReference2;
        if (weakReference != null && (weakReference2 = this.f179450b) == weakReference) {
            int indexOf = this.f179449a.indexOf(weakReference2);
            int size = this.f179449a.size();
            if (indexOf != -1 && indexOf != size - 1 && size != 0) {
                this.f179450b = this.f179449a.get(indexOf + 1);
            } else {
                this.f179450b = null;
            }
        }
    }

    private void s() {
    }

    private static void m(String str) {
    }
}
