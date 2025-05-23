package com.tencent.guildmedia.aio.excellentdetail.msglist;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.AIOLayoutManager;
import androidx.recyclerview.widget.AIORecycleView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aio.api.list.IListUIOperationApi;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.guild.aio.chosen.msglist.a;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListDataState;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListViewState;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J \u0010\u0016\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016R\u0016\u0010\u001d\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001cR\u0016\u0010&\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/guildmedia/aio/excellentdetail/msglist/a;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/c;", "Lat/b;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "", HippyTKDListViewAdapter.SCROLL_STATE, "", "L1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", Constants.APK_CERTIFICATE, "height", "K1", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataState;", "state", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "uiHelper", "J1", "size", "I1", "childView", "T0", "S0", "u0", "Lcom/tencent/guildmedia/aio/excellentdetail/msglist/GuildMediaExcellentMsgListDataVM;", "H1", "M", "Landroid/view/View;", "mEmptyView", "Landroidx/recyclerview/widget/AIORecycleView;", "N", "Landroidx/recyclerview/widget/AIORecycleView;", "mRecycleView", "P", "mChildView", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/aio/api/list/IListUIOperationApi;", "listUIOperationApi", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "quiEmptyState", "<init>", "()V", ExifInterface.LATITUDE_SOUTH, "a", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a extends c<at.b, MsgListUiState> {

    /* renamed from: M, reason: from kotlin metadata */
    private View mEmptyView;

    /* renamed from: N, reason: from kotlin metadata */
    private AIORecycleView mRecycleView;

    /* renamed from: P, reason: from kotlin metadata */
    private View mChildView;

    /* renamed from: Q, reason: from kotlin metadata */
    private IListUIOperationApi listUIOperationApi;

    /* renamed from: R, reason: from kotlin metadata */
    private QUIEmptyState quiEmptyState;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/guildmedia/aio/excellentdetail/msglist/a$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                a.this.L1(newState);
            }
        }
    }

    private final View G1(com.tencent.mvi.api.help.a createViewParams) {
        LinearLayout linearLayout = new LinearLayout(createViewParams.a());
        FrameLayout.LayoutParams a16 = com.tencent.aio.base.tool.b.f69219a.a(createViewParams.a(), -2, -2);
        a16.gravity = 17;
        linearLayout.setLayoutParams(a16);
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(linearLayout.getContext()).setImageType(16);
        String qqStr = HardCodeUtil.qqStr(R.string.f141080fp);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_channel_announce_empty_msg)");
        QUIEmptyState build = imageType.setTitle(qqStr).setHalfScreenState(true).setThemeType(2).setBackgroundColorType(0).build();
        this.quiEmptyState = build;
        QUIEmptyState qUIEmptyState = null;
        if (build == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quiEmptyState");
            build = null;
        }
        TextView textView = (TextView) build.findViewById(R.id.uuo);
        textView.setSingleLine(false);
        textView.setGravity(17);
        QUIEmptyState qUIEmptyState2 = this.quiEmptyState;
        if (qUIEmptyState2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quiEmptyState");
        } else {
            qUIEmptyState = qUIEmptyState2;
        }
        linearLayout.addView(qUIEmptyState);
        return linearLayout;
    }

    private final void I1(int size) {
        boolean z16;
        if (size > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        View view = this.mEmptyView;
        AIORecycleView aIORecycleView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmptyView");
            view = null;
        }
        vs0.a.p(view, !z16);
        AIORecycleView aIORecycleView2 = this.mRecycleView;
        if (aIORecycleView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecycleView");
        } else {
            aIORecycleView = aIORecycleView2;
        }
        vs0.a.p(aIORecycleView, z16);
        sendIntent(new a.C1178a(size));
    }

    private final void J1(GuildMsgListDataState state, IListUIOperationApi uiHelper) {
        RecyclerView.Adapter adapter = uiHelper.i().getAdapter();
        if (state.getForceUpdate()) {
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        } else {
            super.u0(state, uiHelper);
        }
        I1(state.size());
    }

    private final void K1(int height) {
        if (getHostView().getPaddingBottom() != height) {
            getHostView().setPadding(0, 0, 0, height);
            getHostView().requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L1(int scrollState) {
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

    @Override // com.tencent.aio.api.list.j
    @NotNull
    /* renamed from: H1, reason: merged with bridge method [inline-methods] */
    public GuildMediaExcellentMsgListDataVM F0() {
        return new GuildMediaExcellentMsgListDataVM();
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, com.tencent.aio.api.list.j
    public void S0() {
        String qqStr;
        super.S0();
        com.tencent.guildmedia.aio.excellentdetail.msglist.b bVar = new com.tencent.guildmedia.aio.excellentdetail.msglist.b(false);
        sendIntent(bVar);
        QUIEmptyState qUIEmptyState = this.quiEmptyState;
        if (qUIEmptyState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quiEmptyState");
            qUIEmptyState = null;
        }
        if (!bVar.getHavePermissions()) {
            qqStr = HardCodeUtil.qqStr(R.string.f141080fp);
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.f141090fq);
        }
        Intrinsics.checkNotNullExpressionValue(qqStr, "if (!intent.havePermissi\u2026or_manager)\n            }");
        qUIEmptyState.setTitle(qqStr);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, com.tencent.aio.api.list.j
    @NotNull
    public View T0(@NotNull com.tencent.mvi.api.help.a createViewParams, @NotNull View childView, @NotNull IListUIOperationApi uiHelper) {
        AIORecycleView aIORecycleView;
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(uiHelper, "uiHelper");
        super.T0(createViewParams, childView, uiHelper);
        this.mChildView = childView;
        this.listUIOperationApi = uiHelper;
        AIORecycleView i3 = uiHelper.i();
        this.mRecycleView = i3;
        View view = null;
        if (i3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecycleView");
            aIORecycleView = null;
        } else {
            aIORecycleView = i3;
        }
        aIORecycleView.getLayoutManager().setStackFromEnd(false);
        i3.addOnScrollListener(new b());
        FrameLayout frameLayout = new FrameLayout(createViewParams.a());
        frameLayout.setLayoutParams(com.tencent.aio.base.tool.b.f69219a.a(createViewParams.a(), -1, -1));
        View view2 = this.mChildView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChildView");
            view2 = null;
        }
        frameLayout.addView(view2, -1, -1);
        View G1 = G1(createViewParams);
        this.mEmptyView = G1;
        if (G1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmptyView");
        } else {
            view = G1;
        }
        frameLayout.addView(view);
        return frameLayout;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, com.tencent.aio.api.list.j
    public void u0(@NotNull MsgListUiState state, @NotNull IListUIOperationApi uiHelper) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(uiHelper, "uiHelper");
        if (state instanceof GuildMsgListDataState) {
            J1((GuildMsgListDataState) state, uiHelper);
        } else if (state instanceof GuildMsgListViewState.GuildInputBarHeightChangeDataState) {
            K1(((GuildMsgListViewState.GuildInputBarHeightChangeDataState) state).getHeight());
        }
    }
}
