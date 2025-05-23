package com.tencent.luggage.wxa.rj;

import com.tencent.luggage.wxa.fd.b;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public static final List f139814a = Arrays.asList(AuthorizeCenter.SCOPE_USER_LOCATION, AuthorizeCenter.SCOPE_CAMERA);

    public static boolean a(String str, com.tencent.luggage.wxa.fd.q qVar) {
        String[] strArr;
        boolean z16;
        if (!f139814a.contains(str)) {
            if (!(qVar instanceof com.tencent.luggage.wxa.j4.g) || (strArr = ((com.tencent.luggage.wxa.j4.g) qVar).f130831g0.f125732c0) == null) {
                return false;
            }
            int length = strArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    z16 = false;
                    break;
                }
                if (Objects.equals(strArr[i3], str)) {
                    z16 = true;
                    break;
                }
                i3++;
            }
            if (!z16) {
                return false;
            }
        }
        str.hashCode();
        if (str.equals(AuthorizeCenter.SCOPE_USER_LOCATION)) {
            return qVar.f125962h;
        }
        return true;
    }

    public static String a(String str, com.tencent.luggage.wxa.ic.g gVar) {
        str.hashCode();
        if (!str.equals(AuthorizeCenter.SCOPE_CAMERA)) {
            b.f b16 = gVar.E().b(str);
            if (b16 == null) {
                return null;
            }
            return b16.f125650b;
        }
        return gVar.F().getString(R.string.z2h);
    }
}
