package com.tencent.biz.qqcircle.immersive.feed.ad;

import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.gdtad.aditem.GdtAd;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes4.dex */
public final class QFSFeedAdFeedbackEvent extends SimpleBaseEvent {
    public static int STATUS_END = 2;
    public static int STATUS_START = 1;
    public static int STATUS_UNKNOWN;
    private GdtAd mGdtAd;
    private AdFeedbackDialogFragment.Result mResult;
    private int mStatus;

    public QFSFeedAdFeedbackEvent(int i3) {
        this.mStatus = i3;
    }

    public int getAction() {
        AdFeedbackDialogFragment.Result result = this.mResult;
        if (result != null) {
            return result.action;
        }
        return 0;
    }

    public GdtAd getGdtAd() {
        return this.mGdtAd;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setAd(GdtAd gdtAd) {
        this.mGdtAd = gdtAd;
    }

    public void setResult(AdFeedbackDialogFragment.Result result) {
        GdtAd gdtAd;
        this.mResult = result;
        if (result != null) {
            Ad ad5 = result.f61345ad;
            if (ad5 instanceof GdtAd) {
                gdtAd = (GdtAd) GdtAd.class.cast(ad5);
                this.mGdtAd = gdtAd;
            }
        }
        gdtAd = null;
        this.mGdtAd = gdtAd;
    }
}
