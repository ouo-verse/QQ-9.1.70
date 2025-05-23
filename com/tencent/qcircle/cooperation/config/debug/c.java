package com.tencent.qcircle.cooperation.config.debug;

import android.text.TextUtils;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import uq3.k;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Class, a> f342443a = Collections.synchronizedMap(new LinkedHashMap());

    public static <T extends a> void a(Class<T> cls) {
        Map<Class, a> map = f342443a;
        if (map.containsKey(cls)) {
            return;
        }
        try {
            map.put(cls, cls.newInstance());
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
        } catch (InstantiationException e17) {
            e17.printStackTrace();
        }
    }

    private static Class b(String str) {
        Collection<a> c16 = c();
        synchronized (c16) {
            for (a aVar : c16) {
                if (aVar != null && !TextUtils.isEmpty(aVar.d()) && aVar.d().equals(str)) {
                    return aVar.getClass();
                }
            }
            return null;
        }
    }

    public static Collection<a> c() {
        return Collections.synchronizedCollection(f342443a.values());
    }

    public static int d(QCircleDebugKey$SwitchStateKey qCircleDebugKey$SwitchStateKey, int i3) {
        if (qCircleDebugKey$SwitchStateKey != null && f()) {
            d dVar = (d) f342443a.get(b(qCircleDebugKey$SwitchStateKey.name()));
            if (dVar != null) {
                return dVar.i();
            }
            return e(qCircleDebugKey$SwitchStateKey.name(), i3);
        }
        return i3;
    }

    private static int e(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return i3;
        }
        return k.b().e(str, i3);
    }

    public static boolean f() {
        if (((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isPublicVersion() && !((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
            return false;
        }
        return true;
    }

    public static boolean g() {
        if (!f()) {
            return false;
        }
        return h(QCircleDebugKey$SwitchStateKey.QCIRCLE_NEW_USER_CONTROLLER, 0);
    }

    public static boolean h(QCircleDebugKey$SwitchStateKey qCircleDebugKey$SwitchStateKey, int i3) {
        if (qCircleDebugKey$SwitchStateKey != null && f()) {
            Class b16 = b(qCircleDebugKey$SwitchStateKey.name());
            if (b16 != null) {
                return i(b16, i3);
            }
            if (e(qCircleDebugKey$SwitchStateKey.name(), i3) != 1) {
                return false;
            }
            return true;
        }
        if (i3 != 1) {
            return false;
        }
        return true;
    }

    private static <T extends d> boolean i(Class<T> cls, int i3) {
        if (cls != null && f()) {
            d dVar = (d) f342443a.get(cls);
            if (dVar != null) {
                return dVar.n();
            }
            if (i3 != 1) {
                return false;
            }
            return true;
        }
        if (i3 != 1) {
            return false;
        }
        return true;
    }

    public static void j(QCircleDebugKey$SwitchStateKey qCircleDebugKey$SwitchStateKey, int i3) {
        if (qCircleDebugKey$SwitchStateKey == null) {
            return;
        }
        Class b16 = b(qCircleDebugKey$SwitchStateKey.name());
        if (b16 != null) {
            k(b16, i3);
        } else {
            l(qCircleDebugKey$SwitchStateKey.name(), i3);
        }
    }

    private static <T extends d> void k(Class<T> cls, int i3) {
        d dVar;
        if (cls != null && (dVar = (d) f342443a.get(cls)) != null) {
            dVar.p(i3);
        }
    }

    private static void l(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        k.b().m(str, i3);
    }
}
