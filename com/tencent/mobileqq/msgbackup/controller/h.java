package com.tencent.mobileqq.msgbackup.controller;

import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes15.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static SparseArray<ArrayList<byte[]>> f251071a;

    /* renamed from: b, reason: collision with root package name */
    private static SparseArray<Integer> f251072b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22106);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f251071a = new SparseArray<>(2000);
            f251072b = new SparseArray<>(2000);
        }
    }

    public static synchronized void a() {
        synchronized (h.class) {
            f251071a.clear();
            f251072b.clear();
        }
    }

    public static synchronized byte[] b(int i3) {
        synchronized (h.class) {
            ArrayList<byte[]> arrayList = f251071a.get(i3);
            if (arrayList == null) {
                return null;
            }
            int intValue = f251072b.get(i3).intValue();
            if (intValue >= arrayList.size()) {
                return null;
            }
            byte[] bArr = arrayList.get(intValue);
            f251072b.put(i3, Integer.valueOf(intValue + 1));
            return bArr;
        }
    }

    public static synchronized void c(byte[] bArr) {
        synchronized (h.class) {
            int length = bArr.length;
            if (length > 2000) {
                return;
            }
            ArrayList<byte[]> arrayList = f251071a.get(length);
            if (arrayList == null) {
                arrayList = new ArrayList<>(100);
                f251072b.put(length, 0);
            }
            if (arrayList.size() >= 100) {
                return;
            }
            arrayList.add(bArr);
            f251071a.put(bArr.length, arrayList);
            f251072b.put(length, Integer.valueOf(f251072b.get(length).intValue() + 1));
        }
    }

    public static synchronized void d() {
        synchronized (h.class) {
            int size = f251072b.size();
            for (int i3 = 0; i3 < size; i3++) {
                f251072b.setValueAt(i3, 0);
            }
        }
    }
}
