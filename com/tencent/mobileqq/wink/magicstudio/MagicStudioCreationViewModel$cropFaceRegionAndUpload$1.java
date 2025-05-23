package com.tencent.mobileqq.wink.magicstudio;

import cooperation.qzone.report.lp.LpReportInfoConfig;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel", f = "MagicStudioCreationViewModel.kt", i = {0}, l = {LpReportInfoConfig.ACTION_VIDEO_EDITOR, 707}, m = "cropFaceRegionAndUpload", n = {"imagePath"}, s = {"L$0"})
/* loaded from: classes21.dex */
public final class MagicStudioCreationViewModel$cropFaceRegionAndUpload$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MagicStudioCreationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicStudioCreationViewModel$cropFaceRegionAndUpload$1(MagicStudioCreationViewModel magicStudioCreationViewModel, Continuation<? super MagicStudioCreationViewModel$cropFaceRegionAndUpload$1> continuation) {
        super(continuation);
        this.this$0 = magicStudioCreationViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object y26;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        y26 = this.this$0.y2(null, this);
        return y26;
    }
}
