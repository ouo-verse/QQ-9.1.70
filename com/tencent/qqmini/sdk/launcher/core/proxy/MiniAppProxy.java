package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.ResultReceiver;
import android.widget.ImageView;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.AppThemeInfo;
import com.tencent.qqmini.sdk.launcher.core.model.PrivacyDetailInfo;
import com.tencent.qqmini.sdk.launcher.model.AppState;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.ui.MoreItem;
import com.tencent.qqmini.sdk.launcher.ui.MoreItemList;
import com.tencent.qqmini.sdk.launcher.ui.OnAppCloseAction;
import com.tencent.qqmini.sdk.launcher.ui.OnMoreItemSelectedListener;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public abstract class MiniAppProxy {

    /* loaded from: classes23.dex */
    public enum DeviceType {
        PHONE,
        TABLET,
        FOLD
    }

    /* loaded from: classes23.dex */
    public interface GetA2InfoCallback {
        void onFail(int i3, String str);

        void onSuccess(String str, String str2, String str3);
    }

    /* loaded from: classes23.dex */
    public interface GetPrivacyInfoListener {
        void onResult(boolean z16, boolean z17, PrivacyDetailInfo privacyDetailInfo);
    }

    /* loaded from: classes23.dex */
    public interface GetStringCallback {
        void onResult(String str);
    }

    /* loaded from: classes23.dex */
    public interface GetUserRoleGroupListener {
        void onResult(boolean z16, JSONObject jSONObject);
    }

    /* loaded from: classes23.dex */
    public interface IAppUpdateListener {
        void onGetAppUpdateResult(boolean z16, String str);
    }

    /* loaded from: classes23.dex */
    public interface IChoosePhotoListner {
        void onResult(ArrayList<String> arrayList);
    }

    /* loaded from: classes23.dex */
    public interface IDrawableLoadedCallBack {
        void onLoadSuccessed(Drawable drawable);
    }

    /* loaded from: classes23.dex */
    public interface InitTbsCallback {
        void onTbsInitFinish();
    }

    /* loaded from: classes23.dex */
    public interface SenderListener {
        boolean onReply(int i3, byte[] bArr, String str);
    }

    public abstract boolean addShortcut(Context context, MiniAppInfo miniAppInfo, AsyncResult asyncResult);

    public abstract void changeNavIcon(ImageView imageView, ImageView imageView2);

    public abstract boolean chooseLocation(Context context, AsyncResult asyncResult);

    public abstract boolean downloadApp(Context context, MiniAppInfo miniAppInfo, String str, String str2, String str3, String str4);

    public abstract boolean enterQRCode(Context context, boolean z16, AsyncResult asyncResult);

    public abstract void getA2(GetA2InfoCallback getA2InfoCallback);

    public abstract void getA2(String str, GetA2InfoCallback getA2InfoCallback);

    public abstract String getAccount();

    public abstract String getAmsAppId();

    public abstract String getAppId();

    public abstract String getAppName();

    public abstract AppThemeInfo getAppThemeInfo();

    public abstract void getAppUpdate(Activity activity, IAppUpdateListener iAppUpdateListener);

    public abstract String getAppVersion();

    public abstract int getClipboardInterval();

    public abstract DeviceType getDeviceType();

    public abstract Drawable getDrawable(Context context, String str, int i3, int i16, Drawable drawable);

    public abstract Drawable getDrawable(Context context, String str, int i3, int i16, Drawable drawable, boolean z16);

    public abstract String getLocation(Context context);

    public abstract boolean getLocation(Context context, String str, boolean z16, AsyncResult asyncResult);

    public abstract byte[] getLoginSig();

    public abstract int getLoginType();

    public abstract void getMiniAppPrivacyInfo(String str, String str2, GetPrivacyInfoListener getPrivacyInfoListener);

    public abstract OnMoreItemSelectedListener getMoreItemSelectedListener();

    public abstract ArrayList<MoreItem> getMoreItems(MoreItemList.Builder builder);

    public abstract String getNickName();

    public abstract String getPayAccessToken();

    public abstract int getPayMode();

    public abstract String getPayOpenId();

    public abstract String getPayOpenKey();

    public abstract String getPlatformId();

    public abstract String getPlatformQUA();

    public abstract void getPskey(String str, GetStringCallback getStringCallback);

    public abstract String getQImei16();

    public abstract String getQImei36();

    public abstract float getQQDensity(Context context);

    public abstract JSONObject getQQMCConfig(String str);

    public abstract void getRoleGroupInfoList(String str, GetUserRoleGroupListener getUserRoleGroupListener);

    public abstract String getSoPath();

    public abstract int getTbsVersion();

    public abstract String getUin();

    public abstract boolean hasTbsInitDone();

    public abstract void initTbs(InitTbsCallback initTbsCallback);

    public abstract boolean isDebugVersion();

    public abstract boolean isFolderScreenOpenMode(Context context);

    public abstract boolean isGrayVersion();

    public abstract void isGroupMember(String str, String str2, AsyncResult asyncResult);

    public abstract boolean isInnerMode();

    public abstract boolean isPreloadApkgState();

    public abstract boolean isPublicVersion();

    public abstract boolean isShortcutExist(Context context, MiniAppInfo miniAppInfo);

    public abstract boolean isSplitView(Context context);

    public abstract boolean isUseWebViewTryLockOrRecreateFile();

    public abstract void loadImage(Context context, ImageView imageView, String str, int i3, int i16, Drawable drawable, Drawable drawable2);

    public abstract void muteAudioFocus(Context context, boolean z16);

    public abstract void notifyMiniAppInfo(int i3, MiniAppInfo miniAppInfo);

    public abstract OnAppCloseAction onAppClose(MiniAppInfo miniAppInfo, Closeable closeable);

    public abstract void onAppStateChange(MiniAppInfo miniAppInfo, @AppState int i3);

    public abstract boolean onCapsuleButtonCloseClick(IMiniAppContext iMiniAppContext, DialogInterface.OnClickListener onClickListener);

    public abstract boolean onCapsuleButtonMoreClick(IMiniAppContext iMiniAppContext);

    public abstract boolean openChoosePhotoActivity(Context context, int i3, IChoosePhotoListner iChoosePhotoListner);

    public abstract boolean openImagePreview(Context context, int i3, List<String> list);

    public abstract boolean openLocation(Context context, double d16, double d17, int i3, String str, String str2);

    public abstract boolean openNativePage(Context context, String str, String str2, String str3);

    public abstract boolean openSchema(Context context, String str, int i3, ResultReceiver resultReceiver);

    public abstract void sendData(byte[] bArr, SenderListener senderListener);

    public abstract void sendRequestByMsf(byte[] bArr, String str, SenderListener senderListener);

    public abstract void sendShareInfoToGroup(IMiniAppContext iMiniAppContext, long j3);

    public abstract void setDrawableCallback(Drawable drawable, IDrawableLoadedCallBack iDrawableLoadedCallBack);

    public abstract boolean startBrowserActivity(Context context, Intent intent);

    public abstract void synchConvertSDK2QQConfig(IMiniAppContext iMiniAppContext);

    public abstract boolean verifyFile(int i3, String str);
}
