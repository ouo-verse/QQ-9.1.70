package com.tencent.biz.qqcircle.immersive.personal.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.reflect.TypeToken;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectScrollProcessor;
import com.tencent.biz.qqcircle.bean.QFSPushBoxBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.qqcircle.events.QFSUpdatePushStateEvent;
import com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedBaseAdapter;
import com.tencent.biz.qqcircle.immersive.personal.bean.v;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSLayerFeedPosSyncEvent;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSNormalNoMoreHintView;
import com.tencent.biz.qqcircle.immersive.utils.ad;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.QFS5507ReportHelper;
import cooperation.qqcircle.utils.JsonBinder;
import feedcloud.FeedCloudMeta$PushBoxViewInfo;
import feedcloud.FeedCloudWrite$PushBoxBasic;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleFeedBase$StFeedBusiReqData;

/* loaded from: classes4.dex */
public abstract class QFSPersonalBaseFeedFragment extends QFSPersonalBaseNestScrollFragment {
    protected BlockPart E;
    protected com.tencent.biz.qqcircle.immersive.personal.part.y F;
    protected NestScrollRecyclerView G;
    protected QFSPersonalFeedBaseAdapter H;
    protected com.tencent.biz.qqcircle.immersive.personal.viewmodel.t I;
    protected com.tencent.biz.qqcircle.immersive.personal.viewmodel.f J;
    private f K;
    protected QFSPersonalDetailsFragment L;
    protected int M;
    protected int N = 0;
    protected boolean P = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements MultiViewBlock.OnLoadDataDelegate<QFSPersonalFeedBaseAdapter> {
        a() {
        }

        @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onLoadData(LoadInfo loadInfo, QFSPersonalFeedBaseAdapter qFSPersonalFeedBaseAdapter) {
            if (loadInfo.isLoadMoreState()) {
                QFSPersonalBaseFeedFragment.this.J.S1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements QFSPersonalFeedBaseAdapter.b {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedBaseAdapter.b
        public void a(int i3, com.tencent.biz.qqcircle.immersive.personal.bean.e eVar, QCircleBaseWidgetView qCircleBaseWidgetView) {
            if (FastClickUtils.isFastDoubleClick("fast_click_personal_detail_publish")) {
                return;
            }
            QFSPersonalBaseFeedFragment.this.xh(i3, eVar, qCircleBaseWidgetView);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements Observer<UIStateData<List<e30.b>>> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UIStateData<List<e30.b>> uIStateData) {
            QFSPersonalBaseFeedFragment.this.Rh(uIStateData);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d extends v.a {
        d() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.bean.v.a
        public List<String> a() {
            return Arrays.asList("key_version_extend_base_info", "update_versionP_user_black");
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.bean.v.a
        public void d(@NonNull com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
            if (!wVar.z() && QFSPersonalBaseFeedFragment.this.F != null) {
                if (wVar.x()) {
                    QFSPersonalBaseFeedFragment.this.F.Q9();
                    return;
                }
                if (wVar.v()) {
                    QFSPersonalBaseFeedFragment.this.F.M9(uq3.c.c2(), uq3.c.b2());
                } else if (wVar.w()) {
                    QFSPersonalBaseFeedFragment.this.F.M9(uq3.c.c2(), uq3.c.a2());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e extends RecyclerView.OnScrollListener {
        e() {
        }

        public void handleScrollStateChanged(int i3) {
            QCircleAspectScrollProcessor.getInstance().onScrollState(QFSPersonalBaseFeedFragment.this, i3);
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
            if (recyclerView.getLayoutManager() instanceof SafeGridLayoutManager) {
                SafeGridLayoutManager safeGridLayoutManager = (SafeGridLayoutManager) recyclerView.getLayoutManager();
                QFSPersonalBaseFeedFragment.this.N = ((safeGridLayoutManager.findFirstVisibleItemPosition() + safeGridLayoutManager.findLastVisibleItemPosition()) / 2) / 3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class f extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QFSPersonalBaseFeedFragment> f88600a;

        /* loaded from: classes4.dex */
        class a extends TypeToken<List<QFSPushBoxBean>> {
            a() {
            }
        }

        public f(QFSPersonalBaseFeedFragment qFSPersonalBaseFeedFragment) {
            this.f88600a = new WeakReference<>(qFSPersonalBaseFeedFragment);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("push_box_json");
            if (!TextUtils.isEmpty(stringExtra) && this.f88600a.get() != null) {
                QFSPersonalBaseFeedFragment qFSPersonalBaseFeedFragment = this.f88600a.get();
                List<QFSPushBoxBean> fromJson = JsonBinder.getInstance().fromJson(stringExtra, new a().getType());
                if (fromJson == null) {
                    return;
                }
                qFSPersonalBaseFeedFragment.Ih(fromJson);
            }
        }
    }

    public QFSPersonalBaseFeedFragment(int i3) {
        this.M = i3;
    }

    private String Bh(int i3) {
        if (i3 == 20102) {
            return com.tencent.biz.qqcircle.utils.h.a(R.string.f19306497);
        }
        if (i3 == 20108) {
            return com.tencent.biz.qqcircle.utils.h.a(R.string.f19305496);
        }
        if (i3 == 20103) {
            return com.tencent.biz.qqcircle.utils.h.a(R.string.f1930949_);
        }
        return "";
    }

    private void Eh(QFSLayerFeedPosSyncEvent qFSLayerFeedPosSyncEvent) {
        QLog.d(getTAG(), 4, "QFSLayerFeedPosSyncEvent position = " + qFSLayerFeedPosSyncEvent.getPos());
        if (this.J != null && this.H != null && qFSLayerFeedPosSyncEvent.getPageCode() == hashCode()) {
            ad.g(this.H.i0(), this.G, this.L.Jh(), qFSLayerFeedPosSyncEvent, this.H.getHeaderCount());
        }
    }

    private void Fh(UIStateData<List<e30.b>> uIStateData) {
        QLog.i(getTAG(), 1, "[handleModify] -> uiStateData = " + uIStateData);
        if (this.J != null && this.H != null && uIStateData != null && uIStateData.getData() != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<e30.b> it = uIStateData.getData().iterator();
            while (it.hasNext()) {
                arrayList.add(new com.tencent.biz.qqcircle.immersive.personal.bean.e(it.next()));
            }
            this.H.setDatas(arrayList);
        }
    }

    private void Gh() {
        com.tencent.biz.qqcircle.immersive.personal.part.y yVar;
        if (!HostNetworkUtils.isNetworkAvailable() && (yVar = this.F) != null) {
            yVar.N9(uq3.c.N3());
        }
    }

    private void Lh() {
        this.H.setOnLoadDataDelegate(new a());
        this.H.p0(new b());
    }

    private void Mh() {
        this.E.getBlockContainer().getRecyclerView().setNestedScrollingEnabled(true);
        this.E.getBlockContainer().setEnableRefresh(false);
        this.E.getBlockContainer().setEnableLoadMore(true);
        this.E.getBlockContainer().setParentFragment(this);
        this.E.getBlockContainer().getBlockMerger().setTryToLoadMoreWhenNotFullScreen(3);
        this.E.getBlockContainer().getBlockMerger().setCustomNoMoreDataView(new QFSNormalNoMoreHintView(getContext()));
    }

    private void Qh() {
        UIStateData<List<e30.b>> value;
        if (!this.P || (value = this.J.Q1().getValue()) == null) {
            return;
        }
        List<e30.b> P1 = this.J.P1();
        if (RFSafeListUtils.isEmpty(P1)) {
            value.setState(0);
        } else {
            value.setState(3);
        }
        value.setData(value.getIsLoadMore(), P1);
        this.J.Q1().setValue(value);
        this.P = false;
    }

    private void initReceiver() {
        if (getActivity() != null) {
            this.K = new f(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("action_open_push_box");
            try {
                getActivity().registerReceiver(this.K, intentFilter);
            } catch (Exception e16) {
                RFWLog.e("QFSPersonalBaseFeedFragment", RFWLog.USR, "registerReceiver failure , msg = " + e16.getMessage());
            }
        }
    }

    private void wh(int i3, com.tencent.biz.qqcircle.immersive.personal.bean.e eVar, QCircleBaseWidgetView qCircleBaseWidgetView) {
        if (eVar != null && qCircleBaseWidgetView != null && this.J != null) {
            QCircleLayerBean zh5 = zh(i3, eVar);
            int[] iArr = new int[2];
            qCircleBaseWidgetView.getLocationInWindow(iArr);
            QFSTransitionAnimBean qFSTransitionAnimBean = new QFSTransitionAnimBean();
            int i16 = iArr[0];
            zh5.setTransitionAnimBean(qFSTransitionAnimBean.setLayoutRect(new QFSTransitionAnimBean.SourceRect(i16, iArr[1], qCircleBaseWidgetView.getWidth() + i16, iArr[1] + qCircleBaseWidgetView.getHeight())).setScaleType(ImageView.ScaleType.CENTER_CROP).setImageUrl(eVar.a()));
            zh5.setPrePersonalPageUin(this.J.getUin());
            com.tencent.biz.qqcircle.launcher.c.u(getContext(), zh5);
            return;
        }
        QLog.e(getTAG(), 1, "[callOnFeedClick] params error: feedInfo=" + eVar + ", itemView=" + qCircleBaseWidgetView + ",mFeedViewModel=" + this.J);
    }

    public abstract com.tencent.biz.qqcircle.immersive.personal.viewmodel.f Ah(IPartHost iPartHost);

    protected abstract void Ch();

    protected void Dh(String str, long j3) {
        QLog.i(getTAG(), 1, "[handleError] -> errorMsg = " + str);
        this.F.P9(str, j3);
    }

    protected void Hh(QCirclePolyPraiseUpdateEvent qCirclePolyPraiseUpdateEvent) {
        String str = qCirclePolyPraiseUpdateEvent.mTargetFeedId;
        int i3 = qCirclePolyPraiseUpdateEvent.mPraisedStatus;
        int i16 = qCirclePolyPraiseUpdateEvent.mPraisedNum;
        boolean isPraised = qCirclePolyPraiseUpdateEvent.isPraised();
        RFWLog.i(getTAG(), RFWLog.USR, "handlePraisedUpdateEvent feedId = " + str + ",praisedStatus = " + i3 + ",praisedCount = " + i16 + ",isPraised = " + isPraised);
        for (e30.b bVar : this.J.P1()) {
            if (bVar != null && bVar.g() != null && TextUtils.equals(str, bVar.g().f398449id.get())) {
                bVar.g().likeInfo.status.set(i3);
                bVar.g().likeInfo.count.set(i16);
                bVar.g().likeInfo.setHasFlag(true);
                this.P = true;
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ih(@NonNull List<QFSPushBoxBean> list) {
        if (this.H != null && this.J != null) {
            HashMap hashMap = new HashMap();
            for (QFSPushBoxBean qFSPushBoxBean : list) {
                hashMap.put(qFSPushBoxBean.getFeedId(), qFSPushBoxBean);
            }
            for (int i3 = 0; i3 < this.H.getDataList().size(); i3++) {
                com.tencent.biz.qqcircle.immersive.personal.bean.e item = this.H.getItem(i3);
                QFSPushBoxBean qFSPushBoxBean2 = (QFSPushBoxBean) hashMap.get(item.d());
                if (qFSPushBoxBean2 != null) {
                    FeedCloudMeta$PushBoxViewInfo pushBoxViewInfo = qFSPushBoxBean2.getPushBoxViewInfo();
                    item.h(pushBoxViewInfo);
                    QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData = (QQCircleFeedBase$StFeedBusiReqData) item.c().b("DITTO_FEED_BUSI_REQ_DATA");
                    qQCircleFeedBase$StFeedBusiReqData.pushList.pushBoxViewInfo.set(pushBoxViewInfo);
                    item.c().o("DITTO_FEED_BUSI_REQ_DATA", qQCircleFeedBase$StFeedBusiReqData);
                    this.H.notifyItemChanged(i3);
                    com.tencent.biz.qqcircle.immersive.personal.viewmodel.f fVar = this.J;
                    if (fVar != null && fVar.Q1().getValue() != null && this.J.Q1().getValue().getData() != null && this.J.Q1().getValue().getData().size() > i3) {
                        e30.b bVar = this.J.Q1().getValue().getData().get(i3);
                        bVar.o("DITTO_FEED_BUSI_REQ_DATA", qQCircleFeedBase$StFeedBusiReqData);
                        bVar.g().busiData.set(ByteStringMicro.copyFrom(qQCircleFeedBase$StFeedBusiReqData.toByteArray()));
                    }
                }
            }
        }
    }

    protected void Jh(UIStateData<List<e30.b>> uIStateData) {
        QLog.i(getTAG(), 1, "[handleSuccess] -> uiStateData = " + uIStateData);
        if (this.J != null && this.H != null && uIStateData != null && uIStateData.getData() != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<e30.b> it = uIStateData.getData().iterator();
            while (it.hasNext()) {
                arrayList.add(new com.tencent.biz.qqcircle.immersive.personal.bean.e(it.next()));
            }
            this.H.setDatas(arrayList);
            this.F.E9();
        }
    }

    protected void Kh(QFSUpdatePushStateEvent qFSUpdatePushStateEvent) {
        if (qFSUpdatePushStateEvent == null) {
            return;
        }
        List<FeedCloudWrite$PushBoxBasic> pushBoxBasics = qFSUpdatePushStateEvent.getPushBoxBasics();
        ArrayList arrayList = new ArrayList();
        for (FeedCloudWrite$PushBoxBasic feedCloudWrite$PushBoxBasic : pushBoxBasics) {
            if (feedCloudWrite$PushBoxBasic != null) {
                arrayList.add(new QFSPushBoxBean(feedCloudWrite$PushBoxBasic));
            }
        }
        Ih(arrayList);
    }

    protected void Nh() {
        QFSPersonalFeedBaseAdapter qFSPersonalFeedBaseAdapter = this.H;
        if (qFSPersonalFeedBaseAdapter != null && this.J != null) {
            NestScrollRecyclerView parentRecyclerView = qFSPersonalFeedBaseAdapter.getParentRecyclerView();
            this.G = parentRecyclerView;
            parentRecyclerView.addOnScrollListener(new e());
        }
    }

    public boolean Oh() {
        com.tencent.biz.qqcircle.immersive.personal.data.w N1;
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.I;
        if (tVar == null || (N1 = tVar.N1()) == null) {
            return false;
        }
        return N1.z();
    }

    protected List<MultiViewBlock> Ph() {
        QFSPersonalFeedBaseAdapter yh5 = yh();
        this.H = yh5;
        yh5.q0(Bh(this.M));
        Lh();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.H);
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void Rh(UIStateData<List<e30.b>> uIStateData) {
        boolean z16;
        QFSPersonalFeedBaseAdapter qFSPersonalFeedBaseAdapter;
        if (uIStateData == null) {
            return;
        }
        boolean isFinish = uIStateData.getIsFinish();
        int state = uIStateData.getState();
        int i3 = 0;
        if (state != 0) {
            if (state != 1) {
                if (state != 2) {
                    if (state != 3) {
                        if (state != 4) {
                            if (state == 7) {
                                Fh(uIStateData);
                            }
                        } else {
                            Dh(uIStateData.getMsg(), uIStateData.getRetCode());
                        }
                    } else {
                        z16 = true;
                    }
                } else {
                    z16 = false;
                }
                Jh(uIStateData);
                this.E.getBlockContainer().getBlockMerger().resetTryToLoadMoreCount();
            } else {
                z16 = false;
            }
            qFSPersonalFeedBaseAdapter = this.H;
            if (qFSPersonalFeedBaseAdapter != null) {
                qFSPersonalFeedBaseAdapter.getLoadInfo().setFinish(isFinish);
                if (z16) {
                    this.H.notifyLoadingComplete(true, isFinish);
                }
            }
            String tag = getTAG();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[updateData] -> state = ");
            sb5.append(uIStateData.getState());
            sb5.append(",isLoadMore = ");
            sb5.append(uIStateData.getIsLoadMore());
            sb5.append(",isLoadingComplete = ");
            sb5.append(z16);
            sb5.append(",isFinish = ");
            sb5.append(isFinish);
            sb5.append(",dataSize = ");
            if (uIStateData.getData() != null) {
                i3 = uIStateData.getData().size();
            }
            sb5.append(i3);
            QLog.i(tag, 1, sb5.toString());
        }
        Ch();
        z16 = true;
        qFSPersonalFeedBaseAdapter = this.H;
        if (qFSPersonalFeedBaseAdapter != null) {
        }
        String tag2 = getTAG();
        StringBuilder sb52 = new StringBuilder();
        sb52.append("[updateData] -> state = ");
        sb52.append(uIStateData.getState());
        sb52.append(",isLoadMore = ");
        sb52.append(uIStateData.getIsLoadMore());
        sb52.append(",isLoadingComplete = ");
        sb52.append(z16);
        sb52.append(",isFinish = ");
        sb52.append(isFinish);
        sb52.append(",dataSize = ");
        if (uIStateData.getData() != null) {
        }
        sb52.append(i3);
        QLog.i(tag2, 1, sb52.toString());
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        BlockPart blockPart = new BlockPart(R.id.vg9, Ph(), 2, 3);
        this.E = blockPart;
        arrayList.add(blockPart);
        com.tencent.biz.qqcircle.immersive.personal.part.y yVar = new com.tencent.biz.qqcircle.immersive.personal.part.y();
        this.F = yVar;
        arrayList.add(yVar);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.glh;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(QFSLayerFeedPosSyncEvent.class);
        eventClass.add(QCirclePolyPraiseUpdateEvent.class);
        eventClass.add(QFSUpdatePushStateEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return TVKQQLiveAssetPlayerMsg.PLAYER_INFO_ON_RICH_MEDIA_PREPARE_FAILED;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initViewModel() {
        QLog.i(getTAG(), 1, "[initViewModel] getParentFragment() = " + getParentFragment());
        if (!(getParentFragment() instanceof QFSPersonalDetailsFragment)) {
            return;
        }
        QFSPersonalDetailsFragment qFSPersonalDetailsFragment = (QFSPersonalDetailsFragment) getParentFragment();
        this.L = qFSPersonalDetailsFragment;
        this.J = Ah(qFSPersonalDetailsFragment);
        w20.a.j().registerDisplaySurface(this.J.R1(), this.J);
        this.I = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.t) getViewModel(this.L, "", com.tencent.biz.qqcircle.immersive.personal.viewmodel.t.class);
        this.J.Q1().observe(this, new c());
        this.I.O1().c(this, new d());
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initReceiver();
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (getActivity() != null && this.K != null) {
            try {
                getActivity().unregisterReceiver(this.K);
            } catch (Exception e16) {
                RFWLog.e("QFSPersonalBaseFeedFragment", RFWLog.USR, "unregisterReceiver failure , msg = " + e16.getMessage());
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.f fVar = this.J;
        if (fVar != null) {
            fVar.onPause();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSLayerFeedPosSyncEvent) {
            Eh((QFSLayerFeedPosSyncEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCirclePolyPraiseUpdateEvent) {
            Hh((QCirclePolyPraiseUpdateEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSUpdatePushStateEvent) {
            Kh((QFSUpdatePushStateEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Qh();
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.f fVar = this.J;
        if (fVar != null) {
            fVar.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalBaseNestScrollFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        Mh();
        initViewModel();
        Nh();
        Gh();
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalBaseNestScrollFragment
    protected NestScrollRecyclerView sh() {
        QFSPersonalFeedBaseAdapter qFSPersonalFeedBaseAdapter = this.H;
        if (qFSPersonalFeedBaseAdapter == null) {
            return null;
        }
        return qFSPersonalFeedBaseAdapter.getParentRecyclerView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xh(int i3, com.tencent.biz.qqcircle.immersive.personal.bean.e eVar, QCircleBaseWidgetView qCircleBaseWidgetView) {
        wh(i3, eVar, qCircleBaseWidgetView);
    }

    protected QFSPersonalFeedBaseAdapter yh() {
        return new QFSPersonalFeedBaseAdapter(getArguments());
    }

    public QCircleLayerBean zh(int i3, com.tencent.biz.qqcircle.immersive.personal.bean.e eVar) {
        QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
        qCircleLayerBean.setSourceType(this.M);
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setSourceType(this.M);
        if (eVar != null) {
            qCircleLayerBean.setFeed(eVar.b());
        }
        qCircleLayerBean.setDataPosInList(i3);
        qCircleLayerBean.setTransInitBean(qCircleInitBean);
        qCircleLayerBean.setLayerBizAssemblerType("biz_data_share");
        qCircleLayerBean.setGlobalViewModelKey(this.J.R1());
        qCircleLayerBean.setPageCode(hashCode());
        String Hh = this.L.Hh();
        if (!TextUtils.isEmpty(Hh)) {
            qCircleLayerBean.getExtraTypeInfo().mReportExtraMap.put(QFS5507ReportHelper.JsonKey.TRANS_FEEDID, Hh);
        }
        String Ih = this.L.Ih();
        if (!TextUtils.isEmpty(Ih)) {
            qCircleLayerBean.getExtraTypeInfo().mReportExtraMap.put(QFS5507ReportHelper.JsonKey.TRANS_REQID, Ih);
        }
        return qCircleLayerBean;
    }
}
