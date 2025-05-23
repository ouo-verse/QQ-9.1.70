package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class bg {

    /* renamed from: a, reason: collision with root package name */
    private boolean f202605a = false;

    /* renamed from: b, reason: collision with root package name */
    private String f202606b = ITeamWorkUtils.TENCENT_DOC_MIMI_APPID;

    /* renamed from: c, reason: collision with root package name */
    private String f202607c = "pages/list/list";

    /* renamed from: d, reason: collision with root package name */
    private String f202608d = "";

    /* renamed from: e, reason: collision with root package name */
    private String f202609e = "";

    public static bg e(JSONObject jSONObject) throws JSONException {
        bg bgVar = new bg();
        if (jSONObject.has("enableOpenMiniCode")) {
            boolean z16 = true;
            if (jSONObject.getInt("enableOpenMiniCode") != 1) {
                z16 = false;
            }
            bgVar.f202605a = z16;
        }
        if (jSONObject.has("miniCodeAppid")) {
            bgVar.f202606b = jSONObject.getString("miniCodeAppid");
        }
        if (jSONObject.has("miniCodePage")) {
            bgVar.f202607c = jSONObject.getString("miniCodePage");
        }
        if (jSONObject.has("miniCodeEnvVersion")) {
            bgVar.f202608d = jSONObject.getString("miniCodeEnvVersion");
        }
        if (jSONObject.has("miniCodeUrlBlackRegular")) {
            bgVar.f202609e = jSONObject.getString("miniCodeUrlBlackRegular");
        }
        return bgVar;
    }

    public String a() {
        return this.f202606b;
    }

    public String b() {
        return this.f202607c;
    }

    public String c() {
        return this.f202609e;
    }

    public boolean d() {
        return this.f202605a;
    }

    public void f(String str) {
        this.f202607c = str;
    }

    public void g(boolean z16) {
        this.f202605a = z16;
    }
}
