package com.qq.e.comm.plugin.base.ad.e;

import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.net.NetworkClientImpl;
import com.qq.e.comm.net.rr.S2SSRequest;
import com.qq.e.comm.plugin.base.ad.model.l;
import com.qq.e.comm.plugin.k.ag;
import com.qq.e.comm.plugin.k.aj;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final String f38791a = "https://sdkreport.e.qq.com";

    /* renamed from: b, reason: collision with root package name */
    public static final String f38792b = "https://ttc.gdt.qq.com";

    /* renamed from: c, reason: collision with root package name */
    public static final String f38793c;

    /* renamed from: d, reason: collision with root package name */
    private static final String f38794d = "dev";

    static {
        String str;
        StringBuilder sb5 = new StringBuilder();
        if (aj.f()) {
            str = f38792b;
        } else {
            str = f38791a;
        }
        sb5.append(str);
        sb5.append("/xq_msg");
        f38793c = sb5.toString();
    }

    public static void a(int i3, JSONObject jSONObject, l lVar, String str, Map<Integer, String> map) {
        a(i3, jSONObject, lVar, str, map, null);
    }

    public static void a(int i3, JSONObject jSONObject, l lVar, String str, Map<Integer, String> map, String str2) {
        Pair<String, String> taidAndOaidTicket;
        if (GDTADManager.getInstance().getSM().getInteger("sdk_msg_report", 0) != 0) {
            return;
        }
        try {
            JSONObject buildS2SSBaseInfo = GDTADManager.getInstance().buildS2SSBaseInfo();
            if (buildS2SSBaseInfo != null) {
                if ((i3 == 1006 || i3 == 1007) && (taidAndOaidTicket = ((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).getTaidAndOaidTicket()) != null) {
                    buildS2SSBaseInfo.putOpt("td", taidAndOaidTicket.first);
                    buildS2SSBaseInfo.putOpt("od", taidAndOaidTicket.second);
                    if (map == null) {
                        map = new ConcurrentHashMap<>();
                    }
                    map.put(2, String.valueOf(taidAndOaidTicket.first));
                    map.put(1, String.valueOf(taidAndOaidTicket.second));
                }
                com.qq.e.comm.plugin.base.a.a.a().a(map);
                buildS2SSBaseInfo.putOpt(Constants.KEYS.PLCINFO, a(lVar));
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        buildS2SSBaseInfo.putOpt("datasource", Integer.valueOf(Integer.parseInt(str2)));
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("code", Integer.valueOf(i3));
                jSONObject2.putOpt("threadid", str);
                jSONObject2.putOpt("data", jSONObject);
                buildS2SSBaseInfo.put("biz", jSONObject2);
                S2SSRequest s2SSRequest = new S2SSRequest(f38793c, buildS2SSBaseInfo.toString().getBytes(ag.f39619a), true);
                GDTLogger.d("SendMsg2SDKServer: " + buildS2SSBaseInfo.toString());
                NetworkClientImpl.getInstance().submit(s2SSRequest, 3);
                return;
            }
            GDTLogger.e("Fail while build S2SS MSG Info");
        } catch (JSONException e16) {
            GDTLogger.e("Exception while send S2SS MSG", e16);
        }
    }

    public static JSONObject a(l lVar) throws JSONException {
        if (lVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("posid", lVar.a());
        jSONObject.putOpt("adw", Integer.valueOf(lVar.c()));
        jSONObject.putOpt("adh", Integer.valueOf(lVar.d()));
        jSONObject.putOpt("adtype", Integer.valueOf(lVar.b().b()));
        return jSONObject;
    }
}
