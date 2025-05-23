package com.tencent.ecommerce.base.ui;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.base.ui.ECEnableSkinManager$init$1", f = "ECEnableSkinManager.kt", i = {1}, l = {46, 48}, m = "invokeSuspend", n = {"needUpdateSkinFile"}, s = {"Z$0"})
/* loaded from: classes32.dex */
final class ECEnableSkinManager$init$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    boolean Z$0;
    int label;
    final /* synthetic */ ECEnableSkinManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECEnableSkinManager$init$1(ECEnableSkinManager eCEnableSkinManager, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCEnableSkinManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECEnableSkinManager$init$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECEnableSkinManager$init$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0053  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        boolean booleanValue;
        boolean z16;
        String str;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ECEnableSkinManager eCEnableSkinManager = this.this$0;
            this.label = 1;
            obj = eCEnableSkinManager.f(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    z16 = this.Z$0;
                    ResultKt.throwOnFailure(obj);
                    booleanValue = z16;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("skin file is ");
                    if (!booleanValue) {
                        str = "out of date, update file";
                    } else {
                        str = "latest";
                    }
                    sb5.append(str);
                    cg0.a.b("ECSkin.ECEnableSkinManager", sb5.toString());
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        booleanValue = ((Boolean) obj).booleanValue();
        if (booleanValue) {
            ECEnableSkinManager eCEnableSkinManager2 = this.this$0;
            this.Z$0 = booleanValue;
            this.label = 2;
            if (eCEnableSkinManager2.h(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            z16 = booleanValue;
            booleanValue = z16;
        }
        StringBuilder sb52 = new StringBuilder();
        sb52.append("skin file is ");
        if (!booleanValue) {
        }
        sb52.append(str);
        cg0.a.b("ECSkin.ECEnableSkinManager", sb52.toString());
        return Unit.INSTANCE;
    }
}
