package com.tencent.biz.qqcircle.immersive.tab;

import android.os.Bundle;
import android.view.View;
import com.tencent.biz.qcircleshadow.lib.QCircleHostRedPointHelper;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.bizparts.z;
import com.tencent.biz.qqcircle.hodor.QFSHodorCollectManager;
import com.tencent.biz.qqcircle.immersive.events.QFSChangePgidEvent;
import com.tencent.biz.qqcircle.requests.QCircleClearCountRequest;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleRedPointAppidContants;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudRead$StClearCountInfo;
import feedcloud.FeedCloudRead$StClearCountRsp;
import java.util.List;
import qqcircle.QQCircleCounter$RedPointInfo;
import qqcircle.QQCircleCounterMsg$RedDisplayInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFollowTabFragment extends QFSFolderLayerTabFragment {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StClearCountRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f90013a;

        a(long j3) {
            this.f90013a = j3;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StClearCountRsp feedCloudRead$StClearCountRsp) {
            StringBuilder sb5 = new StringBuilder();
            if (z16 && j3 == 0) {
                long followTabFeedListLastRspTimestamp = EeveeRedpointUtil.getFollowTabFeedListLastRspTimestamp();
                long j16 = this.f90013a;
                if (j16 > followTabFeedListLastRspTimestamp) {
                    EeveeRedpointUtil.saveFollowTabFeedListLastRspTimestamp(j16);
                }
                sb5.append("[sendClearFollowTabRedPointRequest] clear outer red dot success!");
                if (feedCloudRead$StClearCountRsp != null) {
                    sb5.append(", result.retCode: ");
                    sb5.append(feedCloudRead$StClearCountRsp.result.retCode.get());
                    sb5.append(", result.msg: ");
                    sb5.append(feedCloudRead$StClearCountRsp.result.f398427msg.get());
                }
                sb5.append(", followTabFeedListLastPreRspTimestamp: ");
                sb5.append(this.f90013a);
                sb5.append(", followTabFeedListLastRspTimestamp: ");
                sb5.append(followTabFeedListLastRspTimestamp);
                QLog.d("QCircleEeveeRedPoint_QFSFollowTabFragment", 1, sb5);
                return;
            }
            sb5.append("[sendClearFollowTabRedPointRequest] clear outer red dot error! isSuccess : ");
            sb5.append(z16);
            sb5.append(", retCode: ");
            sb5.append(j3);
            if (feedCloudRead$StClearCountRsp != null) {
                sb5.append(", result.retCode: ");
                sb5.append(feedCloudRead$StClearCountRsp.result.retCode.get());
                sb5.append(", result.msg: ");
                sb5.append(feedCloudRead$StClearCountRsp.result.f398427msg.get());
            }
            QLog.e("QCircleEeveeRedPoint_QFSFollowTabFragment", 1, sb5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public QFSFollowTabFragment(QCircleTabInfo qCircleTabInfo, int i3) {
        super(qCircleTabInfo, i3);
        QFSHodorCollectManager.f84689a.a("qfs_follow_tab_create_cost");
    }

    private void ti() {
        QCircleTabInfo qCircleTabInfo = this.E;
        if (qCircleTabInfo != null && qCircleTabInfo.getType() == 1) {
            QLog.d(EeveeRedpointUtil.LOG_TAG_PREFIX + getTAG(), 1, "[clearLocalFollowRedPoint");
            QCircleHostRedPointHelper.setSmallRedPointReaded(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE);
        }
    }

    private void ui(long j3) {
        QLog.d("QCircleEeveeRedPoint_QFSFollowTabFragment", 1, "[sendClearFollowTabRedPointRequest]");
        FeedCloudRead$StClearCountInfo feedCloudRead$StClearCountInfo = new FeedCloudRead$StClearCountInfo();
        feedCloudRead$StClearCountInfo.clearType.set(3);
        feedCloudRead$StClearCountInfo.countType.set(2);
        feedCloudRead$StClearCountInfo.rewriteClearTime.set(j3);
        VSNetworkHelper.getInstance().sendRequest(new QCircleClearCountRequest(HostDataTransUtils.getAccount(), feedCloudRead$StClearCountInfo), new a(j3));
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public int Dh() {
        return 301;
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderLayerTabFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        assembleParts.add(new z());
        return assembleParts;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.g_z;
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_FOLLOWING_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSFollowTabFragment";
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderLayerTabFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 501;
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void hi() {
        super.hi();
        ti();
        if (ri() != null) {
            long followTabFeedListLastPreRspTimestamp = EeveeRedpointUtil.getFollowTabFeedListLastPreRspTimestamp();
            long followTabFeedListLastRspTimestamp = EeveeRedpointUtil.getFollowTabFeedListLastRspTimestamp();
            if (followTabFeedListLastPreRspTimestamp > followTabFeedListLastRspTimestamp) {
                ui(followTabFeedListLastPreRspTimestamp);
            }
            QLog.d("QFSFollowTabFragment", 1, "[setUserVisibleHint] followTabFeedListLastPreRspTimestamp: " + followTabFeedListLastPreRspTimestamp + ", followTabFeedListLastRspTimestamp: " + followTabFeedListLastRspTimestamp);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderLayerTabFragment, com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        SimpleEventBus.getInstance().dispatchEvent(new QFSChangePgidEvent(getDaTongPageId()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderLayerTabFragment, com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        QFSHodorCollectManager.f84689a.c("qfs_follow_tab_create_cost");
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void rh() {
        List<QQCircleCounterMsg$RedDisplayInfo> list;
        QQCircleCounter$RedPointInfo smallRedPointInfotByAppid = QCircleHostRedPointHelper.getSmallRedPointInfotByAppid(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE);
        if (smallRedPointInfotByAppid != null && (list = smallRedPointInfotByAppid.rptRedInfo.get()) != null && list.size() > 0) {
            this.H = true;
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z16) {
        super.setUserVisibleHint(z16);
        if (z16) {
            QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(22).setSubActionType(1));
        }
    }
}
