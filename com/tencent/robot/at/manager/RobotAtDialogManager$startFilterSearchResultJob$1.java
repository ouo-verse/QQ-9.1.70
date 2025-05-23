package com.tencent.robot.at.manager;

import b74.a;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
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
@DebugMetadata(c = "com.tencent.robot.at.manager.RobotAtDialogManager$startFilterSearchResultJob$1", f = "RobotAtDialogManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
public final class RobotAtDialogManager$startFilterSearchResultJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $keyword;
    final /* synthetic */ boolean $showDialogIfNotShowed;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RobotAtDialogManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.robot.at.manager.RobotAtDialogManager$startFilterSearchResultJob$1$1", f = "RobotAtDialogManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.robot.at.manager.RobotAtDialogManager$startFilterSearchResultJob$1$1, reason: invalid class name */
    /* loaded from: classes25.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<a> $itemDataList;
        final /* synthetic */ String $keyword;
        final /* synthetic */ boolean $showDialogIfNotShowed;
        int label;
        final /* synthetic */ RobotAtDialogManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(RobotAtDialogManager robotAtDialogManager, String str, boolean z16, List<? extends a> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = robotAtDialogManager;
            this.$keyword = str;
            this.$showDialogIfNotShowed = z16;
            this.$itemDataList = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$keyword, this.$showDialogIfNotShowed, this.$itemDataList, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.l(this.$keyword, this.$showDialogIfNotShowed, this.$itemDataList);
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
    public RobotAtDialogManager$startFilterSearchResultJob$1(RobotAtDialogManager robotAtDialogManager, String str, boolean z16, Continuation<? super RobotAtDialogManager$startFilterSearchResultJob$1> continuation) {
        super(2, continuation);
        this.this$0 = robotAtDialogManager;
        this.$keyword = str;
        this.$showDialogIfNotShowed = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RobotAtDialogManager$startFilterSearchResultJob$1 robotAtDialogManager$startFilterSearchResultJob$1 = new RobotAtDialogManager$startFilterSearchResultJob$1(this.this$0, this.$keyword, this.$showDialogIfNotShowed, continuation);
        robotAtDialogManager$startFilterSearchResultJob$1.L$0 = obj;
        return robotAtDialogManager$startFilterSearchResultJob$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        com.tencent.robot.slash.businessapi.a m3;
        List<a> emptyList;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            RobotAtDialogManager robotAtDialogManager = this.this$0;
            obj2 = robotAtDialogManager.mCachedResult;
            m3 = robotAtDialogManager.m(obj2, this.$keyword);
            if (m3 == null || (emptyList = m3.b()) == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            CorountineFunKt.e(coroutineScope, "RobotAtDialogManager.filterSearchResult.submitList", Boxing.boxBoolean(true), null, Boxing.boxBoolean(true), new AnonymousClass1(this.this$0, this.$keyword, this.$showDialogIfNotShowed, emptyList, null), 4, null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RobotAtDialogManager$startFilterSearchResultJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
