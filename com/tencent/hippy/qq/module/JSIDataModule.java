package com.tencent.hippy.qq.module;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.api.HippyInterpolator;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.api.ISSRBundleRequester;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.fragment.BaseHippyFragment;
import com.tencent.hippy.qq.interpolators.HippyInterpolatorConfig;
import com.tencent.hippy.qq.update.HippyQQFileUtil;
import com.tencent.hippy.qq.utils.HippyAccessHelper;
import com.tencent.hippy.qq.utils.HippyModuleUtils;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.PromiseImpl;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@HippyNativeModule(name = JSIDataModule.CLASS_NAME)
/* loaded from: classes7.dex */
public class JSIDataModule extends QQBaseModule {
    public static final String CLASS_NAME = "JSIDataModule";
    private static final String KEY_ERROR_MESSAGE = "errMsg";
    private static final String KEY_RESULT_CODE = "retCode";
    private static final int SSR_RESULT_EXECUTE_FAILED = -1;
    private static final int SSR_RESULT_NO_SSR = -3;
    private static final int SSR_RESULT_OK = 0;
    private static final int SSR_RESULT_REQUEST_FAILED = -2;

    public JSIDataModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    private void callbackResult(Promise promise, int i3, String str) {
        if (promise != null) {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushInt("retCode", i3);
            hippyMap.pushString("errMsg", str);
            promise.resolve(hippyMap);
        }
    }

    private ISSRBundleRequester getSSRBundleRequester() {
        ISSRBundleRequester iSSRBundleRequester;
        QBaseFragment fragment;
        HippyInterpolator interpolator = HippyInterpolatorConfig.getInterpolator(getBundleName());
        if (interpolator != null) {
            iSSRBundleRequester = interpolator.getSSRBundleRequester();
        } else {
            iSSRBundleRequester = null;
        }
        if (iSSRBundleRequester == null && (fragment = getFragment()) != null && (fragment instanceof BaseHippyFragment)) {
            return ((BaseHippyFragment) fragment).getSSRBundleRequester();
        }
        return iSSRBundleRequester;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$executeSSRDataJs$0(Promise promise, int i3, String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(CLASS_NAME, 2, "getSSRBundle code:", Integer.valueOf(i3), " msg:", str, " isJsEmpty:", Boolean.valueOf(TextUtils.isEmpty(str2)));
        }
        HippyQQEngine hippyQQEngine = getHippyQQEngine();
        if (hippyQQEngine != null && !hippyQQEngine.isDestroyed()) {
            if (!TextUtils.isEmpty(str2)) {
                hippyQQEngine.runJavaScript(str2);
                callbackResult(promise, 0, "");
            } else {
                callbackResult(promise, -2, str);
            }
        }
    }

    private void mergeJson(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null) {
            Iterator keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                Object opt = jSONObject2.opt(str);
                if (!jSONObject.has(str)) {
                    try {
                        jSONObject.putOpt(str, opt);
                    } catch (JSONException e16) {
                        QLog.e(CLASS_NAME, 1, "mergeJson error:", e16);
                    }
                }
            }
        }
    }

    private void mergeMap(JSONObject jSONObject, HashMap<String, String> hashMap) {
        if (jSONObject != null && hashMap != null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key) && !jSONObject.has(key)) {
                    try {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    } catch (JSONException e16) {
                        QLog.e(CLASS_NAME, 1, "mergeMap e:", e16);
                    }
                }
            }
        }
    }

    @HippyMethod(isSync = true, name = "createPreRequestKey")
    public String createPreRequestKey(String str) {
        return HippyAccessHelper.getCurrentUin() + "_" + MD5Utils.toMD5(str);
    }

    @HippyMethod(isSync = true, name = "deleteCacheData")
    public boolean deleteCacheData(String str) {
        String str2;
        HippyQQEngine hippyQQEngine = getHippyQQEngine();
        if (hippyQQEngine != null) {
            str2 = hippyQQEngine.getModuleName();
        } else {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            File file = new File(HippyQQFileUtil.getBusinessDataDir(str2), str);
            try {
                if (file.exists()) {
                    return file.delete();
                }
            } catch (Exception e16) {
                QLog.e(CLASS_NAME, 1, "deleteCacheData error:", e16);
            }
        }
        return false;
    }

    @HippyMethod(isSync = true, name = "executeSSRDataJs")
    public void executeSSRDataJs(final Promise promise) {
        if (QLog.isColorLevel()) {
            QLog.d(CLASS_NAME, 2, "executeSSRDataJs start");
        }
        ((PromiseImpl) promise).setContext(this.mContext);
        ISSRBundleRequester sSRBundleRequester = getSSRBundleRequester();
        if (sSRBundleRequester == null) {
            callbackResult(promise, -3, "");
        } else {
            sSRBundleRequester.getSSRBundle(new ISSRBundleRequester.OnGetSSRBundleListener() { // from class: com.tencent.hippy.qq.module.b
                @Override // com.tencent.hippy.qq.api.ISSRBundleRequester.OnGetSSRBundleListener
                public final void onGetSSRBundle(int i3, String str, String str2) {
                    JSIDataModule.this.lambda$executeSSRDataJs$0(promise, i3, str, str2);
                }
            });
        }
    }

    @HippyMethod(isSync = true, name = "getBusinessData")
    public String getBusinessData() {
        OpenHippyInfo openHippyInfo;
        SerializableMap serializableMap;
        JSONObject businessData;
        try {
            String bundleName = getBundleName();
            if (TextUtils.isEmpty(bundleName)) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            HippyInterpolator interpolator = HippyInterpolatorConfig.getInterpolator(bundleName);
            if (interpolator != null && (businessData = interpolator.getBusinessData()) != null) {
                jSONObject = businessData;
            }
            QBaseFragment fragment = getFragment();
            if (fragment != null && (fragment instanceof BaseHippyFragment)) {
                mergeJson(jSONObject, ((BaseHippyFragment) fragment).generateBusinessData());
            }
            HippyQQEngine engineInstance = HippyQQEngine.getEngineInstance(this.mContext.getEngineId());
            if (engineInstance != null && (openHippyInfo = engineInstance.getOpenHippyInfo()) != null && (serializableMap = openHippyInfo.mExtraMap) != null) {
                mergeMap(jSONObject, serializableMap.getMap());
            }
            return jSONObject.toString();
        } catch (Throwable th5) {
            QLog.e(CLASS_NAME, 1, "getBusinessData error:", th5);
            return "";
        }
    }

    @HippyMethod(isSync = true, name = "getHippyInfo")
    public String getHippyInfo() {
        String str;
        int i3;
        HippyQQEngine engineInstance = HippyQQEngine.getEngineInstance(this.mContext.getEngineId());
        if (engineInstance != null) {
            str = engineInstance.getPageUrl();
        } else {
            str = null;
        }
        if (engineInstance != null) {
            i3 = engineInstance.getModuleVersion();
        } else {
            i3 = 0;
        }
        String openHippyFrom = HippyModuleUtils.getOpenHippyFrom(getFragment());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(VasWebviewConstants.KEY_PAGE_URL, str);
            jSONObject.put("version", i3);
            jSONObject.put("from", openHippyFrom);
            return jSONObject.toString();
        } catch (JSONException e16) {
            QLog.e(CLASS_NAME, 1, "getBusinessData error:", e16);
            return "";
        }
    }

    @HippyMethod(isSync = true, name = "getTabConfig")
    public String getTabConfig() {
        AppInterface appInterface;
        String readFileContent;
        String bundleName = getBundleName();
        if (TextUtils.isEmpty(bundleName) || (appInterface = getAppInterface()) == null) {
            return "";
        }
        File tabConfigFile = ((IHippyUpdate) QRoute.api(IHippyUpdate.class)).getTabConfigFile(appInterface.getCurrentUin(), bundleName);
        if (tabConfigFile == null || !tabConfigFile.exists() || (readFileContent = FileUtils.readFileContent(tabConfigFile)) == null) {
            return "";
        }
        return readFileContent;
    }

    @HippyMethod(isSync = true, name = "readCacheData")
    public String readCacheData(String str) {
        String str2;
        HippyQQEngine hippyQQEngine = getHippyQQEngine();
        if (hippyQQEngine != null) {
            str2 = hippyQQEngine.getModuleName();
        } else {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            File file = new File(HippyQQFileUtil.getBusinessDataDir(str2), str);
            if (!file.exists()) {
                return null;
            }
            return FileUtils.readFileContent(file);
        }
        return "";
    }

    @HippyMethod(isSync = true, name = ITVKPlayerEventListener.KEY_USER_INFO)
    public String userInfo() {
        String domain = HippyModuleUtils.getDomain(getFragment(), getHippyQQEngine());
        if (!((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).checkDomainPermission(domain)) {
            domain = null;
        }
        return HippyModuleUtils.getUserInfo(domain);
    }

    @HippyMethod(isSync = true, name = "writeCacheData")
    public boolean writeCacheData(String str, String str2) {
        String str3;
        HippyQQEngine hippyQQEngine = getHippyQQEngine();
        if (hippyQQEngine != null) {
            str3 = hippyQQEngine.getModuleName();
        } else {
            str3 = null;
        }
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) {
            return false;
        }
        File file = new File(HippyQQFileUtil.getBusinessDataDir(str3), str2);
        if (file.exists()) {
            file.delete();
        }
        if (!TextUtils.isEmpty(str)) {
            return FileUtils.writeFile(file.getAbsolutePath(), str, false);
        }
        return true;
    }
}
