package com.tencent.mobileqq.qcircle.api.utils;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, Map<String, Boolean>> f261724a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, Map<String, Boolean>> f261725b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private static final Set<C8280a> f261726c = new CopyOnWriteArraySet();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qcircle.api.utils.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static class C8280a extends WeakReference<b> {

        /* renamed from: a, reason: collision with root package name */
        private String f261727a;

        /* renamed from: b, reason: collision with root package name */
        private String f261728b;

        public C8280a(String str, String str2, b bVar) {
            super(bVar);
            this.f261727a = str;
            this.f261728b = str2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface b {
        void a(boolean z16);
    }

    private static C8280a a(String str, String str2) {
        Set<C8280a> set = f261726c;
        if (set.isEmpty()) {
            return null;
        }
        for (C8280a c8280a : set) {
            if (c8280a.get() != null && TextUtils.equals(c8280a.f261728b, str2) && TextUtils.equals(c8280a.f261727a, str)) {
                return c8280a;
            }
        }
        return null;
    }

    private static boolean b(String str, String str2) {
        if (a(str, str2) != null) {
            return true;
        }
        return false;
    }

    public static boolean c(String str) {
        String accountId = RFWApplication.getAccountId();
        if (!TextUtils.isEmpty(accountId) && !TextUtils.isEmpty(str)) {
            try {
                Map<String, Boolean> map = f261724a.get(accountId);
                if (map == null) {
                    QLog.d("QPL-QCirclePrivateLetterUtils", 1, "[isSingleFollowUid] followMapResult == null.");
                    return true;
                }
                Boolean bool = map.get(str);
                QLog.d("QPL-QCirclePrivateLetterUtils", 1, "[isSingleFollowUid] accountId: " + accountId + " | peerUid: " + str + " | isSingleFollow: " + bool);
                if (bool == null || !bool.booleanValue()) {
                    return false;
                }
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        QLog.d("QPL-QCirclePrivateLetterUtils", 1, "[isSingleFollowUid] accountId or letter is empty.");
        return false;
    }

    public static boolean d(String str) {
        String accountId = RFWApplication.getAccountId();
        if (!TextUtils.isEmpty(accountId) && !TextUtils.isEmpty(str)) {
            try {
                Map<String, Boolean> map = f261725b.get(accountId);
                if (map == null) {
                    QLog.d("QPL-QCirclePrivateLetterUtils", 1, "[isSingleFollowUin] followMapResult == null.");
                    return false;
                }
                Boolean bool = map.get(str);
                QLog.d("QPL-QCirclePrivateLetterUtils", 1, "[isSingleFollowUin] accountId: " + accountId + " | peerUin: " + str + " | isSingleFollow: " + bool);
                if (bool == null || !bool.booleanValue()) {
                    return false;
                }
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        QLog.d("QPL-QCirclePrivateLetterUtils", 1, "[isSingleFollowUin] accountId or letter is empty.");
        return false;
    }

    public static void e(String str, b bVar) {
        Boolean bool;
        QLog.d("QPL-QCirclePrivateLetterUtils", 1, "[loadPeerUinFollowState] peerUin: " + str);
        String accountId = RFWApplication.getAccountId();
        Map<String, Boolean> map = f261725b.get(accountId);
        if (map == null) {
            bool = null;
        } else {
            bool = map.get(str);
        }
        if (bool != null) {
            bVar.a(bool.booleanValue());
        } else {
            if (b(accountId, str)) {
                return;
            }
            f261726c.add(new C8280a(accountId, str, bVar));
        }
    }

    public static void f(String str, String str2, boolean z16) {
        try {
            C8280a a16 = a(str, str2);
            if (a16 != null && a16.get() != null) {
                a16.get().a(z16);
                f261726c.remove(a16);
            }
        } catch (Throwable th5) {
            QLog.e("QPL-QCirclePrivateLetterUtils", 1, "[notifyPeerFollowStateUpdate] error: ", th5);
        }
    }

    public static void g(String str, String str2, String str3, boolean z16) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            Map<String, Map<String, Boolean>> map = f261724a;
            Map<String, Boolean> map2 = map.get(str);
            if (map2 == null) {
                map2 = new ConcurrentHashMap<>();
                map.put(str, map2);
            }
            Map<String, Map<String, Boolean>> map3 = f261725b;
            Map<String, Boolean> map4 = map3.get(str);
            if (map4 == null) {
                map4 = new ConcurrentHashMap<>();
                map3.put(str, map4);
            }
            RFWLog.d("QPL-QCirclePrivateLetterUtils", RFWLog.USR, "[putSingleFollow] uin: " + str + " | peerUin: " + str2 + " | peerUid: " + str3 + " | isSingleFollow: " + z16);
            map2.put(str3, Boolean.valueOf(z16));
            map4.put(str2, Boolean.valueOf(z16));
            f(str, str2, z16);
            return;
        }
        RFWLog.d("QPL-QCirclePrivateLetterUtils", RFWLog.USR, "[putSingleFollow] uin or letterUin should not be null.");
    }
}
