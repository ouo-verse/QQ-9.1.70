package com.tencent.ad.tangram.statistics;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.lang.ref.WeakReference;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdReporterForFeedback {
    private static final String TAG = "AdReporterForFeedback";

    @Nullable
    private static String getUrl(@Nullable Ad ad5, int i3) {
        String str;
        if (ad5 != null && ad5.isValid()) {
            str = ad5.getUrlForFeedBack();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.replaceAll("__ACT_TYPE__", String.valueOf(i3));
    }

    public static void reportAsync(@Nullable final WeakReference<Context> weakReference, final Ad ad5, int i3) {
        Context context;
        final String url = getUrl(ad5, i3);
        AdLog.i(TAG, String.format("reportAsync %s", url));
        if (weakReference != null) {
            context = weakReference.get();
        } else {
            context = null;
        }
        AdAnalysisHelperForStatistics.reportForFeedbackStatisticsStart(context, ad5, url);
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.statistics.AdReporterForFeedback.1
            @Override // java.lang.Runnable
            public void run() {
                Context context2;
                AdHttp.Params params = new AdHttp.Params();
                params.setUrl(url);
                params.method = "GET";
                AdHttp.send(params);
                WeakReference weakReference2 = weakReference;
                if (weakReference2 != null) {
                    context2 = (Context) weakReference2.get();
                } else {
                    context2 = null;
                }
                AdAnalysisHelperForStatistics.reportForFeedbackStatisticsEnd(context2, ad5, params);
            }
        }, 4);
    }
}
