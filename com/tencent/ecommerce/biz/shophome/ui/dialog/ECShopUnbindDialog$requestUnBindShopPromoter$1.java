package com.tencent.ecommerce.biz.shophome.ui.dialog;

import cg0.a;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.ui.ECBaseDialogFragment;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.biz.shophome.repo.ECShopHomeDefaultRepository;
import com.tencent.ecommerce.biz.shophome.repo.IECShopHomeRepository;
import com.tencent.ecommerce.biz.shophome.ui.dialog.ECShopUnbindDialog;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.apache.httpcore.message.TokenParser;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.shophome.ui.dialog.ECShopUnbindDialog$requestUnBindShopPromoter$1", f = "ECShopUnbindDialog.kt", i = {0}, l = {91, 96, 108}, m = "invokeSuspend", n = {"response"}, s = {"L$0"})
/* loaded from: classes31.dex */
public final class ECShopUnbindDialog$requestUnBindShopPromoter$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $shopId;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ECShopUnbindDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "com.tencent.ecommerce.biz.shophome.ui.dialog.ECShopUnbindDialog$requestUnBindShopPromoter$1$1", f = "ECShopUnbindDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.ecommerce.biz.shophome.ui.dialog.ECShopUnbindDialog$requestUnBindShopPromoter$1$1, reason: invalid class name */
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
                i.f101155b.c(R.string.wig, ECToastIcon.ICON_NONE, 0);
                ECShopUnbindDialog.yh(ECShopUnbindDialog$requestUnBindShopPromoter$1.this.this$0).setVisibility(8);
                ECBaseDialogFragment.th(ECShopUnbindDialog$requestUnBindShopPromoter$1.this.this$0, ECShopUnbindDialog.ECShopUnbindDialogResult.Confirm.f104367d, 0, 2, null);
                ECShopUnbindDialog$requestUnBindShopPromoter$1.this.this$0.dismiss();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "com.tencent.ecommerce.biz.shophome.ui.dialog.ECShopUnbindDialog$requestUnBindShopPromoter$1$2", f = "ECShopUnbindDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.ecommerce.biz.shophome.ui.dialog.ECShopUnbindDialog$requestUnBindShopPromoter$1$2, reason: invalid class name */
    /* loaded from: classes31.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef $response;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Ref.ObjectRef objectRef, Continuation continuation) {
            super(2, continuation);
            this.$response = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$response, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                i.f101155b.d(((ECNetworkResponse) this.$response.element).getMessage(), ECToastIcon.ICON_NONE, 0);
                ECShopUnbindDialog.yh(ECShopUnbindDialog$requestUnBindShopPromoter$1.this.this$0).setVisibility(8);
                ECBaseDialogFragment.th(ECShopUnbindDialog$requestUnBindShopPromoter$1.this.this$0, ECShopUnbindDialog.ECShopUnbindDialogResult.Cancel.f104366d, 0, 2, null);
                ECShopUnbindDialog$requestUnBindShopPromoter$1.this.this$0.dismiss();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopUnbindDialog$requestUnBindShopPromoter$1(ECShopUnbindDialog eCShopUnbindDialog, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCShopUnbindDialog;
        this.$shopId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECShopUnbindDialog$requestUnBindShopPromoter$1(this.this$0, this.$shopId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECShopUnbindDialog$requestUnBindShopPromoter$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v3, types: [com.tencent.ecommerce.base.network.api.d, T] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ECShopHomeDefaultRepository eCShopHomeDefaultRepository = ECShopHomeDefaultRepository.f104251a;
            objectRef = new Ref.ObjectRef();
            String str = this.$shopId;
            this.L$0 = objectRef;
            this.L$1 = objectRef;
            this.label = 1;
            obj = IECShopHomeRepository.a.f(eCShopHomeDefaultRepository, str, null, this, 2, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef2 = objectRef;
        } else {
            if (i3 != 1) {
                if (i3 != 2 && i3 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            objectRef = (Ref.ObjectRef) this.L$1;
            objectRef2 = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        objectRef.element = (ECNetworkResponse) obj;
        a.b("ECShopUnbindDialog", "response from backend " + ((ECNetworkResponse) objectRef2.element) + TokenParser.SP);
        if (((ECNetworkResponse) objectRef2.element).getCode() == 0) {
            a.b("ECShopUnbindDialog", "[unBindShopPromoter] \u89e3\u7ed1\u6210\u529f");
            MainCoroutineDispatcher main = Dispatchers.getMain();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
            if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            a.a("ECShopUnbindDialog", "[unBindShopPromoter]", "\u89e3\u7ed1\u5931\u8d25 code = " + ((ECNetworkResponse) objectRef2.element).getCode() + ", msg = " + ((ECNetworkResponse) objectRef2.element).getMessage());
            MainCoroutineDispatcher main2 = Dispatchers.getMain();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(objectRef2, null);
            this.L$0 = null;
            this.L$1 = null;
            this.label = 3;
            if (BuildersKt.withContext(main2, anonymousClass2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
