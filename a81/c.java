package a81;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.aio.helper.t;
import com.tencent.mobileqq.aio.msglist.holder.component.ark.view.ArkAppContainer;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    private static final boolean f25677c = com.tencent.qqnt.util.b.f362976b.isDebugVersion();

    /* renamed from: d, reason: collision with root package name */
    private static Handler f25678d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f25679e;

    /* renamed from: a, reason: collision with root package name */
    LinkedList<WeakReference<ArkAppContainer>> f25680a;

    /* renamed from: b, reason: collision with root package name */
    WeakReference<ArkAppContainer> f25681b;

    /* compiled from: P */
    /* loaded from: classes11.dex */
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
                        c.this.q(true);
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

    public c() {
        boolean k3 = k();
        f25679e = k3;
        if (!k3) {
            return;
        }
        this.f25680a = new LinkedList<>();
        f25678d = new a(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        m("do clear");
        this.f25680a.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(WeakReference<ArkAppContainer> weakReference) {
        if (weakReference == null) {
            l("doMoveToFirst node is null");
            return;
        }
        s(weakReference);
        l(String.format("doMoveToFirst: %h", weakReference.get()));
        if (!this.f25680a.isEmpty() && this.f25680a.getFirst() == weakReference) {
            l("doMoveToFirst node already in the first position");
            return;
        }
        if (this.f25680a.contains(weakReference)) {
            this.f25680a.remove(weakReference);
        }
        this.f25680a.addFirst(weakReference);
        q(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(WeakReference<ArkAppContainer> weakReference) {
        if (weakReference == null) {
            l("doMoveToFirstInActive node is null");
            return;
        }
        l(String.format("doMoveToFirstInActive: %h", weakReference.get()));
        if (!this.f25680a.isEmpty() && this.f25680a.contains(weakReference)) {
            this.f25680a.remove(weakReference);
            WeakReference<ArkAppContainer> weakReference2 = this.f25681b;
            if (weakReference2 == null) {
                this.f25680a.addLast(weakReference);
            } else {
                int indexOf = this.f25680a.indexOf(weakReference2);
                if (indexOf > 0) {
                    this.f25680a.add(indexOf, weakReference);
                }
            }
            this.f25681b = weakReference;
            q(false);
            return;
        }
        l("doMoveToFirstInActive node not in the list");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(WeakReference<ArkAppContainer> weakReference) {
        if (weakReference == null) {
            l("doRemove node is null");
            return;
        }
        l(String.format("doRemove %h", weakReference.get()));
        s(weakReference);
        this.f25680a.remove(weakReference);
    }

    private boolean k() {
        if (f25677c) {
            return true;
        }
        return false;
    }

    private static void l(String str) {
        if (f25677c) {
            QLog.d("ArkApp.GuildArkAppContainerMRUUpdater", 4, String.format(Locale.CHINA, str, new Object[0]));
        }
    }

    private static void m(String str) {
        QLog.i("ArkApp.GuildArkAppContainerMRUUpdater", 1, String.format(Locale.CHINA, str, new Object[0]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(boolean z16) {
        int i3;
        WeakReference<ArkAppContainer> peekLast;
        if (this.f25680a.isEmpty()) {
            l("removeLast, list is empty");
            return;
        }
        int size = this.f25680a.size();
        if (z16) {
            i3 = size;
        } else {
            i3 = size - 10;
        }
        int i16 = 0;
        int max = Math.max(i3, 0);
        int indexOf = this.f25680a.indexOf(this.f25681b);
        if (indexOf > 0) {
            i16 = size - indexOf;
        }
        int min = Math.min(max, i16);
        l("removeLast, size = " + size + ", toBeRemovedCount = " + min + " , numOfInactive = " + i16);
        while (true) {
            int i17 = min - 1;
            if (min <= 0 || (peekLast = this.f25680a.peekLast()) == null) {
                break;
            }
            ArkAppContainer arkAppContainer = peekLast.get();
            if (arkAppContainer != null) {
                m("destroy wrapper");
                t.INSTANCE.a(arkAppContainer.c(), peekLast);
                arkAppContainer.doOnEvent(2);
                arkAppContainer.j(null);
            }
            j(peekLast);
            min = i17;
        }
        r();
    }

    private void r() {
        Object obj;
        if (f25677c) {
            Iterator<WeakReference<ArkAppContainer>> it = this.f25680a.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                WeakReference<ArkAppContainer> next = it.next();
                Object[] objArr = new Object[3];
                int i16 = i3 + 1;
                objArr[0] = Integer.valueOf(i3);
                objArr[1] = next.get();
                WeakReference<ArkAppContainer> weakReference = this.f25681b;
                if (weakReference == null) {
                    obj = 0;
                } else {
                    obj = weakReference.get();
                }
                objArr[2] = obj;
                l(String.format("traverse, %d: %h , first inactive node:%h", objArr));
                i3 = i16;
            }
        }
    }

    private void s(WeakReference<ArkAppContainer> weakReference) {
        WeakReference<ArkAppContainer> weakReference2;
        if (weakReference != null && (weakReference2 = this.f25681b) == weakReference) {
            int indexOf = this.f25680a.indexOf(weakReference2);
            int size = this.f25680a.size();
            if (indexOf != -1 && indexOf != size - 1 && size != 0) {
                this.f25681b = this.f25680a.get(indexOf + 1);
            } else {
                this.f25681b = null;
            }
        }
    }

    public void f() {
        if (!f25679e) {
            return;
        }
        Handler handler = f25678d;
        handler.sendMessage(handler.obtainMessage(4));
    }

    public void n(WeakReference<ArkAppContainer> weakReference) {
        if (!f25679e) {
            return;
        }
        Handler handler = f25678d;
        handler.sendMessage(handler.obtainMessage(1, weakReference));
    }

    public void o(WeakReference<ArkAppContainer> weakReference) {
        if (!f25679e) {
            return;
        }
        Handler handler = f25678d;
        handler.sendMessage(handler.obtainMessage(2, weakReference));
    }

    public void p(WeakReference<ArkAppContainer> weakReference) {
        if (!f25679e) {
            return;
        }
        Handler handler = f25678d;
        handler.sendMessage(handler.obtainMessage(3, weakReference));
    }
}
