package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.VideoReportInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.tvideo.protocol.pb.AdActionField;
import com.tencent.tvideo.protocol.pb.AdOrderItem;
import java.util.HashMap;
import java.util.Map;
import pw2.w;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private gw2.a f304026a;

    /* renamed from: b, reason: collision with root package name */
    protected QAdVrReportParams f304027b;

    /* renamed from: c, reason: collision with root package name */
    protected Map<String, Object> f304028c;

    /* renamed from: d, reason: collision with root package name */
    protected Map<Integer, ew2.a> f304029d = new HashMap();

    public b(@NonNull gw2.a aVar) {
        this.f304026a = aVar;
    }

    private void k() {
        Map<String, Object> map;
        View g16 = g();
        QAdVrReportParams qAdVrReportParams = this.f304027b;
        if (qAdVrReportParams != null) {
            map = qAdVrReportParams.h();
        } else {
            map = null;
        }
        QAdVrReport.a(0, g16, QAdVrReport.ElementID.WHOLE_AD, map);
    }

    protected abstract int a(int i3);

    protected abstract int b(int i3);

    public void c() {
        if (g() == null) {
            return;
        }
        QAdVrReport.h(g(), this.f304027b, this.f304028c);
    }

    public void d() {
        if (g() == null) {
            return;
        }
        QAdVrReport.n(g(), this.f304027b, this.f304028c);
    }

    public abstract ew2.a e(int i3);

    public AdOrderItem f() {
        return this.f304026a.f();
    }

    public View g() {
        return this.f304026a.e();
    }

    protected Map<String, String> h() {
        return gw2.b.b(f());
    }

    protected QAdVrReportParams i() {
        return null;
    }

    public VideoReportInfo j(int i3) {
        if (i3 != 0 && g() != null) {
            return vv2.a.a(g().findViewById(i3), i());
        }
        return null;
    }

    public void l(QAdVrReportParams qAdVrReportParams) {
        if (qAdVrReportParams == null) {
            qAdVrReportParams = new QAdVrReportParams();
        }
        this.f304027b = qAdVrReportParams;
        this.f304027b.g(h());
        k();
    }

    public void m(View view) {
        if (g() == null || this.f304027b == null || f() == null || view == null) {
            return;
        }
        int b16 = b(view.getId());
        ew2.a e16 = e(b16);
        QAdVrReportParams.a e17 = this.f304027b.i().d(a(b16)).e(e16.f397277b);
        if (AdActionField.AD_ACTION_FIELD_POSTER.equals(e16.f397276a)) {
            e17.h(gw2.b.e(f()));
        } else if (AdActionField.AD_ACTION_FIELD_ACTION_BTN.equals(e16.f397276a)) {
            e17.h(gw2.b.a(f()));
        }
        w.l(view, e16.f397278c, null);
        w.n(view, 0);
        Map<String, Object> g16 = w.g(view);
        g16.putAll(e17.i().h());
        QAdVrReport.f(view, g16);
    }
}
