package com.tencent.biz.pubaccount.weishi.report.dc898;

import com.tencent.biz.pubaccount.weishi.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi.player.l;
import com.tencent.component.network.module.common.NetworkState;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static WSReportDC898Base f81525a;

    public static Map<String, String> a(com.tencent.biz.pubaccount.weishi.player.e eVar, boolean z16) {
        String valueOf;
        WSPlayerWrapper wSPlayerWrapper = eVar.f81129e;
        if (wSPlayerWrapper == null) {
            valueOf = "0";
        } else {
            valueOf = String.valueOf(wSPlayerWrapper.Q(z16));
        }
        l lVar = eVar.f81127c;
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleLpReportDc05507.KEY_VIDEO_TOTAL_TIME, String.valueOf(lVar.f81169d));
        hashMap.put(QCircleLpReportDc05507.KEY_VIDEO_PLAY_TIME, valueOf);
        hashMap.put("videoid", lVar.f81166a);
        hashMap.put("feedid", lVar.f81166a);
        hashMap.put("author_uin", lVar.f81181p);
        hashMap.put("network", String.valueOf(NetworkState.g().getNetworkType() != 1 ? 2 : 1));
        hashMap.put("video_type", String.valueOf(lVar.f81177l));
        return hashMap;
    }

    public static void b(String str, String str2, String str3) {
        f81525a = new WSReportDC898Base(c.a(str));
        c(str2, str3);
    }

    public static void c(String str, String str2) {
        WSReportDC898Base wSReportDC898Base = f81525a;
        if (wSReportDC898Base != null) {
            wSReportDC898Base.o(str2);
            f81525a.p(str);
        }
    }

    public static void d() {
        WSReportDC898Base wSReportDC898Base = f81525a;
        if (wSReportDC898Base == null) {
            return;
        }
        wSReportDC898Base.e();
    }

    public static void e(String str) {
        WSReportDC898Base wSReportDC898Base = f81525a;
        if (wSReportDC898Base == null) {
            return;
        }
        wSReportDC898Base.f(str);
    }

    public static void f(String str, int i3, int i16) {
        WSReportDC898Base wSReportDC898Base = f81525a;
        if (wSReportDC898Base == null) {
            return;
        }
        wSReportDC898Base.g(str, i3, i16);
    }

    public static void g() {
        WSReportDC898Base wSReportDC898Base = f81525a;
        if (wSReportDC898Base == null) {
            return;
        }
        wSReportDC898Base.h();
    }

    public static void h() {
        WSReportDC898Base wSReportDC898Base = f81525a;
        if (wSReportDC898Base == null) {
            return;
        }
        wSReportDC898Base.i();
    }

    public static void i() {
        WSReportDC898Base wSReportDC898Base = f81525a;
        if (wSReportDC898Base == null) {
            return;
        }
        wSReportDC898Base.j();
    }

    public static void j(String str, int i3, int i16) {
        WSReportDC898Base wSReportDC898Base = f81525a;
        if (wSReportDC898Base == null) {
            return;
        }
        wSReportDC898Base.k(str, i3, i16);
    }

    public static void k() {
        WSReportDC898Base wSReportDC898Base = f81525a;
        if (wSReportDC898Base == null) {
            return;
        }
        wSReportDC898Base.l();
    }

    public static void l() {
        WSReportDC898Base wSReportDC898Base = f81525a;
        if (wSReportDC898Base == null) {
            return;
        }
        wSReportDC898Base.m();
    }

    public static void m(com.tencent.biz.pubaccount.weishi.player.e eVar, boolean z16) {
        if (f81525a == null || eVar == null || eVar.f81127c == null) {
            return;
        }
        f81525a.n(a(eVar, z16));
    }
}
