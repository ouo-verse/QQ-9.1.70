package com.tencent.mobileqq.vas.adv.qzone.logic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.util.j;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ8\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bJ\u0018\u0010\u0011\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\u0010\u0010\u0019\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017R0\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u001aj\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014`\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/vas/adv/qzone/logic/b;", "", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Context;", "context", "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "exposureCallback", "Lcom/tencent/mobileqq/vas/adv/common/data/AlumBasicData;", "basicData", "", "videoCurrentDuration", "", "d", "", "clickParam", "e", "Landroid/widget/FrameLayout$LayoutParams;", "a", "", "actionType", "b", "Landroid/view/View;", "view", "c", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "REPORT_ACTION_TYPE_MAP", "<init>", "()V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f308265a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, Integer> REPORT_ACTION_TYPE_MAP;

    static {
        HashMap<Integer, Integer> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(1, 0), TuplesKt.to(2, 1), TuplesKt.to(3, 4), TuplesKt.to(4, 6));
        REPORT_ACTION_TYPE_MAP = hashMapOf;
    }

    b() {
    }

    @NotNull
    public final FrameLayout.LayoutParams a() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = ViewUtils.dpToPx(26.0f);
        layoutParams.bottomMargin = ViewUtils.dpToPx(26.0f);
        layoutParams.gravity = 5;
        return layoutParams;
    }

    public final int b(int actionType) {
        Integer num = REPORT_ACTION_TYPE_MAP.get(Integer.valueOf(actionType));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public final void c(@Nullable View view) {
        if (view == null) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500L);
        view.startAnimation(alphaAnimation);
    }

    public final void d(@Nullable WeakReference<Activity> activity, @NotNull Context context, @NotNull AdExposureChecker.ExposureCallback exposureCallback, @Nullable AlumBasicData basicData, long videoCurrentDuration) {
        String str;
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(exposureCallback, "exposureCallback");
        GdtHandler.Params params = new GdtHandler.Params();
        if (activity != null) {
            params.activity = activity;
            j jVar = j.f109555a;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("");
            Long l3 = null;
            if (basicData != null) {
                str = basicData.traceId;
            } else {
                str = null;
            }
            sb5.append(str);
            String a16 = jVar.a(sb5.toString(), true);
            params.antiSpamParams = a16;
            if (basicData != null) {
                adInfo = basicData.adInfo;
            } else {
                adInfo = null;
            }
            params.f108486ad = new GdtAd(adInfo);
            params.reportForClick = true;
            boolean z16 = false;
            if (basicData != null && basicData.isVideoAdvType()) {
                z16 = true;
            }
            if (z16) {
                params.videoCeilingSupportedIfInstalled = true;
                params.videoCeilingSupportedIfNotInstalled = true;
            }
            Bundle bundle = new Bundle();
            params.extra = bundle;
            bundle.putString(LaunchParam.KEY_REF_ID, "biz_src_jc_qzone");
            params.videoStartPositionMillis = videoCurrentDuration;
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params);
            e(basicData, a16);
            AdExposureChecker.onClick(context, params.f108486ad, new WeakReference(exposureCallback));
            StringBuilder sb6 = new StringBuilder();
            sb6.append("album handleAdClick");
            GdtAd gdtAd = params.f108486ad;
            if (gdtAd != null) {
                l3 = Long.valueOf(gdtAd.getAId());
            }
            sb6.append(l3);
            QZLog.i("QZoneAlbumAdUtils", sb6.toString());
        }
    }

    public final void e(@Nullable AlumBasicData basicData, @NotNull String clickParam) {
        Intrinsics.checkNotNullParameter(clickParam, "clickParam");
        boolean z16 = false;
        if (basicData != null && basicData.sourceFrom == 2) {
            z16 = true;
        }
        if (!z16 && basicData != null) {
            j jVar = j.f109555a;
            String valueOf = String.valueOf(basicData.aid);
            String str = basicData.traceId;
            Intrinsics.checkNotNullExpressionValue(str, "basicData.traceId");
            jVar.f(2, valueOf, str, clickParam, 0, 0);
        }
    }
}
