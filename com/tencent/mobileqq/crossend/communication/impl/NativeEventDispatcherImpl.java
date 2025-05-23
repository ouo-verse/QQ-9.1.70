package com.tencent.mobileqq.crossend.communication.impl;

import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.crossend.communication.INativeEventDispatcher;
import com.tencent.mobileqq.mini.api.IMiniContainer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.ag;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.a;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class NativeEventDispatcherImpl implements INativeEventDispatcher {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "NativeEventDispatcherImpl";

    public NativeEventDispatcherImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void onNativeEventH5(String str, JSONObject jSONObject) {
        String jSONObject2;
        WebViewPlugin b16 = ag.b("QQWebApi");
        if (b16 == null) {
            return;
        }
        String[] strArr = new String[1];
        if (jSONObject == null) {
            jSONObject2 = "";
        } else {
            jSONObject2 = jSONObject.toString();
        }
        strArr[0] = jSONObject2;
        b16.callJs(str, strArr);
    }

    private void onNativeEventHippy(Object obj, String str, JSONObject jSONObject) {
        if (obj instanceof HippyQQEngine) {
            HippyMap hippyMap = new HippyMap();
            if (jSONObject == null) {
                onNativeEventHippyInner((HippyQQEngine) obj, str, hippyMap);
                return;
            } else {
                hippyMap.pushObject("data", jSONObject);
                onNativeEventHippyInner((HippyQQEngine) obj, str, hippyMap);
                return;
            }
        }
        throw new RuntimeException("[onNativeEventHippy] fail, instance is not subtype of BaseHippyFragment");
    }

    private void onNativeEventHippyInner(HippyQQEngine hippyQQEngine, String str, HippyMap hippyMap) {
        try {
            ((EventDispatcher) hippyQQEngine.getHippyEngine().getEngineContext().getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent(str, hippyMap);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    private void onNativeEventLua(Object obj, String str, JSONObject jSONObject) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (jSONObject == null) {
                aVar.callLua(str, (a.b) null, false);
                return;
            } else {
                aVar.callLua(str, jSONObject.toString(), (a.b) null, false);
                return;
            }
        }
        throw new RuntimeException("[onNativeEventLua] fail, instance is not subtype of ILuaCaller");
    }

    private void onNativeEventMini(String str, JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            ((IMiniContainer) QRoute.api(IMiniContainer.class)).dispatchNativeEvent(str, hashMap);
        } else {
            hashMap.put("data", jSONObject);
            ((IMiniContainer) QRoute.api(IMiniContainer.class)).dispatchNativeEvent(str, hashMap);
        }
    }

    @Override // com.tencent.mobileqq.crossend.communication.INativeEventDispatcher
    public void request(int i3, Object obj, String str, JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), obj, str, jSONObject);
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        onNativeEventLua(obj, str, jSONObject);
                        return;
                    }
                    QLog.e(TAG, 1, "invalid web type: " + i3);
                    throw new RuntimeException("invalid web type: " + i3);
                }
                onNativeEventHippy(obj, str, jSONObject);
                return;
            }
            onNativeEventMini(str, jSONObject);
            return;
        }
        onNativeEventH5(str, jSONObject);
    }
}
