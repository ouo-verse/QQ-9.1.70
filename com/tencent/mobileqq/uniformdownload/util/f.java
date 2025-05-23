package com.tencent.mobileqq.uniformdownload.util;

import android.util.SparseArray;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static SparseArray<String> f306009a;

    public static String a(int i3) {
        b();
        return f306009a.get(i3, "[" + String.valueOf(i3) + "]");
    }

    private static void b() {
        if (f306009a != null) {
            return;
        }
        SparseArray<String> sparseArray = new SparseArray<>();
        f306009a = sparseArray;
        sparseArray.put(0, "");
        f306009a.put(1, "[" + String.valueOf(1) + "]");
        f306009a.put(2, HardCodeUtil.qqStr(R.string.f215015ug));
        f306009a.put(5, HardCodeUtil.qqStr(R.string.f214985ud));
        f306009a.put(6, HardCodeUtil.qqStr(R.string.f214925u8));
        f306009a.put(11, HardCodeUtil.qqStr(R.string.f214905u6));
        f306009a.put(12, HardCodeUtil.qqStr(R.string.f214935u9));
        f306009a.put(13, HardCodeUtil.qqStr(R.string.f214945u_));
        f306009a.put(8, HardCodeUtil.qqStr(R.string.f214955ua));
        f306009a.put(3, HardCodeUtil.qqStr(R.string.f214975uc));
        f306009a.put(7, HardCodeUtil.qqStr(R.string.f214965ub));
        f306009a.put(4, HardCodeUtil.qqStr(R.string.f215005uf));
        f306009a.put(9, HardCodeUtil.qqStr(R.string.f214995ue));
        f306009a.put(10, HardCodeUtil.qqStr(R.string.f214915u7));
        f306009a.put(14, HardCodeUtil.qqStr(R.string.f214895u5));
    }
}
