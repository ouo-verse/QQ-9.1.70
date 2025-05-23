package com.tencent.mobileqq.wink.publish.util;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.publish.util.WinkDraftGenerator", f = "WinkDraftGenerator.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3}, l = {97, 104, 108, 115}, m = "genDraftWithRecommendStuckMusic", n = {"this", "content", QAdVrReportParams.ParamKey.MEDIA, "onError", "missionId", "editDataWrapper", "this", "content", QAdVrReportParams.ParamKey.MEDIA, "missionId", "editDataWrapper", "this", "content", QAdVrReportParams.ParamKey.MEDIA, "onError", "missionId", "editDataWrapper", "this", "content", QAdVrReportParams.ParamKey.MEDIA, "onError", "missionId", "editDataWrapper"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
/* loaded from: classes21.dex */
public final class WinkDraftGenerator$genDraftWithRecommendStuckMusic$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WinkDraftGenerator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkDraftGenerator$genDraftWithRecommendStuckMusic$1(WinkDraftGenerator winkDraftGenerator, Continuation<? super WinkDraftGenerator$genDraftWithRecommendStuckMusic$1> continuation) {
        super(continuation);
        this.this$0 = winkDraftGenerator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.j(null, null, null, this);
    }
}
