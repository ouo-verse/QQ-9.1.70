package com.tencent.mobileqq.wink.editor.export;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.model.WinkExportParams;
import com.tencent.mobileqq.winkpublish.report.ExportErrorCode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.export.WinkVideoMergeTask$doOnVideoMergeSucceed$1", f = "WinkVideoMergeTask.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkVideoMergeTask$doOnVideoMergeSucceed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ c $callBack;
    final /* synthetic */ String $outPath;
    final /* synthetic */ WinkEditDataWrapper $winkEditDataWrapper;
    final /* synthetic */ WinkExportParams $winkExportParams;
    int label;
    final /* synthetic */ WinkVideoMergeTask this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkVideoMergeTask$doOnVideoMergeSucceed$1(WinkVideoMergeTask winkVideoMergeTask, String str, WinkEditDataWrapper winkEditDataWrapper, WinkExportParams winkExportParams, c cVar, Continuation<? super WinkVideoMergeTask$doOnVideoMergeSucceed$1> continuation) {
        super(2, continuation);
        this.this$0 = winkVideoMergeTask;
        this.$outPath = str;
        this.$winkEditDataWrapper = winkEditDataWrapper;
        this.$winkExportParams = winkExportParams;
        this.$callBack = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkVideoMergeTask$doOnVideoMergeSucceed$1(this.this$0, this.$outPath, this.$winkEditDataWrapper, this.$winkExportParams, this.$callBack, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (this.this$0.getIsCanceled()) {
            return Unit.INSTANCE;
        }
        w53.b.f("WinkPublish-Export-WinkVideoMergeTask", "winkVideoMerger success");
        LocalMediaInfo composedVideoInfo = WinkExportUtils.d(this.$outPath);
        ac acVar = ac.f320179a;
        Intrinsics.checkNotNullExpressionValue(composedVideoInfo, "composedVideoInfo");
        ExportErrorCode b16 = acVar.b(composedVideoInfo, this.$winkEditDataWrapper, this.$winkExportParams);
        if (b16.transformedCode() != 0) {
            this.this$0.q(this.$winkExportParams, b16, this.$callBack);
            return Unit.INSTANCE;
        }
        w53.b.f("WinkPublish-Export-WinkVideoMergeTask", "winkVideoMerger success, composedVideoInfo:" + composedVideoInfo);
        WinkVideoMergeTask winkVideoMergeTask = this.this$0;
        winkVideoMergeTask.c(this.$winkEditDataWrapper, composedVideoInfo, this.$winkExportParams, true, false, 3, winkVideoMergeTask.getExportStartTime(), this.$callBack);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkVideoMergeTask$doOnVideoMergeSucceed$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
