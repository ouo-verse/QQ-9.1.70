package com.tencent.mobileqq.activity.contact.troop;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.friends.intimate.IntimateInfoHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, Integer> f181397a;

    /* renamed from: b, reason: collision with root package name */
    private static HashMap<String, Long> f181398b;

    /* renamed from: c, reason: collision with root package name */
    private static HashMap<String, List<c>> f181399c;

    /* renamed from: d, reason: collision with root package name */
    private static HashMap<String, HashMap<String, Boolean>> f181400d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67971);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f181397a = new HashMap<>();
        f181398b = new HashMap<>();
        f181399c = new HashMap<>();
        f181400d = new HashMap<>();
    }

    public static boolean a(String str) {
        long currentTimeMillis = (System.currentTimeMillis() - b(str)) / 1000;
        long d16 = d(str);
        if (currentTimeMillis < d16 && d16 != 0) {
            return false;
        }
        j(str);
        h(str);
        i(str);
        return true;
    }

    public static long b(String str) {
        if (f181398b.containsKey(str)) {
            return f181398b.get(str).longValue();
        }
        return 0L;
    }

    public static List<c> c(String str) {
        ArrayList arrayList = new ArrayList();
        if (f181399c.containsKey(str)) {
            return f181399c.get(str);
        }
        return arrayList;
    }

    public static int d(String str) {
        if (f181397a.containsKey(str)) {
            return f181397a.get(str).intValue();
        }
        return 0;
    }

    public static List<a> e(ArrayList<c> arrayList, QQAppInterface qQAppInterface) {
        String str;
        ArrayList arrayList2 = new ArrayList();
        if (!arrayList.isEmpty() && qQAppInterface != null) {
            TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                String valueOf = String.valueOf(arrayList.get(i3).f181390a);
                TroopInfo B = troopManager.B(valueOf);
                if (B != null && (str = B.troopname) != null && !str.isEmpty()) {
                    a aVar = new a();
                    aVar.f181386c = B;
                    aVar.f181384a = valueOf;
                    aVar.f181385b = arrayList.get(i3).f181391b;
                    arrayList2.add(aVar);
                }
            }
        }
        return arrayList2;
    }

    public static boolean f(long j3, int i3, QQAppInterface qQAppInterface) {
        if (QLog.isColorLevel()) {
            QLog.d("TroopWithCommonFriendsHelper", 2, "getTroopWithCommonFriendsList,frienduin:" + j3);
        }
        String valueOf = String.valueOf(j3);
        IntimateInfoHandler intimateInfoHandler = (IntimateInfoHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER);
        if (!a(valueOf)) {
            intimateInfoHandler.E2(d(valueOf), c(valueOf));
            if (QLog.isColorLevel()) {
                QLog.d("TroopWithCommonFriendsHelper", 2, "getTroopWithCommonFriendsList:EnableGetTroopList,false");
            }
            return false;
        }
        if (j3 <= 0 || i3 == 0) {
            return false;
        }
        intimateInfoHandler.H2(j3, i3);
        return true;
    }

    public static boolean g(String str, String str2) {
        HashMap<String, Boolean> hashMap;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (hashMap = f181400d.get(str)) != null && hashMap.containsKey(str2)) {
            return hashMap.get(str2).booleanValue();
        }
        return true;
    }

    public static void h(String str) {
        if (f181398b.containsKey(str)) {
            f181398b.remove(str);
        }
    }

    public static void i(String str) {
        if (f181399c.containsKey(str)) {
            f181399c.remove(str);
        }
    }

    public static void j(String str) {
        if (f181397a.containsKey(str)) {
            f181397a.remove(str);
        }
    }

    public static void k(String str, String str2, boolean z16) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            HashMap<String, Boolean> hashMap = new HashMap<>();
            hashMap.put(str2, Boolean.valueOf(z16));
            f181400d.put(str, hashMap);
        }
    }

    public static void l(String str, long j3) {
        if (j3 > 0 && !TextUtils.isEmpty(str)) {
            f181398b.put(str, Long.valueOf(j3));
        }
    }

    public static void m(String str, List<c> list) {
        if (!TextUtils.isEmpty(str)) {
            f181399c.put(str, list);
        }
    }

    public static void n(String str, int i3) {
        if (i3 > 0 && !TextUtils.isEmpty(str)) {
            f181397a.put(str, Integer.valueOf(i3));
        }
    }
}
