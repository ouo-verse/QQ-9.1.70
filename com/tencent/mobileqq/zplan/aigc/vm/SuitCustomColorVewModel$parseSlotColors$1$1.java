package com.tencent.mobileqq.zplan.aigc.vm;

import com.tencent.mobileqq.zplan.aigc.helper.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.vm.SuitCustomColorVewModel$parseSlotColors$1$1", f = "SuitCustomColorVewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class SuitCustomColorVewModel$parseSlotColors$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    final /* synthetic */ String $gltfPath;
    int label;
    final /* synthetic */ SuitCustomColorVewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SuitCustomColorVewModel$parseSlotColors$1$1(String str, SuitCustomColorVewModel suitCustomColorVewModel, Function1<? super Boolean, Unit> function1, Continuation<? super SuitCustomColorVewModel$parseSlotColors$1$1> continuation) {
        super(2, continuation);
        this.$gltfPath = str;
        this.this$0 = suitCustomColorVewModel;
        this.$callback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SuitCustomColorVewModel$parseSlotColors$1$1(this.$gltfPath, this.this$0, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List list;
        List list2;
        List list3;
        List list4;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            c.UGCMaterialInfo b16 = com.tencent.mobileqq.zplan.aigc.helper.c.f330295a.b(this.$gltfPath);
            SuitCustomColorVewModel suitCustomColorVewModel = this.this$0;
            suitCustomColorVewModel.ugcMaterialList = b16.b();
            suitCustomColorVewModel.t3(b16.a());
            list = this.this$0.ugcMaterialList;
            if (!list.isEmpty()) {
                this.this$0.e3();
                list2 = this.this$0.ugcMaterialList;
                if (list2.size() > 0) {
                    SuitCustomColorVewModel suitCustomColorVewModel2 = this.this$0;
                    list3 = suitCustomColorVewModel2.ugcMaterialList;
                    String baseColorFileAbsolutePath = ((c.UGCMaterial) list3.get(0)).getBaseColorFileAbsolutePath();
                    list4 = this.this$0.ugcMaterialList;
                    suitCustomColorVewModel2.D2(baseColorFileAbsolutePath, ((c.UGCMaterial) list4.get(0)).getIsSRGB());
                }
                this.$callback.invoke(Boxing.boxBoolean(true));
                return Unit.INSTANCE;
            }
            this.$callback.invoke(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuitCustomColorVewModel$parseSlotColors$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
