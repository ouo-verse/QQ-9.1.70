package com.tencent.mobileqq.qqlive.api.impl;

import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.login.LiveLoginInfo;
import com.tencent.qqlive.common.api.AegisLogger;
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

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002H\u008a@"}, d2 = {"Lcom/google/protobuf/nano/MessageNano;", "T", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tencent/mobileqq/qqlive/api/sso/QQLiveResponse;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqlive.api.impl.LiveNetRequestImpl$sendRequestOnFlow$1", f = "LiveNetRequestImpl.kt", i = {}, l = {186}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes17.dex */
final class LiveNetRequestImpl$sendRequestOnFlow$1<T> extends SuspendLambda implements Function2<ProducerScope<? super QQLiveResponse<T>>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, liveBaseRequest, liveNetRequestImpl, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        LiveNetRequestImpl$sendRequestOnFlow$1 liveNetRequestImpl$sendRequestOnFlow$1 = new LiveNetRequestImpl$sendRequestOnFlow$1(this.$request, this.this$0, continuation);
        liveNetRequestImpl$sendRequestOnFlow$1.L$0 = obj;
        return liveNetRequestImpl$sendRequestOnFlow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
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
                AegisLogger.Companion companion = AegisLogger.INSTANCE;
                if (companion.isColorLevel()) {
                    companion.d(LiveNetRequestImpl.LOG_TAG, "sendRequestOnFlow", "cmd=" + LiveNetRequestImplKt.getFullCmd(this.$request));
                }
                if (this.$request.needLogin()) {
                    this.this$0.doLogin(this.$request.getAppId(), new Function1<QQLiveResponse<LiveLoginInfo>, Unit>(producerScope, this.$request, this.this$0) { // from class: com.tencent.mobileqq.qqlive.api.impl.LiveNetRequestImpl$sendRequestOnFlow$1.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ ProducerScope<QQLiveResponse<T>> $$this$callbackFlow;
                        final /* synthetic */ LiveBaseRequest<T> $request;
                        final /* synthetic */ LiveNetRequestImpl this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                            this.$$this$callbackFlow = producerScope;
                            this.$request = r9;
                            this.this$0 = r10;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, producerScope, r9, r10);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<LiveLoginInfo> qQLiveResponse) {
                            invoke2(qQLiveResponse);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull QQLiveResponse<LiveLoginInfo> it) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                                return;
                            }
                            Intrinsics.checkNotNullParameter(it, "it");
                            if (it.isFailed()) {
                                AegisLogger.INSTANCE.e(LiveNetRequestImpl.LOG_TAG, "sendRequestOnFlow", "login failed, " + it.getRetCode() + ", " + it.getErrMsg());
                                this.$$this$callbackFlow.mo2003trySendJP2dKIU(new QQLiveResponse<>(null, it.isSuccess(), it.getRetCode(), it.getErrMsg(), null));
                                return;
                            }
                            this.$request.setLoginInfo(it.getRsp());
                            final LiveBaseRequest<T> liveBaseRequest = this.$request;
                            final ProducerScope<QQLiveResponse<T>> producerScope2 = this.$$this$callbackFlow;
                            VSNetworkHelper.getInstance().sendRequest(liveBaseRequest, new VSDispatchObserver.OnVSRspCallBack(producerScope2) { // from class: com.tencent.mobileqq.qqlive.api.impl.LiveNetRequestImpl$sendRequestOnFlow$1$1$invoke$$inlined$sendRequestWrapper$1
                                static IPatchRedirector $redirector_;
                                final /* synthetic */ ProducerScope $$this$callbackFlow$inlined;

                                {
                                    this.$$this$callbackFlow$inlined = producerScope2;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) LiveBaseRequest.this, (Object) producerScope2);
                                    }
                                }

                                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj2) {
                                    Object obj3;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, this, baseRequest, Boolean.valueOf(z16), Long.valueOf(j3), str, obj2);
                                        return;
                                    }
                                    if (obj2 == null) {
                                        obj3 = null;
                                    } else {
                                        obj3 = obj2;
                                    }
                                    QQLiveResponse qQLiveResponse = new QQLiveResponse(baseRequest, z16, j3, str, obj3);
                                    if (qQLiveResponse.isFailed()) {
                                        AegisLogger.INSTANCE.e(LiveNetRequestImpl.LOG_TAG, "sendRequestWrapper", "request failed, cmd=" + LiveNetRequestImplKt.getFullCmd(LiveBaseRequest.this) + ", retCode=" + j3 + ", errMsg=" + str);
                                    } else {
                                        AegisLogger.Companion companion2 = AegisLogger.INSTANCE;
                                        if (companion2.isColorLevel()) {
                                            companion2.d(LiveNetRequestImpl.LOG_TAG, "sendRequestWrapper", "request success, cmd=" + LiveNetRequestImplKt.getFullCmd(LiveBaseRequest.this));
                                        }
                                    }
                                    this.$$this$callbackFlow$inlined.mo2003trySendJP2dKIU(qQLiveResponse);
                                }
                            });
                        }
                    });
                } else {
                    this.$request.setLoginInfo(null);
                    final LiveBaseRequest<T> liveBaseRequest = this.$request;
                    VSNetworkHelper.getInstance().sendRequest(liveBaseRequest, new VSDispatchObserver.OnVSRspCallBack(producerScope) { // from class: com.tencent.mobileqq.qqlive.api.impl.LiveNetRequestImpl$sendRequestOnFlow$1$invokeSuspend$$inlined$sendRequestWrapper$1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ ProducerScope $$this$callbackFlow$inlined;

                        {
                            this.$$this$callbackFlow$inlined = producerScope;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LiveBaseRequest.this, (Object) producerScope);
                            }
                        }

                        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                        public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj2) {
                            Object obj3;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, this, baseRequest, Boolean.valueOf(z16), Long.valueOf(j3), str, obj2);
                                return;
                            }
                            if (obj2 == null) {
                                obj3 = null;
                            } else {
                                obj3 = obj2;
                            }
                            QQLiveResponse qQLiveResponse = new QQLiveResponse(baseRequest, z16, j3, str, obj3);
                            if (qQLiveResponse.isFailed()) {
                                AegisLogger.INSTANCE.e(LiveNetRequestImpl.LOG_TAG, "sendRequestWrapper", "request failed, cmd=" + LiveNetRequestImplKt.getFullCmd(LiveBaseRequest.this) + ", retCode=" + j3 + ", errMsg=" + str);
                            } else {
                                AegisLogger.Companion companion2 = AegisLogger.INSTANCE;
                                if (companion2.isColorLevel()) {
                                    companion2.d(LiveNetRequestImpl.LOG_TAG, "sendRequestWrapper", "request success, cmd=" + LiveNetRequestImplKt.getFullCmd(LiveBaseRequest.this));
                                }
                            }
                            this.$$this$callbackFlow$inlined.mo2003trySendJP2dKIU(qQLiveResponse);
                        }
                    });
                }
                Function0<Unit> function0 = new Function0<Unit>(this.$request) { // from class: com.tencent.mobileqq.qqlive.api.impl.LiveNetRequestImpl$sendRequestOnFlow$1.3
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ LiveBaseRequest<T> $request;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                        this.$request = r4;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) r4);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        AegisLogger.INSTANCE.i(LiveNetRequestImpl.LOG_TAG, "sendRequestOnFlow", "close, " + LiveNetRequestImplKt.getFullCmd(this.$request));
                    }
                };
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super QQLiveResponse<T>> producerScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((LiveNetRequestImpl$sendRequestOnFlow$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) producerScope, (Object) continuation);
    }
}
