package com.tencent.mobileqq.icgame.api.impl;

import com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest;
import com.tencent.mobileqq.icgame.api.sso.QQLiveResponse;
import com.tencent.mobileqq.icgame.login.LiveLoginInfo;
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
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rt0.a;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002H\u008a@"}, d2 = {"Lcom/google/protobuf/nano/MessageNano;", "T", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tencent/mobileqq/icgame/api/sso/QQLiveResponse;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.icgame.api.impl.LiveNetRequestImpl$sendRequestOnFlow$1", f = "LiveNetRequestImpl.kt", i = {}, l = {216}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes15.dex */
final class LiveNetRequestImpl$sendRequestOnFlow$1<T> extends SuspendLambda implements Function2<ProducerScope<? super QQLiveResponse<T>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ LiveBaseRequest<T> $request;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LiveNetRequestImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LiveNetRequestImpl$sendRequestOnFlow$1(LiveBaseRequest<? extends T> liveBaseRequest, LiveNetRequestImpl liveNetRequestImpl, Continuation<? super LiveNetRequestImpl$sendRequestOnFlow$1> continuation) {
        super(2, continuation);
        this.$request = liveBaseRequest;
        this.this$0 = liveNetRequestImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        LiveNetRequestImpl$sendRequestOnFlow$1 liveNetRequestImpl$sendRequestOnFlow$1 = new LiveNetRequestImpl$sendRequestOnFlow$1(this.$request, this.this$0, continuation);
        liveNetRequestImpl$sendRequestOnFlow$1.L$0 = obj;
        return liveNetRequestImpl$sendRequestOnFlow$1;
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
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            a.Companion companion = rt0.a.INSTANCE;
            if (companion.l()) {
                companion.g(LiveNetRequestImpl.LOG_TAG, "sendRequestOnFlow", "cmd=" + LiveNetRequestImplKt.getFullCmd(this.$request));
            }
            if (this.$request.needLogin()) {
                LiveNetRequestImpl liveNetRequestImpl = this.this$0;
                String wantAppId = this.$request.getWantAppId();
                final LiveBaseRequest<T> liveBaseRequest = this.$request;
                final LiveNetRequestImpl liveNetRequestImpl2 = this.this$0;
                liveNetRequestImpl.doLogin(wantAppId, new Function1<QQLiveResponse<LiveLoginInfo>, Unit>() { // from class: com.tencent.mobileqq.icgame.api.impl.LiveNetRequestImpl$sendRequestOnFlow$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<LiveLoginInfo> qQLiveResponse) {
                        invoke2(qQLiveResponse);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull QQLiveResponse<LiveLoginInfo> it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        if (it.isFailed()) {
                            rt0.a.INSTANCE.h(LiveNetRequestImpl.LOG_TAG, "sendRequestOnFlow", "login failed, " + it.getRetCode() + ", " + it.getErrMsg());
                            producerScope.mo2003trySendJP2dKIU(new QQLiveResponse<>(null, it.isSuccess(), it.getRetCode(), it.getErrMsg(), null));
                            return;
                        }
                        rt0.a.INSTANCE.g(LiveNetRequestImpl.LOG_TAG, "sendRequestOnFlow", "login success");
                        liveBaseRequest.setLoginInfo(it.getRsp());
                        LiveNetRequestImpl liveNetRequestImpl3 = liveNetRequestImpl2;
                        LiveBaseRequest<T> liveBaseRequest2 = liveBaseRequest;
                        final ProducerScope<QQLiveResponse<T>> producerScope2 = producerScope;
                        liveNetRequestImpl3.sendRequestWrapper(liveBaseRequest2, new Function1<QQLiveResponse<T>, Unit>() { // from class: com.tencent.mobileqq.icgame.api.impl.LiveNetRequestImpl.sendRequestOnFlow.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Object obj2) {
                                invoke((QQLiveResponse) obj2);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@NotNull QQLiveResponse<T> res) {
                                Intrinsics.checkNotNullParameter(res, "res");
                                producerScope2.mo2003trySendJP2dKIU(res);
                            }
                        });
                    }
                });
            } else {
                this.$request.setLoginInfo(null);
                this.this$0.sendRequestWrapper(this.$request, new Function1<QQLiveResponse<T>, Unit>() { // from class: com.tencent.mobileqq.icgame.api.impl.LiveNetRequestImpl$sendRequestOnFlow$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Object obj2) {
                        invoke((QQLiveResponse) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull QQLiveResponse<T> res) {
                        Intrinsics.checkNotNullParameter(res, "res");
                        producerScope.mo2003trySendJP2dKIU(res);
                    }
                });
            }
            final LiveBaseRequest<T> liveBaseRequest2 = this.$request;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.icgame.api.impl.LiveNetRequestImpl$sendRequestOnFlow$1.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                    rt0.a.INSTANCE.k(LiveNetRequestImpl.LOG_TAG, "sendRequestOnFlow", "close, " + LiveNetRequestImplKt.getFullCmd(liveBaseRequest2));
                }
            };
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super QQLiveResponse<T>> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((LiveNetRequestImpl$sendRequestOnFlow$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
