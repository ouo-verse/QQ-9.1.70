package com.tencent.ad.tangram.downloader;

import android.content.Context;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.analysis.AdAnalysisEvent;
import com.tencent.ad.tangram.analysis.AdAnalysisUtil;
import com.tencent.ad.tangram.net.AdNet;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
final class AdAnalysisHelperForDownload {
    AdAnalysisHelperForDownload() {
    }

    public static void reportForQueryUrlByCGI(Context context, boolean z16, int i3) {
        int i16;
        if (z16) {
            i16 = 1319;
        } else {
            i16 = gdt_analysis_event.EVENT_QUERY_URL_BY_CGI_FAILED;
        }
        gdt_analysis_event gdt_analysis_eventVar = new gdt_analysis_event();
        AdAnalysisUtil.initEvent(context, i16, gdt_analysis_eventVar);
        gdt_analysis_eventVar.errorCode1 = !AdNet.isNetValid(context) ? 1 : 0;
        gdt_analysis_eventVar.httpErrorCode = i3;
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(gdt_analysis_eventVar, 103));
    }
}
