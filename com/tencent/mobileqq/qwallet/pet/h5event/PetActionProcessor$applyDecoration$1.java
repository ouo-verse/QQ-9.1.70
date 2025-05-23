package com.tencent.mobileqq.qwallet.pet.h5event;

import com.tencent.mobileqq.qwallet.pet.data.PetStateManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qwallet.pet.h5event.PetActionProcessor$applyDecoration$1", f = "PetActionProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes16.dex */
final class PetActionProcessor$applyDecoration$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PetH5Method $h5Action;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PetActionProcessor$applyDecoration$1(PetH5Method petH5Method, Continuation<? super PetActionProcessor$applyDecoration$1> continuation) {
        super(2, continuation);
        this.$h5Action = petH5Method;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PetActionProcessor$applyDecoration$1(this.$h5Action, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        JSONObject optJSONObject;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                optJSONObject = this.$h5Action.getRawJSON().optJSONObject("data");
            } catch (JSONException e16) {
                QLog.i("QWallet.Pet.PetActionProcessor", 1, "applyClothing error: " + e16);
            }
            if (optJSONObject == null) {
                return Unit.INSTANCE;
            }
            QLog.i("QWallet.Pet.PetActionProcessor", 1, "applyClothing: " + optJSONObject);
            List<String> h16 = jl2.b.f410584a.h(optJSONObject.optJSONArray("clothes"));
            if (h16 != null) {
                PetStateManager.f278740a.j(h16);
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("scenes");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                PetStateManager.f278740a.n(optJSONArray.getString(0));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PetActionProcessor$applyDecoration$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
