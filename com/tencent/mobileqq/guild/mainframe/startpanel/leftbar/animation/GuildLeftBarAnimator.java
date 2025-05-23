package com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import as1.b;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 K2\u00020\u0001:\u0003+.1B\u0007\u00a2\u0006\u0004\bI\u0010JJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J0\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016J.\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nJ8\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016J(\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J.\u0010 \u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\n2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0002H\u0016J\b\u0010#\u001a\u00020\u0007H\u0016J\u0006\u0010$\u001a\u00020\u0004J\b\u0010%\u001a\u00020\u0004H\u0016J\u0014\u0010'\u001a\u00020\u00042\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020\u001dJ\u001e\u0010(\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00022\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016R$\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u00020)j\b\u0012\u0004\u0012\u00020\u0002`*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R$\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u00020)j\b\u0012\u0004\u0012\u00020\u0002`*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010,R$\u00102\u001a\u0012\u0012\u0004\u0012\u0002000)j\b\u0012\u0004\u0012\u000200`*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010,R$\u00105\u001a\u0012\u0012\u0004\u0012\u0002030)j\b\u0012\u0004\u0012\u000203`*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010,RF\u00107\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00020)j\b\u0012\u0004\u0012\u00020\u0002`*0)j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00020)j\b\u0012\u0004\u0012\u00020\u0002`*`*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010,RF\u00108\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002000)j\b\u0012\u0004\u0012\u000200`*0)j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002000)j\b\u0012\u0004\u0012\u000200`*`*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010,RF\u0010:\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002030)j\b\u0012\u0004\u0012\u000203`*0)j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002030)j\b\u0012\u0004\u0012\u000203`*`*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010,R&\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\u00020)j\b\u0012\u0004\u0012\u00020\u0002`*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010,R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010G\u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/animation/GuildLeftBarAnimator;", "Landroidx/recyclerview/widget/SimpleItemAnimator;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "", "resetAnimation", "runPendingAnimations", "", "animateRemove", "animateAdd", "", "fromX", "fromY", "toX", "toY", "animateMove", "animateMoveImpl", "oldHolder", "newHolder", "animateChange", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator$ItemHolderInfo;", "preInfo", "postInfo", "Las1/b$b;", "f", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "viewHolder", "changeFlags", "", "", "payloads", "recordPreLayoutInformation", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "endAnimation", "isRunning", "dispatchFinishedWhenDone", "endAnimations", "viewHolders", "cancelAll", "canReuseUpdatedViewHolder", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "mPendingRemovals", "b", "mPendingAdditions", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/animation/GuildLeftBarAnimator$c;", "c", "mPendingMoves", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/animation/GuildLeftBarAnimator$a;", "d", "mPendingChanges", "e", "mAdditionsList", "mMovesList", "g", "mChangesList", h.F, "mMoveAnimations", "Las1/b;", "i", "Las1/b;", "mChangeAnimationRunner", "Las1/a;", "j", "Las1/a;", "mAddAnimationRunner", "Las1/c;", "k", "Las1/c;", "mRemoveAnimationRunner", "<init>", "()V", "l", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildLeftBarAnimator extends SimpleItemAnimator {

    /* renamed from: m, reason: collision with root package name */
    private static final boolean f227572m = false;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    private static TimeInterpolator f227573n;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<RecyclerView.ViewHolder> mPendingRemovals = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<RecyclerView.ViewHolder> mPendingAdditions = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<MoveInfo> mPendingMoves = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<a> mPendingChanges = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<ArrayList<RecyclerView.ViewHolder>> mAdditionsList = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<ArrayList<MoveInfo>> mMovesList = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<ArrayList<a>> mChangesList = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<RecyclerView.ViewHolder> mMoveAnimations = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private as1.b mChangeAnimationRunner = new as1.b(new GuildLeftBarAnimator$mChangeAnimationRunner$1(this), new GuildLeftBarAnimator$mChangeAnimationRunner$2(this), new GuildLeftBarAnimator$mChangeAnimationRunner$4(this), new GuildLeftBarAnimator$mChangeAnimationRunner$3(this), new Function0<Long>() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.animation.GuildLeftBarAnimator$mChangeAnimationRunner$5
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Long invoke() {
            return Long.valueOf(GuildLeftBarAnimator.this.getChangeDuration());
        }
    });

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private as1.a mAddAnimationRunner = new as1.a(new GuildLeftBarAnimator$mAddAnimationRunner$1(this), new GuildLeftBarAnimator$mAddAnimationRunner$2(this), new GuildLeftBarAnimator$mAddAnimationRunner$4(this), new GuildLeftBarAnimator$mAddAnimationRunner$3(this), new Function0<Long>() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.animation.GuildLeftBarAnimator$mAddAnimationRunner$5
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Long invoke() {
            return Long.valueOf(GuildLeftBarAnimator.this.getAddDuration());
        }
    });

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private as1.c mRemoveAnimationRunner = new as1.c(new GuildLeftBarAnimator$mRemoveAnimationRunner$1(this), new GuildLeftBarAnimator$mRemoveAnimationRunner$2(this), new GuildLeftBarAnimator$mRemoveAnimationRunner$4(this), new GuildLeftBarAnimator$mRemoveAnimationRunner$3(this), new Function0<Long>() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.animation.GuildLeftBarAnimator$mRemoveAnimationRunner$5
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Long invoke() {
            return Long.valueOf(GuildLeftBarAnimator.this.getRemoveDuration());
        }
    });

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\n\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\"\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/animation/GuildLeftBarAnimator$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "c", "()Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "setHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "holder", "b", "I", "()I", "setFromX", "(I)V", "fromX", "setFromY", "fromY", "d", "setToX", "toX", "e", "setToY", "toY", "<init>", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;IIII)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.animation.GuildLeftBarAnimator$c, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class MoveInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private RecyclerView.ViewHolder holder;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private int fromX;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private int fromY;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private int toX;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private int toY;

        public MoveInfo(@NotNull RecyclerView.ViewHolder holder, int i3, int i16, int i17, int i18) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            this.holder = holder;
            this.fromX = i3;
            this.fromY = i16;
            this.toX = i17;
            this.toY = i18;
        }

        /* renamed from: a, reason: from getter */
        public final int getFromX() {
            return this.fromX;
        }

        /* renamed from: b, reason: from getter */
        public final int getFromY() {
            return this.fromY;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final RecyclerView.ViewHolder getHolder() {
            return this.holder;
        }

        /* renamed from: d, reason: from getter */
        public final int getToX() {
            return this.toX;
        }

        /* renamed from: e, reason: from getter */
        public final int getToY() {
            return this.toY;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MoveInfo)) {
                return false;
            }
            MoveInfo moveInfo = (MoveInfo) other;
            if (Intrinsics.areEqual(this.holder, moveInfo.holder) && this.fromX == moveInfo.fromX && this.fromY == moveInfo.fromY && this.toX == moveInfo.toX && this.toY == moveInfo.toY) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.holder.hashCode() * 31) + this.fromX) * 31) + this.fromY) * 31) + this.toX) * 31) + this.toY;
        }

        @NotNull
        public String toString() {
            return "MoveInfo(holder=" + this.holder + ", fromX=" + this.fromX + ", fromY=" + this.fromY + ", toX=" + this.toX + ", toY=" + this.toY + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/mainframe/startpanel/leftbar/animation/GuildLeftBarAnimator$d", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animator", "", "onAnimationStart", "onAnimationCancel", "onAnimationEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d extends AnimatorListenerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f227601e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f227602f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ View f227603h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f227604i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f227605m;

        d(RecyclerView.ViewHolder viewHolder, int i3, View view, int i16, ViewPropertyAnimator viewPropertyAnimator) {
            this.f227601e = viewHolder;
            this.f227602f = i3;
            this.f227603h = view;
            this.f227604i = i16;
            this.f227605m = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            if (this.f227602f != 0) {
                this.f227603h.setTranslationX(0.0f);
            }
            if (this.f227604i != 0) {
                this.f227603h.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            this.f227605m.setListener(null);
            GuildLeftBarAnimator.this.dispatchMoveFinished(this.f227601e);
            GuildLeftBarAnimator.this.mMoveAnimations.remove(this.f227601e);
            GuildLeftBarAnimator.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            GuildLeftBarAnimator.this.dispatchMoveStarting(this.f227601e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(ArrayList moves, GuildLeftBarAnimator this$0) {
        Intrinsics.checkNotNullParameter(moves, "$moves");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator it = moves.iterator();
        while (it.hasNext()) {
            Object moves2 = it.next();
            Intrinsics.checkNotNullExpressionValue(moves2, "moves");
            MoveInfo moveInfo = (MoveInfo) moves2;
            this$0.animateMoveImpl(moveInfo.getHolder(), moveInfo.getFromX(), moveInfo.getFromY(), moveInfo.getToX(), moveInfo.getToY());
        }
        moves.clear();
        this$0.mMovesList.remove(moves);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ArrayList changes, GuildLeftBarAnimator this$0) {
        Intrinsics.checkNotNullParameter(changes, "$changes");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator it = changes.iterator();
        while (it.hasNext()) {
            Object changes2 = it.next();
            Intrinsics.checkNotNullExpressionValue(changes2, "changes");
            this$0.mChangeAnimationRunner.d((a) changes2);
        }
        changes.clear();
        this$0.mChangesList.remove(changes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(ArrayList additions, GuildLeftBarAnimator this$0) {
        Intrinsics.checkNotNullParameter(additions, "$additions");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator it = additions.iterator();
        while (it.hasNext()) {
            Object additions2 = it.next();
            Intrinsics.checkNotNullExpressionValue(additions2, "additions");
            this$0.mAddAnimationRunner.f((RecyclerView.ViewHolder) additions2);
        }
        additions.clear();
        this$0.mAdditionsList.remove(additions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetAnimation(RecyclerView.ViewHolder holder) {
        if (f227573n == null) {
            f227573n = new ValueAnimator().getInterpolator();
        }
        holder.itemView.animate().setInterpolator(f227573n);
        endAnimation(holder);
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateAdd(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.mAddAnimationRunner.e(holder);
        this.mPendingAdditions.add(holder);
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateChange(@NotNull RecyclerView.ViewHolder oldHolder, @NotNull RecyclerView.ViewHolder newHolder, int fromX, int fromY, int toX, int toY) {
        Intrinsics.checkNotNullParameter(oldHolder, "oldHolder");
        Intrinsics.checkNotNullParameter(newHolder, "newHolder");
        if (oldHolder == newHolder) {
            return animateMove(oldHolder, fromX, fromY, toX, toY);
        }
        this.mPendingChanges.add(this.mChangeAnimationRunner.b(oldHolder, newHolder, fromX, fromY, toX, toY));
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateMove(@NotNull RecyclerView.ViewHolder holder, int fromX, int fromY, int toX, int toY) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        int translationX = fromX + ((int) holder.itemView.getTranslationX());
        int translationY = fromY + ((int) holder.itemView.getTranslationY());
        resetAnimation(holder);
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
        this.mPendingMoves.add(new MoveInfo(holder, translationX, translationY, toX, toY));
        return true;
    }

    public final void animateMoveImpl(@NotNull RecyclerView.ViewHolder holder, int fromX, int fromY, int toX, int toY) {
        Intrinsics.checkNotNullParameter(holder, "holder");
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
        ViewPropertyAnimator animate = view.animate();
        this.mMoveAnimations.add(holder);
        animate.setDuration(getMoveDuration()).setListener(new d(holder, i3, view, i16, animate)).start();
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateRemove(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.mRemoveAnimationRunner.e(holder);
        this.mPendingRemovals.add(holder);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean canReuseUpdatedViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if ((!payloads.isEmpty()) || super.canReuseUpdatedViewHolder(viewHolder, payloads)) {
            return true;
        }
        return false;
    }

    public final void cancelAll(@NotNull List<? extends RecyclerView.ViewHolder> viewHolders) {
        Intrinsics.checkNotNullParameter(viewHolders, "viewHolders");
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

    public final void dispatchFinishedWhenDone() {
        if (!isRunning()) {
            dispatchAnimationsFinished();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimation(@NotNull RecyclerView.ViewHolder item) {
        Intrinsics.checkNotNullParameter(item, "item");
        View view = item.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "item.itemView");
        view.animate().cancel();
        int size = this.mPendingMoves.size() - 1;
        if (size >= 0) {
            while (true) {
                int i3 = size - 1;
                MoveInfo moveInfo = this.mPendingMoves.get(size);
                Intrinsics.checkNotNullExpressionValue(moveInfo, "mPendingMoves[i]");
                if (moveInfo.getHolder() == item) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    dispatchMoveFinished(item);
                    this.mPendingMoves.remove(size);
                }
                if (i3 < 0) {
                    break;
                } else {
                    size = i3;
                }
            }
        }
        this.mChangeAnimationRunner.f(this.mPendingChanges, item);
        if (this.mPendingRemovals.remove(item)) {
            this.mRemoveAnimationRunner.j(item);
            dispatchRemoveFinished(item);
        }
        if (this.mPendingAdditions.remove(item)) {
            this.mAddAnimationRunner.j(item);
            dispatchAddFinished(item);
        }
        int size2 = this.mChangesList.size() - 1;
        if (size2 >= 0) {
            while (true) {
                int i16 = size2 - 1;
                ArrayList<a> arrayList = this.mChangesList.get(size2);
                Intrinsics.checkNotNullExpressionValue(arrayList, "mChangesList[i]");
                ArrayList<a> arrayList2 = arrayList;
                this.mChangeAnimationRunner.f(arrayList2, item);
                if (arrayList2.isEmpty()) {
                    this.mChangesList.remove(size2);
                }
                if (i16 < 0) {
                    break;
                } else {
                    size2 = i16;
                }
            }
        }
        int size3 = this.mMovesList.size() - 1;
        if (size3 >= 0) {
            while (true) {
                int i17 = size3 - 1;
                ArrayList<MoveInfo> arrayList3 = this.mMovesList.get(size3);
                Intrinsics.checkNotNullExpressionValue(arrayList3, "mMovesList[i]");
                ArrayList<MoveInfo> arrayList4 = arrayList3;
                int size4 = arrayList4.size() - 1;
                if (size4 >= 0) {
                    while (true) {
                        int i18 = size4 - 1;
                        MoveInfo moveInfo2 = arrayList4.get(size4);
                        Intrinsics.checkNotNullExpressionValue(moveInfo2, "moves[j]");
                        if (moveInfo2.getHolder() == item) {
                            view.setTranslationY(0.0f);
                            view.setTranslationX(0.0f);
                            dispatchMoveFinished(item);
                            arrayList4.remove(size4);
                            if (arrayList4.isEmpty()) {
                                this.mMovesList.remove(size3);
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
        int size5 = this.mAdditionsList.size() - 1;
        if (size5 >= 0) {
            while (true) {
                int i19 = size5 - 1;
                ArrayList<RecyclerView.ViewHolder> arrayList5 = this.mAdditionsList.get(size5);
                Intrinsics.checkNotNullExpressionValue(arrayList5, "mAdditionsList[i]");
                ArrayList<RecyclerView.ViewHolder> arrayList6 = arrayList5;
                if (arrayList6.remove(item)) {
                    this.mAddAnimationRunner.j(item);
                    dispatchAddFinished(item);
                    if (arrayList6.isEmpty()) {
                        this.mAdditionsList.remove(size5);
                    }
                }
                if (i19 < 0) {
                    break;
                } else {
                    size5 = i19;
                }
            }
        }
        if (this.mRemoveAnimationRunner.k(item) && f227572m) {
            throw new IllegalStateException("after animation is cancelled, item should not be in mRemoveAnimations list");
        }
        if (this.mAddAnimationRunner.k(item) && f227572m) {
            throw new IllegalStateException("after animation is cancelled, item should not be in mAddAnimations list");
        }
        if (this.mChangeAnimationRunner.o(item) && f227572m) {
            throw new IllegalStateException("after animation is cancelled, item should not be in mChangeAnimations list");
        }
        if (this.mMoveAnimations.remove(item) && f227572m) {
            throw new IllegalStateException("after animation is cancelled, item should not be in mMoveAnimations list");
        }
        dispatchFinishedWhenDone();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimations() {
        int size = this.mPendingMoves.size();
        while (true) {
            size--;
            if (-1 >= size) {
                break;
            }
            MoveInfo moveInfo = this.mPendingMoves.get(size);
            Intrinsics.checkNotNullExpressionValue(moveInfo, "mPendingMoves[i]");
            MoveInfo moveInfo2 = moveInfo;
            View view = moveInfo2.getHolder().itemView;
            Intrinsics.checkNotNullExpressionValue(view, "item.holder.itemView");
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            dispatchMoveFinished(moveInfo2.getHolder());
            this.mPendingMoves.remove(size);
        }
        for (int size2 = this.mPendingRemovals.size() - 1; -1 < size2; size2--) {
            RecyclerView.ViewHolder viewHolder = this.mPendingRemovals.get(size2);
            Intrinsics.checkNotNullExpressionValue(viewHolder, "mPendingRemovals[i]");
            dispatchRemoveFinished(viewHolder);
            this.mPendingRemovals.remove(size2);
        }
        for (int size3 = this.mPendingAdditions.size() - 1; -1 < size3; size3--) {
            RecyclerView.ViewHolder viewHolder2 = this.mPendingAdditions.get(size3);
            Intrinsics.checkNotNullExpressionValue(viewHolder2, "mPendingAdditions[i]");
            RecyclerView.ViewHolder viewHolder3 = viewHolder2;
            this.mAddAnimationRunner.j(viewHolder3);
            dispatchAddFinished(viewHolder3);
            this.mPendingAdditions.remove(size3);
        }
        for (int size4 = this.mPendingChanges.size() - 1; -1 < size4; size4--) {
            as1.b bVar = this.mChangeAnimationRunner;
            a aVar = this.mPendingChanges.get(size4);
            Intrinsics.checkNotNullExpressionValue(aVar, "mPendingChanges[i]");
            bVar.g(aVar);
        }
        this.mPendingChanges.clear();
        if (!isRunning()) {
            return;
        }
        for (int size5 = this.mMovesList.size() - 1; -1 < size5; size5--) {
            ArrayList<MoveInfo> arrayList = this.mMovesList.get(size5);
            Intrinsics.checkNotNullExpressionValue(arrayList, "mMovesList[i]");
            ArrayList<MoveInfo> arrayList2 = arrayList;
            for (int size6 = arrayList2.size() - 1; -1 < size6; size6--) {
                MoveInfo moveInfo3 = arrayList2.get(size6);
                Intrinsics.checkNotNullExpressionValue(moveInfo3, "moves[j]");
                MoveInfo moveInfo4 = moveInfo3;
                View view2 = moveInfo4.getHolder().itemView;
                Intrinsics.checkNotNullExpressionValue(view2, "item.itemView");
                view2.setTranslationY(0.0f);
                view2.setTranslationX(0.0f);
                dispatchMoveFinished(moveInfo4.getHolder());
                arrayList2.remove(size6);
                if (arrayList2.isEmpty()) {
                    this.mMovesList.remove(arrayList2);
                }
            }
        }
        for (int size7 = this.mAdditionsList.size() - 1; -1 < size7; size7--) {
            ArrayList<RecyclerView.ViewHolder> arrayList3 = this.mAdditionsList.get(size7);
            Intrinsics.checkNotNullExpressionValue(arrayList3, "mAdditionsList[i]");
            ArrayList<RecyclerView.ViewHolder> arrayList4 = arrayList3;
            for (int size8 = arrayList4.size() - 1; -1 < size8; size8--) {
                RecyclerView.ViewHolder viewHolder4 = arrayList4.get(size8);
                Intrinsics.checkNotNullExpressionValue(viewHolder4, "additions[j]");
                RecyclerView.ViewHolder viewHolder5 = viewHolder4;
                this.mAddAnimationRunner.j(viewHolder5);
                dispatchAddFinished(viewHolder5);
                arrayList4.remove(size8);
                if (arrayList4.isEmpty()) {
                    this.mAdditionsList.remove(arrayList4);
                }
            }
        }
        for (int size9 = this.mChangesList.size() - 1; -1 < size9; size9--) {
            ArrayList<a> arrayList5 = this.mChangesList.get(size9);
            Intrinsics.checkNotNullExpressionValue(arrayList5, "mChangesList[i]");
            ArrayList<a> arrayList6 = arrayList5;
            for (int size10 = arrayList6.size() - 1; -1 < size10; size10--) {
                as1.b bVar2 = this.mChangeAnimationRunner;
                a aVar2 = arrayList6.get(size10);
                Intrinsics.checkNotNullExpressionValue(aVar2, "changes[j]");
                bVar2.g(aVar2);
                if (arrayList6.isEmpty()) {
                    this.mChangesList.remove(arrayList6);
                }
            }
        }
        cancelAll(this.mMoveAnimations);
        this.mRemoveAnimationRunner.g();
        this.mAddAnimationRunner.g();
        this.mChangeAnimationRunner.e();
        dispatchAnimationsFinished();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    @NotNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public b.C0069b obtainHolderInfo() {
        return new b.C0069b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean isRunning() {
        if ((!this.mPendingAdditions.isEmpty()) || (!this.mPendingChanges.isEmpty()) || (!this.mPendingMoves.isEmpty()) || (!this.mPendingRemovals.isEmpty()) || this.mRemoveAnimationRunner.i() || this.mAddAnimationRunner.i() || this.mChangeAnimationRunner.n() || (!this.mMoveAnimations.isEmpty()) || (!this.mMovesList.isEmpty()) || (!this.mAdditionsList.isEmpty()) || (!this.mChangesList.isEmpty())) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    @NotNull
    public RecyclerView.ItemAnimator.ItemHolderInfo recordPreLayoutInformation(@NotNull RecyclerView.State state, @NotNull RecyclerView.ViewHolder viewHolder, int changeFlags, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        RecyclerView.ItemAnimator.ItemHolderInfo recordPreLayoutInformation = super.recordPreLayoutInformation(state, viewHolder, changeFlags, payloads);
        Intrinsics.checkNotNull(recordPreLayoutInformation, "null cannot be cast to non-null type com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.animation.runners.ChangeAnimationRunner.GuildItemHolderInfo");
        b.C0069b c0069b = (b.C0069b) recordPreLayoutInformation;
        if (changeFlags == 2) {
            for (Object obj : payloads) {
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("Guild.MF.Lt.GuildLeftBarAnimator", 2, "recordPreLayoutInformation position=" + viewHolder.getAdapterPosition() + " info=" + c0069b + " payload=%" + obj);
                }
                if ((obj instanceof Boolean) && !c0069b.getDoAnimation()) {
                    c0069b.b(((Boolean) obj).booleanValue());
                }
            }
        }
        return c0069b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void runPendingAnimations() {
        long j3;
        long j16;
        boolean z16 = !this.mPendingRemovals.isEmpty();
        boolean z17 = !this.mPendingMoves.isEmpty();
        boolean z18 = !this.mPendingChanges.isEmpty();
        boolean z19 = !this.mPendingAdditions.isEmpty();
        if (!z16 && !z17 && !z19 && !z18) {
            return;
        }
        Iterator<RecyclerView.ViewHolder> it = this.mPendingRemovals.iterator();
        while (it.hasNext()) {
            RecyclerView.ViewHolder mPendingRemovals = it.next();
            Intrinsics.checkNotNullExpressionValue(mPendingRemovals, "mPendingRemovals");
            this.mRemoveAnimationRunner.f(mPendingRemovals);
        }
        this.mPendingRemovals.clear();
        if (z17) {
            final ArrayList<MoveInfo> arrayList = new ArrayList<>();
            arrayList.addAll(this.mPendingMoves);
            this.mMovesList.add(arrayList);
            this.mPendingMoves.clear();
            Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.animation.d
                @Override // java.lang.Runnable
                public final void run() {
                    GuildLeftBarAnimator.g(arrayList, this);
                }
            };
            if (z16) {
                View view = arrayList.get(0).getHolder().itemView;
                Intrinsics.checkNotNullExpressionValue(view, "moves[0].holder.itemView");
                ViewCompat.postOnAnimationDelayed(view, runnable, getRemoveDuration());
            } else {
                runnable.run();
            }
        }
        if (z18) {
            final ArrayList<a> arrayList2 = new ArrayList<>();
            arrayList2.addAll(this.mPendingChanges);
            this.mChangesList.add(arrayList2);
            this.mPendingChanges.clear();
            Runnable runnable2 = new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.animation.e
                @Override // java.lang.Runnable
                public final void run() {
                    GuildLeftBarAnimator.h(arrayList2, this);
                }
            };
            if (z16) {
                ViewCompat.postOnAnimationDelayed(arrayList2.get(0).getOldHolder().itemView, runnable2, getRemoveDuration());
            } else {
                runnable2.run();
            }
        }
        if (z19) {
            final ArrayList<RecyclerView.ViewHolder> arrayList3 = new ArrayList<>();
            arrayList3.addAll(this.mPendingAdditions);
            this.mAdditionsList.add(arrayList3);
            this.mPendingAdditions.clear();
            Runnable runnable3 = new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.animation.f
                @Override // java.lang.Runnable
                public final void run() {
                    GuildLeftBarAnimator.i(arrayList3, this);
                }
            };
            if (!z16 && !z17 && !z18) {
                runnable3.run();
                return;
            }
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
            long max = j3 + Math.max(j16, j17);
            View view2 = arrayList3.get(0).itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "additions[0].itemView");
            ViewCompat.postOnAnimationDelayed(view2, runnable3, max);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u00a2\u0006\u0004\b2\u00103B9\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u00a2\u0006\u0004\b2\u00104B)\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010%\u001a\u00020 \u0012\u0006\u0010)\u001a\u00020 \u00a2\u0006\u0004\b2\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0012\u001a\u0004\b\n\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u000f\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\"\u0010\u001c\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\"\u0010\u001f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R$\u0010%\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010!\u001a\u0004\b\u0019\u0010\"\"\u0004\b#\u0010$R$\u0010)\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010!\u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R\"\u0010/\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b*\u0010,\"\u0004\b-\u0010.R\"\u00101\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010+\u001a\u0004\b&\u0010,\"\u0004\b0\u0010.\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/animation/GuildLeftBarAnimator$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "d", "()Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "oldHolder", "b", "c", "newHolder", "I", "()I", "setFromX", "(I)V", "fromX", "setFromY", "fromY", "e", "f", "setToX", "toX", "g", "setToY", "toY", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator$ItemHolderInfo;", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator$ItemHolderInfo;", "()Landroidx/recyclerview/widget/RecyclerView$ItemAnimator$ItemHolderInfo;", "setPreInfo", "(Landroidx/recyclerview/widget/RecyclerView$ItemAnimator$ItemHolderInfo;)V", "preInfo", h.F, "getPostInfo", "setPostInfo", "postInfo", "i", "Z", "()Z", "k", "(Z)V", "isOldHolderClear", "j", "isNewHolderClear", "<init>", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;IIII)V", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ItemAnimator$ItemHolderInfo;Landroidx/recyclerview/widget/RecyclerView$ItemAnimator$ItemHolderInfo;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final /* data */ class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final RecyclerView.ViewHolder oldHolder;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final RecyclerView.ViewHolder newHolder;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int fromX;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int fromY;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int toX;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int toY;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private RecyclerView.ItemAnimator.ItemHolderInfo preInfo;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private RecyclerView.ItemAnimator.ItemHolderInfo postInfo;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private boolean isOldHolderClear;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private boolean isNewHolderClear;

        public a(@NotNull RecyclerView.ViewHolder oldHolder, @NotNull RecyclerView.ViewHolder newHolder) {
            Intrinsics.checkNotNullParameter(oldHolder, "oldHolder");
            Intrinsics.checkNotNullParameter(newHolder, "newHolder");
            this.oldHolder = oldHolder;
            this.newHolder = newHolder;
        }

        /* renamed from: a, reason: from getter */
        public final int getFromX() {
            return this.fromX;
        }

        /* renamed from: b, reason: from getter */
        public final int getFromY() {
            return this.fromY;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final RecyclerView.ViewHolder getNewHolder() {
            return this.newHolder;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final RecyclerView.ViewHolder getOldHolder() {
            return this.oldHolder;
        }

        @Nullable
        /* renamed from: e, reason: from getter */
        public final RecyclerView.ItemAnimator.ItemHolderInfo getPreInfo() {
            return this.preInfo;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            if (Intrinsics.areEqual(this.oldHolder, aVar.oldHolder) && Intrinsics.areEqual(this.newHolder, aVar.newHolder)) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final int getToX() {
            return this.toX;
        }

        /* renamed from: g, reason: from getter */
        public final int getToY() {
            return this.toY;
        }

        /* renamed from: h, reason: from getter */
        public final boolean getIsNewHolderClear() {
            return this.isNewHolderClear;
        }

        public int hashCode() {
            return (this.oldHolder.hashCode() * 31) + this.newHolder.hashCode();
        }

        /* renamed from: i, reason: from getter */
        public final boolean getIsOldHolderClear() {
            return this.isOldHolderClear;
        }

        public final void j(boolean z16) {
            this.isNewHolderClear = z16;
        }

        public final void k(boolean z16) {
            this.isOldHolderClear = z16;
        }

        @NotNull
        public String toString() {
            boolean z16;
            RecyclerView.ViewHolder viewHolder = this.oldHolder;
            RecyclerView.ViewHolder viewHolder2 = this.newHolder;
            int i3 = this.fromX;
            int i16 = this.fromY;
            int i17 = this.toX;
            int i18 = this.toY;
            boolean z17 = true;
            if (this.preInfo != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (this.postInfo == null) {
                z17 = false;
            }
            return "ChangeInfo{oldHolder=" + viewHolder + ", newHolder=" + viewHolder2 + ", fromX=" + i3 + ", fromY=" + i16 + ", toX=" + i17 + ", toY=" + i18 + ", [" + z16 + " , " + z17 + "]}";
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(@NotNull RecyclerView.ViewHolder oldHolder, @NotNull RecyclerView.ViewHolder newHolder, int i3, int i16, int i17, int i18) {
            this(oldHolder, newHolder);
            Intrinsics.checkNotNullParameter(oldHolder, "oldHolder");
            Intrinsics.checkNotNullParameter(newHolder, "newHolder");
            this.fromX = i3;
            this.fromY = i16;
            this.toX = i17;
            this.toY = i18;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(@NotNull RecyclerView.ViewHolder oldHolder, @NotNull RecyclerView.ViewHolder newHolder, @NotNull RecyclerView.ItemAnimator.ItemHolderInfo preInfo, @NotNull RecyclerView.ItemAnimator.ItemHolderInfo postInfo) {
            this(oldHolder, newHolder);
            Intrinsics.checkNotNullParameter(oldHolder, "oldHolder");
            Intrinsics.checkNotNullParameter(newHolder, "newHolder");
            Intrinsics.checkNotNullParameter(preInfo, "preInfo");
            Intrinsics.checkNotNullParameter(postInfo, "postInfo");
            this.preInfo = preInfo;
            this.postInfo = postInfo;
        }
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean animateChange(@NotNull RecyclerView.ViewHolder oldHolder, @NotNull RecyclerView.ViewHolder newHolder, @NotNull RecyclerView.ItemAnimator.ItemHolderInfo preInfo, @NotNull RecyclerView.ItemAnimator.ItemHolderInfo postInfo) {
        Intrinsics.checkNotNullParameter(oldHolder, "oldHolder");
        Intrinsics.checkNotNullParameter(newHolder, "newHolder");
        Intrinsics.checkNotNullParameter(preInfo, "preInfo");
        Intrinsics.checkNotNullParameter(postInfo, "postInfo");
        List<a> c16 = this.mChangeAnimationRunner.c(oldHolder, newHolder, preInfo, postInfo);
        if (c16.isEmpty()) {
            return super.animateChange(oldHolder, newHolder, preInfo, postInfo);
        }
        this.mPendingChanges.addAll(c16);
        return true;
    }
}
