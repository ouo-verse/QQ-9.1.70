package com.tencent.mobileqq.guild.setting.group;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.setting.group.adapterDelegate.BindTitleAdapterDelegate;
import com.tencent.mobileqq.guild.setting.group.adapterDelegate.GroupChatAdapterDelegate;
import com.tencent.mobileqq.guild.setting.group.adapterDelegate.UnbindGroupAdapterDelegate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b!\u0018\u0000 \u000f2\u00020\u0001:\u0004=BEHB\u0007\u00a2\u0006\u0004\bf\u0010gJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J \u0010\u0013\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J\u001e\u0010\u0017\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u00142\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001a\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006J0\u0010$\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u001fH\u0016J.\u0010%\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u001fJ(\u0010*\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020'H\u0016J:\u0010*\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u001fH\u0016J\u000e\u0010+\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010,\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010-\u001a\u00020\u0002H\u0016J\u0006\u0010.\u001a\u00020\bJ\b\u0010/\u001a\u00020\bH\u0016J\u0016\u00102\u001a\u00020\b2\u000e\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000400J \u00106\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u00042\u000e\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010400H\u0016J\b\u00107\u001a\u00020'H\u0016J.\u0010;\u001a\u00020'2\u0006\u00109\u001a\u0002082\u0006\u00103\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u001f2\f\u00105\u001a\b\u0012\u0004\u0012\u0002040\u0014H\u0016R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R$\u0010D\u001a\u0012\u0012\u0004\u0012\u00020\u00040@j\b\u0012\u0004\u0012\u00020\u0004`A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR$\u0010F\u001a\u0012\u0012\u0004\u0012\u00020\u00040@j\b\u0012\u0004\u0012\u00020\u0004`A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010CR$\u0010I\u001a\u0012\u0012\u0004\u0012\u00020G0@j\b\u0012\u0004\u0012\u00020G`A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010CR$\u0010K\u001a\u0012\u0012\u0004\u0012\u00020\n0@j\b\u0012\u0004\u0012\u00020\n`A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010CRR\u0010Q\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040@j\b\u0012\u0004\u0012\u00020\u0004`A0@j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040@j\b\u0012\u0004\u0012\u00020\u0004`A`A8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010C\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PRR\u0010T\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020G0@j\b\u0012\u0004\u0012\u00020G`A0@j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020G0@j\b\u0012\u0004\u0012\u00020G`A`A8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010C\u001a\u0004\bR\u0010N\"\u0004\bS\u0010PRR\u0010X\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n0@j\b\u0012\u0004\u0012\u00020\n`A0@j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n0@j\b\u0012\u0004\u0012\u00020\n`A`A8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010C\u001a\u0004\bV\u0010N\"\u0004\bW\u0010PR6\u0010[\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00040@j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004`A8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010C\u001a\u0004\bY\u0010N\"\u0004\bZ\u0010PR6\u0010^\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00040@j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004`A8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010C\u001a\u0004\b\\\u0010N\"\u0004\b]\u0010PR6\u0010b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00040@j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004`A8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b_\u0010C\u001a\u0004\b`\u0010N\"\u0004\ba\u0010PR6\u0010e\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00040@j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004`A8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010C\u001a\u0004\bc\u0010N\"\u0004\bd\u0010P\u00a8\u0006h"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/o;", "Landroidx/recyclerview/widget/SimpleItemAnimator;", "", "u", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "", "offsetY", "", "j", "Lcom/tencent/mobileqq/guild/setting/group/o$b;", "changeInfo", "t", "Lcom/tencent/mobileqq/guild/setting/group/adapterDelegate/UnbindGroupAdapterDelegate$a;", "newHolder", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "oldView", "newView", "l", "", "infoList", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "endChangeAnimation", DomainData.DOMAIN_NAME, "o", "resetAnimation", "runPendingAnimations", "animateRemove", "animateAdd", "g", "", "fromX", "fromY", "toX", "toY", "animateMove", "animateMoveImpl", "oldHolder", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator$ItemHolderInfo;", "preInfo", "postInfo", "animateChange", "i", "endAnimation", "isRunning", "dispatchFinishedWhenDone", "endAnimations", "", "viewHolders", "cancelAll", "viewHolder", "", "payloads", "canReuseUpdatedViewHolder", "obtainHolderInfo", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "changeFlags", "recordPreLayoutInformation", "Landroid/view/animation/DecelerateInterpolator;", "a", "Landroid/view/animation/DecelerateInterpolator;", "sDefaultInterpolator", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "mPendingRemovals", "c", "mPendingAdditions", "Lcom/tencent/mobileqq/guild/setting/group/o$d;", "d", "mPendingMoves", "e", "mPendingChanges", "f", "getMAdditionsList", "()Ljava/util/ArrayList;", "setMAdditionsList", "(Ljava/util/ArrayList;)V", "mAdditionsList", "getMMovesList", "setMMovesList", "mMovesList", tl.h.F, "getMChangesList", "setMChangesList", "mChangesList", "p", "setMAddAnimations", "mAddAnimations", "r", "setMMoveAnimations", "mMoveAnimations", "k", ReportConstant.COSTREPORT_PREFIX, "setMRemoveAnimations", "mRemoveAnimations", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "setMChangeAnimations", "mChangeAnimations", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class o extends SimpleItemAnimator {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final DecelerateInterpolator sDefaultInterpolator = new DecelerateInterpolator();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<RecyclerView.ViewHolder> mPendingRemovals = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<RecyclerView.ViewHolder> mPendingAdditions = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<d> mPendingMoves = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<b> mPendingChanges = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<ArrayList<RecyclerView.ViewHolder>> mAdditionsList = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<ArrayList<d>> mMovesList = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<ArrayList<b>> mChangesList = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<RecyclerView.ViewHolder> mAddAnimations = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<RecyclerView.ViewHolder> mMoveAnimations = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<RecyclerView.ViewHolder> mRemoveAnimations = new ArrayList<>();

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<RecyclerView.ViewHolder> mChangeAnimations = new ArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0015\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\r\u0010\u0010\"\u0004\b\u0014\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/o$a;", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator$ItemHolderInfo;", "", "a", "I", "()I", "f", "(I)V", "contentViewState", "b", tl.h.F, "sortViewState", "", "c", "Z", "d", "()Z", "g", "(Z)V", "isExpand", "e", "isCollapse", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends RecyclerView.ItemAnimator.ItemHolderInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int contentViewState;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int sortViewState;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private boolean isExpand;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean isCollapse;

        /* renamed from: a, reason: from getter */
        public final int getContentViewState() {
            return this.contentViewState;
        }

        /* renamed from: b, reason: from getter */
        public final int getSortViewState() {
            return this.sortViewState;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsCollapse() {
            return this.isCollapse;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsExpand() {
            return this.isExpand;
        }

        public final void e(boolean z16) {
            this.isCollapse = z16;
        }

        public final void f(int i3) {
            this.contentViewState = i3;
        }

        public final void g(boolean z16) {
            this.isExpand = z16;
        }

        public final void h(int i3) {
            this.sortViewState = i3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B1\b\u0000\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\n\u0012\u0006\u0010\u0018\u001a\u00020\n\u00a2\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0003\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u0011\u0010\u000fR\"\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR\"\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000f\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/o$d;", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "c", "()Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "setHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "holder", "", "b", "I", "()I", "setFromX", "(I)V", "fromX", "setFromY", "fromY", "d", "setToX", "toX", "e", "setToY", "toY", "<init>", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;IIII)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d {

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

        public d(@NotNull RecyclerView.ViewHolder holder, int i3, int i16, int i17, int i18) {
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
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/setting/group/o$e", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animator", "", "onAnimationStart", "onAnimationCancel", "onAnimationEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e extends AnimatorListenerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f233515e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f233516f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f233517h;

        e(RecyclerView.ViewHolder viewHolder, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f233515e = viewHolder;
            this.f233516f = view;
            this.f233517h = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            this.f233516f.setAlpha(1.0f);
            this.f233516f.setTranslationY(0.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            this.f233517h.setListener(null);
            o.this.dispatchAddFinished(this.f233515e);
            o.this.p().remove(this.f233515e);
            o.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            o.this.dispatchAddStarting(this.f233515e);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/setting/group/o$f", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animator", "", "onAnimationStart", "onAnimationEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f extends AnimatorListenerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f233519e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f233520f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ View f233521h;

        f(b bVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f233519e = bVar;
            this.f233520f = viewPropertyAnimator;
            this.f233521h = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            this.f233520f.setListener(null);
            this.f233521h.setAlpha(1.0f);
            this.f233521h.setTranslationX(0.0f);
            this.f233521h.setTranslationY(0.0f);
            o.this.dispatchChangeFinished(this.f233519e.getOldHolder(), true);
            o.this.q().remove(this.f233519e.getOldHolder());
            o.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            o.this.dispatchChangeStarting(this.f233519e.getOldHolder(), true);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/setting/group/o$g", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animator", "", "onAnimationStart", "onAnimationEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class g extends AnimatorListenerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f233523e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f233524f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ View f233525h;

        g(b bVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f233523e = bVar;
            this.f233524f = viewPropertyAnimator;
            this.f233525h = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            this.f233524f.setListener(null);
            this.f233525h.setAlpha(1.0f);
            this.f233525h.setTranslationX(0.0f);
            this.f233525h.setTranslationY(0.0f);
            o.this.dispatchChangeFinished(this.f233523e.getNewHolder(), false);
            o.this.q().remove(this.f233523e.getNewHolder());
            o.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            o.this.dispatchChangeStarting(this.f233523e.getNewHolder(), false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/setting/group/o$h", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animator", "", "onAnimationStart", "onAnimationCancel", "onAnimationEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class h extends AnimatorListenerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f233527e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f233528f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ View f233529h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f233530i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f233531m;

        h(RecyclerView.ViewHolder viewHolder, int i3, View view, int i16, ViewPropertyAnimator viewPropertyAnimator) {
            this.f233527e = viewHolder;
            this.f233528f = i3;
            this.f233529h = view;
            this.f233530i = i16;
            this.f233531m = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            if (this.f233528f != 0) {
                this.f233529h.setTranslationX(0.0f);
            }
            if (this.f233530i != 0) {
                this.f233529h.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            this.f233531m.setListener(null);
            o.this.dispatchMoveFinished(this.f233527e);
            o.this.r().remove(this.f233527e);
            o.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            o.this.dispatchMoveStarting(this.f233527e);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/setting/group/o$i", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animator", "", "onAnimationStart", "onAnimationEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class i extends AnimatorListenerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f233533e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f233534f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ View f233535h;

        i(RecyclerView.ViewHolder viewHolder, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f233533e = viewHolder;
            this.f233534f = viewPropertyAnimator;
            this.f233535h = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            this.f233534f.setListener(null);
            this.f233535h.setAlpha(1.0f);
            this.f233535h.setTranslationY(0.0f);
            o.this.dispatchRemoveFinished(this.f233533e);
            o.this.s().remove(this.f233533e);
            o.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            o.this.dispatchRemoveStarting(this.f233533e);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/setting/group/o$j", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animator", "", "onAnimationStart", "onAnimationEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class j extends AnimatorListenerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f233537e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f233538f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ View f233539h;

        j(b bVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f233537e = bVar;
            this.f233538f = viewPropertyAnimator;
            this.f233539h = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            this.f233538f.setListener(null);
            this.f233539h.setAlpha(1.0f);
            this.f233539h.setVisibility(8);
            o.this.dispatchChangeFinished(this.f233537e.getOldHolder(), true);
            o.this.q().remove(this.f233537e.getOldHolder());
            o.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            o.this.dispatchChangeStarting(this.f233537e.getOldHolder(), true);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/setting/group/o$k", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animator", "", "onAnimationStart", "onAnimationEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class k extends AnimatorListenerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f233541e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f233542f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ View f233543h;

        k(b bVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f233541e = bVar;
            this.f233542f = viewPropertyAnimator;
            this.f233543h = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            a aVar = null;
            this.f233542f.setListener(null);
            RecyclerView.ItemAnimator.ItemHolderInfo preInfo = this.f233541e.getPreInfo();
            if (preInfo instanceof a) {
                aVar = (a) preInfo;
            }
            if (aVar != null) {
                aVar.f(0);
                aVar.h(0);
            }
            this.f233543h.setAlpha(1.0f);
            o.this.dispatchChangeFinished(this.f233541e.getNewHolder(), false);
            o.this.q().remove(this.f233541e.getNewHolder());
            o.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            o.this.dispatchChangeStarting(this.f233541e.getNewHolder(), false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/setting/group/o$l", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animator", "", "onAnimationEnd", "onAnimationStart", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class l extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ UnbindGroupAdapterDelegate.a f233544d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ o f233545e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f233546f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f233547h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ UnbindGroupAdapterDelegate.a f233548i;

        l(UnbindGroupAdapterDelegate.a aVar, o oVar, ViewPropertyAnimator viewPropertyAnimator, int i3, UnbindGroupAdapterDelegate.a aVar2) {
            this.f233544d = aVar;
            this.f233545e = oVar;
            this.f233546f = viewPropertyAnimator;
            this.f233547h = i3;
            this.f233548i = aVar2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            this.f233544d.itemView.setAlpha(1.0f);
            this.f233545e.dispatchChangeStarting(this.f233544d, true);
            this.f233544d.getCollapseIcon().setTag(null);
            this.f233546f.setListener(null);
            ViewCompat.setRotation(this.f233544d.getCollapseIcon(), this.f233547h);
            this.f233545e.q().remove(this.f233548i);
            UnbindGroupAdapterDelegate.a aVar = this.f233544d;
            UnbindGroupAdapterDelegate.a aVar2 = this.f233548i;
            if (aVar != aVar2) {
                this.f233545e.dispatchChangeStarting(aVar2, false);
            }
            this.f233545e.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            this.f233548i.getCollapseIcon().setTag(Boolean.TRUE);
            this.f233545e.dispatchChangeStarting(this.f233548i, false);
        }
    }

    public o() {
        setMoveDuration(300L);
        setChangeDuration(300L);
        setAddDuration(300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(ArrayList additions, o this$0) {
        Intrinsics.checkNotNullParameter(additions, "$additions");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator it = additions.iterator();
        while (it.hasNext()) {
            Object additions2 = it.next();
            Intrinsics.checkNotNullExpressionValue(additions2, "additions");
            h(this$0, (RecyclerView.ViewHolder) additions2, 0.0f, 2, null);
        }
        additions.clear();
        this$0.mAdditionsList.remove(additions);
    }

    private final void endChangeAnimation(List<b> infoList, RecyclerView.ViewHolder item) {
        int size = infoList.size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i3 = size - 1;
            b bVar = infoList.get(size);
            if (o(bVar, item) && bVar.getOldHolder() == null && bVar.getNewHolder() == null) {
                infoList.remove(bVar);
            }
            if (i3 >= 0) {
                size = i3;
            } else {
                return;
            }
        }
    }

    public static /* synthetic */ void h(o oVar, RecyclerView.ViewHolder viewHolder, float f16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f16 = 0.0f;
        }
        oVar.g(viewHolder, f16);
    }

    private final void j(RecyclerView.ViewHolder holder, float offsetY) {
        boolean z16;
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        ViewPropertyAnimator animate = view.animate();
        this.mRemoveAnimations.add(holder);
        if (offsetY == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            animate.translationY(-offsetY);
        }
        animate.alpha(0.0f).setDuration(getRemoveDuration()).setListener(new i(holder, animate, view)).start();
    }

    static /* synthetic */ void k(o oVar, RecyclerView.ViewHolder viewHolder, float f16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f16 = 0.0f;
        }
        oVar.j(viewHolder, f16);
    }

    private final void l(b changeInfo, View oldView, View newView) {
        ViewPropertyAnimator duration = oldView.animate().setDuration(getChangeDuration());
        this.mChangeAnimations.add(changeInfo.getOldHolder());
        duration.alpha(0.0f).setListener(new j(changeInfo, duration, oldView)).start();
        ViewPropertyAnimator duration2 = newView.animate().setDuration(getChangeDuration());
        this.mChangeAnimations.add(changeInfo.getNewHolder());
        newView.setAlpha(0.0f);
        newView.setVisibility(0);
        duration2.alpha(1.0f).setListener(new k(changeInfo, duration2, newView)).start();
    }

    private final void m(UnbindGroupAdapterDelegate.a holder, UnbindGroupAdapterDelegate.a newHolder) {
        BindGroupGroupData bindGroupGroupData;
        boolean z16;
        int i3;
        int i16;
        ViewPropertyAnimator animate = newHolder.getCollapseIcon().animate();
        Object tag = newHolder.itemView.getTag();
        if (tag instanceof BindGroupGroupData) {
            bindGroupGroupData = (BindGroupGroupData) tag;
        } else {
            bindGroupGroupData = null;
        }
        if (bindGroupGroupData != null) {
            z16 = bindGroupGroupData.getIsCollapse();
        } else {
            z16 = false;
        }
        if (z16) {
            i3 = 90;
        } else {
            i3 = 0;
        }
        if (z16) {
            i16 = 0;
        } else {
            i16 = 90;
        }
        this.mChangeAnimations.add(newHolder);
        holder.getCollapseIcon().setRotation(i3);
        animate.setDuration(getChangeDuration()).rotation(i16).setListener(new l(holder, this, animate, i16, newHolder)).start();
    }

    private final void n(b changeInfo) {
        if (changeInfo.getNewHolder() != null) {
            RecyclerView.ViewHolder newHolder = changeInfo.getNewHolder();
            Intrinsics.checkNotNull(newHolder);
            Object tag = newHolder.itemView.getTag(R.id.wvs);
            if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                return;
            }
        }
        if (changeInfo.getOldHolder() != null) {
            o(changeInfo, changeInfo.getOldHolder());
        }
        if (changeInfo.getNewHolder() != null) {
            o(changeInfo, changeInfo.getNewHolder());
        }
    }

    private final boolean o(b changeInfo, RecyclerView.ViewHolder item) {
        boolean z16 = false;
        if (changeInfo.getNewHolder() == item) {
            changeInfo.j(null);
        } else {
            if (changeInfo.getOldHolder() != item) {
                return false;
            }
            changeInfo.k(null);
            z16 = true;
        }
        Intrinsics.checkNotNull(item);
        item.itemView.setAlpha(1.0f);
        item.itemView.setTranslationX(0.0f);
        item.itemView.setTranslationY(0.0f);
        dispatchChangeFinished(item, z16);
        return true;
    }

    private final void resetAnimation(RecyclerView.ViewHolder holder) {
        holder.itemView.animate().setInterpolator(this.sDefaultInterpolator);
        endAnimation(holder);
    }

    private final boolean t(b changeInfo) {
        RecyclerView.ItemAnimator.ItemHolderInfo preInfo = changeInfo.getPreInfo();
        if (!(preInfo instanceof a)) {
            return false;
        }
        a aVar = (a) preInfo;
        if (aVar.getSortViewState() == 0 && aVar.getContentViewState() == 0 && !aVar.getIsCollapse() && !aVar.getIsExpand()) {
            return false;
        }
        RecyclerView.ViewHolder oldHolder = changeInfo.getOldHolder();
        RecyclerView.ViewHolder newHolder = changeInfo.getNewHolder();
        if ((oldHolder instanceof GroupChatAdapterDelegate.a) && (newHolder instanceof GroupChatAdapterDelegate.a)) {
            if (aVar.getContentViewState() == 1) {
                l(changeInfo, ((GroupChatAdapterDelegate.a) oldHolder).getGroupButton(), ((GroupChatAdapterDelegate.a) newHolder).getSortView());
            } else {
                l(changeInfo, ((GroupChatAdapterDelegate.a) oldHolder).getSortView(), ((GroupChatAdapterDelegate.a) newHolder).getGroupButton());
            }
        }
        if ((oldHolder instanceof BindTitleAdapterDelegate.a) && (newHolder instanceof BindTitleAdapterDelegate.a)) {
            if (aVar.getSortViewState() == 1) {
                l(changeInfo, ((BindTitleAdapterDelegate.a) oldHolder).getSortTextView(), ((BindTitleAdapterDelegate.a) newHolder).getFinishView());
            } else {
                l(changeInfo, ((BindTitleAdapterDelegate.a) oldHolder).getFinishView(), ((BindTitleAdapterDelegate.a) newHolder).getSortTextView());
            }
        }
        if ((oldHolder instanceof UnbindGroupAdapterDelegate.a) && (newHolder instanceof UnbindGroupAdapterDelegate.a)) {
            m((UnbindGroupAdapterDelegate.a) oldHolder, (UnbindGroupAdapterDelegate.a) newHolder);
        }
        return true;
    }

    private final boolean u() {
        if (this.mPendingChanges.size() != 1 || this.mPendingChanges.get(0).getOldHolder() == null) {
            return false;
        }
        RecyclerView.ItemAnimator.ItemHolderInfo preInfo = this.mPendingChanges.get(0).getPreInfo();
        if (!(preInfo instanceof a)) {
            return false;
        }
        a aVar = (a) preInfo;
        if (!aVar.getIsExpand() && !aVar.getIsCollapse()) {
            return false;
        }
        int toY = this.mPendingChanges.get(0).getToY();
        Intrinsics.checkNotNull(this.mPendingChanges.get(0).getOldHolder());
        final float height = (toY + r1.itemView.getHeight()) - ViewUtils.dpToPx(15.0f);
        Iterator<RecyclerView.ViewHolder> it = this.mPendingRemovals.iterator();
        while (it.hasNext()) {
            RecyclerView.ViewHolder mPendingRemovals = it.next();
            Intrinsics.checkNotNullExpressionValue(mPendingRemovals, "mPendingRemovals");
            RecyclerView.ViewHolder viewHolder = mPendingRemovals;
            j(viewHolder, viewHolder.itemView.getY() - height);
        }
        this.mPendingRemovals.clear();
        if (!this.mPendingMoves.isEmpty()) {
            final ArrayList<d> arrayList = new ArrayList<>();
            arrayList.addAll(this.mPendingMoves);
            this.mMovesList.add(arrayList);
            this.mPendingMoves.clear();
            new Runnable() { // from class: com.tencent.mobileqq.guild.setting.group.l
                @Override // java.lang.Runnable
                public final void run() {
                    o.v(arrayList, this);
                }
            }.run();
        }
        if (!this.mPendingChanges.isEmpty()) {
            final ArrayList<b> arrayList2 = new ArrayList<>();
            arrayList2.addAll(this.mPendingChanges);
            this.mChangesList.add(arrayList2);
            this.mPendingChanges.clear();
            new Runnable() { // from class: com.tencent.mobileqq.guild.setting.group.m
                @Override // java.lang.Runnable
                public final void run() {
                    o.w(arrayList2, this);
                }
            }.run();
        }
        if (!this.mPendingAdditions.isEmpty()) {
            final ArrayList<RecyclerView.ViewHolder> arrayList3 = new ArrayList<>();
            arrayList3.addAll(this.mPendingAdditions);
            this.mAdditionsList.add(arrayList3);
            this.mPendingAdditions.clear();
            new Runnable() { // from class: com.tencent.mobileqq.guild.setting.group.n
                @Override // java.lang.Runnable
                public final void run() {
                    o.x(arrayList3, height, this);
                }
            }.run();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(ArrayList moves, o this$0) {
        Intrinsics.checkNotNullParameter(moves, "$moves");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator it = moves.iterator();
        while (it.hasNext()) {
            Object moves2 = it.next();
            Intrinsics.checkNotNullExpressionValue(moves2, "moves");
            d dVar = (d) moves2;
            this$0.animateMoveImpl(dVar.getHolder(), dVar.getFromX(), dVar.getFromY(), dVar.getToX(), dVar.getToY());
        }
        moves.clear();
        this$0.mMovesList.remove(moves);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(ArrayList changes, o this$0) {
        Intrinsics.checkNotNullParameter(changes, "$changes");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator it = changes.iterator();
        while (it.hasNext()) {
            Object changes2 = it.next();
            Intrinsics.checkNotNullExpressionValue(changes2, "changes");
            this$0.i((b) changes2);
        }
        changes.clear();
        this$0.mChangesList.remove(changes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(ArrayList additions, float f16, o this$0) {
        Intrinsics.checkNotNullParameter(additions, "$additions");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator it = additions.iterator();
        while (it.hasNext()) {
            Object additions2 = it.next();
            Intrinsics.checkNotNullExpressionValue(additions2, "additions");
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) additions2;
            this$0.g(viewHolder, viewHolder.itemView.getY() - f16);
        }
        additions.clear();
        this$0.mAdditionsList.remove(additions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(ArrayList moves, o this$0) {
        Intrinsics.checkNotNullParameter(moves, "$moves");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator it = moves.iterator();
        while (it.hasNext()) {
            Object moves2 = it.next();
            Intrinsics.checkNotNullExpressionValue(moves2, "moves");
            d dVar = (d) moves2;
            this$0.animateMoveImpl(dVar.getHolder(), dVar.getFromX(), dVar.getFromY(), dVar.getToX(), dVar.getToY());
        }
        moves.clear();
        this$0.mMovesList.remove(moves);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(ArrayList changes, o this$0) {
        Intrinsics.checkNotNullParameter(changes, "$changes");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator it = changes.iterator();
        while (it.hasNext()) {
            Object changes2 = it.next();
            Intrinsics.checkNotNullExpressionValue(changes2, "changes");
            this$0.i((b) changes2);
        }
        changes.clear();
        this$0.mChangesList.remove(changes);
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateAdd(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        resetAnimation(holder);
        holder.itemView.setAlpha(0.0f);
        this.mPendingAdditions.add(holder);
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean animateChange(@NotNull RecyclerView.ViewHolder oldHolder, @NotNull RecyclerView.ViewHolder newHolder, @NotNull RecyclerView.ItemAnimator.ItemHolderInfo preInfo, @NotNull RecyclerView.ItemAnimator.ItemHolderInfo postInfo) {
        Intrinsics.checkNotNullParameter(oldHolder, "oldHolder");
        Intrinsics.checkNotNullParameter(newHolder, "newHolder");
        Intrinsics.checkNotNullParameter(preInfo, "preInfo");
        Intrinsics.checkNotNullParameter(postInfo, "postInfo");
        if (!(preInfo instanceof a)) {
            return super.animateChange(oldHolder, newHolder, preInfo, postInfo);
        }
        a aVar = (a) preInfo;
        if (aVar.getSortViewState() == 0 && aVar.getContentViewState() == 0) {
            if (!aVar.getIsCollapse() && !aVar.getIsExpand()) {
                return super.animateChange(oldHolder, newHolder, preInfo, postInfo);
            }
            this.mPendingChanges.add(new b(oldHolder, newHolder, preInfo, postInfo));
            newHolder.itemView.setTag(R.id.wvs, Boolean.TRUE);
            super.animateChange(oldHolder, newHolder, preInfo, postInfo);
            newHolder.itemView.setTag(R.id.wvs, null);
            return true;
        }
        this.mPendingChanges.add(new b(oldHolder, newHolder, preInfo, postInfo));
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
        this.mPendingMoves.add(new d(holder, translationX, translationY, toX, toY));
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
        animate.setDuration(getMoveDuration()).setListener(new h(holder, i3, view, i16, animate)).start();
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateRemove(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        resetAnimation(holder);
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
            RecyclerView.ViewHolder viewHolder = viewHolders.get(size);
            Intrinsics.checkNotNull(viewHolder);
            viewHolder.itemView.animate().cancel();
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
                d dVar = this.mPendingMoves.get(size);
                Intrinsics.checkNotNullExpressionValue(dVar, "mPendingMoves[i]");
                if (dVar.getHolder() == item) {
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
        endChangeAnimation(this.mPendingChanges, item);
        if (this.mPendingRemovals.remove(item)) {
            view.setAlpha(1.0f);
            dispatchRemoveFinished(item);
        }
        if (this.mPendingAdditions.remove(item)) {
            view.setAlpha(1.0f);
            dispatchAddFinished(item);
        }
        int size2 = this.mChangesList.size() - 1;
        if (size2 >= 0) {
            while (true) {
                int i16 = size2 - 1;
                ArrayList<b> arrayList = this.mChangesList.get(size2);
                Intrinsics.checkNotNullExpressionValue(arrayList, "mChangesList[i]");
                ArrayList<b> arrayList2 = arrayList;
                endChangeAnimation(arrayList2, item);
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
                ArrayList<d> arrayList3 = this.mMovesList.get(size3);
                Intrinsics.checkNotNullExpressionValue(arrayList3, "mMovesList[i]");
                ArrayList<d> arrayList4 = arrayList3;
                int size4 = arrayList4.size() - 1;
                if (size4 >= 0) {
                    while (true) {
                        int i18 = size4 - 1;
                        d dVar2 = arrayList4.get(size4);
                        Intrinsics.checkNotNullExpressionValue(dVar2, "moves[j]");
                        if (dVar2.getHolder() == item) {
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
                    view.setAlpha(1.0f);
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
        this.mRemoveAnimations.remove(item);
        this.mAddAnimations.remove(item);
        this.mChangeAnimations.remove(item);
        this.mMoveAnimations.remove(item);
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
            d dVar = this.mPendingMoves.get(size);
            Intrinsics.checkNotNullExpressionValue(dVar, "mPendingMoves[i]");
            d dVar2 = dVar;
            View view = dVar2.getHolder().itemView;
            Intrinsics.checkNotNullExpressionValue(view, "item.holder.itemView");
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            dispatchMoveFinished(dVar2.getHolder());
            this.mPendingMoves.remove(size);
        }
        for (int size2 = this.mPendingRemovals.size() - 1; -1 < size2; size2--) {
            RecyclerView.ViewHolder viewHolder = this.mPendingRemovals.get(size2);
            Intrinsics.checkNotNullExpressionValue(viewHolder, "mPendingRemovals[i]");
            dispatchRemoveFinished(viewHolder);
            this.mPendingRemovals.remove(size2);
        }
        int size3 = this.mPendingAdditions.size();
        while (true) {
            size3--;
            if (-1 >= size3) {
                break;
            }
            RecyclerView.ViewHolder viewHolder2 = this.mPendingAdditions.get(size3);
            Intrinsics.checkNotNullExpressionValue(viewHolder2, "mPendingAdditions[i]");
            RecyclerView.ViewHolder viewHolder3 = viewHolder2;
            viewHolder3.itemView.setAlpha(1.0f);
            dispatchAddFinished(viewHolder3);
            this.mPendingAdditions.remove(size3);
        }
        for (int size4 = this.mPendingChanges.size() - 1; -1 < size4; size4--) {
            b bVar = this.mPendingChanges.get(size4);
            Intrinsics.checkNotNullExpressionValue(bVar, "mPendingChanges[i]");
            n(bVar);
        }
        this.mPendingChanges.clear();
        if (!isRunning()) {
            return;
        }
        int size5 = this.mMovesList.size();
        while (true) {
            size5--;
            if (-1 >= size5) {
                break;
            }
            ArrayList<d> arrayList = this.mMovesList.get(size5);
            Intrinsics.checkNotNullExpressionValue(arrayList, "mMovesList[i]");
            ArrayList<d> arrayList2 = arrayList;
            for (int size6 = arrayList2.size() - 1; -1 < size6; size6--) {
                d dVar3 = arrayList2.get(size6);
                Intrinsics.checkNotNullExpressionValue(dVar3, "moves[j]");
                d dVar4 = dVar3;
                View view2 = dVar4.getHolder().itemView;
                Intrinsics.checkNotNullExpressionValue(view2, "item.itemView");
                view2.setTranslationY(0.0f);
                view2.setTranslationX(0.0f);
                dispatchMoveFinished(dVar4.getHolder());
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
                View view3 = viewHolder5.itemView;
                Intrinsics.checkNotNullExpressionValue(view3, "item.itemView");
                view3.setAlpha(1.0f);
                dispatchAddFinished(viewHolder5);
                arrayList4.remove(size8);
                if (arrayList4.isEmpty()) {
                    this.mAdditionsList.remove(arrayList4);
                }
            }
        }
        for (int size9 = this.mChangesList.size() - 1; -1 < size9; size9--) {
            ArrayList<b> arrayList5 = this.mChangesList.get(size9);
            Intrinsics.checkNotNullExpressionValue(arrayList5, "mChangesList[i]");
            ArrayList<b> arrayList6 = arrayList5;
            for (int size10 = arrayList6.size() - 1; -1 < size10; size10--) {
                b bVar2 = arrayList6.get(size10);
                Intrinsics.checkNotNullExpressionValue(bVar2, "changes[j]");
                n(bVar2);
                if (arrayList6.isEmpty()) {
                    this.mChangesList.remove(arrayList6);
                }
            }
        }
        cancelAll(this.mRemoveAnimations);
        cancelAll(this.mMoveAnimations);
        cancelAll(this.mAddAnimations);
        cancelAll(this.mChangeAnimations);
        dispatchAnimationsFinished();
    }

    public final void g(@NotNull RecyclerView.ViewHolder holder, float offsetY) {
        boolean z16;
        Intrinsics.checkNotNullParameter(holder, "holder");
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        ViewPropertyAnimator animate = view.animate();
        this.mAddAnimations.add(holder);
        if (offsetY == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            view.setTranslationY(-offsetY);
            animate.translationY(0.0f);
        }
        holder.itemView.setAlpha(0.0f);
        animate.alpha(1.0f).setDuration(getAddDuration()).setListener(new e(holder, view, animate)).start();
    }

    public final void i(@NotNull b changeInfo) {
        View view;
        Intrinsics.checkNotNullParameter(changeInfo, "changeInfo");
        RecyclerView.ViewHolder oldHolder = changeInfo.getOldHolder();
        View view2 = null;
        if (oldHolder != null) {
            view = oldHolder.itemView;
        } else {
            view = null;
        }
        RecyclerView.ViewHolder newHolder = changeInfo.getNewHolder();
        if (newHolder != null) {
            view2 = newHolder.itemView;
        }
        if (t(changeInfo)) {
            return;
        }
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(getChangeDuration());
            this.mChangeAnimations.add(changeInfo.getOldHolder());
            duration.translationX(changeInfo.getToX() - changeInfo.getFromX());
            duration.translationY(changeInfo.getToY() - changeInfo.getFromY());
            duration.alpha(0.0f).setListener(new f(changeInfo, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            this.mChangeAnimations.add(changeInfo.getNewHolder());
            animate.translationX(0.0f).translationY(0.0f).setDuration(getChangeDuration()).alpha(1.0f).setListener(new g(changeInfo, animate, view2)).start();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean isRunning() {
        if ((!this.mPendingAdditions.isEmpty()) || (!this.mPendingChanges.isEmpty()) || (!this.mPendingMoves.isEmpty()) || (!this.mPendingRemovals.isEmpty()) || (!this.mMoveAnimations.isEmpty()) || (!this.mRemoveAnimations.isEmpty()) || (!this.mAddAnimations.isEmpty()) || (!this.mChangeAnimations.isEmpty()) || (!this.mMovesList.isEmpty()) || (!this.mAdditionsList.isEmpty()) || (!this.mChangesList.isEmpty())) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    @NotNull
    public RecyclerView.ItemAnimator.ItemHolderInfo obtainHolderInfo() {
        return new a();
    }

    @NotNull
    public final ArrayList<RecyclerView.ViewHolder> p() {
        return this.mAddAnimations;
    }

    @NotNull
    public final ArrayList<RecyclerView.ViewHolder> q() {
        return this.mChangeAnimations;
    }

    @NotNull
    public final ArrayList<RecyclerView.ViewHolder> r() {
        return this.mMoveAnimations;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    @NotNull
    public RecyclerView.ItemAnimator.ItemHolderInfo recordPreLayoutInformation(@NotNull RecyclerView.State state, @NotNull RecyclerView.ViewHolder viewHolder, int changeFlags, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        RecyclerView.ItemAnimator.ItemHolderInfo recordPreLayoutInformation = super.recordPreLayoutInformation(state, viewHolder, changeFlags, payloads);
        Intrinsics.checkNotNullExpressionValue(recordPreLayoutInformation, "super.recordPreLayoutInf\u2026r, changeFlags, payloads)");
        if (changeFlags != 2) {
            return recordPreLayoutInformation;
        }
        if (!(recordPreLayoutInformation instanceof a)) {
            return recordPreLayoutInformation;
        }
        if (payloads.contains(1)) {
            ((a) recordPreLayoutInformation).f(1);
        } else if (payloads.contains(2)) {
            ((a) recordPreLayoutInformation).f(2);
        } else if (payloads.contains(3)) {
            ((a) recordPreLayoutInformation).h(1);
        } else if (payloads.contains(4)) {
            ((a) recordPreLayoutInformation).h(2);
        } else if (payloads.contains(6)) {
            ((a) recordPreLayoutInformation).g(true);
        } else if (payloads.contains(7)) {
            ((a) recordPreLayoutInformation).e(true);
        }
        return recordPreLayoutInformation;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void runPendingAnimations() {
        long j3;
        long j16;
        boolean z16 = !this.mPendingRemovals.isEmpty();
        boolean z17 = !this.mPendingMoves.isEmpty();
        boolean z18 = !this.mPendingChanges.isEmpty();
        boolean z19 = !this.mPendingAdditions.isEmpty();
        if ((!z16 && !z17 && !z19 && !z18) || u()) {
            return;
        }
        Iterator<RecyclerView.ViewHolder> it = this.mPendingRemovals.iterator();
        while (it.hasNext()) {
            RecyclerView.ViewHolder mPendingRemovals = it.next();
            Intrinsics.checkNotNullExpressionValue(mPendingRemovals, "mPendingRemovals");
            k(this, mPendingRemovals, 0.0f, 2, null);
        }
        this.mPendingRemovals.clear();
        if (z17) {
            final ArrayList<d> arrayList = new ArrayList<>();
            arrayList.addAll(this.mPendingMoves);
            this.mMovesList.add(arrayList);
            this.mPendingMoves.clear();
            Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.guild.setting.group.i
                @Override // java.lang.Runnable
                public final void run() {
                    o.y(arrayList, this);
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
            final ArrayList<b> arrayList2 = new ArrayList<>();
            arrayList2.addAll(this.mPendingChanges);
            this.mChangesList.add(arrayList2);
            this.mPendingChanges.clear();
            new Runnable() { // from class: com.tencent.mobileqq.guild.setting.group.j
                @Override // java.lang.Runnable
                public final void run() {
                    o.z(arrayList2, this);
                }
            }.run();
        }
        if (z19) {
            final ArrayList<RecyclerView.ViewHolder> arrayList3 = new ArrayList<>();
            arrayList3.addAll(this.mPendingAdditions);
            this.mAdditionsList.add(arrayList3);
            this.mPendingAdditions.clear();
            Runnable runnable2 = new Runnable() { // from class: com.tencent.mobileqq.guild.setting.group.k
                @Override // java.lang.Runnable
                public final void run() {
                    o.A(arrayList3, this);
                }
            };
            if (!z16 && !z17 && !z18) {
                runnable2.run();
                return;
            }
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
            long max = j3 + Math.max(j16, 0L);
            View view2 = arrayList3.get(0).itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "additions[0].itemView");
            ViewCompat.postOnAnimationDelayed(view2, runnable2, max);
        }
    }

    @NotNull
    public final ArrayList<RecyclerView.ViewHolder> s() {
        return this.mRemoveAnimations;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u001b\b\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b(\u0010)B;\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0010\u0012\u0006\u0010\u001e\u001a\u00020\u0010\u00a2\u0006\u0004\b(\u0010*B/\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010$\u001a\u0004\u0018\u00010\u001f\u0012\b\u0010'\u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0004\b(\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\"\u0010\u0015\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0011\u001a\u0004\b\u0005\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\f\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\"\u0010\u001b\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\"\u0010\u001e\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R$\u0010$\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010 \u001a\u0004\b\u0018\u0010!\"\u0004\b\"\u0010#R$\u0010'\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010 \u001a\u0004\b%\u0010!\"\u0004\b&\u0010#\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/o$b;", "", "", "toString", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "d", "()Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "k", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "oldHolder", "b", "c", "j", "newHolder", "", "I", "()I", tl.h.F, "(I)V", "fromX", "i", "fromY", "e", "f", "l", "toX", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "toY", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator$ItemHolderInfo;", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator$ItemHolderInfo;", "()Landroidx/recyclerview/widget/RecyclerView$ItemAnimator$ItemHolderInfo;", "setPreInfo", "(Landroidx/recyclerview/widget/RecyclerView$ItemAnimator$ItemHolderInfo;)V", "preInfo", "getPostInfo", "setPostInfo", "postInfo", "<init>", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;IIII)V", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ItemAnimator$ItemHolderInfo;Landroidx/recyclerview/widget/RecyclerView$ItemAnimator$ItemHolderInfo;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private RecyclerView.ViewHolder oldHolder;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private RecyclerView.ViewHolder newHolder;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private int fromX;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private int fromY;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private int toX;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private int toY;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private RecyclerView.ItemAnimator.ItemHolderInfo preInfo;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private RecyclerView.ItemAnimator.ItemHolderInfo postInfo;

        b(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            this.oldHolder = viewHolder;
            this.newHolder = viewHolder2;
        }

        /* renamed from: a, reason: from getter */
        public final int getFromX() {
            return this.fromX;
        }

        /* renamed from: b, reason: from getter */
        public final int getFromY() {
            return this.fromY;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final RecyclerView.ViewHolder getNewHolder() {
            return this.newHolder;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final RecyclerView.ViewHolder getOldHolder() {
            return this.oldHolder;
        }

        @Nullable
        /* renamed from: e, reason: from getter */
        public final RecyclerView.ItemAnimator.ItemHolderInfo getPreInfo() {
            return this.preInfo;
        }

        /* renamed from: f, reason: from getter */
        public final int getToX() {
            return this.toX;
        }

        /* renamed from: g, reason: from getter */
        public final int getToY() {
            return this.toY;
        }

        public final void h(int i3) {
            this.fromX = i3;
        }

        public final void i(int i3) {
            this.fromY = i3;
        }

        public final void j(@Nullable RecyclerView.ViewHolder viewHolder) {
            this.newHolder = viewHolder;
        }

        public final void k(@Nullable RecyclerView.ViewHolder viewHolder) {
            this.oldHolder = viewHolder;
        }

        public final void l(int i3) {
            this.toX = i3;
        }

        public final void m(int i3) {
            this.toY = i3;
        }

        @NotNull
        public String toString() {
            return "ChangeInfo{oldHolder=" + this.oldHolder + ", newHolder=" + this.newHolder + ", fromX=" + this.fromX + ", fromY=" + this.fromY + ", toX=" + this.toX + ", toY=" + this.toY + "}";
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public b(@NotNull RecyclerView.ViewHolder oldHolder, @Nullable RecyclerView.ViewHolder viewHolder, int i3, int i16, int i17, int i18) {
            this(oldHolder, viewHolder);
            Intrinsics.checkNotNullParameter(oldHolder, "oldHolder");
            this.fromX = i3;
            this.fromY = i16;
            this.toX = i17;
            this.toY = i18;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public b(@NotNull RecyclerView.ViewHolder oldHolder, @Nullable RecyclerView.ViewHolder viewHolder, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
            this(oldHolder, viewHolder);
            Intrinsics.checkNotNullParameter(oldHolder, "oldHolder");
            this.preInfo = itemHolderInfo;
            this.postInfo = itemHolderInfo2;
        }
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateChange(@NotNull RecyclerView.ViewHolder oldHolder, @Nullable RecyclerView.ViewHolder newHolder, int fromX, int fromY, int toX, int toY) {
        Intrinsics.checkNotNullParameter(oldHolder, "oldHolder");
        if (oldHolder == newHolder) {
            Object tag = oldHolder.itemView.getTag(R.id.wvs);
            if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                for (b bVar : this.mPendingChanges) {
                    if (Intrinsics.areEqual(bVar.getNewHolder(), oldHolder)) {
                        bVar.h(((int) oldHolder.itemView.getTranslationX()) + fromX);
                        bVar.i(((int) oldHolder.itemView.getTranslationY()) + fromY);
                        bVar.l(toX);
                        bVar.m(toY);
                    }
                }
            }
            return animateMove(oldHolder, fromX, fromY, toX, toY);
        }
        float translationX = oldHolder.itemView.getTranslationX();
        float translationY = oldHolder.itemView.getTranslationY();
        float alpha = oldHolder.itemView.getAlpha();
        resetAnimation(oldHolder);
        int i3 = (int) ((toX - fromX) - translationX);
        int i16 = (int) ((toY - fromY) - translationY);
        oldHolder.itemView.setTranslationX(translationX);
        oldHolder.itemView.setTranslationY(translationY);
        oldHolder.itemView.setAlpha(alpha);
        if (newHolder != null) {
            resetAnimation(newHolder);
            newHolder.itemView.setTranslationX(-i3);
            newHolder.itemView.setTranslationY(-i16);
            newHolder.itemView.setAlpha(0.0f);
        }
        this.mPendingChanges.add(new b(oldHolder, newHolder, fromX, fromY, toX, toY));
        return true;
    }
}
