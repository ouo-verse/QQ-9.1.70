package com.tencent.qqmini.miniapp.util;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.core.utils.f;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.MD5Utils;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.io.File;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class V8Utils {
    public static final String TAG = "V8Utils";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        String f346320a;

        /* renamed from: b, reason: collision with root package name */
        int f346321b;

        /* renamed from: c, reason: collision with root package name */
        String f346322c;

        a() {
        }
    }

    public static boolean checkEnableV8() {
        boolean isEnabled = isEnabled();
        if (isEnabled) {
            boolean booleanValue = f.a("100141", "use_scriptx", false).booleanValue();
            Bundle bundle = new Bundle();
            bundle.putBoolean(IPCConst.KEY_USE_SCRIPTX, booleanValue);
            if (booleanValue) {
                if (isScriptXValid()) {
                    QMLog.i(TAG, "ScriptX valid");
                    return true;
                }
                QMLog.i(TAG, "ScriptX not valid");
                bundle.putString(IPCConst.KEY_SO_URL, f.b("100141", "url", ""));
                downloadSo(bundle);
                return false;
            }
            if (isValid()) {
                return true;
            }
            downloadSo(bundle);
        } else {
            QMLog.e(TAG, "mini_app_enable_v8_service is " + isEnabled);
        }
        return false;
    }

    private static void downloadSo(Bundle bundle) {
        AppBrandCmdProxy.g().sendCmd(IPCConst.CMD_UPDATE_V8RT, bundle, new MiniCmdCallback.Stub() { // from class: com.tencent.qqmini.miniapp.util.V8Utils.1
            @Override // com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback
            public void onCmdResult(boolean z16, Bundle bundle2) throws RemoteException {
                QMLog.d(V8Utils.TAG, "update v8rt so succeed.");
            }
        });
    }

    public static boolean isEnabled() {
        if (WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_KEY_MINI_APP_ENABLE_V8_SERVICE, 1) > 0) {
            return true;
        }
        return false;
    }

    public static boolean isScriptXValid() {
        try {
            String b16 = f.b("100141", "md5", "");
            File file = new File(MiniSDKConst.getScriptXPath());
            if (file.exists()) {
                String lowerCase = MD5Utils.encodeFileHexStr(file.getAbsolutePath()).toLowerCase();
                QMLog.i(TAG, "isScriptXValid fileMd5 " + lowerCase);
                if (TextUtils.equals(b16.toLowerCase(), lowerCase)) {
                    return true;
                }
            }
            file.deleteOnExit();
            return false;
        } catch (Exception e16) {
            QMLog.e(TAG, "isScriptXValid check error " + e16.getMessage());
            return false;
        }
    }

    public static boolean isValid() {
        String config = WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_KEY_MINI_APP_V8RT_URL, WnsConfig.DEFAULT_MINI_APP_V8RT_URL);
        if (TextUtils.isEmpty(config)) {
            QMLog.e(TAG, "mini_app_v8_rt_url is null");
            return false;
        }
        a parserUrlJson = parserUrlJson(config);
        if (!TextUtils.isEmpty(parserUrlJson.f346320a) && parserUrlJson.f346321b != 0 && !TextUtils.isEmpty(parserUrlJson.f346322c)) {
            return v8rtValid(parserUrlJson.f346321b, parserUrlJson.f346322c);
        }
        QMLog.e(TAG, "url is" + parserUrlJson.f346320a + "  size:" + parserUrlJson.f346321b + " md5:" + parserUrlJson.f346322c);
        return false;
    }

    private static a parserUrlJson(String str) {
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (QUAUtil.isAbi64()) {
                aVar.f346320a = jSONObject.optString("url64", "");
                aVar.f346321b = jSONObject.optInt("size64", 0);
                aVar.f346322c = jSONObject.optString("md564", "");
            } else {
                aVar.f346320a = jSONObject.optString("url", "");
                aVar.f346321b = jSONObject.optInt("size", 0);
                aVar.f346322c = jSONObject.optString("md5", "");
            }
        } catch (Exception e16) {
            QMLog.e(TAG, "parse v8rt_url failed", e16);
        }
        return aVar;
    }

    private static boolean v8rtValid(int i3, String str) {
        File file = new File(MiniSDKConst.getMiniAppV8rtPath());
        if (file.exists() && file.length() == i3) {
            String lowerCase = MD5Utils.encodeFileHexStr(file.getAbsolutePath()).toLowerCase();
            QMLog.i(TAG, "isv8rtValid fileMd5 " + lowerCase);
            if (TextUtils.equals(str.toLowerCase(), lowerCase)) {
                return true;
            }
        }
        file.delete();
        return false;
    }
}
