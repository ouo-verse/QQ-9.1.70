package com.tencent.mobileqq.guild.feed.publish.publishV2.taskx;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.FeedMediaUploadTask$submitSingleMedium$1", f = "FeedMediaUploadTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class FeedMediaUploadTask$submitSingleMedium$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $fileId;
    final /* synthetic */ LocalMediaInfo $medium;
    final /* synthetic */ int $seq;
    int label;
    final /* synthetic */ FeedMediaUploadTask this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedMediaUploadTask$submitSingleMedium$1(FeedMediaUploadTask feedMediaUploadTask, String str, int i3, LocalMediaInfo localMediaInfo, Continuation<? super FeedMediaUploadTask$submitSingleMedium$1> continuation) {
        super(2, continuation);
        this.this$0 = feedMediaUploadTask;
        this.$fileId = str;
        this.$seq = i3;
        this.$medium = localMediaInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FeedMediaUploadTask$submitSingleMedium$1(this.this$0, this.$fileId, this.$seq, this.$medium, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Map mapOf;
        Set emptySet;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.this$0.taskInfoWrapperMap.containsKey(this.$fileId)) {
                if (QLog.isDevelopLevel()) {
                    QLog.d(this.this$0.logTag, 4, "[submitSingleMedium](" + this.$seq + "): parentId=" + this.this$0.Q() + ", fileId=" + this.$fileId + ", already in");
                }
                return Unit.INSTANCE;
            }
            FeedMediaUploadTask feedMediaUploadTask = this.this$0;
            int i3 = this.$seq;
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(this.$fileId, com.tencent.mobileqq.guild.data.h.a(this.$medium)));
            emptySet = SetsKt__SetsKt.emptySet();
            feedMediaUploadTask.I(i3, mapOf, emptySet);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedMediaUploadTask$submitSingleMedium$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
