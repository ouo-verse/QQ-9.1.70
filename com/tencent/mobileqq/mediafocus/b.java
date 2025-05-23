package com.tencent.mobileqq.mediafocus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.mediafocus.MediaFocusController;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b implements MediaFocusController.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Object f245799a;

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<String, c> f245800b;

    /* renamed from: c, reason: collision with root package name */
    private final HashMap<String, Integer> f245801c;

    /* renamed from: d, reason: collision with root package name */
    private final a f245802d;

    /* renamed from: e, reason: collision with root package name */
    private MediaFocusController f245803e;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final Handler f245804a;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.mediafocus.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes15.dex */
        class HandlerC8023a extends Handler {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f245806a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            HandlerC8023a(Looper looper, b bVar) {
                super(looper);
                this.f245806a = bVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, a.this, looper, bVar);
                }
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c f16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    synchronized (b.this.f245799a) {
                        f16 = b.this.f((String) message.obj);
                    }
                    if (f16 != null) {
                        f16.a(message.what);
                        return;
                    }
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                return;
            }
            Looper myLooper = Looper.myLooper();
            myLooper = myLooper == null ? Looper.getMainLooper() : myLooper;
            if (myLooper != null) {
                this.f245804a = new HandlerC8023a(myLooper, b.this);
            } else {
                this.f245804a = null;
            }
        }

        Handler a() {
            return this.f245804a;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.mediafocus.b$b, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    private static class C8024b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final b f245808a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36635);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f245808a = new b();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface c {
        void a(int i3);
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f245799a = new Object();
        this.f245800b = new HashMap<>();
        this.f245801c = new HashMap<>();
        this.f245802d = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c f(String str) {
        return this.f245800b.get(str);
    }

    private String h(c cVar) {
        if (cVar == null) {
            return new String(toString());
        }
        return new String(toString() + cVar.toString());
    }

    public static final b i() {
        return C8024b.f245808a;
    }

    private void k(c cVar) {
        synchronized (this.f245799a) {
            if (this.f245803e == null) {
                this.f245803e = new MediaFocusController(this);
            }
            String h16 = h(cVar);
            if (this.f245801c.containsKey(h16)) {
                this.f245801c.put(h16, Integer.valueOf(this.f245801c.get(h16).intValue() + 1));
            } else {
                this.f245801c.put(h16, 1);
            }
            if (this.f245800b.containsKey(h16)) {
                return;
            }
            this.f245800b.put(h16, cVar);
        }
    }

    private boolean m(c cVar, boolean z16) {
        synchronized (this.f245799a) {
            String h16 = h(cVar);
            boolean z17 = true;
            if (!z16) {
                this.f245801c.remove(h16);
                this.f245800b.remove(h16);
                return true;
            }
            if (this.f245801c.containsKey(h16)) {
                int intValue = this.f245801c.get(h16).intValue();
                if (intValue > 1) {
                    this.f245801c.put(h16, Integer.valueOf(intValue - 1));
                    z17 = false;
                } else {
                    this.f245801c.remove(h16);
                    this.f245800b.remove(h16);
                }
            } else {
                this.f245800b.remove(h16);
            }
            return z17;
        }
    }

    @Override // com.tencent.mobileqq.mediafocus.MediaFocusController.a
    public void a(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MediaFocusManager", 2, "onDispatch focus:", Integer.valueOf(i3), " ,id:", str);
        }
        this.f245802d.a().sendMessage(this.f245802d.a().obtainMessage(i3, str));
    }

    public int d(c cVar) {
        MediaFocusController mediaFocusController;
        String obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar)).intValue();
        }
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[2];
            objArr[0] = "abandonMediaFocus! listener:";
            if (cVar == null) {
                obj = "null";
            } else {
                obj = cVar.toString();
            }
            objArr[1] = obj;
            QLog.d("MediaFocusManager", 2, objArr);
        }
        if (!m(cVar, true) || (mediaFocusController = this.f245803e) == null) {
            return 1;
        }
        return mediaFocusController.k(h(cVar));
    }

    public int e(c cVar) {
        MediaFocusController mediaFocusController;
        String obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) cVar)).intValue();
        }
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[2];
            objArr[0] = "abandonMediaFocusForce! listener:";
            if (cVar == null) {
                obj = "null";
            } else {
                obj = cVar.toString();
            }
            objArr[1] = obj;
            QLog.d("MediaFocusManager", 2, objArr);
        }
        if (!m(cVar, false) || (mediaFocusController = this.f245803e) == null) {
            return 1;
        }
        return mediaFocusController.k(h(cVar));
    }

    public List<MediaFocusStackItem> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        MediaFocusController mediaFocusController = this.f245803e;
        if (mediaFocusController == null) {
            return null;
        }
        return mediaFocusController.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean j(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        MediaFocusController mediaFocusController = this.f245803e;
        if (mediaFocusController != null) {
            return mediaFocusController.c(str, str2);
        }
        return false;
    }

    public int l(int i3, c cVar) {
        String obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) cVar)).intValue();
        }
        if (i3 >= 1 && i3 <= 3) {
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[4];
                objArr[0] = "requestMediaFocus focusType:";
                objArr[1] = Integer.valueOf(i3);
                objArr[2] = " ,listener:";
                if (cVar == null) {
                    obj = "null";
                } else {
                    obj = cVar.toString();
                }
                objArr[3] = obj;
                QLog.d("MediaFocusManager", 2, objArr);
            }
            k(cVar);
            MediaFocusController mediaFocusController = this.f245803e;
            if (mediaFocusController == null) {
                return 1;
            }
            return mediaFocusController.l(i3, h(cVar));
        }
        QLog.e("MediaFocusManager", 1, "requestMediaFocus denied, Invalid type:", Integer.valueOf(i3));
        return 1;
    }

    @Override // com.tencent.mobileqq.mediafocus.MediaFocusController.a
    public void onClear() {
        MediaFocusController mediaFocusController;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MediaFocusManager", 2, "onClear map:", Integer.valueOf(this.f245800b.size()));
        }
        if (this.f245800b.isEmpty() && (mediaFocusController = this.f245803e) != null) {
            mediaFocusController.d();
            this.f245803e = null;
        }
    }
}
