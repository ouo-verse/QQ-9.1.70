package com.tencent.mobileqq.guild.feed.publish.publishV2.impl;

import com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedDraftServiceV2Impl$dataStore$1;
import com.tencent.mobileqq.guild.util.at;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildFeedDraft;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uh2.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.impl.FeedDraftServiceV2Impl$dataStore$1$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$default$1", f = "FeedDraftServiceV2Impl.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class FeedDraftServiceV2Impl$dataStore$1$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super GProGuildFeedDraft>, Object> {
    final /* synthetic */ String $draftId$inlined;
    final /* synthetic */ String $draftKey$inlined;
    final /* synthetic */ int $draftType$inlined;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedDraftServiceV2Impl$dataStore$1$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$default$1(Continuation continuation, String str, int i3, String str2) {
        super(2, continuation);
        this.$draftId$inlined = str;
        this.$draftType$inlined = i3;
        this.$draftKey$inlined = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FeedDraftServiceV2Impl$dataStore$1$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$default$1(continuation, this.$draftId$inlined, this.$draftType$inlined, this.$draftKey$inlined);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Continuation intercepted;
        Object coroutine_suspended2;
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
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            c b16 = at.f235448a.b();
            if (b16 != null) {
                b16.getGuildFeedDraft(this.$draftId$inlined, this.$draftType$inlined, this.$draftKey$inlined, new FeedDraftServiceV2Impl$dataStore$1.AnonymousClass1.a(cancellableContinuationImpl));
            }
            obj = cancellableContinuationImpl.getResult();
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (obj == coroutine_suspended2) {
                DebugProbes.probeCoroutineSuspended(this);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super GProGuildFeedDraft> continuation) {
        return ((FeedDraftServiceV2Impl$dataStore$1$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$default$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
