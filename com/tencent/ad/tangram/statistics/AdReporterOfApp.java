package com.tencent.ad.tangram.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.protocol.sdk_event_log;
import com.tencent.ad.tangram.util.AdAppUtil;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdReporterOfApp {
    private static final String TAG = "AdReporterOfApp";

    public static void report(WeakReference<Context> weakReference, Ad ad5) {
        Context context;
        int i3;
        int i16;
        if (weakReference != null) {
            context = weakReference.get();
        } else {
            context = null;
        }
        Context context2 = context;
        if (context2 != null && ad5 != null && ad5.isAppProductType() && !TextUtils.isEmpty(ad5.getAppPackageName())) {
            boolean isInstalled = AdAppUtil.isInstalled(context2, ad5.getAppPackageName());
            AdLog.i(TAG, "[report] installed:" + isInstalled);
            if (isInstalled) {
                i3 = 247;
            } else {
                i3 = 248;
            }
            AdReporterForEffect.reportAsync(weakReference, ad5, i3);
            AdReporterForLinkEvent adReporterForLinkEvent = AdReporterForLinkEvent.getInstance();
            if (isInstalled) {
                i16 = sdk_event_log.SdkEventDimension.EVENT_APP_INSTALLED;
            } else {
                i16 = sdk_event_log.SdkEventDimension.EVENT_APP_NOT_INSTALLED;
            }
            adReporterForLinkEvent.reportAsync(context2, i16, ad5, null, null);
            return;
        }
        AdLog.i(TAG, "[report] do nothing, not valid");
    }
}
