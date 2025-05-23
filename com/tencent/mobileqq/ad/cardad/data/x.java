package com.tencent.mobileqq.ad.cardad.data;

import android.content.Context;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ad.cardad.views.CardAdPicLandscape;
import com.tencent.mobileqq.ad.cardad.views.CardAdPicPortrait;
import com.tencent.mobileqq.ad.cardad.views.CardAdVideoLandscape;
import com.tencent.mobileqq.ad.cardad.views.CardAdVideoPortrait;
import com.tencent.mobileqq.ad.cardad.views.CardAdView;
import com.tencent.mobileqq.ad.cardad.views.guild.CardAdPicForGuildSquareFeed;
import com.tencent.mobileqq.ad.cardad.views.guild.CardAdPicLandscapeForGuildDiscovery;
import com.tencent.mobileqq.ad.cardad.views.guild.CardAdVideoForGuildSquareFeed;
import com.tencent.mobileqq.ad.cardad.views.guild.CardAdVideoLandscapeForGuildDiscovery;
import com.tencent.mobileqq.ad.cardad.views.guild.CardAdVideoPortraitForGuildDiscovery;
import com.tencent.mobileqq.ad.cardad.views.qqshop.CardAdPicLandscapeForQQShop;
import com.tencent.mobileqq.ad.cardad.views.qqshop.CardAdPicPortraitForQQShop;
import com.tencent.mobileqq.ad.cardad.views.qqshop.CardAdVideoLandscapeForQQShop;
import com.tencent.mobileqq.ad.cardad.views.qqshop.CardAdVideoPortraitForQQShop;
import com.tencent.mobileqq.ad.cardad.views.qqshop.mediadown.CardAdPicLandscapeMediaDown;
import com.tencent.mobileqq.ad.cardad.views.qqshop.mediadown.CardAdPicLandscapeMediaDownWithMargin;
import com.tencent.mobileqq.ad.cardad.views.qqshop.mediadown.CardAdPicPortraitMediaDown;
import com.tencent.mobileqq.ad.cardad.views.qqshop.mediadown.CardAdVideoLandscapeMediaDown;
import com.tencent.mobileqq.ad.cardad.views.qqshop.mediadown.CardAdVideoLandscapeMediaDownWithMargin;
import com.tencent.mobileqq.ad.cardad.views.qqshop.mediadown.CardAdVideoPortraitMediaDown;
import com.tencent.mobileqq.ad.cardad.views.qqshop.mediaup.CardAdPicLandscapeMediaUp;
import com.tencent.mobileqq.ad.cardad.views.qqshop.mediaup.CardAdPicPortraitMediaUp;
import com.tencent.mobileqq.ad.cardad.views.qqshop.mediaup.CardAdVideoLandscapeMediaUp;
import com.tencent.mobileqq.ad.cardad.views.qqshop.mediaup.CardAdVideoPortraitMediaUp;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001%B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$R#\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R#\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R#\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R#\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R#\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007R#\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0007R#\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\u0007R#\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u0007R)\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u00028\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0005\u001a\u0004\b!\u0010\u0007\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/ad/cardad/data/x;", "", "", "", "b", "Ljava/util/Map;", "V", "()Ljava/util/Map;", "INNER_SHOW_TYPE_MAP", "c", "b0", "SHOP_AD_INNER_SHOW_TYPE_MAP", "d", "a0", "INNER_SHOW_TYPE_MAP_MEDIA_UP_MAP", "e", "Y", "INNER_SHOW_TYPE_MAP_MEDIA_DOWN_MAP", "f", "Z", "INNER_SHOW_TYPE_MAP_MEDIA_DOWN_WITH_MARGIN_MAP", "g", "X", "INNER_SHOW_TYPE_MAP_GUILD_SQUARE_FEED_MAP", tl.h.F, "W", "INNER_SHOW_TYPE_MAP_GUILD_DISCOVERY_MAP", "i", "c0", "VIEW_CLICK_POS_ID_MAP", "Lcom/tencent/mobileqq/ad/cardad/data/x$a;", "Lcom/tencent/mobileqq/ad/cardad/views/CardAdView;", "j", "U", "CARD_AD_TYPE_TO_VIEW_MAP", "<init>", "()V", "a", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class x {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final x f186705a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, Integer> INNER_SHOW_TYPE_MAP;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, Integer> SHOP_AD_INNER_SHOW_TYPE_MAP;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, Integer> INNER_SHOW_TYPE_MAP_MEDIA_UP_MAP;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, Integer> INNER_SHOW_TYPE_MAP_MEDIA_DOWN_MAP;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, Integer> INNER_SHOW_TYPE_MAP_MEDIA_DOWN_WITH_MARGIN_MAP;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, Integer> INNER_SHOW_TYPE_MAP_GUILD_SQUARE_FEED_MAP;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, Integer> INNER_SHOW_TYPE_MAP_GUILD_DISCOVERY_MAP;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, Integer> VIEW_CLICK_POS_ID_MAP;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, a<CardAdView>> CARD_AD_TYPE_TO_VIEW_MAP;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00e6\u0080\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J)\u0010\t\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/ad/cardad/data/x$a;", "T", "", "Landroid/content/Context;", "context", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "Lcom/tencent/mobileqq/ad/cardad/data/aa;", "reportCallback", "a", "(Landroid/content/Context;Lcom/tencent/gdtad/aditem/GdtAd;Lcom/tencent/mobileqq/ad/cardad/data/aa;)Ljava/lang/Object;", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public interface a<T> {
        T a(@NotNull Context context, @NotNull GdtAd gdtAd, @Nullable aa reportCallback);
    }

    static {
        HashMap hashMapOf;
        HashMap hashMapOf2;
        HashMap hashMapOf3;
        HashMap hashMapOf4;
        HashMap hashMapOf5;
        HashMap hashMapOf6;
        HashMap hashMapOf7;
        HashMap hashMapOf8;
        HashMap hashMapOf9;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26474);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        f186705a = new x();
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(1, 1), TuplesKt.to(2, 2), TuplesKt.to(3, 3), TuplesKt.to(4, 4), TuplesKt.to(50, 1), TuplesKt.to(35, 1), TuplesKt.to(36, 3), TuplesKt.to(49, 3));
        INNER_SHOW_TYPE_MAP = hashMapOf;
        hashMapOf2 = MapsKt__MapsKt.hashMapOf(TuplesKt.to(1, 5), TuplesKt.to(2, 6), TuplesKt.to(3, 7), TuplesKt.to(4, 8), TuplesKt.to(50, 5), TuplesKt.to(35, 5), TuplesKt.to(36, 7), TuplesKt.to(49, 7));
        SHOP_AD_INNER_SHOW_TYPE_MAP = hashMapOf2;
        hashMapOf3 = MapsKt__MapsKt.hashMapOf(TuplesKt.to(1, 9), TuplesKt.to(2, 10), TuplesKt.to(3, 11), TuplesKt.to(4, 12));
        INNER_SHOW_TYPE_MAP_MEDIA_UP_MAP = hashMapOf3;
        hashMapOf4 = MapsKt__MapsKt.hashMapOf(TuplesKt.to(1, 13), TuplesKt.to(2, 14), TuplesKt.to(3, 15), TuplesKt.to(4, 16));
        INNER_SHOW_TYPE_MAP_MEDIA_DOWN_MAP = hashMapOf4;
        hashMapOf5 = MapsKt__MapsKt.hashMapOf(TuplesKt.to(1, 17), TuplesKt.to(2, 14), TuplesKt.to(3, 18), TuplesKt.to(4, 16));
        INNER_SHOW_TYPE_MAP_MEDIA_DOWN_WITH_MARGIN_MAP = hashMapOf5;
        hashMapOf6 = MapsKt__MapsKt.hashMapOf(TuplesKt.to(1, 19), TuplesKt.to(2, 19), TuplesKt.to(8, 19), TuplesKt.to(6, 19), TuplesKt.to(3, 20), TuplesKt.to(4, 20));
        INNER_SHOW_TYPE_MAP_GUILD_SQUARE_FEED_MAP = hashMapOf6;
        hashMapOf7 = MapsKt__MapsKt.hashMapOf(TuplesKt.to(1, 21), TuplesKt.to(3, 22), TuplesKt.to(4, 23));
        INNER_SHOW_TYPE_MAP_GUILD_DISCOVERY_MAP = hashMapOf7;
        hashMapOf8 = MapsKt__MapsKt.hashMapOf(TuplesKt.to(Integer.valueOf(R.id.tm_), 2), TuplesKt.to(Integer.valueOf(R.id.tmi), 3), TuplesKt.to(Integer.valueOf(R.id.tm6), 4), TuplesKt.to(Integer.valueOf(R.id.f164727tm2), 8), TuplesKt.to(Integer.valueOf(R.id.tmb), 5), TuplesKt.to(Integer.valueOf(R.id.tn8), 6));
        VIEW_CLICK_POS_ID_MAP = hashMapOf8;
        hashMapOf9 = MapsKt__MapsKt.hashMapOf(TuplesKt.to(1, new a() { // from class: com.tencent.mobileqq.ad.cardad.data.a
            @Override // com.tencent.mobileqq.ad.cardad.data.x.a
            public final Object a(Context context, GdtAd gdtAd, aa aaVar) {
                CardAdView x16;
                x16 = x.x(context, gdtAd, aaVar);
                return x16;
            }
        }), TuplesKt.to(2, new a() { // from class: com.tencent.mobileqq.ad.cardad.data.c
            @Override // com.tencent.mobileqq.ad.cardad.data.x.a
            public final Object a(Context context, GdtAd gdtAd, aa aaVar) {
                CardAdView y16;
                y16 = x.y(context, gdtAd, aaVar);
                return y16;
            }
        }), TuplesKt.to(3, new a() { // from class: com.tencent.mobileqq.ad.cardad.data.g
            @Override // com.tencent.mobileqq.ad.cardad.data.x.a
            public final Object a(Context context, GdtAd gdtAd, aa aaVar) {
                CardAdView J;
                J = x.J(context, gdtAd, aaVar);
                return J;
            }
        }), TuplesKt.to(4, new a() { // from class: com.tencent.mobileqq.ad.cardad.data.h
            @Override // com.tencent.mobileqq.ad.cardad.data.x.a
            public final Object a(Context context, GdtAd gdtAd, aa aaVar) {
                CardAdView N;
                N = x.N(context, gdtAd, aaVar);
                return N;
            }
        }), TuplesKt.to(5, new a() { // from class: com.tencent.mobileqq.ad.cardad.data.i
            @Override // com.tencent.mobileqq.ad.cardad.data.x.a
            public final Object a(Context context, GdtAd gdtAd, aa aaVar) {
                CardAdView O;
                O = x.O(context, gdtAd, aaVar);
                return O;
            }
        }), TuplesKt.to(6, new a() { // from class: com.tencent.mobileqq.ad.cardad.data.j
            @Override // com.tencent.mobileqq.ad.cardad.data.x.a
            public final Object a(Context context, GdtAd gdtAd, aa aaVar) {
                CardAdView P;
                P = x.P(context, gdtAd, aaVar);
                return P;
            }
        }), TuplesKt.to(7, new a() { // from class: com.tencent.mobileqq.ad.cardad.data.k
            @Override // com.tencent.mobileqq.ad.cardad.data.x.a
            public final Object a(Context context, GdtAd gdtAd, aa aaVar) {
                CardAdView Q;
                Q = x.Q(context, gdtAd, aaVar);
                return Q;
            }
        }), TuplesKt.to(8, new a() { // from class: com.tencent.mobileqq.ad.cardad.data.m
            @Override // com.tencent.mobileqq.ad.cardad.data.x.a
            public final Object a(Context context, GdtAd gdtAd, aa aaVar) {
                CardAdView R;
                R = x.R(context, gdtAd, aaVar);
                return R;
            }
        }), TuplesKt.to(9, new a() { // from class: com.tencent.mobileqq.ad.cardad.data.n
            @Override // com.tencent.mobileqq.ad.cardad.data.x.a
            public final Object a(Context context, GdtAd gdtAd, aa aaVar) {
                CardAdView S;
                S = x.S(context, gdtAd, aaVar);
                return S;
            }
        }), TuplesKt.to(10, new a() { // from class: com.tencent.mobileqq.ad.cardad.data.o
            @Override // com.tencent.mobileqq.ad.cardad.data.x.a
            public final Object a(Context context, GdtAd gdtAd, aa aaVar) {
                CardAdView T;
                T = x.T(context, gdtAd, aaVar);
                return T;
            }
        }), TuplesKt.to(11, new a() { // from class: com.tencent.mobileqq.ad.cardad.data.l
            @Override // com.tencent.mobileqq.ad.cardad.data.x.a
            public final Object a(Context context, GdtAd gdtAd, aa aaVar) {
                CardAdView z16;
                z16 = x.z(context, gdtAd, aaVar);
                return z16;
            }
        }), TuplesKt.to(12, new a() { // from class: com.tencent.mobileqq.ad.cardad.data.p
            @Override // com.tencent.mobileqq.ad.cardad.data.x.a
            public final Object a(Context context, GdtAd gdtAd, aa aaVar) {
                CardAdView A;
                A = x.A(context, gdtAd, aaVar);
                return A;
            }
        }), TuplesKt.to(13, new a() { // from class: com.tencent.mobileqq.ad.cardad.data.q
            @Override // com.tencent.mobileqq.ad.cardad.data.x.a
            public final Object a(Context context, GdtAd gdtAd, aa aaVar) {
                CardAdView B;
                B = x.B(context, gdtAd, aaVar);
                return B;
            }
        }), TuplesKt.to(14, new a() { // from class: com.tencent.mobileqq.ad.cardad.data.r
            @Override // com.tencent.mobileqq.ad.cardad.data.x.a
            public final Object a(Context context, GdtAd gdtAd, aa aaVar) {
                CardAdView C;
                C = x.C(context, gdtAd, aaVar);
                return C;
            }
        }), TuplesKt.to(15, new a() { // from class: com.tencent.mobileqq.ad.cardad.data.s
            @Override // com.tencent.mobileqq.ad.cardad.data.x.a
            public final Object a(Context context, GdtAd gdtAd, aa aaVar) {
                CardAdView D;
                D = x.D(context, gdtAd, aaVar);
                return D;
            }
        }), TuplesKt.to(16, new a() { // from class: com.tencent.mobileqq.ad.cardad.data.t
            @Override // com.tencent.mobileqq.ad.cardad.data.x.a
            public final Object a(Context context, GdtAd gdtAd, aa aaVar) {
                CardAdView E;
                E = x.E(context, gdtAd, aaVar);
                return E;
            }
        }), TuplesKt.to(17, new a() { // from class: com.tencent.mobileqq.ad.cardad.data.u
            @Override // com.tencent.mobileqq.ad.cardad.data.x.a
            public final Object a(Context context, GdtAd gdtAd, aa aaVar) {
                CardAdView F;
                F = x.F(context, gdtAd, aaVar);
                return F;
            }
        }), TuplesKt.to(18, new a() { // from class: com.tencent.mobileqq.ad.cardad.data.v
            @Override // com.tencent.mobileqq.ad.cardad.data.x.a
            public final Object a(Context context, GdtAd gdtAd, aa aaVar) {
                CardAdView G;
                G = x.G(context, gdtAd, aaVar);
                return G;
            }
        }), TuplesKt.to(19, new a() { // from class: com.tencent.mobileqq.ad.cardad.data.w
            @Override // com.tencent.mobileqq.ad.cardad.data.x.a
            public final Object a(Context context, GdtAd gdtAd, aa aaVar) {
                CardAdView H;
                H = x.H(context, gdtAd, aaVar);
                return H;
            }
        }), TuplesKt.to(20, new a() { // from class: com.tencent.mobileqq.ad.cardad.data.b
            @Override // com.tencent.mobileqq.ad.cardad.data.x.a
            public final Object a(Context context, GdtAd gdtAd, aa aaVar) {
                CardAdView I;
                I = x.I(context, gdtAd, aaVar);
                return I;
            }
        }), TuplesKt.to(21, new a() { // from class: com.tencent.mobileqq.ad.cardad.data.d
            @Override // com.tencent.mobileqq.ad.cardad.data.x.a
            public final Object a(Context context, GdtAd gdtAd, aa aaVar) {
                CardAdView K;
                K = x.K(context, gdtAd, aaVar);
                return K;
            }
        }), TuplesKt.to(22, new a() { // from class: com.tencent.mobileqq.ad.cardad.data.e
            @Override // com.tencent.mobileqq.ad.cardad.data.x.a
            public final Object a(Context context, GdtAd gdtAd, aa aaVar) {
                CardAdView L;
                L = x.L(context, gdtAd, aaVar);
                return L;
            }
        }), TuplesKt.to(23, new a() { // from class: com.tencent.mobileqq.ad.cardad.data.f
            @Override // com.tencent.mobileqq.ad.cardad.data.x.a
            public final Object a(Context context, GdtAd gdtAd, aa aaVar) {
                CardAdView M;
                M = x.M(context, gdtAd, aaVar);
                return M;
            }
        }));
        CARD_AD_TYPE_TO_VIEW_MAP = hashMapOf9;
    }

    x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CardAdView A(Context context, GdtAd gdtAd, aa aaVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        return new CardAdVideoPortraitMediaUp(context, gdtAd, aaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CardAdView B(Context context, GdtAd gdtAd, aa aaVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        return new CardAdPicLandscapeMediaDown(context, gdtAd, aaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CardAdView C(Context context, GdtAd gdtAd, aa aaVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        return new CardAdPicPortraitMediaDown(context, gdtAd, aaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CardAdView D(Context context, GdtAd gdtAd, aa aaVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        return new CardAdVideoLandscapeMediaDown(context, gdtAd, aaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CardAdView E(Context context, GdtAd gdtAd, aa aaVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        return new CardAdVideoPortraitMediaDown(context, gdtAd, aaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CardAdView F(Context context, GdtAd gdtAd, aa aaVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        return new CardAdPicLandscapeMediaDownWithMargin(context, gdtAd, aaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CardAdView G(Context context, GdtAd gdtAd, aa aaVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        return new CardAdVideoLandscapeMediaDownWithMargin(context, gdtAd, aaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CardAdView H(Context context, GdtAd gdtAd, aa aaVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        return new CardAdPicForGuildSquareFeed(context, gdtAd, aaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CardAdView I(Context context, GdtAd gdtAd, aa aaVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        return new CardAdVideoForGuildSquareFeed(context, gdtAd, aaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CardAdView J(Context context, GdtAd gdtAd, aa aaVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        return new CardAdVideoLandscape(context, gdtAd, aaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CardAdView K(Context context, GdtAd gdtAd, aa aaVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        return new CardAdPicLandscapeForGuildDiscovery(context, gdtAd, aaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CardAdView L(Context context, GdtAd gdtAd, aa aaVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        return new CardAdVideoLandscapeForGuildDiscovery(context, gdtAd, aaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CardAdView M(Context context, GdtAd gdtAd, aa aaVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        return new CardAdVideoPortraitForGuildDiscovery(context, gdtAd, aaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CardAdView N(Context context, GdtAd gdtAd, aa aaVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        return new CardAdVideoPortrait(context, gdtAd, aaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CardAdView O(Context context, GdtAd gdtAd, aa aaVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        return new CardAdPicLandscapeForQQShop(context, gdtAd, aaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CardAdView P(Context context, GdtAd gdtAd, aa aaVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        return new CardAdPicPortraitForQQShop(context, gdtAd, aaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CardAdView Q(Context context, GdtAd gdtAd, aa aaVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        return new CardAdVideoLandscapeForQQShop(context, gdtAd, aaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CardAdView R(Context context, GdtAd gdtAd, aa aaVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        return new CardAdVideoPortraitForQQShop(context, gdtAd, aaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CardAdView S(Context context, GdtAd gdtAd, aa aaVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        return new CardAdPicLandscapeMediaUp(context, gdtAd, aaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CardAdView T(Context context, GdtAd gdtAd, aa aaVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        return new CardAdPicPortraitMediaUp(context, gdtAd, aaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CardAdView x(Context context, GdtAd gdtAd, aa aaVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        return new CardAdPicLandscape(context, gdtAd, aaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CardAdView y(Context context, GdtAd gdtAd, aa aaVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        return new CardAdPicPortrait(context, gdtAd, aaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CardAdView z(Context context, GdtAd gdtAd, aa aaVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        return new CardAdVideoLandscapeMediaUp(context, gdtAd, aaVar);
    }

    @NotNull
    public final Map<Integer, a<CardAdView>> U() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Map) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return CARD_AD_TYPE_TO_VIEW_MAP;
    }

    @NotNull
    public final Map<Integer, Integer> V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return INNER_SHOW_TYPE_MAP;
    }

    @NotNull
    public final Map<Integer, Integer> W() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Map) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return INNER_SHOW_TYPE_MAP_GUILD_DISCOVERY_MAP;
    }

    @NotNull
    public final Map<Integer, Integer> X() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Map) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return INNER_SHOW_TYPE_MAP_GUILD_SQUARE_FEED_MAP;
    }

    @NotNull
    public final Map<Integer, Integer> Y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Map) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return INNER_SHOW_TYPE_MAP_MEDIA_DOWN_MAP;
    }

    @NotNull
    public final Map<Integer, Integer> Z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Map) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return INNER_SHOW_TYPE_MAP_MEDIA_DOWN_WITH_MARGIN_MAP;
    }

    @NotNull
    public final Map<Integer, Integer> a0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Map) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return INNER_SHOW_TYPE_MAP_MEDIA_UP_MAP;
    }

    @NotNull
    public final Map<Integer, Integer> b0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Map) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return SHOP_AD_INNER_SHOW_TYPE_MAP;
    }

    @NotNull
    public final Map<Integer, Integer> c0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Map) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return VIEW_CLICK_POS_ID_MAP;
    }
}
