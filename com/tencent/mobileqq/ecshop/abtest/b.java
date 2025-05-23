package com.tencent.mobileqq.ecshop.abtest;

import android.text.TextUtils;
import com.tencent.mobileqq.ecshop.utils.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static Map<String, a> a() {
        HashMap hashMap = new HashMap();
        try {
            String c16 = e.c("ab_test_info_" + com.tencent.mobileqq.ecshop.utils.a.a().getAccount());
            if (!TextUtils.isEmpty(c16)) {
                c(hashMap, c16);
            }
        } catch (Exception e16) {
            QLog.e("qqshop_ABTestUtil", 1, e16, new Object[0]);
        }
        return hashMap;
    }

    public static String b() {
        Map<String, a> a16 = a();
        StringBuilder sb5 = new StringBuilder();
        for (a aVar : a16.values()) {
            if (aVar != null) {
                if (sb5.length() > 0) {
                    sb5.append("##");
                }
                if (!TextUtils.isEmpty(aVar.f203936c)) {
                    sb5.append(aVar.f203936c);
                }
                sb5.append(">");
                if (!TextUtils.isEmpty(aVar.f203938e)) {
                    sb5.append(aVar.f203938e);
                }
                sb5.append(">");
                if (!TextUtils.isEmpty(aVar.a())) {
                    sb5.append(aVar.a());
                }
            }
        }
        return sb5.toString();
    }

    private static void c(Map<String, a> map, String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("MBucketTest");
            if (optJSONObject == null) {
                return;
            }
            Iterator keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(str2);
                if (optJSONObject2 != null) {
                    map.put(str2, a.b(optJSONObject2));
                }
            }
        } catch (Exception e16) {
            QLog.e("qqshop_ABTestUtil", 1, e16, new Object[0]);
        }
    }
}
