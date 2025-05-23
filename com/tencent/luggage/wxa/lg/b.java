package com.tencent.luggage.wxa.lg;

import android.text.TextUtils;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.p;
import com.tencent.xweb.updater.IXWebBroadcastListener;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum b {
    UPDATING(IXWebBroadcastListener.STAGE_PROGRESSED),
    NO_UPDATE("noUpdate"),
    UPDATE_READY("updateReady"),
    UPDATE_FAILED("updateFailed");


    /* renamed from: a, reason: collision with root package name */
    public final String f133409a;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.lg.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6441b extends p {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onUpdateStatusChange";

        public C6441b() {
        }
    }

    b(String str) {
        this.f133409a = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f133409a;
    }

    public void a(l lVar, int i3, String str, String str2, String str3) {
        if (lVar == null) {
            return;
        }
        w.d("MicroMsg.AppBrand.Version.UpdateState[appversion]", "dispatch(%s), appId:%s, service:%d, intVersion:%d, stringVersion:%s, passThroughInfo:%s, stablePassThroughInfo:%s", this.f133409a, lVar.getAppId(), Integer.valueOf(lVar.hashCode()), Integer.valueOf(i3), str, str2, str3);
        HashMap hashMap = new HashMap(1);
        hashMap.put("state", this.f133409a);
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("passThroughInfo", new JSONObject(str2));
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("stablePassThroughInfo", new JSONObject(str3));
            }
            if (jSONObject.length() > 0) {
                hashMap.put("appContactInfo", jSONObject);
            }
        } catch (JSONException e16) {
            w.b("MicroMsg.AppBrand.Version.UpdateState[appversion]", "dispatch(%s), appId:%s, service:%d, put passThroughInfo get Exception:%s", this.f133409a, lVar.getAppId(), Integer.valueOf(lVar.hashCode()), e16);
        }
        hashMap.put("appVersion", Integer.valueOf(i3));
        hashMap.put("customVersion", str);
        new C6441b().setContext(lVar).setData(hashMap).dispatch();
    }
}
