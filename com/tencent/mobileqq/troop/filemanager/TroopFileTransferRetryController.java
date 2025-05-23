package com.tencent.mobileqq.troop.filemanager;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.filemanager.e;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopFileTransferRetryController {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected long f295726a;

    /* renamed from: b, reason: collision with root package name */
    protected final h f295727b;

    /* renamed from: c, reason: collision with root package name */
    protected int f295728c;

    /* renamed from: d, reason: collision with root package name */
    protected int f295729d;

    /* renamed from: e, reason: collision with root package name */
    protected int f295730e;

    /* renamed from: f, reason: collision with root package name */
    protected final a f295731f;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f295732g;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f295733h;

    /* renamed from: i, reason: collision with root package name */
    protected int f295734i;

    /* renamed from: j, reason: collision with root package name */
    protected Map<String, b> f295735j;

    /* renamed from: k, reason: collision with root package name */
    protected int f295736k;

    /* renamed from: l, reason: collision with root package name */
    protected int f295737l;

    /* renamed from: m, reason: collision with root package name */
    protected int f295738m;

    /* renamed from: n, reason: collision with root package name */
    protected int f295739n;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        long a();

        void b(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f295741a;

        /* renamed from: b, reason: collision with root package name */
        int f295742b;

        /* renamed from: c, reason: collision with root package name */
        int f295743c;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFileTransferRetryController.this);
                return;
            }
            this.f295741a = 0;
            this.f295742b = 0;
            this.f295743c = 0;
            a();
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            this.f295741a = 0;
            this.f295742b = 0;
            this.f295743c = 0;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return " retryInfo[AutoR-" + this.f295741a + " EofR-" + this.f295742b + " SvrErrR-" + this.f295743c + "]";
        }
    }

    public TroopFileTransferRetryController(QQAppInterface qQAppInterface, List<String> list, String str, long j3, boolean z16, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qQAppInterface, list, str, Long.valueOf(j3), Boolean.valueOf(z16), aVar);
            return;
        }
        this.f295728c = 0;
        this.f295729d = 0;
        this.f295730e = 0;
        this.f295732g = false;
        this.f295733h = false;
        this.f295734i = 0;
        this.f295735j = new HashMap();
        this.f295736k = 3;
        this.f295737l = 3;
        this.f295738m = 3;
        this.f295739n = 30;
        h hVar = new h(qQAppInterface, list, str);
        this.f295727b = hVar;
        if (z16) {
            hVar.f(true);
        }
        this.f295731f = aVar;
        this.f295726a = j3;
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.f295728c;
    }

    protected void b(b bVar, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, bVar, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (9056 == i3) {
            int i16 = bVar.f295742b;
            if (i16 < this.f295737l) {
                bVar.f295742b = i16 + 1;
                return;
            }
            bVar.f295742b = 0;
            bVar.f295741a++;
            this.f295729d++;
            return;
        }
        if (z16) {
            int i17 = bVar.f295743c;
            if (i17 < this.f295738m) {
                bVar.f295743c = i17 + 1;
                return;
            }
            bVar.f295743c = 0;
            bVar.f295741a++;
            this.f295729d++;
            return;
        }
        bVar.f295741a++;
        this.f295729d++;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        boolean z16 = true;
        String str = null;
        int i3 = 0;
        do {
            String a16 = this.f295727b.a();
            if (!TextUtils.isEmpty(a16)) {
                this.f295735j.put(a16, new b());
                if (str == null) {
                    str = a16;
                }
                i3++;
                e.b.c("TroopFileTransferRetryController", e.b.f295938b, "[" + this.f295726a + "] retryContrller init:" + a16);
            } else {
                z16 = false;
            }
            if (!z16) {
                break;
            }
        } while (i3 < 4);
        return str;
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.f295732g;
    }

    public synchronized void e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        b bVar = this.f295735j.get(str);
        if (bVar == null) {
            return;
        }
        if (!this.f295733h) {
            this.f295733h = true;
            bVar.a();
            this.f295735j.clear();
            this.f295735j.put(str, bVar);
            e.b.c("TroopFileTransferRetryController", e.b.f295938b, "[" + this.f295726a + "] data conned. lockedUseThisUrl:" + str);
            return;
        }
        if (this.f295734i > this.f295739n) {
            return;
        }
        bVar.a();
        this.f295734i++;
        e.b.c("TroopFileTransferRetryController", e.b.f295938b, "[" + this.f295726a + "] data conned. resetRetryInfo. resetcount:" + this.f295734i);
    }

    public boolean f(String str, int i3, boolean z16) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), Boolean.valueOf(z16))).booleanValue();
        }
        if (this.f295731f == null) {
            e.b.b("TroopFileTransferRetryController", e.b.f295938b, "[" + this.f295726a + "] reqRetryOnErr fail. sink=null");
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            e.b.b("TroopFileTransferRetryController", e.b.f295938b, "[" + this.f295726a + "] reqRetryOnErr fail. strErrUrl=null");
            return false;
        }
        String g16 = g(str, i3, z16);
        if (TextUtils.isEmpty(g16)) {
            e.b.b("TroopFileTransferRetryController", e.b.f295938b, "[" + this.f295726a + "] reqRetryOnErr fail. all retry over or has err. errCode:" + i3 + " bSvrErr:" + z16 + " ReportR:" + this.f295728c + "UrlChgedT:" + this.f295730e + " strErrUrl:" + str);
            return false;
        }
        if (9056 != i3) {
            j3 = this.f295731f.a();
        } else {
            j3 = 100;
        }
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable(g16) { // from class: com.tencent.mobileqq.troop.filemanager.TroopFileTransferRetryController.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f295740d;

            {
                this.f295740d = g16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopFileTransferRetryController.this, (Object) g16);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    TroopFileTransferRetryController.this.f295731f.b(this.f295740d);
                }
            }
        }, j3);
        this.f295732g = false;
        this.f295728c++;
        if (!str.equalsIgnoreCase(g16)) {
            this.f295730e++;
        }
        e.b.c("TroopFileTransferRetryController", e.b.f295938b, "[" + this.f295726a + "] reqRetryOnErr suc, delay:" + j3 + " errCode:" + i3 + " bSvrErr:" + z16 + " strErrUrl:" + str + " selectUrl:" + g16 + " ReportR:" + this.f295728c + "UrlChgedT:" + this.f295730e);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0131, code lost:
    
        com.tencent.mobileqq.troop.filemanager.e.b.e("TroopFileTransferRetryController", com.tencent.mobileqq.troop.filemanager.e.b.f295938b, "[" + r16.f295726a + "] no next url use cur errurl");
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0186 A[Catch: all -> 0x01df, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x000e, B:8:0x0015, B:12:0x0033, B:14:0x003e, B:20:0x00ae, B:21:0x00c7, B:23:0x00cd, B:25:0x011a, B:34:0x0125, B:38:0x0180, B:40:0x0186, B:44:0x01b8, B:48:0x0131, B:49:0x0154, B:50:0x0071, B:52:0x0077), top: B:3:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected synchronized String g(String str, int i3, boolean z16) {
        String str2 = str;
        synchronized (this) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, this, str2, Integer.valueOf(i3), Boolean.valueOf(z16));
            }
            b bVar = this.f295735j.get(str2);
            if (bVar == null) {
                e.b.b("TroopFileTransferRetryController", e.b.f295938b, "[" + this.f295726a + "] selectUrl err. not find strErrUrl. urlCont:" + this.f295735j.size());
                return null;
            }
            if ((9056 == i3 || z16) && bVar.f295741a < this.f295736k) {
                b(bVar, i3, z16);
                e.b.c("TroopFileTransferRetryController", e.b.f295938b, "[" + this.f295726a + "] selectUrl:" + str2 + bVar.toString() + " eof err or serr, use cur errurl");
                return str2;
            }
            b bVar2 = new b();
            bVar2.f295741a = Integer.MAX_VALUE;
            bVar2.f295742b = Integer.MAX_VALUE;
            bVar2.f295743c = Integer.MAX_VALUE;
            String str3 = null;
            for (Map.Entry<String, b> entry : this.f295735j.entrySet()) {
                String key = entry.getKey();
                b value = entry.getValue();
                e.b.c("TroopFileTransferRetryController", e.b.f295938b, "[" + this.f295726a + "]" + key + " <->" + value.toString());
                if (!str2.equalsIgnoreCase(key) && value.f295741a < bVar2.f295741a) {
                    bVar2 = value;
                    str3 = key;
                }
            }
            if (str3 != null && bVar2.f295741a < this.f295736k) {
                bVar = bVar2;
                str2 = str3;
                if (bVar.f295741a >= this.f295736k) {
                    b(bVar, i3, z16);
                    e.b.c("TroopFileTransferRetryController", e.b.f295938b, "[" + this.f295726a + "] selectUrl:" + str2 + bVar.toString());
                    return str2;
                }
                this.f295732g = true;
                e.b.b("TroopFileTransferRetryController", e.b.f295938b, "[" + this.f295726a + "] all retry over and fail");
                return null;
            }
            e.b.e("TroopFileTransferRetryController", e.b.f295938b, "[" + this.f295726a + "] minurl retry over, use cur errurl. minRetryUrl:" + str3 + bVar2.toString());
            if (bVar.f295741a >= this.f295736k) {
            }
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.f295736k = 3;
        this.f295737l = 3;
        this.f295738m = 0;
        this.f295739n = 5;
    }
}
