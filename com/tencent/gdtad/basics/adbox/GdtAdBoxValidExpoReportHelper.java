package com.tencent.gdtad.basics.adbox;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import androidx.annotation.Nullable;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivevideo.report.b;
import com.tencent.gdtad.statistics.GdtOriginalExposureReporter;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtAdBoxValidExpoReportHelper {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<Activity> f108675a;

    /* renamed from: b, reason: collision with root package name */
    private List<e> f108676b = Collections.synchronizedList(new ArrayList());

    /* renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<String, Runnable> f108677c = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private final Handler f108678d = ThreadManagerV2.getUIHandlerV2();

    /* renamed from: e, reason: collision with root package name */
    private final com.tencent.gdtad.basics.motivevideo.report.b f108679e = new com.tencent.gdtad.basics.motivevideo.report.b();

    public GdtAdBoxValidExpoReportHelper(WeakReference<Activity> weakReference) {
        this.f108675a = weakReference;
    }

    private void d(final String str, final GdtAd gdtAd, View view, long j3, final boolean z16) {
        final WeakReference weakReference = new WeakReference(view);
        Runnable runnable = new Runnable() { // from class: com.tencent.gdtad.basics.adbox.GdtAdBoxValidExpoReportHelper.3
            @Override // java.lang.Runnable
            public void run() {
                if (z16) {
                    GdtAdBoxValidExpoReportHelper.this.j(str, gdtAd, weakReference);
                } else {
                    GdtAdBoxValidExpoReportHelper.this.h(str, gdtAd, weakReference);
                }
            }
        };
        this.f108678d.postDelayed(runnable, j3);
        k(str, runnable);
    }

    private b.a e(View view) {
        try {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            return new b.a(view.getWidth(), view.getHeight(), iArr[0], iArr[1]);
        } catch (Exception e16) {
            QLog.e("GdtAdBoxValidExpoReportHelper", 1, "gdiReportExposure", e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(AbsListView absListView, long j3, boolean z16) {
        int firstVisiblePosition = absListView.getFirstVisiblePosition();
        int lastVisiblePosition = absListView.getLastVisiblePosition();
        for (int i3 = 0; i3 < absListView.getChildCount(); i3++) {
            View childAt = absListView.getChildAt(i3);
            int positionForView = absListView.getPositionForView(childAt);
            if (positionForView >= firstVisiblePosition && positionForView <= lastVisiblePosition && positionForView < ((ListAdapter) absListView.getAdapter()).getCount() && positionForView < this.f108676b.size()) {
                e eVar = this.f108676b.get(positionForView);
                d(eVar.f108697d, eVar.f108698e, childAt, j3, z16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, GdtAd gdtAd, WeakReference<View> weakReference) {
        if (!i.b().c(str) && i(weakReference.get(), 0.5d)) {
            l(gdtAd, weakReference.get());
            QLog.d("GdtAdBoxValidExpoReportHelper", 2, "impression exposure report itemIdentity: " + str);
            i.b().e(str);
        }
    }

    private static boolean i(View view, double d16) {
        boolean z16;
        if (view == null || !view.isShown()) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (rect.width() * rect.height() > view.getWidth() * view.getHeight() * d16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        Rect rect2 = new Rect();
        view.getWindowVisibleDisplayFrame(rect2);
        return rect2.contains(rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, GdtAd gdtAd, WeakReference<View> weakReference) {
        if (!i.b().d(str) && i(weakReference.get(), 0.05d)) {
            GdtOriginalExposureReporter.reportOriginalExposure(gdtAd, this.f108675a.get());
            QLog.d("GdtAdBoxValidExpoReportHelper", 2, "origin exposure report itemIdentity: " + str);
            i.b().f(str);
        }
    }

    private void k(String str, @Nullable Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.f108677c.put(str, runnable);
    }

    private void l(GdtAd gdtAd, View view) {
        String b16 = this.f108679e.b(gdtAd.getUrlForImpression(), e(view));
        GdtReporter.doCgiReport(b16);
        QLog.d("GdtAdBoxValidExpoReportHelper", 2, "reportImpression exposure report url: " + b16);
    }

    public void g(final AbsListView absListView) {
        Runnable runnable = new Runnable() { // from class: com.tencent.gdtad.basics.adbox.GdtAdBoxValidExpoReportHelper.1
            @Override // java.lang.Runnable
            public void run() {
                GdtAdBoxValidExpoReportHelper.this.f(absListView, 0L, true);
            }
        };
        this.f108678d.postDelayed(runnable, 300L);
        k("identity_gdt_ad_box_origin_expo_report_task", runnable);
        Runnable runnable2 = new Runnable() { // from class: com.tencent.gdtad.basics.adbox.GdtAdBoxValidExpoReportHelper.2
            @Override // java.lang.Runnable
            public void run() {
                GdtAdBoxValidExpoReportHelper.this.f(absListView, 1000L, false);
            }
        };
        this.f108678d.postDelayed(runnable2, 300L);
        k("identity_gdt_ad_box_impression_expo_report_task", runnable2);
    }

    public void m(List<e> list) {
        this.f108676b.clear();
        this.f108676b = list;
    }

    public void n(boolean z16) {
        ArrayList arrayList = new ArrayList(this.f108677c.values());
        this.f108677c.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f108678d.removeCallbacks((Runnable) it.next());
        }
        if (z16) {
            i.b().a();
        }
    }
}
