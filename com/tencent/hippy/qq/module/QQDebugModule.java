package com.tencent.hippy.qq.module;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.api.HippyInterpolator;
import com.tencent.hippy.qq.api.IHippyImageUtil;
import com.tencent.hippy.qq.fragment.BaseHippyFragment;
import com.tencent.hippy.qq.interpolators.HippyInterpolatorConfig;
import com.tencent.hippy.qq.utils.AttaReporter;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@HippyNativeModule(name = QQDebugModule.CLASSNAME)
/* loaded from: classes7.dex */
public class QQDebugModule extends QQBaseModule {
    public static final String CLASSNAME = "QQDebugModule";

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class AttaTaskCallback implements com.tencent.qqnt.http.api.l {
        private WeakReference<Promise> mPromise;

        AttaTaskCallback(Promise promise) {
            this.mPromise = new WeakReference<>(promise);
        }

        @Override // com.tencent.qqnt.http.api.l
        public void onFailed(@NonNull com.tencent.qqnt.http.api.b bVar, @NonNull com.tencent.qqnt.http.api.m mVar) {
            Promise promise = this.mPromise.get();
            QLog.e(QQDebugModule.CLASSNAME, 1, "[onFailed]");
            if (promise != null && mVar != null) {
                try {
                    int intValue = mVar.c().intValue();
                    QLog.e(QQDebugModule.CLASSNAME, 1, "http code:" + intValue);
                    promise.resolve(Integer.valueOf(intValue));
                } catch (Throwable th5) {
                    QLog.e(QQDebugModule.CLASSNAME, 1, "[onFailed],th:" + th5);
                }
            }
        }

        @Override // com.tencent.qqnt.http.api.l
        public void onSuccess(@NonNull com.tencent.qqnt.http.api.b bVar, @NonNull com.tencent.qqnt.http.api.m mVar) {
            Promise promise = this.mPromise.get();
            if (promise != null && mVar != null) {
                promise.resolve(mVar.c());
            }
        }
    }

    public QQDebugModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$picFormatInfo$0(HippyMap hippyMap, Promise promise) {
        HippyMap hippyMap2 = new HippyMap();
        try {
            String string = hippyMap.getString("sourceUrl");
            String urlWithParams = ((IHippyImageUtil) QRoute.api(IHippyImageUtil.class)).getUrlWithParams(string);
            String imageLocalPath = ((IHippyImageUtil) QRoute.api(IHippyImageUtil.class)).getImageLocalPath(urlWithParams);
            if (TextUtils.isEmpty(imageLocalPath)) {
                hippyMap2.pushInt("size", 0);
                hippyMap2.pushString("type", "");
                promise.resolve(hippyMap2);
                return;
            }
            File file = new File(imageLocalPath);
            if (!file.exists()) {
                if (QLog.isColorLevel()) {
                    QLog.d(CLASSNAME, 2, "image NOT exist in local, url:", string);
                }
                hippyMap2.pushInt("size", 0);
                hippyMap2.pushString("type", "");
                promise.resolve(hippyMap2);
                return;
            }
            long length = file.length();
            hippyMap2.pushString("type", ((IHippyImageUtil) QRoute.api(IHippyImageUtil.class)).getImageType(file));
            hippyMap2.pushString("url", urlWithParams);
            hippyMap2.pushInt("size", (int) length);
            promise.resolve(hippyMap2);
            if (QLog.isDevelopLevel()) {
                QLog.d(CLASSNAME, 4, "[picFormatInfo], map:" + hippyMap2.toString());
            }
        } catch (Throwable th5) {
            QLog.e(CLASSNAME, 1, "[picFormatInfo], error:" + th5.getMessage());
            hippyMap2.pushInt("size", 0);
            hippyMap2.pushString("type", "");
            promise.resolve(hippyMap2);
        }
    }

    private void processWebLog(AppInterface appInterface, Context context, String str, String str2, String str3, boolean z16) {
        String str4;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append("|");
        sb5.append(str2);
        sb5.append("|");
        sb5.append(str3);
        sb5.append("|");
        sb5.append("ANDROID");
        sb5.append("|");
        sb5.append(AppSetting.f99554n);
        sb5.append("|");
        sb5.append(ah.t());
        sb5.append("|");
        sb5.append(MobileQQ.getShortUinStr(appInterface.getCurrentAccountUin()));
        sb5.append("|");
        sb5.append(DeviceInfoMonitor.getModel());
        sb5.append("|");
        String str5 = "\u672a\u77e5";
        if (TextUtils.isEmpty(ah.G(context).f307419c)) {
            str4 = "\u672a\u77e5";
        } else {
            str4 = ah.G(context).f307419c;
        }
        sb5.append(str4);
        sb5.append("|");
        if (!TextUtils.isEmpty(ah.G(context).f307417a)) {
            str5 = ah.G(context).f307417a;
        }
        sb5.append(str5);
        if (z16) {
            QLog.w("WebLog", 1, sb5.toString());
        } else if (QLog.isColorLevel()) {
            QLog.w("WebLog", 2, sb5.toString());
        }
    }

    private void webLog(AppInterface appInterface, Context context, JSONObject jSONObject) {
        try {
            processWebLog(appInterface, context, jSONObject.getString("id"), jSONObject.getString("subid"), jSONObject.getString("content"), jSONObject.getBoolean("isall"));
        } catch (JSONException e16) {
            QLog.e(CLASSNAME, 1, "webLog json error ", e16);
        } catch (Exception e17) {
            QLog.e(CLASSNAME, 1, "webLog error ", e17);
        }
    }

    @HippyMethod(name = "detailLog")
    public void detailLog(String str) {
        AppInterface appInterface = getAppInterface();
        if (appInterface == null) {
            QLog.e(CLASSNAME, 1, "appInterface is null");
            return;
        }
        try {
            webLog(appInterface, MobileQQ.sMobileQQ.getBaseContext(), new JSONObject(str));
        } catch (Exception e16) {
            QLog.e(CLASSNAME, 1, "detailLog error:" + e16);
        }
    }

    @HippyMethod(name = "getPerformanceData")
    public void getPerformanceData(Promise promise) {
        HashMap<String, Long> hashMap;
        QBaseFragment fragment = getFragment();
        HippyMap hippyMap = new HippyMap();
        if (fragment instanceof BaseHippyFragment) {
            hashMap = ((BaseHippyFragment) fragment).getPerformanceData();
        } else {
            HippyInterpolator interpolator = HippyInterpolatorConfig.getInterpolator(getBundleName());
            if (interpolator != null) {
                hashMap = interpolator.getPerformanceData();
            } else {
                hashMap = null;
            }
        }
        if (hashMap != null && hashMap.size() > 0) {
            for (Map.Entry<String, Long> entry : hashMap.entrySet()) {
                hippyMap.pushLong(entry.getKey(), entry.getValue().longValue());
            }
            hippyMap.pushInt("retCode", 0);
        } else {
            hippyMap.pushInt("retCode", -1);
        }
        promise.resolve(hippyMap);
    }

    @HippyMethod(name = "picFormatInfo")
    public void picFormatInfo(final HippyMap hippyMap, final Promise promise) {
        if (QLog.isColorLevel()) {
            QLog.d(CLASSNAME, 2, "params:", hippyMap);
        }
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.hippy.qq.module.f
            @Override // java.lang.Runnable
            public final void run() {
                QQDebugModule.lambda$picFormatInfo$0(HippyMap.this, promise);
            }
        });
    }

    @HippyMethod(name = "reportAtta")
    public void reportAtta(HippyMap hippyMap, Promise promise) {
        if (QLog.isColorLevel()) {
            QLog.d(CLASSNAME, 1, "[reportAtta], body:", hippyMap.toString());
        }
        try {
            String string = hippyMap.getString("attainfo");
            if (string.isEmpty()) {
                QLog.w(CLASSNAME, 1, "---req body is empty----");
            } else {
                AttaReporter.INSTANCE.doReport(string, new AttaTaskCallback(promise));
            }
        } catch (Throwable th5) {
            QLog.e(CLASSNAME, 1, "[reportAtta], error:" + th5);
        }
    }
}
