package com.tencent.comic.hippy.module;

import android.text.TextUtils;
import com.tencent.ecommerce.richtext.annotation.JSMethod;
import com.tencent.qphone.base.util.QLog;
import gk0.a;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ComicModule extends a {
    private static final String METHOD_CALLBACK = "callback";
    public static final String TAG = "ComicModule";

    @JSMethod(uiThread = false)
    public void getChapterList(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", "");
        } catch (Exception e16) {
            QLog.e(TAG, 1, "ComicModule getChapterList:", e16);
            try {
                jSONObject.put("error_code", e16.getMessage());
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
        }
        TextUtils.isEmpty(str2);
    }

    @JSMethod(uiThread = false)
    public void getPictureList(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        new ArrayList().add(str2);
        try {
            jSONObject.put("data", "");
        } catch (Exception e16) {
            QLog.e(TAG, 1, "ComicModule getPictureList:", e16);
            try {
                jSONObject.put("error_code", e16.getMessage());
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
        }
        TextUtils.isEmpty(str3);
    }

    public void destroy() {
    }
}
