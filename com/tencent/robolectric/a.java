package com.tencent.robolectric;

import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, Object> f365903a;

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: P */
    /* renamed from: com.tencent.robolectric.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    class C9751a<R> implements c<R> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f365904a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f365905b;

        C9751a(String str, Object obj) {
            this.f365904a = str;
            this.f365905b = obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, obj);
            }
        }

        @Override // com.tencent.robolectric.a.c
        public R a(Class<?> cls) throws Exception {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (R) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cls);
            }
            Field declaredField = cls.getDeclaredField(this.f365904a);
            declaredField.setAccessible(true);
            return (R) declaredField.get(this.f365905b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class b<V> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final Class<? extends V> f365906a;

        /* renamed from: b, reason: collision with root package name */
        public final V f365907b;

        public b(Class<? extends V> cls, V v3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cls, (Object) v3);
            } else {
                this.f365906a = cls;
                this.f365907b = v3;
            }
        }

        public static Class<?>[] a(b<?>... bVarArr) {
            Class<?>[] clsArr = new Class[bVarArr.length];
            for (int i3 = 0; i3 < bVarArr.length; i3++) {
                clsArr[i3] = bVarArr[i3].f365906a;
            }
            return clsArr;
        }

        public static Object[] b(b<?>... bVarArr) {
            Object[] objArr = new Object[bVarArr.length];
            for (int i3 = 0; i3 < bVarArr.length; i3++) {
                objArr[i3] = bVarArr[i3].f365907b;
            }
            return objArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface c<R> {
        R a(Class<?> cls) throws Exception;
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50935);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(HippyControllerProps.BOOLEAN, Boolean.FALSE);
        hashMap.put(PoiListCacheRecord.WEIGHT_TYPE, 0);
        hashMap.put(PoiListCacheRecord.TIMESTAMP_TYPE, 0L);
        hashMap.put("float", Float.valueOf(0.0f));
        hashMap.put("double", Double.valueOf(0.0d));
        hashMap.put(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT, (short) 0);
        hashMap.put("byte", (byte) 0);
        f365903a = Collections.unmodifiableMap(hashMap);
    }

    public static <R> R a(Class<?> cls, String str, b<?>... bVarArr) {
        try {
            Class<?>[] a16 = b.a(bVarArr);
            Object[] b16 = b.b(bVarArr);
            Method declaredMethod = cls.getDeclaredMethod(str, a16);
            declaredMethod.setAccessible(true);
            if (Modifier.isStatic(declaredMethod.getModifiers())) {
                return (R) declaredMethod.invoke(null, b16);
            }
            throw new IllegalArgumentException(declaredMethod + " is not static");
        } catch (NoSuchMethodException e16) {
            throw new RuntimeException("no such method " + cls + "." + str, e16);
        } catch (InvocationTargetException e17) {
            if (!(e17.getTargetException() instanceof RuntimeException)) {
                if (e17.getTargetException() instanceof Error) {
                    throw ((Error) e17.getTargetException());
                }
                throw new RuntimeException(e17.getTargetException());
            }
            throw ((RuntimeException) e17.getTargetException());
        } catch (Exception e18) {
            throw new RuntimeException(e18);
        }
    }

    public static <R> R b(Object obj, String str) {
        try {
            return (R) c(obj.getClass(), NoSuchFieldException.class, new C9751a(str, obj));
        } catch (Exception e16) {
            throw new RuntimeException(e16);
        }
    }

    private static <R, E extends Exception> R c(Class<?> cls, Class<? extends E> cls2, c<R> cVar) throws Exception {
        do {
            try {
                return cVar.a(cls);
            } catch (Exception e16) {
                if (cls2.isInstance(e16)) {
                    cls = cls.getSuperclass();
                } else {
                    throw e16;
                }
            }
        } while (cls != null);
        throw new RuntimeException(e16);
    }
}
