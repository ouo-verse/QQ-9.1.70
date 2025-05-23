package com.tencent.mobileqq.vas;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class at {

    /* renamed from: c, reason: collision with root package name */
    private static at f308654c;

    /* renamed from: a, reason: collision with root package name */
    private List<String> f308655a = new CopyOnWriteArrayList();

    /* renamed from: b, reason: collision with root package name */
    private List<String> f308656b = new CopyOnWriteArrayList();

    public at() {
        this.f308655a.add("vip.qq.com");
    }

    public static at a() {
        if (f308654c == null) {
            synchronized (at.class) {
                if (f308654c == null) {
                    f308654c = new at();
                }
            }
        }
        return f308654c;
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        List<String> list = this.f308656b;
        if (list.isEmpty()) {
            list = this.f308655a;
        }
        for (String str2 : list) {
            if (!TextUtils.isEmpty(str2) && str.endsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public void c(JSONArray jSONArray) {
        if (QLog.isColorLevel()) {
            QLog.d("VipLongMsgShareDomainHelper", 2, "setConfigData data = " + jSONArray);
        }
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    if (jSONObject != null) {
                        this.f308656b.add(jSONObject.optString("domain", ""));
                    }
                } catch (Exception e16) {
                    QLog.e("VipLongMsgShareDomainHelper", 1, "setConfigData exception ", e16);
                }
            }
        }
    }
}
