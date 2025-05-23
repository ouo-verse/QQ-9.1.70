package com.tencent.mobileqq.guild.feed.publish.publishV2.taskx;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt___SetsKt;
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
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.FeedMediaUploadTask$batchSubmitMediaSelected$1", f = "FeedMediaUploadTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class FeedMediaUploadTask$batchSubmitMediaSelected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, LocalMediaInfo> $mediaSelected;
    final /* synthetic */ int $seq;
    int label;
    final /* synthetic */ FeedMediaUploadTask this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FeedMediaUploadTask$batchSubmitMediaSelected$1(Map<String, ? extends LocalMediaInfo> map, FeedMediaUploadTask feedMediaUploadTask, int i3, Continuation<? super FeedMediaUploadTask$batchSubmitMediaSelected$1> continuation) {
        super(2, continuation);
        this.$mediaSelected = map;
        this.this$0 = feedMediaUploadTask;
        this.$seq = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FeedMediaUploadTask$batchSubmitMediaSelected$1(this.$mediaSelected, this.this$0, this.$seq, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Set O;
        Map minus;
        Set O2;
        Set minus2;
        int mapCapacity;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Map<String, LocalMediaInfo> map = this.$mediaSelected;
            O = this.this$0.O();
            minus = MapsKt__MapsKt.minus((Map) map, (Iterable) O);
            O2 = this.this$0.O();
            minus2 = SetsKt___SetsKt.minus(O2, (Iterable) this.$mediaSelected.keySet());
            if (minus.isEmpty() && minus2.isEmpty()) {
                if (QLog.isDevelopLevel()) {
                    QLog.d(this.this$0.logTag, 4, "[batchSubmitMediaSelected](" + this.$seq + "): parentId=" + this.this$0.Q() + ", no difference");
                }
                return Unit.INSTANCE;
            }
            if (this.this$0.j()) {
                QLog.w(this.this$0.logTag, 1, "[batchSubmitMediaSelected](" + this.$seq + "): parentId=" + this.this$0.Q() + ", submit operation isn't supported while awaiting");
                return Unit.INSTANCE;
            }
            this.this$0.L();
            FeedMediaUploadTask feedMediaUploadTask = this.this$0;
            int i3 = this.$seq;
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(minus.size());
            LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
            for (Map.Entry entry : minus.entrySet()) {
                linkedHashMap.put(entry.getKey(), com.tencent.mobileqq.guild.data.h.a((LocalMediaInfo) entry.getValue()));
            }
            feedMediaUploadTask.I(i3, linkedHashMap, minus2);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedMediaUploadTask$batchSubmitMediaSelected$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
