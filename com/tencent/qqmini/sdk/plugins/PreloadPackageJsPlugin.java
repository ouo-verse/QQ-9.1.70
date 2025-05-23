package com.tencent.qqmini.sdk.plugins;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.a;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class PreloadPackageJsPlugin extends BaseJsPlugin {

    /* renamed from: d, reason: collision with root package name */
    private final Map<RequestEvent, String> f348232d = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public enum PreloadResult {
        PRELOAD_SUCCESS(1000),
        PERMISSION_FAIL_WHITELIST(2000),
        PARAM_ERROR_NO_APPID(2001),
        PRELOAD_IN_PROGRESS(2002),
        INTERNAL_ERROR_NULL_APP_INFO(3000),
        GET_APP_INFO_FAIL(3001),
        GET_APP_INFO_NULL_RESULT(3002),
        GET_APP_INFO_NO_DATA(3003),
        GET_GPKG_INFO_FAIL(3004);

        public final int code;

        PreloadResult(int i3) {
            this.code = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public class a implements AsyncResult {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestEvent f348233a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f348234b;

        a(RequestEvent requestEvent, String str) {
            this.f348233a = requestEvent;
            this.f348234b = str;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
        public void onReceiveResult(boolean z16, JSONObject jSONObject) {
            if (jSONObject == null) {
                PreloadPackageJsPlugin.this.g(this.f348233a, PreloadResult.GET_APP_INFO_NULL_RESULT);
                return;
            }
            QMLog.d("PreloadPackageJsPlugin", "getAppInfoById request appId:" + this.f348234b + "; response, retCode:" + jSONObject.optLong("retCode") + ",errMsg:" + jSONObject.optString("errMsg") + " , is success:" + z16);
            if (!z16) {
                PreloadPackageJsPlugin.this.g(this.f348233a, PreloadResult.GET_APP_INFO_FAIL);
                return;
            }
            MiniAppInfo miniAppInfo = (MiniAppInfo) jSONObject.opt("mini_app_info_data");
            if (miniAppInfo != null) {
                PreloadPackageJsPlugin.this.e(miniAppInfo, this.f348233a);
            } else {
                QMLog.w("PreloadPackageJsPlugin", "no mini app info obj found");
                PreloadPackageJsPlugin.this.g(this.f348233a, PreloadResult.GET_APP_INFO_NO_DATA);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public class c extends MiniCmdCallback.Stub {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RequestEvent f348238d;

        c(RequestEvent requestEvent) {
            this.f348238d = requestEvent;
        }

        @Override // com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback
        public void onCmdResult(boolean z16, @NonNull Bundle bundle) throws RemoteException {
            if (z16) {
                int i3 = bundle.getInt("retCode");
                String str = "retCode," + i3 + " , errMsg," + bundle.getString("errMsg");
                QMLog.d("PreloadPackageJsPlugin", "download pkg msg:" + str);
                if (i3 == 0) {
                    PreloadPackageJsPlugin.this.g(this.f348238d, PreloadResult.PRELOAD_SUCCESS);
                } else {
                    PreloadPackageJsPlugin.this.h(this.f348238d, PreloadResult.GET_GPKG_INFO_FAIL, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f348240a;

        static {
            int[] iArr = new int[PreloadResult.values().length];
            f348240a = iArr;
            try {
                iArr[PreloadResult.PRELOAD_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f348240a[PreloadResult.PERMISSION_FAIL_WHITELIST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f348240a[PreloadResult.PARAM_ERROR_NO_APPID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f348240a[PreloadResult.PRELOAD_IN_PROGRESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(@NonNull MiniAppInfo miniAppInfo, @NonNull RequestEvent requestEvent) {
        if (miniAppInfo.isEngineTypeMiniGame()) {
            com.tencent.qqmini.sdk.manager.a.a(miniAppInfo, true, new b(requestEvent));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_mini_app_config", miniAppInfo);
        bundle.putBoolean("key_run_in_mainprocess", true);
        AppBrandCmdProxy.g().sendCmd(IPCConst.CMD_MAIN_PROCESS_LOAD_PKG, bundle, new c(requestEvent));
    }

    private void f(String str, String str2, RequestEvent requestEvent) {
        ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
        if (channelProxy == null) {
            QMLog.w("PreloadPackageJsPlugin", "get proxy ChannelProxy return null");
            g(requestEvent, PreloadResult.GET_APP_INFO_FAIL);
        } else {
            channelProxy.getAppInfoById(str, "", str2, new a(requestEvent, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(@NonNull RequestEvent requestEvent, @NonNull PreloadResult preloadResult) {
        h(requestEvent, preloadResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(@NonNull RequestEvent requestEvent, @NonNull PreloadResult preloadResult, String str) {
        this.f348232d.remove(requestEvent);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", preloadResult.code);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("preloadMsg", str);
            }
        } catch (JSONException e16) {
            QMLog.e("PreloadPackageJsPlugin", "create js callback result fail,", e16);
        }
        int i3 = d.f348240a[preloadResult.ordinal()];
        if (i3 != 1) {
            if (i3 != 2 && i3 != 3 && i3 != 4) {
                requestEvent.fail(jSONObject, "");
                return;
            } else {
                requestEvent.cancel(jSONObject);
                return;
            }
        }
        requestEvent.ok(jSONObject);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        this.f348232d.clear();
        super.onDestroy();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0088  */
    @JsEvent({"preloadPackage"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void preloadPackage(RequestEvent requestEvent) {
        String str;
        String str2 = "";
        if (requestEvent == null) {
            QMLog.w("PreloadPackageJsPlugin", "RequestEvent is null");
            return;
        }
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo == null) {
            QMLog.e("PreloadPackageJsPlugin", "mMiniAppInfo can't be null.");
            g(requestEvent, PreloadResult.INTERNAL_ERROR_NULL_APP_INFO);
            return;
        }
        List<String> list = miniAppInfo.whiteList;
        if (list != null && !list.contains("preloadPackage")) {
            QMLog.w("PreloadPackageJsPlugin", "current mini app has no preloadPackage api in its whitelist");
            g(requestEvent, PreloadResult.PERMISSION_FAIL_WHITELIST);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            str = jSONObject.getString("appId");
            try {
                str2 = jSONObject.optString("envVersion");
            } catch (JSONException unused) {
                QMLog.e("PreloadPackageJsPlugin", "fail to get appId from jsonParams");
                if ("release".equals(this.mMiniAppInfo.getVerTypeStr())) {
                }
                if (!TextUtils.isEmpty(str)) {
                }
            }
        } catch (JSONException unused2) {
            str = "";
        }
        if ("release".equals(this.mMiniAppInfo.getVerTypeStr())) {
            str2 = "release";
        }
        if (!TextUtils.isEmpty(str)) {
            QMLog.w("PreloadPackageJsPlugin", "no appId in jsonParams: " + requestEvent.jsonParams);
            g(requestEvent, PreloadResult.PARAM_ERROR_NO_APPID);
            return;
        }
        if (this.f348232d.containsValue(str)) {
            if (QMLog.isColorLevel()) {
                QMLog.i("PreloadPackageJsPlugin", "app id $appId is preloading...");
            }
            g(requestEvent, PreloadResult.PRELOAD_IN_PROGRESS);
        } else {
            this.f348232d.put(requestEvent, str);
            f(str, str2, requestEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public class b implements a.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestEvent f348236a;

        b(RequestEvent requestEvent) {
            this.f348236a = requestEvent;
        }

        @Override // com.tencent.qqmini.sdk.manager.a.b
        public void onFail(@NonNull String str) {
            PreloadPackageJsPlugin.this.h(this.f348236a, PreloadResult.GET_GPKG_INFO_FAIL, str);
        }

        @Override // com.tencent.qqmini.sdk.manager.a.b
        public void onSuccess() {
            PreloadPackageJsPlugin.this.g(this.f348236a, PreloadResult.PRELOAD_SUCCESS);
        }

        @Override // com.tencent.qqmini.sdk.manager.a.b
        public void onProgress(float f16, long j3) {
        }
    }
}
