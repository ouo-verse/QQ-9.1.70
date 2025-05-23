package com.tencent.mobileqq.crossend.communication.base;

import com.tencent.hippy.qq.module.QQBaseModule;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
@HippyNativeModule(name = "QQCrossEndHippyModule")
/* loaded from: classes10.dex */
public class QQCrossEndHippyModule extends QQBaseModule {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QQCrossEndHippyPlugin";

    public QQCrossEndHippyModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hippyEngineContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$callNative$0(Promise promise, JSONObject jSONObject) {
        Object jSONObject2;
        try {
            if (jSONObject.getInt("code") == 0) {
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushInt("code", jSONObject.getInt("code"));
                if (jSONObject.has("data")) {
                    jSONObject2 = jSONObject.get("data");
                } else {
                    jSONObject2 = new JSONObject();
                }
                hippyMap.pushObject("data", jSONObject2);
                promise.resolve(hippyMap);
                return;
            }
            promise.reject("ErrorCode:" + jSONObject.getInt("code"));
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    @HippyMethod(name = "callNative")
    public void callNative(HippyMap hippyMap, final Promise promise) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) hippyMap, (Object) promise);
            return;
        }
        try {
            com.tencent.mobileqq.crossend.communication.core.a.d(hippyMap.getString("business"), hippyMap.getString("method"), hippyMap.toJSONObject().getJSONObject("data"), new ab1.a() { // from class: com.tencent.mobileqq.crossend.communication.base.c
                @Override // ab1.a
                public final void f(JSONObject jSONObject) {
                    QQCrossEndHippyModule.lambda$callNative$0(Promise.this, jSONObject);
                }
            });
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }
}
