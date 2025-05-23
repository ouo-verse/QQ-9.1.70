package com.tencent.mobileqq.nearbypro.repository.service;

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
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/Deferred;", "Lorg/json/JSONObject;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.nearbypro.repository.service.AvatarService$reqOtherAvatarInfo$avatarInfoDeferred$1$1", f = "AvatarService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes15.dex */
public final class AvatarService$reqOtherAvatarInfo$avatarInfoDeferred$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Deferred<? extends JSONObject>>, Object> {
    final /* synthetic */ String $clientVersion;
    final /* synthetic */ long $tinyId;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lorg/json/JSONObject;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.nearbypro.repository.service.AvatarService$reqOtherAvatarInfo$avatarInfoDeferred$1$1$1", f = "AvatarService.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.nearbypro.repository.service.AvatarService$reqOtherAvatarInfo$avatarInfoDeferred$1$1$1, reason: invalid class name */
    /* loaded from: classes15.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super JSONObject>, Object> {
        final /* synthetic */ String $clientVersion;
        final /* synthetic */ long $tinyId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(long j3, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$tinyId = j3;
            this.$clientVersion = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$tinyId, this.$clientVersion, continuation);
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
                AvatarService avatarService = AvatarService.INSTANCE;
                long j3 = this.$tinyId;
                String str = this.$clientVersion;
                this.label = 1;
                obj = avatarService.doReqOtherAvatarInfo(j3, str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return obj;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super JSONObject> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarService$reqOtherAvatarInfo$avatarInfoDeferred$1$1(long j3, String str, Continuation<? super AvatarService$reqOtherAvatarInfo$avatarInfoDeferred$1$1> continuation) {
        super(2, continuation);
        this.$tinyId = j3;
        this.$clientVersion = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AvatarService$reqOtherAvatarInfo$avatarInfoDeferred$1$1 avatarService$reqOtherAvatarInfo$avatarInfoDeferred$1$1 = new AvatarService$reqOtherAvatarInfo$avatarInfoDeferred$1$1(this.$tinyId, this.$clientVersion, continuation);
        avatarService$reqOtherAvatarInfo$avatarInfoDeferred$1$1.L$0 = obj;
        return avatarService$reqOtherAvatarInfo$avatarInfoDeferred$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Deferred async$default;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            async$default = BuildersKt__Builders_commonKt.async$default((CoroutineScope) this.L$0, null, null, new AnonymousClass1(this.$tinyId, this.$clientVersion, null), 3, null);
            return async$default;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Deferred<? extends JSONObject>> continuation) {
        return ((AvatarService$reqOtherAvatarInfo$avatarInfoDeferred$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
