package com.tencent.mobileqq.shortvideo;

import androidx.annotation.NonNull;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    int f287864d;

    /* renamed from: e, reason: collision with root package name */
    int f287865e;

    /* renamed from: f, reason: collision with root package name */
    int f287866f;

    /* renamed from: h, reason: collision with root package name */
    int f287867h;

    @NonNull
    public static f a(String str) {
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray(MiniChatConstants.MINI_APP_SHOW_DETAIL);
            if (jSONArray.length() > 0) {
                JSONObject jSONObject = jSONArray.getJSONObject(0);
                f fVar = new f();
                String optString = jSONObject.optString("name");
                if ("photo".equals(optString)) {
                    fVar.f287866f = jSONObject.optInt("showRed", 0);
                    fVar.f287867h = jSONObject.optInt("version", 0);
                } else if ("gif".equals(optString)) {
                    fVar.f287864d = jSONObject.optInt("showRed", 0);
                    fVar.f287865e = jSONObject.optInt("version", 0);
                }
                return fVar;
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("ShortVideoAndHotPicRedDotConfProcessor", 2, "handleGetPtvHotPicConfig Exception :", e16);
            }
        }
        return new f();
    }

    @NonNull
    public String toString() {
        return "showRedDotHotPic: " + this.f287864d + " versionHotPic: " + this.f287865e + " showRedDotCamera: " + this.f287866f + " versionCamera: " + this.f287867h;
    }
}
