package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ax implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    private boolean f202562d;

    /* renamed from: e, reason: collision with root package name */
    private int f202563e;

    /* renamed from: f, reason: collision with root package name */
    private String f202564f = "";

    /* renamed from: h, reason: collision with root package name */
    private String f202565h = "";

    public static ax e(String str) {
        if (str == null) {
            return null;
        }
        try {
            ax axVar = new ax();
            JSONObject jSONObject = new JSONObject(str);
            boolean z16 = true;
            if (jSONObject.optInt("enable", 0) != 1) {
                z16 = false;
            }
            axVar.f202562d = z16;
            axVar.f202563e = jSONObject.optInt("showCount", 0);
            axVar.f202564f = jSONObject.optString("c2cTipsContent", "");
            axVar.f202565h = jSONObject.optString("c2cHighlightContent", "");
            return axVar;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public String a() {
        if (TextUtils.isEmpty(this.f202565h)) {
            return "\u6253\u5f00\u6d88\u606f\u63a8\u9001";
        }
        return this.f202565h;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f202564f)) {
            return "\u60f3\u53ca\u65f6\u6536\u5230\u5bf9\u65b9\u7684\u56de\u590d\uff0c\u5feb\u53bb\u6253\u5f00\u6d88\u606f\u63a8\u9001\u8bbe\u7f6e\u5427\u3002";
        }
        return this.f202564f;
    }

    public int c() {
        return this.f202563e;
    }

    public boolean d() {
        return this.f202562d;
    }

    public void f(boolean z16) {
        this.f202562d = z16;
    }
}
