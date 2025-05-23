package com.tencent.biz.qqcircle.immersive.layer.biz;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.qqcircle.bizparts.QCircleLightInteractListPart;
import com.tencent.biz.qqcircle.events.QCircleShowPushBoxShareEvent;
import com.tencent.biz.qqcircle.immersive.adapter.m;
import com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseMiddleListPart;
import com.tencent.biz.qqcircle.immersive.utils.au;
import com.tencent.biz.qqcircle.immersive.utils.o;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer;
import com.tencent.biz.qqcircle.utils.cq;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.qcircle.api.event.QFSApertureExposeFeedEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class f extends QFSLayerBaseMiddleListPart {

    /* renamed from: f, reason: collision with root package name */
    private static final CharSequence f86532f = "wechat";

    /* renamed from: d, reason: collision with root package name */
    private QCircleLayerBean f86533d;

    /* renamed from: e, reason: collision with root package name */
    private QFSLayerDefaultViewModel f86534e;

    public f(QCircleLayerBean qCircleLayerBean) {
        this.f86533d = qCircleLayerBean;
    }

    private void N9() {
        m mVar = this.mLayerPageAdapter;
        if (mVar != null && mVar.getDataList() != null) {
            for (e30.b bVar : this.mLayerPageAdapter.getDataList()) {
                if (bVar.g() != null && bVar.g().type.get() == 2) {
                    w20.a.j().t(bVar.g().f398449id.get(), 0);
                }
            }
        }
    }

    private int O9() {
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(getContext());
        if (qCircleInitBean != null && qCircleInitBean.getExtraTypeInfo() != null) {
            int i3 = qCircleInitBean.getExtraTypeInfo().sourceType;
            QLog.d(getTAG(), 1, "getPanelSource  source = " + i3);
            if (i3 == 60) {
                return 5;
            }
            if (i3 == 1002) {
                return 10;
            }
        }
        return 0;
    }

    private QCircleShareInfo P9(QCircleInitBean.QCircleActionBean qCircleActionBean, e30.b bVar) {
        FeedCloudMeta$StFeed g16 = bVar.g();
        if (qCircleActionBean.mIsShowDetailSharePanel) {
            QCircleShareInfo c16 = au.c(g16);
            QCircleExtraTypeInfo qCircleExtraTypeInfo = new QCircleExtraTypeInfo();
            qCircleExtraTypeInfo.mFeed = g16;
            qCircleExtraTypeInfo.pageType = getPageId();
            c16.extraTypeInfo = qCircleExtraTypeInfo;
            c16.type = 0;
            c16.feed = qCircleExtraTypeInfo.mFeed;
            c16.feedBlockData = bVar;
            c16.source = 4;
            c16.shareStyleType = 0;
            return c16;
        }
        QCircleShareInfo qCircleShareInfo = new QCircleShareInfo();
        QCircleExtraTypeInfo qCircleExtraTypeInfo2 = new QCircleExtraTypeInfo();
        qCircleExtraTypeInfo2.mFeed = bVar.g();
        qCircleExtraTypeInfo2.pageType = getPageId();
        qCircleShareInfo.extraTypeInfo = qCircleExtraTypeInfo2;
        qCircleShareInfo.type = 0;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = qCircleExtraTypeInfo2.mFeed;
        qCircleShareInfo.feed = feedCloudMeta$StFeed;
        qCircleShareInfo.feedBlockData = bVar;
        qCircleShareInfo.isShowDisLike = false;
        qCircleShareInfo.isShowDelete = false;
        qCircleShareInfo.isShowDownLoad = false;
        qCircleShareInfo.isShowReport = false;
        qCircleShareInfo.isShowBarrageSwitch = false;
        qCircleShareInfo.isShareBottomBarrageSwitch = o.e(feedCloudMeta$StFeed);
        qCircleShareInfo.isShowDeletePush = false;
        qCircleShareInfo.source = 4;
        qCircleShareInfo.shareStyleType = 1;
        return qCircleShareInfo;
    }

    private void Q9(UIStateData<List<e30.b>> uIStateData) {
        QCircleInitBean.QCircleActionBean actionBean;
        final String str;
        QCircleLayerBean qCircleLayerBean = this.f86533d;
        if (qCircleLayerBean != null && (actionBean = qCircleLayerBean.getActionBean()) != null && W9(actionBean) && uIStateData != null && uIStateData.getData() != null && uIStateData.getData().size() > uIStateData.getPos() && uIStateData.getState() == 3 && !uIStateData.getIsLoadMore()) {
            e30.b bVar = uIStateData.getData().get(uIStateData.getPos());
            final QFSCommentInfo qFSCommentInfo = new QFSCommentInfo();
            qFSCommentInfo.mFeed = bVar.g();
            qFSCommentInfo.mFeedBlockData = bVar;
            qFSCommentInfo.mCmtPanelSource = O9();
            QFSCommentInfo.ActionBean actionBean2 = new QFSCommentInfo.ActionBean();
            actionBean2.mShowCommentPanelTabIndex = actionBean.mShowCommentPanelTabIndex;
            actionBean2.mCommentInitBeanActionBean = actionBean;
            qFSCommentInfo.mActionBean = actionBean2;
            if (actionBean.mOnlyShowCommentKeyboard) {
                str = "comment_input_window_show";
            } else {
                str = "comment_panel_show";
            }
            getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.X9(str, qFSCommentInfo);
                }
            }, uq3.c.I0());
        }
    }

    private void R9(UIStateData<List<e30.b>> uIStateData) {
        List<e30.b> data;
        if (this.f86533d == null || uIStateData == null || uIStateData.getData() == null || uIStateData.getData().size() <= uIStateData.getPos() || uIStateData.getState() != 3 || uIStateData.getIsLoadMore() || (data = uIStateData.getData()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(data);
        int pos = uIStateData.getPos();
        if (arrayList.size() <= pos) {
            return;
        }
        e30.b bVar = (e30.b) arrayList.get(pos);
        QCircleInitBean.QCircleActionBean actionBean = this.f86533d.getActionBean();
        if (actionBean == null) {
            return;
        }
        if (actionBean.mShowTopSharePanel) {
            broadcastMessage("share_action_show_push_box_share_sheet", new QCircleShowPushBoxShareEvent(bVar.g()));
        }
        if (actionBean.mShowSharePanel) {
            broadcastMessage("share_action_show_share_sheet", P9(actionBean, bVar));
        }
        S9(uIStateData, actionBean, bVar, pos);
    }

    private void S9(UIStateData<List<e30.b>> uIStateData, QCircleInitBean.QCircleActionBean qCircleActionBean, e30.b bVar, int i3) {
        if (bVar != null && qCircleActionBean != null && qCircleActionBean.mShowLightInteractListPanel && qCircleActionBean.mLightInteractListRequestType != 0 && uIStateData != null && uIStateData.getData() != null && uIStateData.getData().size() > uIStateData.getPos() && uIStateData.getState() == 3 && !uIStateData.getIsLoadMore()) {
            QCircleLightInteractListPart.g gVar = new QCircleLightInteractListPart.g();
            gVar.f82701a = bVar;
            gVar.f82702b = bVar.g();
            gVar.f82704d = i3;
            gVar.f82705e = qCircleActionBean.mLightInteractListRequestType;
            broadcastMessage("light_interact_list_show", gVar);
        }
    }

    private IDataDisplaySurface<e30.b> U9() {
        QFSLayerDefaultViewModel qFSLayerDefaultViewModel = (QFSLayerDefaultViewModel) getViewModel(QFSLayerDefaultViewModel.class);
        this.f86534e = qFSLayerDefaultViewModel;
        if (qFSLayerDefaultViewModel == null) {
            return null;
        }
        QCircleReportBean reportBean = getReportBean();
        if (reportBean != null) {
            this.f86534e.p3(reportBean.getDtPageId());
        }
        if (getInitBean() != null && z20.h.b()) {
            this.f86534e.e3(getInitBean());
        }
        this.f86534e.j().observe(getHostFragment(), new Observer() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                f.this.Z9((UIStateData) obj);
            }
        });
        I9();
        return this.f86534e;
    }

    private boolean V9() {
        QCircleLayerBean qCircleLayerBean = this.f86533d;
        if (qCircleLayerBean != null && qCircleLayerBean.getSchemeAttrs() != null) {
            return QCircleDaTongConstant.PageId.PG_XSJ_AVATAR_APERTURE_PAGE.equals(this.f86533d.getSchemeAttrs().get("xsj_custom_pgid"));
        }
        return false;
    }

    private boolean W9(@NonNull QCircleInitBean.QCircleActionBean qCircleActionBean) {
        if (!qCircleActionBean.mShowCommentPanel && !qCircleActionBean.mOnlyShowCommentKeyboard) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X9(String str, QFSCommentInfo qFSCommentInfo) {
        broadcastMessage(str, qFSCommentInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean Y9() {
        broadcastMessage("layer_notify_part_action_down", null);
        return false;
    }

    private void aa() {
        QCircleLayerBean qCircleLayerBean = this.f86533d;
        if (qCircleLayerBean != null && qCircleLayerBean.getSchemeAttrs() != null && TextUtils.equals(this.f86533d.getSchemeAttrs().get("xsj_main_entrance"), f86532f)) {
            this.f86534e.W1();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseMiddleListPart
    protected com.tencent.biz.qqcircle.immersive.layer.base.e H9() {
        return this.f86534e;
    }

    protected void T9() {
        this.mLayerPageContainer.setActionDownEventListener(new QFSPageTurnContainer.g() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.c
            @Override // com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer.g
            public final boolean a() {
                boolean Y9;
                Y9 = f.this.Y9();
                return Y9;
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, t40.a
    public QCircleInitBean getInitBean() {
        return this.f86533d;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSLayerSchemaDefaultPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public Object getMessage(String str, Object obj) {
        if (str.equals("qfs_get_feed_by_pos")) {
            if ((obj instanceof Integer) && this.f86534e != null) {
                int intValue = ((Integer) obj).intValue();
                UIStateData<List<e30.b>> value = this.f86534e.j().getValue();
                if (value != null && !RFSafeListUtils.isEmpty(value.getData())) {
                    if (intValue >= value.getData().size()) {
                        return super.getMessage(str, obj);
                    }
                    return value.getData().get(intValue);
                }
                return super.getMessage(str, obj);
            }
            return super.getMessage(str, obj);
        }
        return super.getMessage(str, obj);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    protected IDataDisplaySurface<e30.b> getViewModelSurface() {
        return U9();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    protected void handleEmptyState() {
        hideLoadingView();
        if (isEmptyContent() && this.mFaultHintView != null) {
            com.tencent.biz.qqcircle.helpers.e.f84616a.c(getInitBean(), null);
            this.mFaultHintView.z0(uq3.c.w3(), false, 16);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    protected void handleErrorState(UIStateData<List<e30.b>> uIStateData, long j3, String str) {
        super.handleErrorState(uIStateData, j3, str);
        com.tencent.biz.qqcircle.helpers.e.f84616a.c(getInitBean(), null);
        if (V9() && this.f86533d != null) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSApertureExposeFeedEvent(this.f86533d.getFeedId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseMiddleListPart, com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    /* renamed from: handleFeedRsp, reason: merged with bridge method [inline-methods] */
    public void Z9(UIStateData<List<e30.b>> uIStateData) {
        QCircleInitBean initBean = getInitBean();
        if (initBean != null && TextUtils.equals(initBean.getLayerBizAssemblerType(), "biz_qzone_qq_video_layer") && cq.f92752a.t(uIStateData)) {
            QLog.d(getTAG(), 1, "handleFeedRsp feed not exist");
            super.broadcastMessage("MSG_FEED_NOT_EXIST", null);
        } else {
            super.Z9(uIStateData);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    protected void handleSuccessState(UIStateData<List<e30.b>> uIStateData, boolean z16) {
        super.handleSuccessState(uIStateData, z16);
        Q9(uIStateData);
        R9(uIStateData);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, t40.a
    public boolean isContainerOnScreen() {
        if (getHostFragment() != null && getHostFragment().isResumed()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseMiddleListPart, com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        T9();
        E9();
        requestData(true, false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        N9();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    protected void requestData(boolean z16, boolean z17) {
        if (this.f86534e != null && this.f86533d != null) {
            QLog.d(getTAG(), 1, "requestData  isLoadMore: " + z16 + ", enableProtocolCache: " + z17 + ", attachInfo: " + this.f86534e.P1().getStringAttachInfo());
            aa();
            QFSLayerDefaultViewModel qFSLayerDefaultViewModel = this.f86534e;
            QCircleLayerBean qCircleLayerBean = this.f86533d;
            qFSLayerDefaultViewModel.o3(qCircleLayerBean, qCircleLayerBean.isGetFeedList(), z16 ^ true);
        }
    }
}
