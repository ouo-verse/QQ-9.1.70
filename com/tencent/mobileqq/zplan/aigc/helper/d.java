package com.tencent.mobileqq.zplan.aigc.helper;

import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.zplan.aigc.helper.d;
import com.tencent.qphone.base.util.QLog;
import gl0.b;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010\t\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/helper/d;", "", "Lgl0/b;", "listener", "", "c", "b", "", "downloadSo", "d", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class d {
    /* JADX INFO: Access modifiers changed from: private */
    public final void c(gl0.b listener) {
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(AEResInfo.AGENT_TYPE_PAG, new c(listener, this));
    }

    public final void b(gl0.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(AEResInfo.AGENT_TYPE_LIGHT_SDK_BASE, new b(listener));
    }

    public final boolean d(gl0.b listener, boolean downloadSo) {
        Object m476constructorimpl;
        String aEResUnzipFinalPath = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getAEResUnzipFinalPath(AEResInfo.AGENT_TYPE_LIGHT_SDK_BASE);
        String aEResUnzipFinalPath2 = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getAEResUnzipFinalPath(AEResInfo.AGENT_TYPE_PAG);
        QLog.i("DownloadLightSDKHelper", 1, "loadLightSdkSoByAERes dir : " + aEResUnzipFinalPath);
        if (aEResUnzipFinalPath == null || aEResUnzipFinalPath.length() == 0) {
            return false;
        }
        if (aEResUnzipFinalPath2 == null || aEResUnzipFinalPath2.length() == 0) {
            return false;
        }
        String str = aEResUnzipFinalPath + AECameraConstants.LIB_LIGHT;
        if (!new File(str).exists()) {
            return false;
        }
        String str2 = aEResUnzipFinalPath2 + AECameraConstants.LIB_PAG;
        if (!new File(str2).exists()) {
            return false;
        }
        QLog.i("DownloadLightSDKHelper", 1, "loadLightSdkSoByAERes soPath: " + str);
        try {
            Result.Companion companion = Result.INSTANCE;
            System.load(str2);
            System.load(str);
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m483isSuccessimpl(m476constructorimpl)) {
            QLog.i("DownloadLightSDKHelper", 1, "loadLightSdkSoByAERes success");
            if (listener != null) {
                b.a.a(listener, true, downloadSo, 0, null, 8, null);
            }
            return true;
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            QLog.i("DownloadLightSDKHelper", 1, "loadLightSdkSoByAERes fail : " + m479exceptionOrNullimpl);
            if (listener != null) {
                listener.a(false, downloadSo, -1, "System.load error, " + m479exceptionOrNullimpl.getMessage());
            }
        }
        return false;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\"\u0010\u000f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/zplan/aigc/helper/d$b", "Lcom/tencent/aelight/camera/download/api/a;", "Lcom/tencent/aelight/camera/download/api/AEResInfo;", "aeResInfo", "", "localFilePath", "", "downloaded", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "", "onAEDownloadFinish", "", "currentOffset", "totalLength", "onAEProgressUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.aelight.camera.download.api.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ gl0.b f330310e;

        b(gl0.b bVar) {
            this.f330310e = bVar;
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEDownloadFinish(AEResInfo aeResInfo, String localFilePath, boolean downloaded, int errorType) {
            if (Intrinsics.areEqual(aeResInfo != null ? aeResInfo.agentType : null, AEResInfo.AGENT_TYPE_LIGHT_SDK_BASE)) {
                if (errorType != 0 && errorType != 1) {
                    QLog.i("DownloadLightSDKHelper", 1, "downloadLightSoByAE fail, aeResInfo: " + aeResInfo + ", localFilePath: " + localFilePath + ", downloaded: " + downloaded + ", errorType: " + errorType);
                    b.a.a(this.f330310e, false, true, errorType, null, 8, null);
                } else {
                    QLog.i("DownloadLightSDKHelper", 1, "onAEDownloadFinish, localFilePath: " + localFilePath + ", downloaded: " + downloaded + ", errorType: " + errorType);
                    d.this.c(this.f330310e);
                }
                ((IAEResUtil) QRoute.api(IAEResUtil.class)).removeAEDownloadCallBack(this);
            }
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEProgressUpdate(AEResInfo aeResInfo, long currentOffset, long totalLength) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\"\u0010\u000f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/zplan/aigc/helper/d$c", "Lcom/tencent/aelight/camera/download/api/a;", "Lcom/tencent/aelight/camera/download/api/AEResInfo;", "aeResInfo", "", "localFilePath", "", "downloaded", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "", "onAEDownloadFinish", "", "currentOffset", "totalLength", "onAEProgressUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.aelight.camera.download.api.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ gl0.b f330311d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f330312e;

        c(gl0.b bVar, d dVar) {
            this.f330311d = bVar;
            this.f330312e = dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(d this$0, gl0.b listener) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(listener, "$listener");
            this$0.d(listener, true);
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEDownloadFinish(AEResInfo aeResInfo, String localFilePath, boolean downloaded, int errorType) {
            if (Intrinsics.areEqual(aeResInfo != null ? aeResInfo.agentType : null, AEResInfo.AGENT_TYPE_PAG)) {
                if (errorType != 0 && errorType != 1) {
                    QLog.i("DownloadLightSDKHelper", 1, "downloadPagSoByAE fail, aeResInfo: " + aeResInfo + ", localFilePath: " + localFilePath + ", downloaded: " + downloaded + ", errorType: " + errorType);
                    b.a.a(this.f330311d, false, true, errorType, null, 8, null);
                } else {
                    QLog.i("DownloadLightSDKHelper", 1, "onAEDownloadFinish, localFilePath: " + localFilePath + ", downloaded: " + downloaded + ", errorType: " + errorType);
                    t74.l lVar = t74.l.f435563a;
                    final d dVar = this.f330312e;
                    final gl0.b bVar = this.f330311d;
                    lVar.f(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.helper.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            d.c.b(d.this, bVar);
                        }
                    });
                }
                ((IAEResUtil) QRoute.api(IAEResUtil.class)).removeAEDownloadCallBack(this);
            }
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEProgressUpdate(AEResInfo aeResInfo, long currentOffset, long totalLength) {
        }
    }
}
