package com.tencent.gamecenter.wadl.sdk.common.d.k.b.g;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.sdk.common.b.g;
import com.tencent.gamecenter.wadl.sdk.common.d.k.b.c;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a extends com.tencent.gamecenter.wadl.sdk.common.d.k.b.b {

    /* renamed from: a, reason: collision with root package name */
    private final g.a f107224a = new g.a();

    /* compiled from: P */
    /* renamed from: com.tencent.gamecenter.wadl.sdk.common.d.k.b.g.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class RunnableC1129a implements Runnable {
        RunnableC1129a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String string = com.tencent.gamecenter.wadl.sdk.common.a.b().getSharedPreferences(a.this.f(), 0).getString("Wadl_cloud_param_content", "");
            com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-cloud-HttpRspSetting", "loadLocal jsonData:" + string);
            if (!TextUtils.isEmpty(string)) {
                try {
                    a.this.f107224a.a(string);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                    a.this.a("");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                c.d().e().a(a.this.f107224a.b(), com.tencent.gamecenter.wadl.sdk.common.d.k.a.b.a().c());
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    public a() {
        com.tencent.gamecenter.wadl.sdk.common.a.g().post(new RunnableC1129a());
    }

    private void e() {
        com.tencent.gamecenter.wadl.sdk.common.a.g().post(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Wadl_Cloud_Param_Content_");
        sb5.append(com.tencent.gamecenter.wadl.sdk.common.a.c());
        sb5.append("_for_SettingsHandler");
        if (com.tencent.gamecenter.wadl.sdk.common.a.i()) {
            str = "_test";
        } else {
            str = "";
        }
        sb5.append(str);
        return sb5.toString();
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.k.b.b, com.tencent.gamecenter.wadl.sdk.common.d.a
    public void c() {
        e();
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.k.b.b
    public String d() {
        return QCircleDaTongConstant.ElementParamValue.SETTINGS;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.k.b.b
    public void a(com.tencent.gamecenter.wadl.sdk.common.d.k.b.a aVar) {
        aVar.a("confVersion", this.f107224a.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        com.tencent.gamecenter.wadl.sdk.common.a.b().getSharedPreferences(f(), 0).edit().putString("Wadl_cloud_param_content", str).commit();
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.k.b.b
    public void a(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("Setting");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("data");
                if (!TextUtils.isEmpty(optString)) {
                    this.f107224a.a(optString);
                    a(this.f107224a.b());
                }
            }
        } finally {
            try {
            } finally {
            }
        }
    }
}
