package cw2;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadutils.SpaEffectReportActionKey;
import com.tencent.qqlive.ona.protocol.jce.AdOrderItem;
import ew2.e;
import java.util.HashMap;
import java.util.Map;
import pw2.n;
import pw2.x;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Integer, String> f391990a;

    static {
        HashMap hashMap = new HashMap();
        f391990a = hashMap;
        hashMap.put(8, SpaEffectReportActionKey.ID_LAUNCH_FROM_CONFIRM_SUCC);
        hashMap.put(7, SpaEffectReportActionKey.ID_LAUNCH_FROM_CONFIRM);
        hashMap.put(6, SpaEffectReportActionKey.ID_DISMISS_FROM_CONFIRM);
        hashMap.put(19, SpaEffectReportActionKey.ID_LAUNCH_FROM_APP);
        hashMap.put(27, SpaEffectReportActionKey.ID_LAUNCH_FROM_APP_DIRECT_TRY_XS);
        hashMap.put(28, SpaEffectReportActionKey.ID_LAUNCH_FROM_APP_DIRECT_SUCC_XS);
        hashMap.put(29, SpaEffectReportActionKey.ID_LAUNCH_FROM_APP_DIRECT_FAIL_XS);
        hashMap.put(30, SpaEffectReportActionKey.ID_LAUNCH_FROM_APP_LANDINGPAGE_XS);
        hashMap.put(34, SpaEffectReportActionKey.ID_TRY_OPEN_HAP_APP_XS);
        hashMap.put(35, SpaEffectReportActionKey.ID_OPEN_HAP_APP_SUCC_XS);
        hashMap.put(36, SpaEffectReportActionKey.ID_OPEN_HAP_APP_FAIL_XS);
    }

    public static e a(AdOrderItem adOrderItem, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.a aVar) {
        String str;
        if (adOrderItem == null || aVar == null) {
            return null;
        }
        n.a("ActionHandlerHandlerUtils", "[SPA][EffectReport:jce] orderID:" + adOrderItem.orderId + " eventID:" + aVar.a());
        if (aVar.b() != null && !(aVar.b() instanceof ew2.c)) {
            return null;
        }
        if (aVar.b() != null) {
            str = ((ew2.c) aVar.b()).f397280b;
        } else {
            str = null;
        }
        String c16 = c(aVar.a());
        n.a("ActionHandlerHandlerUtils", "[SPA][EffectReport] orderID:" + adOrderItem.orderId + " actionID:" + c16 + " clickID:" + str);
        if ("0".equals(c16)) {
            return null;
        }
        return e.E(adOrderItem, c16, str);
    }

    public static e b(com.tencent.tvideo.protocol.pb.AdOrderItem adOrderItem, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.a aVar) {
        String str;
        if (adOrderItem == null || aVar == null) {
            return null;
        }
        n.a("ActionHandlerHandlerUtils", "[SPA][EffectReport:pb] orderID:" + adOrderItem.order_id + " eventID:" + aVar.a());
        if (aVar.b() != null && !(aVar.b() instanceof ew2.c)) {
            return null;
        }
        if (aVar.b() != null) {
            str = ((ew2.c) aVar.b()).f397280b;
        } else {
            str = null;
        }
        String c16 = c(aVar.a());
        n.a("ActionHandlerHandlerUtils", "[SPA][EffectReport] orderID:" + adOrderItem.order_id + " actionID:" + c16 + " clickID:" + str);
        if ("0".equals(c16)) {
            return null;
        }
        return e.G(adOrderItem, c16, str);
    }

    public static String c(int i3) {
        return x.a(f391990a.get(Integer.valueOf(i3)));
    }
}
