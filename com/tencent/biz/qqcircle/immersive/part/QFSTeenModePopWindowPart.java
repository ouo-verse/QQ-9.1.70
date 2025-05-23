package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSDynamicUIBottomPanelVisibleEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSEnableSlideRightActionEvent;
import com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdTopViewPresenter;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSTabTitleVisibilityEvent;
import com.tencent.biz.qqcircle.immersive.views.RadiusChangeableQUIButton;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView;
import com.tencent.biz.qqcircle.utils.QFSSlidBottomView;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qcircle.api.global.QFSTeenModeConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.AppSetting;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommonDialog$Dialog;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes4.dex */
public class QFSTeenModePopWindowPart extends u implements View.OnClickListener, SimpleEventReceiver {
    private static boolean J = false;
    private QUIButton C;
    private TextView D;
    private TextView E;
    private TextView F;
    private String G;
    private boolean H = false;
    private boolean I = false;

    /* renamed from: d, reason: collision with root package name */
    private View f87594d;

    /* renamed from: e, reason: collision with root package name */
    private FrameLayout f87595e;

    /* renamed from: f, reason: collision with root package name */
    private QFSSlidBottomView f87596f;

    /* renamed from: h, reason: collision with root package name */
    private LinearLayout f87597h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f87598i;

    /* renamed from: m, reason: collision with root package name */
    private LinearLayout f87599m;

    private void L9(String str) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", str);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", buildElementParams);
    }

    private boolean M9() {
        QFSSlidBottomView qFSSlidBottomView = this.f87596f;
        if (qFSSlidBottomView != null && qFSSlidBottomView.getVisibility() == 0) {
            this.f87596f.d();
            return true;
        }
        return false;
    }

    private void N9() {
        QFSSlidBottomView qFSSlidBottomView = this.f87596f;
        if (qFSSlidBottomView == null) {
            return;
        }
        qFSSlidBottomView.d();
        QLog.d("QFSTeenModePopWindowPart", 1, "Teen Mode Window Dismiss");
    }

    private boolean O9() {
        return com.tencent.biz.qqcircle.utils.k.g("exp_youth_popopui", "exp_youth_popopui_B");
    }

    private boolean P9() {
        return com.tencent.biz.qqcircle.utils.k.g("exp_youth_popopui", "exp_youth_popopui_C");
    }

    private void Q9() {
        this.f87596f.c(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R9() {
        int i3;
        if (this.H) {
            QLog.d("QFSTeenModePopWindowPart", 1, "Teen Mode Window Has init.");
            return;
        }
        ViewStub viewStub = (ViewStub) this.f87594d.findViewById(R.id.f55362hp);
        if (viewStub == null) {
            return;
        }
        if (S9()) {
            i3 = R.layout.f168763gt3;
        } else {
            i3 = R.layout.f168762gt2;
        }
        viewStub.setLayoutResource(i3);
        com.tencent.biz.qqcircle.utils.k.j("exp_youth_popopui");
        QLog.d("QFSTeenModePopWindowPart", 1, "Teen Mode Window start init.");
        View inflate = viewStub.inflate();
        this.f87595e = (FrameLayout) inflate.findViewById(R.id.f55352ho);
        this.f87596f = (QFSSlidBottomView) inflate.findViewById(R.id.f55372hq);
        this.f87597h = (LinearLayout) inflate.findViewById(R.id.f55272hg);
        this.f87598i = (ImageView) inflate.findViewById(R.id.f55242hd);
        this.f87599m = (LinearLayout) inflate.findViewById(R.id.f55282hh);
        this.C = (QUIButton) inflate.findViewById(R.id.f55252he);
        this.D = (TextView) inflate.findViewById(R.id.f55522i5);
        this.E = (TextView) inflate.findViewById(R.id.f55262hf);
        this.F = (TextView) inflate.findViewById(R.id.f55292hi);
        this.f87598i.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.f87599m.setOnClickListener(this);
        Q9();
        this.f87595e.setVisibility(8);
        this.H = true;
        QUIButton qUIButton = this.C;
        if (qUIButton instanceof RadiusChangeableQUIButton) {
            qUIButton.setType(O9() ? 1 : 0);
        }
    }

    private boolean S9() {
        if (AppSetting.isGrayVersion()) {
            QLog.d("QFSTeenModePopWindowPart", 1, "Feature open in GrayVersion");
            return true;
        }
        boolean O9 = O9();
        boolean P9 = P9();
        QLog.d("QFSTeenModePopWindowPart", 1, "hitExpBShowWhiteButton:" + O9 + ", hitExpCShowBlueButton:" + P9);
        if (O9 || P9) {
            return true;
        }
        return false;
    }

    public static boolean T9() {
        return J;
    }

    private void U9() {
        if (TextUtils.isEmpty(this.G)) {
            QLog.d("QFSTeenModePopWindowPart", 1, "mJumpScheme is empty.");
            return;
        }
        com.tencent.biz.qqcircle.launcher.c.j(getContext(), this.G, true);
        N9();
        QLog.d("QFSTeenModePopWindowPart", 1, "Jump To Teen Mode Setting Page.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V9() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_TEENAGER_MODE_PANEL);
        VideoReport.reportEvent("ev_xsj_abnormal_imp", buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W9(boolean z16) {
        if (this.I) {
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new QFSDynamicUIBottomPanelVisibleEvent(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X9(final FeedCloudCommonDialog$Dialog feedCloudCommonDialog$Dialog, final int i3) {
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSTeenModePopWindowPart.3
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("QFSTeenModePopWindowPart", 1, "[setWindowVisible]");
                if (feedCloudCommonDialog$Dialog != null) {
                    QFSTeenModePopWindowPart.this.R9();
                    if (!TextUtils.isEmpty(feedCloudCommonDialog$Dialog.title.get())) {
                        QFSTeenModePopWindowPart.this.D.setText(feedCloudCommonDialog$Dialog.title.get());
                    }
                    if (!TextUtils.isEmpty(feedCloudCommonDialog$Dialog.content.get())) {
                        QFSTeenModePopWindowPart.this.E.setText(feedCloudCommonDialog$Dialog.content.get());
                    }
                    if (!TextUtils.isEmpty(feedCloudCommonDialog$Dialog.jump_text.get())) {
                        QFSTeenModePopWindowPart.this.F.setText(feedCloudCommonDialog$Dialog.jump_text.get());
                    }
                    QFSTeenModePopWindowPart.this.G = feedCloudCommonDialog$Dialog.jump_url.get();
                    if (TextUtils.isEmpty(QFSTeenModePopWindowPart.this.G)) {
                        QFSTeenModePopWindowPart.this.G = "mqqapi://setting/childrenmode?fromtype=5&present=1";
                    }
                    if (QFSTeenModePopWindowPart.this.f87595e != null && QFSTeenModePopWindowPart.this.f87596f != null) {
                        QFSTeenModePopWindowPart.J = true;
                        if (i3 == 1) {
                            QFSTeenModeConfig.saveTeenModeWindowLastShowTime();
                            QLog.d("QFSTeenModePopWindowPart", 1, "[setWindowVisible] Teen Mode Window Last Show Time Saved.");
                        }
                        QFSTeenModePopWindowPart.this.f87595e.setVisibility(0);
                        QFSTeenModePopWindowPart.this.f87596f.j(QFSTeenModePopWindowPart.this.f87597h);
                        z70.b x16 = QFSFeedChildAdTopViewPresenter.x1(QFSTeenModePopWindowPart.this.getContext());
                        if (x16 != null) {
                            x16.b(QFSTeenModePopWindowPart.this.f87595e);
                        }
                        QFSTeenModePopWindowPart.this.V9();
                        QLog.d("QFSTeenModePopWindowPart", 1, "Teen Mode Window Start Show.");
                    }
                }
            }
        }, 500L);
    }

    private void Y9(final int i3) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSTeenModePopWindowPart.2
            @Override // java.lang.Runnable
            public void run() {
                FeedCloudCommonDialog$Dialog teenModeDialogRsp = QFSTeenModeConfig.getTeenModeDialogRsp(i3);
                boolean H0 = com.tencent.biz.qqcircle.immersive.utils.r.H0(QFSTeenModePopWindowPart.this.getHostFragment());
                QLog.d("QFSTeenModePopWindowPart", 1, "[show] dialogType = " + i3 + ", isNeedShow = " + H0);
                int i16 = i3;
                if (i16 == 2 || H0) {
                    QFSTeenModePopWindowPart.this.X9(teenModeDialogRsp, i16);
                }
            }
        });
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSTabTitleVisibilityEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSTeenModePopWindowPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public Object getMessage(String str, Object obj) {
        boolean z16;
        if ("qfs_is_teen_mode_window_show".equals(str)) {
            FrameLayout frameLayout = this.f87595e;
            if (frameLayout != null && frameLayout.getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.d("QFSTeenModePopWindowPart", 1, "is show teen windows:" + z16);
            return Boolean.valueOf(z16);
        }
        return super.getMessage(str, obj);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if ("qfs_open_teen_mode_window".equals(str)) {
            Y9(2);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (!M9() && !super.onBackEvent()) {
            return false;
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f55242hd) {
            N9();
            L9(QCircleDaTongConstant.ElementId.EM_XSJ_TEENAGER_MODE_CLOSE_BUTTON);
        } else if (id5 == R.id.f55252he) {
            N9();
            L9(QCircleDaTongConstant.ElementId.EM_XSJ_TEENAGER_MODE_KNOW_BUTTON);
        } else if (id5 == R.id.f55282hh) {
            U9();
            L9(QCircleDaTongConstant.ElementId.EM_XSJ_TEENAGER_MODE_ENTER_BUTTON);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f87594d = view;
        this.I = QCircleHostGlobalInfo.isCurrentTabActive();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        if (this.I && !QCircleHostGlobalInfo.isCurrentTabActive()) {
            return;
        }
        Y9(1);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        M9();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        if (J) {
            com.tencent.biz.qqcircle.immersive.utils.ax.h(getContext(), false);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        FrameLayout frameLayout;
        if ((simpleBaseEvent instanceof QFSTabTitleVisibilityEvent) && T9() && (frameLayout = this.f87595e) != null) {
            frameLayout.setVisibility(0);
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
            com.tencent.biz.qqcircle.immersive.utils.ax.h(QFSTeenModePopWindowPart.this.getContext(), true);
            QFSTeenModePopWindowPart.this.W9(true);
            SimpleEventBus.getInstance().dispatchEvent(new QFSEnableSlideRightActionEvent(true, QFSTeenModePopWindowPart.this.getContext()));
            SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(35, "", false));
            if (QFSTeenModePopWindowPart.this.f87595e != null) {
                QFSTeenModePopWindowPart.this.f87595e.setVisibility(8);
            }
            z70.b x16 = QFSFeedChildAdTopViewPresenter.x1(QFSTeenModePopWindowPart.this.getContext());
            if (x16 != null) {
                x16.i(QFSTeenModePopWindowPart.this.f87595e);
            }
            QFSTeenModePopWindowPart.J = false;
            QLog.d("QFSTeenModePopWindowPart", 1, "Teen Mode Window Dismiss.");
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public /* synthetic */ void onScrollChanged(int i3, int i16, int i17, int i18) {
            com.tencent.biz.qqcircle.utils.ad.b(this, i3, i16, i17, i18);
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public void onShow() {
            com.tencent.biz.qqcircle.immersive.utils.ax.h(QFSTeenModePopWindowPart.this.getContext(), false);
            QFSTeenModePopWindowPart.this.W9(false);
            SimpleEventBus.getInstance().dispatchEvent(new QFSEnableSlideRightActionEvent(false, QFSTeenModePopWindowPart.this.getContext()));
            SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(35, "", true));
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public void onStatusChange(int i3) {
        }
    }
}
