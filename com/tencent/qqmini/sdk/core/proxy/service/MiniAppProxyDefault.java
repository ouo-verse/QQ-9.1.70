package com.tencent.qqmini.sdk.core.proxy.service;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.ResultReceiver;
import android.widget.ImageView;
import com.tencent.mobileqq.msf.MSFAccountChangeRegisterTask;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.core.manager.HttpServer;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.AppThemeInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AppState;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.ui.MoreItem;
import com.tencent.qqmini.sdk.launcher.ui.MoreItemList;
import com.tencent.qqmini.sdk.launcher.ui.OnAppCloseAction;
import com.tencent.qqmini.sdk.launcher.ui.OnMoreItemSelectedListener;
import com.tencent.qqmini.sdk.ui.DefaultMoreItemSelectedListener;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@ProxyService(proxy = MiniAppProxy.class)
/* loaded from: classes23.dex */
public class MiniAppProxyDefault extends MiniAppProxy {
    private static final String TAG = "MiniAppProxyDefault";

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean addShortcut(Context context, MiniAppInfo miniAppInfo, AsyncResult asyncResult) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean chooseLocation(Context context, AsyncResult asyncResult) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean downloadApp(Context context, MiniAppInfo miniAppInfo, String str, String str2, String str3, String str4) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean enterQRCode(Context context, boolean z16, AsyncResult asyncResult) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void getA2(MiniAppProxy.GetA2InfoCallback getA2InfoCallback) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public String getAccount() {
        return MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public String getAmsAppId() {
        return "";
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public String getAppId() {
        return "";
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public String getAppName() {
        return "sdk";
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public AppThemeInfo getAppThemeInfo() {
        return new AppThemeInfo(1.0f, 16.0f, false);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void getAppUpdate(Activity activity, MiniAppProxy.IAppUpdateListener iAppUpdateListener) {
        if (iAppUpdateListener != null) {
            iAppUpdateListener.onGetAppUpdateResult(false, "\u66f4\u65b0\u5931\u8d25");
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public String getAppVersion() {
        return "9.1.10";
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public int getClipboardInterval() {
        return 2;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public MiniAppProxy.DeviceType getDeviceType() {
        return MiniAppProxy.DeviceType.PHONE;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public Drawable getDrawable(Context context, String str, int i3, int i16, Drawable drawable) {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean getLocation(Context context, String str, boolean z16, AsyncResult asyncResult) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public byte[] getLoginSig() {
        return new byte[0];
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public int getLoginType() {
        return 0;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public OnMoreItemSelectedListener getMoreItemSelectedListener() {
        return new DefaultMoreItemSelectedListener();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public ArrayList<MoreItem> getMoreItems(MoreItemList.Builder builder) {
        MoreItemList.Builder addShareWxMoments = builder.addShareQQ("QQ", R.drawable.mini_sdk_channel_qq).addShareQzone("QQ\u7a7a\u95f4", R.drawable.mini_sdk_channel_qzone).addShareWxFriends("\u5fae\u4fe1\u597d\u53cb", R.drawable.mini_sdk_channel_wx_friend).addShareWxMoments("\u5fae\u4fe1\u670b\u53cb\u5708", R.drawable.mini_sdk_channel_wx_moment);
        int i3 = R.drawable.mini_sdk_about;
        addShareWxMoments.addAbout("\u5173\u4e8e", i3).addComplaint("\u4e3e\u62a5", R.drawable.mini_sdk_browser_report).addDebug("\u8c03\u8bd5", i3).addMonitor("\u6027\u80fd", i3);
        return builder.build();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public String getNickName() {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public String getPayAccessToken() {
        return "ABC";
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public int getPayMode() {
        if (!QUAUtil.isAlienApp() && !QUAUtil.isMicroApp() && !QUAUtil.isQQApp()) {
            if (WnsConfig.getConfig("qqminiapp", "mini_game_pay_by_h5", 1) != 1) {
                return 2;
            }
            return 1;
        }
        if (WnsConfig.getConfig("qqminiapp", "mini_game_pay_by_h5", 0) == 0) {
            return 2;
        }
        return 1;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public String getPayOpenId() {
        return com.tencent.mobileqq.msf.core.auth.e.f247445e;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public String getPayOpenKey() {
        return "ABC";
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public String getPlatformId() {
        return "16";
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public String getPlatformQUA() {
        return "";
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void getPskey(String str, MiniAppProxy.GetStringCallback getStringCallback) {
        if (getStringCallback != null) {
            getStringCallback.onResult("get pskey");
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public String getQImei16() {
        return "1612345678901616";
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public String getQImei36() {
        return "16123456789016168888789698887456";
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public float getQQDensity(Context context) {
        return 0.0f;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public JSONObject getQQMCConfig(String str) {
        return new JSONObject();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public String getSoPath() {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public int getTbsVersion() {
        return 1;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public String getUin() {
        return "getUinTest";
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean hasTbsInitDone() {
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean isDebugVersion() {
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean isFolderScreenOpenMode(Context context) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean isGrayVersion() {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean isInnerMode() {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean isPreloadApkgState() {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean isPublicVersion() {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean isShortcutExist(Context context, MiniAppInfo miniAppInfo) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean isSplitView(Context context) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean isUseWebViewTryLockOrRecreateFile() {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public OnAppCloseAction onAppClose(MiniAppInfo miniAppInfo, Closeable closeable) {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void onAppStateChange(MiniAppInfo miniAppInfo, @AppState int i3) {
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            QMLog.e(TAG, miniAppInfo.name + "," + miniAppInfo.appId + ",unknown AppState " + i3);
            return;
        }
        QMLog.d(TAG, miniAppInfo.name + "," + miniAppInfo.appId + ",onAppStateChange " + i3);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean onCapsuleButtonCloseClick(IMiniAppContext iMiniAppContext, DialogInterface.OnClickListener onClickListener) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean onCapsuleButtonMoreClick(IMiniAppContext iMiniAppContext) {
        QMLog.d(TAG, "onCapsuleButtonMoreClick");
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean openChoosePhotoActivity(Context context, int i3, MiniAppProxy.IChoosePhotoListner iChoosePhotoListner) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean openImagePreview(Context context, int i3, List<String> list) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean openLocation(Context context, double d16, double d17, int i3, String str, String str2) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean openNativePage(Context context, String str, String str2, String str3) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean openSchema(Context context, String str, int i3, ResultReceiver resultReceiver) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void sendData(byte[] bArr, MiniAppProxy.SenderListener senderListener) {
        HttpServer.sendData(bArr, senderListener);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void sendRequestByMsf(byte[] bArr, String str, MiniAppProxy.SenderListener senderListener) {
        HttpServer.sendData(bArr, senderListener);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean startBrowserActivity(Context context, Intent intent) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public boolean verifyFile(int i3, String str) {
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void getA2(String str, MiniAppProxy.GetA2InfoCallback getA2InfoCallback) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public Drawable getDrawable(Context context, String str, int i3, int i16, Drawable drawable, boolean z16) {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public String getLocation(Context context) {
        Location lastKnownLocation;
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            Criteria criteria = new Criteria();
            criteria.setCostAllowed(false);
            criteria.setAccuracy(2);
            String bestProvider = locationManager.getBestProvider(criteria, true);
            if (bestProvider == null || (lastKnownLocation = LocationMonitor.getLastKnownLocation(locationManager, bestProvider)) == null) {
                return "";
            }
            return lastKnownLocation.getLatitude() + "*" + lastKnownLocation.getLongitude();
        } catch (Exception e16) {
            QMLog.e("getLocation", "getLocation>>>", e16);
        }
        return "";
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void initTbs(MiniAppProxy.InitTbsCallback initTbsCallback) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void synchConvertSDK2QQConfig(IMiniAppContext iMiniAppContext) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void changeNavIcon(ImageView imageView, ImageView imageView2) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void getRoleGroupInfoList(String str, MiniAppProxy.GetUserRoleGroupListener getUserRoleGroupListener) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void muteAudioFocus(Context context, boolean z16) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void notifyMiniAppInfo(int i3, MiniAppInfo miniAppInfo) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void sendShareInfoToGroup(IMiniAppContext iMiniAppContext, long j3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void setDrawableCallback(Drawable drawable, MiniAppProxy.IDrawableLoadedCallBack iDrawableLoadedCallBack) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void getMiniAppPrivacyInfo(String str, String str2, MiniAppProxy.GetPrivacyInfoListener getPrivacyInfoListener) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void isGroupMember(String str, String str2, AsyncResult asyncResult) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy
    public void loadImage(Context context, ImageView imageView, String str, int i3, int i16, Drawable drawable, Drawable drawable2) {
    }
}
