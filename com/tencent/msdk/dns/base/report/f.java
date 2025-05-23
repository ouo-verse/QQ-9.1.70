package com.tencent.msdk.dns.base.report;

import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes21.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final SparseArray<a> f336221a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f336222b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17949);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        SparseArray<a> sparseArray = new SparseArray<>(2);
        f336221a = sparseArray;
        f336222b = false;
        c cVar = new c();
        sparseArray.put(1, cVar);
        f336222b = cVar.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a(int i3) {
        int i16 = 0;
        while (true) {
            SparseArray<a> sparseArray = f336221a;
            if (i16 < sparseArray.size()) {
                int keyAt = sparseArray.keyAt(i16);
                if (keyAt == i3) {
                    return sparseArray.get(keyAt);
                }
                i16++;
            } else {
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<a> b(int i3) {
        ArrayList arrayList = null;
        int i16 = 0;
        while (true) {
            SparseArray<a> sparseArray = f336221a;
            if (i16 >= sparseArray.size()) {
                break;
            }
            int keyAt = sparseArray.keyAt(i16);
            if ((keyAt & i3) != 0) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(sparseArray.get(keyAt));
            }
            i16++;
        }
        if (arrayList == null) {
            return Collections.emptyList();
        }
        return arrayList;
    }
}
