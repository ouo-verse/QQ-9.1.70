package com.tencent.mobileqq.qroute.utils;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<ArrayList<String>> f276501a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9078);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f276501a = new ThreadLocal<>();
        }
    }

    public static void a(@NonNull String str) {
        if (!QRoute.getConfig().isForceCheck()) {
            return;
        }
        ThreadLocal<ArrayList<String>> threadLocal = f276501a;
        if (threadLocal.get() != null && !threadLocal.get().isEmpty() && str.compareTo(threadLocal.get().get(0)) == 0) {
            threadLocal.remove();
        }
    }

    public static boolean b(@NonNull String str) {
        if (!QRoute.getConfig().isForceCheck()) {
            return true;
        }
        ThreadLocal<ArrayList<String>> threadLocal = f276501a;
        if (threadLocal.get() == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            threadLocal.set(arrayList);
        } else {
            if (threadLocal.get().contains(str)) {
                return false;
            }
            threadLocal.get().add(str);
        }
        return true;
    }

    public static void c() {
        if (!QRoute.getConfig().isForceCheck()) {
            return;
        }
        ThreadLocal<ArrayList<String>> threadLocal = f276501a;
        if (threadLocal.get() != null) {
            threadLocal.remove();
        }
    }
}
