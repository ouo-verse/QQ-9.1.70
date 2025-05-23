package cooperation.qzone.report.datong;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.adapter.a;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.utils.JsonUtils;
import com.tencent.qzonehub.api.IQZonePageApi;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QZoneDTLoginReporter {
    public static final String EV_BAS_SPACE_LOGIN = "ev_bas_space_login";
    public static final String KEY_APP_ID = "appid";
    public static final String KEY_APP_NAME = "appname";
    public static final String LOGIN_FROM = "login_from";
    public static final String LOGIN_FROM_EXTRA = "login_from_extra";
    public static final String PAGE_STYLE = "page_style";
    public static final int PAGE_STYLE_DEFAULT = 0;
    public static final int PAGE_STYLE_PRO = 1;
    public static final String QUA = "qua";
    public static final String SCHEMA = "schema";
    public static final String TAG = "QZoneDTLoginReporter";
    public static final String TOUIN = "touin";

    public static void daTongLoginReport(int i3) {
        dtLoginReport(i3, null);
    }

    public static void dtLoginReport(int i3, Map<String, Object> map) {
        Map<String, Object> buildElementParams = new QZoneDTParamBuilder().buildElementParams();
        if (map != null && !map.isEmpty()) {
            buildElementParams.putAll(map);
        }
        buildElementParams.put(LOGIN_FROM, Integer.valueOf(i3));
        buildElementParams.put("qua", a.f().i());
        if (((IQZonePageApi) QRoute.api(IQZonePageApi.class)).isQzoneFeedProPage()) {
            buildElementParams.put(PAGE_STYLE, 1);
        } else {
            buildElementParams.put(PAGE_STYLE, 0);
        }
        VideoReport.reportEvent(EV_BAS_SPACE_LOGIN, buildElementParams);
    }

    public static void daTongLoginReport(int i3, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("touin", str);
        dtLoginReport(i3, hashMap);
    }

    public static void daTongLoginReport(int i3, long j3, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("appid", Long.valueOf(j3));
        hashMap.put("appname", str);
        String jsonFromMap = JsonUtils.getJsonFromMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(LOGIN_FROM_EXTRA, jsonFromMap);
        dtLoginReport(i3, hashMap2);
    }

    public static void daTongLoginReport(int i3, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("touin", str2);
        hashMap.put(SCHEMA, str);
        dtLoginReport(i3, hashMap);
    }
}
