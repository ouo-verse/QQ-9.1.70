package com.tencent.mobileqq.uftransfer.common.transfer.urlprovider;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.UFTUrlProvider;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c extends UFTUrlProvider {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name */
    protected boolean f305121l;

    /* renamed from: m, reason: collision with root package name */
    protected Map<String, UFTUrlProvider.a> f305122m;

    public c(AppRuntime appRuntime, List<String> list, String str, long j3, boolean z16, a aVar) {
        super(appRuntime, list, str, j3, z16, aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, list, str, Long.valueOf(j3), Boolean.valueOf(z16), aVar);
        } else {
            this.f305121l = false;
            this.f305122m = new HashMap();
        }
    }

    private void l(String str, UFTUrlProvider.a aVar, boolean z16) {
        synchronized (this) {
            if (z16) {
                this.f305122m.clear();
            }
            this.f305122m.put(str, aVar);
        }
    }

    private UFTUrlProvider.a m(String str) {
        UFTUrlProvider.a aVar;
        synchronized (this) {
            aVar = this.f305122m.get(str);
        }
        return aVar;
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.UFTUrlProvider
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        UFTUrlProvider.a m3 = m(this.f305096f);
        if (m3 != null) {
            return m3.f305103a;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.UFTUrlProvider
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        String str = null;
        int i3 = 0;
        do {
            String a16 = this.f305092b.a();
            if (a16 == null) {
                break;
            }
            if (!TextUtils.isEmpty(a16)) {
                l(a16, new UFTUrlProvider.a(), false);
                if (TextUtils.isEmpty(str)) {
                    str = a16;
                }
            }
            i3++;
        } while (i3 < 16);
        this.f305096f = str;
        this.f305095e = false;
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTSmartUrlProvider", 1, "[" + this.f305091a + "] initProvider init:" + str);
        return str;
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.UFTUrlProvider
    public void g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        UFTUrlProvider.a m3 = m(str);
        if (m3 == null) {
            return;
        }
        m3.f305103a = 0;
        m3.f305104b = 0;
        m3.f305107e = true;
        if (!this.f305121l) {
            this.f305121l = true;
            l(str, m3, true);
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTSmartUrlProvider", 1, "[" + this.f305091a + "] data conned. lockedUseThisUrl:" + str);
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.UFTUrlProvider
    protected String j(String str, int i3, boolean z16) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        UFTUrlProvider.a m3 = m(str);
        if (m3 == null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTSmartUrlProvider", 1, "[" + this.f305091a + "] selectUrl err. not find strErrUrl. strErrUrl:" + str);
            return null;
        }
        if ((9056 == i3 || z16) && f(m3)) {
            b(m3, i3, z16);
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTSmartUrlProvider", 1, "[" + this.f305091a + "] selectUrl:" + str + m3.toString() + " eof err or serr, use cur errurl");
            return str;
        }
        UFTUrlProvider.a aVar = new UFTUrlProvider.a();
        aVar.f305103a = Integer.MAX_VALUE;
        aVar.f305104b = Integer.MAX_VALUE;
        aVar.f305105c = Integer.MAX_VALUE;
        aVar.f305106d = Integer.MAX_VALUE;
        synchronized (this) {
            str2 = null;
            for (Map.Entry<String, UFTUrlProvider.a> entry : this.f305122m.entrySet()) {
                String key = entry.getKey();
                UFTUrlProvider.a value = entry.getValue();
                com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTSmartUrlProvider", 1, "[" + this.f305091a + "]" + key + " <->" + value.toString());
                if (value.f305103a < aVar.f305103a) {
                    aVar = value;
                    str2 = key;
                }
            }
        }
        if (!TextUtils.isEmpty(str2) && f(aVar)) {
            b(aVar, i3, z16);
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTSmartUrlProvider", 1, "[" + this.f305091a + "] selectUrl:" + str2 + aVar.toString());
            return str2;
        }
        this.f305095e = true;
        com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTSmartUrlProvider", 1, "[" + this.f305091a + "] all retry over and fail");
        return null;
    }
}
