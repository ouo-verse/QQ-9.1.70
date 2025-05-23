package com.tencent.mobileqq.ad.cardad.manager;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.ad.cardad.data.aa;
import com.tencent.mobileqq.ad.cardad.data.x;
import com.tencent.mobileqq.ad.cardad.views.CardAdPicLandscape;
import com.tencent.mobileqq.ad.cardad.views.CardAdView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J8\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J&\u0010\u0011\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\bH\u0002J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J@\u0010\u0014\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ.\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/ad/cardad/manager/a;", "", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "", "type", "Lcom/tencent/mobileqq/ad/cardad/data/aa;", "reportCallback", "Lcom/tencent/mobileqq/ad/cardad/views/CardAdView;", "a", "", "posId", "cardAdStyle", "e", "", "d", "c", "b", "<init>", "()V", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f186722a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26481);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f186722a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final CardAdView a(Context context, ViewGroup container, GdtAd gdtAd, int type, aa reportCallback) {
        CardAdView cardAdView = null;
        if (context != null && container != null) {
            x xVar = x.f186705a;
            if (xVar.U().containsKey(Integer.valueOf(type))) {
                x.a<CardAdView> aVar = xVar.U().get(Integer.valueOf(type));
                if (aVar != null) {
                    cardAdView = aVar.a(context, gdtAd, reportCallback);
                }
            } else {
                cardAdView = new CardAdPicLandscape(context, gdtAd, reportCallback);
            }
            if (container.getChildCount() > 0) {
                container.removeAllViews();
            }
            container.addView(cardAdView);
            return cardAdView;
        }
        QLog.e("CardAdFactory", 1, "createCardAd error: null");
        return null;
    }

    private final boolean d(String posId) {
        if (TextUtils.isEmpty(posId)) {
            return false;
        }
        if (!TextUtils.equals(posId, "7085109922408095") && !TextUtils.equals(posId, "6070053621217196") && !TextUtils.equals(posId, "5099373422087196")) {
            return false;
        }
        return true;
    }

    private final int e(GdtAd gdtAd, String posId, int cardAdStyle) {
        Integer num;
        if (gdtAd == null) {
            return 0;
        }
        int innerShowType = gdtAd.getInnerShowType();
        QLog.d("CardAdFactory", 1, "parseCardAdType posId:", posId, ",style:", Integer.valueOf(cardAdStyle));
        if (cardAdStyle == 4) {
            x xVar = x.f186705a;
            if (xVar.a0().containsKey(Integer.valueOf(innerShowType))) {
                Integer num2 = xVar.a0().get(Integer.valueOf(innerShowType));
                if (num2 == null) {
                    return 0;
                }
                return num2.intValue();
            }
        }
        if (cardAdStyle == 3) {
            x xVar2 = x.f186705a;
            if (xVar2.Y().containsKey(Integer.valueOf(innerShowType))) {
                Integer num3 = xVar2.Y().get(Integer.valueOf(innerShowType));
                if (num3 == null) {
                    return 0;
                }
                return num3.intValue();
            }
        }
        if (cardAdStyle == 2) {
            x xVar3 = x.f186705a;
            if (xVar3.Z().containsKey(Integer.valueOf(innerShowType))) {
                Integer num4 = xVar3.Z().get(Integer.valueOf(innerShowType));
                if (num4 == null) {
                    return 0;
                }
                return num4.intValue();
            }
        }
        if (cardAdStyle == 1 || d(posId)) {
            x xVar4 = x.f186705a;
            if (xVar4.b0().containsKey(Integer.valueOf(innerShowType))) {
                Integer num5 = xVar4.b0().get(Integer.valueOf(innerShowType));
                if (num5 == null) {
                    return 0;
                }
                return num5.intValue();
            }
        }
        if (cardAdStyle == 5) {
            x xVar5 = x.f186705a;
            if (xVar5.X().containsKey(Integer.valueOf(innerShowType))) {
                Integer num6 = xVar5.X().get(Integer.valueOf(innerShowType));
                if (num6 == null) {
                    return 0;
                }
                return num6.intValue();
            }
        }
        if (cardAdStyle == 6) {
            x xVar6 = x.f186705a;
            if (xVar6.W().containsKey(Integer.valueOf(innerShowType))) {
                Integer num7 = xVar6.W().get(Integer.valueOf(innerShowType));
                if (num7 == null) {
                    return 0;
                }
                return num7.intValue();
            }
        }
        x xVar7 = x.f186705a;
        if (!xVar7.V().containsKey(Integer.valueOf(innerShowType)) || (num = xVar7.V().get(Integer.valueOf(innerShowType))) == null) {
            return 0;
        }
        return num.intValue();
    }

    static /* synthetic */ int f(a aVar, GdtAd gdtAd, String str, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        return aVar.e(gdtAd, str, i3);
    }

    @Nullable
    public final CardAdView b(@Nullable Context context, @Nullable ViewGroup container, @NotNull GdtAd gdtAd, @Nullable aa reportCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CardAdView) iPatchRedirector.redirect((short) 3, this, context, container, gdtAd, reportCallback);
        }
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        return a(context, container, gdtAd, f(this, gdtAd, gdtAd.getPosId(), 0, 4, null), reportCallback);
    }

    @Nullable
    public final CardAdView c(@Nullable Context context, @Nullable ViewGroup container, @NotNull GdtAd gdtAd, @Nullable String posId, int cardAdStyle, @Nullable aa reportCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CardAdView) iPatchRedirector.redirect((short) 2, this, context, container, gdtAd, posId, Integer.valueOf(cardAdStyle), reportCallback);
        }
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        return a(context, container, gdtAd, e(gdtAd, posId, cardAdStyle), reportCallback);
    }
}
