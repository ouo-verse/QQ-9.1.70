package com.tencent.mobileqq.activity.qcircle.tab;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CancellationException;
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
import qqcircle.QQCircleCounter$RedPointInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.activity.qcircle.tab.QCircleTabAvatarHelper$showTabAvatar$1", f = "QCircleTabAvatarHelper.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes10.dex */
public final class QCircleTabAvatarHelper$showTabAvatar$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ QQCircleCounter$RedPointInfo $redPointInfo;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QCircleTabAvatarHelper$showTabAvatar$1(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo, Continuation<? super QCircleTabAvatarHelper$showTabAvatar$1> continuation) {
        super(2, continuation);
        this.$redPointInfo = qQCircleCounter$RedPointInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new QCircleTabAvatarHelper$showTabAvatar$1(this.$redPointInfo, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object I;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                QCircleTabAvatarHelper qCircleTabAvatarHelper = QCircleTabAvatarHelper.f184573a;
                QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo = this.$redPointInfo;
                this.label = 1;
                I = qCircleTabAvatarHelper.I(qQCircleCounter$RedPointInfo, this);
                if (I == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } catch (Throwable th5) {
            if (th5 instanceof CancellationException) {
                return Unit.INSTANCE;
            }
            QLog.e("QCircleTabRedPoint.TabAvatarHelper", 1, "[showTabAvatar] error: ", th5);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((QCircleTabAvatarHelper$showTabAvatar$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
