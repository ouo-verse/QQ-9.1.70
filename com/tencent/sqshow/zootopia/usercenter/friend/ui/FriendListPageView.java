package com.tencent.sqshow.zootopia.usercenter.friend.ui;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.usercenter.friend.data.FollowStateChangedEvent;
import com.tencent.sqshow.zootopia.view.pull2refresh.RecyclerViewWithHeaderFooterFix;
import com.tencent.sqshow.zootopia.view.pull2refresh.XPullToRefreshView;
import com.tencent.sqshow.zootopia.view.pull2refresh.ZootopiaPullRefreshLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import su4.f;
import su4.i;
import tl.h;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 F2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001GB\u0011\b\u0016\u0012\u0006\u0010@\u001a\u00020?\u00a2\u0006\u0004\bA\u0010BB\u001b\b\u0016\u0012\u0006\u0010@\u001a\u00020?\u0012\b\u0010D\u001a\u0004\u0018\u00010C\u00a2\u0006\u0004\bA\u0010EJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u001e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011J\u0016\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bJ,\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u000b2\u001c\b\u0002\u0010\u001b\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0018J\b\u0010\u001d\u001a\u00020\u0005H\u0014J\b\u0010\u001e\u001a\u00020\u0005H\u0014J\u001a\u0010\"\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\u000bH\u0016J\u001a\u0010$\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010#\u001a\u00020\u000fH\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\u0012\u0010'\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010\u0004H\u0016J\u0016\u0010*\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040)\u0018\u00010(H\u0016R\u0018\u0010-\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010/R\u0018\u00103\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u00102R\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006H"}, d2 = {"Lcom/tencent/sqshow/zootopia/usercenter/friend/ui/FriendListPageView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/XPullToRefreshView$c;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "i", "e", "d", "Lsu4/i;", "newRelationInfo", "", "f", "", "uin", "", "tabType", "", "name", "setParam", "Lsu4/d;", "result", "isRefresh", "c", "Lkotlin/Function1;", "", "Lsu4/f;", "callback", "g", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/sqshow/zootopia/view/pull2refresh/XPullToRefreshView;", "recyclerView", "isMachineRefresh", "xe", "reqType", "J3", "endOfRefresh", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/sqshow/zootopia/usercenter/friend/ui/ZPlanUserCenterEmptyView;", "Lcom/tencent/sqshow/zootopia/usercenter/friend/ui/ZPlanUserCenterEmptyView;", "emptyView", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/ZootopiaPullRefreshLayout;", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/ZootopiaPullRefreshLayout;", "refreshView", "Lcom/tencent/sqshow/zootopia/usercenter/friend/ui/b;", "Lcom/tencent/sqshow/zootopia/usercenter/friend/ui/b;", "adapter", h.F, "I", "b", "()I", "setTabType", "(I)V", "J", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "[B", "lastPageInfo", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class FriendListPageView extends RelativeLayout implements XPullToRefreshView.c, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ZPlanUserCenterEmptyView emptyView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ZootopiaPullRefreshLayout refreshView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.sqshow.zootopia.usercenter.friend.ui.b adapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int tabType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long uin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private byte[] lastPageInfo;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/usercenter/friend/ui/FriendListPageView$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lsu4/d;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements e<su4.d> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f373136e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function1<f[], Unit> f373137f;

        /* JADX WARN: Multi-variable type inference failed */
        b(boolean z16, Function1<? super f[], Unit> function1) {
            this.f373136e = z16;
            this.f373137f = function1;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(su4.d result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("FriendListPageView", 1, "pullFriendListByType success :: result size == " + result.f434776a.length);
            FriendListPageView.this.c(result, this.f373136e);
            Function1<f[], Unit> function1 = this.f373137f;
            if (function1 != null) {
                f[] fVarArr = result.f434777b;
                Intrinsics.checkNotNullExpressionValue(fVarArr, "result.relationPageInfoList");
                function1.invoke(fVarArr);
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("FriendListPageView", 1, "pullFriendListByType failed :: error == " + error + " , $ message ==" + message);
            FriendListPageView.this.d();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendListPageView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.dh8, this);
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        ZPlanUserCenterEmptyView zPlanUserCenterEmptyView = this.emptyView;
        if (zPlanUserCenterEmptyView != null) {
            zPlanUserCenterEmptyView.setVisibility(8);
        }
        ZootopiaPullRefreshLayout zootopiaPullRefreshLayout = this.refreshView;
        if (zootopiaPullRefreshLayout == null) {
            return;
        }
        zootopiaPullRefreshLayout.setVisibility(0);
    }

    private final boolean f(i newRelationInfo) {
        List<i> A;
        com.tencent.sqshow.zootopia.usercenter.friend.ui.b bVar = this.adapter;
        if (bVar == null || (A = bVar.A()) == null) {
            return false;
        }
        Iterator<T> it = A.iterator();
        while (it.hasNext()) {
            if (((i) it.next()).f434792a == newRelationInfo.f434792a) {
                return true;
            }
        }
        return false;
    }

    private final void i() {
        ZPlanUserCenterEmptyView zPlanUserCenterEmptyView = this.emptyView;
        if (zPlanUserCenterEmptyView != null) {
            zPlanUserCenterEmptyView.setVisibility(0);
        }
        ZPlanUserCenterEmptyView zPlanUserCenterEmptyView2 = this.emptyView;
        if (zPlanUserCenterEmptyView2 != null) {
            zPlanUserCenterEmptyView2.setText(lc4.a.f414373a.c(this.uin, this.tabType));
        }
        ZootopiaPullRefreshLayout zootopiaPullRefreshLayout = this.refreshView;
        if (zootopiaPullRefreshLayout == null) {
            return;
        }
        zootopiaPullRefreshLayout.setVisibility(8);
    }

    /* renamed from: b, reason: from getter */
    public final int getTabType() {
        return this.tabType;
    }

    public final void c(su4.d result, boolean isRefresh) {
        List mutableList;
        List<i> mutableList2;
        List<i> mutableList3;
        Intrinsics.checkNotNullParameter(result, "result");
        i[] iVarArr = result.f434776a;
        Intrinsics.checkNotNullExpressionValue(iVarArr, "result.userRelationInfoList");
        mutableList = ArraysKt___ArraysKt.toMutableList(iVarArr);
        if (mutableList.isEmpty()) {
            i();
            return;
        }
        d();
        int i3 = result.f434781f;
        if (isRefresh) {
            com.tencent.sqshow.zootopia.usercenter.friend.ui.b bVar = this.adapter;
            if (bVar != null) {
                mutableList3 = CollectionsKt___CollectionsKt.toMutableList((Collection) mutableList);
                bVar.I(mutableList3, i3);
            }
        } else {
            com.tencent.sqshow.zootopia.usercenter.friend.ui.b bVar2 = this.adapter;
            if (bVar2 != null) {
                mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) mutableList);
                bVar2.u(mutableList2, i3);
            }
        }
        QLog.d("FriendListPageView", 1, "new fans " + result.f434781f);
        ZootopiaPullRefreshLayout zootopiaPullRefreshLayout = this.refreshView;
        if (zootopiaPullRefreshLayout != null) {
            zootopiaPullRefreshLayout.F(true, result.f434779d);
        }
        this.lastPageInfo = result.f434778c;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(FollowStateChangedEvent.class);
        return arrayList;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        List<i> A;
        ZootopiaPullRefreshLayout zootopiaPullRefreshLayout;
        List<i> A2;
        if (event instanceof FollowStateChangedEvent) {
            boolean z16 = false;
            if (this.tabType == 1) {
                FollowStateChangedEvent followStateChangedEvent = (FollowStateChangedEvent) event;
                if ((followStateChangedEvent.getRelationInfo().f434796e == 1 || followStateChangedEvent.getRelationInfo().f434796e == 3) && !f(followStateChangedEvent.getRelationInfo())) {
                    com.tencent.sqshow.zootopia.usercenter.friend.ui.b bVar = this.adapter;
                    if (((bVar == null || (A2 = bVar.A()) == null || !A2.isEmpty()) ? false : true) && (zootopiaPullRefreshLayout = this.refreshView) != null) {
                        zootopiaPullRefreshLayout.F(true, false);
                    }
                    com.tencent.sqshow.zootopia.usercenter.friend.ui.b bVar2 = this.adapter;
                    if (bVar2 != null) {
                        bVar2.v(followStateChangedEvent.getRelationInfo());
                    }
                    ZootopiaPullRefreshLayout zootopiaPullRefreshLayout2 = this.refreshView;
                    if (zootopiaPullRefreshLayout2 != null) {
                        zootopiaPullRefreshLayout2.I();
                    }
                }
            }
            com.tencent.sqshow.zootopia.usercenter.friend.ui.b bVar3 = this.adapter;
            if (bVar3 != null) {
                bVar3.K(((FollowStateChangedEvent) event).getRelationInfo());
            }
            com.tencent.sqshow.zootopia.usercenter.friend.ui.b bVar4 = this.adapter;
            if (bVar4 != null && (A = bVar4.A()) != null && A.isEmpty()) {
                z16 = true;
            }
            if (z16) {
                i();
            } else {
                d();
            }
        }
    }

    public final void setParam(long uin, int tabType, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.uin = uin;
        this.tabType = tabType;
        com.tencent.sqshow.zootopia.usercenter.friend.ui.b bVar = this.adapter;
        if (bVar != null) {
            bVar.J(tabType, name);
        }
    }

    public final void setTabType(int i3) {
        this.tabType = i3;
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.XPullToRefreshView.c
    public void J3(XPullToRefreshView recyclerView, int reqType) {
        QLog.i("FriendListPageView", 1, "startLoadMore");
        h(this, false, null, 2, null);
    }

    private final void e() {
        this.refreshView = (ZootopiaPullRefreshLayout) findViewById(R.id.f163578qw1);
        this.emptyView = (ZPlanUserCenterEmptyView) findViewById(R.id.qvy);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.adapter = new com.tencent.sqshow.zootopia.usercenter.friend.ui.b(context);
        ZootopiaPullRefreshLayout zootopiaPullRefreshLayout = this.refreshView;
        RecyclerViewWithHeaderFooterFix E = zootopiaPullRefreshLayout != null ? zootopiaPullRefreshLayout.E() : null;
        if (E != null) {
            E.setAdapter(this.adapter);
        }
        ZootopiaPullRefreshLayout zootopiaPullRefreshLayout2 = this.refreshView;
        RecyclerViewWithHeaderFooterFix E2 = zootopiaPullRefreshLayout2 != null ? zootopiaPullRefreshLayout2.E() : null;
        if (E2 != null) {
            E2.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        ZootopiaPullRefreshLayout zootopiaPullRefreshLayout3 = this.refreshView;
        if (zootopiaPullRefreshLayout3 != null) {
            zootopiaPullRefreshLayout3.setRefreshEnable(false);
        }
        ZootopiaPullRefreshLayout zootopiaPullRefreshLayout4 = this.refreshView;
        if (zootopiaPullRefreshLayout4 != null) {
            zootopiaPullRefreshLayout4.setRefreshCallback(this);
        }
    }

    public final void g(boolean isRefresh, Function1<? super f[], Unit> callback) {
        if (isRefresh) {
            this.lastPageInfo = null;
        }
        lc4.a.f414373a.d(this.uin, this.tabType, this.lastPageInfo, new b(isRefresh, callback));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendListPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.dh8, this);
        e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void h(FriendListPageView friendListPageView, boolean z16, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = null;
        }
        friendListPageView.g(z16, function1);
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.XPullToRefreshView.c
    public void endOfRefresh() {
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.XPullToRefreshView.c
    public void xe(XPullToRefreshView recyclerView, boolean isMachineRefresh) {
    }
}
