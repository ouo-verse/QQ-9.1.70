package com.tencent.ecommerce.biz.applysample;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.ecommerce.base.ktx.RepeatOnLifecycleKt;
import com.tencent.ecommerce.base.ui.d;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.repo.aftersale.apply.OptionValue;
import com.tencent.mobileqq.R;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke", "com/tencent/ecommerce/biz/applysample/ECAbortFulfillOrderFragment$tryAbortFulfillOrder$1$1"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECAbortFulfillOrderFragment$tryAbortFulfillOrder$$inlined$apply$lambda$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ OptionValue $reason$inlined;
    final /* synthetic */ ECAbortFulfillOrderFragment this$0;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/ecommerce/base/ktx/RepeatOnLifecycleKt$launchAndRepeatWithViewLifecycle$1", "com/tencent/ecommerce/biz/applysample/ECAbortFulfillOrderFragment$tryAbortFulfillOrder$1$1$$special$$inlined$launchAndRepeatWithViewLifecycle$1"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "com.tencent.ecommerce.biz.applysample.ECAbortFulfillOrderFragment$tryAbortFulfillOrder$1$1$$special$$inlined$launchAndRepeatWithViewLifecycle$1", f = "ECAbortFulfillOrderFragment.kt", i = {}, l = {166}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.ecommerce.biz.applysample.ECAbortFulfillOrderFragment$tryAbortFulfillOrder$$inlined$apply$lambda$1$1, reason: invalid class name */
    /* loaded from: classes31.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ d $dialog$inlined;
        final /* synthetic */ Lifecycle.State $minActiveState;
        final /* synthetic */ Fragment $this_launchAndRepeatWithViewLifecycle;
        int label;
        final /* synthetic */ ECAbortFulfillOrderFragment$tryAbortFulfillOrder$$inlined$apply$lambda$1 this$0;

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/ecommerce/base/ktx/RepeatOnLifecycleKt$launchAndRepeatWithViewLifecycle$1$1", "com/tencent/ecommerce/biz/applysample/ECAbortFulfillOrderFragment$tryAbortFulfillOrder$1$1$$special$$inlined$launchAndRepeatWithViewLifecycle$1$1"}, k = 3, mv = {1, 4, 1})
        @DebugMetadata(c = "com.tencent.ecommerce.biz.applysample.ECAbortFulfillOrderFragment$tryAbortFulfillOrder$1$1$$special$$inlined$launchAndRepeatWithViewLifecycle$1$1", f = "ECAbortFulfillOrderFragment.kt", i = {}, l = {192}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.tencent.ecommerce.biz.applysample.ECAbortFulfillOrderFragment$tryAbortFulfillOrder$$inlined$apply$lambda$1$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes31.dex */
        public static final class C10401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "com/tencent/ecommerce/biz/applysample/ECAbortFulfillOrderFragment$tryAbortFulfillOrder$1$1$$special$$inlined$launchAndRepeatWithViewLifecycle$1$1$lambda$1"}, k = 1, mv = {1, 4, 1})
            /* renamed from: com.tencent.ecommerce.biz.applysample.ECAbortFulfillOrderFragment$tryAbortFulfillOrder$$inlined$apply$lambda$1$1$1$a */
            /* loaded from: classes31.dex */
            public static final class a implements FlowCollector<Boolean> {
                public a() {
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                public Object emit(Boolean bool, Continuation continuation) {
                    boolean booleanValue = bool.booleanValue();
                    AnonymousClass1.this.$dialog$inlined.dismiss();
                    if (booleanValue) {
                        Intent intent = new Intent();
                        intent.putExtra("abort_apply_sample_result", true);
                        i.e(i.f101155b, R.string.wfk, null, 0, 6, null);
                        AnonymousClass1.this.this$0.this$0.requireActivity().setResult(-1, intent);
                        AnonymousClass1.this.this$0.this$0.requireActivity().finish();
                    } else {
                        i.e(i.f101155b, R.string.wfj, null, 0, 6, null);
                    }
                    return Unit.INSTANCE;
                }
            }

            public C10401(Continuation continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C10401 c10401 = new C10401(continuation);
                c10401.L$0 = obj;
                return c10401;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C10401) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended;
                ECAbortFulfillOrderViewModel Th;
                String str;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = this.label;
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    AnonymousClass1.this.$dialog$inlined.show();
                    Th = AnonymousClass1.this.this$0.this$0.Th();
                    str = AnonymousClass1.this.this$0.this$0.com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID java.lang.String;
                    ECAbortFulfillOrderFragment$tryAbortFulfillOrder$$inlined$apply$lambda$1 eCAbortFulfillOrderFragment$tryAbortFulfillOrder$$inlined$apply$lambda$1 = AnonymousClass1.this.this$0;
                    Flow<Boolean> P1 = Th.P1(str, eCAbortFulfillOrderFragment$tryAbortFulfillOrder$$inlined$apply$lambda$1.$reason$inlined, ECAbortFulfillOrderFragment.Lh(eCAbortFulfillOrderFragment$tryAbortFulfillOrder$$inlined$apply$lambda$1.this$0).getText().toString());
                    a aVar = new a();
                    this.label = 1;
                    if (P1.collect(aVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Fragment fragment, Lifecycle.State state, Continuation continuation, ECAbortFulfillOrderFragment$tryAbortFulfillOrder$$inlined$apply$lambda$1 eCAbortFulfillOrderFragment$tryAbortFulfillOrder$$inlined$apply$lambda$1, d dVar) {
            super(2, continuation);
            this.$this_launchAndRepeatWithViewLifecycle = fragment;
            this.$minActiveState = state;
            this.this$0 = eCAbortFulfillOrderFragment$tryAbortFulfillOrder$$inlined$apply$lambda$1;
            this.$dialog$inlined = dVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$this_launchAndRepeatWithViewLifecycle, this.$minActiveState, continuation, this.this$0, this.$dialog$inlined);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                Lifecycle lifecycle = this.$this_launchAndRepeatWithViewLifecycle.getViewLifecycleOwner().getLifecycle();
                Lifecycle.State state = this.$minActiveState;
                C10401 c10401 = new C10401(null);
                this.label = 1;
                if (RepeatOnLifecycleKt.a(lifecycle, state, c10401, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel", "com/tencent/ecommerce/biz/applysample/ECAbortFulfillOrderFragment$tryAbortFulfillOrder$1$1$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements DialogInterface.OnCancelListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Job f101335d;

        a(Job job) {
            this.f101335d = job;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            Job.DefaultImpls.cancel$default(this.f101335d, (CancellationException) null, 1, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECAbortFulfillOrderFragment$tryAbortFulfillOrder$$inlined$apply$lambda$1(ECAbortFulfillOrderFragment eCAbortFulfillOrderFragment, OptionValue optionValue) {
        super(1);
        this.this$0 = eCAbortFulfillOrderFragment;
        this.$reason$inlined = optionValue;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Job launch$default;
        String str;
        d dVar = new d(this.this$0.requireContext(), this.this$0.requireContext().getString(R.string.wfl));
        ECAbortFulfillOrderFragment eCAbortFulfillOrderFragment = this.this$0;
        launch$default = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(eCAbortFulfillOrderFragment.getViewLifecycleOwner()), null, null, new AnonymousClass1(eCAbortFulfillOrderFragment, Lifecycle.State.STARTED, null, this, dVar), 3, null);
        dVar.setOnCancelListener(new a(launch$default));
        com.tencent.ecommerce.biz.applysample.a aVar = com.tencent.ecommerce.biz.applysample.a.f101341a;
        str = this.this$0.com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID java.lang.String;
        aVar.a(str, true);
    }
}
