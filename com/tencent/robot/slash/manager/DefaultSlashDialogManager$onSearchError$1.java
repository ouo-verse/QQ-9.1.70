package com.tencent.robot.slash.manager;

import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.slash.manager.d;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.slash.manager.DefaultSlashDialogManager$onSearchError$1", f = "DefaultSlashDialogManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
final class DefaultSlashDialogManager$onSearchError$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DefaultSlashDialogManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultSlashDialogManager$onSearchError$1(DefaultSlashDialogManager defaultSlashDialogManager, Continuation<? super DefaultSlashDialogManager$onSearchError$1> continuation) {
        super(2, continuation);
        this.this$0 = defaultSlashDialogManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DefaultSlashDialogManager$onSearchError$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z16;
        String str;
        boolean z17;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            z16 = this.this$0.mProcessEndFlag;
            if (!z16) {
                this.this$0.mSlashState = 2;
                str = this.this$0.mKeyword;
                if (str.length() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    this.this$0.K();
                } else {
                    d.a.a(this.this$0, false, 1, null);
                }
                return Unit.INSTANCE;
            }
            QLog.i("SlashDialogManager", 1, "onSearchError mProcessEndFlag == true return");
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DefaultSlashDialogManager$onSearchError$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
