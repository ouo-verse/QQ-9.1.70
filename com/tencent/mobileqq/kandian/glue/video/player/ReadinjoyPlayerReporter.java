package com.tencent.mobileqq.kandian.glue.video.player;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;

/* loaded from: classes33.dex */
public class ReadinjoyPlayerReporter extends com.tencent.mobileqq.kandian.base.video.player.c {

    /* renamed from: a, reason: collision with root package name */
    private int f240053a;

    /* renamed from: c, reason: collision with root package name */
    private e f240055c;

    /* renamed from: e, reason: collision with root package name */
    private boolean f240057e;

    /* renamed from: g, reason: collision with root package name */
    private boolean f240059g;

    /* renamed from: h, reason: collision with root package name */
    private SparseArray<f> f240060h = new SparseArray<>();

    /* renamed from: d, reason: collision with root package name */
    private Handler f240056d = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    public q52.b f240054b = new q52.b();

    /* renamed from: f, reason: collision with root package name */
    private boolean f240058f = false;

    /* loaded from: classes33.dex */
    public class a extends f {
        public a() {
            super();
        }

        @Override // com.tencent.mobileqq.kandian.glue.video.player.ReadinjoyPlayerReporter.f
        public void a(int i3, Object obj) {
            q52.b bVar = ReadinjoyPlayerReporter.this.f240054b;
            long j3 = bVar.f428408m;
            long uptimeMillis = SystemClock.uptimeMillis();
            q52.b bVar2 = ReadinjoyPlayerReporter.this.f240054b;
            bVar.f428408m = j3 + (uptimeMillis - bVar2.f428406l);
            bVar2.f428410o++;
        }
    }

    /* loaded from: classes33.dex */
    public class b extends f {
        public b() {
            super();
        }

        @Override // com.tencent.mobileqq.kandian.glue.video.player.ReadinjoyPlayerReporter.f
        public void a(int i3, Object obj) {
            ReadinjoyPlayerReporter.this.f240054b.f428406l = SystemClock.uptimeMillis();
        }
    }

    /* loaded from: classes33.dex */
    public class c extends f {
        public c() {
            super();
        }

        @Override // com.tencent.mobileqq.kandian.glue.video.player.ReadinjoyPlayerReporter.f
        public void a(int i3, Object obj) {
            q52.b bVar = ReadinjoyPlayerReporter.this.f240054b;
            if (bVar.f428400i > 0) {
                bVar.f428401i0 = SystemClock.uptimeMillis() - ReadinjoyPlayerReporter.this.f240054b.f428400i;
            } else {
                bVar.f428401i0 = 0L;
            }
            ReadinjoyPlayerReporter.this.f240054b.f428403j0 = SystemClock.uptimeMillis() - ReadinjoyPlayerReporter.this.f240054b.f428402j;
        }
    }

    /* loaded from: classes33.dex */
    public class d extends f {
        public d() {
            super();
        }

        @Override // com.tencent.mobileqq.kandian.glue.video.player.ReadinjoyPlayerReporter.f
        public void a(int i3, Object obj) {
            p52.a.INSTANCE.b(obj, ReadinjoyPlayerReporter.this.f240054b);
        }
    }

    /* loaded from: classes33.dex */
    public interface e {
        void l(q52.b bVar);
    }

    /* loaded from: classes33.dex */
    public class g extends f {
        public g() {
            super();
        }

        @Override // com.tencent.mobileqq.kandian.glue.video.player.ReadinjoyPlayerReporter.f
        public void a(int i3, Object obj) {
            ReadinjoyPlayerReporter.this.f240054b.f428405k0 = ((Long) obj).intValue();
        }
    }

    public ReadinjoyPlayerReporter(int i3, e eVar) {
        this.f240053a = i3;
        this.f240055c = eVar;
        l();
    }

    private void l() {
        this.f240060h.put(112, new b());
        this.f240060h.put(113, new a());
        this.f240060h.put(208, new d());
        this.f240060h.put(105, new c());
        this.f240060h.put(209, new g());
    }

    private void o(String str) {
        q52.b bVar = new q52.b();
        this.f240054b = bVar;
        bVar.f428386b = str;
        bVar.f428411p = this.f240053a;
        bVar.f428394f = true;
        bVar.M = 0;
        bVar.N = 0;
        bVar.O = 0;
        bVar.Q = false;
        bVar.R = "";
        bVar.Y = false;
        bVar.Z = false;
        e eVar = this.f240055c;
        if (eVar != null) {
            eVar.l(bVar);
        }
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.c
    public void b(String str) {
        this.f240054b.S = str;
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.c
    public void c(int i3, int i16, String str) {
        q52.b bVar = this.f240054b;
        bVar.f428394f = false;
        bVar.f428396g = i3 + ":" + i16;
        this.f240054b.f428398h = str;
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.c
    public void d(boolean z16) {
        this.f240054b.f428400i = SystemClock.uptimeMillis();
        this.f240054b.L = z16 ? 2 : 1;
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.c
    public void e(int i3, Object obj) {
        f fVar = this.f240060h.get(i3);
        if (fVar != null) {
            fVar.a(i3, obj);
        }
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.c
    public void g(VideoPlayerWrapper videoPlayerWrapper) {
        this.f240054b.I = videoPlayerWrapper.J();
        this.f240054b.H = videoPlayerWrapper.M();
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.c
    public void h(VideoPlayerWrapper videoPlayerWrapper, int i3) {
        this.f240054b.f428390d = videoPlayerWrapper.H(this.f240057e);
        this.f240054b.f428417v = videoPlayerWrapper.D();
        this.f240054b.f428416u = videoPlayerWrapper.E();
        this.f240054b.f428418w = videoPlayerWrapper.I();
        q52.b bVar = this.f240054b;
        bVar.f428419x = videoPlayerWrapper.A;
        bVar.C = videoPlayerWrapper.f239162w;
        bVar.B = videoPlayerWrapper.f239160u;
        bVar.D = videoPlayerWrapper.y();
        q52.b bVar2 = this.f240054b;
        if (bVar2.f428390d == 0 && bVar2.f428404k == 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            q52.b bVar3 = this.f240054b;
            bVar2.f428404k = uptimeMillis - bVar3.f428400i;
            bVar3.f428408m = bVar3.f428404k;
        }
        q52.b bVar4 = this.f240054b;
        bVar4.f428392e = i3;
        bVar4.f428399h0 = videoPlayerWrapper.A();
        videoPlayerWrapper.l(this.f240054b.a());
        n(this.f240054b);
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.c
    public void i(final VideoPlayerWrapper videoPlayerWrapper) {
        q52.b bVar = this.f240054b;
        if (bVar.f428404k != 0) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        q52.b bVar2 = this.f240054b;
        bVar.f428404k = uptimeMillis - bVar2.f428400i;
        bVar2.f428408m += bVar2.f428404k;
        bVar2.f428410o++;
        if (QLog.isColorLevel()) {
            QLog.d("ReadinjoyPlayerReporter", 2, "doReportOnVideoPrepared: vid=" + this.f240054b.f428386b + ", \u9884\u52a0\u8f7d\u72b6\u6001\uff1a" + this.f240054b.L + ", \u9884\u4e0b\u8f7d\u547d\u4e2d\uff1a" + this.f240058f + ", \u9996\u5e27\u8017\u65f6\uff1a" + this.f240054b.f428404k);
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.video.player.ReadinjoyPlayerReporter.1
            @Override // java.lang.Runnable
            public void run() {
                if (ReadinjoyPlayerReporter.this.f240059g) {
                    return;
                }
                videoPlayerWrapper.B();
            }
        }, 16, null, true);
    }

    public void k(r52.c cVar) {
        this.f240054b.f428412q = r52.b.a().f430767a.longValue();
        q52.b bVar = this.f240054b;
        bVar.f428413r = cVar.f430763j;
        bVar.J = cVar.f430756c;
        bVar.K = cVar.f430758e;
        bVar.P = cVar.f430757d;
        int i3 = 0;
        bVar.Q = false;
        String str = "";
        bVar.R = "";
        bVar.W = cVar.f430759f;
        bVar.Z = !TextUtils.isEmpty(cVar.f430760g);
        try {
            String host = new URL(cVar.f430754a).getHost();
            ArrayList<String> reqDnsForIpList = InnerDns.getInstance().reqDnsForIpList(host, 1006);
            q52.b bVar2 = this.f240054b;
            if (reqDnsForIpList != null) {
                i3 = reqDnsForIpList.size();
            }
            bVar2.U = i3;
            q52.b bVar3 = this.f240054b;
            if (reqDnsForIpList != null) {
                str = reqDnsForIpList.toString();
            }
            bVar3.V = str;
            this.f240054b.T = host;
        } catch (Exception unused) {
        }
    }

    private void n(q52.b bVar) {
        this.f240059g = true;
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.c
    public void a() {
        this.f240057e = true;
        q52.b bVar = this.f240054b;
        bVar.f428394f = true;
        bVar.f428415t = true;
    }

    @Override // com.tencent.mobileqq.kandian.base.video.player.c
    public void f(String str, String str2, boolean z16, boolean z17) {
        this.f240057e = false;
        this.f240059g = false;
        o(str);
        q52.b bVar = this.f240054b;
        bVar.L = 0;
        if (!z16) {
            bVar.f428400i = SystemClock.uptimeMillis();
        }
        this.f240054b.f428402j = SystemClock.uptimeMillis();
        q52.b bVar2 = this.f240054b;
        bVar2.M = 0;
        bVar2.N = 0;
        bVar2.O = 0;
        bVar2.Y = false;
        bVar2.Z = false;
        bVar2.f428387b0 = z17;
        m(str, str2);
    }

    public void p(f62.b bVar) {
    }

    /* loaded from: classes33.dex */
    public class f {
        public f() {
        }

        public void a(int i3, Object obj) {
        }
    }

    private void m(String str, String str2) {
    }
}
