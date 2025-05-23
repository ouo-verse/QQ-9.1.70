package com.tencent.mobileqq.guild.widget.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Looper;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 O2\u00020\u0001:\u000214B/\u0012\b\b\u0002\u0010I\u001a\u00020\u0011\u0012\b\b\u0002\u0010J\u001a\u00020\u0011\u0012\b\b\u0002\u0010K\u001a\u00020\u0011\u0012\b\b\u0002\u0010L\u001a\u00020\u0011\u00a2\u0006\u0004\bM\u0010NJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0002J0\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\u001e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016J0\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J<\u0010\"\u001a\u00020\u00112\b\u0010 \u001a\u0004\u0018\u00010\u00022\b\u0010!\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010#\u001a\u00020\u0004H\u0016J\b\u0010$\u001a\u00020\u0011H\u0016J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J.\u0010.\u001a\u00020-2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\f2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*H\u0016R$\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u00020/j\b\u0012\u0004\u0012\u00020\u0002`08\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R$\u00105\u001a\u0012\u0012\u0004\u0012\u00020\u00020/j\b\u0012\u0004\u0012\u00020\u0002`08\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00102R$\u00107\u001a\u0012\u0012\u0004\u0012\u00020\u00020/j\b\u0012\u0004\u0012\u00020\u0002`08\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00102R$\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00130/j\b\u0012\u0004\u0012\u00020\u0013`08\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00102R$\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u00020/j\b\u0012\u0004\u0012\u00020\u0002`08\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u00102R$\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\u00020/j\b\u0012\u0004\u0012\u00020\u0002`08\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u00102R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R0\u0010E\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0Aj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f`B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010H\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010G\u00a8\u0006P"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/anim/GuildScaleInItemAnimator;", "Landroidx/recyclerview/widget/DefaultItemAnimator;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "", "k", "l", "", "viewHolders", "cancelAll", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "fromY", "toY", "fromX", "toX", "", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/guild/widget/anim/GuildScaleInItemAnimator$b;", "moveInfo", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", "o", "Lkotlin/Function0;", "block", "r", "animateAdd", "endAnimations", "endAnimation", "animateMove", "oldHolder", "newHolder", "animateChange", "runPendingAnimations", "isRunning", "animateRemove", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "viewHolder", "changeFlags", "", "", "payloads", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator$ItemHolderInfo;", "recordPreLayoutInformation", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "movingHV", "b", "addingVH", "c", "removingVH", "d", "e", "removeInfo", "f", "addInfo", "Landroid/view/animation/LinearInterpolator;", "g", "Landroid/view/animation/LinearInterpolator;", "addAnim", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", h.F, "Ljava/util/HashMap;", "vhOldPostMap", "i", "I", "curTimeMoveDirection", "removeAnimSwitch", "moveAnimSwitch", "addAnimSwitch", "changeAnimSwitch", "<init>", "(ZZZZ)V", "j", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildScaleInItemAnimator extends DefaultItemAnimator {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<RecyclerView.ViewHolder> movingHV;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<RecyclerView.ViewHolder> addingVH;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<RecyclerView.ViewHolder> removingVH;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<PosMoveInfo> moveInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<RecyclerView.ViewHolder> removeInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<RecyclerView.ViewHolder> addInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearInterpolator addAnim;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, Integer> vhOldPostMap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int curTimeMoveDirection;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0010\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001a\u0010\u0013\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/anim/GuildScaleInItemAnimator$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "c", "()Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "b", "I", "()I", "d", "(I)V", "fromY", "g", "toY", "getOldPos", "f", "oldPos", "e", "getNewPos", "newPos", "<init>", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.widget.anim.GuildScaleInItemAnimator$b, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class PosMoveInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final RecyclerView.ViewHolder viewHolder;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int fromY;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int toY;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int oldPos;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int newPos;

        public PosMoveInfo(@NotNull RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            this.viewHolder = viewHolder;
            this.oldPos = -1;
            this.newPos = -1;
        }

        /* renamed from: a, reason: from getter */
        public final int getFromY() {
            return this.fromY;
        }

        /* renamed from: b, reason: from getter */
        public final int getToY() {
            return this.toY;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final RecyclerView.ViewHolder getViewHolder() {
            return this.viewHolder;
        }

        public final void d(int i3) {
            this.fromY = i3;
        }

        public final void e(int i3) {
            this.newPos = i3;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof PosMoveInfo) && Intrinsics.areEqual(this.viewHolder, ((PosMoveInfo) other).viewHolder)) {
                return true;
            }
            return false;
        }

        public final void f(int i3) {
            this.oldPos = i3;
        }

        public final void g(int i3) {
            this.toY = i3;
        }

        public int hashCode() {
            return this.viewHolder.hashCode();
        }

        @NotNull
        public String toString() {
            return "PosMoveInfo(viewHolder=" + this.viewHolder + ")";
        }
    }

    public GuildScaleInItemAnimator() {
        this(false, false, false, false, 15, null);
    }

    private final void cancelAll(List<? extends RecyclerView.ViewHolder> viewHolders) {
        int size = viewHolders.size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i3 = size - 1;
            viewHolders.get(size).itemView.animate().cancel();
            if (i3 >= 0) {
                size = i3;
            } else {
                return;
            }
        }
    }

    private final void k(final RecyclerView.ViewHolder holder) {
        final View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        this.addingVH.add(holder);
        view.setZ(-1000.0f);
        final ViewPropertyAnimator animate = view.animate();
        animate.alpha(1.0f).translationY(0.0f).setDuration(getAddDuration()).setInterpolator(this.addAnim).setListener(new AnimatorListenerAdapter() { // from class: com.tencent.mobileqq.guild.widget.anim.GuildScaleInItemAnimator$addAnimateImpl$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                view.setAlpha(1.0f);
                view.setTranslationY(0.0f);
                view.setZ(0.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                animate.setListener(null);
                view.setAlpha(1.0f);
                view.setTranslationY(0.0f);
                view.setZ(0.0f);
                GuildScaleInItemAnimator.this.dispatchAddFinished(holder);
                final GuildScaleInItemAnimator guildScaleInItemAnimator = GuildScaleInItemAnimator.this;
                final RecyclerView.ViewHolder viewHolder = holder;
                guildScaleInItemAnimator.r(viewHolder, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.widget.anim.GuildScaleInItemAnimator$addAnimateImpl$1$onAnimationEnd$1
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
                        arrayList = GuildScaleInItemAnimator.this.addingVH;
                        arrayList.remove(viewHolder);
                        GuildScaleInItemAnimator.this.o();
                    }
                });
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                GuildScaleInItemAnimator.this.dispatchAddStarting(holder);
            }
        }).start();
    }

    private final void l() {
        Iterator<PosMoveInfo> it = this.moveInfo.iterator();
        while (it.hasNext()) {
            PosMoveInfo next = it.next();
            View view = next.getViewHolder().itemView;
            Intrinsics.checkNotNullExpressionValue(view, "item.viewHolder.itemView");
            view.animate().cancel();
            view.setTranslationY(0.0f);
            view.setAlpha(1.0f);
            dispatchMoveFinished(next.getViewHolder());
        }
        this.moveInfo.clear();
        Iterator<RecyclerView.ViewHolder> it5 = this.addInfo.iterator();
        while (it5.hasNext()) {
            RecyclerView.ViewHolder next2 = it5.next();
            View view2 = next2.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "item.itemView");
            view2.animate().cancel();
            view2.setTranslationY(0.0f);
            view2.setAlpha(1.0f);
            dispatchAddFinished(next2);
        }
        this.addInfo.clear();
        Iterator<RecyclerView.ViewHolder> it6 = this.removeInfo.iterator();
        while (it6.hasNext()) {
            RecyclerView.ViewHolder next3 = it6.next();
            View view3 = next3.itemView;
            Intrinsics.checkNotNullExpressionValue(view3, "item.itemView");
            view3.animate().cancel();
            view3.setTranslationY(0.0f);
            view3.setAlpha(1.0f);
            dispatchRemoveFinished(next3);
        }
        this.removeInfo.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(PosMoveInfo moveInfo) {
        final RecyclerView.ViewHolder viewHolder = moveInfo.getViewHolder();
        final View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        final ViewPropertyAnimator animate = view.animate();
        if (this.curTimeMoveDirection == 1) {
            view.setTranslationY((-view.getHeight()) / 4.0f);
        } else {
            view.setTranslationY(view.getHeight() / 4.0f);
        }
        view.setAlpha(0.0f);
        animate.alpha(1.0f).translationY(0.0f).setDuration(getAddDuration() / 2).setInterpolator(this.addAnim).setListener(new AnimatorListenerAdapter() { // from class: com.tencent.mobileqq.guild.widget.anim.GuildScaleInItemAnimator$endMove$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                view.setAlpha(1.0f);
                view.setTranslationY(0.0f);
                view.setZ(0.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                animate.setListener(null);
                view.setAlpha(1.0f);
                view.setTranslationY(0.0f);
                view.setZ(0.0f);
                this.dispatchMoveFinished(viewHolder);
                final GuildScaleInItemAnimator guildScaleInItemAnimator = this;
                final RecyclerView.ViewHolder viewHolder2 = viewHolder;
                guildScaleInItemAnimator.r(viewHolder2, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.widget.anim.GuildScaleInItemAnimator$endMove$1$onAnimationEnd$1
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
                        arrayList.remove(viewHolder2);
                        GuildScaleInItemAnimator.this.o();
                    }
                });
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }
        }).start();
    }

    private final boolean n(RecyclerView.ViewHolder holder, int fromY, int toY, int fromX, int toX) {
        int intValue;
        if (!this.addingVH.contains(holder) && !this.removingVH.contains(holder) && !this.movingHV.contains(holder)) {
            endAnimation(holder);
        }
        if (fromY == toY && fromX == toX) {
            dispatchChangeFinished(holder, false);
            return false;
        }
        ArrayList<PosMoveInfo> arrayList = this.moveInfo;
        PosMoveInfo posMoveInfo = new PosMoveInfo(holder);
        posMoveInfo.d(fromY);
        posMoveInfo.g(toY);
        Integer num = this.vhOldPostMap.get(Integer.valueOf(holder.hashCode()));
        if (num == null) {
            intValue = -1;
        } else {
            Intrinsics.checkNotNullExpressionValue(num, "vhOldPostMap[holder.hashCode()] ?: -1");
            intValue = num.intValue();
        }
        posMoveInfo.f(intValue);
        posMoveInfo.e(holder.getLayoutPosition());
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        view.setZ(-1000.0f);
        view.setTranslationY(fromY - toY);
        arrayList.add(posMoveInfo);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        if (!isRunning()) {
            dispatchAnimationsFinished();
        }
    }

    private final void p(final RecyclerView.ViewHolder holder) {
        final View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        this.removingVH.add(holder);
        if (this.curTimeMoveDirection == 2) {
            view.animate().translationY(view.getHeight() / 2.0f);
        } else {
            view.animate().translationY((-view.getHeight()) / 2.0f);
        }
        view.animate().alpha(0.0f).setDuration(getRemoveDuration()).setInterpolator(this.addAnim).setListener(new AnimatorListenerAdapter() { // from class: com.tencent.mobileqq.guild.widget.anim.GuildScaleInItemAnimator$removeAnimateImpl$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                view.setAlpha(1.0f);
                view.setTranslationY(0.0f);
                view.setZ(0.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                view.setTranslationY(0.0f);
                view.setAlpha(1.0f);
                view.setZ(0.0f);
                GuildScaleInItemAnimator.this.dispatchRemoveFinished(holder);
                final GuildScaleInItemAnimator guildScaleInItemAnimator = GuildScaleInItemAnimator.this;
                final RecyclerView.ViewHolder viewHolder = holder;
                guildScaleInItemAnimator.r(viewHolder, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.widget.anim.GuildScaleInItemAnimator$removeAnimateImpl$1$onAnimationEnd$1
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
                        arrayList = GuildScaleInItemAnimator.this.removingVH;
                        arrayList.remove(viewHolder);
                        GuildScaleInItemAnimator.this.o();
                    }
                });
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                GuildScaleInItemAnimator.this.dispatchRemoveStarting(holder);
            }
        }).start();
    }

    private final void q(RecyclerView.ViewHolder item) {
        View view = item.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "item.itemView");
        view.setTranslationY(0.0f);
        view.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(RecyclerView.ViewHolder holder, final Function0<Unit> block) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            block.invoke();
        } else {
            holder.itemView.post(new Runnable() { // from class: com.tencent.mobileqq.guild.widget.anim.a
                @Override // java.lang.Runnable
                public final void run() {
                    GuildScaleInItemAnimator.s(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    private final void t(PosMoveInfo moveInfo) {
        RecyclerView.ViewHolder viewHolder = moveInfo.getViewHolder();
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        int fromY = moveInfo.getFromY() - moveInfo.getToY();
        this.movingHV.add(moveInfo.getViewHolder());
        ViewPropertyAnimator animate = view.animate();
        if (this.curTimeMoveDirection == 1) {
            animate.translationY(fromY - (view.getHeight() / 4.0f));
        } else {
            animate.translationY(fromY + (view.getHeight() / 4.0f));
        }
        animate.alpha(0.0f);
        animate.setDuration(getRemoveDuration() / 2);
        animate.setInterpolator(this.addAnim);
        animate.setListener(new GuildScaleInItemAnimator$startMove$1$1(this, viewHolder, view, moveInfo));
        animate.start();
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateAdd(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        endAnimation(holder);
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        view.setAlpha(0.0f);
        view.setTranslationY((-view.getHeight()) / 2.0f);
        view.setZ(-1000.0f);
        this.addInfo.add(holder);
        this.vhOldPostMap.remove(Integer.valueOf(holder.hashCode()));
        return true;
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateChange(@Nullable RecyclerView.ViewHolder oldHolder, @Nullable RecyclerView.ViewHolder newHolder, int fromX, int fromY, int toX, int toY) {
        int i3;
        int i16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("animateChange: ");
        sb5.append(newHolder);
        sb5.append(" oldHolder: ");
        sb5.append(oldHolder);
        StringBuilder sb6 = new StringBuilder();
        sb6.append("from: ");
        sb6.append(fromY);
        sb6.append(" to: ");
        sb6.append(toY);
        if (Intrinsics.areEqual(oldHolder, newHolder) && oldHolder != null) {
            boolean n3 = n(oldHolder, fromY, toY, fromX, toX);
            this.vhOldPostMap.remove(Integer.valueOf(oldHolder.hashCode()));
            return n3;
        }
        if (oldHolder != null) {
            endAnimation(oldHolder);
        }
        if (newHolder != null) {
            endAnimation(newHolder);
        }
        dispatchChangeFinished(oldHolder, true);
        dispatchChangeFinished(newHolder, false);
        HashMap<Integer, Integer> hashMap = this.vhOldPostMap;
        if (oldHolder != null) {
            i3 = oldHolder.hashCode();
        } else {
            i3 = 0;
        }
        hashMap.remove(Integer.valueOf(i3));
        HashMap<Integer, Integer> hashMap2 = this.vhOldPostMap;
        if (newHolder != null) {
            i16 = newHolder.hashCode();
        } else {
            i16 = 0;
        }
        hashMap2.remove(Integer.valueOf(i16));
        return false;
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateMove(@NotNull RecyclerView.ViewHolder holder, int fromX, int fromY, int toX, int toY) {
        boolean animateMove;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Integer num = this.vhOldPostMap.get(Integer.valueOf(holder.hashCode()));
        if (num == null) {
            num = -1;
        }
        int intValue = num.intValue();
        int abs = Math.abs(fromY - toY);
        int i3 = 1;
        if (Math.abs(intValue - holder.getAdapterPosition()) > 1 && intValue != -1 && abs > holder.itemView.getHeight() * 1.5d) {
            animateMove = n(holder, fromY, toY, fromX, toX);
        } else {
            int i16 = this.curTimeMoveDirection;
            if (fromY <= toY) {
                i3 = 2;
            }
            this.curTimeMoveDirection = i16 | i3;
            animateMove = super.animateMove(holder, fromX, fromY, toX, toY);
        }
        ViewPropertyAnimator animate = holder.itemView.animate();
        if (animate != null) {
            animate.setInterpolator(this.addAnim);
        }
        this.vhOldPostMap.remove(Integer.valueOf(holder.hashCode()));
        return animateMove;
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateRemove(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        endAnimation(holder);
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = "animateRemove: " + holder.hashCode();
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("GuildScaleInItemAnimator", 1, (String) it.next(), null);
        }
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        view.setZ(-1000.0f);
        this.removeInfo.add(holder);
        this.vhOldPostMap.remove(Integer.valueOf(holder.hashCode()));
        return true;
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimation(@NotNull RecyclerView.ViewHolder item) {
        Intrinsics.checkNotNullParameter(item, "item");
        super.endAnimation(item);
        q(item);
        if (this.addInfo.contains(item)) {
            this.addInfo.remove(item);
            dispatchAddFinished(item);
        }
        if (this.removeInfo.contains(item)) {
            this.removeInfo.remove(item);
            dispatchRemoveFinished(item);
        }
        if (this.moveInfo.contains(new PosMoveInfo(item))) {
            this.moveInfo.remove(this.moveInfo.indexOf(new PosMoveInfo(item)));
            dispatchMoveFinished(item);
        }
        this.removingVH.remove(item);
        this.addingVH.remove(item);
        this.movingHV.remove(item);
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimations() {
        l();
        cancelAll(this.addingVH);
        cancelAll(this.removingVH);
        cancelAll(this.movingHV);
        this.curTimeMoveDirection = 0;
        super.endAnimations();
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean isRunning() {
        if (super.isRunning() || (!this.movingHV.isEmpty()) || (!this.addingVH.isEmpty()) || (!this.removingVH.isEmpty()) || (!this.moveInfo.isEmpty()) || (!this.addInfo.isEmpty()) || (!this.removeInfo.isEmpty())) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    @NotNull
    public RecyclerView.ItemAnimator.ItemHolderInfo recordPreLayoutInformation(@NotNull RecyclerView.State state, @NotNull RecyclerView.ViewHolder viewHolder, int changeFlags, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        this.vhOldPostMap.put(Integer.valueOf(viewHolder.hashCode()), Integer.valueOf(viewHolder.getOldPosition()));
        RecyclerView.ItemAnimator.ItemHolderInfo recordPreLayoutInformation = super.recordPreLayoutInformation(state, viewHolder, changeFlags, payloads);
        Intrinsics.checkNotNullExpressionValue(recordPreLayoutInformation, "super.recordPreLayoutInf\u2026r, changeFlags, payloads)");
        return recordPreLayoutInformation;
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void runPendingAnimations() {
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = "runPendingAnimations: moveInfo:" + this.moveInfo.size() + ", addInfo:" + this.addInfo.size() + ", removeInfo:" + this.removeInfo.size();
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("GuildScaleInItemAnimator", 1, (String) it.next(), null);
        }
        if (this.curTimeMoveDirection == 3) {
            endAnimations();
            return;
        }
        Iterator<T> it5 = this.removeInfo.iterator();
        while (it5.hasNext()) {
            p((RecyclerView.ViewHolder) it5.next());
        }
        this.removeInfo.clear();
        Iterator<T> it6 = this.moveInfo.iterator();
        while (it6.hasNext()) {
            t((PosMoveInfo) it6.next());
        }
        this.moveInfo.clear();
        Iterator<T> it7 = this.addInfo.iterator();
        while (it7.hasNext()) {
            k((RecyclerView.ViewHolder) it7.next());
        }
        this.addInfo.clear();
        this.curTimeMoveDirection = 0;
        super.runPendingAnimations();
    }

    public /* synthetic */ GuildScaleInItemAnimator(boolean z16, boolean z17, boolean z18, boolean z19, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z16, (i3 & 2) != 0 ? true : z17, (i3 & 4) != 0 ? false : z18, (i3 & 8) != 0 ? true : z19);
    }

    public GuildScaleInItemAnimator(boolean z16, boolean z17, boolean z18, boolean z19) {
        this.movingHV = new ArrayList<>();
        this.addingVH = new ArrayList<>();
        this.removingVH = new ArrayList<>();
        this.moveInfo = new ArrayList<>();
        this.removeInfo = new ArrayList<>();
        this.addInfo = new ArrayList<>();
        this.addAnim = new LinearInterpolator();
        this.vhOldPostMap = new HashMap<>();
        setMoveDuration(z17 ? 100L : 0L);
        setRemoveDuration(z16 ? 100L : 0L);
        setAddDuration(z18 ? 100L : 0L);
        setChangeDuration(z19 ? 100L : 0L);
        setSupportsChangeAnimations(false);
    }
}
