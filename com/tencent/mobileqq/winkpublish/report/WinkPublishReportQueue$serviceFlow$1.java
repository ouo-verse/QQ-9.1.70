package com.tencent.mobileqq.winkpublish.report;

import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.mobileqq.winkpublish.report.WinkPublishReportQueue;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tencent/mobileqq/winkpublish/report/WinkPublishReportQueue$ReportBundle;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.winkpublish.report.WinkPublishReportQueue$serviceFlow$1", f = "WinkPublishReportQueue.kt", i = {}, l = {177}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkPublishReportQueue$serviceFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super WinkPublishReportQueue.ReportBundle>, Continuation<? super Unit>, Object> {
    final /* synthetic */ WinkPublishReportQueue.ReportBundle $reportBundle;
    private /* synthetic */ Object L$0;
    int label;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/winkpublish/report/WinkPublishReportQueue$serviceFlow$1$a", "Lcom/tencent/mobileqq/winkpublish/WinkPublishHelper2$Callback;", "Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "service", "", "onServiceConnected", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements WinkPublishHelper2.Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WinkPublishReportQueue.ReportBundle f327384a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ProducerScope<WinkPublishReportQueue.ReportBundle> f327385b;

        /* JADX WARN: Multi-variable type inference failed */
        a(WinkPublishReportQueue.ReportBundle reportBundle, ProducerScope<? super WinkPublishReportQueue.ReportBundle> producerScope) {
            this.f327384a = reportBundle;
            this.f327385b = producerScope;
        }

        @Override // com.tencent.mobileqq.winkpublish.WinkPublishHelper2.Callback
        public void onServiceConnected(@NotNull WinkPublishServiceProxy2 service) {
            Intrinsics.checkNotNullParameter(service, "service");
            this.f327384a.setService(service);
            try {
                this.f327385b.mo2003trySendJP2dKIU(this.f327384a);
            } catch (Exception e16) {
                QLog.i(WinkPublishReportQueue.TAG, 1, "WinkPublishReportQueue offer error:" + e16);
            }
            SendChannel.DefaultImpls.close$default(this.f327385b.getChannel(), null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkPublishReportQueue$serviceFlow$1(WinkPublishReportQueue.ReportBundle reportBundle, Continuation<? super WinkPublishReportQueue$serviceFlow$1> continuation) {
        super(2, continuation);
        this.$reportBundle = reportBundle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        WinkPublishReportQueue$serviceFlow$1 winkPublishReportQueue$serviceFlow$1 = new WinkPublishReportQueue$serviceFlow$1(this.$reportBundle, continuation);
        winkPublishReportQueue$serviceFlow$1.L$0 = obj;
        return winkPublishReportQueue$serviceFlow$1;
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
            ProducerScope producerScope = (ProducerScope) this.L$0;
            WinkPublishHelper2 winkPublishHelper2 = WinkPublishHelper2.INSTANCE;
            WinkPublishServiceProxy2 service = winkPublishHelper2.getService(this.$reportBundle.getBusinessType());
            if (service != null) {
                this.$reportBundle.setService(service);
                try {
                    producerScope.mo2003trySendJP2dKIU(this.$reportBundle);
                } catch (Exception e16) {
                    QLog.i(WinkPublishReportQueue.TAG, 1, "WinkPublishReportQueue offer error:" + e16);
                }
                SendChannel.DefaultImpls.close$default(producerScope.getChannel(), null, 1, null);
            } else {
                QLog.i(WinkPublishReportQueue.TAG, 1, "[serviceFlow] no service yet");
                winkPublishHelper2.bindService(this.$reportBundle.getBusinessType(), new a(this.$reportBundle, producerScope));
            }
            AnonymousClass2 anonymousClass2 = new Function0<Unit>() { // from class: com.tencent.mobileqq.winkpublish.report.WinkPublishReportQueue$serviceFlow$1.2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    QLog.d(WinkPublishReportQueue.TAG, 4, "[serviceFlow] callbackFlow close");
                }
            };
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, anonymousClass2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super WinkPublishReportQueue.ReportBundle> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkPublishReportQueue$serviceFlow$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
