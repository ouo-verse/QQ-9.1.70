package com.tencent.turingcam;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.turingcam.AExmx;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes27.dex */
public class q0QQ5 implements Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final Handler.Callback f382340a;

    /* renamed from: b, reason: collision with root package name */
    public final XSZyU f382341b;

    /* renamed from: c, reason: collision with root package name */
    public final String f382342c;

    public q0QQ5(Handler.Callback callback, XSZyU xSZyU, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, callback, xSZyU, str);
            return;
        }
        this.f382340a = callback;
        this.f382341b = xSZyU;
        this.f382342c = str;
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
        Object a17 = rBDKv.a(obj.getClass(), "argi3", message.obj);
        if (!(a17 instanceof Integer) || (a16 = rBDKv.a(message.obj.getClass(), "arg1", message.obj)) == null) {
            return false;
        }
        Class<?> cls = a16.getClass();
        Class[] clsArr = {Boolean.TYPE, Integer.TYPE};
        Object[] objArr = {Boolean.FALSE, a17};
        try {
            Method a18 = rBDKv.a(cls, "setPerformAccessibilityActionResult", (Class<?>[]) clsArr);
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
            XSZyU xSZyU = this.f382341b;
            String str = this.f382342c;
            AExmx.spXPg spxpg = (AExmx.spXPg) xSZyU;
            if (!spxpg.f381721a.get()) {
                spxpg.f381722b.obtainMessage(1, str).sendToTarget();
            }
            if (vneRm.f382408a.get() && a(message)) {
                z16 = true;
                if (!z16) {
                    return true;
                }
                Handler.Callback callback = this.f382340a;
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
