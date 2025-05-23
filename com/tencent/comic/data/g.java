package com.tencent.comic.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList<Integer> f99363a;

    /* renamed from: b, reason: collision with root package name */
    private static HashMap<Integer, HashMap<Integer, Long>> f99364b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33818);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        f99363a = arrayList;
        f99364b = new HashMap<>();
        arrayList.add(13);
        arrayList.add(12);
        arrayList.add(11);
        arrayList.add(2);
        arrayList.add(1);
    }

    public static void a(int i3) {
        if (f99364b.containsKey(Integer.valueOf(i3))) {
            f99364b.remove(Integer.valueOf(i3));
        }
    }

    public static boolean b(int i3, int i16) {
        HashMap<Integer, Long> hashMap = f99364b.get(Integer.valueOf(i3));
        if (hashMap == null) {
            return false;
        }
        return hashMap.containsKey(Integer.valueOf(i16));
    }

    public static long c(int i3, int i16) {
        Long l3;
        HashMap<Integer, Long> hashMap = f99364b.get(Integer.valueOf(i3));
        if (hashMap == null || (l3 = hashMap.get(Integer.valueOf(i16))) == null) {
            return 0L;
        }
        return l3.longValue();
    }

    public static void d(int i3, int i16, long j3) {
        if (f99363a.contains(Integer.valueOf(i16))) {
            HashMap<Integer, Long> hashMap = f99364b.get(Integer.valueOf(i3));
            if (hashMap == null) {
                hashMap = new HashMap<>();
                f99364b.put(Integer.valueOf(i3), hashMap);
            }
            hashMap.put(Integer.valueOf(i16), Long.valueOf(j3));
        }
    }
}
