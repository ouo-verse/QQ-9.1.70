package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import java.util.Map;
import pw2.w;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {
    private static void a(Context context, QAdVrReportParams qAdVrReportParams) {
        if (qAdVrReportParams != null && !qAdVrReportParams.c(QAdVrReportParams.ParamKey.IS_FULLSCREEN)) {
            qAdVrReportParams.f(QAdVrReportParams.ParamKey.IS_FULLSCREEN, g(context));
        }
    }

    public static void b(Object obj, View view, String str, QAdVrReportParams qAdVrReportParams, boolean z16) {
        if (view == null) {
            return;
        }
        if (qAdVrReportParams == null) {
            qAdVrReportParams = new QAdVrReportParams().i().i();
        }
        a(view.getContext(), qAdVrReportParams);
        qAdVrReportParams.g(gw2.b.b(obj));
        if (z16) {
            QAdVrReport.g(view, qAdVrReportParams, str);
        } else {
            QAdVrReport.m(view, qAdVrReportParams, str);
        }
    }

    public static void c(Object obj, View view, String str, QAdVrReportParams qAdVrReportParams) {
        if (view == null) {
            return;
        }
        if (qAdVrReportParams == null) {
            qAdVrReportParams = new QAdVrReportParams().i().i();
        }
        a(view.getContext(), qAdVrReportParams);
        qAdVrReportParams.g(f(obj, str));
        w.l(view, str, null);
        QAdVrReport.f(view, qAdVrReportParams.h());
    }

    public static void d(Object obj, View view, String str, QAdVrReportParams qAdVrReportParams) {
        b(obj, view, str, qAdVrReportParams, true);
    }

    public static void e(Object obj, View view, String str, QAdVrReportParams qAdVrReportParams) {
        b(obj, view, str, qAdVrReportParams, false);
    }

    public static Map<String, String> f(Object obj, String str) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1359893700:
                if (str.equals(QAdVrReport.ElementID.AD_TITLE)) {
                    c16 = 0;
                    break;
                }
                break;
            case -1152608132:
                if (str.equals(QAdVrReport.ElementID.AD_HEAD)) {
                    c16 = 1;
                    break;
                }
                break;
            case -1152432857:
                if (str.equals(QAdVrReport.ElementID.AD_NAME)) {
                    c16 = 2;
                    break;
                }
                break;
            case -1152274405:
                if (str.equals(QAdVrReport.ElementID.SKIP_BUTTON)) {
                    c16 = 3;
                    break;
                }
                break;
            case -982450867:
                if (str.equals(QAdVrReport.ElementID.AD_POSTER)) {
                    c16 = 4;
                    break;
                }
                break;
            case 243470802:
                if (str.equals(QAdVrReport.ElementID.AD_ACTION_BTN)) {
                    c16 = 5;
                    break;
                }
                break;
            case 2132047752:
                if (str.equals(QAdVrReport.ElementID.AD_POSTER_RELATIVE)) {
                    c16 = 6;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
            case 1:
            case 2:
            case 4:
            case 6:
                return gw2.b.e(obj);
            case 3:
                return gw2.b.f(obj);
            case 5:
                return gw2.b.a(obj);
            default:
                return gw2.b.b(obj);
        }
    }

    public static String g(Context context) {
        boolean z16;
        if (context != null) {
            z16 = y.k(context);
        } else {
            z16 = false;
        }
        if (z16) {
            return "1";
        }
        return "0";
    }
}
