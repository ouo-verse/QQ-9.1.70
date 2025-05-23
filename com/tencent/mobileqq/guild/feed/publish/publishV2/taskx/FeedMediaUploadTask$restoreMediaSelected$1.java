package com.tencent.mobileqq.guild.feed.publish.publishV2.taskx;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.JobKt__JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.FeedMediaUploadTask$restoreMediaSelected$1", f = "FeedMediaUploadTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class FeedMediaUploadTask$restoreMediaSelected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<MediumUploadStateRestoreInfo> $restoreInfoList;
    final /* synthetic */ int $seq;
    int label;
    final /* synthetic */ FeedMediaUploadTask this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedMediaUploadTask$restoreMediaSelected$1(FeedMediaUploadTask feedMediaUploadTask, int i3, List<MediumUploadStateRestoreInfo> list, Continuation<? super FeedMediaUploadTask$restoreMediaSelected$1> continuation) {
        super(2, continuation);
        this.this$0 = feedMediaUploadTask;
        this.$seq = i3;
        this.$restoreInfoList = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FeedMediaUploadTask$restoreMediaSelected$1(this.this$0, this.$seq, this.$restoreInfoList, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Deferred deferred;
        Set emptySet;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            deferred = this.this$0.deferredResult;
            if (deferred != null) {
                JobKt__JobKt.cancel$default(deferred, "restoreMediaSelected, seq=" + this.$seq, null, 2, null);
            }
            this.this$0.L();
            this.this$0.M();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            ArrayList arrayList = new ArrayList();
            for (MediumUploadStateRestoreInfo mediumUploadStateRestoreInfo : this.$restoreInfoList) {
                if (mediumUploadStateRestoreInfo.getIsFinishSuccess() && mediumUploadStateRestoreInfo.getTaskInfo() != null) {
                    this.this$0.taskInfoWrapperMap.put(mediumUploadStateRestoreInfo.getFileId(), new i(mediumUploadStateRestoreInfo.getTaskInfo()));
                } else if (mediumUploadStateRestoreInfo.getIsNeedReUpload()) {
                    linkedHashMap.put(mediumUploadStateRestoreInfo.getFileId(), mediumUploadStateRestoreInfo.getLocalMediumInfo());
                } else if (mediumUploadStateRestoreInfo.getIsInterrupted() && mediumUploadStateRestoreInfo.getTaskInfo() != null) {
                    arrayList.add(mediumUploadStateRestoreInfo);
                } else {
                    QLog.e(this.this$0.logTag, 1, "[restoreMediaSelected](" + this.$seq + "): invalid restoreInfo=" + mediumUploadStateRestoreInfo);
                }
            }
            FeedMediaUploadTask feedMediaUploadTask = this.this$0;
            int i3 = this.$seq;
            emptySet = SetsKt__SetsKt.emptySet();
            feedMediaUploadTask.I(i3, linkedHashMap, emptySet);
            this.this$0.Y(this.$seq, arrayList);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedMediaUploadTask$restoreMediaSelected$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
