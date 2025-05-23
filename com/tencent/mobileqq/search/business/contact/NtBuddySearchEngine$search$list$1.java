package com.tencent.mobileqq.search.business.contact;

import com.tencent.mobileqq.guild.util.Logger;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lcom/tencent/mobileqq/search/model/k;", "kotlin.jvm.PlatformType", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.search.business.contact.NtBuddySearchEngine$search$list$1", f = "NtBuddySearchEngine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes18.dex */
final class NtBuddySearchEngine$search$list$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends com.tencent.mobileqq.search.model.k>>, Object> {
    final /* synthetic */ pn2.a $searchRequest;
    int label;
    final /* synthetic */ NtBuddySearchEngine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NtBuddySearchEngine$search$list$1(NtBuddySearchEngine ntBuddySearchEngine, pn2.a aVar, Continuation<? super NtBuddySearchEngine$search$list$1> continuation) {
        super(2, continuation);
        this.this$0 = ntBuddySearchEngine;
        this.$searchRequest = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new NtBuddySearchEngine$search$list$1(this.this$0, this.$searchRequest, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Logger logger = Logger.f235387a;
            pn2.a aVar = this.$searchRequest;
            NtBuddySearchEngine ntBuddySearchEngine = this.this$0;
            logger.d().i("NtBuddySearchEngine", 1, "search(" + aVar + "), " + aVar.f426495a + ", ret = " + ntBuddySearchEngine.searchId);
            return this.this$0.o(this.$searchRequest).get(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<? extends com.tencent.mobileqq.search.model.k>> continuation) {
        return ((NtBuddySearchEngine$search$list$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
