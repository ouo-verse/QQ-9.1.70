package com.tencent.aelight.camera.aioeditor.shortvideo;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.l;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f67594a = "QIMBeautyManager";

    /* renamed from: b, reason: collision with root package name */
    private static a f67595b;

    a() {
        d();
    }

    private String b() {
        String string = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_beauty_config", 0).getString("short_video_beauty_content", "");
        if (QLog.isColorLevel()) {
            QLog.d(f67594a, 2, "take  config content= " + string);
        }
        return string;
    }

    public static a c() {
        if (f67595b == null) {
            synchronized (a.class) {
                if (f67595b == null) {
                    f67595b = new a();
                }
            }
        }
        return f67595b;
    }

    public int a(Context context) {
        return context.getSharedPreferences("short_video_beauty_config", 0).getInt("short_video_beauty_version", 0);
    }

    public void d() {
        JSONArray jSONArray;
        try {
            String b16 = b();
            if (TextUtils.isEmpty(b16)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(b16);
            if (jSONObject.has("category") && (jSONArray = jSONObject.getJSONArray("category")) != null && jSONArray.length() > 0) {
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    if (jSONObject2.has("downloadInfo")) {
                        l.f94471a = jSONObject2.getString("downloadInfo");
                        if (QLog.isColorLevel()) {
                            QLog.e(f67594a, 2, "QIMBeautyManager WeishiGuideUtils.DOWNLOAD_JSON=  " + l.f94471a);
                        }
                    }
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(f67594a, 2, "parseConfig error", e16);
            }
        }
    }

    public boolean e(String str, int i3, Context context) {
        if (QLog.isColorLevel()) {
            QLog.d(f67594a, 2, "saveBeautyConfig :  " + str);
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("short_video_beauty_config", 0).edit();
        edit.putString("short_video_beauty_content", str);
        edit.putInt("short_video_beauty_version", i3);
        edit.commit();
        return true;
    }
}
