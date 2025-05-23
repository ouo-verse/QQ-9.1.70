package com.tencent.mobileqq.friend.helper;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    static final String f211684b;

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, byte[]> f211685a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41625);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f211684b = a.class.getSimpleName();
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f211685a = new ConcurrentHashMap<>(5);
        }
    }

    public void a(String str, int i3, int i16, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16), bArr);
            return;
        }
        if (bArr == null || bArr.length == 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String format = String.format("%s_%s_%s", str, Integer.valueOf(i3), Integer.valueOf(i16));
            this.f211685a.put(format, bArr);
            if (QLog.isColorLevel()) {
                QLog.i(f211684b, 2, String.format("cacheToken key: %s, token_len: %s", format, Integer.valueOf(bArr.length)));
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public byte[] b(String str, int i3, int i16) {
        String format;
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        byte[] bArr2 = null;
        try {
            format = String.format("%s_%s_%s", str, Integer.valueOf(i3), Integer.valueOf(i16));
            bArr = this.f211685a.get(format);
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            if (QLog.isColorLevel()) {
                String str2 = f211684b;
                Object[] objArr = new Object[2];
                objArr[0] = format;
                if (bArr != null) {
                    i17 = bArr.length;
                }
                objArr[1] = Integer.valueOf(i17);
                QLog.i(str2, 2, String.format("getCachedToken key: %s, token: %s", objArr));
                return bArr;
            }
            return bArr;
        } catch (Throwable th6) {
            th = th6;
            bArr2 = bArr;
            th.printStackTrace();
            return bArr2;
        }
    }
}
