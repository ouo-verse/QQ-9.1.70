package com.tencent.biz.qqcircle.immersive.layer.base;

import android.text.TextUtils;
import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart;
import com.tencent.biz.qqcircle.immersive.utils.y;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer;
import com.tencent.biz.qqcircle.launcher.parser.QCircleContentDetailSchemeParser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDTLoginReporter;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class QFSLayerBaseMiddleListPart extends QFSLayerBasePart {
    private boolean C9() {
        if (u40.a.b(getInitBean()) && !y.c(getInitBean())) {
            return true;
        }
        return false;
    }

    private boolean D9(QCircleInitBean qCircleInitBean) {
        if (qCircleInitBean == null) {
            return false;
        }
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_layer_enable_sync_load_fake_feed", true)) {
            QLog.d(getTAG(), 1, "canSyncLoadFakeFeed server config false");
            return false;
        }
        if (!TextUtils.isEmpty(qCircleInitBean.getQQVideoBusinessFeedID())) {
            return true;
        }
        FeedCloudMeta$StFeed a16 = u40.a.a();
        if (a16 != null && TextUtils.equals(a16.f398449id.get(), qCircleInitBean.getFeedId())) {
            QLog.e(getTAG(), 4, "canSyncLoadFakeFeed use cache feed");
            return true;
        }
        if (!QCircleContentDetailSchemeParser.r(qCircleInitBean.getSchemeAttrs())) {
            return false;
        }
        return true;
    }

    private void F9() {
        QCircleInitBean initBean = getInitBean();
        if (initBean != null && initBean.getSchemeAttrs() != null && TextUtils.equals(initBean.getSchemeAttrs().get("is_force_login_report"), "1")) {
            QLog.d(getTAG(), 1, "[doLoginReport] real do" + initBean.getAction());
            QCircleDTLoginReporter.daTongLoginReport(initBean.getAction(), initBean.getSchemeAttrs());
        }
    }

    private void J9() {
        QCircleInitBean initBean = getInitBean();
        if (initBean == null) {
            return;
        }
        QLog.d(getTAG(), 1, "syncLoadFakeFeed initBean");
        e H9 = H9();
        FeedCloudMeta$StFeed feed = initBean.getFeed();
        if (H9 != null && feed != null) {
            ArrayList arrayList = new ArrayList();
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
            feedCloudMeta$StFeed.set(feed);
            feedCloudMeta$StFeed.f398449id.set("share_fake_" + feed.f398449id.get());
            arrayList.add(feedCloudMeta$StFeed);
            H9.f2(initBean);
            Z9(H9.l2(arrayList));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E9() {
        if (H9() == null) {
            return;
        }
        H9().P1().setAdAttachInfo(null);
        H9().P1().setStringAttachInfo(null);
        H9().P1().setRefreshAttachInfo(null);
    }

    public int G9() {
        ViewPager2 B;
        QFSPageTurnContainer qFSPageTurnContainer = this.mLayerPageContainer;
        if (qFSPageTurnContainer == null) {
            B = null;
        } else {
            B = qFSPageTurnContainer.B();
        }
        if (B == null) {
            return -1;
        }
        return B.getCurrentItem();
    }

    protected e H9() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I9() {
        if (!C9()) {
            this.mPlayPageReport.K("3");
            return;
        }
        this.mPlayPageReport.K("8");
        if (D9(getInitBean())) {
            QLog.d(getTAG(), 1, "realLoadFakeFeed mainThread");
            J9();
        } else {
            RFWThreadManager.getInstance().getSerialThreadHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseMiddleListPart.1
                @Override // java.lang.Runnable
                public void run() {
                    e H9 = QFSLayerBaseMiddleListPart.this.H9();
                    FeedCloudMeta$StFeed feed = QFSLayerBaseMiddleListPart.this.getInitBean().getFeed();
                    if (H9 != null && feed != null) {
                        ArrayList arrayList = new ArrayList();
                        FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
                        feedCloudMeta$StFeed.set(feed);
                        feedCloudMeta$StFeed.f398449id.set("share_fake_" + feed.f398449id.get());
                        arrayList.add(feedCloudMeta$StFeed);
                        H9.i2(arrayList);
                    }
                }
            });
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    protected void fakeDateNotifyDataSetChanged(List<e30.b> list) {
        if (getInitBean() != null && getInitBean().getFeed() != null && getInitBean().getFeed().f398449id.get().startsWith("share_fake_") && this.mLayerPageAdapter != null && list != null && list.size() >= 1 && !list.get(0).g().f398449id.get().startsWith("share_fake_")) {
            this.mLayerPageAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    /* renamed from: handleFeedRsp */
    public void Z9(UIStateData<List<e30.b>> uIStateData) {
        if (C9() && uIStateData != null && uIStateData.getState() == 1) {
            QLog.d(getTAG(), 1, "[handleFeedRsp] has simple feed, need not loading");
            hideLoadingView();
        } else {
            super.Z9(uIStateData);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        boolean z16;
        super.onInitView(view);
        if (getInitBean() != null && getInitBean().isDisableFoot()) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.mLayerPageContainer.setLoadMoreEnable(z16);
        this.mLayerPageContainer.setRefreshEnable(com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.c.a(getInitBean()));
        F9();
        e H9 = H9();
        if (H9 != null) {
            H9.g2(this.mFeedWasteCollector);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    public void pageContainerOnPageSelected(int i3) {
        super.pageContainerOnPageSelected(i3);
        e H9 = H9();
        if (H9 != null) {
            H9.e2(i3);
        }
    }
}
