package com.tencent.robot.at.manager;

import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.robot.slash.businessapi.a;
import java.util.List;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.at.manager.RobotAtDialogManager$startHandleSearchResultJob$1", f = "RobotAtDialogManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
public final class RobotAtDialogManager$startHandleSearchResultJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $searchResult;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RobotAtDialogManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.robot.at.manager.RobotAtDialogManager$startHandleSearchResultJob$1$1", f = "RobotAtDialogManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.robot.at.manager.RobotAtDialogManager$startHandleSearchResultJob$1$1, reason: invalid class name */
    /* loaded from: classes25.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ a $convertResult;
        final /* synthetic */ Object $searchResult;
        int label;
        final /* synthetic */ RobotAtDialogManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(RobotAtDialogManager robotAtDialogManager, Object obj, a aVar, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = robotAtDialogManager;
            this.$searchResult = obj;
            this.$convertResult = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$searchResult, this.$convertResult, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            List<b74.a> list;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.mCachedResult = this.$searchResult;
                if (this.this$0.getIsWaitingSearchResult()) {
                    this.this$0.B(false);
                    RobotAtDialogManager robotAtDialogManager = this.this$0;
                    a aVar = this.$convertResult;
                    if (aVar != null) {
                        list = aVar.b();
                    } else {
                        list = null;
                    }
                    RobotAtDialogManager.G(robotAtDialogManager, list, false, 2, null);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotAtDialogManager$startHandleSearchResultJob$1(RobotAtDialogManager robotAtDialogManager, Object obj, Continuation<? super RobotAtDialogManager$startHandleSearchResultJob$1> continuation) {
        super(2, continuation);
        this.this$0 = robotAtDialogManager;
        this.$searchResult = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RobotAtDialogManager$startHandleSearchResultJob$1 robotAtDialogManager$startHandleSearchResultJob$1 = new RobotAtDialogManager$startHandleSearchResultJob$1(this.this$0, this.$searchResult, continuation);
        robotAtDialogManager$startHandleSearchResultJob$1.L$0 = obj;
        return robotAtDialogManager$startHandleSearchResultJob$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        a m3;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            RobotAtDialogManager robotAtDialogManager = this.this$0;
            Object obj2 = this.$searchResult;
            str = robotAtDialogManager.mCurrentKeyword;
            if (str == null) {
                str = "";
            }
            m3 = robotAtDialogManager.m(obj2, str);
            CorountineFunKt.e(coroutineScope, "RobotAtDialogManageronSearchResult.showOnUI", Boxing.boxBoolean(true), null, Boxing.boxBoolean(true), new AnonymousClass1(this.this$0, this.$searchResult, m3, null), 4, null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RobotAtDialogManager$startHandleSearchResultJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
