package com.tencent.mobileqq.wink.ai.imagetext;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.ai.imagetext.WinkAIImageTextAPIHelper", f = "WinkAIImageTextAPIHelper.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {171, 190, 243, 245}, m = "getImageTextInfosFromApi", n = {"this", "imagePath", "originText", "callback", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "textInfoMap", "textInfosResult", "isStream", "startTime", "compressEndTime", "this", "callback", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "textInfoMap", "textInfosResult", "uploadImageUrl", "isStream", "startTime", "uploadImageEndTime", "this", "callback", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "textInfoMap", "uploadImageUrl", "requestTextIds", "loopDelayTime", "startTime", "retryCount", "loopCount", "this", "callback", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "textInfoMap", "uploadImageUrl", "requestTextIds", "loopDelayTime", "startTime", "retryCount", "loopCount"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "J$0", "J$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "J$0", "J$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "I$0", "I$1"})
/* loaded from: classes21.dex */
public final class WinkAIImageTextAPIHelper$getImageTextInfosFromApi$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WinkAIImageTextAPIHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAIImageTextAPIHelper$getImageTextInfosFromApi$1(WinkAIImageTextAPIHelper winkAIImageTextAPIHelper, Continuation<? super WinkAIImageTextAPIHelper$getImageTextInfosFromApi$1> continuation) {
        super(continuation);
        this.this$0 = winkAIImageTextAPIHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object h16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        h16 = this.this$0.h(null, null, false, false, null, null, this);
        return h16;
    }
}
