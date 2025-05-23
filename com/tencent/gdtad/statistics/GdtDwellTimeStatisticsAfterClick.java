package com.tencent.gdtad.statistics;

import android.os.SystemClock;
import android.view.View;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtActionReporter;
import java.lang.ref.WeakReference;

/* compiled from: P */
@Deprecated
/* loaded from: classes6.dex */
final class GdtDwellTimeStatisticsAfterClick {

    /* renamed from: a, reason: collision with root package name */
    private GdtAd f109472a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<View> f109473b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f109474c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f109475d;

    /* renamed from: e, reason: collision with root package name */
    private long f109476e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class CheckRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        WeakReference<GdtDwellTimeStatisticsAfterClick> f109477d;

        public CheckRunnable(WeakReference<GdtDwellTimeStatisticsAfterClick> weakReference) {
            this.f109477d = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference<GdtDwellTimeStatisticsAfterClick> weakReference = this.f109477d;
            if (weakReference != null && weakReference.get() != null) {
                this.f109477d.get().b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        WeakReference weakReference = new WeakReference(this);
        if (this.f109475d) {
            WeakReference<View> weakReference2 = this.f109473b;
            if (weakReference2 != null && weakReference2.get() != null) {
                if (this.f109473b.get().isShown()) {
                    this.f109475d = false;
                    this.f109474c = false;
                    d();
                    return;
                }
                this.f109473b.get().postDelayed(new CheckRunnable(weakReference), 100L);
                return;
            }
            this.f109475d = false;
            this.f109474c = false;
            d();
            return;
        }
        WeakReference<View> weakReference3 = this.f109473b;
        if (weakReference3 != null && weakReference3.get() != null) {
            if (!this.f109473b.get().isShown()) {
                this.f109475d = true;
                c();
                this.f109473b.get().postDelayed(new CheckRunnable(weakReference), 100L);
                return;
            }
            this.f109473b.get().postDelayed(new CheckRunnable(weakReference), 100L);
            return;
        }
        this.f109474c = false;
    }

    private void c() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f109476e = elapsedRealtime;
        GdtLog.i("GdtDwellTimeStatisticsAfterClick", String.format("enter %d", Long.valueOf(elapsedRealtime)));
    }

    private void d() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        GdtLog.i("GdtDwellTimeStatisticsAfterClick", String.format("leave %d", Long.valueOf(elapsedRealtime)));
        if (this.f109476e == WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
            GdtLog.e("GdtDwellTimeStatisticsAfterClick", "leave error");
        }
        long j3 = elapsedRealtime - this.f109476e;
        GdtLog.i("GdtDwellTimeStatisticsAfterClick", String.format("dwell %d", Long.valueOf(j3)));
        this.f109476e = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        GdtActionReporter.Params params = new GdtActionReporter.Params();
        params.f109471ad = this.f109472a;
        params.data.landing_page_action_type.set(42);
        params.data.latency_ms.set(j3);
        GdtActionReporter.report(params);
    }
}
