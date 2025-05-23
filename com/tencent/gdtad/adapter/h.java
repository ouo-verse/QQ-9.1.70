package com.tencent.gdtad.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.ad.tangram.interpage.AdInterPageAdapter;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ad.tangram.statistics.AdAnalysisHelper;
import com.tencent.ad.tangram.util.AdClickUtil;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.api.interpage.GdtOlympicInterPageFragment;
import com.tencent.gdtad.api.interpage.GdtOlympicLoadFailFragment;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import cooperation.qzone.util.NetworkState;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class h implements AdInterPageAdapter {
    private void a(Context context, GdtAd gdtAd, boolean z16) {
        gdt_analysis_event createEventForAd = AdAnalysisHelper.createEventForAd(context, gdt_analysis_event.EVENT_JUMP_OLYMPIC_INTER_PAGE, gdtAd);
        createEventForAd.actionId = !z16 ? 1 : 0;
        fm0.i.INSTANCE.b(new WeakReference<>(context), createEventForAd);
    }

    @Override // com.tencent.ad.tangram.interpage.AdInterPageAdapter
    public AdError showOlympicPage(AdClickUtil.Params params) {
        Ad ad5;
        GdtAd gdtAd;
        if (params != null && params.isValid() && (ad5 = params.f61334ad) != null && (ad5 instanceof GdtAd) && ad5.isOlympicInterPageType()) {
            Ad ad6 = params.f61334ad;
            Activity activity = null;
            if (ad6 instanceof GdtAd) {
                gdtAd = (GdtAd) ad6;
            } else {
                gdtAd = null;
            }
            if (gdtAd != null && (!TextUtils.isEmpty(gdtAd.getOlympicInterPageImage()) || !TextUtils.isEmpty(gdtAd.getVideoUrl()))) {
                GdtHandler.Options options = new GdtHandler.Options();
                GdtHandler.fillOptionsFromClickUtilParams(params, options);
                boolean isNetSupport = NetworkState.isNetSupport();
                WeakReference<Activity> weakReference = params.activity;
                if (weakReference != null) {
                    activity = weakReference.get();
                }
                if (activity == null) {
                    GdtLog.e("GdtInterPageAdapter", "[showOlympicPage] activity error");
                    return new AdError(4);
                }
                GdtLog.i("GdtInterPageAdapter", "[startOlympicPage] isNetSupport:" + isNetSupport);
                a(activity, gdtAd, isNetSupport);
                Intent intent = new Intent();
                intent.putExtra("public_fragment_window_feature", 1);
                if (isNetSupport) {
                    intent.putExtra("big_brother_source_key", AdDownloadConstants.DOWNLOAD_SOURCE_AD);
                    intent.putExtra("public_fragment_window_feature", 1);
                    intent.putExtra("key_options", options);
                    intent.putExtra("keyOlympicImageUrl", gdtAd.getOlympicInterPageImage());
                    intent.putExtra("keyOlympicVideoUrl", gdtAd.getVideoUrl());
                    QPublicFragmentActivity.b.b(activity, intent, QPublicTransFragmentActivity.class, GdtOlympicInterPageFragment.class);
                } else {
                    QPublicFragmentActivity.b.b(activity, intent, QPublicTransFragmentActivity.class, GdtOlympicLoadFailFragment.class);
                }
                return new AdError(0);
            }
            GdtLog.e("GdtInterPageAdapter", "[showOlympicPage] gdtAd error");
            return new AdError(4);
        }
        GdtLog.e("GdtInterPageAdapter", "[showOlympicPage] error");
        return new AdError(4);
    }
}
