package com.tencent.hippy.qq.module;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.utils.HippyModuleUtils;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.PromiseImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
@HippyNativeModule(name = JSITicketModule.CLASS_NAME)
/* loaded from: classes7.dex */
public class JSITicketModule extends QQBaseModule {
    static final String CLASS_NAME = "JSITicketModule";

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private static class PSKeyCallback implements sd2.a {
        private Promise promise;
        private String bundleName = "";
        private int bundleVersion = 0;
        private String reportFrom = "";
        private String domain = "";

        PSKeyCallback() {
        }

        @Override // sd2.a
        public void onFail(@NonNull String str) {
            this.promise.resolve("");
            QLog.e(JSITicketModule.CLASS_NAME, 1, "getPSKey reportFrom:", this.reportFrom, " failed:", str);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("domain", this.domain);
            hashMap.put("reportFrom", this.reportFrom);
            hashMap.put(HippyReporter.EXTRA_KEY_REPORT_ERRMSG, str);
            HippyReporter.getInstance().reportToDengTa(this.bundleName, this.bundleVersion, HippyReporter.EventCode.HIPPY_PSKEY, -1, hashMap);
        }

        @Override // sd2.a
        public void onSuccess(@NonNull Map<String, String> map) {
            String str = map.get(this.domain);
            Promise promise = this.promise;
            if (str == null) {
                str = "";
            }
            promise.resolve(str);
        }
    }

    public JSITicketModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    private IPskeyManager getPSKeyManager() {
        AppInterface appInterface = HippyUtils.getAppInterface();
        if (appInterface != null) {
            return (IPskeyManager) appInterface.getRuntimeService(IPskeyManager.class, "all");
        }
        return null;
    }

    @HippyMethod(isSync = true, name = "getPSKey")
    public void getPSKey(Promise promise) {
        String str;
        int i3;
        ((PromiseImpl) promise).setContext(this.mContext);
        HippyQQEngine engineInstance = HippyQQEngine.getEngineInstance(this.mContext.getEngineId());
        PSKeyCallback pSKeyCallback = new PSKeyCallback();
        if (engineInstance == null) {
            str = "";
        } else {
            str = engineInstance.getModuleName();
        }
        pSKeyCallback.bundleName = str;
        if (engineInstance != null) {
            i3 = engineInstance.getModuleVersion();
        } else {
            i3 = 0;
        }
        pSKeyCallback.bundleVersion = i3;
        pSKeyCallback.reportFrom = "getPSKey";
        pSKeyCallback.domain = HippyModuleUtils.getDomain(getFragment(), engineInstance);
        pSKeyCallback.promise = promise;
        IPskeyManager pSKeyManager = getPSKeyManager();
        if (pSKeyManager != null && !TextUtils.isEmpty(pSKeyCallback.domain)) {
            pSKeyManager.getPskey(new String[]{pSKeyCallback.domain}, pSKeyCallback);
        } else {
            promise.resolve("");
            QLog.e("HippyAccessHelper", 1, "getPSKey error domain:", pSKeyCallback.domain, " psKeyManager:", pSKeyManager);
        }
    }

    @HippyMethod(isSync = true, name = "replacePSKey")
    public void replacePSKey(Promise promise) {
        String str;
        int i3;
        ((PromiseImpl) promise).setContext(this.mContext);
        HippyQQEngine engineInstance = HippyQQEngine.getEngineInstance(this.mContext.getEngineId());
        PSKeyCallback pSKeyCallback = new PSKeyCallback();
        if (engineInstance == null) {
            str = "";
        } else {
            str = engineInstance.getModuleName();
        }
        pSKeyCallback.bundleName = str;
        if (engineInstance != null) {
            i3 = engineInstance.getModuleVersion();
        } else {
            i3 = 0;
        }
        pSKeyCallback.bundleVersion = i3;
        pSKeyCallback.reportFrom = "replacePSKey";
        pSKeyCallback.domain = HippyModuleUtils.getDomain(getFragment(), engineInstance);
        pSKeyCallback.promise = promise;
        IPskeyManager pSKeyManager = getPSKeyManager();
        if (pSKeyManager != null && !TextUtils.isEmpty(pSKeyCallback.domain)) {
            pSKeyManager.replacePskey(new String[]{pSKeyCallback.domain}, pSKeyCallback);
        } else {
            promise.resolve("");
            QLog.e("HippyAccessHelper", 1, "replacePSKey error domain:", pSKeyCallback.domain, " psKeyManager:", pSKeyManager);
        }
    }
}
