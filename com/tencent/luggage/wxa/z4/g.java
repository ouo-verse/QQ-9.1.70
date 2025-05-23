package com.tencent.luggage.wxa.z4;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes9.dex */
public class g {

    /* renamed from: i, reason: collision with root package name */
    public static final a f146302i = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f146303a;

    /* renamed from: b, reason: collision with root package name */
    public int f146304b;

    /* renamed from: c, reason: collision with root package name */
    public h f146305c;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.luggage.wxa.fd.i f146306d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f146307e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f146308f;

    /* renamed from: g, reason: collision with root package name */
    public final long f146309g;

    /* renamed from: h, reason: collision with root package name */
    public String f146310h;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public g(String appId, int i3, h status, com.tencent.luggage.wxa.fd.i initConfig, boolean z16) {
        boolean z17;
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(initConfig, "initConfig");
        this.f146303a = appId;
        this.f146304b = i3;
        this.f146305c = status;
        this.f146306d = initConfig;
        this.f146307e = z16;
        if (status != h.PRE_RENDERED && status != h.RUNNING) {
            z17 = false;
        } else {
            z17 = true;
        }
        this.f146308f = z17;
        this.f146309g = System.currentTimeMillis();
        this.f146310h = "";
    }

    public final String a() {
        return this.f146303a;
    }

    public final int b() {
        return this.f146304b;
    }

    public final com.tencent.luggage.wxa.fd.i c() {
        return this.f146306d;
    }

    public final String d() {
        return this.f146310h;
    }

    public final long e() {
        return this.f146309g;
    }

    public final boolean f() {
        return this.f146307e;
    }

    public String toString() {
        return "LuggageMiniProgramRecord(appId='" + this.f146303a + "', debugType=" + this.f146304b + ", instanceId=" + this.f146310h + ", status=" + this.f146305c + ", isPersistent=" + this.f146307e + ", preRendered=" + this.f146308f + ", startingTimestamp=" + this.f146309g + ')';
    }

    public final void a(com.tencent.luggage.wxa.fd.i iVar) {
        Intrinsics.checkNotNullParameter(iVar, "<set-?>");
        this.f146306d = iVar;
    }

    public final void a(boolean z16) {
        this.f146307e = z16;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f146310h = str;
    }

    public final void a(h status) {
        Intrinsics.checkNotNullParameter(status, "status");
        this.f146305c = status;
    }
}
