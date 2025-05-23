package com.tencent.mobileqq.uftransfer.common.transfer.urlprovider;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import mqq.app.AppRuntime;

/* loaded from: classes19.dex */
public class UFTUrlProvider {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected long f305091a;

    /* renamed from: b, reason: collision with root package name */
    protected final b f305092b;

    /* renamed from: c, reason: collision with root package name */
    protected int f305093c;

    /* renamed from: d, reason: collision with root package name */
    protected int f305094d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f305095e;

    /* renamed from: f, reason: collision with root package name */
    protected String f305096f;

    /* renamed from: g, reason: collision with root package name */
    protected a f305097g;

    /* renamed from: h, reason: collision with root package name */
    protected final com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.a f305098h;

    /* renamed from: i, reason: collision with root package name */
    protected int f305099i;

    /* renamed from: j, reason: collision with root package name */
    protected int f305100j;

    /* renamed from: k, reason: collision with root package name */
    protected int f305101k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f305103a;

        /* renamed from: b, reason: collision with root package name */
        int f305104b;

        /* renamed from: c, reason: collision with root package name */
        int f305105c;

        /* renamed from: d, reason: collision with root package name */
        int f305106d;

        /* renamed from: e, reason: collision with root package name */
        boolean f305107e;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UFTUrlProvider.this);
                return;
            }
            this.f305103a = 0;
            this.f305104b = 0;
            this.f305105c = 0;
            this.f305106d = 0;
            this.f305107e = false;
            a();
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            this.f305103a = 0;
            this.f305104b = 0;
            this.f305105c = 0;
            this.f305106d = 0;
            this.f305107e = false;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return " retryInfo[AutoR:" + this.f305103a + " EofR:" + this.f305104b + " SvrErrR:" + this.f305105c + " UrlErrR:" + this.f305106d + " DataConn:" + this.f305107e + "]";
        }
    }

    public UFTUrlProvider(AppRuntime appRuntime, List<String> list, String str, long j3, boolean z16, com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, list, str, Long.valueOf(j3), Boolean.valueOf(z16), aVar);
            return;
        }
        this.f305093c = 0;
        this.f305094d = 0;
        this.f305095e = false;
        this.f305097g = new a();
        this.f305099i = 6;
        this.f305100j = 3;
        this.f305101k = 3;
        this.f305092b = new b(appRuntime, list, str, z16);
        this.f305098h = aVar;
        this.f305091a = j3;
    }

    private String k() {
        String a16 = this.f305092b.a();
        if (a16 != null) {
            this.f305094d++;
            this.f305097g.a();
        }
        return a16;
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.f305097g.f305103a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(a aVar, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, aVar, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (9056 == i3) {
            int i16 = aVar.f305104b;
            if (i16 < this.f305100j) {
                aVar.f305104b = i16 + 1;
            } else {
                aVar.f305104b = 0;
                aVar.f305103a++;
            }
        } else if (z16) {
            int i17 = aVar.f305105c;
            if (i17 < this.f305101k) {
                aVar.f305105c = i17 + 1;
            } else {
                aVar.f305105c = 0;
                aVar.f305103a++;
            }
        } else {
            aVar.f305103a++;
        }
        aVar.f305106d++;
    }

    public String c() {
        String a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        int i3 = 0;
        do {
            a16 = this.f305092b.a();
            if (a16 == null) {
                break;
            }
            if (!TextUtils.isEmpty(a16)) {
                break;
            }
            i3++;
        } while (i3 < 8);
        a16 = null;
        this.f305096f = a16;
        this.f305095e = false;
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTUrlProvider", 1, "[" + this.f305091a + "] initProvider init:" + a16);
        return a16;
    }

    protected boolean d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, i3)).booleanValue();
        }
        if (this.f305097g.f305107e) {
            return false;
        }
        if (i3 != 9052 && i3 != 9050 && i3 != 9055 && i3 != 9053 && i3 != 9054) {
            return false;
        }
        return true;
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.f305095e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean f(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar)).booleanValue();
        }
        if (aVar == null || aVar.f305103a >= this.f305099i) {
            return false;
        }
        return true;
    }

    public void g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        if (!TextUtils.isEmpty(str) && str.equals(this.f305096f)) {
            a aVar = this.f305097g;
            aVar.f305103a = 0;
            aVar.f305104b = 0;
            aVar.f305107e = true;
        }
    }

    public boolean h(String str, int i3, boolean z16) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), Boolean.valueOf(z16))).booleanValue();
        }
        if (!TextUtils.isEmpty(str) && str.equals(this.f305096f)) {
            String j16 = j(str, i3, z16);
            if (TextUtils.isEmpty(j16)) {
                this.f305095e = true;
                com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTUrlProvider", 1, "[" + this.f305091a + "] reqUrlRetryOnErr fail. all retry over or has err. errCode:" + i3 + " svrRetryErr:" + z16 + i());
                return false;
            }
            if (9056 != i3) {
                j3 = this.f305098h.a();
            } else {
                j3 = 100;
            }
            com.tencent.mobileqq.uftransfer.a.a().c(new Runnable(j16) { // from class: com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.UFTUrlProvider.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f305102d;

                {
                    this.f305102d = j16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UFTUrlProvider.this, (Object) j16);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        UFTUrlProvider.this.f305098h.b(this.f305102d);
                    }
                }
            }, j3);
            this.f305096f = j16;
            this.f305095e = false;
            this.f305093c++;
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTUrlProvider", 1, "[" + this.f305091a + "] reqUrlRetryOnErr suc, delay:" + j3 + " errCode:" + i3 + " svrRetryErr:" + z16 + " strErrUrl:" + str + " selectUrl:" + j16 + i());
            return true;
        }
        this.f305095e = true;
        com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTUrlProvider", 1, "[" + this.f305091a + "] reqUrlRetryOnErr fail. strErrUrl is no match");
        return false;
    }

    protected String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return "totalRetries:" + this.f305093c + " UrlChgedT:" + this.f305094d + this.f305097g.toString();
    }

    protected String j(String str, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        if (d(i3)) {
            String k3 = k();
            if (TextUtils.isEmpty(k3) && f(this.f305097g)) {
                b(this.f305097g, i3, z16);
                com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTUrlProvider", 1, "[" + this.f305091a + "] selectUrl:" + str + this.f305097g.toString() + " no more url, use cur errurl retry");
                return str;
            }
            return k3;
        }
        if (f(this.f305097g)) {
            b(this.f305097g, i3, z16);
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTUrlProvider", 1, "[" + this.f305091a + "] selectUrl:" + str + this.f305097g.toString() + " use cur errurl retry");
            return str;
        }
        return k();
    }
}
