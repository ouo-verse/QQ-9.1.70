package com.tencent.mobileqq.wink.h5native;

import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeExportManager", f = "WinkAiPaintNativeExportManager.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {687}, m = "exportVideo", n = {"this", WadlProxyConsts.KEY_MATERIAL, "cacheDir", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, AEEditorConstants.KEY_WINK_LOCAL_MEDIA_INFOS, "assetDataMap", "startTime"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0"})
/* loaded from: classes21.dex */
public final class WinkAiPaintNativeExportManager$exportVideo$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WinkAiPaintNativeExportManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAiPaintNativeExportManager$exportVideo$1(WinkAiPaintNativeExportManager winkAiPaintNativeExportManager, Continuation<? super WinkAiPaintNativeExportManager$exportVideo$1> continuation) {
        super(continuation);
        this.this$0 = winkAiPaintNativeExportManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object Q;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Q = this.this$0.Q(null, null, null, null, null, this);
        return Q;
    }
}
