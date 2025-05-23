package com.tencent.mobileqq.zplan.aigc;

import com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$recordAndExportThumbnailImage$1", f = "SuitOutfitPreviewFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class SuitOutfitPreviewFragment$recordAndExportThumbnailImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SuitOutfitPreviewFragment.b $callback;
    int label;
    final /* synthetic */ SuitOutfitPreviewFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitOutfitPreviewFragment$recordAndExportThumbnailImage$1(SuitOutfitPreviewFragment.b bVar, SuitOutfitPreviewFragment suitOutfitPreviewFragment, Continuation<? super SuitOutfitPreviewFragment$recordAndExportThumbnailImage$1> continuation) {
        super(2, continuation);
        this.$callback = bVar;
        this.this$0 = suitOutfitPreviewFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SuitOutfitPreviewFragment$recordAndExportThumbnailImage$1(this.$callback, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        File file;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            SuitOutfitPreviewFragment.b bVar = this.$callback;
            file = this.this$0.outfitThumbnailImageFile;
            bVar.a(file);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuitOutfitPreviewFragment$recordAndExportThumbnailImage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
