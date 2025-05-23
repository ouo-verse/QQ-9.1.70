package com.tencent.biz.qqcircle.immersive.tab;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.events.QFSFolderFirstFragmentShowEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSLayerTabPart;
import com.tencent.biz.qqcircle.immersive.tab.mixfeed.QFSMixFeedMainTabFragment;
import com.tencent.biz.qqcircle.immersive.utils.ba;
import com.tencent.biz.qqcircle.lazyload.QFSNotifyLazyLoadEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.ILazyLoader;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.loader.ASEngineUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.event.QCircleFrameEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleSelectTabEvent;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StSubTabInfo;
import qqcircle.QQCircleFeedBase$StTabInfo;
import qqcircle.QQCircleFeedBase$StTabJumpUrlInfo;
import qqcircle.QQCircleFeedBase$StTabOpInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class QFSFolderTabFragment extends QFSBaseFragment implements ILazyLoader {
    protected final QCircleTabInfo E;
    protected int F;
    protected boolean H;
    private boolean I;
    private boolean J;
    private long K;
    private boolean M;
    private boolean N;
    protected String Q;
    protected int G = -1;
    private boolean L = true;
    protected boolean P = true;

    /* JADX INFO: Access modifiers changed from: protected */
    public QFSFolderTabFragment(QCircleTabInfo qCircleTabInfo, int i3) {
        this.E = qCircleTabInfo;
        this.F = i3;
        rh();
    }

    private void Bh() {
        QCircleInitBean qCircleInitBean;
        boolean isLaunchFromFolderPage = QCircleReportHelper.getInstance().isLaunchFromFolderPage();
        QLog.d(QCircleReportHelper.TAG, 1, getTAG() + " onAttach isLaunchFromFolderPage:" + isLaunchFromFolderPage);
        if (!isLaunchFromFolderPage || !Oh() || (qCircleInitBean = (QCircleInitBean) getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean")) == null) {
            return;
        }
        QCircleReportHelper.getInstance().setLaunchParms(QCircleReportHelper.LaunchParam.wrap(qCircleInitBean.getLaunchFrom(), qCircleInitBean.getLaunchId(), qCircleInitBean.getUin(), getPageId(), qCircleInitBean.getSchemeAttrs()));
        QLog.d(QCircleReportHelper.TAG, 1, getTAG() + " launchPageId:" + getPageId());
    }

    private void Fh(QCirclePanelStateEvent qCirclePanelStateEvent) {
        if (!Rh()) {
            return;
        }
        this.M = qCirclePanelStateEvent.isShowing();
    }

    private void Ih(QCirclePanelStateEvent qCirclePanelStateEvent) {
        if (qCirclePanelStateEvent.getPanelType() == 0) {
            Fh(qCirclePanelStateEvent);
        }
    }

    private void Jh(QCircleFrameEvent qCircleFrameEvent) {
        if (getContext() != null && getContext().hashCode() != qCircleFrameEvent.mHashCode) {
            bi(qCircleFrameEvent.mRefreshTab);
        }
    }

    public static boolean Ph(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith("http") && !str.startsWith("https")) {
            return false;
        }
        return true;
    }

    public static boolean Qh(String str) {
        return !TextUtils.isEmpty(QFSKuiklyFragment.ri(str));
    }

    public static QFSFolderTabFragment uh(QCircleTabInfo qCircleTabInfo, int i3) {
        QQCircleFeedBase$StTabJumpUrlInfo qQCircleFeedBase$StTabJumpUrlInfo;
        if (qCircleTabInfo == null) {
            return null;
        }
        if (QFSGameTabFragment.INSTANCE.a(qCircleTabInfo)) {
            return new QFSFolderTabAutoMemoryFragment(qCircleTabInfo, i3);
        }
        int type = qCircleTabInfo.getType();
        if (type != 1) {
            if (type != 6) {
                if (type != 8) {
                    if (type != 9) {
                        switch (type) {
                            case 11:
                                QQCircleFeedBase$StTabOpInfo tabDiyConfig = qCircleTabInfo.getTabDiyConfig();
                                if (tabDiyConfig != null && (qQCircleFeedBase$StTabJumpUrlInfo = tabDiyConfig.jumpUrlInfo) != null) {
                                    String str = qQCircleFeedBase$StTabJumpUrlInfo.jumpUrl.get();
                                    RFWLog.d("QFSFolderTabFragment", RFWLog.USR, "is yuheng type url " + str);
                                    if (Ph(str)) {
                                        return new QFSActivityTabFragment(qCircleTabInfo, i3);
                                    }
                                    if (Qh(str)) {
                                        return new QFSKuiklyFragment(qCircleTabInfo, i3);
                                    }
                                    return new QFSFolderTabAutoMemoryFragment(qCircleTabInfo, i3);
                                }
                                RFWLog.e("QFSFolderTabFragment", RFWLog.USR, "yuheng jumpUrlInfo is null");
                                return new QFSFolderTabAutoMemoryFragment(qCircleTabInfo, i3);
                            case 12:
                            case 13:
                                return new QFSSimpleTabFragment(qCircleTabInfo, i3);
                            default:
                                return new QFSFolderTabAutoMemoryFragment(qCircleTabInfo, i3);
                        }
                    }
                    return new QFSFriendTabFragment(qCircleTabInfo, i3);
                }
                return new QFSMixFeedMainTabFragment(qCircleTabInfo, i3);
            }
            return new QFSRecommendTabFragment(qCircleTabInfo, i3);
        }
        return new QFSFollowTabFragment(qCircleTabInfo, i3);
    }

    public int Ah() {
        Part part = getPartManager().getPart(QFSLayerTabPart.class.getName());
        if (!(part instanceof QFSLayerTabPart)) {
            return -1;
        }
        return ((QFSLayerTabPart) part).X9();
    }

    public int Ch() {
        return 1;
    }

    public int Dh() {
        return 200;
    }

    public QCircleTabInfo Eh() {
        return this.E;
    }

    public void Gh() {
        if (this.E == null) {
            return;
        }
        QCircleSelectTabEvent qCircleSelectTabEvent = new QCircleSelectTabEvent(6);
        qCircleSelectTabEvent.needDownOnePage = true;
        SimpleEventBus.getInstance().dispatchEvent(qCircleSelectTabEvent);
        QCircleToast.h(R.string.f19048428, 2000);
        xh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Hh(QFSNotifyLazyLoadEvent qFSNotifyLazyLoadEvent) {
        if (qFSNotifyLazyLoadEvent.getNotifyId() == Ch()) {
            makeSureInit(true);
        }
    }

    public boolean Kh() {
        return j60.a.b(this.E);
    }

    public boolean Mh() {
        if (this.H) {
            return true;
        }
        return j60.a.a(this.E);
    }

    public boolean Nh() {
        return this.L;
    }

    public boolean Oh() {
        return this.J;
    }

    public boolean Rh() {
        return this.I;
    }

    public boolean Sh() {
        return this.N;
    }

    public boolean Th() {
        QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo;
        QCircleTabInfo qCircleTabInfo = this.E;
        if (qCircleTabInfo != null && (qQCircleFeedBase$StTabInfo = qCircleTabInfo.mTab) != null && qQCircleFeedBase$StTabInfo.tabInfoByOperators.tabIconInfo.effectOnPageIcons.get() == 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Uh(int i3, int i16) {
        QCircleTabInfo qCircleTabInfo = this.E;
        if (qCircleTabInfo == null) {
            return false;
        }
        int type = qCircleTabInfo.getType();
        if (this.G != i16 || type != i3) {
            return false;
        }
        return true;
    }

    public boolean Vh() {
        return false;
    }

    public boolean Wh() {
        return true;
    }

    public void Yh(boolean z16) {
        View view = ((QCircleBaseFragment) this).mContentView;
        if (view == null) {
            return;
        }
        if (z16) {
            view.setBackgroundColor(yh());
        } else {
            view.setBackground(null);
        }
    }

    protected void Zh() {
        if (System.currentTimeMillis() - this.K > 1000) {
            gi(2);
            this.K = System.currentTimeMillis();
        }
    }

    public void bi(int i3) {
        if ((i3 == 0 || i3 == 4) && (isResumed() & (!(this instanceof QFSMixFeedMainTabFragment)))) {
            Zh();
        }
    }

    public abstract void di();

    public void ei(int i3) {
        if (getPartManager() == null) {
            return;
        }
        Part part = getPartManager().getPart(QFSLayerTabPart.class.getName());
        if (!(part instanceof QFSLayerTabPart)) {
            return;
        }
        QFSLayerTabPart qFSLayerTabPart = (QFSLayerTabPart) part;
        qFSLayerTabPart.La(qFSLayerTabPart.X9() + i3, false);
    }

    public abstract void fi();

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        return "";
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(QFSNotifyLazyLoadEvent.class);
        eventClass.add(QCircleFrameEvent.class);
        eventClass.add(QCirclePanelStateEvent.class);
        return eventClass;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getTitleName() {
        QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo;
        QQCircleFeedBase$StSubTabInfo qQCircleFeedBase$StSubTabInfo;
        QCircleTabInfo qCircleTabInfo = this.E;
        if (qCircleTabInfo == null) {
            return null;
        }
        if (this.G != -1 && (qQCircleFeedBase$StTabInfo = qCircleTabInfo.mTab) != null) {
            int size = qQCircleFeedBase$StTabInfo.subTabInfo.size();
            int i3 = this.G;
            if (size > i3 && (qQCircleFeedBase$StSubTabInfo = qCircleTabInfo.mTab.subTabInfo.get(i3)) != null) {
                return qQCircleFeedBase$StSubTabInfo.tabName.get();
            }
        }
        return qCircleTabInfo.getName();
    }

    public void gi(int i3) {
        fi();
    }

    public void hi() {
        this.H = false;
        if (Mh() || Kh()) {
            j60.a.j(this.E);
        }
    }

    public void ii(String str) {
        this.Q = str;
    }

    public boolean isLazyLoad() {
        return !Oh();
    }

    public void ji(boolean z16) {
        this.P = z16;
    }

    public void ki(boolean z16) {
        QCircleTabInfo qCircleTabInfo;
        this.J = z16;
        this.I = z16;
        this.N = z16;
        if (z16 && (qCircleTabInfo = this.E) != null) {
            QCircleFolderFunnelCollect.setPrimaryState(String.valueOf(qCircleTabInfo.getSource()));
        }
    }

    public void li(boolean z16) {
        this.N = z16;
    }

    public void mi(boolean z16) {
        this.L = z16;
        if (z16) {
            sh();
        } else {
            di();
        }
    }

    public void ni(int i3) {
        this.G = i3;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Bh();
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        this.I = false;
        super.onPause();
        QLog.d(getTAG(), 1, getTAG() + "->onPageUnselected");
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSNotifyLazyLoadEvent) {
            Hh((QFSNotifyLazyLoadEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCircleFrameEvent) {
            Jh((QCircleFrameEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCirclePanelStateEvent) {
            Ih((QCirclePanelStateEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        this.I = true;
        super.onResume();
        QLog.d(getTAG(), 1, getTAG() + "->onPageSelected");
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment.1
            @Override // java.lang.Runnable
            public void run() {
                Context hostContext = ASEngineUtils.getHostContext(QFSFolderTabFragment.this.getActivity());
                if (!(hostContext instanceof Activity) || !QFSFolderTabFragment.this.Wh()) {
                    return;
                }
                QUIImmersiveHelper.s((Activity) hostContext, true, true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NonNull View view, @Nullable Bundle bundle) {
        int i3;
        super.onViewCreatedAfterPartInit(view, bundle);
        if (this.J) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                i3 = activity.hashCode();
            } else {
                i3 = 0;
            }
            RFWLog.d("QFSFolderTabFragment", RFWLog.USR, "send first load event");
            SimpleEventBus.getInstance().dispatchEvent(new QFSFolderFirstFragmentShowEvent(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
        QCircleFolderFunnelCollect.record(QCircleFolderFunnelCollect.PERIOD_INIT_FOLDER_PAGE);
    }

    public abstract void scrollToTop();

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z16) {
        super.setUserVisibleHint(z16);
        if (z16) {
            QCircleReportHelper.getInstance().pushPageScene(getPageId());
            QCircleReportHelper.getInstance().recordPageStartShow(getPageId());
        } else {
            QCircleReportHelper.getInstance().recordPageEndShow(getPageId(), isHaveInteractive());
            QCircleReportHelper.getInstance().popPageScene(getPageId());
        }
    }

    public abstract void sh();

    public void wh() {
        PBStringField pBStringField;
        FeedCloudMeta$StFeed zh5 = zh();
        if (zh5 == null) {
            return;
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        PBStringField pBStringField2 = zh5.f398449id;
        if (pBStringField2 != null) {
            buildElementParams.put("xsj_feed_id", pBStringField2.get());
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser = zh5.poster;
        if (feedCloudMeta$StUser != null && (pBStringField = feedCloudMeta$StUser.f398463id) != null) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, pBStringField.get());
        }
        buildElementParams.put("xsj_custom_pgid", getDaTongPageId());
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_QUIT_GESTURE_SLIDING);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", buildElementParams);
        QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder(ua0.c.c(zh5));
        dataBuilder.setActionType(1500).setSubActionType(2).setToUin(zh5.poster.f398463id.get()).setPosition(Ah()).setActTime(System.currentTimeMillis()).setRequestId(ba.d(zh5)).setSealTransfer(zh5.recomInfo.recomTrace.get()).setPageId(getPageId()).setFirstFeedId(w20.a.j().h());
        QCircleLpReportDc05507.report(dataBuilder);
    }

    public void xh() {
        PBStringField pBStringField;
        FeedCloudMeta$StFeed zh5 = zh();
        if (zh5 == null) {
            return;
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        PBStringField pBStringField2 = zh5.f398449id;
        if (pBStringField2 != null) {
            buildElementParams.put("xsj_feed_id", pBStringField2.get());
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser = zh5.poster;
        if (feedCloudMeta$StUser != null && (pBStringField = feedCloudMeta$StUser.f398463id) != null) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, pBStringField.get());
        }
        buildElementParams.put("dt_pgid", getDaTongPageId());
        buildElementParams.put("dt_eid", QCircleDaTongConstant.ElementId.EM_XSJ_QUIT_TIP_TOAST);
        VideoReport.reportEvent("dt_imp", buildElementParams);
        QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder(ua0.c.c(zh5));
        dataBuilder.setActionType(1500).setSubActionType(1).setToUin(zh5.poster.f398463id.get()).setPosition(Ah()).setActTime(System.currentTimeMillis()).setRequestId(ba.d(zh5)).setSealTransfer(zh5.recomInfo.recomTrace.get()).setPageId(getPageId()).setFirstFeedId(w20.a.j().h());
        QCircleLpReportDc05507.report(dataBuilder);
    }

    protected int yh() {
        int i3;
        QCircleSkinHelper qCircleSkinHelper = QCircleSkinHelper.getInstance();
        if (Th()) {
            i3 = R.color.qvideo_skin_color_bg_backplate;
        } else {
            i3 = R.color.cje;
        }
        return qCircleSkinHelper.getColor(i3);
    }

    public FeedCloudMeta$StFeed zh() {
        Part part = getPartManager().getPart(QFSLayerTabPart.class.getName());
        if (!(part instanceof QFSLayerTabPart)) {
            return null;
        }
        return ((QFSLayerTabPart) part).V9();
    }

    public void Lh() {
    }

    public void Xh() {
    }

    public void ai() {
    }

    public void ci() {
    }

    public void oi() {
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    protected void pushPageScene() {
    }

    public void rh() {
    }

    public void th() {
    }

    public void vh() {
    }
}
