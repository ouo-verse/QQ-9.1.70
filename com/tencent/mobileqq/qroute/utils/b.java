package com.tencent.mobileqq.qroute.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.route.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static Object a(List<Class> list) {
        if (list != null && list.size() > 0) {
            try {
                return list.get(0).newInstance();
            } catch (IllegalAccessException e16) {
                k.d("GenNewInstanceUtils#genObject", e16);
                return null;
            } catch (InstantiationException e17) {
                k.d("GenNewInstanceUtils#genObject", e17);
                return null;
            }
        }
        return null;
    }

    public static void b(HashMap<String, Class> hashMap, HashMap<String, Object> hashMap2) {
        if (hashMap != null && !hashMap.isEmpty() && hashMap2 != null) {
            try {
                for (Map.Entry<String, Class> entry : hashMap.entrySet()) {
                    hashMap2.put(entry.getKey(), entry.getValue().newInstance());
                }
            } catch (IllegalAccessException e16) {
                k.d("GenNewInstanceUtils#genObjectHashMap", e16);
            } catch (InstantiationException e17) {
                k.d("GenNewInstanceUtils#genObjectHashMap", e17);
            }
        }
    }

    public static void c(List<Class> list, List<Object> list2) {
        if (list != null && list.size() > 0 && list2 != null) {
            try {
                Iterator<Class> it = list.iterator();
                while (it.hasNext()) {
                    list2.add(it.next().newInstance());
                }
            } catch (IllegalAccessException e16) {
                k.d("GenNewInstanceUtils#genObjectList", e16);
            } catch (InstantiationException e17) {
                k.d("GenNewInstanceUtils#genObjectList", e17);
            }
        }
    }
}
