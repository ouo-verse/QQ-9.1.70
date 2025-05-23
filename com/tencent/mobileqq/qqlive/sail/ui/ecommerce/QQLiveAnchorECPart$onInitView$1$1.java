package com.tencent.mobileqq.qqlive.sail.ui.ecommerce;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqlive.sail.ui.ecommerce.QQLiveAnchorECPart$onInitView$1$1", f = "QQLiveAnchorECPart.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes17.dex */
public final class QQLiveAnchorECPart$onInitView$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ QQLiveAnchorECPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveAnchorECPart$onInitView$1$1(QQLiveAnchorECPart qQLiveAnchorECPart, Continuation<? super QQLiveAnchorECPart$onInitView$1$1> continuation) {
        super(2, continuation);
        this.this$0 = qQLiveAnchorECPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QQLiveAnchorECPart qQLiveAnchorECPart) {
        qQLiveAnchorECPart.ba("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new QQLiveAnchorECPart$onInitView$1$1(this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0038  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        QQLiveAnchorECViewModel na5;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        boolean z16 = false;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            na5 = this.this$0.na();
            if (na5 != null) {
                this.label = 1;
                obj = na5.d2(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            if (!z16) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final QQLiveAnchorECPart qQLiveAnchorECPart = this.this$0;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.ecommerce.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQLiveAnchorECPart$onInitView$1$1.b(QQLiveAnchorECPart.this);
                    }
                });
            }
            return Unit.INSTANCE;
        }
        if (((Boolean) obj).booleanValue()) {
            z16 = true;
        }
        if (!z16) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((QQLiveAnchorECPart$onInitView$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
