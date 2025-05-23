package com.tencent.mobileqq.guild.feed.publish.publishV2.impl;

import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.feed.publish.helper.GuildDbDataHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kn1.FeedPublishStateV2;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0006\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u00032\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlin/Pair;", "", "<name for destructuring parameter 0>", "Lkotlinx/coroutines/Deferred;", "", "Lkn1/b;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$memoryStorage$1", f = "FeedPublishServiceV2Impl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class FeedPublishServiceV2Impl$memoryStorage$1 extends SuspendLambda implements Function2<Pair<? extends String, ? extends String>, Continuation<? super Deferred<? extends List<? extends FeedPublishStateV2>>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FeedPublishServiceV2Impl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lkn1/b;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$memoryStorage$1$1", f = "FeedPublishServiceV2Impl.kt", i = {}, l = {431}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$memoryStorage$1$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends FeedPublishStateV2>>, Object> {
        final /* synthetic */ String $channel;
        final /* synthetic */ String $guild;
        int label;
        final /* synthetic */ FeedPublishServiceV2Impl this$0;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u00052*\u0010\u0004\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00030\u0000H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/tencent/mobileqq/guild/feed/publish/bean/GuildTaskProgressState;", "kotlin.jvm.PlatformType", "", "list", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedPublishServiceV2Impl$memoryStorage$1$1$a */
        /* loaded from: classes13.dex */
        static final class a<T> implements GuildDbDataHelper.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Continuation<List<FeedPublishStateV2>> f223078a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ FeedPublishServiceV2Impl f223079b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Multi-variable type inference failed */
            public a(Continuation<? super List<FeedPublishStateV2>> continuation, FeedPublishServiceV2Impl feedPublishServiceV2Impl) {
                this.f223078a = continuation;
                this.f223079b = feedPublishServiceV2Impl;
            }

            @Override // com.tencent.mobileqq.guild.feed.publish.helper.GuildDbDataHelper.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void onResult(List<GuildTaskProgressState> list) {
                ArrayList arrayList;
                FeedPublishStateV2 stateV2FromProgressState;
                Continuation<List<FeedPublishStateV2>> continuation = this.f223078a;
                if (list != null) {
                    FeedPublishServiceV2Impl feedPublishServiceV2Impl = this.f223079b;
                    arrayList = new ArrayList();
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        stateV2FromProgressState = feedPublishServiceV2Impl.stateV2FromProgressState(false, (GuildTaskProgressState) it.next());
                        if (stateV2FromProgressState != null) {
                            arrayList.add(stateV2FromProgressState);
                        }
                    }
                } else {
                    arrayList = null;
                }
                continuation.resumeWith(Result.m476constructorimpl(arrayList));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, FeedPublishServiceV2Impl feedPublishServiceV2Impl, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$guild = str;
            this.$channel = str2;
            this.this$0 = feedPublishServiceV2Impl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$guild, this.$channel, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends FeedPublishStateV2>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<FeedPublishStateV2>>) continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            List emptyList;
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
                FeedPublishServiceV2Impl$memoryStorage$1$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$default$1 feedPublishServiceV2Impl$memoryStorage$1$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$default$1 = new FeedPublishServiceV2Impl$memoryStorage$1$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$default$1(null, this.$guild, this.$channel, this.this$0);
                this.label = 1;
                obj = TimeoutKt.withTimeoutOrNull(15000L, feedPublishServiceV2Impl$memoryStorage$1$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$default$1, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            List list = (List) obj;
            if (list == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
            return list;
        }

        @Nullable
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<FeedPublishStateV2>> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedPublishServiceV2Impl$memoryStorage$1(FeedPublishServiceV2Impl feedPublishServiceV2Impl, Continuation<? super FeedPublishServiceV2Impl$memoryStorage$1> continuation) {
        super(2, continuation);
        this.this$0 = feedPublishServiceV2Impl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FeedPublishServiceV2Impl$memoryStorage$1 feedPublishServiceV2Impl$memoryStorage$1 = new FeedPublishServiceV2Impl$memoryStorage$1(this.this$0, continuation);
        feedPublishServiceV2Impl$memoryStorage$1.L$0 = obj;
        return feedPublishServiceV2Impl$memoryStorage$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Pair<? extends String, ? extends String> pair, Continuation<? super Deferred<? extends List<? extends FeedPublishStateV2>>> continuation) {
        return invoke2((Pair<String, String>) pair, (Continuation<? super Deferred<? extends List<FeedPublishStateV2>>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        CoroutineScope coroutineScope;
        Deferred async$default;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Pair pair = (Pair) this.L$0;
            String str = (String) pair.component1();
            String str2 = (String) pair.component2();
            coroutineScope = this.this$0.scope;
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new AnonymousClass1(str, str2, this.this$0, null), 3, null);
            return async$default;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull Pair<String, String> pair, @Nullable Continuation<? super Deferred<? extends List<FeedPublishStateV2>>> continuation) {
        return ((FeedPublishServiceV2Impl$memoryStorage$1) create(pair, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
