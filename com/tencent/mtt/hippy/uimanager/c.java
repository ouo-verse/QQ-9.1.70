package com.tencent.mtt.hippy.uimanager;

import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.utils.ArgumentUtils;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.views.custom.HippyCustomPropsController;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c<T, G> {

    /* renamed from: a, reason: collision with root package name */
    static final Map<Class, Map<String, a>> f337671a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ boolean f337672b = true;

    /* renamed from: c, reason: collision with root package name */
    private T f337673c;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        Method f337674a;

        /* renamed from: b, reason: collision with root package name */
        String f337675b;

        /* renamed from: c, reason: collision with root package name */
        String f337676c;

        /* renamed from: d, reason: collision with root package name */
        double f337677d;

        /* renamed from: e, reason: collision with root package name */
        boolean f337678e;

        /* renamed from: f, reason: collision with root package name */
        Type[] f337679f;
    }

    private Map<String, a> a(Class cls) {
        HashMap hashMap = new HashMap();
        a(cls, hashMap);
        return hashMap;
    }

    private void a(Class cls, Map<String, a> map) {
        if (cls != HippyViewController.class) {
            a(cls.getSuperclass(), map);
        }
        Map<String, a> map2 = f337671a.get(cls);
        if (map2 != null) {
            map.putAll(map2);
            return;
        }
        for (Method method : cls.getMethods()) {
            HippyControllerProps hippyControllerProps = (HippyControllerProps) method.getAnnotation(HippyControllerProps.class);
            if (hippyControllerProps != null) {
                String name = hippyControllerProps.name();
                a aVar = new a();
                aVar.f337677d = hippyControllerProps.defaultNumber();
                aVar.f337675b = hippyControllerProps.defaultType();
                aVar.f337676c = hippyControllerProps.defaultString();
                aVar.f337678e = hippyControllerProps.defaultBoolean();
                aVar.f337674a = method;
                map.put(name, aVar);
            }
        }
        f337671a.put(cls, new HashMap(map));
    }

    public void a(T t16) {
        if (!f337672b && t16 == null) {
            throw new AssertionError();
        }
        this.f337673c = t16;
    }

    public void a(T t16, G g16, HippyMap hippyMap) {
        if (!f337672b && hippyMap == null) {
            throw new AssertionError();
        }
        if (hippyMap == null) {
            return;
        }
        Class<?> cls = t16.getClass();
        Map<String, a> map = f337671a.get(cls);
        if (map == null) {
            map = a((Class) cls);
        }
        for (String str : hippyMap.keySet()) {
            a aVar = map.get(str);
            if (aVar != null) {
                a(t16, g16, hippyMap, str, aVar);
            } else if (str.equals("style") && (hippyMap.get(str) instanceof HippyMap)) {
                a(t16, g16, (HippyMap) hippyMap.get(str));
            } else {
                a(t16, g16, hippyMap, str);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(T t16, G g16, HippyMap hippyMap, String str) {
        boolean z16 = f337672b;
        if (!z16 && !(g16 instanceof View)) {
            throw new AssertionError();
        }
        if (!z16 && !(this.f337673c instanceof HippyCustomPropsController)) {
            throw new AssertionError();
        }
        if (g16 instanceof View) {
            Object obj = hippyMap.get(str);
            T t17 = this.f337673c;
            boolean z17 = false;
            if (t17 != null && (t17 instanceof HippyCustomPropsController)) {
                Class<?> cls = t17.getClass();
                Map<String, a> map = f337671a.get(cls);
                if (map == null) {
                    map = a((Class) cls);
                }
                a aVar = map.get(str);
                if (aVar != null) {
                    try {
                        a(this.f337673c, g16, hippyMap, str, aVar);
                        z17 = true;
                    } catch (Throwable th5) {
                        LogUtils.e("ControllerUpdateManager", "customProps " + th5.getMessage(), th5);
                        th5.printStackTrace();
                    }
                }
            }
            if (z17 || !(t16 instanceof HippyViewController)) {
                return;
            }
            ((HippyViewController) t16).setCustomProp((View) g16, str, obj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0089 A[Catch: all -> 0x00c3, TryCatch #0 {all -> 0x00c3, blocks: (B:2:0x0000, B:4:0x0009, B:15:0x0047, B:18:0x0055, B:20:0x0063, B:22:0x0067, B:23:0x006f, B:25:0x0089, B:27:0x001f, B:30:0x002a, B:33:0x0035, B:36:0x009b, B:38:0x00a3, B:40:0x00a7, B:41:0x00af, B:42:0x00b7), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(T t16, G g16, HippyMap hippyMap, String str, a aVar) {
        char c16;
        try {
            if (hippyMap.get(str) != null) {
                Object obj = hippyMap.get(str);
                if (obj instanceof Number) {
                    if (aVar.f337679f == null) {
                        aVar.f337679f = aVar.f337674a.getGenericParameterTypes();
                    }
                    obj = ArgumentUtils.parseArgument(aVar.f337679f[1], hippyMap, str);
                }
                aVar.f337674a.invoke(t16, g16, obj);
                return;
            }
            String str2 = aVar.f337675b;
            int hashCode = str2.hashCode();
            if (hashCode == -1034364087) {
                if (str2.equals("number")) {
                    c16 = 1;
                    if (c16 != 0) {
                    }
                }
                c16 = '\uffff';
                if (c16 != 0) {
                }
            } else if (hashCode != -891985903) {
                if (hashCode == 64711720 && str2.equals(HippyControllerProps.BOOLEAN)) {
                    c16 = 0;
                    if (c16 != 0) {
                        aVar.f337674a.invoke(t16, g16, Boolean.valueOf(aVar.f337678e));
                        return;
                    }
                    if (c16 == 1) {
                        if (aVar.f337679f == null) {
                            aVar.f337679f = aVar.f337674a.getGenericParameterTypes();
                        }
                        aVar.f337674a.invoke(t16, g16, ArgumentUtils.parseArgument(aVar.f337679f[1], Double.valueOf(aVar.f337677d)));
                        return;
                    } else if (c16 != 2) {
                        aVar.f337674a.invoke(t16, g16, null);
                        return;
                    } else {
                        aVar.f337674a.invoke(t16, g16, aVar.f337676c);
                        return;
                    }
                }
                c16 = '\uffff';
                if (c16 != 0) {
                }
            } else {
                if (str2.equals(HippyControllerProps.STRING)) {
                    c16 = 2;
                    if (c16 != 0) {
                    }
                }
                c16 = '\uffff';
                if (c16 != 0) {
                }
            }
        } catch (Throwable th5) {
            LogUtils.e("ControllerUpdateManager", th5.getMessage(), th5);
            th5.printStackTrace();
        }
    }
}
