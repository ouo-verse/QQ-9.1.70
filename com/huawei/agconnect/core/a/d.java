package com.huawei.agconnect.core.a;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.core.Service;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static Map<Class<?>, Service> f36529a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private static Map<Class<?>, Object> f36530b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private Map<Class<?>, Service> f36531c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private Map<Class<?>, Object> f36532d = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(List<Service> list, Context context) {
        a(list, context);
    }

    private Object a(AGConnectInstance aGConnectInstance, Service service) {
        StringBuilder sb5;
        if (service.getInstance() != null) {
            return service.getInstance();
        }
        Class<?> type = service.getType();
        if (type == null) {
            return null;
        }
        try {
            Constructor a16 = a(type, Context.class, AGConnectInstance.class);
            if (a16 != null) {
                return a16.newInstance(aGConnectInstance.getContext(), aGConnectInstance);
            }
            Constructor a17 = a(type, Context.class);
            return a17 != null ? a17.newInstance(aGConnectInstance.getContext()) : type.newInstance();
        } catch (IllegalAccessException e16) {
            e = e16;
            sb5 = new StringBuilder();
            sb5.append("Instantiate service exception ");
            sb5.append(e.getLocalizedMessage());
            Log.e("ServiceRepository", sb5.toString());
            return null;
        } catch (InstantiationException e17) {
            e = e17;
            sb5 = new StringBuilder();
            sb5.append("Instantiate service exception ");
            sb5.append(e.getLocalizedMessage());
            Log.e("ServiceRepository", sb5.toString());
            return null;
        } catch (InvocationTargetException e18) {
            e = e18;
            sb5 = new StringBuilder();
            sb5.append("Instantiate service exception ");
            sb5.append(e.getLocalizedMessage());
            Log.e("ServiceRepository", sb5.toString());
            return null;
        }
    }

    public <T> T a(AGConnectInstance aGConnectInstance, Class<?> cls) {
        T t16;
        Service service = this.f36531c.get(cls);
        if (service == null && (service = f36529a.get(cls)) != null) {
            return (T) f36530b.get(cls);
        }
        if (service == null) {
            return null;
        }
        if (service.isSingleton() && (t16 = (T) this.f36532d.get(cls)) != null) {
            return t16;
        }
        T t17 = (T) a(aGConnectInstance, service);
        if (t17 != null && service.isSingleton()) {
            this.f36532d.put(cls, t17);
        }
        return t17;
    }

    private static Constructor a(Class cls, Class... clsArr) {
        boolean z16 = false;
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == clsArr.length) {
                for (int i3 = 0; i3 < clsArr.length; i3++) {
                    z16 = parameterTypes[i3] == clsArr[i3];
                }
                if (z16) {
                    return constructor;
                }
            }
        }
        return null;
    }

    private void a(String str, Exception exc) {
        Log.e("ServiceRepository", "Instantiate shared service " + str + exc.getLocalizedMessage());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("cause message:");
        sb5.append(exc.getCause() != null ? exc.getCause().getMessage() : "");
        Log.e("ServiceRepository", sb5.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005b A[Catch: InvocationTargetException -> 0x0076, InstantiationException -> 0x007b, IllegalAccessException -> 0x0080, TryCatch #2 {IllegalAccessException -> 0x0080, InstantiationException -> 0x007b, InvocationTargetException -> 0x0076, blocks: (B:22:0x0049, B:26:0x005b, B:27:0x006c, B:30:0x0064), top: B:21:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0064 A[Catch: InvocationTargetException -> 0x0076, InstantiationException -> 0x007b, IllegalAccessException -> 0x0080, TryCatch #2 {IllegalAccessException -> 0x0080, InstantiationException -> 0x007b, InvocationTargetException -> 0x0076, blocks: (B:22:0x0049, B:26:0x005b, B:27:0x006c, B:30:0x0064), top: B:21:0x0049 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(List<Service> list, Context context) {
        Map<Class<?>, Service> map;
        String str;
        if (list == null) {
            return;
        }
        for (Service service : list) {
            if (service.isSharedInstance()) {
                if (!f36529a.containsKey(service.getInterface())) {
                    map = f36529a;
                }
                if (service.isAutoCreated() && service.getType() != null && !f36530b.containsKey(service.getInterface())) {
                    try {
                        Constructor a16 = a(service.getType(), Context.class);
                        f36530b.put(service.getInterface(), a16 == null ? a16.newInstance(context) : service.getType().newInstance());
                    } catch (IllegalAccessException e16) {
                        e = e16;
                        str = "AccessException";
                        a(str, e);
                    } catch (InstantiationException e17) {
                        e = e17;
                        str = "InstantiationException";
                        a(str, e);
                    } catch (InvocationTargetException e18) {
                        e = e18;
                        str = "TargetException";
                        a(str, e);
                    }
                }
            } else {
                map = this.f36531c;
            }
            map.put(service.getInterface(), service);
            if (service.isAutoCreated()) {
                Constructor a162 = a(service.getType(), Context.class);
                f36530b.put(service.getInterface(), a162 == null ? a162.newInstance(context) : service.getType().newInstance());
            }
        }
    }
}
