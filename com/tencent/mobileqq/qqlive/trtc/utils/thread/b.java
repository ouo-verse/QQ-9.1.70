package com.tencent.mobileqq.qqlive.trtc.utils.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.trtc.utils.lock.RTCReadWriteLock;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f273386a;

    /* renamed from: b, reason: collision with root package name */
    private a f273387b;

    /* renamed from: c, reason: collision with root package name */
    private Looper f273388c;

    /* renamed from: d, reason: collision with root package name */
    private RTCReadWriteLock f273389d;

    /* renamed from: e, reason: collision with root package name */
    private Object f273390e;

    /* renamed from: f, reason: collision with root package name */
    private Class<?> f273391f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a extends Handler {
        static IPatchRedirector $redirector_;

        a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            } else if (b.this.f273390e != null) {
                b.this.k(message.what, message.obj);
            } else {
                QLog.e(b.this.f273386a, 1, "handle listener is null, return");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqlive.trtc.utils.thread.b$b, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static class C8401b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public Object f273393a;

        /* renamed from: b, reason: collision with root package name */
        public com.tencent.mobileqq.qqlive.trtc.utils.thread.a f273394b;

        C8401b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public b(String str, Looper looper, @NonNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, looper, obj);
            return;
        }
        this.f273386a = str;
        this.f273388c = looper;
        this.f273389d = new RTCReadWriteLock();
        this.f273387b = new a(this.f273388c);
        this.f273390e = obj;
        Class<?> cls = obj.getClass();
        this.f273391f = cls;
        if (RTCThreadAnnotations.k(cls, 0)) {
            return;
        }
        QLog.e(this.f273386a, 1, "Register " + this.f273391f.getName() + " @ThreadSwitch method failed");
        throw new RuntimeException("register @ThreadSwitch method failed, player can not work");
    }

    private Object d(String str, Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        String name = RTCThreadAnnotations.b(this.f273391f, str, g(obj2)).getReturnType().getName();
        if (name.equals(HippyControllerProps.BOOLEAN)) {
            return Boolean.FALSE;
        }
        if (name.equals(PoiListCacheRecord.WEIGHT_TYPE)) {
            return 0;
        }
        if (name.equals(PoiListCacheRecord.TIMESTAMP_TYPE)) {
            return 0L;
        }
        return null;
    }

    private Object[] g(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof C8401b) {
            Object obj2 = ((C8401b) obj).f273393a;
            if (obj2 == null) {
                return null;
            }
            return (Object[]) obj2;
        }
        return (Object[]) obj;
    }

    private boolean h(int i3, int i16, int i17, Object obj, boolean z16, boolean z17, long j3) {
        if (this.f273387b == null) {
            QLog.e(this.f273386a, 1, l(i3) + " , send failed , handler null");
            return false;
        }
        if (z16 && obj == null) {
            QLog.e(this.f273386a, 1, l(i3) + ", send failed , params null");
            return false;
        }
        if (!this.f273388c.getThread().isAlive()) {
            QLog.e(this.f273386a, 1, l(i3) + ", send failed , thread had dead");
            return false;
        }
        this.f273389d.readLock().lock();
        if (z17) {
            this.f273387b.removeMessages(i3);
        }
        Message obtainMessage = this.f273387b.obtainMessage();
        obtainMessage.what = i3;
        obtainMessage.arg1 = i16;
        obtainMessage.arg2 = i17;
        obtainMessage.obj = obj;
        this.f273387b.sendMessageDelayed(obtainMessage, j3);
        this.f273389d.readLock().unlock();
        return true;
    }

    private boolean i(int i3, Object obj) {
        return h(i3, 0, 0, obj, false, false, 0L);
    }

    private Object j(int i3, Object obj) {
        com.tencent.mobileqq.qqlive.trtc.utils.thread.a aVar = new com.tencent.mobileqq.qqlive.trtc.utils.thread.a();
        C8401b c8401b = new C8401b();
        c8401b.f273393a = obj;
        c8401b.f273394b = aVar;
        i(i3, c8401b);
        try {
            return aVar.a(500L);
        } catch (Exception e16) {
            QLog.e(this.f273386a, 1, l(i3) + " , internalMessageLock getResult has exception:" + e16.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i3, Object obj) {
        Object invoke;
        Method c16 = RTCThreadAnnotations.c(this.f273391f, i3);
        if (c16 != null) {
            try {
                if (c16.getParameterTypes().length == 0) {
                    invoke = c16.invoke(this.f273390e, new Object[0]);
                } else {
                    invoke = c16.invoke(this.f273390e, g(obj));
                }
                if (obj instanceof C8401b) {
                    ((C8401b) obj).f273394b.b(invoke);
                    return;
                }
                return;
            } catch (Exception e16) {
                QLog.e(this.f273386a, 1, "invokeMethod " + c16.getName() + " has excecption: " + e16.toString());
                return;
            }
        }
        QLog.e(this.f273386a, 1, "invokeMethod, handle method name is empty, msg:" + i3);
        throw new RuntimeException("invokeMethod, handle method name is empty");
    }

    private String l(int i3) {
        String a16 = RTCThreadAnnotations.a(this.f273391f, i3);
        if (!TextUtils.isEmpty(a16) && !a16.equals("unknown")) {
            return a16;
        }
        return i3 + " not find";
    }

    public Object e(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, obj);
        }
        if (!TextUtils.isEmpty(str)) {
            int d16 = RTCThreadAnnotations.d(this.f273391f, str, g(obj));
            if (d16 >= 0) {
                if (RTCThreadAnnotations.j(this.f273391f, d16)) {
                    return j(d16, obj);
                }
                i(d16, obj);
                return null;
            }
            QLog.e(this.f273386a, 1, "dealThreadSwitch failed , not match method:" + str);
            throw new RuntimeException("dealThreadSwitch failed , not match method:" + str);
        }
        QLog.e(this.f273386a, 1, "dealThreadSwitch failed , methodName is null");
        throw new RuntimeException("dealThreadSwitch failed , methodName is null");
    }

    public Object f(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, obj);
        }
        return d(str, e(str, obj), obj);
    }
}
