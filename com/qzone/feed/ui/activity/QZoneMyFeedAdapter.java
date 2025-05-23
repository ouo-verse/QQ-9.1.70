package com.qzone.feed.ui.activity;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.qzone.common.activities.base.QZoneCompatFeedAdapter;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellOperationInfo;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import com.tencent.widget.ListView;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneMyFeedAdapter extends QZoneCompatFeedAdapter {
    @Override // com.qzone.common.activities.base.QZoneCompatFeedAdapter
    protected void A(int i3, AbsFeedView absFeedView, final BusinessFeedData businessFeedData, int i16) {
        super.A(i3, absFeedView, businessFeedData, i16);
        CellFeedCommInfo feedCommInfo = businessFeedData.getFeedCommInfo();
        if (feedCommInfo != null && feedCommInfo.appid == 7002) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.feed.ui.activity.QZoneMyFeedAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    ClickReport.r("", "", "", true, "31", "1");
                }
            });
        }
        if (businessFeedData.isHasHighFive()) {
            LpReportInfo_pf00064.allReport(302, 74, 3);
        }
        if (feedCommInfo != null && com.qzone.proxy.feedcomponent.util.d.j(feedCommInfo.operatemask2, 11)) {
            LpReportInfo_pf00064.allReport(303, 12, 1);
        }
        if (businessFeedData.isCoupleFeed()) {
            ClickReport.q("308", "76", "1", true);
        }
        if (feedCommInfo != null && feedCommInfo.needQBossReport() && businessFeedData.getOperationInfo() != null && businessFeedData.getOperationInfo().hasReportExposure == 0) {
            businessFeedData.getOperationInfo().hasReportExposure = 1;
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.feed.ui.activity.QZoneMyFeedAdapter.2
                @Override // java.lang.Runnable
                public void run() {
                    ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportExpose(businessFeedData.getOperationInfo().qbossTrace, null);
                }
            });
        }
        CellOperationInfo operationInfo = businessFeedData.getOperationInfo();
        if (operationInfo != null && operationInfo.hasReportExposure == 0) {
            operationInfo.hasReportExposure = 1;
            if (feedCommInfo.needAdvReport() || businessFeedData.isGDTAdvFeed()) {
                Message obtain = Message.obtain();
                obtain.what = 2;
                obtain.arg1 = (i3 - this.f45221e.zi().j0().getHeaderViewsCount()) + 1;
                obtain.obj = businessFeedData;
                this.f45221e.getHandler().sendMessage(obtain);
            }
        }
        if (businessFeedData.getUser().uin != 88882222 || businessFeedData.getLeftThumb() == null || TextUtils.isEmpty(businessFeedData.getLeftThumb().getActionUrl())) {
            return;
        }
        LpReportInfo_pf00064.allReport(701, 1, 0, (String) null, businessFeedData.getLeftThumb().getActionUrl());
    }

    @Override // com.qzone.common.activities.base.QZoneCompatFeedAdapter
    protected AbsFeedView l(int i3, AbsFeedView absFeedView, BusinessFeedData businessFeedData) {
        super.l(i3, absFeedView, businessFeedData);
        absFeedView.setData(businessFeedData);
        absFeedView.setTag(Integer.valueOf(i3));
        absFeedView.setFeedPosition(m() + i3);
        if (businessFeedData.cellUniverse == null) {
            com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().setMyFeedViewData(absFeedView, businessFeedData, true);
            absFeedView.setOnFeedElementClickListener(e());
            absFeedView.setFeedPosition(i3 + m());
            if (businessFeedData.getLeftThumb() != null) {
                businessFeedData.getLeftThumb().isPassive = businessFeedData.feedType == 4098;
            }
        }
        absFeedView.setAlpha(255);
        return absFeedView;
    }

    @Override // com.qzone.common.activities.base.QZoneCompatFeedAdapter
    protected AbsFeedView r(Context context) {
        return com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().obtainFeedView(context, e(), false, true, this.f45221e.f45261x0);
    }

    @Override // com.qzone.common.activities.base.QZoneCompatFeedAdapter
    protected AbsFeedView t(Context context) {
        return r(context);
    }

    public QZoneMyFeedAdapter(QZoneMyFeedFragment qZoneMyFeedFragment, ListView listView) {
        super(qZoneMyFeedFragment, listView, true);
    }
}
