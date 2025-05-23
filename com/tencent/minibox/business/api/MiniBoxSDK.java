package com.tencent.minibox.business.api;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.tencent.minibox.business.MiniBoxEngine;
import com.tencent.minibox.common.log.LogUtils;
import com.tencent.minibox.common.thread.ThreadManager;
import com.tencent.minibox.contract.IMiniBoxPluginCallback;
import com.tencent.minibox.contract.IMiniBoxServiceConnection;
import com.tencent.minibox.contract.LaunchAppInfo;
import com.tencent.minibox.loader.core.PluginVersionManager;
import com.tencent.minibox.proxy.MiniBoxProxy;
import java.util.List;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public class MiniBoxSDK {

    /* compiled from: P */
    @Keep
    /* loaded from: classes9.dex */
    static class GetExtraInfoCallback extends IMiniBoxPluginCallback.Stub {
        private final IMiniBoxDataCallback<String> dataCallback;

        GetExtraInfoCallback(IMiniBoxDataCallback<String> iMiniBoxDataCallback) {
            this.dataCallback = iMiniBoxDataCallback;
        }

        @Override // com.tencent.minibox.contract.IMiniBoxPluginCallback
        public void onResult(Bundle bundle) throws RemoteException {
            if (bundle != null) {
                int i3 = bundle.getInt("code");
                String string = bundle.getString("content");
                if (i3 == 0 && !TextUtils.isEmpty(string)) {
                    IMiniBoxDataCallback<String> iMiniBoxDataCallback = this.dataCallback;
                    if (iMiniBoxDataCallback != null) {
                        iMiniBoxDataCallback.onSuccess(string);
                        return;
                    }
                    return;
                }
                IMiniBoxDataCallback<String> iMiniBoxDataCallback2 = this.dataCallback;
                if (iMiniBoxDataCallback2 != null) {
                    iMiniBoxDataCallback2.onFail(i3, "content is empty");
                }
            }
        }
    }

    public static void bindService(final Intent intent, final String str, final IMiniBoxServiceConnection iMiniBoxServiceConnection) {
        ThreadManager.get().execute(new Runnable() { // from class: com.tencent.minibox.business.api.d
            @Override // java.lang.Runnable
            public final void run() {
                MiniBoxSDK.lambda$bindService$10(intent, str, iMiniBoxServiceConnection);
            }
        });
    }

    public static void checkAvailable(String str) {
        MiniBoxEngine.s().d(str);
    }

    public static void clearAllCache(Context context, boolean z16) {
        MiniBoxEngine.e(context, z16);
    }

    public static void clearPlugin(Context context) {
        MiniBoxEngine.f(context);
    }

    public static void clearPluginSafely(Context context) {
        MiniBoxEngine.g(context);
    }

    public static long getAllCacheSize(Context context) {
        return MiniBoxEngine.i(context);
    }

    @Nullable
    public static String getApkPath(Context context, String str) {
        return MiniBoxEngine.s().j(context, str);
    }

    public static void getAppDataStorageSpace(final String str, final AsyncCallback<Long> asyncCallback) {
        ThreadManager.get().execute(new Runnable() { // from class: com.tencent.minibox.business.api.f
            @Override // java.lang.Runnable
            public final void run() {
                MiniBoxSDK.lambda$getAppDataStorageSpace$12(str, asyncCallback);
            }
        });
    }

    public static void getAppExternalStorageSpace(final String str, final AsyncCallback<Long> asyncCallback) {
        ThreadManager.get().execute(new Runnable() { // from class: com.tencent.minibox.business.api.k
            @Override // java.lang.Runnable
            public final void run() {
                MiniBoxSDK.lambda$getAppExternalStorageSpace$13(str, asyncCallback);
            }
        });
    }

    public static void getAppExtraInfo(final String str, final Bundle bundle, final IMiniBoxDataCallback<String> iMiniBoxDataCallback) {
        if (TextUtils.isEmpty(str)) {
            LogUtils.e("MiniBoxSDK", "getAppExtraInfo pkgName is empty");
        } else {
            ThreadManager.get().execute(new Runnable() { // from class: com.tencent.minibox.business.api.MiniBoxSDK.1
                @Override // java.lang.Runnable
                public void run() {
                    String str2;
                    MiniBoxAppInfo installedAppInfo = MiniBoxSDK.getInstalledAppInfo(str);
                    String str3 = "";
                    if (installedAppInfo == null) {
                        str2 = "";
                    } else {
                        str2 = installedAppInfo.getVersionName();
                    }
                    if (str2 != null) {
                        str3 = str2;
                    }
                    MiniBoxEngine.s().m(str, str3, bundle, new GetExtraInfoCallback(iMiniBoxDataCallback));
                }
            });
        }
    }

    @Nullable
    public static LaunchAppInfo getAppInfo() {
        return MiniBoxEngine.s().n();
    }

    public static long getAppStorageSpace(String str) {
        return MiniBoxEngine.s().k(str) + MiniBoxEngine.s().l(str);
    }

    public static String getDexVersion(Context context) {
        return PluginVersionManager.f151646b.i(context);
    }

    @WorkerThread
    public static MiniBoxAppInfo getInstalledAppInfo(String str) {
        return MiniBoxEngine.s().p(str);
    }

    @WorkerThread
    public static List<MiniBoxAppInfo> getInstalledApps() {
        return MiniBoxEngine.s().q(0);
    }

    public static Bundle getMetaDataFromApplicationInfo(String str) {
        ApplicationInfo o16 = MiniBoxEngine.s().o(str);
        if (o16 != null) {
            return o16.metaData;
        }
        return null;
    }

    public static void init(Context context, MiniBoxProxy miniBoxProxy) {
        MiniBoxEngine.s().v(miniBoxProxy);
        MiniBoxEngine.s().u(context, miniBoxProxy);
    }

    @AnyThread
    public static void installApp(@NonNull final String str, @Nullable final IMiniBoxCallback iMiniBoxCallback) {
        ThreadManager.get().execute(new Runnable() { // from class: com.tencent.minibox.business.api.b
            @Override // java.lang.Runnable
            public final void run() {
                MiniBoxSDK.lambda$installApp$1(str, iMiniBoxCallback);
            }
        });
    }

    @WorkerThread
    public static boolean isAppInstalled(@NonNull String str) {
        return MiniBoxEngine.s().y(str);
    }

    public static boolean isMAppAlive(Context context) {
        return p51.c.d(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$bindService$10(Intent intent, String str, IMiniBoxServiceConnection iMiniBoxServiceConnection) {
        MiniBoxEngine.s().c(intent, str, iMiniBoxServiceConnection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getAppDataStorageSpace$12(String str, AsyncCallback asyncCallback) {
        asyncCallback.onResult(Long.valueOf(MiniBoxEngine.s().k(str)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getAppExternalStorageSpace$13(String str, AsyncCallback asyncCallback) {
        asyncCallback.onResult(Long.valueOf(MiniBoxEngine.s().l(str)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getInstalledAppInfo$5(String str, AsyncCallback asyncCallback) {
        asyncCallback.onResult(MiniBoxEngine.s().p(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getInstalledApps$4(IMiniBoxDataCallback iMiniBoxDataCallback) {
        MiniBoxEngine.s().r(0, iMiniBoxDataCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$installApp$1(String str, IMiniBoxCallback iMiniBoxCallback) {
        MiniBoxEngine.s().w(str, iMiniBoxCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$isAppInstalled$3(String str, AsyncCallback asyncCallback) {
        asyncCallback.onResult(Boolean.valueOf(MiniBoxEngine.s().y(str)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$launchApp$8(LaunchAppInfo launchAppInfo, IMiniBoxCallback iMiniBoxCallback) {
        MiniBoxEngine.s().A(launchAppInfo, iMiniBoxCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$preLaunchApp$6(String str, IMiniBoxCallback iMiniBoxCallback) {
        MiniBoxEngine.s().C(str, iMiniBoxCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$preLaunchProcess$7(Context context, boolean z16) {
        MiniBoxEngine.s().D(context, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$preload$0() {
        MiniBoxEngine.s().E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$stopApp$9(String str, AsyncCallback asyncCallback) {
        MiniBoxEngine.s().F(str, asyncCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$unInstallApp$2(String str, AsyncCallback asyncCallback) {
        boolean h16 = MiniBoxEngine.s().h(str);
        if (asyncCallback != null) {
            asyncCallback.onResult(Boolean.valueOf(h16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$unbindService$11(IMiniBoxServiceConnection iMiniBoxServiceConnection) {
        MiniBoxEngine.s().G(iMiniBoxServiceConnection);
    }

    @AnyThread
    public static void launchApp(@NonNull LaunchAppInfo launchAppInfo) {
        launchApp(launchAppInfo, null);
    }

    public static boolean notifyClient(int i3, String str, Bundle bundle) {
        return MiniBoxEngine.s().B(i3, str, bundle);
    }

    public static void onMiniBoxProcessInit(Application application, MiniBoxProxy miniBoxProxy) {
        MiniBoxEngine.s().v(miniBoxProxy);
        n51.b.c(application);
    }

    public static void preLaunchApp(final String str, final IMiniBoxCallback iMiniBoxCallback) {
        ThreadManager.get().execute(new Runnable() { // from class: com.tencent.minibox.business.api.j
            @Override // java.lang.Runnable
            public final void run() {
                MiniBoxSDK.lambda$preLaunchApp$6(str, iMiniBoxCallback);
            }
        });
    }

    public static boolean preLaunchAppSync(String str) {
        return MiniBoxEngine.s().C(str, null);
    }

    public static void preLaunchProcess(final Context context, final boolean z16) {
        ThreadManager.get().execute(new Runnable() { // from class: com.tencent.minibox.business.api.a
            @Override // java.lang.Runnable
            public final void run() {
                MiniBoxSDK.lambda$preLaunchProcess$7(context, z16);
            }
        });
    }

    public static void preload() {
        ThreadManager.get().execute(new Runnable() { // from class: com.tencent.minibox.business.api.n
            @Override // java.lang.Runnable
            public final void run() {
                MiniBoxSDK.lambda$preload$0();
            }
        });
    }

    public static void stopApp(final String str, final AsyncCallback<String> asyncCallback) {
        ThreadManager.get().execute(new Runnable() { // from class: com.tencent.minibox.business.api.i
            @Override // java.lang.Runnable
            public final void run() {
                MiniBoxSDK.lambda$stopApp$9(str, asyncCallback);
            }
        });
    }

    @WorkerThread
    public static boolean unInstallApp(@NonNull String str) {
        return MiniBoxEngine.s().h(str);
    }

    public static void unbindService(final IMiniBoxServiceConnection iMiniBoxServiceConnection) {
        ThreadManager.get().execute(new Runnable() { // from class: com.tencent.minibox.business.api.h
            @Override // java.lang.Runnable
            public final void run() {
                MiniBoxSDK.lambda$unbindService$11(IMiniBoxServiceConnection.this);
            }
        });
    }

    @AnyThread
    public static void getInstalledAppInfo(final String str, final AsyncCallback<MiniBoxAppInfo> asyncCallback) {
        ThreadManager.get().execute(new Runnable() { // from class: com.tencent.minibox.business.api.l
            @Override // java.lang.Runnable
            public final void run() {
                MiniBoxSDK.lambda$getInstalledAppInfo$5(str, asyncCallback);
            }
        });
    }

    @AnyThread
    public static void getInstalledApps(@NonNull final IMiniBoxDataCallback<List<MiniBoxAppInfo>> iMiniBoxDataCallback) {
        ThreadManager.get().execute(new Runnable() { // from class: com.tencent.minibox.business.api.m
            @Override // java.lang.Runnable
            public final void run() {
                MiniBoxSDK.lambda$getInstalledApps$4(IMiniBoxDataCallback.this);
            }
        });
    }

    @AnyThread
    public static void isAppInstalled(@NonNull final String str, @NonNull final AsyncCallback<Boolean> asyncCallback) {
        ThreadManager.get().execute(new Runnable() { // from class: com.tencent.minibox.business.api.e
            @Override // java.lang.Runnable
            public final void run() {
                MiniBoxSDK.lambda$isAppInstalled$3(str, asyncCallback);
            }
        });
    }

    @AnyThread
    public static void launchApp(@NonNull final LaunchAppInfo launchAppInfo, final IMiniBoxCallback iMiniBoxCallback) {
        ThreadManager.get().execute(new Runnable() { // from class: com.tencent.minibox.business.api.g
            @Override // java.lang.Runnable
            public final void run() {
                MiniBoxSDK.lambda$launchApp$8(LaunchAppInfo.this, iMiniBoxCallback);
            }
        });
    }

    @AnyThread
    public static void unInstallApp(@NonNull final String str, @Nullable final AsyncCallback<Boolean> asyncCallback) {
        ThreadManager.get().execute(new Runnable() { // from class: com.tencent.minibox.business.api.c
            @Override // java.lang.Runnable
            public final void run() {
                MiniBoxSDK.lambda$unInstallApp$2(str, asyncCallback);
            }
        });
    }
}
