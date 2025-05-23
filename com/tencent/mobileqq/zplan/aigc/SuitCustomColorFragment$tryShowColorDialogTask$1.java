package com.tencent.mobileqq.zplan.aigc;

import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.zplan.aigc.helper.ZplanUgcDyeingDialogHelper;
import com.tencent.mobileqq.zplan.aigc.vm.SuitCustomColorVewModel;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.SuitCustomColorFragment$tryShowColorDialogTask$1", f = "SuitCustomColorFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class SuitCustomColorFragment$tryShowColorDialogTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $price;
    int label;
    final /* synthetic */ SuitCustomColorFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitCustomColorFragment$tryShowColorDialogTask$1(SuitCustomColorFragment suitCustomColorFragment, int i3, Continuation<? super SuitCustomColorFragment$tryShowColorDialogTask$1> continuation) {
        super(2, continuation);
        this.this$0 = suitCustomColorFragment;
        this.$price = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SuitCustomColorFragment$tryShowColorDialogTask$1(this.this$0, this.$price, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            SuitCustomColorVewModel suitCustomColorVewModel = this.this$0.vm;
            SuitCustomColorVewModel suitCustomColorVewModel2 = null;
            if (suitCustomColorVewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                suitCustomColorVewModel = null;
            }
            SuitCustomColorVewModel suitCustomColorVewModel3 = this.this$0.vm;
            if (suitCustomColorVewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                suitCustomColorVewModel3 = null;
            }
            String valueOf = String.valueOf(suitCustomColorVewModel3.getSlotId());
            SuitCustomColorVewModel suitCustomColorVewModel4 = this.this$0.vm;
            if (suitCustomColorVewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
            } else {
                suitCustomColorVewModel2 = suitCustomColorVewModel4;
            }
            suitCustomColorVewModel.G2(valueOf, String.valueOf(suitCustomColorVewModel2.getUgcId()), this.this$0.getContext());
            final SuitCustomColorFragment suitCustomColorFragment = this.this$0;
            final int i3 = this.$price;
            CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCustomColorFragment$tryShowColorDialogTask$1.1
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
                    ZplanUgcDyeingDialogHelper zplanUgcDyeingDialogHelper;
                    FrameLayout Sh;
                    if (SuitCustomColorFragment.this.getView() == null) {
                        return;
                    }
                    zplanUgcDyeingDialogHelper = SuitCustomColorFragment.this.colorPanel;
                    SuitCustomColorVewModel suitCustomColorVewModel5 = null;
                    if (zplanUgcDyeingDialogHelper == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("colorPanel");
                        zplanUgcDyeingDialogHelper = null;
                    }
                    SuitCustomColorVewModel suitCustomColorVewModel6 = SuitCustomColorFragment.this.vm;
                    if (suitCustomColorVewModel6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("vm");
                    } else {
                        suitCustomColorVewModel5 = suitCustomColorVewModel6;
                    }
                    int slotId = suitCustomColorVewModel5.getSlotId();
                    int i16 = i3;
                    Sh = SuitCustomColorFragment.this.Sh();
                    LifecycleOwner viewLifecycleOwner = SuitCustomColorFragment.this.getViewLifecycleOwner();
                    Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
                    zplanUgcDyeingDialogHelper.U(slotId, i16, Sh, viewLifecycleOwner);
                    SuitCustomColorFragment.this.ki();
                    SuitCustomColorFragment.this.Lh(true);
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuitCustomColorFragment$tryShowColorDialogTask$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
