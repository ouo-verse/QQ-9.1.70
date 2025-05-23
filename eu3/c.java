package eu3;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.manager.BaseLibManager;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.io.File;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class c {
    public static String a(ApkgInfo apkgInfo) {
        String str;
        String str2;
        if (apkgInfo == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appId", apkgInfo.appId);
            jSONObject.put("icon", apkgInfo.iconUrl);
            jSONObject.put("nickname", apkgInfo.apkgName);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        MiniAppInfo miniAppInfo = apkgInfo.mMiniAppInfo;
        if (miniAppInfo == null) {
            str = "";
            str2 = "release";
        } else {
            str2 = miniAppInfo.getVerTypeStr();
            str = apkgInfo.mMiniAppInfo.version;
        }
        String format = String.format("if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig=%1$s;  __qqConfig = extend(__qqConfig, __tempConfig);__qqConfig.accountInfo=JSON.parse('%2$s');  __qqConfig.envVersion='" + str2 + "'; __qqConfig.deviceinfo='" + QUAUtil.getSimpleDeviceInfo(AppLoaderFactory.g().getContext()) + "'; __qqConfig.miniapp_version='" + str + "';", apkgInfo.mConfigStr, jSONObject.toString());
        if (DebugUtil.getDebugEnabled(apkgInfo.appId)) {
            format = format + "__qqConfig.debug=true;";
        }
        return format + "__qqConfig.openDataHosts='" + WnsConfig.getConfig("qqminiapp", "opendatahosts", ".qlogo.com;.qlogo.cn;.qq.com;.tcb.qcloud.la") + "';if (typeof WeixinJSBridge != 'undefined' && typeof WeixinJSBridge.subscribeHandler == 'function') {WeixinJSBridge.subscribeHandler('onWxConfigReady')};";
    }

    public static BaselibLoader.BaselibContent b(Context context, boolean z16) {
        String str = "";
        BaselibLoader.BaselibContent baselibContent = new BaselibLoader.BaselibContent();
        try {
            SharedPreferences preference = StorageUtil.getPreference();
            String string = preference.getString("downloadUrl", "");
            String string2 = preference.getString("version", "1.74.3.00001");
            String baseLibDir = BaseLibManager.g().getBaseLibDir(string, string2);
            if (BaseLibInfo.needUpdateVersion("1.74.3.00001", string2) || TextUtils.isEmpty(baseLibDir) || !BaseLibManager.verifyBaselib(new File(baseLibDir))) {
                string2 = "1.74.3.00001";
            } else {
                str = baseLibDir;
            }
            baselibContent.waWebviewJsStr = FileUtils.readFileToStr(new File(str, "QView.js"));
            baselibContent.waServiceJsStr = FileUtils.readFileToStr(new File(str, "QLogic.js"));
            baselibContent.waServicePath = str + File.separator + "QLogic.js";
            if (z16) {
                baselibContent.waConsoleJsStr = FileUtils.readFileToStr(new File(str, "QVConsole.js"));
                baselibContent.waRemoteDebugStr = FileUtils.readFileToStr(new File(str, "QRemoteDebug.js"));
            }
            baselibContent.miniappWebviewStr = FileUtils.readFileToStr(new File(str, "QWebview.js"));
            baselibContent.waWorkerStr = FileUtils.readFileToStr(new File(str, "QWorker.js"));
            baselibContent.pageFrameStr = FileUtils.readFileToStr(new File(str, "QPageFrame.html"));
            baselibContent.version = string2;
            if (!baselibContent.isBaseLibInited()) {
                baselibContent.waServicePath = "assets://mini/QLogic.js";
                baselibContent.waWebviewJsStr = FileUtils.readFileFromAssets(context, "mini/QView.js");
                baselibContent.waServiceJsStr = FileUtils.readFileFromAssets(context, "mini/QLogic.js");
                if (z16) {
                    baselibContent.waConsoleJsStr = FileUtils.readFileFromAssets(context, "mini/QVConsole.js");
                    baselibContent.waRemoteDebugStr = FileUtils.readFileFromAssets(context, "mini/QRemoteDebug.js");
                }
                baselibContent.miniappWebviewStr = FileUtils.readFileFromAssets(context, "mini/QWebview.js");
                baselibContent.waWorkerStr = FileUtils.readFileFromAssets(context, "mini/QWorker.js");
                baselibContent.pageFrameStr = FileUtils.readFileFromAssets(context, "mini/QPageFrame.html");
                baselibContent.version = "1.74.3.00001";
            }
        } catch (Exception e16) {
            QMLog.e("ScriptGenerator", "initBaseLibrary failed.", e16);
        }
        return baselibContent;
    }

    public static String c(int i3, String str) {
        return String.format(Locale.US, "WeixinJSBridge.invokeCallbackHandler(%d, %s)", Integer.valueOf(i3), str);
    }

    public static String d() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("USER_DATA_PATH", "qqfile://usr");
            jSONObject.put(MosaicConstants$JsProperty.PROP_ENV, jSONObject2);
            jSONObject.put("preload", true);
            return String.format(Locale.US, "function extend(obj, src) {\n    for (var key in src) {\n        if (src.hasOwnProperty(key)) obj[key] = src[key];\n    }\n    return obj;\n}\nvar window = window || {}; window.__webview_engine_version__ = 0.02; if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig = JSON.parse('%s');__qqConfig = extend(__qqConfig, __tempConfig);__qqConfig.appContactInfo = {};__qqConfig.isWebContainer = true;__qqConfig.appContactInfo.operationInfo = {};__qqConfig.appContactInfo.operationInfo.jsonInfo = {};__qqConfig.appContactInfo.operationInfo.jsonInfo.apiAvailable = {'navigateToMiniProgramConfig':0,'shareCustomImageUrl':1,'share':0,'authorize':0,'navigateToMiniProgram':1,'getUserInfo':0,'openSetting':0};__qqConfig.platform = 'android';__qqConfig.QUA='" + QUAUtil.getPlatformQUA() + "';__qqConfig.frameworkInfo = {};__qqConfig.envVersion='release';__qqConfig.deviceinfo='" + QUAUtil.getSimpleDeviceInfo(AppLoaderFactory.g().getContext()) + "';__qqConfig.XWebVideoMinVersion=045100;", jSONObject);
        } catch (Exception e16) {
            QMLog.d("ScriptGenerator", "generateConfig failed: " + e16);
            return "";
        }
    }

    public static String e(String str, String str2, int i3) {
        return String.format(Locale.US, "WeixinJSBridge.subscribeHandler(\"%s\", %s, %d, 0)", str, str2, Integer.valueOf(i3));
    }

    public static String f(String str, String str2, int i3) {
        return String.format(Locale.US, "WeixinJSBridge.subscribeHandler(\"%s\", %s, 0, \"%d\")", str, str2, Integer.valueOf(i3));
    }

    public static String g(boolean z16) {
        return String.format(Locale.US, "if (typeof __qqConfig === 'undefined') var __qqConfig = {};__qqConfig.useXWebVideo=%b;__qqConfig.useXWebLive=%b;__qqConfig.useXWebElement=%b;__qqConfig.useXWebCanvas=%b;", Boolean.valueOf(z16), Boolean.valueOf(z16), Boolean.valueOf(z16), Boolean.valueOf(z16));
    }
}
