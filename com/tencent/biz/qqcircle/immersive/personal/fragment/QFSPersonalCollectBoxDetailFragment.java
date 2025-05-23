package com.tencent.biz.qqcircle.immersive.personal.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.qq.wx.voice.util.ErrorCode;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.bizparts.QFSSharePart;
import com.tencent.biz.qqcircle.events.QFSCollectedFeedEvent;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.QFSBlockContainer;
import com.tencent.biz.qqcircle.immersive.part.QFSBaseBlockPart;
import com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalCollectBoxAddFeedAdapter;
import com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedBaseAdapter;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalCollectBoxDetailBean;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSLayerFeedPosSyncEvent;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSPersonalCollectBoxEvent;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSCollectBoxRemoveFeedRequest;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalCollectBoxAddFeedBottomSheet;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalCollectBoxDetailFeedItemView;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalSelectCollectBoxBottomSheet;
import com.tencent.biz.qqcircle.immersive.utils.ad;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudFavoritessvr$ReomveFavoritesFeedsRsp;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StFavoritesFeedsPageRsp;

/* loaded from: classes4.dex */
public class QFSPersonalCollectBoxDetailFragment extends QFSBaseFragment implements View.OnClickListener {
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.i E;
    private QFSBaseBlockPart F;
    private QFSSharePart G;
    private com.tencent.biz.qqcircle.immersive.personal.adapter.e H;
    private com.tencent.biz.qqcircle.immersive.personal.adapter.d I;
    private QFSPersonalCollectBoxDetailBean J;
    private com.tencent.biz.qqcircle.immersive.personal.part.y K;
    private final com.tencent.biz.qqcircle.immersive.personal.part.d L = new com.tencent.biz.qqcircle.immersive.personal.part.d();
    private final List<Integer> M = new ArrayList();
    private View N;
    private QUIButton P;
    private QUIButton Q;
    private QUIButton R;
    private FrameLayout S;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Observer<UIStateData<List<e30.b>>> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UIStateData<List<e30.b>> uIStateData) {
            boolean z16;
            if (uIStateData == null) {
                return;
            }
            boolean isFinish = uIStateData.getIsFinish();
            int state = uIStateData.getState();
            if (state != 1 && state != 2) {
                if (state != 3) {
                    if (state == 4) {
                        QFSPersonalCollectBoxDetailFragment.this.Ph(uIStateData.getMsg());
                    }
                } else {
                    QFSPersonalCollectBoxDetailFragment qFSPersonalCollectBoxDetailFragment = QFSPersonalCollectBoxDetailFragment.this;
                    qFSPersonalCollectBoxDetailFragment.Uh(qFSPersonalCollectBoxDetailFragment.ei(uIStateData.getData()));
                }
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                QFSPersonalCollectBoxDetailFragment.this.I.getLoadInfo().setFinish(isFinish);
                QFSPersonalCollectBoxDetailFragment.this.I.notifyLoadingComplete(true, isFinish);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSPersonalCollectBoxDetailFragment.this.N.setVisibility(0);
            Iterator<com.tencent.biz.qqcircle.immersive.personal.bean.e> it = QFSPersonalCollectBoxDetailFragment.this.I.getDataList().iterator();
            while (it.hasNext()) {
                ((com.tencent.biz.qqcircle.immersive.personal.bean.h) it.next()).l(true);
            }
            QFSPersonalCollectBoxDetailFragment.this.I.o0(5);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f88606d;

        /* loaded from: classes4.dex */
        class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudFavoritessvr$ReomveFavoritesFeedsRsp> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ List f88608a;

            a(List list) {
                this.f88608a = list;
            }

            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudFavoritessvr$ReomveFavoritesFeedsRsp feedCloudFavoritessvr$ReomveFavoritesFeedsRsp) {
                if (z16 && j3 == 0 && feedCloudFavoritessvr$ReomveFavoritesFeedsRsp != null) {
                    QFSPersonalCollectBoxEvent qFSPersonalCollectBoxEvent = new QFSPersonalCollectBoxEvent(5);
                    qFSPersonalCollectBoxEvent.setFavoritesInfo(QFSPersonalCollectBoxDetailFragment.this.J.getFavoritesInfo());
                    qFSPersonalCollectBoxEvent.setFeedList(this.f88608a);
                    SimpleEventBus.getInstance().dispatchEvent(qFSPersonalCollectBoxEvent);
                    QFSPersonalCollectBoxDetailFragment.this.bi();
                    QFSPersonalCollectBoxDetailFragment.this.di();
                    return;
                }
                QLog.e("QFSPersonalCollectBoxDetailFragment", 1, "handleMoveOut error:" + j3 + "  errorMsg:" + str);
                QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f19193465), 0);
            }
        }

        c(String str) {
            this.f88606d = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            List fi5 = QFSPersonalCollectBoxDetailFragment.this.fi();
            VSNetworkHelper.getInstance().sendRequest(new QFSCollectBoxRemoveFeedRequest(QFSPersonalCollectBoxDetailFragment.this.J.getFavoritesInfo().f398434id.get(), fi5), new a(fi5));
            QFSPersonalCollectBoxDetailFragment.this.Lh(true, this.f88606d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f88610d;

        d(String str) {
            this.f88610d = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            QFSPersonalCollectBoxDetailFragment.this.Lh(true, this.f88610d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class e implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QFSPersonalCollectBoxDetailFragment> f88612a;

        e(QFSPersonalCollectBoxDetailFragment qFSPersonalCollectBoxDetailFragment) {
            this.f88612a = new WeakReference<>(qFSPersonalCollectBoxDetailFragment);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            if (this.f88612a.get() == null) {
                return null;
            }
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SELECT_PRODUCT_NUM, Integer.valueOf(this.f88612a.get().M.size()));
            return buildElementParams;
        }
    }

    private void Hh(List<FeedCloudMeta$StFeed> list) {
        boolean z16;
        this.J.getFavoritesInfo().feed_num.set(this.J.getFavoritesInfo().feed_num.get() + list.size());
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.i iVar = this.E;
        if (!RFSafeListUtils.isEmpty(this.I.getDataList()) && !this.I.getLoadInfo().isFinish()) {
            z16 = false;
        } else {
            z16 = true;
        }
        iVar.N1(list, false, z16);
    }

    private void Ih(ArrayList<Part> arrayList) {
        com.tencent.biz.qqcircle.immersive.personal.part.y yVar = new com.tencent.biz.qqcircle.immersive.personal.part.y();
        this.K = yVar;
        yVar.K9(true);
        arrayList.add(this.K);
    }

    private void Jh(View view, String str) {
        VideoReport.setElementId(view, str);
        VideoReport.setEventDynamicParams(view, new e(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kh(int i3, com.tencent.biz.qqcircle.immersive.personal.bean.e eVar, QCircleBaseWidgetView qCircleBaseWidgetView) {
        QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
        qCircleLayerBean.setFeed(eVar.b());
        qCircleLayerBean.setGetFeedList(true);
        QCircleExtraTypeInfo qCircleExtraTypeInfo = new QCircleExtraTypeInfo();
        qCircleExtraTypeInfo.sourceType = ErrorCode.ERROR_CHECKLEGALAPP_UNKNOWN_RET;
        qCircleLayerBean.setExtraTypeInfo(qCircleExtraTypeInfo);
        qCircleLayerBean.setDataPosInList(i3);
        qCircleLayerBean.setLayerBizAssemblerType("biz_data_share");
        qCircleLayerBean.setGlobalViewModelKey(this.E.P1());
        qCircleLayerBean.setPageCode(hashCode());
        qCircleLayerBean.setTransInitBean(new QCircleInitBean());
        ImageView imageView = ((QFSPersonalCollectBoxDetailFeedItemView) qCircleBaseWidgetView).f89200d;
        int[] iArr = new int[2];
        imageView.getLocationInWindow(iArr);
        QFSTransitionAnimBean qFSTransitionAnimBean = new QFSTransitionAnimBean();
        int i16 = iArr[0];
        qCircleLayerBean.setTransitionAnimBean(qFSTransitionAnimBean.setLayoutRect(new QFSTransitionAnimBean.SourceRect(i16, iArr[1], imageView.getWidth() + i16, iArr[1] + imageView.getHeight())).setScaleType(ImageView.ScaleType.CENTER_CROP).setImageUrl(eVar.a()).setTransitionDelayTimeMs(0).setTransitionDurationMs(200).setEnterAnimFadeCoverTimeMs(300));
        qCircleLayerBean.getTransitionAnimBean().setCoverDrawable(imageView.getDrawable());
        com.tencent.biz.qqcircle.launcher.c.u(qCircleBaseWidgetView.getContext(), qCircleLayerBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lh(boolean z16, String str) {
        String str2;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_REMOVE_POPUP);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COLLECT_FOLDER_ID, Long.valueOf(this.J.getFavoritesInfo().f398434id.get()));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SELECT_PRODUCT_NUM, Integer.valueOf(this.M.size()));
        if (z16) {
            buildElementParams.put("xsj_item_name", str);
        }
        if (getReportBean() != null) {
            buildElementParams.put("xsj_custom_pgid", getReportBean().getDtPageId());
        }
        if (z16) {
            str2 = "ev_xsj_abnormal_clck";
        } else {
            str2 = "ev_xsj_abnormal_imp";
        }
        VideoReport.reportEvent(str2, buildElementParams);
    }

    private void Mh() {
        com.tencent.biz.qqcircle.immersive.personal.bean.f fVar = new com.tencent.biz.qqcircle.immersive.personal.bean.f(3);
        fVar.c(this.J.getFavoritesInfo());
        new QFSPersonalCollectBoxAddFeedBottomSheet(getContext(), this.mParentView, fVar, getReportBean()).show();
    }

    private void Oh() {
        String str;
        String str2;
        if (com.tencent.biz.qqcircle.immersive.utils.r.v0(this.J.getFavoritesInfo().owner_id.get())) {
            this.R.setVisibility(0);
            str2 = "\u6682\u65e0\u5185\u5bb9";
            str = "\u5feb\u6765\u4e30\u5bcc\u4f60\u7684\u6536\u85cf\u5939\u5427";
        } else {
            this.R.setVisibility(8);
            str = "";
            str2 = "\u6536\u85cf\u5939\u6682\u65f6\u8fd8\u6ca1\u6709\u5185\u5bb9\u54e6";
        }
        this.S.setVisibility(0);
        this.K.M9(str2, str);
        this.L.M9(false);
        this.I.getRecyclerView().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ph(String str) {
        this.S.setVisibility(0);
        this.K.M9(str, null);
        this.L.J9();
    }

    private void Qh(@NonNull QFSLayerFeedPosSyncEvent qFSLayerFeedPosSyncEvent) {
        QLog.d("QFSPersonalCollectBoxDetailFragment", 4, "QFSLayerFeedPosSyncEvent position = " + qFSLayerFeedPosSyncEvent.getPos());
        if (qFSLayerFeedPosSyncEvent.getPageCode() != hashCode()) {
            return;
        }
        ad.f(this.I.i0(), this.I.getRecyclerView(), null, qFSLayerFeedPosSyncEvent);
    }

    private void Rh() {
        if (this.M.isEmpty()) {
            return;
        }
        String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f19194466);
        String a17 = com.tencent.biz.qqcircle.utils.h.a(R.string.cancel);
        String a18 = com.tencent.biz.qqcircle.utils.h.a(R.string.f171151ok);
        DialogUtil.createCustomDialog(getContext(), 230, (String) null, a16, a17, a18, new c(a18), new d(a17)).show();
        Lh(false, null);
    }

    private void Sh() {
        if (this.M.isEmpty()) {
            return;
        }
        com.tencent.biz.qqcircle.immersive.personal.bean.r rVar = new com.tencent.biz.qqcircle.immersive.personal.bean.r(2);
        rVar.d(this.J.getFavoritesInfo());
        rVar.e(fi());
        new QFSPersonalSelectCollectBoxBottomSheet(getContext(), getView(), rVar, getReportBean()).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Th, reason: merged with bridge method [inline-methods] */
    public void Yh(QFSPersonalCollectBoxEvent qFSPersonalCollectBoxEvent) {
        if (this.J.getFavoritesInfo().f398434id != qFSPersonalCollectBoxEvent.getFavoritesInfo().f398434id) {
            return;
        }
        if (qFSPersonalCollectBoxEvent.getEventStatus() == 5) {
            bi();
            di();
        } else if (qFSPersonalCollectBoxEvent.getEventStatus() == 6) {
            Hh(qFSPersonalCollectBoxEvent.getFeedList());
            di();
        } else if (qFSPersonalCollectBoxEvent.getEventStatus() == 2) {
            this.J.getFavoritesInfo().title.set(qFSPersonalCollectBoxEvent.getFavoritesInfo().title.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uh(List<com.tencent.biz.qqcircle.immersive.personal.bean.e> list) {
        if (list.isEmpty()) {
            Oh();
            return;
        }
        this.I.getRecyclerView().setVisibility(0);
        this.I.setDatas(list);
        this.S.setVisibility(8);
        this.K.E9();
        this.R.setVisibility(8);
        this.L.M9(true);
    }

    private void Vh() {
        BlockContainer blockContainer = this.F.getBlockContainer();
        blockContainer.setLayoutManagerType(2, 3);
        blockContainer.setEnableLoadMore(true);
        blockContainer.setParentFragment(this);
        blockContainer.setEnableRefresh(false);
        blockContainer.getBlockMerger().setNoMoreHint(com.tencent.biz.qqcircle.utils.h.a(R.string.f1921346o));
        blockContainer.getBlockMerger().setTryToLoadMoreWhenNotFullScreen(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Wh(int i3, com.tencent.biz.qqcircle.immersive.personal.bean.e eVar, View view) {
        com.tencent.biz.qqcircle.immersive.personal.bean.g gVar = (com.tencent.biz.qqcircle.immersive.personal.bean.g) eVar;
        boolean i16 = gVar.i();
        if (i16) {
            this.M.remove(Integer.valueOf(i3));
        } else {
            if (this.M.size() >= QFSPersonalCollectBoxAddFeedBottomSheet.R) {
                QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f195274e6), 0);
                this.I.v0(i3);
                return;
            }
            this.M.add(Integer.valueOf(i3));
        }
        gVar.j(!i16);
        this.I.v0(i3);
        gi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Xh(QQCircleFeedBase$StFavoritesFeedsPageRsp qQCircleFeedBase$StFavoritesFeedsPageRsp) {
        this.J.getFavoritesInfo().title.set(qQCircleFeedBase$StFavoritesFeedsPageRsp.title.get());
        this.J.getFavoritesInfo().owner_id.set(qQCircleFeedBase$StFavoritesFeedsPageRsp.author.f398463id.get());
        this.J.getFavoritesInfo().status.set(qQCircleFeedBase$StFavoritesFeedsPageRsp.status.get());
        this.H.i0(qQCircleFeedBase$StFavoritesFeedsPageRsp);
        this.L.H9(qQCircleFeedBase$StFavoritesFeedsPageRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Zh(LoadInfo loadInfo, Object obj) {
        if (loadInfo.isLoadMoreState()) {
            this.E.loadMoreForDisplaySurface(new Object[0]);
        }
    }

    private List<MultiViewBlock> ai() {
        ArrayList arrayList = new ArrayList();
        this.H = new com.tencent.biz.qqcircle.immersive.personal.adapter.e(null);
        com.tencent.biz.qqcircle.immersive.personal.adapter.d dVar = new com.tencent.biz.qqcircle.immersive.personal.adapter.d(null);
        this.I = dVar;
        dVar.setOnLoadDataDelegate(new MultiViewBlock.OnLoadDataDelegate() { // from class: com.tencent.biz.qqcircle.immersive.personal.fragment.c
            @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
            public final void onLoadData(LoadInfo loadInfo, Object obj) {
                QFSPersonalCollectBoxDetailFragment.this.Zh(loadInfo, obj);
            }
        });
        this.I.p0(new QFSPersonalFeedBaseAdapter.b() { // from class: com.tencent.biz.qqcircle.immersive.personal.fragment.d
            @Override // com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedBaseAdapter.b
            public final void a(int i3, com.tencent.biz.qqcircle.immersive.personal.bean.e eVar, QCircleBaseWidgetView qCircleBaseWidgetView) {
                QFSPersonalCollectBoxDetailFragment.this.Kh(i3, eVar, qCircleBaseWidgetView);
            }
        });
        arrayList.add(this.I);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bi() {
        List<com.tencent.biz.qqcircle.immersive.personal.bean.e> dataList = this.I.getDataList();
        Iterator<Integer> it = this.M.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            dataList.remove(it.next().intValue() - i3);
            i3++;
        }
        ci(this.M.contains(0), this.M.size());
    }

    private void ci(boolean z16, int i3) {
        String a16;
        this.J.getFavoritesInfo().feed_num.set(this.J.getFavoritesInfo().feed_num.get() - i3);
        List<com.tencent.biz.qqcircle.immersive.personal.bean.e> dataList = this.I.getDataList();
        if (z16) {
            if (dataList.isEmpty()) {
                a16 = "";
            } else {
                a16 = dataList.get(0).a();
            }
            this.J.getFavoritesInfo().cover_url.set(a16);
            QFSPersonalCollectBoxEvent qFSPersonalCollectBoxEvent = new QFSPersonalCollectBoxEvent(2);
            qFSPersonalCollectBoxEvent.setFavoritesInfo(this.J.getFavoritesInfo());
            SimpleEventBus.getInstance().dispatchEvent(qFSPersonalCollectBoxEvent);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<com.tencent.biz.qqcircle.immersive.personal.bean.e> it = dataList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().b());
        }
        this.E.X1(arrayList, false, this.I.getLoadInfo().isFinish());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di() {
        this.N.setVisibility(8);
        this.L.K9();
        this.M.clear();
        gi();
        Iterator<com.tencent.biz.qqcircle.immersive.personal.bean.e> it = this.I.getDataList().iterator();
        while (it.hasNext()) {
            com.tencent.biz.qqcircle.immersive.personal.bean.h hVar = (com.tencent.biz.qqcircle.immersive.personal.bean.h) it.next();
            hVar.j(false);
            hVar.l(false);
        }
        this.I.o0(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.tencent.biz.qqcircle.immersive.personal.bean.e> ei(List<e30.b> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<e30.b> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new com.tencent.biz.qqcircle.immersive.personal.bean.h(it.next()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<FeedCloudMeta$StFeed> fi() {
        Collections.sort(this.M);
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = this.M.iterator();
        while (it.hasNext()) {
            arrayList.add(this.I.i0().get(it.next().intValue()).g());
        }
        return arrayList;
    }

    private void gi() {
        if (this.M.isEmpty()) {
            this.P.setEnabled(false);
            this.Q.setEnabled(false);
        } else {
            this.P.setEnabled(true);
            this.Q.setEnabled(true);
        }
    }

    private void initIntentData() {
        if (getActivity() == null) {
            return;
        }
        Intent intent = getActivity().getIntent();
        if (intent != null && intent.hasExtra("key_bundle_common_init_bean")) {
            QFSPersonalCollectBoxDetailBean qFSPersonalCollectBoxDetailBean = (QFSPersonalCollectBoxDetailBean) intent.getSerializableExtra("key_bundle_common_init_bean");
            this.J = qFSPersonalCollectBoxDetailBean;
            this.L.L9(qFSPersonalCollectBoxDetailBean);
            return;
        }
        QLog.i("QFSPersonalCollectBoxDetailFragment", 1, "InitBean is null");
    }

    private void initListener() {
        this.L.N9(new b());
        this.R.setOnClickListener(this);
        this.P.setOnClickListener(this);
        this.Q.setOnClickListener(this);
        this.I.x0(new QFSPersonalCollectBoxAddFeedAdapter.b() { // from class: com.tencent.biz.qqcircle.immersive.personal.fragment.f
            @Override // com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalCollectBoxAddFeedAdapter.b
            public final void a(int i3, com.tencent.biz.qqcircle.immersive.personal.bean.e eVar, View view) {
                QFSPersonalCollectBoxDetailFragment.this.Wh(i3, eVar, view);
            }
        });
    }

    private void initView(View view) {
        this.R = (QUIButton) view.findViewById(R.id.f10583673);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.f371416g);
        this.S = frameLayout;
        this.K.G9(frameLayout);
        this.N = view.findViewById(R.id.yni);
        this.P = (QUIButton) view.findViewById(R.id.f109426fs);
        this.Q = (QUIButton) view.findViewById(R.id.f109416fr);
        QFSBlockContainer qFSBlockContainer = (QFSBlockContainer) view.findViewById(R.id.vfy);
        qFSBlockContainer.registerBlock(this.H);
        qFSBlockContainer.setParentFragment(this);
        VideoReport.setElementId(this.R, QCircleDaTongConstant.ElementId.EM_XSJ_ADD_CONTENT_BUTTON);
        Jh(this.P, QCircleDaTongConstant.ElementId.EM_XSJ_MOVE_TO_BUTTON);
        Jh(this.Q, QCircleDaTongConstant.ElementId.EM_XSJ_REMOVE_BUTTON);
    }

    private void initViewModel() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.i iVar = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.i) getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.i.class);
        this.E = iVar;
        iVar.R1(this.J.getFavoritesInfo().f398434id.get(), this.J.getSchemeAttrs());
        w20.a.j().registerDisplaySurface(this.E.P1(), this.E);
        this.E.O1().observe(this, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.personal.fragment.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPersonalCollectBoxDetailFragment.this.Xh((QQCircleFeedBase$StFavoritesFeedsPageRsp) obj);
            }
        });
        this.E.getDisplaySurfaceData(new Object[0]).observe(this, new a());
    }

    protected void Nh(QFSCollectedFeedEvent qFSCollectedFeedEvent) {
        if (this.E == null) {
            return;
        }
        String feedId = qFSCollectedFeedEvent.getFeedId();
        boolean isCollected = qFSCollectedFeedEvent.isCollected();
        RFWLog.i(getTAG(), RFWLog.USR, "[handleCollectFeedEvent] feedId = " + feedId + ",isCollected = " + isCollected);
        if (!isCollected) {
            List<com.tencent.biz.qqcircle.immersive.personal.bean.e> dataList = this.I.getDataList();
            boolean z16 = false;
            int i3 = 0;
            while (true) {
                if (i3 < dataList.size()) {
                    if (TextUtils.equals(dataList.get(i3).d(), feedId)) {
                        dataList.remove(i3);
                        break;
                    }
                    i3++;
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 >= 0) {
                if (i3 == 0) {
                    z16 = true;
                }
                ci(z16, 1);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList<Part> arrayList = new ArrayList<>();
        this.F = new QFSBaseBlockPart(R.id.vfu, ai());
        QFSSharePart qFSSharePart = new QFSSharePart();
        this.G = qFSSharePart;
        qFSSharePart.setReportBeanAgent(this);
        Ih(arrayList);
        this.L.setReportBean(getReportBean());
        arrayList.add(this.L);
        arrayList.add(this.F);
        arrayList.add(this.G);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public Map<String, Object> getChildDaTongPageParams() {
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_COLLECT_FOLDER_ID, Long.valueOf(this.J.getFavoritesInfo().f398434id.get()));
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_COLLECT_FOLDER_NAME, this.J.getFavoritesInfo().title.get());
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_COLLECT_FOLDER_AUTHOR_UIN, this.J.getFavoritesInfo().owner_id.get());
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_COLLECT_FOLDER_PRODUCT_NUM, Long.valueOf(this.J.getFavoritesInfo().feed_num.get()));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gke;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_COLLECT_FOLDER_DETAIL_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        super.getEventClass();
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSPersonalCollectBoxEvent.class);
        arrayList.add(QFSLayerFeedPosSyncEvent.class);
        arrayList.add(QFSCollectedFeedEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalCollectBoxDetailFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return -1;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        View view = this.N;
        if (view != null && view.getVisibility() == 0) {
            di();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f10583673) {
            Mh();
        } else if (view.getId() == R.id.f109426fs) {
            Sh();
        } else if (view.getId() == R.id.f109416fr) {
            Rh();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(final SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSPersonalCollectBoxEvent) {
            getMainHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.fragment.b
                @Override // java.lang.Runnable
                public final void run() {
                    QFSPersonalCollectBoxDetailFragment.this.Yh(simpleBaseEvent);
                }
            });
        } else if (simpleBaseEvent instanceof QFSLayerFeedPosSyncEvent) {
            Qh((QFSLayerFeedPosSyncEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSCollectedFeedEvent) {
            Nh((QFSCollectedFeedEvent) simpleBaseEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        Vh();
        initViewModel();
        SimpleEventBus.getInstance().registerReceiver(this);
        initListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
        initIntentData();
        initView(view);
    }
}
