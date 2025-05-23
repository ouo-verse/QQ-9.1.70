package com.tencent.mobileqq.qcircle.api.constant;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.qcircle.api.IQCircleConfigApi;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public class QCirclePeriodCollect {
    public static final String PERIOD_ENTER_CLICK = "enter_click";
    public static final String PERIOD_FOLDER_CREATE = "folder_create";
    public static final String PERIOD_FOLDER_INIT = "folder_init";
    public static final String PERIOD_FOLDER_LAUNCH = "folder_launch";
    public static final String PERIOD_GET_NEARBY_GPSINFO = "get_nearby_gpsinfo";
    public static final String PERIOD_GET_PAGE_CACHE_RSP = "get_page_cache_rsp";
    public static final String PERIOD_GET_PAGE_NET_RSP = "get_page_net_rsp";
    public static final String PERIOD_GET_TAB_CACHE_RSP = "get_tab_cache_rsp";
    public static final String PERIOD_GET_TAB_NET_RSP = "get_tab_net_rsp";
    public static final String PERIOD_NOTIFY_PAGE_BY_CACHE = "notify_page_by_cache";
    public static final String PERIOD_NOTIFY_PAGE_BY_NET = "notify_page_by_net";
    public static final String PERIOD_PAGE_LOADED = "page_loaded";
    public static final String PERIOD_PLUGIN_LOADED = "plugin_loaded";
    public static final String PERIOD_REQUEST_PAGE_BY_CACHE = "request_page_by_cache";
    public static final String PERIOD_REQUEST_PAGE_BY_NET = "request_page_by_net";
    public static final String PERIOD_REQUEST_TAB = "request_tab";
    public static final String REFER_BOTTOM_TAB = "1";
    public static final String REFER_OTHER = "2";
    public static final String STATE_CACHE = "2";
    public static final String STATE_FAKE_FEED = "8";
    public static final String STATE_FILE_CACHE = "4";
    public static final String STATE_LOAD_MORE_BACK_UP = "9";
    public static final String STATE_NETWORK = "3";
    public static final String STATE_PRELOAD = "1";
    public static final String STATE_RED_POINT_BACK_UP = "7";
    public static final String STATE_REUSE = "6";
    private static final String TAG = "QCirclePeriodCollect";
    private static final ArrayList<Pair<String, Long>> BASE_PERIOD_LIST = new ArrayList<>();
    private static final HashMap<String, TypeParams> TYPE_PARAM_MAP = new HashMap<>();
    private static final HashMap<String, Boolean> TYPE_PERIOD_COLLECT_FINISH_MAP = new HashMap<>();
    private static boolean sEnableCollect = false;
    private static String sRefer = "1";
    private static long sStartTimeStamp = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class TypeParams {
        private final String type;
        private String state = "";
        private boolean hasRecordRealLoad = false;
        private boolean isPurelyMemCache = false;
        private final ArrayList<Pair<String, Long>> mPeriodList = new ArrayList<>();

        public TypeParams(String str) {
            this.type = str;
        }

        boolean filterPageLoaded(String str) {
            if (str.equals(QCirclePeriodCollect.PERIOD_PAGE_LOADED)) {
                if (this.hasRecordRealLoad) {
                    return true;
                }
                this.hasRecordRealLoad = true;
                return false;
            }
            return false;
        }

        public void record(String str) {
            if (QCirclePeriodCollect.access$200() || filterPageLoaded(str)) {
                return;
            }
            Pair<String, Long> pair = new Pair<>(str, Long.valueOf(System.currentTimeMillis()));
            this.mPeriodList.add(pair);
            QLog.d(QCirclePeriodCollect.TAG, 1, "record type:" + this.type + ",period:" + ((String) pair.first) + ",start :" + pair.second + ",cost:" + (((Long) pair.second).longValue() - QCirclePeriodCollect.sStartTimeStamp) + "ms");
        }

        public void setState(String str) {
            if (!TextUtils.isEmpty(this.state)) {
                return;
            }
            this.state = str;
            QLog.d(QCirclePeriodCollect.TAG, 1, "setState type: ", this.type, ",state: " + this.state);
        }
    }

    static {
        initEnablePeriodCollect();
    }

    static /* synthetic */ boolean access$200() {
        return pass();
    }

    public static void flushPeriodReport(String str, String str2) {
        long j3;
        if (pass()) {
            return;
        }
        if (hasFlushed(str)) {
            QLog.e(TAG, 1, "flushPeriodReport hasFlushed type: ", str);
            return;
        }
        if (!shouldFlushNow(str, str2)) {
            QLog.e(TAG, 1, "flushPeriodReport should not flush now period: ", str2);
            return;
        }
        TYPE_PERIOD_COLLECT_FINISH_MAP.put(str, Boolean.TRUE);
        String state = getState(str);
        String periodStr = getPeriodStr(str);
        if (periodStr.contains(PERIOD_PAGE_LOADED)) {
            j3 = System.currentTimeMillis() - sStartTimeStamp;
        } else {
            j3 = 0;
        }
        QLog.d(TAG, 1, "flushPeriodReport ", "type: ", str, ",state: ", state, ",period: ", str2, ",duration:", Long.valueOf(j3), "ms");
        ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).reportLaunchPeriodEvent(new QCircleAlphaUserReportDataBuilder().setType(str).setState(state).setRefer(sRefer).setAttachInfo(periodStr).setTimeCost(j3));
    }

    public static String getPeriodStr(String str) {
        ArrayList arrayList = new ArrayList(BASE_PERIOD_LIST);
        TypeParams typeParams = TYPE_PARAM_MAP.get(str);
        if (typeParams != null) {
            arrayList.addAll(typeParams.mPeriodList);
        }
        JSONObject jSONObject = new JSONObject();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (pair != null) {
                try {
                    jSONObject.put((String) pair.first, pair.second);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        }
        return jSONObject.toString();
    }

    private static String getState(String str) {
        TypeParams typeParams = TYPE_PARAM_MAP.get(str);
        if (typeParams != null) {
            return typeParams.state;
        }
        return "";
    }

    private static boolean hasFlushed(String str) {
        Boolean bool = TYPE_PERIOD_COLLECT_FINISH_MAP.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private static void initEnablePeriodCollect() {
        String str;
        sEnableCollect = QCircleHostConfig.getEnablePeriodCollect();
        if (((IQCircleConfigApi) QRoute.api(IQCircleConfigApi.class)).isShowQQCircleMainTabEntrance()) {
            str = "1";
        } else {
            str = "2";
        }
        sRefer = str;
        QLog.d(TAG, 1, "initEnablePeriodCollect value:" + sEnableCollect);
    }

    private static boolean pass() {
        return !sEnableCollect;
    }

    public static void record(String str) {
        if (pass()) {
            return;
        }
        if (PERIOD_ENTER_CLICK.equals(str)) {
            reset();
        }
        Pair<String, Long> pair = new Pair<>(str, Long.valueOf(System.currentTimeMillis()));
        BASE_PERIOD_LIST.add(pair);
        QLog.d(TAG, 1, "record period:" + ((String) pair.first) + ",start :" + pair.second + ",cost:" + (((Long) pair.second).longValue() - sStartTimeStamp) + "ms");
    }

    private static void reset() {
        sStartTimeStamp = System.currentTimeMillis();
        BASE_PERIOD_LIST.clear();
        TYPE_PARAM_MAP.clear();
        TYPE_PERIOD_COLLECT_FINISH_MAP.clear();
    }

    public static void setEnableCollect(boolean z16) {
        sEnableCollect = z16;
        QLog.d(TAG, 1, "setEnableCollect value:" + z16);
    }

    public static void setState(String str, String str2) {
        TypeParams typeParams;
        QCircleFolderFunnelCollect.setState(str, str2);
        if (!pass() && (typeParams = TYPE_PARAM_MAP.get(str)) != null) {
            typeParams.setState(str2);
        }
    }

    private static boolean shouldFlushNow(String str, String str2) {
        if (getState(str).equals("2")) {
            return PERIOD_NOTIFY_PAGE_BY_CACHE.equals(str2);
        }
        return PERIOD_NOTIFY_PAGE_BY_NET.equals(str2);
    }

    public static void record(String str, String str2) {
        if (pass() || TextUtils.isEmpty(str)) {
            return;
        }
        HashMap<String, TypeParams> hashMap = TYPE_PARAM_MAP;
        if (!hashMap.containsKey(str)) {
            hashMap.put(str, new TypeParams(str));
        }
        TypeParams typeParams = hashMap.get(str);
        if (typeParams != null) {
            typeParams.record(str2);
        }
    }
}
