package com.tencent.mobileqq.guild.live.livemanager;

import android.content.Context;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.live.livemanager.QQGuildOrientationSensorManager$refreshIsAutoRotateOn$1", f = "QQGuildOrientationSensorManager.kt", i = {}, l = {126}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class QQGuildOrientationSensorManager$refreshIsAutoRotateOn$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    Object L$0;
    int label;
    final /* synthetic */ QQGuildOrientationSensorManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.live.livemanager.QQGuildOrientationSensorManager$refreshIsAutoRotateOn$1$1", f = "QQGuildOrientationSensorManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.live.livemanager.QQGuildOrientationSensorManager$refreshIsAutoRotateOn$1$1, reason: invalid class name */
    /* loaded from: classes14.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Context $context;
        int label;
        final /* synthetic */ QQGuildOrientationSensorManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(QQGuildOrientationSensorManager qQGuildOrientationSensorManager, Context context, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = qQGuildOrientationSensorManager;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$context, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            boolean g16;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                g16 = this.this$0.g(this.$context);
                return Boxing.boxBoolean(g16);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQGuildOrientationSensorManager$refreshIsAutoRotateOn$1(QQGuildOrientationSensorManager qQGuildOrientationSensorManager, Context context, Continuation<? super QQGuildOrientationSensorManager$refreshIsAutoRotateOn$1> continuation) {
        super(2, continuation);
        this.this$0 = qQGuildOrientationSensorManager;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new QQGuildOrientationSensorManager$refreshIsAutoRotateOn$1(this.this$0, this.$context, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        QQGuildOrientationSensorManager qQGuildOrientationSensorManager;
        boolean z16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                qQGuildOrientationSensorManager = (QQGuildOrientationSensorManager) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            QQGuildOrientationSensorManager qQGuildOrientationSensorManager2 = this.this$0;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(qQGuildOrientationSensorManager2, this.$context, null);
            this.L$0 = qQGuildOrientationSensorManager2;
            this.label = 1;
            Object withTimeoutOrNull = TimeoutKt.withTimeoutOrNull(200L, anonymousClass1, this);
            if (withTimeoutOrNull == coroutine_suspended) {
                return coroutine_suspended;
            }
            qQGuildOrientationSensorManager = qQGuildOrientationSensorManager2;
            obj = withTimeoutOrNull;
        }
        Boolean bool = (Boolean) obj;
        if (bool != null) {
            z16 = bool.booleanValue();
        } else {
            z16 = false;
        }
        qQGuildOrientationSensorManager.isAutoRotateOn = z16;
        this.this$0.refreshIsAutoRotateOnJob = null;
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((QQGuildOrientationSensorManager$refreshIsAutoRotateOn$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
