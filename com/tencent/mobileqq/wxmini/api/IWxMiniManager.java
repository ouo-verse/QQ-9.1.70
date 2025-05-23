package com.tencent.mobileqq.wxmini.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.wxmini.api.data.b;
import com.tencent.mobileqq.wxmini.api.data.c;
import com.tencent.mobileqq.wxmini.api.data.d;
import com.tencent.mobileqq.wxmini.api.data.e;
import db3.a;
import java.util.HashMap;
import mqq.app.Constants;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IWxMiniManager extends QRouteApi {
    public static final int CODE_TYPE_QRCODE = 19;
    public static final int CODE_TYPE_WXCODE = 22;
    public static final String KEY_ERROR_CODE = "errCode";

    void attachBaseContext(Context context);

    boolean checkDynamicPackage();

    void checkWxAuthed(b bVar);

    void clearWxMiniAppCache();

    d getBindingWeChatUserInfo();

    d getBindingWeChatUserInfoWithAccount(String str);

    String getSDKVersion();

    int getVersionTypeFromScheme(String str);

    Class<?> getWXMiniEntryClass();

    Class<?> getWxBindJumpClass();

    void handleWXEntryActivityIntent(Activity activity, Intent intent);

    boolean hasRecentShowWxMiniTipInfo();

    void initApi();

    boolean isWxCodeType(String str);

    boolean isWxMiniApp(String str);

    void loadDynamicPackage(b bVar);

    void login(String str, b bVar);

    void onLogout(int i3);

    void onLogout(Constants.LogoutReason logoutReason);

    void onLogout(Constants.LogoutReason logoutReason, int i3);

    void openWxBindingPage();

    void preCheckWxaPackages(b bVar);

    void preloadProcessEnv(boolean z16);

    void requestPayment(String str, long j3, String str2, String str3, String str4, String str5, b bVar);

    void requestWxMiniAppInfo(int i3, String str, int i16, a aVar);

    int resetQQMiniAppVtToWxMiniAppVt(int i3);

    void restartRecentShowWxMiniTipInfo();

    void sendWxAccountUnBindRequest(c cVar);

    void sendWxAuthEvent(Context context, int i3);

    void setIsDebugIP(boolean z16);

    void startWxMiniApp(Context context, e eVar, int i3);

    void startWxMiniAppByAppId(Context context, String str, String str2, int i3);

    void startWxMiniAppByAppId(Context context, String str, String str2, int i3, int i16);

    void startWxMiniAppByAppId(Context context, String str, String str2, int i3, int i16, Uri uri);

    void startWxMiniAppByAppId(Context context, String str, String str2, int i3, int i16, Uri uri, HashMap<String, Object> hashMap);

    void startWxMiniAppByAppIdWithCallback(Context context, String str, String str2, int i3, b bVar);

    void startWxMiniAppByQQCode(Context context, String str, int i3);

    void startWxMiniAppByQQUrl(Context context, String str, int i3);

    void startWxMiniAppByUsername(Context context, String str, String str2, int i3);

    void startWxMiniAppByUsername(Context context, String str, String str2, int i3, HashMap<String, Object> hashMap);

    void startWxMiniAppByUsernameWithCallback(String str, String str2, int i3, b bVar);

    void startWxMiniAppByUsernameWithCallback(String str, String str2, int i3, HashMap<String, Object> hashMap, b bVar);

    void startWxMiniAppByWxCode(Context context, String str, int i3);

    void startWxMiniAppByWxRawData(Context context, String str, int i3);

    void unzipDynamicPackage(b bVar);

    void updateTuringAIDTicket(String str);

    void uploadLogFiles(int i3, int i16, db3.b bVar);
}
