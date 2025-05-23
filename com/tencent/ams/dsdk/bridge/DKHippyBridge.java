package com.tencent.ams.dsdk.bridge;

import android.text.TextUtils;
import com.tencent.ams.dsdk.event.DKMethodDispatcher;
import com.tencent.ams.dsdk.event.DKMethodHandler;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import org.json.JSONObject;

/* compiled from: P */
@HippyNativeModule(name = DKHippyBridge.CLASS_NAME)
/* loaded from: classes3.dex */
public class DKHippyBridge extends HippyNativeModuleBase {
    static IPatchRedirector $redirector_ = null;
    public static final String CLASS_NAME = "DKBridge";
    private static final String KEY_METHOD = "method";
    private static final String KEY_MODULE = "module";
    private static final String KEY_PARAMS = "params";
    private static final String TAG = "DKHippyBridge";
    private DKMethodDispatcher mMethodDispatcher;

    public DKHippyBridge(HippyEngineContext hippyEngineContext, DKMethodDispatcher dKMethodDispatcher) {
        super(hippyEngineContext);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hippyEngineContext, (Object) dKMethodDispatcher);
        } else {
            this.mMethodDispatcher = dKMethodDispatcher;
        }
    }

    private HippyMap buildResult(int i3, String str, Object obj) {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushInt("code", i3);
        hippyMap.pushString("msg", str);
        if (obj != null) {
            if (obj instanceof JSONObject) {
                HippyMap hippyMap2 = new HippyMap();
                hippyMap2.pushJSONObject((JSONObject) obj);
                hippyMap.pushMap("result", hippyMap2);
            } else {
                try {
                    hippyMap.pushObject("result", obj);
                } catch (Throwable th5) {
                    DLog.e(TAG, "unsupport object type.", th5);
                }
            }
        }
        return hippyMap;
    }

    private void handleDispatcher(String str, String str2, HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        if (hippyMap == null) {
            jSONObject = null;
        } else {
            try {
                jSONObject = hippyMap.toJSONObject();
            } catch (Throwable th5) {
                DLog.e(TAG, "invoke error.", th5);
                reject(-3, th5.getMessage(), null, promise);
                return;
            }
        }
        DKMethodDispatcher dKMethodDispatcher = this.mMethodDispatcher;
        if (dKMethodDispatcher == null || !dKMethodDispatcher.dispatcher(str, str2, jSONObject, new DKMethodHandler.Callback(promise) { // from class: com.tencent.ams.dsdk.bridge.DKHippyBridge.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Promise val$promise;

            {
                this.val$promise = promise;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DKHippyBridge.this, (Object) promise);
                }
            }

            @Override // com.tencent.ams.dsdk.event.DKMethodHandler.Callback
            public void onFailure(int i3, String str3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    DKHippyBridge.this.reject(i3, str3, null, this.val$promise);
                } else {
                    iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str3);
                }
            }

            @Override // com.tencent.ams.dsdk.event.DKMethodHandler.Callback
            public void onResult(Object obj) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, obj);
                    return;
                }
                Promise promise2 = this.val$promise;
                if (promise2 != null) {
                    if (obj instanceof JSONObject) {
                        HippyMap hippyMap2 = new HippyMap();
                        hippyMap2.pushJSONObject((JSONObject) obj);
                        this.val$promise.resolve(hippyMap2);
                        return;
                    }
                    promise2.resolve(obj);
                }
            }
        })) {
            reject(-2, "cant't find " + str + "." + str2 + " method handler.", null, promise);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reject(int i3, String str, Object obj, Promise promise) {
        if (promise != null) {
            promise.reject(buildResult(i3, str, obj));
        }
    }

    @HippyMethod(name = "invoke")
    public void invoke(HippyMap hippyMap, Promise promise) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) hippyMap, (Object) promise);
            return;
        }
        DLog.d(TAG, "invoke, params: " + hippyMap);
        if (hippyMap == null) {
            reject(-1, "params is null", null, promise);
            return;
        }
        String string = hippyMap.getString("module");
        String string2 = hippyMap.getString("method");
        HippyMap map = hippyMap.getMap("params");
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
            handleDispatcher(string, string2, map, promise);
        } else {
            reject(-1, "moduleId or methodName is empty.", null, promise);
        }
    }
}
