package com.tencent.ams.dsdk.event;

import android.text.TextUtils;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.event.DKMethodHandler;
import com.tencent.ams.dsdk.event.handler.CommonMethodHandler;
import com.tencent.ams.dsdk.event.handler.DefaultAdCommonMethodHandler;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DKMethodDispatcher {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DKMethodDispatcher";
    private static final Map<String, DKMethodHandler> sDefaultMethodHandles;
    private DKEngine mEngine;
    private final byte[] mHandlerLock;
    private final Map<String, DKMethodHandler> mMethodHandleCache;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface ErrorCode {
        public static final int METHOD_NOT_FOUND = -2;
        public static final int OK = 0;
        public static final int OTHER_ERROR = -3;
        public static final int PARAMS_ERROR = -1;
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18077);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        sDefaultMethodHandles = new HashMap();
        registerDefaultMethodHandler(new CommonMethodHandler());
        registerDefaultMethodHandler(new DefaultAdCommonMethodHandler());
    }

    public DKMethodDispatcher(DKEngine dKEngine) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dKEngine);
            return;
        }
        this.mHandlerLock = new byte[0];
        this.mMethodHandleCache = new HashMap();
        this.mEngine = dKEngine;
    }

    private DKMethodHandler getDefaultMethodHandle(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return sDefaultMethodHandles.get(str);
    }

    private DKMethodHandler getMethodHandler(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mMethodHandleCache.get(str);
    }

    private static void registerDefaultMethodHandler(DKMethodHandler dKMethodHandler) {
        if (dKMethodHandler != null && !TextUtils.isEmpty(dKMethodHandler.getModuleId())) {
            sDefaultMethodHandles.put(dKMethodHandler.getModuleId(), dKMethodHandler);
        }
    }

    public boolean dispatcher(String str, String str2, JSONObject jSONObject, DKMethodHandler.Callback callback) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, str, str2, jSONObject, callback)).booleanValue();
        }
        DKMethodHandler methodHandler = getMethodHandler(str);
        if (methodHandler == null) {
            DLog.d(TAG, "not found custom method handler");
            methodHandler = getDefaultMethodHandle(str);
        } else {
            z16 = false;
        }
        if (methodHandler == null) {
            DLog.d(TAG, "not found method handler.");
            return false;
        }
        String str3 = str + "." + str2;
        DLog.d(TAG, "dispatcher, method: " + str3 + ", params: " + jSONObject + ", handler: " + methodHandler);
        boolean invoke = methodHandler.invoke(this.mEngine, str2, jSONObject, callback);
        if (!invoke && !z16) {
            DLog.d(TAG, "custom register handler can't precess " + str3 + " event");
            DKMethodHandler defaultMethodHandle = getDefaultMethodHandle(str);
            if (defaultMethodHandle != null) {
                DLog.d(TAG, "use default method handler precess " + str3 + " event");
                return defaultMethodHandle.invoke(this.mEngine, str2, jSONObject, callback);
            }
            return invoke;
        }
        return invoke;
    }

    public boolean register(DKMethodHandler dKMethodHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) dKMethodHandler)).booleanValue();
        }
        if (dKMethodHandler == null) {
            return false;
        }
        synchronized (this.mHandlerLock) {
            String moduleId = dKMethodHandler.getModuleId();
            DLog.d(TAG, "register, key: " + moduleId + "handler: " + dKMethodHandler);
            if (TextUtils.isEmpty(moduleId)) {
                DLog.w(TAG, "register failed. moduleId or methodName is empty.");
                return false;
            }
            if (this.mMethodHandleCache.containsKey(moduleId)) {
                DLog.w(TAG, "register failed. " + moduleId + " has been registered.");
                return false;
            }
            this.mMethodHandleCache.put(moduleId, dKMethodHandler);
            return true;
        }
    }

    public boolean unregister(DKMethodHandler dKMethodHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) dKMethodHandler)).booleanValue();
        }
        if (dKMethodHandler == null) {
            return false;
        }
        synchronized (this.mHandlerLock) {
            String moduleId = dKMethodHandler.getModuleId();
            if (TextUtils.isEmpty(moduleId)) {
                DLog.w(TAG, "unregister failed. moduleId or methodName is empty.");
                return false;
            }
            if (!this.mMethodHandleCache.containsKey(moduleId)) {
                DLog.w(TAG, "unregister failed. " + moduleId + " has been registered.");
                return false;
            }
            this.mMethodHandleCache.remove(moduleId);
            return true;
        }
    }
}
