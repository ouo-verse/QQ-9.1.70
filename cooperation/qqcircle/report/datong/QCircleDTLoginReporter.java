package cooperation.qqcircle.report.datong;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.qcircle.api.IQCircleInit571ABTestApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.QCircleTABLoginReporter;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.HashMap;
import java.util.Map;
import uq3.c;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleDTLoginReporter {
    private static final String TAG = "QCircleDTLoginReporter";

    public static void daTongLoginReport(String str, HashMap<String, String> hashMap) {
        if (str == null || hashMap == null || TextUtils.equals(hashMap.get("xsj_main_entrance"), QCircleDaTongConstant.ElementParamValue.QQ_MAIN_TAB)) {
            return;
        }
        Map<String, Object> parseSameReportParams = parseSameReportParams(hashMap);
        String str2 = hashMap.get(QCircleSchemeAttr.BaseKey.XSJ_SHORT_SESSION_ID);
        if (TextUtils.isEmpty(str2)) {
            parseSameReportParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        } else {
            parseSameReportParams.put("xsj_session_id", str2);
        }
        executeDaTongLoginReport(parseSameReportParams);
    }

    public static void daTongLoginReportMiddlePage(HashMap<String, String> hashMap, boolean z16) {
        if (hashMap == null) {
            QLog.i(TAG, 1, "daTongLoginReportMiddlePage  attrs == null");
            return;
        }
        if (!c.Y6()) {
            return;
        }
        Map<String, Object> parseSameReportParams = parseSameReportParams(hashMap);
        parseSameReportParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_MIDDLE_PAGE, Boolean.TRUE);
        parseSameReportParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_FIRST_LOGIN, Boolean.valueOf(z16));
        parseSameReportParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        executeDaTongLoginReport(parseSameReportParams);
    }

    public static void doQQVideoDaTongLoginReport(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            QLog.i(TAG, 1, "daTongLoginReportMiddlePage  attrs == null");
            return;
        }
        Map<String, Object> parseSameReportParams = parseSameReportParams(hashMap);
        parseSameReportParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_MIDDLE_PAGE, Boolean.TRUE);
        parseSameReportParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        executeDaTongLoginReport(parseSameReportParams);
    }

    private static void dtAddSchemaAttr(HashMap<String, String> hashMap, Map<String, Object> map) {
        String str;
        if (hashMap == null || map == null || (str = hashMap.get("key_scheme")) == null) {
            return;
        }
        if (str.length() > 500) {
            str = str.substring(0, 500);
        }
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_SCHEMA, str);
    }

    private static void dtLoginAttrResolve(HashMap<String, String> hashMap, Map<String, Object> map, String str, String str2) {
        if (hashMap != null && map != null && !TextUtils.isEmpty(str)) {
            if (hashMap.containsKey(str)) {
                String str3 = hashMap.get(str);
                if (!TextUtils.isEmpty(str3)) {
                    map.put(str, str3);
                    return;
                }
                return;
            }
            if (!TextUtils.isEmpty(str2)) {
                map.put(str, str2);
            }
        }
    }

    public static void executeDaTongLoginReport(Map<String, Object> map) {
        VideoReport.reportEvent(QCircleDaTongConstant.EventId.XSJ_LOGIN, map);
        QCircleTABLoginReporter.reportTABExpExportWhenLogin();
        ((IQCircleInit571ABTestApi) QRoute.api(IQCircleInit571ABTestApi.class)).init571WhenLoginQCircle();
    }

    private static String getDefaultFeedId(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return null;
        }
        return hashMap.get("feedid");
    }

    public static void jointScheme(String str, HashMap<String, String> hashMap) {
        if (!TextUtils.isEmpty(str) && hashMap != null) {
            if (hashMap.containsKey("key_scheme")) {
                QLog.i(TAG, 1, "jointScheme no joint , scheme = " + hashMap.get("key_scheme"));
                return;
            }
            StringBuilder sb5 = new StringBuilder(QCircleScheme.Q_CIRCLE_SCHEME_PREFIX);
            sb5.append(str);
            sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                sb5.append(entry.getKey());
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(entry.getValue());
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb5.deleteCharAt(sb5.toString().length() - 1);
            hashMap.put("key_scheme", sb5.toString());
            QLog.i(TAG, 1, "jointScheme  scheme = " + sb5.toString());
        }
    }

    private static Map<String, Object> parseSameReportParams(HashMap<String, String> hashMap) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PAGE_STACK_NUM, QCircleReportHelper.getQQCirclePageStackNum() + "");
        dtLoginAttrResolve(hashMap, buildElementParams, "xsj_main_entrance", "others");
        dtLoginAttrResolve(hashMap, buildElementParams, "xsj_sub_entrance", "default");
        dtLoginAttrResolve(hashMap, buildElementParams, QCircleDaTongConstant.ElementParamKey.XSJ_AIO_TYPE, null);
        dtLoginAttrResolve(hashMap, buildElementParams, QCircleDaTongConstant.ElementParamKey.XSJ_SHARE_FROM_GROUP_ID, null);
        dtLoginAttrResolve(hashMap, buildElementParams, QCircleDaTongConstant.ElementParamKey.XSJ_FROM_UIN, null);
        dtLoginAttrResolve(hashMap, buildElementParams, QCircleDaTongConstant.ElementParamKey.XSJ_SHARE_CONTENT_HOST, null);
        dtLoginAttrResolve(hashMap, buildElementParams, "xsj_feed_id", getDefaultFeedId(hashMap));
        dtLoginAttrResolve(hashMap, buildElementParams, "xsj_topic_id", null);
        dtLoginAttrResolve(hashMap, buildElementParams, QCircleDaTongConstant.ElementParamKey.XSJ_POI_MSG, null);
        dtLoginAttrResolve(hashMap, buildElementParams, QCircleDaTongConstant.ElementParamKey.XSJ_FILTER_ID, null);
        dtLoginAttrResolve(hashMap, buildElementParams, QCircleDaTongConstant.ElementParamKey.XSJ_PUSH_ID, null);
        dtLoginAttrResolve(hashMap, buildElementParams, QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, null);
        dtLoginAttrResolve(hashMap, buildElementParams, QCircleDaTongConstant.ElementParamKey.XSJ_RED_DOT_MAIN_TYPE, null);
        dtLoginAttrResolve(hashMap, buildElementParams, QCircleDaTongConstant.ElementParamKey.XSJ_RED_DOT_SUB_TYPE, null);
        dtLoginAttrResolve(hashMap, buildElementParams, QCircleDaTongConstant.ElementParamKey.XSJ_PUSH_INTERACTIVE_NUM, null);
        dtLoginAttrResolve(hashMap, buildElementParams, QCircleDaTongConstant.ElementParamKey.XSJ_PUSH_EMOJI, null);
        dtLoginAttrResolve(hashMap, buildElementParams, QCircleDaTongConstant.ElementParamKey.XSJ_LOCK_PUSH_ID, null);
        dtAddSchemaAttr(hashMap, buildElementParams);
        return buildElementParams;
    }
}
