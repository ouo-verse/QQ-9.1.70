package com.tencent.mobileqq.config.business.qfile;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class k implements rb1.a<String>, c {

    /* renamed from: d, reason: collision with root package name */
    public boolean f202746d = false;

    /* renamed from: e, reason: collision with root package name */
    public String f202747e = "{}";

    @Override // com.tencent.mobileqq.config.business.qfile.c
    public boolean a() {
        return this.f202746d;
    }

    @Override // rb1.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onParse(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("QFileAppStorePromoteDialogConfigBean<QFile>", 1, "onParse: but configContent is null!");
        }
        this.f202747e = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("dialogSwitch")) {
                this.f202746d = jSONObject.getBoolean("dialogSwitch");
            }
        } catch (JSONException e16) {
            QLog.e("QFileAppStorePromoteDialogConfigBean<QFile>", 1, QLog.getStackTraceString(e16));
        }
    }
}
