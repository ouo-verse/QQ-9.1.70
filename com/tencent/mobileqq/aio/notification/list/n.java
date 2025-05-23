package com.tencent.mobileqq.aio.notification.list;

import android.animation.Animator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 F2\u00020\u0001:\u0006.258:<B\u0011\u0012\b\b\u0002\u00100\u001a\u00020\u0017\u00a2\u0006\u0004\bQ\u0010RJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J0\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u001e\u0010\u0015\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00122\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u001a\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\u0016\u0010\u001c\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H$J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H$J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J0\u0010$\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016J8\u0010'\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010)\u001a\u00020\u0017H\u0016J\b\u0010*\u001a\u00020\u0004H\u0016J\u000e\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020+R\u0014\u00100\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00103R\u001a\u00109\u001a\b\u0012\u0004\u0012\u000207018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00103R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020\u000f018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u00103R \u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000201018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u00103R \u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020701018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u00103R \u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f01018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u00103R(\u0010D\u001a\b\u0012\u0004\u0012\u00020\u0002018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\b\u00103\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u00103R(\u0010H\u001a\b\u0012\u0004\u0012\u00020\u0002018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u00103\u001a\u0004\bF\u0010A\"\u0004\bG\u0010CR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u00103R\"\u0010P\u001a\u00020J8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010O\u00a8\u0006S"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/list/n;", "Landroidx/recyclerview/widget/SimpleItemAnimator;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "j", "i", "", "fromX", "fromY", "toX", "toY", "animateMoveImpl", "Lcom/tencent/mobileqq/aio/notification/list/n$b;", "changeInfo", "g", "", "infoList", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "endChangeAnimation", "k", "", "l", "dispatchFinishedWhenDone", "", "viewHolders", "cancelAll", "runPendingAnimations", "r", "p", "animateRemoveImpl", "animateAddImpl", "animateRemove", "animateAdd", "animateMove", "oldHolder", "newHolder", "animateChange", "endAnimation", "isRunning", "endAnimations", "Landroid/view/View;", "v", tl.h.F, "a", "Z", "runAnimationWithoutDelay", "Ljava/util/ArrayList;", "b", "Ljava/util/ArrayList;", "pendingRemovals", "c", "pendingAdditions", "Lcom/tencent/mobileqq/aio/notification/list/n$f;", "d", "pendingMoves", "e", "pendingChanges", "f", "additionsList", "movesList", "changesList", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/util/ArrayList;", "setAddAnimations", "(Ljava/util/ArrayList;)V", "addAnimations", "moveAnimations", DomainData.DOMAIN_NAME, "setRemoveAnimations", "removeAnimations", "changeAnimations", "Landroid/view/animation/Interpolator;", "Landroid/view/animation/Interpolator;", "getInterpolator", "()Landroid/view/animation/Interpolator;", "setInterpolator", "(Landroid/view/animation/Interpolator;)V", "interpolator", "<init>", "(Z)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public abstract class n extends SimpleItemAnimator {
    static IPatchRedirector $redirector_;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean runAnimationWithoutDelay;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<RecyclerView.ViewHolder> pendingRemovals;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<RecyclerView.ViewHolder> pendingAdditions;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<f> pendingMoves;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<b> pendingChanges;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<ArrayList<RecyclerView.ViewHolder>> additionsList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<ArrayList<f>> movesList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<ArrayList<b>> changesList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<RecyclerView.ViewHolder> addAnimations;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<RecyclerView.ViewHolder> moveAnimations;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<RecyclerView.ViewHolder> removeAnimations;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<RecyclerView.ViewHolder> changeAnimations;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Interpolator interpolator;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/list/n$a;", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "", "onAnimationCancel", "onAnimationRepeat", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static class a implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
            } else {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            } else {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/list/n$c;", "", "", "DEBUG", "Z", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.notification.list.n$c, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/list/n$d;", "Lcom/tencent/mobileqq/aio/notification/list/n$a;", "Landroid/animation/Animator;", "animator", "", "onAnimationStart", "onAnimationCancel", "onAnimationEnd", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "d", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getViewHolder", "()Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "setViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "viewHolder", "<init>", "(Lcom/tencent/mobileqq/aio/notification/list/n;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public final class d extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private RecyclerView.ViewHolder viewHolder;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ n f192983e;

        public d(@NotNull n nVar, RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            this.f192983e = nVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) nVar, (Object) viewHolder);
            } else {
                this.viewHolder = viewHolder;
            }
        }

        @Override // com.tencent.mobileqq.aio.notification.list.n.a, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
                return;
            }
            Intrinsics.checkNotNullParameter(animator, "animator");
            n nVar = this.f192983e;
            View view = this.viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "viewHolder.itemView");
            nVar.h(view);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) animator);
                return;
            }
            Intrinsics.checkNotNullParameter(animator, "animator");
            n nVar = this.f192983e;
            View view = this.viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "viewHolder.itemView");
            nVar.h(view);
            this.f192983e.dispatchAddFinished(this.viewHolder);
            this.f192983e.m().remove(this.viewHolder);
            this.f192983e.dispatchFinishedWhenDone();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
            } else {
                Intrinsics.checkNotNullParameter(animator, "animator");
                this.f192983e.dispatchAddStarting(this.viewHolder);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0094\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/list/n$e;", "Lcom/tencent/mobileqq/aio/notification/list/n$a;", "Landroid/animation/Animator;", "animator", "", "onAnimationStart", "onAnimationCancel", "onAnimationEnd", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "d", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getViewHolder", "()Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "setViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "viewHolder", "<init>", "(Lcom/tencent/mobileqq/aio/notification/list/n;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    protected class e extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private RecyclerView.ViewHolder viewHolder;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ n f192985e;

        public e(@NotNull n nVar, RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            this.f192985e = nVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) nVar, (Object) viewHolder);
            } else {
                this.viewHolder = viewHolder;
            }
        }

        @Override // com.tencent.mobileqq.aio.notification.list.n.a, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
                return;
            }
            Intrinsics.checkNotNullParameter(animator, "animator");
            n nVar = this.f192985e;
            View view = this.viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "viewHolder.itemView");
            nVar.h(view);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) animator);
                return;
            }
            Intrinsics.checkNotNullParameter(animator, "animator");
            n nVar = this.f192985e;
            View view = this.viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "viewHolder.itemView");
            nVar.h(view);
            this.f192985e.dispatchRemoveFinished(this.viewHolder);
            this.f192985e.n().remove(this.viewHolder);
            this.f192985e.dispatchFinishedWhenDone();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
            } else {
                Intrinsics.checkNotNullParameter(animator, "animator");
                this.f192985e.dispatchRemoveStarting(this.viewHolder);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0011\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\n\u0012\u0006\u0010\u0018\u001a\u00020\n\u00a2\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0003\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u0011\u0010\u000fR\"\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR\"\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000f\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/list/n$f;", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "c", "()Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "setHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "holder", "", "b", "I", "()I", "setFromX", "(I)V", "fromX", "setFromY", "fromY", "d", "setToX", "toX", "e", "setToY", "toY", "<init>", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;IIII)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private RecyclerView.ViewHolder holder;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int fromX;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int fromY;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int toX;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int toY;

        public f(@NotNull RecyclerView.ViewHolder holder, int i3, int i16, int i17, int i18) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, holder, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                return;
            }
            this.holder = holder;
            this.fromX = i3;
            this.fromY = i16;
            this.toX = i17;
            this.toY = i18;
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.fromX;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.fromY;
        }

        @NotNull
        public final RecyclerView.ViewHolder c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.holder;
        }

        public final int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return this.toX;
        }

        public final int e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return this.toY;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/aio/notification/list/n$g", "Lcom/tencent/mobileqq/aio/notification/list/n$a;", "Landroid/animation/Animator;", "animator", "", "onAnimationStart", "onAnimationEnd", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class g extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f192992e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f192993f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ View f192994h;

        g(b bVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f192992e = bVar;
            this.f192993f = viewPropertyAnimator;
            this.f192994h = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, n.this, bVar, viewPropertyAnimator, view);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            Intrinsics.checkNotNullParameter(animator, "animator");
            this.f192993f.setListener(null);
            this.f192994h.setAlpha(1.0f);
            this.f192994h.setTranslationX(0.0f);
            this.f192994h.setTranslationY(0.0f);
            n.this.dispatchChangeFinished(this.f192992e.d(), true);
            if (this.f192992e.d() != null) {
                ArrayList arrayList = n.this.changeAnimations;
                RecyclerView.ViewHolder d16 = this.f192992e.d();
                Intrinsics.checkNotNull(d16);
                arrayList.remove(d16);
            }
            n.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            } else {
                Intrinsics.checkNotNullParameter(animator, "animator");
                n.this.dispatchChangeStarting(this.f192992e.d(), true);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/aio/notification/list/n$h", "Lcom/tencent/mobileqq/aio/notification/list/n$a;", "Landroid/animation/Animator;", "animator", "", "onAnimationStart", "onAnimationEnd", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class h extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f192996e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f192997f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ View f192998h;

        h(b bVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f192996e = bVar;
            this.f192997f = viewPropertyAnimator;
            this.f192998h = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, n.this, bVar, viewPropertyAnimator, view);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            Intrinsics.checkNotNullParameter(animator, "animator");
            this.f192997f.setListener(null);
            this.f192998h.setAlpha(1.0f);
            this.f192998h.setTranslationX(0.0f);
            this.f192998h.setTranslationY(0.0f);
            n.this.dispatchChangeFinished(this.f192996e.c(), false);
            if (this.f192996e.c() != null) {
                ArrayList arrayList = n.this.changeAnimations;
                RecyclerView.ViewHolder c16 = this.f192996e.c();
                Intrinsics.checkNotNull(c16);
                arrayList.remove(c16);
            }
            n.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            } else {
                Intrinsics.checkNotNullParameter(animator, "animator");
                n.this.dispatchChangeStarting(this.f192996e.c(), false);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/aio/notification/list/n$i", "Lcom/tencent/mobileqq/aio/notification/list/n$a;", "Landroid/animation/Animator;", "animator", "", "onAnimationStart", "onAnimationCancel", "onAnimationEnd", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class i extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f193000e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f193001f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ View f193002h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f193003i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f193004m;

        i(RecyclerView.ViewHolder viewHolder, int i3, View view, int i16, ViewPropertyAnimator viewPropertyAnimator) {
            this.f193000e = viewHolder;
            this.f193001f = i3;
            this.f193002h = view;
            this.f193003i = i16;
            this.f193004m = viewPropertyAnimator;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, n.this, viewHolder, Integer.valueOf(i3), view, Integer.valueOf(i16), viewPropertyAnimator);
            }
        }

        @Override // com.tencent.mobileqq.aio.notification.list.n.a, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            Intrinsics.checkNotNullParameter(animator, "animator");
            if (this.f193001f != 0) {
                this.f193002h.setTranslationX(0.0f);
            }
            if (this.f193003i != 0) {
                this.f193002h.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
                return;
            }
            Intrinsics.checkNotNullParameter(animator, "animator");
            this.f193004m.setListener(null);
            n.this.dispatchMoveFinished(this.f193000e);
            n.this.moveAnimations.remove(this.f193000e);
            n.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            } else {
                Intrinsics.checkNotNullParameter(animator, "animator");
                n.this.dispatchMoveStarting(this.f193000e);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54817);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public n(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
            return;
        }
        this.runAnimationWithoutDelay = z16;
        this.pendingRemovals = new ArrayList<>();
        this.pendingAdditions = new ArrayList<>();
        this.pendingMoves = new ArrayList<>();
        this.pendingChanges = new ArrayList<>();
        this.additionsList = new ArrayList<>();
        this.movesList = new ArrayList<>();
        this.changesList = new ArrayList<>();
        this.addAnimations = new ArrayList<>();
        this.moveAnimations = new ArrayList<>();
        this.removeAnimations = new ArrayList<>();
        this.changeAnimations = new ArrayList<>();
        this.interpolator = new DecelerateInterpolator();
        setSupportsChangeAnimations(false);
    }

    private final void animateMoveImpl(RecyclerView.ViewHolder holder, int fromX, int fromY, int toX, int toY) {
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        int i3 = toX - fromX;
        int i16 = toY - fromY;
        if (i3 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i16 != 0) {
            view.animate().translationY(0.0f);
        }
        this.moveAnimations.add(holder);
        ViewPropertyAnimator animate = view.animate();
        animate.setInterpolator(null);
        animate.setDuration(getMoveDuration()).setListener(new i(holder, i3, view, i16, animate)).start();
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchFinishedWhenDone() {
        if (!isRunning()) {
            dispatchAnimationsFinished();
        }
    }

    private final void endChangeAnimation(List<b> infoList, RecyclerView.ViewHolder item) {
        int size = infoList.size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i3 = size - 1;
            b bVar = infoList.get(size);
            if (l(bVar, item) && bVar.d() == null && bVar.c() == null) {
                infoList.remove(bVar);
            }
            if (i3 >= 0) {
                size = i3;
            } else {
                return;
            }
        }
    }

    private final void g(b changeInfo) {
        View view;
        RecyclerView.ViewHolder d16 = changeInfo.d();
        View view2 = null;
        if (d16 != null) {
            view = d16.itemView;
        } else {
            view = null;
        }
        RecyclerView.ViewHolder c16 = changeInfo.c();
        if (c16 != null) {
            view2 = c16.itemView;
        }
        if (view != null) {
            if (changeInfo.d() != null) {
                ArrayList<RecyclerView.ViewHolder> arrayList = this.changeAnimations;
                RecyclerView.ViewHolder d17 = changeInfo.d();
                Intrinsics.checkNotNull(d17);
                arrayList.add(d17);
            }
            ViewPropertyAnimator duration = view.animate().setDuration(getChangeDuration());
            duration.translationX(changeInfo.e() - changeInfo.a());
            duration.translationY(changeInfo.f() - changeInfo.b());
            duration.alpha(0.0f).setListener(new g(changeInfo, duration, view)).start();
        }
        if (view2 != null) {
            if (changeInfo.c() != null) {
                ArrayList<RecyclerView.ViewHolder> arrayList2 = this.changeAnimations;
                RecyclerView.ViewHolder c17 = changeInfo.c();
                Intrinsics.checkNotNull(c17);
                arrayList2.add(c17);
            }
            ViewPropertyAnimator animate = view2.animate();
            animate.translationX(0.0f).translationY(0.0f).setDuration(getChangeDuration()).alpha(1.0f).setListener(new h(changeInfo, animate, view2)).start();
        }
    }

    private final void i(RecyclerView.ViewHolder holder) {
        animateAddImpl(holder);
        this.addAnimations.add(holder);
    }

    private final void j(RecyclerView.ViewHolder holder) {
        animateRemoveImpl(holder);
        this.removeAnimations.add(holder);
    }

    private final void k(b changeInfo) {
        if (changeInfo.d() != null) {
            l(changeInfo, changeInfo.d());
        }
        if (changeInfo.c() != null) {
            l(changeInfo, changeInfo.c());
        }
    }

    private final boolean l(b changeInfo, RecyclerView.ViewHolder item) {
        boolean z16 = false;
        if (changeInfo.c() == item) {
            changeInfo.g(null);
        } else {
            if (changeInfo.d() != item) {
                return false;
            }
            changeInfo.h(null);
            z16 = true;
        }
        Intrinsics.checkNotNull(item);
        item.itemView.setAlpha(1.0f);
        item.itemView.setTranslationX(0.0f);
        item.itemView.setTranslationY(0.0f);
        dispatchChangeFinished(item, z16);
        return true;
    }

    private final void o(RecyclerView.ViewHolder holder) {
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        h(view);
        p(holder);
    }

    private final void q(RecyclerView.ViewHolder holder) {
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        h(view);
        r(holder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(n this$0, ArrayList moves) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(moves, "$moves");
        if (!this$0.movesList.remove(moves)) {
            return;
        }
        Iterator it = moves.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            this$0.animateMoveImpl(fVar.c(), fVar.a(), fVar.b(), fVar.d(), fVar.e());
        }
        moves.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(n this$0, ArrayList changes) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(changes, "$changes");
        if (!this$0.changesList.remove(changes)) {
            return;
        }
        Iterator it = changes.iterator();
        while (it.hasNext()) {
            b change = (b) it.next();
            Intrinsics.checkNotNullExpressionValue(change, "change");
            this$0.g(change);
        }
        changes.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(n this$0, ArrayList additions) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(additions, "$additions");
        if (!this$0.additionsList.remove(additions)) {
            return;
        }
        Iterator it = additions.iterator();
        while (it.hasNext()) {
            RecyclerView.ViewHolder holder = (RecyclerView.ViewHolder) it.next();
            Intrinsics.checkNotNullExpressionValue(holder, "holder");
            this$0.i(holder);
        }
        additions.clear();
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateAdd(@NotNull RecyclerView.ViewHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) holder)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        endAnimation(holder);
        o(holder);
        this.pendingAdditions.add(holder);
        return true;
    }

    protected abstract void animateAddImpl(@NotNull RecyclerView.ViewHolder holder);

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateChange(@NotNull RecyclerView.ViewHolder oldHolder, @NotNull RecyclerView.ViewHolder newHolder, int fromX, int fromY, int toX, int toY) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, this, oldHolder, newHolder, Integer.valueOf(fromX), Integer.valueOf(fromY), Integer.valueOf(toX), Integer.valueOf(toY))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(oldHolder, "oldHolder");
        Intrinsics.checkNotNullParameter(newHolder, "newHolder");
        if (oldHolder == newHolder) {
            return animateMove(oldHolder, fromX, fromY, toX, toY);
        }
        float translationX = oldHolder.itemView.getTranslationX();
        float translationY = oldHolder.itemView.getTranslationY();
        float alpha = oldHolder.itemView.getAlpha();
        endAnimation(oldHolder);
        oldHolder.itemView.setTranslationX(translationX);
        oldHolder.itemView.setTranslationY(translationY);
        oldHolder.itemView.setAlpha(alpha);
        endAnimation(newHolder);
        newHolder.itemView.setTranslationX(-((int) ((toX - fromX) - translationX)));
        newHolder.itemView.setTranslationY(-((int) ((toY - fromY) - translationY)));
        newHolder.itemView.setAlpha(0.0f);
        this.pendingChanges.add(new b(oldHolder, newHolder, fromX, fromY, toX, toY));
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateMove(@NotNull RecyclerView.ViewHolder holder, int fromX, int fromY, int toX, int toY) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, this, holder, Integer.valueOf(fromX), Integer.valueOf(fromY), Integer.valueOf(toX), Integer.valueOf(toY))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        int translationX = fromX + ((int) holder.itemView.getTranslationX());
        int translationY = fromY + ((int) holder.itemView.getTranslationY());
        endAnimation(holder);
        int i3 = toX - translationX;
        int i16 = toY - translationY;
        if (i3 == 0 && i16 == 0) {
            dispatchMoveFinished(holder);
            return false;
        }
        if (i3 != 0) {
            view.setTranslationX(-i3);
        }
        if (i16 != 0) {
            view.setTranslationY(-i16);
        }
        this.pendingMoves.add(new f(holder, translationX, translationY, toX, toY));
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateRemove(@NotNull RecyclerView.ViewHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) holder)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        endAnimation(holder);
        q(holder);
        this.pendingRemovals.add(holder);
        return true;
    }

    protected abstract void animateRemoveImpl(@NotNull RecyclerView.ViewHolder holder);

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimation(@NotNull RecyclerView.ViewHolder item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        View view = item.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "item.itemView");
        view.animate().cancel();
        int size = this.pendingMoves.size() - 1;
        if (size >= 0) {
            while (true) {
                int i3 = size - 1;
                f fVar = this.pendingMoves.get(size);
                Intrinsics.checkNotNullExpressionValue(fVar, "pendingMoves[i]");
                if (fVar.c() == item) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    dispatchMoveFinished(item);
                    this.pendingMoves.remove(size);
                }
                if (i3 < 0) {
                    break;
                } else {
                    size = i3;
                }
            }
        }
        endChangeAnimation(this.pendingChanges, item);
        if (this.pendingRemovals.remove(item)) {
            View view2 = item.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "item.itemView");
            h(view2);
            dispatchRemoveFinished(item);
        }
        if (this.pendingAdditions.remove(item)) {
            View view3 = item.itemView;
            Intrinsics.checkNotNullExpressionValue(view3, "item.itemView");
            h(view3);
            dispatchAddFinished(item);
        }
        int size2 = this.changesList.size() - 1;
        if (size2 >= 0) {
            while (true) {
                int i16 = size2 - 1;
                ArrayList<b> arrayList = this.changesList.get(size2);
                Intrinsics.checkNotNullExpressionValue(arrayList, "changesList[i]");
                ArrayList<b> arrayList2 = arrayList;
                endChangeAnimation(arrayList2, item);
                if (arrayList2.isEmpty()) {
                    this.changesList.remove(size2);
                }
                if (i16 < 0) {
                    break;
                } else {
                    size2 = i16;
                }
            }
        }
        int size3 = this.movesList.size() - 1;
        if (size3 >= 0) {
            while (true) {
                int i17 = size3 - 1;
                ArrayList<f> arrayList3 = this.movesList.get(size3);
                Intrinsics.checkNotNullExpressionValue(arrayList3, "movesList[i]");
                ArrayList<f> arrayList4 = arrayList3;
                int size4 = arrayList4.size() - 1;
                if (size4 >= 0) {
                    while (true) {
                        int i18 = size4 - 1;
                        f fVar2 = arrayList4.get(size4);
                        Intrinsics.checkNotNullExpressionValue(fVar2, "moves[j]");
                        if (fVar2.c() == item) {
                            view.setTranslationY(0.0f);
                            view.setTranslationX(0.0f);
                            dispatchMoveFinished(item);
                            arrayList4.remove(size4);
                            if (arrayList4.isEmpty()) {
                                this.movesList.remove(size3);
                            }
                        } else if (i18 < 0) {
                            break;
                        } else {
                            size4 = i18;
                        }
                    }
                }
                if (i17 < 0) {
                    break;
                } else {
                    size3 = i17;
                }
            }
        }
        int size5 = this.additionsList.size() - 1;
        if (size5 >= 0) {
            while (true) {
                int i19 = size5 - 1;
                ArrayList<RecyclerView.ViewHolder> arrayList5 = this.additionsList.get(size5);
                Intrinsics.checkNotNullExpressionValue(arrayList5, "additionsList[i]");
                ArrayList<RecyclerView.ViewHolder> arrayList6 = arrayList5;
                if (arrayList6.remove(item)) {
                    View view4 = item.itemView;
                    Intrinsics.checkNotNullExpressionValue(view4, "item.itemView");
                    h(view4);
                    dispatchAddFinished(item);
                    if (arrayList6.isEmpty()) {
                        this.additionsList.remove(size5);
                    }
                }
                if (i19 < 0) {
                    break;
                } else {
                    size5 = i19;
                }
            }
        }
        this.removeAnimations.remove(item);
        this.addAnimations.remove(item);
        this.changeAnimations.remove(item);
        this.moveAnimations.remove(item);
        dispatchFinishedWhenDone();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimations() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        int size = this.pendingMoves.size();
        while (true) {
            size--;
            if (-1 >= size) {
                break;
            }
            f fVar = this.pendingMoves.get(size);
            Intrinsics.checkNotNullExpressionValue(fVar, "pendingMoves[i]");
            f fVar2 = fVar;
            View view = fVar2.c().itemView;
            Intrinsics.checkNotNullExpressionValue(view, "item.holder.itemView");
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            dispatchMoveFinished(fVar2.c());
            this.pendingMoves.remove(size);
        }
        for (int size2 = this.pendingRemovals.size() - 1; -1 < size2; size2--) {
            RecyclerView.ViewHolder viewHolder = this.pendingRemovals.get(size2);
            Intrinsics.checkNotNullExpressionValue(viewHolder, "pendingRemovals[i]");
            dispatchRemoveFinished(viewHolder);
            this.pendingRemovals.remove(size2);
        }
        int size3 = this.pendingAdditions.size();
        while (true) {
            size3--;
            if (-1 >= size3) {
                break;
            }
            RecyclerView.ViewHolder viewHolder2 = this.pendingAdditions.get(size3);
            Intrinsics.checkNotNullExpressionValue(viewHolder2, "pendingAdditions[i]");
            RecyclerView.ViewHolder viewHolder3 = viewHolder2;
            View view2 = viewHolder3.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "item.itemView");
            h(view2);
            dispatchAddFinished(viewHolder3);
            this.pendingAdditions.remove(size3);
        }
        for (int size4 = this.pendingChanges.size() - 1; -1 < size4; size4--) {
            b bVar = this.pendingChanges.get(size4);
            Intrinsics.checkNotNullExpressionValue(bVar, "pendingChanges[i]");
            k(bVar);
        }
        this.pendingChanges.clear();
        if (!isRunning()) {
            return;
        }
        for (int size5 = this.movesList.size() - 1; -1 < size5; size5--) {
            ArrayList<f> arrayList = this.movesList.get(size5);
            Intrinsics.checkNotNullExpressionValue(arrayList, "movesList[i]");
            ArrayList<f> arrayList2 = arrayList;
            for (int size6 = arrayList2.size() - 1; -1 < size6; size6--) {
                f fVar3 = arrayList2.get(size6);
                Intrinsics.checkNotNullExpressionValue(fVar3, "moves[j]");
                f fVar4 = fVar3;
                View view3 = fVar4.c().itemView;
                Intrinsics.checkNotNullExpressionValue(view3, "item.itemView");
                view3.setTranslationY(0.0f);
                view3.setTranslationX(0.0f);
                dispatchMoveFinished(fVar4.c());
                arrayList2.remove(size6);
                if (arrayList2.isEmpty()) {
                    this.movesList.remove(arrayList2);
                }
            }
        }
        for (int size7 = this.additionsList.size() - 1; -1 < size7; size7--) {
            ArrayList<RecyclerView.ViewHolder> arrayList3 = this.additionsList.get(size7);
            Intrinsics.checkNotNullExpressionValue(arrayList3, "additionsList[i]");
            ArrayList<RecyclerView.ViewHolder> arrayList4 = arrayList3;
            for (int size8 = arrayList4.size() - 1; -1 < size8; size8--) {
                RecyclerView.ViewHolder viewHolder4 = arrayList4.get(size8);
                Intrinsics.checkNotNullExpressionValue(viewHolder4, "additions[j]");
                RecyclerView.ViewHolder viewHolder5 = viewHolder4;
                View view4 = viewHolder5.itemView;
                Intrinsics.checkNotNullExpressionValue(view4, "item.itemView");
                view4.setAlpha(1.0f);
                dispatchAddFinished(viewHolder5);
                if (size8 < arrayList4.size()) {
                    arrayList4.remove(size8);
                }
                if (arrayList4.isEmpty()) {
                    this.additionsList.remove(arrayList4);
                }
            }
        }
        for (int size9 = this.changesList.size() - 1; -1 < size9; size9--) {
            ArrayList<b> arrayList5 = this.changesList.get(size9);
            Intrinsics.checkNotNullExpressionValue(arrayList5, "changesList[i]");
            ArrayList<b> arrayList6 = arrayList5;
            for (int size10 = arrayList6.size() - 1; -1 < size10; size10--) {
                b bVar2 = arrayList6.get(size10);
                Intrinsics.checkNotNullExpressionValue(bVar2, "changes[j]");
                k(bVar2);
                if (arrayList6.isEmpty()) {
                    this.changesList.remove(arrayList6);
                }
            }
        }
        cancelAll(this.removeAnimations);
        cancelAll(this.moveAnimations);
        cancelAll(this.addAnimations);
        cancelAll(this.changeAnimations);
        dispatchAnimationsFinished();
    }

    public final void h(@NotNull View v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) v3);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        v3.setAlpha(1.0f);
        v3.setScaleY(1.0f);
        v3.setScaleX(1.0f);
        v3.setTranslationY(0.0f);
        v3.setTranslationX(0.0f);
        v3.setRotation(0.0f);
        v3.setRotationY(0.0f);
        v3.setRotationX(0.0f);
        v3.setPivotY(v3.getMeasuredHeight() / 2.0f);
        v3.setPivotX(v3.getMeasuredWidth() / 2.0f);
        v3.animate().setInterpolator(null).setStartDelay(0L);
        v3.setZ(0.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean isRunning() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        if ((!this.pendingAdditions.isEmpty()) || (!this.pendingChanges.isEmpty()) || (!this.pendingMoves.isEmpty()) || (!this.pendingRemovals.isEmpty()) || (!this.moveAnimations.isEmpty()) || (!this.removeAnimations.isEmpty()) || (!this.addAnimations.isEmpty()) || (!this.changeAnimations.isEmpty()) || (!this.movesList.isEmpty()) || (!this.additionsList.isEmpty()) || (!this.changesList.isEmpty())) {
            return true;
        }
        return false;
    }

    @NotNull
    protected final ArrayList<RecyclerView.ViewHolder> m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.addAnimations;
    }

    @NotNull
    protected final ArrayList<RecyclerView.ViewHolder> n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.removeAnimations;
    }

    protected abstract void p(@NotNull RecyclerView.ViewHolder holder);

    protected void r(@NotNull RecyclerView.ViewHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) holder);
        } else {
            Intrinsics.checkNotNullParameter(holder, "holder");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void runPendingAnimations() {
        long j3;
        long j16;
        long coerceAtLeast;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        boolean z16 = !this.pendingRemovals.isEmpty();
        boolean z17 = !this.pendingMoves.isEmpty();
        boolean z18 = !this.pendingChanges.isEmpty();
        boolean z19 = !this.pendingAdditions.isEmpty();
        if (!z16 && !z17 && !z19 && !z18) {
            return;
        }
        Iterator<RecyclerView.ViewHolder> it = this.pendingRemovals.iterator();
        while (it.hasNext()) {
            RecyclerView.ViewHolder holder = it.next();
            Intrinsics.checkNotNullExpressionValue(holder, "holder");
            j(holder);
        }
        this.pendingRemovals.clear();
        if (z17) {
            final ArrayList<f> arrayList = new ArrayList<>(this.pendingMoves);
            this.movesList.add(arrayList);
            this.pendingMoves.clear();
            Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.aio.notification.list.k
                @Override // java.lang.Runnable
                public final void run() {
                    n.s(n.this, arrayList);
                }
            };
            if (!this.runAnimationWithoutDelay && z16) {
                View view = arrayList.get(0).c().itemView;
                Intrinsics.checkNotNullExpressionValue(view, "moves[0].holder.itemView");
                view.postOnAnimationDelayed(runnable, getRemoveDuration());
            } else {
                runnable.run();
            }
        }
        if (z18) {
            final ArrayList<b> arrayList2 = new ArrayList<>(this.pendingChanges);
            this.changesList.add(arrayList2);
            this.pendingChanges.clear();
            Runnable runnable2 = new Runnable() { // from class: com.tencent.mobileqq.aio.notification.list.l
                @Override // java.lang.Runnable
                public final void run() {
                    n.t(n.this, arrayList2);
                }
            };
            if (!this.runAnimationWithoutDelay && z16) {
                RecyclerView.ViewHolder d16 = arrayList2.get(0).d();
                Intrinsics.checkNotNull(d16);
                d16.itemView.postOnAnimationDelayed(runnable2, getRemoveDuration());
            } else {
                runnable2.run();
            }
        }
        if (z19) {
            final ArrayList<RecyclerView.ViewHolder> arrayList3 = new ArrayList<>(this.pendingAdditions);
            this.additionsList.add(arrayList3);
            this.pendingAdditions.clear();
            Runnable runnable3 = new Runnable() { // from class: com.tencent.mobileqq.aio.notification.list.m
                @Override // java.lang.Runnable
                public final void run() {
                    n.u(n.this, arrayList3);
                }
            };
            if (!this.runAnimationWithoutDelay && (z16 || z17 || z18)) {
                long j17 = 0;
                if (z16) {
                    j3 = getRemoveDuration();
                } else {
                    j3 = 0;
                }
                if (z17) {
                    j16 = getMoveDuration();
                } else {
                    j16 = 0;
                }
                if (z18) {
                    j17 = getChangeDuration();
                }
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(j16, j17);
                long j18 = j3 + coerceAtLeast;
                View view2 = arrayList3.get(0).itemView;
                Intrinsics.checkNotNullExpressionValue(view2, "additions[0].itemView");
                view2.postOnAnimationDelayed(runnable3, j18);
                return;
            }
            runnable3.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0011\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001e\u0010\u001fB9\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u0010\u0012\u0006\u0010\u001d\u001a\u00020\u0010\u00a2\u0006\u0004\b\u001e\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\"\u0010\u0015\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0011\u001a\u0004\b\u0005\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\f\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\"\u0010\u001a\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/list/n$b;", "", "", "toString", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "d", "()Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", tl.h.F, "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "oldHolder", "b", "c", "g", "newHolder", "", "I", "()I", "setFromX", "(I)V", "fromX", "setFromY", "fromY", "e", "setToX", "toX", "f", "setToY", "toY", "<init>", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;IIII)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private RecyclerView.ViewHolder oldHolder;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private RecyclerView.ViewHolder newHolder;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int fromX;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int fromY;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int toX;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int toY;

        b(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) viewHolder, (Object) viewHolder2);
            } else {
                this.oldHolder = viewHolder;
                this.newHolder = viewHolder2;
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.fromX;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return this.fromY;
        }

        @Nullable
        public final RecyclerView.ViewHolder c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.newHolder;
        }

        @Nullable
        public final RecyclerView.ViewHolder d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.oldHolder;
        }

        public final int e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return this.toX;
        }

        public final int f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
            }
            return this.toY;
        }

        public final void g(@Nullable RecyclerView.ViewHolder viewHolder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) viewHolder);
            } else {
                this.newHolder = viewHolder;
            }
        }

        public final void h(@Nullable RecyclerView.ViewHolder viewHolder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewHolder);
            } else {
                this.oldHolder = viewHolder;
            }
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (String) iPatchRedirector.redirect((short) 15, (Object) this);
            }
            return "ChangeInfo{oldHolder=" + this.oldHolder + ", newHolder=" + this.newHolder + ", fromX=" + this.fromX + ", fromY=" + this.fromY + ", toX=" + this.toX + ", toY=" + this.toY + "}";
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public b(@NotNull RecyclerView.ViewHolder oldHolder, @NotNull RecyclerView.ViewHolder newHolder, int i3, int i16, int i17, int i18) {
            this(oldHolder, newHolder);
            Intrinsics.checkNotNullParameter(oldHolder, "oldHolder");
            Intrinsics.checkNotNullParameter(newHolder, "newHolder");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, this, oldHolder, newHolder, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                return;
            }
            this.fromX = i3;
            this.fromY = i16;
            this.toX = i17;
            this.toY = i18;
        }
    }
}
