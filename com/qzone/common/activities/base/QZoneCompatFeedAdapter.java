package com.qzone.common.activities.base;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.qzone.app.ResourcePreloader;
import com.qzone.common.logic.report.MiscReportUtils;
import com.qzone.misc.network.report.QzoneFeedVisitorReportService;
import com.qzone.module.feedcomponent.ui.QZoneOldFrdHotVideoFeedListView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellGuiding;
import com.qzone.proxy.feedcomponent.model.CellUniverse;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import com.qzone.reborn.view.QZoneEmptyFeedView;
import com.qzone.reborn.view.QZoneReadDivideLineView;
import com.qzone.reborn.view.QZoneReeditFeedTipsView;
import com.qzone.widget.QZonePullToRefreshListView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vip.api.IVipDataUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneCompatFeedAdapter extends QZoneBaseFeedAdapter {

    /* renamed from: m, reason: collision with root package name */
    private final boolean f45274m;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements AbsListView.RecyclerListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f45280d;

        a(boolean z16) {
            this.f45280d = z16;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view) {
            if (view instanceof com.qzone.proxy.feedcomponent.widget.g) {
                if (this.f45280d) {
                    QzoneFeedVisitorReportService.f().j(view);
                }
                ((com.qzone.proxy.feedcomponent.widget.g) view).onRecycled();
            }
        }
    }

    public QZoneCompatFeedAdapter(QZoneBaseFeedFragment qZoneBaseFeedFragment, ListView listView, boolean z16) {
        super(qZoneBaseFeedFragment);
        this.f45274m = z16;
        if (listView != null) {
            listView.setRecyclerListener(new a(z16));
        }
    }

    private void B(final int i3, final AbsFeedView absFeedView, final BusinessFeedData businessFeedData, final int i16) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.common.activities.base.QZoneCompatFeedAdapter.4
            @Override // java.lang.Runnable
            public void run() {
                QZoneCompatFeedAdapter.this.A(i3, absFeedView, businessFeedData, i16);
            }
        });
    }

    protected boolean C() {
        return false;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        BusinessFeedData item;
        if (this.f45274m && (item = getItem(i3)) != null) {
            if (item.isBirthdayCardFeed()) {
                return 21;
            }
            CellUniverse cellUniverse = item.cellUniverse;
            if (cellUniverse != null && !TextUtils.isEmpty(cellUniverse.jsonTemplate) && !item.isQQLiveFeed()) {
                return 17;
            }
            if (item.isMultiAdvContainerFeed() || item.isSpecialCareInContainerFeed() || item.isFriendLikeContainer() || item.isFriendBirthdayContainerFeed() || item.isRecommendLiveShowContainerFeed() || item.isCardFriendsRecommendContainerFeed() || item.isCardSchoolRecommendContainerFeed() || item.isCardFollowMoreRecommendContainerFeed() || item.isCardSpecialFollowMoreRecommendContainerFeed()) {
                return 2;
            }
            if (item.isRecomEventTagFeed() || item.isRecomMyEventTagContainerFeed()) {
                return 7;
            }
            if (item.isFriendVideoFeed()) {
                return 11;
            }
            if (item.isFrdLikeVideoContainer()) {
                return 12;
            }
            if (item.isFriendLikeVerticalSlideContainer() || item.isFrdLikeMiniAppContainer()) {
                return 16;
            }
            if (item.isSecretFeed()) {
                return 6;
            }
            if (item.isNegativeFeedback()) {
                return 8;
            }
            if (item.isCardFollowMoreRecommendVerticalFeed()) {
                return 10;
            }
            if (item.getFeedCommInfo().isBizRecomFeeds() && !item.isPublicAccountContainer() && !item.isRecommendQQCircleFeed()) {
                return 1;
            }
            if (item.isFunctionGuideFeed()) {
                return 4;
            }
            if (item.isFriendAnniversaryFeed()) {
                return 5;
            }
            if (item.isRegisterAnniversaryFeed()) {
                return 13;
            }
            if (item.isNewGuideFeed()) {
                return 14;
            }
            if (item.isFriendFeedReadLineFeed()) {
                return 23;
            }
            if (item.isReeditFeed()) {
                return 26;
            }
            if (com.qzone.proxy.feedcomponent.model.c.b(item)) {
                return 27;
            }
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qzone.common.activities.base.QZoneBaseFeedAdapter, android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        AbsFeedView o16;
        AbsFeedView l3;
        v();
        BusinessFeedData item = getItem(i3);
        if (item == null) {
            QZLog.w("QZoneCompatFeedAdapter", "getView: null data " + i3);
        } else {
            w(i3, item);
            int itemViewType = getItemViewType(i3);
            if (view instanceof AbsFeedView) {
                o16 = (AbsFeedView) view;
            } else {
                o16 = o(itemViewType, item);
            }
            if (o16 == null) {
                QZLog.w("QZoneCompatFeedAdapter", "getView: failed to obtain view " + i3);
            } else {
                if (!item.hasCalculate) {
                    item.preCalculate();
                }
                if (item.getCellUserInfo() != null && item.getCellUserInfo().user != null && !TextUtils.isEmpty(item.getCellUserInfo().user.feedAvatarDecorationUrl) && ((IVipDataUtils) QRoute.api(IVipDataUtils.class)).getVipDataForFriends(String.valueOf(item.getCellUserInfo().user.uin)).isSplendid()) {
                    item.getCellUserInfo().user.feedAvatarDecorationUrl = null;
                }
                l3 = l(i3, o16, item);
                B(i3, l3, item, itemViewType);
                l3.setOnFeedElementClickListener(e());
                u(i3, item);
                EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
                return l3;
            }
        }
        l3 = view;
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return l3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return this.f45274m ? 28 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbsFeedView l(int i3, AbsFeedView absFeedView, BusinessFeedData businessFeedData) {
        absFeedView.setOnFeedElementClickListener(e());
        return absFeedView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int m() {
        QZonePullToRefreshListView zi5 = this.f45221e.zi();
        if (zi5 == null) {
            return 0;
        }
        return zi5.j0().getHeaderViewsCount();
    }

    protected final Context n() {
        Context c16 = ResourcePreloader.b().c();
        return c16 == null ? this.f45221e.getActivity() : c16;
    }

    protected final AbsFeedView o(int i3, final BusinessFeedData businessFeedData) {
        Context n3 = n();
        if (2 == i3 || 3 == i3) {
            AbsFeedView obtainFeedAdvContainer = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().obtainFeedAdvContainer(n3, businessFeedData);
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.common.activities.base.QZoneCompatFeedAdapter.3
                @Override // java.lang.Runnable
                public void run() {
                    QZoneCompatFeedAdapter.this.z(businessFeedData);
                    QZoneCompatFeedAdapter.this.y(businessFeedData);
                    QZoneCompatFeedAdapter.this.x(businessFeedData);
                }
            });
            MiscReportUtils.a(businessFeedData);
            return obtainFeedAdvContainer;
        }
        if (21 == i3) {
            return com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().obtainFeedBirthdayContainer(n3, businessFeedData);
        }
        if (7 == i3) {
            return com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().obtainFeedGalleryContainer(n3, businessFeedData);
        }
        if (1 == i3) {
            return com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().obtainFeedAdvContainer(n3, businessFeedData);
        }
        if (4 == i3) {
            AbsFeedView obtainFunctionGuideFeedView = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().obtainFunctionGuideFeedView(n3);
            CellGuiding cellGuiding = businessFeedData.getCellGuiding();
            if (cellGuiding != null && cellGuiding.guiding_type == 4) {
                MiscReportUtils.k(cellGuiding, CellGuiding.reportExposure);
            }
            MiscReportUtils.c(cellGuiding);
            return obtainFunctionGuideFeedView;
        }
        if (5 == i3) {
            AbsFeedView obtainFriendAnniversyFeedView = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().obtainFriendAnniversyFeedView(n3);
            if (businessFeedData == null) {
                return obtainFriendAnniversyFeedView;
            }
            MiscReportUtils.c(businessFeedData.getCellGuiding());
            return obtainFriendAnniversyFeedView;
        }
        if (8 == i3) {
            return com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().obtainNegativeFeedbackFeedView(n3);
        }
        if (10 == i3) {
            return com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().obtainVerticalRecomFollowFeedView(n3);
        }
        if (6 == i3) {
            return t(n3);
        }
        if (11 == i3) {
            return com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().generateFriendVideoFeedView(n3);
        }
        if (12 == i3) {
            return com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().generateFrdLikeVideoFeedView(n3);
        }
        if (13 == i3) {
            return com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().obtainRegisterAnniversyFeedView(n3);
        }
        if (14 == i3) {
            return com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().obtainNewGuideView(n3);
        }
        if (17 == i3) {
            return com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().obtainNewUserFeedView(n3);
        }
        if (16 == i3) {
            return com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().generateFrdLikeVideoSlideFeedView(n3);
        }
        if (23 == i3) {
            return s(n3);
        }
        if (26 == i3) {
            if (C()) {
                return q(n3);
            }
            return new QZoneEmptyFeedView(n3);
        }
        if (27 == i3) {
            return p(n3);
        }
        return r(n3);
    }

    protected AbsFeedView p(Context context) {
        return new QZoneOldFrdHotVideoFeedListView(context);
    }

    protected AbsFeedView q(Context context) {
        return new QZoneReeditFeedTipsView(context);
    }

    protected AbsFeedView r(Context context) {
        throw null;
    }

    protected AbsFeedView t(Context context) {
        throw null;
    }

    protected void y(BusinessFeedData businessFeedData) {
        LpReportInfo_pf00064 lpReportInfo_pf00064;
        if (businessFeedData.isCardSchoolRecommendContainerFeed()) {
            lpReportInfo_pf00064 = new LpReportInfo_pf00064("650", "1");
        } else if (businessFeedData.isCardFollowMoreRecommendContainerFeed()) {
            lpReportInfo_pf00064 = new LpReportInfo_pf00064("645", "1");
        } else {
            lpReportInfo_pf00064 = businessFeedData.isCardSpecialFollowMoreRecommendContainerFeed() ? new LpReportInfo_pf00064("721", "1") : null;
        }
        if (lpReportInfo_pf00064 != null) {
            LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
        }
    }

    protected AbsFeedView s(Context context) {
        QLog.d("QZoneCompatFeedAdapter", 1, "readLineViewInit");
        return new QZoneReadDivideLineView(context);
    }

    protected void w(int i3, BusinessFeedData businessFeedData) {
        businessFeedData.ignoreTitleGap = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(BusinessFeedData businessFeedData) {
    }

    protected void v() {
    }

    protected void z(BusinessFeedData businessFeedData) {
    }

    protected void u(int i3, BusinessFeedData businessFeedData) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(int i3, AbsFeedView absFeedView, BusinessFeedData businessFeedData, int i16) {
    }
}
