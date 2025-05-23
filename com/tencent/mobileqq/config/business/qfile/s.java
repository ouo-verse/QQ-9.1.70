package com.tencent.mobileqq.config.business.qfile;

import android.text.TextUtils;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class s implements rb1.a<String> {

    /* renamed from: d, reason: collision with root package name */
    public boolean f202778d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f202779e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f202780f = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f202781h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f202782i = false;

    /* renamed from: m, reason: collision with root package name */
    public int f202783m = 0;

    private void b() {
        this.f202778d = false;
        this.f202779e = false;
        this.f202780f = false;
        this.f202781h = false;
        this.f202782i = false;
        this.f202783m = 0;
    }

    @Override // rb1.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onParse(String str) {
        String str2;
        QLog.i("QFileIPv6ConfigBean", 1, "configID:449 onParse FileIPv6Config:" + str);
        if (!TextUtils.isEmpty(str)) {
            str2 = str.toLowerCase();
        } else {
            str2 = "";
        }
        if (TextUtils.isEmpty(str2)) {
            QLog.w("QFileIPv6ConfigBean", 1, "FileIPv6ConfigContent is empty, configID:449 use default value");
            b();
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2).getJSONObject("ipv6config");
            if (jSONObject != null) {
                if (jSONObject.has("allswitch")) {
                    this.f202778d = jSONObject.getBoolean("allswitch");
                } else {
                    this.f202778d = false;
                }
                if (jSONObject.has("c2cenable")) {
                    this.f202779e = jSONObject.getBoolean("c2cenable");
                } else {
                    this.f202779e = false;
                }
                if (jSONObject.has("groupenable")) {
                    this.f202780f = jSONObject.getBoolean("groupenable");
                } else {
                    this.f202780f = false;
                }
                if (jSONObject.has("discenable")) {
                    this.f202781h = jSONObject.getBoolean("discenable");
                } else {
                    this.f202781h = false;
                }
                if (jSONObject.has("datalineenable")) {
                    this.f202782i = jSONObject.getBoolean("datalineenable");
                } else {
                    this.f202782i = false;
                }
                if (jSONObject.has(AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY)) {
                    this.f202783m = jSONObject.getInt(AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY);
                    return;
                } else {
                    this.f202783m = 0;
                    return;
                }
            }
            QLog.w("QFileIPv6ConfigBean", 1, "FileIPv6ConfigContent is no ipv6config. use default value");
            b();
        } catch (JSONException e16) {
            QLog.e("QFileIPv6ConfigBean", 1, e16, new Object[0]);
        }
    }
}
