package com.tencent.gdtad.adapter;

import android.content.Intent;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.triple.AdTripleLinkAdapter;
import com.tencent.ad.tangram.util.AdClickUtil;
import com.tencent.ad.tangram.videoceiling.AdVideoCeiling;
import com.tencent.ad.tangram.web.AdBrowser;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingData;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingFragment;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class s implements AdTripleLinkAdapter {
    private AdError a(AdClickUtil.Params params, AdClickUtil.URLObject uRLObject) {
        AdBrowser.Params browserParams = AdClickUtil.getBrowserParams(params, uRLObject);
        Intent a16 = com.tencent.gdtad.util.i.a(browserParams);
        if (browserParams != null && a16 != null) {
            GdtHandler.Options options = new GdtHandler.Options();
            GdtHandler.fillOptionsFromClickUtilParams(params, options);
            a16.putExtra("key_options", options);
            try {
                com.tencent.gdtad.statistics.b.a(browserParams);
                params.activity.get().startActivity(a16);
                if (params.useVerticalTransitionBetweenActivities) {
                    params.activity.get().overridePendingTransition(R.anim.f154424l, R.anim.f154442w);
                }
                return new AdError(0);
            } catch (Throwable th5) {
                GdtLog.e("GdtTripleLinkAdapter", "show", th5);
                return new AdError(202, th5);
            }
        }
        GdtLog.e("GdtTripleLinkAdapter", "[show] params error");
        return new AdError(4);
    }

    private AdError b(AdClickUtil.Params params) {
        AdVideoCeiling.Params videoCeilingParams = AdClickUtil.getVideoCeilingParams(params);
        GdtVideoCeilingData a16 = com.tencent.gdtad.util.q.a(videoCeilingParams);
        if (videoCeilingParams != null && a16 != null) {
            if (!a16.isValid()) {
                GdtLog.e("GdtTripleLinkAdapter", "show error");
                return new AdError(4);
            }
            GdtHandler.Options options = new GdtHandler.Options();
            GdtHandler.fillOptionsFromClickUtilParams(params, options);
            GdtVideoCeilingFragment.uh(params.activity.get(), a16, params.useVerticalTransitionBetweenActivities, params.extrasForIntent, options);
            return new AdError(0);
        }
        GdtLog.e("GdtTripleLinkAdapter", "[show] params error");
        return new AdError(4);
    }

    @Override // com.tencent.ad.tangram.triple.AdTripleLinkAdapter
    public AdError show(AdClickUtil.Params params, AdClickUtil.URLObject uRLObject) {
        Ad ad5;
        if (params != null && params.isValid() && (ad5 = params.f61334ad) != null && (ad5 instanceof GdtAd) && ad5.isTripleLink() && uRLObject != null) {
            AdError b16 = b(params);
            if (b16 == null || !b16.isSuccess()) {
                return a(params, uRLObject);
            }
            return b16;
        }
        GdtLog.e("GdtTripleLinkAdapter", "[show] error");
        return new AdError(4);
    }
}
