package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    static HashMap<String, Integer> f297412a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64379);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        f297412a = hashMap;
        hashMap.put("str", 0);
        f297412a.put("img", 1);
        f297412a.put("video", 2);
        f297412a.put("voice", 3);
    }

    public static b a(JSONObject jSONObject, String str) {
        Integer num;
        try {
            num = f297412a.get(jSONObject.getString("type"));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (num == null) {
            return null;
        }
        int intValue = num.intValue();
        if (intValue != 0) {
            if (intValue != 1) {
                if (intValue != 2) {
                    if (intValue != 3) {
                        return null;
                    }
                    return new a(jSONObject, str);
                }
                return new VideoInfo(jSONObject, str);
            }
            return new ImageInfo(jSONObject, str);
        }
        return new f(jSONObject);
    }

    public static b b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return a(new JSONObject(str), str2);
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
