package com.tencent.mobileqq.config.business.qfile;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class j implements rb1.a<String>, b {

    /* renamed from: d, reason: collision with root package name */
    public boolean f202742d = false;

    /* renamed from: e, reason: collision with root package name */
    public String f202743e = "";

    /* renamed from: f, reason: collision with root package name */
    public String f202744f = "";

    /* renamed from: h, reason: collision with root package name */
    public String f202745h = "{}";

    @Override // com.tencent.mobileqq.config.business.qfile.b
    public String a() {
        return this.f202743e;
    }

    @Override // com.tencent.mobileqq.config.business.qfile.b
    public boolean b() {
        return this.f202742d;
    }

    @Override // rb1.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onParse(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("QFileAppStorePromoteConfigBean<QFile>", 1, "onParse: but configContent is null!");
        }
        this.f202745h = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("actionSwitch")) {
                this.f202742d = jSONObject.getBoolean("actionSwitch");
            }
            if (jSONObject.has("actionHint")) {
                this.f202743e = jSONObject.getString("actionHint");
            }
            if (jSONObject.has("actionYYBDownloadUrl")) {
                this.f202744f = jSONObject.getString("actionYYBDownloadUrl");
            }
        } catch (JSONException e16) {
            QLog.e("QFileAppStorePromoteConfigBean<QFile>", 1, QLog.getStackTraceString(e16));
        }
    }
}
