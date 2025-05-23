package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.aio.BaseForwardUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QMMKVMigrateHelper;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.parser.jumpcontroller.b;
import com.tencent.mobileqq.app.parser.tempapi.IQJumpApi;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.haoliyou.util.JumpUriUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig;
import com.tencent.mobileqq.mini.app.AppBrandContant;
import com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.open.api.IOpenSdkJumpActionStashApi;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.Pair;
import com.tencent.util.VersionUtils;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class JumpActivityHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static com.tencent.mobileqq.app.parser.jumpcontroller.b f196425a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27906);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        try {
            if (com.tencent.mobileqq.app.parser.jumpcontroller.d.f196484a.size() > 0) {
                f196425a = com.tencent.mobileqq.app.parser.jumpcontroller.d.f196484a.get(0).newInstance();
                QLog.d("JumpActivityHelper", 1, "JumpActivityHelper newInstance");
            }
        } catch (Exception e16) {
            QLog.e("JumpActivityHelper", 1, "JumpActivityHelper static statement: ", e16);
        }
    }

    public static void A(JumpActivity jumpActivity, Intent intent) {
        if (!jumpActivity.getAppRuntime().isLogin()) {
            Intent intent2 = new Intent();
            intent2.addFlags(67371008);
            intent2.putExtra("QQCOMIC_SHORTCUT_JUMP_KEY", intent);
            intent2.putExtras(intent.getExtras());
            RouteUtils.startActivity(jumpActivity, intent2, RouterConstants.UI_ROUTER_LOGIN);
            jumpActivity.finish();
            return;
        }
        if (((IQJumpApi) QRoute.api(IQJumpApi.class)).gestureGetJumpLock(jumpActivity, jumpActivity.getAppRuntime().getCurrentAccountUin()) && !BaseGesturePWDUtil.getAppForground(jumpActivity)) {
            Intent intent3 = new Intent();
            intent3.putExtra(GesturePWDUnlockActivity.KEY_GESTURE_FROM_JUMPACTIVITY, true);
            Intent intent4 = new Intent();
            jumpActivity.gotoQQComic = intent4;
            intent4.putExtras(intent);
            RouteUtils.startActivityForResult(jumpActivity, intent3, RouterConstants.UI_ROUTE_GESTURE_PWD_UNLOCK, PlayerResources.ViewId.EXTENDED_VIEW_TV_COUNTDOWN);
            return;
        }
        d0(jumpActivity, intent);
    }

    public static void B(JumpActivity jumpActivity, Intent intent) {
        if (!jumpActivity.getAppRuntime().isLogin()) {
            Intent intent2 = new Intent();
            intent2.addFlags(67371008);
            intent2.putExtra("QFILE_SHORTCUT_JUMP_KEY", intent);
            intent2.putExtras(intent.getExtras());
            RouteUtils.startActivity(jumpActivity, intent2, RouterConstants.UI_ROUTER_LOGIN);
            jumpActivity.finish();
            return;
        }
        if (((IQJumpApi) QRoute.api(IQJumpApi.class)).gestureGetJumpLock(jumpActivity, jumpActivity.getAppRuntime().getCurrentAccountUin()) && !BaseGesturePWDUtil.getAppForground(jumpActivity)) {
            Intent intent3 = new Intent();
            intent3.putExtra(GesturePWDUnlockActivity.KEY_GESTURE_FROM_JUMPACTIVITY, true);
            intent3.putExtras(intent.getExtras());
            RouteUtils.startActivityForResult(jumpActivity, intent3, RouterConstants.UI_ROUTE_GESTURE_PWD_UNLOCK, PlayerResources.ViewId.EXTENDED_VIEW_BTN_BUTTON_TEXT);
            return;
        }
        c0(jumpActivity);
    }

    public static void C(JumpActivity jumpActivity, Intent intent) {
        boolean z16 = false;
        try {
            z16 = intent.getBooleanExtra("IS_LOGIN_SUC_CALL", false);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (!jumpActivity.getAppRuntime().isLogin()) {
            if (z16) {
                jumpActivity.finish();
                return;
            }
            Intent intent2 = new Intent();
            intent2.addFlags(67371008);
            intent2.putExtra("QLINK_SHORTCUT_JUMP_KEY", intent);
            RouteUtils.startActivity(jumpActivity, intent2, RouterConstants.UI_ROUTER_LOGIN);
            jumpActivity.finish();
            return;
        }
        f196425a.r(jumpActivity);
        jumpActivity.finish();
    }

    public static void D(JumpActivity jumpActivity, Intent intent) {
        long j3;
        String str;
        Uri data = intent.getData();
        if (data != null) {
            String str2 = new String(PluginBaseInfoHelper.Base64Helper.decode(data.getQueryParameter("param"), 0));
            String queryParameter = data.getQueryParameter("appname");
            data.getQueryParameter(ISchemeApi.KEY_IOS_SRC_TYPE);
            data.getQueryParameter("version");
            String queryParameter2 = data.getQueryParameter(MiniProgramOpenSdkUtil.ATTR_SHARE_APPID_RICH);
            try {
                j3 = Long.parseLong(queryParameter2);
            } catch (Exception unused) {
                j3 = 0;
            }
            if (!TextUtils.isEmpty(queryParameter2) && j3 != 0) {
                if (!"wangzhe".equals(queryParameter)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("JumpActivityHelper", 2, "app name is not wangzhe");
                        return;
                    }
                    return;
                }
                try {
                    str = new JSONObject(str2).getString("url");
                } catch (JSONException e16) {
                    e16.printStackTrace();
                    str = null;
                }
                if (!jumpActivity.getAppRuntime().isLogin() && !TextUtils.isEmpty(str)) {
                    f196425a.e(jumpActivity, j3, str);
                    return;
                } else {
                    f196425a.f(jumpActivity, j3, str);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("JumpActivityHelper", 2, "app id is null,can not share");
            }
        }
    }

    private static void E(JumpActivity jumpActivity) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        RouteUtils.startActivity(jumpActivity, intent, RouterConstants.UI_ROUTER_SPLASH);
        jumpActivity.finish();
    }

    public static void F(JumpActivity jumpActivity, boolean z16) {
        SimpleMiniAppConfig simpleMiniAppConfig;
        Intent intent = jumpActivity.getIntent();
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        if (z16 && !jumpActivity.getAppRuntime().isLogin()) {
            Intent intent2 = new Intent();
            intent2.putExtra("isActionSend", true);
            intent2.putExtras(extras);
            intent2.putExtras(intent);
            RouteUtils.startActivityForResult(jumpActivity, intent2, RouterConstants.UI_ROUTER_LOGIN, 24);
            return;
        }
        String stringExtra = intent.getStringExtra("CONFIG_APPID");
        String stringExtra2 = intent.getStringExtra("CONFIG_APPNAME");
        String stringExtra3 = intent.getStringExtra("CONFIG_APPICON");
        String stringExtra4 = intent.getStringExtra("MINI_CONFIG_DEV_DESC");
        String stringExtra5 = intent.getStringExtra(AppBrandContant.CONFIG_GAME_REGISTRATION_NUMBER);
        int intExtra = intent.getIntExtra("CONFIG_VER_TYPE", 3);
        int intExtra2 = intent.getIntExtra("CONFIG_REPORTTYPE", 0);
        int intExtra3 = intent.getIntExtra("CONFIG_ENGINETYPE", 0);
        int intExtra4 = intent.getIntExtra("CONFIG_APPTYPE", -1);
        if (intExtra4 != -1) {
            intExtra2 = intExtra4;
            intExtra3 = intExtra2;
        }
        int intExtra5 = intent.getIntExtra("MINI_CONFIG_SCENE", 10086);
        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2) && !TextUtils.isEmpty(stringExtra3)) {
            SimpleMiniAppConfig.SimpleMiniAppInfo simpleMiniAppInfo = new SimpleMiniAppConfig.SimpleMiniAppInfo();
            simpleMiniAppInfo.appId = stringExtra;
            simpleMiniAppInfo.name = stringExtra2;
            simpleMiniAppInfo.iconUrl = stringExtra3;
            simpleMiniAppInfo.setEngineType(intExtra3);
            simpleMiniAppInfo.setReportType(intExtra2);
            simpleMiniAppInfo.developerDesc = stringExtra4;
            simpleMiniAppInfo.verType = intExtra;
            simpleMiniAppInfo.gameRegistrationNumber = stringExtra5;
            simpleMiniAppConfig = new SimpleMiniAppConfig(simpleMiniAppInfo);
            SimpleMiniAppConfig.SimpleLaunchParam simpleLaunchParam = new SimpleMiniAppConfig.SimpleLaunchParam();
            simpleMiniAppConfig.launchParam = simpleLaunchParam;
            simpleLaunchParam.miniAppId = stringExtra;
            simpleLaunchParam.scene = intExtra5;
        } else {
            simpleMiniAppConfig = null;
        }
        if (simpleMiniAppConfig != null && intExtra5 == 1023 && simpleMiniAppConfig.config.isEngineTypeMiniGame()) {
            ((IQJumpApi) QRoute.api(IQJumpApi.class)).handleByColorNote();
        }
        if (simpleMiniAppConfig != null) {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).startApp(jumpActivity, simpleMiniAppConfig, null);
        }
        jumpActivity.moveTaskToBack(true);
        jumpActivity.finish();
    }

    public static boolean G(JumpActivity jumpActivity, com.tencent.mobileqq.utils.ax axVar) {
        int i3;
        int i16;
        String n06;
        String n07;
        if (axVar == null || TextUtils.isEmpty(axVar.f(MiniProgramOpenSdkUtil.ATTR_SHARE_APPID_RICH))) {
            return false;
        }
        String f16 = axVar.f(AppConstants.Key.SHARE_REQ_TYPE);
        String f17 = axVar.f(AppConstants.Key.SHARE_REQ_EXT_INT);
        if (TextUtils.isEmpty(f16)) {
            return false;
        }
        try {
            n07 = n0(f16);
        } catch (NumberFormatException e16) {
            QLog.d("JumpActivityHelper", 1, "needToStartQZoneProcess catch NumberFormatException. ", e16);
        }
        if (!TextUtils.isEmpty(n07)) {
            i3 = Integer.valueOf(n07).intValue();
            if ((i3 != 3 || i3 == 4) && "qzone".equals(axVar.f307439d) && "publish".equals(axVar.f307440e)) {
                QLog.i("JumpActivityHelper", 1, "ShareShuoshuoOrVideoToQZone and the JumpActivity has not finish.");
                return true;
            }
            if (TextUtils.isEmpty(f17)) {
                return false;
            }
            try {
                n06 = n0(f17);
            } catch (NumberFormatException e17) {
                QLog.d("JumpActivityHelper", 1, "needToStartQZoneProcess catch NumberFormatException. ", e17);
            }
            if (!TextUtils.isEmpty(n06)) {
                i16 = Integer.valueOf(n06).intValue();
                if (i3 == 5 || (i16 & 1) == 0) {
                    return false;
                }
                QLog.i("JumpActivityHelper", 1, "SharePictureToQZone and the JumpActivity has not finish.");
                return true;
            }
            i16 = 0;
            if (i3 == 5) {
            }
            return false;
        }
        i3 = 1;
        if (i3 != 3) {
        }
        QLog.i("JumpActivityHelper", 1, "ShareShuoshuoOrVideoToQZone and the JumpActivity has not finish.");
        return true;
    }

    public static int H(JumpActivity jumpActivity, Bundle bundle) {
        String encodeToString;
        try {
            QLog.d("JumpActivityHelper", 1, "startSystemShareToQQFav|beg");
            Uri uri = (Uri) bundle.getParcelable("android.intent.extra.STREAM");
            if (uri != null && "file".equals(uri.getScheme()) && uri.getPath().startsWith("/storage")) {
                return 4;
            }
            String string = bundle.getString("android.intent.extra.TITLE");
            String string2 = bundle.getString("android.intent.extra.TEXT");
            String type = jumpActivity.getIntent().getType();
            if (TextUtils.isEmpty(type)) {
                QLog.d("JumpActivityHelper", 1, "startSystemShareToQQFav|type null");
                return 1;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(ISchemeApi.KEY_IOS_SRC_TYPE, "app");
            hashMap.put("version", "1");
            hashMap.put(AppConstants.Key.SHARE_REQ_EXT_INT, PluginBaseInfoHelper.Base64Helper.encodeToString("1".getBytes(), 0));
            if (TextUtils.isEmpty(string)) {
                encodeToString = "";
            } else {
                encodeToString = PluginBaseInfoHelper.Base64Helper.encodeToString(string.getBytes(), 0);
            }
            hashMap.put("title", encodeToString);
            if (type.startsWith("text")) {
                return jumpActivity.qqFavHandleTypeTxt(bundle, hashMap, uri, string2);
            }
            if (type.startsWith("image")) {
                return jumpActivity.qqFavHandleTypeImage(bundle, hashMap);
            }
            QLog.d("JumpActivityHelper", 1, "startSystemShareToQQFav|unknown type. type=" + type);
            return 1;
        } catch (OutOfMemoryError unused) {
            QLog.d("JumpActivityHelper", 1, "startSystemShareToQQFav|outofmemoryerror");
            return 1;
        }
    }

    public static void I(Intent intent) {
        String action = intent.getAction();
        String dataString = intent.getDataString();
        QLog.i("JumpActivityHelper", 1, "reportJumpArguments action=" + action + "; data=" + dataString);
        HashMap hashMap = new HashMap();
        hashMap.put("action", action);
        hashMap.put("data", dataString);
        QQBeaconReport.report("", "JA_ARGUMENTS", hashMap);
    }

    public static void J(JumpActivity jumpActivity, boolean z16, Intent intent) {
        f196425a.n(jumpActivity, z16, intent);
    }

    public static void K(JumpActivity jumpActivity, Bundle bundle) {
        String string = bundle.getString("android.intent.extra.TEXT");
        String type = jumpActivity.getIntent().getType();
        if ("cn.wps.moffice_eng".equals(bundle.getString("pkg_name"))) {
            ReportController.o(jumpActivity.getAppRuntime(), "CliOper", "", "", "0X8008810", "0X8008810", 0, 0, "", "", "", "");
        }
        if (TextUtils.isEmpty(type)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("JumpActivityHelper", 2, "forward form JumpActivity doShare type=" + type);
        }
        if (type.startsWith("text") && !bundle.containsKey("android.intent.extra.STREAM")) {
            X(jumpActivity, string);
        } else if (type.startsWith("message")) {
            V(jumpActivity, bundle);
        } else if (type.startsWith("image")) {
            if (U(jumpActivity, bundle)) {
                return;
            }
        } else if (T(jumpActivity, bundle, type)) {
            return;
        }
        String scheme = jumpActivity.getIntent().getScheme();
        if (!TextUtils.isEmpty(scheme) && scheme.equals("geo")) {
            Intent intent = new Intent();
            intent.putExtras(new Bundle());
            intent.putExtra("isFromShare", true);
            intent.putExtra(AppConstants.Key.FORWARD_IS_FROMJUMP, true);
            intent.putExtra("forward_type", -2);
            intent.setData(jumpActivity.getIntent().getData());
            f196425a.j(intent, jumpActivity);
            jumpActivity.finish();
            return;
        }
        jumpActivity.finish();
    }

    public static void L(JumpActivity jumpActivity, boolean z16) {
        Intent intent = jumpActivity.getIntent();
        if (intent == null) {
            QLog.i("JumpActivityHelper", 1, "system share.doShare error intent is null");
            jumpActivity.finish();
            return;
        }
        if (intent.getExtras() == null) {
            QLog.i("JumpActivityHelper", 1, "system share.doShare error extra is null");
            jumpActivity.finish();
        } else {
            if (BaseForwardUtil.b(jumpActivity)) {
                W(jumpActivity, z16);
                return;
            }
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "noSDPermissionShare", true, 0L, 0L, new HashMap<>(), "");
            boolean S = S(jumpActivity, intent);
            QLog.d("JumpActivityHelper", 1, "system share.doShare needGrantSDPermission=", Boolean.valueOf(S));
            if (S) {
                f196425a.q(jumpActivity, z16);
            } else {
                W(jumpActivity, z16);
            }
        }
    }

    public static boolean M(JumpActivity jumpActivity) {
        Intent intent = jumpActivity.getIntent();
        if (intent != null && !TextUtils.isEmpty(intent.getScheme()) && intent.getScheme().equals("mqqdatamigration")) {
            return true;
        }
        try {
            if (com.tencent.mobileqq.utils.bg.k(jumpActivity)) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void N(JumpActivity jumpActivity) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.addFlags(268435456);
        RouteUtils.startActivity(jumpActivity, intent, RouterConstants.UI_ROUTE_INSTALL);
        jumpActivity.finish();
    }

    public static void O(JumpActivity jumpActivity, boolean z16, String str, boolean z17) {
        Intent intent = jumpActivity.getIntent();
        if (z16 && !jumpActivity.getAppRuntime().isLogin()) {
            JumpActivity.sIsStartFromThirdParty = true;
            Intent intent2 = new Intent();
            intent2.putExtra("isActionSend", true);
            intent2.putExtras(intent2);
            intent2.setFlags(16777216);
            RouteUtils.startActivityForResult(jumpActivity, intent2, RouterConstants.UI_ROUTER_LOGIN, 26);
            return;
        }
        if (z17 && ((IQJumpApi) QRoute.api(IQJumpApi.class)).gestureGetJumpLock(jumpActivity, jumpActivity.getAppRuntime().getCurrentAccountUin())) {
            RouteUtils.startActivityForResult(jumpActivity, new Intent(), RouterConstants.UI_ROUTE_GESTURE_PWD_UNLOCK, 27);
            return;
        }
        JumpActivity.sIsStartFromThirdParty = false;
        com.tencent.mobileqq.utils.ax c16 = com.tencent.mobileqq.utils.bi.c((BaseQQAppInterface) jumpActivity.getAppRuntime(), jumpActivity, intent.getDataString());
        c16.v(str);
        c16.B(jumpActivity.mPackageName);
        if (c16.b()) {
            jumpActivity.finish();
        } else {
            QLog.i("JumpActivityHelper", 1, "[doRealThirdPartyCheckLoginAndGesture]: doAction result is false ", new Exception());
        }
    }

    public static void P(JumpActivity jumpActivity, Intent intent) {
        Parcelable parcelableExtra;
        try {
            parcelableExtra = intent.getParcelableExtra(((IQJumpApi) QRoute.api(IQJumpApi.class)).getSecurityVerifyPluginDataKey());
        } catch (Exception e16) {
            QLog.d(LogTag.TAG_SECURITY_VERIFY, 1, "goToWebSecVerify", e16);
        }
        if (!TextUtils.isEmpty(intent.getStringExtra("url")) && ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).isInviteOrJoinTroopParam(parcelableExtra)) {
            Intent intent2 = new Intent();
            intent2.putExtras(intent);
            RouteUtils.startActivityForResult(jumpActivity, intent2, RouterConstants.UI_ROUTE_BROWSER, 25);
        } else {
            QLog.d(LogTag.TAG_SECURITY_VERIFY, 1, "goToWebSecVerify, error param!");
            jumpActivity.finish();
        }
    }

    public static void Q(JumpActivity jumpActivity, boolean z16, String str, boolean z17) {
        Intent intent = jumpActivity.getIntent();
        if (z16 && !jumpActivity.getAppRuntime().isLogin()) {
            JumpActivity.sIsStartFromWpa = true;
            Intent intent2 = new Intent();
            intent2.putExtra("isActionSend", true);
            intent2.putExtras(intent2);
            intent2.setFlags(16777216);
            RouteUtils.startActivityForResult(jumpActivity, intent2, RouterConstants.UI_ROUTER_LOGIN, 21);
            return;
        }
        if (z17 && ((IQJumpApi) QRoute.api(IQJumpApi.class)).gestureGetJumpLock(jumpActivity, jumpActivity.getAppRuntime().getCurrentAccountUin())) {
            RouteUtils.startActivityForResult(jumpActivity, new Intent(), RouterConstants.UI_ROUTE_GESTURE_PWD_UNLOCK, 22);
            return;
        }
        JumpActivity.sIsStartFromWpa = false;
        com.tencent.mobileqq.utils.ax c16 = com.tencent.mobileqq.utils.bi.c((BaseQQAppInterface) jumpActivity.getAppRuntime(), jumpActivity, intent.getDataString());
        "wpa".equals(c16.f307441f.get("chat_type"));
        c16.v(str);
        c16.b();
        jumpActivity.finish();
    }

    public static void R(Context context, Intent intent) {
        String className;
        String str;
        try {
            if (intent.getComponent() != null && (className = intent.getComponent().getClassName()) != null) {
                if ((className.contains("QQBrowserActivity") || className.contains("QQBrowserDelegationActivity")) && !intent.hasExtra("StartClickTime")) {
                    intent.putExtra("StartClickTime", SystemClock.elapsedRealtime());
                    String fragmentName = JumpActivity.getFragmentName(context);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(context.getClass().getName());
                    if (TextUtils.isEmpty(fragmentName)) {
                        str = "";
                    } else {
                        str = "$" + fragmentName;
                    }
                    sb5.append(str);
                    intent.putExtra("SourceActivityName", sb5.toString());
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean S(JumpActivity jumpActivity, Intent intent) {
        Uri parse;
        if (intent == null) {
            return false;
        }
        Uri uri = null;
        try {
            Bundle extras = intent.getExtras();
            StringBuilder sb5 = new StringBuilder("system share.doShareCheckNeedSDPermission():");
            sb5.append("phone info [mod:");
            sb5.append(DeviceInfoMonitor.getModel());
            sb5.append(",ver:");
            sb5.append(Build.VERSION.SDK);
            sb5.append(",maf:");
            sb5.append(Build.MANUFACTURER);
            sb5.append("]");
            Object obj = extras.get("android.intent.extra.STREAM");
            if (obj != null) {
                if (obj instanceof Uri) {
                    parse = (Uri) obj;
                } else if (obj instanceof String) {
                    parse = Uri.parse((String) obj);
                }
                uri = parse;
            }
            sb5.append(",intent.extra=");
            sb5.append(uri);
            QLog.i("JumpActivityHelper", 1, sb5.toString());
        } catch (Exception e16) {
            QLog.e("JumpActivityHelper", 1, "system share.doShareCheckNeedSDPermission() e=", e16);
        }
        Boolean a16 = f196425a.a(jumpActivity, uri);
        if (a16 == null) {
            return false;
        }
        return a16.booleanValue();
    }

    private static boolean T(JumpActivity jumpActivity, Bundle bundle, String str) {
        String action = jumpActivity.getIntent().getAction();
        Intent intent = new Intent();
        intent.putExtra("isFromShare", true);
        intent.putExtra(AppConstants.Key.FORWARD_IS_FROMJUMP, true);
        intent.putExtra("forward_type", 0);
        intent.putExtra("system_share", true);
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
        intent.putExtra("intent_create_process_id", Process.myPid());
        intent.putExtra("intent_create_time", System.currentTimeMillis());
        if (action.equals("android.intent.action.SEND")) {
            Object obj = bundle.get("android.intent.extra.STREAM");
            if (obj != null) {
                if (obj instanceof Uri) {
                    Uri uri = (Uri) obj;
                    if ("text/x-vcard".equals(str) && "content".equals(uri.getScheme())) {
                        intent.putExtra("sendMultiple", false);
                        intent.putExtras(bundle);
                        new JumpActivity.c(intent).execute(jumpActivity.getApplicationContext(), uri);
                        return true;
                    }
                    String path = uri.getPath();
                    Uri e16 = e(uri);
                    if (e16 == null) {
                        jumpActivity.finish();
                        return true;
                    }
                    if (((IQJumpApi) QRoute.api(IQJumpApi.class)).backToFileScheme() && "file".equals(e16.getScheme())) {
                        QLog.d("JumpActivityHelper", 1, "doShare scheme uriPath=", path);
                        if (path != null && path.startsWith(BaseForwardUtil.a())) {
                            intent.putExtra("path_for_file_scheme", path);
                        }
                    }
                    intent.setData(e16);
                } else if (obj instanceof String) {
                    intent.setData(Uri.parse((String) obj));
                } else {
                    jumpActivity.finish();
                    return true;
                }
                intent.putExtra("sendMultiple", false);
            } else {
                jumpActivity.finish();
                return true;
            }
        } else {
            intent.putExtra("sendMultiple", true);
            intent.putExtra(AppConstants.Key.FORWARD_TEXT, jumpActivity.getString(R.string.a8u));
        }
        intent.putExtras(bundle);
        f196425a.j(intent, jumpActivity);
        if ("android.intent.action.SEND".equalsIgnoreCase(action) || "android.intent.action.SEND_MULTIPLE".equalsIgnoreCase(action)) {
            JumpUriUtils.grantShareUriPermissions(intent, jumpActivity);
        }
        return false;
    }

    private static boolean U(JumpActivity jumpActivity, Bundle bundle) {
        Intent intent = new Intent();
        intent.putExtra("isFromShare", true);
        intent.putExtra(AppConstants.Key.FORWARD_IS_FROMJUMP, true);
        intent.putExtra("k_favorites", true);
        intent.putExtra("system_share", true);
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
        intent.putExtras(new Bundle());
        intent.putExtra("forward_type", 1);
        if (jumpActivity.getIntent().getAction().equals("android.intent.action.SEND")) {
            Object obj = bundle.get("android.intent.extra.STREAM");
            if (obj != null) {
                if (obj instanceof Uri) {
                    Uri uri = (Uri) obj;
                    intent.setData(uri);
                    o0(jumpActivity, uri);
                } else if (obj instanceof String) {
                    String str = (String) obj;
                    intent.setData(Uri.parse(str));
                    o0(jumpActivity, Uri.parse(str));
                } else {
                    jumpActivity.finish();
                    return true;
                }
                intent.putExtra("sendMultiple", false);
            } else {
                jumpActivity.finish();
                return true;
            }
        } else {
            intent.putExtra("sendMultiple", true);
            intent.putExtra(AppConstants.Key.FORWARD_TEXT, jumpActivity.getString(R.string.a8u));
        }
        intent.putExtras(bundle);
        RouteUtils.startActivity(jumpActivity, intent, RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT);
        return false;
    }

    private static void V(JumpActivity jumpActivity, Bundle bundle) {
        Intent intent = new Intent();
        intent.putExtras(new Bundle());
        intent.putExtra("isFromShare", true);
        intent.putExtra(AppConstants.Key.FORWARD_IS_FROMJUMP, true);
        intent.putExtra("k_favorites", true);
        intent.putExtra("forward_type", -1);
        intent.putExtra(AppConstants.Key.FORWARD_TEXT, (SpannableString) bundle.get("android.intent.extra.TEXT"));
        RouteUtils.startActivity(jumpActivity, intent, RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT);
        jumpActivity.finish();
    }

    public static void W(JumpActivity jumpActivity, boolean z16) {
        Intent intent = jumpActivity.getIntent();
        Bundle extras = intent.getExtras();
        if (extras == null) {
            QLog.i("JumpActivityHelper", 1, "system share.doShare error extra is null");
            jumpActivity.finish();
            return;
        }
        if (z16 && !jumpActivity.getAppRuntime().isLogin()) {
            Intent intent2 = new Intent();
            intent2.putExtra("isActionSend", true);
            intent2.putExtras(extras);
            intent2.putExtras(intent2);
            RouteUtils.startActivityForResult(jumpActivity, intent2, RouterConstants.UI_ROUTER_LOGIN, 19);
            return;
        }
        if (extras.getBoolean("qqfav_extra_from_system_share", false)) {
            int doQfavShare = jumpActivity.doQfavShare(extras);
            if (doQfavShare == 4) {
                Y(jumpActivity, R.string.ezz, 1);
            } else if (doQfavShare != 0) {
                Y(jumpActivity, R.string.ezv, 1);
            }
            jumpActivity.finish();
            return;
        }
        c(jumpActivity, intent, 0);
    }

    private static void X(JumpActivity jumpActivity, String str) {
        Intent intent = new Intent();
        intent.putExtras(new Bundle());
        intent.putExtra("isFromShare", true);
        intent.putExtra(AppConstants.Key.FORWARD_IS_FROMJUMP, true);
        intent.putExtra("k_favorites", true);
        intent.putExtra("system_share", true);
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
        intent.putExtra("forward_type", -1);
        intent.putExtra(AppConstants.Key.FORWARD_TEXT, str);
        RouteUtils.startActivity(jumpActivity, intent, RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT);
    }

    public static void Y(Context context, int i3, int i16) {
        QQToast makeText = QQToast.makeText(context, i16, i3, 2000);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.title_bar_height) - ((int) com.tencent.mobileqq.utils.al.a(context, 5.0f));
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable(dimensionPixelSize) { // from class: com.tencent.mobileqq.app.parser.JumpActivityHelper.2
                static IPatchRedirector $redirector_;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f196430e;

                {
                    this.f196430e = dimensionPixelSize;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQToast.this, dimensionPixelSize);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        QQToast.this.show(this.f196430e);
                    }
                }
            });
        } else {
            makeText.show(dimensionPixelSize);
        }
    }

    private static void Z(JumpActivity jumpActivity, Intent intent) {
        ((IQJumpApi) QRoute.api(IQJumpApi.class)).qzoneLaunchForPreview(jumpActivity, intent.getExtras());
        jumpActivity.finish();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003e, code lost:
    
        r7 = com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor.getPackageInfo(r7.getPackageManager(), r3, 64);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0048, code lost:
    
        if (r7 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
    
        r7 = r7.signatures;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
    
        if (r7 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004f, code lost:
    
        if (r7.length <= 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0051, code lost:
    
        r2 = java.security.MessageDigest.getInstance(com.tencent.soter.core.keystore.KeyPropertiesCompact.DIGEST_MD5);
        r2.update(r7[0].toByteArray());
        r1 = com.tencent.mobileqq.utils.HexUtil.bytes2HexStr(r2.digest());
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0069, code lost:
    
        if (r1 != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006b, code lost:
    
        r7 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0073, code lost:
    
        r1 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006f, code lost:
    
        r7 = r1.toLowerCase();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Pair<String, String> a0(JumpActivity jumpActivity, Intent intent) {
        boolean z16 = false;
        String str = null;
        int i3 = 0;
        String str2 = null;
        while (true) {
            if (i3 >= 3) {
                break;
            }
            try {
                str2 = jumpActivity.getCallingPackage();
                if (TextUtils.isEmpty(str2)) {
                    QLog.i("JumpActivityHelper", 1, "-->onCreate getCallingPackage returns null!");
                    ComponentName callingActivity = jumpActivity.getCallingActivity();
                    if (callingActivity != null) {
                        str2 = callingActivity.getPackageName();
                        if (TextUtils.isEmpty(str2)) {
                            QLog.i("JumpActivityHelper", 1, "-->onCreate get package from activity returns null!");
                        }
                    } else {
                        QLog.i("JumpActivityHelper", 1, "-->onCreate getCallingActivity returns null!");
                    }
                }
                if (!TextUtils.isEmpty(str2)) {
                    break;
                }
                i3++;
            } catch (Exception e16) {
                QLog.e("JumpActivityHelper", 1, "getCallingPkgAndSig: excepton.", e16);
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            if ("emu".equals(com.tencent.open.agent.util.c.i(intent.getExtras(), "bif")) && TextUtils.equals(str2, MobileQQ.PACKAGE_NAME)) {
                z16 = true;
            }
            if (z16) {
                str2 = intent.getStringExtra("pkg_name");
                str = com.tencent.open.agent.util.c.l(intent, "packagesign");
                QLog.w("JumpActivityHelper", 1, "use userPkgName, callingPkgName=" + str2);
            }
        }
        return new Pair<>(str2, str);
    }

    public static boolean b(JumpActivity jumpActivity, com.tencent.mobileqq.utils.ax axVar) {
        return r(jumpActivity.getAppRuntime(), axVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Uri b0(Object[] objArr) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        StringBuilder sb5;
        Context context = (Context) objArr[0];
        Uri uri = (Uri) objArr[1];
        String str = "save_contact.vcf";
        String str2 = AppConstants.SDCARD_SHARE_VCARD;
        Cursor cursor = null;
        r11 = null;
        r11 = null;
        FileInputStream fileInputStream2 = null;
        cursor = null;
        try {
            Cursor query = ContactsMonitor.query(context.getContentResolver(), uri, new String[]{InputMethodUtil.SOUGOU_URI_DISPLAYNAME}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str = query.getString(0);
                        query.close();
                    }
                } catch (Exception e16) {
                    e = e16;
                    fileInputStream = null;
                    fileOutputStream = null;
                    cursor = query;
                    try {
                        e.printStackTrace();
                        if (cursor != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        sb5 = new StringBuilder();
                        sb5.append("file://");
                        sb5.append(str2);
                        sb5.append(str);
                        return Uri.parse(sb5.toString());
                    } catch (Throwable th5) {
                        th = th5;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e17) {
                                e17.printStackTrace();
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                            }
                        }
                        Uri.parse("file://" + str2 + str);
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    fileInputStream = null;
                    fileOutputStream = null;
                    cursor = query;
                    if (cursor != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    Uri.parse("file://" + str2 + str);
                    throw th;
                }
            }
            if (!FileUtils.fileExists(str2)) {
                new File(str2).mkdirs();
            }
            fileOutputStream = new FileOutputStream(new File(str2 + str));
            try {
                AssetFileDescriptor openAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, "r");
                if (openAssetFileDescriptor != null) {
                    fileInputStream2 = openAssetFileDescriptor.createInputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                }
                if (query != null) {
                    query.close();
                }
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e19) {
                        e19.printStackTrace();
                    }
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e26) {
                    e26.printStackTrace();
                }
                sb5 = new StringBuilder();
            } catch (Exception e27) {
                e = e27;
                fileInputStream = fileInputStream2;
                cursor = query;
                e.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e28) {
                        e28.printStackTrace();
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e29) {
                        e29.printStackTrace();
                    }
                }
                sb5 = new StringBuilder();
                sb5.append("file://");
                sb5.append(str2);
                sb5.append(str);
                return Uri.parse(sb5.toString());
            } catch (Throwable th7) {
                th = th7;
                fileInputStream = fileInputStream2;
                cursor = query;
                if (cursor != null) {
                }
                if (fileInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                Uri.parse("file://" + str2 + str);
                throw th;
            }
        } catch (Exception e36) {
            e = e36;
            fileInputStream = null;
            fileOutputStream = null;
        } catch (Throwable th8) {
            th = th8;
            fileInputStream = null;
            fileOutputStream = null;
        }
        sb5.append("file://");
        sb5.append(str2);
        sb5.append(str);
        return Uri.parse(sb5.toString());
    }

    public static synchronized void c(JumpActivity jumpActivity, Intent intent, int i3) {
        synchronized (JumpActivityHelper.class) {
            if (jumpActivity.mBgThread == null) {
                HandlerThread newFreeHandlerThread = ThreadManagerV2.newFreeHandlerThread("jump_action_thread", 0);
                jumpActivity.mBgThread = newFreeHandlerThread;
                newFreeHandlerThread.start();
                jumpActivity.mBgHandler = new MqqHandler(jumpActivity.mBgThread.getLooper());
            }
            f196425a.m(jumpActivity, intent, i3);
        }
    }

    public static void c0(JumpActivity jumpActivity) {
        f196425a.c(jumpActivity);
        jumpActivity.finish();
    }

    private static void d(JumpActivity jumpActivity, com.tencent.mobileqq.utils.ax axVar, boolean z16, boolean z17, boolean z18) {
        if (QLog.isColorLevel()) {
            QLog.d("JumpActivityHelper", 2, "JumpActivity is finish");
        }
        if (!z17) {
            jumpActivity.initFinishBroadcastReceiver();
            return;
        }
        if (axVar.f307439d != null && axVar.f307440e != null) {
            if (i0(axVar, "gav", Const.BUNDLE_KEY_REQUEST)) {
                if (!"0".equals(axVar.f("relation_id")) && z16) {
                    jumpActivity.finish();
                    return;
                }
                return;
            }
            if (!i0(axVar, "videochat", Const.BUNDLE_KEY_REQUEST) && !i0(axVar, "randomavchat", Const.BUNDLE_KEY_REQUEST)) {
                if (i0(axVar, QCircleDaTongConstant.ElementParamValue.WALLET, "modify_pass")) {
                    if (z16) {
                        jumpActivity.finish();
                        return;
                    }
                    return;
                }
                if (axVar.l()) {
                    if (z16) {
                        jumpActivity.finish();
                        return;
                    }
                    return;
                }
                if (i0(axVar, "qcircle", QCircleScheme.Q_CIRCLE_ACTION_OPEN_CIRCLE_CONTENT_DETAIL)) {
                    jumpActivity.finish();
                    return;
                }
                if (i0(axVar, ProcessConstant.READINJOY, "open")) {
                    QLog.i("JumpActivityHelper", 1, "[beforeFinish] kd open.");
                    jumpActivity.finish();
                    return;
                }
                if (b(jumpActivity, axVar)) {
                    QLog.d("JumpActivityHelper", 1, "asynShareJumpAction wait for finishing");
                    return;
                }
                if (!j0(jumpActivity, axVar)) {
                    if (axVar.f307458w) {
                        jumpActivity.finish();
                        jumpActivity.overridePendingTransition(0, 0);
                        return;
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d("JumpActivityHelper", 2, "wait for finishing");
                            return;
                        }
                        return;
                    }
                }
                if (z18 && i0(axVar, "qzone", "publish")) {
                    QLog.i("JumpActivityHelper", 1, "beforeFinish: qzone publish finish");
                    jumpActivity.finish();
                }
                jumpActivity.initBroadcastReceiver();
                return;
            }
            if (z16) {
                jumpActivity.finish();
                return;
            }
            return;
        }
        jumpActivity.finish();
    }

    public static void d0(JumpActivity jumpActivity, Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("comicID");
            if (!stringExtra.equalsIgnoreCase("0") && !TextUtils.isEmpty(stringExtra)) {
                Intent intent2 = new Intent();
                intent2.setFlags(1073741824);
                intent2.putExtras(intent);
                RouteUtils.startActivity(jumpActivity, intent2, RouterConstants.UI_ROUTE_BROWSER);
            } else {
                ActivityURIRequest activityURIRequest = new ActivityURIRequest(jumpActivity, RouterConstants.UI_ROUTER_VIPCOMIC);
                activityURIRequest.extra().putAll(intent.getExtras());
                QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
            }
        }
        jumpActivity.finish();
    }

    private static Uri e(Uri uri) {
        if (uri != null && "file".equals(uri.getScheme())) {
            String path = uri.getPath();
            if (!TextUtils.isEmpty(path)) {
                File file = new File(path);
                if (file.exists()) {
                    try {
                        String canonicalPath = file.getCanonicalPath();
                        QLog.d("JumpActivityHelper", 1, "checkAndRebuildFileUri path", path, ", actFilePath=", canonicalPath);
                        if (!canonicalPath.startsWith(BaseForwardUtil.a() + BaseApplication.getContext().getPackageName())) {
                            return Uri.parse("file://" + canonicalPath);
                        }
                        return null;
                    } catch (Exception unused) {
                        return uri;
                    }
                }
                return uri;
            }
            return uri;
        }
        return uri;
    }

    private static void e0(JumpActivity jumpActivity) {
        try {
            ((IQJumpApi) QRoute.api(IQJumpApi.class)).buildMapActivityProxy(jumpActivity.getAppRuntime().getAccount());
            RouteUtils.startActivityForResult(jumpActivity, new Intent().putExtra("uin", jumpActivity.getAppRuntime().getAccount()), RouterConstants.UI_ROUTE_QQMAP, 18);
        } catch (Exception unused) {
            if (jumpActivity.doCallBack) {
                n(jumpActivity, "Google Map not exist");
            }
            jumpActivity.finish();
        }
    }

    public static boolean f(String str) {
        if (JumpActivity.sLegalPrefix == null) {
            synchronized (com.tencent.mobileqq.utils.ax.class) {
                if (JumpActivity.sLegalPrefix == null) {
                    JumpActivity.sLegalPrefix = new HashMap<>();
                    int i3 = 0;
                    while (true) {
                        String[] strArr = JumpActivity.sLegalPrefixes;
                        if (i3 >= strArr.length) {
                            break;
                        }
                        JumpActivity.sLegalPrefix.put(strArr[i3], Integer.valueOf(i3));
                        i3++;
                    }
                    if (!JumpActivity.sSwitchInited) {
                        JumpActivity.initJASwitch();
                    }
                }
            }
        }
        return JumpActivity.sLegalPrefix.containsKey(str);
    }

    private static String f0(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.close();
                return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
            }
        }
    }

    public static boolean g(JumpActivity jumpActivity, Intent intent) {
        if (CommonConstant.ACTION.HWID_SCHEME_URL.equals(intent.getAction()) && intent.getIntExtra("MINI_CONFIG_SCENE", -1) > 0 && !TextUtils.isEmpty(intent.getStringExtra("CONFIG_APPID"))) {
            JumpActivity.doJumpToMiniApp(jumpActivity, true);
            return false;
        }
        if ("from_nearby_pb".equals(intent.getStringExtra("from"))) {
            o(jumpActivity, intent);
            return false;
        }
        if ("from_gesturemgr_download".equals(intent.getAction())) {
            jumpActivity.finish();
            return false;
        }
        if ("from_webtool_launchshortvideo".equals(intent.getAction())) {
            Z(jumpActivity, intent);
            return false;
        }
        if (!"android.intent.action.SEND".equals(intent.getAction()) && !"android.intent.action.SEND_MULTIPLE".equals(intent.getAction())) {
            if (!CommonConstant.ACTION.HWID_SCHEME_URL.equals(intent.getAction()) || (!"file".equals(intent.getScheme()) && !"content".equals(intent.getScheme()))) {
                return true;
            }
            JumpActivity.doView(jumpActivity, true);
            return false;
        }
        JumpActivity.doShare(jumpActivity, true);
        return false;
    }

    private static boolean g0(String str) {
        List<SimpleAccount> allAccounts = MobileQQ.sMobileQQ.getAllAccounts();
        if (allAccounts != null) {
            for (SimpleAccount simpleAccount : allAccounts) {
                if (simpleAccount != null && TextUtils.equals(str, simpleAccount.getUin()) && simpleAccount.isLogined()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean h(JumpActivity jumpActivity, Intent intent) {
        if (p(jumpActivity)) {
            return false;
        }
        if ("android.intent.action.SENDTO".equals(intent.getAction()) && "imto".equals(intent.getScheme())) {
            jumpActivity.doSumsungCallUp();
            return false;
        }
        if ("thridapp".equals(intent.getStringExtra(WinkDaTongReportConstant.ElementParamKey.SHARE_FROM))) {
            return f196425a.d(jumpActivity, intent);
        }
        if (("android.intent.action.MAIN".equals(intent.getAction()) && intent.getBooleanExtra("_is_from_qlink_shortcut", false)) || intent.getBooleanExtra("_goto_qlink_when_login_suc_", false)) {
            jumpActivity.doJumpQlink(intent);
            return false;
        }
        if ("com.tencent.qqcomic.SHORT_CUT".equals(intent.getAction())) {
            jumpActivity.doJumpQQComic(intent);
            return false;
        }
        if (("android.intent.action.MAIN".equals(intent.getAction()) && intent.getBooleanExtra("_is_from_qfile_shortcut", false)) || intent.getBooleanExtra("_goto_qfile_when_login_suc_", false)) {
            jumpActivity.doJumpQfile(intent);
            return false;
        }
        if ("android.intent.action.MAIN".equals(intent.getAction()) && intent.getBooleanExtra("jump_shortcut_dataline", false)) {
            jumpActivity.doJumpDataLine(intent);
            jumpActivity.finish();
            return false;
        }
        if ("kandianugc".equals(intent.getScheme())) {
            jumpActivity.doJumpReadInjoy(intent);
            jumpActivity.finish();
            return false;
        }
        if ("android.intent.action.MAIN".equals(intent.getAction()) && intent.getBooleanExtra("_is_from_kandian_shortcut", false)) {
            z(jumpActivity, intent);
            return false;
        }
        if ("mqqdatamigration".equals(intent.getScheme())) {
            s(jumpActivity, intent);
            return false;
        }
        return true;
    }

    private static boolean h0(com.tencent.mobileqq.utils.ax axVar) {
        HashMap<String, String> hashMap;
        if (!i0(axVar, "forward", "url") || (hashMap = axVar.f307441f) == null) {
            return false;
        }
        return "weixin-share".equals(hashMap.get("from"));
    }

    public static boolean i(JumpActivity jumpActivity, Intent intent) {
        if ("mqq".equals(intent.getScheme()) && "mqq://".equals(intent.getDataString())) {
            QLog.i("JumpActivityHelper", 1, "[dealByIntentData3] jump splash");
            E(jumpActivity);
            return false;
        }
        if ("com.tencent.security.VERIFY_WEB".equals(intent.getAction())) {
            jumpActivity.goToWebSecVerify(intent);
            return false;
        }
        if (f196425a.o(jumpActivity, intent)) {
            QLog.i("JumpActivityHelper", 1, "[dealByIntentData3] handleThirdPushJump");
            jumpActivity.finish();
            return false;
        }
        b.a aVar = new b.a();
        if (f196425a.i(jumpActivity, intent, aVar)) {
            QLog.i("JumpActivityHelper", 1, "[dealByIntentData3] handleThirdMessagePush, finishJumpActivity=" + aVar.f196482a);
            if (aVar.f196482a) {
                jumpActivity.finish();
            } else {
                jumpActivity.initFinishBroadcastReceiver();
            }
            return false;
        }
        QLog.i("JumpActivityHelper", 1, "[dealByIntentData3] not handled");
        return true;
    }

    private static boolean i0(com.tencent.mobileqq.utils.ax axVar, String str, String str2) {
        if (str2 == null || str == null || !str.equals(axVar.f307439d) || !str2.equals(axVar.f307440e)) {
            return false;
        }
        return true;
    }

    private static boolean j(JumpActivity jumpActivity, Intent intent, com.tencent.mobileqq.utils.ax axVar, String str, String str2, String str3, String str4) {
        String str5;
        if (axVar.f307439d.equals("qqidentifier") && str3 == null) {
            QLog.e("JumpActivityHelper", 1, "can not get caller");
            jumpActivity.finish();
            return false;
        }
        if (axVar.f307439d.equals(AppConstants.Key.KEY_PUZZLE_VERIFY_CODE) && axVar.f307440e != null) {
            Intent intent2 = new Intent(jumpActivity.getIntent());
            if (axVar.f307440e.equals("PUZZLEVERIFYCODE")) {
                f196425a.k(jumpActivity);
                RouteUtils.startActivity(jumpActivity, intent2, RouterConstants.UI_ROUTE_BROWSER);
            } else if (axVar.f307440e.equals("VERIFYCODE")) {
                RouteUtils.startActivity(jumpActivity, intent2, RouterConstants.UI_ROUTE_VERIFY_CODE);
            }
            jumpActivity.finish();
            return false;
        }
        if (!str.startsWith("mqqwpa://im") && !str.startsWith("mqqwpaopenid://im")) {
            if (str.startsWith("mqqapi:") && (str3 == null || "com.tencent.mobileqq".equals(str3))) {
                str5 = jumpActivity.getIntent().getStringExtra("pkg_name");
            } else {
                str5 = str3;
            }
            if (!str.startsWith("mqqapi://im") && !str.startsWith("mqqapi://connect_miniapp")) {
                return k(jumpActivity, intent, axVar, str, str2, str5, str4);
            }
            jumpActivity.mPackageName = str5;
            JumpActivity.doThirdPartyCheckLoginAndGesture(jumpActivity, true, str2, true);
            return false;
        }
        JumpActivity.dowpa(jumpActivity, true, str2, true);
        return false;
    }

    public static boolean j0(JumpActivity jumpActivity, com.tencent.mobileqq.utils.ax axVar) {
        return G(jumpActivity, axVar);
    }

    private static boolean k(JumpActivity jumpActivity, Intent intent, com.tencent.mobileqq.utils.ax axVar, String str, String str2, String str3, String str4) {
        boolean z16;
        boolean z17;
        boolean z18 = axVar.J;
        if (i0(axVar, "ptlogin", "qlogin") || axVar.f307439d.equals("qqreg") || "invite_register".equals(axVar.f307440e)) {
            z18 = false;
        }
        boolean z19 = true;
        if (!jumpActivity.getAppRuntime().isLogin() && z18) {
            Intent intent2 = new Intent();
            intent2.putExtra(AppConstants.Key.SHARE_REQ_SCHEME_CONTENT_ORIGINAL, str);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            String str5 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
            if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                str5 = ContainerUtils.FIELD_DELIMITER;
            }
            sb5.append(str5);
            intent2.putExtra(AppConstants.Key.SHARE_REQ_SCHEME_CONTENT, sb5.toString() + "jfrom=login");
            intent2.putExtra("pkg_name", str3);
            intent2.putExtra("useNewLoginPage", true);
            intent2.setFlags(268435456);
            if (i0(axVar, "profile", "sdk_face_collection")) {
                intent2.putParcelableArrayListExtra("android.intent.extra.STREAM", jumpActivity.getIntent().getParcelableArrayListExtra("android.intent.extra.STREAM"));
            }
            if (VersionUtils.isHoneycomb()) {
                intent2.addFlags(32768);
            }
            if (h0(axVar)) {
                l0(axVar, intent2);
            }
            ((IOpenSdkJumpActionStashApi) QRoute.api(IOpenSdkJumpActionStashApi.class)).recordJumpAction(intent2);
            RouteUtils.startActivity(jumpActivity, intent2, RouterConstants.UI_ROUTER_LOGIN);
            z17 = true;
        } else if (f196425a.g(jumpActivity, str)) {
            QLog.d("JumpActivityHelper", 1, "to GesturePWDUnlockActivity pkgName=", str3);
            QRoute.createNavigator(jumpActivity, RouterConstants.UI_ROUTE_GESTURE_PWD_UNLOCK).withBoolean(GesturePWDUnlockActivity.KEY_GESTURE_FROM_JUMPACTIVITY, true).withString(AppConstants.Key.SHARE_REQ_SCHEME_CONTENT, str).withString("pkg_name", str3).requestWithReturn();
            z17 = false;
        } else {
            if (i0(axVar, "gvideo", "open_plugin")) {
                f196425a.h(jumpActivity, intent);
                jumpActivity.finish();
                return false;
            }
            if (i0(axVar, "nearby_videochat", "open_plugin")) {
                f196425a.p(jumpActivity, intent);
                return false;
            }
            if (i0(axVar, "qwerewolf", "enterHomePage")) {
                ((IQJumpApi) QRoute.api(IQJumpApi.class)).nearByEnterNewGame(jumpActivity);
                jumpActivity.finish();
                return false;
            }
            if (str.startsWith("mqqapi://tenpay/pay?")) {
                String stringExtra = intent.getStringExtra("url_app_info");
                if (!TextUtils.isEmpty(stringExtra)) {
                    axVar.r("url_app_info", stringExtra);
                }
            }
            axVar.B(str3);
            axVar.C(str4);
            QLog.d("JumpActivityHelper", 1, "dealByOtherUrlData(), jaAction.doAction() call. jaAction class:" + axVar.getClass().getSimpleName());
            if (h0(axVar)) {
                axVar.f307460y = true;
            }
            z16 = false;
            z19 = axVar.b();
            z17 = true;
            d(jumpActivity, axVar, z19, z17, z16);
            return false;
        }
        z16 = z17;
        d(jumpActivity, axVar, z19, z17, z16);
        return false;
    }

    public static void k0(JumpActivity jumpActivity, boolean z16, int i3, int i16, String str, String str2) {
        try {
            jumpActivity.uiHandler.sendEmptyMessage(1);
            if (z16 && i3 == 0 && i16 == 1) {
                if (!TextUtils.isEmpty(str)) {
                    Intent intent = new Intent();
                    intent.putExtra("url", str);
                    intent.putExtra("hide_more_button", true);
                    RouteUtils.startActivity(jumpActivity, intent, RouterConstants.UI_ROUTE_BROWSER);
                }
                jumpActivity.finish();
                return;
            }
            if (!"android.intent.action.SEND".equals(str2) && !"android.intent.action.SEND_MULTIPLE".equals(str2)) {
                if (CommonConstant.ACTION.HWID_SCHEME_URL.equals(str2)) {
                    Intent intent2 = jumpActivity.getIntent();
                    Bundle extras = intent2.getExtras();
                    if (extras == null) {
                        extras = new Bundle();
                    }
                    jumpActivity.doView(intent2, extras);
                    return;
                }
                return;
            }
            jumpActivity.doShare(jumpActivity.getIntent().getExtras());
        } catch (Throwable th5) {
            QLog.e("JumpActivityHelper", 1, th5, new Object[0]);
        }
    }

    public static boolean l(JumpActivity jumpActivity, Intent intent) {
        String str;
        String dataString = jumpActivity.getIntent().getDataString();
        String stringExtra = jumpActivity.getIntent().getStringExtra("from");
        Pair<String, String> a06 = a0(jumpActivity, intent);
        String str2 = a06.first;
        String str3 = a06.second;
        if (str2 == null) {
            String stringExtra2 = jumpActivity.getIntent().getStringExtra("pkg_name");
            StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("osVersion", Build.VERSION.RELEASE);
            hashMap.put("deviceName", Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel());
            statisticCollector.collectPerformance("", "GetCallingPackageEmpty", true, 0L, 0L, hashMap, "");
            str = stringExtra2;
        } else {
            str = str2;
        }
        OnlinePushJumpReportUtil.a(jumpActivity);
        if (dataString != null) {
            if (QLog.isColorLevel()) {
                QLog.d("JumpActivityHelper", 2, "jump url:" + dataString);
            }
            com.tencent.mobileqq.utils.ax c16 = com.tencent.mobileqq.utils.bi.c((BaseQQAppInterface) jumpActivity.getAppRuntime(), jumpActivity, dataString);
            if ("webview".equals(stringExtra) && c16 != null) {
                c16.v(stringExtra);
            }
            if (c16 != null && c16.f307439d != null) {
                c16.f307442g = true;
                QLog.d("JumpActivityHelper", 1, "dealUriString(), jaAction --> " + c16);
                return j(jumpActivity, intent, c16, dataString, stringExtra, str, str3);
            }
        } else {
            QLog.d("JumpActivityHelper", 1, "dealUriString(), jump url is null!");
        }
        String stringExtra3 = jumpActivity.getIntent().getStringExtra("action");
        if (stringExtra3 == null) {
            QLog.d("JumpActivityHelper", 1, "dealUriString(), action is null!");
            jumpActivity.finish();
            return false;
        }
        jumpActivity.doCallBack = jumpActivity.getIntent().getBooleanExtra("doCallBack", false);
        jumpActivity.srcType = jumpActivity.getIntent().getStringExtra(ISchemeApi.KEY_IOS_SRC_TYPE);
        jumpActivity.callbackType = jumpActivity.getIntent().getStringExtra("callback_type");
        jumpActivity.callbackName = jumpActivity.getIntent().getStringExtra("callback_name");
        if ("photo".equals(stringExtra3)) {
            jumpActivity.isActionPhoto = true;
        } else if ("select_location".equals(stringExtra3)) {
            jumpActivity.isActionSelectLocation = true;
        }
        if (!jumpActivity.isActionPhoto && jumpActivity.isActionSelectLocation) {
            e0(jumpActivity);
        }
        return false;
    }

    private static void l0(com.tencent.mobileqq.utils.ax axVar, Intent intent) {
        String str = axVar.f307441f.get("uin");
        if (TextUtils.isEmpty(str)) {
            QLog.i("JumpActivityHelper", 2, "uinFromWx is empty");
            return;
        }
        if (g0(str)) {
            intent.putExtra("loginFragmentType", 6);
        } else {
            intent.putExtra("loginFragmentType", 5);
        }
        intent.putExtra("uin", str);
    }

    public static Intent m(JumpActivity jumpActivity, boolean z16) {
        Intent intent = jumpActivity.getIntent();
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        if (z16 && !jumpActivity.getAppRuntime().isLogin()) {
            Intent intent2 = new Intent();
            intent2.putExtra("isActionSend", true);
            intent2.putExtras(extras);
            intent2.putExtras(intent);
            RouteUtils.startActivityForResult(jumpActivity, intent2, RouterConstants.UI_ROUTER_LOGIN, 20);
            return null;
        }
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m0(JumpActivity jumpActivity) {
        int i3;
        HashSet<String> b16 = com.tencent.mobileqq.utils.bg.b(jumpActivity);
        StringBuilder sb5 = new StringBuilder();
        if (b16 != null && !b16.isEmpty()) {
            Iterator<String> it = b16.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (sb5.length() > 0) {
                    sb5.append("|");
                }
                sb5.append(next);
            }
        }
        String sb6 = sb5.toString();
        if (!TextUtils.isEmpty(sb6)) {
            if (sb6.contains("com.tencent.mm")) {
                i3 = 1;
            } else if (sb6.contains("com.alibaba.android.rimet")) {
                i3 = 2;
            } else if (sb6.contains("com.tencent.wework")) {
                i3 = 3;
            } else if (sb6.contains("com.ss.android.lark.lite")) {
                i3 = 4;
            }
            ReportController.o(jumpActivity.getAppRuntime(), "dc00898", "", "", "0X800B008", "0X800B008", i3, 0, "", "", "", "");
        }
        i3 = 5;
        ReportController.o(jumpActivity.getAppRuntime(), "dc00898", "", "", "0X800B008", "0X800B008", i3, 0, "", "", "", "");
    }

    public static void n(JumpActivity jumpActivity, String str) {
        String str2;
        if (str != null && jumpActivity.callbackName != null && jumpActivity.callbackType != null && (str2 = jumpActivity.srcType) != null && !"app".equals(str2)) {
            if ("web".equals(jumpActivity.srcType)) {
                if ("javascript".equals(jumpActivity.callbackType)) {
                    String str3 = com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.JAVASCRIPT_PREFIX + jumpActivity.callbackName + "('" + str + "')";
                    Intent intent = new Intent();
                    intent.putExtra("uin", jumpActivity.getAppRuntime().getCurrentAccountUin());
                    intent.setData(Uri.parse(str3));
                    RouteUtils.startActivity(jumpActivity, intent, RouterConstants.UI_ROUTE_BROWSER);
                    return;
                }
                return;
            }
            "internal".equals(jumpActivity.srcType);
        }
    }

    private static String n0(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        if (str.length() != 0) {
            try {
            } catch (Exception unused) {
                return null;
            }
        }
        return new String(PluginBaseInfoHelper.Base64Helper.decode(str, 0));
    }

    private static void o(JumpActivity jumpActivity, Intent intent) {
        com.tencent.mobileqq.utils.ax c16;
        try {
            String dataString = intent.getDataString();
            if (!TextUtils.isEmpty(dataString) && (c16 = com.tencent.mobileqq.utils.bi.c((BaseQQAppInterface) jumpActivity.getAppRuntime(), jumpActivity, dataString)) != null) {
                c16.q();
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.NEARBY, 2, "nearby_pb|exception:" + e16.toString());
            }
        }
        jumpActivity.finish();
    }

    private static void o0(Activity activity, Uri uri) {
        try {
            activity.grantUriPermission(activity.getPackageName(), uri, 1);
        } catch (Throwable th5) {
            QLog.e("JumpActivityHelper", 1, "transformUriReadPermission catch exception: ", th5);
        }
    }

    public static boolean p(JumpActivity jumpActivity) {
        try {
            if (!com.tencent.mobileqq.utils.bh.a(jumpActivity, true)) {
                jumpActivity.finish();
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void q(Intent intent) {
        boolean z16;
        String dataString = intent.getDataString();
        if (intent.getComponent() == null && !TextUtils.isEmpty(dataString)) {
            String scheme = Uri.parse(dataString).getScheme();
            boolean isLegalScheme = JumpActivity.isLegalScheme(scheme);
            if (isLegalScheme) {
                z16 = JumpActivity.needForceSetComponent(scheme);
            } else {
                z16 = false;
            }
            if (QLog.isDevelopLevel()) {
                QLog.w("JumpActivityHelper", 1, "processIntent, scheme[" + scheme + "], isLegalScheme[" + isLegalScheme + "], needForceSetComponent[" + z16 + "]");
            }
            if (isLegalScheme && z16) {
                StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(Global.TRACKING_URL, dataString);
                statisticCollector.collectPerformance("", "JA_ILLEGAL", true, 0L, 0L, hashMap, "");
                intent.setComponent(new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity"));
            }
        }
    }

    public static boolean r(AppRuntime appRuntime, com.tencent.mobileqq.utils.ax axVar) {
        if (axVar != null && axVar.f307441f != null) {
            try {
                IMiniAppService iMiniAppService = (IMiniAppService) QRoute.api(IMiniAppService.class);
                if (iMiniAppService == null || !iMiniAppService.asyncShareMiniProgram(axVar)) {
                    return false;
                }
                return appRuntime.isLogin();
            } catch (Exception e16) {
                QLog.e("JumpActivityHelper", 1, "doRealAsynShareJumpAction", e16);
            }
        }
        return false;
    }

    private static void s(JumpActivity jumpActivity, Intent intent) {
        f196425a.s(jumpActivity, intent);
    }

    public static int t(JumpActivity jumpActivity, HashMap<String, String> hashMap) {
        if (hashMap == null) {
            QLog.e("JumpActivityHelper", 1, "qqFavDoAction error: params are null");
            return 1;
        }
        StringBuilder sb5 = new StringBuilder("mqqapi://share/to_qqfav?");
        Set<String> keySet = hashMap.keySet();
        int i3 = 0;
        for (String str : keySet) {
            sb5.append(str);
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(hashMap.get(str));
            if (i3 != keySet.size() - 1) {
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
            i3++;
        }
        com.tencent.mobileqq.utils.ax c16 = com.tencent.mobileqq.utils.bi.c((BaseQQAppInterface) jumpActivity.getAppRuntime(), jumpActivity, sb5.toString());
        if (c16 == null) {
            QLog.d("JumpActivityHelper", 1, "startSystemShareToQQFav|jump parse fail");
            return 1;
        }
        c16.b();
        QLog.d("JumpActivityHelper", 1, "startSystemShareToQQFav|end");
        return 0;
    }

    public static int u(JumpActivity jumpActivity, Bundle bundle, HashMap<String, String> hashMap) {
        hashMap.put(AppConstants.Key.SHARE_REQ_TYPE, PluginBaseInfoHelper.Base64Helper.encodeToString("5".getBytes(), 0));
        ArrayList arrayList = null;
        Uri parse = null;
        if (jumpActivity.getIntent().getAction().equals("android.intent.action.SEND")) {
            Object obj = bundle.get("android.intent.extra.STREAM");
            if (obj == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("JumpActivityHelper", 2, "startSystemShareToQQFav|action_send extra_stream null");
                }
                return 1;
            }
            if (obj instanceof Uri) {
                parse = (Uri) obj;
            } else if (obj instanceof String) {
                parse = Uri.parse((String) obj);
            }
            if (parse == null) {
                return 1;
            }
            String forwardGetFilePath = ((IQJumpApi) QRoute.api(IQJumpApi.class)).forwardGetFilePath(jumpActivity, parse);
            if (!TextUtils.isEmpty(forwardGetFilePath) && new File(forwardGetFilePath).exists()) {
                try {
                    hashMap.put("file_data", PluginBaseInfoHelper.Base64Helper.encodeToString(URLEncoder.encode(forwardGetFilePath, "UTF-8").getBytes(), 0));
                } catch (UnsupportedEncodingException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("JumpActivityHelper", 2, "startSystemShareToQQFav|encode fail. path=" + forwardGetFilePath + ",exp:" + e16.getMessage());
                    }
                    return 1;
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("JumpActivityHelper", 2, "startSystemShareToQQFav|action_send file path invalid. path=" + forwardGetFilePath);
                }
                return 1;
            }
        } else {
            try {
                arrayList = (ArrayList) bundle.get("android.intent.extra.STREAM");
            } catch (Exception e17) {
                e17.printStackTrace();
            }
            if (arrayList == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("JumpActivityHelper", 2, "startSystemShareToQQFav|action_send_muti extra_stream null");
                }
                return 1;
            }
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                String forwardGetFilePath2 = ((IQJumpApi) QRoute.api(IQJumpApi.class)).forwardGetFilePath(jumpActivity, (Uri) arrayList.get(i3));
                if (!TextUtils.isEmpty(forwardGetFilePath2) && new File(forwardGetFilePath2).exists()) {
                    try {
                        arrayList2.add(URLEncoder.encode(forwardGetFilePath2, "UTF-8"));
                    } catch (UnsupportedEncodingException e18) {
                        if (QLog.isColorLevel()) {
                            QLog.d("JumpActivityHelper", 2, "startSystemShareToQQFav|action_send_muti path encode fail: %s" + e18.getMessage());
                        }
                    }
                }
            }
            if (arrayList2.isEmpty()) {
                if (QLog.isColorLevel()) {
                    QLog.d("JumpActivityHelper", 2, "startSystemShareToQQFav|action_send_muti pathlist empty");
                }
                return 1;
            }
            String str = "";
            for (int i16 = 0; i16 < arrayList2.size(); i16++) {
                str = str + ((String) arrayList2.get(i16));
                if (i16 != arrayList2.size() - 1) {
                    str = str + ";";
                }
            }
            hashMap.put("file_data", PluginBaseInfoHelper.Base64Helper.encodeToString(str.getBytes(), 0));
        }
        return jumpActivity.qqFavDoAction(hashMap);
    }

    public static int v(JumpActivity jumpActivity, Bundle bundle, HashMap<String, String> hashMap, Uri uri, String str) {
        String str2 = "";
        if (!bundle.containsKey("android.intent.extra.STREAM")) {
            hashMap.put(AppConstants.Key.SHARE_REQ_TYPE, PluginBaseInfoHelper.Base64Helper.encodeToString("6".getBytes(), 0));
            if (!TextUtils.isEmpty(str)) {
                str2 = PluginBaseInfoHelper.Base64Helper.encodeToString(str.getBytes(), 0);
            }
            hashMap.put("description", str2);
        } else if (uri != null) {
            InputStream inputStream = null;
            try {
                InputStream openInputStream = jumpActivity.getContentResolver().openInputStream(uri);
                try {
                    String f06 = f0(openInputStream);
                    openInputStream.close();
                    if (TextUtils.isEmpty(f06)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("JumpActivityHelper", 2, "startSystemShareToQQFav|text, extra_stream, empty");
                        }
                        return 1;
                    }
                    hashMap.put(AppConstants.Key.SHARE_REQ_TYPE, PluginBaseInfoHelper.Base64Helper.encodeToString("6".getBytes(), 0));
                    if (!TextUtils.isEmpty(f06)) {
                        str2 = PluginBaseInfoHelper.Base64Helper.encodeToString(f06.getBytes(), 0);
                    }
                    hashMap.put("description", str2);
                } catch (Exception e16) {
                    e = e16;
                    inputStream = openInputStream;
                    QLog.d("JumpActivityHelper", 1, "startSystemShareToQQFav|text, extra_stream, exp:" + e.getMessage());
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                    }
                    return 1;
                }
            } catch (Exception e18) {
                e = e18;
            }
        }
        return jumpActivity.qqFavDoAction(hashMap);
    }

    public static void w(JumpActivity jumpActivity, Intent intent, Bundle bundle) {
        new Runnable(intent, bundle) { // from class: com.tencent.mobileqq.app.parser.JumpActivityHelper.1
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Intent f196427e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Bundle f196428f;

            {
                this.f196427e = intent;
                this.f196428f = bundle;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, JumpActivity.this, intent, bundle);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                int i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    JumpActivityHelper.m0(JumpActivity.this);
                    String type = this.f196427e.getType();
                    Uri data = this.f196427e.getData();
                    Intent intent2 = new Intent();
                    if (type != null && type.startsWith("image")) {
                        i3 = 1;
                    } else {
                        this.f196428f.putBoolean("not_forward", true);
                        i3 = 0;
                    }
                    this.f196428f.putParcelable("android.intent.extra.STREAM", data);
                    intent2.putExtras(this.f196428f);
                    intent2.putExtra("isFromShare", true);
                    intent2.putExtra("forward_type", i3);
                    intent2.putExtra(AppConstants.Key.FORWARD_IS_FROMJUMP, true);
                    intent2.setData(data);
                    intent2.putExtra("sendMultiple", false);
                    RouteUtils.startActivity(JumpActivity.this, intent2, RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT);
                    JumpUriUtils.grantShareUriPermissions(this.f196427e, JumpActivity.this);
                    JumpActivity.this.finish();
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }.run();
    }

    public static String x(Context context) {
        return f196425a.l(context);
    }

    public static void y(String str, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("JumpActivityHelper", 2, "initJASwitch with " + str + " inited=" + JumpActivity.sSwitchInited);
        }
        if (JumpActivity.sSwitchInited) {
            return;
        }
        try {
            JumpActivity.sJASwitches = (int) Long.parseLong(str, 16);
            if (z16) {
                QMMKVMigrateHelper.getMMKVMigratedSharePreferencesSync(BaseApplication.getContext(), "Jump_Action", 0).edit().putString("JASwitch", str).commit();
            }
        } catch (NumberFormatException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("JumpActivityHelper", 2, "initJASwitch error", e16);
            }
        }
        JumpActivity.sSwitchInited = true;
    }

    private static void z(JumpActivity jumpActivity, Intent intent) {
        f196425a.b(jumpActivity, intent);
    }
}
