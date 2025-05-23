package com.tencent.biz.qqcircle.immersive.personal.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.qq.wx.voice.util.ErrorCode;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.bean.QFSPushBoxBean;
import com.tencent.biz.qqcircle.events.QCirclePushUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleUndoPushUpdateEvent;
import com.tencent.biz.qqcircle.events.QFSSuspendOpenBoxUpdateEvent;
import com.tencent.biz.qqcircle.events.QFSUpdatePushStateEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedBaseAdapter;
import com.tencent.biz.qqcircle.immersive.personal.bean.v;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalPushFeedBoxItemView;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.request.QFSOpenPushBoxRequest;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.IQFSPushOpenBoxPopWindowApi;
import com.tencent.mobileqq.qcircle.api.global.QFSPushOpenBoxInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$PushBoxViewInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StPushList;
import feedcloud.FeedCloudWrite$PushBoxBasic;
import feedcloud.FeedCloudWrite$PushBoxBasicDrawInfo;
import feedcloud.FeedCloudWrite$PushBoxDrawRocketRsp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleFeedBase$StUserPushBoxInfo;

/* loaded from: classes4.dex */
public class QFSPersonalPushedFeedFragment extends QFSPersonalBaseFeedFragment {
    private com.tencent.biz.qqcircle.immersive.personal.adapter.m Q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudWrite$PushBoxDrawRocketRsp> {
        a() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudWrite$PushBoxDrawRocketRsp feedCloudWrite$PushBoxDrawRocketRsp) {
            QLog.d("handleOpenPushBox", 1, "onResponse, isSuccess:" + z16 + ", retCode: " + j3 + ", errMsg: " + str);
            if (z16 && j3 == 0 && feedCloudWrite$PushBoxDrawRocketRsp != null) {
                QFSPersonalPushedFeedFragment.this.Uh(feedCloudWrite$PushBoxDrawRocketRsp);
                QFSPushOpenBoxInfo convertToOpenSingleBoxInfo = QFSPushOpenBoxInfo.convertToOpenSingleBoxInfo(feedCloudWrite$PushBoxDrawRocketRsp);
                convertToOpenSingleBoxInfo.setSource(QCircleDaTongConstant.ElementId.EM_XSJ_PROFILE_BOX_BUTTON);
                ((IQFSPushOpenBoxPopWindowApi) QRoute.api(IQFSPushOpenBoxPopWindowApi.class)).showPushOpenBoxWindow(QFSPersonalPushedFeedFragment.this.getContext(), convertToOpenSingleBoxInfo, null, QFSPersonalPushedFeedFragment.this.getView());
                return;
            }
            QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f19225470), 0);
        }
    }

    /* loaded from: classes4.dex */
    class b extends v.a {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.bean.v.a
        public List<String> a() {
            return Arrays.asList("update_version_op_mask");
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.bean.v.a
        public void d(@NonNull com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
            if (QFSPersonalPushedFeedFragment.this.F != null && !wVar.x() && !wVar.v() && !wVar.w()) {
                if (!wVar.z() && wVar.u(8)) {
                    QFSPersonalPushedFeedFragment.this.F.T9();
                    return;
                }
                com.tencent.biz.qqcircle.immersive.personal.viewmodel.f fVar = QFSPersonalPushedFeedFragment.this.J;
                if (fVar != null && fVar.Q1().getValue() == null) {
                    RFWLog.i("QFSPersonalPushedFeedFragment", RFWLog.USR, "[requestFeeds]");
                    QFSPersonalPushedFeedFragment.this.J.U1(true);
                }
            }
        }
    }

    public QFSPersonalPushedFeedFragment() {
        super(ErrorCode.ERROR_VERIFY_FAILED);
    }

    private void Th() {
        VideoReport.setElementId(((QCircleBaseFragment) this).mContentView, QCircleDaTongConstant.ElementId.EM_XSJ_PROFILE_PUSH_TAB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uh(FeedCloudWrite$PushBoxDrawRocketRsp feedCloudWrite$PushBoxDrawRocketRsp) {
        if (this.Q == null) {
            return;
        }
        FeedCloudWrite$PushBoxBasic feedCloudWrite$PushBoxBasic = feedCloudWrite$PushBoxDrawRocketRsp.drawBoxResult.get();
        String str = feedCloudWrite$PushBoxBasic.feed_id.get();
        FeedCloudMeta$PushBoxViewInfo feedCloudMeta$PushBoxViewInfo = feedCloudWrite$PushBoxBasic.pushBoxViewInfo.get();
        FeedCloudMeta$StPushList f16 = QCirclePushInfoManager.e().f(str);
        if (f16 != null) {
            f16.pushBoxViewInfo.set(feedCloudMeta$PushBoxViewInfo);
            QCirclePushInfoManager.e().p(str, f16);
        }
        Yh(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(feedCloudWrite$PushBoxBasic);
        com.tencent.biz.qqcircle.f.v().b(arrayList);
        SimpleEventBus.getInstance().dispatchEvent(new QFSUpdatePushStateEvent(arrayList));
    }

    private void Wh(QCircleUndoPushUpdateEvent qCircleUndoPushUpdateEvent) {
        boolean z16;
        if (this.J == null) {
            return;
        }
        String str = qCircleUndoPushUpdateEvent.mTargetFeedId;
        RFWLog.i(getTAG(), RFWLog.USR, "handleUndoPushUpdateEvent feedId = " + str);
        for (e30.b bVar : this.J.P1()) {
            if (TextUtils.equals(bVar.g().f398449id.get(), str)) {
                if (!this.J.P1().remove(bVar) && !this.P) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                this.P = z16;
                return;
            }
        }
    }

    private void Xh(com.tencent.biz.qqcircle.immersive.personal.bean.e eVar) {
        if (eVar != null && eVar.b() != null) {
            if (!HostNetworkUtils.isNetworkAvailable()) {
                QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f19225470), 0);
                QLog.d("QFSPersonalPushedFeedFragment", 1, "open box fail");
                return;
            }
            FeedCloudWrite$PushBoxBasic feedCloudWrite$PushBoxBasic = new FeedCloudWrite$PushBoxBasic();
            feedCloudWrite$PushBoxBasic.feed_id.set(eVar.d());
            feedCloudWrite$PushBoxBasic.auth_uin.set(eVar.b().poster.f398463id.get());
            ArrayList arrayList = new ArrayList();
            if (eVar.f().boxType.get() == 1) {
                FeedCloudWrite$PushBoxBasicDrawInfo feedCloudWrite$PushBoxBasicDrawInfo = new FeedCloudWrite$PushBoxBasicDrawInfo();
                feedCloudWrite$PushBoxBasicDrawInfo.box_type.set(1);
                arrayList.add(feedCloudWrite$PushBoxBasicDrawInfo);
            } else if (eVar.f().boxType.get() == 2) {
                if (eVar.f().available_box_cnt.get() == 2) {
                    FeedCloudWrite$PushBoxBasicDrawInfo feedCloudWrite$PushBoxBasicDrawInfo2 = new FeedCloudWrite$PushBoxBasicDrawInfo();
                    feedCloudWrite$PushBoxBasicDrawInfo2.box_type.set(1);
                    arrayList.add(feedCloudWrite$PushBoxBasicDrawInfo2);
                }
                FeedCloudWrite$PushBoxBasicDrawInfo feedCloudWrite$PushBoxBasicDrawInfo3 = new FeedCloudWrite$PushBoxBasicDrawInfo();
                feedCloudWrite$PushBoxBasicDrawInfo3.box_type.set(2);
                arrayList.add(feedCloudWrite$PushBoxBasicDrawInfo3);
            }
            feedCloudWrite$PushBoxBasic.drawBoxInfo.set(arrayList);
            VSNetworkHelper.getInstance().sendRequest(new QFSOpenPushBoxRequest(feedCloudWrite$PushBoxBasic), new a());
        }
    }

    private void Yh(int i3) {
        if (this.Q.s0() && this.Q.r0() != null && this.Q.r0().b() != null) {
            com.tencent.biz.qqcircle.immersive.personal.bean.o r06 = this.Q.r0();
            long j3 = r06.b().unopendPushBoxCount.get() - i3;
            if (j3 < 0) {
                j3 = 0;
            }
            r06.b().unopendPushBoxCount.set(j3);
            QQCircleFeedBase$StUserPushBoxInfo qQCircleFeedBase$StUserPushBoxInfo = new QQCircleFeedBase$StUserPushBoxInfo();
            qQCircleFeedBase$StUserPushBoxInfo.unopendPushBoxCount.set(j3);
            SimpleEventBus.getInstance().dispatchEvent(new QFSSuspendOpenBoxUpdateEvent(qQCircleFeedBase$StUserPushBoxInfo));
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalBaseFeedFragment
    public com.tencent.biz.qqcircle.immersive.personal.viewmodel.f Ah(IPartHost iPartHost) {
        return (com.tencent.biz.qqcircle.immersive.personal.viewmodel.f) getViewModel(iPartHost, "key_prefix_pushed", com.tencent.biz.qqcircle.immersive.personal.viewmodel.d.class);
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalBaseFeedFragment
    protected void Ch() {
        String I1;
        String G1;
        QLog.i("QFSPersonalPushedFeedFragment", 1, "[handleEmptyState]");
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.I;
        if (tVar != null && tVar.N1() != null && this.F != null) {
            boolean z16 = this.I.N1().z();
            if (z16) {
                I1 = uq3.c.J1();
            } else {
                I1 = uq3.c.I1();
            }
            if (z16) {
                G1 = uq3.c.H1();
            } else {
                G1 = uq3.c.G1();
            }
            this.F.M9(I1, G1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalBaseFeedFragment
    public void Ih(@NonNull List<QFSPushBoxBean> list) {
        super.Ih(list);
        Yh(list.size());
    }

    protected void Vh(QCirclePushUpdateEvent qCirclePushUpdateEvent) {
        if (this.J != null && qCirclePushUpdateEvent.getStFeed() != null) {
            FeedCloudMeta$StFeed stFeed = qCirclePushUpdateEvent.getStFeed();
            RFWLog.i(getTAG(), RFWLog.USR, "handlePushUpdateEvent feedId = " + stFeed.f398449id.get());
            if (stFeed.feedType.get() == 4) {
                return;
            }
            this.J.P1().add(0, new e30.b(stFeed).p());
            this.P = true;
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalBaseFeedFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(QCircleUndoPushUpdateEvent.class);
        eventClass.add(QCirclePushUpdateEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalPushedFeedFragment";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalBaseFeedFragment
    public void initViewModel() {
        super.initViewModel();
        this.I.O1().c(this, new b());
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalBaseFeedFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (!Oh()) {
            return;
        }
        if (simpleBaseEvent instanceof QCircleUndoPushUpdateEvent) {
            Wh((QCircleUndoPushUpdateEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCirclePushUpdateEvent) {
            Vh((QCirclePushUpdateEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalBaseFeedFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.tencent.biz.qqcircle.immersive.personal.adapter.m mVar = this.Q;
        if (mVar != null && mVar.s0() && this.Q.getNUM_BACKGOURND_ICON() != 0) {
            this.Q.notifyItemChanged(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
        Th();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalBaseFeedFragment
    public void xh(int i3, com.tencent.biz.qqcircle.immersive.personal.bean.e eVar, QCircleBaseWidgetView qCircleBaseWidgetView) {
        if (qCircleBaseWidgetView instanceof QFSPersonalPushFeedBoxItemView) {
            Xh(eVar);
        } else {
            super.xh(i3, eVar, qCircleBaseWidgetView);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalBaseFeedFragment
    protected QFSPersonalFeedBaseAdapter yh() {
        com.tencent.biz.qqcircle.immersive.personal.adapter.m mVar = new com.tencent.biz.qqcircle.immersive.personal.adapter.m(getArguments());
        this.Q = mVar;
        return mVar;
    }
}
