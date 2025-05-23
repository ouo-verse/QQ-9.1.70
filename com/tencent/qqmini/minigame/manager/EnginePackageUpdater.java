package com.tencent.qqmini.minigame.manager;

import android.os.Bundle;
import android.os.SystemClock;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qqmini.minigame.helper.d;
import com.tencent.qqmini.minigame.utils.TritonEngineUtil;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.ZipUtil;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J(\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqmini/minigame/manager/EnginePackageUpdater;", "", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "appInfo", "", "f", "", "appId", "e", "Lju3/a;", DownloadInfo.spKey_Config, "Lcom/tencent/qqmini/minigame/manager/EnginePackageUpdater$a;", "listener", "i", "Ljava/io/File;", "tempSaveDir", "downloadedFile", h.F, "", "newTimestamp", "g", "Ljava/util/concurrent/atomic/AtomicBoolean;", "a", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInUpdate", "b", "J", WadlProxyConsts.LAST_UPDATE_TIME, "<init>", "()V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class EnginePackageUpdater {

    /* renamed from: c, reason: collision with root package name */
    public static final EnginePackageUpdater f346498c = new EnginePackageUpdater();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final AtomicBoolean isInUpdate = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long lastUpdateTime = -1;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqmini/minigame/manager/EnginePackageUpdater$a;", "", "", "errorMsg", "", "onFail", "onSuccess", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes23.dex */
    public interface a {
        void onFail(@NotNull String errorMsg);

        void onSuccess();
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqmini/minigame/manager/EnginePackageUpdater$b", "Lcom/tencent/qqmini/minigame/manager/EnginePackageUpdater$a;", "", "errorMsg", "", "onFail", "onSuccess", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes23.dex */
    public static final class b implements a {
        b() {
        }

        @Override // com.tencent.qqmini.minigame.manager.EnginePackageUpdater.a
        public void onFail(@NotNull String errorMsg) {
            Intrinsics.checkParameterIsNotNull(errorMsg, "errorMsg");
            EnginePackageUpdater.b(EnginePackageUpdater.f346498c).set(false);
            EnginePackageUpdater.lastUpdateTime = SystemClock.uptimeMillis();
            QMLog.e("GameEngineUpdater", "[updateFailed]: " + errorMsg);
        }

        @Override // com.tencent.qqmini.minigame.manager.EnginePackageUpdater.a
        public void onSuccess() {
            EnginePackageUpdater.b(EnginePackageUpdater.f346498c).set(false);
            EnginePackageUpdater.lastUpdateTime = SystemClock.uptimeMillis();
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/qqmini/minigame/manager/EnginePackageUpdater$c", "Lcom/tencent/qqmini/minigame/helper/d;", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "filePath", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener$DownloadResult;", "result", "", "onDownloadSucceed", "errorMsg", "onDownloadFailed", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes23.dex */
    public static final class c extends d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f346499a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ File f346500b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ju3.a f346501c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f346502d;

        c(File file, File file2, ju3.a aVar, a aVar2) {
            this.f346499a = file;
            this.f346500b = file2;
            this.f346501c = aVar;
            this.f346502d = aVar2;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
        public void onDownloadFailed(int statusCode, @Nullable String errorMsg) {
            this.f346502d.onFail("download failed, statusCode=" + statusCode + ", errorMsg=" + errorMsg);
            FileUtils.deleteDirectory(this.f346499a.getAbsolutePath());
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
        public void onDownloadSucceed(int statusCode, @Nullable String filePath, @Nullable DownloaderProxy.DownloadListener.DownloadResult result) {
            TritonEngineUtil.f346833b.c("\u65b0\u5f15\u64ce\u4e0b\u8f7d\u5b8c\u6210\u3002");
            EnginePackageUpdater.f346498c.h(this.f346499a, this.f346500b, this.f346501c, this.f346502d);
            FileUtils.deleteDirectory(this.f346499a.getAbsolutePath());
        }
    }

    EnginePackageUpdater() {
    }

    public static final /* synthetic */ AtomicBoolean b(EnginePackageUpdater enginePackageUpdater) {
        return isInUpdate;
    }

    @JvmStatic
    public static final void e(@NotNull String appId) {
        Intrinsics.checkParameterIsNotNull(appId, "appId");
        if (SystemClock.uptimeMillis() - lastUpdateTime < 300000) {
            QMLog.d("GameEngineUpdater", "checkUpdate: do not need update.");
            return;
        }
        AtomicBoolean atomicBoolean = isInUpdate;
        if (atomicBoolean.get()) {
            QMLog.d("GameEngineUpdater", "checkUpdate: is updating.");
            return;
        }
        atomicBoolean.set(true);
        ju3.a a16 = EnginePackageUtil.f346509e.a();
        b bVar = new b();
        if (a16 != null && a16.a(appId)) {
            f346498c.i(a16, bVar);
        } else {
            EnginePackageManager.checkTritonUpdate(bVar);
        }
    }

    @JvmStatic
    public static final void f(@Nullable final MiniAppInfo appInfo) {
        if (appInfo == null) {
            return;
        }
        ThreadManager.runIOTask(new Runnable() { // from class: com.tencent.qqmini.minigame.manager.EnginePackageUpdater$checkUpdateInMainProcess$1
            @Override // java.lang.Runnable
            public final void run() {
                Bundle bundle = new Bundle();
                bundle.putParcelable("key_mini_app_config", MiniAppInfo.this);
                AppBrandCmdProxy.g().sendCmd("cmd_update_triton_engine", bundle, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(long newTimestamp) {
        File[] listFiles;
        Long longOrNull;
        Long longOrNull2;
        try {
            File d16 = EnginePackageUtil.f346509e.d();
            if (!d16.exists() || (listFiles = d16.listFiles()) == null || listFiles.length < 2) {
                return;
            }
            ArrayList<File> arrayList = new ArrayList();
            long j3 = 0;
            for (File child : listFiles) {
                Intrinsics.checkExpressionValueIsNotNull(child, "child");
                String name = child.getName();
                Intrinsics.checkExpressionValueIsNotNull(name, "child.name");
                longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(name);
                if (longOrNull2 != null) {
                    long longValue = longOrNull2.longValue();
                    if (longValue < newTimestamp) {
                        arrayList.add(child);
                    }
                    if (longValue > j3) {
                        j3 = longValue;
                    }
                }
            }
            for (File file : arrayList) {
                String name2 = file.getName();
                Intrinsics.checkExpressionValueIsNotNull(name2, "it.name");
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(name2);
                if (longOrNull != null && longOrNull.longValue() == j3) {
                }
                FileUtils.deleteDirectory(file.getAbsolutePath());
                QMLog.i("GameEngineUpdater", "deleteOldEnginePackage: delete filePath=" + file.getAbsolutePath());
            }
        } catch (IOException e16) {
            QMLog.e("GameEngineUpdater", "deleteOldEnginePackage: failed.", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(File tempSaveDir, File downloadedFile, final ju3.a config, a listener) {
        try {
            if (!downloadedFile.exists()) {
                listener.onFail("download success, but file not exist. file=" + downloadedFile);
                return;
            }
            File file = new File(tempSaveDir, "unZip_" + System.nanoTime());
            ZipUtil.unZipFolder(downloadedFile.getAbsolutePath(), file.getAbsolutePath());
            if (!config.g(file)) {
                listener.onFail("unZipped file list not match verify file list");
                return;
            }
            File d16 = EnginePackageUtil.f346509e.d();
            if (!d16.exists()) {
                d16.mkdirs();
            }
            if (file.renameTo(config.d())) {
                QMLog.i("GameEngineUpdater", "update success, jsLibVersion=" + config.getJsLibVersion() + ", tritonVersion=" + config.getTritonVersion());
                listener.onSuccess();
                ThreadManager.runIOTask(new Runnable() { // from class: com.tencent.qqmini.minigame.manager.EnginePackageUpdater$onDownloadSuccess$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        EnginePackageUpdater.f346498c.g(ju3.a.this.getTimestamp());
                    }
                });
                return;
            }
            listener.onFail("rename failed, source=" + file.getAbsolutePath() + ", target=" + config.d().getAbsolutePath());
        } catch (IOException e16) {
            listener.onFail("write engine files failed, reason=" + e16.getMessage());
        }
    }

    private final void i(ju3.a config, a listener) {
        if (config.g(config.d())) {
            QMLog.i("GameEngineUpdater", "updateByConfig: already install this version.");
            listener.onSuccess();
            return;
        }
        File file = new File(EnginePackageUtil.f346509e.c(), String.valueOf(config.getTimestamp()));
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, System.nanoTime() + ".zip");
        if (file2.exists()) {
            file2.delete();
        }
        c cVar = new c(file, file2, config, listener);
        TritonEngineUtil.f346833b.c("\u89e6\u53d1\u65b0\u5f15\u64ce\u4e0b\u8f7d\u3002");
        ((DownloaderProxy) ProxyManager.get(DownloaderProxy.class)).download(config.getDownloadUrl(), null, file2.getAbsolutePath(), 60, cVar);
    }
}
