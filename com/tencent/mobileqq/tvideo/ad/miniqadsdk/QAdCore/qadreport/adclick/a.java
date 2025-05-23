package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adclick;

import androidx.annotation.NonNull;
import com.tencent.qqlive.ona.protocol.jce.AdReport;
import com.tencent.tvideo.protocol.pb.AdAction;
import com.tencent.tvideo.protocol.pb.AdActionType;
import com.tencent.tvideo.protocol.pb.AdExtraReportItem;
import com.tencent.tvideo.protocol.pb.AdOrderItem;
import kw2.c;
import pw2.n;
import pw2.p;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    public static void a(@NonNull b bVar) {
        boolean z16;
        int i3;
        AdAction u16 = bVar.u();
        AdOrderItem v3 = bVar.v();
        String F = bVar.F();
        int x16 = bVar.x();
        int D = bVar.D();
        boolean L = bVar.L();
        if (bVar.z() == 13) {
            z16 = true;
        } else {
            z16 = false;
        }
        wv2.a c16 = c.c(v3, u16, F, x16, 1, D, L, z16, bVar.I());
        c16.f446589y = bVar.M();
        c16.C = bVar.w();
        c16.f446584t = bVar.K();
        c16.G = bVar.t();
        c16.f446579o = bVar.N();
        c16.H = bVar.B();
        c16.I = bVar.J();
        c16.J = bVar.G();
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.b a16 = wv2.b.a(c16, bVar.y());
        boolean b16 = b(c16, a16, bVar);
        String a17 = nv2.a.a(bVar.F());
        AdOrderItem v16 = bVar.v();
        int D2 = bVar.D();
        if (b16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        QAdStandardClickReportInfo G = QAdStandardClickReportInfo.G(v16, u16, D2, i3, bVar.A(), a17, bVar.C());
        if (G != null) {
            G.B = bVar.H();
            AdReport adReport = G.f304048a;
            if (adReport != null) {
                c16.f446588x = adReport.headerInfo;
            }
            d(G, bVar, c16);
        }
        if (G != null && a16 != null) {
            G.w(c(bVar.v()));
            a16.i(new com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.c(bVar.v()));
            a16.c(G, null);
            n.e("QAdClickHandler", "[CLICK] \u6267\u884c\u70b9\u51fb\u4e8b\u4ef6");
        }
    }

    private static boolean b(wv2.a aVar, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.b bVar, @NonNull b bVar2) {
        if ((aVar.f446568d && (bVar instanceof xv2.a) && bVar2.L()) || (aVar.f446568d && (bVar instanceof cw2.c))) {
            return true;
        }
        return false;
    }

    private static boolean c(AdOrderItem adOrderItem) {
        AdExtraReportItem adExtraReportItem;
        if (adOrderItem != null && (adExtraReportItem = adOrderItem.extra_report_param) != null && p.d(Boolean.valueOf(adExtraReportItem.need_retry_report))) {
            return true;
        }
        return false;
    }

    private static void d(QAdStandardClickReportInfo qAdStandardClickReportInfo, b bVar, wv2.a aVar) {
        int value;
        AdActionType adActionType;
        qAdStandardClickReportInfo.M(bVar.E());
        AdAction u16 = bVar.u();
        if (u16 != null && (adActionType = u16.action_type) != null) {
            value = adActionType.getValue();
        } else {
            value = AdActionType.AD_ACTION_TYPE_UNKNOWN.getValue();
        }
        qAdStandardClickReportInfo.H(value);
        qAdStandardClickReportInfo.L(aVar.f446581q);
    }
}
