package com.tencent.ad.tangram.statistics.canvas;

import android.content.Context;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.analysis.AdAnalysisEvent;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ad.tangram.statistics.AdAnalysisHelper;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdAnalysisHelperForCanvas {
    public static void reportForCanvasDataBuildEnd(Context context, Ad ad5, boolean z16, long j3) {
        gdt_analysis_event createEventForAd = AdAnalysisHelper.createEventForAd(context, 1202, ad5);
        createEventForAd.duration = j3;
        createEventForAd.errorCode1 = z16 ? 1 : 0;
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(createEventForAd, 102));
    }

    public static void reportForCanvasDataBuildError(Context context, Ad ad5, String str) {
        gdt_analysis_event createEventForAd = AdAnalysisHelper.createEventForAd(context, 1201, ad5);
        createEventForAd.androidActivityName = str;
        createEventForAd.internalErrorMessage = str;
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(createEventForAd, 102));
    }
}
