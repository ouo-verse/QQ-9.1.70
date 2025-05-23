package com.tencent.qqnt.chats.core.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.core.anim.DefaultScaleInAnimator;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\"\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"com/tencent/qqnt/chats/core/anim/DefaultScaleInAnimator$startMove$1$1", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationCancel", "onAnimationEnd", "", "d", "Z", "isCancel", "()Z", "setCancel", "(Z)V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class DefaultScaleInAnimator$startMove$1$1 extends AnimatorListenerAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isCancel;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ DefaultScaleInAnimator f354732e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ RecyclerView.ViewHolder f354733f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ View f354734h;

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ DefaultScaleInAnimator.b f354735i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultScaleInAnimator$startMove$1$1(DefaultScaleInAnimator defaultScaleInAnimator, RecyclerView.ViewHolder viewHolder, View view, DefaultScaleInAnimator.b bVar) {
        this.f354732e = defaultScaleInAnimator;
        this.f354733f = viewHolder;
        this.f354734h = view;
        this.f354735i = bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, defaultScaleInAnimator, viewHolder, view, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DefaultScaleInAnimator this$0, DefaultScaleInAnimator.b moveInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(moveInfo, "$moveInfo");
        this$0.j(moveInfo);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(@Nullable Animator animation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) animation);
            return;
        }
        this.f354734h.setAlpha(1.0f);
        this.f354734h.setTranslationY(0.0f);
        this.f354734h.setZ(0.0f);
        this.isCancel = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(@Nullable Animator animation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) animation);
            return;
        }
        super.onAnimationEnd(animation);
        if (!this.isCancel) {
            View view = this.f354734h;
            final DefaultScaleInAnimator defaultScaleInAnimator = this.f354732e;
            final DefaultScaleInAnimator.b bVar = this.f354735i;
            view.post(new Runnable() { // from class: com.tencent.qqnt.chats.core.anim.d
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultScaleInAnimator$startMove$1$1.b(DefaultScaleInAnimator.this, bVar);
                }
            });
            return;
        }
        this.f354732e.dispatchMoveFinished(this.f354733f);
        final DefaultScaleInAnimator defaultScaleInAnimator2 = this.f354732e;
        final RecyclerView.ViewHolder viewHolder = this.f354733f;
        defaultScaleInAnimator2.p(viewHolder, new Function0<Unit>(viewHolder) { // from class: com.tencent.qqnt.chats.core.anim.DefaultScaleInAnimator$startMove$1$1$onAnimationEnd$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ RecyclerView.ViewHolder $holder;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$holder = viewHolder;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DefaultScaleInAnimator.this, (Object) viewHolder);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ArrayList arrayList;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                arrayList = DefaultScaleInAnimator.this.movingHV;
                arrayList.remove(this.$holder);
                DefaultScaleInAnimator.this.m();
            }
        });
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(@Nullable Animator animation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
        } else {
            this.f354732e.dispatchMoveStarting(this.f354733f);
        }
    }
}
