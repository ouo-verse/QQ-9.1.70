package com.tencent.mobileqq.microapp.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.qwallet.utils.ComIPCUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResultCallback;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MiniAppLauncher {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "MiniAppLauncher";
    private static final String URL_PREFIX_MINIAPP_HTTP = "https://imgcache.qq.com/channel/mini_app/upgrade.html";
    private static final String URL_PREFIX_MINIAPP_HTTPS = "https://imgcache.qq.com/channel/mini_app/upgrade.html";
    private static final String URL_PREFIX_WX_MINIAPP_HTTPS = "https://mp.weixin.qq.com/a/";
    static long mLastGameTime;

    public MiniAppLauncher() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean isMiniAppScheme(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("mqqapi://microapp/open")) {
            return false;
        }
        return true;
    }

    public static boolean isMiniAppUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith("https://imgcache.qq.com/channel/mini_app/upgrade.html") && !str.startsWith("https://imgcache.qq.com/channel/mini_app/upgrade.html") && !str.startsWith(URL_PREFIX_WX_MINIAPP_HTTPS)) {
            return false;
        }
        return true;
    }

    public static boolean launchMiniApp(Context context, String str, int i3) {
        LaunchParam launchParam = new LaunchParam();
        launchParam.miniAppId = str;
        launchParam.scene = i3;
        return launchMiniApp(context, launchParam);
    }

    public static boolean launchMiniAppByScanCode(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            int i3 = 1207;
            if (!str.startsWith("https://imgcache.qq.com/channel/mini_app/upgrade.html") && !str.startsWith("https://imgcache.qq.com/channel/mini_app/upgrade.html") && str.startsWith(URL_PREFIX_WX_MINIAPP_HTTPS)) {
                i3 = 1208;
            }
            LaunchParam launchParam = new LaunchParam();
            launchParam.scene = i3;
            launchParam.extraKey = str;
            return launchMiniApp(context, launchParam);
        }
        return false;
    }

    public static boolean launchMiniAppByScheme(Context context, HashMap hashMap) {
        String str;
        if (hashMap == null || context == null) {
            return false;
        }
        String str2 = (String) hashMap.get(PreloadingFragment.KEY_APPID);
        try {
            str = URLDecoder.decode((String) hashMap.get("entry_path"), "UTF-8");
        } catch (Throwable unused) {
            str = null;
        }
        String str3 = (String) hashMap.get("scene");
        int i3 = 1200;
        try {
            if (!TextUtils.isEmpty(str3)) {
                i3 = Integer.parseInt(str3);
            }
        } catch (Throwable unused2) {
        }
        String str4 = (String) hashMap.get("qqwallet_appinfo");
        if (!TextUtils.isEmpty(str4)) {
            try {
                str4 = URLDecoder.decode(str4, "UTF-8");
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
            }
        }
        LaunchParam launchParam = new LaunchParam();
        launchParam.miniAppId = str2;
        launchParam.entryPath = str;
        launchParam.scene = i3;
        launchParam.appInfo = str4;
        return launchMiniApp(context, launchParam);
    }

    public static boolean navigateBackMiniApp(Context context, String str, String str2) {
        LaunchParam launchParam = new LaunchParam();
        launchParam.miniAppId = str;
        launchParam.navigateExtData = str2;
        launchParam.scene = LaunchParam.SCENE_NAVIGATE_BACK;
        return launchMiniApp(context, launchParam);
    }

    public static boolean navigateToMiniApp(Context context, String str, String str2, String str3, String str4) {
        LaunchParam launchParam = new LaunchParam();
        launchParam.miniAppId = str;
        launchParam.entryPath = str2;
        launchParam.fromMiniAppId = str3;
        launchParam.navigateExtData = str4;
        launchParam.scene = LaunchParam.SCENE_NAVIGATE_TO;
        return launchMiniApp(context, launchParam);
    }

    private static boolean openMiniApp(Context context, LaunchParam launchParam) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "launchMiniApp openMiniApp :" + launchParam);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - mLastGameTime <= 1000) {
            return false;
        }
        mLastGameTime = currentTimeMillis;
        launchParam.standardize();
        Intent intent = new Intent();
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra(MiniAppBridgeActivity.KEY_LAUNCH_PARAM, launchParam);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        return true;
    }

    public static boolean launchMiniApp(Context context, String str, StructMsgForGeneralShare structMsgForGeneralShare, String str2) {
        if (structMsgForGeneralShare == null) {
            return false;
        }
        LaunchParam launchParam = new LaunchParam();
        launchParam.miniAppId = str;
        int i3 = structMsgForGeneralShare.uinType;
        int i16 = 1212;
        if (i3 != 0 && (i3 == 1 || i3 == 3000)) {
            i16 = 1213;
        }
        launchParam.scene = i16;
        if (!TextUtils.isEmpty(str2)) {
            launchParam.entryPath = str2;
        }
        return launchMiniApp(context, launchParam);
    }

    public static boolean launchMiniApp(Context context, LaunchParam launchParam) {
        if (context != null && launchParam != null) {
            try {
                if (launchParam.isValid()) {
                    if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
                        return openMiniApp(context, launchParam);
                    }
                    ComIPCUtils.lauchMiniApp(launchParam, (EIPCResultCallback) null);
                    return true;
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
                return false;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "launchMiniApp param invalid :" + context + "|" + launchParam);
        }
        return false;
    }

    public static void launchMiniAppByScheme(Context context, String str) {
        launchMiniAppByScheme(context, str, 1200);
    }

    public static void launchMiniAppByScheme(Context context, String str, int i3) {
        if (!TextUtils.isEmpty(str) || (context instanceof Activity)) {
            Activity activity = (Activity) context;
            if (i3 != 1200) {
                str = str + "&scene=" + i3;
            }
            Intent intent = new Intent(activity, (Class<?>) JumpActivity.class);
            intent.setData(Uri.parse(str));
            activity.startActivityForResult(intent, -1);
        }
    }
}
