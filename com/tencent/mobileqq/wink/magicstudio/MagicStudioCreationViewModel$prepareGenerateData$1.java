package com.tencent.mobileqq.wink.magicstudio;

import com.tencent.mobileqq.mini.report.MiniReportManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel", f = "MagicStudioCreationViewModel.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4}, l = {615, 620, 626, 631, MiniReportManager.EventId.PAGE_LOAD_END}, m = "prepareGenerateData", n = {"this", "imagePath", "magicStudioPicStyle", "currentImg", "this", "imagePath", "magicStudioPicStyle", "currentImg", "compressImageUrl", "magicStudioPicStyle", "currentImg", "this", "magicStudioPicStyle", "currentImg", "cropFaceUrl", "magicStudioPicStyle", "currentImg", "compressImageUrl"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
/* loaded from: classes21.dex */
public final class MagicStudioCreationViewModel$prepareGenerateData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MagicStudioCreationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicStudioCreationViewModel$prepareGenerateData$1(MagicStudioCreationViewModel magicStudioCreationViewModel, Continuation<? super MagicStudioCreationViewModel$prepareGenerateData$1> continuation) {
        super(continuation);
        this.this$0 = magicStudioCreationViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object j3;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        j3 = this.this$0.j3(null, null, false, this);
        return j3;
    }
}
