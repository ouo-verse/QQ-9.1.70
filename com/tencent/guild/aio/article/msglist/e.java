package com.tencent.guild.aio.article.msglist;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.AIOLayoutManager;
import androidx.recyclerview.widget.AIORecycleView;
import androidx.recyclerview.widget.OnAIOTouchListener;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aio.api.list.IBounceScrollApi;
import com.tencent.aio.api.list.IListUIOperationApi;
import com.tencent.aio.api.list.IScreenRenderingApi;
import com.tencent.aio.api.refreshLoad.c;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.intent.a;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.state.MsgListState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB;
import com.tencent.guild.aio.article.msglist.GuildArticleMsgListDataUIState;
import com.tencent.guild.aio.article.msglist.f;
import com.tencent.guild.aio.article.msglist.i;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListDataState;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListViewState;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.guild.aio.msglist.highlight.HighLightViewHolderUIState;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 T2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001UB\u0007\u00a2\u0006\u0004\bR\u0010SJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0002J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0018\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0013H\u0002J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020!H\u0002J \u0010'\u001a\u00020%2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010(\u001a\u00020\u0007H\u0016J\u0012\u0010+\u001a\u0004\u0018\u00010\u000f2\u0006\u0010*\u001a\u00020)H\u0016J\u0014\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030,H\u0016J\u0016\u00100\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030/0.H\u0016J\u0018\u00101\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u00103\u001a\u000202H\u0016R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00106R\u0016\u0010<\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010;R\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010P\u00a8\u0006V"}, d2 = {"Lcom/tencent/guild/aio/article/msglist/e;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/c;", "Lat/b;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "Lcom/tencent/aio/api/list/IScreenRenderingApi;", "", HippyTKDListViewAdapter.SCROLL_STATE, "", "e2", "", "springBackDistance", "f2", "d2", "g2", "index", "Landroid/os/Bundle;", "U1", "T1", "height", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "uiHelper", "Y1", ICustomDataEditor.STRING_ARRAY_PARAM_2, com.tencent.luggage.wxa.c8.c.G, "V1", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataState;", "state", "W1", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/state/MsgListState;", "helper", "Z1", "Lcom/tencent/guild/aio/msglist/highlight/HighLightViewHolderUIState;", "X1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "S1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "childView", "T0", "S0", "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "generateVBState", "Lcom/tencent/aio/base/mvvm/b;", "F0", "", "Ljava/lang/Class;", "getObserverStates", "u0", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/AbsMsgListVB$b;", "E1", "", "M", "Z", "couldTrigerDismissPanel", "N", "couldTriggerShowKeyboard", "P", "I", "bottomMargin", "Landroidx/recyclerview/widget/AIORecycleView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroidx/recyclerview/widget/AIORecycleView;", "mRecyclerView", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/aio/api/list/IListUIOperationApi;", "listUIOperationApi", "Lbq0/f;", ExifInterface.LATITUDE_SOUTH, "Lbq0/f;", "mHighLightViewHolderApi", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;", "T", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;", "mItemAnimator", "U", "mFirstPageAnimState", "Lcom/tencent/guild/aio/factory/business/holder/msglist/scrollers/b;", "V", "Lcom/tencent/guild/aio/factory/business/holder/msglist/scrollers/b;", "mFocusBottomHandler", "<init>", "()V", "W", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class e extends com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c<at.b, MsgListUiState> implements IScreenRenderingApi {

    /* renamed from: P, reason: from kotlin metadata */
    private int bottomMargin;

    /* renamed from: Q, reason: from kotlin metadata */
    private AIORecycleView mRecyclerView;

    /* renamed from: R, reason: from kotlin metadata */
    private IListUIOperationApi listUIOperationApi;

    /* renamed from: S, reason: from kotlin metadata */
    private bq0.f mHighLightViewHolderApi;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private RecyclerView.ItemAnimator mItemAnimator;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean couldTrigerDismissPanel = true;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean couldTriggerShowKeyboard = true;

    /* renamed from: U, reason: from kotlin metadata */
    private int mFirstPageAnimState = 1;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.guild.aio.factory.business.holder.msglist.scrollers.b mFocusBottomHandler = new com.tencent.guild.aio.factory.business.holder.msglist.scrollers.b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/guild/aio/article/msglist/e$b", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/AbsMsgListVB$b;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/state/MsgListState;", "state", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "helper", "", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements AbsMsgListVB.b {
        b() {
        }

        @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB.b
        public void a(@NotNull MsgListState state, @NotNull IListUIOperationApi helper) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(helper, "helper");
            com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
            if (bVar.j(state.getExtra())) {
                boolean m3 = bVar.m(state, helper);
                QLog.i("GuildMsgListDataVB", 1, "processFocusIndex, FOCUS_BOTTOM state.size = " + state.size() + ", needHandle: " + m3);
                if (m3) {
                    e.this.mFocusBottomHandler.i(state, helper);
                    return;
                }
                return;
            }
            if (bVar.k(state.getExtra())) {
                QLog.i("GuildMsgListDataVB", 1, "processFocusIndex, FOCUS_HEAD state.size = " + state.size());
                a.C11562a.a(helper, 0, false, null, 6, null);
                return;
            }
            if (bVar.l(state.getExtra())) {
                e.this.Z1(state, helper);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/article/msglist/e$c", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onSingleTapUp", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c extends GestureDetector.SimpleOnGestureListener {
        c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(@Nullable MotionEvent e16) {
            e.this.sendIntent(a.C1186a.f110458d);
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/article/msglist/e$d", "Lxs/a$b;", "Landroid/view/View;", "targetView", "", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class d implements a.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f109946a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f109947b;

        d(int i3, e eVar) {
            this.f109946a = i3;
            this.f109947b = eVar;
        }

        @Override // xs.a.b
        public void b(@Nullable View targetView) {
            if (this.f109946a < 0) {
                return;
            }
            if (targetView == null) {
                QLog.i("GuildMsgListDataVB", 1, "handleNavigation, onScrollComplete targetView is null.");
            }
            this.f109947b.sendIntent(new bq0.c(this.f109946a, targetView));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/guild/aio/article/msglist/e$e", "Lcom/tencent/aio/api/refreshLoad/c$b;", "", ReportConstant.COSTREPORT_PREFIX, HippyScrollViewEventHelper.EVENT_TYPE_REFRESH, "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.article.msglist.e$e, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1175e implements c.b {
        C1175e() {
        }

        @Override // com.tencent.aio.api.refreshLoad.c.b
        public void onRefresh() {
            QLog.i("GuildMsgListDataVB", 1, HippyScrollViewEventHelper.EVENT_TYPE_REFRESH);
            e.this.sendIntent(new a.c("GuildMsgListDataVB"));
        }

        @Override // com.tencent.aio.api.refreshLoad.c.b
        public void s() {
            QLog.i("GuildMsgListDataVB", 1, "onLoadMore");
            e.this.sendIntent(new a.C0640a("GuildMsgListDataVB"));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/guild/aio/article/msglist/e$f", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "newState", "onScrollStateChanged", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class f extends RecyclerView.OnScrollListener {
        f() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                e.this.couldTrigerDismissPanel = true;
                e.this.couldTriggerShowKeyboard = true;
                e.this.e2(newState);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (recyclerView.getScrollState() == 1 && e.this.couldTrigerDismissPanel) {
                e.this.couldTrigerDismissPanel = false;
                e.this.sendIntent(a.C1186a.f110458d);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/guild/aio/article/msglist/e$g", "Lcom/tencent/aio/api/list/IBounceScrollApi$b;", "", "moveType", "moveDistance", "", "totalDistance", "", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class g implements IBounceScrollApi.b {
        g() {
        }

        @Override // com.tencent.aio.api.list.IBounceScrollApi.b
        public void a(int moveType, int moveDistance, float totalDistance) {
            if (moveType == 1 && moveDistance < 0 && Math.abs(totalDistance) > 400.0f && e.this.couldTriggerShowKeyboard) {
                QLog.i("GuildMsgListDataVB", 1, "onBounceLayoutMove, showKeyBoard, moveDistance = " + moveDistance + ", totalDistance = " + totalDistance);
                e.this.sendIntent(a.l.f110477d);
                e.this.couldTriggerShowKeyboard = false;
                e.this.couldTrigerDismissPanel = false;
            } else if (moveType == 1 && moveDistance > 0 && e.this.couldTrigerDismissPanel) {
                QLog.i("GuildMsgListDataVB", 1, "onBounceLayoutMove, hideKeyBoard moveDistance = " + moveDistance + ", totalDistance = " + totalDistance);
                e.this.sendIntent(a.C1186a.f110458d);
                e.this.couldTrigerDismissPanel = false;
            }
            if (moveType == 1 && totalDistance <= 0.0f) {
                e.this.f2(0.0f);
            } else if (moveType == 0 && totalDistance <= 0.0f) {
                e.this.f2(totalDistance);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/guild/aio/article/msglist/e$h", "Lcom/tencent/aio/api/list/l;", "", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class h implements com.tencent.aio.api.list.l {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IListUIOperationApi f109952b;

        h(IListUIOperationApi iListUIOperationApi) {
            this.f109952b = iListUIOperationApi;
        }

        @Override // com.tencent.aio.api.list.l
        public void a() {
            QLog.i("GuildMsgListDataVB", 1, "afterListRender");
            e.this.g2();
            this.f109952b.J0(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/guild/aio/article/msglist/e$i", "Landroidx/recyclerview/widget/OnAIOTouchListener;", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", "onTouch", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class i implements OnAIOTouchListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GestureDetector f109954e;

        i(GestureDetector gestureDetector) {
            this.f109954e = gestureDetector;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@Nullable View v3, @Nullable MotionEvent event) {
            if (e.this.mFirstPageAnimState != 3) {
                return true;
            }
            return this.f109954e.onTouchEvent(event);
        }
    }

    private final GestureDetector.SimpleOnGestureListener S1() {
        return new c();
    }

    private final Bundle T1() {
        Bundle bundle = new Bundle();
        AIORecycleView aIORecycleView = this.mRecyclerView;
        AIORecycleView aIORecycleView2 = null;
        if (aIORecycleView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            aIORecycleView = null;
        }
        bundle.putBoolean("guild_article_can_scroll_vertically_up", aIORecycleView.canScrollVertically(-1));
        AIORecycleView aIORecycleView3 = this.mRecyclerView;
        if (aIORecycleView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        } else {
            aIORecycleView2 = aIORecycleView3;
        }
        bundle.putBoolean("guild_article_can_scroll_vertically_down", aIORecycleView2.canScrollVertically(1));
        return bundle;
    }

    private final Bundle U1(int index, int springBackDistance) {
        int i3;
        int i16;
        View view;
        AIORecycleView aIORecycleView = this.mRecyclerView;
        IListUIOperationApi iListUIOperationApi = null;
        if (aIORecycleView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            aIORecycleView = null;
        }
        aIORecycleView.getLayoutManager().findFirstVisibleItemPosition();
        IListUIOperationApi iListUIOperationApi2 = this.listUIOperationApi;
        if (iListUIOperationApi2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
        } else {
            iListUIOperationApi = iListUIOperationApi2;
        }
        RecyclerView.ViewHolder G = iListUIOperationApi.G(index);
        if (G != null && (view = G.itemView) != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            i3 = iArr[1] - springBackDistance;
            i16 = view.getHeight() + i3;
        } else {
            i3 = Integer.MAX_VALUE;
            i16 = Integer.MAX_VALUE;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("guild_article_main_msg_is_showing", true);
        bundle.putInt("guild_article_main_msg_top_screen_position", i3);
        bundle.putInt("guild_article_main_msg_bottom_screen_position", i16);
        return bundle;
    }

    private final void V1(int pos) {
        if (pos >= 0) {
            IListUIOperationApi iListUIOperationApi = this.listUIOperationApi;
            if (iListUIOperationApi == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
                iListUIOperationApi = null;
            }
            iListUIOperationApi.d(pos, 1);
        }
    }

    private final void W1(GuildMsgListDataState state) {
        QLog.i("GuildMsgListDataVB", 1, "handleGuildMsgListDataState, state = " + state.getForceUpdate() + ", size = " + state.size());
        IListUIOperationApi iListUIOperationApi = null;
        if (state.getForceUpdate()) {
            IListUIOperationApi iListUIOperationApi2 = this.listUIOperationApi;
            if (iListUIOperationApi2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
            } else {
                iListUIOperationApi = iListUIOperationApi2;
            }
            RecyclerView.Adapter adapter = iListUIOperationApi.i().getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
                return;
            }
            return;
        }
        IListUIOperationApi iListUIOperationApi3 = this.listUIOperationApi;
        if (iListUIOperationApi3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
        } else {
            iListUIOperationApi = iListUIOperationApi3;
        }
        super.u0(state, iListUIOperationApi);
    }

    private final void X1(HighLightViewHolderUIState state) {
        bq0.f fVar = this.mHighLightViewHolderApi;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHighLightViewHolderApi");
            fVar = null;
        }
        fVar.b(state.getPosition(), state.getMsgRecord(), state.getParserId(), state.getExtra(), state.getItemView());
    }

    private final void Y1(int height, IListUIOperationApi uiHelper) {
        QLog.i("GuildMsgListDataVB", 1, "handleInputBarHeightChange, height = " + height + " host " + getHostView());
        if (this.bottomMargin != height) {
            this.bottomMargin = height;
            ViewGroup.LayoutParams layoutParams = getHostView().getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.bottomMargin;
            getHostView().requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z1(MsgListState state, IListUIOperationApi helper) {
        int i3;
        boolean z16;
        boolean z17;
        long g16 = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a.g(state.getExtra());
        Iterator<com.tencent.aio.data.msglist.a> it = state.iterator();
        int i16 = 0;
        while (true) {
            i3 = -1;
            if (it.hasNext()) {
                if (it.next().getMsgSeq() == g16) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    break;
                } else {
                    i16++;
                }
            } else {
                i16 = -1;
                break;
            }
        }
        Iterator<com.tencent.aio.data.msglist.a> it5 = state.iterator();
        int i17 = 0;
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            com.tencent.aio.data.msglist.a next = it5.next();
            if (next.getMsgSeq() == g16 && next.getMsgId() != 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                i3 = i17;
                break;
            }
            i17++;
        }
        QLog.i("GuildMsgListDataVB", 1, "processFocusIndex, FOCUS msgSeq: " + g16 + " state.size = " + state.size() + ", findIndex=" + i16);
        if (i16 < 0) {
            return;
        }
        a.C11562a.a(helper, i16, false, new d(i3, this), 2, null);
    }

    private final void a2() {
        AIORecycleView aIORecycleView = this.mRecyclerView;
        if (aIORecycleView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            aIORecycleView = null;
        }
        aIORecycleView.postDelayed(new Runnable() { // from class: com.tencent.guild.aio.article.msglist.c
            @Override // java.lang.Runnable
            public final void run() {
                e.c2(e.this);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c2(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IListUIOperationApi iListUIOperationApi = this$0.listUIOperationApi;
        if (iListUIOperationApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
            iListUIOperationApi = null;
        }
        this$0.e2(iListUIOperationApi.i().getScrollState());
    }

    private final void d2() {
        AIORecycleView aIORecycleView = this.mRecyclerView;
        IListUIOperationApi iListUIOperationApi = null;
        if (aIORecycleView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            aIORecycleView = null;
        }
        aIORecycleView.setItemAnimator(this.mItemAnimator);
        this.mFirstPageAnimState = 3;
        IListUIOperationApi iListUIOperationApi2 = this.listUIOperationApi;
        if (iListUIOperationApi2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
        } else {
            iListUIOperationApi = iListUIOperationApi2;
        }
        iListUIOperationApi.H(true);
        sendIntent(new f.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e2(int scrollState) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void f2(float springBackDistance) {
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
            sendIntent(new f.GuildArticleSpringBackIntent(springBackDistance, i3, findLastVisibleItemPosition, aVar, aVar2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g2() {
        if (this.mFirstPageAnimState == 1) {
            this.mFirstPageAnimState = 2;
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.guild.aio.article.msglist.b
                @Override // java.lang.Runnable
                public final void run() {
                    e.h2(e.this);
                }
            }, 50L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h2(final e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AIORecycleView aIORecycleView = this$0.mRecyclerView;
        if (aIORecycleView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            aIORecycleView = null;
        }
        if (aIORecycleView.getChildCount() <= 0) {
            aIORecycleView.setAlpha(1.0f);
            this$0.d2();
            return;
        }
        int childCount = aIORecycleView.getChildCount();
        int i3 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = aIORecycleView.getChildAt(i16);
            if (childAt != null) {
                childAt.setAlpha(0.0f);
            }
        }
        aIORecycleView.setAlpha(1.0f);
        a aVar = new a(0.0f, 0.79f, 0.16f, 1.0f);
        while (i3 < aIORecycleView.getChildCount() - 1) {
            View childAt2 = aIORecycleView.getChildAt(i3);
            if (childAt2 != null) {
                float f16 = (i3 * 10.0f) + 512.0f;
                childAt2.setTranslationY(f16);
                childAt2.animate().translationYBy(-f16).alphaBy(1.0f).setInterpolator(aVar).setDuration((i3 * 40) + 450).start();
            }
            i3++;
        }
        View childAt3 = aIORecycleView.getChildAt(i3);
        if (childAt3 != null) {
            float f17 = (i3 * 10.0f) + 512.0f;
            childAt3.setTranslationY(f17);
            childAt3.animate().translationYBy(-f17).alphaBy(1.0f).setInterpolator(aVar).setDuration((i3 * 40) + 450).withEndAction(new Runnable() { // from class: com.tencent.guild.aio.article.msglist.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.i2(e.this);
                }
            }).start();
            return;
        }
        this$0.d2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i2(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.d2();
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c
    @NotNull
    public AbsMsgListVB.b E1() {
        return new b();
    }

    @Override // com.tencent.aio.api.list.j
    @NotNull
    public com.tencent.aio.base.mvvm.b<at.b, MsgListUiState> F0() {
        return new GuildArticleMsgListDataVM();
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, com.tencent.aio.api.list.j
    public void S0() {
        super.S0();
        sendIntent(new a.b("from_first_screen"));
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, com.tencent.aio.api.list.j
    @NotNull
    public View T0(@NotNull com.tencent.mvi.api.help.a createViewParams, @NotNull View childView, @NotNull IListUIOperationApi uiHelper) {
        IListUIOperationApi iListUIOperationApi;
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(uiHelper, "uiHelper");
        this.listUIOperationApi = uiHelper;
        IListUIOperationApi iListUIOperationApi2 = null;
        if (uiHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
            iListUIOperationApi = null;
        } else {
            iListUIOperationApi = uiHelper;
        }
        iListUIOperationApi.i().setItemAnimator(null);
        IListUIOperationApi iListUIOperationApi3 = this.listUIOperationApi;
        if (iListUIOperationApi3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
            iListUIOperationApi3 = null;
        }
        this.mItemAnimator = iListUIOperationApi3.i().getItemAnimator();
        IListUIOperationApi iListUIOperationApi4 = this.listUIOperationApi;
        if (iListUIOperationApi4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
            iListUIOperationApi4 = null;
        }
        iListUIOperationApi4.i().setItemAnimator(null);
        IListUIOperationApi iListUIOperationApi5 = this.listUIOperationApi;
        if (iListUIOperationApi5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
            iListUIOperationApi5 = null;
        }
        iListUIOperationApi5.l(new C1175e());
        uiHelper.i().setAlpha(0.0f);
        uiHelper.i().addOnScrollListener(new f());
        IListUIOperationApi iListUIOperationApi6 = this.listUIOperationApi;
        if (iListUIOperationApi6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
            iListUIOperationApi6 = null;
        }
        iListUIOperationApi6.C(new g());
        uiHelper.s(new h(uiHelper));
        uiHelper.i().setPadding(uiHelper.i().getPaddingLeft(), uiHelper.i().getPaddingTop(), uiHelper.i().getPaddingRight(), createViewParams.a().getResources().getDimensionPixelSize(R.dimen.cha));
        uiHelper.i().setClipToPadding(false);
        uiHelper.i().addOnTouchListener(new i(new GestureDetector(getMContext(), S1())));
        IListUIOperationApi iListUIOperationApi7 = this.listUIOperationApi;
        if (iListUIOperationApi7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
        } else {
            iListUIOperationApi2 = iListUIOperationApi7;
        }
        iListUIOperationApi2.H(false);
        this.mRecyclerView = uiHelper.i();
        this.mHighLightViewHolderApi = new bq0.b(uiHelper);
        return super.T0(createViewParams, childView, uiHelper);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.api.ability.c
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        if (stateCmd instanceof i.b) {
            i.b bVar = (i.b) stateCmd;
            return U1(bVar.getIndex(), bVar.getSpringBackDistance());
        }
        if (stateCmd instanceof i.a) {
            return T1();
        }
        return new Bundle();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends MsgListUiState>> getObserverStates() {
        List<Class<? extends MsgListUiState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{HighLightViewHolderUIState.class, GuildArticleMsgListDataUIState.FirstPageMsgInitCompletedState.class, GuildMsgListViewState.GuildMsgItemChangedState.class, GuildMsgListViewState.GuildInputBarHeightChangeDataState.class, GuildArticleMsgListDataUIState.TryToPlayFirstPageAnim.class, GuildArticleMsgListDataUIState.PanelStatusChangedUIState.class});
        return listOf;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c, com.tencent.aio.api.list.j
    public void u0(@NotNull MsgListUiState state, @NotNull IListUIOperationApi uiHelper) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(uiHelper, "uiHelper");
        if (state instanceof HighLightViewHolderUIState) {
            X1((HighLightViewHolderUIState) state);
            return;
        }
        if (!(state instanceof GuildArticleMsgListDataUIState.FirstPageMsgInitCompletedState)) {
            if (state instanceof GuildArticleMsgListDataUIState.TryToPlayFirstPageAnim) {
                g2();
                return;
            }
            if (state instanceof GuildMsgListViewState.GuildMsgItemChangedState) {
                V1(((GuildMsgListViewState.GuildMsgItemChangedState) state).getPos());
                return;
            }
            if (state instanceof GuildMsgListViewState.GuildInputBarHeightChangeDataState) {
                Y1(((GuildMsgListViewState.GuildInputBarHeightChangeDataState) state).getHeight(), uiHelper);
                return;
            }
            if (state instanceof GuildArticleMsgListDataUIState.PanelStatusChangedUIState) {
                a2();
                return;
            }
            if (state instanceof GuildMsgListDataState) {
                if (this.mFirstPageAnimState != 2) {
                    W1((GuildMsgListDataState) state);
                    IListUIOperationApi iListUIOperationApi = this.listUIOperationApi;
                    if (iListUIOperationApi == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("listUIOperationApi");
                        iListUIOperationApi = null;
                    }
                    sendIntent(new f.b(iListUIOperationApi.i().getLayoutManager().findLastVisibleItemPosition()));
                    return;
                }
                return;
            }
            super.u0(state, uiHelper);
        }
    }
}
