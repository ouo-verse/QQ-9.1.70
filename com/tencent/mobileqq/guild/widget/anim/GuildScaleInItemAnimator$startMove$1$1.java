package com.tencent.mobileqq.guild.widget.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.widget.anim.GuildScaleInItemAnimator;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\"\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/guild/widget/anim/GuildScaleInItemAnimator$startMove$1$1", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationCancel", "onAnimationEnd", "", "d", "Z", "isCancel", "()Z", "setCancel", "(Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildScaleInItemAnimator$startMove$1$1 extends AnimatorListenerAdapter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isCancel;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ GuildScaleInItemAnimator f236252e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ RecyclerView.ViewHolder f236253f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ View f236254h;

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ GuildScaleInItemAnimator.PosMoveInfo f236255i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildScaleInItemAnimator$startMove$1$1(GuildScaleInItemAnimator guildScaleInItemAnimator, RecyclerView.ViewHolder viewHolder, View view, GuildScaleInItemAnimator.PosMoveInfo posMoveInfo) {
        this.f236252e = guildScaleInItemAnimator;
        this.f236253f = viewHolder;
        this.f236254h = view;
        this.f236255i = posMoveInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildScaleInItemAnimator this$0, GuildScaleInItemAnimator.PosMoveInfo moveInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(moveInfo, "$moveInfo");
        this$0.m(moveInfo);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(@Nullable Animator animation) {
        this.f236254h.setAlpha(1.0f);
        this.f236254h.setTranslationY(0.0f);
        this.f236254h.setZ(0.0f);
        this.isCancel = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(@Nullable Animator animation) {
        super.onAnimationEnd(animation);
        if (!this.isCancel) {
            View view = this.f236254h;
            final GuildScaleInItemAnimator guildScaleInItemAnimator = this.f236252e;
            final GuildScaleInItemAnimator.PosMoveInfo posMoveInfo = this.f236255i;
            view.post(new Runnable() { // from class: com.tencent.mobileqq.guild.widget.anim.b
                @Override // java.lang.Runnable
                public final void run() {
                    GuildScaleInItemAnimator$startMove$1$1.b(GuildScaleInItemAnimator.this, posMoveInfo);
                }
            });
            return;
        }
        this.f236252e.dispatchMoveFinished(this.f236253f);
        final GuildScaleInItemAnimator guildScaleInItemAnimator2 = this.f236252e;
        final RecyclerView.ViewHolder viewHolder = this.f236253f;
        guildScaleInItemAnimator2.r(viewHolder, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.widget.anim.GuildScaleInItemAnimator$startMove$1$1$onAnimationEnd$2
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
                ArrayList arrayList;
                arrayList = GuildScaleInItemAnimator.this.movingHV;
                arrayList.remove(viewHolder);
                GuildScaleInItemAnimator.this.o();
            }
        });
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(@Nullable Animator animation) {
        this.f236252e.dispatchMoveStarting(this.f236253f);
    }
}
