package com.tencent.sqshow.zootopia.usercenter.view.ui;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ZootopiaDetailFeedsCardData;
import com.tencent.sqshow.zootopia.data.ZootopiaDetailFeedsListData;
import com.tencent.sqshow.zootopia.publish.event.ZPlanFeedsPublishSuccessEvent;
import com.tencent.sqshow.zootopia.recommend.main.dress.ui.ZplanBanWorkItemEvent;
import com.tencent.sqshow.zootopia.recommend.main.dress.ui.ZplanChangeShowTypeEvent;
import com.tencent.sqshow.zootopia.recommend.main.dress.ui.ZplanDeleteWorkItemEvent;
import com.tencent.sqshow.zootopia.usercenter.fragment.a;
import com.tencent.sqshow.zootopia.usercenter.friend.ui.ZPlanUserCenterEmptyView;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.view.pull2refresh.androidx.RecyclerViewXWithHeaderFooter;
import com.tencent.sqshow.zootopia.view.pull2refresh.androidx.XPullToRefreshViewV2;
import com.tencent.sqshow.zootopia.view.pull2refresh.androidx.ZootopiaPullRefreshLayoutV2;
import ic4.d;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import pu4.l;
import pu4.n;
import t74.u;
import tl.h;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 E2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001FB\u0019\b\u0007\u0012\u0006\u0010B\u001a\u00020A\u0012\u0006\u0010.\u001a\u00020)\u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\tH\u0002J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\u001a\u0010\u001d\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u001a\u0010\u001f\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001e\u001a\u00020\tH\u0016J\b\u0010 \u001a\u00020\u0005H\u0016J\u0006\u0010!\u001a\u00020\tJ\b\u0010\"\u001a\u00020\u0005H\u0014J\b\u0010#\u001a\u00020\u0005H\u0014J\u0012\u0010%\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040'0&H\u0016R\u0017\u0010.\u001a\u00020)8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u00100R\u0018\u00104\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u00106R\u0014\u00109\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u00108R\u0014\u0010:\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u00108R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006G"}, d2 = {"Lcom/tencent/sqshow/zootopia/usercenter/view/ui/UserCenterWearPageView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/androidx/XPullToRefreshViewV2$c;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", DomainData.DOMAIN_NAME, "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "fixedPos", "k", "Lpu4/n;", QCircleScheme.AttrDetail.FEED_INFO, h.F, "", "id", "p", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TYPE, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/sqshow/zootopia/view/pull2refresh/androidx/ZootopiaPullRefreshLayoutV2;", "j", "Lcom/tencent/sqshow/zootopia/data/h;", "feedsData", "o", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/androidx/XPullToRefreshViewV2;", "recyclerView", "", "isMachineRefresh", "e", "reqType", "b", "endOfRefresh", "i", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/sqshow/zootopia/usercenter/fragment/a;", "d", "Lcom/tencent/sqshow/zootopia/usercenter/fragment/a;", "getUserCenterPage", "()Lcom/tencent/sqshow/zootopia/usercenter/fragment/a;", "userCenterPage", "Lcom/tencent/sqshow/zootopia/usercenter/friend/ui/ZPlanUserCenterEmptyView;", "Lcom/tencent/sqshow/zootopia/usercenter/friend/ui/ZPlanUserCenterEmptyView;", "emptyView", "f", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/androidx/ZootopiaPullRefreshLayoutV2;", "refreshView", "Lic4/d;", "Lic4/d;", "mAdapter", "I", "mLeftMargin", "mRightMargin", "Ljc4/c;", BdhLogUtil.LogTag.Tag_Conn, "Ljc4/c;", "repository", "D", "Lcom/tencent/sqshow/zootopia/data/h;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/sqshow/zootopia/usercenter/fragment/a;)V", "E", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class UserCenterWearPageView extends RelativeLayout implements XPullToRefreshViewV2.c, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private final jc4.c repository;

    /* renamed from: D, reason: from kotlin metadata */
    private ZootopiaDetailFeedsListData feedsData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final a userCenterPage;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ZPlanUserCenterEmptyView emptyView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ZootopiaPullRefreshLayoutV2 refreshView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private d mAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int mLeftMargin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int mRightMargin;

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/usercenter/view/ui/UserCenterWearPageView$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f373216d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ UserCenterWearPageView f373217e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f373218f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f373219h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f373220i;

        b(d dVar, UserCenterWearPageView userCenterWearPageView, int i3, int i16, int i17) {
            this.f373216d = dVar;
            this.f373217e = userCenterWearPageView;
            this.f373218f = i3;
            this.f373219h = i16;
            this.f373220i = i17;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int i3;
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData = this.f373216d.p0().isEmpty() ? null : this.f373216d.p0().get(0);
            int indexOf = zootopiaDetailFeedsCardData == null ? -1 : this.f373216d.p0().indexOf(zootopiaDetailFeedsCardData);
            Object tag = view.getTag();
            Integer num = tag instanceof Integer ? (Integer) tag : null;
            int intValue = num != null ? num.intValue() : -1;
            if (indexOf < 0 || intValue < 0 || (i3 = intValue - indexOf) < 0) {
                return;
            }
            int i16 = i3 % 3;
            if (i16 == 0) {
                outRect.set(this.f373217e.mLeftMargin, this.f373217e.k(i3), (this.f373218f - this.f373217e.mLeftMargin) - this.f373219h, i.b(4));
            } else if (i16 != 2) {
                outRect.set(this.f373220i, this.f373217e.k(i3), this.f373220i, i.b(4));
            } else {
                outRect.set((this.f373218f - this.f373217e.mRightMargin) - this.f373219h, this.f373217e.k(i3), this.f373217e.mRightMargin, i.b(4));
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/usercenter/view/ui/UserCenterWearPageView$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/sqshow/zootopia/data/h;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements e<ZootopiaDetailFeedsListData> {
        c() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ZootopiaDetailFeedsListData result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("UserCenterWearPageView", 1, "loadNextPageDetailData :: success , result == " + result);
            d dVar = UserCenterWearPageView.this.mAdapter;
            if (dVar != null) {
                dVar.addData(result.a());
            }
            ZootopiaPullRefreshLayoutV2 zootopiaPullRefreshLayoutV2 = UserCenterWearPageView.this.refreshView;
            if (zootopiaPullRefreshLayoutV2 != null) {
                zootopiaPullRefreshLayoutV2.F(true, result.getHasMore());
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.i("UserCenterWearPageView", 1, "loadNextPageDetailData :: failed , error == " + error + " , message ==" + message);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserCenterWearPageView(Context context, a userCenterPage) {
        super(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(userCenterPage, "userCenterPage");
        this.userCenterPage = userCenterPage;
        this.mLeftMargin = i.b(16);
        this.mRightMargin = i.b(16);
        this.repository = new jc4.c();
        LayoutInflater.from(context).inflate(R.layout.dhb, this);
        n();
    }

    private final void n() {
        l();
        m();
    }

    private final void p(String id5) {
        d dVar = this.mAdapter;
        if (dVar != null) {
            dVar.t0(id5);
        }
        d dVar2 = this.mAdapter;
        if (dVar2 != null && dVar2.getNUM_BACKGOURND_ICON() == 0) {
            ZPlanUserCenterEmptyView zPlanUserCenterEmptyView = this.emptyView;
            if (zPlanUserCenterEmptyView != null) {
                zPlanUserCenterEmptyView.setVisibility(0);
            }
            ZootopiaPullRefreshLayoutV2 zootopiaPullRefreshLayoutV2 = this.refreshView;
            if (zootopiaPullRefreshLayoutV2 == null) {
                return;
            }
            zootopiaPullRefreshLayoutV2.setVisibility(8);
        }
    }

    private final void q(String id5, int showType) {
        d dVar = this.mAdapter;
        if (dVar != null) {
            dVar.u0(id5, showType);
        }
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.androidx.XPullToRefreshViewV2.c
    public void b(XPullToRefreshViewV2 recyclerView, int reqType) {
        byte[] pagInfo;
        ZootopiaDetailFeedsListData zootopiaDetailFeedsListData = this.feedsData;
        if (zootopiaDetailFeedsListData == null || (pagInfo = zootopiaDetailFeedsListData.getPagInfo()) == null) {
            return;
        }
        this.repository.a(this.userCenterPage.getCurrentUin(), pagInfo, new c());
    }

    public final int i() {
        ArrayList<ZootopiaDetailFeedsCardData> p06;
        d dVar = this.mAdapter;
        if (dVar == null || (p06 = dVar.p0()) == null) {
            return 0;
        }
        return p06.size();
    }

    /* renamed from: j, reason: from getter */
    public final ZootopiaPullRefreshLayoutV2 getRefreshView() {
        return this.refreshView;
    }

    public final void o(ZootopiaDetailFeedsListData feedsData) {
        this.feedsData = feedsData;
        if (feedsData != null && !feedsData.a().isEmpty()) {
            ZPlanUserCenterEmptyView zPlanUserCenterEmptyView = this.emptyView;
            if (zPlanUserCenterEmptyView != null) {
                zPlanUserCenterEmptyView.setVisibility(8);
            }
            d dVar = this.mAdapter;
            if (dVar != null) {
                dVar.s0(feedsData.a());
            }
            ZootopiaPullRefreshLayoutV2 zootopiaPullRefreshLayoutV2 = this.refreshView;
            if (zootopiaPullRefreshLayoutV2 != null) {
                zootopiaPullRefreshLayoutV2.setVisibility(0);
            }
            ZootopiaPullRefreshLayoutV2 zootopiaPullRefreshLayoutV22 = this.refreshView;
            if (zootopiaPullRefreshLayoutV22 != null) {
                zootopiaPullRefreshLayoutV22.F(true, feedsData.getHasMore());
                return;
            }
            return;
        }
        ZPlanUserCenterEmptyView zPlanUserCenterEmptyView2 = this.emptyView;
        if (zPlanUserCenterEmptyView2 != null) {
            zPlanUserCenterEmptyView2.setVisibility(0);
        }
        ZPlanUserCenterEmptyView zPlanUserCenterEmptyView3 = this.emptyView;
        if (zPlanUserCenterEmptyView3 != null) {
            ZPlanUserCenterEmptyView.setMode$default(zPlanUserCenterEmptyView3, ZPlanUserCenterEmptyView.MODE.MODE_EMPTY_PRODUCT, false, null, 4, null);
        }
        ZPlanUserCenterEmptyView zPlanUserCenterEmptyView4 = this.emptyView;
        if (zPlanUserCenterEmptyView4 != null) {
            zPlanUserCenterEmptyView4.setText(this.userCenterPage.Qa() ? R.string.xwm : R.string.xwl);
        }
        ZootopiaPullRefreshLayoutV2 zootopiaPullRefreshLayoutV23 = this.refreshView;
        if (zootopiaPullRefreshLayoutV23 != null) {
            zootopiaPullRefreshLayoutV23.setVisibility(8);
        }
        ZootopiaPullRefreshLayoutV2 zootopiaPullRefreshLayoutV24 = this.refreshView;
        if (zootopiaPullRefreshLayoutV24 != null) {
            zootopiaPullRefreshLayoutV24.F(false, false);
        }
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
        if (event instanceof ZplanDeleteWorkItemEvent) {
            p(((ZplanDeleteWorkItemEvent) event).getId());
            return;
        }
        if (event instanceof ZplanBanWorkItemEvent) {
            p(((ZplanBanWorkItemEvent) event).getId());
            return;
        }
        if (event instanceof ZplanChangeShowTypeEvent) {
            if (this.userCenterPage.Qa()) {
                ZplanChangeShowTypeEvent zplanChangeShowTypeEvent = (ZplanChangeShowTypeEvent) event;
                q(zplanChangeShowTypeEvent.getId(), zplanChangeShowTypeEvent.getShowType());
                return;
            } else {
                ZplanChangeShowTypeEvent zplanChangeShowTypeEvent2 = (ZplanChangeShowTypeEvent) event;
                if (zplanChangeShowTypeEvent2.getShowType() == 2) {
                    p(zplanChangeShowTypeEvent2.getId());
                    return;
                }
                return;
            }
        }
        if (event instanceof ZPlanFeedsPublishSuccessEvent) {
            h(((ZPlanFeedsPublishSuccessEvent) event).getFeedInfo());
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(ZplanDeleteWorkItemEvent.class, ZplanBanWorkItemEvent.class, ZplanChangeShowTypeEvent.class, ZPlanFeedsPublishSuccessEvent.class);
        return arrayListOf;
    }

    private final void h(n feedInfo) {
        ArrayList<ZootopiaDetailFeedsCardData> p06;
        l lVar;
        QLog.i("UserCenterWearPageView", 1, "UserCenterWearPageView :: addItem , feedId == " + ((feedInfo == null || (lVar = feedInfo.f427499b) == null) ? null : lVar.f427476a));
        if (feedInfo != null) {
            ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData = new ZootopiaDetailFeedsCardData(0, feedInfo, 0, 5, null);
            d dVar = this.mAdapter;
            if ((dVar == null || (p06 = dVar.p0()) == null || !p06.isEmpty()) ? false : true) {
                d dVar2 = this.mAdapter;
                if (dVar2 != null) {
                    dVar2.k0(zootopiaDetailFeedsCardData);
                }
                ZPlanUserCenterEmptyView zPlanUserCenterEmptyView = this.emptyView;
                if (zPlanUserCenterEmptyView != null) {
                    zPlanUserCenterEmptyView.setVisibility(8);
                }
                ZootopiaPullRefreshLayoutV2 zootopiaPullRefreshLayoutV2 = this.refreshView;
                if (zootopiaPullRefreshLayoutV2 != null) {
                    zootopiaPullRefreshLayoutV2.setVisibility(0);
                }
                ZootopiaPullRefreshLayoutV2 zootopiaPullRefreshLayoutV22 = this.refreshView;
                if (zootopiaPullRefreshLayoutV22 != null) {
                    zootopiaPullRefreshLayoutV22.G(false);
                }
                ZootopiaPullRefreshLayoutV2 zootopiaPullRefreshLayoutV23 = this.refreshView;
                if (zootopiaPullRefreshLayoutV23 != null) {
                    zootopiaPullRefreshLayoutV23.F(true, false);
                    return;
                }
                return;
            }
            d dVar3 = this.mAdapter;
            if (dVar3 != null) {
                dVar3.k0(zootopiaDetailFeedsCardData);
            }
        }
    }

    private final void l() {
        this.emptyView = (ZPlanUserCenterEmptyView) findViewById(R.id.r9g);
    }

    private final void m() {
        RecyclerViewXWithHeaderFooter E;
        ZootopiaPullRefreshLayoutV2 zootopiaPullRefreshLayoutV2 = (ZootopiaPullRefreshLayoutV2) findViewById(R.id.r9h);
        this.refreshView = zootopiaPullRefreshLayoutV2;
        if (zootopiaPullRefreshLayoutV2 != null) {
            zootopiaPullRefreshLayoutV2.setRefreshEnable(false);
        }
        ZootopiaPullRefreshLayoutV2 zootopiaPullRefreshLayoutV22 = this.refreshView;
        if (zootopiaPullRefreshLayoutV22 != null) {
            zootopiaPullRefreshLayoutV22.G(true);
        }
        ZootopiaPullRefreshLayoutV2 zootopiaPullRefreshLayoutV23 = this.refreshView;
        RecyclerViewXWithHeaderFooter E2 = zootopiaPullRefreshLayoutV23 != null ? zootopiaPullRefreshLayoutV23.E() : null;
        if (E2 != null) {
            E2.setClipChildren(false);
        }
        ZootopiaPullRefreshLayoutV2 zootopiaPullRefreshLayoutV24 = this.refreshView;
        RecyclerViewXWithHeaderFooter E3 = zootopiaPullRefreshLayoutV24 != null ? zootopiaPullRefreshLayoutV24.E() : null;
        if (E3 != null) {
            E3.setItemAnimator(null);
        }
        ZootopiaPullRefreshLayoutV2 zootopiaPullRefreshLayoutV25 = this.refreshView;
        if (zootopiaPullRefreshLayoutV25 != null) {
            zootopiaPullRefreshLayoutV25.setRefreshCallback(this);
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        d dVar = new d(context, this.userCenterPage);
        this.mAdapter = dVar;
        ZootopiaPullRefreshLayoutV2 zootopiaPullRefreshLayoutV26 = this.refreshView;
        RecyclerViewXWithHeaderFooter E4 = zootopiaPullRefreshLayoutV26 != null ? zootopiaPullRefreshLayoutV26.E() : null;
        if (E4 != null) {
            E4.setAdapter(this.mAdapter);
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        ZootopiaPullRefreshLayoutV2 zootopiaPullRefreshLayoutV27 = this.refreshView;
        RecyclerViewXWithHeaderFooter E5 = zootopiaPullRefreshLayoutV27 != null ? zootopiaPullRefreshLayoutV27.E() : null;
        if (E5 != null) {
            E5.setLayoutManager(gridLayoutManager);
        }
        int c16 = u.INSTANCE.c(BaseApplication.context);
        int b16 = (c16 - i.b(48)) / 3;
        int i3 = c16 / 3;
        int i16 = (i3 - b16) / 2;
        ZootopiaPullRefreshLayoutV2 zootopiaPullRefreshLayoutV28 = this.refreshView;
        if (zootopiaPullRefreshLayoutV28 == null || (E = zootopiaPullRefreshLayoutV28.E()) == null) {
            return;
        }
        E.addItemDecoration(new b(dVar, this, i3, b16, i16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int k(int fixedPos) {
        return i.b(fixedPos < 3 ? 20 : 4);
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.androidx.XPullToRefreshViewV2.c
    public void endOfRefresh() {
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.androidx.XPullToRefreshViewV2.c
    public void e(XPullToRefreshViewV2 recyclerView, boolean isMachineRefresh) {
    }
}
