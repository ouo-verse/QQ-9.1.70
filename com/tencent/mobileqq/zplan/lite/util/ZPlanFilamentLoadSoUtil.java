package com.tencent.mobileqq.zplan.lite.util;

import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.zplan.lite.IZPlanFilamentLoadSoUtil;
import com.tencent.mobileqq.zplan.lite.util.ZPlanFilamentLoadSoUtil;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.qphone.base.util.QLog;
import gl0.b;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import t74.l;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0003J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/zplan/lite/util/ZPlanFilamentLoadSoUtil;", "Lcom/tencent/mobileqq/zplan/lite/IZPlanFilamentLoadSoUtil;", "Lgl0/b;", "listener", "", "downloadFilamentSoByAE", "downloadFilamentSoByManager", "", "downloadSo", "loadFilamentSoByAERes", "loadFilamentSoByManager", "downloadAndLoadSo", "downloadAndLoadSoReal", "loadSoIfReady", "", "TAG", "Ljava/lang/String;", "FILAMENT_SO_NAME", "enableSoManager", "Z", "", "lastLogTimeMillis", "J", "", "LOG_THROTTLE_MS", "I", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanFilamentLoadSoUtil implements IZPlanFilamentLoadSoUtil {
    private static final String FILAMENT_SO_NAME = "ace_zplan";
    private static final int LOG_THROTTLE_MS = 60000;
    public static final String TAG = "ZPlanFilamentLoadSoUtil";
    private static long lastLogTimeMillis;
    public static final ZPlanFilamentLoadSoUtil INSTANCE = new ZPlanFilamentLoadSoUtil();
    private static final boolean enableSoManager = ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).enableFilamentUseSomanager();

    ZPlanFilamentLoadSoUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void downloadAndLoadSo$lambda$0(gl0.b listener) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        INSTANCE.downloadAndLoadSoReal(listener);
    }

    private final void downloadFilamentSoByAE(gl0.b listener) {
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(AEResInfo.AGENT_TYPE_FILAMENT, new a(listener));
    }

    private final void downloadFilamentSoByManager(final gl0.b listener) {
        SoLoadManager.getInstance().download(FILAMENT_SO_NAME, new OnLoadListener() { // from class: com.tencent.mobileqq.zplan.lite.util.b
            @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
            public final void onLoadResult(int i3, LoadExtResult loadExtResult) {
                ZPlanFilamentLoadSoUtil.downloadFilamentSoByManager$lambda$2(gl0.b.this, i3, loadExtResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void downloadFilamentSoByManager$lambda$2(final gl0.b listener, int i3, LoadExtResult loadExtResult) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        if (i3 == 0) {
            QLog.i(TAG, 1, "downloadFilamentSoByManager, onLoadResult success");
            l.f435563a.f(new Runnable() { // from class: com.tencent.mobileqq.zplan.lite.util.a
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanFilamentLoadSoUtil.downloadFilamentSoByManager$lambda$2$lambda$1(gl0.b.this);
                }
            });
            return;
        }
        QLog.i(TAG, 1, "downloadFilamentSoByManager, onLoadResult fail, " + i3 + ", " + (loadExtResult != null ? loadExtResult.getReportStr() : null));
        listener.a(false, true, i3, loadExtResult != null ? loadExtResult.getReportStr() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void downloadFilamentSoByManager$lambda$2$lambda$1(gl0.b listener) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        INSTANCE.loadFilamentSoByManager(listener, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadFilamentSoByAERes(gl0.b listener, boolean downloadSo) {
        Object m476constructorimpl;
        String aEResUnzipFinalPath = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getAEResUnzipFinalPath(AEResInfo.AGENT_TYPE_FILAMENT);
        QLog.i(TAG, 1, "loadFilamentSoByAERes dir : " + aEResUnzipFinalPath);
        if (aEResUnzipFinalPath == null || aEResUnzipFinalPath.length() == 0) {
            return;
        }
        String str = aEResUnzipFinalPath + AECameraConstants.FILAMENT_NAME;
        if (new File(str).exists()) {
            QLog.i(TAG, 1, "loadFilamentSoByAERes soPath: " + str);
            try {
                Result.Companion companion = Result.INSTANCE;
                System.load(str);
                m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            if (Result.m483isSuccessimpl(m476constructorimpl)) {
                QLog.i(TAG, 1, "loadFilamentSoByAERes success");
                b.a.a(listener, true, downloadSo, 0, null, 8, null);
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                QLog.i(TAG, 1, "loadFilamentSoByAERes fail : " + m479exceptionOrNullimpl);
                listener.a(false, downloadSo, -1, "System.load error, " + m479exceptionOrNullimpl.getMessage());
            }
        }
    }

    private final void loadFilamentSoByManager(gl0.b listener, boolean downloadSo) {
        LoadExtResult loadSync = SoLoadManager.getInstance().loadSync(FILAMENT_SO_NAME);
        if (loadSync.isSucc()) {
            QLog.i(TAG, 1, "loadFilamentSoByManager success");
            b.a.a(listener, true, downloadSo, 0, null, 8, null);
            return;
        }
        QLog.i(TAG, 1, "loadFilamentSoByManager fail : " + loadSync.getReportCode() + ", " + loadSync.getReportStr());
        listener.a(false, downloadSo, loadSync.getReportCode(), loadSync.getReportStr());
    }

    @Override // com.tencent.mobileqq.zplan.lite.IZPlanFilamentLoadSoUtil
    public void downloadAndLoadSo(final gl0.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.lite.util.c
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanFilamentLoadSoUtil.downloadAndLoadSo$lambda$0(gl0.b.this);
            }
        }, 16, null, true);
    }

    public final void downloadAndLoadSoReal(gl0.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        boolean z16 = enableSoManager;
        QLog.i(TAG, 1, "downloadAndLoadSo, enableSoManager:" + z16);
        if (z16) {
            boolean isExist = SoLoadManager.getInstance().isExist(FILAMENT_SO_NAME);
            QLog.i(TAG, 1, "soReady:" + isExist);
            if (!isExist) {
                downloadFilamentSoByManager(listener);
                return;
            } else {
                loadFilamentSoByManager$default(this, listener, false, 2, null);
                return;
            }
        }
        boolean isAEResExist = ((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.AGENT_TYPE_FILAMENT);
        QLog.i(TAG, 1, "soReady:" + isAEResExist);
        if (!isAEResExist) {
            downloadFilamentSoByAE(listener);
        } else {
            loadFilamentSoByAERes$default(this, listener, false, 2, null);
        }
    }

    public final boolean loadSoIfReady(gl0.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (enableSoManager) {
            if (SoLoadManager.getInstance().isExist(FILAMENT_SO_NAME)) {
                loadFilamentSoByManager$default(this, listener, false, 2, null);
                return true;
            }
        } else if (((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.AGENT_TYPE_FILAMENT)) {
            loadFilamentSoByAERes$default(this, listener, false, 2, null);
            return true;
        }
        return false;
    }

    static /* synthetic */ void loadFilamentSoByAERes$default(ZPlanFilamentLoadSoUtil zPlanFilamentLoadSoUtil, gl0.b bVar, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        zPlanFilamentLoadSoUtil.loadFilamentSoByAERes(bVar, z16);
    }

    static /* synthetic */ void loadFilamentSoByManager$default(ZPlanFilamentLoadSoUtil zPlanFilamentLoadSoUtil, gl0.b bVar, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        zPlanFilamentLoadSoUtil.loadFilamentSoByManager(bVar, z16);
    }

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\"\u0010\u000f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/zplan/lite/util/ZPlanFilamentLoadSoUtil$a", "Lcom/tencent/aelight/camera/download/api/a;", "Lcom/tencent/aelight/camera/download/api/AEResInfo;", "aeResInfo", "", "localFilePath", "", "downloaded", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "", "onAEDownloadFinish", "", "currentOffset", "totalLength", "onAEProgressUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements com.tencent.aelight.camera.download.api.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ gl0.b f333801d;

        a(gl0.b bVar) {
            this.f333801d = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(gl0.b listener) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            ZPlanFilamentLoadSoUtil.INSTANCE.loadFilamentSoByAERes(listener, true);
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEDownloadFinish(AEResInfo aeResInfo, String localFilePath, boolean downloaded, int errorType) {
            if (Intrinsics.areEqual(aeResInfo != null ? aeResInfo.agentType : null, AEResInfo.AGENT_TYPE_FILAMENT)) {
                if (errorType != 0 && errorType != 1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ZPlanFilamentLoadSoUtil.lastLogTimeMillis > 60000) {
                        QLog.i(ZPlanFilamentLoadSoUtil.TAG, 1, "downloadFilamentSoByAE fail, aeResInfo: " + aeResInfo + ", localFilePath: " + localFilePath + ", downloaded: " + downloaded + ", errorType: " + errorType);
                        ZPlanFilamentLoadSoUtil.lastLogTimeMillis = currentTimeMillis;
                    }
                    b.a.a(this.f333801d, false, true, errorType, null, 8, null);
                    return;
                }
                QLog.i(ZPlanFilamentLoadSoUtil.TAG, 1, "onAEDownloadFinish, localFilePath: " + localFilePath + ", downloaded: " + downloaded + ", errorType: " + errorType);
                l lVar = l.f435563a;
                final gl0.b bVar = this.f333801d;
                lVar.f(new Runnable() { // from class: com.tencent.mobileqq.zplan.lite.util.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZPlanFilamentLoadSoUtil.a.b(gl0.b.this);
                    }
                });
            }
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEProgressUpdate(AEResInfo aeResInfo, long currentOffset, long totalLength) {
        }
    }
}
