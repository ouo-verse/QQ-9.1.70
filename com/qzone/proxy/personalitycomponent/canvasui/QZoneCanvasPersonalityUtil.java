package com.qzone.proxy.personalitycomponent.canvasui;

import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.HashMap;

/* loaded from: classes39.dex */
public class QZoneCanvasPersonalityUtil {
    public static final String MTA_EVENT_KEY_CANVAS_PERSONALITY = "qzone_canvas_personality";
    public static final String MTA_SUB_KEY_GET_WIDGET_FAIL = "get_widget_fail";
    public static final String MTA_SUB_KEY_JSON_DOWN_LOAD = "json_down_load";
    public static final String MTA_SUB_KEY_JSON_TO_MAP = "json_to_map";
    public static final String MTA_SUB_KEY_VIEW_SHOW = "view_show";
    public static final String MTA_VALUE_SUCCESS = "success";

    public static void reportBeacon(final String str, final String str2, final String str3) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.proxy.personalitycomponent.canvasui.QZoneCanvasPersonalityUtil.1
            @Override // java.lang.Runnable
            public void run() {
                String str4 = str3;
                if (str4 == null || TextUtils.isEmpty(str4)) {
                    return;
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(str2, str3);
                StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(LoginData.getInstance().getUinString(), str, true, 0L, 0L, hashMap, null);
            }
        });
    }
}
