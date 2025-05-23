package com.tencent.biz.qqcircle.fragments.polymerization;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.adapter.ai;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectScrollProcessor;
import com.tencent.biz.qqcircle.beans.QCircleHotEventPolymerizationBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.fragments.QCirclePolymerizationFragment;
import com.tencent.biz.qqcircle.fragments.polymerization.QFSPolymerizationTagBaseFragment;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.aggregation.widget.QFSAggregationBottomHintView;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSLayerFeedPosSyncEvent;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSNormalNoMoreHintView;
import com.tencent.biz.qqcircle.immersive.utils.ad;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.cj;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.qqcircle.viewmodels.QCirclePolymerizationViewModel;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import t30.f;
import ua0.c;

/* loaded from: classes4.dex */
public abstract class QFSPolymerizationTagBaseFragment extends QFSBaseFragment {
    protected int F;
    private BlockPart L;
    protected QFSAggregationBottomHintView M;
    protected ai N;
    protected QCirclePolymerizationViewModel P;
    protected QCirclePolymerizationBean Q;
    protected NestScrollRecyclerView R;
    private RecyclerView S;
    private f T;
    protected int E = 71;
    private String G = null;
    private int H = 0;
    private int I = 0;
    private int J = 0;
    protected int K = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements ai.c {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.adapter.ai.c
        public void a(int i3, e30.b bVar, View view) {
            QFSPolymerizationTagBaseFragment.this.wh(i3, bVar, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends RecyclerView.OnScrollListener {
        b() {
        }

        private void handleScrollStateChanged(int i3) {
            QCircleAspectScrollProcessor.getInstance().onScrollState(QFSPolymerizationTagBaseFragment.this, i3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                VideoReport.traverseExposure();
            }
            handleScrollStateChanged(i3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
            SafeGridLayoutManager safeGridLayoutManager = (SafeGridLayoutManager) recyclerView.getLayoutManager();
            QFSPolymerizationTagBaseFragment.this.I = safeGridLayoutManager.findFirstVisibleItemPosition();
            QFSPolymerizationTagBaseFragment.this.J = safeGridLayoutManager.findLastVisibleItemPosition();
            QFSPolymerizationTagBaseFragment qFSPolymerizationTagBaseFragment = QFSPolymerizationTagBaseFragment.this;
            qFSPolymerizationTagBaseFragment.K = ((qFSPolymerizationTagBaseFragment.I + QFSPolymerizationTagBaseFragment.this.J) / 2) / 3;
        }
    }

    private void Bh(QCircleFeedEvent qCircleFeedEvent) {
        if (qCircleFeedEvent.mState == 3) {
            yh(qCircleFeedEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eh(UIStateData<List<e30.b>> uIStateData) {
        RFWLog.d("QFSPolymerizationTagBaseFragment", RFWLog.USR, "handleModify");
        List<e30.b> data = uIStateData.getData();
        if (data == null) {
            data = new ArrayList<>();
        }
        ai aiVar = this.N;
        if (aiVar != null) {
            aiVar.setDatas(data);
        }
    }

    private void Fh() {
        ViewGroup.LayoutParams layoutParams = this.L.getBlockContainer().getLayoutParams();
        layoutParams.height = cx.b(getContext()) - cx.h();
        QLog.d("QFSPolymerizationTagBaseFragment", 1, "handleOnConfigEvent : width =" + layoutParams.width + " , height : " + layoutParams.height);
        this.L.getBlockContainer().getRecyclerView().setLayoutParams(layoutParams);
        QFSAggregationBottomHintView qFSAggregationBottomHintView = this.M;
        if (qFSAggregationBottomHintView != null) {
            qFSAggregationBottomHintView.setLayoutParams(layoutParams);
        }
    }

    private void Ih() {
        this.L.getBlockContainer().setLayoutManagerType(2, 3);
        this.L.getBlockContainer().getRecyclerView().setNestedScrollingEnabled(true);
        this.L.getBlockContainer().setRefreshing(false);
        this.L.getBlockContainer().setEnableLoadMore(true);
        this.L.getBlockContainer().setParentFragment(getParentFragment());
        this.L.getBlockContainer().getBlockMerger().setTryToLoadMoreWhenNotFullScreen(1);
        if (getContext() != null) {
            QFSNormalNoMoreHintView qFSNormalNoMoreHintView = new QFSNormalNoMoreHintView(getContext());
            qFSNormalNoMoreHintView.setHintTextColor(getContext().getResources().getColorStateList(R.color.qui_common_text_tertiary));
            this.L.getBlockContainer().getBlockMerger().setCustomNoMoreDataView(qFSNormalNoMoreHintView);
        }
        this.L.getBlockContainer().registerBlock(this.N);
        this.L.getBlockContainer().start();
    }

    private void Jh(View view) {
        this.M = (QFSAggregationBottomHintView) view.findViewById(R.id.x_w);
    }

    private boolean Kh(QCircleLayerBean.QFSTagPolymerizationBean qFSTagPolymerizationBean) {
        if (qFSTagPolymerizationBean != null && !"0".equals(qFSTagPolymerizationBean.feedTagPageFromType)) {
            return true;
        }
        return false;
    }

    private void Mh(e30.b bVar, int i3) {
        if (this.Q.getPolymerizationType() == 63 && (this.Q instanceof QCircleHotEventPolymerizationBean)) {
            QCircleLpReportDc05507.DataBuilder c16 = c.c(bVar.g());
            c16.setPageId(303).setActionType(605).setSubActionType(2).setExt4(Integer.toString(i3 + 1));
            if (this.Q.getHotEventInfo() != null) {
                c16.setExt2(this.Q.getHotEventInfo().getId());
            }
            QCircleLpReportDc05507.report(c16);
        }
    }

    private QCircleLayerBean xh(int i3, e30.b bVar) {
        String str;
        QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
        qCircleLayerBean.setFeed(bVar.g());
        qCircleLayerBean.setDataPosInList(i3);
        qCircleLayerBean.setTransInitBean(this.Q);
        String str2 = this.G;
        if (str2 == null) {
            str2 = String.valueOf(this.P.hashCode());
        }
        qCircleLayerBean.setGlobalViewModelKey(str2);
        qCircleLayerBean.setTagInfo(this.Q.getTagInfo());
        qCircleLayerBean.setPolymerizationType(this.Q.getPolymerizationType());
        qCircleLayerBean.setQfsTagPolymerizationBean(this.P.Z1());
        if (Kh(this.P.Z1())) {
            str = "biz_wink_tag_polymerization";
        } else if (this.Q.getPolymerizationType() == 7) {
            str = "biz_polymerization";
        } else {
            str = "biz_data_share";
        }
        qCircleLayerBean.setLayerBizAssemblerType(str);
        qCircleLayerBean.setPageCode(hashCode());
        return qCircleLayerBean;
    }

    private void yh(QCircleFeedEvent qCircleFeedEvent) {
        ai aiVar = this.N;
        if (aiVar == null) {
            QLog.e("QFSPolymerizationTagBaseFragment", 1, "[handleDeleteFeed] mFeedsBlock is null");
            return;
        }
        QLog.i("QFSPolymerizationTagBaseFragment", 1, "[handleDeleteFeed] feedId = " + qCircleFeedEvent.mTargetId + " | result = " + aiVar.q0(qCircleFeedEvent.mTargetId));
        if (this.N.getItemCount() == 0) {
            QFSAggregationBottomHintView qFSAggregationBottomHintView = this.M;
            if (qFSAggregationBottomHintView != null) {
                qFSAggregationBottomHintView.l0("", h.a(R.string.f188043vm));
            }
            QLog.i("QFSPolymerizationTagBaseFragment", 1, "[handleDeleteFeed] isEmptyContent");
        }
    }

    protected void Ah(UIStateData<List<e30.b>> uIStateData) {
        String msg2;
        if (TextUtils.isEmpty(uIStateData.getMsg())) {
            msg2 = h.a(R.string.f181603e8);
        } else {
            msg2 = uIStateData.getMsg();
        }
        QLog.e("QFSPolymerizationTagBaseFragment", 1, "handleFeedsRsp() return error\uff01errMsg:" + msg2);
        ai aiVar = this.N;
        if (aiVar != null && aiVar.getItemCount() > 0) {
            this.N.setDatas(uIStateData.getData());
            QLog.d("QFSPolymerizationTagBaseFragment", 1, "handleErrorRsp clear mFeedsBlock.");
            cj.c(false, uIStateData.getRetCode(), msg2, 1, QCircleToast.f91645e);
        }
        QFSAggregationBottomHintView qFSAggregationBottomHintView = this.M;
        if (qFSAggregationBottomHintView != null) {
            qFSAggregationBottomHintView.m0("", msg2);
        }
        if (!HostNetworkUtils.isNetworkAvailable() && QCirclePluginUtil.getQCircleBaseFragment(getContext()) != null) {
            QCirclePluginUtil.getQCircleBaseFragment(getContext()).getPartManager().broadcastMessage("publish_show_or_hide", Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ch(UIStateData<List<e30.b>> uIStateData) {
        boolean z16;
        ai aiVar;
        if (uIStateData == null) {
            return;
        }
        boolean isFinish = uIStateData.getIsFinish();
        int state = uIStateData.getState();
        if (state != 0) {
            z16 = false;
            if (state != 2) {
                if (state != 3) {
                    if (state == 4) {
                        Ah(uIStateData);
                    }
                } else {
                    Gh(uIStateData, isFinish);
                }
            } else {
                Gh(uIStateData, isFinish);
            }
            if (!z16 && (aiVar = this.N) != null) {
                aiVar.getLoadInfo().setFinish(isFinish);
                this.N.notifyLoadingComplete(true);
                this.R = this.N.getParentRecyclerView();
                Nh();
                return;
            }
        }
        zh(uIStateData, isFinish);
        z16 = true;
        if (!z16) {
        }
    }

    public void Dh(@NonNull QFSLayerFeedPosSyncEvent qFSLayerFeedPosSyncEvent) {
        QLog.d("QFSPolymerizationTagBaseFragment", 4, "QFSLayerFeedPosSyncEvent position = " + qFSLayerFeedPosSyncEvent.getPos());
        if (this.N != null && this.Q != null && qFSLayerFeedPosSyncEvent.getPageCode() == hashCode()) {
            ad.f(this.N.getDataList(), this.R, this.S, qFSLayerFeedPosSyncEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Gh(UIStateData<List<e30.b>> uIStateData, boolean z16) {
        if (this.N == null) {
            return;
        }
        if (uIStateData.getIsLoadMore()) {
            this.N.addAll(uIStateData.getData());
        } else {
            this.N.setDatas(uIStateData.getData());
        }
        this.N.getLoadInfo().setFinish(z16);
        QFSAggregationBottomHintView qFSAggregationBottomHintView = this.M;
        if (qFSAggregationBottomHintView != null) {
            qFSAggregationBottomHintView.k0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Hh() {
        ai r06 = new ai(new Bundle()).t0(this.F).r0(((QCirclePolymerizationViewModel) getViewModel((QCirclePolymerizationFragment) getParentFragment(), null, QCirclePolymerizationViewModel.class)).X1());
        this.N = r06;
        r06.s0(new a());
        f fVar = new f(getLogTag(), this.N, new f.b() { // from class: p30.a
            @Override // t30.f.b
            public final void a(UIStateData uIStateData) {
                QFSPolymerizationTagBaseFragment.this.Eh(uIStateData);
            }
        });
        this.T = fVar;
        fVar.a2(1);
    }

    protected List<MultiViewBlock> Lh() {
        Hh();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.N);
        return arrayList;
    }

    protected void Nh() {
        BlockPart blockPart = this.L;
        if (blockPart == null) {
            return;
        }
        blockPart.getBlockContainer().getRecyclerView().addOnScrollListener(new b());
    }

    public void Oh(RecyclerView recyclerView) {
        this.S = recyclerView;
    }

    public void Ph(int i3) {
        this.F = i3;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        BlockPart blockPart = new BlockPart(R.id.f493322e, Lh(), 2, 3);
        this.L = blockPart;
        arrayList.add(blockPart);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public Map<String, Object> getChildDaTongPageParams() {
        if (this.Q == null) {
            return super.getChildDaTongPageParams();
        }
        HashMap hashMap = new HashMap();
        if (this.Q.getTagInfo() != null) {
            hashMap.put("xsj_topic_name", this.Q.getTagInfo().tagName.get());
            hashMap.put("xsj_topic_id", this.Q.getTagInfo().tagId.get());
            hashMap.put("xsj_topic_page_source", this.Q.getFeedTagPageFromType());
        }
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_WHITELIST, 0);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gnw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_TOPIC_AGG_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(QFSLayerFeedPosSyncEvent.class);
        eventClass.add(QCircleConfigChangeEvent.class);
        eventClass.add(QCircleFeedEvent.class);
        return eventClass;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initViewModel() {
        QCirclePolymerizationViewModel qCirclePolymerizationViewModel = (QCirclePolymerizationViewModel) getViewModel((QCirclePolymerizationFragment) getParentFragment(), null, QCirclePolymerizationViewModel.class);
        this.P = qCirclePolymerizationViewModel;
        this.Q = qCirclePolymerizationViewModel.X1();
        this.G = String.valueOf(this.P.hashCode());
        w20.a.j().registerDisplaySurface(this.G, this.P);
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        f fVar = this.T;
        if (fVar != null) {
            fVar.onPause();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSLayerFeedPosSyncEvent) {
            Dh((QFSLayerFeedPosSyncEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCircleConfigChangeEvent) {
            Fh();
        } else if (simpleBaseEvent instanceof QCircleFeedEvent) {
            Bh((QCircleFeedEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        f fVar = this.T;
        if (fVar != null) {
            fVar.onResume();
        }
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        Jh(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        Ih();
        initViewModel();
    }

    protected void wh(int i3, e30.b bVar, View view) {
        if (bVar == null) {
            return;
        }
        QCircleLayerBean xh5 = xh(i3, bVar);
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        QFSTransitionAnimBean qFSTransitionAnimBean = new QFSTransitionAnimBean();
        int i16 = iArr[0];
        xh5.setTransitionAnimBean(qFSTransitionAnimBean.setLayoutRect(new QFSTransitionAnimBean.SourceRect(i16, iArr[1], view.getWidth() + i16, iArr[1] + view.getHeight())).setScaleType(ImageView.ScaleType.CENTER_CROP).setImageUrl(bVar.g().cover.picUrl.get()));
        xh5.setPreRenderType(10010);
        com.tencent.biz.qqcircle.launcher.c.u(getContext(), xh5);
        Mh(bVar, i3);
    }

    protected void zh(UIStateData<List<e30.b>> uIStateData, boolean z16) {
        String msg2;
        ai aiVar;
        QLog.e("QFSPolymerizationTagBaseFragment", 1, "handleFeedsRsp() return empty data");
        if (uIStateData.getIsLoadMore() && (aiVar = this.N) != null && aiVar.getItemCount() > 0) {
            this.N.getLoadInfo().setFinish(z16);
            QLog.d("QFSPolymerizationTagBaseFragment", 1, "handleEmptyRsp load finish.");
            return;
        }
        ai aiVar2 = this.N;
        if (aiVar2 != null) {
            aiVar2.setDatas(uIStateData.getData());
        }
        if (TextUtils.isEmpty(uIStateData.getMsg())) {
            msg2 = h.a(R.string.f188043vm);
        } else {
            msg2 = uIStateData.getMsg();
        }
        QFSAggregationBottomHintView qFSAggregationBottomHintView = this.M;
        if (qFSAggregationBottomHintView != null) {
            qFSAggregationBottomHintView.l0("", msg2);
        }
    }
}
