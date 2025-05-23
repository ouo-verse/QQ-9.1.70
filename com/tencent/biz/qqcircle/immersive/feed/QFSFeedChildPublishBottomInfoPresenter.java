package com.tencent.biz.qqcircle.immersive.feed;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView;
import com.tencent.biz.qqcircle.widgets.QCircleMaxHeightScrollView;
import com.tencent.biz.qqcircle.widgets.QFSVipNickNameAndIconView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StTagInfo;
import java.util.HashMap;
import java.util.Map;
import qqcircle.QQCircleDitto$StCircleDittoDataNew;

/* loaded from: classes4.dex */
public class QFSFeedChildPublishBottomInfoPresenter extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private LinearLayout I;
    private TextView J;
    private QFSVipNickNameAndIconView K;
    private QCircleMaxHeightScrollView L;
    private QCircleExpandableTextView M;
    private FeedCloudMeta$StFeed N;

    /* loaded from: classes4.dex */
    class a implements QFSVipNickNameAndIconView.a {
        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c implements RFWAsyncRichTextView.OnClickAtTextListener {
        c() {
        }

        @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickAtTextListener
        public void onClick(String str) {
            if (QFSFeedChildPublishBottomInfoPresenter.this.N != null && QFSFeedChildPublishBottomInfoPresenter.this.C != null) {
                QCircleInitBean qCircleInitBean = new QCircleInitBean();
                qCircleInitBean.setUin(str);
                qCircleInitBean.setFeed(QFSFeedChildPublishBottomInfoPresenter.this.N);
                if (QFSFeedChildPublishBottomInfoPresenter.this.getReportBean() != null) {
                    qCircleInitBean.setFromReportBean(QFSFeedChildPublishBottomInfoPresenter.this.getReportBean().m466clone());
                }
                com.tencent.biz.qqcircle.launcher.c.d0(QFSFeedChildPublishBottomInfoPresenter.this.C.getContext(), qCircleInitBean);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class d implements RFWAsyncRichTextView.OnClickHashTagTextListener {
        d() {
        }

        @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickHashTagTextListener
        public void onClick(String str) {
            if (QFSFeedChildPublishBottomInfoPresenter.this.C != null) {
                QCirclePolymerizationBean qCirclePolymerizationBean = new QCirclePolymerizationBean();
                FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo = new FeedCloudMeta$StTagInfo();
                feedCloudMeta$StTagInfo.tagName.set(str);
                qCirclePolymerizationBean.setTagInfo(feedCloudMeta$StTagInfo);
                qCirclePolymerizationBean.setFromReportBean(QFSFeedChildPublishBottomInfoPresenter.this.getReportBean().m466clone());
                qCirclePolymerizationBean.setPolymerizationType(7);
                qCirclePolymerizationBean.setExt1From(3);
                com.tencent.biz.qqcircle.launcher.c.G(QFSFeedChildPublishBottomInfoPresenter.this.C.getContext(), qCirclePolymerizationBean);
                if (QFSFeedChildPublishBottomInfoPresenter.this.N != null && !TextUtils.isEmpty(str)) {
                    QFSFeedChildPublishBottomInfoPresenter qFSFeedChildPublishBottomInfoPresenter = QFSFeedChildPublishBottomInfoPresenter.this;
                    qFSFeedChildPublishBottomInfoPresenter.r1(16, 2, qFSFeedChildPublishBottomInfoPresenter.N, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l1(final int i3, final int i16, final QCircleExtraTypeInfo qCircleExtraTypeInfo, final String str) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildPublishBottomInfoPresenter.3
            @Override // java.lang.Runnable
            public void run() {
                QFSFeedChildPublishBottomInfoPresenter.this.R0(i3, i16, qCircleExtraTypeInfo, str);
            }
        });
    }

    private void m1(View view, String str, Map<String, Object> map) {
        e30.b bVar = this.E;
        if (bVar != null && bVar.g() != null && view != null && !TextUtils.isEmpty(str)) {
            VideoReport.setElementId(view, str);
            HashMap hashMap = new HashMap();
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.f85018i + 1));
            if (map != null && map.size() > 0) {
                hashMap.putAll(map);
            }
            VideoReport.setElementReuseIdentifier(view, str + this.E.g().f398449id.get());
            VideoReport.setElementParams(view, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n1() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.N;
        if (feedCloudMeta$StFeed != null && 2 == feedCloudMeta$StFeed.type.get()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed, boolean z16) {
        TextView c16 = this.M.c();
        VideoReport.setElementId(c16, QCircleDaTongConstant.ElementId.EM_XSJ_PLAIN_CMT_EXPAND_BUTTON);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, feedCloudMeta$StFeed.poster.f398463id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PARENT_EMID, QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA);
        if (z16) {
            VideoReport.reportEvent("dt_clck", c16, buildElementParams);
        } else {
            VideoReport.setElementParams(c16, buildElementParams);
        }
    }

    private void q1(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed, boolean z16) {
        TextView e16 = this.M.e();
        VideoReport.setElementClickPolicy(e16, ClickPolicy.REPORT_NONE);
        VideoReport.setElementId(e16, QCircleDaTongConstant.ElementId.EM_XSJ_PLAIN_CMT_COPY);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, feedCloudMeta$StFeed.poster.f398463id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PARENT_EMID, QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA);
        VideoReport.setElementParams(e16, buildElementParams);
        if (z16) {
            VideoReport.reportEvent("ev_xsj_abnormal_clck", e16, buildElementParams);
        } else {
            VideoReport.setElementParams(e16, buildElementParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r1(int i3, int i16, FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str) {
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(ua0.c.a(feedCloudMeta$StFeed).setActionType(i3).setSubActionType(i16).setExt1(str)).setPageId(y0()));
    }

    private void s1() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.N;
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        this.K.setUser(feedCloudMeta$StFeed.poster);
        this.K.setReportData(new QFSVipNickNameAndIconView.b().g(this.N).k(r0()));
        String str = this.N.poster.nick.get();
        if (!TextUtils.isEmpty(str)) {
            this.K.w0("@" + str);
        }
        m1(this.K, "em_xsj_author_name", null);
    }

    private void t1() {
        if (this.N == null) {
            return;
        }
        TextView e16 = this.M.e();
        if (e16 instanceof QCircleAsyncTextView) {
            e16.setTextSize(2, 14.0f);
            ((QCircleAsyncTextView) e16).setPreloadParserInfo(uc0.a.a(this.N));
        }
        TextView c16 = this.M.c();
        if (c16 != null) {
            c16.setTextSize(2, 14.0f);
        }
        this.M.setOnClickHashTagListener(new d());
        this.M.setSpecialAreaTextColor(R.color.f158017al3);
        this.M.setNeedSpecialAreaBold(true);
        this.M.setText(this.N.content.get(), false, new c());
        this.M.setVisibility(0);
        this.L.setVisibility(0);
        this.M.setOnClickListener(new e());
        this.M.setListener(new b());
        this.M.setDisableExpand(true);
        if (TextUtils.isEmpty(this.N.content.get())) {
            this.M.setVisibility(8);
            this.L.setVisibility(8);
        }
        q1(this.N, false);
    }

    private void u1() {
        boolean z16;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.N;
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        if (feedCloudMeta$StFeed.right.ugcRight.rightFlag.get() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.I.setVisibility(0);
            this.J.setText(this.N.right.rightDisplayText.get());
        } else {
            this.I.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void K0() {
        super.K0();
        com.tencent.biz.qqcircle.utils.l.i("exp_tagstrengthen_2");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.I = (LinearLayout) view.findViewById(R.id.f40971ft);
        this.J = (TextView) view.findViewById(R.id.f41001fw);
        QFSVipNickNameAndIconView qFSVipNickNameAndIconView = (QFSVipNickNameAndIconView) view.findViewById(R.id.v_i);
        this.K = qFSVipNickNameAndIconView;
        qFSVipNickNameAndIconView.setNickNameClickListener(new a());
        QCircleMaxHeightScrollView qCircleMaxHeightScrollView = (QCircleMaxHeightScrollView) view.findViewById(R.id.f58152p9);
        this.L = qCircleMaxHeightScrollView;
        qCircleMaxHeightScrollView.setMaxHeight((int) (ImmersiveUtils.getScreenHeight() * 0.6f));
        this.M = (QCircleExpandableTextView) view.findViewById(R.id.f165233va0);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: o1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        if (feedCloudMeta$StFeed == null) {
            QLog.e("QFSFeedChildPublishBottomInfoPresenter", 1, "onBindData  data == null");
            return;
        }
        super.L0(feedCloudMeta$StFeed, i3);
        QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew = (QQCircleDitto$StCircleDittoDataNew) this.E.b("DITTO_FEED_PUBLISH_TEMPLATE");
        if (qQCircleDitto$StCircleDittoDataNew != null && qQCircleDitto$StCircleDittoDataNew.itemContainter.get() != null && qQCircleDitto$StCircleDittoDataNew.itemContainter.items.size() > 0 && qQCircleDitto$StCircleDittoDataNew.itemContainter.items.get(0).feeds.size() > 0) {
            this.N = qQCircleDitto$StCircleDittoDataNew.itemContainter.items.get(0).feeds.get(0);
            u1();
            s1();
            t1();
            return;
        }
        QLog.e("QFSFeedChildPublishBottomInfoPresenter", 1, "onBindData  dittoData error");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildPublishBottomInfoPresenter";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements QCircleExpandableTextView.c {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView.c
        public void X0(boolean z16) {
            String str;
            if (QFSFeedChildPublishBottomInfoPresenter.this.E0()) {
                QFSFeedChildPublishBottomInfoPresenter qFSFeedChildPublishBottomInfoPresenter = QFSFeedChildPublishBottomInfoPresenter.this;
                QCircleExtraTypeInfo r16 = qFSFeedChildPublishBottomInfoPresenter.r();
                if (QFSFeedChildPublishBottomInfoPresenter.this.n1()) {
                    str = "1";
                } else {
                    str = "2";
                }
                qFSFeedChildPublishBottomInfoPresenter.l1(82, 1, r16, str);
                if (!z16) {
                    QFSFeedChildPublishBottomInfoPresenter qFSFeedChildPublishBottomInfoPresenter2 = QFSFeedChildPublishBottomInfoPresenter.this;
                    qFSFeedChildPublishBottomInfoPresenter2.p1(qFSFeedChildPublishBottomInfoPresenter2.N, false);
                }
            }
        }

        @Override // com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView.c
        public void Y0(boolean z16) {
            int i3;
            String str;
            QFSFeedChildPublishBottomInfoPresenter qFSFeedChildPublishBottomInfoPresenter = QFSFeedChildPublishBottomInfoPresenter.this;
            if (z16) {
                i3 = 2;
            } else {
                i3 = 3;
            }
            QCircleExtraTypeInfo r16 = qFSFeedChildPublishBottomInfoPresenter.r();
            if (QFSFeedChildPublishBottomInfoPresenter.this.n1()) {
                str = "1";
            } else {
                str = "2";
            }
            qFSFeedChildPublishBottomInfoPresenter.l1(82, i3, r16, str);
            QFSFeedChildPublishBottomInfoPresenter.this.T0(new com.tencent.biz.qqcircle.immersive.feed.event.p(z16));
            if (z16) {
                QFSFeedChildPublishBottomInfoPresenter qFSFeedChildPublishBottomInfoPresenter2 = QFSFeedChildPublishBottomInfoPresenter.this;
                qFSFeedChildPublishBottomInfoPresenter2.p1(qFSFeedChildPublishBottomInfoPresenter2.N, true);
            }
        }

        @Override // com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView.c
        public void W0(boolean z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }
}
