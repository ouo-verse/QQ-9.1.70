package com.tencent.rmonitor.base.config.impl;

import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.bugly.common.meta.UserMeta;
import com.tencent.bugly.common.privacy.PrivacyInformation;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.utils.StringUtil;
import com.tencent.rmonitor.common.logger.Logger;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    public String f365332a = "";

    /* renamed from: b, reason: collision with root package name */
    public String f365333b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f365334c;

    /* renamed from: d, reason: collision with root package name */
    public String f365335d;

    /* renamed from: e, reason: collision with root package name */
    public String f365336e;

    /* renamed from: f, reason: collision with root package name */
    public String f365337f;

    /* renamed from: g, reason: collision with root package name */
    public String f365338g;

    /* renamed from: h, reason: collision with root package name */
    public String f365339h;

    /* renamed from: i, reason: collision with root package name */
    public String f365340i;

    /* renamed from: j, reason: collision with root package name */
    public String f365341j;

    /* renamed from: k, reason: collision with root package name */
    public String f365342k;

    /* renamed from: l, reason: collision with root package name */
    public String f365343l;

    public JSONObject a() {
        JSONObject jSONObject;
        Throwable th5;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("pid", this.f365334c);
                jSONObject.put("app_key", this.f365335d);
                jSONObject.put("version", this.f365336e);
                jSONObject.put(HiAnalyticsConstant.BI_KEY_SDK_VER, this.f365337f);
                jSONObject.put("uin", this.f365339h);
                jSONObject.put("deviceid", this.f365340i);
                jSONObject.put("os", this.f365342k);
                jSONObject.put("manu", this.f365343l);
                jSONObject.put("device", this.f365341j);
                jSONObject.put(ReportDataBuilder.KEY_APP_VERSION_MODE, this.f365338g);
                jSONObject.put("md5code", this.f365333b);
            } catch (Throwable th6) {
                th5 = th6;
                Logger.f365497g.c("RMonitor_config", th5);
                return jSONObject;
            }
        } catch (Throwable th7) {
            jSONObject = null;
            th5 = th7;
        }
        return jSONObject;
    }

    public boolean b(@NotNull b bVar) {
        if (TextUtils.equals(this.f365334c, bVar.f365334c) && TextUtils.equals(this.f365335d, bVar.f365335d) && TextUtils.equals(this.f365338g, bVar.f365338g) && TextUtils.equals(this.f365336e, bVar.f365336e) && TextUtils.equals(this.f365337f, bVar.f365337f) && TextUtils.equals(this.f365340i, bVar.f365340i) && TextUtils.equals(this.f365339h, bVar.f365339h) && TextUtils.equals(this.f365342k, bVar.f365342k) && TextUtils.equals(this.f365341j, bVar.f365341j)) {
            return false;
        }
        return true;
    }

    public void c(UserMeta userMeta) {
        if (userMeta == null) {
            return;
        }
        this.f365334c = userMeta.appId;
        this.f365335d = userMeta.appKey;
        String str = userMeta.appVersionMode;
        this.f365336e = userMeta.appVersion;
        this.f365337f = userMeta.sdkVersion;
        this.f365338g = str;
        this.f365339h = userMeta.uin;
        this.f365340i = userMeta.getUniqueID();
        this.f365341j = StringUtil.encode(PrivacyInformation.getInstance().getModel());
        this.f365343l = PrivacyInformation.getInstance().getManufacture();
        this.f365342k = PrivacyInformation.getInstance().getOSVersion();
    }

    public void d(b bVar) {
        if (bVar == null) {
            return;
        }
        this.f365332a = bVar.f365332a;
        this.f365333b = bVar.f365333b;
        this.f365334c = bVar.f365334c;
        this.f365335d = bVar.f365335d;
        this.f365336e = bVar.f365336e;
        this.f365337f = bVar.f365337f;
        this.f365338g = bVar.f365338g;
        this.f365339h = bVar.f365339h;
        this.f365340i = bVar.f365340i;
        this.f365341j = bVar.f365341j;
        this.f365342k = bVar.f365342k;
        this.f365343l = bVar.f365343l;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f365334c = jSONObject.optString("pid");
        this.f365335d = jSONObject.optString("app_key");
        this.f365336e = jSONObject.optString("version");
        this.f365339h = jSONObject.optString("uin");
        this.f365340i = jSONObject.optString("deviceid");
        this.f365336e = jSONObject.optString("version");
        this.f365337f = jSONObject.optString(HiAnalyticsConstant.BI_KEY_SDK_VER);
        this.f365342k = jSONObject.optString("os");
        this.f365343l = jSONObject.optString("manu");
        this.f365341j = jSONObject.optString("device");
        this.f365338g = jSONObject.optString(ReportDataBuilder.KEY_APP_VERSION_MODE);
        this.f365333b = jSONObject.optString("md5code");
    }
}
