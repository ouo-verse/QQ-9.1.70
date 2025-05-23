package com.tencent.rmonitor.custom;

import com.tencent.bugly.common.cache.IProcessContextLoader;
import com.tencent.bugly.common.cache.ProcessContextWrapper;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static a f365549a;

    public static a a() {
        if (f365549a == null) {
            synchronized (b.class) {
                if (f365549a == null) {
                    a aVar = new a();
                    aVar.u(ProcessContextWrapper.getInstance().getProcessContextCache());
                    f365549a = aVar;
                }
            }
        }
        return f365549a;
    }

    public static a b(IProcessContextLoader iProcessContextLoader) {
        a aVar = null;
        if (iProcessContextLoader == null) {
            return null;
        }
        Set<String> allKeys = iProcessContextLoader.getAllKeys();
        if (allKeys != null && !allKeys.isEmpty()) {
            aVar = c();
            Iterator<String> it = allKeys.iterator();
            while (it.hasNext()) {
                d(iProcessContextLoader, aVar, it.next());
            }
        }
        return aVar;
    }

    public static a c() {
        return new a();
    }

    protected static void d(IProcessContextLoader iProcessContextLoader, a aVar, String str) {
        if (s04.a.b(ICustomDataEditor.NUMBER_PARAM_KEYS, str)) {
            aVar.putNumberParam(str, iProcessContextLoader.getDouble(str, 0.0d));
            return;
        }
        if (s04.a.b(ICustomDataEditor.STRING_PARAM_KEYS, str)) {
            aVar.putStringParam(str, iProcessContextLoader.getString(str, ""));
            return;
        }
        if (s04.a.b(ICustomDataEditor.STRING_ARRAY_PARAM_KEYS, str)) {
            f(iProcessContextLoader, aVar, str);
        } else if (s04.a.b(a.f365540j, str)) {
            e(iProcessContextLoader, aVar, str);
        } else if (str.startsWith("user_data_")) {
            aVar.putUserData(str.substring(10), iProcessContextLoader.getString(str, ""));
        }
    }

    private static void e(IProcessContextLoader iProcessContextLoader, a aVar, String str) {
        List<String> list = iProcessContextLoader.getList(str, null);
        if (list != null && !list.isEmpty()) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                aVar.e(str, it.next());
            }
        }
    }

    private static void f(IProcessContextLoader iProcessContextLoader, a aVar, String str) {
        List<String> list = iProcessContextLoader.getList(str, null);
        if (list != null && !list.isEmpty()) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                aVar.addStringToStringArrayParam(str, it.next());
            }
        }
    }
}
