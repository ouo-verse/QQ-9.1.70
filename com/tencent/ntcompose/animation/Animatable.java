package com.tencent.ntcompose.animation;

import androidx.compose.runtime.State;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.ntcompose.core.GlobalSnapshotManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0011\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010#\u001a\u00028\u0000\u00a2\u0006\u0004\b$\u0010 J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003JG\u0010\r\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00028\u00002\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\b\u0002\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eR \u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00148\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00028\u00008F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00028\u00008F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 \u00a8\u0006%"}, d2 = {"Lcom/tencent/ntcompose/animation/Animatable;", "T", "", "Landroidx/compose/runtime/State;", "c", "targetValue", "Lcom/tencent/ntcompose/animation/a;", "animationSpec", "Lkotlin/Function1;", "", "finishedListener", "", "nextLoop", "a", "(Ljava/lang/Object;Lcom/tencent/ntcompose/animation/a;Lkotlin/jvm/functions/Function1;Z)V", "Lcom/tencent/ntcompose/animation/c;", "Lcom/tencent/ntcompose/animation/c;", "getInternalState$ntcompose_release", "()Lcom/tencent/ntcompose/animation/c;", "internalState", "", "b", "I", "d", "()I", "setAsyncFlag$ntcompose_release", "(I)V", "asyncFlag", "value", "e", "()Ljava/lang/Object;", "g", "(Ljava/lang/Object;)V", "f", tl.h.F, "initialValue", "<init>", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class Animatable<T> {

    /* renamed from: c, reason: collision with root package name */
    public static final int f339143c = 8;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final c<T> internalState;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int asyncFlag;

    public Animatable(T t16) {
        this.internalState = new c<>(t16);
    }

    public final void a(final T targetValue, final a<T> animationSpec, final Function1<? super T, Unit> finishedListener, boolean nextLoop) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.ntcompose.animation.Animatable$animateTo$animation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function0<Unit> function02;
                GlobalSnapshotManager.f339199a.f(true);
                final Function1<T, Unit> function1 = finishedListener;
                if (function1 != 0) {
                    final T t16 = targetValue;
                    function02 = new Function0<Unit>() { // from class: com.tencent.ntcompose.animation.Animatable$animateTo$animation$1$listener$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function1.invoke(t16);
                        }
                    };
                } else {
                    function02 = null;
                }
                ComposeAnimationManager composeAnimationManager = ComposeAnimationManager.f339152a;
                T t17 = targetValue;
                a<T> aVar = animationSpec;
                final Animatable<T> animatable = this;
                composeAnimationManager.l(t17, aVar, function02, new Function1<T, Unit>() { // from class: com.tencent.ntcompose.animation.Animatable$animateTo$animation$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                        invoke2((AnonymousClass1<T>) obj);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(T t18) {
                        animatable.g(t18);
                    }
                });
            }
        };
        if (nextLoop) {
            final int i3 = this.asyncFlag + 1;
            this.asyncFlag = i3;
            TimerKt.h(0, new Function0<Unit>() { // from class: com.tencent.ntcompose.animation.Animatable$animateTo$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    if (i3 == this.getAsyncFlag()) {
                        function0.invoke();
                    }
                }
            }, 1, null);
        } else {
            this.asyncFlag++;
            function0.invoke();
        }
    }

    public final State<T> c() {
        return this.internalState;
    }

    /* renamed from: d, reason: from getter */
    public final int getAsyncFlag() {
        return this.asyncFlag;
    }

    public final T e() {
        return this.internalState.a();
    }

    public final T f() {
        return this.internalState.getValue();
    }

    public final void g(T t16) {
        this.internalState.setValue(t16);
    }

    public final void h(T t16) {
        this.internalState.setValue(t16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void b(Animatable animatable, Object obj, a aVar, Function1 function1, boolean z16, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            aVar = b.b(1.0f, 0.0f, 0, 0.0f, null, 0, false, 126, null);
        }
        if ((i3 & 4) != 0) {
            function1 = null;
        }
        if ((i3 & 8) != 0) {
            z16 = true;
        }
        animatable.a(obj, aVar, function1, z16);
    }
}
