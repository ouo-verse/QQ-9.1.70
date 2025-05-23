package com.tencent.ecommerce.biz.showwindow.editor.ui;

import androidx.lifecycle.MutableLiveData;
import com.tencent.ecommerce.biz.showwindow.editor.network.ECProductCardEditorRepo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.showwindow.editor.ui.ECProductCardEditorViewModel$requestNetworkProductInfo$1", f = "ECProductCardEditorViewModel.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECProductCardEditorViewModel$requestNetworkProductInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef $requestParams;
    int label;
    final /* synthetic */ ECProductCardEditorViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "com.tencent.ecommerce.biz.showwindow.editor.ui.ECProductCardEditorViewModel$requestNetworkProductInfo$1$1", f = "ECProductCardEditorViewModel.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.ecommerce.biz.showwindow.editor.ui.ECProductCardEditorViewModel$requestNetworkProductInfo$1$1, reason: invalid class name */
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

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            ECProductCardEditorRepo Q1;
            MutableLiveData mutableLiveData;
            MutableLiveData mutableLiveData2;
            MutableLiveData mutableLiveData3;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                Q1 = ECProductCardEditorViewModel$requestNetworkProductInfo$1.this.this$0.Q1();
                JSONObject jSONObject = (JSONObject) ECProductCardEditorViewModel$requestNetworkProductInfo$1.this.$requestParams.element;
                this.label = 1;
                obj = Q1.a(jSONObject, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            JSONObject jSONObject2 = (JSONObject) obj;
            if (jSONObject2 != null) {
                mutableLiveData2 = ECProductCardEditorViewModel$requestNetworkProductInfo$1.this.this$0._hasNetworkData;
                mutableLiveData2.postValue(Boxing.boxBoolean(true));
                cg0.a.b("ECProductCardEditorViewModel", "Get data from remote" + jSONObject2);
                mutableLiveData3 = ECProductCardEditorViewModel$requestNetworkProductInfo$1.this.this$0._productInfo;
                mutableLiveData3.postValue(jSONObject2);
            } else {
                mutableLiveData = ECProductCardEditorViewModel$requestNetworkProductInfo$1.this.this$0._hasNetworkData;
                mutableLiveData.postValue(Boxing.boxBoolean(false));
                cg0.a.b("ECProductCardEditorViewModel", "No network data from server");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECProductCardEditorViewModel$requestNetworkProductInfo$1(ECProductCardEditorViewModel eCProductCardEditorViewModel, Ref.ObjectRef objectRef, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCProductCardEditorViewModel;
        this.$requestParams = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECProductCardEditorViewModel$requestNetworkProductInfo$1(this.this$0, this.$requestParams, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECProductCardEditorViewModel$requestNetworkProductInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
