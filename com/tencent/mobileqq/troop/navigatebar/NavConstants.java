package com.tencent.mobileqq.troop.navigatebar;

import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class NavConstants {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<Integer, CORRELATION> f297977a;

    /* renamed from: b, reason: collision with root package name */
    private static final Map<Integer, Integer> f297978b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static final class CORRELATION {
        private static final /* synthetic */ CORRELATION[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final CORRELATION STRONG;
        public static final CORRELATION UNKNOWN;
        public static final CORRELATION WEAK;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42169);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            CORRELATION correlation = new CORRELATION("STRONG", 0);
            STRONG = correlation;
            CORRELATION correlation2 = new CORRELATION("WEAK", 1);
            WEAK = correlation2;
            CORRELATION correlation3 = new CORRELATION("UNKNOWN", 2);
            UNKNOWN = correlation3;
            $VALUES = new CORRELATION[]{correlation, correlation2, correlation3};
        }

        CORRELATION(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static CORRELATION valueOf(String str) {
            return (CORRELATION) Enum.valueOf(CORRELATION.class, str);
        }

        public static CORRELATION[] values() {
            return (CORRELATION[]) $VALUES.clone();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(ProfileContants.FIELD_EXTEND_FRIEND_ADD_FRIEND);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashMap<Integer, CORRELATION> hashMap = new HashMap<>();
        f297977a = hashMap;
        CORRELATION correlation = CORRELATION.WEAK;
        hashMap.put(1, correlation);
        f297977a.put(6, correlation);
        f297977a.put(4, correlation);
        HashMap<Integer, CORRELATION> hashMap2 = f297977a;
        CORRELATION correlation2 = CORRELATION.STRONG;
        hashMap2.put(23, correlation2);
        f297977a.put(108, correlation2);
        f297977a.put(14, correlation2);
        f297977a.put(17, correlation2);
        f297977a.put(22, correlation2);
        f297977a.put(11, correlation2);
        f297977a.put(26, correlation2);
        f297977a.put(100, correlation2);
        f297977a.put(102, correlation2);
        f297978b = new HashMap(32);
        c(5, 6);
        c(13, 13);
        c(14, 14);
        c(18, 17);
        c(11, 11);
        c(19, 18);
        c(20, 19);
        c(22, 21);
        c(23, 22);
        c(25, 23);
        c(27, 26);
        c(4, 5);
        c(3, 4);
        c(2, 3);
        c(10, 10);
        c(6, 7);
        c(21, 20);
        c(17, 100);
        c(31, 102);
        c(12, 102);
        c(24, 101);
        c(7, 108);
    }

    public static int a(int i3) {
        for (Map.Entry<Integer, Integer> entry : f297978b.entrySet()) {
            if (entry.getValue().intValue() == i3) {
                return entry.getKey().intValue();
            }
        }
        return 0;
    }

    public static int b(int i3) {
        Integer num = f297978b.get(Integer.valueOf(i3));
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    private static void c(int i3, int i16) {
        Map<Integer, Integer> map = f297978b;
        if (map.containsKey(Integer.valueOf(i3)) && QLog.isColorLevel()) {
            QLog.d("Navigate.Constants", 2, "NavConstants.put the repeat key!, key = " + i3 + ", val = " + i16);
        }
        map.put(Integer.valueOf(i3), Integer.valueOf(i16));
    }
}
