package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class bc {

    /* renamed from: a, reason: collision with root package name */
    public String f202596a = "";

    /* renamed from: b, reason: collision with root package name */
    public int f202597b = 0;

    /* renamed from: c, reason: collision with root package name */
    public HashMap<String, String> f202598c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public String f202599d = "";

    public static bc a(String str) {
        if (str == null) {
            return null;
        }
        try {
            bc bcVar = new bc();
            bcVar.f202596a = str;
            JSONObject jSONObject = new JSONObject(str);
            bcVar.f202597b = jSONObject.optInt("isShowEntry");
            String optString = jSONObject.optString("iconUrl");
            bcVar.f202599d = optString;
            if (!TextUtils.isEmpty(optString)) {
                bcVar.f202599d = bcVar.f202599d.trim();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(PublicAccountMessageUtilImpl.ITEM_GRAY_TIPS);
            Iterator keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                bcVar.f202598c.put(str2, optJSONObject.optString(str2));
            }
            QLog.d("ConfBean", 2, "confBean = " + bcVar.toString());
            return bcVar;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("ConfBean", 1, "parse e:", e16);
            }
            return null;
        }
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder(100);
        sb5.append("configContent:");
        sb5.append(this.f202596a);
        return sb5.toString();
    }
}
