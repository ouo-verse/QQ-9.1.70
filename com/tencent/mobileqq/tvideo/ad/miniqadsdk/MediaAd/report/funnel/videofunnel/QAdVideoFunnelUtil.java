package com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.report.funnel.videofunnel;

import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.QAdVideoHelper;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.report.funnel.videofunnel.funnelconstants.VideoFunnelConstant;
import com.tencent.qqlive.ona.protocol.jce.AdInSideVideoExposureItem;
import com.tencent.qqlive.ona.protocol.jce.AdInsideVideoItem;
import com.tencent.qqlive.ona.protocol.jce.AdOrderItem;
import com.tencent.qqlive.ona.protocol.jce.AdReport;
import cooperation.qzone.remote.ServiceConst;
import gw2.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;
import kt3.j;
import pw2.w;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QAdVideoFunnelUtil {

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public @interface OrderInfoType {
        public static final int ALL_TYPE = 1;
        public static final int EFFECT_TYPE = 3;
        public static final int ORIGIN_TYPE = 2;
    }

    private static void a(StringBuilder sb5, AdOrderItem adOrderItem) {
        b(sb5);
        String k3 = k(adOrderItem);
        if (!TextUtils.isEmpty(k3)) {
            sb5.append(k3);
        }
        q(sb5, Typography.amp);
    }

    private static void b(StringBuilder sb5) {
        c(sb5, "if_replace_rqst", Boolean.FALSE);
    }

    private static void c(StringBuilder sb5, String str, Object obj) {
        sb5.append(str);
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(obj);
        sb5.append(ContainerUtils.FIELD_DELIMITER);
    }

    private static AdOrderItem d(c cVar) {
        AdInsideVideoItem adInsideVideoItem;
        AdOrderItem adOrderItem;
        if (cVar != null && (adInsideVideoItem = cVar.f303589a) != null && (adOrderItem = adInsideVideoItem.orderItem) != null) {
            return adOrderItem;
        }
        return null;
    }

    public static String e(List<c> list) {
        if (list == null) {
            return null;
        }
        return f(list, 0, 1);
    }

    public static String f(List<c> list, int i3, int i16) {
        StringBuilder sb5 = new StringBuilder();
        while (i3 < list.size()) {
            AdOrderItem d16 = d(list.get(i3));
            if ((p(d16, i16) || i16 == 1) && d16 != null) {
                String k3 = k(d16);
                if (!TextUtils.isEmpty(k3)) {
                    sb5.append(k3);
                    sb5.append("#");
                }
            }
            i3++;
        }
        q(sb5, '#');
        return sb5.toString();
    }

    public static String g(int i3, int i16, List<c> list, @OrderInfoType int i17) {
        if (o(d((c) y.d(list, i3)), i16, i17)) {
            i3++;
        }
        return m(i3, list, i17);
    }

    private static Map<String, Object> h(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        for (String str : VideoFunnelConstant.f303666a) {
            Object obj = map.get(str);
            if (obj != null) {
                hashMap.put(str, obj);
            }
        }
        return hashMap;
    }

    public static Map<String, Object> i(j jVar) {
        if (jVar != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("flow_id", jVar.e());
            hashMap.put("ad_play_source", Integer.valueOf(n(jVar)));
            hashMap.put("vid", jVar.i());
            hashMap.put("cid", jVar.d());
            hashMap.put("pid", l(jVar));
            hashMap.put(ServiceConst.PARA_SESSION_ID, jVar.h());
            hashMap.put("pre_vid", jVar.g());
            return hashMap;
        }
        return null;
    }

    public static Map<String, Object> j(View view) {
        Map<String, Object> g16;
        if (view == null || (g16 = w.g(view)) == null || !(g16.get("cur_pg") instanceof Map)) {
            return null;
        }
        return h((Map) g16.get("cur_pg"));
    }

    public static String k(AdOrderItem adOrderItem) {
        Map<String, String> c16 = b.c(adOrderItem);
        if (y.i(c16)) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        for (String str : c16.keySet()) {
            String str2 = c16.get(str);
            if (!TextUtils.isEmpty(str2)) {
                sb5.append(str);
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(str2);
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
        }
        q(sb5, Typography.amp);
        return sb5.toString();
    }

    private static String l(j jVar) {
        Map<String, String> c16 = jVar.c();
        if (c16 != null && c16.containsKey("livepid")) {
            return c16.get("livepid");
        }
        return "";
    }

    private static String m(int i3, List<c> list, @OrderInfoType int i16) {
        StringBuilder sb5 = new StringBuilder();
        while (i3 < list.size()) {
            AdOrderItem d16 = d(list.get(i3));
            if ((p(d16, i16) || i16 == 1) && d16 != null) {
                a(sb5, d16);
                sb5.append("#");
            }
            i3++;
        }
        q(sb5, '#');
        return sb5.toString();
    }

    private static int n(j jVar) {
        if (QAdVideoHelper.g(jVar) == 3) {
            return 2;
        }
        return 1;
    }

    public static boolean o(AdOrderItem adOrderItem, int i3, int i16) {
        ArrayList<AdReport> arrayList;
        if (!p(adOrderItem, i16)) {
            return false;
        }
        if (i16 == 2) {
            arrayList = adOrderItem.exposureItem.originExposureReportList;
        } else {
            arrayList = adOrderItem.exposureItem.exposureReportList;
        }
        if (i3 >= arrayList.size()) {
            return false;
        }
        return true;
    }

    private static boolean p(AdOrderItem adOrderItem, int i3) {
        AdInSideVideoExposureItem adInSideVideoExposureItem;
        ArrayList<AdReport> arrayList;
        ArrayList<AdReport> arrayList2;
        if (adOrderItem == null || (adInSideVideoExposureItem = adOrderItem.exposureItem) == null) {
            return false;
        }
        if (i3 == 2 && (arrayList2 = adInSideVideoExposureItem.originExposureReportList) != null && arrayList2.size() != 0) {
            return true;
        }
        if (i3 != 3 || (arrayList = adInSideVideoExposureItem.exposureReportList) == null || arrayList.size() == 0) {
            return false;
        }
        return true;
    }

    private static void q(StringBuilder sb5, char c16) {
        if (!TextUtils.isEmpty(sb5) && sb5.charAt(sb5.length() - 1) == c16) {
            sb5.deleteCharAt(sb5.length() - 1);
        }
    }
}
