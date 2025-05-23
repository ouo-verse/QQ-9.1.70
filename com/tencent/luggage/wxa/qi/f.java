package com.tencent.luggage.wxa.qi;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.luggage.wxa.qi.i;
import com.tencent.luggage.wxa.ri.d;
import com.tencent.luggage.wxa.si.a;
import com.tencent.luggage.wxa.ti.b;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.e0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f {

    /* renamed from: u, reason: collision with root package name */
    public static f f138839u;

    /* renamed from: v, reason: collision with root package name */
    public static Object f138840v;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.luggage.wxa.si.b f138844d;

    /* renamed from: g, reason: collision with root package name */
    public String f138847g;

    /* renamed from: o, reason: collision with root package name */
    public b0 f138855o;

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.si.a f138841a = null;

    /* renamed from: b, reason: collision with root package name */
    public boolean f138842b = false;

    /* renamed from: c, reason: collision with root package name */
    public Object f138843c = new Object();

    /* renamed from: e, reason: collision with root package name */
    public n f138845e = n.INITIALIZING;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.ri.d f138846f = null;

    /* renamed from: h, reason: collision with root package name */
    public boolean f138848h = false;

    /* renamed from: i, reason: collision with root package name */
    public int f138849i = 0;

    /* renamed from: j, reason: collision with root package name */
    public e0 f138850j = null;

    /* renamed from: k, reason: collision with root package name */
    public long f138851k = 0;

    /* renamed from: l, reason: collision with root package name */
    public long f138852l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f138853m = 0;

    /* renamed from: n, reason: collision with root package name */
    public long f138854n = 0;

    /* renamed from: p, reason: collision with root package name */
    public boolean f138856p = false;

    /* renamed from: q, reason: collision with root package name */
    public boolean f138857q = false;

    /* renamed from: r, reason: collision with root package name */
    public a.b f138858r = new C6647f();

    /* renamed from: s, reason: collision with root package name */
    public d.a f138859s = new g();

    /* renamed from: t, reason: collision with root package name */
    public com.tencent.luggage.wxa.qi.e f138860t = new d();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = f.this;
            fVar.a(fVar.f138852l);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.u();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.u();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements com.tencent.luggage.wxa.qi.e {
        public d() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements i.b {
        @Override // com.tencent.luggage.wxa.qi.i.b
        public void a(long j3, long j16, long j17, boolean z16) {
        }

        @Override // com.tencent.luggage.wxa.qi.i.b
        public void a(ArrayList arrayList, boolean z16) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g implements d.a {
        public g() {
        }

        @Override // com.tencent.luggage.wxa.ri.d.a
        public void a(byte[] bArr, int i3, boolean z16) {
            f.this.a(bArr, i3, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h implements e0.a {
        public h() {
        }

        @Override // com.tencent.luggage.wxa.tn.e0.a
        public boolean a() {
            w.d("MicroMsg.Record.AudioRecordMgr", "timer, onTimerExpired to stop record");
            f.this.t();
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.si.b f138868a;

        public i(com.tencent.luggage.wxa.si.b bVar) {
            this.f138868a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (f.this.f138843c) {
                f.this.f138844d = this.f138868a;
                f.this.c();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (f.this.f138843c) {
                f.this.b();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (f.this.f138843c) {
                f.this.a();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (f.this.f138843c) {
                f.this.d();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = f.this;
            fVar.a(fVar.f138852l);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum n {
        INITIALIZING,
        START,
        RESUME,
        PAUSE,
        STOP,
        ERROR
    }

    static {
        com.tencent.luggage.wxa.qi.i.a(new e());
        f138840v = new Object();
    }

    public boolean k() {
        if (this.f138845e == n.STOP) {
            return true;
        }
        return false;
    }

    public void l() {
        w.d("MicroMsg.Record.AudioRecordMgr", MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        this.f138845e = n.PAUSE;
        this.f138842b = false;
        com.tencent.luggage.wxa.ti.b bVar = new com.tencent.luggage.wxa.ti.b();
        b.a aVar = bVar.f141374d;
        aVar.f141375a = 3;
        aVar.f141377c = "pause";
        com.tencent.luggage.wxa.si.b bVar2 = this.f138844d;
        if (bVar2 != null) {
            aVar.f141384j = bVar2.f140380j;
        }
        bVar.a(Looper.getMainLooper());
    }

    public void m() {
        w.d("MicroMsg.Record.AudioRecordMgr", "onResume");
        this.f138845e = n.RESUME;
        this.f138842b = true;
        com.tencent.luggage.wxa.ti.b bVar = new com.tencent.luggage.wxa.ti.b();
        b.a aVar = bVar.f141374d;
        aVar.f141375a = 1;
        aVar.f141377c = "resume";
        com.tencent.luggage.wxa.si.b bVar2 = this.f138844d;
        if (bVar2 != null) {
            aVar.f141384j = bVar2.f140380j;
        }
        bVar.a(Looper.getMainLooper());
    }

    public void n() {
        w.d("MicroMsg.Record.AudioRecordMgr", "onStart");
        this.f138845e = n.START;
        this.f138842b = true;
        com.tencent.luggage.wxa.ti.b bVar = new com.tencent.luggage.wxa.ti.b();
        b.a aVar = bVar.f141374d;
        aVar.f141375a = 0;
        aVar.f141377c = "start";
        com.tencent.luggage.wxa.si.b bVar2 = this.f138844d;
        if (bVar2 != null) {
            aVar.f141384j = bVar2.f140380j;
        }
        bVar.a(Looper.getMainLooper());
    }

    public void o() {
        w.d("MicroMsg.Record.AudioRecordMgr", DKHippyEvent.EVENT_STOP);
        this.f138845e = n.STOP;
        this.f138842b = false;
        com.tencent.luggage.wxa.ti.b bVar = new com.tencent.luggage.wxa.ti.b();
        b.a aVar = bVar.f141374d;
        aVar.f141375a = 2;
        aVar.f141377c = "stop";
        com.tencent.luggage.wxa.si.b bVar2 = this.f138844d;
        if (bVar2 != null) {
            aVar.f141384j = bVar2.f140380j;
        }
        w.d("MicroMsg.Record.AudioRecordMgr", "mPcmDuration:%d, mRealRecordedTime%d", Integer.valueOf(this.f138849i), Integer.valueOf(this.f138853m));
        bVar.f141374d.f141376b = Math.min(this.f138849i, this.f138853m);
        b.a aVar2 = bVar.f141374d;
        String str = this.f138847g;
        aVar2.f141378d = str;
        aVar2.f141379e = (int) com.tencent.luggage.wxa.qi.g.c(str);
        bVar.a(Looper.getMainLooper());
    }

    public boolean p() {
        w.d("MicroMsg.Record.AudioRecordMgr", "pauseRecord");
        if (this.f138841a == null) {
            w.b("MicroMsg.Record.AudioRecordMgr", "mRecord is null");
            return false;
        }
        if (i()) {
            w.b("MicroMsg.Record.AudioRecordMgr", "is paused, don't pause again");
            return true;
        }
        com.tencent.luggage.wxa.co.a.a(new k(), "app_brand_pause_record");
        return true;
    }

    public final void q() {
        if (this.f138856p) {
            return;
        }
        this.f138856p = true;
    }

    public boolean r() {
        if (this.f138842b) {
            w.b("MicroMsg.Record.AudioRecordMgr", "resumeRecord fail, is recording");
            return false;
        }
        if (this.f138844d == null) {
            w.b("MicroMsg.Record.AudioRecordMgr", "resumeRecord fail, mRecordParam is null");
            return false;
        }
        com.tencent.luggage.wxa.qi.i.a();
        com.tencent.luggage.wxa.co.a.a(new j(), "app_brand_resume_record");
        return true;
    }

    public final boolean s() {
        w.d("MicroMsg.Record.AudioRecordMgr", "startRecordInternal");
        com.tencent.luggage.wxa.si.a aVar = this.f138841a;
        if (aVar != null) {
            aVar.d();
            this.f138841a = null;
            w.d("MicroMsg.Record.AudioRecordMgr", "mRecorder is not null, stop it, and not callback stop event");
        }
        if (this.f138841a == null) {
            com.tencent.luggage.wxa.si.a aVar2 = new com.tencent.luggage.wxa.si.a(this.f138844d);
            this.f138841a = aVar2;
            aVar2.a(this.f138858r);
        }
        boolean c16 = this.f138841a.c();
        w.d("MicroMsg.Record.AudioRecordMgr", "record start:%b", Boolean.valueOf(c16));
        return c16;
    }

    public boolean t() {
        w.d("MicroMsg.Record.AudioRecordMgr", "stopRecord");
        if (this.f138841a == null && this.f138846f == null) {
            w.b("MicroMsg.Record.AudioRecordMgr", "mRecord is null and mAudioEncoder is null, stop fail");
            return false;
        }
        com.tencent.luggage.wxa.co.a.a(new l(), "app_brand_stop_record");
        return true;
    }

    public final void u() {
        w.d("MicroMsg.Record.AudioRecordMgr", "stopTimer");
        e0 e0Var = this.f138850j;
        if (e0Var != null) {
            e0Var.f();
        }
        this.f138850j = null;
    }

    public static f h() {
        f fVar;
        synchronized (f138840v) {
            if (f138839u == null) {
                f138839u = new f();
            }
            fVar = f138839u;
        }
        return fVar;
    }

    public final void b() {
        try {
            w.d("MicroMsg.Record.AudioRecordMgr", "_resume in runnable");
            if (this.f138846f == null) {
                a(3);
                w.b("MicroMsg.Record.AudioRecordMgr", "resume record fail");
                return;
            }
            if (this.f138852l <= 0) {
                d();
                w.b("MicroMsg.Record.AudioRecordMgr", "resume record fail, record time reach max time, to stop record");
            } else {
                if (s()) {
                    this.f138854n = System.currentTimeMillis();
                    w.d("MicroMsg.Record.AudioRecordMgr", "mLimitTime:%d, currentTime:%d", Long.valueOf(this.f138852l), Long.valueOf(this.f138854n));
                    e().a((Runnable) new a());
                    m();
                    w.d("MicroMsg.Record.AudioRecordMgr", "resume record success");
                    return;
                }
                a(7);
                w.b("MicroMsg.Record.AudioRecordMgr", "resume record fail");
            }
        } catch (Exception e16) {
            w.a("MicroMsg.Record.AudioRecordMgr", e16, "_resume", new Object[0]);
            a(5);
        }
    }

    public final void c() {
        try {
            w.d("MicroMsg.Record.AudioRecordMgr", "_start in runnable");
            if (!g()) {
                a(2);
                w.b("MicroMsg.Record.AudioRecordMgr", "init encoder fail");
                return;
            }
            this.f138848h = false;
            this.f138849i = 0;
            q();
            if (s()) {
                this.f138846f.a(this.f138841a.b());
                this.f138846f.a(this.f138844d.f140378h);
                this.f138853m = 0;
                this.f138851k = this.f138844d.f140371a;
                this.f138854n = System.currentTimeMillis();
                long j3 = this.f138851k;
                this.f138852l = j3;
                w.d("MicroMsg.Record.AudioRecordMgr", "mDuration:%d, mCurrentTime:%d", Long.valueOf(j3), Long.valueOf(this.f138854n));
                e().a((Runnable) new m());
                n();
                w.d("MicroMsg.Record.AudioRecordMgr", "start record success");
                return;
            }
            a(6);
            w.b("MicroMsg.Record.AudioRecordMgr", "start record fail");
        } catch (Exception e16) {
            w.a("MicroMsg.Record.AudioRecordMgr", e16, "_start", new Object[0]);
            a(4);
        }
    }

    public final void d() {
        boolean z16;
        w.d("MicroMsg.Record.AudioRecordMgr", "stop record in runnable");
        try {
        } catch (Exception e16) {
            w.a("MicroMsg.Record.AudioRecordMgr", e16, "_stop", new Object[0]);
            z16 = false;
        }
        if (k()) {
            w.b("MicroMsg.Record.AudioRecordMgr", "is stopped, don't stop again");
            return;
        }
        com.tencent.luggage.wxa.si.a aVar = this.f138841a;
        if (aVar != null) {
            z16 = aVar.d();
            this.f138841a = null;
        } else {
            w.b("MicroMsg.Record.AudioRecordMgr", "mRecorder is null, has stop record!");
            z16 = true;
        }
        this.f138848h = true;
        w.d("MicroMsg.Record.AudioRecordMgr", "mPcmDuration:%d", Integer.valueOf(this.f138849i));
        com.tencent.luggage.wxa.ri.d dVar = this.f138846f;
        if (dVar != null) {
            dVar.flush();
            this.f138846f.close();
            this.f138846f = null;
        }
        e().a((Runnable) new c());
        if (i()) {
            w.b("MicroMsg.Record.AudioRecordMgr", "don't calculate time again if it is pause state");
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            long currentTimeMillis2 = System.currentTimeMillis() - this.f138854n;
            w.d("MicroMsg.Record.AudioRecordMgr", "currentTime:%d, interval:%d, mRealRecordedTime:%d", Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis2), Integer.valueOf(this.f138853m));
            int i3 = (int) (this.f138853m + currentTimeMillis2);
            this.f138853m = i3;
            long j3 = this.f138851k - i3;
            this.f138852l = j3;
            w.d("MicroMsg.Record.AudioRecordMgr", "mLimitTime:%d, mRealRecordTime:%d", Long.valueOf(j3), Integer.valueOf(this.f138853m));
        }
        w.d("MicroMsg.Record.AudioRecordMgr", "stop:%b", Boolean.valueOf(z16));
        if (z16) {
            o();
            w.d("MicroMsg.Record.AudioRecordMgr", "stop record success");
        } else {
            a(9);
            w.b("MicroMsg.Record.AudioRecordMgr", "stop record fail");
        }
        this.f138844d = null;
        com.tencent.luggage.wxa.qi.c.a((List) null);
    }

    public final b0 e() {
        if (this.f138855o == null) {
            this.f138855o = new b0(Looper.getMainLooper());
        }
        return this.f138855o;
    }

    public n f() {
        return this.f138845e;
    }

    public final boolean g() {
        w.d("MicroMsg.Record.AudioRecordMgr", "initEncode");
        com.tencent.luggage.wxa.ri.d dVar = this.f138846f;
        if (dVar != null) {
            dVar.close();
            this.f138846f = null;
        }
        com.tencent.luggage.wxa.si.b bVar = this.f138844d;
        String b16 = com.tencent.luggage.wxa.qi.g.b(bVar.f140375e, bVar.f140376f);
        this.f138847g = b16;
        boolean z16 = false;
        w.d("MicroMsg.Record.AudioRecordMgr", "mFilePath:%s", b16);
        com.tencent.luggage.wxa.ri.d a16 = com.tencent.luggage.wxa.ri.b.a(this.f138844d.f140375e);
        this.f138846f = a16;
        if (a16 != null) {
            boolean e16 = com.tencent.luggage.wxa.qi.g.e(this.f138847g);
            if (!e16) {
                w.b("MicroMsg.Record.AudioRecordMgr", "prepare cache file fail");
                return e16;
            }
            try {
                com.tencent.luggage.wxa.ri.d dVar2 = this.f138846f;
                String str = this.f138847g;
                com.tencent.luggage.wxa.si.b bVar2 = this.f138844d;
                z16 = dVar2.a(str, bVar2.f140372b, bVar2.f140373c, bVar2.f140374d);
            } catch (Exception e17) {
                w.a("MicroMsg.Record.AudioRecordMgr", e17, "init encoder fail", new Object[0]);
            }
            this.f138846f.a(this.f138859s);
        }
        return z16;
    }

    public boolean i() {
        return this.f138845e == n.PAUSE;
    }

    public boolean j() {
        return this.f138842b;
    }

    public static /* synthetic */ int a(f fVar, int i3) {
        int i16 = fVar.f138849i + i3;
        fVar.f138849i = i16;
        return i16;
    }

    public final void a(long j3) {
        u();
        w.d("MicroMsg.Record.AudioRecordMgr", "startTimer");
        e0 e0Var = new e0(new h(), false);
        this.f138850j = e0Var;
        e0Var.a(j3);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.qi.f$f, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6647f implements a.b {
        public C6647f() {
        }

        @Override // com.tencent.luggage.wxa.si.a.b
        public void a(byte[] bArr, int i3) {
            if (f.this.f138846f == null || f.this.f138841a == null) {
                return;
            }
            f fVar = f.this;
            f.a(fVar, fVar.f138841a.a());
            try {
                if (f.this.f138846f.a(f.this.f138848h, bArr, i3)) {
                    return;
                }
                w.b("MicroMsg.Record.AudioRecordMgr", "encode pcm fail!");
            } catch (Exception e16) {
                w.a("MicroMsg.Record.AudioRecordMgr", e16, "onRecPcmDataReady", new Object[0]);
                if (f.this.f138844d == null || !FileReaderHelper.MP3_EXT.equalsIgnoreCase(f.this.f138844d.f140375e)) {
                    if (f.this.f138844d == null || !FileReaderHelper.AAC_EXT.equalsIgnoreCase(f.this.f138844d.f140375e)) {
                        return;
                    }
                    com.tencent.luggage.wxa.qi.i.a(23);
                    return;
                }
                com.tencent.luggage.wxa.qi.i.a(19);
            }
        }

        @Override // com.tencent.luggage.wxa.si.a.b
        public void a(int i3, int i16) {
            w.d("MicroMsg.Record.AudioRecordMgr", "onRecError state:%d, detailState:%d", Integer.valueOf(i3), Integer.valueOf(i16));
            f.this.a(1);
        }
    }

    public boolean a(com.tencent.luggage.wxa.si.b bVar) {
        com.tencent.luggage.wxa.si.b bVar2;
        String str;
        w.d("MicroMsg.Record.AudioRecordMgr", "startRecord");
        if (bVar != null && (bVar2 = this.f138844d) != null && (str = bVar.f140380j) != null && !str.equalsIgnoreCase(bVar2.f140380j)) {
            w.b("MicroMsg.Record.AudioRecordMgr", "appId is diff, must stop record first");
            t();
        } else {
            if (this.f138842b) {
                w.b("MicroMsg.Record.AudioRecordMgr", "startRecord fail, is recording");
                return false;
            }
            if (i()) {
                w.b("MicroMsg.Record.AudioRecordMgr", "startRecord fail, is pause");
                return false;
            }
        }
        if (bVar == null) {
            w.b("MicroMsg.Record.AudioRecordMgr", "startRecord fail, param is null");
            return false;
        }
        if (!com.tencent.luggage.wxa.si.c.a(bVar)) {
            w.b("MicroMsg.Record.AudioRecordMgr", "startRecord fail, param is invalid");
            com.tencent.luggage.wxa.qi.i.a(15);
            return false;
        }
        if (!com.tencent.luggage.wxa.qi.g.d(bVar.f140375e)) {
            w.b("MicroMsg.Record.AudioRecordMgr", "startRecord fail, encode format %s is not support!", bVar.f140375e);
            com.tencent.luggage.wxa.qi.i.a(16);
            return false;
        }
        if (TextUtils.isEmpty(bVar.f140376f)) {
            bVar.f140376f = "" + System.currentTimeMillis();
        }
        com.tencent.luggage.wxa.qi.i.a();
        com.tencent.luggage.wxa.si.c.b(bVar);
        com.tencent.luggage.wxa.co.a.a(new i(bVar), "app_brand_start_record");
        return true;
    }

    public void a() {
        boolean z16;
        w.d("MicroMsg.Record.AudioRecordMgr", "pause record in runnable");
        try {
        } catch (Exception e16) {
            w.a("MicroMsg.Record.AudioRecordMgr", e16, "_pause", new Object[0]);
            z16 = false;
        }
        if (i()) {
            w.b("MicroMsg.Record.AudioRecordMgr", "is paused, don't pause again");
            return;
        }
        com.tencent.luggage.wxa.si.a aVar = this.f138841a;
        if (aVar != null) {
            z16 = aVar.d();
            this.f138841a = null;
        } else {
            z16 = false;
        }
        com.tencent.luggage.wxa.si.b bVar = this.f138844d;
        e().a((Runnable) new b());
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = currentTimeMillis - this.f138854n;
        w.d("MicroMsg.Record.AudioRecordMgr", "currentTime:%d, interval:%d, mRealRecordedTime:%d", Long.valueOf(currentTimeMillis), Long.valueOf(j3), Integer.valueOf(this.f138853m));
        int i3 = (int) (this.f138853m + j3);
        this.f138853m = i3;
        long j16 = this.f138851k - i3;
        this.f138852l = j16;
        w.d("MicroMsg.Record.AudioRecordMgr", "mLimitTime:%d, mRealRecordTime:%d", Long.valueOf(j16), Integer.valueOf(this.f138853m));
        w.d("MicroMsg.Record.AudioRecordMgr", "stop:%b", Boolean.valueOf(z16));
        if (z16) {
            l();
            w.d("MicroMsg.Record.AudioRecordMgr", "pause record success");
        } else {
            a(8);
            w.b("MicroMsg.Record.AudioRecordMgr", "pause record fail");
        }
    }

    public void a(int i3) {
        w.d("MicroMsg.Record.AudioRecordMgr", "onError errType:%d", Integer.valueOf(i3));
        n f16 = f();
        n nVar = n.ERROR;
        if (f16 != nVar) {
            com.tencent.luggage.wxa.qi.i.b(i3);
        }
        this.f138845e = nVar;
        this.f138842b = false;
        com.tencent.luggage.wxa.ti.b bVar = new com.tencent.luggage.wxa.ti.b();
        b.a aVar = bVar.f141374d;
        aVar.f141375a = 4;
        aVar.f141377c = "error";
        com.tencent.luggage.wxa.si.b bVar2 = this.f138844d;
        if (bVar2 != null) {
            aVar.f141384j = bVar2.f140380j;
        }
        aVar.f141382h = i3;
        aVar.f141383i = com.tencent.luggage.wxa.qi.h.b(i3);
        bVar.a(Looper.getMainLooper());
    }

    public void a(byte[] bArr, int i3, boolean z16) {
        w.d("MicroMsg.Record.AudioRecordMgr", "onFrameRecorded  buffSize:%d, isLastFrameL:%b", Integer.valueOf(i3), Boolean.valueOf(z16));
        com.tencent.luggage.wxa.ti.b bVar = new com.tencent.luggage.wxa.ti.b();
        b.a aVar = bVar.f141374d;
        aVar.f141377c = "frameRecorded";
        com.tencent.luggage.wxa.si.b bVar2 = this.f138844d;
        if (bVar2 != null) {
            aVar.f141384j = bVar2.f140380j;
        }
        aVar.f141375a = 5;
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, 0, bArr2, 0, i3);
        b.a aVar2 = bVar.f141374d;
        aVar2.f141380f = bArr2;
        aVar2.f141381g = z16;
        bVar.a(Looper.getMainLooper());
    }
}
