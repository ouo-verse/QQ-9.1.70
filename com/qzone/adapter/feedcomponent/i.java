package com.qzone.adapter.feedcomponent;

import ADV_REPORT.s_anti_cheat;
import NS_MOBILE_FEEDS.s_join_list;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.MotionEvent;
import com.qq.taf.jce.JceStruct;
import com.qzone.common.event.IObserver;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.PicText;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.DittoUIEngine;
import cooperation.vip.vipcomponent.QQUnionIconInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f41887a = false;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f41888b = false;

    /* renamed from: c, reason: collision with root package name */
    static i f41889c = null;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f41890d = false;

    /* renamed from: e, reason: collision with root package name */
    public static int f41891e = 255;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f41892f;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f41893g;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f41894h;

    /* renamed from: i, reason: collision with root package name */
    private static String f41895i;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f41896j;

    /* renamed from: k, reason: collision with root package name */
    private static boolean f41897k;

    public static void A2(boolean z16) {
        f41892f = z16;
    }

    public static void B2(boolean z16) {
        f41893g = z16;
    }

    public static void C2(boolean z16) {
        f41897k = z16;
    }

    public static i H() {
        if (f41889c == null) {
            f41889c = com.qzone.util.i.c();
            try {
                DittoUIEngine.setOuterGlobalData(new g());
            } catch (Throwable unused) {
            }
        }
        i iVar = f41889c;
        if (iVar != null) {
            return iVar;
        }
        throw new RuntimeException("FeedEnv does not init");
    }

    public static String J() {
        return f41895i;
    }

    public static boolean O0() {
        return f41896j;
    }

    public static void P0(i iVar) {
        f41889c = iVar;
    }

    public static boolean T0() {
        return f41894h;
    }

    public static boolean a1(int i3) {
        if (2 == i3) {
            return true;
        }
        return false;
    }

    public static boolean b1(int i3) {
        if (4 == i3) {
            return true;
        }
        return false;
    }

    public static boolean c1(int i3) {
        if (311 == i3) {
            return true;
        }
        return false;
    }

    public static boolean q1() {
        return f41897k;
    }

    public static void v2(int i3) {
        f41891e = i3;
    }

    public static void y2(boolean z16) {
        f41896j = z16;
    }

    public static void z2(Boolean bool) {
        f41894h = bool.booleanValue();
    }

    public abstract void A(int i3, int i16, int i17, long j3, BusinessFeedData businessFeedData, int i18, int i19, Map<Integer, String> map);

    public abstract Bitmap A0(Drawable drawable, int i3, int i16);

    public abstract IResult A1(int i3);

    public abstract void B(int i3, int i16, int i17, long j3, Map<Integer, String> map, BusinessFeedData businessFeedData, int i18, int i19);

    public abstract long B0();

    public abstract s B1(int i3);

    public abstract void C(int i3, int i16, int i17, long j3, Map<Integer, String> map, BusinessFeedData businessFeedData, int i18, int i19, Object obj, boolean z16);

    public abstract String C0(String str);

    public abstract void C1();

    public abstract void D(int i3, int i16, int i17, long j3, boolean z16);

    public abstract Drawable D0(User user, s8.j jVar);

    public abstract void D1();

    public abstract boolean D2(BusinessFeedData businessFeedData);

    public abstract String E(String str);

    public abstract int E0();

    public abstract void E1();

    public abstract void E2(Context context, Object obj);

    public abstract boolean F();

    public abstract String F0(Paint paint, String str, int i3, int i16);

    public abstract void F1(String str, String str2, boolean z16, String str3, IServiceCallback iServiceCallback);

    public abstract void F2();

    public abstract void G(BusinessFeedData businessFeedData, User user);

    public abstract List<String> G0(String str);

    public abstract void G1(String str);

    public abstract void G2();

    public abstract com.qzone.proxy.feedcomponent.model.s H0();

    public abstract void H1(String str, QZoneFakeFeedStatus qZoneFakeFeedStatus);

    public abstract void H2(String str, BusinessFeedData businessFeedData, Context context);

    public abstract Object I(CellPictureInfo cellPictureInfo, int i3);

    public abstract VideoInfo I0(String str);

    public abstract void I1(FeedElement feedElement, int i3, Object obj);

    public abstract void I2(String str);

    public abstract float J0();

    public abstract void J1(int i3);

    public abstract void J2(String str);

    public abstract Drawable K(String str, boolean z16);

    public abstract float K0(BusinessFeedData businessFeedData);

    public abstract void K1(Context context, BusinessFeedData businessFeedData, boolean z16);

    public abstract void K2(String str);

    public abstract AppRuntime L();

    public abstract float L0();

    public abstract void L1(Context context, BusinessFeedData businessFeedData, boolean z16);

    public abstract void L2(String str);

    public abstract String M(long j3, String str);

    public abstract Drawable M0(User user, s8.j jVar);

    public abstract void M1(BusinessFeedData businessFeedData);

    public abstract void M2(String str);

    public abstract String N();

    public abstract String N0(String str);

    public abstract void N1(Context context, BusinessFeedData businessFeedData, boolean z16);

    public abstract void N2(String str);

    public abstract String O(long j3, short s16, String str);

    public abstract void O1(String str, VideoInfo videoInfo);

    public abstract void O2(User user);

    public abstract String P(Long l3);

    public abstract void P1(String str);

    public abstract boolean P2();

    public abstract int Q();

    public abstract IObserver Q0(com.qzone.proxy.feedcomponent.manager.e eVar);

    public abstract void Q1(String str);

    public abstract void Q2(int i3, int i16, int i17, BusinessFeedData businessFeedData);

    public abstract float R(String str, String str2, float f16);

    public abstract void R0(Context context);

    public abstract boolean R1(BusinessFeedData businessFeedData, int i3);

    public abstract void R2(String str);

    public abstract int S(String str, String str2, int i3);

    public abstract boolean S0();

    public abstract void S1(BusinessFeedData businessFeedData, boolean z16);

    public abstract void S2(String str, String str2, byte[] bArr, DittoHost.SilentRequestCallback silentRequestCallback);

    public abstract String T(String str, String str2, String str3);

    public abstract void T1(int i3, BusinessFeedData businessFeedData);

    public abstract boolean U(String str, String str2, boolean z16);

    public abstract boolean U0(PicText picText);

    public abstract void U1(int i3, String str);

    public abstract boolean V();

    public abstract boolean V0();

    public abstract void V1(String str, int i3, int i16, boolean z16, boolean z17, boolean z18, int i17, Map<Integer, String> map, int i18);

    public abstract int W();

    public abstract boolean W0();

    public abstract void W1(String str, String str2, String str3);

    public abstract String X();

    public abstract boolean X0();

    public abstract void X1(String str, String str2, String str3, int i3, String str4);

    public abstract int Y();

    public abstract boolean Y0(String str);

    public abstract void Y1(String str, String str2, String str3, boolean z16);

    public abstract long Z();

    public abstract boolean Z0(long j3);

    public abstract void Z1(String str, String str2);

    public abstract void a(BusinessFeedData businessFeedData);

    public abstract Drawable a0();

    public abstract void a2(int i3);

    public abstract String b(String str);

    public abstract String b0();

    public abstract void b2(ArrayList<Map<String, String>> arrayList, Handler handler);

    public abstract void c(BusinessFeedData businessFeedData, int i3);

    public abstract boolean c0();

    public abstract void c2(long j3, String str);

    public abstract void d(Map<Integer, String> map, int i3, int i16, int i17, int i18, int i19, boolean z16, boolean z17, String str, String str2, long j3, boolean z18, boolean z19, String str3, boolean z26, BusinessFeedData businessFeedData);

    public abstract int d0();

    public abstract boolean d1();

    public abstract void d2(int i3);

    public abstract void e(Map<Integer, String> map, int i3, int i16, int i17, s_anti_cheat s_anti_cheatVar, int i18, int i19, boolean z16, boolean z17);

    public abstract Rect e0();

    public abstract boolean e1();

    public abstract void e2(String str, Properties properties, int i3);

    public abstract void f(int i3, int i16, int i17);

    public abstract int f0(int i3);

    public abstract boolean f1();

    public abstract void f2(int i3, int i16, int i17, String str);

    public abstract void g(int i3, int i16, int i17, String str, String str2, String str3);

    public abstract Object[] g0(s_join_list s_join_listVar);

    public abstract boolean g1();

    public abstract void g2(int i3, List<PicText> list, BusinessFeedData businessFeedData);

    public abstract void h(int i3, int i16, int i17, String str, String str2, String str3, long j3);

    public abstract int h0(int i3);

    public abstract boolean h1();

    public abstract void h2();

    public abstract Drawable i(Drawable drawable);

    public abstract com.qzone.proxy.feedcomponent.widget.c i0(String str, String str2, Context context);

    public abstract boolean i1();

    public abstract void i2(Context context, boolean z16, String str, int i3, int i16);

    public abstract String j(CellPictureInfo cellPictureInfo);

    public abstract long j0();

    public abstract boolean j1();

    public abstract void j2(int i3, int i16, int i17);

    public abstract boolean k();

    public abstract String k0();

    public abstract boolean k1();

    public abstract void k2(BusinessFeedData businessFeedData, int i3, int i16, int i17);

    public abstract boolean l();

    public abstract String l0(long j3);

    public abstract boolean l1();

    public abstract void l2(String str);

    public abstract boolean m();

    public abstract String m0(String str);

    public abstract boolean m1();

    public abstract void m2(int i3, int i16, boolean z16, boolean z17, boolean z18, int i17, Map<Integer, String> map, int i18, int i19);

    public abstract StringBuilder n(StringBuilder sb5);

    public abstract String n0(User user);

    public abstract boolean n1(AppRuntime appRuntime);

    public abstract void n2(int i3, boolean z16, boolean z17, boolean z18, int i16, Map<Integer, String> map, int i17, int i18);

    public abstract void o(Context context, BusinessFeedData businessFeedData);

    public abstract boolean o0();

    public abstract boolean o1();

    public abstract void o2(Context context, boolean z16, String str, String str2, int i3, int i16, int i17, int i18);

    public abstract void p(Context context);

    public abstract String p0();

    @Deprecated
    public abstract boolean p1();

    public abstract void p2(BusinessFeedData businessFeedData);

    public abstract void q(Context context, BusinessFeedData businessFeedData);

    public abstract HashSet<String> q0();

    public abstract void q2(int i3, int i16, int i17, String str);

    public abstract void r(IObserver iObserver);

    public abstract float r0();

    public abstract boolean r1();

    public abstract void r2(BusinessFeedData businessFeedData);

    public abstract void s(String str);

    public abstract float s0();

    public abstract boolean s1();

    public abstract void s2(String str);

    public abstract <T extends JceStruct> T t(T t16, byte[] bArr);

    public abstract long t0();

    public abstract boolean t1(Context context);

    public abstract void t2(MotionEvent motionEvent);

    public abstract <T extends JceStruct> T u(Class<T> cls, byte[] bArr);

    public abstract String u0();

    public abstract boolean u1(BusinessFeedData businessFeedData);

    public abstract void u2(Context context, boolean z16);

    public abstract void v(String str, long j3, HashMap<String, String> hashMap);

    public abstract List<String> v0();

    public abstract boolean v1();

    public abstract void w(String str, int i3, int i16, int i17, BusinessFeedData businessFeedData, int i18);

    public abstract QQUnionIconInfo w0(int i3, Map<String, QQUnionIconInfo> map);

    public abstract boolean w1();

    public abstract void w2(boolean z16);

    public abstract void x(String str, int i3, int i16, int i17, BusinessFeedData businessFeedData, int i18, long j3);

    public abstract int x0(int i3);

    public abstract void x1(String str, boolean z16, long j3);

    public abstract void x2(boolean z16);

    public abstract void y(int i3, int i16, int i17, long j3, Map<Integer, String> map, BusinessFeedData businessFeedData, int i18, int i19);

    public abstract int y0(int i3);

    public abstract m y1(Class cls, long j3, String str);

    public abstract void z(int i3, int i16, int i17, long j3, BusinessFeedData businessFeedData, int i18, int i19);

    public abstract void z0(String str, String str2, String str3, String str4, com.tencent.mobileqq.qzoneplayer.video.i iVar);

    public abstract n z1();
}
