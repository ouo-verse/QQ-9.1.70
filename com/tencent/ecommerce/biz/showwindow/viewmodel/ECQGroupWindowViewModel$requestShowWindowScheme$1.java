package com.tencent.ecommerce.biz.showwindow.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.ecommerce.base.config.service.ECLocalConfig;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.showwindow.viewmodel.ECQGroupWindowViewModel$requestShowWindowScheme$1", f = "ECQGroupWindowViewModel.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECQGroupWindowViewModel$requestShowWindowScheme$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $groupId;
    int label;
    final /* synthetic */ ECQGroupWindowViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECQGroupWindowViewModel$requestShowWindowScheme$1(ECQGroupWindowViewModel eCQGroupWindowViewModel, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCQGroupWindowViewModel;
        this.$groupId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECQGroupWindowViewModel$requestShowWindowScheme$1(this.this$0, this.$groupId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECQGroupWindowViewModel$requestShowWindowScheme$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ECQGroupWindowViewModel eCQGroupWindowViewModel = this.this$0;
            String str = this.$groupId;
            this.label = 1;
            obj = ECQGroupWindowViewModel.O1(eCQGroupWindowViewModel, str, null, this, 2, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject != null) {
            String P1 = this.this$0.P1(this.$groupId);
            String optString = jSONObject.optString("url", "");
            int optInt = jSONObject.optInt("window_type", 0);
            cg0.a.b("ECQGroupWindowViewModel", "[showWindowSchemeLiveData] oldScheme=" + P1 + " scheme=" + optString + ", windowType=" + optInt);
            this.this$0.S1(this.$groupId, optString);
            mutableLiveData2 = this.this$0._showWindowScheme;
            mutableLiveData2.postValue(optString);
            fj0.a.f399472a.b(this.$groupId, optInt);
        } else {
            ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.viewmodel.ECQGroupWindowViewModel$requestShowWindowScheme$1.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    i.f101155b.d("\u8bf7\u6c42\u6a71\u7a97\u94fe\u63a5\u5931\u8d25", ECToastIcon.ICON_NONE, 0);
                }
            });
            ECLocalConfig.f100650f.remove("show_window_scheme", Boxing.boxBoolean(true));
            mutableLiveData = this.this$0._showWindowScheme;
            mutableLiveData.postValue("");
        }
        return Unit.INSTANCE;
    }
}
