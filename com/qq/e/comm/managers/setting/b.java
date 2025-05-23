package com.qq.e.comm.managers.setting;

import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f38229a;

    public b() {
        this.f38229a = new JSONObject();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object a(String str) {
        return this.f38229a.opt(str);
    }

    public String toString() {
        return "GDTSDKSetting[" + this.f38229a.toString() + "]";
    }

    public b(String str) {
        this();
        GDTLogger.d("Initialize GDTSDKSetting,Json=" + str);
        if (StringUtil.isEmpty(str)) {
            return;
        }
        try {
            this.f38229a = new JSONObject(str);
        } catch (JSONException e16) {
            GDTLogger.report("Exception while building GDTSDKSetting from json", e16);
        }
    }

    public final void a() {
        this.f38229a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, Object obj) {
        try {
            this.f38229a.putOpt(str, obj);
        } catch (JSONException e16) {
            GDTLogger.e("Exception while update setting", e16);
        }
    }
}
