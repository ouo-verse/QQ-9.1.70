package com.tencent.mobileqq.wink.magicstudio;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel", f = "MagicStudioCreationViewModel.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4}, l = {988, 989, 991, 1017, 1018}, m = "onReceiveAigcResp", n = {"this", "scope", "aigcResponse", "successCount", "firstAigcFlow", "aigcResps", "mediaType", "imgResult", "allCount", "this", "aigcResponse", "successCount", "firstAigcFlow", "aigcResps", "mediaType", "imgResult", "allCount", "this", "aigcResponse", "successCount", "firstAigcFlow", "aigcResps", "mediaType", "allCount", "this", "successCount", "firstAigcFlow", "aigcResps", "info", "allCount", "this", "successCount", "aigcResps", "info"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes21.dex */
public final class MagicStudioCreationViewModel$onReceiveAigcResp$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MagicStudioCreationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicStudioCreationViewModel$onReceiveAigcResp$1(MagicStudioCreationViewModel magicStudioCreationViewModel, Continuation<? super MagicStudioCreationViewModel$onReceiveAigcResp$1> continuation) {
        super(continuation);
        this.this$0 = magicStudioCreationViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object f36;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        f36 = this.this$0.f3(null, null, null, null, 0, null, 0, null, this);
        return f36;
    }
}
