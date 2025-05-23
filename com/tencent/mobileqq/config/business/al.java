package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class al {

    /* renamed from: a, reason: collision with root package name */
    private boolean f202510a = false;

    /* renamed from: b, reason: collision with root package name */
    private boolean f202511b = false;

    /* renamed from: c, reason: collision with root package name */
    private long f202512c;

    public static al d(com.tencent.mobileqq.config.ai[] aiVarArr) {
        boolean z16;
        al alVar = new al();
        StringBuilder sb5 = new StringBuilder();
        int i3 = 0;
        while (true) {
            try {
                boolean z17 = true;
                if (i3 < aiVarArr.length) {
                    String str = aiVarArr[i3].f202268b;
                    if (TextUtils.isEmpty(str)) {
                        com.tencent.open.agent.util.t.b("OpenSdkConfProcessor", "parse, content empty");
                    } else {
                        JSONObject jSONObject = new JSONObject(str);
                        if (jSONObject.has("enable_third_app_share_big_image_by_server")) {
                            if (jSONObject.optInt("enable_third_app_share_big_image_by_server", 0) == 1) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            alVar.f202510a = z16;
                        }
                        if (jSONObject.has("sdk_share_verify_appinfo_timeout_duration")) {
                            alVar.f202512c = jSONObject.optInt("sdk_share_verify_appinfo_timeout_duration", 0);
                        }
                        if (jSONObject.has("sdk_login_use_third_transform_pkg_name")) {
                            if (jSONObject.optInt("sdk_login_use_third_transform_pkg_name", 0) != 1) {
                                z17 = false;
                            }
                            alVar.f202511b = z17;
                        }
                        sb5.append("config: ");
                        sb5.append(str);
                        sb5.append(",");
                    }
                    i3++;
                } else {
                    com.tencent.open.agent.util.t.b("OpenSdkConfProcessor", "parse, content:" + sb5.toString());
                    return alVar;
                }
            } catch (Exception e16) {
                com.tencent.open.agent.util.t.a("OpenSdkConfProcessor", "parse, failed!", e16);
                return null;
            }
        }
    }

    public long a() {
        return this.f202512c;
    }

    public boolean b() {
        return this.f202510a;
    }

    public boolean c() {
        return this.f202511b;
    }

    public String toString() {
        return super.toString();
    }
}
