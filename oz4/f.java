package oz4;

import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import com.xingin.xhssharesdk.a.g;
import e05.b;
import e05.c;
import e05.d;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;
import oz4.k;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f424748a;

    /* renamed from: b, reason: collision with root package name */
    public final ExecutorService f424749b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f424750c;

    /* renamed from: d, reason: collision with root package name */
    public final com.xingin.xhssharesdk.b.r f424751d;

    /* renamed from: e, reason: collision with root package name */
    public s f424752e;

    /* renamed from: f, reason: collision with root package name */
    public w f424753f;

    public f() {
        final com.xingin.xhssharesdk.b.r rVar = com.xingin.xhssharesdk.b.r.BIZ;
        this.f424748a = new AtomicBoolean(false);
        this.f424750c = new ArrayList();
        this.f424751d = rVar;
        this.f424749b = ProxyExecutors.newSingleThreadExecutor(new ThreadFactory() { // from class: oz4.d
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return f.b(com.xingin.xhssharesdk.b.r.this, runnable);
            }
        });
    }

    public static Thread b(com.xingin.xhssharesdk.b.r rVar, Runnable runnable) {
        return new BaseThread(runnable, "TrackerEncoder-" + rVar.f389974a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(k kVar, n nVar) {
        pz4.c cVar;
        com.xingin.xhssharesdk.a.q<String, String> qVar;
        i iVar = new i(kVar, nVar);
        q.a("%s ,track() TrackerEvent=%s", this.f424751d, iVar);
        j jVar = iVar.f424765b;
        b.a d16 = e05.b.Z.d();
        int i3 = iVar.f424765b.f424772e;
        d16.f();
        ((e05.b) d16.f389937e).f395325h = i3;
        String str = iVar.f424765b.f424773f;
        d16.f();
        e05.b bVar = (e05.b) d16.f389937e;
        bVar.getClass();
        String str2 = "";
        if (str == null) {
            str = "";
        }
        bVar.f395326i = str;
        String valueOf = String.valueOf(iVar.f424765b.f424774h);
        d16.f();
        e05.b bVar2 = (e05.b) d16.f389937e;
        bVar2.getClass();
        if (valueOf == null) {
            valueOf = "";
        }
        bVar2.f395327m = valueOf;
        iVar.f424765b.getClass();
        d16.f();
        e05.b bVar3 = (e05.b) d16.f389937e;
        bVar3.getClass();
        bVar3.C = "";
        iVar.f424765b.getClass();
        d16.f();
        e05.b bVar4 = (e05.b) d16.f389937e;
        bVar4.getClass();
        bVar4.D = "";
        String a16 = l.a(iVar.f424769f.f424778c);
        d16.f();
        e05.b bVar5 = (e05.b) d16.f389937e;
        bVar5.getClass();
        bVar5.G = a16;
        String str3 = iVar.f424764a.f424788d;
        d16.f();
        e05.b bVar6 = (e05.b) d16.f389937e;
        bVar6.getClass();
        if (str3 == null) {
            str3 = "";
        }
        bVar6.H = str3;
        iVar.f424764a.getClass();
        d16.f();
        e05.b bVar7 = (e05.b) d16.f389937e;
        bVar7.getClass();
        bVar7.I = "Android";
        String str4 = iVar.f424764a.f424789e;
        d16.f();
        e05.b bVar8 = (e05.b) d16.f389937e;
        bVar8.getClass();
        if (str4 == null) {
            str4 = "";
        }
        bVar8.J = str4;
        String valueOf2 = String.valueOf(iVar.f424764a.f424790f);
        d16.f();
        e05.b bVar9 = (e05.b) d16.f389937e;
        bVar9.getClass();
        if (valueOf2 == null) {
            valueOf2 = "";
        }
        bVar9.K = valueOf2;
        iVar.f424764a.getClass();
        d16.f();
        e05.b bVar10 = (e05.b) d16.f389937e;
        bVar10.getClass();
        bVar10.L = "";
        iVar.f424764a.getClass();
        d16.f();
        ((e05.b) d16.f389937e).M = 0;
        String str5 = iVar.f424764a.f424791h;
        d16.f();
        e05.b bVar11 = (e05.b) d16.f389937e;
        bVar11.getClass();
        if (str5 == null) {
            str5 = "";
        }
        bVar11.N = str5;
        String str6 = iVar.f424764a.f424792i;
        d16.f();
        e05.b bVar12 = (e05.b) d16.f389937e;
        bVar12.getClass();
        if (str6 == null) {
            str6 = "";
        }
        bVar12.P = str6;
        iVar.f424764a.getClass();
        d16.f();
        ((e05.b) d16.f389937e).M = 0;
        String str7 = iVar.f424766c.f424801d;
        d16.f();
        e05.b bVar13 = (e05.b) d16.f389937e;
        bVar13.getClass();
        if (str7 == null) {
            str7 = "";
        }
        bVar13.R = str7;
        String str8 = iVar.f424766c.f424802e;
        d16.f();
        e05.b bVar14 = (e05.b) d16.f389937e;
        bVar14.getClass();
        if (str8 == null) {
            str8 = "";
        }
        bVar14.S = str8;
        String str9 = iVar.f424768e.f424798d;
        d16.f();
        e05.b bVar15 = (e05.b) d16.f389937e;
        bVar15.getClass();
        if (str9 == null) {
            str9 = "";
        }
        bVar15.T = str9;
        String str10 = iVar.f424768e.f424799e;
        d16.f();
        e05.b bVar16 = (e05.b) d16.f389937e;
        bVar16.getClass();
        if (str10 == null) {
            str10 = "";
        }
        bVar16.U = str10;
        String str11 = iVar.f424765b.f424771d;
        d16.f();
        e05.b bVar17 = (e05.b) d16.f389937e;
        bVar17.getClass();
        if (str11 == null) {
            str11 = "";
        }
        bVar17.V = str11;
        String str12 = iVar.f424767d.f424794d;
        d16.f();
        e05.b bVar18 = (e05.b) d16.f389937e;
        bVar18.getClass();
        if (str12 == null) {
            str12 = "";
        }
        bVar18.W = str12;
        String str13 = iVar.f424767d.f424795e;
        d16.f();
        e05.b bVar19 = (e05.b) d16.f389937e;
        bVar19.getClass();
        if (str13 == null) {
            str13 = "";
        }
        bVar19.X = str13;
        int a17 = b.a(iVar.f424767d.f424796f);
        d16.f();
        ((e05.b) d16.f389937e).Y = a17;
        e05.b e16 = d16.e();
        d.b d17 = e05.d.K.d();
        int i16 = iVar.f424769f.f424780e;
        d17.f();
        ((e05.d) d17.f389937e).f395331h = i16;
        iVar.f424769f.getClass();
        iVar.f424769f.getClass();
        iVar.f424769f.getClass();
        int i17 = iVar.f424769f.f424781f;
        if (i17 != 0) {
            d17.f();
            e05.d dVar = (e05.d) d17.f389937e;
            dVar.getClass();
            dVar.D = e05.a.a(i17);
        }
        String str14 = iVar.f424769f.f424776a;
        d17.f();
        e05.d dVar2 = (e05.d) d17.f389937e;
        dVar2.getClass();
        if (str14 != null) {
            str2 = str14;
        }
        dVar2.E = str2;
        int i18 = iVar.f424769f.f424779d;
        d17.f();
        ((e05.d) d17.f389937e).F = i18;
        long j3 = iVar.f424769f.f424777b;
        d17.f();
        ((e05.d) d17.f389937e).G = j3;
        HashMap hashMap = iVar.f424769f.f424782g;
        d17.f();
        e05.d dVar3 = (e05.d) d17.f389937e;
        com.xingin.xhssharesdk.a.q<String, String> qVar2 = dVar3.J;
        if (!qVar2.f389971a) {
            if (qVar2.isEmpty()) {
                qVar = new com.xingin.xhssharesdk.a.q<>();
            } else {
                qVar = new com.xingin.xhssharesdk.a.q<>(qVar2);
            }
            dVar3.J = qVar;
        }
        dVar3.J.putAll(hashMap);
        e05.d e17 = d17.e();
        c.a d18 = e05.c.f395328m.d();
        d18.f();
        e05.c cVar2 = (e05.c) d18.f389937e;
        cVar2.getClass();
        cVar2.f395330i = e17;
        d18.f();
        e05.c cVar3 = (e05.c) d18.f389937e;
        cVar3.getClass();
        cVar3.f395329h = e16;
        e05.c e18 = d18.e();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            Logger logger = com.xingin.xhssharesdk.a.g.f389913a;
            cVar = new pz4.c(new g.d(byteArrayOutputStream));
        } catch (FileNotFoundException e19) {
            e19.printStackTrace();
            cVar = null;
        }
        if (cVar != null) {
            try {
                cVar.a(e18);
            } catch (Exception e26) {
                e26.printStackTrace();
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (jVar != null && kVar != null) {
            String str15 = kVar.f424776a;
            l.a(kVar.f424778c);
            if (g(str15, byteArray)) {
                this.f424753f.i();
                return;
            }
            String str16 = kVar.f424776a;
            c.a(kVar.f424778c);
            this.f424753f.g(new sz4.f(-1L, str16, byteArray, null));
        }
    }

    public final void c() {
        q.a("%s ,handleCache() cache size=%s", this.f424751d, Integer.valueOf(this.f424750c.size()));
        synchronized (this.f424750c) {
            Iterator it = this.f424750c.iterator();
            while (it.hasNext()) {
                e((k) it.next());
            }
        }
    }

    public final synchronized void d(k.a aVar) {
        aVar.f424783a = 1;
        k kVar = new k();
        kVar.f424778c = aVar.f424783a;
        kVar.f424780e = aVar.f424784b;
        kVar.f424781f = aVar.f424785c;
        kVar.f424782g = aVar.f424786d;
        e(kVar);
    }

    public final void e(final k kVar) {
        if (!this.f424748a.get()) {
            q.a("%s ,addToCache() TrackerEventDetail=%s", this.f424751d, kVar);
            synchronized (this.f424750c) {
                this.f424750c.add(kVar);
            }
            return;
        }
        final n a16 = n.a();
        this.f424749b.execute(new Runnable() { // from class: oz4.e
            @Override // java.lang.Runnable
            public final void run() {
                f.this.f(kVar, a16);
            }
        });
    }

    public final boolean g(String str, byte[] bArr) {
        s sVar = this.f424752e;
        long b16 = sVar.f424804a.b(new sz4.f(-1L, str, bArr, null));
        Object[] objArr = new Object[2];
        com.xingin.xhssharesdk.b.r rVar = sVar.f424805b;
        if (b16 >= 0) {
            objArr[0] = rVar;
            objArr[1] = str;
            q.a("%s, store() success eventId=%s", objArr);
        } else {
            objArr[0] = rVar;
            objArr[1] = str;
            q.a("%s, store() fail eventId=%s", objArr);
        }
        if (b16 >= 0) {
            return true;
        }
        return false;
    }
}
