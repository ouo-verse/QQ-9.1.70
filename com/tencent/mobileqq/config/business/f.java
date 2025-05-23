package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public JSONObject f202654a = new JSONObject();

    /* renamed from: b, reason: collision with root package name */
    public int f202655b = 1;

    /* renamed from: c, reason: collision with root package name */
    public String f202656c = "https://h5.qzone.qq.com/mood/lover?_wv=16777219&from=common&qzUseTransparentNavBar=1&_proxy=1";

    public static f b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            f fVar = new f();
            fVar.f202654a = new JSONObject(str).optJSONObject("loverAIOPush");
            return fVar;
        } catch (Exception e16) {
            QLog.e("C2CLovePushGrayConfBean", 2, "C2CLovePushGrayConfBean onParsed erro " + e16.toString());
            return null;
        }
    }

    public f a(String str) {
        f fVar = new f();
        try {
            JSONObject jSONObject = this.f202654a;
            if (jSONObject != null) {
                JSONObject optJSONObject = jSONObject.optJSONObject(str);
                if (optJSONObject != null) {
                    fVar.f202655b = optJSONObject.optInt("linkType", 1);
                    fVar.f202656c = optJSONObject.optString("linkURL", "https://h5.qzone.qq.com/mood/lover?_wv=16777219&from=common&qzUseTransparentNavBar=1&_proxy=1");
                } else {
                    fVar.f202655b = 1;
                    fVar.f202656c = "https://h5.qzone.qq.com/mood/lover?_wv=16777219&from=common&qzUseTransparentNavBar=1&_proxy=1";
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("C2CLovePushGrayProcessor", 2, "getC2CLovePushGrayConfBean Exception :", e16);
            }
            fVar.f202655b = 1;
            fVar.f202656c = "https://h5.qzone.qq.com/mood/lover?_wv=16777219&from=common&qzUseTransparentNavBar=1&_proxy=1";
        }
        return fVar;
    }
}
