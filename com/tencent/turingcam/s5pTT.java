package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes27.dex */
public class s5pTT {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final String f382356a;

    /* renamed from: b, reason: collision with root package name */
    private static final String f382357b;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class spXPg {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public Object f382358a;

        public spXPg() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public <T> T a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (T) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (T) this.f382358a;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18652);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f382356a = FxCVY.b("mdNjPO1K7FJ+9CbSnlMtKMQ1GBI=");
            f382357b = FxCVY.b("atljSFyftxO7USe0FJAEN952jDJYW1+B");
        }
    }

    public static boolean a(Object obj, String str, spXPg spxpg) {
        try {
            Field field = (Field) Class.class.getDeclaredMethod(f382356a, String.class).invoke(obj.getClass(), str);
            if (field != null) {
                field.setAccessible(true);
                Object obj2 = field.get(obj);
                field.setAccessible(false);
                spxpg.f382358a = obj2;
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean a(Object obj, String str, Class[] clsArr, Object[] objArr) {
        try {
            Method method = (Method) Class.class.getDeclaredMethod(f382357b, String.class, Class[].class).invoke(obj.getClass(), str, clsArr);
            if (method != null) {
                method.setAccessible(true);
                method.invoke(obj, objArr);
                method.setAccessible(false);
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
