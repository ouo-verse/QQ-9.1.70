package com.tencent.mobileqq.wink.editor.export;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.model.WinkExportParams;
import com.tencent.mobileqq.winkpublish.report.ExportErrorCode;
import com.tencent.tavcut.core.render.exporter.ExportOutput;
import java.util.ArrayList;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.export.WinkVideoQuickClipTask$doQuickClickCompleted$1", f = "WinkVideoQuickClipTask.kt", i = {}, l = {184}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
final class WinkVideoQuickClipTask$doQuickClickCompleted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ c $callback;
    final /* synthetic */ ExportOutput $exportOutput;
    final /* synthetic */ String $filePath;
    final /* synthetic */ WinkEditDataWrapper $winkEditDataWrapper;
    final /* synthetic */ WinkExportParams $winkExportParams;
    int label;
    final /* synthetic */ WinkVideoQuickClipTask this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkVideoQuickClipTask$doQuickClickCompleted$1(String str, WinkEditDataWrapper winkEditDataWrapper, WinkExportParams winkExportParams, WinkVideoQuickClipTask winkVideoQuickClipTask, c cVar, ExportOutput exportOutput, Continuation<? super WinkVideoQuickClipTask$doQuickClickCompleted$1> continuation) {
        super(2, continuation);
        this.$filePath = str;
        this.$winkEditDataWrapper = winkEditDataWrapper;
        this.$winkExportParams = winkExportParams;
        this.this$0 = winkVideoQuickClipTask;
        this.$callback = cVar;
        this.$exportOutput = exportOutput;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkVideoQuickClipTask$doQuickClickCompleted$1(this.$filePath, this.$winkEditDataWrapper, this.$winkExportParams, this.this$0, this.$callback, this.$exportOutput, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        long j3;
        LocalMediaInfo localMediaInfo;
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
        LocalMediaInfo composedVideoInfo = WinkExportUtils.d(this.$filePath);
        af afVar = af.f320186a;
        ArrayList<LocalMediaInfo> originMediaInfos = this.$winkEditDataWrapper.getOriginMediaInfos();
        if (originMediaInfos != null && (localMediaInfo = originMediaInfos.get(0)) != null) {
            j3 = localMediaInfo.mediaBitrate;
        } else {
            j3 = 0;
        }
        String str = this.$winkExportParams.D;
        Intrinsics.checkNotNullExpressionValue(str, "winkExportParams.mBusinessName");
        ExportErrorCode b16 = afVar.b(composedVideoInfo, j3, str, 2, this.$winkEditDataWrapper.getOriginMediaInfos(), this.$winkExportParams.F);
        if (b16.transformedCode() == 0) {
            WinkVideoQuickClipTask winkVideoQuickClipTask = this.this$0;
            WinkEditDataWrapper winkEditDataWrapper = this.$winkEditDataWrapper;
            Intrinsics.checkNotNullExpressionValue(composedVideoInfo, "composedVideoInfo");
            winkVideoQuickClipTask.c(winkEditDataWrapper, composedVideoInfo, this.$winkExportParams, true, false, 2, this.this$0.getExportStartTime(), this.$callback);
        } else {
            this.this$0.q(this.$exportOutput, this.$winkEditDataWrapper, this.$winkExportParams, this.$callback, b16);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkVideoQuickClipTask$doQuickClickCompleted$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
