package com.tencent.ecommerce.biz.comment;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.ktx.RepeatOnLifecycleKt;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.g;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.biz.comment.ECQShopCommentFragment;
import com.tencent.ecommerce.biz.comment.ECQShopCommentViewModel;
import com.tencent.ecommerce.biz.submitsucceed.ECSubmitSucceedFragment;
import com.tencent.ecommerce.biz.submitsucceed.SubmitSucceedFrom;
import com.tencent.ecommerce.biz.submitsucceed.SubmitSucceedUIState;
import com.tencent.ecommerce.repo.comment.ECQShopOrderCommentInfo;
import com.tencent.mobileqq.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.comment.ECQShopCommentFragment$publishComment$$inlined$launchAndRepeatWithViewLifecycle$1", f = "ECQShopCommentFragment.kt", i = {}, l = {166}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECQShopCommentFragment$publishComment$$inlined$launchAndRepeatWithViewLifecycle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ECQShopOrderCommentInfo $commentInfo$inlined;
    final /* synthetic */ Lifecycle.State $minActiveState;
    final /* synthetic */ Fragment $this_launchAndRepeatWithViewLifecycle;
    int label;
    final /* synthetic */ ECQShopCommentFragment this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "com.tencent.ecommerce.biz.comment.ECQShopCommentFragment$publishComment$$inlined$launchAndRepeatWithViewLifecycle$1$1", f = "ECQShopCommentFragment.kt", i = {}, l = {187}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.ecommerce.biz.comment.ECQShopCommentFragment$publishComment$$inlined$launchAndRepeatWithViewLifecycle$1$1, reason: invalid class name */
    /* loaded from: classes31.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            ECQShopCommentViewModel Qh;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                Qh = ECQShopCommentFragment$publishComment$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.Qh();
                Flow<ECQShopCommentViewModel.c> M1 = Qh.M1(ECQShopCommentFragment$publishComment$$inlined$launchAndRepeatWithViewLifecycle$1.this.$commentInfo$inlined);
                FlowCollector<ECQShopCommentViewModel.c> flowCollector = new FlowCollector<ECQShopCommentViewModel.c>() { // from class: com.tencent.ecommerce.biz.comment.ECQShopCommentFragment$publishComment$$inlined$launchAndRepeatWithViewLifecycle$1$1$lambda$1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public Object emit(ECQShopCommentViewModel.c cVar, Continuation continuation) {
                        Dialog dialog;
                        String str;
                        List<String> listOf;
                        String str2;
                        String str3;
                        final ECQShopCommentViewModel.c cVar2 = cVar;
                        dialog = ECQShopCommentFragment$publishComment$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.loadingDialog;
                        if (dialog != null) {
                            dialog.dismiss();
                        }
                        if (cVar2 instanceof ECQShopCommentViewModel.c.a) {
                            i.f101155b.c(R.string.wqg, ECToastIcon.ICON_DEFAULT, 0);
                        } else if (cVar2 instanceof ECQShopCommentViewModel.c.b) {
                            g gVar = new g(ECQShopCommentFragment$publishComment$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.requireContext());
                            gVar.Y(ECQShopCommentFragment$publishComment$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.getResources().getString(R.string.wqj));
                            gVar.b0("");
                            gVar.f0(ECQShopCommentFragment$publishComment$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.getResources().getString(R.string.wi6));
                            gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.comment.ECQShopCommentFragment$publishComment$$inlined$launchAndRepeatWithViewLifecycle$1$1$lambda$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                                    invoke2(view);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(View view) {
                                    LifecycleEventBus.f100688b.f(new ECQShopCommentFragment.b(((ECQShopCommentViewModel.c.b) ECQShopCommentViewModel.c.this).com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams.KEY_COMMENT_ID java.lang.String));
                                    ECQShopCommentFragment$publishComment$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.requireActivity().finish();
                                }
                            });
                            gVar.show();
                        } else if (cVar2 instanceof ECQShopCommentViewModel.c.C1044c) {
                            SubmitSucceedUIState submitSucceedUIState = new SubmitSucceedUIState(ECQShopCommentFragment$publishComment$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.getString(R.string.wq9), ECQShopCommentFragment$publishComment$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.getString(R.string.wqa), ECQShopCommentFragment$publishComment$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.getString(R.string.wrq));
                            ECSubmitSucceedFragment.Companion companion = ECSubmitSucceedFragment.INSTANCE;
                            Context requireContext = ECQShopCommentFragment$publishComment$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.requireContext();
                            SubmitSucceedFrom submitSucceedFrom = SubmitSucceedFrom.WRITE_COMMENT;
                            str = ECQShopCommentFragment$publishComment$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.spuId;
                            listOf = CollectionsKt__CollectionsJVMKt.listOf(str);
                            JSONObject jSONObject = new JSONObject();
                            str2 = ECQShopCommentFragment$publishComment$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID java.lang.String;
                            jSONObject.put("order_id", str2);
                            ECQShopCommentViewModel.c.C1044c c1044c = (ECQShopCommentViewModel.c.C1044c) cVar2;
                            jSONObject.put("comment_id", c1044c.com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams.KEY_COMMENT_ID java.lang.String);
                            str3 = ECQShopCommentFragment$publishComment$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.skuId;
                            jSONObject.put("sku_id", str3);
                            Unit unit = Unit.INSTANCE;
                            companion.a(requireContext, submitSucceedUIState, submitSucceedFrom, listOf, jSONObject);
                            LifecycleEventBus.f100688b.f(new ECQShopCommentFragment.b(c1044c.com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams.KEY_COMMENT_ID java.lang.String));
                            ECQShopCommentFragment$publishComment$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.requireActivity().finish();
                        }
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (M1.collect(flowCollector, this) == coroutine_suspended) {
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
    public ECQShopCommentFragment$publishComment$$inlined$launchAndRepeatWithViewLifecycle$1(Fragment fragment, Lifecycle.State state, Continuation continuation, ECQShopCommentFragment eCQShopCommentFragment, ECQShopOrderCommentInfo eCQShopOrderCommentInfo) {
        super(2, continuation);
        this.$this_launchAndRepeatWithViewLifecycle = fragment;
        this.$minActiveState = state;
        this.this$0 = eCQShopCommentFragment;
        this.$commentInfo$inlined = eCQShopOrderCommentInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECQShopCommentFragment$publishComment$$inlined$launchAndRepeatWithViewLifecycle$1(this.$this_launchAndRepeatWithViewLifecycle, this.$minActiveState, continuation, this.this$0, this.$commentInfo$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECQShopCommentFragment$publishComment$$inlined$launchAndRepeatWithViewLifecycle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
            this.label = 1;
            if (RepeatOnLifecycleKt.a(lifecycle, state, anonymousClass1, this) == coroutine_suspended) {
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
