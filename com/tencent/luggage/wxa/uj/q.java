package com.tencent.luggage.wxa.uj;

import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class q {
    public String A;
    public String B;

    /* renamed from: a, reason: collision with root package name */
    public long f142527a;

    /* renamed from: b, reason: collision with root package name */
    public long f142528b;

    /* renamed from: c, reason: collision with root package name */
    public long f142529c;

    /* renamed from: d, reason: collision with root package name */
    public long f142530d;

    /* renamed from: e, reason: collision with root package name */
    public long f142531e;

    /* renamed from: f, reason: collision with root package name */
    public long f142532f;

    /* renamed from: g, reason: collision with root package name */
    public long f142533g;

    /* renamed from: h, reason: collision with root package name */
    public long f142534h;

    /* renamed from: i, reason: collision with root package name */
    public long f142535i;

    /* renamed from: j, reason: collision with root package name */
    public long f142536j;

    /* renamed from: k, reason: collision with root package name */
    public long f142537k;

    /* renamed from: l, reason: collision with root package name */
    public long f142538l;

    /* renamed from: m, reason: collision with root package name */
    public long f142539m;

    /* renamed from: n, reason: collision with root package name */
    public long f142540n;

    /* renamed from: o, reason: collision with root package name */
    public long f142541o;

    /* renamed from: p, reason: collision with root package name */
    public long f142542p;

    /* renamed from: q, reason: collision with root package name */
    public long f142543q;

    /* renamed from: r, reason: collision with root package name */
    public long f142544r;

    /* renamed from: s, reason: collision with root package name */
    public long f142545s;

    /* renamed from: t, reason: collision with root package name */
    public long f142546t;

    /* renamed from: u, reason: collision with root package name */
    public long f142547u;

    /* renamed from: v, reason: collision with root package name */
    public long f142548v;

    /* renamed from: w, reason: collision with root package name */
    public long f142549w;

    /* renamed from: x, reason: collision with root package name */
    public long f142550x;

    /* renamed from: y, reason: collision with root package name */
    public long f142551y;

    /* renamed from: z, reason: collision with root package name */
    public long f142552z;

    public q(long j3, long j16, long j17, long j18, long j19, long j26, long j27, long j28, long j29, long j36, long j37, long j38, long j39, long j46, long j47, long j48, long j49, long j56, long j57, long j58, long j59, long j65, long j66, long j67, long j68, long j69, String appId, String phoneNumber) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        this.f142527a = j3;
        this.f142528b = j16;
        this.f142529c = j17;
        this.f142530d = j18;
        this.f142531e = j19;
        this.f142532f = j26;
        this.f142533g = j27;
        this.f142534h = j28;
        this.f142535i = j29;
        this.f142536j = j36;
        this.f142537k = j37;
        this.f142538l = j38;
        this.f142539m = j39;
        this.f142540n = j46;
        this.f142541o = j47;
        this.f142542p = j48;
        this.f142543q = j49;
        this.f142544r = j56;
        this.f142545s = j57;
        this.f142546t = j58;
        this.f142547u = j59;
        this.f142548v = j65;
        this.f142549w = j66;
        this.f142550x = j67;
        this.f142551y = j68;
        this.f142552z = j69;
        this.A = appId;
        this.B = phoneNumber;
    }

    public final void a(long j3) {
        this.f142527a = j3;
    }

    public final void b(long j3) {
        this.f142528b = j3;
    }

    public final long c() {
        return this.f142531e;
    }

    public final void d(long j3) {
        this.f142530d = j3;
    }

    public final void e(long j3) {
        this.f142531e = j3;
    }

    public final void f(long j3) {
        this.f142535i = j3;
    }

    public final long g() {
        return this.f142533g;
    }

    public final long h() {
        return this.f142534h;
    }

    public final long i() {
        return this.f142529c;
    }

    public final void j(long j3) {
        this.f142534h = j3;
    }

    public final void k(long j3) {
        this.f142529c = j3;
    }

    public final void l(long j3) {
        this.f142550x = j3;
    }

    public final void m(long j3) {
        this.f142552z = j3;
    }

    public final void n(long j3) {
        this.f142551y = j3;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isBindPhone", this.f142527a);
        jSONObject.put("bindSuccess", this.f142528b);
        jSONObject.put("getPhoneNumberCount", this.f142529c);
        jSONObject.put("clickConfirmCount", this.f142530d);
        jSONObject.put("clickDenyCount", this.f142531e);
        jSONObject.put("clickCancelCount", this.f142532f);
        jSONObject.put("confirmBindedPhoneCount", this.f142533g);
        jSONObject.put("confirmUnBindPhoneCount", this.f142534h);
        jSONObject.put("clickInfoCount", this.f142535i);
        jSONObject.put("clickUseOtherPhoneCount", this.f142536j);
        jSONObject.put("clickManagePhoneCount", this.f142537k);
        jSONObject.put("clickGetVerifyCodeCount", this.f142538l);
        jSONObject.put("getVerifyCodeSuccessCount", this.f142539m);
        jSONObject.put("getVerifyCodeFailedCount", this.f142540n);
        jSONObject.put("clickAddPhoneDoneCount", this.f142541o);
        jSONObject.put("addPhoneSuccessCount", this.f142542p);
        jSONObject.put("addPhoneFailedCount", this.f142543q);
        jSONObject.put("addPhoneAndSaveCount", this.f142544r);
        jSONObject.put("addPhoneNotSaveCount", this.f142545s);
        jSONObject.put("clickAddPhoneOnManagePageCount", this.f142546t);
        jSONObject.put("deletePhoneCount", this.f142547u);
        jSONObject.put("deletePhoneSuccessCount", this.f142548v);
        jSONObject.put("deletePhoneFailedCount", this.f142549w);
        jSONObject.put("verifyCodeCount", this.f142550x);
        jSONObject.put("verifyCodeSuccessCount", this.f142551y);
        jSONObject.put("verifyCodeFailedCount", this.f142552z);
        jSONObject.put("appId", this.A);
        jSONObject.put(MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER, this.B);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        return jSONObject2;
    }

    public final long a() {
        return this.f142532f;
    }

    public final long b() {
        return this.f142530d;
    }

    public final void c(long j3) {
        this.f142532f = j3;
    }

    public final long d() {
        return this.f142535i;
    }

    public final long e() {
        return this.f142537k;
    }

    public final long f() {
        return this.f142536j;
    }

    public final void g(long j3) {
        this.f142537k = j3;
    }

    public final void h(long j3) {
        this.f142536j = j3;
    }

    public final void i(long j3) {
        this.f142533g = j3;
    }

    public final long j() {
        return this.f142550x;
    }

    public final long k() {
        return this.f142552z;
    }

    public final long l() {
        return this.f142551y;
    }

    public final void m() {
        n.f142511a.b().a(this);
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.A = str;
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.B = str;
    }

    public /* synthetic */ q(long j3, long j16, long j17, long j18, long j19, long j26, long j27, long j28, long j29, long j36, long j37, long j38, long j39, long j46, long j47, long j48, long j49, long j56, long j57, long j58, long j59, long j65, long j66, long j67, long j68, long j69, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? 0L : j16, (i3 & 4) != 0 ? 0L : j17, (i3 & 8) != 0 ? 0L : j18, (i3 & 16) != 0 ? 0L : j19, (i3 & 32) != 0 ? 0L : j26, (i3 & 64) != 0 ? 0L : j27, (i3 & 128) != 0 ? 0L : j28, (i3 & 256) != 0 ? 0L : j29, (i3 & 512) != 0 ? 0L : j36, (i3 & 1024) != 0 ? 0L : j37, (i3 & 2048) != 0 ? 0L : j38, (i3 & 4096) != 0 ? 0L : j39, (i3 & 8192) != 0 ? 0L : j46, (i3 & 16384) != 0 ? 0L : j47, (32768 & i3) != 0 ? 0L : j48, (65536 & i3) != 0 ? 0L : j49, (131072 & i3) != 0 ? 0L : j56, (262144 & i3) != 0 ? 0L : j57, (524288 & i3) != 0 ? 0L : j58, (1048576 & i3) != 0 ? 0L : j59, (2097152 & i3) != 0 ? 0L : j65, (4194304 & i3) != 0 ? 0L : j66, (8388608 & i3) != 0 ? 0L : j67, (16777216 & i3) != 0 ? 0L : j68, (33554432 & i3) == 0 ? j69 : 0L, (67108864 & i3) != 0 ? "" : str, (i3 & 134217728) == 0 ? str2 : "");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public q(String jsonStr) {
        this(0L, 0L, 0L, 0L, 0L, 0L, r16, r16, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, null, 268435455, null);
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        long j3 = 0;
        try {
            JSONObject jSONObject = new JSONObject(jsonStr);
            try {
                this.f142527a = jSONObject.optLong("isBindPhone", 0L);
                this.f142528b = jSONObject.optLong("bindSuccess", 0L);
                this.f142529c = jSONObject.optLong("getPhoneNumberCount", 0L);
                this.f142530d = jSONObject.optLong("clickConfirmCount", 0L);
                this.f142531e = jSONObject.optLong("clickDenyCount", 0L);
                this.f142532f = jSONObject.optLong("clickCancelCount", 0L);
                this.f142533g = jSONObject.optLong("confirmBindedPhoneCount", 0L);
                this.f142534h = jSONObject.optLong("confirmUnBindPhoneCount", 0L);
                this.f142535i = jSONObject.optLong("clickInfoCount", 0L);
                this.f142536j = jSONObject.optLong("clickUseOtherPhoneCount", 0L);
                this.f142537k = jSONObject.optLong("clickManagePhoneCount", 0L);
                this.f142538l = jSONObject.optLong("clickGetVerifyCodeCount", 0L);
                this.f142539m = jSONObject.optLong("getVerifyCodeSuccessCount", 0L);
                this.f142540n = jSONObject.optLong("getVerifyCodeFailedCount", 0L);
                this.f142541o = jSONObject.optLong("clickAddPhoneDoneCount", 0L);
                this.f142542p = jSONObject.optLong("addPhoneSuccessCount", 0L);
                this.f142543q = jSONObject.optLong("addPhoneFailedCount", 0L);
                this.f142544r = jSONObject.optLong("addPhoneAndSaveCount", 0L);
                this.f142545s = jSONObject.optLong("addPhoneNotSaveCount", 0L);
                this.f142546t = jSONObject.optLong("clickAddPhoneOnManagePageCount", 0L);
                this.f142547u = jSONObject.optLong("deletePhoneCount", 0L);
                this.f142548v = jSONObject.optLong("deletePhoneSuccessCount", 0L);
                this.f142549w = jSONObject.optLong("deletePhoneFailedCount", 0L);
                this.f142550x = jSONObject.optLong("verifyCodeCount", 0L);
                this.f142551y = jSONObject.optLong("verifyCodeSuccessCount", 0L);
                this.f142552z = jSONObject.optLong("verifyCodeFailedCount", 0L);
                String optString = jSONObject.optString("appId", "");
                Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"appId\", \"\")");
                this.A = optString;
                String optString2 = jSONObject.optString(MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER, "");
                Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(\"phoneNumber\", \"\")");
                this.B = optString2;
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
        }
    }
}
