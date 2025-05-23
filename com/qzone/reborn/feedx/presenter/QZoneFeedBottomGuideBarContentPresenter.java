package com.qzone.reborn.feedx.presenter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.adapter.feedcomponent.FakeShuoShuoDataCacheHelper;
import com.qzone.common.event.EventCenter;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellAlbumEntrance;
import com.qzone.reborn.feedx.presenter.QZoneFeedBottomGuideBarContentPresenter;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes37.dex */
public class QZoneFeedBottomGuideBarContentPresenter extends vg.a {
    private LinearLayout F;
    private ImageView G;
    private TextView H;
    private boolean I;
    private boolean J = false;
    private BusinessFeedData K;

    /* JADX INFO: Access modifiers changed from: private */
    public void O(BusinessFeedData businessFeedData, FakeShuoShuoDataCacheHelper.a aVar, View view) {
        try {
            RFWLog.i("QZoneFeedBottomGuideBarContentPresenter", RFWLog.USR, "handlePublishQCircle, shuoShuoData: " + aVar);
            P(businessFeedData, view, aVar);
            com.qzone.feed.utils.c.f(this.K);
        } catch (Exception e16) {
            RFWLog.e("QZoneFeedBottomGuideBarContentPresenter", RFWLog.USR, "handlePublishQCircle, error ", e16);
        }
    }

    private void P(BusinessFeedData businessFeedData, View view, FakeShuoShuoDataCacheHelper.a aVar) {
        String str;
        if (businessFeedData == null) {
            RFWLog.e("QZoneFeedBottomGuideBarContentPresenter", RFWLog.USR, "onPublishQCircleClick, businessData is null");
            return;
        }
        CellAlbumEntrance cellAlbumEntrance = businessFeedData.cellAlbumEntrance;
        String str2 = "";
        if (cellAlbumEntrance == null) {
            str = "";
        } else {
            str = cellAlbumEntrance.guideUrl;
        }
        RFWLog.i("QZoneFeedBottomGuideBarContentPresenter", RFWLog.USR, "onPublishQCircleClick, args: " + aVar + ", schema: " + str);
        if (TextUtils.isEmpty(str) || aVar == null) {
            return;
        }
        List<String> a16 = aVar.a();
        if (businessFeedData.getFeedCommInfo() != null && businessFeedData.getFeedCommInfo().appid == 311 && businessFeedData.getCellSummaryV2() != null) {
            str2 = businessFeedData.getCellSummaryV2().summary;
        }
        qo.c.d(view.getContext(), str, new ArrayList(a16), str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        BusinessFeedData businessFeedData = this.K;
        if (businessFeedData == null) {
            RFWLog.i("QZoneFeedBottomGuideBarContentPresenter", RFWLog.USR, "reportQCircleEntranceExpose, mFeedData is null ");
        } else {
            if (this.I) {
                return;
            }
            this.I = true;
            com.qzone.feed.utils.c.g(businessFeedData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        if (this.K == null) {
            RFWLog.e("QZoneFeedBottomGuideBarContentPresenter", RFWLog.USR, "reportQCircleEntranceExposeTianshu, mFeedData is null ");
        } else {
            RFWLog.i("QZoneFeedBottomGuideBarContentPresenter", RFWLog.USR, "reportQCircleEntranceExposeTianshu ");
            com.qzone.feed.utils.c.h(this.K);
        }
    }

    @Override // vg.a
    protected void A(final BusinessFeedData businessFeedData) {
        this.K = businessFeedData;
        LinearLayout linearLayout = this.F;
        if (linearLayout == null || this.J) {
            return;
        }
        linearLayout.setVisibility(8);
        if (businessFeedData == null || businessFeedData.getFeedCommInfoV2() == null) {
            return;
        }
        String str = businessFeedData.getFeedCommInfoV2().clientkey;
        CellAlbumEntrance cellAlbumEntrance = businessFeedData.cellAlbumEntrance;
        if (cellAlbumEntrance == null) {
            if (RFWLog.isColorLevel()) {
                RFWLog.i("QZoneFeedBottomGuideBarContentPresenter", RFWLog.CLR, "onBindData, clientKey: " + str + ", feedData.cellAlbumEntrance is null");
                return;
            }
            return;
        }
        if (RFWLog.isColorLevel()) {
            RFWLog.i("QZoneFeedBottomGuideBarContentPresenter", RFWLog.CLR, "feedData.cellAlbumEntrance, iAttr: " + cellAlbumEntrance.iAttr + ", guideTitle: " + cellAlbumEntrance.guideTitle + ", url: " + cellAlbumEntrance.guideIcon + ", feedsKey: " + str);
        }
        Map<String, String> map = cellAlbumEntrance.busi_param;
        if (map != null && map.containsKey("hasClicked")) {
            RFWLog.e("QZoneFeedBottomGuideBarContentPresenter", RFWLog.USR, "onBindData error, has clicked");
            return;
        }
        final String str2 = cellAlbumEntrance.guideIcon;
        if (!TextUtils.isEmpty(str2) && cellAlbumEntrance.iAttr == 2) {
            final String str3 = cellAlbumEntrance.guideTitle;
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            final FakeShuoShuoDataCacheHelper.a b16 = FakeShuoShuoDataCacheHelper.b(str);
            if (b16 == null) {
                RFWLog.e("QZoneFeedBottomGuideBarContentPresenter", RFWLog.USR, "onBindData error, shuoShuoData is null");
            } else {
                FeedGlobalEnv.g().postRunnableToNormalThread(new Runnable() { // from class: com.qzone.reborn.feedx.presenter.QZoneFeedBottomGuideBarContentPresenter.1

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* renamed from: com.qzone.reborn.feedx.presenter.QZoneFeedBottomGuideBarContentPresenter$1$1, reason: invalid class name and collision with other inner class name */
                    /* loaded from: classes37.dex */
                    public class RunnableC04641 implements Runnable {
                        RunnableC04641() {
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public /* synthetic */ void b(BusinessFeedData businessFeedData, FakeShuoShuoDataCacheHelper.a aVar, View view) {
                            EventCollector.getInstance().onViewClickedBefore(view);
                            EventCenter.getInstance().post("FeedX", 3, (Object[]) null);
                            QZoneFeedBottomGuideBarContentPresenter.this.O(businessFeedData, aVar, view);
                            QZoneFeedBottomGuideBarContentPresenter.this.J = true;
                            EventCollector.getInstance().onViewClicked(view);
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            RFWLog.i("QZoneFeedBottomGuideBarContentPresenter", RFWLog.USR, "handleQCircleEntrance, set visible ");
                            com.tencent.mobileqq.qzone.picload.c.a().i(Option.obtain().setUrl(str2).setTargetView(QZoneFeedBottomGuideBarContentPresenter.this.G), null);
                            QZoneFeedBottomGuideBarContentPresenter.this.H.setText(str3);
                            QZoneFeedBottomGuideBarContentPresenter.this.F.setVisibility(0);
                            LinearLayout linearLayout = QZoneFeedBottomGuideBarContentPresenter.this.F;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            final BusinessFeedData businessFeedData = businessFeedData;
                            final FakeShuoShuoDataCacheHelper.a aVar = b16;
                            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.presenter.k
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    QZoneFeedBottomGuideBarContentPresenter.AnonymousClass1.RunnableC04641.this.b(businessFeedData, aVar, view);
                                }
                            });
                            QZoneFeedBottomGuideBarContentPresenter.this.Q();
                            QZoneFeedBottomGuideBarContentPresenter.this.R();
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        boolean c16 = b16.c();
                        RFWLog.i("QZoneFeedBottomGuideBarContentPresenter", RFWLog.USR, "handleQCircleEntrance, fileExists: " + c16);
                        if (c16) {
                            FeedGlobalEnv.g().postRunnableToUIThread(new RunnableC04641());
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneFeedBottomGuideBarContentPresenter";
    }

    @Override // vg.a, vg.c
    public void onStop() {
        LinearLayout linearLayout;
        BusinessFeedData businessFeedData;
        super.onStop();
        if (!this.J || (linearLayout = this.F) == null || (businessFeedData = this.K) == null || businessFeedData.cellAlbumEntrance == null) {
            return;
        }
        linearLayout.setVisibility(8);
        CellAlbumEntrance cellAlbumEntrance = this.K.cellAlbumEntrance;
        if (cellAlbumEntrance.busi_param == null) {
            cellAlbumEntrance.busi_param = new HashMap();
        }
        this.K.cellAlbumEntrance.busi_param.put("hasClicked", "true");
    }

    @Override // vg.a
    protected int s() {
        return R.id.nnm;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    public boolean y() {
        return super.y() && !zm.d.f452771a.c();
    }

    @Override // vg.a
    protected void C(View view) {
        this.F = (LinearLayout) view.findViewById(R.id.f162737k94);
        this.G = (ImageView) view.findViewById(R.id.l7a);
        this.H = (TextView) view.findViewById(R.id.nix);
    }
}
