package com.tencent.mobileqq.minigame.metafarm.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.minigame.api.IMetaFarmWidgetApi;
import com.tencent.mobileqq.minigame.metafarm.network.MetaFarmWidgetRequest;
import com.tencent.mobileqq.minigame.metafarm.widget.MetaFarmWidgetData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginStatus;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.f;
import com.tencent.mobileqq.vip.g;
import com.tencent.mobileqq.vip.h;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001cH\u0002J,\u0010!\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010\u00042\u0006\u0010#\u001a\u00020\u000b2\b\b\u0002\u0010$\u001a\u00020\u000bH\u0002J\u0010\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020'H\u0016J*\u0010(\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u000b2\b\b\u0002\u0010$\u001a\u00020\u000bH\u0002J\u0010\u0010*\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010+\u001a\u00020\u001cH\u0002J\b\u0010,\u001a\u00020\u001cH\u0002J\u000e\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u000bJ\u0010\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u0006H\u0002J\u000e\u00101\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u00102\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u000bH\u0002J\u001c\u00103\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u00104\u001a\u00020\u0010H\u0002J\b\u00105\u001a\u00020\u001cH\u0002J\b\u00106\u001a\u00020\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/minigame/metafarm/widget/MetaFarmWidgetUpdateManager;", "Landroid/os/Handler$Callback;", "()V", "ACTION_MINI_BOX_PROCESS_EXIT", "", "DEFAULT_UPDATE_INTERVAL", "", "DELAY_FOR_UPDATE_BROADCAST", "EXTRA_PACKAGE_NAME", "META_DREAM_PACKAGE_NAME", "MSG_REQUEST_UPDATE", "", "MSG_SEND_UPDATE_BROADCAST", "TAG", "WIDGET_DIR", "isProviderReceiverRegistered", "", "isVAExitReceiverRegistered", "mImageCacheDir", "Ljava/io/File;", "mMainHandler", "Lcom/tencent/util/WeakReferenceHandler;", "metaFarmVAExitReceiver", "Landroid/content/BroadcastReceiver;", "providerUpdateReceiver", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/mobileqq/minigame/metafarm/network/MetaFarmWidgetRequest;", "clearImgCache", "", "downloadImg", "widgetData", "Lcom/tencent/mobileqq/minigame/metafarm/widget/MetaFarmWidgetData;", "generateImageCacheDir", "handleImgDownload", "url", "type", "index", "handleMessage", "msg", "Landroid/os/Message;", "onImgDownloaded", "imgPath", "onWidgetDataUpdate", "registerMetaFarmVAExitReceiver", "registerProviderUpdateReceiver", "requestUpdateWidget", "source", "sendRequestUpdateMessage", "delay", "sendUpdateWidgetMessage", "sendWidgetRequest", "sendWidgetUpdateBroadcast", QAdLoginDefine$LoginStatus.IS_LOGIN, "unregisterMetaFarmVAExitReceiver", "unregisterProviderUpdateReceiver", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MetaFarmWidgetUpdateManager implements Handler.Callback {
    private static final String ACTION_MINI_BOX_PROCESS_EXIT = "action_mini_box_process_exit";
    private static final long DEFAULT_UPDATE_INTERVAL = 120000;
    private static final long DELAY_FOR_UPDATE_BROADCAST = 500;
    private static final String EXTRA_PACKAGE_NAME = "extra_package_name";
    public static final MetaFarmWidgetUpdateManager INSTANCE;
    private static final String META_DREAM_PACKAGE_NAME = "com.tencent.letsgo";
    private static final int MSG_REQUEST_UPDATE = 16;
    private static final int MSG_SEND_UPDATE_BROADCAST = 17;
    private static final String TAG = "MetaFarmWidgetUpdateManager";
    private static final String WIDGET_DIR = "metaFarmWidgetImg";
    private static boolean isProviderReceiverRegistered;
    private static boolean isVAExitReceiverRegistered;
    private static File mImageCacheDir;
    private static WeakReferenceHandler mMainHandler;
    private static BroadcastReceiver metaFarmVAExitReceiver;
    private static BroadcastReceiver providerUpdateReceiver;
    private static final MetaFarmWidgetRequest request;

    static {
        MetaFarmWidgetUpdateManager metaFarmWidgetUpdateManager = new MetaFarmWidgetUpdateManager();
        INSTANCE = metaFarmWidgetUpdateManager;
        mMainHandler = new WeakReferenceHandler(Looper.getMainLooper(), metaFarmWidgetUpdateManager);
        request = new MetaFarmWidgetRequest();
        metaFarmWidgetUpdateManager.generateImageCacheDir();
    }

    MetaFarmWidgetUpdateManager() {
    }

    private final void downloadImg(MetaFarmWidgetData widgetData) {
        generateImageCacheDir();
        MetaFarmWidgetData.UserInfo userInfo = widgetData.getUserInfo();
        handleImgDownload$default(this, widgetData, userInfo != null ? userInfo.getAvatar() : null, 1, 0, 8, null);
        MetaFarmWidgetData.UserInfo userInfo2 = widgetData.getUserInfo();
        handleImgDownload$default(this, widgetData, userInfo2 != null ? userInfo2.getLevelIconUrl() : null, 2, 0, 8, null);
        MetaFarmWidgetData.UserInfo userInfo3 = widgetData.getUserInfo();
        handleImgDownload$default(this, widgetData, userInfo3 != null ? userInfo3.getCoinIconUrl() : null, 3, 0, 8, null);
        int size = widgetData.getCards().size();
        for (int i3 = 0; i3 < size; i3++) {
            handleImgDownload(widgetData, widgetData.getCards().get(i3).getIcon(), 4, i3);
        }
    }

    private final void generateImageCacheDir() {
        File cacheDir;
        if (Intrinsics.areEqual("mounted", Environment.getExternalStorageState())) {
            cacheDir = new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH));
        } else {
            cacheDir = MobileQQ.sMobileQQ.getCacheDir();
        }
        File file = new File(cacheDir, WIDGET_DIR);
        mImageCacheDir = file;
        boolean exists = file.exists();
        File file2 = null;
        if (exists) {
            File file3 = mImageCacheDir;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mImageCacheDir");
                file3 = null;
            }
            if (file3.isDirectory()) {
                return;
            }
        }
        File file4 = mImageCacheDir;
        if (file4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageCacheDir");
        } else {
            file2 = file4;
        }
        file2.mkdirs();
    }

    private final void handleImgDownload(final MetaFarmWidgetData widgetData, String url, final int type, final int index) {
        if (TextUtils.isEmpty(url)) {
            QLog.w(TAG, 1, "handleImgDownload url empty, type:" + type);
            return;
        }
        String Crc64String = Utils.Crc64String(url);
        QLog.i(TAG, 1, "handleImgDownload fileName:" + Crc64String + ", url:" + url + ", type:" + type);
        File file = mImageCacheDir;
        if (file == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageCacheDir");
            file = null;
        }
        final File file2 = new File(file, Crc64String);
        if (file2.exists()) {
            QLog.i(TAG, 1, "handleImgDownload file exist: " + file2.getAbsolutePath());
            String absolutePath = file2.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "imgFile.absolutePath");
            onImgDownloaded(widgetData, absolutePath, type, index);
            return;
        }
        f fVar = new f() { // from class: com.tencent.mobileqq.minigame.metafarm.widget.MetaFarmWidgetUpdateManager$handleImgDownload$listener$1
            @Override // com.tencent.mobileqq.vip.f
            public void onDone(g task) {
                Intrinsics.checkNotNullParameter(task, "task");
                super.onDone(task);
                if (3 == task.i()) {
                    QLog.i("MetaFarmWidgetUpdateManager", 1, "handleImgDownload downloaed file path:" + file2.getAbsolutePath());
                    MetaFarmWidgetUpdateManager metaFarmWidgetUpdateManager = MetaFarmWidgetUpdateManager.INSTANCE;
                    MetaFarmWidgetData metaFarmWidgetData = widgetData;
                    String absolutePath2 = file2.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath2, "imgFile.absolutePath");
                    metaFarmWidgetUpdateManager.onImgDownloaded(metaFarmWidgetData, absolutePath2, type, index);
                    return;
                }
                QLog.w("MetaFarmWidgetUpdateManager", 1, "handleImgDownload download img failed~");
            }

            @Override // com.tencent.mobileqq.vip.f
            public boolean onStart(g task) {
                Intrinsics.checkNotNullParameter(task, "task");
                return super.onStart(task);
            }
        };
        g gVar = new g(url, file2);
        h downloader = ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).getDownloader(1);
        if (downloader != null) {
            downloader.startDownload(gVar, fVar, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void onImgDownloaded(MetaFarmWidgetData widgetData, String imgPath, int type, int index) {
        if (type == 1) {
            MetaFarmWidgetData.UserInfo userInfo = widgetData.getUserInfo();
            if (userInfo != null) {
                userInfo.setAvatarImgPath(imgPath);
            }
        } else if (type == 2) {
            MetaFarmWidgetData.UserInfo userInfo2 = widgetData.getUserInfo();
            if (userInfo2 != null) {
                userInfo2.setLevelIconImgPath(imgPath);
            }
        } else if (type == 3) {
            MetaFarmWidgetData.UserInfo userInfo3 = widgetData.getUserInfo();
            if (userInfo3 != null) {
                userInfo3.setCoinIconImgPath(imgPath);
            }
        } else if (type == 4) {
            widgetData.getCards().get(index).setIconImgPath(imgPath);
        }
        sendUpdateWidgetMessage(widgetData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onWidgetDataUpdate(MetaFarmWidgetData widgetData) {
        sendUpdateWidgetMessage(widgetData);
        downloadImg(widgetData);
    }

    private final void registerMetaFarmVAExitReceiver() {
        if (isVAExitReceiverRegistered) {
            return;
        }
        if (metaFarmVAExitReceiver == null) {
            metaFarmVAExitReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.minigame.metafarm.widget.MetaFarmWidgetUpdateManager$registerMetaFarmVAExitReceiver$1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    Bundle extras;
                    Object obj = (intent == null || (extras = intent.getExtras()) == null) ? null : extras.get("extra_package_name");
                    QLog.d("MetaFarmWidgetUpdateManager", 1, "MetaFarmVAExitReceiver onReceive action:" + (intent != null ? intent.getAction() : null) + ", pkgName:" + obj);
                    if (Intrinsics.areEqual("action_mini_box_process_exit", intent != null ? intent.getAction() : null) && Intrinsics.areEqual(obj, "com.tencent.letsgo")) {
                        MetaFarmWidgetUpdateManager.INSTANCE.requestUpdateWidget(2);
                    }
                }
            };
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_MINI_BOX_PROCESS_EXIT);
        MobileQQ.sMobileQQ.registerReceiver(metaFarmVAExitReceiver, intentFilter);
        QLog.e(TAG, 1, "registerMetaFarmVAExitReceiver");
        isVAExitReceiverRegistered = true;
    }

    private final void registerProviderUpdateReceiver() {
        if (isProviderReceiverRegistered) {
            return;
        }
        if (providerUpdateReceiver == null) {
            providerUpdateReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.minigame.metafarm.widget.MetaFarmWidgetUpdateManager$registerProviderUpdateReceiver$1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    QLog.d("MetaFarmWidgetUpdateManager", 1, "ProviderUpdateReceiver onReceive action:" + (intent != null ? intent.getAction() : null));
                    if (Intrinsics.areEqual(MetaFarmAppWidgetProvider.ACTION_PROVIDER_UPDATE_WIDGET, intent != null ? intent.getAction() : null)) {
                        MetaFarmWidgetUpdateManager metaFarmWidgetUpdateManager = MetaFarmWidgetUpdateManager.INSTANCE;
                        metaFarmWidgetUpdateManager.requestUpdateWidget(4);
                        metaFarmWidgetUpdateManager.unregisterProviderUpdateReceiver();
                    }
                }
            };
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MetaFarmAppWidgetProvider.ACTION_PROVIDER_UPDATE_WIDGET);
        MobileQQ.sMobileQQ.registerReceiver(providerUpdateReceiver, intentFilter);
        QLog.e(TAG, 1, "registerProviderUpdateReceiver");
        isProviderReceiverRegistered = true;
    }

    private final void sendWidgetRequest(int source) {
        boolean hasWidget = ((IMetaFarmWidgetApi) QRoute.api(IMetaFarmWidgetApi.class)).hasWidget();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        boolean isLogin = peekAppRuntime != null ? peekAppRuntime.isLogin() : false;
        QLog.d(TAG, 1, "sendWidgetRequest hasWidget:" + hasWidget + ", source:" + source + ", isLogin:" + isLogin);
        sendRequestUpdateMessage(120000L);
        if (hasWidget && isLogin) {
            registerMetaFarmVAExitReceiver();
            QLog.d(TAG, 1, "sendWidgetRequest");
            MetaFarmWidgetRequest metaFarmWidgetRequest = request;
            metaFarmWidgetRequest.setListener(new Function2<Boolean, MetaFarmWidgetData, Unit>() { // from class: com.tencent.mobileqq.minigame.metafarm.widget.MetaFarmWidgetUpdateManager$sendWidgetRequest$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, MetaFarmWidgetData metaFarmWidgetData) {
                    invoke(bool.booleanValue(), metaFarmWidgetData);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, MetaFarmWidgetData metaFarmWidgetData) {
                    long j3;
                    MetaFarmWidgetRequest metaFarmWidgetRequest2;
                    QLog.d("MetaFarmWidgetUpdateManager", 1, "sendWidgetRequest isSuccess:" + z16 + ", widgetData:" + metaFarmWidgetData);
                    if (!z16 || metaFarmWidgetData == null) {
                        j3 = 120000;
                    } else {
                        if (metaFarmWidgetData.getNextPullGapSecond() <= 0) {
                            metaFarmWidgetData.setNextPullGapSecond(120L);
                        }
                        j3 = metaFarmWidgetData.getNextPullGapSecond() * 1000;
                        MetaFarmWidgetUpdateManager.INSTANCE.onWidgetDataUpdate(metaFarmWidgetData);
                    }
                    MetaFarmWidgetUpdateManager.INSTANCE.sendRequestUpdateMessage(j3);
                    metaFarmWidgetRequest2 = MetaFarmWidgetUpdateManager.request;
                    metaFarmWidgetRequest2.setListener(null);
                }
            });
            metaFarmWidgetRequest.getWidgetData(source);
            return;
        }
        unregisterMetaFarmVAExitReceiver();
        if (isLogin) {
            return;
        }
        sendWidgetUpdateBroadcast(null, false);
    }

    private final void sendWidgetUpdateBroadcast(MetaFarmWidgetData widgetData, boolean isLogin) {
        QLog.d(TAG, 1, "sendWidgetUpdateBroadcast process:" + MobileQQ.sMobileQQ.getQQProcessName() + ", isLogin:" + isLogin);
        Context applicationContext = BaseApplication.getContext().getApplicationContext();
        Intent intent = new Intent();
        intent.setAction(MetaFarmAppWidgetProvider.ACTION_META_FARM_UPDATE);
        intent.putExtra(MetaFarmAppWidgetProvider.EXTRA_IS_LOGIN, isLogin);
        intent.putExtra(MetaFarmAppWidgetProvider.EXTRA_WIDGET_DATA, widgetData);
        intent.setPackage(BaseApplication.getContext().getPackageName());
        applicationContext.sendBroadcast(intent);
    }

    private final void unregisterMetaFarmVAExitReceiver() {
        if (metaFarmVAExitReceiver == null || !isVAExitReceiverRegistered) {
            return;
        }
        try {
            MobileQQ.sMobileQQ.unregisterReceiver(metaFarmVAExitReceiver);
            QLog.e(TAG, 1, "unregisterMetaFarmVAExitReceiver");
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "unregisterMetaFarmVAExitReceiver exception:", th5);
        }
        isVAExitReceiverRegistered = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void unregisterProviderUpdateReceiver() {
        if (providerUpdateReceiver == null || !isProviderReceiverRegistered) {
            return;
        }
        try {
            MobileQQ.sMobileQQ.unregisterReceiver(providerUpdateReceiver);
            QLog.e(TAG, 1, "unregisterProviderUpdateReceiver");
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "unregisterProviderUpdateReceiver exception:", th5);
        }
        isProviderReceiverRegistered = false;
    }

    public final void clearImgCache() {
        try {
            File file = mImageCacheDir;
            File file2 = null;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mImageCacheDir");
                file = null;
            }
            if (file.exists()) {
                File file3 = mImageCacheDir;
                if (file3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mImageCacheDir");
                } else {
                    file2 = file3;
                }
                FileUtils.deleteFilesInDirectory(file2.getAbsolutePath());
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "clearImgCache error:", th5);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        int i3 = msg2.what;
        if (i3 == 16) {
            sendWidgetRequest(3);
        } else if (i3 == 17) {
            Object obj = msg2.obj;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.minigame.metafarm.widget.MetaFarmWidgetData");
            sendWidgetUpdateBroadcast((MetaFarmWidgetData) obj, true);
        }
        return true;
    }

    public final void requestUpdateWidget(int source) {
        QLog.d(TAG, 1, "requestUpdateWidget source:" + source);
        try {
            mMainHandler.removeCallbacksAndMessages(null);
            mMainHandler.removeMessages(0);
            registerMetaFarmVAExitReceiver();
            registerProviderUpdateReceiver();
            sendWidgetRequest(source);
        } catch (Exception e16) {
            QLog.d(TAG, 1, "requestUpdateWidget exception:" + e16);
        }
    }

    public final synchronized void sendUpdateWidgetMessage(MetaFarmWidgetData widgetData) {
        Intrinsics.checkNotNullParameter(widgetData, "widgetData");
        mMainHandler.removeMessages(17);
        Message obtainMessage = mMainHandler.obtainMessage(17);
        Intrinsics.checkNotNullExpressionValue(obtainMessage, "mMainHandler.obtainMessa\u2026SG_SEND_UPDATE_BROADCAST)");
        obtainMessage.obj = widgetData;
        mMainHandler.sendMessageDelayed(obtainMessage, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendRequestUpdateMessage(long delay) {
        QLog.d(TAG, 1, "sendRequestUpdateMessage");
        mMainHandler.removeMessages(16);
        WeakReferenceHandler weakReferenceHandler = mMainHandler;
        weakReferenceHandler.sendMessageDelayed(weakReferenceHandler.obtainMessage(16), delay);
    }

    static /* synthetic */ void handleImgDownload$default(MetaFarmWidgetUpdateManager metaFarmWidgetUpdateManager, MetaFarmWidgetData metaFarmWidgetData, String str, int i3, int i16, int i17, Object obj) {
        if ((i17 & 8) != 0) {
            i16 = 0;
        }
        metaFarmWidgetUpdateManager.handleImgDownload(metaFarmWidgetData, str, i3, i16);
    }

    static /* synthetic */ void onImgDownloaded$default(MetaFarmWidgetUpdateManager metaFarmWidgetUpdateManager, MetaFarmWidgetData metaFarmWidgetData, String str, int i3, int i16, int i17, Object obj) {
        if ((i17 & 8) != 0) {
            i16 = 0;
        }
        metaFarmWidgetUpdateManager.onImgDownloaded(metaFarmWidgetData, str, i3, i16);
    }

    static /* synthetic */ void sendWidgetUpdateBroadcast$default(MetaFarmWidgetUpdateManager metaFarmWidgetUpdateManager, MetaFarmWidgetData metaFarmWidgetData, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        metaFarmWidgetUpdateManager.sendWidgetUpdateBroadcast(metaFarmWidgetData, z16);
    }
}
