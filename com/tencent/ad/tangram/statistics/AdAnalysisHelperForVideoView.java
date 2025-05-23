package com.tencent.ad.tangram.statistics;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.analysis.AdAnalysisEvent;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import java.lang.ref.WeakReference;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdAnalysisHelperForVideoView {
    @NonNull
    private static gdt_analysis_event createEvent(Context context, int i3, boolean z16, Ad ad5) {
        gdt_analysis_event createEventForAd = AdAnalysisHelper.createEventForAd(context, i3, ad5);
        createEventForAd.isSupplement = z16 ? 1 : 0;
        return createEventForAd;
    }

    public static void reportError(Context context, AdError adError, int i3, boolean z16, Ad ad5) {
        gdt_analysis_event createEvent = createEvent(context, 1226, z16, ad5);
        createEvent.errorCode1 = adError.getErrorCode();
        createEvent.internalErrorCode = i3;
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(createEvent, 103));
    }

    public static void reportFirstCompleted(Context context, boolean z16, Ad ad5) {
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(createEvent(context, gdt_analysis_event.EVENT_VIDEO_FIRST_COMPLETED, z16, ad5), 102));
    }

    public static void reportFirstFrameRendered(Context context, boolean z16, Ad ad5) {
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(createEvent(context, gdt_analysis_event.EVENT_VIDEO_FIRST_FRAME_RENDERED, z16, ad5), 102));
    }

    public static void reportInitializeStart(Context context, boolean z16, Ad ad5) {
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(createEvent(context, 1221, z16, ad5), 102));
    }

    public static void reportInitializeSuccess(Context context, boolean z16, Ad ad5) {
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(createEvent(context, gdt_analysis_event.EVENT_VIDEO_STATE_INITIALIZE_SUCCESS, z16, ad5), 102));
    }

    public static void reportPrepared(Context context, boolean z16, Ad ad5) {
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(createEvent(context, gdt_analysis_event.EVENT_VIDEO_STATE_PREPARED, z16, ad5), 102));
    }
}
