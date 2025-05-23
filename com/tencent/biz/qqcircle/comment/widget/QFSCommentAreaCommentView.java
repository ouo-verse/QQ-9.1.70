package com.tencent.biz.qqcircle.comment.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.adapter.QFSCommentBlock;
import com.tencent.biz.qqcircle.adapter.ac;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.qqcircle.beans.QFSCommentItemInfo;
import com.tencent.biz.qqcircle.bizparts.QFSCommentPanelPart;
import com.tencent.biz.qqcircle.comment.QFSBaseCommentPresenter;
import com.tencent.biz.qqcircle.comment.QFSCommentBaseItemView;
import com.tencent.biz.qqcircle.comment.QFSCommentFeedDescItemView;
import com.tencent.biz.qqcircle.comment.af;
import com.tencent.biz.qqcircle.comment.animation.QFSMoreReplyAnimation;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.fragments.QCircleBlockMerger;
import com.tencent.biz.qqcircle.hodor.QFSHodorCollectManager;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.cq;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QCirclePanelLoadingView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseRejected;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoaderFactory;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.event.QFSRemoveFeedbackCardEvent;
import com.tencent.mobileqq.qcircle.api.event.QFSReportResultEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentAreaCommentView extends QCircleBaseWidgetView<QFSCommentInfo> implements SimpleEventReceiver {
    private TextView C;
    private boolean D;
    private com.tencent.biz.qqcircle.widgets.comment.c E;
    private com.tencent.biz.qqcircle.viewmodels.n F;
    private com.tencent.biz.qqcircle.adapter.u G;
    private final HashMap<Integer, String> H;
    private boolean I;
    private QCircleReportBean J;

    /* renamed from: d, reason: collision with root package name */
    private QCircleBlockContainer f84002d;

    /* renamed from: e, reason: collision with root package name */
    protected QFSCommentBlock f84003e;

    /* renamed from: f, reason: collision with root package name */
    private QCirclePanelLoadingView f84004f;

    /* renamed from: h, reason: collision with root package name */
    private ViewGroup f84005h;

    /* renamed from: i, reason: collision with root package name */
    private QFSCommentFeedDescItemView f84006i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f84007m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QFSCommentAreaCommentView.this.f84002d.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements OnPromiseResolved<r20.a> {
        b() {
        }

        @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onDone(r20.a aVar) {
            boolean z16 = true;
            if (aVar == null) {
                QLog.e(QFSCommentAreaCommentView.this.getLogTag(), 1, "[initBlockContainer] ioc == null");
                return;
            }
            QFSCommentAreaCommentView qFSCommentAreaCommentView = QFSCommentAreaCommentView.this;
            if (!(aVar instanceof QFSCommentPanelPart) && !(aVar instanceof com.tencent.biz.qqcircle.immersive.layer.biz.inside.fullscreen.b)) {
                z16 = false;
            }
            qFSCommentAreaCommentView.D = z16;
            if (aVar instanceof com.tencent.biz.qqcircle.widgets.comment.c) {
                QFSCommentAreaCommentView.this.E = (com.tencent.biz.qqcircle.widgets.comment.c) aVar;
            }
            QFSCommentAreaCommentView.this.n1(aVar.getCommentPartHost());
            if (QFSCommentAreaCommentView.this.J1()) {
                return;
            }
            QFSCommentAreaCommentView.this.f84003e = aVar.getCmtBlock();
            QFSCommentAreaCommentView.this.f84002d.registerBlock(QFSCommentAreaCommentView.this.f84003e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f84010d;

        c(LinearLayoutManager linearLayoutManager) {
            this.f84010d = linearLayoutManager;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                QFSCommentAreaCommentView.this.j1(this.f84010d);
                VideoReport.traversePage(recyclerView);
            } else if (i3 == 1) {
                QFSCommentAreaCommentView.this.L0(this.f84010d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements OnPromiseRejected {
        d() {
        }

        @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseRejected
        public void onFail(String str) {
            QLog.e(QFSCommentAreaCommentView.this.getLogTag(), 1, new RuntimeException("[getCommentPartIoc]  error = " + str), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class e implements OnPromiseResolved<r20.a> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OnPromiseResolved f84013a;

        e(OnPromiseResolved onPromiseResolved) {
            this.f84013a = onPromiseResolved;
        }

        @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onDone(r20.a aVar) {
            this.f84013a.onDone(aVar);
        }
    }

    public QFSCommentAreaCommentView(@NonNull Context context, QCircleReportBean qCircleReportBean) {
        super(context);
        this.H = new HashMap<>();
        this.I = true;
        this.J = qCircleReportBean;
        initView();
        k1();
        QFSHodorCollectManager.f84689a.c("qfs_comment_panel_cost");
    }

    private void A1(View view, int i3) {
        QFSCommentBaseItemView qFSCommentBaseItemView = (QFSCommentBaseItemView) view;
        if (!qFSCommentBaseItemView.r0()) {
            qFSCommentBaseItemView.p0();
            J0(qFSCommentBaseItemView.q0());
        } else {
            if (this.H.containsKey(Integer.valueOf(i3)) && TextUtils.equals(this.H.get(Integer.valueOf(i3)), "true")) {
                qFSCommentBaseItemView.u0();
                return;
            }
            qFSCommentBaseItemView.v0();
            I0(qFSCommentBaseItemView.q0());
            this.H.put(Integer.valueOf(i3), "true");
        }
    }

    private void B1(QFSCommentInfo qFSCommentInfo) {
        QLog.d("QFSCommentAreaCommentView", 1, "[showFeedDescView]");
        this.f84006i.setFeed(qFSCommentInfo.mFeed);
        QFSCommentItemInfo qFSCommentItemInfo = new QFSCommentItemInfo(0);
        if (qFSCommentInfo.mFrom == 1) {
            qFSCommentItemInfo.mContentLimitLines = 3;
            qFSCommentItemInfo.mDefaultExpanded = true;
        } else {
            qFSCommentItemInfo.mContentLimitLines = 3;
            qFSCommentItemInfo.mDefaultExpanded = false;
        }
        this.f84006i.bindData(qFSCommentItemInfo, 0);
        this.f84006i.setOnCommentElementClickListener(this.E);
        this.f84006i.setVisibility(0);
        if (!(this.f84005h.getChildAt(0) instanceof QFSCommentFeedDescItemView)) {
            this.f84005h.addView(this.f84006i, 0, new ViewGroup.LayoutParams(-1, -2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D1() {
        QCircleBlockContainer qCircleBlockContainer = this.f84002d;
        if (qCircleBlockContainer != null) {
            VideoReport.traversePage(qCircleBlockContainer.getRecyclerView());
        }
    }

    private void E0() {
        if (this.f84002d.getRecyclerView().getItemAnimator() == null) {
            this.f84002d.getRecyclerView().setItemAnimator(new QFSMoreReplyAnimation());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0() {
        QCirclePanelLoadingView qCirclePanelLoadingView = this.f84004f;
        if (qCirclePanelLoadingView != null && qCirclePanelLoadingView.getLayoutParams() != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f84004f.getLayoutParams();
            layoutParams.gravity = 49;
            layoutParams.topMargin = (getMeasuredHeight() - this.f84004f.getMeasuredHeight()) / 2;
            this.f84004f.setLayoutParams(layoutParams);
            QLog.d("QFSCommentAreaCommentView", 4, "[adjustLoadingMargin] topMargin: " + layoutParams.topMargin);
        }
    }

    private void F1() {
        O0(this.f84005h, new OnPromiseResolved() { // from class: com.tencent.biz.qqcircle.comment.widget.d
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                QFSCommentAreaCommentView.this.v1((r20.a) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G1(String str) {
        int d16;
        UIStateData<List<QFSCommentItemInfo>> value;
        ViewGroup viewGroup = this.f84005h;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setVisibility(8);
        this.C.setVisibility(8);
        this.f84006i.setVisibility(8);
        if (cq.f92752a.r(this.F.b2().getValue())) {
            z1(false);
            this.f84005h.setVisibility(0);
            this.f84007m.setText(str);
            this.f84007m.setTextColor(QFSQUIUtilsKt.d(getContext(), R.color.qui_common_text_secondary));
            return;
        }
        if (Boolean.TRUE.equals(this.F.Z1().getValue())) {
            QLog.d(getLogTag(), 1, "[updateListEmptyTextView] loading... ");
            return;
        }
        if (J1() && (value = this.F.c2().getValue()) != null && !RFSafeListUtils.isEmpty(value.getData())) {
            QLog.d("QFSCommentAreaCommentView", 1, "[updateListEmptyTextView] useNewCommentItemView == true. has showing comment. ");
            z1(true);
            return;
        }
        QFSCommentBlock qFSCommentBlock = this.f84003e;
        if (qFSCommentBlock != null && qFSCommentBlock.getNUM_BACKGOURND_ICON() != 0) {
            z1(true);
            return;
        }
        this.f84005h.setVisibility(0);
        F1();
        this.f84007m.setText("\u6682\u65e0\u53ef\u5c55\u793a\u8bc4\u8bba");
        TextView textView = this.f84007m;
        if (M0()) {
            d16 = QFSQUIUtilsKt.d(getContext(), R.color.qui_common_text_primary);
        } else {
            d16 = QFSQUIUtilsKt.d(getContext(), R.color.qui_common_text_secondary);
        }
        textView.setTextColor(d16);
        this.C.setVisibility(8);
        z1(false);
        H0();
    }

    private void H0() {
        VideoReport.setElementId(this.C, QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL_QUICK_SEND_BUTTON);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_item_name", com.tencent.biz.qqcircle.utils.h.a(R.string.f189203yr));
        VideoReport.setElementParams(this.C, buildElementParams);
        VideoReport.setElementExposePolicy(this.C, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.C, ClickPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H1(boolean z16) {
        QLog.d(getLogTag(), 1, "[handleCommentBlockLoadingStatus] isShowLoading = " + z16);
        QCirclePanelLoadingView qCirclePanelLoadingView = this.f84004f;
        if (qCirclePanelLoadingView != null && this.f84002d != null) {
            if (z16) {
                qCirclePanelLoadingView.n0();
                this.f84004f.post(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.widget.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        QFSCommentAreaCommentView.this.F0();
                    }
                });
                this.f84002d.setVisibility(8);
                ViewGroup viewGroup = this.f84005h;
                if (viewGroup != null) {
                    viewGroup.setVisibility(8);
                    return;
                }
                return;
            }
            qCirclePanelLoadingView.k0();
            if (this.f84002d.getVisibility() != 0) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f84002d, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
                ofFloat.setDuration(200L);
                ofFloat.addListener(new a());
                ofFloat.start();
            }
        }
    }

    private void I0(View view) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AVATAR_IF_DIFF, 1);
        VideoReport.setElementId(view, "em_xsj_author_avatar");
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I1(String str) {
        QCircleBlockContainer qCircleBlockContainer = this.f84002d;
        if (qCircleBlockContainer != null && this.F != null && qCircleBlockContainer.getBlockMerger() != null) {
            QLog.d("QFSCommentAreaCommentView", 4, "[updateNoMoreHintText] text: " + str);
            Boolean bool = Boolean.TRUE;
            if (bool.equals(this.F.Z1().getValue())) {
                QLog.d("QFSCommentAreaCommentView", 4, "[updateNoMoreHintText] is loading comment. ");
                return;
            }
            boolean equals = bool.equals(this.F.g2().getValue());
            if (equals) {
                QLog.d("QFSCommentAreaCommentView", 1, "[updateNoMoreHintText] isFinish");
                this.f84002d.getBlockMerger().setNoMoreHint(str);
            }
            this.f84002d.getBlockMerger().onLoadMoreCompleted(true, equals);
        }
    }

    private void J0(View view) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AVATAR_IF_DIFF, 0);
        VideoReport.setElementId(view, "em_xsj_author_avatar");
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J1() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101664", true) && this.F != null && this.D) {
            return true;
        }
        return false;
    }

    private boolean K0() {
        UIStateData<List<FeedCloudMeta$StComment>> value = this.F.e2().getValue();
        if (value != null && !RFSafeListUtils.isEmpty(value.getData())) {
            return false;
        }
        return true;
    }

    private boolean M0() {
        boolean z16;
        com.tencent.biz.qqcircle.viewmodels.n nVar = this.F;
        if (nVar == null || nVar.b2() == null || this.F.b2().getValue() == null) {
            return false;
        }
        FeedCloudMeta$StFeed value = this.F.b2().getValue();
        if (QCirclePluginUtil.isFeedOwner(value) && cq.f92752a.s(value)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        if (QFSBaseCommentPresenter.n(value)) {
            return false;
        }
        return !QFSBaseCommentPresenter.l(value);
    }

    private String P0() {
        com.tencent.biz.qqcircle.viewmodels.n nVar = this.F;
        if (nVar != null && nVar.b2() != null && this.F.b2().getValue() != null) {
            return this.F.b2().getValue().f398449id.get();
        }
        return "";
    }

    private void S0(List<QFSCommentItemInfo> list, int i3, boolean z16) {
        QCircleBlockContainer qCircleBlockContainer;
        int i16;
        if (list != null && i3 < list.size() && (qCircleBlockContainer = this.f84002d) != null && qCircleBlockContainer.getBlockMerger() != null && i3 <= this.f84002d.getBlockMerger().getDataNumber()) {
            if (list.size() == 1) {
                this.f84002d.getRecyclerView().setItemAnimator(null);
                I1(com.tencent.biz.qqcircle.utils.h.a(R.string.f184043kt));
            }
            QFSCommentItemInfo qFSCommentItemInfo = list.get(i3);
            qFSCommentItemInfo.mDefaultExpanded = true;
            ac acVar = new ac(null);
            acVar.S0(i3);
            acVar.U0(this.E);
            acVar.T0(this.F.b2().getValue());
            acVar.setDatas(Collections.singletonList(qFSCommentItemInfo));
            if (h1()) {
                i16 = i3 + 1;
            } else {
                i16 = i3;
            }
            if (i1()) {
                i3++;
            }
            this.f84002d.getBlockMerger().registerBlock(acVar, i16);
            boolean z17 = false;
            int i17 = 0;
            for (MultiViewBlock multiViewBlock : this.f84002d.getBlockMerger().getDataList()) {
                if (multiViewBlock == this.G && i1()) {
                    i17++;
                }
                if (multiViewBlock == acVar) {
                    break;
                } else {
                    i17 += multiViewBlock.getNUM_BACKGOURND_ICON();
                }
            }
            int findFirstVisibleItemPosition = ((LinearLayoutManager) this.f84002d.getLayoutManager()).findFirstVisibleItemPosition();
            if (findFirstVisibleItemPosition <= i17) {
                z17 = true;
            }
            if (z17) {
                this.f84002d.getBlockMerger().notifyItemInserted(i17);
            }
            if (z16) {
                this.f84002d.getRecyclerView().scrollToPosition(i3);
            }
            QLog.d("QFSCommentAreaCommentView", 1, "[handleAddFakeComment] type: " + qFSCommentItemInfo.type + " hasFeedDesc: " + h1() + " scrollToTop: " + z16 + " insertPos: " + i16 + " adapterPos: " + i17 + " firstVisibleItemPosition: " + findFirstVisibleItemPosition + ", pos:" + i3);
        }
    }

    private void T0(UIStateData<List<QFSCommentItemInfo>> uIStateData) {
        QCircleBlockContainer qCircleBlockContainer = this.f84002d;
        if (qCircleBlockContainer != null && qCircleBlockContainer.getBlockMerger() != null) {
            int pos = uIStateData.getPos();
            int i3 = uIStateData.getData().get(pos).fakeReplyPos + 1;
            if (h1()) {
                pos++;
            }
            List<MultiViewBlock> dataList = this.f84002d.getBlockMerger().getDataList();
            if (RFSafeListUtils.isEmpty(dataList) || pos >= dataList.size()) {
                QLog.e("QFSCommentAreaCommentView", 1, "[handleAddFakeReply] block is empty. ");
            }
            MultiViewBlock multiViewBlock = dataList.get(pos);
            multiViewBlock.notifyItemChanged(i3);
            multiViewBlock.notifyItemInserted(i3);
        }
    }

    private void U0(QCirclePanelStateEvent qCirclePanelStateEvent) {
        if (qCirclePanelStateEvent.getPanelType() == 0 && qCirclePanelStateEvent.isShowing()) {
            return;
        }
        HashMap<Integer, String> hashMap = this.H;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.I = true;
        if (!qCirclePanelStateEvent.isShowing()) {
            if (qCirclePanelStateEvent.getPanelType() == 0) {
                Y0();
            }
            com.tencent.biz.qqcircle.viewmodels.n nVar = this.F;
            if (nVar != null) {
                nVar.o2(qCirclePanelStateEvent.getFeedId());
            }
        }
    }

    private void V0(int i3, boolean z16) {
        if (h1()) {
            i3++;
        }
        QCircleBlockContainer qCircleBlockContainer = this.f84002d;
        if (qCircleBlockContainer != null && qCircleBlockContainer.getBlockMerger() != null && !RFSafeListUtils.isEmpty(this.f84002d.getBlockMerger().getDataList()) && i3 >= 0 && i3 < this.f84002d.getBlockMerger().getDataList().size()) {
            QLog.d("QFSCommentAreaCommentView", 1, "[handleDeleteComment] pos: " + i3);
            final MultiViewBlock multiViewBlock = this.f84002d.getBlockMerger().getDataList().get(i3);
            if (z16) {
                this.f84002d.getBlockMerger().unRegisterBlock(multiViewBlock);
                return;
            }
            this.f84002d.getBlockMerger().getDataList().remove(multiViewBlock);
            multiViewBlock.notifyItemRangeRemoved(0, multiViewBlock.getNUM_BACKGOURND_ICON());
            multiViewBlock.getMainHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.widget.e
                @Override // java.lang.Runnable
                public final void run() {
                    QFSCommentAreaCommentView.this.p1(multiViewBlock);
                }
            });
        }
    }

    private void W0(int i3, int i16) {
        QCircleBlockContainer qCircleBlockContainer = this.f84002d;
        if (qCircleBlockContainer != null && qCircleBlockContainer.getBlockMerger() != null && !RFSafeListUtils.isEmpty(this.f84002d.getBlockMerger().getDataList()) && i3 < this.f84002d.getBlockMerger().getDataList().size()) {
            QLog.d("QFSCommentAreaCommentView", 1, "[handleDeleteCommentReply] commentPos: " + i3 + ", replyPos: " + i16);
            MultiViewBlock multiViewBlock = this.f84002d.getBlockMerger().getDataList().get(i3);
            if (i3 > 0) {
                i16++;
            }
            multiViewBlock.notifyItemRemoved(i16 + 1);
        }
    }

    private void X0() {
        QLog.d("QFSCommentAreaCommentView", 1, "[handleDeleteFastComment] ");
        c1(false);
        I1(com.tencent.biz.qqcircle.utils.h.a(R.string.f184043kt));
    }

    private void Y0() {
        com.tencent.biz.qqcircle.viewmodels.n nVar = this.F;
        if (nVar == null) {
            return;
        }
        nVar.U1("feedback_card_id");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean] */
    private void Z0() {
        ?? h16 = h1();
        QCircleBlockContainer qCircleBlockContainer = this.f84002d;
        if (qCircleBlockContainer != null && qCircleBlockContainer.getBlockMerger() != null && !RFSafeListUtils.isEmpty(this.f84002d.getBlockMerger().getDataList()) && h16 < this.f84002d.getBlockMerger().getDataList().size()) {
            this.f84002d.getBlockMerger().getDataList().get(h16 == true ? 1 : 0).notifyDataSetChanged();
        }
    }

    private void a1(SimpleBaseEvent simpleBaseEvent) {
        if ((simpleBaseEvent instanceof QFSReportResultEvent) && simpleBaseEvent.mHashCode == getContext().hashCode() && this.F != null) {
            QFSReportResultEvent qFSReportResultEvent = (QFSReportResultEvent) simpleBaseEvent;
            if (qFSReportResultEvent.getType() == QFSReportResultEvent.ReportType.COMMENT) {
                this.F.U1(qFSReportResultEvent.getCommentId());
            } else if (qFSReportResultEvent.getType() == QFSReportResultEvent.ReportType.REPLY) {
                this.F.W1(qFSReportResultEvent.getCommentId(), qFSReportResultEvent.getReplyId());
            }
        }
    }

    private void b1(List<QFSCommentItemInfo> list, int i3, boolean z16) {
        QCircleBlockContainer qCircleBlockContainer;
        boolean z17;
        if (list != null && (qCircleBlockContainer = this.f84002d) != null && qCircleBlockContainer.getBlockMerger() != null) {
            Boolean value = this.F.g2().getValue();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[handleRequestComments] isLoadMore: ");
            sb5.append(z16);
            sb5.append(", data size: ");
            sb5.append(list.size());
            sb5.append(", startPos: ");
            sb5.append(i3);
            sb5.append(", isFinish: ");
            sb5.append(value);
            sb5.append(", commentElementClickListener is null: ");
            if (this.E == null) {
                z17 = true;
            } else {
                z17 = false;
            }
            sb5.append(z17);
            QLog.d("QFSCommentAreaCommentView", 1, sb5.toString());
            if (i3 >= list.size()) {
                return;
            }
            ArrayList<MultiViewBlock> arrayList = new ArrayList<>();
            int i16 = i3;
            while (i3 < list.size()) {
                ac acVar = new ac(null);
                acVar.S0(i16);
                i16++;
                acVar.U0(this.E);
                acVar.T0(this.F.b2().getValue());
                acVar.setDatas(Collections.singletonList(list.get(i3)));
                arrayList.add(acVar);
                i3++;
            }
            if (z16) {
                E0();
            }
            this.f84002d.registerBlock(arrayList);
            if (!arrayList.isEmpty()) {
                ac acVar2 = (ac) arrayList.get(arrayList.size() - 1);
                acVar2.getLoadInfo().setFinish(Boolean.TRUE.equals(value));
                acVar2.Q0(true);
                acVar2.setOnLoadDataDelegate(new MultiViewBlock.OnLoadDataDelegate() { // from class: com.tencent.biz.qqcircle.comment.widget.n
                    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
                    public final void onLoadData(LoadInfo loadInfo, Object obj) {
                        QFSCommentAreaCommentView.this.r1(loadInfo, obj);
                    }
                });
            }
            if (!z16) {
                getMainHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.widget.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        QFSCommentAreaCommentView.this.s1();
                    }
                });
            }
        }
    }

    private void e1(List<QFSCommentItemInfo> list, int i3) {
        QCircleBlockContainer qCircleBlockContainer = this.f84002d;
        if (qCircleBlockContainer != null && qCircleBlockContainer.getBlockMerger() != null) {
            QLog.d("QFSCommentAreaCommentView", 1, "[handleShowFastComment] pos: " + i3);
            c1(false);
            S0(list, i3, true);
            I1("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f1(final Boolean bool) {
        O0(this, new OnPromiseResolved() { // from class: com.tencent.biz.qqcircle.comment.widget.m
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                QFSCommentAreaCommentView.this.t1(bool, (r20.a) obj);
            }
        });
    }

    private void g1(List<QFSCommentItemInfo> list, int i3) {
        if (i3 == 0) {
            Z0();
            return;
        }
        this.f84002d.getRecyclerView().setItemAnimator(null);
        V0(i3, true);
        S0(list, 0, true);
    }

    private boolean h1() {
        QCircleBlockContainer qCircleBlockContainer = this.f84002d;
        if (qCircleBlockContainer == null || qCircleBlockContainer.getBlockMerger() == null || !(this.f84002d.getBlockMerger().getBlock(0) instanceof com.tencent.biz.qqcircle.adapter.u)) {
            return false;
        }
        return true;
    }

    private boolean i1() {
        com.tencent.biz.qqcircle.adapter.u uVar = this.G;
        if (uVar != null && uVar.getVisible()) {
            return true;
        }
        return false;
    }

    private void initView() {
        QCirclePanelLoadingView qCirclePanelLoadingView = (QCirclePanelLoadingView) findViewById(R.id.f30810pc);
        this.f84004f = qCirclePanelLoadingView;
        qCirclePanelLoadingView.setHintTextColor(getContext().getResources().getColor(R.color.cb6));
        this.f84004f.setHintTextSize(12.0f);
        this.f84004f.setNeedHideWhenDetachedFromWindow(false);
        this.f84005h = (ViewGroup) findViewById(R.id.f164853b42);
        this.f84007m = (TextView) findViewById(R.id.f166327f13);
        this.f84006i = new QFSCommentFeedDescItemView(getContext());
        TextView textView = (TextView) findViewById(R.id.f361113o);
        this.C = textView;
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1(LinearLayoutManager linearLayoutManager) {
        for (int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition(); findFirstVisibleItemPosition <= linearLayoutManager.findLastVisibleItemPosition(); findFirstVisibleItemPosition++) {
            View findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
            if (findViewByPosition instanceof QFSCommentBaseItemView) {
                A1(findViewByPosition, findFirstVisibleItemPosition);
            }
        }
    }

    private void k1() {
        QCircleBlockContainer qCircleBlockContainer = (QCircleBlockContainer) findViewById(R.id.f30790pa);
        this.f84002d = qCircleBlockContainer;
        qCircleBlockContainer.getRecyclerView().setAdapter(null);
        this.f84002d.getRecyclerView().setAdapter(this.f84002d.getBlockMerger());
        this.f84002d.getRecyclerView().setNestedScrollingEnabled(true);
        this.f84002d.setEnablePageRecyclerViewPool(true);
        O0(this, new b());
        m1();
    }

    private void m1() {
        QCircleBlockContainer qCircleBlockContainer = this.f84002d;
        if (qCircleBlockContainer != null && qCircleBlockContainer.getRecyclerView() != null) {
            NestScrollRecyclerView recyclerView = this.f84002d.getRecyclerView();
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                recyclerView.addOnScrollListener(new c((LinearLayoutManager) layoutManager));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n1(IPartHost iPartHost) {
        if (iPartHost == null) {
            QLog.e(getLogTag(), 1, "[initViewModel] partHost == null");
            return;
        }
        if (!(iPartHost instanceof QCircleBaseFragment)) {
            QLog.e(getLogTag(), 1, "[initViewModel] partHost not instanceof QCircleBaseFragment");
            return;
        }
        QCircleBaseFragment qCircleBaseFragment = (QCircleBaseFragment) iPartHost;
        com.tencent.biz.qqcircle.viewmodels.n nVar = (com.tencent.biz.qqcircle.viewmodels.n) getViewModel(qCircleBaseFragment, com.tencent.biz.qqcircle.viewmodels.n.class);
        this.F = nVar;
        if (nVar == null) {
            QLog.e(getLogTag(), 1, "[initViewModel] getViewModel error. ");
            return;
        }
        nVar.Z1().observe(qCircleBaseFragment, new Observer() { // from class: com.tencent.biz.qqcircle.comment.widget.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSCommentAreaCommentView.this.H1(((Boolean) obj).booleanValue());
            }
        });
        this.F.d2().observe(qCircleBaseFragment, new Observer() { // from class: com.tencent.biz.qqcircle.comment.widget.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSCommentAreaCommentView.this.G1((String) obj);
            }
        });
        this.F.h2().observe(qCircleBaseFragment, new Observer() { // from class: com.tencent.biz.qqcircle.comment.widget.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSCommentAreaCommentView.this.I1((String) obj);
            }
        });
        this.F.k2().observe(qCircleBaseFragment, new Observer() { // from class: com.tencent.biz.qqcircle.comment.widget.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSCommentAreaCommentView.this.f1((Boolean) obj);
            }
        });
        this.F.c2().observe(qCircleBaseFragment, new Observer() { // from class: com.tencent.biz.qqcircle.comment.widget.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSCommentAreaCommentView.this.u1((UIStateData) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p1(MultiViewBlock multiViewBlock) {
        multiViewBlock.onDetachedFromRecyclerView(this.f84002d.getRecyclerView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r1(final LoadInfo loadInfo, Object obj) {
        O0(this, new OnPromiseResolved() { // from class: com.tencent.biz.qqcircle.comment.widget.f
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj2) {
                ((r20.a) obj2).loadMoreComments(LoadInfo.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s1() {
        D1();
        if (this.I) {
            this.I = false;
            l1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t1(Boolean bool, r20.a aVar) {
        QLog.d("QFSCommentAreaCommentView", 1, "[handleShowFeedDescBlock] show descBlock. , show: " + bool);
        if (this.G == null) {
            com.tencent.biz.qqcircle.adapter.u uVar = new com.tencent.biz.qqcircle.adapter.u(null);
            this.G = uVar;
            uVar.setReportBean(this.J);
            this.G.j0((com.tencent.biz.qqcircle.widgets.comment.c) aVar);
            this.G.setBlockVisible(false);
            this.f84002d.registerBlock(this.G);
        }
        if (bool.booleanValue()) {
            this.G.k0(aVar.getCommentInfo(), this.F.b2().getValue());
        }
        this.G.setBlockVisible(bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u1(UIStateData uIStateData) {
        if (!J1()) {
            return;
        }
        int state = uIStateData.getState();
        if (state != 0) {
            if (state != 2 && state != 3) {
                if (state != 6) {
                    if (state != 7) {
                        if (state == 8) {
                            E0();
                            if (TextUtils.equals(uIStateData.getMsg(), "add_fake_comment")) {
                                S0((List) uIStateData.getData(), uIStateData.getPos(), true);
                                return;
                            } else if (TextUtils.equals(uIStateData.getMsg(), "add_fake_reply")) {
                                T0(uIStateData);
                                return;
                            } else {
                                if (TextUtils.equals(uIStateData.getMsg(), "add_fast_comment")) {
                                    e1((List) uIStateData.getData(), uIStateData.getPos());
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    E0();
                    if (TextUtils.equals(uIStateData.getMsg(), "sticky_comment")) {
                        g1((List) uIStateData.getData(), uIStateData.getPos());
                        return;
                    } else {
                        if (TextUtils.equals(uIStateData.getMsg(), "cancel_sticky_comment")) {
                            Z0();
                            return;
                        }
                        return;
                    }
                }
                E0();
                if (TextUtils.equals(uIStateData.getMsg(), "delete_fast_comment")) {
                    X0();
                    return;
                } else if (TextUtils.equals(uIStateData.getMsg(), "delete_comment")) {
                    V0(uIStateData.getPos(), false);
                    return;
                } else {
                    if (TextUtils.equals(uIStateData.getMsg(), QCircleDaTongConstant.ElementParamValue.DELETE_REPLY)) {
                        W0(uIStateData.getPos(), uIStateData.getType());
                        return;
                    }
                    return;
                }
            }
            b1((List) uIStateData.getData(), uIStateData.getPos(), uIStateData.getIsLoadMore());
            return;
        }
        c1(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v1(r20.a aVar) {
        QFSCommentInfo commentInfo = aVar.getCommentInfo();
        if (commentInfo == null) {
            QLog.d("QFSCommentAreaCommentView", 1, "[showFeedDescView] commentInfo is null. ");
            return;
        }
        boolean w16 = w1(commentInfo, commentInfo.mFeed);
        QLog.d("QFSCommentAreaCommentView", 1, "[tryShowFeedDescView] needShowFeedDesc: " + w16);
        if (w16) {
            B1(commentInfo);
        } else {
            y1();
        }
    }

    private boolean w1(@NonNull QFSCommentInfo qFSCommentInfo, @NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QFSCommentInfo.ActionBean actionBean = qFSCommentInfo.mActionBean;
        if ((actionBean != null && !actionBean.mNeedShowTopFeedDesc) || TextUtils.isEmpty(feedCloudMeta$StFeed.content.get()) || qFSCommentInfo.mFrom != 1) {
            return false;
        }
        return true;
    }

    private void x1(QCirclePanelStateEvent qCirclePanelStateEvent) {
        boolean z16;
        if (af.q() && TextUtils.equals(qCirclePanelStateEvent.getFeedId(), P0()) && qCirclePanelStateEvent.isShowing()) {
            if ((qCirclePanelStateEvent.getArg() instanceof Boolean) && !((Boolean) qCirclePanelStateEvent.getArg()).booleanValue()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return;
            }
            getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.widget.c
                @Override // java.lang.Runnable
                public final void run() {
                    QFSCommentAreaCommentView.this.D1();
                }
            }, 200L);
        }
    }

    private void y1() {
        QLog.d("QFSCommentAreaCommentView", 1, "[removeFeedDescView]");
        if (this.f84005h.getChildAt(0) instanceof QFSCommentFeedDescItemView) {
            this.f84005h.removeView(this.f84006i);
        }
    }

    private void z1(boolean z16) {
        int i3;
        QCircleBlockContainer qCircleBlockContainer = this.f84002d;
        if (qCircleBlockContainer == null) {
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        qCircleBlockContainer.setVisibility(i3);
    }

    public void C1(View view, int i3) {
        QFSCommentBaseItemView qFSCommentBaseItemView = (QFSCommentBaseItemView) view;
        if (qFSCommentBaseItemView.r0()) {
            qFSCommentBaseItemView.v0();
            this.H.put(Integer.valueOf(i3), "true");
            I0(qFSCommentBaseItemView.q0());
        } else {
            qFSCommentBaseItemView.p0();
            J0(qFSCommentBaseItemView.q0());
        }
    }

    public void L0(LinearLayoutManager linearLayoutManager) {
        for (int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition(); findFirstVisibleItemPosition <= linearLayoutManager.findLastVisibleItemPosition(); findFirstVisibleItemPosition++) {
            View findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
            if (findViewByPosition instanceof QFSCommentBaseItemView) {
                QFSCommentBaseItemView qFSCommentBaseItemView = (QFSCommentBaseItemView) findViewByPosition;
                if (!qFSCommentBaseItemView.r0()) {
                    qFSCommentBaseItemView.p0();
                } else if (this.H.containsKey(Integer.valueOf(findFirstVisibleItemPosition)) && this.H.get(Integer.valueOf(findFirstVisibleItemPosition)) != null && TextUtils.equals(this.H.get(Integer.valueOf(findFirstVisibleItemPosition)), "true")) {
                    qFSCommentBaseItemView.u0();
                }
            }
        }
    }

    public QCircleBlockContainer N0() {
        return this.f84002d;
    }

    public void O0(View view, OnPromiseResolved<r20.a> onPromiseResolved) {
        RFWIocAbilityProvider.g().getIoc(r20.a.class).originView(view).done(new e(onPromiseResolved)).fail(new d()).run();
    }

    public int Q0() {
        QFSCommentFeedDescItemView qFSCommentFeedDescItemView = this.f84006i;
        if (qFSCommentFeedDescItemView != null && qFSCommentFeedDescItemView.getVisibility() == 0) {
            return this.f84006i.getMeasuredHeight();
        }
        return 0;
    }

    public void c1(boolean z16) {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_clear_comment_cache_in_tab_switch", true)) {
            d1(z16);
            return;
        }
        QCircleBlockContainer qCircleBlockContainer = this.f84002d;
        if (qCircleBlockContainer != null && qCircleBlockContainer.getBlockMerger() != null) {
            QLog.d("QFSCommentAreaCommentView", 1, "[handleResetComments] clear data. ");
            this.f84002d.getBlockMerger().clearData();
            this.f84002d.getRecyclerView().setItemAnimator(null);
            this.f84002d.registerBlock(this.G);
        }
    }

    public void d1(boolean z16) {
        QCircleBlockContainer qCircleBlockContainer = this.f84002d;
        if (qCircleBlockContainer != null && qCircleBlockContainer.getBlockMerger() != null) {
            QCircleBlockMerger blockMerger = this.f84002d.getBlockMerger();
            QLog.d("QFSCommentAreaCommentView", 1, "[handleResetCommentsNew] clear data. clearRecyclerCache: " + z16);
            if (blockMerger == null) {
                QLog.e("QFSCommentAreaCommentView", 1, "[handleResetCommentsNew] blockMerger is null.");
                return;
            }
            blockMerger.clearData();
            BlockPart blockPart = blockMerger.getBlockPart();
            blockMerger.destroy();
            blockMerger.setBlockContainer(this.f84002d);
            blockMerger.setBlockWrapper(blockPart);
            if (z16 && this.f84002d.getRecyclerView() != null) {
                this.f84002d.getRecyclerView().getRecycledViewPool().clear();
                this.f84002d.getRecyclerView().setAdapter(blockMerger);
            }
            this.f84002d.getRecyclerView().setItemAnimator(null);
            this.f84002d.registerBlock(this.G);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCirclePanelStateEvent.class);
        arrayList.add(QFSReportResultEvent.class);
        arrayList.add(QFSRemoveFeedbackCardEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g8z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public RFWLayoutPreLoader getLayoutPreLoader() {
        return RFWLayoutPreLoaderFactory.getLayoutLoader(l30.a.a().c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSCommentAreaCommentView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    @NonNull
    public FrameLayout.LayoutParams getPreLoadLayoutParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    public void l1() {
        QCircleBlockContainer qCircleBlockContainer = this.f84002d;
        if (qCircleBlockContainer != null && qCircleBlockContainer.getRecyclerView() != null && (this.f84002d.getRecyclerView().getLayoutManager() instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f84002d.getRecyclerView().getLayoutManager();
            QLog.d("QFSCommentAreaCommentView", 1, "initScrollListAnimation, size: " + linearLayoutManager.findLastVisibleItemPosition());
            for (int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition(); findFirstVisibleItemPosition <= linearLayoutManager.findLastVisibleItemPosition(); findFirstVisibleItemPosition++) {
                View findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
                if (findViewByPosition instanceof QFSCommentBaseItemView) {
                    C1(findViewByPosition, findFirstVisibleItemPosition);
                }
            }
        }
    }

    public boolean o1() {
        if (J1()) {
            if (!K0() || this.f84006i.getVisibility() == 0) {
                return false;
            }
            return true;
        }
        QFSCommentBlock qFSCommentBlock = this.f84003e;
        if (qFSCommentBlock != null && qFSCommentBlock.getNUM_BACKGOURND_ICON() != 0) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        HashMap<Integer, String> hashMap = this.H;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.I = true;
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCirclePanelStateEvent) {
            QCirclePanelStateEvent qCirclePanelStateEvent = (QCirclePanelStateEvent) simpleBaseEvent;
            U0(qCirclePanelStateEvent);
            x1(qCirclePanelStateEvent);
        }
        if ((simpleBaseEvent instanceof QFSRemoveFeedbackCardEvent) && getContext() != null && simpleBaseEvent.mHashCode == getContext().hashCode()) {
            if (((QFSRemoveFeedbackCardEvent) simpleBaseEvent).getIsRealFeedBack()) {
                com.tencent.biz.qqcircle.helpers.g.f84619a.f(true);
            }
            Y0();
        }
        a1(simpleBaseEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void bindData(QFSCommentInfo qFSCommentInfo, int i3) {
    }
}
