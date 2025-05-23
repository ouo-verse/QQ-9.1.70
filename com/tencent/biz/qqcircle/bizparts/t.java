package com.tencent.biz.qqcircle.bizparts;

import android.util.Size;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StUser;
import java.util.List;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase$StTagPageData;
import qqcircle.QQCircleRankinglist$RankingItem;

/* compiled from: P */
/* loaded from: classes4.dex */
public class t extends QFSPolymerizationBaseSharePart implements View.OnClickListener {
    public static final int I = com.tencent.biz.qqcircle.utils.cx.a(52.0f);
    public static final int J = com.tencent.biz.qqcircle.utils.cx.a(44.0f);
    private static final int K = com.tencent.biz.qqcircle.utils.cx.a(24.0f);
    private TextView C;
    private ImageView D;
    private FrameLayout E;
    private QCircleAvatarView F;
    private QCircleAvatarView G;
    private LinearLayout H;

    public t(QCirclePolymerizationBean qCirclePolymerizationBean) {
        super(qCirclePolymerizationBean);
    }

    private void J9() {
        FrameLayout frameLayout = this.E;
        if (frameLayout == null) {
            return;
        }
        VideoReport.setElementId(frameLayout, QCircleDaTongConstant.ElementId.EM_XSJ_ROCKET_RANKING_ICON);
        VideoReport.setElementParams(this.E, new QCircleDTParamBuilder().buildElementParams());
    }

    private void K9(QQCircleFeedBase$StTagPageData qQCircleFeedBase$StTagPageData) {
        if (qQCircleFeedBase$StTagPageData != null && qQCircleFeedBase$StTagPageData.urlInfo.has()) {
            com.tencent.biz.qqcircle.launcher.c.o0(getContext(), com.tencent.biz.qqcircle.d.d(qQCircleFeedBase$StTagPageData.urlInfo.get(), "tagFuelRankUrl"), null, -1);
            QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(46).setSubActionType(4).setThrActionType(1).setExt6(String.valueOf(this.mInitBean.getPolymerizationName())).setPageId(getPageId()));
        } else {
            QLog.e("QCirclePolymerizationClipPart", 1, "[launchFuelListPage] stTagPageData == null || url == null");
        }
    }

    private void L9(QQCircleFeedBase$StTagPageData qQCircleFeedBase$StTagPageData) {
        if (this.E != null && this.F != null && this.G != null) {
            List<QQCircleRankinglist$RankingItem> list = qQCircleFeedBase$StTagPageData.fuelCircleRankItem.get();
            if (RFSafeListUtils.isEmpty(list)) {
                QLog.e("QCirclePolymerizationClipPart", 1, "[updateFuelListView] rankingItemList == null");
                this.E.setVisibility(8);
                return;
            }
            this.E.setVisibility(0);
            this.E.setOnClickListener(this);
            J9();
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (i3 == 0) {
                    QCircleAvatarView qCircleAvatarView = this.F;
                    FeedCloudMeta$StUser feedCloudMeta$StUser = list.get(i3).user;
                    int i16 = K;
                    qCircleAvatarView.setAvatar(feedCloudMeta$StUser, new Size(i16, i16));
                } else if (i3 == 1) {
                    QCircleAvatarView qCircleAvatarView2 = this.G;
                    FeedCloudMeta$StUser feedCloudMeta$StUser2 = list.get(i3).user;
                    int i17 = K;
                    qCircleAvatarView2.setAvatar(feedCloudMeta$StUser2, new Size(i17, i17));
                } else {
                    return;
                }
            }
            return;
        }
        QLog.e("QCirclePolymerizationClipPart", 1, "[updateFuelListView] mFuelListWrapper == null || mFuelListAvatarListView == null");
    }

    @Override // com.tencent.biz.qqcircle.bizparts.QFSPolymerizationBaseSharePart
    @NonNull
    protected ImageView D9() {
        return (ImageView) getPartRootView().findViewById(R.id.f165970y94);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.bizparts.QFSPolymerizationBaseSharePart
    public void E9(QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData) {
        super.E9(qQCircleFeedBase$StFeedListBusiRspData);
        this.C.setText(this.mInitBean.getPolymerizationName());
        if (qQCircleFeedBase$StFeedListBusiRspData != null) {
            L9(qQCircleFeedBase$StFeedListBusiRspData.tagPageData.get());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCirclePolymerizationClipPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        QQCircleFeedBase$StFeedListBusiRspData mBusiRspData;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.du6) {
            if (!getPartManager().onBackEvent() && getActivity() != null) {
                getActivity().finish();
            }
        } else if (id5 == R.id.f493422f && (mBusiRspData = getMBusiRspData()) != null) {
            K9(mBusiRspData.tagPageData);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.QFSPolymerizationBaseSharePart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.C = (TextView) view.findViewById(R.id.kbs);
        this.D = (ImageView) view.findViewById(R.id.du6);
        this.E = (FrameLayout) view.findViewById(R.id.f493422f);
        this.F = (QCircleAvatarView) view.findViewById(R.id.f493522g);
        this.G = (QCircleAvatarView) view.findViewById(R.id.f493622h);
        this.D.setOnClickListener(this);
        if (getHostFragment() instanceof QCircleBaseFragment) {
            ((QCircleBaseFragment) getHostFragment()).setExcludeInteractiveView(this.D);
        }
        this.H = (LinearLayout) view.findViewById(R.id.f760440l);
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(view.getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, I);
        layoutParams.topMargin = statusBarHeight;
        this.H.setLayoutParams(layoutParams);
    }
}
