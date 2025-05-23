package com.tencent.luggage.wxa.b9;

import com.eclipsesource.mmv8.snapshot.CreateSnapshotResult;
import com.tencent.luggage.wxa.tn.w0;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface d {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void a(d dVar);

        void b(d dVar);

        void c(d dVar);
    }

    t a(int i3, int i16);

    void a();

    void a(int i3);

    void a(int i3, com.tencent.luggage.wxa.ei.i iVar);

    void a(Runnable runnable);

    void a(Runnable runnable, long j3);

    void a(Runnable runnable, long j3, boolean z16);

    void a(Runnable runnable, boolean z16);

    void a(String str, boolean z16);

    t b(int i3);

    void b();

    void b(Runnable runnable);

    t c(int i3);

    void c(Runnable runnable);

    boolean c();

    String d();

    void e();

    long f();

    void h();

    boolean i();

    long j();

    a k();

    void pause();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f122185a;

        /* renamed from: b, reason: collision with root package name */
        public String f122186b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f122187c;

        /* renamed from: d, reason: collision with root package name */
        public byte[] f122188d;

        /* renamed from: e, reason: collision with root package name */
        public int f122189e;

        /* renamed from: f, reason: collision with root package name */
        public String f122190f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f122191g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f122192h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f122193i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f122194j;

        /* renamed from: k, reason: collision with root package name */
        public String f122195k;

        /* renamed from: l, reason: collision with root package name */
        public String f122196l;

        /* renamed from: m, reason: collision with root package name */
        public int f122197m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f122198n;

        /* renamed from: o, reason: collision with root package name */
        public WeakReference f122199o;

        /* renamed from: p, reason: collision with root package name */
        public h f122200p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f122201q;

        public a(String str, byte[] bArr) {
            this.f122185a = null;
            this.f122186b = null;
            this.f122187c = false;
            this.f122188d = null;
            this.f122189e = CreateSnapshotResult.Success.INVALID_CONTEXT_INDEX;
            this.f122190f = "0";
            this.f122193i = false;
            this.f122194j = false;
            this.f122195k = null;
            this.f122196l = "";
            this.f122197m = Integer.MIN_VALUE;
            this.f122198n = false;
            this.f122199o = null;
            this.f122201q = true;
            this.f122185a = str;
            this.f122188d = bArr;
        }

        public boolean a() {
            return "1".equalsIgnoreCase(this.f122190f);
        }

        public String toString() {
            String str;
            boolean z16;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Config{codeCache='");
            sb5.append(this.f122185a);
            sb5.append('\'');
            sb5.append(", delaySaveCodeCache=");
            sb5.append(this.f122198n);
            sb5.append(", snapshotPath='");
            sb5.append(this.f122186b);
            sb5.append('\'');
            sb5.append(", isNodeSnapshot=");
            sb5.append(this.f122187c);
            sb5.append(", snapShot=");
            if (w0.b(this.f122188d)) {
                str = "null";
            } else {
                str = "not null";
            }
            sb5.append(str);
            sb5.append(", mainContextSnapshotIndex=");
            sb5.append(this.f122189e);
            sb5.append(", nativeBuffer='");
            sb5.append(this.f122190f);
            sb5.append('\'');
            sb5.append(", supportDirectEvaluation=");
            sb5.append(this.f122191g);
            sb5.append(", enableNativeTrans=");
            sb5.append(this.f122192h);
            sb5.append(", hasGlobalTimer=");
            sb5.append(this.f122193i);
            sb5.append(", ignoreRemainingTaskWhenLoopEnd=");
            sb5.append(this.f122194j);
            sb5.append(", globalAlias=");
            sb5.append(this.f122195k);
            sb5.append(", jsThreadPriority=");
            sb5.append(this.f122197m);
            sb5.append(", hasComponent=");
            WeakReference weakReference = this.f122199o;
            boolean z17 = true;
            if (weakReference != null && weakReference.get() != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append(", hasBufferStore=");
            if (this.f122200p == null) {
                z17 = false;
            }
            sb5.append(z17);
            sb5.append(", enableJavaConsole=");
            sb5.append(this.f122201q);
            sb5.append('}');
            return sb5.toString();
        }

        public a() {
            this.f122185a = null;
            this.f122186b = null;
            this.f122187c = false;
            this.f122188d = null;
            this.f122189e = CreateSnapshotResult.Success.INVALID_CONTEXT_INDEX;
            this.f122190f = "0";
            this.f122193i = false;
            this.f122194j = false;
            this.f122195k = null;
            this.f122196l = "";
            this.f122197m = Integer.MIN_VALUE;
            this.f122198n = false;
            this.f122199o = null;
            this.f122201q = true;
        }
    }
}
