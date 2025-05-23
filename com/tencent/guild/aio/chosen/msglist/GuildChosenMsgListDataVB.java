package com.tencent.guild.aio.chosen.msglist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.AIOLayoutManager;
import androidx.recyclerview.widget.AIORecycleView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aio.api.list.IListUIOperationApi;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.state.MsgListState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.guild.aio.chosen.msglist.a;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListDataState;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListViewState;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import xs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 72\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00018B\u0007\u00a2\u0006\u0004\b5\u00106J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J \u0010 \u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0018\u0010!\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0016\u0010$\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030#0\"H\u0016J\b\u0010&\u001a\u00020%H\u0016J\u0014\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030'H\u0016R\u0016\u0010+\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0016\u00100\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00069"}, d2 = {"Lcom/tencent/guild/aio/chosen/msglist/GuildChosenMsgListDataVB;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/c;", "Lat/b;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "Landroid/content/Context;", "context", "", "I1", "", HippyTKDListViewAdapter.SCROLL_STATE, "P1", "height", "O1", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/state/MsgListState;", "state", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "helper", "K1", "L1", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataState;", "uiHelper", "N1", c.G, "M1", "itemCount", "Landroidx/recyclerview/widget/AIORecycleView;", "recycleView", "J1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "childView", "T0", "u0", "", "Ljava/lang/Class;", "getObserverStates", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/AbsMsgListVB$b;", "E1", "Lcom/tencent/aio/base/mvvm/b;", "F0", "M", "Landroid/view/View;", "mEmptyContainerView", "N", "mChildView", "P", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "listUIOperationApi", "Lcom/tencent/guild/aio/factory/business/holder/msglist/scrollers/b;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/guild/aio/factory/business/holder/msglist/scrollers/b;", "focusBottomHandler", "<init>", "()V", BdhLogUtil.LogTag.Tag_Req, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildChosenMsgListDataVB extends com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c<at.b, MsgListUiState> {

    /* renamed from: M, reason: from kotlin metadata */
    private View mEmptyContainerView;

    /* renamed from: N, reason: from kotlin metadata */
    private View mChildView;

    /* renamed from: P, reason: from kotlin metadata */
    private IListUIOperationApi listUIOperationApi;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private com.tencent.guild.aio.factory.business.holder.msglist.scrollers.b focusBottomHandler = new com.tencent.guild.aio.factory.business.holder.msglist.scrollers.b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/guild/aio/chosen/msglist/GuildChosenMsgListDataVB$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                GuildChosenMsgListDataVB.this.P1(newState);
            }
        }
    }

    private final void I1(Context context) {
        QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(context).setImageType(16);
        String qqStr = HardCodeUtil.qqStr(R.string.f157861o2);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(com.tencent.mobile\u2026ring.guild_top_empty_msg)");
        QUIEmptyState build = imageType.setTitle(qqStr).setHalfScreenState(true).setBackgroundColorType(0).build();
        View view = this.mEmptyContainerView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmptyContainerView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.uux);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mEmptyContainerView.find\u2026.id.empty_view_container)");
        ((LinearLayout) findViewById).addView(build);
    }

    private final void J1(int itemCount, AIORecycleView recycleView) {
        View view = null;
        if (itemCount > 0) {
            recycleView.setVisibility(0);
            View view2 = this.mEmptyContainerView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEmptyContainerView");
            } else {
                view = view2;
            }
            view.setVisibility(8);
        } else {
            recycleView.setVisibility(8);
            View view3 = this.mEmptyContainerView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEmptyContainerView");
            } else {
                view = view3;
            }
            view.setVisibility(0);
        }
        sendIntent(new a.C1178a(itemCount));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K1(MsgListState state, IListUIOperationApi helper) {
        boolean m3 = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a.m(state, helper);
        QLog.i("GuildMsgListDataVB", 1, "processFocusIndex, FOCUS_BOTTOM, state.size = " + state.size() + ", needHandle: " + m3 + ", updateType: " + state.getUpdateType());
        if (m3) {
            this.focusBottomHandler.i(state, helper);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L1(MsgListState state, IListUIOperationApi helper) {
        QLog.i("GuildMsgListDataVB", 1, "processFocusIndex, FOCUS_HEAD, state.size = " + state.size() + ", opType: " + state.getUpdateType());
        a.C11562a.a(helper, 0, false, null, 6, null);
    }

    private final void M1(int pos, IListUIOperationApi uiHelper) {
        if (pos >= 0) {
            uiHelper.d(pos, 1);
        }
    }

    private final void N1(GuildMsgListDataState state, IListUIOperationApi uiHelper) {
        RecyclerView.Adapter adapter = uiHelper.i().getAdapter();
        if (state.getForceUpdate()) {
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        } else {
            super.u0(state, uiHelper);
        }
        J1(state.size(), uiHelper.i());
    }

    private final void O1(int height) {
        QLog.i("GuildMsgListDataVB", 1, "handleInputBarHeightChange, height = " + height + " host " + getHostView());
        View view = this.mChildView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChildView");
            view = null;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams.bottomMargin != height) {
                marginLayoutParams.bottomMargin = height;
                View view3 = this.mChildView;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mChildView");
                } else {
                    view2 = view3;
                }
                view2.requestLayout();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P1(int scrollState) {
        com.tencent.aio.data.msglist.a aVar;
        int i3;
        IListUIOperationApi iListUIOperationApi = this.listUIOperationApi;
        com.tencent.aio.data.msglist.a aVar2 = null;
        if (iListUIOperationApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
            iListUIOperationApi = null;
        }
        AIOLayoutManager layoutManager = iListUIOperationApi.i().getLayoutManager();
        int findFirstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
        if (findFirstVisibleItemPosition >= 0 && findLastVisibleItemPosition >= 0) {
            IListUIOperationApi iListUIOperationApi2 = this.listUIOperationApi;
            if (iListUIOperationApi2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
                iListUIOperationApi2 = null;
            }
            Pair<com.tencent.aio.api.vo.a, com.tencent.aio.api.vo.a> J = iListUIOperationApi2.J(findFirstVisibleItemPosition, findLastVisibleItemPosition);
            com.tencent.aio.api.vo.a first = J.getFirst();
            if (first != null) {
                aVar = first.a();
                i3 = first.b();
            } else {
                aVar = null;
                i3 = findFirstVisibleItemPosition;
            }
            com.tencent.aio.api.vo.a second = J.getSecond();
            if (second != null) {
                aVar2 = second.a();
                findLastVisibleItemPosition = second.b();
            }
            sendIntent(new a.g(scrollState, i3, findLastVisibleItemPosition, aVar, aVar2));
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c
    @NotNull
    public AbsMsgListVB.b E1() {
        return new AbsMsgListVB.b() { // from class: com.tencent.guild.aio.chosen.msglist.GuildChosenMsgListDataVB$createFocusIndex$1
            @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB.b
            public void a(@NotNull MsgListState state, @NotNull IListUIOperationApi helper) {
                Intrinsics.checkNotNullParameter(state, "state");
                Intrinsics.checkNotNullParameter(helper, "helper");
                com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
                if (bVar.j(state.getExtra())) {
                    GuildChosenMsgListDataVB.this.K1(state, helper);
                    return;
                }
                if (bVar.k(state.getExtra())) {
                    GuildChosenMsgListDataVB.this.L1(state, helper);
                } else if (bVar.l(state.getExtra())) {
                    final GuildChosenMsgListDataVB guildChosenMsgListDataVB = GuildChosenMsgListDataVB.this;
                    bVar.i(state, helper, "GuildMsgListDataVB", new Function1<at.b, Unit>() { // from class: com.tencent.guild.aio.chosen.msglist.GuildChosenMsgListDataVB$createFocusIndex$1$processFocusIndex$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(at.b bVar2) {
                            invoke2(bVar2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull at.b intent) {
                            Intrinsics.checkNotNullParameter(intent, "intent");
                            GuildChosenMsgListDataVB.this.sendIntent(intent);
                        }
                    });
                }
            }
        };
    }

    @Override // com.tencent.aio.api.list.j
    @NotNull
    public com.tencent.aio.base.mvvm.b<at.b, MsgListUiState> F0() {
        return new GuildChosenMsgListDataVM();
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, com.tencent.aio.api.list.j
    @NotNull
    public View T0(@NotNull com.tencent.mvi.api.help.a createViewParams, @NotNull View childView, @NotNull IListUIOperationApi uiHelper) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(uiHelper, "uiHelper");
        super.T0(createViewParams, childView, uiHelper);
        this.listUIOperationApi = uiHelper;
        AIORecycleView i3 = uiHelper.i();
        i3.getLayoutManager().setStackFromEnd(false);
        uiHelper.setEnableLoadMore(false);
        uiHelper.a(false);
        i3.addOnScrollListener(new b());
        FrameLayout frameLayout = new FrameLayout(createViewParams.a());
        this.mChildView = childView;
        View view = null;
        View inflate = LayoutInflater.from(createViewParams.a()).inflate(R.layout.ede, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(createViewParams.co\u2026de_chosen_aio_empty,null)");
        this.mEmptyContainerView = inflate;
        Context context = frameLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        I1(context);
        frameLayout.addView(childView);
        View view2 = this.mEmptyContainerView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmptyContainerView");
        } else {
            view = view2;
        }
        frameLayout.addView(view, com.tencent.aio.base.tool.b.f69219a.a(createViewParams.a(), -1, -1));
        return frameLayout;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends MsgListUiState>> getObserverStates() {
        List<Class<? extends MsgListUiState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{GuildMsgListViewState.GuildInputBarHeightChangeDataState.class, GuildMsgListViewState.GuildMsgItemChangedState.class});
        return listOf;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, com.tencent.aio.api.list.j
    public void u0(@NotNull MsgListUiState state, @NotNull IListUIOperationApi uiHelper) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(uiHelper, "uiHelper");
        if (state instanceof GuildMsgListViewState.GuildInputBarHeightChangeDataState) {
            O1(((GuildMsgListViewState.GuildInputBarHeightChangeDataState) state).getHeight());
        } else if (state instanceof GuildMsgListDataState) {
            N1((GuildMsgListDataState) state, uiHelper);
        } else if (state instanceof GuildMsgListViewState.GuildMsgItemChangedState) {
            M1(((GuildMsgListViewState.GuildMsgItemChangedState) state).getPos(), uiHelper);
        }
    }
}
