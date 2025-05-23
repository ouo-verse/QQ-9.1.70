package com.qzone.reborn.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.qzone.feed.business.service.QZoneFeedService;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import com.qzone.proxy.feedcomponent.ui.g;
import com.qzone.proxy.feedcomponent.ui.h;
import com.qzone.reborn.view.QZoneReeditFeedTipsView;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import un.c;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneReeditFeedTipsView extends AbsFeedView {
    public QZoneReeditFeedTipsView(Context context) {
        super(context);
        d(context);
    }

    private void d(final Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.clg, this);
        ((TextView) inflate.findViewById(R.id.mtv)).setOnClickListener(new View.OnClickListener() { // from class: no.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneReeditFeedTipsView.this.e(context, view);
            }
        });
        inflate.setOnClickListener(new View.OnClickListener() { // from class: no.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneReeditFeedTipsView.f(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.mFeedData != null && c.e().h(this.mFeedData)) {
            c.e().k(context);
        } else {
            QQToast.makeText(BaseApplication.getContext(), l.a(R.string.kvz), 1).show();
        }
        g();
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData != null) {
            LpReportInfo_pf00064.allReport(3001, 1, 1, (String) null, c(businessFeedData.getFeedCommInfo().appid));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void g() {
        if (this.mFeedData != null) {
            QZoneFeedService.U().Q(this.mFeedData);
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean hasVideoPlayed() {
        return false;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean isAlwaysAutoPlayFeed() {
        return false;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean isAutoVideoFeed() {
        return false;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setData(BusinessFeedData businessFeedData) {
        super.setData(businessFeedData);
        if (!c.e().h(businessFeedData)) {
            g();
            QLog.d("QZoneReeditContentRecordManager", 1, "last record content retired,remove self feed key:", businessFeedData.getFeedCommInfo().clientkey);
        } else {
            LpReportInfo_pf00064.allReport(3001, 1, 0, (String) null, c(businessFeedData.getFeedCommInfo().appid));
        }
    }

    private String c(int i3) {
        if (i3 == 4) {
            return "album";
        }
        if (i3 != 311) {
            return "unknown";
        }
        return LpReportInfoConfig.RESERVE_DELETE_FEED_TYPE_SHUOSHUO;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateIdle() {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateScrolling() {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void startFlashNickName() {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateIdleOnDetail(boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setAlpha(int i3) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setFeedPosition(int i3) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setHasRecommHeader(boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setHasSearchSeparator(boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setNeedFillBlackArea(boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setOnFeedElementClickListener(g gVar) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setOnFeedEventListener(h hVar) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateLikeInfo(BusinessFeedData businessFeedData) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateRecommAction(BusinessFeedData businessFeedData) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateTransparentBackground(BusinessFeedData businessFeedData) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void reportFeed(BusinessFeedData businessFeedData, int i3) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void showSearchSeparator(boolean z16, String str) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateTitle(BusinessFeedData businessFeedData, Boolean bool) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateFollowInfo(BusinessFeedData businessFeedData, long j3, boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateSpecialFollowInfo(BusinessFeedData businessFeedData, long j3, boolean z16) {
    }
}
