package com.tencent.mobileqq.qqlive.room.livelabel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.sso.request.QQLiveGetSecondLabelsRequest;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqlive.room.livelabel.QQLiveLabelViewModel$getAllLabels$1", f = "QQLiveLabelViewModel.kt", i = {}, l = {114}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes17.dex */
public final class QQLiveLabelViewModel$getAllLabels$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    int label;
    final /* synthetic */ QQLiveLabelViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/sso/QQLiveResponse;", "Lf55/b;", "gameResponse", "videoResponse", "Lcom/tencent/mobileqq/qqlive/room/livelabel/j;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.qqlive.room.livelabel.QQLiveLabelViewModel$getAllLabels$1$1", f = "QQLiveLabelViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.qqlive.room.livelabel.QQLiveLabelViewModel$getAllLabels$1$1, reason: invalid class name */
    /* loaded from: classes17.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<QQLiveResponse<f55.b>, QQLiveResponse<f55.b>, Continuation<? super j>, Object> {
        static IPatchRedirector $redirector_;
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;
        final /* synthetic */ QQLiveLabelViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(QQLiveLabelViewModel qQLiveLabelViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
            this.this$0 = qQLiveLabelViewModel;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQLiveLabelViewModel, (Object) continuation);
            }
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        public final Object invoke(@NotNull QQLiveResponse<f55.b> qQLiveResponse, @NotNull QQLiveResponse<f55.b> qQLiveResponse2, @Nullable Continuation<? super j> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, this, qQLiveResponse, qQLiveResponse2, continuation);
            }
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = qQLiveResponse;
            anonymousClass1.L$1 = qQLiveResponse2;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            j U1;
            j U12;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    QQLiveResponse qQLiveResponse = (QQLiveResponse) this.L$0;
                    QQLiveResponse qQLiveResponse2 = (QQLiveResponse) this.L$1;
                    AegisLogger.Companion companion = AegisLogger.INSTANCE;
                    companion.i("Open_Live|QQLiveLabelViewModel", "getAllLabels", "gameResponse, isSuccess=" + qQLiveResponse.isSuccess() + ", retCode=" + qQLiveResponse.getRetCode() + ", errMsg=" + qQLiveResponse.getErrMsg());
                    companion.i("Open_Live|QQLiveLabelViewModel", "getAllLabels", "videoResponse, isSuccess=" + qQLiveResponse2.isSuccess() + ", retCode=" + qQLiveResponse2.getRetCode() + ", errMsg=" + qQLiveResponse2.getErrMsg());
                    U1 = this.this$0.U1(qQLiveResponse);
                    U12 = this.this$0.U1(qQLiveResponse2);
                    if (U1 != null) {
                        return U1.a(U12);
                    }
                    return U12;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a implements FlowCollector<j> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQLiveLabelViewModel f271616d;

        public a(QQLiveLabelViewModel qQLiveLabelViewModel) {
            this.f271616d = qQLiveLabelViewModel;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQLiveLabelViewModel);
            }
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(j jVar, @NotNull Continuation<? super Unit> continuation) {
            MutableLiveData mutableLiveData;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                mutableLiveData = this.f271616d._allLabels;
                mutableLiveData.postValue(jVar);
                return Unit.INSTANCE;
            }
            return iPatchRedirector.redirect((short) 2, (Object) this, (Object) jVar, (Object) continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveLabelViewModel$getAllLabels$1(QQLiveLabelViewModel qQLiveLabelViewModel, Continuation<? super QQLiveLabelViewModel$getAllLabels$1> continuation) {
        super(2, continuation);
        this.this$0 = qQLiveLabelViewModel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQLiveLabelViewModel, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new QQLiveLabelViewModel$getAllLabels$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ILiveNetRequest iLiveNetRequest;
        ILiveNetRequest iLiveNetRequest2;
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
                iLiveNetRequest = this.this$0.requestApi;
                Flow sendRequestOnFlow = iLiveNetRequest.sendRequestOnFlow(new QQLiveGetSecondLabelsRequest(2L));
                iLiveNetRequest2 = this.this$0.requestApi;
                Flow flowCombine = FlowKt.flowCombine(sendRequestOnFlow, iLiveNetRequest2.sendRequestOnFlow(new QQLiveGetSecondLabelsRequest(1L)), new AnonymousClass1(this.this$0, null));
                a aVar = new a(this.this$0);
                this.label = 1;
                if (flowCombine.collect(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((QQLiveLabelViewModel$getAllLabels$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
