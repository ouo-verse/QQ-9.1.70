package kw2;

import android.text.TextUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.VideoReportInfo;
import com.tencent.qqlive.ona.protocol.jce.AdActionItem;
import com.tencent.tvideo.protocol.pb.AdAction;
import com.tencent.tvideo.protocol.pb.AdOrderItem;
import com.tencent.tvideo.protocol.pb.AdReport;
import com.tencent.tvideo.protocol.pb.AdReportType;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {
    private static boolean a(int i3) {
        if (i3 != 1025 && i3 != 1026 && i3 != 1021 && i3 != 1023 && i3 != 1031 && i3 != 1030 && i3 != 1032) {
            return false;
        }
        return true;
    }

    private static boolean b(int i3, int i16) {
        if (i3 != 5 && !a(i16)) {
            return false;
        }
        return true;
    }

    public static wv2.a c(AdOrderItem adOrderItem, AdAction adAction, String str, int i3, int i16, int i17, boolean z16, boolean z17, VideoReportInfo videoReportInfo) {
        boolean z18;
        wv2.a aVar = new wv2.a();
        if (adOrderItem != null && adAction != null) {
            com.tencent.qqlive.ona.protocol.jce.AdAction adAction2 = (com.tencent.qqlive.ona.protocol.jce.AdAction) a.b().a(adAction);
            AdActionItem adActionItem = adAction2.actionItem;
            aVar.f446565a = adActionItem;
            aVar.f446581q = adAction2.pageType;
            aVar.f446566b = adAction2.actionType;
            aVar.f446571g = i3;
            String str2 = adOrderItem.order_id;
            aVar.f446567c = str2;
            aVar.f446573i = str2;
            aVar.f446575k = str;
            aVar.f446570f = i16;
            aVar.f446572h = i17;
            aVar.f446577m = z16;
            boolean z19 = false;
            if (adActionItem != null && adActionItem.parseType == 1) {
                z18 = true;
            } else {
                z18 = false;
            }
            aVar.f446568d = z18;
            if (!z18 || !b(i16, i17)) {
                z19 = true;
            }
            aVar.f446578n = z19;
            aVar.f446569e = b.a(adOrderItem, AdReportType.AD_REPORT_TYPE_EFFECT);
            aVar.B = z17;
            aVar.K = true;
            aVar.E = videoReportInfo;
            aVar.F = adOrderItem.vr_report_dict;
            AdReport b16 = b.b(adOrderItem, AdReportType.AD_REPORT_TYPE_CLICK);
            if (b16 != null && !TextUtils.isEmpty(b16.header_info)) {
                aVar.f446588x = b16.header_info;
            }
        }
        return aVar;
    }
}
