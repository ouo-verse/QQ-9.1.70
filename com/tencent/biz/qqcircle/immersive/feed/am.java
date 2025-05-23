package com.tencent.biz.qqcircle.immersive.feed;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.immersive.events.QFSShowPolymerizationPanelEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSUnShowFreeFlowViewEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import qqcircle.QQCircleFeedBase$StFeedListBusiReqData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class am extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener {
    private LinearLayout I;
    private TextView J;
    private TextView K;
    private TextView L;
    private View M;
    private View N;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements View.OnLayoutChangeListener {
        a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            if (am.this.K.getLayout() != null && am.this.K.getWidth() != ((int) am.this.K.getLayout().getLineWidth(0))) {
                am.this.K.removeOnLayoutChangeListener(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) am.this.K.getLayout().getLineWidth(0), -2);
                layoutParams.gravity = 16;
                am.this.K.setLayoutParams(layoutParams);
            }
        }
    }

    private void h1() {
        LinearLayout linearLayout = this.I;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    private void i1() {
        if (this.I != null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) ((ViewStub) this.C.findViewById(R.id.f46551uw)).inflate();
        this.I = linearLayout;
        this.J = (TextView) linearLayout.findViewById(R.id.f348910d);
        this.K = (TextView) this.I.findViewById(R.id.f46531uu);
        this.L = (TextView) this.I.findViewById(R.id.f365914z);
        this.M = this.I.findViewById(R.id.f46501ur);
        this.N = this.I.findViewById(R.id.f46521ut);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void j1(Context context) {
        T t16 = this.f85017h;
        if (t16 == 0) {
            QLog.w("QFSFeedChildLocationInfoPresenter", 1, "[jumpLbsPage] invalid data");
            return;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) t16;
        QCirclePolymerizationBean qCirclePolymerizationBean = new QCirclePolymerizationBean();
        QQCircleFeedBase$StFeedListBusiReqData qQCircleFeedBase$StFeedListBusiReqData = new QQCircleFeedBase$StFeedListBusiReqData();
        qQCircleFeedBase$StFeedListBusiReqData.gpsInfo = feedCloudMeta$StFeed.poiInfo.gps;
        qCirclePolymerizationBean.setFeedListBusiReqData(qQCircleFeedBase$StFeedListBusiReqData);
        qCirclePolymerizationBean.setPolymerizationType(16);
        qCirclePolymerizationBean.setExt1From(1);
        qCirclePolymerizationBean.setPoiInfo(feedCloudMeta$StFeed.poiInfo);
        if (com.tencent.biz.qqcircle.immersive.utils.a.b()) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSShowPolymerizationPanelEvent((FeedCloudMeta$StFeed) this.f85017h, qCirclePolymerizationBean, true, m0().hashCode()));
        } else {
            com.tencent.biz.qqcircle.launcher.c.j0(context, qCirclePolymerizationBean);
        }
    }

    private void l1(int i3) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        String str;
        int i16;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2;
        QCircleExtraTypeInfo qCircleExtraTypeInfo = this.D;
        if (qCircleExtraTypeInfo != null) {
            feedCloudMeta$StFeed = qCircleExtraTypeInfo.mFeed;
        } else {
            feedCloudMeta$StFeed = null;
        }
        QCircleLpReportDc05501.DataBuilder subActionType = ua0.c.a(feedCloudMeta$StFeed).setActionType(i3).setSubActionType(2);
        QCircleExtraTypeInfo qCircleExtraTypeInfo2 = this.D;
        if (qCircleExtraTypeInfo2 != null && (feedCloudMeta$StFeed2 = qCircleExtraTypeInfo2.mFeed) != null) {
            str = feedCloudMeta$StFeed2.poster.f398463id.get();
        } else {
            str = "";
        }
        QCircleLpReportDc05501.DataBuilder toUin = subActionType.setToUin(str);
        QCircleExtraTypeInfo qCircleExtraTypeInfo3 = this.D;
        if (qCircleExtraTypeInfo3 != null) {
            i16 = qCircleExtraTypeInfo3.mDataPosition;
        } else {
            i16 = -1;
        }
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(toUin.setIndex(i16).setPageId(y0())));
    }

    private void m1() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        String str;
        int i3;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2;
        if (E0()) {
            QCircleExtraTypeInfo qCircleExtraTypeInfo = this.D;
            if (qCircleExtraTypeInfo != null) {
                feedCloudMeta$StFeed = qCircleExtraTypeInfo.mFeed;
            } else {
                feedCloudMeta$StFeed = null;
            }
            QCircleLpReportDc05501.DataBuilder subActionType = ua0.c.a(feedCloudMeta$StFeed).setActionType(92).setSubActionType(1);
            QCircleExtraTypeInfo qCircleExtraTypeInfo2 = this.D;
            if (qCircleExtraTypeInfo2 != null && (feedCloudMeta$StFeed2 = qCircleExtraTypeInfo2.mFeed) != null) {
                str = feedCloudMeta$StFeed2.poster.f398463id.get();
            } else {
                str = "";
            }
            QCircleLpReportDc05501.DataBuilder toUin = subActionType.setToUin(str);
            QCircleExtraTypeInfo qCircleExtraTypeInfo3 = this.D;
            if (qCircleExtraTypeInfo3 != null) {
                i3 = qCircleExtraTypeInfo3.mDataPosition;
            } else {
                i3 = -1;
            }
            QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(toUin.setIndex(i3).setPageId(y0())));
        }
    }

    private void n1() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.gravity = 16;
        layoutParams.weight = 1.0f;
        this.K.setLayoutParams(layoutParams);
        this.K.addOnLayoutChangeListener(new a());
    }

    private void o1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        String str;
        if (s0() != null && s0().getInitBean() != null && s0().getInitBean().getSchemeAttrs() != null && (str = s0().getInitBean().getSchemeAttrs().get("xsj_custom_pgid")) != null && str.equals(QCircleDaTongConstant.PageId.PG_XSJ_MINIGAME_FEED_PAGE)) {
            h1();
            return;
        }
        if (feedCloudMeta$StFeed != null && this.E.g() != null && this.E.g().liteBanner != null && TextUtils.isEmpty(this.E.g().liteBanner.title.get()) && this.E.g().liteBanner.style_type.get() == 0) {
            i1();
            String a16 = com.tencent.biz.qqcircle.utils.aa.a(feedCloudMeta$StFeed);
            if (TextUtils.isEmpty(a16)) {
                this.I.setVisibility(8);
            } else {
                this.I.setVisibility(0);
                if (a16.contains("\u00b7")) {
                    int indexOf = a16.indexOf("\u00b7");
                    this.J.setText(a16.substring(0, indexOf));
                    this.K.setText(a16.substring(indexOf + 1));
                    n1();
                    this.M.setVisibility(0);
                    this.K.setVisibility(0);
                } else {
                    this.J.setText(a16);
                    this.M.setVisibility(8);
                    this.K.setVisibility(8);
                }
                if (!TextUtils.isEmpty(feedCloudMeta$StFeed.poiInfo.distanceText.get())) {
                    this.L.setText(feedCloudMeta$StFeed.poiInfo.distanceText.get());
                    this.N.setVisibility(0);
                } else {
                    this.L.setText("");
                    this.N.setVisibility(8);
                }
                m1();
            }
            this.I.setOnClickListener(this);
            return;
        }
        h1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        super.C0(hVar);
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.ai) {
            h1();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        o1(feedCloudMeta$StFeed);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f46551uw) {
            j1(view.getContext());
            SimpleEventBus.getInstance().dispatchEvent(new QFSUnShowFreeFlowViewEvent());
            l1(92);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildLocationInfoPresenter";
    }
}
