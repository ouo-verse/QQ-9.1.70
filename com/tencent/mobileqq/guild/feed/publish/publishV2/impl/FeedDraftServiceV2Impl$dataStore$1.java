package com.tencent.mobileqq.guild.feed.publish.publishV2.impl;

import com.tencent.mobileqq.guild.feed.util.ae;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildFeedDraft;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGuildDraftCallback;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.android.HandlerDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlin/Triple;", "", "", "<name for destructuring parameter 0>", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGuildFeedDraft;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedDraftServiceV2Impl$dataStore$1", f = "FeedDraftServiceV2Impl.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class FeedDraftServiceV2Impl$dataStore$1 extends SuspendLambda implements Function2<Triple<? extends String, ? extends Integer, ? extends String>, Continuation<? super GProGuildFeedDraft>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGuildFeedDraft;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedDraftServiceV2Impl$dataStore$1$1", f = "FeedDraftServiceV2Impl.kt", i = {}, l = {163}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedDraftServiceV2Impl$dataStore$1$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super GProGuildFeedDraft>, Object> {
        final /* synthetic */ String $draftId;
        final /* synthetic */ String $draftKey;
        final /* synthetic */ int $draftType;
        int label;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "kotlin.jvm.PlatformType", "v", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGuildFeedDraft;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedDraftServiceV2Impl$dataStore$1$1$a */
        /* loaded from: classes13.dex */
        static final class a implements IGProGuildDraftCallback {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Continuation<GProGuildFeedDraft> f223029a;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Multi-variable type inference failed */
            public a(Continuation<? super GProGuildFeedDraft> continuation) {
                this.f223029a = continuation;
            }

            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGuildDraftCallback
            public final void onResult(int i3, String str, GProGuildFeedDraft gProGuildFeedDraft) {
                this.f223029a.resumeWith(Result.m476constructorimpl(gProGuildFeedDraft));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, int i3, String str2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$draftId = str;
            this.$draftType = i3;
            this.$draftKey = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$draftId, this.$draftType, this.$draftKey, continuation);
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
                FeedDraftServiceV2Impl$dataStore$1$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$default$1 feedDraftServiceV2Impl$dataStore$1$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$default$1 = new FeedDraftServiceV2Impl$dataStore$1$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$default$1(null, this.$draftId, this.$draftType, this.$draftKey);
                this.label = 1;
                obj = TimeoutKt.withTimeoutOrNull(15000L, feedDraftServiceV2Impl$dataStore$1$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$default$1, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return obj;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super GProGuildFeedDraft> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FeedDraftServiceV2Impl$dataStore$1(Continuation<? super FeedDraftServiceV2Impl$dataStore$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FeedDraftServiceV2Impl$dataStore$1 feedDraftServiceV2Impl$dataStore$1 = new FeedDraftServiceV2Impl$dataStore$1(continuation);
        feedDraftServiceV2Impl$dataStore$1.L$0 = obj;
        return feedDraftServiceV2Impl$dataStore$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Triple<? extends String, ? extends Integer, ? extends String> triple, Continuation<? super GProGuildFeedDraft> continuation) {
        return invoke2((Triple<String, Integer, String>) triple, continuation);
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
            Triple triple = (Triple) this.L$0;
            String str = (String) triple.component1();
            int intValue = ((Number) triple.component2()).intValue();
            String str2 = (String) triple.component3();
            HandlerDispatcher d16 = ae.a().d();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(str, intValue, str2, null);
            this.label = 1;
            obj = BuildersKt.withContext(d16, anonymousClass1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull Triple<String, Integer, String> triple, @Nullable Continuation<? super GProGuildFeedDraft> continuation) {
        return ((FeedDraftServiceV2Impl$dataStore$1) create(triple, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
