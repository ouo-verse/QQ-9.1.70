package com.tencent.mobileqq.config.business.qfile;

import android.text.TextUtils;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Deprecated
/* loaded from: classes10.dex */
public class m implements rb1.a<String>, d {

    /* renamed from: d, reason: collision with root package name */
    public boolean f202754d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f202755e = false;

    /* renamed from: f, reason: collision with root package name */
    public long f202756f = GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT;

    /* renamed from: h, reason: collision with root package name */
    public long f202757h = 3145728;

    /* renamed from: i, reason: collision with root package name */
    public long f202758i = 3000;

    /* renamed from: m, reason: collision with root package name */
    public String f202759m = "{}";

    @Override // com.tencent.mobileqq.config.business.qfile.d
    public long a() {
        return this.f202758i;
    }

    @Override // com.tencent.mobileqq.config.business.qfile.d
    @Deprecated
    public void b(boolean z16) {
        this.f202754d = z16;
    }

    @Override // com.tencent.mobileqq.config.business.qfile.d
    public long c() {
        return this.f202757h;
    }

    @Override // com.tencent.mobileqq.config.business.qfile.d
    public boolean d() {
        return this.f202754d;
    }

    @Override // com.tencent.mobileqq.config.business.qfile.d
    public long e() {
        return this.f202756f;
    }

    @Override // com.tencent.mobileqq.config.business.qfile.d
    public boolean f() {
        return false;
    }

    @Override // com.tencent.mobileqq.config.business.qfile.d
    @Deprecated
    public void g(AppRuntime appRuntime, boolean z16) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, z16);
            JSONObject optJSONObject = jSONObject.optJSONObject("options");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("offline");
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wlan");
            if (optJSONObject3 == null) {
                optJSONObject3 = new JSONObject();
            }
            optJSONObject2.put("onlyofflinesize", this.f202756f);
            optJSONObject2.put("autodown", this.f202757h);
            optJSONObject3.put("offlinedealy", this.f202758i);
            optJSONObject.putOpt("offline", optJSONObject2);
            optJSONObject.putOpt("wlan", optJSONObject3);
            jSONObject.putOpt("options", optJSONObject);
            com.tencent.mobileqq.filemanager.util.h.h(appRuntime, "file_dataline_key", jSONObject.toString());
        } catch (JSONException e16) {
            QLog.e("QFileDatalineConfigBean", 1, QLog.getStackTraceString(e16));
        }
    }

    @Override // rb1.a
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void onParse(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("QFileDatalineConfigBean", 1, "onParse: but configContent is null!");
        }
        String lowerCase = str.toLowerCase();
        this.f202759m = lowerCase;
        try {
            JSONObject jSONObject = new JSONObject(lowerCase);
            if (!jSONObject.has(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH)) {
                return;
            }
            this.f202754d = jSONObject.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
            if (!jSONObject.has("options")) {
                return;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("options");
            if (jSONObject2.has("offline")) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject("offline");
                this.f202756f = jSONObject3.getLong("onlyofflinesize");
                this.f202757h = jSONObject3.getLong("autodown");
            }
            if (jSONObject2.has("wlan")) {
                this.f202758i = jSONObject2.getJSONObject("wlan").getLong("offlinedealy");
            }
        } catch (JSONException e16) {
            QLog.e("QFileDatalineConfigBean", 1, QLog.getStackTraceString(e16));
        }
    }
}
