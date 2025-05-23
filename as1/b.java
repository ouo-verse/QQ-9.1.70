package as1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.animation.GuildLeftBarAnimator;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0002&\u0017B\u00a7\u0001\u00126\u0010*\u001a2\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u00040!\u00126\u0010,\u001a2\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u00040!\u0012\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040-\u0012\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000402\u0012\f\u00109\u001a\b\u0012\u0004\u0012\u00020702\u00a2\u0006\u0004\b=\u0010>J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J,\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rJ6\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010\u001b\u001a\u00020\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00192\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0006J\u0006\u0010\u001f\u001a\u00020\u0004J\u0006\u0010 \u001a\u00020\bRG\u0010*\u001a2\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u00040!8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)RG\u0010,\u001a2\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u00040!8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010'\u001a\u0004\b+\u0010)R#\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040-8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010.\u001a\u0004\b/\u00100R\u001d\u00106\u001a\b\u0012\u0004\u0012\u00020\u0004028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u00103\u001a\u0004\b4\u00105R\u001d\u00109\u001a\b\u0012\u0004\u0012\u000207028\u0006\u00a2\u0006\f\n\u0004\b\u001f\u00103\u001a\u0004\b8\u00105R\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00060:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010;\u00a8\u0006?"}, d2 = {"Las1/b;", "", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/animation/GuildLeftBarAnimator$a;", "changeInfo", "", "l", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "oldHolder", "newHolder", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator$ItemHolderInfo;", "preInfo", "postInfo", "", "c", "", "fromX", "fromY", "toX", "toY", "b", "d", "", "infoList", "f", "g", "holder", "o", "e", DomainData.DOMAIN_NAME, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "viewHolder", "isOldItem", "a", "Lkotlin/jvm/functions/Function2;", "j", "()Lkotlin/jvm/functions/Function2;", "dispatchChangeStarting", "i", "dispatchChangeFinished", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "getResetAnimation", "()Lkotlin/jvm/functions/Function1;", "resetAnimation", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "k", "()Lkotlin/jvm/functions/Function0;", "dispatchFinishedWhenDone", "", "getChangeDuration", "changeDuration", "Ljava/util/ArrayList;", "Ljava/util/ArrayList;", "mChangeAnimations", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<RecyclerView.ViewHolder, Boolean, Unit> dispatchChangeStarting;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<RecyclerView.ViewHolder, Boolean, Unit> dispatchChangeFinished;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<RecyclerView.ViewHolder, Unit> resetAnimation;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> dispatchFinishedWhenDone;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Long> changeDuration;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<RecyclerView.ViewHolder> mChangeAnimations;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nR\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Las1/b$b;", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator$ItemHolderInfo;", "", "a", "Z", "()Z", "b", "(Z)V", "doAnimation", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: as1.b$b, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static final class C0069b extends RecyclerView.ItemAnimator.ItemHolderInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean doAnimation;

        /* renamed from: a, reason: from getter */
        public final boolean getDoAnimation() {
            return this.doAnimation;
        }

        public final void b(boolean z16) {
            this.doAnimation = z16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"as1/b$d", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animator", "", "onAnimationStart", "onAnimationEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d extends AnimatorListenerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f26857e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f26858f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ View f26859h;

        d(RecyclerView.ViewHolder viewHolder, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f26857e = viewHolder;
            this.f26858f = viewPropertyAnimator;
            this.f26859h = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            this.f26858f.setListener(null);
            this.f26859h.setAlpha(1.0f);
            this.f26859h.setTranslationX(0.0f);
            this.f26859h.setTranslationY(0.0f);
            b.this.i().invoke(this.f26857e, Boolean.TRUE);
            b.this.mChangeAnimations.remove(this.f26857e);
            b.this.k().invoke();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            b.this.j().invoke(this.f26857e, Boolean.TRUE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"as1/b$e", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animator", "", "onAnimationStart", "onAnimationEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e extends AnimatorListenerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f26861e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f26862f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ View f26863h;

        e(RecyclerView.ViewHolder viewHolder, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f26861e = viewHolder;
            this.f26862f = viewPropertyAnimator;
            this.f26863h = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            this.f26862f.setListener(null);
            this.f26863h.setAlpha(1.0f);
            this.f26863h.setTranslationX(0.0f);
            this.f26863h.setTranslationY(0.0f);
            b.this.i().invoke(this.f26861e, Boolean.FALSE);
            b.this.mChangeAnimations.remove(this.f26861e);
            b.this.k().invoke();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            b.this.j().invoke(this.f26861e, Boolean.FALSE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull Function2<? super RecyclerView.ViewHolder, ? super Boolean, Unit> dispatchChangeStarting, @NotNull Function2<? super RecyclerView.ViewHolder, ? super Boolean, Unit> dispatchChangeFinished, @NotNull Function1<? super RecyclerView.ViewHolder, Unit> resetAnimation, @NotNull Function0<Unit> dispatchFinishedWhenDone, @NotNull Function0<Long> changeDuration) {
        Intrinsics.checkNotNullParameter(dispatchChangeStarting, "dispatchChangeStarting");
        Intrinsics.checkNotNullParameter(dispatchChangeFinished, "dispatchChangeFinished");
        Intrinsics.checkNotNullParameter(resetAnimation, "resetAnimation");
        Intrinsics.checkNotNullParameter(dispatchFinishedWhenDone, "dispatchFinishedWhenDone");
        Intrinsics.checkNotNullParameter(changeDuration, "changeDuration");
        this.dispatchChangeStarting = dispatchChangeStarting;
        this.dispatchChangeFinished = dispatchChangeFinished;
        this.resetAnimation = resetAnimation;
        this.dispatchFinishedWhenDone = dispatchFinishedWhenDone;
        this.changeDuration = changeDuration;
        this.mChangeAnimations = new ArrayList<>();
    }

    private final boolean h(GuildLeftBarAnimator.a changeInfo, RecyclerView.ViewHolder item) {
        boolean z16 = false;
        if (!changeInfo.getIsNewHolderClear() && changeInfo.getNewHolder() == item) {
            changeInfo.j(true);
        } else {
            if (changeInfo.getIsOldHolderClear() || changeInfo.getOldHolder() != item) {
                return false;
            }
            changeInfo.k(true);
            z16 = true;
        }
        item.itemView.setAlpha(1.0f);
        item.itemView.setTranslationX(0.0f);
        item.itemView.setTranslationY(0.0f);
        this.dispatchChangeFinished.invoke(item, Boolean.valueOf(z16));
        return true;
    }

    private final void l(GuildLeftBarAnimator.a changeInfo) {
        boolean z16;
        RecyclerView.ViewHolder oldHolder = changeInfo.getOldHolder();
        RecyclerView.ItemAnimator.ItemHolderInfo preInfo = changeInfo.getPreInfo();
        if (oldHolder == changeInfo.getNewHolder()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (oldHolder instanceof fs1.b) {
                if (preInfo instanceof C0069b) {
                    ((fs1.b) oldHolder).N(new c(oldHolder, preInfo));
                    return;
                }
                throw new IllegalStateException("Check failed.".toString());
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private final void m(GuildLeftBarAnimator.a changeInfo) {
        if (!changeInfo.getIsOldHolderClear()) {
            RecyclerView.ViewHolder oldHolder = changeInfo.getOldHolder();
            View view = oldHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "oldHolder.itemView");
            ViewPropertyAnimator duration = view.animate().setDuration(0L);
            this.mChangeAnimations.add(oldHolder);
            duration.translationX(changeInfo.getToX() - changeInfo.getFromX());
            duration.translationY(changeInfo.getToY() - changeInfo.getFromY());
            duration.alpha(0.0f).setListener(new d(oldHolder, duration, view)).start();
        }
        if (!changeInfo.getIsNewHolderClear()) {
            RecyclerView.ViewHolder newHolder = changeInfo.getNewHolder();
            View view2 = newHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "newHolder.itemView");
            ViewPropertyAnimator animate = view2.animate();
            this.mChangeAnimations.add(newHolder);
            animate.translationX(0.0f).translationY(0.0f).setDuration(0L).alpha(1.0f).setListener(new e(newHolder, animate, view2)).start();
        }
    }

    @NotNull
    public final GuildLeftBarAnimator.a b(@NotNull RecyclerView.ViewHolder oldHolder, @NotNull RecyclerView.ViewHolder newHolder, int fromX, int fromY, int toX, int toY) {
        Intrinsics.checkNotNullParameter(oldHolder, "oldHolder");
        Intrinsics.checkNotNullParameter(newHolder, "newHolder");
        float translationX = oldHolder.itemView.getTranslationX();
        float translationY = oldHolder.itemView.getTranslationY();
        float alpha = oldHolder.itemView.getAlpha();
        this.resetAnimation.invoke(oldHolder);
        oldHolder.itemView.setTranslationX(translationX);
        oldHolder.itemView.setTranslationY(translationY);
        oldHolder.itemView.setAlpha(alpha);
        this.resetAnimation.invoke(newHolder);
        newHolder.itemView.setTranslationX(-((int) ((toX - fromX) - translationX)));
        newHolder.itemView.setTranslationY(-((int) ((toY - fromY) - translationY)));
        newHolder.itemView.setAlpha(0.0f);
        return new GuildLeftBarAnimator.a(oldHolder, newHolder, fromX, fromY, toX, toY);
    }

    @NotNull
    public final List<GuildLeftBarAnimator.a> c(@NotNull RecyclerView.ViewHolder oldHolder, @NotNull RecyclerView.ViewHolder newHolder, @NotNull RecyclerView.ItemAnimator.ItemHolderInfo preInfo, @NotNull RecyclerView.ItemAnimator.ItemHolderInfo postInfo) {
        List<GuildLeftBarAnimator.a> listOf;
        List<GuildLeftBarAnimator.a> emptyList;
        Intrinsics.checkNotNullParameter(oldHolder, "oldHolder");
        Intrinsics.checkNotNullParameter(newHolder, "newHolder");
        Intrinsics.checkNotNullParameter(preInfo, "preInfo");
        Intrinsics.checkNotNullParameter(postInfo, "postInfo");
        if (preInfo instanceof C0069b) {
            if (!((C0069b) preInfo).getDoAnimation()) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new GuildLeftBarAnimator.a(oldHolder, newHolder, preInfo, postInfo));
            return listOf;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final void d(@NotNull GuildLeftBarAnimator.a changeInfo) {
        Intrinsics.checkNotNullParameter(changeInfo, "changeInfo");
        RecyclerView.ItemAnimator.ItemHolderInfo preInfo = changeInfo.getPreInfo();
        if (preInfo == null) {
            m(changeInfo);
        } else {
            if (preInfo instanceof C0069b) {
                if (!((C0069b) preInfo).getDoAnimation()) {
                    return;
                }
                l(changeInfo);
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public final void e() {
        int size = this.mChangeAnimations.size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i3 = size - 1;
            RecyclerView.ViewHolder viewHolder = this.mChangeAnimations.get(size);
            Intrinsics.checkNotNullExpressionValue(viewHolder, "mChangeAnimations[i]");
            RecyclerView.ViewHolder viewHolder2 = viewHolder;
            viewHolder2.itemView.animate().cancel();
            if (viewHolder2 instanceof fs1.b) {
                ((fs1.b) viewHolder2).s();
            }
            if (i3 >= 0) {
                size = i3;
            } else {
                return;
            }
        }
    }

    public final void f(@NotNull List<GuildLeftBarAnimator.a> infoList, @NotNull RecyclerView.ViewHolder item) {
        Intrinsics.checkNotNullParameter(infoList, "infoList");
        Intrinsics.checkNotNullParameter(item, "item");
        int size = infoList.size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i3 = size - 1;
            GuildLeftBarAnimator.a aVar = infoList.get(size);
            if (h(aVar, item) && aVar.getIsOldHolderClear() && aVar.getIsNewHolderClear()) {
                infoList.remove(aVar);
            }
            if (i3 >= 0) {
                size = i3;
            } else {
                return;
            }
        }
    }

    public final void g(@NotNull GuildLeftBarAnimator.a changeInfo) {
        Intrinsics.checkNotNullParameter(changeInfo, "changeInfo");
        RecyclerView.ViewHolder oldHolder = changeInfo.getOldHolder();
        if (!changeInfo.getIsOldHolderClear()) {
            h(changeInfo, oldHolder);
        }
        RecyclerView.ViewHolder newHolder = changeInfo.getNewHolder();
        if (!changeInfo.getIsNewHolderClear()) {
            h(changeInfo, newHolder);
        }
    }

    @NotNull
    public final Function2<RecyclerView.ViewHolder, Boolean, Unit> i() {
        return this.dispatchChangeFinished;
    }

    @NotNull
    public final Function2<RecyclerView.ViewHolder, Boolean, Unit> j() {
        return this.dispatchChangeStarting;
    }

    @NotNull
    public final Function0<Unit> k() {
        return this.dispatchFinishedWhenDone;
    }

    public final boolean n() {
        return !this.mChangeAnimations.isEmpty();
    }

    public final boolean o(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        return this.mChangeAnimations.remove(holder);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"as1/b$c", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements Animator.AnimatorListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f26854e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ RecyclerView.ItemAnimator.ItemHolderInfo f26855f;

        c(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
            this.f26854e = viewHolder;
            this.f26855f = itemHolderInfo;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            onAnimationEnd(animation);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            b.this.i().invoke(this.f26854e, Boolean.TRUE);
            b.this.k().invoke();
            ((C0069b) this.f26855f).b(false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            b.this.j().invoke(this.f26854e, Boolean.TRUE);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }
    }
}
