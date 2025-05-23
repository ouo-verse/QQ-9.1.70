package com.tencent.mobileqq.search.rich;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZoneImageUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private int f283759a = 1;

    /* renamed from: b, reason: collision with root package name */
    private String f283760b = "";

    /* renamed from: c, reason: collision with root package name */
    private String f283761c = "";

    public static String b(int i3, boolean z16, String str, boolean z17) {
        int i16;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("entry", i3);
            int i17 = 1;
            if (z16) {
                i16 = 1;
            } else {
                i16 = 0;
            }
            jSONObject.put(QZoneImageUtils.KEY_MATCH, i16);
            jSONObject.put("keyword", str);
            if (!z17) {
                i17 = 0;
            }
            jSONObject.put("nightmode", i17);
            return jSONObject.toString();
        } catch (JSONException e16) {
            QLog.e("RichMetaData", 2, "setLayout101ExtraData exception:" + e16);
            return null;
        }
    }

    public void a(boolean z16) {
        if (z16) {
            this.f283759a = 1;
        } else {
            this.f283759a = 0;
        }
    }

    public void c(String str) {
        this.f283761c = str;
    }

    public void d(String str) {
        this.f283760b = str;
    }

    public String e() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("serverdata", new JSONObject(this.f283760b));
            jSONObject2.put("state", this.f283759a);
            if (!TextUtils.isEmpty(this.f283761c)) {
                jSONObject2.put("extradata", new JSONObject(this.f283761c));
            }
            jSONObject.put("data", jSONObject2);
        } catch (JSONException e16) {
            QLog.e("RichMetaData", 2, "convertMetaData exception : " + e16);
        }
        return jSONObject.toString();
    }
}
