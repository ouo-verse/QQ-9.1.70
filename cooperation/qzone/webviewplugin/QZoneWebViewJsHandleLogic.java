package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.widget.RelativeLayout;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.qrcode.util.h;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.module.QQBridgeModule;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.servlet.GetGuildJoinUrlServlet;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.af;
import com.tencent.mobileqq.webview.swift.y;
import com.tencent.mobileqq.webviewplugin.n;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.downloadnew.e;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneShareApi;
import com.tencent.qzonehub.api.impl.QZoneHelperProxyImpl;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QzoneAuthorizeConfig;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import s4.c;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QZoneWebViewJsHandleLogic {
    public static final String ACTION_PICK_GAME_MATES = "qzone.pickgamemates";
    private static final String JS_CALL_CARE_SPECIAL_FAMOUS_SPACE_METHOD = "UpdateFamousSpaceVpageOptions";
    public static final String STR_GAMEMATES = "gamemates";
    public static final String TAG = "QZoneWebViewJsHandleLogic";
    static String mShareMsgCallback;
    static CustomWebView webview;
    static IQzoneShareApi.WXShareListener wxShareListener = new IQzoneShareApi.WXShareListener() { // from class: cooperation.qzone.webviewplugin.QZoneWebViewJsHandleLogic.1
        @Override // com.tencent.qzonehub.api.IQzoneShareApi.WXShareListener
        public void onWXShareResp(BaseResp baseResp) {
            CustomWebView customWebView;
            if (!TextUtils.isEmpty(QZoneWebViewJsHandleLogic.mShareMsgCallback) && (customWebView = QZoneWebViewJsHandleLogic.webview) != null) {
                customWebView.callJs(QZoneWebViewJsHandleLogic.mShareMsgCallback, String.valueOf(baseResp.errCode));
            } else {
                int i3 = baseResp.errCode;
                if (i3 != -2) {
                    if (i3 != 0) {
                        h.T(1, R.string.hit);
                    } else {
                        h.T(2, R.string.hj9);
                    }
                }
            }
            QZoneWebViewJsHandleLogic.mShareMsgCallback = null;
            QZoneWebViewJsHandleLogic.webview = null;
            ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).removeObserver(this);
        }
    };

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0041, code lost:
    
        r0 = r0.length() + r1;
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
    
        if (r3 >= r7.length()) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004d, code lost:
    
        r5 = r7.charAt(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0051, code lost:
    
        if (r5 == '&') goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0053, code lost:
    
        if (r5 != '#') goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:
    
        if (r8.equals("_wv") == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:
    
        if (r1 <= r7.indexOf(35)) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
    
        return android.net.Uri.parse(r7).buildUpon().appendQueryParameter(r8, r9).toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
    
        return r7.substring(0, r0) + r9 + r7.substring(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String appendQueryParameter(String str, String str2, String str3) {
        char charAt;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String str4 = str2 + '=';
        int indexOf = str.indexOf(str4);
        while (indexOf != -1 && (indexOf == 0 || ((charAt = str.charAt(indexOf - 1)) != '?' && charAt != '#' && charAt != '&'))) {
            indexOf = str.indexOf(str4, indexOf + str4.length());
        }
        return Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).toString();
    }

    public static String appendWVParameter(String str, int i3, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            String queryParameter = Uri.parse(str).getQueryParameter("_wv");
            if (queryParameter == null) {
                return appendQueryParameter(str, "_wv", String.valueOf(i3));
            }
            return z16 ? appendQueryParameter(str, "_wv", String.valueOf(i3 | Integer.valueOf(queryParameter).intValue())) : str;
        } catch (Exception unused) {
            return str;
        }
    }

    private static boolean checkScheme(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String scheme = Uri.parse(str).getScheme();
        return "mqzone".equals(scheme) || "mqzonev2".equals(scheme);
    }

    public static boolean disPatchMethod(WebViewPlugin webViewPlugin, WebViewPlugin.b bVar, String str, String... strArr) {
        if (QZoneJsConstants.METHOD_UPDATE_FEEDCONTAINER.equalsIgnoreCase(str)) {
            updateFeedContainer(bVar, strArr);
            return true;
        }
        if (QZoneJsConstants.SEND_GIFT_FINISHED.equalsIgnoreCase(str)) {
            handleSendGift(bVar, strArr);
            return true;
        }
        if (QZoneJsConstants.SEND_GIFT_SUCCESS.equalsIgnoreCase(str)) {
            handleSendGiftSuccess(bVar, strArr);
            return true;
        }
        if (QZoneJsConstants.METHOD_OPEN_APP_DETAIL.equalsIgnoreCase(str)) {
            handleOpenAppDetail(bVar, strArr);
            return true;
        }
        if ("Schema".equalsIgnoreCase(str)) {
            handleSchema(webViewPlugin, bVar, strArr);
            return true;
        }
        if (QZoneJsConstants.METHOD_REFRESH_FEEDS.equals(str)) {
            if (bVar.a() != null) {
                if (VasNormalToggle.VAS_QZONE_BACKGROUND_REFRESH_SWITCH_2.isEnable(true)) {
                    Intent intent = new Intent();
                    QzonePluginProxyActivity.setActivityNameToIntent(intent, "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
                    intent.putExtra("open_what", 6);
                    intent.putExtra("cover", strArr[0]);
                    if (bVar.b() != null) {
                        QzonePluginProxyActivity.launchPluingActivityForResult(bVar.a(), bVar.b().getAccount(), intent, 22);
                    }
                } else {
                    doRefreshFeed(bVar.a());
                }
            }
            return true;
        }
        if (JS_CALL_CARE_SPECIAL_FAMOUS_SPACE_METHOD.equalsIgnoreCase(str)) {
            handleCareSpecialFamousSpace(bVar, strArr[0]);
            return true;
        }
        if (QZoneJsConstants.METHOD_CLICK_WEISHI_WIDGET.equalsIgnoreCase(str)) {
            handleClickWeiShiWidget(bVar, strArr);
            return true;
        }
        if (QZoneJsConstants.METHOD_SHOW_FOLLOW_ACTION_SHEET.equalsIgnoreCase(str)) {
            handleShowFollowActionSheet(bVar, strArr);
            return true;
        }
        if (QZoneJsConstants.METHOD_UPDATE_NATIVE_IS_SPECIAL_FOLLOW.equalsIgnoreCase(str)) {
            handleUpdateIsSpecialFollow(bVar, strArr);
            return true;
        }
        if (QZoneJsConstants.METHOD_SHARE_MINIPROGRAM.equals(str)) {
            shareMiniProgramFromQzone(bVar, strArr);
            return true;
        }
        if (!QZoneJsConstants.METHOD_PICK_GAME_MATES.equals(str)) {
            return false;
        }
        handleGameMates(bVar, strArr);
        return true;
    }

    public static void doRefreshFeed(Activity activity) {
        Intent intent = new Intent();
        intent.setAction("SignInSbumited");
        if (activity != null) {
            activity.sendBroadcast(intent);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void handleCareSpecialFamousSpace(WebViewPlugin.b bVar, String str) {
        int i3;
        Activity a16;
        JSONObject jSONObject;
        if (bVar == null) {
            return;
        }
        String str2 = "0";
        int i16 = -1;
        try {
            jSONObject = new JSONObject(str);
            i3 = jSONObject.optInt(QZoneHelper.KEY_FAMOUS_SPACE_CONCERN);
        } catch (JSONException e16) {
            e = e16;
            i3 = -1;
        }
        try {
            str2 = jSONObject.optString("uin");
            i16 = jSONObject.optInt(QZoneHelper.KEY_NOT_SHOW_SPECIAL_TOAST);
        } catch (JSONException e17) {
            e = e17;
            e.printStackTrace();
            Intent intent = new Intent();
            intent.setAction(QZoneHelper.FAMOUS_SPACE_JS_CALL_NATIVE_ACTION);
            intent.putExtra(QZoneHelper.KEY_FAMOUS_SPACE_CONCERN, i3);
            intent.putExtra("uin", Long.parseLong(str2));
            intent.putExtra("key_jump_from", QZoneHelper.KEY_FROM_H5_COVER_USER_HOME);
            intent.putExtra(QZoneHelper.KEY_NOT_SHOW_SPECIAL_TOAST, i16);
            a16 = bVar.a();
            if (a16 == null) {
            }
        }
        Intent intent2 = new Intent();
        intent2.setAction(QZoneHelper.FAMOUS_SPACE_JS_CALL_NATIVE_ACTION);
        intent2.putExtra(QZoneHelper.KEY_FAMOUS_SPACE_CONCERN, i3);
        intent2.putExtra("uin", Long.parseLong(str2));
        intent2.putExtra("key_jump_from", QZoneHelper.KEY_FROM_H5_COVER_USER_HOME);
        intent2.putExtra(QZoneHelper.KEY_NOT_SHOW_SPECIAL_TOAST, i16);
        a16 = bVar.a();
        if (a16 == null) {
            a16.sendBroadcast(intent2);
        }
    }

    private static void handleClickWeiShiWidget(WebViewPlugin.b bVar, String... strArr) {
        if (bVar == null || bVar.a() == null || strArr == null || strArr.length <= 0) {
            return;
        }
        Activity a16 = bVar.a();
        if (PackageUtil.isAppInstalled(a16, QQBridgeModule.WEISHI_PAKG_NAME)) {
            String str = "";
            try {
                str = new JSONObject(strArr[0]).optString(QZoneDTLoginReporter.SCHEMA);
                if (!TextUtils.isEmpty(str)) {
                    Intent intent = new Intent();
                    intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
                    intent.setData(Uri.parse(str));
                    QZoneHelper.addSource(intent);
                    List<ResolveInfo> queryIntentActivities = InstalledAppListMonitor.queryIntentActivities(a16.getPackageManager(), intent, 65536);
                    if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                        a16.startActivity(intent);
                    } else {
                        goToDownloadWeiShiApp(a16);
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 1, "weishi schema is " + str);
                    return;
                }
                return;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "handleClickWeiShiWidget catch an exception. weishi schema is " + str, e16);
                return;
            }
        }
        goToDownloadWeiShiApp(a16);
    }

    private static void handleOpenAppDetail(WebViewPlugin.b bVar, String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            String string = jSONObject.getString("packName");
            String string2 = jSONObject.getString("taskAppId");
            String string3 = jSONObject.getString("appId");
            String string4 = jSONObject.getString("taskApkId");
            String string5 = jSONObject.getString("via");
            String string6 = jSONObject.getString("versionCode");
            String string7 = jSONObject.getString(WadlProxyConsts.CHANNEL);
            String string8 = jSONObject.getString("from");
            int i3 = 3;
            try {
                if (!TextUtils.isEmpty(string8)) {
                    i3 = Integer.parseInt(string8);
                }
            } catch (NumberFormatException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "from \u9519\u8bef", e16);
                }
            }
            StringBuilder sb5 = new StringBuilder();
            if (!TextUtils.isEmpty(string3)) {
                sb5.append(e.f341493b);
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(string3);
            }
            if (!TextUtils.isEmpty(string)) {
                sb5.append(ContainerUtils.FIELD_DELIMITER);
                sb5.append(e.f341497f);
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(string);
            }
            if (!TextUtils.isEmpty(string2)) {
                sb5.append(ContainerUtils.FIELD_DELIMITER);
                sb5.append(e.f341494c);
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(string2);
            }
            if (!TextUtils.isEmpty(string4)) {
                sb5.append(ContainerUtils.FIELD_DELIMITER);
                sb5.append(e.f341495d);
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(string4);
            }
            if (!TextUtils.isEmpty(string5)) {
                sb5.append(ContainerUtils.FIELD_DELIMITER);
                sb5.append(e.f341500i);
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(string5);
            }
            if (!TextUtils.isEmpty(string6)) {
                sb5.append(ContainerUtils.FIELD_DELIMITER);
                sb5.append(e.f341496e);
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(string6);
            }
            if (!TextUtils.isEmpty(string7)) {
                sb5.append(ContainerUtils.FIELD_DELIMITER);
                sb5.append(e.D);
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(string7);
            }
            String sb6 = sb5.toString();
            Bundle bundle = new Bundle();
            bundle.putInt("from", i3);
            bundle.putString("schemaUrl", sb6);
            QZoneHelper.addSource(bundle);
            AppClient.g(bVar.a(), bundle);
        } catch (JSONException e17) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "json \u89e3\u6790\u5f02\u5e38", e17);
            }
        }
    }

    private static void handleSendGift(WebViewPlugin.b bVar, String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            if (jSONObject.getInt("success") == 1) {
                JSONArray jSONArray = jSONObject.getJSONArray("uins");
                JSONArray jSONArray2 = jSONObject.getJSONArray("birthdays");
                String string = jSONObject.getString("giftmessage");
                int optInt = jSONObject.optInt("giftid");
                if (jSONArray == null || jSONArray.length() <= 0 || jSONArray2 == null || jSONArray2.length() != jSONArray.length()) {
                    return;
                }
                if (jSONObject.has("toast") && jSONObject.getBoolean("toast")) {
                    QQToast.makeText(bVar.a(), 2, R.string.f170004cn, 0).show();
                }
                long[] jArr = new long[jSONArray.length()];
                long[] jArr2 = new long[jSONArray2.length()];
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    jArr[i3] = jSONArray.getLong(i3);
                    jArr2[i3] = jSONArray2.getLong(i3);
                }
                Intent intent = new Intent();
                intent.putExtra("key_msg_type", 2);
                intent.putExtra("key_friend_list", jArr);
                intent.putExtra("key_time_list", jArr2);
                intent.putExtra("key_msg_content", string);
                intent.putExtra("key_gift_id", optInt);
                bVar.a().setResult(-1, intent);
                bVar.a().finish();
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "the giftid is " + optInt + "\n the giftmessage is" + string + "\n the uins are: " + jSONArray.toString() + "\n the birthdays are: " + jSONArray2.toString());
                }
            }
        } catch (JSONException e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    private static void handleShowFollowActionSheet(WebViewPlugin.b bVar, String... strArr) {
        if (bVar == null || bVar.a() == null || strArr == null || strArr.length <= 0) {
            return;
        }
        try {
            int optInt = new JSONObject(strArr[0]).optInt("followStatus");
            Intent intent = new Intent(QZoneHelper.ACTION_SHOW_FOLLOW_ACTION_SHEET);
            intent.putExtra("followStatus", optInt);
            BaseApplicationImpl.getApplication().sendBroadcast(intent);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "followStatus = " + optInt);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "handleShowFollowActionSheet catch an exception. ", e16);
        }
    }

    private static void handleUpdateIsSpecialFollow(WebViewPlugin.b bVar, String... strArr) {
        if (bVar == null || bVar.a() == null || strArr == null || strArr.length <= 0) {
            return;
        }
        try {
            int optInt = new JSONObject(strArr[0]).optInt("isSpecialFollow", -1);
            Intent intent = new Intent(QZoneHelper.ACTION_UPDATE_IS_SPEICAL_FOLLOW);
            intent.putExtra("isSpecialFollow", optInt);
            BaseApplicationImpl.getApplication().sendBroadcast(intent);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "followStatus = " + optInt);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "handleUpdateIsSpecialFollow catch an exception. ", e16);
        }
    }

    static void handleUrl(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("handleUrl", 2, "browse url fail:" + str);
                return;
            }
            return;
        }
        String appendWVParameter = appendWVParameter(str, 7, false);
        Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) QQBrowserDelegationActivity.class);
        intent.putExtra("url", appendWVParameter);
        intent.putExtra("fromQZone", true);
        intent.putExtra("injectrecommend", true);
        intent.setData(Uri.parse(appendWVParameter));
        intent.addFlags(268435456);
        intent.putExtra("source_name", BaseApplication.getContext().getString(R.string.ghh));
        context.startActivity(intent);
        if (QLog.isColorLevel()) {
            QLog.d("handleurl", 2, "jump to browser: " + appendWVParameter);
        }
    }

    static void simpleSchemeJump(Context context, Uri uri) {
        Intent intent = new Intent();
        intent.setData(uri);
        intent.setPackage("com.qzone");
        context.startActivity(intent);
    }

    public static void showQzoneAppDownloadDialog(final Context context, WebViewPlugin.b bVar) {
        final QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 0);
        createCustomDialog.setMessage(context.getString(R.string.i1e));
        createCustomDialog.setPositiveButton(context.getString(R.string.f170862av0), new DialogInterface.OnClickListener() { // from class: cooperation.qzone.webviewplugin.QZoneWebViewJsHandleLogic.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                try {
                    if (QUA.getQUA3().indexOf("GM") < 0) {
                        QZoneWebViewJsHandleLogic.handleUrl(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_DOWNLOAD_QZONE_CLIENT, QZoneJsConstants.URL_STANDALONE_QZONE_DOWNLOAD), context);
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("showQzoneAppDownloadDialog", 2, "simpleBrowserJump exception", e16);
                    }
                }
            }
        });
        createCustomDialog.setNegativeButton(context.getString(R.string.bsc), new DialogInterface.OnClickListener() { // from class: cooperation.qzone.webviewplugin.QZoneWebViewJsHandleLogic.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                if (QQCustomDialog.this.isShowing()) {
                    QQCustomDialog.this.dismiss();
                }
            }
        });
        try {
            if (createCustomDialog.isShowing()) {
                return;
            }
            createCustomDialog.show();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("showQzoneAppDownloadDialog", 2, "mDialog.show() exception", e16);
            }
        }
    }

    public static boolean supportJumpToQzone(Context context, int i3) {
        PackageInfo packageInfo;
        try {
            packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), "com.qzone", 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null && packageInfo.versionCode >= i3;
    }

    private static void goToDownloadWeiShiApp(Context context) {
        if (context != null) {
            String config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.KEY_MARTET_TO_DOWNLOAD_WEISHI, QzoneConfig.DEFAULT_KEY_MARTET_TO_DOWNLOAD_WEISHI);
            if (TextUtils.isEmpty(config)) {
                return;
            }
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
            intent.setData(Uri.parse(config));
            QZoneHelper.addSource(intent);
            try {
                context.startActivity(intent);
            } catch (Exception unused) {
                String config2 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.KEY_WEB_TO_DOWNLOAD_WEISHI, QzoneConfig.DEFAULT_KEY_WEB_TO_DOWNLOAD_WEISHI);
                if (TextUtils.isEmpty(config2)) {
                    return;
                }
                intent.setData(Uri.parse(config2));
                try {
                    context.startActivity(intent);
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "goToDownloadWeishi catch an exception.", e16);
                }
            }
        }
    }

    private static void handleGameMates(WebViewPlugin.b bVar, String... strArr) {
        if (bVar == null || bVar.a() == null || strArr == null || strArr.length <= 0) {
            return;
        }
        Intent intent = new Intent("qzone.pickgamemates");
        intent.putExtra("gamemates", strArr[0]);
        BaseApplicationImpl.getApplication().sendBroadcast(intent);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "handleGameMates = " + strArr[0]);
        }
    }

    private static void handleSendGiftSuccess(WebViewPlugin.b bVar, String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        try {
            LocalMultiProcConfig.putString("BirthdayGiftSendSuccessList", new JSONObject(strArr[0]).optString("uins"));
        } catch (JSONException e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    static void shareMiniProgramFromQzone(final WebViewPlugin.b bVar, String... strArr) {
        QQProgressDialog sharePD;
        if (bVar == null || bVar.a() == null || strArr == null || strArr.length <= 0) {
            return;
        }
        try {
            y d16 = bVar.d(bVar.a());
            if (d16 != null && (d16 instanceof n) && (sharePD = ((Share) ((n) d16).getShare()).getSharePD()) != null && sharePD.isShowing()) {
                sharePD.dismiss();
            }
            webview = bVar.e();
            JSONObject jSONObject = new JSONObject(strArr[0]);
            mShareMsgCallback = jSONObject.optString("callback");
            final String optString = jSONObject.optString("webpageUrl");
            jSONObject.optInt("miniprogramType");
            final String optString2 = jSONObject.optString("userName");
            final String optString3 = jSONObject.optString("path");
            final String optString4 = jSONObject.optString("title");
            final String optString5 = jSONObject.optString("description");
            final String optString6 = jSONObject.optString("picUrl");
            final HashMap hashMap = new HashMap(1);
            final Runnable runnable = new Runnable() { // from class: cooperation.qzone.webviewplugin.QZoneWebViewJsHandleLogic.2
                @Override // java.lang.Runnable
                public void run() {
                    Activity a16 = WebViewPlugin.b.this.a();
                    if (a16 == null || a16.isFinishing()) {
                        return;
                    }
                    Bitmap bitmap = (Bitmap) hashMap.remove("image");
                    ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).addObserver(QZoneWebViewJsHandleLogic.wxShareListener);
                    ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).shareMiniProgram(optString4, bitmap, optString5, optString, optString3, optString2, null, 0);
                }
            };
            if (TextUtils.isEmpty(optString6)) {
                runnable.run();
            } else {
                ThreadManagerV2.post(new Runnable() { // from class: cooperation.qzone.webviewplugin.QZoneWebViewJsHandleLogic.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap decodeByteArray;
                        try {
                            byte[] openUrlForByte = HttpUtil.openUrlForByte(BaseApplication.getContext(), optString6, "GET", null, null);
                            if (openUrlForByte != null && (decodeByteArray = BitmapFactory.decodeByteArray(openUrlForByte, 0, openUrlForByte.length)) != null) {
                                hashMap.put("image", decodeByteArray);
                            }
                        } catch (IOException e16) {
                            QZLog.e(QZoneWebViewJsHandleLogic.TAG, "download pic error", e16);
                        } catch (OutOfMemoryError e17) {
                            QZLog.e(QZoneWebViewJsHandleLogic.TAG, "download pic error", e17);
                        }
                        bVar.b().runOnUiThread(runnable);
                    }
                }, 8, null, false);
            }
        } catch (Exception e16) {
            QZLog.e(TAG, "shareMiniProgramFromQzone error", e16);
        }
    }

    private static void updateFeedContainer(WebViewPlugin.b bVar, String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        try {
            if (new JSONObject(strArr[0]).getInt("height") <= 0) {
                if (bVar.e().getParent() instanceof RelativeLayout) {
                    ((RelativeLayout) bVar.e().getParent()).setVisibility(8);
                }
            } else if (bVar.e().getParent() instanceof RelativeLayout) {
                ((RelativeLayout) bVar.e().getParent()).setVisibility(0);
            }
        } catch (JSONException e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    private static int jumpQzoneScheme(Context context, String str, int i3, WebViewPlugin.b bVar) {
        if (context == null) {
            return 5;
        }
        if (checkScheme(str)) {
            if (supportJumpToQzone(context, i3)) {
                if (QLog.isColorLevel()) {
                    QLog.d("QZoneWebViewPlugin", 2, "simpleSchemeJump");
                }
                simpleSchemeJump(context, Uri.parse(str));
                return 1;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QZoneWebViewPlugin", 2, "showQzoneAppDownloadDialog");
            }
            showQzoneAppDownloadDialog(context, bVar);
            return 2;
        }
        if (!URLUtil.isNetworkUrl(str) || !QLog.isColorLevel()) {
            return 5;
        }
        QLog.d("QZoneWebViewPlugin", 2, "isNetworkUrl do nothing");
        return 5;
    }

    private static void handleSchema(WebViewPlugin webViewPlugin, WebViewPlugin.b bVar, String... strArr) {
        if (strArr == null || bVar == null || strArr.length <= 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            String optString = jSONObject.optString(QZoneDTLoginReporter.SCHEMA);
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            if (!QzoneAuthorizeConfig.getInstance().hasJsApiRight(bVar.e().getUrl(), optString)) {
                QLog.e(TAG, 1, "has no right handle this jsapi");
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("dealparam");
            if (optJSONObject != null) {
                String optString2 = optJSONObject.optString("url");
                optJSONObject.optString("blogurl", "");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    optString = optString + "&url=" + optString2;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("QZoneWebViewPlugin", 2, " handleSchema scheme:" + optString);
            }
            Activity a16 = bVar.a();
            if (a16 != null && (a16 instanceof BasePluginActivity)) {
                a16 = ((BasePluginActivity) a16).getOutActivity();
            }
            if (a16 != null && (a16 instanceof BasePluginActivity)) {
                a16 = ((BasePluginActivity) a16).getOutActivity();
            }
            if (optString.startsWith(QZoneJsConstants.SCHEME_PREFIX_USER_HOME)) {
                if (a16 != null) {
                    try {
                        if (optString.indexOf("uin=") != -1) {
                            QZoneHelper.forwardToUserHome(a16, QZoneHelper.UserInfo.getInstance(), optString.substring(optString.indexOf("uin=") + 4, optString.length()), 0, 0, 0);
                            return;
                        }
                        return;
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        return;
                    }
                }
                return;
            }
            try {
                if (!optString.startsWith(QZoneJsConstants.SCHEME_FEED_DETAIL)) {
                    if (QZoneJsConstants.SCHEMA_DYNAMICNICKNAME.equalsIgnoreCase(optString)) {
                        if (bVar.a() == null || bVar.b() == null) {
                            return;
                        }
                        QZoneHelper.forwardToQZoneFlashNickNameSetting(bVar.a(), bVar.b().getAccount());
                        return;
                    }
                    if (optString.startsWith(QZoneJsConstants.SCHEME_PREFIX_UPLOAD_PHOTO)) {
                        QZoneHelperProxyImpl.forwardToUploadPhoto(webViewPlugin, bVar, bVar.a(), bVar.b().getAccount(), optString);
                        return;
                    }
                    if (!optString.startsWith(QZoneJsConstants.SCHEME_PREFIX_FACADE) && !optString.startsWith(QZoneJsConstants.SCHEME_PREFIX_FACADE_V2)) {
                        Intent intent = new Intent(QZoneJsConstants.QZonePersonalizeJsConstants.ACTION_WEB_JS_TO_QZONE);
                        Bundle bundle = new Bundle();
                        bundle.putString("cmd", "Schema");
                        bundle.putString(QZoneDTLoginReporter.SCHEMA, optString);
                        boolean z16 = jSONObject.optInt("showQzoneProgressDialog", 1) != 0;
                        intent.putExtras(bundle);
                        if (QLog.isColorLevel()) {
                            QLog.d("QZoneWebViewPlugin", 2, "handleSchema actionString: " + intent.getAction() + "scheme:" + optString);
                        }
                        if (optString.startsWith(QZoneJsConstants.SCHEME_OPEN_VIDEOLAYER)) {
                            QZoneHelper.forwardToQzoneTransluentActivity(a16, QZoneHelper.UserInfo.getInstance(), intent, QZoneWebViewPlugin.generateRequestCode(webViewPlugin, bVar, 4), z16);
                            return;
                        } else {
                            QZoneHelper.forwardToQzoneTransluentActivity(a16, QZoneHelper.UserInfo.getInstance(), intent, -1, z16);
                            return;
                        }
                    }
                    jumpQzoneScheme(bVar.a(), optString, 81, bVar);
                    return;
                }
                if (a16 != null) {
                    Uri parse = Uri.parse(optString);
                    String queryParameter = parse.getQueryParameter("uin");
                    String queryParameter2 = parse.getQueryParameter("appid");
                    String queryParameter3 = parse.getQueryParameter(c.CELLID);
                    String queryParameter4 = parse.getQueryParameter("subid");
                    String queryParameter5 = parse.getQueryParameter("source");
                    String queryParameter6 = parse.getQueryParameter("cookie");
                    String queryParameter7 = parse.getQueryParameter("local_city_feedindex");
                    String queryParameter8 = parse.getQueryParameter(c.UGCKEY);
                    String queryParameter9 = parse.getQueryParameter("feedData");
                    String queryParameter10 = parse.getQueryParameter("needShowBottom");
                    String queryParameter11 = parse.getQueryParameter("urlForTodayInHistory");
                    String queryParameter12 = parse.getQueryParameter("buttonText");
                    Bundle bundle2 = new Bundle();
                    if (queryParameter5 != null) {
                        bundle2.putString("source", queryParameter5);
                    }
                    if (queryParameter6 != null) {
                        bundle2.putString("cookie", queryParameter6);
                    }
                    if (queryParameter7 != null) {
                        bundle2.putString("local_city_feedindex", queryParameter7);
                    }
                    if (queryParameter8 != null) {
                        bundle2.putString(c.UGCKEY, queryParameter8);
                    }
                    if (queryParameter9 != null) {
                        bundle2.putString("local_city_feedData", queryParameter9);
                    }
                    if (queryParameter10 != null) {
                        bundle2.putString("show_share_btn", queryParameter10);
                    }
                    if (queryParameter11 != null) {
                        bundle2.putString(GetGuildJoinUrlServlet.BUNDLE_KEY_URL, queryParameter11);
                    }
                    if (queryParameter12 != null) {
                        bundle2.putString("share_btn_text", queryParameter12);
                    }
                    y d16 = bVar.d(a16);
                    if (d16 instanceof af) {
                        ((af) d16).switchRequestCode(webViewPlugin, (byte) 3);
                    }
                    QZoneHelper.UserInfo.getInstance().qzone_uin = bVar.b().getAccount();
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("source", parse.getQueryParameter("source"));
                    bundle3.putString("bypassparam", parse.getQueryParameter("bypassparam"));
                    bundle3.putAll(bundle2);
                    QZoneHelper.forwardToDetail(a16, queryParameter, queryParameter2, queryParameter3, queryParameter4, bundle3);
                }
            } catch (JSONException e17) {
                e = e17;
                e.printStackTrace();
                QLog.e(TAG, 1, "handleSchema", e);
            }
        } catch (JSONException e18) {
            e = e18;
        }
    }
}
