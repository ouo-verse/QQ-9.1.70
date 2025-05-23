package com.tencent.qqnt.pluspanel.utils;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.util.WnsNetworkConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/pluspanel/utils/a;", "", "a", "plus_panel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a {
    static IPatchRedirector $redirector_;
    private static final int A;
    private static final int A0;
    private static final int B;
    private static final int B0;
    private static final int C;
    private static final int C0;
    private static final int D;
    private static final int D0;
    private static final int E;
    private static final int E0;
    private static final int F;
    private static final int F0;
    private static final int G;
    private static final int G0;
    private static final int H;
    private static final int H0;
    private static final int I;
    private static final int I0;
    private static final int J;
    private static final int J0;
    private static final int K;
    private static final int K0;
    private static final int L;
    private static final int L0;
    private static final int M;
    private static final int M0;
    private static final int N;
    private static final int N0;
    private static final int O;
    private static final int O0;
    private static final int P;
    private static final int P0;
    private static final int Q;
    private static final int Q0;
    private static final int R;
    private static final int R0;
    private static final int S;
    private static final int S0;
    private static final int T;
    private static final int T0;
    private static final int U;
    private static final int U0;
    private static final int V;
    private static final int V0;
    private static final int W;
    private static final int W0;
    private static final int X;
    private static final int X0;
    private static final int Y;
    private static final int Y0;
    private static final int Z;
    private static final int Z0;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a0, reason: collision with root package name */
    private static final int f360614a0;

    /* renamed from: a1, reason: collision with root package name */
    private static final int f360615a1;

    /* renamed from: b, reason: collision with root package name */
    private static final int f360616b;

    /* renamed from: b0, reason: collision with root package name */
    private static final int f360617b0;

    /* renamed from: b1, reason: collision with root package name */
    private static final int f360618b1;

    /* renamed from: c, reason: collision with root package name */
    private static final int f360619c;

    /* renamed from: c0, reason: collision with root package name */
    private static final int f360620c0;

    /* renamed from: c1, reason: collision with root package name */
    private static final int f360621c1;

    /* renamed from: d, reason: collision with root package name */
    private static final int f360622d;

    /* renamed from: d0, reason: collision with root package name */
    private static final int f360623d0;

    /* renamed from: d1, reason: collision with root package name */
    private static final int f360624d1;

    /* renamed from: e, reason: collision with root package name */
    private static final int f360625e;

    /* renamed from: e0, reason: collision with root package name */
    private static final int f360626e0;

    /* renamed from: e1, reason: collision with root package name */
    private static final int f360627e1;

    /* renamed from: f, reason: collision with root package name */
    private static final int f360628f;

    /* renamed from: f0, reason: collision with root package name */
    private static final int f360629f0;

    /* renamed from: f1, reason: collision with root package name */
    private static final int f360630f1;

    /* renamed from: g, reason: collision with root package name */
    private static final int f360631g;

    /* renamed from: g0, reason: collision with root package name */
    private static final int f360632g0;

    /* renamed from: g1, reason: collision with root package name */
    private static final int f360633g1;

    /* renamed from: h, reason: collision with root package name */
    private static final int f360634h;

    /* renamed from: h0, reason: collision with root package name */
    private static final int f360635h0;

    /* renamed from: h1, reason: collision with root package name */
    private static final int f360636h1;

    /* renamed from: i, reason: collision with root package name */
    private static final int f360637i;

    /* renamed from: i0, reason: collision with root package name */
    private static final int f360638i0;

    /* renamed from: i1, reason: collision with root package name */
    private static final int f360639i1;

    /* renamed from: j, reason: collision with root package name */
    private static final int f360640j;

    /* renamed from: j0, reason: collision with root package name */
    private static final int f360641j0;

    /* renamed from: k, reason: collision with root package name */
    private static final int f360642k;

    /* renamed from: k0, reason: collision with root package name */
    private static final int f360643k0;

    /* renamed from: l, reason: collision with root package name */
    private static final int f360644l;

    /* renamed from: l0, reason: collision with root package name */
    private static final int f360645l0;

    /* renamed from: m, reason: collision with root package name */
    private static final int f360646m;

    /* renamed from: m0, reason: collision with root package name */
    private static final int f360647m0;

    /* renamed from: n, reason: collision with root package name */
    private static final int f360648n;

    /* renamed from: n0, reason: collision with root package name */
    private static final int f360649n0;

    /* renamed from: o, reason: collision with root package name */
    private static final int f360650o;

    /* renamed from: o0, reason: collision with root package name */
    private static final int f360651o0;

    /* renamed from: p, reason: collision with root package name */
    private static final int f360652p;

    /* renamed from: p0, reason: collision with root package name */
    private static final int f360653p0;

    /* renamed from: q, reason: collision with root package name */
    private static final int f360654q;

    /* renamed from: q0, reason: collision with root package name */
    private static final int f360655q0;

    /* renamed from: r, reason: collision with root package name */
    private static final int f360656r;

    /* renamed from: r0, reason: collision with root package name */
    private static final int f360657r0;

    /* renamed from: s, reason: collision with root package name */
    private static final int f360658s;

    /* renamed from: s0, reason: collision with root package name */
    private static final int f360659s0;

    /* renamed from: t, reason: collision with root package name */
    private static final int f360660t;

    /* renamed from: t0, reason: collision with root package name */
    private static final int f360661t0;

    /* renamed from: u, reason: collision with root package name */
    private static final int f360662u;

    /* renamed from: u0, reason: collision with root package name */
    private static final int f360663u0;

    /* renamed from: v, reason: collision with root package name */
    private static final int f360664v;

    /* renamed from: v0, reason: collision with root package name */
    private static final int f360665v0;

    /* renamed from: w, reason: collision with root package name */
    private static final int f360666w;

    /* renamed from: w0, reason: collision with root package name */
    private static final int f360667w0;

    /* renamed from: x, reason: collision with root package name */
    private static final int f360668x;

    /* renamed from: x0, reason: collision with root package name */
    private static final int f360669x0;

    /* renamed from: y, reason: collision with root package name */
    private static final int f360670y;

    /* renamed from: y0, reason: collision with root package name */
    private static final int f360671y0;

    /* renamed from: z, reason: collision with root package name */
    private static final int f360672z;

    /* renamed from: z0, reason: collision with root package name */
    private static final int f360673z0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0003\b\u00a4\u0001\b\u0086\u0003\u0018\u00002\u00020\u0001B\u000b\b\u0002\u00a2\u0006\u0006\b\u00a4\u0001\u0010\u00a5\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001a\u0010\u0019\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001a\u0010\u001b\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001a\u0010\u001d\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001a\u0010\u001f\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006R\u001a\u0010!\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006R\u001a\u0010#\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006R\u001a\u0010%\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006R\u001a\u0010'\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006R\u001a\u0010)\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006R\u001a\u0010+\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006R\u001a\u0010-\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006R\u001a\u0010/\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b/\u0010\u0004\u001a\u0004\b0\u0010\u0006R\u001a\u00101\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b1\u0010\u0004\u001a\u0004\b2\u0010\u0006R\u001a\u00103\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b3\u0010\u0004\u001a\u0004\b4\u0010\u0006R\u001a\u00105\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b5\u0010\u0004\u001a\u0004\b6\u0010\u0006R\u001a\u00107\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b7\u0010\u0004\u001a\u0004\b8\u0010\u0006R\u001a\u00109\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b9\u0010\u0004\u001a\u0004\b:\u0010\u0006R\u001a\u0010;\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b;\u0010\u0004\u001a\u0004\b<\u0010\u0006R\u001a\u0010=\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b=\u0010\u0004\u001a\u0004\b>\u0010\u0006R\u001a\u0010?\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b?\u0010\u0004\u001a\u0004\b@\u0010\u0006R\u001a\u0010A\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\bA\u0010\u0004\u001a\u0004\bB\u0010\u0006R\u001a\u0010C\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\bC\u0010\u0004\u001a\u0004\bD\u0010\u0006R\u001a\u0010E\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\bE\u0010\u0004\u001a\u0004\bF\u0010\u0006R\u001a\u0010G\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\bG\u0010\u0004\u001a\u0004\bH\u0010\u0006R\u001a\u0010I\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\bI\u0010\u0004\u001a\u0004\bJ\u0010\u0006R\u001a\u0010K\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\bK\u0010\u0004\u001a\u0004\bL\u0010\u0006R\u001a\u0010M\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\bM\u0010\u0004\u001a\u0004\bN\u0010\u0006R\u001a\u0010O\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\bO\u0010\u0004\u001a\u0004\bP\u0010\u0006R\u001a\u0010Q\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\bQ\u0010\u0004\u001a\u0004\bR\u0010\u0006R\u001a\u0010S\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\bS\u0010\u0004\u001a\u0004\bT\u0010\u0006R\u001a\u0010U\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\bU\u0010\u0004\u001a\u0004\bV\u0010\u0006R\u001a\u0010W\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\bW\u0010\u0004\u001a\u0004\bX\u0010\u0006R\u001a\u0010Y\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\bY\u0010\u0004\u001a\u0004\bZ\u0010\u0006R\u001a\u0010[\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b[\u0010\u0004\u001a\u0004\b\\\u0010\u0006R\u001a\u0010]\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b]\u0010\u0004\u001a\u0004\b^\u0010\u0006R\u001a\u0010_\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b_\u0010\u0004\u001a\u0004\b`\u0010\u0006R\u001a\u0010a\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\ba\u0010\u0004\u001a\u0004\bb\u0010\u0006R\u001a\u0010c\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\bc\u0010\u0004\u001a\u0004\bd\u0010\u0006R\u001a\u0010e\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\be\u0010\u0004\u001a\u0004\bf\u0010\u0006R\u001a\u0010g\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\bg\u0010\u0004\u001a\u0004\bh\u0010\u0006R\u001a\u0010i\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\bi\u0010\u0004\u001a\u0004\bj\u0010\u0006R\u001a\u0010k\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\bk\u0010\u0004\u001a\u0004\bl\u0010\u0006R\u001a\u0010m\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\bm\u0010\u0004\u001a\u0004\bn\u0010\u0006R\u001a\u0010o\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\bo\u0010\u0004\u001a\u0004\bp\u0010\u0006R\u001a\u0010q\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\bq\u0010\u0004\u001a\u0004\br\u0010\u0006R\u001a\u0010s\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\bs\u0010\u0004\u001a\u0004\bt\u0010\u0006R\u001a\u0010u\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\bu\u0010\u0004\u001a\u0004\bv\u0010\u0006R\u001a\u0010w\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\bw\u0010\u0004\u001a\u0004\bx\u0010\u0006R\u001a\u0010y\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\by\u0010\u0004\u001a\u0004\bz\u0010\u0006R\u001a\u0010{\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b{\u0010\u0004\u001a\u0004\b|\u0010\u0006R\u001a\u0010}\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b}\u0010\u0004\u001a\u0004\b~\u0010\u0006R\u001a\u0010\u007f\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u007f\u0010\u0004\u001a\u0004\b\u0004\u0010\u0006R\u001d\u0010\u0080\u0001\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\u000e\n\u0005\b\u0080\u0001\u0010\u0004\u001a\u0005\b\u0081\u0001\u0010\u0006R\u001d\u0010\u0082\u0001\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\u000e\n\u0005\b\u0082\u0001\u0010\u0004\u001a\u0005\b\u0083\u0001\u0010\u0006R\u001d\u0010\u0084\u0001\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\u000e\n\u0005\b\u0084\u0001\u0010\u0004\u001a\u0005\b\u0085\u0001\u0010\u0006R\u001d\u0010\u0086\u0001\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\u000e\n\u0005\b\u0086\u0001\u0010\u0004\u001a\u0005\b\u0087\u0001\u0010\u0006R\u001d\u0010\u0088\u0001\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\u000e\n\u0005\b\u0088\u0001\u0010\u0004\u001a\u0005\b\u0089\u0001\u0010\u0006R\u001d\u0010\u008a\u0001\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\u000e\n\u0005\b\u008a\u0001\u0010\u0004\u001a\u0005\b\u008b\u0001\u0010\u0006R\u001d\u0010\u008c\u0001\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\u000e\n\u0005\b\u008c\u0001\u0010\u0004\u001a\u0005\b\u008d\u0001\u0010\u0006R\u001d\u0010\u008e\u0001\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\u000e\n\u0005\b\u008e\u0001\u0010\u0004\u001a\u0005\b\u008f\u0001\u0010\u0006R\u001d\u0010\u0090\u0001\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\u000e\n\u0005\b\u0090\u0001\u0010\u0004\u001a\u0005\b\u0091\u0001\u0010\u0006R\u001d\u0010\u0092\u0001\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\u000e\n\u0005\b\u0092\u0001\u0010\u0004\u001a\u0005\b\u0093\u0001\u0010\u0006R\u001d\u0010\u0094\u0001\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\u000e\n\u0005\b\u0094\u0001\u0010\u0004\u001a\u0005\b\u0095\u0001\u0010\u0006R\u001d\u0010\u0096\u0001\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\u000e\n\u0005\b\u0096\u0001\u0010\u0004\u001a\u0005\b\u0097\u0001\u0010\u0006R\u001d\u0010\u0098\u0001\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\u000e\n\u0005\b\u0098\u0001\u0010\u0004\u001a\u0005\b\u0099\u0001\u0010\u0006R\u001d\u0010\u009a\u0001\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\u000e\n\u0005\b\u009a\u0001\u0010\u0004\u001a\u0005\b\u009b\u0001\u0010\u0006R\u0016\u0010\u009c\u0001\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0007\n\u0005\b\u009c\u0001\u0010\u0004R\u0016\u0010\u009d\u0001\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0007\n\u0005\b\u009d\u0001\u0010\u0004R\u0016\u0010\u009e\u0001\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0007\n\u0005\b\u009e\u0001\u0010\u0004R\u0016\u0010\u009f\u0001\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0007\n\u0005\b\u009f\u0001\u0010\u0004R\u0016\u0010\u00a0\u0001\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0007\n\u0005\b\u00a0\u0001\u0010\u0004R\u0016\u0010\u00a1\u0001\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0007\n\u0005\b\u00a1\u0001\u0010\u0004R\u0016\u0010\u00a2\u0001\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0007\n\u0005\b\u00a2\u0001\u0010\u0004R\u0016\u0010\u00a3\u0001\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0007\n\u0005\b\u00a3\u0001\u0010\u0004\u00a8\u0006\u00a6\u0001"}, d2 = {"Lcom/tencent/qqnt/pluspanel/utils/a$a;", "", "", "APPID_MORE_APP", "I", "Z", "()I", "APPID_PHOTO", "f0", "APPID_SHORT_VIDEO", "k0", "APPID_PHONE_AUDIO", "c0", "APPID_PHONE_VIDEO", "e0", "APPID_PHONE_SHARE", "d0", "APPID_VIDEO", "u0", "APPID_VIDEO_OPEN_CLASS", "v0", "APPID_HONGBAO", "V", "APPID_ANONYMITY", "c", "APPID_FILE", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "APPID_LOCATION", "Y", "APPID_MUSIC", "a0", "APPID_LISTENTOGETHER", "X", "APPID_WATCHTOGETHER", "w0", "APPID_SINGTOGETHER", "l0", "APPID_PLAY_TOGETHER", "g0", "APPID_NAMECARD", "b0", "APPID_COLLECTION", "M", "APPID_FLOWER", BdhLogUtil.LogTag.Tag_Req, "APPID_TROOP_APP_ACTIVITY", "o0", "APPID_TOUPIAO", "n0", "APPID_SCRIBBLE", "i0", "APPID_AV_GAME", h.F, "APPID_ASKANONYMOUSLY", "g", "APPID_TROOP_RECEIPT_MESSAGE", "s0", "APPID_TROOP_EFFECT_PIC", "p0", "APPID_BULK_SEND_MESSAGE", "i", "APPID_TROOP_GIF", "q0", "APPID_TROOP_TEAMWORK", "t0", "APPID_FORM", ExifInterface.LATITUDE_SOUTH, "APPID_DINGYUE", "O", "APPID_TENCENT_DOCS", "m0", "APPID_SHOOT", "j0", "APPID_EXIT_ANONYMITY", "P", "APPID_ANONYMITY_SET", "e", "APPID_ANONYMITY_FLOWER", "d", "APPID_CM_SHOW", "L", "APPID_ARK_APP_MANAGER", "f", "APPID_AA_SHOUKUAN", "a", "APPID_PUBLIC_ACCOUNT_VOICE", "h0", "APPID_TROOP_GUILD_DA_KA", "r0", "APPID_CLOCK_IN", "K", "APPID_COLLECT_MONEY", "N", "APPID_HOME_WORK", "U", "APPID_AI_VOICE", "b", "APPID_GROUP_INVITE_TEAM", "T", "APPID_KING_RED_PACK", "W", "APPID_C2C_PHONE_AUDIO", HippyTKDListViewAdapter.X, "APPID_C2C_PHONE_VIDEO", "y", "APPID_C2C_POKE", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "APPID_C2C_HOT_PIC", ReportConstant.COSTREPORT_PREFIX, "APPID_C2C_LOCATION", "u", "APPID_C2C_FILE", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "APPID_C2C_LISTEN_TOGETHER", "t", "APPID_C2C_FAVORITE", "p", "APPID_C2C_MINI_APP", "v", "APPID_C2C_DOODLE", "o", "APPID_C2C_TRANSFER", "J", "APPID_C2C_BUSINESS_CARD", "l", "APPID_C2C_GIFT", "r", "APPID_C2C_TENCENT_DOCS", "APPID_C2C_CM_SHOW", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "APPID_C2C_RECEIPT_MSG", "D", "APPID_C2C_PIC", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "APPID_C2C_SHOOT", "G", "APPID_C2C_RED_PACKET", "E", "APPID_C2C_SING_TOGETHER", "H", "APPID_C2C_SHARE_SCREEN", UserInfo.SEX_FEMALE, "APPID_C2C_AV_GAME", "k", "APPID_C2C_QAV_WATCH_TOGETHER", "B", "APPID_C2C_QCIRCLE", BdhLogUtil.LogTag.Tag_Conn, "APPID_C2C_ARK_APP_MANAGER", "j", "APPID_C2C_DINGYUE", DomainData.DOMAIN_NAME, "APPID_C2C_MUSIC", "w", "MANAGE_ID_C2C_QCIRCLE", "x0", "APPID_HOMEWORK", "APPID_MORE", "APPID_ROBOT_CAMERA", "APPID_ROBOT_COMMUNICATION_SHARE", "APPID_ROBOT_PIC", "APPID_ROBOT_PTT", "APPID_ROBOT_STORY", "APPID_TROOP_ROBOT", "<init>", "()V", "plus_panel_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.pluspanel.utils.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 114)) {
                return;
            }
            iPatchRedirector.redirect((short) 114, (Object) this, (Object) defaultConstructorMarker);
        }

        public final int A() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 59)) {
                return a.f360632g0;
            }
            return ((Integer) iPatchRedirector.redirect((short) 59, (Object) this)).intValue();
        }

        public final int B() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 79)) {
                return a.A0;
            }
            return ((Integer) iPatchRedirector.redirect((short) 79, (Object) this)).intValue();
        }

        public final int C() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 80)) {
                return a.B0;
            }
            return ((Integer) iPatchRedirector.redirect((short) 80, (Object) this)).intValue();
        }

        public final int D() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 72)) {
                return a.f360661t0;
            }
            return ((Integer) iPatchRedirector.redirect((short) 72, (Object) this)).intValue();
        }

        public final int E() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 75)) {
                return a.f360667w0;
            }
            return ((Integer) iPatchRedirector.redirect((short) 75, (Object) this)).intValue();
        }

        public final int F() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 77)) {
                return a.f360671y0;
            }
            return ((Integer) iPatchRedirector.redirect((short) 77, (Object) this)).intValue();
        }

        public final int G() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 74)) {
                return a.f360665v0;
            }
            return ((Integer) iPatchRedirector.redirect((short) 74, (Object) this)).intValue();
        }

        public final int H() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 76)) {
                return a.f360669x0;
            }
            return ((Integer) iPatchRedirector.redirect((short) 76, (Object) this)).intValue();
        }

        public final int I() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 70)) {
                return a.f360657r0;
            }
            return ((Integer) iPatchRedirector.redirect((short) 70, (Object) this)).intValue();
        }

        public final int J() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 67)) {
                return a.f360651o0;
            }
            return ((Integer) iPatchRedirector.redirect((short) 67, (Object) this)).intValue();
        }

        public final int K() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 50)) {
                return a.X;
            }
            return ((Integer) iPatchRedirector.redirect((short) 50, (Object) this)).intValue();
        }

        public final int L() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 45)) {
                return a.S;
            }
            return ((Integer) iPatchRedirector.redirect((short) 45, (Object) this)).intValue();
        }

        public final int M() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
                return a.f360660t;
            }
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }

        public final int N() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 52)) {
                return a.Z;
            }
            return ((Integer) iPatchRedirector.redirect((short) 52, (Object) this)).intValue();
        }

        public final int O() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 38)) {
                return a.L;
            }
            return ((Integer) iPatchRedirector.redirect((short) 38, (Object) this)).intValue();
        }

        public final int P() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 41)) {
                return a.O;
            }
            return ((Integer) iPatchRedirector.redirect((short) 41, (Object) this)).intValue();
        }

        public final int Q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
                return a.f360644l;
            }
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }

        public final int R() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) {
                return a.f360662u;
            }
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }

        public final int S() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 35)) {
                return a.I;
            }
            return ((Integer) iPatchRedirector.redirect((short) 35, (Object) this)).intValue();
        }

        public final int T() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 55)) {
                return a.f360620c0;
            }
            return ((Integer) iPatchRedirector.redirect((short) 55, (Object) this)).intValue();
        }

        public final int U() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 53)) {
                return a.f360614a0;
            }
            return ((Integer) iPatchRedirector.redirect((short) 53, (Object) this)).intValue();
        }

        public final int V() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
                return a.f360640j;
            }
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }

        public final int W() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 56)) {
                return a.f360623d0;
            }
            return ((Integer) iPatchRedirector.redirect((short) 56, (Object) this)).intValue();
        }

        public final int X() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
                return a.f360650o;
            }
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }

        public final int Y() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
                return a.f360646m;
            }
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }

        public final int Z() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return a.f360616b;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 47)) {
                return a.U;
            }
            return ((Integer) iPatchRedirector.redirect((short) 47, (Object) this)).intValue();
        }

        public final int a0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
                return a.f360648n;
            }
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 54)) {
                return a.f360617b0;
            }
            return ((Integer) iPatchRedirector.redirect((short) 54, (Object) this)).intValue();
        }

        public final int b0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
                return a.f360658s;
            }
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
                return a.f360642k;
            }
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }

        public final int c0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return a.f360625e;
            }
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }

        public final int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 43)) {
                return a.Q;
            }
            return ((Integer) iPatchRedirector.redirect((short) 43, (Object) this)).intValue();
        }

        public final int d0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return a.f360631g;
            }
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }

        public final int e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 42)) {
                return a.P;
            }
            return ((Integer) iPatchRedirector.redirect((short) 42, (Object) this)).intValue();
        }

        public final int e0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return a.f360628f;
            }
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }

        public final int f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 46)) {
                return a.T;
            }
            return ((Integer) iPatchRedirector.redirect((short) 46, (Object) this)).intValue();
        }

        public final int f0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return a.f360619c;
            }
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }

        public final int g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 26)) {
                return a.f360672z;
            }
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }

        public final int g0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
                return a.f360656r;
            }
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }

        public final int h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 25)) {
                return a.f360670y;
            }
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }

        public final int h0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 48)) {
                return a.V;
            }
            return ((Integer) iPatchRedirector.redirect((short) 48, (Object) this)).intValue();
        }

        public final int i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 30)) {
                return a.D;
            }
            return ((Integer) iPatchRedirector.redirect((short) 30, (Object) this)).intValue();
        }

        public final int i0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 24)) {
                return a.f360668x;
            }
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }

        public final int j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 82)) {
                return a.D0;
            }
            return ((Integer) iPatchRedirector.redirect((short) 82, (Object) this)).intValue();
        }

        public final int j0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 40)) {
                return a.N;
            }
            return ((Integer) iPatchRedirector.redirect((short) 40, (Object) this)).intValue();
        }

        public final int k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 78)) {
                return a.f360673z0;
            }
            return ((Integer) iPatchRedirector.redirect((short) 78, (Object) this)).intValue();
        }

        public final int k0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return a.f360622d;
            }
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }

        public final int l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 68)) {
                return a.f360653p0;
            }
            return ((Integer) iPatchRedirector.redirect((short) 68, (Object) this)).intValue();
        }

        public final int l0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
                return a.f360654q;
            }
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }

        public final int m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 71)) {
                return a.f360659s0;
            }
            return ((Integer) iPatchRedirector.redirect((short) 71, (Object) this)).intValue();
        }

        public final int m0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 39)) {
                return a.M;
            }
            return ((Integer) iPatchRedirector.redirect((short) 39, (Object) this)).intValue();
        }

        public final int n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 83)) {
                return a.E0;
            }
            return ((Integer) iPatchRedirector.redirect((short) 83, (Object) this)).intValue();
        }

        public final int n0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) {
                return a.f360666w;
            }
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }

        public final int o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 66)) {
                return a.f360649n0;
            }
            return ((Integer) iPatchRedirector.redirect((short) 66, (Object) this)).intValue();
        }

        public final int o0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
                return a.f360664v;
            }
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }

        public final int p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 64)) {
                return a.f360645l0;
            }
            return ((Integer) iPatchRedirector.redirect((short) 64, (Object) this)).intValue();
        }

        public final int p0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 28)) {
                return a.B;
            }
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this)).intValue();
        }

        public final int q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 62)) {
                return a.f360641j0;
            }
            return ((Integer) iPatchRedirector.redirect((short) 62, (Object) this)).intValue();
        }

        public final int q0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 33)) {
                return a.G;
            }
            return ((Integer) iPatchRedirector.redirect((short) 33, (Object) this)).intValue();
        }

        public final int r() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 69)) {
                return a.f360655q0;
            }
            return ((Integer) iPatchRedirector.redirect((short) 69, (Object) this)).intValue();
        }

        public final int r0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 49)) {
                return a.W;
            }
            return ((Integer) iPatchRedirector.redirect((short) 49, (Object) this)).intValue();
        }

        public final int s() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 60)) {
                return a.f360635h0;
            }
            return ((Integer) iPatchRedirector.redirect((short) 60, (Object) this)).intValue();
        }

        public final int s0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 27)) {
                return a.A;
            }
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this)).intValue();
        }

        public final int t() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 63)) {
                return a.f360643k0;
            }
            return ((Integer) iPatchRedirector.redirect((short) 63, (Object) this)).intValue();
        }

        public final int t0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 34)) {
                return a.H;
            }
            return ((Integer) iPatchRedirector.redirect((short) 34, (Object) this)).intValue();
        }

        public final int u() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 61)) {
                return a.f360638i0;
            }
            return ((Integer) iPatchRedirector.redirect((short) 61, (Object) this)).intValue();
        }

        public final int u0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return a.f360634h;
            }
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }

        public final int v() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 65)) {
                return a.f360647m0;
            }
            return ((Integer) iPatchRedirector.redirect((short) 65, (Object) this)).intValue();
        }

        public final int v0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
                return a.f360637i;
            }
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }

        public final int w() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 86)) {
                return a.H0;
            }
            return ((Integer) iPatchRedirector.redirect((short) 86, (Object) this)).intValue();
        }

        public final int w0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
                return a.f360652p;
            }
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }

        public final int x() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 57)) {
                return a.f360626e0;
            }
            return ((Integer) iPatchRedirector.redirect((short) 57, (Object) this)).intValue();
        }

        public final int x0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 110)) {
                return a.f360630f1;
            }
            return ((Integer) iPatchRedirector.redirect((short) 110, (Object) this)).intValue();
        }

        public final int y() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 58)) {
                return a.f360629f0;
            }
            return ((Integer) iPatchRedirector.redirect((short) 58, (Object) this)).intValue();
        }

        public final int z() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 73)) {
                return a.f360663u0;
            }
            return ((Integer) iPatchRedirector.redirect((short) 73, (Object) this)).intValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38122);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        INSTANCE = new Companion(null);
        f360616b = 1104864064;
        f360619c = 217;
        f360622d = 1104788673;
        f360625e = 1104651886;
        f360628f = 1106658188;
        f360631g = 101850591;
        f360634h = 100719166;
        f360637i = 101847385;
        f360640j = 1104864062;
        f360642k = 1101487426;
        f360644l = 1104864066;
        f360646m = 1104864068;
        f360648n = 1104864070;
        f360650o = IChatSettingForTroopApi.APPID_TOGETHERLISTEN;
        f360652p = 101793773;
        f360654q = IChatSettingForTroopApi.APPID_TOGETHERSING;
        f360656r = 1108481457;
        f360658s = 1104788679;
        f360660t = 1104639410;
        f360662u = 1104874204;
        f360664v = 1101678813;
        f360666w = 1104536706;
        f360668x = 1106114157;
        f360670y = IChatSettingForTroopApi.APPID_TOGETHEHIGH;
        f360672z = 101912132;
        A = 1106189400;
        B = 1106194086;
        C = 1105981808;
        D = 1106729451;
        E = 1106865772;
        F = 1106717414;
        G = 1107930043;
        H = 101458937;
        I = 1108961705;
        J = 101849720;
        K = 1200000000;
        L = 1200000001;
        M = 1200000002;
        N = 218;
        O = 1200000004;
        P = 1200000005;
        Q = 1200000006;
        R = 1200000007;
        S = 1200000008;
        T = 1200000009;
        U = 1200000010;
        V = 1200000011;
        W = 1200000012;
        X = 100729587;
        Y = 1108164955;
        Z = 1106551782;
        f360614a0 = 101846357;
        f360617b0 = 102438828;
        f360620c0 = 102245003;
        f360623d0 = 102007304;
        f360626e0 = 1104651886;
        f360629f0 = 1106658188;
        f360632g0 = 203;
        f360635h0 = 1107930043;
        f360638i0 = 1104864068;
        f360641j0 = 1104864066;
        f360643k0 = IChatSettingForTroopApi.APPID_TOGETHERLISTEN;
        f360645l0 = 1104639410;
        f360647m0 = 209;
        f360649n0 = 210;
        f360651o0 = 211;
        f360653p0 = 1104788679;
        f360655q0 = 1104874204;
        f360657r0 = 101458937;
        f360659s0 = 215;
        f360661t0 = 216;
        f360663u0 = 217;
        f360665v0 = 218;
        f360667w0 = 1104864062;
        f360669x0 = 220;
        f360671y0 = 101850591;
        f360673z0 = 222;
        A0 = 223;
        B0 = 102115711;
        C0 = 1000000000;
        D0 = 1000000001;
        E0 = 1000000003;
        F0 = 1000000004;
        G0 = 1000000005;
        H0 = 1000000006;
        I0 = 502;
        J0 = 503;
        K0 = 515;
        L0 = 641;
        M0 = WnsNetworkConst.NETWORK_DISABLE;
        N0 = 514;
        O0 = 516;
        P0 = 509;
        Q0 = 507;
        R0 = WnsNetworkConst.WRITE_FAIL;
        S0 = 505;
        T0 = 508;
        U0 = 506;
        V0 = TVKQQLiveAssetPlayerMsg.PLAYER_INFO_CGI_REQUEST;
        W0 = 511;
        X0 = 504;
        Y0 = 512;
        Z0 = 510;
        f360615a1 = 600;
        f360618b1 = 513;
        f360621c1 = PlayerResources.ViewId.GET_MORE_TOGGLE_AREA;
        f360624d1 = 517;
        f360627e1 = LpReportInfoConfig.ACTION_TYPE_LOCAL_PICTUREVIEWER_PAGE;
        f360630f1 = FriendListHandler.OIDB_0X5D1_CONST_SHIELD;
        f360633g1 = 2000000001;
        f360636h1 = 2000000002;
        f360639i1 = 2000000003;
    }
}
