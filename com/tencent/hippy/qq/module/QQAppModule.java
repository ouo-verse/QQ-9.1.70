package com.tencent.hippy.qq.module;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@HippyNativeModule(name = QQAppModule.TAG)
/* loaded from: classes7.dex */
public class QQAppModule extends QQBaseModule {
    static final String TAG = "QQAppModule";

    public QQAppModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    @HippyMethod(name = "getAppsVerionCodeBatch")
    public void getAppsVerionCodeBatch(String str, Promise promise) {
        promise.resolve(PackageUtil.getAppsVerionCodeBatch(BaseApplication.getContext(), str));
    }

    @HippyMethod(name = "isAppInstalled")
    public void isAppInstalled(String str, Promise promise) {
        if (promise != null) {
            promise.resolve(Boolean.valueOf(PackageUtil.isAppInstalled(getActivity(), str)));
        }
    }

    @HippyMethod(name = "isAppInstalledBatch")
    public void isAppInstalledBatch(String str, Promise promise) {
        promise.resolve(PackageUtil.isAppInstalledBatch(BaseApplication.getContext(), str));
    }

    @HippyMethod(name = "launchAppWithTokens")
    public void launchAppWithTokens(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            launchAppWithTokens(jSONObject.optString("appID"), jSONObject.optString("paramsStr"), jSONObject.optString("packageName"), jSONObject.optString(WadlProxyConsts.FLAGS), jSONObject.optString("type"), jSONObject.optString("subappid"), jSONObject.optString("from"));
        } catch (JSONException unused) {
            QLog.e(TAG, 1, "launchAppWithTokens, parse params error");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0099, code lost:
    
        if (com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor.queryIntentActivities(r6, r9, 0).size() > 0) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void launchAppWithTokens(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "launchAppWithTokens " + str3);
        }
        eq2.a aVar = new eq2.a();
        AppInterface appInterface = getAppInterface();
        if (appInterface == null) {
            return;
        }
        boolean z16 = true;
        try {
            int parseInt = Integer.parseInt(str4);
            r6 = (parseInt & 67108864) == 67108864 ? 335544320 : 268435456;
            if ((parseInt & 536870912) == 536870912) {
                r6 |= 536870912;
            }
            if ((parseInt & 4194304) == 4194304) {
                r6 |= 4194304;
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
        int i3 = r6;
        String str8 = "tencentwtlogin" + str + QzoneWebViewOfflinePlugin.STR_DEVIDER;
        if (util.FILE_DIR.equals(str5)) {
            PackageManager packageManager = getActivity().getPackageManager();
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
            intent.setData(Uri.parse(str8));
            if (packageManager != null) {
            }
        }
        z16 = false;
        if (z16) {
            aVar.f(str8, getActivity(), "", appInterface, str, str3, i3, str6);
        } else {
            aVar.e(appInterface, getActivity(), str, str2, str3, i3, str7);
        }
    }
}
