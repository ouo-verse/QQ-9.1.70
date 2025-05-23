package com.tencent.mobileqq.troop.text;

import android.text.TextUtils;
import android.text.style.DynamicDrawableSpan;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b extends DynamicDrawableSpan {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static String f299228d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76607);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f299228d = "startPos";
        }
    }

    public static String a(long j3, String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            JSONArray jSONArray2 = new JSONArray();
            int i3 = 0;
            for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i16);
                if (i16 == 0) {
                    if (jSONObject.optLong("uin") == j3) {
                        i3 = jSONObject.optInt(f299228d);
                    } else {
                        jSONArray2.mo162put(jSONObject);
                    }
                } else {
                    int optInt = jSONObject.optInt(f299228d, 0);
                    if (optInt > i3) {
                        jSONObject.put(f299228d, optInt - i3);
                    }
                    jSONArray2.mo162put(jSONObject);
                }
            }
            if (jSONArray2.length() == 0) {
                return null;
            }
            return jSONArray2.toString();
        } catch (JSONException unused) {
            return str;
        }
    }
}
