package com.tencent.smtt.sdk.core.dynamicinstall;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.utils.AppUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private String f369328a;

    /* renamed from: b, reason: collision with root package name */
    private String f369329b;

    /* renamed from: c, reason: collision with root package name */
    private String f369330c;

    /* renamed from: d, reason: collision with root package name */
    private String f369331d;

    /* renamed from: e, reason: collision with root package name */
    private String f369332e;

    public static d f(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        d dVar = new d();
        JSONObject jSONObject = new JSONObject(str);
        dVar.a(jSONObject.getString("pkg"));
        dVar.b(jSONObject.getString(PreloadTRTCPlayerParams.KEY_SIG));
        dVar.c(jSONObject.getString("conf_id"));
        dVar.d(jSONObject.getString("key"));
        dVar.e(jSONObject.getString(TbsCoreSettings.TBS_BUSINESS_LICENSE_KEY));
        return dVar;
    }

    public String a() {
        return this.f369328a;
    }

    public String b() {
        return this.f369329b;
    }

    public String c() {
        return this.f369330c;
    }

    public String d() {
        return this.f369331d;
    }

    public void e(String str) {
        this.f369332e = str;
    }

    public void a(String str) {
        this.f369328a = str;
    }

    public void b(String str) {
        this.f369329b = str;
    }

    public void c(String str) {
        this.f369330c = str;
    }

    public void d(String str) {
        this.f369331d = str;
    }

    public String e() {
        return this.f369332e;
    }

    public static com.tencent.smtt.sdk.core.dynamicinstall.b.c a(d dVar, Context context) {
        String packageName = context.getApplicationContext().getPackageName();
        String sHA256Signature = AppUtil.getSHA256Signature(context.getApplicationContext());
        if (packageName != null && !TextUtils.isEmpty(packageName)) {
            if (sHA256Signature != null && !TextUtils.isEmpty(sHA256Signature)) {
                if (!packageName.equalsIgnoreCase(dVar.a())) {
                    return new com.tencent.smtt.sdk.core.dynamicinstall.b.c(-1011, "app name not match");
                }
                if (sHA256Signature.equals(dVar.b())) {
                    return null;
                }
                return new com.tencent.smtt.sdk.core.dynamicinstall.b.c(-1012, "app sig not match");
            }
            return new com.tencent.smtt.sdk.core.dynamicinstall.b.c(-1010, "app sig is empty");
        }
        return new com.tencent.smtt.sdk.core.dynamicinstall.b.c(-1009, "app name is empty");
    }
}
