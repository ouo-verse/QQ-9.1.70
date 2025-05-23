package com.tencent.mobileqq.webview.swift.injector;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class aa {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static aa f314570d;

    /* renamed from: e, reason: collision with root package name */
    public static final Class<ab> f314571e;

    /* renamed from: f, reason: collision with root package name */
    private static final Map<String, Object> f314572f;

    /* renamed from: g, reason: collision with root package name */
    private static ArrayList f314573g;

    /* renamed from: a, reason: collision with root package name */
    private CopyOnWriteArrayList<Object> f314574a;

    /* renamed from: b, reason: collision with root package name */
    private List<Class<?>> f314575b;

    /* renamed from: c, reason: collision with root package name */
    @QAutoInject(configPath = "AutoInjectYml/Business/Webview/Inject_AppSetting.yml", version = 1)
    private com.tencent.mobileqq.inject.b f314576c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49383);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f314573g = arrayList;
        arrayList.add(com.tencent.mobileqq.injector.d.class);
        f314571e = ab.class;
        HashMap hashMap = new HashMap();
        hashMap.put(HippyControllerProps.BOOLEAN, Boolean.FALSE);
        hashMap.put(PoiListCacheRecord.WEIGHT_TYPE, 0);
        hashMap.put(PoiListCacheRecord.TIMESTAMP_TYPE, 0L);
        hashMap.put("float", Float.valueOf(0.0f));
        hashMap.put("double", Double.valueOf(0.0d));
        hashMap.put(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT, (short) 0);
        hashMap.put("byte", (byte) 0);
        f314572f = Collections.unmodifiableMap(hashMap);
    }

    aa(Class cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cls);
            return;
        }
        this.f314574a = new CopyOnWriteArrayList<>();
        this.f314575b = new ArrayList();
        h();
        g(cls);
    }

    @NonNull
    private <T> T b(final Class<T> cls) {
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.tencent.mobileqq.webview.swift.injector.z
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                Object i3;
                i3 = aa.this.i(cls, obj, method, objArr);
                return i3;
            }
        });
    }

    @Nullable
    private <T> T c(Class<T> cls) {
        for (Class<?> cls2 : this.f314575b) {
            if (cls.isAssignableFrom(cls2)) {
                try {
                    return (T) cls2.newInstance();
                } catch (IllegalAccessException e16) {
                    QLog.e("Inject", 1, String.format("findAndCreateInjector IllegalAccessException: %s", cls), e16);
                } catch (InstantiationException e17) {
                    QLog.e("Inject", 1, String.format("findAndCreateInjector InstantiationException: %s", cls), e17);
                } catch (Throwable th5) {
                    QLog.e("Inject", 1, String.format("findAndCreateInjector exception: %s", cls), th5);
                }
            }
        }
        return null;
    }

    @NonNull
    public static <T> T d(Class<T> cls) {
        return (T) e(f314571e).j(cls);
    }

    @NonNull
    private static aa e(Class cls) {
        if (f314570d == null) {
            synchronized (aa.class) {
                if (f314570d == null) {
                    f314570d = new aa(cls);
                }
            }
        }
        return f314570d;
    }

    @NonNull
    private <T> T f(Class<T> cls) {
        Iterator<Object> it = this.f314574a.iterator();
        while (it.hasNext()) {
            T t16 = (T) it.next();
            if (cls.isAssignableFrom(t16.getClass())) {
                return t16;
            }
        }
        T t17 = (T) c(cls);
        if (t17 != null) {
            this.f314574a.add(t17);
            return t17;
        }
        com.tencent.mobileqq.inject.b bVar = this.f314576c;
        if (bVar != null && !bVar.isPublicVersion()) {
            QLog.w("Inject", 1, String.format("globalInjector class [%s] not found.", cls));
        }
        T t18 = (T) b(cls);
        this.f314574a.add(t18);
        return t18;
    }

    private void g(Class cls) {
        if (QLog.isColorLevel()) {
            QLog.i("Inject", 2, String.format("initInjectorClzList config: %s \n", Integer.valueOf(cls.getDeclaredFields().length)));
        }
        for (Field field : cls.getDeclaredFields()) {
            if (field.isAnnotationPresent(QAutoInjectJustClazz.class) && Collection.class.isAssignableFrom(field.getType()) && Modifier.isStatic(field.getModifiers())) {
                field.setAccessible(true);
                try {
                    for (Class<?> cls2 : (Collection) field.get(null)) {
                        if (cls2 != null && !this.f314575b.contains(cls2)) {
                            this.f314575b.add(cls2);
                        }
                    }
                } catch (IllegalAccessException e16) {
                    QLog.e("Inject", 1, String.format("initInjectorClzList field IllegalAccessException: %s", field.getName()), e16);
                } catch (Throwable th5) {
                    QLog.e("Inject", 1, String.format("initInjectorClzList field exception: %s", field.getName()), th5);
                }
            }
        }
        QLog.i("Inject", 1, String.format("crashIfNoInjector:%b initInjectorClzList result: %s", Boolean.FALSE, Integer.valueOf(this.f314575b.toArray().length)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object i(Class cls, Object obj, Method method, Object[] objArr) throws Throwable {
        Object obj2;
        Map<String, Object> map = f314572f;
        if (map.containsKey(method.getReturnType().getName())) {
            obj2 = map.get(method.getReturnType().getName());
        } else if (method.getReturnType().isInterface()) {
            obj2 = b(method.getReturnType());
        } else {
            obj2 = null;
        }
        com.tencent.mobileqq.inject.b bVar = this.f314576c;
        if (bVar != null && bVar.isDebugVersion()) {
            QLog.w("Inject", 2, String.format("invoke method name:%s retType:%s retValue:%s clz:%s", method.getName(), method.getReturnType(), obj2, cls));
        }
        return obj2;
    }

    @NonNull
    private <T> T j(Class<T> cls) {
        T t16 = (T) c(cls);
        if (t16 != null) {
            return t16;
        }
        com.tencent.mobileqq.inject.b bVar = this.f314576c;
        if (bVar != null && !bVar.isPublicVersion()) {
            QLog.w("Inject", 1, String.format("newInjector class [%s] not found.", cls));
        }
        return (T) b(cls);
    }

    @NonNull
    public static <T> T k(Class<T> cls) {
        return (T) e(f314571e).f(cls);
    }

    @QAutoInitMethod
    void h() {
        this.f314576c = (com.tencent.mobileqq.inject.b) com.tencent.mobileqq.qroute.utils.b.a(f314573g);
    }
}
