package com.qzone.common.activities.base;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ListAdapter;
import com.qzone.common.logic.report.MiscReportUtils;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.util.ap;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.luan.ioc.annotation.Named;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

/* compiled from: P */
@Named("BaseFragmentReporter")
/* loaded from: classes39.dex */
public class ad implements d5.ab<BusinessFeedData>, ap.a {

    /* renamed from: d, reason: collision with root package name */
    private final SparseIntArray f45443d = new SparseIntArray();

    @Inject
    public ad() {
    }

    @Override // d5.ab
    public void a(Object obj) {
        if (obj instanceof BusinessFeedData) {
            BusinessFeedData businessFeedData = (BusinessFeedData) obj;
            if (businessFeedData.isSpecialCareInContainerFeed()) {
                LpReportInfo_pf00064.allReport(PlayerResources.ViewId.EXTENDED_VIEW_BTN_NORMAL_BUTTON, 1, 2);
            } else if (businessFeedData.isCardFriendsRecommendContainerFeed() || businessFeedData.isCardSchoolRecommendContainerFeed() || businessFeedData.isCardFollowMoreRecommendContainerFeed() || businessFeedData.isCardSpecialFollowMoreRecommendContainerFeed()) {
                LpReportInfo_pf00064.allReport(PlayerResources.ViewId.EXTENDED_VIEW_BTN_SHINE_BUTTON, 1, 2);
            }
        }
    }

    @Override // d5.ab
    public boolean b() {
        return com.qzone.util.ap.c();
    }

    @Override // d5.ab
    public void c(View view, d5.k<BusinessFeedData> kVar) {
        String str;
        BusinessFeedData b16 = kVar.b();
        if (b16 != null) {
            int i3 = 302;
            if (b16.isRecommendLiveShowContainerFeed()) {
                ClickReport.p("465", "1", "" + (b16.currShowIndex + 1), null, true);
                ClickReport.p("465", "2", null, null, true);
            } else if (b16.getFeedCommInfo().isBizRecomFeeds() && !b16.getFeedCommInfo().isSubOfMultiAdvContainerFeed) {
                MiscReportUtils.d(view, b16, 0, FeedElement.FEED_VIEW_EXPOSURE);
            } else if (b16.getFeedCommInfo().isMayKnowFriendFeed()) {
                ClickReport.q("22", "1", "", true);
            } else if (b16.cellFollowGuide != null) {
                LpReportInfo_pf00064.allReport(302, 86, 1);
            } else if (b16.isQzoneCardFeed()) {
                ClickReport.p("644", "1", "", null, true);
            } else if (b16.isLiveVideoFeed()) {
                com.qzone.adapter.feedcomponent.i.H().f(236, 1, 1);
            }
            if (b16.getCommentInfoV2() != null && b16.getCommentInfoV2().realCount > 0) {
                int i16 = b16.feedType;
                int i17 = 3;
                if (i16 == 3) {
                    i3 = 308;
                    i17 = 81;
                } else if (i16 == 4099) {
                    i3 = LpReportInfoConfig.ACTION_TYPE_MOOD_LIST;
                } else {
                    i17 = 87;
                }
                LpReportInfo_pf00064.allReport(i3, i17, 1);
            }
            if (b16.cellShareCard != null) {
                if (b16.getFeedCommInfo().extendInfo != null && b16.getFeedCommInfo().extendInfo.containsKey("campus_share_type")) {
                    str = b16.getFeedCommInfo().extendInfo.get("campus_share_type");
                } else {
                    str = "0";
                }
                ClickReport.p("690", "1", str, null, true);
            }
        }
    }

    @Override // d5.ab
    public void d(ListAdapter listAdapter, int i3, int i16, int i17, int i18) {
        if (!com.qzone.util.ap.b() || listAdapter == null || listAdapter.getCount() == 0) {
            return;
        }
        int i19 = this.f45443d.get(i17, -1);
        if (i19 != -1 && i16 > i19 && i19 < listAdapter.getCount()) {
            com.qzone.util.ap.f59791b.e(i17, i18, i19, ((QZoneBaseFeedAdapter) listAdapter).getItem(i19));
        }
        if (i16 > i19 + 1) {
            this.f45443d.delete(i17);
        }
        if (i17 == 25) {
        }
        for (int i26 = i3; i26 < i16; i26++) {
            int f16 = i26 - f();
            if (f16 >= 0) {
                if (f16 >= listAdapter.getCount()) {
                    this.f45443d.append(i17, f16);
                } else {
                    QZoneBaseFeedAdapter qZoneBaseFeedAdapter = (QZoneBaseFeedAdapter) listAdapter;
                    BusinessFeedData item = qZoneBaseFeedAdapter.getItem(f16);
                    com.qzone.util.ap.f59791b.e(i17, i18, f16, item);
                    if (qZoneBaseFeedAdapter.f45221e != null && item != null && g(i3, i16)) {
                        eo.b.f396876a.b(qZoneBaseFeedAdapter.f45221e.getOutActivity(), item.getFeedCommInfo().feedskey);
                    }
                }
            }
        }
    }

    @Override // d5.ab
    public void e() {
        com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().doCommentActionReport(2);
    }

    protected int f() {
        return 0;
    }

    @Override // com.qzone.util.ap.a
    public int getReportPageId() {
        return -1;
    }

    @Override // d5.ab
    public void onPause() {
        com.qzone.util.ap.g();
    }

    @Override // d5.ab
    public void onResume() {
        com.qzone.util.ap.h(this);
    }

    private boolean g(int i3, int i16) {
        return i16 - i3 <= QZoneConfigHelper.F0();
    }
}
