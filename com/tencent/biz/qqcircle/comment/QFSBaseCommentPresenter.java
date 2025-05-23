package com.tencent.biz.qqcircle.comment;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectScrollProcessor;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.qqcircle.immersive.events.QFSShowPersonalPanelEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.qqcircle.utils.an;
import com.tencent.biz.qqcircle.utils.cq;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter;
import com.tencent.mobileqq.R;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.util.List;
import qqcircle.QQCircleFeedBase$StBusiInfoCommentListData;

/* loaded from: classes4.dex */
public class QFSBaseCommentPresenter {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage.a f83147a;

    /* loaded from: classes4.dex */
    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        public void d(int i3, int i16) {
            QCircleAspectScrollProcessor.getInstance().onScrollPageIdState(i3, i16);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            d(i3, 80003);
        }
    }

    private static String h(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f189063yd);
        if (feedCloudMeta$StFeed == null) {
            return a16;
        }
        String str = feedCloudMeta$StFeed.commentTextInfo.normalCommentBoxDesc.get();
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return a16;
    }

    public static boolean l(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.opMask2.get().contains(45)) {
            return true;
        }
        return false;
    }

    public static boolean m(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        boolean l3 = l(feedCloudMeta$StFeed);
        if (l3) {
            QCircleToast.u(h(feedCloudMeta$StFeed), 0, true);
        }
        return l3;
    }

    public static boolean n(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.right.ugcRight.rightFlag.get() == 2) {
            return true;
        }
        return false;
    }

    public static boolean o(Context context, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (!QCirclePluginUtil.isFeedOwner(feedCloudMeta$StFeed) || cq.f92752a.s(feedCloudMeta$StFeed) || !n(feedCloudMeta$StFeed)) {
            return false;
        }
        QCircleToast.u(context.getResources().getString(R.string.f181833eu), 0, true);
        return true;
    }

    public void a(List<FeedCloudMeta$StComment> list, List<FeedCloudMeta$StComment> list2) {
        if (list != null && list2 != null) {
            for (FeedCloudMeta$StComment feedCloudMeta$StComment : list) {
                if (feedCloudMeta$StComment != null && p(feedCloudMeta$StComment)) {
                    list2.add(feedCloudMeta$StComment);
                }
            }
        }
    }

    public void b(BlockContainer blockContainer, int i3) {
        View childAt;
        if (blockContainer == null || blockContainer.getRecyclerView().getChildCount() <= 0 || (childAt = blockContainer.getRecyclerView().getChildAt(blockContainer.getRecyclerView().getChildCount() - 1)) == null || !(blockContainer.getRecyclerView().findContainingViewHolder(childAt) instanceof PullLoadMoreAdapter.LoadMoreViewHolder)) {
            return;
        }
        childAt.setPadding(childAt.getPaddingLeft(), childAt.getPaddingTop(), childAt.getPaddingRight(), i3);
    }

    public QQCircleFeedBase$StBusiInfoCommentListData c(QCircleInitBean qCircleInitBean) {
        try {
            byte[] busiInfoData = qCircleInitBean.getBusiInfoData();
            if (busiInfoData == null) {
                return null;
            }
            QQCircleFeedBase$StBusiInfoCommentListData qQCircleFeedBase$StBusiInfoCommentListData = new QQCircleFeedBase$StBusiInfoCommentListData();
            qQCircleFeedBase$StBusiInfoCommentListData.mergeFrom(busiInfoData);
            qQCircleFeedBase$StBusiInfoCommentListData.setHasFlag(true);
            return qQCircleFeedBase$StBusiInfoCommentListData;
        } catch (Exception e16) {
            QLog.e("QFSBaseCommentPresenter", 1, "getInfoError", e16);
            return null;
        }
    }

    public String d(QFSCommentInfo qFSCommentInfo) {
        if (qFSCommentInfo == null) {
            return "";
        }
        String G = QFSCommentHelper.L().G(qFSCommentInfo.mFeed, null, null);
        an E = QFSCommentHelper.L().E(qFSCommentInfo.mFeed, null, null);
        if (E != null && !TextUtils.isEmpty(E.d())) {
            G = G + QCircleApplication.APP.getResources().getString(R.string.f182983hy);
        }
        if (E != null && !TextUtils.isEmpty(E.e())) {
            return G + QCircleApplication.APP.getResources().getString(R.string.image);
        }
        return G;
    }

    public String e(QCircleReportBean qCircleReportBean, com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> aVar) {
        if (qCircleReportBean != null) {
            return qCircleReportBean.getDtPageId();
        }
        if (aVar != null && aVar.getReportBean() != null) {
            return aVar.getReportBean().getDtPageId();
        }
        return null;
    }

    public int f(BlockContainer blockContainer, String str, String str2) {
        int i3 = -1;
        if (!TextUtils.isEmpty(str) && blockContainer != null) {
            for (int i16 = 0; i16 < blockContainer.getRecyclerView().getChildCount(); i16++) {
                View childAt = blockContainer.getRecyclerView().getChildAt(i16);
                if (childAt instanceof QFSCommentDefaultItemView) {
                    QFSCommentDefaultItemView qFSCommentDefaultItemView = (QFSCommentDefaultItemView) childAt;
                    if (qFSCommentDefaultItemView.L0() != null && qFSCommentDefaultItemView.L0().f398447id.get().equals(str)) {
                        RecyclerView T0 = qFSCommentDefaultItemView.T0();
                        if (T0 == null) {
                            return i3;
                        }
                        i3 = T0.getHeight();
                        if (TextUtils.isEmpty(str2)) {
                            return i3;
                        }
                        int i17 = 0;
                        while (true) {
                            if (i17 < T0.getChildCount()) {
                                View childAt2 = T0.getChildAt(i17);
                                if (childAt2 instanceof QFSReplyItemView) {
                                    QFSReplyItemView qFSReplyItemView = (QFSReplyItemView) childAt2;
                                    if (qFSReplyItemView.y0() != null && qFSReplyItemView.y0().f398460id.get().equals(str2)) {
                                        i3 -= qFSReplyItemView.getBottom();
                                        break;
                                    }
                                }
                                i17++;
                            }
                        }
                    }
                }
            }
        }
        return i3;
    }

    public String g(QFSCommentInfo qFSCommentInfo) {
        FeedCloudMeta$StUser m3 = QCirclePluginGlobalInfo.m();
        if (m3.is_e_da_xia.get()) {
            return com.tencent.biz.qqcircle.utils.h.a(R.string.f1899740u);
        }
        boolean z16 = true;
        if (1 == m3.label.get()) {
            return QCircleApplication.APP.getResources().getString(R.string.f181863ex);
        }
        if (!TextUtils.isEmpty(qFSCommentInfo.mHintText)) {
            return qFSCommentInfo.mHintText;
        }
        QFSCommentInfo.ActionBean actionBean = qFSCommentInfo.mActionBean;
        if (actionBean == null || !actionBean.mShowMaxHeight) {
            z16 = false;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = qFSCommentInfo.mFeed;
        if (feedCloudMeta$StFeed != null && !z16 && !TextUtils.isEmpty(feedCloudMeta$StFeed.commentTextInfo.normalCommentBoxDesc.get())) {
            return qFSCommentInfo.mFeed.commentTextInfo.normalCommentBoxDesc.get();
        }
        return uq3.c.b1("qqcircle", "qcircle_comment_list_input_place_holder", QCircleApplication.APP.getResources().getString(R.string.f181873ey));
    }

    public int i(String str, QCircleReportBean qCircleReportBean, com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> aVar) {
        if (qCircleReportBean != null) {
            return QCircleReportBean.getPageId(str, qCircleReportBean);
        }
        if (aVar != null) {
            return QCircleReportBean.getPageId(str, aVar.getReportBean());
        }
        return 0;
    }

    public int j(String str, QCircleReportBean qCircleReportBean, com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> aVar) {
        if (qCircleReportBean != null) {
            return QCircleReportBean.getParentPageId(str, qCircleReportBean);
        }
        if (aVar != null) {
            return QCircleReportBean.getParentPageId(str, aVar.getReportBean());
        }
        return 0;
    }

    public QCircleReportBean k(String str, QCircleReportBean qCircleReportBean, com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> aVar) {
        if (qCircleReportBean != null) {
            return QCircleReportBean.getReportBean(str, qCircleReportBean).m466clone();
        }
        if (aVar != null) {
            return QCircleReportBean.getReportBean(str, aVar.getReportBean()).m466clone();
        }
        return new QCircleReportBean();
    }

    public boolean p(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        if (feedCloudMeta$StComment != null && feedCloudMeta$StComment.sourceType.get() != 4) {
            return true;
        }
        return false;
    }

    public void q(Context context, FeedCloudMeta$StUser feedCloudMeta$StUser, QCircleReportBean qCircleReportBean, boolean z16, boolean z17, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        boolean z18;
        if (context != null && feedCloudMeta$StUser != null) {
            com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage.a aVar = this.f83147a;
            if (aVar != null && !aVar.isFullScreenComment()) {
                z18 = false;
            } else {
                z18 = true;
            }
            if (!z18 && af.n(feedCloudMeta$StUser)) {
                if (feedCloudMeta$StFeed == null) {
                    feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
                }
                feedCloudMeta$StFeed.poster.set(feedCloudMeta$StUser);
                QFSShowPersonalPanelEvent qFSShowPersonalPanelEvent = new QFSShowPersonalPanelEvent(feedCloudMeta$StFeed, true, context.hashCode());
                qFSShowPersonalPanelEvent.setPanelModel(2);
                qFSShowPersonalPanelEvent.setNeedMaskView(true);
                SimpleEventBus.getInstance().dispatchEvent(qFSShowPersonalPanelEvent);
                return;
            }
            QCircleInitBean qCircleInitBean = new QCircleInitBean();
            qCircleInitBean.setUser(feedCloudMeta$StUser);
            qCircleInitBean.setFromReportBean(qCircleReportBean.m466clone());
            qCircleInitBean.setEnableReleaseAudioFocus(z16);
            qCircleInitBean.setClientFromType(2);
            qCircleInitBean.setStartNewIntent(z17);
            if (feedCloudMeta$StFeed != null) {
                qCircleInitBean.setFeed(feedCloudMeta$StFeed);
            }
            com.tencent.biz.qqcircle.launcher.c.d0(context, qCircleInitBean);
        }
    }

    public void r(BlockContainer blockContainer) {
        NestScrollRecyclerView recyclerView;
        if (blockContainer == null || (recyclerView = blockContainer.getRecyclerView()) == null) {
            return;
        }
        recyclerView.addOnScrollListener(new a());
    }

    public void s(final BlockContainer blockContainer, final View view) {
        if (view == null) {
            return;
        }
        view.getLocationOnScreen(r4);
        final int[] iArr = {0, iArr[1] + view.getHeight()};
        final int J = QFSCommentHelper.L().J();
        if (iArr[1] > J && blockContainer != null) {
            blockContainer.getRecyclerView().scrollBy(0, iArr[1] - J);
            b(blockContainer, iArr[1] - J);
            RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.QFSBaseCommentPresenter.2
                @Override // java.lang.Runnable
                public void run() {
                    view.getLocationOnScreen(iArr);
                    int[] iArr2 = iArr;
                    iArr2[1] = iArr2[1] + view.getHeight();
                    if (iArr[1] > J) {
                        blockContainer.getRecyclerView().scrollBy(0, iArr[1] - J);
                    }
                }
            }, 1L, true);
        }
    }

    public void t(com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage.a aVar) {
        this.f83147a = aVar;
    }
}
