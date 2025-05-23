package com.tencent.mobileqq.tvideo.net.base;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tl.h;
import tvideo.BucketInfo;
import tvideo.DeviceInfo;
import tvideo.EnvInfo;
import tvideo.FlagInfo;
import tvideo.LocationInfo;
import tvideo.LoginToken;
import tvideo.NetworkInfo;
import tvideo.OttInfo;
import tvideo.RequestHead;
import tvideo.SafeInfo;
import tvideo.UserStatusInfo;
import tvideo.VersionInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0016\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0002J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0002J\u0006\u0010\u001d\u001a\u00020\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/tvideo/net/base/a;", "", "Ltvideo/SafeInfo;", "k", "Ltvideo/DeviceInfo;", "c", "Ltvideo/VersionInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ltvideo/NetworkInfo;", "i", "Ltvideo/FlagInfo;", "f", "Ltvideo/BucketInfo;", "b", "Ltvideo/UserStatusInfo;", "l", "", "", "e", "Ltvideo/OttInfo;", "j", "Ltvideo/EnvInfo;", "d", "Ltvideo/LocationInfo;", "g", "", "Ltvideo/LoginToken;", h.F, "Ltvideo/RequestHead$a;", "a", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f304490a = new a();

    a() {
    }

    private final BucketInfo b() {
        return null;
    }

    private final DeviceInfo c() {
        return com.tencent.mobileqq.tvideo.net.utils.b.f304500a.d();
    }

    private final EnvInfo d() {
        return null;
    }

    private final Map<String, String> e() {
        return com.tencent.mobileqq.tvideo.net.utils.b.f304500a.e();
    }

    private final FlagInfo f() {
        return null;
    }

    private final LocationInfo g() {
        return null;
    }

    private final List<LoginToken> h() {
        return com.tencent.mobileqq.tvideo.net.utils.b.f304500a.f();
    }

    private final NetworkInfo i() {
        return com.tencent.mobileqq.tvideo.net.utils.b.f304500a.g();
    }

    private final OttInfo j() {
        return null;
    }

    private final SafeInfo k() {
        return null;
    }

    private final UserStatusInfo l() {
        return com.tencent.mobileqq.tvideo.net.utils.b.f304500a.h();
    }

    private final VersionInfo m() {
        return com.tencent.mobileqq.tvideo.net.utils.b.f304500a.i();
    }

    @NotNull
    public final RequestHead.a a() {
        RequestHead.a aVar = new RequestHead.a();
        SafeInfo k3 = k();
        if (k3 != null) {
            aVar.p(k3);
        }
        DeviceInfo c16 = c();
        if (c16 != null) {
            aVar.e(c16);
        }
        VersionInfo m3 = m();
        if (m3 != null) {
            aVar.s(m3);
        }
        NetworkInfo i3 = i();
        if (i3 != null) {
            aVar.l(i3);
        }
        FlagInfo f16 = f();
        if (f16 != null) {
            aVar.h(f16);
        }
        BucketInfo b16 = b();
        if (b16 != null) {
            aVar.a(b16);
        }
        UserStatusInfo l3 = l();
        if (l3 != null) {
            aVar.r(l3);
        }
        Map<String, String> e16 = e();
        if (e16 != null) {
            aVar.g(e16);
        }
        OttInfo j3 = j();
        if (j3 != null) {
            aVar.m(j3);
        }
        EnvInfo d16 = d();
        if (d16 != null) {
            aVar.f(d16);
        }
        LocationInfo g16 = g();
        if (g16 != null) {
            aVar.j(g16);
        }
        List<LoginToken> h16 = h();
        if (h16 != null) {
            aVar.k(h16);
        }
        return aVar;
    }
}
