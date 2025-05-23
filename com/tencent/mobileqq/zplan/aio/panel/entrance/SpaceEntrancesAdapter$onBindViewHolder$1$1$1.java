package com.tencent.mobileqq.zplan.aio.panel.entrance;

import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.zplan.aio.panel.entrance.view.SpaceEntranceBackground;
import com.tencent.mobileqq.zplan.utils.CoroutineUtilKt;
import fi3.bp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.panel.entrance.SpaceEntrancesAdapter$onBindViewHolder$1$1$1", f = "SpaceEntrancesAdapter.kt", i = {2}, l = {98, 99, 103, 104, 105}, m = "invokeSuspend", n = {"fadeOutJob"}, s = {"L$0"})
/* loaded from: classes35.dex */
public final class SpaceEntrancesAdapter$onBindViewHolder$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $it;
    final /* synthetic */ SpaceEntrance $item;
    final /* synthetic */ bp $this_apply;
    Object L$0;
    int label;
    final /* synthetic */ SpaceEntrancesAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpaceEntrancesAdapter$onBindViewHolder$1$1$1(bp bpVar, SpaceEntrancesAdapter spaceEntrancesAdapter, SpaceEntrance spaceEntrance, View view, Continuation<? super SpaceEntrancesAdapter$onBindViewHolder$1$1$1> continuation) {
        super(2, continuation);
        this.$this_apply = bpVar;
        this.this$0 = spaceEntrancesAdapter;
        this.$item = spaceEntrance;
        this.$it = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SpaceEntrancesAdapter$onBindViewHolder$1$1$1(this.$this_apply, this.this$0, this.$item, this.$it, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SpaceEntrancesAdapter$onBindViewHolder$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00cc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009d A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        Job a16;
        Function3<CoroutineScope, View, Continuation<? super Unit>, Object> b16;
        CoroutineScope coroutineScope2;
        View view;
        ObjectAnimator duration;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(41L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    coroutineScope = this.this$0.scope;
                    com.tencent.mobileqq.qcoroutine.api.coroutine.b e16 = CorountineFunKt.e(coroutineScope, "zplan_SpaceEntrancesAdapter_\u6d88\u9690\u52a8\u753b", null, null, Boxing.boxBoolean(true), new SpaceEntrancesAdapter$onBindViewHolder$1$1$1$fadeOutJob$1(this.$this_apply, null), 6, null);
                    Intrinsics.checkNotNull(e16);
                    a16 = e16.a();
                    Intrinsics.checkNotNull(a16);
                    b16 = this.$item.b();
                    coroutineScope2 = this.this$0.scope;
                    view = this.$it;
                    this.L$0 = a16;
                    this.label = 3;
                    if (b16.invoke(coroutineScope2, view, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.L$0 = null;
                    this.label = 4;
                    if (a16.join(this) == coroutine_suspended) {
                    }
                    duration = ObjectAnimator.ofFloat(this.$this_apply.f399137b, (Property<SpaceEntranceBackground, Float>) View.ALPHA, 0.0f, 1.0f).setDuration(328L);
                    Intrinsics.checkNotNullExpressionValue(duration, "ofFloat(zplanPanelSpaceE\u2026etDuration(1000 / 24 * 8)");
                    this.label = 5;
                    if (CoroutineUtilKt.a(duration, this) == coroutine_suspended) {
                    }
                    return Unit.INSTANCE;
                }
                if (i3 == 3) {
                    a16 = (Job) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    this.L$0 = null;
                    this.label = 4;
                    if (a16.join(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    duration = ObjectAnimator.ofFloat(this.$this_apply.f399137b, (Property<SpaceEntranceBackground, Float>) View.ALPHA, 0.0f, 1.0f).setDuration(328L);
                    Intrinsics.checkNotNullExpressionValue(duration, "ofFloat(zplanPanelSpaceE\u2026etDuration(1000 / 24 * 8)");
                    this.label = 5;
                    if (CoroutineUtilKt.a(duration, this) == coroutine_suspended) {
                    }
                    return Unit.INSTANCE;
                }
                if (i3 != 4) {
                    if (i3 == 5) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                duration = ObjectAnimator.ofFloat(this.$this_apply.f399137b, (Property<SpaceEntranceBackground, Float>) View.ALPHA, 0.0f, 1.0f).setDuration(328L);
                Intrinsics.checkNotNullExpressionValue(duration, "ofFloat(zplanPanelSpaceE\u2026etDuration(1000 / 24 * 8)");
                this.label = 5;
                if (CoroutineUtilKt.a(duration, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        Job animationJob = this.$this_apply.f399137b.getAnimationJob();
        if (animationJob != null) {
            this.label = 2;
            if (animationJob.join(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        coroutineScope = this.this$0.scope;
        com.tencent.mobileqq.qcoroutine.api.coroutine.b e162 = CorountineFunKt.e(coroutineScope, "zplan_SpaceEntrancesAdapter_\u6d88\u9690\u52a8\u753b", null, null, Boxing.boxBoolean(true), new SpaceEntrancesAdapter$onBindViewHolder$1$1$1$fadeOutJob$1(this.$this_apply, null), 6, null);
        Intrinsics.checkNotNull(e162);
        a16 = e162.a();
        Intrinsics.checkNotNull(a16);
        b16 = this.$item.b();
        coroutineScope2 = this.this$0.scope;
        view = this.$it;
        this.L$0 = a16;
        this.label = 3;
        if (b16.invoke(coroutineScope2, view, this) == coroutine_suspended) {
        }
        this.L$0 = null;
        this.label = 4;
        if (a16.join(this) == coroutine_suspended) {
        }
        duration = ObjectAnimator.ofFloat(this.$this_apply.f399137b, (Property<SpaceEntranceBackground, Float>) View.ALPHA, 0.0f, 1.0f).setDuration(328L);
        Intrinsics.checkNotNullExpressionValue(duration, "ofFloat(zplanPanelSpaceE\u2026etDuration(1000 / 24 * 8)");
        this.label = 5;
        if (CoroutineUtilKt.a(duration, this) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }
}
