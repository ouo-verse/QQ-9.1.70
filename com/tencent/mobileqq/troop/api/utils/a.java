package com.tencent.mobileqq.troop.api.utils;

import com.tencent.mobileqq.data.troop.TroopExtDBInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final Object f294337a;

    /* renamed from: b, reason: collision with root package name */
    public static Comparator<TroopInfo> f294338b;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.api.utils.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    class C8673a implements Comparator<TroopInfo> {
        static IPatchRedirector $redirector_;

        C8673a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(TroopInfo troopInfo, TroopInfo troopInfo2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopInfo, (Object) troopInfo2)).intValue();
            }
            TroopExtDBInfo troopExtDBInfo = troopInfo.extDBInfo;
            int i3 = troopExtDBInfo.comparePartInt;
            TroopExtDBInfo troopExtDBInfo2 = troopInfo2.extDBInfo;
            return a.a(i3, troopExtDBInfo.compareSpell, troopExtDBInfo2.comparePartInt, troopExtDBInfo2.compareSpell);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45744);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f294337a = new Object();
            f294338b = new C8673a();
        }
    }

    public static int a(int i3, String str, int i16, String str2) {
        if (i3 > i16) {
            return 1;
        }
        if (i3 < i16) {
            return -1;
        }
        if (str == null) {
            if (str2 != null) {
                return -1;
            }
            return 0;
        }
        if (str2 == null) {
            return 1;
        }
        return str.compareTo(str2);
    }

    public static int b(String str, String str2) {
        int i3;
        int i16 = 0;
        char charAt = str2.charAt(0);
        if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
            i3 = 65536;
        } else if (charAt >= '0' && charAt <= '9') {
            i3 = 262144;
        } else {
            i3 = 131072;
        }
        int i17 = (charAt << '\b') | i3 | 0;
        if (str.charAt(0) >= '\u00ff') {
            i16 = 1;
        }
        return i17 | i16;
    }

    public static String c(TroopInfo troopInfo) {
        return troopInfo.troopNameFromNT + "-" + troopInfo.troopuin;
    }

    public static void d(TroopInfo troopInfo) {
        String c16 = c(troopInfo);
        String d16 = ChnToSpell.d(c16, 1);
        int b16 = b(c16, d16);
        TroopExtDBInfo troopExtDBInfo = troopInfo.extDBInfo;
        troopExtDBInfo.compareSpell = d16;
        troopExtDBInfo.comparePartInt = b16;
    }
}
