package com.tencent.mtt.hippy.dom;

import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.node.StyleNode;
import com.tencent.mtt.hippy.utils.ArgumentUtils;
import com.tencent.mtt.hippy.utils.LogUtils;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class d<T> {

    /* renamed from: a, reason: collision with root package name */
    static final Map<Class, Map<String, a>> f337298a = new HashMap();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        Method f337299a;

        /* renamed from: b, reason: collision with root package name */
        String f337300b;

        /* renamed from: c, reason: collision with root package name */
        String f337301c;

        /* renamed from: d, reason: collision with root package name */
        double f337302d;

        /* renamed from: e, reason: collision with root package name */
        boolean f337303e;

        /* renamed from: f, reason: collision with root package name */
        Type[] f337304f;
    }

    private Map<String, a> a(Class cls) {
        HashMap hashMap = new HashMap();
        a(cls, hashMap);
        return hashMap;
    }

    private void a(Class cls, Map<String, a> map) {
        if (cls != StyleNode.class) {
            a(cls.getSuperclass(), map);
        }
        Map<String, a> map2 = f337298a.get(cls);
        if (map2 != null) {
            map.putAll(map2);
            return;
        }
        for (Method method : cls.getDeclaredMethods()) {
            HippyControllerProps hippyControllerProps = (HippyControllerProps) method.getAnnotation(HippyControllerProps.class);
            if (hippyControllerProps != null) {
                String name = hippyControllerProps.name();
                a aVar = new a();
                aVar.f337302d = hippyControllerProps.defaultNumber();
                aVar.f337300b = hippyControllerProps.defaultType();
                aVar.f337301c = hippyControllerProps.defaultString();
                aVar.f337303e = hippyControllerProps.defaultBoolean();
                aVar.f337299a = method;
                aVar.f337304f = method.getGenericParameterTypes();
                map.put(name, aVar);
            }
        }
        f337298a.put(cls, new HashMap(map));
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0074 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(T t16, HippyMap hippyMap) {
        char c16;
        if (hippyMap == null) {
            return;
        }
        Class<?> cls = t16.getClass();
        Map<String, a> map = f337298a.get(cls);
        if (map == null) {
            map = a(cls);
        }
        for (String str : hippyMap.keySet()) {
            a aVar = map.get(str);
            if (aVar != null) {
                try {
                    if (hippyMap.get(str) == null) {
                        String str2 = aVar.f337300b;
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
                                    aVar.f337299a.invoke(t16, Boolean.valueOf(aVar.f337303e));
                                } else if (c16 == 1) {
                                    aVar.f337299a.invoke(t16, ArgumentUtils.parseArgument(aVar.f337304f[0], Double.valueOf(aVar.f337302d)));
                                } else if (c16 != 2) {
                                    aVar.f337299a.invoke(t16, null);
                                } else {
                                    aVar.f337299a.invoke(t16, aVar.f337301c);
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
                    } else {
                        aVar.f337299a.invoke(t16, ArgumentUtils.parseArgument(aVar.f337304f[0], hippyMap, str));
                    }
                } catch (Throwable th5) {
                    LogUtils.e("ControllerUpdateManager", th5.getMessage(), th5);
                    th5.printStackTrace();
                }
            } else if ((hippyMap.get(str) instanceof HippyMap) && str.equals("style")) {
                a((d<T>) t16, (HippyMap) hippyMap.get(str));
            }
        }
    }
}
