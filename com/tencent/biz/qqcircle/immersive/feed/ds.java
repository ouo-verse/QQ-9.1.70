package com.tencent.biz.qqcircle.immersive.feed;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qqcircle.immersive.views.banner.QFSFeedTemplateBannerAdapter;
import com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleDitto$StCircleDittoDataNew;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ds extends b {
    private QFSImageBanner S;
    private QFSFeedTemplateBannerAdapter T;
    private String U = "";
    private View V;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends ViewPager2.OnPageChangeCallback {
        a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i3) {
            super.onPageSelected(i3);
            if (ds.this.T != null && ds.this.T.v0().size() > i3) {
                List<QQCircleDitto$StItemInfo> v06 = ds.this.T.v0();
                if (i3 < v06.size() - 1) {
                    QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder().setActionType(612).setSubActionType(1).setExt3(v06.get(i3).f429300id.get()));
                } else {
                    QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder().setActionType(612).setSubActionType(1).setExt3(ds.this.U));
                }
            }
        }
    }

    private void n1(int i3) {
        ViewGroup.LayoutParams layoutParams;
        View view = this.V;
        if (view == null) {
            layoutParams = null;
        } else {
            layoutParams = view.getLayoutParams();
        }
        if (!(layoutParams instanceof ConstraintLayout.LayoutParams)) {
            QLog.e("QFSTemplatePresenter", 1, "[initDittoTitleMargin] not is constraint layout params");
            return;
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = i3;
        ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = i3;
        this.V.setLayoutParams(layoutParams2);
    }

    private void o1() {
        LinearLayout linearLayout = this.Q;
        if (linearLayout != null) {
            linearLayout.setPadding(0, 0, 0, 0);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.b, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.S = (QFSImageBanner) view.findViewById(R.id.f34090y8);
        this.V = view.findViewById(R.id.f46111tp);
        int j3 = (com.tencent.biz.qqcircle.utils.bz.j() - ImmersiveUtils.dpToPx(270.0f)) / 2;
        n1(ImmersiveUtils.dpToPx(12.0f) + j3);
        this.S.setPageTransformer(new u70.a());
        this.S.setVpPadding(j3, 0, j3, 0);
        QFSFeedTemplateBannerAdapter qFSFeedTemplateBannerAdapter = new QFSFeedTemplateBannerAdapter();
        this.T = qFSFeedTemplateBannerAdapter;
        this.S.setAdapter(qFSFeedTemplateBannerAdapter);
        this.S.q0(new a());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: j1 */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        boolean z16;
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed.dittoFeed.dittoId.get() == 37) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        o1();
        List<QQCircleDitto$StItemInfo> list = ((QQCircleDitto$StCircleDittoDataNew) this.E.b(String.valueOf(feedCloudMeta$StFeed.dittoFeed.dittoId.get()))).itemContainter.get().items.get();
        this.T.setDatas(list);
        StringBuilder sb5 = new StringBuilder();
        Iterator<QQCircleDitto$StItemInfo> it = list.iterator();
        while (it.hasNext()) {
            sb5.append(it.next().f429300id.get());
            sb5.append(";");
        }
        this.U = sb5.toString();
        f0(this.S, QCircleDaTongConstant.ElementId.EM_XSJ_TEMPLATE_LIST_CARD);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.b, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        QFSFeedTemplateBannerAdapter qFSFeedTemplateBannerAdapter = this.T;
        if (qFSFeedTemplateBannerAdapter != null) {
            qFSFeedTemplateBannerAdapter.B0();
        }
        QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder().setActionType(612).setSubActionType(1).setExt3(this.U));
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.b, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        QFSFeedTemplateBannerAdapter qFSFeedTemplateBannerAdapter = this.T;
        if (qFSFeedTemplateBannerAdapter != null) {
            qFSFeedTemplateBannerAdapter.C0();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSTemplatePresenter";
    }
}
