package com.tencent.mobileqq.guild.feed.nativepublish.publish;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent;
import com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.FeedMediaUploadTaskRestoreInfoQueryFilter;
import com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.MediumUploadStateRestoreInfo;
import com.tencent.mobileqq.guild.feed.util.ae;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativepublish.publish.FeedEditorMediaUploadTaskQueueVMDelegate$handleTriggerMediasRestore$1", f = "FeedEditorMediaUploadTaskQueueVMDelegate.kt", i = {0}, l = {90}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: classes13.dex */
public final class FeedEditorMediaUploadTaskQueueVMDelegate$handleTriggerMediasRestore$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FeedEditorContentMsgIntent.TriggerMediasRestore $event;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FeedEditorMediaUploadTaskQueueVMDelegate this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativepublish.publish.FeedEditorMediaUploadTaskQueueVMDelegate$handleTriggerMediasRestore$1$1", f = "FeedEditorMediaUploadTaskQueueVMDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativepublish.publish.FeedEditorMediaUploadTaskQueueVMDelegate$handleTriggerMediasRestore$1$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FeedEditorContentMsgIntent.TriggerMediasRestore $event;
        int label;
        final /* synthetic */ FeedEditorMediaUploadTaskQueueVMDelegate this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(FeedEditorMediaUploadTaskQueueVMDelegate feedEditorMediaUploadTaskQueueVMDelegate, FeedEditorContentMsgIntent.TriggerMediasRestore triggerMediasRestore, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = feedEditorMediaUploadTaskQueueVMDelegate;
            this.$event = triggerMediasRestore;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$event, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            HashMap j3;
            HashMap j16;
            HashMap j17;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                j3 = this.this$0.j();
                boolean isEmpty = j3.isEmpty();
                j16 = this.this$0.j();
                j16.putAll(this.$event.a());
                if (!isEmpty) {
                    String logTag = this.this$0.getLogTag();
                    String a16 = com.tencent.mobileqq.guild.feed.nativepublish.utils.a.a(this.this$0.c());
                    j17 = this.this$0.j();
                    QLog.i(logTag, 1, "[handleTriggerMediasRestore]: " + a16 + ", mediaMap.size=" + j17.size());
                    this.this$0.p();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedEditorMediaUploadTaskQueueVMDelegate$handleTriggerMediasRestore$1(FeedEditorMediaUploadTaskQueueVMDelegate feedEditorMediaUploadTaskQueueVMDelegate, FeedEditorContentMsgIntent.TriggerMediasRestore triggerMediasRestore, Continuation<? super FeedEditorMediaUploadTaskQueueVMDelegate$handleTriggerMediasRestore$1> continuation) {
        super(2, continuation);
        this.this$0 = feedEditorMediaUploadTaskQueueVMDelegate;
        this.$event = triggerMediasRestore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FeedEditorMediaUploadTaskQueueVMDelegate$handleTriggerMediasRestore$1 feedEditorMediaUploadTaskQueueVMDelegate$handleTriggerMediasRestore$1 = new FeedEditorMediaUploadTaskQueueVMDelegate$handleTriggerMediasRestore$1(this.this$0, this.$event, continuation);
        feedEditorMediaUploadTaskQueueVMDelegate$handleTriggerMediasRestore$1.L$0 = obj;
        return feedEditorMediaUploadTaskQueueVMDelegate$handleTriggerMediasRestore$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        in1.c uploadTaskApi;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            FeedMediaUploadTaskRestoreInfoQueryFilter feedMediaUploadTaskRestoreInfoQueryFilter = new FeedMediaUploadTaskRestoreInfoQueryFilter();
            String a16 = com.tencent.mobileqq.guild.feed.nativepublish.utils.a.a(this.this$0.c());
            Map<String, LocalMediaInfo> a17 = this.$event.a();
            this.L$0 = coroutineScope2;
            this.label = 1;
            Object d16 = feedMediaUploadTaskRestoreInfoQueryFilter.d(a16, a17, this);
            if (d16 == coroutine_suspended) {
                return coroutine_suspended;
            }
            coroutineScope = coroutineScope2;
            obj = d16;
        }
        List<MediumUploadStateRestoreInfo> list = (List) obj;
        in1.d b16 = com.tencent.mobileqq.guild.feed.nativepublish.utils.a.b(this.this$0.c());
        if (b16 != null && (uploadTaskApi = b16.getUploadTaskApi()) != null) {
            uploadTaskApi.e(list);
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, ae.a().e(), null, new AnonymousClass1(this.this$0, this.$event, null), 2, null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedEditorMediaUploadTaskQueueVMDelegate$handleTriggerMediasRestore$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
