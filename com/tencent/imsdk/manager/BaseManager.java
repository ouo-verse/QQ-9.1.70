package com.tencent.imsdk.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.common.NetworkInfoCenter;
import com.tencent.imsdk.common.SystemUtil;
import com.tencent.imsdk.conversation.ConversationManager;
import com.tencent.imsdk.group.GroupManager;
import com.tencent.imsdk.manager.SDKConfig;
import com.tencent.imsdk.message.MessageCenter;
import com.tencent.imsdk.relationship.RelationshipManager;
import com.tencent.imsdk.relationship.UserInfo;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes7.dex */
public class BaseManager implements NetworkInfoCenter.INetworkChangeListener {
    private static final String TAG = "BaseManager";
    private static boolean mLoadLibrarySuccess = false;
    private WeakReference<SDKListener> sdkListenerWeakReference;
    private SDKConfig.NetworkInfo mLastNetworkInfo = new SDKConfig.NetworkInfo();
    private boolean isInit = false;
    private boolean isTestEnvironment = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class BaseManagerHolder {
        private static final BaseManager baseManager = new BaseManager();

        BaseManagerHolder() {
        }
    }

    static {
        try {
            mLoadLibrarySuccess = SystemUtil.loadIMLibrary();
        } catch (Exception e16) {
            Log.e(TAG, e16.toString());
        }
    }

    public static BaseManager getInstance() {
        return BaseManagerHolder.baseManager;
    }

    private String getUIPlatform() {
        boolean isTUIKit = isTUIKit();
        boolean isFlutter = isFlutter();
        boolean isUnity = isUnity();
        if (isFlutter) {
            if (isTUIKit) {
                return "tuikit&flutter";
            }
            return "flutter";
        }
        if (isUnity) {
            if (isTUIKit) {
                return "tuikit&unity";
            }
            return "unity";
        }
        if (isTUIKit) {
            return "tuikit";
        }
        return "";
    }

    private boolean isFlutter() {
        try {
            Class.forName("com.qq.qcloud.tencent_im_sdk_plugin.tencent_im_sdk_plugin");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean isTUIKit() {
        try {
            Class.forName("com.tencent.qcloud.tim.uikit.TUIKit");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean isUnity() {
        try {
            Class.forName("com.qcloud.tencentimsdk.TencentImSDKPluginUnity");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public long getClockTickInHz() {
        if (!this.isInit) {
            Log.e(TAG, "sdk not init");
            return 0L;
        }
        return nativeGetClockTickInHz();
    }

    public int getLoginStatus() {
        if (!this.isInit) {
            Log.e(TAG, "sdk not init");
            return 0;
        }
        return nativeGetLoginStatus();
    }

    public String getLoginUser() {
        if (!this.isInit) {
            Log.e(TAG, "sdk not init");
            return null;
        }
        return nativeGetLoginUser();
    }

    public long getServerTime() {
        if (!this.isInit) {
            Log.e(TAG, "sdk not init");
            return 0L;
        }
        return nativeGetServerTime();
    }

    public long getTimeTick() {
        if (!this.isInit) {
            Log.e(TAG, "sdk not init");
            return 0L;
        }
        return nativeGetTimeTick();
    }

    public String getVersion() {
        if (!this.isInit) {
            Log.e(TAG, "sdk not init");
            return null;
        }
        return nativeGetSDKVersion();
    }

    public void initLocalStorage(String str, IMCallback iMCallback) {
        if (!this.isInit) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeInitLocalStorage(str, iMCallback);
    }

    public boolean initSDK(Context context, SDKConfig sDKConfig, boolean z16, SDKListener sDKListener) {
        if (!mLoadLibrarySuccess) {
            IMLog.e(TAG, "libimsdk.so is not loaded");
            return false;
        }
        if (sDKConfig.sdkAppId <= 0) {
            IMLog.e(TAG, "invalid sdkAppID:" + sDKConfig.sdkAppId);
            return false;
        }
        if (context == null) {
            IMLog.e(TAG, "null context");
            return false;
        }
        if (this.isInit) {
            IMLog.w(TAG, "Has initSDK");
            return true;
        }
        String nativeGetSDKVersion = nativeGetSDKVersion();
        SharedPreferences.Editor edit = context.getSharedPreferences("BuglySdkInfos", 0).edit();
        edit.putString("ebfa608d4d", nativeGetSDKVersion);
        edit.commit();
        IMContext.getInstance().init(context.getApplicationContext());
        NetworkInfoCenter.getInstance().init(context.getApplicationContext(), this);
        MessageCenter.getInstance().init();
        GroupManager.getInstance().init();
        ConversationManager.getInstance().init();
        RelationshipManager.getInstance().init();
        sDKConfig.sdkInitPath = SystemUtil.getSDKInitPath();
        sDKConfig.sdkInstanceType = SystemUtil.getInstanceType();
        sDKConfig.testEnvironment = this.isTestEnvironment;
        sDKConfig.deviceInfo.deviceType = SystemUtil.getDeviceType();
        sDKConfig.deviceInfo.deviceId = SystemUtil.getDeviceID();
        sDKConfig.deviceInfo.deviceBrand = SystemUtil.getInstanceType();
        sDKConfig.deviceInfo.systemVersion = SystemUtil.getSystemVersion();
        sDKConfig.networkInfo.networkType = NetworkInfoCenter.getInstance().getNetworkType();
        sDKConfig.networkInfo.ipType = NetworkInfoCenter.getInstance().getIPType();
        sDKConfig.networkInfo.networkId = NetworkInfoCenter.getInstance().getNetworkID();
        sDKConfig.networkInfo.networkConnected = NetworkInfoCenter.getInstance().isNetworkConnected();
        SDKConfig.LogSetting logSetting = sDKConfig.logSetting;
        logSetting.enableConsoleLog = true;
        logSetting.logFilePath = SystemUtil.getSDKLogPath();
        sDKConfig.uiPlatform = getUIPlatform();
        this.mLastNetworkInfo = sDKConfig.networkInfo;
        nativeInitSDK(sDKConfig, z16, sDKListener);
        this.sdkListenerWeakReference = new WeakReference<>(sDKListener);
        this.isInit = true;
        return true;
    }

    public boolean isInited() {
        return this.isInit;
    }

    public void login(String str, String str2, IMCallback iMCallback) {
        if (!this.isInit) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeLogin(str, str2, iMCallback);
    }

    public void logout(IMCallback iMCallback) {
        if (!this.isInit) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeLogout(iMCallback);
    }

    protected native long nativeGetClockTickInHz();

    protected native int nativeGetLoginStatus();

    protected native String nativeGetLoginUser();

    protected native String nativeGetSDKVersion();

    protected native long nativeGetServerTime();

    protected native long nativeGetTimeTick();

    protected native void nativeInitLocalStorage(String str, IMCallback iMCallback);

    protected native void nativeInitSDK(SDKConfig sDKConfig, boolean z16, SDKListener sDKListener);

    protected native void nativeLogin(String str, String str2, IMCallback iMCallback);

    protected native void nativeLogout(IMCallback iMCallback);

    protected native void nativeNotifyNetworkChange(boolean z16, int i3, int i16, String str);

    protected native void nativeSetCustomServerInfo(CustomServerInfo customServerInfo);

    protected native void nativeUninitSDK();

    public void notifySelfInfoUpdated(UserInfo userInfo) {
        SDKListener sDKListener;
        WeakReference<SDKListener> weakReference = this.sdkListenerWeakReference;
        if (weakReference != null && (sDKListener = weakReference.get()) != null) {
            sDKListener.onSelfInfoUpdated(userInfo);
        }
    }

    @Override // com.tencent.imsdk.common.NetworkInfoCenter.INetworkChangeListener
    public void onNetworkChange(boolean z16, int i3, int i16, String str) {
        SDKConfig.NetworkInfo networkInfo = this.mLastNetworkInfo;
        if (z16 == networkInfo.networkConnected && i3 == networkInfo.networkType && i16 == networkInfo.ipType && str != null && str.equals(networkInfo.networkId)) {
            Log.w(TAG, "onNetworkChange, networkinfo is same");
            return;
        }
        SDKConfig.NetworkInfo networkInfo2 = this.mLastNetworkInfo;
        networkInfo2.networkConnected = z16;
        networkInfo2.networkType = i3;
        networkInfo2.ipType = i16;
        networkInfo2.networkId = str;
        nativeNotifyNetworkChange(z16, i3, i16, str);
    }

    public void setCustomServerInfo(CustomServerInfo customServerInfo) {
        nativeSetCustomServerInfo(customServerInfo);
    }

    public boolean setLibraryPath(String str) {
        boolean loadIMLibrary = SystemUtil.loadIMLibrary(str);
        mLoadLibrarySuccess = loadIMLibrary;
        return loadIMLibrary;
    }

    public void setTestEnvironment(boolean z16) {
        this.isTestEnvironment = z16;
    }

    public void unInitSDK() {
        nativeUninitSDK();
        this.isInit = false;
        this.isTestEnvironment = false;
        this.mLastNetworkInfo.clean();
    }
}
