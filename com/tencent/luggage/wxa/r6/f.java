package com.tencent.luggage.wxa.r6;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f extends com.tencent.luggage.wxa.r6.a {
    public long A;
    public long B;

    /* renamed from: d, reason: collision with root package name */
    public long f139324d;

    /* renamed from: e, reason: collision with root package name */
    public a f139325e;

    /* renamed from: g, reason: collision with root package name */
    public long f139327g;

    /* renamed from: i, reason: collision with root package name */
    public long f139329i;

    /* renamed from: k, reason: collision with root package name */
    public long f139331k;

    /* renamed from: l, reason: collision with root package name */
    public long f139332l;

    /* renamed from: m, reason: collision with root package name */
    public long f139333m;

    /* renamed from: n, reason: collision with root package name */
    public long f139334n;

    /* renamed from: o, reason: collision with root package name */
    public long f139335o;

    /* renamed from: p, reason: collision with root package name */
    public long f139336p;

    /* renamed from: q, reason: collision with root package name */
    public long f139337q;

    /* renamed from: r, reason: collision with root package name */
    public long f139338r;

    /* renamed from: s, reason: collision with root package name */
    public long f139339s;

    /* renamed from: t, reason: collision with root package name */
    public long f139340t;

    /* renamed from: u, reason: collision with root package name */
    public long f139341u;

    /* renamed from: v, reason: collision with root package name */
    public long f139342v;

    /* renamed from: w, reason: collision with root package name */
    public long f139343w;

    /* renamed from: x, reason: collision with root package name */
    public long f139344x;

    /* renamed from: y, reason: collision with root package name */
    public long f139345y;

    /* renamed from: z, reason: collision with root package name */
    public long f139346z;

    /* renamed from: b, reason: collision with root package name */
    public String f139322b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f139323c = "";

    /* renamed from: f, reason: collision with root package name */
    public String f139326f = "";

    /* renamed from: h, reason: collision with root package name */
    public String f139328h = "";

    /* renamed from: j, reason: collision with root package name */
    public String f139330j = "";
    public String C = "";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum a {
        release(1),
        debug(2),
        demo(3);


        /* renamed from: a, reason: collision with root package name */
        public final int f139351a;

        a(int i3) {
            this.f139351a = i3;
        }

        public int b() {
            return this.f139351a;
        }

        public static a a(int i3) {
            if (i3 == 1) {
                return release;
            }
            if (i3 == 2) {
                return debug;
            }
            if (i3 != 3) {
                return null;
            }
            return demo;
        }
    }

    @Override // com.tencent.luggage.wxa.r6.a
    public int a() {
        return 10168;
    }

    public f b(String str) {
        this.f139322b = a("AppId", str, true);
        return this;
    }

    public f c(long j3) {
        this.f139342v = j3;
        return this;
    }

    public f d(String str) {
        this.f139323c = str;
        return this;
    }

    public f e(String str) {
        this.f139326f = a("InstanceId", str, true);
        return this;
    }

    public f f(String str) {
        this.f139330j = a("LibVersion", str, true);
        return this;
    }

    public f g(String str) {
        this.f139328h = a("NetworkType", str, true);
        return this;
    }

    public f h(long j3) {
        this.f139346z = j3;
        return this;
    }

    public f i(long j3) {
        this.f139335o = j3;
        return this;
    }

    public f j(long j3) {
        this.f139336p = j3;
        return this;
    }

    public f k(long j3) {
        this.f139343w = j3;
        return this;
    }

    public f l(long j3) {
        this.f139344x = j3;
        return this;
    }

    public f m(long j3) {
        this.f139337q = j3;
        return this;
    }

    public f n(long j3) {
        this.f139332l = j3;
        return this;
    }

    public f o(long j3) {
        this.f139340t = j3;
        return this;
    }

    public f p(long j3) {
        this.f139341u = j3;
        return this;
    }

    public f q(long j3) {
        this.f139331k = j3;
        return this;
    }

    public f r(long j3) {
        this.f139334n = j3;
        return this;
    }

    public f s(long j3) {
        this.f139329i = j3;
        return this;
    }

    public f t(long j3) {
        this.f139333m = j3;
        return this;
    }

    public f u(long j3) {
        this.f139339s = j3;
        return this;
    }

    public f a(a aVar) {
        this.f139325e = aVar;
        return this;
    }

    public f c(String str) {
        this.C = a("ExtraInfo", str, true);
        return this;
    }

    public f d(long j3) {
        this.B = j3;
        return this;
    }

    public String h(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f139322b);
        stringBuffer.append(str);
        stringBuffer.append(this.f139324d);
        stringBuffer.append(str);
        a aVar = this.f139325e;
        stringBuffer.append(aVar != null ? aVar.b() : -1);
        stringBuffer.append(str);
        stringBuffer.append(this.f139326f);
        stringBuffer.append(str);
        stringBuffer.append(this.f139327g);
        stringBuffer.append(str);
        stringBuffer.append(this.f139328h);
        stringBuffer.append(str);
        stringBuffer.append(this.f139329i);
        stringBuffer.append(str);
        stringBuffer.append(this.f139330j);
        stringBuffer.append(str);
        stringBuffer.append(this.f139331k);
        stringBuffer.append(str);
        stringBuffer.append(this.f139332l);
        stringBuffer.append(str);
        stringBuffer.append(this.f139333m);
        stringBuffer.append(str);
        stringBuffer.append(this.f139334n);
        stringBuffer.append(str);
        stringBuffer.append(this.f139335o);
        stringBuffer.append(str);
        stringBuffer.append(this.f139336p);
        stringBuffer.append(str);
        stringBuffer.append(this.f139337q);
        stringBuffer.append(str);
        stringBuffer.append(this.f139338r);
        stringBuffer.append(str);
        stringBuffer.append(this.f139339s);
        stringBuffer.append(str);
        stringBuffer.append(this.f139340t);
        stringBuffer.append(str);
        stringBuffer.append(this.f139341u);
        stringBuffer.append(str);
        stringBuffer.append(this.f139342v);
        stringBuffer.append(str);
        stringBuffer.append(this.f139343w);
        stringBuffer.append(str);
        stringBuffer.append(this.f139344x);
        stringBuffer.append(str);
        stringBuffer.append(this.f139345y);
        stringBuffer.append(str);
        stringBuffer.append(this.f139346z);
        stringBuffer.append(str);
        stringBuffer.append(this.A);
        stringBuffer.append(str);
        stringBuffer.append(this.B);
        stringBuffer.append(str);
        stringBuffer.append(this.C);
        stringBuffer.append(str);
        stringBuffer.append(this.f139323c);
        String stringBuffer2 = stringBuffer.toString();
        a(stringBuffer2);
        return stringBuffer2;
    }

    public f a(long j3) {
        this.f139327g = j3;
        return this;
    }

    public f b(long j3) {
        this.f139324d = j3;
        return this;
    }

    @Override // com.tencent.luggage.wxa.r6.a
    public String d() {
        return h(",");
    }

    public f e(long j3) {
        this.A = j3;
        return this;
    }

    public f f(long j3) {
        this.f139338r = j3;
        return this;
    }

    public f g(long j3) {
        this.f139345y = j3;
        return this;
    }

    public String e() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AppId");
        stringBuffer.append(":");
        stringBuffer.append(this.f139322b);
        stringBuffer.append("\r\n");
        stringBuffer.append("AppVersion");
        stringBuffer.append(":");
        stringBuffer.append(this.f139324d);
        stringBuffer.append("\r\n");
        stringBuffer.append("AppState");
        stringBuffer.append(":");
        stringBuffer.append(this.f139325e);
        stringBuffer.append("\r\n");
        stringBuffer.append("InstanceId");
        stringBuffer.append(":");
        stringBuffer.append(this.f139326f);
        stringBuffer.append("\r\n");
        stringBuffer.append("AppType");
        stringBuffer.append(":");
        stringBuffer.append(this.f139327g);
        stringBuffer.append("\r\n");
        stringBuffer.append("NetworkType");
        stringBuffer.append(":");
        stringBuffer.append(this.f139328h);
        stringBuffer.append("\r\n");
        stringBuffer.append("Scene");
        stringBuffer.append(":");
        stringBuffer.append(this.f139329i);
        stringBuffer.append("\r\n");
        stringBuffer.append("LibVersion");
        stringBuffer.append(":");
        stringBuffer.append(this.f139330j);
        stringBuffer.append("\r\n");
        stringBuffer.append("RenderMode");
        stringBuffer.append(":");
        stringBuffer.append(this.f139331k);
        stringBuffer.append("\r\n");
        stringBuffer.append("MainCanvasType");
        stringBuffer.append(":");
        stringBuffer.append(this.f139332l);
        stringBuffer.append("\r\n");
        stringBuffer.append("SceneId");
        stringBuffer.append(":");
        stringBuffer.append(this.f139333m);
        stringBuffer.append("\r\n");
        stringBuffer.append("RuntimeDuration");
        stringBuffer.append(":");
        stringBuffer.append(this.f139334n);
        stringBuffer.append("\r\n");
        stringBuffer.append("Fps");
        stringBuffer.append(":");
        stringBuffer.append(this.f139335o);
        stringBuffer.append("\r\n");
        stringBuffer.append("FpsEx");
        stringBuffer.append(":");
        stringBuffer.append(this.f139336p);
        stringBuffer.append("\r\n");
        stringBuffer.append("Jank");
        stringBuffer.append(":");
        stringBuffer.append(this.f139337q);
        stringBuffer.append("\r\n");
        stringBuffer.append("BigJank");
        stringBuffer.append(":");
        stringBuffer.append(this.f139338r);
        stringBuffer.append("\r\n");
        stringBuffer.append("Stutter");
        stringBuffer.append(":");
        stringBuffer.append(this.f139339s);
        stringBuffer.append("\r\n");
        stringBuffer.append("Memory");
        stringBuffer.append(":");
        stringBuffer.append(this.f139340t);
        stringBuffer.append("\r\n");
        stringBuffer.append("MemoryDiff");
        stringBuffer.append(":");
        stringBuffer.append(this.f139341u);
        stringBuffer.append("\r\n");
        stringBuffer.append("AvailableMemory");
        stringBuffer.append(":");
        stringBuffer.append(this.f139342v);
        stringBuffer.append("\r\n");
        stringBuffer.append("GPUMemory");
        stringBuffer.append(":");
        stringBuffer.append(this.f139343w);
        stringBuffer.append("\r\n");
        stringBuffer.append("GPUUtilizationDevice");
        stringBuffer.append(":");
        stringBuffer.append(this.f139344x);
        stringBuffer.append("\r\n");
        stringBuffer.append("CPUUtilization");
        stringBuffer.append(":");
        stringBuffer.append(this.f139345y);
        stringBuffer.append("\r\n");
        stringBuffer.append("CPUUtilizationDevice");
        stringBuffer.append(":");
        stringBuffer.append(this.f139346z);
        stringBuffer.append("\r\n");
        stringBuffer.append("BatteryLevel");
        stringBuffer.append(":");
        stringBuffer.append(this.A);
        stringBuffer.append("\r\n");
        stringBuffer.append("BatteryInfo");
        stringBuffer.append(":");
        stringBuffer.append(this.B);
        stringBuffer.append("\r\n");
        stringBuffer.append("ExtraInfo");
        stringBuffer.append(":");
        stringBuffer.append(this.C);
        stringBuffer.append("\r\n");
        stringBuffer.append("HostAppId");
        stringBuffer.append(":");
        stringBuffer.append(this.f139323c);
        return stringBuffer.toString();
    }
}
