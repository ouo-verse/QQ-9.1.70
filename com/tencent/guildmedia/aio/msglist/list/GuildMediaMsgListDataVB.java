package com.tencent.guildmedia.aio.msglist.list;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.AIORecycleView;
import androidx.recyclerview.widget.OnAIOTouchListener;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aio.api.list.IBounceScrollApi;
import com.tencent.aio.api.list.IListUIOperationApi;
import com.tencent.aio.api.list.l;
import com.tencent.aio.api.refreshLoad.c;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.intent.a;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.state.MsgListState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListDataState;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListViewState;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.guild.aio.factory.business.holder.msglist.k;
import com.tencent.guild.aio.msglist.highlight.HighLightViewHolderUIState;
import com.tencent.guildmedia.aio.msglist.list.b;
import com.tencent.guildmedia.aio.msglist.refresh.GuildMediaRefreshUIState;
import com.tencent.guildmedia.utils.GuildMediaLogUtil;
import com.tencent.guildmedia.widget.GuildMediaMsgListFrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 K2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001LB\u0011\u0012\b\u0010-\u001a\u0004\u0018\u00010*\u00a2\u0006\u0004\bI\u0010JJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J0\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00112\b\b\u0002\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u0011H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J \u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0014\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030 H\u0016J\b\u0010\"\u001a\u00020\u0006H\u0016J\u0018\u0010#\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010%\u001a\u00020$H\u0016J\u0010\u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020&H\u0016R\u0016\u0010-\u001a\u0004\u0018\u00010*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\"\u0010;\u001a\u0002048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010/R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u00106R\u0016\u0010H\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u00106\u00a8\u0006M"}, d2 = {"Lcom/tencent/guildmedia/aio/msglist/list/GuildMediaMsgListDataVB;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/c;", "Lat/b;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "Landroidx/recyclerview/widget/AIORecycleView;", "recycleView", "", "M1", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "uiHelper", "N1", "Lcom/tencent/guild/aio/msglist/highlight/HighLightViewHolderUIState;", "state", "Q1", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataState;", "P1", "S1", "", "height", "R1", "leftPad", "topPad", "rightPad", "bottomPad", "T1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "O1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "childView", "T0", "Lcom/tencent/aio/base/mvvm/b;", "F0", "S0", "u0", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/AbsMsgListVB$b;", "E1", "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "Landroid/os/Bundle;", "generateVBState", "Let0/a;", "M", "Let0/a;", "aioListener", "N", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/scrollers/b;", "P", "Lcom/tencent/guild/aio/factory/business/holder/msglist/scrollers/b;", "focusBottomHandler", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Z", "getPanelOrKeyboardShow", "()Z", "setPanelOrKeyboardShow", "(Z)V", "panelOrKeyboardShow", BdhLogUtil.LogTag.Tag_Req, "I", "bottomMargin", ExifInterface.LATITUDE_SOUTH, "listUIOperationApi", "Lbq0/f;", "T", "Lbq0/f;", "highLightViewHolderApi", "U", "couldTrigerDismissPanel", "V", "couldTriggerShowKeyboard", "<init>", "(Let0/a;)V", "W", "a", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMediaMsgListDataVB extends com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c<at.b, MsgListUiState> {
    private static final float X = ViewUtils.dip2px(56.0f);

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private final et0.a aioListener;

    /* renamed from: N, reason: from kotlin metadata */
    private IListUIOperationApi uiHelper;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean panelOrKeyboardShow;

    /* renamed from: R, reason: from kotlin metadata */
    private int bottomMargin;

    /* renamed from: S, reason: from kotlin metadata */
    private IListUIOperationApi listUIOperationApi;

    /* renamed from: T, reason: from kotlin metadata */
    private bq0.f highLightViewHolderApi;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.guild.aio.factory.business.holder.msglist.scrollers.b focusBottomHandler = new com.tencent.guild.aio.factory.business.holder.msglist.scrollers.b();

    /* renamed from: U, reason: from kotlin metadata */
    private boolean couldTrigerDismissPanel = true;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean couldTriggerShowKeyboard = true;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/guildmedia/aio/msglist/list/GuildMediaMsgListDataVB$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "newState", "onScrollStateChanged", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                GuildMediaMsgListDataVB.this.couldTrigerDismissPanel = true;
                GuildMediaMsgListDataVB.this.couldTriggerShowKeyboard = true;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (recyclerView.getScrollState() == 1 && GuildMediaMsgListDataVB.this.couldTrigerDismissPanel) {
                GuildMediaMsgListDataVB.this.couldTrigerDismissPanel = false;
                GuildMediaMsgListDataVB.this.sendIntent(a.C1186a.f110458d);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/guildmedia/aio/msglist/list/GuildMediaMsgListDataVB$c", "Landroidx/recyclerview/widget/OnAIOTouchListener;", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", "onTouch", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c implements OnAIOTouchListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GestureDetector f113135d;

        c(GestureDetector gestureDetector) {
            this.f113135d = gestureDetector;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@Nullable View v3, @Nullable MotionEvent event) {
            return this.f113135d.onTouchEvent(event);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/guildmedia/aio/msglist/list/GuildMediaMsgListDataVB$d", "Lcom/tencent/aio/api/refreshLoad/c$b;", "", ReportConstant.COSTREPORT_PREFIX, HippyScrollViewEventHelper.EVENT_TYPE_REFRESH, "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class d implements c.b {
        d() {
        }

        @Override // com.tencent.aio.api.refreshLoad.c.b
        public void onRefresh() {
            GuildMediaMsgListDataVB.this.sendIntent(new a.c("GuildMediaMsgListDataVB"));
        }

        @Override // com.tencent.aio.api.refreshLoad.c.b
        public void s() {
            GuildMediaMsgListDataVB.this.sendIntent(new a.C0640a("GuildMediaMsgListDataVB"));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/guildmedia/aio/msglist/list/GuildMediaMsgListDataVB$e", "Lcom/tencent/aio/api/list/IBounceScrollApi$b;", "", "moveType", "moveDistance", "", "totalDistance", "", "a", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class e implements IBounceScrollApi.b {
        e() {
        }

        @Override // com.tencent.aio.api.list.IBounceScrollApi.b
        public void a(int moveType, int moveDistance, float totalDistance) {
            if (moveType == 1 && moveDistance > 0 && GuildMediaMsgListDataVB.this.couldTrigerDismissPanel) {
                QLog.i("GuildMediaMsgListDataVB", 1, "onBounceLayoutMove, hideKeyBoard moveDistance = " + moveDistance + ", totalDistance = " + totalDistance);
                GuildMediaMsgListDataVB.this.sendIntent(a.C1186a.f110458d);
                GuildMediaMsgListDataVB.this.couldTrigerDismissPanel = false;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/guildmedia/aio/msglist/list/GuildMediaMsgListDataVB$f", "Lcom/tencent/aio/api/list/l;", "", "a", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class f implements l {
        f() {
        }

        @Override // com.tencent.aio.api.list.l
        public void a() {
            et0.a aVar = GuildMediaMsgListDataVB.this.aioListener;
            if (aVar != null) {
                aVar.l0();
            }
            IListUIOperationApi iListUIOperationApi = GuildMediaMsgListDataVB.this.listUIOperationApi;
            if (iListUIOperationApi == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
                iListUIOperationApi = null;
            }
            iListUIOperationApi.J0(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guildmedia/aio/msglist/list/GuildMediaMsgListDataVB$g", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onSingleTapUp", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class g extends GestureDetector.SimpleOnGestureListener {
        g() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(@Nullable MotionEvent e16) {
            GuildMediaMsgListDataVB.this.sendIntent(a.C1186a.f110458d);
            return false;
        }
    }

    public GuildMediaMsgListDataVB(@Nullable et0.a aVar) {
        this.aioListener = aVar;
    }

    private final void M1(AIORecycleView recycleView) {
        recycleView.addOnScrollListener(new b());
        recycleView.addOnTouchListener(new c(new GestureDetector(getMContext(), O1())));
    }

    private final void N1(IListUIOperationApi uiHelper) {
        this.listUIOperationApi = uiHelper;
        IListUIOperationApi iListUIOperationApi = null;
        if (uiHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
            uiHelper = null;
        }
        uiHelper.l(new d());
        IListUIOperationApi iListUIOperationApi2 = this.listUIOperationApi;
        if (iListUIOperationApi2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
            iListUIOperationApi2 = null;
        }
        iListUIOperationApi2.C(new e());
        IListUIOperationApi iListUIOperationApi3 = this.listUIOperationApi;
        if (iListUIOperationApi3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
        } else {
            iListUIOperationApi = iListUIOperationApi3;
        }
        iListUIOperationApi.s(new f());
    }

    private final GestureDetector.SimpleOnGestureListener O1() {
        return new g();
    }

    private final void P1(GuildMsgListDataState state, IListUIOperationApi uiHelper) {
        if (state.getForceUpdate()) {
            S1();
        } else {
            super.u0(state, uiHelper);
        }
    }

    private final void Q1(HighLightViewHolderUIState state) {
        bq0.f fVar = this.highLightViewHolderApi;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("highLightViewHolderApi");
            fVar = null;
        }
        fVar.b(state.getPosition(), state.getMsgRecord(), state.getParserId(), state.getExtra(), state.getItemView());
    }

    private final void R1(int height) {
        if (this.bottomMargin != height) {
            this.bottomMargin = height;
            U1(this, 0, 0, 0, height, 7, null);
        }
    }

    private final void S1() {
        GuildMediaLogUtil.INSTANCE.c("GuildMediaMsgListDataVB", "[notifyDataSetChanged] ");
        IListUIOperationApi iListUIOperationApi = this.listUIOperationApi;
        if (iListUIOperationApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
            iListUIOperationApi = null;
        }
        RecyclerView.Adapter adapter = iListUIOperationApi.i().getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    private final void T1(int leftPad, int topPad, int rightPad, int bottomPad) {
        getHostView().setPadding(leftPad, topPad, rightPad, bottomPad);
    }

    static /* synthetic */ void U1(GuildMediaMsgListDataVB guildMediaMsgListDataVB, int i3, int i16, int i17, int i18, int i19, Object obj) {
        if ((i19 & 1) != 0) {
            i3 = guildMediaMsgListDataVB.getHostView().getPaddingLeft();
        }
        if ((i19 & 2) != 0) {
            i16 = guildMediaMsgListDataVB.getHostView().getPaddingTop();
        }
        if ((i19 & 4) != 0) {
            i17 = guildMediaMsgListDataVB.getHostView().getPaddingRight();
        }
        if ((i19 & 8) != 0) {
            i18 = guildMediaMsgListDataVB.getHostView().getPaddingBottom();
        }
        guildMediaMsgListDataVB.T1(i3, i16, i17, i18);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c
    @NotNull
    public AbsMsgListVB.b E1() {
        return new AbsMsgListVB.b() { // from class: com.tencent.guildmedia.aio.msglist.list.GuildMediaMsgListDataVB$createFocusIndex$1
            @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB.b
            public void a(@NotNull MsgListState state, @NotNull IListUIOperationApi helper) {
                com.tencent.guild.aio.factory.business.holder.msglist.scrollers.b bVar;
                IListUIOperationApi iListUIOperationApi;
                Intrinsics.checkNotNullParameter(state, "state");
                Intrinsics.checkNotNullParameter(helper, "helper");
                com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar2 = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
                if (bVar2.j(state.getExtra())) {
                    boolean m3 = bVar2.m(state, helper);
                    QLog.i("GuildMediaMsgListDataVB", 1, "processFocusIndex, FOCUS_BOTTOM state.size = " + state.size() + ", needHandle: " + m3);
                    if (m3) {
                        bVar = GuildMediaMsgListDataVB.this.focusBottomHandler;
                        bVar.i(state, helper);
                        iListUIOperationApi = GuildMediaMsgListDataVB.this.uiHelper;
                        if (iListUIOperationApi == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("uiHelper");
                            iListUIOperationApi = null;
                        }
                        iListUIOperationApi.i().getLayoutManager().requestSimpleAnimationsInNextLayout();
                        return;
                    }
                    return;
                }
                if (bVar2.k(state.getExtra())) {
                    QLog.i("GuildMediaMsgListDataVB", 1, "processFocusIndex, FOCUS_HEAD state.size = " + state.size());
                    a.C11562a.a(helper, 0, false, null, 6, null);
                    return;
                }
                if (bVar2.l(state.getExtra())) {
                    final GuildMediaMsgListDataVB guildMediaMsgListDataVB = GuildMediaMsgListDataVB.this;
                    bVar2.i(state, helper, "GuildMediaMsgListDataVB", new Function1<at.b, Unit>() { // from class: com.tencent.guildmedia.aio.msglist.list.GuildMediaMsgListDataVB$createFocusIndex$1$processFocusIndex$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(at.b bVar3) {
                            invoke2(bVar3);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull at.b intent) {
                            Intrinsics.checkNotNullParameter(intent, "intent");
                            GuildMediaMsgListDataVB.this.sendIntent(intent);
                        }
                    });
                }
            }
        };
    }

    @Override // com.tencent.aio.api.list.j
    @NotNull
    public com.tencent.aio.base.mvvm.b<at.b, MsgListUiState> F0() {
        return new GuildMediaMsgListDataVM();
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, com.tencent.aio.api.list.j
    public void S0() {
        super.S0();
        sendIntent(a.t.f110488d);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, com.tencent.aio.api.list.j
    @NotNull
    public View T0(@NotNull com.tencent.mvi.api.help.a createViewParams, @NotNull View childView, @NotNull IListUIOperationApi uiHelper) {
        View view;
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(uiHelper, "uiHelper");
        super.T0(createViewParams, childView, uiHelper);
        this.uiHelper = uiHelper;
        AIORecycleView i3 = uiHelper.i();
        ViewGroup.LayoutParams layoutParams = i3.getLayoutParams();
        layoutParams.height = -2;
        i3.setLayoutParams(layoutParams);
        GuildMediaMsgListFrameLayout guildMediaMsgListFrameLayout = new GuildMediaMsgListFrameLayout(createViewParams.a(), null, 0, 6, null);
        guildMediaMsgListFrameLayout.a(this.aioListener);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.rightMargin = (int) getMContext().getResources().getDimension(R.dimen.cg9);
        Unit unit = Unit.INSTANCE;
        guildMediaMsgListFrameLayout.addView(childView, layoutParams2);
        guildMediaMsgListFrameLayout.setPositionAndDrawSize(1, X);
        guildMediaMsgListFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        N1(uiHelper);
        this.highLightViewHolderApi = new bq0.b(uiHelper);
        M1(i3);
        et0.a aVar = this.aioListener;
        if (aVar != null) {
            view = aVar.g4(guildMediaMsgListFrameLayout);
        } else {
            view = null;
        }
        if (view != null) {
            return view;
        }
        return guildMediaMsgListFrameLayout;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.api.ability.c
    @NotNull
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
        View view;
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        IListUIOperationApi iListUIOperationApi = null;
        RecyclerView.ViewHolder viewHolder = null;
        if (stateCmd instanceof k.b) {
            try {
                IListUIOperationApi iListUIOperationApi2 = this.listUIOperationApi;
                if (iListUIOperationApi2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
                    iListUIOperationApi2 = null;
                }
                viewHolder = iListUIOperationApi2.G(((k.b) stateCmd).getDisplayListIndex());
            } catch (Exception e16) {
                GuildMediaLogUtil.INSTANCE.b("GuildMediaMsgListDataVB", "[generateVBState] GetMsgHolderRectF e:" + e16);
            }
            Bundle bundle = new Bundle();
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                bundle.putInt("left", iArr[0]);
                bundle.putInt("right", iArr[0] + view.getWidth());
                bundle.putInt("top", iArr[1]);
                bundle.putInt("bottom", iArr[1] + view.getHeight());
            }
            return bundle;
        }
        if (stateCmd instanceof b.a) {
            com.tencent.guild.aio.factory.business.holder.msglist.scrollers.b bVar = this.focusBottomHandler;
            IListUIOperationApi iListUIOperationApi3 = this.uiHelper;
            if (iListUIOperationApi3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiHelper");
            } else {
                iListUIOperationApi = iListUIOperationApi3;
            }
            boolean h16 = bVar.h(iListUIOperationApi, 2);
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("GuildMediaMsgListDataVB", "[generateVBState] isBottomRange:" + h16);
            }
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("is_bottom_range", h16);
            return bundle2;
        }
        return new Bundle();
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, com.tencent.aio.api.list.j
    public void u0(@NotNull MsgListUiState state, @NotNull IListUIOperationApi uiHelper) {
        et0.a aVar;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(uiHelper, "uiHelper");
        if (state instanceof GuildMsgListDataState) {
            P1((GuildMsgListDataState) state, uiHelper);
            return;
        }
        if (state instanceof GuildMediaRefreshUIState.PanelVisibleChange) {
            this.panelOrKeyboardShow = ((GuildMediaRefreshUIState.PanelVisibleChange) state).getShow();
            return;
        }
        if (state instanceof GuildMediaRefreshUIState.NotifyMsgList) {
            S1();
            return;
        }
        if (state instanceof GuildMsgListViewState.GuildInputBarHeightChangeDataState) {
            R1(((GuildMsgListViewState.GuildInputBarHeightChangeDataState) state).getHeight());
            return;
        }
        if (state instanceof HighLightViewHolderUIState) {
            Q1((HighLightViewHolderUIState) state);
        } else if ((state instanceof GuildMsgListViewState.GuildInitFirstMsgSeq) && (aVar = this.aioListener) != null) {
            aVar.E2(((GuildMsgListViewState.GuildInitFirstMsgSeq) state).getSeq());
        }
    }
}
