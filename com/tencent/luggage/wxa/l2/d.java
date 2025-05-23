package com.tencent.luggage.wxa.l2;

import com.tencent.luggage.wxa.ae.o;
import com.tencent.luggage.wxa.i3.y;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import org.apache.commons.lang.ArrayUtils;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends a {
    public static final int CTRL_INDEX = 79;
    public static final String NAME = "operateWXData";

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f132966c = {"webapi_getuserallappauth", AuthorizeCenter.KEY_API_NAME_GET_USER_INFO, "webapi_getuserprofile", "webapi_getuseravatarpopupinfo"};

    /* renamed from: b, reason: collision with root package name */
    public final boolean f132967b;

    public d(boolean z16) {
        super(new o());
        this.f132967b = z16;
    }

    @Override // com.tencent.luggage.wxa.t2.a
    public boolean a(JSONObject jSONObject) {
        String str;
        if (jSONObject != null) {
            try {
                str = w0.d(jSONObject.getJSONObject("data").getString("api_name"));
            } catch (Throwable unused) {
                str = "";
            }
            if (y.f129448a.f().f128497e.contains(str)) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.l2.a, com.tencent.luggage.wxa.t2.a
    public boolean b(JSONObject jSONObject) {
        String jSONObject2;
        boolean z16;
        String str;
        Object[] objArr = new Object[1];
        if (jSONObject == null) {
            jSONObject2 = null;
        } else {
            jSONObject2 = jSONObject.toString();
        }
        objArr[0] = jSONObject2;
        w.d("JsApiOperateWXDataStandalone", "invoke with args %s", objArr);
        if (this.f132967b && jSONObject != null) {
            try {
                str = w0.d(jSONObject.getJSONObject("data").getString("api_name"));
            } catch (Throwable unused) {
                str = "";
            }
            if (ArrayUtils.contains(f132966c, str)) {
                z16 = true;
                if (z16 && !super.b(jSONObject)) {
                    return false;
                }
            }
        }
        z16 = false;
        return z16 ? true : true;
    }
}
