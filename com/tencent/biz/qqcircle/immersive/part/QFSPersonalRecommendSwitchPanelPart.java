package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.events.QCircleShowSettingEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSEnableSlideRightActionEvent;
import com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdTopViewPresenter;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleSetUserSwitchRequest;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView;
import com.tencent.biz.qqcircle.utils.QFSSlidBottomView;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.event.QFSPersonalRecommendSwitchClosedEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Map;
import qqcircle.QQCircleProfile$SetUserSwitchRsp;

/* loaded from: classes4.dex */
public class QFSPersonalRecommendSwitchPanelPart extends u implements SimpleEventReceiver, View.OnClickListener {
    private static final String E = uq3.c.b1("qqcircle", "qqcircle_personalized_recommendation_hint_text", "\u63d0\u793a\uff1a\u53ef\u8bbe\u7f6e\u4e0d\u628a\u4e92\u52a8\u5185\u5bb9\u63a8\u8350\u7ed9\u597d\u53cb\u54e6\uff5e");
    private static boolean F = false;
    private QUIButton C;
    private int D;

    /* renamed from: d, reason: collision with root package name */
    private FrameLayout f87500d;

    /* renamed from: e, reason: collision with root package name */
    private QFSSlidBottomView f87501e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f87502f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f87503h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f87504i;

    /* renamed from: m, reason: collision with root package name */
    private QUIButton f87505m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements VSDispatchObserver.OnVSRspCallBack<QQCircleProfile$SetUserSwitchRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f87507a;

        b(boolean z16) {
            this.f87507a = z16;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleProfile$SetUserSwitchRsp qQCircleProfile$SetUserSwitchRsp) {
            if (z16 && j3 == 0) {
                SimpleEventBus.getInstance().dispatchEvent(new QCircleShowSettingEvent(10, this.f87507a));
                QCircleToast.o("\u4e2a\u6027\u5316\u63a8\u8350\u5f00\u542f\u6210\u529f", 0);
            } else {
                com.tencent.biz.qqcircle.utils.cj.b(false, j3, str);
            }
        }
    }

    private void F9(String str, View view) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_clck", view, I9());
    }

    private boolean G9() {
        QFSSlidBottomView qFSSlidBottomView = this.f87501e;
        if (qFSSlidBottomView != null && qFSSlidBottomView.getVisibility() == 0) {
            this.f87501e.d();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H9(String str, View view) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_imp_end", view, I9());
    }

    private Map<String, Object> I9() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CUMULATIVE_SHOW_TIMES, Integer.valueOf(com.tencent.biz.qqcircle.immersive.utils.r.B()));
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        return buildElementParams;
    }

    private void J9() {
        if (this.D != 1) {
            QLog.d("QFSPersonalRecommendSwitchPanelPart", 1, "[handlePersonalRecommendSwitchClosedEvent] is not the first resume. mResumeTimes =" + this.D);
            return;
        }
        if (!QFSTeenModePopWindowPart.T9() && !com.tencent.biz.qqcircle.immersive.utils.r.H0(getHostFragment())) {
            if (!com.tencent.biz.qqcircle.immersive.utils.r.w0()) {
                QLog.d("QFSPersonalRecommendSwitchPanelPart", 1, "[handlePersonalRecommendSwitchClosedEvent] panel should not show.");
                return;
            } else {
                QLog.d("QFSPersonalRecommendSwitchPanelPart", 1, "[handlePersonalRecommendSwitchClosedEvent] initAndShowAuthorPanel");
                getMainHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSPersonalRecommendSwitchPanelPart.3
                    @Override // java.lang.Runnable
                    public void run() {
                        QFSPersonalRecommendSwitchPanelPart.this.L9();
                    }
                });
                return;
            }
        }
        QLog.d("QFSPersonalRecommendSwitchPanelPart", 1, "[handlePersonalRecommendSwitchClosedEvent] teen mode pop window is showing.");
    }

    private void K9(String str, View view) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementParams(view, I9());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L9() {
        QLog.d("QFSPersonalRecommendSwitchPanelPart", 1, "[initAndShowAuthorPanel]");
        M9();
        initSlideView();
        QFSSlidBottomView qFSSlidBottomView = this.f87501e;
        if (qFSSlidBottomView != null && this.f87500d != null) {
            qFSSlidBottomView.j(this.f87502f);
            this.f87500d.setVisibility(0);
            uq3.k.a().n("sp_key_personal_recommend_switch_panel_show_timestamp", System.currentTimeMillis());
            uq3.k.a().m("sp_key_personal_recommend_switch_panel_showed_times", com.tencent.biz.qqcircle.immersive.utils.r.B() + 1);
            z70.b x16 = QFSFeedChildAdTopViewPresenter.x1(getContext());
            if (x16 != null) {
                x16.b(this.f87500d);
            }
            K9(QCircleDaTongConstant.ElementId.EM_XSJ_OPEN_PERSONAL_RECOMMEND_PANEL, this.f87500d);
            K9(QCircleDaTongConstant.ElementId.EM_XSJ_OPEN_BUTTON, this.C);
            K9("em_xsj_close_button", this.f87503h);
            K9(QCircleDaTongConstant.ElementId.EM_XSJ_NEGATIVE_FEEDBACK_BUTTON, this.f87505m);
        }
    }

    private void M9() {
        if (this.f87500d != null) {
            QLog.d("QFSPersonalRecommendSwitchPanelPart", 1, "[initPanel] personal recommend switch panel has init");
            return;
        }
        ViewStub viewStub = (ViewStub) getPartRootView().findViewById(R.id.f487020p);
        if (viewStub == null) {
            QLog.e("QFSPersonalRecommendSwitchPanelPart", 1, "[initPanel] qfs_personal_recommend_switch_enable_view_stub is null");
            return;
        }
        View inflate = viewStub.inflate();
        this.f87500d = (FrameLayout) inflate.findViewById(R.id.f486820n);
        this.f87501e = (QFSSlidBottomView) inflate.findViewById(R.id.f486920o);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.f486520k);
        this.f87502f = linearLayout;
        com.tencent.mobileqq.qui.b.f276860a.a(linearLayout, RFWNavigationBarImmersiveHelper.ImmersiveType.IMMERSIVE);
        this.f87503h = (ImageView) inflate.findViewById(R.id.f486420j);
        this.f87504i = (TextView) inflate.findViewById(R.id.f486620l);
        this.f87505m = (QUIButton) inflate.findViewById(R.id.f486320i);
        this.C = (QUIButton) inflate.findViewById(R.id.f486720m);
        TextView textView = this.f87504i;
        if (textView != null) {
            textView.setText(E);
        }
        ImageView imageView = this.f87503h;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        QUIButton qUIButton = this.f87505m;
        if (qUIButton != null) {
            qUIButton.setOnClickListener(this);
        }
        QUIButton qUIButton2 = this.C;
        if (qUIButton2 != null) {
            qUIButton2.setOnClickListener(this);
        }
    }

    public static boolean N9() {
        return F;
    }

    private void initSlideView() {
        QFSSlidBottomView qFSSlidBottomView = this.f87501e;
        if (qFSSlidBottomView == null) {
            QLog.e("QFSPersonalRecommendSwitchPanelPart", 1, "[initSlideView] mSlideView is null");
        } else {
            qFSSlidBottomView.c(new a());
        }
    }

    protected void O9(boolean z16) {
        VSNetworkHelper.getInstance().sendRequest(new QCircleSetUserSwitchRequest(5, !z16 ? 1 : 0), new b(z16));
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSPersonalRecommendSwitchClosedEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalRecommendSwitchPanelPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return !((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (!G9() && !super.onBackEvent()) {
            return false;
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f486420j) {
            G9();
            F9("em_xsj_close_button", this.f87503h);
        } else if (id5 == R.id.f486320i) {
            G9();
            F9(QCircleDaTongConstant.ElementId.EM_XSJ_NEGATIVE_FEEDBACK_BUTTON, this.f87505m);
        } else if (id5 == R.id.f486720m) {
            O9(true);
            G9();
            F9(QCircleDaTongConstant.ElementId.EM_XSJ_OPEN_BUTTON, this.C);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        G9();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        this.D++;
        QLog.d("QFSPersonalRecommendSwitchPanelPart", 1, "[onPartResume] mResumeTimes =" + this.D);
        FrameLayout frameLayout = this.f87500d;
        if (frameLayout != null && frameLayout.getVisibility() == 0) {
            QLog.d("QFSPersonalRecommendSwitchPanelPart", 1, "[onPartResume] setAllBottomTabVisible(false)");
            com.tencent.biz.qqcircle.immersive.utils.ax.g(getContext(), false);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSPersonalRecommendSwitchClosedEvent) {
            J9();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements QCircleSlidBottomView.d {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public /* synthetic */ void a() {
            com.tencent.biz.qqcircle.utils.ad.c(this);
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public /* synthetic */ void onConfigurationChanged() {
            com.tencent.biz.qqcircle.utils.ad.a(this);
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public void onDismiss() {
            QLog.d("QFSPersonalRecommendSwitchPanelPart", 1, "[initSlideView] mSlideView.addStatusListener onDismiss");
            SimpleEventBus.getInstance().dispatchEvent(new QFSEnableSlideRightActionEvent(true, QFSPersonalRecommendSwitchPanelPart.this.getContext()));
            if (QFSPersonalRecommendSwitchPanelPart.this.f87500d != null) {
                QFSPersonalRecommendSwitchPanelPart.this.f87500d.setVisibility(8);
            }
            SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(7, "", false));
            com.tencent.biz.qqcircle.immersive.utils.ax.g(QFSPersonalRecommendSwitchPanelPart.this.getContext(), true);
            z70.b x16 = QFSFeedChildAdTopViewPresenter.x1(QFSPersonalRecommendSwitchPanelPart.this.getContext());
            if (x16 != null) {
                x16.i(QFSPersonalRecommendSwitchPanelPart.this.f87500d);
            }
            QFSPersonalRecommendSwitchPanelPart.F = false;
            QFSPersonalRecommendSwitchPanelPart qFSPersonalRecommendSwitchPanelPart = QFSPersonalRecommendSwitchPanelPart.this;
            qFSPersonalRecommendSwitchPanelPart.H9(QCircleDaTongConstant.ElementId.EM_XSJ_OPEN_PERSONAL_RECOMMEND_PANEL, qFSPersonalRecommendSwitchPanelPart.f87500d);
            QFSPersonalRecommendSwitchPanelPart qFSPersonalRecommendSwitchPanelPart2 = QFSPersonalRecommendSwitchPanelPart.this;
            qFSPersonalRecommendSwitchPanelPart2.H9(QCircleDaTongConstant.ElementId.EM_XSJ_OPEN_BUTTON, qFSPersonalRecommendSwitchPanelPart2.C);
            QFSPersonalRecommendSwitchPanelPart qFSPersonalRecommendSwitchPanelPart3 = QFSPersonalRecommendSwitchPanelPart.this;
            qFSPersonalRecommendSwitchPanelPart3.H9("em_xsj_close_button", qFSPersonalRecommendSwitchPanelPart3.f87503h);
            QFSPersonalRecommendSwitchPanelPart qFSPersonalRecommendSwitchPanelPart4 = QFSPersonalRecommendSwitchPanelPart.this;
            qFSPersonalRecommendSwitchPanelPart4.H9(QCircleDaTongConstant.ElementId.EM_XSJ_NEGATIVE_FEEDBACK_BUTTON, qFSPersonalRecommendSwitchPanelPart4.f87505m);
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public /* synthetic */ void onScrollChanged(int i3, int i16, int i17, int i18) {
            com.tencent.biz.qqcircle.utils.ad.b(this, i3, i16, i17, i18);
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public void onShow() {
            QLog.d("QFSPersonalRecommendSwitchPanelPart", 1, "[initSlideView] mSlideView.addStatusListener onShow");
            SimpleEventBus.getInstance().dispatchEvent(new QFSEnableSlideRightActionEvent(false, QFSPersonalRecommendSwitchPanelPart.this.getContext()));
            SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(7, "", true));
            com.tencent.biz.qqcircle.immersive.utils.ax.g(QFSPersonalRecommendSwitchPanelPart.this.getContext(), false);
            QFSPersonalRecommendSwitchPanelPart.F = true;
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public void onStatusChange(int i3) {
        }
    }
}
