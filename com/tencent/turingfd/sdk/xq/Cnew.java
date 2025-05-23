package com.tencent.turingfd.sdk.xq;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.turingfd.sdk.xq.Cnative;
import java.lang.reflect.Method;

/* compiled from: P */
/* renamed from: com.tencent.turingfd.sdk.xq.new, reason: invalid class name */
/* loaded from: classes27.dex */
public class Cnew implements Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final Handler.Callback f383405a;

    /* renamed from: b, reason: collision with root package name */
    public final Ctry f383406b;

    /* renamed from: c, reason: collision with root package name */
    public final String f383407c;

    public Cnew(Handler.Callback callback, Ctry ctry, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, callback, ctry, str);
            return;
        }
        this.f383405a = callback;
        this.f383406b = ctry;
        this.f383407c = str;
    }

    public final boolean a(Message message) {
        Object a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) message)).booleanValue();
        }
        Object obj = message.obj;
        if (obj == null) {
            return false;
        }
        Object a17 = Coconut.a(obj.getClass(), "argi3", message.obj);
        if (!(a17 instanceof Integer) || (a16 = Coconut.a(message.obj.getClass(), "arg1", message.obj)) == null) {
            return false;
        }
        Class<?> cls = a16.getClass();
        Class[] clsArr = {Boolean.TYPE, Integer.TYPE};
        Object[] objArr = {Boolean.FALSE, a17};
        try {
            Method a18 = Coconut.a(cls, "setPerformAccessibilityActionResult", (Class<?>[]) clsArr);
            if (a18 != null) {
                a18.invoke(a16, objArr);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0047 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0048 A[Catch: all -> 0x0051, TryCatch #0 {all -> 0x0051, blocks: (B:10:0x0017, B:12:0x001c, B:15:0x0034, B:17:0x003c, B:22:0x0048, B:24:0x004c, B:28:0x002b), top: B:9:0x0017 }] */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(Message message) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 1) {
            Ctry ctry = this.f383406b;
            String str = this.f383407c;
            Cnative.Cdo cdo = (Cnative.Cdo) ctry;
            if (!cdo.f383403a.get()) {
                cdo.f383404b.obtainMessage(1, str).sendToTarget();
            }
            if (CanisMajor.f382623a.get() && a(message)) {
                z16 = true;
                if (!z16) {
                    return true;
                }
                Handler.Callback callback = this.f383405a;
                if (callback != null) {
                    return callback.handleMessage(message);
                }
                return false;
            }
        }
        z16 = false;
        if (!z16) {
        }
    }
}
