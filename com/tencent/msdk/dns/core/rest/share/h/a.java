package com.tencent.msdk.dns.core.rest.share.h;

import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.msdk.dns.c.e.c;
import com.tencent.msdk.dns.core.e;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final a f336369d;

    /* renamed from: e, reason: collision with root package name */
    public static final a f336370e;

    /* renamed from: a, reason: collision with root package name */
    public final String f336371a;

    /* renamed from: b, reason: collision with root package name */
    public final String[] f336372b;

    /* renamed from: c, reason: collision with root package name */
    public final int f336373c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16445);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        String[] strArr = e.f336253a;
        f336369d = new a("0", strArr, 0);
        f336370e = new a("0", strArr, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i3, String str, String[] strArr, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, strArr, Integer.valueOf(i16));
            return;
        }
        i3 = 2 != i3 ? 1 : i3;
        if (!TextUtils.isEmpty(str)) {
            if (!com.tencent.msdk.dns.c.e.a.i(strArr)) {
                String[] b16 = b(i3, strArr);
                if (!a(i16)) {
                    this.f336371a = str;
                    if (5 >= b16.length) {
                        this.f336372b = b16;
                    } else {
                        String[] strArr2 = new String[5];
                        this.f336372b = strArr2;
                        System.arraycopy(b16, 0, strArr2, 0, 5);
                    }
                    this.f336373c = i16;
                    return;
                }
                throw new IllegalArgumentException(RemoteMessageConst.TTL.concat(" is invalid"));
            }
            throw new IllegalArgumentException("ips".concat(" can not be empty"));
        }
        throw new IllegalArgumentException(ImageTaskConst.CLIENT_IP.concat(" can not be empty"));
    }

    public static boolean a(int i3) {
        if (i3 < 0) {
            return true;
        }
        return false;
    }

    private static String[] b(int i3, String[] strArr) {
        int length = strArr.length;
        int i16 = length;
        for (int i17 = 0; i17 < length; i17++) {
            String str = strArr[i17];
            if (2 == i3) {
                if (!c.c(str)) {
                    strArr[i17] = "0";
                    i16--;
                }
            } else if (!c.b(str)) {
                strArr[i17] = "0";
                i16--;
            }
        }
        if (i16 == length) {
            return strArr;
        }
        if (i16 <= 0) {
            return e.f336253a;
        }
        String[] strArr2 = new String[i16];
        int i18 = i16 - 1;
        for (int i19 = length - 1; i19 >= 0 && i18 >= 0; i19--) {
            String str2 = strArr[i19];
            if (!"0".equals(str2)) {
                strArr2[i18] = str2;
                i18--;
            }
        }
        return strArr2;
    }

    a(String str, String[] strArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, strArr, Integer.valueOf(i3));
            return;
        }
        this.f336371a = str;
        this.f336372b = strArr;
        this.f336373c = i3;
    }
}
