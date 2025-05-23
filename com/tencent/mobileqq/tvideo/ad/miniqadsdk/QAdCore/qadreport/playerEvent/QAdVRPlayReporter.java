package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.vr.IVRPlayReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.QAdThreadManager;
import com.tencent.qqlive.ona.protocol.jce.AdReport;
import com.tencent.tvideo.protocol.pb.AdOrderItem;
import com.tencent.tvideo.protocol.pb.AdReportType;
import java.util.Map;
import pw2.n;
import pw2.w;
import pw2.y;

/* loaded from: classes19.dex */
public abstract class QAdVRPlayReporter implements d {

    /* renamed from: a, reason: collision with root package name */
    protected String f304087a;

    /* renamed from: b, reason: collision with root package name */
    protected String f304088b;

    /* renamed from: c, reason: collision with root package name */
    protected String f304089c;

    /* renamed from: d, reason: collision with root package name */
    protected String f304090d;

    /* renamed from: e, reason: collision with root package name */
    protected AdReport f304091e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f304092f;

    /* renamed from: g, reason: collision with root package name */
    protected Map<String, String> f304093g;

    public QAdVRPlayReporter(AdOrderItem adOrderItem) {
        n(adOrderItem);
    }

    private IVRPlayReport c(@NonNull f fVar) {
        n.e("QAdVRPlayReporter", "createVRPlayReport, event.extraVRParams=" + fVar.f304105f + ";mVRPlayReportParams=" + this.f304093g);
        if (!y.i(fVar.f304105f) && !y.i(this.f304093g)) {
            return com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.vr.a.a(fVar, this.f304093g);
        }
        return null;
    }

    private void f(f fVar) {
        if (this.f304092f) {
            o(4, fVar);
            this.f304092f = false;
        }
    }

    private void g(f fVar) {
        o(6, fVar);
    }

    private void h(f fVar) {
        o(15, fVar);
    }

    private void i(f fVar) {
        o(10, fVar);
    }

    private void j(f fVar) {
        o(2, fVar);
    }

    private void k(f fVar) {
        o(5, fVar);
        this.f304092f = true;
    }

    private void l(f fVar) {
        o(3, fVar);
        this.f304092f = true;
    }

    private void m(f fVar) {
        Map<String, ?> map;
        o(1, fVar);
        if (this.f304091e != null && (map = fVar.f304105f) != null && map.containsKey("is_auto_play") && "1".equals(fVar.f304105f.get("is_auto_play"))) {
            d(7, fVar);
        }
        this.f304092f = true;
    }

    private void n(AdOrderItem adOrderItem) {
        String str;
        if (adOrderItem == null) {
            return;
        }
        this.f304087a = adOrderItem.order_id;
        this.f304089c = adOrderItem.ad_report_key;
        this.f304090d = adOrderItem.ad_report_param;
        AdReportType adReportType = AdReportType.AD_REPORT_TYPE_PLAY_BACK;
        this.f304091e = kw2.b.a(adOrderItem, adReportType);
        Map<String, String> c16 = kw2.b.c(adOrderItem, adReportType);
        if (c16 != null) {
            str = c16.get("__SEQ__");
        } else {
            str = "";
        }
        this.f304088b = str;
        this.f304093g = QAdVrReport.c(adOrderItem);
    }

    private void o(final int i3, @NonNull final f fVar) {
        if (this.f304091e == null) {
            return;
        }
        QAdThreadManager.INSTANCE.execTask(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.QAdVRPlayReporter.1
            @Override // java.lang.Runnable
            public void run() {
                QAdVRPlayReporter.this.d(i3, fVar);
                QAdVRPlayReporter.this.e(i3, fVar);
            }
        });
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.d
    @CallSuper
    public void a(f fVar) {
        if (fVar == null) {
            return;
        }
        int i3 = fVar.f304100a;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 != 8) {
                                if (i3 != 9) {
                                    if (i3 == 15) {
                                        h(fVar);
                                        return;
                                    }
                                    return;
                                }
                                i(fVar);
                                return;
                            }
                            k(fVar);
                            return;
                        }
                        g(fVar);
                        return;
                    }
                    f(fVar);
                    return;
                }
                l(fVar);
                return;
            }
            j(fVar);
            return;
        }
        m(fVar);
    }

    protected abstract void d(int i3, @NonNull f fVar);

    protected void e(int i3, @NonNull f fVar) {
        IVRPlayReport c16 = c(fVar);
        n.a("QAdVRPlayReporter", "doVRPlayReport, vrPlayReport=" + c16);
        if (c16 != null) {
            w.i(c16.getReportKey(), c16.getReportParams());
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.d
    public void b(f fVar) {
    }
}
