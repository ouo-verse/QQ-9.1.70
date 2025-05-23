package com.tencent.mobileqq.zplan.aio.panel.entrance;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.material.tabs.TabLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.aio.panel.entrance.SpaceEntrance$Companion$generateSource$showPanelLayout$1;
import com.tencent.mobileqq.zplan.aio.panel.panel.view.SpacePanelLayout;
import com.tencent.mobileqq.zplan.utils.CoroutineUtilKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import le3.ApiPanelEventHandler;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", ReportConstant.COSTREPORT_PREFIX, "", "index", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.panel.entrance.SpaceEntrance$Companion$generateSource$showPanelLayout$1", f = "SpaceEntrance.kt", i = {0, 0}, l = {162, 128}, m = "invokeSuspend", n = {"window", "showJob"}, s = {"L$0", "L$1"})
/* loaded from: classes35.dex */
final class SpaceEntrance$Companion$generateSource$showPanelLayout$1 extends SuspendLambda implements Function3<CoroutineScope, Integer, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<View> $behindViews;
    final /* synthetic */ Context $context;
    final /* synthetic */ Function0<SpacePanelLayout> $createPanelLayout;
    final /* synthetic */ ApiPanelEventHandler $handler;
    final /* synthetic */ View $popupParent;
    final /* synthetic */ CoroutineScope $scope;
    /* synthetic */ int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.panel.entrance.SpaceEntrance$Companion$generateSource$showPanelLayout$1$3", f = "SpaceEntrance.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.zplan.aio.panel.entrance.SpaceEntrance$Companion$generateSource$showPanelLayout$1$3, reason: invalid class name */
    /* loaded from: classes35.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<View> $behindViews;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(List<? extends View> list, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$behindViews = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(List list, ValueAnimator valueAnimator) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            float floatValue = ((Float) animatedValue).floatValue();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setAlpha(floatValue);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$behindViews, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(328L);
                final List<View> list = this.$behindViews;
                duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.zplan.aio.panel.entrance.e
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        SpaceEntrance$Companion$generateSource$showPanelLayout$1.AnonymousClass3.b(list, valueAnimator);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(duration, "ofFloat(0f, 1f).setDurat\u2026  }\n                    }");
                this.label = 1;
                if (CoroutineUtilKt.a(duration, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "onDismiss"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public static final class a implements PopupWindow.OnDismissListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PopupWindow f331118d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Unit> f331119e;

        /* JADX WARN: Multi-variable type inference failed */
        a(PopupWindow popupWindow, CancellableContinuation<? super Unit> cancellableContinuation) {
            this.f331118d = popupWindow;
            this.f331119e = cancellableContinuation;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            this.f331118d.setOnDismissListener(null);
            if (this.f331119e.isActive()) {
                CancellableContinuation<Unit> cancellableContinuation = this.f331119e;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SpaceEntrance$Companion$generateSource$showPanelLayout$1(ApiPanelEventHandler apiPanelEventHandler, CoroutineScope coroutineScope, Context context, Function0<SpacePanelLayout> function0, List<? extends View> list, View view, Continuation<? super SpaceEntrance$Companion$generateSource$showPanelLayout$1> continuation) {
        super(3, continuation);
        this.$handler = apiPanelEventHandler;
        this.$scope = coroutineScope;
        this.$context = context;
        this.$createPanelLayout = function0;
        this.$behindViews = list;
        this.$popupParent = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(PopupWindow popupWindow, View view) {
        popupWindow.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(PopupWindow popupWindow, View view) {
        popupWindow.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(CoroutineScope coroutineScope, PopupWindow popupWindow, View view) {
        CorountineFunKt.e(coroutineScope, "zplan_SpaceEntrance_\u5173\u95ed\u9762\u677f", null, null, null, new SpaceEntrance$Companion$generateSource$showPanelLayout$1$1$1(popupWindow, null), 14, null);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Integer num, Continuation<? super Unit> continuation) {
        return invoke(coroutineScope, num.intValue(), continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, int i3, Continuation<? super Unit> continuation) {
        SpaceEntrance$Companion$generateSource$showPanelLayout$1 spaceEntrance$Companion$generateSource$showPanelLayout$1 = new SpaceEntrance$Companion$generateSource$showPanelLayout$1(this.$handler, this.$scope, this.$context, this.$createPanelLayout, this.$behindViews, this.$popupParent, continuation);
        spaceEntrance$Companion$generateSource$showPanelLayout$1.I$0 = i3;
        return spaceEntrance$Companion$generateSource$showPanelLayout$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Job a16;
        Continuation intercepted;
        Object coroutine_suspended2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            int i16 = this.I$0;
            final PopupWindow popupWindow = new PopupWindow();
            Context context = this.$context;
            Function0<SpacePanelLayout> function0 = this.$createPanelLayout;
            popupWindow.setWidth(-1);
            popupWindow.setHeight(-2);
            popupWindow.setFocusable(true);
            popupWindow.setAnimationStyle(R.style.f2431703);
            RelativeLayout relativeLayout = new RelativeLayout(context);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -2);
            int applyDimension = (int) TypedValue.applyDimension(1, 17.0f, context.getResources().getDisplayMetrics());
            int applyDimension2 = (int) TypedValue.applyDimension(1, 38.0f, context.getResources().getDisplayMetrics());
            relativeLayout.setPadding(applyDimension, applyDimension2, applyDimension, applyDimension2);
            relativeLayout.setLayoutParams(layoutParams);
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aio.panel.entrance.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SpaceEntrance$Companion$generateSource$showPanelLayout$1.d(popupWindow, view);
                }
            });
            SpacePanelLayout invoke = function0.invoke();
            SpacePanelLayout spacePanelLayout = invoke;
            spacePanelLayout.setVisibility(0);
            TabLayout.g B = spacePanelLayout.getTabLayout().B(i16);
            if (B != null) {
                B.m();
            }
            spacePanelLayout.getViewPager().setCurrentItem(i16, false);
            spacePanelLayout.getSpaceCloseBtn().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aio.panel.entrance.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SpaceEntrance$Companion$generateSource$showPanelLayout$1.e(popupWindow, view);
                }
            });
            relativeLayout.addView(invoke);
            popupWindow.setContentView(relativeLayout);
            Function1<View.OnClickListener, Unit> g16 = this.$handler.g();
            final CoroutineScope coroutineScope = this.$scope;
            g16.invoke(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aio.panel.entrance.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SpaceEntrance$Companion$generateSource$showPanelLayout$1.f(CoroutineScope.this, popupWindow, view);
                }
            });
            com.tencent.mobileqq.qcoroutine.api.coroutine.b e16 = CorountineFunKt.e(this.$scope, "zplan_SpaceEntrance_\u5c55\u793a\u52a8\u753b", null, null, Boxing.boxBoolean(true), new SpaceEntrance$Companion$generateSource$showPanelLayout$1$showJob$1(this.$behindViews, null), 6, null);
            a16 = e16 != null ? e16.a() : null;
            View view = this.$popupParent;
            this.L$0 = popupWindow;
            this.L$1 = a16;
            this.L$2 = view;
            this.label = 1;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.zplan.aio.panel.entrance.SpaceEntrance$Companion$generateSource$showPanelLayout$1$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                    invoke2(th5);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th5) {
                    popupWindow.dismiss();
                }
            });
            popupWindow.setOnDismissListener(new a(popupWindow, cancellableContinuationImpl));
            popupWindow.showAtLocation(view, 80, 0, 0);
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended2) {
                DebugProbes.probeCoroutineSuspended(this);
            }
            if (result == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    CorountineFunKt.e(this.$scope, "zplan_SpaceEntrance_\u9000\u51fa\u52a8\u753b", null, null, null, new AnonymousClass3(this.$behindViews, null), 14, null);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a16 = (Job) this.L$1;
            ResultKt.throwOnFailure(obj);
        }
        if (a16 != null) {
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 2;
            if (a16.join(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        CorountineFunKt.e(this.$scope, "zplan_SpaceEntrance_\u9000\u51fa\u52a8\u753b", null, null, null, new AnonymousClass3(this.$behindViews, null), 14, null);
        return Unit.INSTANCE;
    }
}
