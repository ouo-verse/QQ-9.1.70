package com.tencent.mobileqq.tvideo.net.utils;

import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.mobileqq.transfile.IPAddressUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.NetworkState;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import tvideo.DeviceInfo;
import tvideo.LoginToken;
import tvideo.NetworkInfo;
import tvideo.UserStatusInfo;
import tvideo.VersionInfo;
import zt2.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ(\u0010\t\u001a\u00020\b2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J(\u0010\n\u001a\u00020\b2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u000fJ\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/tvideo/net/utils/b;", "", "Ljava/util/ArrayList;", "Ltvideo/LoginToken;", "Lkotlin/collections/ArrayList;", "tokenList", "Lbu2/a;", "account", "", "b", "a", "", "tokenString", "Lokio/ByteString;", "c", "", "e", "Ltvideo/UserStatusInfo;", h.F, "Ltvideo/NetworkInfo;", "g", "Ltvideo/VersionInfo;", "i", "Ltvideo/DeviceInfo;", "d", "", "f", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f304500a = new b();

    b() {
    }

    private final void a(ArrayList<LoginToken> tokenList, bu2.a account) {
        String openId = account.getOpenId();
        String str = account.getCom.huawei.hms.support.feature.result.CommonConstant.KEY_ACCESS_TOKEN java.lang.String();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(openId)) {
            LoginToken build = new LoginToken.a().b("102031143").e(c(str)).f(10).a(openId).d(true).build();
            Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              \u2026                 .build()");
            tokenList.add(build);
        }
    }

    private final void b(ArrayList<LoginToken> tokenList, bu2.a account) {
        String valueOf = String.valueOf(account.getVideoUserId());
        String videoSessionKey = account.getVideoSessionKey();
        if (!TextUtils.isEmpty(videoSessionKey) && !TextUtils.isEmpty(valueOf)) {
            LoginToken build = new LoginToken.a().b("").e(c(videoSessionKey)).f(9).d(false).a(valueOf).build();
            Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              \u2026                 .build()");
            tokenList.add(build);
        }
    }

    private final ByteString c(String tokenString) {
        if (TextUtils.isEmpty(tokenString)) {
            return ByteString.EMPTY;
        }
        byte[] bytes = tokenString.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return ByteString.INSTANCE.of(bytes, 0, bytes.length);
    }

    @NotNull
    public final DeviceInfo d() {
        DeviceInfo.a aVar = new DeviceInfo.a();
        TVideoConfig tVideoConfig = TVideoConfig.f304492a;
        DeviceInfo build = aVar.c(tVideoConfig.d()).d("").f(tVideoConfig.f()).q(tVideoConfig.m()).o(tVideoConfig.k()).e(ah.s()).l(ah.C()).p(tVideoConfig.l()).n(tVideoConfig.g()).g(tVideoConfig.g()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder().density_dpi(TV\u2026Config.getGuid()).build()");
        return build;
    }

    @NotNull
    public final Map<String, String> e() {
        Map<String, String> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("OAID", HostStaticInvokeHelper.getAIDTicket()), TuplesKt.to("TAID", HostStaticInvokeHelper.getTAIDTicket()), TuplesKt.to("QIMEI36", TVideoConfig.f304492a.k()), TuplesKt.to("privacy_state", ny2.a.f421586a.a()));
        return mapOf;
    }

    @Nullable
    public final List<LoginToken> f() {
        bu2.a i3 = e.f453199a.i();
        if (i3 != null) {
            QLog.i("TVideoSsoHeaderHelper", 1, "genLoginToken: curr userId:" + i3.getVideoUserId() + " isExpired:" + i3.isExpired());
            ArrayList<LoginToken> arrayList = new ArrayList<>();
            b bVar = f304500a;
            bVar.b(arrayList, i3);
            bVar.a(arrayList, i3);
            return arrayList;
        }
        return null;
    }

    @NotNull
    public final NetworkInfo g() {
        int networkType = NetworkState.getNetworkType();
        int i3 = 3;
        int i16 = 1;
        if (networkType != 1) {
            if (networkType != 2) {
                if (networkType != 3) {
                    i3 = 5;
                    i16 = 4;
                    if (networkType != 4) {
                        if (networkType == 5) {
                            i3 = 6;
                        }
                    }
                } else {
                    i3 = 2;
                }
            }
            i3 = i16;
        }
        String ip5 = com.dataline.util.a.a(false);
        String str = "";
        if (IPAddressUtil.isIPv4LiteralAddress(ip5)) {
            Intrinsics.checkNotNullExpressionValue(ip5, "ip");
        } else if (!IPAddressUtil.isIPv6LiteralAddress(ip5)) {
            ip5 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(ip5, "ip");
            str = ip5;
            ip5 = "";
        }
        NetworkInfo build = new NetworkInfo.a().i(i3).e(ip5).f(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder().network_mode(n\u2026(ipv4).ipv6(ipv6).build()");
        return build;
    }

    @NotNull
    public final UserStatusInfo h() {
        UserStatusInfo build = new UserStatusInfo.a().c(0).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder().preview_mode(0).build()");
        return build;
    }

    @NotNull
    public final VersionInfo i() {
        VersionInfo.a aVar = new VersionInfo.a();
        TVideoConfig tVideoConfig = TVideoConfig.f304492a;
        VersionInfo build = aVar.e(tVideoConfig.j()).d(tVideoConfig.h()).g(tVideoConfig.n()).a("3000063").c(tVideoConfig.b()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder().platform_versi\u2026Config.channelId).build()");
        return build;
    }
}
