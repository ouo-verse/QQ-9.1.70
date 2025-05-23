package com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.WinkNewAlbumPreviewViewModel$requestAndProcessData$1", f = "WinkNewAlbumPreviewViewModel.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkNewAlbumPreviewViewModel$requestAndProcessData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $templateId;
    int label;
    final /* synthetic */ WinkNewAlbumPreviewViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.WinkNewAlbumPreviewViewModel$requestAndProcessData$1$1", f = "WinkNewAlbumPreviewViewModel.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel.WinkNewAlbumPreviewViewModel$requestAndProcessData$1$1, reason: invalid class name */
    /* loaded from: classes21.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $templateId;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ WinkNewAlbumPreviewViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(WinkNewAlbumPreviewViewModel winkNewAlbumPreviewViewModel, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = winkNewAlbumPreviewViewModel;
            this.$templateId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$templateId, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            MutableLiveData mutableLiveData;
            Deferred async$default;
            Deferred async$default2;
            MutableLiveData mutableLiveData2;
            MutableLiveData mutableLiveData3;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            try {
                if (i3 != 0) {
                    if (i3 == 1) {
                        mutableLiveData3 = (MutableLiveData) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                    WinkCoroutineScopes winkCoroutineScopes = WinkCoroutineScopes.f317652a;
                    async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, winkCoroutineScopes.c(), null, new WinkNewAlbumPreviewViewModel$requestAndProcessData$1$1$mateDeferred$1(this.this$0, this.$templateId, booleanRef, null), 2, null);
                    async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, winkCoroutineScopes.d(), null, new WinkNewAlbumPreviewViewModel$requestAndProcessData$1$1$createPreviewDataDeferred$1(this.this$0, async$default, null), 2, null);
                    w53.b.f(this.this$0.getTAG(), "createPreviewDataDeferred success");
                    mutableLiveData2 = this.this$0._prepared;
                    Result.Companion companion = Result.INSTANCE;
                    this.L$0 = mutableLiveData2;
                    this.label = 1;
                    obj = async$default2.await(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutableLiveData3 = mutableLiveData2;
                }
                mutableLiveData3.setValue(Result.m475boximpl(Result.m476constructorimpl(obj)));
            } catch (Throwable th5) {
                w53.b.d(this.this$0.getTAG(), "requestAndProcessData fail", th5);
                mutableLiveData = this.this$0._prepared;
                Result.Companion companion2 = Result.INSTANCE;
                mutableLiveData.setValue(Result.m475boximpl(Result.m476constructorimpl(ResultKt.createFailure(th5))));
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkNewAlbumPreviewViewModel$requestAndProcessData$1(WinkNewAlbumPreviewViewModel winkNewAlbumPreviewViewModel, String str, Continuation<? super WinkNewAlbumPreviewViewModel$requestAndProcessData$1> continuation) {
        super(2, continuation);
        this.this$0 = winkNewAlbumPreviewViewModel;
        this.$templateId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkNewAlbumPreviewViewModel$requestAndProcessData$1(this.this$0, this.$templateId, continuation);
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
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$templateId, null);
            this.label = 1;
            if (SupervisorKt.supervisorScope(anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkNewAlbumPreviewViewModel$requestAndProcessData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
