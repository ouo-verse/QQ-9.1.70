package com.tencent.mobileqq.qwallet.hb.detail;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H&R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/detail/HbSkinState;", "", "(Ljava/lang/String;I)V", "accelerateDecelerateInterpolator", "Landroid/view/animation/AccelerateDecelerateInterpolator;", "getAccelerateDecelerateInterpolator", "()Landroid/view/animation/AccelerateDecelerateInterpolator;", "accelerateDecelerateInterpolator$delegate", "Lkotlin/Lazy;", "decreaseInterpolator", "Landroid/view/animation/DecelerateInterpolator;", "getDecreaseInterpolator", "()Landroid/view/animation/DecelerateInterpolator;", "decreaseInterpolator$delegate", "linearInterpolator", "Landroid/view/animation/LinearInterpolator;", "getLinearInterpolator", "()Landroid/view/animation/LinearInterpolator;", "linearInterpolator$delegate", "overshootInterpolator", "Landroid/view/animation/OvershootInterpolator;", "getOvershootInterpolator", "()Landroid/view/animation/OvershootInterpolator;", "overshootInterpolator$delegate", "interpolator", "Landroid/view/animation/Interpolator;", "INITIAL", "COLLAPSED", "INTERMEDIATE", "EXPANDED", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public enum HbSkinState {
    INITIAL { // from class: com.tencent.mobileqq.qwallet.hb.detail.HbSkinState.INITIAL
        @Override // com.tencent.mobileqq.qwallet.hb.detail.HbSkinState
        @NotNull
        public Interpolator interpolator() {
            return getLinearInterpolator();
        }
    },
    COLLAPSED { // from class: com.tencent.mobileqq.qwallet.hb.detail.HbSkinState.COLLAPSED
        @Override // com.tencent.mobileqq.qwallet.hb.detail.HbSkinState
        @NotNull
        public Interpolator interpolator() {
            return getOvershootInterpolator();
        }
    },
    INTERMEDIATE { // from class: com.tencent.mobileqq.qwallet.hb.detail.HbSkinState.INTERMEDIATE
        @Override // com.tencent.mobileqq.qwallet.hb.detail.HbSkinState
        @NotNull
        public Interpolator interpolator() {
            return getOvershootInterpolator();
        }
    },
    EXPANDED { // from class: com.tencent.mobileqq.qwallet.hb.detail.HbSkinState.EXPANDED
        @Override // com.tencent.mobileqq.qwallet.hb.detail.HbSkinState
        @NotNull
        public Interpolator interpolator() {
            return getDecreaseInterpolator();
        }
    };


    /* renamed from: accelerateDecelerateInterpolator$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy accelerateDecelerateInterpolator;

    /* renamed from: decreaseInterpolator$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy decreaseInterpolator;

    /* renamed from: linearInterpolator$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy linearInterpolator;

    /* renamed from: overshootInterpolator$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy overshootInterpolator;

    /* synthetic */ HbSkinState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public final AccelerateDecelerateInterpolator getAccelerateDecelerateInterpolator() {
        return (AccelerateDecelerateInterpolator) this.accelerateDecelerateInterpolator.getValue();
    }

    @NotNull
    public final DecelerateInterpolator getDecreaseInterpolator() {
        return (DecelerateInterpolator) this.decreaseInterpolator.getValue();
    }

    @NotNull
    public final LinearInterpolator getLinearInterpolator() {
        return (LinearInterpolator) this.linearInterpolator.getValue();
    }

    @NotNull
    public final OvershootInterpolator getOvershootInterpolator() {
        return (OvershootInterpolator) this.overshootInterpolator.getValue();
    }

    @NotNull
    public abstract Interpolator interpolator();

    HbSkinState() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<OvershootInterpolator>() { // from class: com.tencent.mobileqq.qwallet.hb.detail.HbSkinState$overshootInterpolator$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final OvershootInterpolator invoke() {
                return new OvershootInterpolator(1.0f);
            }
        });
        this.overshootInterpolator = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<DecelerateInterpolator>() { // from class: com.tencent.mobileqq.qwallet.hb.detail.HbSkinState$decreaseInterpolator$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final DecelerateInterpolator invoke() {
                return new DecelerateInterpolator();
            }
        });
        this.decreaseInterpolator = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<LinearInterpolator>() { // from class: com.tencent.mobileqq.qwallet.hb.detail.HbSkinState$linearInterpolator$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LinearInterpolator invoke() {
                return new LinearInterpolator();
            }
        });
        this.linearInterpolator = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<AccelerateDecelerateInterpolator>() { // from class: com.tencent.mobileqq.qwallet.hb.detail.HbSkinState$accelerateDecelerateInterpolator$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AccelerateDecelerateInterpolator invoke() {
                return new AccelerateDecelerateInterpolator();
            }
        });
        this.accelerateDecelerateInterpolator = lazy4;
    }
}
