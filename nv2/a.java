package nv2;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdConfigDefine$VersionDefine;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadutils.QAdDeviceUtils;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Marker;
import ow2.c;
import pw2.n;
import qv2.b;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    public static String a(String str) {
        HashMap<String, String> f16 = f();
        if (!TextUtils.isEmpty(str)) {
            f16.put("requestid", str);
        }
        return c(f16);
    }

    private static void b(HashMap<String, String> hashMap) {
        hashMap.put(AdParam.OPENUDID, QAdDeviceUtils.o());
        hashMap.put(AdParam.HWMACHINE, QAdDeviceUtils.g());
        hashMap.put(AdParam.HWMODEL, QAdDeviceUtils.h());
        hashMap.put(AdParam.BRANDS, QAdDeviceUtils.b());
        hashMap.put("chid", ov2.a.b().a());
        hashMap.put(AdParam.PF, QAdConfigDefine$VersionDefine.K_QAD_PF);
        hashMap.put(AdParam.OSVERSION, QAdDeviceUtils.p());
        hashMap.put("appname", "\u624bQ");
        hashMap.put("androidid", QAdDeviceUtils.a());
        hashMap.put(AdParam.ROUTERMACADDRESS, QAdDeviceUtils.i());
        hashMap.put("qimei36", b.b().c());
    }

    public static String c(Map<String, String> map) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        if (map != null && map.size() != 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null) {
                    if (TextUtils.isEmpty(entry.getValue())) {
                        str = "";
                        sb5.append(entry.getKey());
                        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                        sb5.append(str);
                        sb5.append(ContainerUtils.FIELD_DELIMITER);
                    } else {
                        str = URLEncoder.encode(entry.getValue(), "UTF-8").replace(Marker.ANY_NON_NULL_MARKER, "%20");
                        sb5.append(entry.getKey());
                        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                        sb5.append(str);
                        sb5.append(ContainerUtils.FIELD_DELIMITER);
                    }
                }
            }
            if (sb5.length() > 0) {
                sb5.deleteCharAt(sb5.length() - 1);
            }
            return qv2.a.b(sb5.toString());
        }
        return sb5.toString();
    }

    private static void d(HashMap<String, String> hashMap, c cVar) {
        if (cVar != null && !TextUtils.isEmpty(cVar.a())) {
            hashMap.put(AdParam.NETSTATUS, cVar.a());
        } else {
            hashMap.put(AdParam.NETSTATUS, QAdDeviceUtils.j());
        }
        hashMap.put("mid", lv2.a.b().c());
        hashMap.put("omgid", lv2.a.b().e());
        hashMap.put("omgbizid", lv2.a.b().d());
        hashMap.putAll(e());
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("guid", lv2.a.b().a());
    }

    private static HashMap<String, String> e() {
        HashMap<String, String> hashMap = new HashMap<>();
        if (!TextUtils.isEmpty(lv2.b.c().g())) {
            hashMap.put("qq", lv2.b.c().g());
        }
        if (!TextUtils.isEmpty(lv2.b.c().f())) {
            hashMap.put("qqopenid", lv2.b.c().f());
        }
        if (!TextUtils.isEmpty(lv2.b.c().d())) {
            hashMap.put("openid", lv2.b.c().d());
        } else if (!TextUtils.isEmpty(lv2.b.c().h())) {
            hashMap.put("openid", lv2.b.c().h());
        }
        if (!TextUtils.isEmpty(lv2.b.c().e())) {
            hashMap.put("qqappid", lv2.b.c().e());
        }
        if (!TextUtils.isEmpty(lv2.b.c().a())) {
            hashMap.put("appid", lv2.b.c().a());
        }
        if (!TextUtils.isEmpty(lv2.b.c().b())) {
            hashMap.put(AdParam.CONSUMERID, lv2.b.c().b());
        }
        return hashMap;
    }

    public static HashMap<String, String> f() {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            b(hashMap);
            d(hashMap, null);
            return hashMap;
        } catch (Throwable th5) {
            n.b("QADAdxEncryDataUtils", "getUserMap error, msg=" + th5.getLocalizedMessage());
            return new HashMap<>(0);
        }
    }
}
