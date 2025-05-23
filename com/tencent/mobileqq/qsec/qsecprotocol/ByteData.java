package com.tencent.mobileqq.qsec.qsecprotocol;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ByteData {
    static IPatchRedirector $redirector_ = null;
    private static final String MY_VERSION = "0.5.5";
    private static boolean isInit;
    private Context mContext;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    private static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final ByteData f276836a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20320);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f276836a = new ByteData(null);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20323);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            isInit = false;
        }
    }

    /* synthetic */ ByteData(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
    }

    private native byte[] getByte(Context context, Object obj);

    public static ByteData getInstance() {
        return b.f276836a;
    }

    public byte[] getSign(String str, String str2, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, this, str, str2, bArr);
        }
        return "unsupported".getBytes();
    }

    public void init(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        } else {
            this.mContext = context;
            isInit = true;
        }
    }

    ByteData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mContext = null;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
