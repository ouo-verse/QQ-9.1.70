package com.tencent.mobileqq.config.business.qfile;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class l implements rb1.a<String> {

    /* renamed from: d, reason: collision with root package name */
    public boolean f202748d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f202749e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f202750f = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f202751h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f202752i = false;

    /* renamed from: m, reason: collision with root package name */
    public boolean f202753m = false;
    public boolean C = false;
    public boolean D = false;
    public boolean E = false;
    public boolean F = false;
    public boolean G = false;
    public boolean H = false;
    public boolean I = false;
    public boolean J = false;
    public boolean K = false;
    public boolean L = true;
    public String M = "";

    private void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            QLog.e("QFileCommonConfigBean", 1, "receiveAllConfigs|type: 396no httpsJson");
            return;
        }
        try {
            this.f202748d = jSONObject.getBoolean("c2c_up");
            if (QLog.isColorLevel()) {
                QLog.d("QFileCommonConfigBean", 2, "https_c2c_up = " + this.f202748d);
            }
            this.f202749e = jSONObject.getBoolean("c2c_down");
            if (QLog.isColorLevel()) {
                QLog.d("QFileCommonConfigBean", 2, "https_c2c_down = " + this.f202749e);
            }
            this.f202750f = jSONObject.getBoolean("c2czip_down");
            if (QLog.isColorLevel()) {
                QLog.d("QFileCommonConfigBean", 2, "https_c2czip_down = " + this.f202750f);
            }
            this.f202751h = jSONObject.getBoolean("c2c_thumb");
            if (QLog.isColorLevel()) {
                QLog.d("QFileCommonConfigBean", 2, "https_c2c_thumb = " + this.f202751h);
            }
            this.f202752i = jSONObject.getBoolean("disc_up");
            if (QLog.isColorLevel()) {
                QLog.d("QFileCommonConfigBean", 2, "https_disc_up = " + this.f202752i);
            }
            this.f202753m = jSONObject.getBoolean("disc_down");
            if (QLog.isColorLevel()) {
                QLog.d("QFileCommonConfigBean", 2, "https_disc_down = " + this.f202753m);
            }
            this.C = jSONObject.getBoolean("disczip_down");
            if (QLog.isColorLevel()) {
                QLog.d("QFileCommonConfigBean", 2, "https_disczip_down = " + this.C);
            }
            this.D = jSONObject.getBoolean("disc_thumb");
            if (QLog.isColorLevel()) {
                QLog.d("QFileCommonConfigBean", 2, "https_disc_thumb = " + this.D);
            }
            this.E = jSONObject.getBoolean("troop_up");
            if (QLog.isColorLevel()) {
                QLog.d("QFileCommonConfigBean", 2, "https_troop_up = " + this.E);
            }
            this.F = jSONObject.getBoolean("troop_down");
            if (QLog.isColorLevel()) {
                QLog.d("QFileCommonConfigBean", 2, "https_troop_down = " + this.F);
            }
            this.G = jSONObject.getBoolean("troopzip_down");
            if (QLog.isColorLevel()) {
                QLog.d("QFileCommonConfigBean", 2, "https_troopzip_down = " + this.G);
            }
            this.H = jSONObject.getBoolean("troop_thumb");
            if (QLog.isColorLevel()) {
                QLog.d("QFileCommonConfigBean", 2, "https_troop_thumb = " + this.H);
            }
        } catch (JSONException e16) {
            QLog.e("QFileCommonConfigBean", 1, e16, new Object[0]);
        }
    }

    private void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            QLog.e("QFileCommonConfigBean", 1, "receiveAllConfigs|type: 396no mediaPlatformJson");
            return;
        }
        try {
            this.L = jSONObject.getBoolean("EnableAQQ");
            if (QLog.isColorLevel()) {
                QLog.d("QFileCommonConfigBean", 2, "enableFileMediaPlatform = " + this.L);
            }
        } catch (JSONException e16) {
            QLog.e("QFileCommonConfigBean", 1, e16, new Object[0]);
        }
    }

    private void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            QLog.e("QFileCommonConfigBean", 1, "receiveAllConfigs|type: 396no troop");
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("videopreview");
            if (jSONObject2 == null) {
                QLog.e("QFileCommonConfigBean", 1, "parse Troop Json |type: 396no videoPreview");
                return;
            }
            this.I = jSONObject2.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
            if (QLog.isColorLevel()) {
                QLog.d("QFileCommonConfigBean", 2, "troopVideoPriview = " + this.I);
            }
            this.J = jSONObject2.getBoolean("svip");
            if (QLog.isColorLevel()) {
                QLog.d("QFileCommonConfigBean", 2, "troopVideoPriview for SVIP = " + this.J);
            }
            this.K = jSONObject2.getBoolean("yearsvip");
            if (QLog.isColorLevel()) {
                QLog.d("QFileCommonConfigBean", 2, "troopVideoPriview for YearSVIP = " + this.J);
            }
        } catch (JSONException e16) {
            QLog.e("QFileCommonConfigBean", 1, e16, new Object[0]);
        }
    }

    @Override // rb1.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onParse(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("QFileCommonConfigBean", 1, "receiveAllConfigs|type: 396configContent is empty");
            return;
        }
        this.M = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            b(jSONObject.getJSONObject("https"));
            d(jSONObject.getJSONObject("troop"));
            c(jSONObject.getJSONObject("UseMediaPlatform"));
        } catch (JSONException e16) {
            QLog.e("QFileCommonConfigBean", 1, e16, new Object[0]);
        }
    }
}
