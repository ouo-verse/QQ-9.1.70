package com.tencent.mobileqq.shortvideo;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class r {
    public static int a(Context context) {
        return context.getSharedPreferences("shortVideoMsgTailSp", 0).getInt("short_video_msg_config_version", 0);
    }

    public static void b(Context context, int i3) {
        SharedPreferences.Editor edit = context.getSharedPreferences("shortVideoMsgTailSp", 0).edit();
        edit.putInt("short_video_msg_config_version", i3);
        edit.apply();
    }

    public static void c(Context context, List<String> list) {
        try {
            if (list == null) {
                if (QLog.isColorLevel()) {
                    QLog.i("ShortVideoMsgTailHelper", 2, "updateShortVideoMsgTailConfig, configs == null");
                    return;
                }
                return;
            }
            for (String str : list) {
                if (QLog.isColorLevel()) {
                    QLog.i("ShortVideoMsgTailHelper", 2, "updateShortVideoMsgTailConfig, config=" + str);
                }
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                if (length > 0) {
                    SharedPreferences.Editor edit = context.getSharedPreferences("shortVideoMsgTailSp", 0).edit();
                    for (int i3 = 0; i3 < length; i3++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i3);
                        int i16 = jSONObject.getInt("type");
                        if (i16 != 0) {
                            edit.putBoolean("short_video_msg_tail_is_show_" + i16, "1".equals(jSONObject.optString(ViewStickEventHelper.IS_SHOW)));
                            edit.putString("short_video_msg_tail_wording_" + i16, jSONObject.optString("wording"));
                            edit.putString("short_video_msg_tail_jumping_url_" + i16, jSONObject.optString(WadlProxyConsts.KEY_JUMP_URL));
                            edit.apply();
                        } else {
                            QLog.i("ShortVideoMsgTailHelper", 1, "type == 0");
                        }
                    }
                }
            }
        } catch (JSONException e16) {
            QLog.e("ShortVideoMsgTailHelper", 1, e16.toString(), e16);
        }
    }
}
