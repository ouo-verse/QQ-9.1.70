package com.tencent.gdtad.basics.motivevideo.hippy.method;

import android.text.TextUtils;
import com.tencent.ad.tangram.json.AdJSONUtil;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.event.DKMethodHandler;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a implements DKMethodHandler {

    /* renamed from: d, reason: collision with root package name */
    private final WeakReference<om0.a> f109011d;

    public a(WeakReference<om0.a> weakReference) {
        this.f109011d = weakReference;
    }

    private void a(JSONObject jSONObject, DKMethodHandler.Callback callback) {
        om0.a aVar;
        if (!AdJSONUtil.isJSONObjectNull(jSONObject)) {
            int optInt = AdJSONUtil.optInt(jSONObject, "status", 0);
            String optString = AdJSONUtil.optString(jSONObject, "errMsg", "");
            QLog.i("GdtMotiveAdInitMethodHandler ", 1, "[handleNativeRenderEvent] status:" + optInt + " errorMsg:" + optString);
            WeakReference<om0.a> weakReference = this.f109011d;
            if (weakReference != null) {
                aVar = weakReference.get();
            } else {
                aVar = null;
            }
            if (aVar != null) {
                aVar.d(optInt, optString);
            }
            if (callback != null) {
                callback.onResult(null);
            }
        }
    }

    private void b(DKMethodHandler.Callback callback) {
        om0.a aVar;
        WeakReference<om0.a> weakReference = this.f109011d;
        if (weakReference != null) {
            aVar = weakReference.get();
        } else {
            aVar = null;
        }
        if (aVar != null) {
            aVar.b();
        }
        if (callback != null) {
            callback.onResult(null);
        }
    }

    private void c(JSONObject jSONObject, DKMethodHandler.Callback callback) {
        om0.a aVar;
        WeakReference<om0.a> weakReference = this.f109011d;
        if (weakReference != null) {
            aVar = weakReference.get();
        } else {
            aVar = null;
        }
        String optString = AdJSONUtil.optString(AdJSONUtil.optJSONObject(jSONObject, "extra"), "antiSpam", "");
        if (aVar != null) {
            aVar.a(optString);
        }
        if (callback != null) {
            callback.onResult(null);
        }
    }

    @Override // com.tencent.ams.dsdk.event.DKMethodHandler
    public String getModuleId() {
        return "AdCommon";
    }

    @Override // com.tencent.ams.dsdk.event.DKMethodHandler
    public boolean invoke(DKEngine dKEngine, String str, JSONObject jSONObject, DKMethodHandler.Callback callback) {
        if (TextUtils.isEmpty(str)) {
            QLog.i("GdtMotiveAdInitMethodHandler ", 1, "[invoke] methodName is empty.");
            return false;
        }
        QLog.i("GdtMotiveAdInitMethodHandler ", 1, "[invoke] methodName:" + str + " params:" + AdJSONUtil.toString(jSONObject));
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case 32005132:
                if (str.equals("onNativeRender")) {
                    c16 = 0;
                    break;
                }
                break;
            case 273540089:
                if (str.equals("onAdPresent")) {
                    c16 = 1;
                    break;
                }
                break;
            case 811723230:
                if (str.equals(AdCommonMethodHandler.AdCommonEvent.CLICK_ACTION)) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                a(jSONObject, callback);
                return true;
            case 1:
                b(callback);
                return true;
            case 2:
                c(jSONObject, callback);
                return true;
            default:
                return false;
        }
    }
}
