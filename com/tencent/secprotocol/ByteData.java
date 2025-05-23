package com.tencent.secprotocol;

import android.content.Context;
import com.tencent.mobileqq.fe.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qsec.qsecurity.QSec;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.report.O3Report;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes25.dex */
public class ByteData {
    static IPatchRedirector $redirector_;
    String devid;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    private static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final ByteData f368860a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19974);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f368860a = new ByteData();
            }
        }
    }

    ByteData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static ByteData getInstance() {
        return a.f368860a;
    }

    public String buf_to_string(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bArr);
        }
        String str = "";
        if (bArr == null) {
            return "";
        }
        for (int i3 = 0; i3 < bArr.length; i3++) {
            str = (str + Integer.toHexString((bArr[i3] >> 4) & 15)) + Integer.toHexString(bArr[i3] & RegisterType.DOUBLE_HI);
        }
        return str;
    }

    public byte[] getSign(String str, String str2, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, this, str, str2, bArr);
        }
        byte[] bArr2 = new byte[1];
        QSec.getInstance().initSign();
        if (e.b().e()) {
            bArr2 = QSec.getInstance().getLiteSign(str2, bArr);
            O3Report.j("sign_point", str2, buf_to_string(bArr2));
            if (QLog.isColorLevel()) {
                QLog.d("poxy_shell", 2, "source: " + buf_to_string(bArr) + " sign: " + buf_to_string(bArr2) + " moudle: " + str2);
            }
        }
        return bArr2;
    }

    public void init(Context context, String str, String str2, String str3, String str4, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, str, str2, str3, str4, str5);
            return;
        }
        this.devid = str2;
        e.b().i();
        QSec.getInstance().initSign();
    }
}
