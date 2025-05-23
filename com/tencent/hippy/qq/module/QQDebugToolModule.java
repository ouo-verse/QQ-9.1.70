package com.tencent.hippy.qq.module;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.api.MMKVCommonFileKeys;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.update.HippyQQFileUtil;
import com.tencent.hippy.qq.utils.HippyDebugSoUtil;
import com.tencent.hippy.qq.utils.HippyDebugUtil;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRJumpApi;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@HippyNativeModule(name = QQDebugToolModule.CLASSNAME)
/* loaded from: classes7.dex */
public class QQDebugToolModule extends QQBaseLifecycleModule {
    protected static final String CLASSNAME = "QQDebugToolModule";
    private static final String FILE_PROTOCOL_JS_BUNDLE = "jsBundle://";
    private static final int REQ_CODE_QR_SCAN = 1;

    public QQDebugToolModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    private File getFileByPath(String str) {
        File rooDirByFileProtocol;
        if (!str.startsWith(FILE_PROTOCOL_JS_BUNDLE) || (rooDirByFileProtocol = getRooDirByFileProtocol(FILE_PROTOCOL_JS_BUNDLE)) == null) {
            return null;
        }
        return new File(rooDirByFileProtocol.getAbsolutePath() + str.substring(11));
    }

    private File getRooDirByFileProtocol(String str) {
        if (FILE_PROTOCOL_JS_BUNDLE.equals(str)) {
            return new File(HippyQQFileUtil.getHippyRootDir(), "bundle");
        }
        return null;
    }

    private JSONArray getSubFileList(File file) {
        JSONArray jSONArray = new JSONArray();
        if (file.exists() && !file.isFile()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return jSONArray;
            }
            for (int i3 = 0; i3 < listFiles.length; i3++) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("name", listFiles[i3].getName());
                    if (listFiles[i3].isFile()) {
                        jSONObject.put("type", "file");
                    } else {
                        jSONObject.put("type", QzoneZipCacheHelper.DIR);
                    }
                    jSONArray.mo162put(jSONObject);
                } catch (JSONException e16) {
                    QLog.e(CLASSNAME, 1, "getSubFileList e:", e16);
                }
            }
        }
        return jSONArray;
    }

    private boolean isMqqHippyScheme(String str) {
        return str.startsWith(WadlProxyConsts.HIPPY_OPEN_SCHEME);
    }

    private boolean isQbScheme(String str) {
        if (!str.startsWith("qb://react") && !str.startsWith("qb://hippy")) {
            return false;
        }
        return true;
    }

    private void jumpMqqHippyScheme(String str) {
        BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) HippyUtils.getAppInterface();
        new OpenHippyInfo(bi.c(baseQQAppInterface, baseQQAppInterface.getApplicationContext(), str).f307441f).enableOpenDebugHippy().openHippy(getActivity());
    }

    private void jumpQbScheme(String str) {
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("module");
        String queryParameter2 = parse.getQueryParameter("url");
        String queryParameter3 = parse.getQueryParameter("framework");
        OpenHippyInfo enableOpenDebugHippy = new OpenHippyInfo().enableOpenDebugHippy();
        enableOpenDebugHippy.bundleName = queryParameter;
        enableOpenDebugHippy.bundleUrl = queryParameter2;
        enableOpenDebugHippy.framework = queryParameter3;
        enableOpenDebugHippy.openHippy(getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setDebugInfo$0() {
        HippyDebugSoUtil.switchToDebugSo(getActivity());
    }

    private void onQRScanResult(int i3, Intent intent) {
        if (i3 == -1 && intent != null) {
            String stringExtra = intent.getStringExtra("scanResult");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            if (isQbScheme(stringExtra)) {
                jumpQbScheme(stringExtra);
            } else if (isMqqHippyScheme(stringExtra)) {
                jumpMqqHippyScheme(stringExtra);
            } else {
                QLog.e(CLASSNAME, 1, "onQRScanResult unknown url:", stringExtra);
            }
        }
    }

    @HippyMethod(name = "deleteModule")
    public void deleteModule(String str, Promise promise) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            promise.resolve(Boolean.valueOf(HippyDebugUtil.deleteModule(jSONObject.optString("moduleName"), Integer.parseInt(jSONObject.optString("version")))));
        } catch (NumberFormatException e16) {
            QLog.e(CLASSNAME, 1, "deleteModule parse error:", e16);
            promise.resolve(Boolean.FALSE);
        } catch (JSONException e17) {
            QLog.e(CLASSNAME, 1, "deleteModule json error:", e17);
            promise.resolve(Boolean.FALSE);
        }
    }

    @HippyMethod(name = "getDebugInfo")
    public void getDebugInfo(Promise promise) {
        try {
            String hippyBundleName = HippyDebugUtil.getHippyBundleName();
            String hippyServerHost = HippyDebugUtil.getHippyServerHost();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("module", hippyBundleName);
            jSONObject.put("server", hippyServerHost);
            JSONArray jSONArray = new JSONArray();
            jSONArray.mo162put(jSONObject);
            promise.resolve(jSONArray.toString());
        } catch (JSONException unused) {
            promise.resolve("");
        }
    }

    @HippyMethod(name = "getLibraryVersions")
    public void getLibraryVersions(Promise promise) {
        HashMap<String, String> libraryVersions = HippyDebugUtil.getLibraryVersions();
        HippyMap hippyMap = new HippyMap();
        for (Map.Entry<String, String> entry : libraryVersions.entrySet()) {
            hippyMap.pushString(entry.getKey(), entry.getValue());
        }
        promise.resolve(hippyMap);
    }

    @HippyMethod(name = "getSubFileNameList")
    public void getSubFileNameList(String str, Promise promise) {
        promise.resolve(getSubFileList(getFileByPath(str)).toString());
    }

    @Override // com.tencent.hippy.qq.module.QQBaseLifecycleModule, com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public void onActivityResult(Activity activity, int i3, int i16, Intent intent) {
        if (i3 == 1) {
            onQRScanResult(i16, intent);
        }
    }

    @Override // com.tencent.hippy.qq.module.QQBaseLifecycleModule, com.tencent.hippy.qq.fragment.HippyActivityLifecycleListener
    public void onNewIntent(Activity activity, Intent intent) {
        super.onNewIntent(activity, intent);
    }

    @HippyMethod(name = "openQRScan")
    public void openQRScan(Promise promise) {
        Intent intent = new Intent(getFragment().getContext(), ((IQRJumpApi) QRoute.api(IQRJumpApi.class)).getScannerActivityCls());
        intent.putExtra("from", "hippy");
        intent.putExtra("detectType", 1);
        getFragment().startActivityForResult(intent, 1);
        promise.resolve("success");
    }

    @HippyMethod(name = "setDebugInfo")
    public void setDebugInfo(String str, String str2, Promise promise) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            HippyDebugUtil.enableDebug(true);
            HippyDebugUtil.enableDebugModule(str);
            HippyDebugUtil.enableDebugPort(str2);
            if (!HippyDebugSoUtil.isUseDebugSo()) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.hippy.qq.module.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQDebugToolModule.this.lambda$setDebugInfo$0();
                    }
                });
            }
        } else {
            HippyDebugUtil.setDebugModuleAndPort(str, str2);
            HippyDebugUtil.enableDebug(false);
        }
        promise.resolve("success");
    }

    @HippyMethod(name = "setHippySdkLogStatus")
    public void setHippySdkLogStatus(boolean z16) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool(MMKVCommonFileKeys.IS_OPEN_HIPPY_SDK_LOG, z16).commitAsync();
    }
}
