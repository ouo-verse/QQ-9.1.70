package com.tencent.mobileqq.service;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f286078a;

    /* renamed from: b, reason: collision with root package name */
    private static final Object f286079b;

    /* renamed from: c, reason: collision with root package name */
    private static Map<String, Set<String>> f286080c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(ProfileContants.FIELD_PRESENT_SWITCH);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f286079b = new Object();
            f286080c = new ConcurrentHashMap();
        }
    }

    public static void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            synchronized (f286079b) {
                Set<String> set = f286080c.get(str);
                if (set == null) {
                    f286080c.put(str, new HashSet(Arrays.asList(str2)));
                } else {
                    set.add(str2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Set<String> b(AppInterface appInterface, String str) {
        Set<String> set;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (f286079b) {
            e(appInterface);
            set = f286080c.get(str);
        }
        return set;
    }

    public static boolean c(String str) {
        return f286080c.containsKey(str);
    }

    public static void d(String str, Set<String> set) {
        if (set != null && !set.isEmpty() && !TextUtils.isEmpty(str)) {
            synchronized (f286079b) {
                for (String str2 : set) {
                    Set<String> set2 = f286080c.get(str2);
                    if (set2 != null) {
                        set2.add(str);
                    } else {
                        HashSet hashSet = new HashSet();
                        hashSet.add(str);
                        f286080c.put(str2, hashSet);
                    }
                }
            }
        }
    }

    private static Map<String, String[]> e(AppInterface appInterface) {
        if (!f286078a && appInterface != null) {
            MobileQQServiceBase mobileQQService = appInterface.getMobileQQService();
            if (mobileQQService != null) {
                f(f286080c, mobileQQService.getCompatibleCmd2HandlerMap());
            }
            f286078a = true;
            return null;
        }
        return null;
    }

    private static void f(Map<String, Set<String>> map, Map<String, String[]> map2) {
        if (map != null && map2 != null) {
            for (Map.Entry<String, String[]> entry : map2.entrySet()) {
                String key = entry.getKey();
                String[] value = entry.getValue();
                if (value != null) {
                    Set<String> set = map.get(key);
                    if (set == null) {
                        map.put(key, new HashSet(Arrays.asList(value)));
                    } else {
                        set.addAll(new HashSet(Arrays.asList(value)));
                    }
                }
            }
        }
    }

    public static void g(String str, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (f286079b) {
            if (strArr != null) {
                f286080c.put(str, new HashSet(Arrays.asList(strArr)));
            } else {
                f286080c.remove(str);
            }
        }
    }
}
