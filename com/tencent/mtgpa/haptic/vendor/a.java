package com.tencent.mtgpa.haptic.vendor;

import android.content.Context;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes21.dex */
public class a extends com.tencent.mtgpa.haptic.base.a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f336889b = false;

    /* renamed from: c, reason: collision with root package name */
    private static Class f336890c = null;

    /* renamed from: d, reason: collision with root package name */
    private static Method f336891d = null;

    /* renamed from: e, reason: collision with root package name */
    private static Class f336892e = null;

    /* renamed from: f, reason: collision with root package name */
    private static Constructor<?> f336893f = null;

    /* renamed from: g, reason: collision with root package name */
    private static Method f336894g = null;

    /* renamed from: h, reason: collision with root package name */
    private static Method f336895h = null;

    /* renamed from: i, reason: collision with root package name */
    private static Method f336896i = null;

    /* renamed from: j, reason: collision with root package name */
    private static Method f336897j = null;

    /* renamed from: k, reason: collision with root package name */
    private static Method f336898k = null;

    /* renamed from: l, reason: collision with root package name */
    private static Method f336899l = null;

    /* renamed from: m, reason: collision with root package name */
    private static Method f336900m = null;

    /* renamed from: n, reason: collision with root package name */
    private static Method f336901n = null;

    /* renamed from: o, reason: collision with root package name */
    private static Method f336902o = null;

    /* renamed from: p, reason: collision with root package name */
    private static boolean f336903p = false;

    /* renamed from: a, reason: collision with root package name */
    private Object f336904a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15519);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f336904a = null;
        }
    }

    public static synchronized boolean c() {
        Method method;
        synchronized (a.class) {
            if (f336903p) {
                if (f336889b) {
                    Log.d("StandardHapticPlayer", "no need to check again, the api is available!");
                }
                return f336903p;
            }
            try {
                f336890c = Class.forName("android.os.DynamicEffect");
                Class<?> cls = Class.forName("android.os.HapticPlayer");
                f336892e = cls;
                f336893f = cls.getConstructor(f336890c);
                try {
                    f336891d = d(f336890c, OperateCustomButton.OPERATE_CREATE, String.class);
                    f336894g = d(f336892e, "isAvailable", new Class[0]);
                    Class cls2 = f336892e;
                    Class cls3 = Integer.TYPE;
                    f336895h = d(cls2, "start", cls3);
                    f336896i = d(f336892e, "stop", new Class[0]);
                    f336897j = d(f336892e, "start", cls3, cls3, cls3);
                    f336898k = d(f336892e, "start", cls3, cls3, cls3, cls3);
                    f336899l = d(f336892e, "updateInterval", cls3);
                    f336900m = d(f336892e, "updateAmplitude", cls3);
                    f336901n = d(f336892e, "updateFrequency", cls3);
                    f336902o = d(f336892e, "updateParameter", cls3, cls3, cls3);
                } catch (Exception e16) {
                    e16.printStackTrace();
                    Log.w("StandardHapticPlayer", "find DynamicEffect/HapticPlayer class method exception in this os version!");
                }
                if (f336891d != null && (method = f336894g) != null && f336895h != null && f336896i != null) {
                    try {
                        f336903p = ((Boolean) method.invoke(f336892e, new Object[0])).booleanValue();
                    } catch (Exception e17) {
                        e17.printStackTrace();
                        Log.w("StandardHapticPlayer", "invoke HapticPlayer isAvailable method exception in this os version!");
                    }
                } else {
                    Log.i("StandardHapticPlayer", "This os version don't support standard haptic player, some necessary method is missing!");
                }
                return f336903p;
            } catch (ClassNotFoundException unused) {
                Log.w("StandardHapticPlayer", "can't find DynamicEffect/HapticPlayer class in this os version!");
                return false;
            } catch (NoSuchMethodException unused2) {
                Log.w("StandardHapticPlayer", "can't find HapticPlayer constructor in this os version!");
                return false;
            } catch (Exception e18) {
                e18.printStackTrace();
                Log.w("StandardHapticPlayer", "find DynamicEffect class exception in this os version!");
                return false;
            }
        }
    }

    private static Method d(Class<?> cls, String str, Class<?>... clsArr) {
        String str2;
        if (cls != null && str != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Exception unused) {
                str2 = String.format("Didn't find class %s 's method %s with %d arg!", cls.getName(), str, Integer.valueOf(clsArr.length));
            }
        } else {
            str2 = "get class method failed!";
        }
        Log.w("StandardHapticPlayer", str2);
        return null;
    }

    private void f(String str, int i3, int i16, int i17) {
        try {
            Object newInstance = f336893f.newInstance(f336891d.invoke(f336890c, str));
            this.f336904a = newInstance;
            Method method = f336897j;
            if (method != null) {
                method.invoke(newInstance, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            } else {
                f336895h.invoke(newInstance, Integer.valueOf(i3));
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | Exception e16) {
            e16.printStackTrace();
        }
    }

    private void g(String str, int i3, int i16, int i17, int i18) {
        if (f336898k != null) {
            try {
                Object newInstance = f336893f.newInstance(f336891d.invoke(f336890c, str));
                this.f336904a = newInstance;
                f336898k.invoke(newInstance, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                return;
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException | Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
        f(str, i3, i16, i17);
    }

    @Override // com.tencent.mtgpa.haptic.base.a
    public void a(String str, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            if (!e()) {
                return;
            }
            if (i18 != -1) {
                g(str, i3, i16, i17, i18);
            } else {
                f(str, i3, i16, i17);
            }
        }
    }

    @Override // com.tencent.mtgpa.haptic.base.a
    public void b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
        }
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return f336903p;
    }
}
