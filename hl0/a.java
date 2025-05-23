package hl0;

import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.gamecenter.util.b;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static LruCache<String, List<String>> f405236a = new LruCache<>(10);

    public static void a(Map<Integer, String> map, String str) {
        if (map == null) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(str) && b.f213409b != null) {
                List<String> list = f405236a.get(str);
                int i3 = 0;
                if (list != null && list.size() > 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("GameCenterUtils", 1, "get _orted_configs from cache");
                    }
                    while (i3 < list.size()) {
                        map.put(Integer.valueOf(15 + i3), list.get(i3));
                        i3++;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("GameCenterUtils", 1, "get _orted_configs from msg decode");
                }
                String str2 = b.f213409b.get(str + "_orted_configs");
                if (!TextUtils.isEmpty(str2)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("GameCenterUtils", 1, "get _orted_configs from msg decode orted_configs = " + str2);
                    }
                    JSONArray jSONArray = new JSONArray(str2);
                    ArrayList arrayList = new ArrayList();
                    while (i3 < jSONArray.length()) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i3);
                        Iterator keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String optString = jSONObject.optString((String) keys.next());
                            map.put(Integer.valueOf(15 + i3), optString);
                            arrayList.add(i3, optString);
                        }
                        i3++;
                    }
                    f405236a.put(str, arrayList);
                }
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("GameCenterUtils", 1, "get _orted_configs err=" + th5.toString());
            }
            th5.printStackTrace();
        }
    }

    public static void b(AppInterface appInterface, String str, String str2, String str3, String str4, String str5, String str6) {
        c(appInterface, str, str2, str3, str4, str5, str6, null);
    }

    public static void c(AppInterface appInterface, String str, String str2, String str3, String str4, String str5, String str6, Map<Integer, String> map) {
        WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
        wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule(str).setOperId(str2).setGameAppId(str3).setExt(1, str4).setExt(11, str5).setExt(12, str6);
        if (map != null && map.keySet().size() > 0) {
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                wadlReportBuilder.setExt(entry.getKey().intValue(), entry.getValue());
            }
        }
        wadlReportBuilder.report();
    }
}
