package com.tencent.ams.dsdk.core;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.ams.dsdk.cache.ModuleConfigCache;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.data.ModuleInfo;
import com.tencent.ams.dsdk.fodder.BundleEventListener;
import com.tencent.ams.dsdk.fodder.BusinessBundleManager;
import com.tencent.ams.dsdk.fodder.VendorBundleManager;
import com.tencent.ams.dsdk.monitor.metric.DynamicReporter;
import com.tencent.ams.dsdk.monitor.metric.event.TagValue;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.utils.HttpUtils;
import com.tencent.ams.dsdk.utils.SharedPreferencedUtil;
import com.tencent.ams.dsdk.utils.WorkThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DKBundleManager {
    static IPatchRedirector $redirector_ = null;
    private static final int MAX_RETRY = 3;
    private static final int REQUEST_TIMEOUT = 3000;
    private static final String TAG = "DKBundleManager";
    private static volatile DKBundleManager sInstance;

    DKBundleManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doPreloadBundles() {
        DLog.d(TAG, "doPreloadBundles");
        List<ModuleInfo> requestBundleConfig = requestBundleConfig();
        SharedPreferencedUtil.updateLastUpdateBundleConfigTime();
        BusinessBundleManager.getInstance().clearCache(requestBundleConfig);
        VendorBundleManager.getInstance().clearCache(requestBundleConfig);
        BusinessBundleManager.getInstance().updateBundles(requestBundleConfig);
        VendorBundleManager.getInstance().updateBundles(requestBundleConfig);
    }

    public static DKBundleManager getInstance() {
        if (sInstance == null) {
            synchronized (DKBundleManager.class) {
                if (sInstance == null) {
                    sInstance = new DKBundleManager();
                }
            }
        }
        return sInstance;
    }

    public static String getModuleVersion(String str) {
        ModuleInfo moduleInfo;
        String str2;
        if (!TextUtils.isEmpty(str) && (moduleInfo = ModuleConfigCache.getModuleInfo(str)) != null && BusinessBundleManager.getInstance().checkModuleBundleExits(moduleInfo)) {
            List<String> dependencies = moduleInfo.getDependencies();
            if (dependencies != null && !dependencies.isEmpty()) {
                str2 = dependencies.get(0);
            } else {
                str2 = DKConfiguration.Directory.VENDOR;
            }
            ModuleInfo moduleInfo2 = ModuleConfigCache.getModuleInfo(str2);
            if (moduleInfo2 != null && VendorBundleManager.getInstance().checkModuleBundleExits(moduleInfo2)) {
                return moduleInfo.getVersion();
            }
        }
        return null;
    }

    private void notifyBundleRequestFinish(int i3, long j3) {
        long currentTimeMillis = System.currentTimeMillis() - j3;
        DLog.i(TAG, "notifyBundleRequestFinish, statusCode: " + i3 + ", timeCost: " + currentTimeMillis);
        BundleEventListener bundleEventListener = DKConfiguration.getBundleEventListener();
        if (bundleEventListener != null) {
            bundleEventListener.onRequestBundleConfigFinish(i3, currentTimeMillis);
        }
    }

    private void notifyBundleRequestStart() {
        DLog.i(TAG, "notifyBundleRequestStart");
        BundleEventListener bundleEventListener = DKConfiguration.getBundleEventListener();
        if (bundleEventListener != null) {
            bundleEventListener.onRequestBundleConfigStart();
        }
    }

    private List<ModuleInfo> parseBundleConfig(JSONObject jSONObject) {
        DLog.d(TAG, "parseBundleConfig");
        if (jSONObject == null) {
            DLog.w(TAG, "config object is null.");
            return null;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("modules");
        if (optJSONArray == null) {
            DLog.w(TAG, "hippy_modules node is null.");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            ModuleInfo parseModuleInfo = parseModuleInfo(optJSONArray.optJSONObject(i3));
            if (parseModuleInfo != null) {
                DLog.d(TAG, "parse module info: " + parseModuleInfo);
                arrayList.add(parseModuleInfo);
            }
        }
        return arrayList;
    }

    private ModuleInfo parseModuleInfo(JSONObject jSONObject) {
        DLog.d(TAG, "parseModuleInfo");
        if (jSONObject == null) {
            DLog.w(TAG, "module info config is null.");
            return null;
        }
        String optString = jSONObject.optString("id");
        String optString2 = jSONObject.optString("version");
        boolean optBoolean = jSONObject.optBoolean("force_update");
        int optInt = jSONObject.optInt("file_type");
        String optString3 = jSONObject.optString("url");
        String optString4 = jSONObject.optString("name");
        String optString5 = jSONObject.optString("md5");
        int optInt2 = jSONObject.optInt("encrypt_version");
        JSONObject optJSONObject = jSONObject.optJSONObject("extra_info");
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("dependencies");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                arrayList.add(optJSONArray.optString(i3));
            }
        }
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
            return new ModuleInfo(optString, optString2, optBoolean, optString4, optInt, optString3, optString5, optInt2, optJSONObject, arrayList);
        }
        DLog.w(TAG, "module info config is invalid.");
        return null;
    }

    private List<ModuleInfo> requestBundleConfig() {
        String jSONObject;
        byte[] bytes;
        int i3;
        DLog.d(TAG, "requestBundleConfig");
        long currentTimeMillis = System.currentTimeMillis();
        long uptimeMillis = SystemClock.uptimeMillis();
        String bundleConfigUrl = DKConfiguration.getBundleConfigUrl();
        if (TextUtils.isEmpty(bundleConfigUrl)) {
            DLog.w(TAG, "config url is null.");
            return null;
        }
        DLog.d(TAG, "bundle config url: " + bundleConfigUrl);
        notifyBundleRequestStart();
        DynamicReporter.reportBundleConfigGetStart();
        JSONObject createRequestBody = HttpUtils.createRequestBody();
        if (createRequestBody == null) {
            jSONObject = null;
        } else {
            jSONObject = createRequestBody.toString();
        }
        if (jSONObject == null) {
            bytes = null;
        } else {
            bytes = jSONObject.getBytes();
        }
        String postHttpJson = HttpUtils.postHttpJson(bundleConfigUrl, bytes, 3000, 3);
        if (TextUtils.isEmpty(postHttpJson)) {
            DLog.w(TAG, "config response is null.");
            DynamicReporter.reportBundleConfigGetEnd(uptimeMillis, TagValue.RESP_EMPTY);
            notifyBundleRequestFinish(1, currentTimeMillis);
            return null;
        }
        DLog.d(TAG, "bundle config response: " + postHttpJson);
        try {
            List<ModuleInfo> parseBundleConfig = parseBundleConfig(new JSONObject(postHttpJson));
            if (parseBundleConfig != null) {
                i3 = 0;
            } else {
                i3 = 2;
            }
            DynamicReporter.reportBundleConfigGetEnd(uptimeMillis, "none");
            notifyBundleRequestFinish(i3, currentTimeMillis);
            return parseBundleConfig;
        } catch (Throwable th5) {
            DLog.e(TAG, "config response format error.", th5);
            DynamicReporter.reportBundleConfigGetEnd(uptimeMillis, TagValue.PARSE_ERROR);
            notifyBundleRequestFinish(2, currentTimeMillis);
            return null;
        }
    }

    public String getModuleBundleFilePath(String str, boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? BusinessBundleManager.getInstance().getModuleBundleFilePath(str, z16, j3) : (String) iPatchRedirector.redirect((short) 5, this, str, Boolean.valueOf(z16), Long.valueOf(j3));
    }

    @Deprecated
    public String getVendorBundleFilePath(boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? VendorBundleManager.getInstance().getVendorBundleFilePath(z16, j3) : (String) iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Long.valueOf(j3));
    }

    public void preloadBundles() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            DLog.d(TAG, "preloadBundles");
            WorkThreadManager.getInstance().getImmediateThreadPool().execute(new Runnable() { // from class: com.tencent.ams.dsdk.core.DKBundleManager.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DKBundleManager.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        DKBundleManager.this.doPreloadBundles();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    public String getModuleBundleFilePath(ModuleInfo moduleInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? BusinessBundleManager.getInstance().getModuleBundleFilePath(moduleInfo) : (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) moduleInfo);
    }

    public String getVendorBundleFilePath(String str, boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? VendorBundleManager.getInstance().getVendorBundleFilePath(str, z16, j3) : (String) iPatchRedirector.redirect((short) 4, this, str, Boolean.valueOf(z16), Long.valueOf(j3));
    }
}
