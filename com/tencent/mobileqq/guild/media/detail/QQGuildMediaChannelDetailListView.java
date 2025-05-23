package com.tencent.mobileqq.guild.media.detail;

import android.content.Context;
import android.util.AttributeSet;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.media.core.MediaChannelCore;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.data.r;
import com.tencent.mobileqq.guild.media.detail.MediaDetailUserListVM;
import com.tencent.mobileqq.guild.media.detail.e;
import com.tencent.mobileqq.guild.media.detail.j;
import com.tencent.mobileqq.guild.setting.channeldetails.GuildChannelDetailHeadViewNew;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.NumberUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t12.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001$\u0018\u0000 02\u00020\u0001:\u00011B'\b\u0007\u0012\u0006\u0010)\u001a\u00020(\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u0012\b\b\u0002\u0010-\u001a\u00020,\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001f\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001bR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/guild/media/detail/QQGuildMediaChannelDetailListView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/tencent/mobileqq/guild/media/detail/e;", "notifyEvent", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/guild/media/core/data/r;", "userInfoList", BdhLogUtil.LogTag.Tag_Req, "K", "P", "M", "O", "Lcom/tencent/mobileqq/guild/setting/channeldetails/GuildChannelDetailHeadViewNew;", "guildChannelDetailHeadViewNew", "I", "Lcom/tencent/mobileqq/guild/media/detail/b;", "handler", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/media/detail/j;", "f", "Lcom/tencent/mobileqq/guild/media/detail/j;", "mAdapter", "Lcom/tencent/mobileqq/guild/media/detail/MediaDetailUserListVM;", tl.h.F, "Lkotlin/Lazy;", "H", "()Lcom/tencent/mobileqq/guild/media/detail/MediaDetailUserListVM;", "vmStoreOwner", "i", "G", "userListVM", "Lt12/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lt12/a;", "mSearchScrollManager", "com/tencent/mobileqq/guild/media/detail/QQGuildMediaChannelDetailListView$b", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/media/detail/QQGuildMediaChannelDetailListView$b;", "mLoadMoreScrollListener", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class QQGuildMediaChannelDetailListView extends RecyclerView {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final b mLoadMoreScrollListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final j mAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy vmStoreOwner;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy userListVM;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final t12.a mSearchScrollManager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JL\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/guild/media/detail/QQGuildMediaChannelDetailListView$b", "Lt12/b;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "manager", "firstVisiblePos", "lastVisiblePos", "firstCompletelyVisible", "lastCompletelyVisible", "", "isScrollUp", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements t12.b {
        b() {
        }

        @Override // t12.b
        public void a(@Nullable RecyclerView recyclerView, int newState, @Nullable RecyclerView.LayoutManager manager, int firstVisiblePos, int lastVisiblePos, int firstCompletelyVisible, int lastCompletelyVisible, boolean isScrollUp) {
            RecyclerView.LayoutManager layoutManager;
            RecyclerView.ViewHolder findViewHolderForAdapterPosition;
            if (newState != 0) {
                return;
            }
            LinearLayoutManager linearLayoutManager = null;
            if (recyclerView != null) {
                layoutManager = recyclerView.getLayoutManager();
            } else {
                layoutManager = null;
            }
            if (layoutManager instanceof LinearLayoutManager) {
                linearLayoutManager = (LinearLayoutManager) layoutManager;
            }
            if (linearLayoutManager != null && (findViewHolderForAdapterPosition = QQGuildMediaChannelDetailListView.this.findViewHolderForAdapterPosition(lastVisiblePos)) != null && (findViewHolderForAdapterPosition instanceof l)) {
                p pVar = (p) ((l) findViewHolderForAdapterPosition).itemView.getTag();
                if (pVar == null) {
                    QLog.d("QQGuildMediaChannelDetailListView", 1, "onScrollStateChanged userInfo is null");
                    return;
                }
                QLog.d("QQGuildMediaChannelDetailListView", 4, "onScrollStateChanged " + pVar.f228094b);
                if (lastVisiblePos >= linearLayoutManager.getItemCount() - 1 && linearLayoutManager.getItemCount() != 0) {
                    QQGuildMediaChannelDetailListView.this.G().loadMore();
                }
            }
        }

        @Override // t12.b
        public void b(int i3, int i16, int i17, int i18, boolean z16) {
            b.a.b(this, i3, i16, i17, i18, z16);
        }

        @Override // t12.b
        public void c(@Nullable RecyclerView recyclerView, int i3, int i16, boolean z16) {
            b.a.a(this, recyclerView, i3, i16, z16);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QQGuildMediaChannelDetailListView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MediaDetailUserListVM G() {
        return (MediaDetailUserListVM) this.userListVM.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MediaDetailUserListVM H() {
        return (MediaDetailUserListVM) this.vmStoreOwner.getValue();
    }

    private final void K() {
        cn<e> Q1 = G().Q1();
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(this);
        Intrinsics.checkNotNull(lifecycleOwner);
        Q1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.media.detail.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildMediaChannelDetailListView.L(QQGuildMediaChannelDetailListView.this, (e) obj);
            }
        });
        G().initData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(QQGuildMediaChannelDetailListView this$0, e it) {
        boolean areEqual;
        boolean areEqual2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("QQGuildMediaChannelDetailListView", 4, "NotifyEvent, " + it);
        boolean z16 = true;
        if (it instanceof e.a) {
            areEqual = true;
        } else {
            areEqual = Intrinsics.areEqual(it, e.b.f228778a);
        }
        if (areEqual) {
            areEqual2 = true;
        } else {
            areEqual2 = Intrinsics.areEqual(it, e.c.f228779a);
        }
        if (!areEqual2) {
            z16 = Intrinsics.areEqual(it, e.C7833e.f228781a);
        }
        if (z16) {
            this$0.P();
            j jVar = this$0.mAdapter;
            List<p> list = MediaChannelCore.INSTANCE.a().o0().getTotalUserInfoList().f228125a;
            Intrinsics.checkNotNullExpressionValue(list, "MediaChannelCore.instanc\u2026totalUserInfoList.anchors");
            jVar.r0(list);
            if (Intrinsics.areEqual(it, e.a.f228777a)) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                this$0.Q(it);
                return;
            }
            return;
        }
        if (it instanceof e.d) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.Q(it);
        } else if (it instanceof e.f) {
            this$0.R(((e.f) it).getUserInfoList());
        }
    }

    private final void P() {
        MediaChannelCore.Companion companion = MediaChannelCore.INSTANCE;
        companion.a().o0().getTotalUserInfoList().f228125a.clear();
        companion.a().o0().getTotalUserInfoList().f228125a.addAll(G().R1());
        List<p> list = companion.a().o0().getTotalUserInfoList().f228125a;
        Intrinsics.checkNotNullExpressionValue(list, "MediaChannelCore.instanc\u2026totalUserInfoList.anchors");
        ArrayList<p> arrayList = new ArrayList();
        for (Object obj : list) {
            if (MediaChannelCore.INSTANCE.a().o0().r().contains(Long.valueOf(NumberUtil.stringToLong(((p) obj).f228093a)))) {
                arrayList.add(obj);
            }
        }
        for (p pVar : arrayList) {
            if (!pVar.f228112t) {
                pVar.f228112t = true;
                MediaChannelCore.INSTANCE.a().y0().muteRemoteAudio(pVar.f228093a, true);
            }
        }
    }

    private final void Q(e notifyEvent) {
        if (getLayoutManager() instanceof LinearLayoutManager) {
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            if (findFirstVisibleItemPosition > findLastVisibleItemPosition) {
                return;
            }
            while (true) {
                RecyclerView.ViewHolder findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(findFirstVisibleItemPosition);
                if (findViewHolderForAdapterPosition != null && (findViewHolderForAdapterPosition instanceof j.b)) {
                    int X = com.tencent.mobileqq.guild.media.core.j.c().X();
                    if (notifyEvent instanceof e.a) {
                        ((j.b) findViewHolderForAdapterPosition).l(com.tencent.mobileqq.guild.media.core.j.c().W(), X);
                    } else if (notifyEvent instanceof e.d) {
                        ((j.b) findViewHolderForAdapterPosition).l(((e.d) notifyEvent).getCount(), X);
                    }
                }
                if (findFirstVisibleItemPosition != findLastVisibleItemPosition) {
                    findFirstVisibleItemPosition++;
                } else {
                    return;
                }
            }
        }
    }

    private final void R(r userInfoList) {
        if (getLayoutManager() instanceof LinearLayoutManager) {
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            if (findFirstVisibleItemPosition > findLastVisibleItemPosition) {
                return;
            }
            while (true) {
                RecyclerView.ViewHolder findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(findFirstVisibleItemPosition);
                if (findViewHolderForAdapterPosition != null && (findViewHolderForAdapterPosition instanceof l)) {
                    ((l) findViewHolderForAdapterPosition).q(userInfoList);
                }
                if (findFirstVisibleItemPosition != findLastVisibleItemPosition) {
                    findFirstVisibleItemPosition++;
                } else {
                    return;
                }
            }
        }
    }

    public final void F(@NotNull com.tencent.mobileqq.guild.media.detail.b handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.mAdapter.n0(handler);
    }

    public final void I(@NotNull GuildChannelDetailHeadViewNew guildChannelDetailHeadViewNew) {
        Intrinsics.checkNotNullParameter(guildChannelDetailHeadViewNew, "guildChannelDetailHeadViewNew");
        this.mAdapter.setHasStableIds(true);
        setAdapter(this.mAdapter);
        setLayoutManager(new com.tencent.mobileqq.guild.media.widget.audiofaceview.e(getContext()));
        this.mAdapter.q0(guildChannelDetailHeadViewNew);
        this.mSearchScrollManager.d(this.mLoadMoreScrollListener);
        addOnScrollListener(this.mSearchScrollManager);
        K();
    }

    public final void M() {
        G().U1();
    }

    public final void O() {
        G().W1();
        if (GuildSplitViewUtils.f235370a.n(getContext())) {
            G().P1();
            LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(this);
            if (lifecycleOwner != null) {
                G().Q1().removeObservers(lifecycleOwner);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QQGuildMediaChannelDetailListView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ QQGuildMediaChannelDetailListView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QQGuildMediaChannelDetailListView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.mAdapter = new j();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MediaDetailUserListVM>() { // from class: com.tencent.mobileqq.guild.media.detail.QQGuildMediaChannelDetailListView$vmStoreOwner$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MediaDetailUserListVM invoke() {
                MediaDetailUserListVM.Companion companion = MediaDetailUserListVM.INSTANCE;
                ViewModelStoreOwner viewModelStoreOwner = ViewTreeViewModelStoreOwner.get(QQGuildMediaChannelDetailListView.this);
                Intrinsics.checkNotNull(viewModelStoreOwner);
                return companion.a(viewModelStoreOwner);
            }
        });
        this.vmStoreOwner = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<MediaDetailUserListVM>() { // from class: com.tencent.mobileqq.guild.media.detail.QQGuildMediaChannelDetailListView$userListVM$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MediaDetailUserListVM invoke() {
                MediaDetailUserListVM H;
                H = QQGuildMediaChannelDetailListView.this.H();
                return H;
            }
        });
        this.userListVM = lazy2;
        this.mSearchScrollManager = new t12.a();
        this.mLoadMoreScrollListener = new b();
    }
}
