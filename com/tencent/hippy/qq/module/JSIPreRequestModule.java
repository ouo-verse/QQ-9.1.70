package com.tencent.hippy.qq.module;

import android.text.TextUtils;
import com.tencent.hippy.qq.api.HippyInterpolator;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.fragment.BaseHippyFragment;
import com.tencent.hippy.qq.interpolators.HippyInterpolatorConfig;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.PromiseImpl;
import com.tencent.qphone.base.util.QLog;

@HippyNativeModule(name = JSIPreRequestModule.CLASS_NAME)
/* loaded from: classes7.dex */
public class JSIPreRequestModule extends QQBaseModule {
    public static final String CLASS_NAME = "JSIPreRequestModule";

    public JSIPreRequestModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    private int getOpenId() {
        QBaseFragment fragment = getFragment();
        if (fragment instanceof BaseHippyFragment) {
            return ((BaseHippyFragment) fragment).getOpenId();
        }
        if (fragment != null && fragment.getArguments() != null) {
            return fragment.getArguments().getInt("openId");
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPreRequestWithPromise$0(Promise promise, String str, String str2) {
        HippyQQEngine hippyQQEngine = getHippyQQEngine();
        if (hippyQQEngine != null && !hippyQQEngine.isDestroyed()) {
            if (str2 != null) {
                promise.resolve(str2);
                if (QLog.isColorLevel()) {
                    QLog.d(CLASS_NAME, 2, "getPreRequestWithPromise getPreRequestData rsp dataKey:", str);
                    return;
                }
                return;
            }
            promise.resolve("{}");
        }
    }

    @HippyMethod(isSync = true, name = "getPreRequest")
    public String getPreRequest(String str) {
        String bundleName;
        if (QLog.isColorLevel()) {
            QLog.d(CLASS_NAME, 2, "getPreRequest dataKey:", str);
        }
        try {
            bundleName = getBundleName();
        } catch (Throwable th5) {
            QLog.e(CLASS_NAME, 1, "getPreRequest error:", th5);
        }
        if (TextUtils.isEmpty(bundleName)) {
            return "{}";
        }
        int openId = getOpenId();
        HippyInterpolator interpolator = HippyInterpolatorConfig.getInterpolator(bundleName);
        if (interpolator != null) {
            String preRequestData = interpolator.getPreRequestData(openId, str);
            if (!TextUtils.isEmpty(preRequestData)) {
                if (QLog.isColorLevel()) {
                    QLog.d(CLASS_NAME, 2, "getPreRequest ret:", preRequestData);
                }
                return preRequestData;
            }
        }
        return "{}";
    }

    @HippyMethod(isSync = true, name = "getPreRequestWithPromise")
    public void getPreRequestWithPromise(final String str, final Promise promise) {
        if (QLog.isColorLevel()) {
            QLog.d(CLASS_NAME, 2, "getPreRequestWithPromise dataKey:", str);
        }
        String bundleName = getBundleName();
        if (promise != null && !TextUtils.isEmpty(bundleName)) {
            ((PromiseImpl) promise).setContext(this.mContext);
            HippyInterpolator interpolator = HippyInterpolatorConfig.getInterpolator(bundleName);
            if (interpolator == null) {
                return;
            }
            interpolator.getPreRequestData(getOpenId(), str, new HippyInterpolator.OnPreRequestListener() { // from class: com.tencent.hippy.qq.module.c
                @Override // com.tencent.hippy.qq.api.HippyInterpolator.OnPreRequestListener
                public final void onGetPreRequestData(String str2) {
                    JSIPreRequestModule.this.lambda$getPreRequestWithPromise$0(promise, str, str2);
                }
            });
        }
    }
}
