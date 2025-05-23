package com.tencent.luggage.wxa.o3;

import com.tencent.luggage.wxa.tn.w0;
import common.config.service.QzoneConfig;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    public static final a f136126j = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public String f136127a;

    /* renamed from: b, reason: collision with root package name */
    public int f136128b;

    /* renamed from: c, reason: collision with root package name */
    public int f136129c;

    /* renamed from: d, reason: collision with root package name */
    public String f136130d;

    /* renamed from: e, reason: collision with root package name */
    public String f136131e;

    /* renamed from: f, reason: collision with root package name */
    public int f136132f;

    /* renamed from: g, reason: collision with root package name */
    public String f136133g;

    /* renamed from: h, reason: collision with root package name */
    public String f136134h;

    /* renamed from: i, reason: collision with root package name */
    public String f136135i;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public j() {
        this.f136127a = "";
        this.f136130d = "";
        this.f136131e = "";
        this.f136133g = "";
        this.f136134h = "";
        this.f136135i = "";
    }

    public void a(int i3) {
        this.f136132f = i3;
    }

    public void b(int i3) {
        this.f136129c = i3;
    }

    public void c(int i3) {
        this.f136128b = i3;
    }

    public String d() {
        return this.f136130d;
    }

    public void e(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f136131e = str;
    }

    public void f(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f136127a = str;
    }

    public String g() {
        return this.f136127a;
    }

    public int h() {
        return this.f136129c;
    }

    public int i() {
        return this.f136128b;
    }

    public final int j() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    public final int k() {
        return (int) (w0.d(i()) - b());
    }

    public String a() {
        return this.f136134h;
    }

    public int b() {
        return this.f136132f;
    }

    public void c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f136130d = str;
    }

    public void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f136133g = str;
    }

    public String e() {
        return this.f136133g;
    }

    public String f() {
        return this.f136131e;
    }

    public void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f136134h = str;
    }

    public void b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f136135i = str;
    }

    public String c() {
        return this.f136135i;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(String runtimeAppId, int i3, String sessionKey, String oauthCode, int i16, String openId, String avatarUrl, String nickName) {
        this();
        Intrinsics.checkNotNullParameter(runtimeAppId, "runtimeAppId");
        Intrinsics.checkNotNullParameter(sessionKey, "sessionKey");
        Intrinsics.checkNotNullParameter(oauthCode, "oauthCode");
        Intrinsics.checkNotNullParameter(openId, "openId");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        b(i3);
        f(sessionKey);
        c(oauthCode);
        c(j());
        a(i16 <= 0 ? QzoneConfig.DefaultValue.QZONESETTINGS_AIO_FEEDS_MIN_REFRESH_TIME : i16);
        e(runtimeAppId);
        d(openId);
        a(avatarUrl);
        b(nickName);
    }
}
