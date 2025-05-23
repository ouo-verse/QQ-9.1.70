package com.tencent.guild.aio.msglist.ark;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.guild.aio.help.GuildArkContainerHelper;
import com.tencent.guild.api.ark.IGuildArkApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes6.dex */
public class d {

    /* renamed from: c, reason: collision with root package name */
    private static Handler f111203c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f111204d;

    /* renamed from: a, reason: collision with root package name */
    LinkedList<WeakReference<tp0.a>> f111205a;

    /* renamed from: b, reason: collision with root package name */
    WeakReference<tp0.a> f111206b;

    /* compiled from: P */
    /* loaded from: classes6.dex */
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
                    d.this.g();
                    return;
                } else {
                    if (i3 == 5) {
                        d.this.q(true);
                        return;
                    }
                    return;
                }
            }
            WeakReference weakReference = (WeakReference) obj;
            int i16 = message.what;
            if (i16 == 1) {
                d.this.h(weakReference);
            } else if (i16 == 2) {
                d.this.i(weakReference);
            } else if (i16 == 3) {
                d.this.j(weakReference);
            }
        }
    }

    public d() {
        boolean k3 = k();
        f111204d = k3;
        if (!k3) {
            return;
        }
        this.f111205a = new LinkedList<>();
        f111203c = new a(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        m("do clear");
        this.f111205a.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(WeakReference<tp0.a> weakReference) {
        if (weakReference == null) {
            l("doMoveToFirst node is null");
            return;
        }
        s(weakReference);
        l(String.format("doMoveToFirst: %h", weakReference.get()));
        if (!this.f111205a.isEmpty() && this.f111205a.getFirst() == weakReference) {
            l("doMoveToFirst node already in the first position");
            return;
        }
        if (this.f111205a.contains(weakReference)) {
            this.f111205a.remove(weakReference);
        }
        this.f111205a.addFirst(weakReference);
        q(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(WeakReference<tp0.a> weakReference) {
        if (weakReference == null) {
            l("doMoveToFirstInActive node is null");
            return;
        }
        l(String.format("doMoveToFirstInActive: %h", weakReference.get()));
        if (!this.f111205a.isEmpty() && this.f111205a.contains(weakReference)) {
            this.f111205a.remove(weakReference);
            WeakReference<tp0.a> weakReference2 = this.f111206b;
            if (weakReference2 == null) {
                this.f111205a.addLast(weakReference);
            } else {
                int indexOf = this.f111205a.indexOf(weakReference2);
                if (indexOf > 0) {
                    this.f111205a.add(indexOf, weakReference);
                }
            }
            this.f111206b = weakReference;
            q(false);
            return;
        }
        l("doMoveToFirstInActive node not in the list");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(WeakReference<tp0.a> weakReference) {
        if (weakReference == null) {
            l("doRemove node is null");
            return;
        }
        l(String.format("doRemove %h", weakReference.get()));
        s(weakReference);
        this.f111205a.remove(weakReference);
    }

    private boolean k() {
        return ((IGuildArkApi) QRoute.api(IGuildArkApi.class)).isOptimizeEnable();
    }

    private static void m(String str) {
        QLog.i("ArkApp.GuildArkAppContainerMRUUpdater", 1, String.format(Locale.CHINA, str, new Object[0]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(boolean z16) {
        int i3;
        WeakReference<tp0.a> peekLast;
        if (this.f111205a.isEmpty()) {
            l("removeLast, list is empty");
            return;
        }
        int size = this.f111205a.size();
        if (z16) {
            i3 = size;
        } else {
            i3 = size - 10;
        }
        int i16 = 0;
        int max = Math.max(i3, 0);
        int indexOf = this.f111205a.indexOf(this.f111206b);
        if (indexOf > 0) {
            i16 = size - indexOf;
        }
        int min = Math.min(max, i16);
        l("removeLast, size = " + size + ", toBeRemovedCount = " + min + " , numOfInactive = " + i16);
        while (true) {
            int i17 = min - 1;
            if (min <= 0 || (peekLast = this.f111205a.peekLast()) == null) {
                break;
            }
            tp0.a aVar = peekLast.get();
            if (aVar != null) {
                m("destroy wrapper");
                GuildArkContainerHelper.INSTANCE.a(aVar.a(), peekLast);
                aVar.doOnEvent(2);
            }
            j(peekLast);
            min = i17;
        }
        r();
    }

    private void s(WeakReference<tp0.a> weakReference) {
        WeakReference<tp0.a> weakReference2;
        if (weakReference != null && (weakReference2 = this.f111206b) == weakReference) {
            int indexOf = this.f111205a.indexOf(weakReference2);
            int size = this.f111205a.size();
            if (indexOf != -1 && indexOf != size - 1 && size != 0) {
                this.f111206b = this.f111205a.get(indexOf + 1);
            } else {
                this.f111206b = null;
            }
        }
    }

    public void f() {
        if (!f111204d) {
            return;
        }
        Handler handler = f111203c;
        handler.sendMessage(handler.obtainMessage(4));
    }

    public void n(WeakReference<tp0.a> weakReference) {
        if (!f111204d) {
            return;
        }
        Handler handler = f111203c;
        handler.sendMessage(handler.obtainMessage(1, weakReference));
    }

    public void o(WeakReference<tp0.a> weakReference) {
        if (!f111204d) {
            return;
        }
        Handler handler = f111203c;
        handler.sendMessage(handler.obtainMessage(2, weakReference));
    }

    public void p(WeakReference<tp0.a> weakReference) {
        if (!f111204d) {
            return;
        }
        Handler handler = f111203c;
        handler.sendMessage(handler.obtainMessage(3, weakReference));
    }

    private void r() {
    }

    private static void l(String str) {
    }
}
