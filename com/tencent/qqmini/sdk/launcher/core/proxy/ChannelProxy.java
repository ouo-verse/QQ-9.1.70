package com.tencent.qqmini.sdk.launcher.core.proxy;

import NS_COMM.COMM;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StInteractiveTemplate;
import NS_MINI_INTERFACE.INTERFACE$StUserSettingInfo;
import NS_MINI_SHARE.MiniProgramShare$StAdaptShareInfoReq;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.MovementMethod;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.auth.UserAuthInfo;
import com.tencent.qqmini.sdk.launcher.core.auth.UserSettingInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.PluginInfo;
import com.tencent.qqmini.sdk.launcher.model.RealTimeLogItem;
import com.tencent.qqmini.sdk.launcher.model.TouchInfo;
import cooperation.vip.pb.TianShuAccess;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public interface ChannelProxy {

    /* loaded from: classes23.dex */
    public interface AuthListResult {
        void onReceiveResult(boolean z16, List<UserAuthInfo> list, List<UserSettingInfo> list2);
    }

    /* loaded from: classes23.dex */
    public enum BeaconReportCategory {
        MINI_GAME,
        MINI_APP
    }

    /* loaded from: classes23.dex */
    public interface ICommandListenr {
        void onFailure(String str);

        void onFinish(boolean z16);

        void onProgress(String str);

        void onStart();

        void onSuccess(String str);
    }

    /* loaded from: classes23.dex */
    public interface SetCookieCallback {
        void onFinish();
    }

    /* loaded from: classes23.dex */
    public interface SoLoaderOption {
        void onBeforeLoadSo();
    }

    void addGroupApp(IMiniAppContext iMiniAppContext, AsyncResult asyncResult);

    void addPhoneNumber(String str, String str2, String str3, int i3, AsyncResult asyncResult);

    boolean addPublicAccount(String str, String str2, AsyncResult asyncResult);

    void batchGetContact(ArrayList<String> arrayList, AsyncResult asyncResult);

    void buildCookieForRedirect(String str);

    void checkBindingState(String str, String str2, int i3, AsyncResult asyncResult);

    void checkNavigateRight(String str, String str2, AsyncResult asyncResult);

    void checkOfferId(String str, String str2, AsyncResult asyncResult);

    void checkSession(String str, AsyncResult asyncResult);

    void checkWxPayUrl(String str, String str2, AsyncResult asyncResult);

    void clearMiniGameUserAgreementData(String str);

    void closeFloatBubble(String str, String str2, AsyncResult asyncResult);

    void dataReport(byte[] bArr, AsyncResult asyncResult);

    String decodeQR(byte[] bArr, int i3, int i16, int i17, int i18, int i19, int i26);

    void delPhoneNumber(String str, String str2, AsyncResult asyncResult);

    void doGameRaffle(String str, String str2, AsyncResult asyncResult);

    void downloadQQBrowser(String str);

    void ffmpegExecCommand(String[] strArr, ICommandListenr iCommandListenr);

    void getAppInfoById(String str, String str2, String str3, AsyncResult asyncResult);

    void getAppInfoById(String str, String str2, String str3, String str4, AsyncResult asyncResult);

    void getAppInfoByLink(String str, int i3, AsyncResult asyncResult);

    void getAuthList(String str, AuthListResult authListResult);

    void getAuthListForSubscribe(String str, AsyncResult asyncResult);

    JSONArray getChooseMessageTempFilesArray(Intent intent);

    void getContainerInfoById(String str, String str2, String str3, AsyncResult asyncResult);

    void getContentAccelerate(String str, String str2, int i3, Map<String, String> map, AsyncResult asyncResult);

    String getDeviceInfo();

    void getFloatBubble(String str, AsyncResult asyncResult);

    @Deprecated
    IFlutterProxy getFlutterProxy();

    void getFormId(String str, AsyncResult asyncResult);

    void getFriendCloudStorage(String str, String[] strArr, AsyncResult asyncResult);

    void getGameFloatEnableConfig(String str, AsyncResult asyncResult);

    void getGameLaunchConfig(String str, AsyncResult asyncResult);

    void getGameRaffleMaterial(String str, String str2, AsyncResult asyncResult);

    void getGameTaskTicket(String str, AsyncResult asyncResult);

    void getGdtAd(String str, int i3, String str2, String str3, String str4, HashMap<String, String> hashMap, AsyncResult asyncResult);

    void getGdtAdInfo(String str, int i3, String str2, AsyncResult asyncResult);

    Drawable getGifDrawable(String str);

    void getGroupAppStatus(IMiniAppContext iMiniAppContext, String str, AsyncResult asyncResult);

    void getGroupCloudStorage(String str, String str2, String[] strArr, AsyncResult asyncResult);

    void getGroupShareInfo(String str, String str2, AsyncResult asyncResult);

    void getLatestUserKey(String str, AsyncResult asyncResult);

    IMediaPlayer getMediaPlayer();

    IMediaPlayerUtil getMediaPlayerUtil();

    void getMidasConsumeResult(String str, String str2, int i3, int i16, int i17, int i18, int i19, String str3, String str4, AsyncResult asyncResult);

    MiniAIOEntranceProxy getMiniAIOEntranceView(Context context, String str);

    void getMiniAppStoreAppList(int i3, AsyncResult asyncResult);

    Object getMiniGameUserAgreementData(String str);

    void getNativeAppInfoForJump(String str, String str2, String str3, int i3, AsyncResult asyncResult);

    void getPhoneNumber(String str, AsyncResult asyncResult);

    void getPotentialFriendList(COMM.StCommonExt stCommonExt, String str, AsyncResult asyncResult);

    void getRobotUin(String str, AsyncResult asyncResult);

    int getRunTimeReportRate();

    void getSDKOpenKeyToken(COMM.StCommonExt stCommonExt, AsyncResult asyncResult);

    long getServerTime();

    void getShareInfo(MiniProgramShare$StAdaptShareInfoReq miniProgramShare$StAdaptShareInfoReq, AsyncResult asyncResult);

    void getTcbTicket(String str, String str2, AsyncResult asyncResult);

    SoLoaderOption getTissueSoLoaderOption();

    void getUserAppInfo(COMM.StCommonExt stCommonExt, ArrayList<String> arrayList, AsyncResult asyncResult);

    void getUserCloudStorage(String str, String[] strArr, AsyncResult asyncResult);

    void getUserGroupInfo(COMM.StCommonExt stCommonExt, String str, String str2, long j3, AsyncResult asyncResult);

    void getUserHealthData(String str, AsyncResult asyncResult);

    void getUserInfo(String str, boolean z16, String str2, AsyncResult asyncResult);

    void getUserInfoExtra(String str, AsyncResult asyncResult);

    void getUserInfoOpenData(String str, String str2, String[] strArr, AsyncResult asyncResult);

    void getUserInteractiveStorage(COMM.StCommonExt stCommonExt, String str, String[] strArr, AsyncResult asyncResult);

    void getUserSetting(String str, String str2, String str3, ArrayList<String> arrayList, AsyncResult asyncResult);

    String getUserTheme();

    AbsVideoPlayer getVideoPlayer();

    void httpReport(Bundle bundle);

    void insertBookShelf(String str, String str2, ArrayList<String> arrayList, AsyncResult asyncResult);

    boolean isGooglePlayVersion();

    void joinGroupByTags(String str, String[] strArr, AsyncResult asyncResult);

    void judgeTiming(String str, int i3, int i16, int i17, long j3, int i18, int i19, String str2, int i26, String str3, int i27, COMM.StCommonExt stCommonExt, String str4, String str5, AsyncResult asyncResult);

    boolean jump2PublicAccount(Context context, String str, String str2);

    void launchAddPhoneNumberFragment(Activity activity, Intent intent, int i3);

    void launchPhoneNumberManagementFragment(Activity activity, Intent intent, int i3);

    void launchSubMsgPermissionSettingFragment(Activity activity, Intent intent, int i3);

    void login(String str, AsyncResult asyncResult);

    void modifyFriendInteractiveStorage(COMM.StCommonExt stCommonExt, String str, String str2, String str3, int i3, String str4, HashMap<String, String> hashMap, boolean z16, CloudStorage$StInteractiveTemplate cloudStorage$StInteractiveTemplate, AsyncResult asyncResult);

    void onInitFinish();

    boolean openGroup(Context context, String str, AsyncResult asyncResult);

    boolean openPermissionSettingsActivity(Context context, String str, String str2);

    boolean openQzonePublish(IMiniAppContext iMiniAppContext, Activity activity, String str, MiniAppInfo miniAppInfo);

    boolean openRobotProfileCard(Context context, String str, String str2);

    void openSchemeOrUrl(Context context, String str, boolean z16);

    void queryBookShelf(String str, ArrayList<String> arrayList, AsyncResult asyncResult);

    void queryCurrency(String str, String str2, int i3, int i16, AsyncResult asyncResult);

    void queryMiniGameUserAgreement(String str, AsyncResult asyncResult);

    void realTimeLogReport(String str, String str2, String str3, String[] strArr, ArrayList<RealTimeLogItem> arrayList, AsyncResult asyncResult);

    void removeUserCloudStorage(String str, String[] strArr, AsyncResult asyncResult);

    void report(byte[] bArr, String str, String str2, AsyncResult asyncResult);

    void reportBeacon(@NonNull BeaconReportCategory beaconReportCategory, @NonNull String str, @Nullable Map<String, String> map);

    void reportBeacon(@NonNull BeaconReportCategory beaconReportCategory, @NonNull String str, @Nullable Map<String, String> map, boolean z16, boolean z17);

    void reportExecute(String str, int i3, String str2, String str3, AsyncResult asyncResult);

    void reportShare(COMM.StCommonExt stCommonExt, long j3, String str, int i3, int i16, int i17, int i18, String str2, AsyncResult asyncResult);

    void reportTrafficFlow(int i3, String str, String str2, String str3, int i16);

    void saveMiniGameUserAgreementData(String str, Object obj);

    void sendSmsCodeRequest(String str, String str2, AsyncResult asyncResult);

    void sendVerifySmsCodeRequest(String str, String str2, String str3, AsyncResult asyncResult);

    void setAuth(String str, UserAuthInfo userAuthInfo, AsyncResult asyncResult);

    void setPersonalizeInfo(String str, String str2, int i3, String str3, String str4, AsyncResult asyncResult);

    void setUserAppLike(boolean z16, COMM.StCommonExt stCommonExt, String str, AsyncResult asyncResult);

    void setUserAppTop(MiniAppInfo miniAppInfo, AsyncResult asyncResult);

    void setUserCloudStorage(String str, HashMap<String, String> hashMap, AsyncResult asyncResult);

    boolean setWebviewCookie(Context context, List<String> list, SetCookieCallback setCookieCallback);

    void showDialog(Activity activity, String str, String str2, String str3, String str4, AsyncMultiObjResult asyncMultiObjResult);

    void showMiniGameUserAgreementDialog(Activity activity, String str, String str2, SpannableString spannableString, MovementMethod movementMethod, boolean z16, AsyncMultiObjResult asyncMultiObjResult);

    void signMiniGameUserAgreement(String str, String str2, boolean z16, AsyncResult asyncResult);

    void springHbReport(String str, int i3, int i16, Map<String, String> map, String str2);

    boolean startAddFriendActivity(Context context, String str, String str2, String str3);

    boolean startBrowserSupportHeaderActivityForResult(Activity activity, String str, Bundle bundle, int i3);

    boolean startChooseMessageFileActivityForResult(Activity activity, int i3, String str, int i16);

    void startDownloadX5(IMiniAppContext iMiniAppContext);

    boolean startRedpacketTranslucentBrowserActivityForResult(Activity activity, String str, Bundle bundle, int i3);

    boolean startTransparentBrowserActivityForResult(Activity activity, String str, Bundle bundle, int i3);

    void subscribePublicAccount(String str, AsyncResult asyncResult);

    void syncForceGroundAndRefreshBadge(Activity activity, String str, String str2);

    boolean tianshuReport(TianShuAccess.AdItem adItem, String str, int i3);

    boolean tianshuRequestAdv(Context context, String str, int i3, int i16, int i17, AsyncResult asyncResult);

    void transForRoomId(String str, String str2, AsyncResult asyncResult);

    boolean updateBaseLib(String str, boolean z16, boolean z17, AsyncResult asyncResult);

    void updateBookshelfReadtime(String str, String str2, String str3, AsyncResult asyncResult);

    boolean updateEntryList(String str);

    void updateTouchInfoList(ArrayList<TouchInfo> arrayList);

    void updateUserSetting(String str, INTERFACE$StUserSettingInfo iNTERFACE$StUserSettingInfo, AsyncResult asyncResult);

    void uploadUserLog(String str);

    void useUserApp(String str, int i3, int i16, String str2, String str3, COMM.StCommonExt stCommonExt, AsyncResult asyncResult);

    void verifyPlugin(String str, ArrayList<PluginInfo> arrayList, AsyncResult asyncResult);

    boolean wnsCgiRequest(JSONObject jSONObject, AsyncResult asyncResult);
}
