package com.tencent.mobileqq.winkreport.datong;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.qwallet.preload.IPreloadResource;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes21.dex */
public class WinkDTParamBuilder {
    public static String APP_KEY = "00000QG6YX3X0LZH";
    public static String APP_KEY_NAME = "app_key";
    public static String KEY_ATTRS = "key_attrs";
    public static final String PUBLIC_MAIN_APP_KEY = "0S200MNJT807V3GE";
    private static final String TAG = "WinkDTParamBuilder";
    public static final String WINK_APP_KEY = "00000QG6YX3X0LZH";

    private static void addTemplateLibCommonParams(Map<String, Object> map) {
        Object obj = WinkDatongCurrentParams.get("xsj_operation_activity_id");
        if (obj != null) {
            map.put("xsj_operation_activity_id", obj);
        }
        Object obj2 = WinkDatongCurrentParams.get("xsj_resource_type");
        if (obj2 != null && !"".equals(obj2)) {
            map.put("xsj_resource_type", obj2);
        }
        Object obj3 = WinkDatongCurrentParams.get("xsj_template_id");
        if (obj3 != null) {
            map.put("xsj_template_id", obj3);
        }
        Object obj4 = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_MODE);
        if (obj4 != null) {
            map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_MODE, obj4);
        }
        Object obj5 = WinkDatongCurrentParams.get("xsj_tianshu_task_id");
        if (obj5 != null) {
            map.put("xsj_tianshu_task_id", obj5);
        }
        Object obj6 = WinkDatongCurrentParams.get("xsj_publish_location");
        if (obj6 != null) {
            map.put("xsj_publish_location", obj6);
        }
        Object obj7 = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_MEMORIES_ALBUM_ID);
        if (obj7 != null) {
            map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MEMORIES_ALBUM_ID, obj7);
        }
        map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_APP_OS, IPreloadResource.ABI_64);
    }

    private static void addTransferParams(Map<String, Object> map) {
        try {
            if (WinkDatongCurrentParams.contains(WinkDaTongReportConstant.ElementParamKey.XSJ_TRANSF_PARAMS)) {
                for (String str : ((String) WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_TRANSF_PARAMS)).split(",")) {
                    if (!TextUtils.isEmpty(str)) {
                        String[] split = str.split("@");
                        if (split.length == 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                            map.put(split[0], split[1]);
                        }
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    public static Map<String, Object> buildElementParams() {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, APP_KEY);
        hashMap.put("xsj_session_id", WinkNativeSessionManager.g().getSessionId());
        addTemplateLibCommonParams(hashMap);
        return hashMap;
    }

    public static Map<String, Object> buildMainAppElementParams() {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        return hashMap;
    }

    public static void setDtParams(Intent intent) {
        if (intent != null) {
            HashMap hashMap = (HashMap) intent.getSerializableExtra(KEY_ATTRS);
            String stringExtra = intent.getStringExtra(APP_KEY_NAME);
            if (TextUtils.isEmpty(stringExtra) && hashMap != null) {
                stringExtra = (String) hashMap.get(APP_KEY_NAME);
            }
            if (!TextUtils.isEmpty(stringExtra)) {
                APP_KEY = stringExtra;
            }
            String str = (String) WinkDatongCurrentParams.params.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID);
            if (TextUtils.isEmpty(str) || "".equals(str)) {
                String stringExtra2 = intent.getStringExtra("xsj_ref_pgid");
                if (TextUtils.isEmpty(stringExtra2) && hashMap != null) {
                    stringExtra2 = (String) hashMap.get("xsj_ref_pgid");
                }
                if (!TextUtils.isEmpty(stringExtra2)) {
                    WinkDatongCurrentParams.params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID, stringExtra2);
                }
            }
        }
    }

    public PageParams buildPageParams(Map<String, Object> map, String str) {
        HashMap hashMap = new HashMap();
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        QLog.i(TAG, 1, "[buildPageParams] cameraSessionId: " + str);
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, APP_KEY);
        hashMap.put("xsj_session_id", WinkNativeSessionManager.g().getSessionId());
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_SESSION_ID, str);
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_TYPE, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_TYPE));
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_ID, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_ID));
        hashMap.put("xsj_operation_activity_id", WinkDatongCurrentParams.get("xsj_operation_activity_id"));
        if (!hashMap.containsKey("xsj_topic_id")) {
            hashMap.put("xsj_topic_id", WinkDatongCurrentParams.get("xsj_topic_id"));
        }
        if (!hashMap.containsKey("xsj_topic_name")) {
            hashMap.put("xsj_topic_name", WinkDatongCurrentParams.get("xsj_topic_name"));
        }
        hashMap.put("xsj_topic_page_source", WinkDatongCurrentParams.get("xsj_topic_page_source"));
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_ATLAS_EXPLORE_PAGE, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_ATLAS_EXPLORE_PAGE));
        WinkDatongCurrentParams.put("xsj_session_id", WinkNativeSessionManager.g().getSessionId());
        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_SESSION_ID, str);
        Object obj = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.QZONE_PUBLISH_ID);
        if (obj != null) {
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.QZONE_PUBLISH_ID, obj);
        }
        Object obj2 = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.ADID);
        if (obj2 != null) {
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.ADID, obj2);
        }
        addTemplateLibCommonParams(hashMap);
        addTransferParams(hashMap);
        return new PageParams(hashMap);
    }

    public PageParams buildReportPageParamsForQQMain(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        return new PageParams(hashMap);
    }
}
