package com.tencent;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static volatile HashMap<String, Long> f61317a;

    /* renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Integer> f61318b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63188);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f61317a = new HashMap<>();
            f61318b = new ConcurrentHashMap<>();
        }
    }

    public static void a(String str, String str2) {
        if (f61317a.containsKey(str) && !TextUtils.isEmpty(str)) {
            QLog.d("qcircle_collection", 1, str + " " + str2 + " cost:" + (System.currentTimeMillis() - f61317a.get(str).longValue()));
        }
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean z16 = !f61318b.containsKey(str);
        QLog.d("qcircle_collection", 4, str + " isFirstPlayer:" + z16);
        return z16;
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ConcurrentHashMap<String, Integer> concurrentHashMap = f61318b;
        Integer num = concurrentHashMap.get(str);
        if (num == null) {
            concurrentHashMap.put(str, 1);
            QLog.d("qcircle_collection", 4, str + " recordPageFirstPlayer1");
            return;
        }
        Integer valueOf = Integer.valueOf(num.intValue() + 1);
        concurrentHashMap.put(str, valueOf);
        QLog.d("qcircle_collection", 4, str + " recordPageFirstPlayer" + valueOf);
    }

    public static void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f61318b.remove(str);
        QLog.d("qcircle_collection", 4, str + " resetPagePlayerCount:0");
    }

    public static void e(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        f61317a.put(str, Long.valueOf(currentTimeMillis));
        QLog.d("qcircle_collection", 1, str + " start :" + currentTimeMillis);
    }
}
