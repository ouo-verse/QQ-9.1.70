package com.tencent.sqshow.zootopia.role.logic;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/sqshow/zootopia/role/logic/f;", "", "Landroid/view/View;", "view", "", "b", "a", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f372762a = new f();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/role/logic/f$a", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f372763d;

        a(View view) {
            this.f372763d = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            this.f372763d.setVisibility(8);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/role/logic/f$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f372764d;

        b(View view) {
            this.f372764d = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            this.f372764d.setVisibility(0);
        }
    }

    f() {
    }

    public final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ofFloat.setDuration(150L);
        ofFloat.addListener(new a(view));
        ofFloat.start();
    }

    public final void b(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat.setDuration(150L);
        ofFloat.addListener(new b(view));
        ofFloat.start();
    }
}
