package com.tencent.theme;

import android.content.res.Resources;
import android.os.Build;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Field;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class l {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    private static volatile l f376076h;

    /* renamed from: a, reason: collision with root package name */
    private Resources f376077a;

    /* renamed from: b, reason: collision with root package name */
    Field f376078b;

    /* renamed from: c, reason: collision with root package name */
    Object f376079c;

    /* renamed from: d, reason: collision with root package name */
    Field f376080d;

    /* renamed from: e, reason: collision with root package name */
    Field f376081e;

    /* renamed from: f, reason: collision with root package name */
    Object f376082f;

    /* renamed from: g, reason: collision with root package name */
    LongSparseArray f376083g;

    l(Resources resources) throws NoSuchFieldException, IllegalAccessException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) resources);
            return;
        }
        if (SkinEngine.IS_NOUGAT) {
            Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
            this.f376078b = declaredField;
            declaredField.setAccessible(true);
            this.f376079c = this.f376078b.get(resources);
            this.f376077a = resources;
        }
    }

    public static l a(Resources resources) throws NoSuchFieldException, IllegalAccessException {
        if (f376076h == null) {
            synchronized (l.class) {
                if (f376076h == null) {
                    f376076h = new l(resources);
                }
            }
        }
        return f376076h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(Resources resources) {
        try {
            Class<?> cls = resources.getClass();
            if (cls.getName().equals("android.content.res.MiuiResources")) {
                Field declaredField = cls.getDeclaredField("sPreloadDrawableSources");
                declaredField.setAccessible(true);
                if (declaredField.get(resources) == null) {
                    declaredField.set(resources, new SparseArray());
                    SkinEngine.IS_PROBLEM_MIUI = true;
                }
            }
        } catch (Exception e16) {
            m.b(SkinEngine.TAG, 1, "init miui error : ", e16);
            SkinEngine.IS_PROBLEM_MIUI = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(Resources resources) {
        if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING.equalsIgnoreCase(Build.BRAND)) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mALDC");
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(resources);
                    if (obj instanceof Map) {
                        ((Map) obj).clear();
                        m.e(SkinEngine.TAG, 2, "clear mALDC suss", null);
                    } else {
                        m.e(SkinEngine.TAG, 1, "clear fail, mALDC type:" + obj, null);
                    }
                } else {
                    m.e(SkinEngine.TAG, 1, "clear fail, null == f", null);
                }
            } catch (Throwable th5) {
                m.d(SkinEngine.TAG, 1, "clear mALDC Error", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(Resources resources) {
        try {
            Field declaredField = resources.getClass().getDeclaredField("mIcons");
            SkinEngine.mIconsOfCM = declaredField;
            declaredField.setAccessible(true);
            SkinEngine.mIconsOfCM.set(resources, null);
            SkinEngine.mIconsOfCM.setAccessible(false);
            Field declaredField2 = resources.getClass().getDeclaredField("mComposedIconInfo");
            SkinEngine.mComposedIconInfoOfCM = declaredField2;
            declaredField2.setAccessible(true);
            SkinEngine.mComposedIconInfoOfCM.set(resources, null);
            SkinEngine.mComposedIconInfoOfCM.setAccessible(false);
            SkinEngine.IS_PROBLEM_CM11 = true;
        } catch (Exception unused) {
            SkinEngine.mIconsOfCM = null;
            SkinEngine.mComposedIconInfoOfCM = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Resources resources) throws NoSuchFieldException, IllegalAccessException {
        if (SkinEngine.IS_NOUGAT) {
            try {
                this.f376081e = this.f376079c.getClass().getDeclaredField("sPreloadedComplexColors");
            } catch (NoSuchFieldException unused) {
                this.f376081e = this.f376079c.getClass().getSuperclass().getDeclaredField("sPreloadedComplexColors");
            }
            this.f376081e.setAccessible(true);
            this.f376083g = (LongSparseArray) this.f376081e.get(this.f376079c);
            return;
        }
        Field declaredField = Resources.class.getDeclaredField("sPreloadedColorStateLists");
        this.f376081e = declaredField;
        declaredField.setAccessible(true);
        this.f376083g = (LongSparseArray) this.f376081e.get(resources);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Resources resources) throws NoSuchFieldException, IllegalAccessException {
        m.a(SkinEngine.TAG, 1, "start init reflect data");
        if (SkinEngine.IS_NOUGAT) {
            try {
                this.f376080d = this.f376079c.getClass().getDeclaredField("sPreloadedDrawables");
            } catch (NoSuchFieldException unused) {
                this.f376080d = this.f376079c.getClass().getSuperclass().getDeclaredField("sPreloadedDrawables");
            }
            this.f376080d.setAccessible(true);
            this.f376082f = this.f376080d.get(this.f376079c);
            return;
        }
        Field declaredField = Resources.class.getDeclaredField("sPreloadedDrawables");
        this.f376080d = declaredField;
        declaredField.setAccessible(true);
        this.f376082f = this.f376080d.get(resources);
    }
}
