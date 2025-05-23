package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSChangePgidEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSFeedPositionChangeEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSPageSelectEvent;
import com.tencent.biz.qqcircle.immersive.utils.QFSPersonalDraftUtil;
import com.tencent.biz.qqcircle.immersive.viewmodel.wink.QFSPublishFeedViewModel;
import com.tencent.biz.qqcircle.immersive.viewmodel.wink.QFSTopPopBannerViewModel;
import com.tencent.biz.qqcircle.lazyload.QFSLazyExecuteEvent;
import com.tencent.biz.qqcircle.publish.plusentry.composer.bubble.PlusEntryBubbleComposer;
import com.tencent.biz.qqcircle.publish.plusentry.composer.dailypag.PlusEntryDailyPagComposer;
import com.tencent.biz.qqcircle.publish.plusentry.composer.operationpos.BasePlusEntryOperationPosComposer;
import com.tencent.biz.qqcircle.publish.plusentry.helper.PlusEntryExp;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.qqcircle.widgets.dialog.QCircleLoadingDialog;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.auto.engine.loader.ASEngineUtils;
import com.tencent.mobileqq.qcircle.api.event.QFSSelectTabEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.publish.api.IWinkDraft;
import com.tencent.mobileqq.winkpublish.model.DraftBean;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ep extends u implements SimpleEventReceiver, la0.a, View.OnClickListener {
    private BasePlusEntryOperationPosComposer C;
    private PlusEntryBubbleComposer D;
    private QCircleLoadingDialog E;
    private com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> F;
    private la0.b G;
    private int H;
    private DraftBean I;
    private boolean J;
    private volatile boolean K;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f88061d;

    /* renamed from: e, reason: collision with root package name */
    private QFSPublishFeedViewModel f88062e;

    /* renamed from: f, reason: collision with root package name */
    private FrameLayout f88063f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.biz.qqcircle.publish.plusentry.composer.b f88064h;

    /* renamed from: i, reason: collision with root package name */
    private na0.a f88065i;

    /* renamed from: m, reason: collision with root package name */
    private PlusEntryDailyPagComposer f88066m;

    private void H9(final View view) {
        QLog.d("PlusEntry-QFSPublishFeedPart", 1, "onclick... hasResult:" + this.K + " hasCheck:" + this.J + " lastDraft:" + this.I);
        if (this.K) {
            DraftBean draftBean = this.I;
            if (draftBean != null && QFSTopPopBannerViewModel.a2(draftBean, getContext())) {
                aa(view, new DraftBean(this.I));
                this.I = null;
                return;
            } else {
                this.G.onClick(view);
                return;
            }
        }
        if (!this.J) {
            this.J = true;
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.eh
                @Override // java.lang.Runnable
                public final void run() {
                    ep.this.ca(view);
                }
            });
        } else {
            this.G.onClick(view);
        }
    }

    private void I9(String str, String str2) {
        QLog.d("PlusEntry-QFSPublishFeedPart", 2, "dialogDaTongReport... evenId:" + str + " eid:" + str2 + " pgId:" + getReportBean().getDtPageId());
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", str2);
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        buildElementParams.put("xsj_custom_pgid", getReportBean().getDtPageId());
        VideoReport.reportEvent(str, null, buildElementParams);
    }

    private void J9() {
        QCircleLoadingDialog qCircleLoadingDialog = this.E;
        if (qCircleLoadingDialog != null && qCircleLoadingDialog.isShowing()) {
            this.E.dismiss();
        }
    }

    private View K9(boolean z16) {
        View partRootView = getPartRootView();
        if (partRootView == null) {
            return null;
        }
        ViewStub viewStub = (ViewStub) partRootView.findViewById(R.id.f502424v);
        if (z16 && viewStub != null) {
            return viewStub.inflate();
        }
        return partRootView.findViewById(R.id.f502524w);
    }

    private void L9() {
        FrameLayout frameLayout = this.f88063f;
        if (frameLayout != null) {
            frameLayout.performClick();
        }
    }

    private void M9(ASEngineTabStatusEvent aSEngineTabStatusEvent) {
        QLog.d("PlusEntry-QFSPublishFeedPart", 1, "handleASEngineTabStatusEvent, isSelected: " + aSEngineTabStatusEvent.isSelected());
        if (ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE.equals(aSEngineTabStatusEvent.getBusinessKey()) && !aSEngineTabStatusEvent.isSelected()) {
            sa();
        }
    }

    private void N9(Object obj) {
        if (!(obj instanceof Boolean)) {
            return;
        }
        Boolean bool = (Boolean) obj;
        QLog.d("PlusEntry-QFSPublishFeedPart", 1, "handleFolderTabClicked, isHomeTabClick: " + bool);
        QFSPublishFeedViewModel qFSPublishFeedViewModel = this.f88062e;
        if (qFSPublishFeedViewModel != null) {
            qFSPublishFeedViewModel.G2(bool.booleanValue());
        }
        if (bool.booleanValue()) {
            la();
        }
    }

    private void O9(@NonNull QFSLazyExecuteEvent qFSLazyExecuteEvent) {
        if (qFSLazyExecuteEvent.getNotifyId() == 2) {
            qFSLazyExecuteEvent.injectExecution(new QFSLazyExecuteEvent.a() { // from class: com.tencent.biz.qqcircle.immersive.part.ei
                @Override // com.tencent.biz.qqcircle.lazyload.QFSLazyExecuteEvent.a
                public final void execute() {
                    ep.this.da();
                }
            });
        }
    }

    private void P9(Object obj) {
        QFSPublishFeedViewModel qFSPublishFeedViewModel = this.f88062e;
        if (qFSPublishFeedViewModel != null) {
            qFSPublishFeedViewModel.Q2(obj);
        }
    }

    private void Q9(@NonNull QCirclePanelStateEvent qCirclePanelStateEvent) {
        QLog.d("PlusEntry-QFSPublishFeedPart", 1, "[handlePanelStateEvent] event.getPanelType() = " + qCirclePanelStateEvent.getPanelType() + ", event.isShowing() = " + qCirclePanelStateEvent.isShowing());
        if (qCirclePanelStateEvent.isShowing()) {
            W9();
        }
    }

    private void R9() {
        QLog.d("PlusEntry-QFSPublishFeedPart", 1, "handleQCirclePublishResult ");
        QCircleReportHelper.getInstance().recordPageEndShow(36, true);
    }

    private void S9(QFSSelectTabEvent qFSSelectTabEvent) {
        QFSPublishFeedViewModel qFSPublishFeedViewModel = this.f88062e;
        if (qFSPublishFeedViewModel != null) {
            qFSPublishFeedViewModel.C2(qFSSelectTabEvent.useDarkTheme());
        }
    }

    private void T9(@NonNull QFSFeedPositionChangeEvent qFSFeedPositionChangeEvent) {
        com.tencent.biz.qqcircle.wink.e.f93946a.x(qFSFeedPositionChangeEvent);
        this.f88062e.A2(qFSFeedPositionChangeEvent);
    }

    private void U9(QFSPageSelectEvent qFSPageSelectEvent) {
        if (qFSPageSelectEvent == null) {
            return;
        }
        QLog.d("PlusEntry-QFSPublishFeedPart", 1, "handlerPageSelectEvent: tabType: " + qFSPageSelectEvent.mSelectTabType);
        com.tencent.biz.qqcircle.wink.e.f93946a.h(getPageId(), this.f88062e.getCom.tencent.mobileqq.profilecard.api.IProfileCardConst.KEY_FROM_TYPE java.lang.String());
        this.H = qFSPageSelectEvent.mSelectTabType;
    }

    private void V9() {
        X9();
        W9();
        sa();
    }

    private void W9() {
        QLog.d("PlusEntry-QFSPublishFeedPart", 1, "hideNewUserTip ");
        PlusEntryBubbleComposer plusEntryBubbleComposer = this.D;
        if (plusEntryBubbleComposer != null) {
            plusEntryBubbleComposer.s();
        }
    }

    private void X9() {
        QLog.d("PlusEntry-QFSPublishFeedPart", 1, "hidePublishTipIfNeed ");
        PlusEntryBubbleComposer plusEntryBubbleComposer = this.D;
        if (plusEntryBubbleComposer != null) {
            plusEntryBubbleComposer.t();
        }
    }

    private void Y9() {
        int i3;
        View partRootView = getPartRootView();
        if (partRootView == null) {
            QLog.e("PlusEntry-QFSPublishFeedPart", 1, "initPlusEntryLayout, rootView is null");
            return;
        }
        if (this.f88061d) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        View b16 = com.tencent.biz.qqcircle.publish.plusentry.helper.a.b();
        if (this.f88061d && com.tencent.biz.qqcircle.publish.plusentry.helper.a.c() && b16 != null) {
            qa(false);
            ua(partRootView, 12.0f);
            i3 = 3;
        } else {
            b16 = K9(true);
            qa(true);
            ua(partRootView, 48.0f);
        }
        QLog.d("PlusEntry-QFSPublishFeedPart", 1, "initPlusEntryLayout, uiType: " + i3 + ", mIsInTabUIType:" + this.f88061d);
        QFSPublishFeedViewModel qFSPublishFeedViewModel = this.f88062e;
        if (qFSPublishFeedViewModel != null) {
            qFSPublishFeedViewModel.q2(i3);
        }
        com.tencent.biz.qqcircle.wink.e.f93946a.A(i3);
        Z9(b16);
    }

    private void Z9(View view) {
        if (view == null) {
            QLog.e("PlusEntry-QFSPublishFeedPart", 1, "initViews, containerView is null");
            return;
        }
        com.tencent.biz.qqcircle.publish.plusentry.composer.b bVar = this.f88064h;
        if (bVar == null) {
            this.f88064h = new com.tencent.biz.qqcircle.publish.plusentry.composer.b(getPartHost(), view);
        } else {
            bVar.j(view);
        }
        PlusEntryExp a16 = com.tencent.biz.qqcircle.publish.plusentry.helper.a.a();
        QLog.d("PlusEntry-QFSPublishFeedPart", 1, "initViews, exp: " + a16);
        this.f88065i = this.f88064h.c(a16);
        this.f88066m = this.f88064h.b();
        this.C = this.f88064h.d(a16);
        this.D = this.f88064h.a();
        this.G = new la0.b("PlusEntry-QFSPublishFeedPart", getContext(), this);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.f502524w);
        this.f88063f = frameLayout;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ba(View view) {
        this.G.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ca(final View view) {
        Runnable runnable;
        final DraftBean lastDraftBeanSync = ((IWinkDraft) QRoute.api(IWinkDraft.class)).getLastDraftBeanSync(HostDataTransUtils.getLongAccountUin());
        if (lastDraftBeanSync != null && QFSTopPopBannerViewModel.a2(lastDraftBeanSync, getContext())) {
            runnable = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.em
                @Override // java.lang.Runnable
                public final void run() {
                    ep.this.aa(view, lastDraftBeanSync);
                }
            };
        } else {
            runnable = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.en
                @Override // java.lang.Runnable
                public final void run() {
                    ep.this.ba(view);
                }
            };
        }
        runOnActivityUiThread(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void da() {
        try {
            if (QLog.isDevelopLevel()) {
                QLog.d("[Performance2]PlusEntry-QFSPublishFeedPart", 1, "callLazyExecute preloadCameraRes");
            }
            pa();
        } catch (Exception e16) {
            QLog.e("PlusEntry-QFSPublishFeedPart", 1, "callLazyExecute failed, exception:", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ea() {
        DraftBean lastDraftBeanSync = ((IWinkDraft) QRoute.api(IWinkDraft.class)).getLastDraftBeanSync(HostDataTransUtils.getLongAccountUin());
        if (lastDraftBeanSync != null && lastDraftBeanSync.getUploadStatus() == 5) {
            this.I = lastDraftBeanSync;
            this.K = true;
        } else {
            this.I = null;
            this.K = false;
        }
        QLog.d("PlusEntry-QFSPublishFeedPart", 1, "loadDraft... lastDraft:" + this.I);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ga(Boolean bool) {
        QLog.d("PlusEntry-QFSPublishFeedPart", 1, "isShowPlusEntryObservable data changed, isShowQTab: " + bool);
        Y9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ha(DraftBean draftBean, DialogInterface dialogInterface, int i3) {
        QLog.d("PlusEntry-QFSPublishFeedPart", 1, "showNewKillProcessDialog, positive btn click, dialog: " + dialogInterface);
        try {
            new QFSPersonalDraftUtil().e(QCirclePublishQualityReporter.getTraceId(), getActivity(), draftBean, 4, 0);
            I9("ev_xsj_camera_action", QCircleDaTongConstant.ElementId.EM_XSJ_DRAFT_PANEL_CONTINUE_BUTTON);
        } catch (Exception e16) {
            QLog.e("PlusEntry-QFSPublishFeedPart", 1, "showNewKillProcessDialog, positive click error ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ia(DraftBean draftBean, View view, DialogInterface dialogInterface, int i3) {
        QLog.d("PlusEntry-QFSPublishFeedPart", 1, "showNewKillProcessDialog, negative btn click, dialog: " + dialogInterface);
        ta(draftBean, R.string.f183513jd);
        I9("ev_xsj_camera_action", QCircleDaTongConstant.ElementId.EM_XSJ_DRAFT_PANEL_DRAFT_BUTTON);
        this.G.onClick(view);
    }

    private void init() {
        Y9();
        ma();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ja(DraftBean draftBean, DialogInterface dialogInterface) {
        QLog.d("PlusEntry-QFSPublishFeedPart", 1, "showNewKillProcessDialog, dialog cancelled, dialog: " + dialogInterface);
        ta(draftBean, R.string.f183513jd);
        I9("ev_xsj_camera_action", QCircleDaTongConstant.ElementId.EM_XSJ_DRAFT_PANEL_CANCEL_BUTTON);
    }

    private void la() {
        if (!b80.e.a()) {
            return;
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.eg
            @Override // java.lang.Runnable
            public final void run() {
                ep.this.ea();
            }
        });
    }

    private void ma() {
        na();
    }

    private void na() {
        LifecycleOwner lifecycleOwner;
        if (getPartHost() != null) {
            lifecycleOwner = getPartHost().getLifecycleOwner();
        } else {
            lifecycleOwner = null;
        }
        if (lifecycleOwner == null) {
            QLog.w("PlusEntry-QFSPublishFeedPart", 1, "observerShowQTab, lifecycleOwner is null ");
        } else {
            com.tencent.biz.qqcircle.publish.plusentry.helper.a.d().observe(lifecycleOwner, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.part.eo
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ep.this.ga((Boolean) obj);
                }
            });
        }
    }

    private void oa() {
        int i3;
        QLog.d("PlusEntry-QFSPublishFeedPart", 1, "preRequestPlusMenuData ");
        if (getReportBean() != null) {
            i3 = getReportBean().getPageId();
        } else {
            i3 = 0;
        }
        ra0.c.f430999a.d(i3);
    }

    private void pa() {
        QLog.d("[Performance2]PlusEntry-QFSPublishFeedPart", 1, "preloadCameraRes:");
        long currentTimeMillis = System.currentTimeMillis();
        QCircleHostLauncher.preCameraEssentialRes();
        if (QLog.isDevelopLevel()) {
            QLog.d("[Performance2]PlusEntry-QFSPublishFeedPart", 1, "preCameraEssentialRes cost:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private void qa(boolean z16) {
        int i3;
        View K9 = K9(z16);
        if (K9 != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            K9.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ra, reason: merged with bridge method [inline-methods] */
    public void aa(final View view, final DraftBean draftBean) {
        boolean z16;
        Context hostContext = ASEngineUtils.getHostContext(getContext());
        if (hostContext == null) {
            QLog.w("PlusEntry-QFSPublishFeedPart", 1, "context == null");
            return;
        }
        QCircleCustomDialog W = QCircleCustomDialog.W(hostContext, "\u7ee7\u7eed\u7f16\u8f91\u672a\u5b8c\u6210\u7684\u4f5c\u54c1\u5417\uff1f", draftBean.getCoverUrl(), R.string.f223876he, R.string.f181943f5, new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.ej
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ep.this.ha(draftBean, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.ek
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ep.this.ia(draftBean, view, dialogInterface, i3);
            }
        });
        W.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.biz.qqcircle.immersive.part.el
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                ep.this.ja(draftBean, dialogInterface);
            }
        });
        if (getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("PlusEntry-QFSPublishFeedPart", 1, "showNewKillProcessDialog, mDialog: " + W + ", activityActive: " + z16);
        if (z16) {
            W.show();
            I9("ev_xsj_camera_action", QCircleDaTongConstant.ElementId.EM_XSJ_REEDIT_HINT_PANEL);
            QFSTopPopBannerViewModel.g2(draftBean, getContext());
        }
    }

    private void sa() {
        if (this.f88066m != null) {
            QLog.d("PlusEntry-QFSPublishFeedPart", 1, "stopDailyPagIfNeed, do stop ");
            this.f88066m.x();
        }
    }

    private void ta(DraftBean draftBean, int i3) {
        QQToast.makeText(getContext(), i3, 1).show();
        ((IWinkDraft) QRoute.api(IWinkDraft.class)).updateUploadStatus(HostDataTransUtils.getLongAccountUin(), draftBean.getMissionId(), 0);
    }

    private void ua(@NonNull View view, float f16) {
        View findViewById = view.findViewById(R.id.f46591v0);
        if (findViewById == null && (findViewById = view.findViewById(R.id.f53712d9)) == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById.getLayoutParams();
        int dpToPx = ImmersiveUtils.dpToPx(f16);
        marginLayoutParams.rightMargin = dpToPx;
        marginLayoutParams.setMarginEnd(dpToPx);
        findViewById.setLayoutParams(marginLayoutParams);
    }

    @Override // la0.a
    public int G() {
        QFSPublishFeedViewModel qFSPublishFeedViewModel = this.f88062e;
        if (qFSPublishFeedViewModel != null) {
            return qFSPublishFeedViewModel.getCom.tencent.mobileqq.profilecard.api.IProfileCardConst.KEY_FROM_TYPE java.lang.String();
        }
        return 0;
    }

    @Override // la0.a
    @NonNull
    public String L8() {
        QFSPublishFeedViewModel qFSPublishFeedViewModel = this.f88062e;
        if (qFSPublishFeedViewModel != null) {
            if (qFSPublishFeedViewModel.x2()) {
                return WinkDaTongReportConstant.ElementParamValue.XSJ_PRESET_VIDEO_OPT_IN_RIGHT_UP;
            }
            return "bottom";
        }
        return "";
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSPageSelectEvent.class);
        arrayList.add(QFSFeedPositionChangeEvent.class);
        arrayList.add(QFSLazyExecuteEvent.class);
        arrayList.add(QFSChangePgidEvent.class);
        arrayList.add(ASEngineTabStatusEvent.class);
        arrayList.add(QCirclePanelStateEvent.class);
        arrayList.add(QFSSelectTabEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "PlusEntry-QFSPublishFeedPart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, la0.a
    @NonNull
    public QCircleReportBean getReportBean() {
        com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> aVar = this.F;
        if (aVar != null) {
            return aVar.getReportBean();
        }
        return super.getReportBean();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if (TextUtils.equals(str, "tab_changed_new_layer")) {
            P9(obj);
            return;
        }
        if (TextUtils.equals(str, "publish_on_click")) {
            L9();
            return;
        }
        if (TextUtils.equals(str, "comment_panel_show")) {
            V9();
        } else if (TextUtils.equals(str, "publish_entrance_dialog_close")) {
            J9();
        } else if (TextUtils.equals(str, "qfs_set_folder_viewpage_scrollable")) {
            N9(obj);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return com.tencent.biz.qqcircle.manager.i.a("qfs_publish_entrance_show");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (256 == i3) {
            R9();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f502524w && !fb0.a.a("PlusEntry-QFSPublishFeedPart")) {
            if (b80.e.a()) {
                H9(view);
            } else {
                this.G.onClick(view);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u
    protected void onEnableSkinChange(boolean z16) {
        QLog.d("PlusEntry-QFSPublishFeedPart", 1, "onEnableSkinChange, enableSkin: " + z16);
        sa();
        QFSPublishFeedViewModel qFSPublishFeedViewModel = this.f88062e;
        if (qFSPublishFeedViewModel != null) {
            qFSPublishFeedViewModel.H2(z16);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        init();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
        oa();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        FrameLayout frameLayout = this.f88063f;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(null);
            QLog.d("PlusEntry-QFSPublishFeedPart", 1, "onPartDestroy, setOnClickListener null ");
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        QLog.d("PlusEntry-QFSPublishFeedPart", 1, "onPartPause ");
        V9();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        QLog.d("PlusEntry-QFSPublishFeedPart", 1, "onPartResume ");
        la();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        super.onPartStop(activity);
        J9();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSPageSelectEvent) {
            U9((QFSPageSelectEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSFeedPositionChangeEvent) {
            T9((QFSFeedPositionChangeEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSLazyExecuteEvent) {
            O9((QFSLazyExecuteEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSChangePgidEvent) {
            String dtPgId = ((QFSChangePgidEvent) simpleBaseEvent).getDtPgId();
            com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> aVar = this.F;
            if (aVar != null && aVar.getReportBean() != null) {
                this.F.getReportBean().setDtPageId(dtPgId);
            }
            com.tencent.biz.qqcircle.wink.e.f93946a.y(dtPgId);
            return;
        }
        if (simpleBaseEvent instanceof ASEngineTabStatusEvent) {
            M9((ASEngineTabStatusEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCirclePanelStateEvent) {
            Q9((QCirclePanelStateEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSSelectTabEvent) {
            S9((QFSSelectTabEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void setEnvironment(IPartHost iPartHost, View view, PartManager partManager) {
        super.setEnvironment(iPartHost, view, partManager);
        QFSPublishFeedViewModel qFSPublishFeedViewModel = (QFSPublishFeedViewModel) getViewModel(QFSPublishFeedViewModel.class);
        this.f88062e = qFSPublishFeedViewModel;
        qFSPublishFeedViewModel.r2(getActivity());
    }

    @Override // la0.a
    public boolean w8(@Nullable View view) {
        if (this.f88062e.N2(getContext())) {
            QLog.i("PlusEntry-QFSPublishFeedPart", 1, "onInterceptClick, mViewModel tryInterceptJump2Publish ");
            return true;
        }
        BasePlusEntryOperationPosComposer basePlusEntryOperationPosComposer = this.C;
        if (basePlusEntryOperationPosComposer != null && basePlusEntryOperationPosComposer.o()) {
            QLog.i("PlusEntry-QFSPublishFeedPart", 1, "onInterceptClick, mOperationManager onInterceptClick ");
            return true;
        }
        return false;
    }
}
