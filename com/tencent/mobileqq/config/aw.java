package com.tencent.mobileqq.config;

import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class aw implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    public String f202410d = "";

    /* renamed from: e, reason: collision with root package name */
    public int f202411e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f202412f = 25;

    public static aw a(String str) {
        QLog.d("WeiYunMiniAppConfigFreesia", 2, str);
        aw awVar = new aw();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("apkgUrl")) {
                awVar.f202410d = jSONObject.getString("apkgUrl");
            }
            if (jSONObject.has("isWeiYunMiniApp")) {
                awVar.f202411e = jSONObject.getInt("isWeiYunMiniApp");
            }
            if (jSONObject.has("miniVersion")) {
                awVar.f202412f = jSONObject.getInt("miniVersion");
            }
        } catch (Exception e16) {
            QLog.e("WeiYunMiniAppConfigFreesia", 1, e16.getLocalizedMessage(), e16);
        }
        return awVar;
    }
}
