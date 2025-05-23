package com.tencent.qqmini.minigame.gpkg;

import android.os.Bundle;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqmini.minigame.report.MiniGameBeaconReport;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.ipc.GamePkgIPCConst;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.raft.measure.utils.MeasureConst;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0002\u0007\u0005B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0017\u0010\r\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0007\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqmini/minigame/gpkg/e;", "", "Lcom/tencent/qqmini/minigame/gpkg/g;", "listener", "", "b", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "a", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "miniAppInfo", "Lcom/tencent/qqmini/minigame/gpkg/SubPkgInfoWrapper;", "Lcom/tencent/qqmini/minigame/gpkg/SubPkgInfoWrapper;", "()Lcom/tencent/qqmini/minigame/gpkg/SubPkgInfoWrapper;", "subPkgInfoWrapper", "<init>", "(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;Lcom/tencent/qqmini/minigame/gpkg/SubPkgInfoWrapper;)V", "c", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final MiniAppInfo miniAppInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SubPkgInfoWrapper subPkgInfoWrapper;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0002R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqmini/minigame/gpkg/e$a;", "", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "appInfo", "Lcom/tencent/qqmini/minigame/gpkg/SubPkgInfoWrapper;", "subPkgInfo", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_IS_DOWNLOADED, "", "startLoadTime", "isSuccess", "", "b", "", "KEY_SUBPACKAGE_REPORT", "Ljava/lang/String;", "TAG", "<init>", "()V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.qqmini.minigame.gpkg.e$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(MiniAppInfo appInfo, SubPkgInfoWrapper subPkgInfo, boolean isDownloaded, long startLoadTime, boolean isSuccess) {
            Object obj;
            Map mutableMapOf;
            Pair[] pairArr = new Pair[6];
            pairArr[0] = TuplesKt.to("appId", appInfo.appId);
            pairArr[1] = TuplesKt.to("subPkgName", subPkgInfo.a());
            String str = "1";
            if (isDownloaded) {
                obj = "1";
            } else {
                obj = "0";
            }
            pairArr[2] = TuplesKt.to(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_IS_DOWNLOADED, obj);
            pairArr[3] = TuplesKt.to("costTime", String.valueOf(System.currentTimeMillis() - startLoadTime));
            if (!isSuccess) {
                str = "0";
            }
            pairArr[4] = TuplesKt.to("loadState", str);
            pairArr[5] = TuplesKt.to(StartupReportKey.PLATFORM_ID, "0");
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
            MiniGameBeaconReport.report("minigame_subpackage_load", mutableMapOf);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\nR\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqmini/minigame/gpkg/e$b;", "Lcom/tencent/qqmini/sdk/launcher/ipc/MiniCmdCallback$Stub;", "", MeasureConst.SLI_TYPE_SUCCESS, "Landroid/os/Bundle;", "bundle", "", "onCmdResult", "", "d", "J", "startTime", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "e", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "appInfo", "Lcom/tencent/qqmini/minigame/gpkg/SubPkgInfoWrapper;", "f", "Lcom/tencent/qqmini/minigame/gpkg/SubPkgInfoWrapper;", "subPkgInfo", h.F, "startLoadTime", "Lcom/tencent/qqmini/minigame/gpkg/g;", "i", "Lcom/tencent/qqmini/minigame/gpkg/g;", "listener", "<init>", "(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;Lcom/tencent/qqmini/minigame/gpkg/SubPkgInfoWrapper;JLcom/tencent/qqmini/minigame/gpkg/g;)V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes23.dex */
    public static final class b extends MiniCmdCallback.Stub {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long startTime;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final MiniAppInfo appInfo;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final SubPkgInfoWrapper subPkgInfo;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final long startLoadTime;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final g listener;

        public b(@NotNull MiniAppInfo appInfo, @NotNull SubPkgInfoWrapper subPkgInfo, long j3, @NotNull g listener) {
            Intrinsics.checkParameterIsNotNull(appInfo, "appInfo");
            Intrinsics.checkParameterIsNotNull(subPkgInfo, "subPkgInfo");
            Intrinsics.checkParameterIsNotNull(listener, "listener");
            this.appInfo = appInfo;
            this.subPkgInfo = subPkgInfo;
            this.startLoadTime = j3;
            this.listener = listener;
            this.startTime = System.currentTimeMillis();
        }

        @Override // com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback
        public void onCmdResult(boolean succ, @Nullable Bundle bundle) {
            if (succ && bundle != null) {
                int i3 = bundle.getInt(GamePkgIPCConst.KEY_CMD, -1);
                if (i3 == 1) {
                    this.listener.onProgress(bundle.getFloat(GamePkgIPCConst.KEY_PROGRESS), bundle.getLong(GamePkgIPCConst.KEY_TOTAL_FILE_SIZE));
                    return;
                }
                if (i3 == 2) {
                    String errorMsg = bundle.getString(GamePkgIPCConst.KEY_ERROR_MSG, "unknown");
                    e.INSTANCE.b(this.appInfo, this.subPkgInfo, false, this.startLoadTime, false);
                    g gVar = this.listener;
                    Intrinsics.checkExpressionValueIsNotNull(errorMsg, "errorMsg");
                    gVar.onFail(errorMsg);
                    return;
                }
                if (i3 == 3) {
                    QMLog.i("GameSubPkgLoader", "onCmdResult: load cost=" + (System.currentTimeMillis() - this.startTime));
                    String path = bundle.getString(GamePkgIPCConst.KEY_SUB_PKG_PATH, "");
                    e.INSTANCE.b(this.appInfo, this.subPkgInfo, false, this.startLoadTime, true);
                    g gVar2 = this.listener;
                    Intrinsics.checkExpressionValueIsNotNull(path, "path");
                    gVar2.onSuccess(path);
                    return;
                }
                QMLog.e("GameSubPkgLoader", "not support cmd=" + i3);
                return;
            }
            this.listener.onFail("IPC call fail");
        }
    }

    public e(@NotNull MiniAppInfo miniAppInfo, @NotNull SubPkgInfoWrapper subPkgInfoWrapper) {
        Intrinsics.checkParameterIsNotNull(miniAppInfo, "miniAppInfo");
        Intrinsics.checkParameterIsNotNull(subPkgInfoWrapper, "subPkgInfoWrapper");
        this.miniAppInfo = miniAppInfo;
        this.subPkgInfoWrapper = subPkgInfoWrapper;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final SubPkgInfoWrapper getSubPkgInfoWrapper() {
        return this.subPkgInfoWrapper;
    }

    public final void b(@NotNull g listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(this.subPkgInfoWrapper.getSavePath(), this.subPkgInfoWrapper.getRoot());
        if (c.h(file)) {
            QMLog.i("GameSubPkgLoader", "load: " + this.subPkgInfoWrapper.a() + " exists.");
            INSTANCE.b(this.miniAppInfo, this.subPkgInfoWrapper, true, currentTimeMillis, true);
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkExpressionValueIsNotNull(absolutePath, "subPkgDir.absolutePath");
            listener.onSuccess(absolutePath);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(GamePkgIPCConst.KEY_GAME_CONFIG, this.miniAppInfo);
        bundle.putParcelable(GamePkgIPCConst.KEY_GAME_SUB_PKG_INFO, this.subPkgInfoWrapper.getSubPkgInfo());
        bundle.putString(GamePkgIPCConst.KEY_GAME_SUB_PKG_ROOT, this.subPkgInfoWrapper.getRoot());
        AppBrandCmdProxy.g().sendCmd(IPCConst.CMD_DOWNLOAD_GAME_SUB_PKG, bundle, new b(this.miniAppInfo, this.subPkgInfoWrapper, currentTimeMillis, listener));
    }
}
