package com.tencent.mobileqq.qqlive.room.util;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.impl.RoomServiceConstants;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.remote.ServiceConst;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Bundle f272109a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58356);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f272109a = null;
        }
    }

    public static Map<String, String> a(String str) {
        HashMap hashMap = new HashMap();
        try {
            String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
            boolean z16 = false;
            for (String str2 : split) {
                String[] split2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split2.length == 2) {
                    String str3 = split2[0];
                    if (str3 != null && str3.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                        str3 = str3.substring(str3.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) + 1);
                    }
                    if ("roomid".equals(str3) || "vid".equals(str3)) {
                        z16 = true;
                    }
                }
            }
            if (!z16) {
                split = URLDecoder.decode(str, "UTF-8").split(ContainerUtils.FIELD_DELIMITER);
            }
            for (String str4 : split) {
                String[] split3 = str4.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split3 != null && split3.length == 2) {
                    String str5 = split3[0];
                    if (str5 != null && str5.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                        str5 = str5.substring(str5.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) + 1);
                    }
                    if (str5 != null && str5.equalsIgnoreCase("pagetype")) {
                        str5 = "pagetype";
                    }
                    hashMap.put(str5, URLDecoder.decode(split3[1]));
                }
            }
        } catch (Exception e16) {
            QLog.e("EnterRoomUtil", 1, "parse mqq schema error " + e16);
        }
        return hashMap;
    }

    public static Intent b(Map<String, String> map, String str) {
        if (map == null) {
            return null;
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        if (map.containsKey("fromid")) {
            String str2 = map.get("fromid");
            intent.putExtra("source", str2);
            bundle.putString("source", str2);
        }
        if (map.containsKey("roomid")) {
            intent.putExtra("roomid", e(map.get("roomid")));
        }
        intent.putExtra("video_format", e(map.get("roomid")));
        intent.putExtra("video_format", 1);
        if (map.containsKey(AppConstants.Key.KEY_QZONE_VIDEO_URL)) {
            intent.putExtra("video_url", c(map));
        }
        if (map.containsKey("room_type")) {
            String str3 = map.get("room_type");
            if (QLog.isColorLevel()) {
                QLog.d("EnterRoomUtil", 2, "enterRoom roomType:" + str3);
            }
            if (TextUtils.isEmpty(str3)) {
                QLog.e("EnterRoomUtil", 1, "roomType is empty");
            } else {
                bundle.putInt("ext_enter_room_room_type", d(str3).intValue());
            }
        }
        if (map.containsKey("video_source")) {
            String str4 = map.get("video_source");
            if (QLog.isColorLevel()) {
                QLog.d("EnterRoomUtil", 2, "enterRoom gameTagId:" + str4);
            }
            if (str4 == null) {
                QLog.e("EnterRoomUtil", 1, "roomType is null");
            } else {
                bundle.putLong("ext_enter_room_video_source_app_id", e(str4).longValue());
            }
        }
        if (map.containsKey("game_id")) {
            String str5 = map.get("game_id");
            QLog.d("EnterRoomUtil", 2, "enterRoom gameId:" + str5);
            if (str5 == null) {
                QLog.e("EnterRoomUtil", 1, "gameId is null");
            } else {
                bundle.putInt("ext_enter_room_game_id", d(str5).intValue());
            }
        }
        if (map.containsKey("game_tag_id")) {
            String str6 = map.get("game_tag_id");
            if (QLog.isColorLevel()) {
                QLog.d("EnterRoomUtil", 2, "enterRoom gameTagId:" + str6);
            }
            if (str6 == null) {
                QLog.e("EnterRoomUtil", 1, "roomType is null");
            } else {
                bundle.putInt("ext_enter_room_game_tag_id", d(str6).intValue());
            }
        }
        if (map.containsKey("coverurl")) {
            bundle.putString("coverurl", map.get("coverurl"));
        }
        if (map.containsKey("pip")) {
            bundle.putString("pip", map.get("pip"));
        }
        if (map.containsKey(RoomServiceConstants.PARAMS_QQ_LIVE_PRODUCT_TYPE)) {
            bundle.putString(RoomServiceConstants.PARAMS_QQ_LIVE_PRODUCT_TYPE, map.get(RoomServiceConstants.PARAMS_QQ_LIVE_PRODUCT_TYPE));
        }
        if (map.containsKey("auto_open_luckybag")) {
            bundle.putInt("auto_open_luckybag", d(map.get("auto_open_luckybag")).intValue());
        }
        if (map.containsKey(WadlProxyConsts.VIA_AUTO_DOWNLOAD)) {
            bundle.putInt(WadlProxyConsts.VIA_AUTO_DOWNLOAD, d(map.get(WadlProxyConsts.VIA_AUTO_DOWNLOAD)).intValue());
        }
        if (map.containsKey("showmore")) {
            bundle.putString("showmore", map.get("showmore"));
        }
        if (map.containsKey("trace_info")) {
            bundle.putString("trace_info", map.get("trace_info"));
        }
        if (map.containsKey("translucent_page")) {
            bundle.putBoolean("translucent_page", Boolean.parseBoolean(map.get("translucent_page")));
        }
        if (map.containsKey(AEEditorConstants.VIDEO_CLIP_START_TIME)) {
            bundle.putLong(AEEditorConstants.VIDEO_CLIP_START_TIME, e(map.get(AEEditorConstants.VIDEO_CLIP_START_TIME)).longValue());
        }
        if (map.containsKey(ServiceConst.PARA_SESSION_ID)) {
            bundle.putString(ServiceConst.PARA_SESSION_ID, map.get(ServiceConst.PARA_SESSION_ID));
        }
        if (map.containsKey("tool_state")) {
            bundle.putString("tool_state", map.get("tool_state"));
        }
        if (map.containsKey("auto_open_url")) {
            bundle.putString("auto_open_url", map.get("auto_open_url"));
        }
        if (map.containsKey("extdata")) {
            bundle.putString("extdata", map.get("extdata"));
        }
        if (map.containsKey("auto_open_page_style")) {
            bundle.putString("auto_open_page_style", map.get("auto_open_page_style"));
        }
        if (map.containsKey("default_tab_id")) {
            bundle.putString("default_tab_id", map.get("default_tab_id"));
        }
        if (map.containsKey("gamelive_custom_params")) {
            bundle.putString("gamelive_custom_params", map.get("gamelive_custom_params"));
        }
        if (map.containsKey("rcmd_context")) {
            bundle.putString("rcmd_context", map.get("rcmd_context"));
        }
        if (map.containsKey("jump_start_time")) {
            bundle.putString("jump_start_time", map.get("jump_start_time"));
        }
        if (map.containsKey(AudienceReportConst.ANCHOR_ID)) {
            bundle.putString(AudienceReportConst.ANCHOR_ID, map.get(AudienceReportConst.ANCHOR_ID));
        }
        if (map.containsKey("closeJump")) {
            bundle.putString("closeJump", map.get("closeJump"));
        }
        if (map.containsKey("traceId")) {
            bundle.putString("traceId", map.get("traceId"));
            intent.putExtra(QQLiveReportConstants.INTENT_TRACE_ID, map.get("traceId"));
            intent.putExtra("key_intent_app_id", QQLiveBusinessConfig.QQLIVE_APP_ID);
        }
        if (map.containsKey("scene_id")) {
            bundle.putString("scene_id", map.get("scene_id"));
        }
        if (map.containsKey("qz_gdt")) {
            bundle.putString("qz_gdt", map.get("qz_gdt"));
        }
        if (map.containsKey("activity_id")) {
            bundle.putString("activity_id", map.get("activity_id"));
        }
        bundle.putString("mqqschema", str);
        intent.putExtra("biz_ext_data", bundle);
        return intent;
    }

    public static String c(Map<String, String> map) {
        String str = map.get(AppConstants.Key.KEY_QZONE_VIDEO_URL);
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            str = URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
        try {
            return (String) new JSONArray(str).get(0);
        } catch (JSONException e17) {
            e17.printStackTrace();
            return "";
        }
    }

    public static Integer d(String str) {
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException e16) {
            QLog.e("EnterRoomUtil", 1, "safeParseInt fail ", e16);
            return 0;
        }
    }

    public static Long e(String str) {
        try {
            return Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException e16) {
            QLog.e("EnterRoomUtil", 1, "safeParseLong fail ", e16);
            return 0L;
        }
    }
}
