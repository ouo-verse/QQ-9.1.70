package com.tencent.mobileqq.activity.qcircle.tab;

import android.widget.RelativeLayout;
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
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.activity.qcircle.tab.QCircleTabAvatarHelper$hideTabAvatar$1", f = "QCircleTabAvatarHelper.kt", i = {}, l = {149, 153}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes10.dex */
public final class QCircleTabAvatarHelper$hideTabAvatar$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QCircleTabAvatarHelper$hideTabAvatar$1(Continuation<? super QCircleTabAvatarHelper$hideTabAvatar$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new QCircleTabAvatarHelper$hideTabAvatar$1(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object A;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            QCircleTabAvatarHelper qCircleTabAvatarHelper = QCircleTabAvatarHelper.f184573a;
            qCircleTabAvatarHelper.B();
            this.label = 1;
            A = qCircleTabAvatarHelper.A(this);
            if (A == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        RelativeLayout g16 = QCircleTabRedPointBuildAvatarViewHelper.f184586a.g();
        if (g16 == null) {
            return Unit.INSTANCE;
        }
        QCircleTabAvatarHelper qCircleTabAvatarHelper2 = QCircleTabAvatarHelper.f184573a;
        qCircleTabAvatarHelper2.F(g16);
        this.label = 2;
        if (QCircleTabAvatarHelper.H(qCircleTabAvatarHelper2, g16, false, this, 1, null) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((QCircleTabAvatarHelper$hideTabAvatar$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
