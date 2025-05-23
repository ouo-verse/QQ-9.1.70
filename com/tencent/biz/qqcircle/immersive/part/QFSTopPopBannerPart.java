package com.tencent.biz.qqcircle.immersive.part;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import b80.d;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.events.QCircleShowSaveDraftDialogEvent;
import com.tencent.biz.qqcircle.immersive.utils.QFSPersonalDraftUtil;
import com.tencent.biz.qqcircle.immersive.viewmodel.wink.QFSTopPopBannerViewModel;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.qqcircle.widgets.QCirclePublishCallbackHelper;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.order.IOrderElement;
import com.tencent.biz.richframework.order.RFWOrderElementManager;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.loader.ASEngineUtils;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.publish.api.IWinkDraft;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.model.DraftBean;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qcircle.cooperation.config.AccountChangeEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.studymode.api.IStudyModeApi;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.tav.core.ExportErrorStatus;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import e40.QFSTopPopBannerData;
import java.util.ArrayList;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes4.dex */
public class QFSTopPopBannerPart extends u implements View.OnClickListener, SimpleEventReceiver, IOrderElement {
    private QFSTopPopBannerViewModel C;
    private com.tencent.biz.qqcircle.widgets.a E;
    private boolean H;
    private QCircleCustomDialog I;
    private b80.d J;
    private DraftBean K;

    /* renamed from: d, reason: collision with root package name */
    private View f87604d;

    /* renamed from: e, reason: collision with root package name */
    private View f87605e;

    /* renamed from: f, reason: collision with root package name */
    private RoundCornerImageView f87606f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f87607h;

    /* renamed from: i, reason: collision with root package name */
    private Button f87608i;

    /* renamed from: m, reason: collision with root package name */
    private Button f87609m;
    private int D = -1;
    private boolean F = false;
    private final Runnable G = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSTopPopBannerPart.1
        @Override // java.lang.Runnable
        public void run() {
            QFSTopPopBannerPart.this.ca();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements DialogInterface.OnCancelListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DraftBean f87618d;

        a(DraftBean draftBean) {
            this.f87618d = draftBean;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            QLog.d("QFSTopPopBannerPart", 1, "showOldKillProcessDialog, dialog cancelled, dialog: " + dialogInterface);
            QFSTopPopBannerPart.this.Da(this.f87618d);
            QCircleToast.i(QCircleToast.f91644d, R.string.f183503jc, 1);
            QFSTopPopBannerPart.this.S9("ev_xsj_camera_action", QCircleDaTongConstant.ElementId.EM_XSJ_DRAFT_PANEL_CANCEL_BUTTON);
        }
    }

    /* loaded from: classes4.dex */
    class c implements Observer<DraftBean> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(DraftBean draftBean) {
            QLog.d("QFSTopPopBannerPart", 1, "getShowDialogLiveData onChanged, draftBean: " + draftBean);
            if (!QFSTopPopBannerPart.this.ga()) {
                QFSTopPopBannerPart.this.wa(draftBean);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d extends com.tencent.biz.qqcircle.widgets.a {
        d() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.a
        public void onTaskStateChanged(@NotNull TaskInfo taskInfo) {
            if (com.tencent.biz.qqcircle.widgets.p.d(taskInfo)) {
                QFSTopPopBannerPart.this.Y9(taskInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DraftBean f87625d;

        e(DraftBean draftBean) {
            this.f87625d = draftBean;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QLog.d("QFSTopPopBannerPart", 1, "showOldKillProcessDialog, positive btn click, dialog: " + dialogInterface);
            try {
                new QFSPersonalDraftUtil().e(QCirclePublishQualityReporter.getTraceId(), QFSTopPopBannerPart.this.getActivity(), this.f87625d, 4, 0);
                QFSTopPopBannerPart.this.S9("ev_xsj_camera_action", QCircleDaTongConstant.ElementId.EM_XSJ_DRAFT_PANEL_CONTINUE_BUTTON);
            } catch (Exception e16) {
                QLog.e("QFSTopPopBannerPart", 1, "showOldKillProcessDialog, positive click error ", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class f implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DraftBean f87627d;

        f(DraftBean draftBean) {
            this.f87627d = draftBean;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QLog.d("QFSTopPopBannerPart", 1, "showOldKillProcessDialog, negative btn click, dialog: " + dialogInterface);
            QFSTopPopBannerPart.this.Da(this.f87627d);
            QCircleToast.i(QCircleToast.f91644d, R.string.f183503jc, 1);
            QFSTopPopBannerPart.this.S9("ev_xsj_camera_action", QCircleDaTongConstant.ElementId.EM_XSJ_DRAFT_PANEL_CANCEL_BUTTON);
        }
    }

    private void Aa(String str) {
        Ba(this.f87604d);
        com.tencent.mobileqq.wink.report.a.f326259a.c(this.f87608i, WinkDaTongReportConstant.ElementId.EM_XSJ_DRAFT_TIP_BUTTON, ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL, "", null, null);
        qa(str);
        this.f87608i.setVisibility(0);
        this.f87608i.setText("\u53bb\u67e5\u770b");
        this.f87608i.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.fx
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSTopPopBannerPart.this.na(view);
            }
        });
        ra("\u5df2\u4fdd\u5b58\u81f3\u4e2a\u4eba\u4e3b\u9875\u8349\u7a3f\u7bb1");
        ua();
    }

    private void Ba(View view) {
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f55702im);
        if (viewStub == null) {
            return;
        }
        View findViewById = viewStub.inflate().findViewById(R.id.f55642ig);
        this.f87605e = findViewById;
        this.f87606f = (RoundCornerImageView) findViewById.findViewById(R.id.f55662ii);
        this.f87607h = (TextView) this.f87605e.findViewById(R.id.f55672ij);
        this.f87608i = (Button) this.f87605e.findViewById(R.id.f55682ik);
        this.f87609m = (Button) this.f87605e.findViewById(R.id.f55652ih);
        this.f87606f.setCorner(ViewUtils.dip2px(8.0f));
        this.f87606f.setBorder(true);
        this.f87606f.setColor(872415231);
        this.f87606f.setBorderWidth(ViewUtils.dpToPx(1.0f));
        sa();
    }

    private void Ca() {
        com.tencent.biz.qqcircle.widgets.a aVar = this.E;
        if (aVar != null) {
            QCirclePublishCallbackHelper.f93064a.v(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Da(DraftBean draftBean) {
        QFSTopPopBannerViewModel qFSTopPopBannerViewModel = this.C;
        if (qFSTopPopBannerViewModel != null) {
            qFSTopPopBannerViewModel.j2(draftBean.getMissionId(), 0);
        }
    }

    private void P9() {
        R9(this.f87605e);
        V9(this.f87605e, WinkDaTongReportConstant.ElementId.EM_XSJ_PUBLISH_TERMINATE_TOAST, new QCircleDTParamBuilder().buildElementParams());
    }

    private void Q9(View view) {
        VideoReport.setElementId(view, "em_xsj_publish_fail");
        VideoReport.setElementEndExposePolicy(this, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this, ClickPolicy.REPORT_ALL);
    }

    private void R9(View view) {
        VideoReport.setElementId(view, "em_xsj_publish_success");
        VideoReport.setElementEndExposePolicy(this, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this, ClickPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S9(String str, String str2) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("dialogDaTongReport... evenId:");
        sb5.append(str);
        sb5.append(" eid:");
        sb5.append(str2);
        sb5.append(" pgId:");
        com.tencent.biz.qqcircle.wink.e eVar = com.tencent.biz.qqcircle.wink.e.f93946a;
        sb5.append(eVar.t());
        QLog.d("QFSTopPopBannerPart", 2, sb5.toString());
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", str2);
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        buildElementParams.put("xsj_custom_pgid", eVar.t());
        VideoReport.reportEvent(str, null, buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T9(QFSTopPopBannerData qFSTopPopBannerData) {
        if (da(qFSTopPopBannerData)) {
            if (ea(qFSTopPopBannerData)) {
                Aa(qFSTopPopBannerData.getCoverUrl());
                return;
            }
            return;
        }
        va(qFSTopPopBannerData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U9(View view, int i3, int i16, boolean z16) {
        if (this.F) {
            if (z16) {
                view.setVisibility(8);
            }
        } else {
            if (view.getVisibility() != 0) {
                return;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", ViewUtils.dpToPx(i3), ViewUtils.dpToPx(i16));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(ofFloat);
            animatorSet.setDuration(240L);
            animatorSet.start();
            animatorSet.addListener(new b(z16, view));
        }
    }

    private void V9(View view, String str, Map<String, Object> map) {
        int i3 = !this.H ? 1 : 0;
        VideoReport.setPageId(getPartRootView(), getPageId() + "");
        VideoReport.addToDetectionWhitelist(getActivity());
        map.put("xsj_is_publish_defeated_works", Integer.valueOf(i3));
        VideoReport.setElementId(view, str);
        VideoReport.setElementParams(view, map);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
    }

    private void W9(View view, String str, String str2, Map<String, Object> map) {
        if (TextUtils.isEmpty(str)) {
            QLog.i("QFSTopPopBannerPart", 1, "dtReport eventId: null");
            return;
        }
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        if (map != null) {
            buildElementParams.putAll(map);
        }
        VideoReport.setElementId(view, str2);
        if (str.equals("dt_imp")) {
            VideoReport.reportEvent("dt_imp", view, buildElementParams);
        } else if (str.equals("dt_imp_end")) {
            VideoReport.reportEvent("dt_imp_end", view, buildElementParams);
        } else if (str.equals("dt_clck")) {
            VideoReport.reportEvent("dt_clck", view, buildElementParams);
        }
    }

    private void X9() {
        QFSTopPopBannerViewModel qFSTopPopBannerViewModel = this.C;
        if (qFSTopPopBannerViewModel != null && qFSTopPopBannerViewModel.h2(getContext())) {
            W9(this.f87605e, "dt_clck", "em_xsj_publish_success", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y9(TaskInfo taskInfo) {
        QLog.d("QFSTopPopBannerPart", 1, "handlePublishResult, taskInfo: " + taskInfo);
        QFSTopPopBannerViewModel qFSTopPopBannerViewModel = this.C;
        if (qFSTopPopBannerViewModel != null) {
            qFSTopPopBannerViewModel.i2(taskInfo.getMissionId(), 2);
        }
        if (taskInfo.isVideoComment()) {
            if (QFSCommentHelper.L().e0(taskInfo.getTaskId() + "")) {
                return;
            }
        }
        if (taskInfo.isSuccess() && !ta(taskInfo)) {
            ba();
            return;
        }
        if ("HOT_COMMENT_COLLECTION_MISSION_ID".equals(taskInfo.getMissionId())) {
            ba();
            if (!taskInfo.isSuccess()) {
                QCircleToast.i(QCircleToast.f91644d, R.string.f185223o0, 1);
                return;
            }
            return;
        }
        QFSTopPopBannerViewModel qFSTopPopBannerViewModel2 = this.C;
        if (qFSTopPopBannerViewModel2 != null) {
            qFSTopPopBannerViewModel2.W1(taskInfo);
        }
    }

    private void Z9() {
        QFSTopPopBannerViewModel qFSTopPopBannerViewModel = this.C;
        if (qFSTopPopBannerViewModel != null) {
            qFSTopPopBannerViewModel.e2();
        }
    }

    private void aa(Object obj) {
        if (obj instanceof Integer) {
            QLog.d("QFSTopPopBannerPart", 1, "handleTabChangedEvent, type: " + obj);
            this.D = ((Integer) obj).intValue();
        }
    }

    private void ba() {
        if (this.f87605e != null) {
            if (RFWThreadManager.isMainThread()) {
                this.f87605e.setVisibility(8);
            } else {
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSTopPopBannerPart.5
                    @Override // java.lang.Runnable
                    public void run() {
                        QFSTopPopBannerPart.this.f87605e.setVisibility(8);
                    }
                });
            }
            SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(19, "", false));
        }
        b80.d dVar = this.J;
        if (dVar != null) {
            dVar.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ca() {
        if (this.f87605e != null) {
            if (RFWThreadManager.isMainThread()) {
                U9(this.f87605e, 0, ExportErrorStatus.END_WRITE_AUDIO_SAMPLE, true);
            } else {
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSTopPopBannerPart.6
                    @Override // java.lang.Runnable
                    public void run() {
                        QFSTopPopBannerPart qFSTopPopBannerPart = QFSTopPopBannerPart.this;
                        qFSTopPopBannerPart.U9(qFSTopPopBannerPart.f87605e, 0, ExportErrorStatus.END_WRITE_AUDIO_SAMPLE, true);
                    }
                });
            }
        }
    }

    private boolean da(QFSTopPopBannerData qFSTopPopBannerData) {
        Bundle transParams = qFSTopPopBannerData.getTransParams();
        if (transParams == null) {
            return false;
        }
        return transParams.getBoolean(QQWinkConstants.NEED_SHOW_SAVE_DRAFT_DIALOG, false);
    }

    private boolean ea(QFSTopPopBannerData qFSTopPopBannerData) {
        Bundle transParams = qFSTopPopBannerData.getTransParams();
        if (transParams == null || transParams.getInt(QQWinkConstants.NEED_SELECT_WHICH) != QFSTopPopBannerViewModel.Selection.SAVE_DRAFT.ordinal()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ga() {
        if (getActivity() != null && !getActivity().isDestroyed()) {
            if (getActivity() != null && !getActivity().isFinishing()) {
                return false;
            }
            QLog.d("QFSTopPopBannerPart", 1, "isNotNeedShowBannerOrDialog, activity is finishing.");
            return true;
        }
        QLog.d("QFSTopPopBannerPart", 1, "isNotNeedShowBannerOrDialog, activity is destroyed.");
        return true;
    }

    private boolean ha() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_use_high_order_snackbar", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ia(DraftBean draftBean) {
        QLog.d("QFSTopPopBannerPart", 1, "mShowBannerNewLiveData onChanged, draftBean: " + draftBean);
        if (ga()) {
            return;
        }
        Aa(draftBean.getCoverUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ja(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Z9();
        ba();
        W9(this.f87608i, "dt_clck", "em_xsj_publish_fail", null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void la(DraftBean draftBean, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        new QFSPersonalDraftUtil().e(QCirclePublishQualityReporter.getTraceId(), getActivity(), draftBean, 4, 0);
        S9("ev_xsj_abnormal_clck", QCircleDaTongConstant.ElementId.EM_XSJ_DRAFT_CONTINUE_BUTTON);
        this.J.i();
        com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement(this);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ma(DraftBean draftBean, boolean z16) {
        if (z16) {
            S9("ev_xsj_abnormal_imp", QCircleDaTongConstant.ElementId.EM_XSJ_DRAFT_AUTO_SAVE);
            Da(draftBean);
            com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement(this);
            QQToast.makeText(getContext(), R.string.f183513jd, 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void na(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setFromReportBean(getReportBean().m466clone());
        com.tencent.biz.qqcircle.launcher.c.C(getContext(), qCircleInitBean, -1);
        ba();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void oa(DraftBean draftBean) {
        if (com.tencent.biz.qqcircle.immersive.manager.e.a().isElementActivating(this)) {
            QLog.d("QFSTopPopBannerPart", 1, "element is showing. ");
        } else {
            this.K = draftBean;
            com.tencent.biz.qqcircle.immersive.manager.e.a().notifyGroupActivate(this, RFWOrderElementManager.OrderMode.FORCE_MODE);
        }
    }

    private void pa() {
        if (this.E == null) {
            this.E = new d();
        }
        QCirclePublishCallbackHelper.f93064a.i(this.E, false);
    }

    private void qa(String str) {
        QLog.d("QFSTopPopBannerPart", 1, "setLocalCover, localCoverUrl: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.tencent.biz.qqcircle.utils.j.a(this.f87606f, str, 44.0f, 60.0f);
    }

    private void ra(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f87607h.setText(str);
        }
    }

    private void sa() {
        this.f87609m.setOnClickListener(this);
        this.f87605e.setOnClickListener(this);
    }

    private boolean ta(TaskInfo taskInfo) {
        if (com.tencent.biz.qqcircle.immersive.utils.r.m0(taskInfo.getTransParams())) {
            return true;
        }
        return !com.tencent.biz.qqcircle.immersive.utils.r.q0(this.D);
    }

    private void ua() {
        View view = this.f87605e;
        if (view != null) {
            view.setVisibility(0);
            U9(this.f87605e, ExportErrorStatus.END_WRITE_AUDIO_SAMPLE, 0, false);
            SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(19, "", true));
            RFWThreadManager.getUIHandler().removeCallbacks(this.G);
            RFWThreadManager.getUIHandler().postDelayed(this.G, 6000L);
        }
    }

    private void va(QFSTopPopBannerData qFSTopPopBannerData) {
        boolean z16;
        int i3;
        String string;
        String string2;
        Bundle transParams = qFSTopPopBannerData.getTransParams();
        Ba(this.f87604d);
        P9();
        Q9(this.f87608i);
        qa(qFSTopPopBannerData.getCoverUrl());
        if (!qFSTopPopBannerData.getIsSuccess() && !qFSTopPopBannerData.g()) {
            z16 = true;
        } else {
            z16 = false;
        }
        Button button = this.f87608i;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        button.setVisibility(i3);
        this.f87608i.setText("\u91cd\u8bd5");
        this.f87608i.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.fw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSTopPopBannerPart.this.ja(view);
            }
        });
        if (com.tencent.biz.qqcircle.immersive.utils.r.m0(transParams)) {
            string = this.f87607h.getResources().getString(R.string.f185273o5);
        } else {
            string = this.f87607h.getResources().getString(R.string.f185263o4);
        }
        if (qFSTopPopBannerData.getIsByUser()) {
            string2 = this.f87607h.getResources().getString(R.string.f185243o2);
        } else {
            string2 = this.f87607h.getResources().getString(R.string.f185253o3);
        }
        try {
            if (uq3.l.b().a(Long.parseLong(qFSTopPopBannerData.getErrorCode())) && !TextUtils.isEmpty(qFSTopPopBannerData.getErrorMsg())) {
                string2 = qFSTopPopBannerData.getErrorMsg();
            }
            if (transParams != null && !transParams.getBoolean(QQWinkConstants.NEED_SAVE_TO_DRAFT_BOX, true)) {
                string2 = this.f87607h.getResources().getString(R.string.f185233o1);
                this.f87608i.setVisibility(8);
                this.f87609m.setVisibility(8);
            }
        } catch (Exception e16) {
            QLog.e("QFSTopPopBannerPart", 1, e16, new Object[0]);
        }
        if (!qFSTopPopBannerData.getIsSuccess()) {
            string = string2;
        }
        ra(string);
        if (qFSTopPopBannerData.getIsSuccess()) {
            W9(this.f87605e, "dt_clck", "em_xsj_publish_success", null);
        } else if (qFSTopPopBannerData.getIsByUser()) {
            W9(this.f87605e, "dt_clck", WinkDaTongReportConstant.ElementId.EM_XSJ_PUBLISH_TERMINATE_TOAST, null);
        } else {
            W9(this.f87605e, "dt_imp", "em_xsj_publish_fail", null);
        }
        ua();
        if (transParams != null && !qFSTopPopBannerData.getIsSuccess() && TextUtils.equals("layer_publish_template", transParams.getString("publish_source_type"))) {
            ra(com.tencent.biz.qqcircle.utils.h.a(R.string.f185223o0));
            this.f87608i.setVisibility(8);
            this.f87609m.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wa(DraftBean draftBean) {
        QCircleCustomDialog qCircleCustomDialog = this.I;
        if (qCircleCustomDialog != null && qCircleCustomDialog.isShowing()) {
            QLog.w("QFSTopPopBannerPart", 1, "showKillProcessDialog, dialog is showing, mDialog: " + this.I);
            return;
        }
        Context hostContext = ASEngineUtils.getHostContext(getContext());
        if (hostContext == null) {
            QLog.w("QFSTopPopBannerPart", 1, "context == null");
            return;
        }
        if (b80.e.a()) {
            return;
        }
        if (b80.e.b()) {
            if (!((IStudyModeApi) QRoute.api(IStudyModeApi.class)).isStudyMode()) {
                if (ha()) {
                    oa(draftBean);
                    return;
                } else {
                    xa(draftBean);
                    return;
                }
            }
            return;
        }
        za(draftBean, hostContext);
        QFSTopPopBannerViewModel.g2(draftBean, getContext());
        S9("ev_xsj_camera_action", QCircleDaTongConstant.ElementId.EM_XSJ_REEDIT_HINT_PANEL);
    }

    private void xa(final DraftBean draftBean) {
        final RoundCornerImageView roundCornerImageView = (RoundCornerImageView) this.J.f(R.id.f55662ii);
        if (roundCornerImageView != null) {
            roundCornerImageView.setCorner(ViewUtils.dip2px(4.0f));
            roundCornerImageView.setBorder(true);
            roundCornerImageView.setColor(R.color.qui_common_fill_standard_primary);
            roundCornerImageView.setBorderWidth(ViewUtils.dpToPx(1.0f));
            Option obtain = Option.obtain();
            obtain.setUrl(draftBean.getCoverUrl()).setPredecode(true).setRequestWidth(ViewUtils.dip2px(36.0f)).setRequestHeight(ViewUtils.dip2px(48.0f));
            QCircleFeedPicLoader.g().loadImage(obtain, new QCirclePicStateListener() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSTopPopBannerPart.7
                @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
                public void onStateChange(final LoadState loadState, final Option option) {
                    RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSTopPopBannerPart.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (loadState == LoadState.STATE_SUCCESS) {
                                roundCornerImageView.setImageDrawable(new BitmapDrawable(option.getResultBitMap()));
                            }
                        }
                    });
                }
            });
        }
        Button button = (Button) this.J.f(R.id.f55682ik);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.fu
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QFSTopPopBannerPart.this.la(draftBean, view);
                }
            });
        }
        this.J.o(new d.a() { // from class: com.tencent.biz.qqcircle.immersive.part.fv
            @Override // b80.d.a
            public final void a(boolean z16) {
                QFSTopPopBannerPart.this.ma(draftBean, z16);
            }
        });
        this.J.p();
        S9("ev_xsj_abnormal_imp", QCircleDaTongConstant.ElementId.EM_XSJ_DRAFT_CONTINUE_BUTTON);
    }

    private void za(DraftBean draftBean, Context context) {
        boolean z16;
        QCircleCustomDialog X = QCircleCustomDialog.X(context, getContext().getResources().getString(R.string.f183663js), getContext().getResources().getString(R.string.f183653jr), draftBean.getCoverUrl(), R.string.cancel, R.string.f181943f5, new e(draftBean), new f(draftBean));
        this.I = X;
        X.setOnCancelListener(new a(draftBean));
        if (getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("QFSTopPopBannerPart", 1, "showOldKillProcessDialog, mDialog: " + this.I + ", activityActive: " + z16);
        if (z16) {
            this.I.show();
        }
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getContextHashCode() {
        if (getContext() == null) {
            return "";
        }
        return String.valueOf(getContext().hashCode());
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ String getElementExtraKey() {
        return com.tencent.biz.richframework.order.a.a(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(AccountChangeEvent.class);
        arrayList.add(QCircleShowSaveDraftDialogEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getGroup() {
        return "bubble_tip";
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ String getGroupExtraKey() {
        return com.tencent.biz.richframework.order.a.b(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSTopPopBannerPart";
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 103;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        if (TextUtils.equals(str, "tab_changed_new_layer")) {
            aa(obj);
        }
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ boolean isDataReady() {
        return com.tencent.biz.richframework.order.a.c(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        if (this.K != null) {
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f55682ik) {
            Z9();
            W9(this.f87608i, "dt_clck", "em_xsj_publish_fail", null);
        } else if (view.getId() == R.id.f55642ig) {
            X9();
        }
        ba();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        QLog.d("QFSTopPopBannerPart", 1, "onElementActivated... lastDraft:" + this.K);
        DraftBean draftBean = this.K;
        if (draftBean != null) {
            xa(draftBean);
        }
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        QLog.d("QFSTopPopBannerPart", 1, "onElementInactivated... ");
        this.K = null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f87604d = view;
        this.J = new b80.d((ViewStub) this.f87604d.findViewById(R.id.f55692il));
        pa();
        com.tencent.biz.qqcircle.immersive.manager.e.a().addElement(this);
        QFSTopPopBannerViewModel qFSTopPopBannerViewModel = (QFSTopPopBannerViewModel) getViewModel(QFSTopPopBannerViewModel.class);
        this.C = qFSTopPopBannerViewModel;
        qFSTopPopBannerViewModel.R1().observe(getHostFragment(), new Observer<QFSTopPopBannerData>() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSTopPopBannerPart.2
            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onChanged(final QFSTopPopBannerData qFSTopPopBannerData) {
                QLog.d("QFSTopPopBannerPart", 1, "getShowBannerLiveData onChanged, bannerData: " + qFSTopPopBannerData);
                if (QFSTopPopBannerPart.this.ga()) {
                    return;
                }
                QFSTopPopBannerPart.this.H = qFSTopPopBannerData.getIsByUser();
                if (QFSTopPopBannerPart.this.f87605e == null || QFSTopPopBannerPart.this.f87605e.getVisibility() != 0) {
                    QFSTopPopBannerPart.this.T9(qFSTopPopBannerData);
                } else {
                    QFSTopPopBannerPart.this.ca();
                    RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSTopPopBannerPart.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QFSTopPopBannerPart.this.T9(qFSTopPopBannerData);
                        }
                    }, 250L);
                }
            }
        });
        this.C.S1().observe(getHostFragment(), new c());
        this.C.P1(true, this.f87604d.getContext());
        this.C.C.observe(getHostFragment(), new Observer() { // from class: com.tencent.biz.qqcircle.immersive.part.ft
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSTopPopBannerPart.this.ia((DraftBean) obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QLog.d("QFSTopPopBannerPart", 1, "onPartDestroy ");
        Ca();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        QCircleCustomDialog qCircleCustomDialog = this.I;
        if (qCircleCustomDialog != null && qCircleCustomDialog.isShowing()) {
            QLog.d("QFSTopPopBannerPart", 1, "onPartDestroy, dismiss dialog: " + this.I);
            this.I.dismiss();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        if (this.C == null) {
            this.C = (QFSTopPopBannerViewModel) getViewModel(QFSTopPopBannerViewModel.class);
        }
        if (this.f87604d != null && QCircleServiceImpl.getAppRunTime().isLogin()) {
            this.C.P1(false, this.f87604d.getContext());
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        Object obj;
        if (simpleBaseEvent instanceof AccountChangeEvent) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onReceiveEvent, dialog: ");
            QCircleCustomDialog qCircleCustomDialog = this.I;
            if (qCircleCustomDialog != null) {
                obj = Boolean.valueOf(qCircleCustomDialog.isShowing());
            } else {
                obj = "";
            }
            sb5.append(obj);
            QLog.d("QFSTopPopBannerPart", 1, sb5.toString());
            QCircleCustomDialog qCircleCustomDialog2 = this.I;
            if (qCircleCustomDialog2 != null && qCircleCustomDialog2.isShowing()) {
                QLog.d("QFSTopPopBannerPart", 1, "onReceiveEvent, dismiss dialog:" + this.I);
                this.I.dismiss();
                return;
            }
            return;
        }
        if (simpleBaseEvent instanceof QCircleShowSaveDraftDialogEvent) {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSTopPopBannerPart.12
                @Override // java.lang.Runnable
                public void run() {
                    QFSTopPopBannerPart.this.C.c2(((IWinkDraft) QRoute.api(IWinkDraft.class)).getLastDraftBeanSync(HostDataTransUtils.getLongAccountUin()));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f87620d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f87621e;

        b(boolean z16, View view) {
            this.f87620d = z16;
            this.f87621e = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            QFSTopPopBannerPart.this.F = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f87620d) {
                this.f87621e.setVisibility(8);
            }
            QFSTopPopBannerPart.this.F = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QFSTopPopBannerPart.this.F = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
