package com.tencent.mobileqq.kandian.biz.video.playfeedback;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.report.SPBeaconReporter;
import com.tencent.thumbplayer.report.reportv1.BeaconAdapter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import t52.e;

/* loaded from: classes33.dex */
public class PlayFeedbackHelper {
    public static void a(Map<String, String> map) {
        map.put("param_uin", ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin());
        map.put("param_platform", String.valueOf(1));
        map.put("param_sdk_version", SuperPlayerSDKMgr.getSDKVersion());
        StringBuilder sb5 = new StringBuilder();
        String str = AppSetting.f99551k;
        sb5.append(str);
        sb5.append(".");
        sb5.append(AppSetting.f99542b);
        map.put("param_version", sb5.toString());
        map.put("param_subversion", str);
        map.put("param_isSuperPlayer", String.valueOf(e.INSTANCE.a()));
        map.put("param_app_package", "com.tencent.mobileqq");
    }

    private static void b(final HashMap<String, String> hashMap) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.kandian.biz.video.playfeedback.PlayFeedbackHelper.1
            @Override // java.lang.Runnable
            public void run() {
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    for (Map.Entry entry : hashMap.entrySet()) {
                        sb5.append((String) entry.getKey());
                        sb5.append(":");
                        sb5.append((String) entry.getValue());
                        sb5.append(" ");
                    }
                    QLog.d("PlayFeedbackHelper", 2, "report actVideoPlayFeedback, data=" + sb5.toString());
                }
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin(), "actVideoPlayFeedback", true, -1L, 0L, hashMap, null);
                BeaconAdapter.onUserActionToTunnel(SPBeaconReporter.APP_KEY, "actVideoPlayFeedback", true, -1L, -1L, hashMap, true, true);
            }
        }, 5, null, true);
    }

    private static void e(Activity activity, JSONObject jSONObject) {
        if (jSONObject.optInt("close_type") > 0) {
            HashMap hashMap = new HashMap();
            JSONObject optJSONObject = jSONObject.optJSONObject("extral");
            a(hashMap);
            if (optJSONObject != null) {
                hashMap.putAll(i(optJSONObject));
            }
            if (activity != null) {
                g(activity, hashMap, jSONObject.optInt("agree_capture"));
            } else {
                QLog.w("PlayFeedbackHelper", 1, "feedbackOnViolaScene but shareEntryActivity is null, don't captureView");
                b(hashMap);
            }
        }
    }

    public static void f(Activity activity, JSONObject jSONObject) {
        try {
            int optInt = new JSONObject(jSONObject.optString("extral")).optInt("callAddress", -1);
            if (optInt == -1) {
                e(activity, jSONObject);
            } else {
                d(jSONObject, optInt);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static void g(Activity activity, HashMap<String, String> hashMap, int i3) {
        hashMap.put("agree_capture", String.valueOf(i3));
        if (i3 != 0) {
            c(activity, hashMap);
        } else {
            b(hashMap);
        }
    }

    public static void h(String str, int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("video_scene", i3);
        } catch (JSONException e16) {
            QLog.e("PlayFeedbackHelper", 2, "reportPlayFeedbackBtnExpose error", e16);
        }
        PublicAccountReportUtils.l(null, "", "0X800AA74", "0X800AA74", 0, 0, ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin(), str, "", jSONObject.toString(), false);
    }

    private static HashMap<String, String> i(JSONObject jSONObject) {
        HashMap<String, String> hashMap = new HashMap<>();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String valueOf = String.valueOf(keys.next());
            String valueOf2 = String.valueOf(jSONObject.opt(valueOf));
            if (!TextUtils.isEmpty(valueOf)) {
                hashMap.put(valueOf, valueOf2);
            }
        }
        return hashMap;
    }

    private static void c(Activity activity, HashMap<String, String> hashMap) {
    }

    private static void d(JSONObject jSONObject, int i3) {
    }
}
