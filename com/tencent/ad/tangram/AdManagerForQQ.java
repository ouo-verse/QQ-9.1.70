package com.tencent.ad.tangram;

import android.content.Context;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.statistics.AdFetcherFromClickUrl;
import com.tencent.ad.tangram.statistics.AdReporterForLinkEvent;
import java.lang.ref.WeakReference;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdManagerForQQ {
    private static final String TAG = "AdManagerForQQ";
    private static volatile AdManagerForQQ sInstance;
    private volatile boolean initialized = false;
    private AdReporterForLinkEvent.Adapter linkReportAdapter = new com.tencent.ad.tangram.statistics.a();

    AdManagerForQQ() {
    }

    public static AdManagerForQQ getInstance() {
        if (sInstance == null) {
            synchronized (AdManagerForQQ.class) {
                if (sInstance == null) {
                    sInstance = new AdManagerForQQ();
                }
            }
        }
        return sInstance;
    }

    private void initForDeepFallbackToUrl(WeakReference<Context> weakReference) {
        AdFetcherFromClickUrl.getInstance().init(weakReference);
    }

    private void initForLinkReport() {
        AdReporterForLinkEvent.getInstance().setAdapter(new WeakReference<>(this.linkReportAdapter));
    }

    public void init(WeakReference<Context> weakReference) {
        if (this.initialized) {
            return;
        }
        synchronized (this) {
            if (this.initialized) {
                return;
            }
            this.initialized = true;
            initForLinkReport();
            initForDeepFallbackToUrl(weakReference);
        }
    }
}
