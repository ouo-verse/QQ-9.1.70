package com.tencent.luggage.wxa.o3;

import com.tencent.map.sdk.comps.vis.VisualLayer;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g extends Throwable {

    /* renamed from: h, reason: collision with root package name */
    public static final int f136110h = 0;

    /* renamed from: a, reason: collision with root package name */
    public final int f136112a;

    /* renamed from: b, reason: collision with root package name */
    public final int f136113b;

    /* renamed from: c, reason: collision with root package name */
    public final String f136114c;

    /* renamed from: d, reason: collision with root package name */
    public static final a f136106d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    public static final int f136107e = 1;

    /* renamed from: f, reason: collision with root package name */
    public static final int f136108f = 2;

    /* renamed from: g, reason: collision with root package name */
    public static final int f136109g = 3;

    /* renamed from: i, reason: collision with root package name */
    public static final int f136111i = -1;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return g.f136111i;
        }

        public final int b() {
            return g.f136110h;
        }

        public final int c() {
            return g.f136108f;
        }

        public final int d() {
            return g.f136107e;
        }

        public final int e() {
            return g.f136109g;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends g {

        /* renamed from: j, reason: collision with root package name */
        public static final b f136115j = new b();

        public b() {
            super(g.f136106d.d(), -2, "invalid args");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends g {

        /* renamed from: j, reason: collision with root package name */
        public static final c f136116j = new c();

        public c() {
            super(g.f136106d.d(), -3, "invalid session");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends g {

        /* renamed from: j, reason: collision with root package name */
        public static final d f136117j = new d();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public d() {
            super(r0.c(), r0.a(), VisualLayer.OnLayerStatusChangedListener.LayerStatusMsg.MSG_ERR_INTERNAL_ERROR);
            a aVar = g.f136106d;
        }
    }

    public g(int i3, int i16, String str) {
        this.f136112a = i3;
        this.f136113b = i16;
        this.f136114c = str;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof g)) {
            g gVar = (g) obj;
            if (this.f136113b == gVar.f136113b && this.f136112a == gVar.f136112a) {
                return true;
            }
            return false;
        }
        return super.equals(obj);
    }

    public final int f() {
        return this.f136113b;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getClass().getName() + " (errType:" + this.f136112a + " errCode:" + this.f136113b + " errMsg:" + this.f136114c + ')';
    }
}
