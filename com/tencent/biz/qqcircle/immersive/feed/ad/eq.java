package com.tencent.biz.qqcircle.immersive.feed.ad;

import com.tencent.biz.qqcircle.immersive.manager.QFSTopViewManager;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u000f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u0010\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u0011\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u0012\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u0014\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u0004J\u0018\u0010\u0015\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/ad/eq;", "", "Lcom/tencent/gdtad/aditem/GdtAd;", "ad", "", "cardStyle", "Lcom/tencent/biz/qqcircle/immersive/feed/ad/AdStyle;", "c", "", "f", "k", tl.h.F, "a", "g", "d", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", "j", "adCardStyle", "b", "l", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class eq {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final eq f85700a = new eq();

    eq() {
    }

    private final AdStyle c(GdtAd ad5, int cardStyle) {
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        if (ad5 != null) {
            adInfo = ad5.info;
        } else {
            adInfo = null;
        }
        if (QFSTopViewManager.h(adInfo)) {
            return AdStyle.TOP_VIEW;
        }
        if (cardStyle == 4) {
            return AdStyle.FINGER;
        }
        if (ad5 == null) {
            return AdStyle.DEFAULT_CARD;
        }
        if (af.g0(ad5, cardStyle)) {
            return AdStyle.POSTER;
        }
        if (h(ad5)) {
            return AdStyle.DEFAULT_CARD;
        }
        if (af.f0(ad5, cardStyle)) {
            return AdStyle.INDUSTRY;
        }
        if (af.V(ad5)) {
            return AdStyle.BUSINESS;
        }
        if (cardStyle == 5) {
            return AdStyle.TRANSPARENT_CARD;
        }
        if (cardStyle == 6) {
            return AdStyle.NO_CARD;
        }
        return AdStyle.DEFAULT_CARD;
    }

    public final boolean a(@Nullable GdtAd ad5, int cardStyle) {
        if (b(ad5, cardStyle)) {
            QLog.i("QFSStyleManger", 2, "[canShowGameBannerStyle] error, is socialPendantStyle");
            return false;
        }
        return af.d0(ad5);
    }

    public final boolean b(@Nullable GdtAd ad5, int adCardStyle) {
        if (h(ad5)) {
            QLog.i("QFSStyleManger", 2, "[canShowSocialPendant] error, is motive style");
            return false;
        }
        if (!l(ad5, adCardStyle)) {
            QLog.i("QFSStyleManger", 2, "[canShowSocialPendant] error, not three state style, cardStyle:$adCardStyle");
            return false;
        }
        int i3 = Integer.MIN_VALUE;
        if (ad5 != null) {
            i3 = ad5.getExperimentIntegerParam(124616, Integer.MIN_VALUE);
        }
        if (i3 != 1) {
            return false;
        }
        return true;
    }

    public final boolean d(@Nullable GdtAd ad5, int cardStyle) {
        if (c(ad5, cardStyle) == AdStyle.BUSINESS) {
            return true;
        }
        return false;
    }

    public final boolean e(@Nullable GdtAd ad5, int cardStyle) {
        if (c(ad5, cardStyle) == AdStyle.DEFAULT_CARD) {
            return true;
        }
        return false;
    }

    public final boolean f(int cardStyle) {
        if (cardStyle == 4) {
            return true;
        }
        return false;
    }

    public final boolean g(@Nullable GdtAd ad5, int cardStyle) {
        if (c(ad5, cardStyle) == AdStyle.INDUSTRY) {
            return true;
        }
        return false;
    }

    public final boolean h(@Nullable GdtAd ad5) {
        return af.b0(ad5);
    }

    public final boolean i(@Nullable GdtAd ad5, int cardStyle) {
        if (c(ad5, cardStyle) == AdStyle.NO_CARD) {
            return true;
        }
        return false;
    }

    public final boolean j(@Nullable GdtAd ad5, int cardStyle) {
        return af.l(ad5, cardStyle);
    }

    public final boolean k(@Nullable GdtAd ad5, int cardStyle) {
        if (c(ad5, cardStyle) == AdStyle.POSTER) {
            return true;
        }
        return false;
    }

    public final boolean l(@Nullable GdtAd ad5, int cardStyle) {
        if (ad5 == null || af.a0(ad5, cardStyle)) {
            return false;
        }
        AdStyle c16 = c(ad5, cardStyle);
        if (c16 != AdStyle.POSTER && c16 != AdStyle.INDUSTRY && c16 != AdStyle.BUSINESS && c16 != AdStyle.DEFAULT_CARD) {
            return false;
        }
        return true;
    }

    public final boolean m(@Nullable GdtAd ad5, int cardStyle) {
        if (c(ad5, cardStyle) == AdStyle.TRANSPARENT_CARD) {
            return true;
        }
        return false;
    }
}
