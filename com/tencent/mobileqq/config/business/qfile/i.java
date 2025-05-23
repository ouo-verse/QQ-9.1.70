package com.tencent.mobileqq.config.business.qfile;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class i implements com.tencent.mobileqq.config.n<String> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f202741a = false;

    @Override // com.tencent.mobileqq.config.n
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onParse(String str) {
        String str2;
        QLog.i("QFileApkCheckConfigBean", 1, "configID:663 onParse apkcheckConfig:" + str);
        if (!TextUtils.isEmpty(str)) {
            str2 = str.toLowerCase();
        } else {
            str2 = "";
        }
        if (TextUtils.isEmpty(str2)) {
            QLog.w("QFileApkCheckConfigBean", 1, "apkcheckConfig is empty, configID:663 use default value");
            this.f202741a = false;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2).getJSONObject("apkcheckconfig");
            if (jSONObject != null) {
                if (jSONObject.has("enable")) {
                    this.f202741a = jSONObject.getBoolean("enable");
                } else {
                    this.f202741a = false;
                }
            } else {
                QLog.w("QFileApkCheckConfigBean", 1, "apkcheckConfig is no enable. use default value");
                this.f202741a = false;
            }
        } catch (JSONException e16) {
            QLog.e("QFileApkCheckConfigBean", 1, e16, new Object[0]);
        }
    }
}
