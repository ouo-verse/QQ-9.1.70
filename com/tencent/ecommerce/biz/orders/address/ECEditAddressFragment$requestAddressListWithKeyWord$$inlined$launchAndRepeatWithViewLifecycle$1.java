package com.tencent.ecommerce.biz.orders.address;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.tencent.ecommerce.base.ktx.RepeatOnLifecycleKt;
import com.tencent.ecommerce.base.location.IECLocationServiceProxy;
import com.tencent.ecommerce.base.ui.SoftKeyboardStateHelper;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.biz.orders.address.ECEditAddressFragment;
import com.tencent.lbssearch.object.result.SuggestionResultObject;
import com.tencent.mobileqq.R;
import gi0.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.address.ECEditAddressFragment$requestAddressListWithKeyWord$$inlined$launchAndRepeatWithViewLifecycle$1", f = "ECEditAddressFragment.kt", i = {}, l = {166}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECEditAddressFragment$requestAddressListWithKeyWord$$inlined$launchAndRepeatWithViewLifecycle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $keyWord$inlined;
    final /* synthetic */ Lifecycle.State $minActiveState;
    final /* synthetic */ Fragment $this_launchAndRepeatWithViewLifecycle;
    int label;
    final /* synthetic */ ECEditAddressFragment this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "com.tencent.ecommerce.biz.orders.address.ECEditAddressFragment$requestAddressListWithKeyWord$$inlined$launchAndRepeatWithViewLifecycle$1$1", f = "ECEditAddressFragment.kt", i = {}, l = {190}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.ecommerce.biz.orders.address.ECEditAddressFragment$requestAddressListWithKeyWord$$inlined$launchAndRepeatWithViewLifecycle$1$1, reason: invalid class name */
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

        /* JADX WARN: Code restructure failed: missing block: B:13:0x003c, code lost:
        
            if (r6 != null) goto L14;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            String str;
            ECEditAddressViewModel ni5;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                ECEditAddressFragment.DistrictInfo districtInfo = ECEditAddressFragment$requestAddressListWithKeyWord$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.getDistrictInfo();
                if (districtInfo != null) {
                    str = districtInfo.province + districtInfo.city;
                }
                str = IECLocationServiceProxy.ALL_REGION;
                ni5 = ECEditAddressFragment$requestAddressListWithKeyWord$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.ni();
                Flow<SuggestionResultObject> N1 = ni5.N1(ECEditAddressFragment$requestAddressListWithKeyWord$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.requireContext(), ECEditAddressFragment$requestAddressListWithKeyWord$$inlined$launchAndRepeatWithViewLifecycle$1.this.$keyWord$inlined, str);
                FlowCollector<SuggestionResultObject> flowCollector = new FlowCollector<SuggestionResultObject>() { // from class: com.tencent.ecommerce.biz.orders.address.ECEditAddressFragment$requestAddressListWithKeyWord$$inlined$launchAndRepeatWithViewLifecycle$1$1$lambda$1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public Object emit(SuggestionResultObject suggestionResultObject, Continuation continuation) {
                        int collectionSizeOrDefault;
                        final SuggestionResultObject suggestionResultObject2 = suggestionResultObject;
                        if (suggestionResultObject2 != null && (!suggestionResultObject2.data.isEmpty())) {
                            List<SuggestionResultObject.SuggestionData> list = suggestionResultObject2.data;
                            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                            for (SuggestionResultObject.SuggestionData suggestionData : list) {
                                arrayList.add(new b.ItemData(suggestionData.title, suggestionData.address));
                            }
                            ECEditAddressFragment eCEditAddressFragment = ECEditAddressFragment$requestAddressListWithKeyWord$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0;
                            ECEditAddressFragment.xi(eCEditAddressFragment, ECEditAddressFragment.Qh(eCEditAddressFragment), null, arrayList, new Function1<Integer, Unit>() { // from class: com.tencent.ecommerce.biz.orders.address.ECEditAddressFragment$requestAddressListWithKeyWord$$inlined$launchAndRepeatWithViewLifecycle$1$1$lambda$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                    invoke(num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(int i16) {
                                    gi0.b bVar;
                                    SoftKeyboardStateHelper.INSTANCE.a(ECEditAddressFragment$requestAddressListWithKeyWord$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.requireActivity());
                                    ECEditAddressFragment$requestAddressListWithKeyWord$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.shouldShowPopupWindow = false;
                                    SuggestionResultObject.SuggestionData suggestionData2 = SuggestionResultObject.this.data.get(i16);
                                    ECEditAddressFragment.DistrictInfo districtInfo2 = new ECEditAddressFragment.DistrictInfo(suggestionData2.province, suggestionData2.city, suggestionData2.district, null, 8, null);
                                    if (!Intrinsics.areEqual(ECEditAddressFragment$requestAddressListWithKeyWord$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.getDistrictInfo(), districtInfo2)) {
                                        ECEditAddressFragment$requestAddressListWithKeyWord$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.vi(districtInfo2);
                                        i.e(i.f101155b, R.string.wo5, null, 0, 6, null);
                                    }
                                    ECEditAddressFragment.Rh(ECEditAddressFragment$requestAddressListWithKeyWord$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0).setText(suggestionData2.title);
                                    ECEditAddressFragment.Rh(ECEditAddressFragment$requestAddressListWithKeyWord$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0).setSelection(suggestionData2.title.length());
                                    bVar = ECEditAddressFragment$requestAddressListWithKeyWord$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.listPopupWindow;
                                    if (bVar != null) {
                                        bVar.dismiss();
                                    }
                                }
                            }, 2, null);
                        }
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (N1.collect(flowCollector, this) == coroutine_suspended) {
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
    public ECEditAddressFragment$requestAddressListWithKeyWord$$inlined$launchAndRepeatWithViewLifecycle$1(Fragment fragment, Lifecycle.State state, Continuation continuation, ECEditAddressFragment eCEditAddressFragment, String str) {
        super(2, continuation);
        this.$this_launchAndRepeatWithViewLifecycle = fragment;
        this.$minActiveState = state;
        this.this$0 = eCEditAddressFragment;
        this.$keyWord$inlined = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECEditAddressFragment$requestAddressListWithKeyWord$$inlined$launchAndRepeatWithViewLifecycle$1(this.$this_launchAndRepeatWithViewLifecycle, this.$minActiveState, continuation, this.this$0, this.$keyWord$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECEditAddressFragment$requestAddressListWithKeyWord$$inlined$launchAndRepeatWithViewLifecycle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
