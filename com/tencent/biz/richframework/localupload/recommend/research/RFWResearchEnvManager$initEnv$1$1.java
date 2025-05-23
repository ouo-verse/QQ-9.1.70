package com.tencent.biz.richframework.localupload.recommend.research;

import android.os.Handler;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.a;
import com.tencent.biz.richframework.localupload.recommend.RFWRecommendThread;
import com.tencent.biz.richframework.localupload.recommend.RecommendContext;
import com.tencent.biz.richframework.localupload.recommend.research.RFWResearchEnvManager;
import com.tencent.biz.richframework.localupload.recommend.research.RFWResearchEnvManager$initEnv$1$1;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/biz/richframework/localupload/recommend/research/RFWResearchEnvManager$initEnv$1$1", "Lcom/tencent/aelight/camera/download/api/a;", "Lcom/tencent/aelight/camera/download/api/AEResInfo;", "aeResInfo", "", "localFilePath", "", "downloaded", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "", "onAEDownloadFinish", "", "currentOffset", "totalLength", "onAEProgressUpdate", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class RFWResearchEnvManager$initEnv$1$1 implements a {
    final /* synthetic */ RFWResearchEnvManager.IInitEnvCallBack $callback;
    final /* synthetic */ RecommendContext $context;
    final /* synthetic */ int $currentRetryCount;
    final /* synthetic */ AtomicInteger $needDownloadSize;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RFWResearchEnvManager$initEnv$1$1(AtomicInteger atomicInteger, RecommendContext recommendContext, RFWResearchEnvManager.IInitEnvCallBack iInitEnvCallBack, int i3) {
        this.$needDownloadSize = atomicInteger;
        this.$context = recommendContext;
        this.$callback = iInitEnvCallBack;
        this.$currentRetryCount = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAEDownloadFinish$lambda$0(RecommendContext context, RFWResearchEnvManager.IInitEnvCallBack iInitEnvCallBack, int i3) {
        Intrinsics.checkNotNullParameter(context, "$context");
        context.d("RFWResearchEnvManager", "onAEDownloadFinish not succeed reDownload");
        RFWResearchEnvManager.INSTANCE.initEnv(context, iInitEnvCallBack, i3 + 1);
    }

    @Override // com.tencent.aelight.camera.download.api.a
    public void onAEDownloadFinish(@Nullable AEResInfo aeResInfo, @Nullable String localFilePath, boolean downloaded, int errorType) {
        int decrementAndGet = this.$needDownloadSize.decrementAndGet();
        this.$context.d("RFWResearchEnvManager", "onAEDownloadFinish " + aeResInfo + " errorType:" + errorType);
        if (RFWResearchEnvManager.INSTANCE.isEnvReady(this.$context)) {
            this.$context.d("RFWResearchEnvManager", "onAEDownloadFinish all succeed!!");
            RFWResearchEnvManager.IInitEnvCallBack iInitEnvCallBack = this.$callback;
            if (iInitEnvCallBack != null) {
                iInitEnvCallBack.onInitSucceed();
                return;
            }
            return;
        }
        if (decrementAndGet == 0) {
            this.$context.d("RFWResearchEnvManager", "onAEDownloadFinish not succeed!!");
            if (this.$currentRetryCount >= 3) {
                RFWResearchEnvManager.IInitEnvCallBack iInitEnvCallBack2 = this.$callback;
                if (iInitEnvCallBack2 != null) {
                    iInitEnvCallBack2.onInitError();
                    return;
                }
                return;
            }
            Handler s_real_time_handler = RFWRecommendThread.INSTANCE.getS_REAL_TIME_HANDLER();
            final RecommendContext recommendContext = this.$context;
            final RFWResearchEnvManager.IInitEnvCallBack iInitEnvCallBack3 = this.$callback;
            final int i3 = this.$currentRetryCount;
            s_real_time_handler.postDelayed(new Runnable() { // from class: le0.b
                @Override // java.lang.Runnable
                public final void run() {
                    RFWResearchEnvManager$initEnv$1$1.onAEDownloadFinish$lambda$0(RecommendContext.this, iInitEnvCallBack3, i3);
                }
            }, 5000L);
        }
    }

    @Override // com.tencent.aelight.camera.download.api.a
    public void onAEProgressUpdate(@NotNull AEResInfo aeResInfo, long currentOffset, long totalLength) {
        Intrinsics.checkNotNullParameter(aeResInfo, "aeResInfo");
    }
}
