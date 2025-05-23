package ik2;

import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResDownload;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lik2/a;", "", "", "a", "Lik2/a$a;", "cb", "", "b", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f407903a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\n"}, d2 = {"Lik2/a$a;", "", "", "soDir", "", "a", "", "errCode", "errMsg", "error", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ik2.a$a, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public interface InterfaceC10536a {
        void a(@NotNull String soDir);

        void error(int errCode, @Nullable String errMsg);
    }

    a() {
    }

    private final boolean a() {
        if (((IAEResDownload) QRoute.api(IAEResDownload.class)).getResPackageStatus(AEResInfo.LIGHT_RES_BASE_PACKAGE) != 4) {
            return true;
        }
        return false;
    }

    public final void b(@NotNull InterfaceC10536a cb5) {
        boolean z16;
        Intrinsics.checkNotNullParameter(cb5, "cb");
        boolean a16 = a();
        String currentSoDir = FeatureManager.getSoDir();
        if (!a16) {
            if (currentSoDir != null && currentSoDir.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                QLog.i("AEResInitManager_", 1, "tryInit currentSoDir god:" + currentSoDir);
                Intrinsics.checkNotNullExpressionValue(currentSoDir, "currentSoDir");
                cb5.a(currentSoDir);
                return;
            }
        }
        ((IAEResDownload) QRoute.api(IAEResDownload.class)).requestDownload(AEResInfo.LIGHT_RES_BASE_PACKAGE, new b(cb5), false);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\"\u0010\u000f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016\u00a8\u0006\u0010"}, d2 = {"ik2/a$b", "Lcom/tencent/aelight/camera/download/api/a;", "Lcom/tencent/aelight/camera/download/api/AEResInfo;", "aeResInfo", "", "localFilePath", "", "downloaded", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "", "onAEDownloadFinish", "", "currentOffset", "totalLength", "onAEProgressUpdate", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements com.tencent.aelight.camera.download.api.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ InterfaceC10536a f407904d;

        b(InterfaceC10536a interfaceC10536a) {
            this.f407904d = interfaceC10536a;
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEDownloadFinish(@Nullable AEResInfo aeResInfo, @Nullable String localFilePath, boolean downloaded, int errorType) {
            String currentSoDir = FeatureManager.getSoDir();
            boolean z16 = true;
            QLog.i("AEResInitManager_", 1, "tryInit#onAEDownloadFinish errorType:" + errorType + ", currentSoDir:" + currentSoDir);
            if (errorType != 0 && errorType != 1) {
                this.f407904d.error(errorType, "download failed " + errorType);
                return;
            }
            if (currentSoDir != null && currentSoDir.length() != 0) {
                z16 = false;
            }
            if (z16) {
                this.f407904d.error(-1, "currentSoDir is null!");
                return;
            }
            InterfaceC10536a interfaceC10536a = this.f407904d;
            Intrinsics.checkNotNullExpressionValue(currentSoDir, "currentSoDir");
            interfaceC10536a.a(currentSoDir);
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEProgressUpdate(@Nullable AEResInfo aeResInfo, long currentOffset, long totalLength) {
        }
    }
}
