package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad;

import android.graphics.Rect;
import android.view.View;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u0017\u0010\r\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fR \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/ad/h;", "", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_AD_TYPE, "Lkotlin/Pair;", "a", "(Ljava/lang/Integer;)Lkotlin/Pair;", "b", "(Ljava/lang/Integer;)I", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "", "c", "d", "(Ljava/lang/Integer;)Z", "Landroid/view/View;", "view", "e", "Lkotlin/Pair;", "DEFAULT_RATIO", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f86763a = new h();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Pair<Integer, Integer> DEFAULT_RATIO = new Pair<>(4, 3);

    h() {
    }

    @NotNull
    public final Pair<Integer, Integer> a(@Nullable Integer adType) {
        if ((adType == null || adType.intValue() != 1) && ((adType == null || adType.intValue() != 3) && !d(adType))) {
            if ((adType == null || adType.intValue() != 2) && (adType == null || adType.intValue() != 4)) {
                return DEFAULT_RATIO;
            }
            return new Pair<>(9, 16);
        }
        return new Pair<>(16, 9);
    }

    public final int b(@Nullable Integer adType) {
        int i3 = 1;
        if ((adType == null || adType.intValue() != 1) && (adType == null || adType.intValue() != 3)) {
            i3 = 2;
            if ((adType == null || adType.intValue() != 2) && (adType == null || adType.intValue() != 4)) {
                return 3;
            }
        }
        return i3;
    }

    public final boolean c(@NotNull GdtAd gdtAd) {
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        return gdtAd.isExperiment(122352, "1");
    }

    public final boolean d(@Nullable Integer adType) {
        if (adType == null) {
            return false;
        }
        if (adType.intValue() != 50 && adType.intValue() != 49 && adType.intValue() != 36 && adType.intValue() != 35) {
            return false;
        }
        return true;
    }

    public final boolean e(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getGlobalVisibleRect(new Rect()) && view.isShown()) {
            return true;
        }
        return false;
    }
}
