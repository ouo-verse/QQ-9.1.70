package com.tencent.ecommerce.biz.showwindow.fragment;

import ck0.Product;
import com.tencent.ecommerce.biz.showwindow.viewmodel.ECShowWindowViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/ecommerce/biz/showwindow/fragment/ECShowWindowFragment$updateProductAddBtnVisibility$1$1"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.showwindow.fragment.ECShowWindowFragment$updateProductAddBtnVisibility$1$1", f = "ECShowWindowFragment.kt", i = {}, l = {1145}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECShowWindowFragment$updateProductAddBtnVisibility$$inlined$run$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isVisible$inlined;
    int label;
    final /* synthetic */ ECShowWindowFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/ecommerce/biz/showwindow/fragment/ECShowWindowFragment$updateProductAddBtnVisibility$1$1$1"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "com.tencent.ecommerce.biz.showwindow.fragment.ECShowWindowFragment$updateProductAddBtnVisibility$1$1$1", f = "ECShowWindowFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.ecommerce.biz.showwindow.fragment.ECShowWindowFragment$updateProductAddBtnVisibility$$inlined$run$lambda$1$1, reason: invalid class name */
    /* loaded from: classes31.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ECShowWindowViewModel zi5 = ECShowWindowFragment.zi(ECShowWindowFragment$updateProductAddBtnVisibility$$inlined$run$lambda$1.this.this$0);
                List<Product> value = ECShowWindowFragment.zi(ECShowWindowFragment$updateProductAddBtnVisibility$$inlined$run$lambda$1.this.this$0).A2().getValue();
                zi5.v3(value != null ? CollectionsKt___CollectionsKt.toList(value) : null, ECShowWindowFragment$updateProductAddBtnVisibility$$inlined$run$lambda$1.this.$isVisible$inlined);
                ECShowWindowFragment.zi(ECShowWindowFragment$updateProductAddBtnVisibility$$inlined$run$lambda$1.this.this$0).w3();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShowWindowFragment$updateProductAddBtnVisibility$$inlined$run$lambda$1(Continuation continuation, ECShowWindowFragment eCShowWindowFragment, boolean z16) {
        super(2, continuation);
        this.this$0 = eCShowWindowFragment;
        this.$isVisible$inlined = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECShowWindowFragment$updateProductAddBtnVisibility$$inlined$run$lambda$1(continuation, this.this$0, this.$isVisible$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECShowWindowFragment$updateProductAddBtnVisibility$$inlined$run$lambda$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher io5 = Dispatchers.getIO();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
            this.label = 1;
            if (BuildersKt.withContext(io5, anonymousClass1, this) == coroutine_suspended) {
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
