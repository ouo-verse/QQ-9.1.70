package com.tencent.qzonehub.api;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import cooperation.qzone.QZoneShareData;
import java.io.File;
import java.util.ArrayList;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQzoneShareApi extends QRouteApi {
    public static final IPatchRedirector $redirector_ = null;
    public static final String BROADCAST_SHARE_UPDATE = "com.tencent.qq.shareupdate";
    public static final int MINIPROGRAMTHUMSIZE = 400;
    public static final String PHOTO_PATH;
    public static final String QZONE_WEIXINDOWNLOAD = "https://app.qq.com/#id=detail&appid=100733732";
    public static final String TAG = "WXShareFromQzone";
    public static final int TYPE_ON_GET_OPENID = 1;
    public static final String WX_APPID = "wx34b037fdb0f655ee";
    public static final String WX_DEBUG_APPID = "wxf22d22dbcb68a585";
    public static final String WX_DEBUG_APPID_EXPERIMENTAL = "wxc577faa50460d9e5";
    public static final String WX_RELEASE_APPID = "wx34b037fdb0f655ee";

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface WXShareListener {
        void onWXShareResp(BaseResp baseResp);
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(23739), (Class<?>) IQzoneShareApi.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
            return;
        }
        PHOTO_PATH = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "photo/");
    }

    void addObserver(WXShareListener wXShareListener);

    String buildTransaction(String str);

    boolean checkAndroidNotBelowN();

    boolean checkVersionValid(Context context);

    void dontShowContact();

    void handleWXEntryActivityIntent(Activity activity, Intent intent);

    boolean isWXinstalled();

    @Deprecated
    boolean isWXsupportApi();

    boolean isWxSupportMiniProgramm();

    boolean isWxSupportTimeLine();

    void jmpWeixinDetail(Activity activity);

    @Deprecated
    boolean jumpToQzoneShare(AppInterface appInterface, Context context, Bundle bundle, DialogInterface.OnDismissListener onDismissListener);

    @Deprecated
    boolean jumpToQzoneShare(AppInterface appInterface, Context context, Bundle bundle, DialogInterface.OnDismissListener onDismissListener, int i3);

    @Deprecated
    boolean jumpToQzoneShare(String str, Context context, Bundle bundle, DialogInterface.OnDismissListener onDismissListener, int i3);

    void onReq(BaseReq baseReq);

    void onResp(BaseResp baseResp);

    void publishToQzone(AppInterface appInterface, Context context, Bundle bundle, DialogInterface.OnDismissListener onDismissListener);

    void publishToQzone(AppInterface appInterface, Context context, Bundle bundle, DialogInterface.OnDismissListener onDismissListener, int i3);

    void publishToQzoneFromMiniApp(Context context, Bundle bundle, DialogInterface.OnDismissListener onDismissListener, int i3);

    void registerApp();

    void removeObserver(WXShareListener wXShareListener);

    void shareImage(Context context, String str, byte[] bArr, int i3);

    void shareMiniProgram(String str, Bitmap bitmap, String str2, String str3, String str4, String str5, String str6, int i3);

    void shareMutilPicToWehat(Context context, ArrayList<File> arrayList);

    void shareQzoneForMini(Activity activity, String str, String str2, String str3, int i3, int i16, int i17, String str4, String str5, String str6, int i18, String str7, boolean z16, int i19);

    void shareText(String str, int i3);

    void shareToQzone(Context context, String str, QZoneShareData qZoneShareData, DialogInterface.OnDismissListener onDismissListener, int i3);

    void shareToQzoneFromAskAnonymously(Context context, String str, QZoneShareData qZoneShareData, int i3);

    void shareWebPage(String str, Bitmap bitmap, String str2, String str3, int i3);

    void startShareServlet(Context context, String str, long j3, QZoneShareData qZoneShareData);
}
