package com.tencent.mobileqq.qwallet.home.report;

import android.graphics.Rect;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.report.ReportField;
import com.tencent.mobileqq.qwallet.report.beacon.IQWalletCommonReport;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 \u00052\u00020\u0001:\u0002\u000f\fB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007J\u0010\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0007R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/report/b;", "", "Landroid/view/View;", "view", "", "d", "adView", "", "i", h.F, "g", "isOnPause", "b", "e", "Lcom/tencent/mobileqq/qwallet/home/report/b$a;", "a", "Lcom/tencent/mobileqq/qwallet/home/report/b$a;", "reportBean", "", "J", "lastAdVisibleTime", "c", "Landroid/view/View;", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {

    /* renamed from: a, reason: from kotlin metadata */
    @NotNull
    private final AdClickReportBean reportBean = new AdClickReportBean(0, 0, 3, null);

    /* renamed from: b, reason: from kotlin metadata */
    private long lastAdVisibleTime;

    /* renamed from: c, reason: from kotlin metadata */
    @Nullable
    private View adView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\t\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/report/b$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "d", "(I)V", "visibleIndex", "", "J", "()J", "c", "(J)V", "adTotalTime", "<init>", "(IJ)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.home.report.b$a, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class AdClickReportBean {

        /* renamed from: a, reason: from kotlin metadata and from toString */
        @ReportField(name = "visible_index")
        private int visibleIndex;

        /* renamed from: b, reason: from kotlin metadata and from toString */
        @ReportField(name = "ad_total_time")
        private long adTotalTime;

        public AdClickReportBean() {
            this(0, 0L, 3, null);
        }

        /* renamed from: a, reason: from getter */
        public final long getAdTotalTime() {
            return this.adTotalTime;
        }

        /* renamed from: b, reason: from getter */
        public final int getVisibleIndex() {
            return this.visibleIndex;
        }

        public final void c(long j3) {
            this.adTotalTime = j3;
        }

        public final void d(int i3) {
            this.visibleIndex = i3;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AdClickReportBean)) {
                return false;
            }
            AdClickReportBean adClickReportBean = (AdClickReportBean) other;
            if (this.visibleIndex == adClickReportBean.visibleIndex && this.adTotalTime == adClickReportBean.adTotalTime) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.visibleIndex * 31) + androidx.fragment.app.a.a(this.adTotalTime);
        }

        @NotNull
        public String toString() {
            return "AdClickReportBean(visibleIndex=" + this.visibleIndex + ", adTotalTime=" + this.adTotalTime + ")";
        }

        public AdClickReportBean(int i3, long j3) {
            this.visibleIndex = i3;
            this.adTotalTime = j3;
        }

        public /* synthetic */ AdClickReportBean(int i3, long j3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? 0L : j3);
        }
    }

    public static /* synthetic */ void c(b bVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        bVar.b(z16);
    }

    private final boolean d(View view) {
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect) || rect.top >= ah.y() || rect.right <= 0 || rect.bottom <= 0) {
            return false;
        }
        return true;
    }

    public static final void f(Map retMap) {
        Intrinsics.checkNotNullParameter(retMap, "$retMap");
        ((IQWalletCommonReport) QRoute.api(IQWalletCommonReport.class)).report("e_qwallet_home_ad_click", (Map<String, String>) retMap);
    }

    public final void b(boolean isOnPause) {
        boolean z16;
        View view = this.adView;
        if (view == null) {
            QLog.w("QWalletHomeAdClickReporter", 1, "adView is null");
            return;
        }
        if (view.getVisibility() != 0) {
            QLog.w("QWalletHomeAdClickReporter", 2, "adView is not VISIBLE");
            return;
        }
        boolean d16 = d(view);
        if (d16 && !isOnPause) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("QWalletHomeAdClickReporter", 1, "checkVisibleState " + isOnPause + " " + d16 + " " + z16 + " " + this.lastAdVisibleTime);
        if (z16 && this.lastAdVisibleTime == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.lastAdVisibleTime = currentTimeMillis;
            QLog.i("QWalletHomeAdClickReporter", 1, "start visible at " + currentTimeMillis);
            return;
        }
        if (!z16 && this.lastAdVisibleTime != 0) {
            long currentTimeMillis2 = System.currentTimeMillis() - this.lastAdVisibleTime;
            AdClickReportBean adClickReportBean = this.reportBean;
            adClickReportBean.c(adClickReportBean.getAdTotalTime() + currentTimeMillis2);
            QLog.i("QWalletHomeAdClickReporter", 1, "update adTotalTime " + this.reportBean.getAdTotalTime());
            this.lastAdVisibleTime = 0L;
        }
    }

    public final void e() {
        b(true);
        final Map<String, String> a16 = ml2.d.f416922a.a(this.reportBean);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qwallet.home.report.a
            @Override // java.lang.Runnable
            public final void run() {
                b.f(a16);
            }
        }, 16, null, true);
    }

    public final void g() {
        b(true);
    }

    public final void h() {
        AdClickReportBean adClickReportBean = this.reportBean;
        adClickReportBean.d(adClickReportBean.getVisibleIndex() + 1);
        c(this, false, 1, null);
    }

    public final void i(@Nullable View adView) {
        this.adView = adView;
    }
}
