package com.tencent.zplan.record.provider.helper;

import com.tencent.zplan.cloud.impl.CloudRecordApiImpl;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.meme.action.MemeZPlanBaseAction;
import com.tencent.zplan.meme.model.AvatarCharacterInfo;
import com.tencent.zplan.record.model.AbsRecordRequestParams;
import com.tencent.zplan.record.model.CloudRecordResult;
import com.tencent.zplan.record.provider.helper.Z1CloudCacheHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import lx4.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tencent/zplan/record/model/a;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.zplan.record.provider.helper.Z1CloudCacheHelper$requestCloudCacheResource$1", f = "Z1CloudCacheHelper.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes27.dex */
public final class Z1CloudCacheHelper$requestCloudCacheResource$1 extends SuspendLambda implements Function2<ProducerScope<? super CloudRecordResult>, Continuation<? super Unit>, Object> {
    final /* synthetic */ AbsRecordRequestParams $params;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z1CloudCacheHelper$requestCloudCacheResource$1(AbsRecordRequestParams absRecordRequestParams, Continuation continuation) {
        super(2, continuation);
        this.$params = absRecordRequestParams;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        Z1CloudCacheHelper$requestCloudCacheResource$1 z1CloudCacheHelper$requestCloudCacheResource$1 = new Z1CloudCacheHelper$requestCloudCacheResource$1(this.$params, completion);
        z1CloudCacheHelper$requestCloudCacheResource$1.L$0 = obj;
        return z1CloudCacheHelper$requestCloudCacheResource$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super CloudRecordResult> producerScope, Continuation<? super Unit> continuation) {
        return ((Z1CloudCacheHelper$requestCloudCacheResource$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        gx4.a aVar;
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
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            final CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(producerScope.getCoroutineContext());
            MemeZPlanBaseAction a16 = this.$params.a();
            final String key = a16.getKey();
            final Z1CloudCacheHelper.a aVar2 = new Z1CloudCacheHelper.a(this.$params, new Function1<CloudRecordResult, Unit>() { // from class: com.tencent.zplan.record.provider.helper.Z1CloudCacheHelper$requestCloudCacheResource$1$listener$1

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: P */
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
                @DebugMetadata(c = "com.tencent.zplan.record.provider.helper.Z1CloudCacheHelper$requestCloudCacheResource$1$listener$1$1", f = "Z1CloudCacheHelper.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: com.tencent.zplan.record.provider.helper.Z1CloudCacheHelper$requestCloudCacheResource$1$listener$1$1, reason: invalid class name */
                /* loaded from: classes27.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ CloudRecordResult $it;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(CloudRecordResult cloudRecordResult, Continuation continuation) {
                        super(2, continuation);
                        this.$it = cloudRecordResult;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
                        Intrinsics.checkNotNullParameter(completion, "completion");
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$it, completion);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                            if (CoroutineScopeKt.isActive((CoroutineScope) this.L$0) || !ProducerScope.this.isClosedForSend()) {
                                ProducerScope producerScope = ProducerScope.this;
                                CloudRecordResult cloudRecordResult = this.$it;
                                this.label = 1;
                                if (producerScope.send(cloudRecordResult, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(CloudRecordResult cloudRecordResult) {
                    invoke2(cloudRecordResult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull CloudRecordResult it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(it, null), 3, null);
                }
            }, new Function0<Unit>() { // from class: com.tencent.zplan.record.provider.helper.Z1CloudCacheHelper$requestCloudCacheResource$1$listener$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    d a17 = LogUtil.f385285b.a();
                    if (a17 != null) {
                        d.a.c(a17, "[ZPlanRRC]CloudProviderHelper", 1, "finish, " + key, null, 8, null);
                    }
                }
            }, 0L, 8, null);
            CloudRecordApiImpl i16 = Z1CloudCacheHelper.f386141d.i();
            int scene = this.$params.getScene();
            int reqFrom = this.$params.getReqFrom();
            String d16 = a16.getSenderInfo().d();
            if (d16 == null) {
                d16 = "";
            }
            AvatarCharacterInfo senderAvatarCharacterInfo = this.$params.getSenderAvatarCharacterInfo();
            if (senderAvatarCharacterInfo != null) {
                aVar = senderAvatarCharacterInfo.getCharacter();
            } else {
                aVar = null;
            }
            i16.j(a16, scene, reqFrom, d16, aVar, aVar2);
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.zplan.record.provider.helper.Z1CloudCacheHelper$requestCloudCacheResource$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    d a17 = LogUtil.f385285b.a();
                    if (a17 != null) {
                        d.a.c(a17, "[ZPlanRRC]CloudProviderHelper", 1, "requestResourceByCloudCache flow close, key:" + key, null, 8, null);
                    }
                    aVar2.d();
                }
            };
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
