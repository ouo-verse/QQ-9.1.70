package com.tencent.open;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, d> f341531a = new HashMap();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final e f341532a = new e();
    }

    e() {
    }

    public static e b() {
        return a.f341532a;
    }

    private void d(AppRuntime appRuntime) {
        JSONObject jSONObject;
        if (!this.f341531a.isEmpty() || appRuntime == null || (jSONObject = ((IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).getJSONObject("opensdk_browser_scheme_white_list_868786471", "")) == null) {
            return;
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("browsers");
            if (jSONArray == null) {
                return;
            }
            HashMap hashMap = new HashMap(jSONArray.length());
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                d a16 = d.a(jSONArray.getJSONObject(i3));
                if (a16 != null) {
                    hashMap.put(a16.f341143c, a16);
                }
            }
            synchronized (this.f341531a) {
                this.f341531a.clear();
                this.f341531a.putAll(hashMap);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public String a(AppRuntime appRuntime, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        d(appRuntime);
        d dVar = this.f341531a.get(str);
        if (dVar == null) {
            return "";
        }
        return dVar.f341145e;
    }

    @NonNull
    public String c(AppRuntime appRuntime, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        d(appRuntime);
        d dVar = this.f341531a.get(str);
        if (dVar == null) {
            return "";
        }
        return dVar.f341142b;
    }
}
