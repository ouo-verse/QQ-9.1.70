package com.tencent.luggage.wxa.o3;

import android.os.Looper;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.luggage.wxa.tn.f0;
import common.config.service.QzoneConfig;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class k extends j {

    /* renamed from: k, reason: collision with root package name */
    public static final k f136136k = new k();

    /* renamed from: l, reason: collision with root package name */
    public static final Lazy f136137l;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f136138a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final f0 invoke() {
            return f0.a("Luggage.SessionInfoShare", 2, "ZuFvyjiexTZ+m92yY8aHJj69cWkmfnqAOfjZw6si5f0=\n");
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(a.f136138a);
        f136137l = lazy;
    }

    @Override // com.tencent.luggage.wxa.o3.j
    public void a(int i3) {
        f0 m3 = m();
        if (m3 != null) {
            m3.putInt("expiresIn", i3);
        }
        f0 m16 = m();
        if (m16 != null) {
            m16.commit();
        }
    }

    @Override // com.tencent.luggage.wxa.o3.j
    public void b(int i3) {
        new com.tencent.luggage.wxa.t3.b(i3).a(Looper.getMainLooper());
        f0 m3 = m();
        if (m3 != null) {
            m3.putInt("uin", i3);
        }
        f0 m16 = m();
        if (m16 != null) {
            m16.commit();
        }
    }

    @Override // com.tencent.luggage.wxa.o3.j
    public void c(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        f0 m3 = m();
        if (m3 != null) {
            m3.putString("oauthCode", value);
        }
        f0 m16 = m();
        if (m16 != null) {
            m16.commit();
        }
    }

    @Override // com.tencent.luggage.wxa.o3.j
    public String d() {
        f0 m3 = m();
        String string = m3 != null ? m3.getString("oauthCode", "") : null;
        return string == null ? "" : string;
    }

    @Override // com.tencent.luggage.wxa.o3.j
    public void e(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        f0 m3 = m();
        if (m3 != null) {
            m3.putString("runtimeAppId", value);
        }
        f0 m16 = m();
        if (m16 != null) {
            m16.commit();
        }
    }

    @Override // com.tencent.luggage.wxa.o3.j
    public void f(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        f0 m3 = m();
        if (m3 != null) {
            m3.putString("sessionKey", value);
        }
        c(j());
        f0 m16 = m();
        if (m16 != null) {
            m16.commit();
        }
    }

    @Override // com.tencent.luggage.wxa.o3.j
    public String g() {
        String str;
        f0 m3 = m();
        if (m3 != null) {
            str = m3.getString("sessionKey", "");
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // com.tencent.luggage.wxa.o3.j
    public int h() {
        f0 m3 = m();
        if (m3 == null) {
            return -1;
        }
        return m3.getInt("uin", -1);
    }

    @Override // com.tencent.luggage.wxa.o3.j
    public int i() {
        f0 m3 = m();
        if (m3 != null) {
            return m3.getInt("updateTimeStamp", -1);
        }
        return 0;
    }

    public final void l() {
        b(0);
        f("");
        c(0);
        c("");
        e("");
        a(QzoneConfig.DefaultValue.QZONESETTINGS_AIO_FEEDS_MIN_REFRESH_TIME);
        a("");
        b("");
    }

    public final f0 m() {
        return (f0) f136137l.getValue();
    }

    public String toString() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.US, "session(uin: %s, sessionKey: %s, oauthCode: %s, runtimeAppId: %s\uff0cexpiresIn: %d, avatarUrl: %s, nickName: %s)", Arrays.copyOf(new Object[]{Integer.valueOf(h()), g(), d(), f(), Integer.valueOf(b()), a(), c()}, 7));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        return format;
    }

    @Override // com.tencent.luggage.wxa.o3.j
    public void d(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        f0 m3 = m();
        if (m3 != null) {
            m3.putString("openId", value);
        }
        f0 m16 = m();
        if (m16 != null) {
            m16.commit();
        }
    }

    @Override // com.tencent.luggage.wxa.o3.j
    public String a() {
        f0 m3 = m();
        String string = m3 != null ? m3.getString(PhotoCategorySummaryInfo.AVATAR_URL, "") : null;
        return string == null ? "" : string;
    }

    @Override // com.tencent.luggage.wxa.o3.j
    public void c(int i3) {
        f0 m3 = m();
        if (m3 != null) {
            m3.putInt("updateTimeStamp", i3);
        }
        f0 m16 = m();
        if (m16 != null) {
            m16.commit();
        }
    }

    @Override // com.tencent.luggage.wxa.o3.j
    public String e() {
        f0 m3 = m();
        String string = m3 != null ? m3.getString("openId", "") : null;
        return string == null ? "" : string;
    }

    @Override // com.tencent.luggage.wxa.o3.j
    public void a(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        f0 m3 = m();
        if (m3 != null) {
            m3.putString(PhotoCategorySummaryInfo.AVATAR_URL, value);
        }
        f0 m16 = m();
        if (m16 != null) {
            m16.commit();
        }
    }

    @Override // com.tencent.luggage.wxa.o3.j
    public int b() {
        f0 m3 = m();
        if (m3 != null) {
            return m3.getInt("expiresIn", -1);
        }
        return -1;
    }

    @Override // com.tencent.luggage.wxa.o3.j
    public String f() {
        f0 m3 = m();
        String string = m3 != null ? m3.getString("runtimeAppId", "") : null;
        return string == null ? "" : string;
    }

    @Override // com.tencent.luggage.wxa.o3.j
    public void b(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        f0 m3 = m();
        if (m3 != null) {
            m3.putString("nickName", value);
        }
        f0 m16 = m();
        if (m16 != null) {
            m16.commit();
        }
    }

    @Override // com.tencent.luggage.wxa.o3.j
    public String c() {
        f0 m3 = m();
        String string = m3 != null ? m3.getString("nickName", "") : null;
        return string == null ? "" : string;
    }
}
