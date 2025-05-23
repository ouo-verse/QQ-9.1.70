package com.tencent.rfix.lib.lite;

import android.app.Application;
import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rfix.lib.RFix;
import com.tencent.rfix.lib.RFixListener;
import com.tencent.rfix.lib.RFixParams;
import com.tencent.rfix.lib.reporter.c;
import com.tencent.rfix.lib.reporter.f;
import com.tencent.rfix.loader.entity.RFixLoadResult;
import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.rfix.loader.thread.RFixThreadPool;
import com.tencent.rfix.loader.track.TimeTrackType;
import com.tencent.rfix.loader.track.TimeTracker;

/* compiled from: P */
@Keep
/* loaded from: classes25.dex */
public class RFixInitializer {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "RFixInitializer";

    public RFixInitializer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected static void doLaunchReport(final Application application, final RFixLoadResult rFixLoadResult, final boolean z16, final long j3) {
        if (!z16) {
            RFixLog.w(TAG, "doLaunchReport init fail! ignore launch report.");
        } else {
            RFixThreadPool.getInstance().execute(new Runnable() { // from class: com.tencent.rfix.lib.lite.b
                @Override // java.lang.Runnable
                public final void run() {
                    RFixInitializer.lambda$doLaunchReport$1(application, rFixLoadResult, z16, j3);
                }
            });
        }
    }

    public static RFix initialize(Application application, RFixLoadResult rFixLoadResult, RFixParams rFixParams) {
        return initialize(application, rFixLoadResult, rFixParams, null);
    }

    protected static RFix initializeRFix(Application application, RFixLoadResult rFixLoadResult, RFixParams rFixParams, RFixListener rFixListener) {
        RFix rFix = null;
        try {
            rFix = new RFix.b(application, rFixLoadResult, rFixParams).b(rFixListener).a();
            RFix.bind(rFix);
            return rFix;
        } catch (Exception e16) {
            RFixLog.e(TAG, "initializeRFix fail!", e16);
            return rFix;
        }
    }

    protected static RFix initializeWrap(final Application application, RFixLoadResult rFixLoadResult, RFixParams rFixParams, RFixListener rFixListener) {
        boolean z16;
        TimeTrackType timeTrackType = TimeTrackType.SDK_INIT_TOTAL;
        TimeTracker.beginTrack(timeTrackType);
        RFixThreadPool.getInstance().execute(new Runnable() { // from class: com.tencent.rfix.lib.lite.a
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.rfix.lib.bugly.a.b(application);
            }
        });
        RFix initializeRFix = initializeRFix(application, rFixLoadResult, rFixParams, rFixListener);
        TimeTracker.endTrack(timeTrackType);
        long trackTimeMillis = TimeTracker.getTrackTimeMillis(timeTrackType);
        if (initializeRFix != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        doLaunchReport(application, rFixLoadResult, z16, trackTimeMillis);
        return initializeRFix;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doLaunchReport$1(Application application, RFixLoadResult rFixLoadResult, boolean z16, long j3) {
        c.b(application, rFixLoadResult, z16, j3);
        f.f(application, rFixLoadResult, z16, j3);
    }

    public static RFix initialize(Application application, RFixLoadResult rFixLoadResult, RFixParams rFixParams, RFixListener rFixListener) {
        return initializeWrap(application, rFixLoadResult, rFixParams, rFixListener);
    }
}
