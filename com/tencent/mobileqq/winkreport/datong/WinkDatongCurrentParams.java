package com.tencent.mobileqq.winkreport.datong;

import com.google.gson.Gson;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes21.dex */
public class WinkDatongCurrentParams {
    private static final Set<String> eleCommKeys;
    private static final HashMap<String, Object> eleCommParams;
    public static HashMap<String, Object> params = new HashMap<>();

    static {
        HashMap<String, Object> hashMap = new HashMap<>();
        eleCommParams = hashMap;
        HashSet hashSet = new HashSet();
        eleCommKeys = hashSet;
        params.put("xsj_session_id", WinkNativeSessionManager.g().getSessionId());
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_SESSION_ID, WinkNativeSessionManager.g().getCameraSessionId());
        params.put("xsj_operation_activity_id", "");
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID, "");
        params.put("xsj_music_id", "");
        params.put("xsj_music_name", "");
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_IS_DEFAULT, 1);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_FROM, "");
        params.put("xsj_query_text", "");
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_CATEGORY_NAME, "");
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_MUSIC_FROM_SEARCH, "");
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_SEARCH_QUERY_SOURCE, "");
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_VOLUME_VALUE, "");
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_ORIGINAL_VOLUME_VALUE, "");
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_IS_CUT, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_SOUND_IS_ORIGIN, "");
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_TYPE, "");
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_ID, "");
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_SMART_CUT, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_PASTE_MODIFIED, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_PASTE_ONEHAND_MODIFIED, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FILTER_NAME_CAMERA, "");
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_IMAGE_ENHANCE, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CONTENT_NUM, 0);
        params.put("xsj_picture_num", 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_VIDEO_NUM, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_DIY_STICKER_IF_BG, 0);
        params.put("xsj_topic_id", "");
        params.put("xsj_topic_name", "");
        params.put("xsj_topic_page_source", "");
        params.put("xsj_url", "");
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IMAGE_ENHANCE_ALGORITHM_VIDEOLENGTH, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IMAGE_ENHANCE_ALGORITHM_FACE, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IMAGE_ENHANCE_ALGORITHM_DEBLUR, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IMAGE_ENHANCE_ALGORITHM_WATERMARK, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXIAO_NAME, "");
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_MUSIC_TYPE, "");
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_DAPIAN_TEMPLATE_NAME, "");
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_DAPIAN_TEMPLATE_CATEGORY, "");
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_BIG_PANEL, "");
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_SETTING_DEFAULT_STATUS, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IF_CLCK_CAMERA_CUT_FINISH, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_SPEED_LIST, "");
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_SPEED_CHANGE, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CUT_IS_SLIDE_ROTATE, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CUT_IS_90DEGREE_ROTATE, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_USE_CUT_SIZE, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CUT_IS_ORIGINAL, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CUT_IS_FREE, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CUT_IS_16TO9, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CUT_IS_9TO16, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CUT_IS_4TO3, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CUT_IS_3TO4, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CUT_IS_1TO1, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_STICKER_IS_ADJUST_DURATION, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_STICKER_IS_ORIGINAL, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_STICKER_IS_CURRENT, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_STICKER_IS_3S, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_STICKER_IS_CUSTOM, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_IS_ADJUST_DURATION, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_IS_ORIGINAL, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_IS_CURRENT, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_IS_3S, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_IS_CUSTOM, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_SUBTITLE, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_BILINGUAL_SUBTITLE, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_IS_NULL, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_IS_BORDER, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_IS_PURE_COLOR, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_IS_TRANSLUCENCE, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_IS_TEXT, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_IS_SUBTITLE, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_TEXT_FROM_STYLE, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_TEXT_FROM_DECORATE, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_UNDERLAY_TEXT_FROM_HUAZI, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_PASTE_TRACK, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_CHAR_TRACK, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_LYRICS, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LYRIC_NAME, "");
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LYRIC_ID, "");
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LYRIC_BUTTON_LOCATION, "");
        params.put(WinkDaTongReportConstant.ElementParamValue.XSJ_COVER_TEMPLATE_ID, 0);
        params.put(WinkDaTongReportConstant.ElementParamValue.XSJ_COVER_TEMPLETE_CATEGORY, "");
        params.put(WinkDaTongReportConstant.ElementParamValue.XSJ_COVER_CHAR_FORM_ID, 0);
        params.put(WinkDaTongReportConstant.ElementParamValue.XSJ_COVER_CHAR_PATTERN_ID, 0);
        params.put(WinkDaTongReportConstant.ElementParamValue.XSJ_COVER_CHAR_ART_ID, 0);
        params.put("xsj_template_id", 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEMPLATE_LIST_ITEM_NAME, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_VOLUME_NAME, "");
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_VOLUME_VALUE, "");
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_VIDEO_OR_PIC_PAGE, "");
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "");
        hashMap.put("xsj_session_id", "");
        hashSet.add(DTParamKey.REPORT_KEY_APPKEY);
        hashSet.add("xsj_session_id");
        params.put("xsj_background_id", 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CHARACTER_NUM, 0);
        params.put("xsj_background_id", 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUB_CLIP_NUM, 0);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CHOOSE_VIDEO_MATERIAL_ID, "");
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_ATLAS_EXPLORE_PAGE, 0);
    }

    public static void clearAll() {
        clearParams();
        clearEleParams();
    }

    public static void clearEleParams() {
        eleCommParams.clear();
    }

    public static void clearParams() {
        params.clear();
    }

    public static boolean contains(String str) {
        return params.containsKey(str);
    }

    public static Object get(String str) {
        if (params.get(str) != null) {
            return params.get(str);
        }
        return "";
    }

    public static Object getEleCommValue(String str) {
        return eleCommParams.get(str);
    }

    public static Map<String, Object> getMap() {
        return params;
    }

    public static void put(String str, Object obj) {
        params.put(str, obj);
    }

    public static void putEleCommValue(String str, Object obj) {
        if (!eleCommKeys.contains(str)) {
            return;
        }
        eleCommParams.put(str, obj);
    }

    public static String toJson() {
        return new Gson().toJson(params);
    }
}
