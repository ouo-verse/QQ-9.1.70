package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.adapter.d;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Map;
import qqcircle.QQCircleDitto$StItemContainer;

/* compiled from: P */
/* loaded from: classes4.dex */
public class bn extends u implements View.OnClickListener {
    private e30.b C;
    private QQCircleDitto$StItemContainer D;
    private boolean E;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f87771d;

    /* renamed from: e, reason: collision with root package name */
    private Dialog f87772e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f87773f;

    /* renamed from: h, reason: collision with root package name */
    private RecyclerView f87774h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.adapter.d f87775i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f87776m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements d.b {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.adapter.d.b
        public void a() {
            bn.this.D9();
        }
    }

    private void A9() {
        QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer = this.D;
        if (qQCircleDitto$StItemContainer == null) {
            QLog.e("QFSFollowDialogPart", 1, "[bindData] mItemContainer is null");
            return;
        }
        this.f87773f.setText(qQCircleDitto$StItemContainer.title.get());
        this.f87775i.setData(this.D.items.get());
        e30.b bVar = this.C;
        if (bVar != null && bVar.g() != null) {
            this.f87775i.p0(this.C.g());
        }
        this.f87775i.setReportBean(getReportBean());
        this.f87775i.o0(this.f87771d);
        this.f87774h.scrollToPosition(0);
    }

    private void B9() {
        VideoReport.setLogicParent(this.f87776m, this.f87771d);
        VideoReport.setElementClickPolicy(this.f87776m, ClickPolicy.REPORT_ALL);
    }

    private void C9() {
        VideoReport.setLogicParent(this.f87776m, this.f87771d);
        VideoReport.setElementExposePolicy(this.f87776m, ExposurePolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D9() {
        Dialog dialog = this.f87772e;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private void E9(Object obj) {
        if (!this.E) {
            QLog.e("QFSFollowDialogPart", 1, "[handleUpdateFeed] mIsResume is false.");
            return;
        }
        if (H9()) {
            QLog.e("QFSFollowDialogPart", 1, "[handleUpdateFeed] priority pop window is showing.");
            return;
        }
        boolean z16 = obj instanceof e30.b;
        if (z16) {
            e30.b bVar = (e30.b) obj;
            if (bVar.g() != null) {
                if (z16 && F9(bVar)) {
                    QLog.e("QFSFollowDialogPart", 1, "[handleUpdateFeed] feed has showed follow dialog.");
                    return;
                }
                this.C = bVar;
                if (bVar.g().dittoFeed.dittoId.get() != 43) {
                    if (QLog.isDevelopLevel()) {
                        QLog.e("QFSFollowDialogPart", 4, "[handleUpdateFeed] feed do not contain dittoFeed.");
                        return;
                    }
                    return;
                }
                QQCircleDitto$StItemContainer i3 = com.tencent.biz.qqcircle.immersive.views.mixfeed.d.i(bVar, String.valueOf(43));
                this.D = i3;
                if (i3 != null && i3.items.get() != null && this.D.items.size() != 0) {
                    G9();
                    A9();
                    K9();
                    z9();
                    C9();
                    return;
                }
                QLog.e("QFSFollowDialogPart", 1, "[handleUpdateFeed] itemContainer should not be null.");
                return;
            }
        }
        QLog.e("QFSFollowDialogPart", 1, "[handleUpdateFeed] feed should not be null.");
    }

    private boolean F9(e30.b bVar) {
        if (bVar == null) {
            QLog.e("QFSFollowDialogPart", 1, "[hasShowedFollowDialog] mFeedBlockData is null");
            return false;
        }
        Object b16 = bVar.b("key_follow_dialog_has_showed");
        if (b16 instanceof Boolean) {
            QLog.e("QFSFollowDialogPart", 1, "[hasShowedFollowDialog] hasShowed =" + b16);
            return ((Boolean) b16).booleanValue();
        }
        if (QLog.isDevelopLevel()) {
            QLog.e("QFSFollowDialogPart", 4, "[hasShowedFollowDialog] hasShowed return false");
        }
        return false;
    }

    private void G9() {
        String dtPageId;
        if (getPartRootView() != null && getActivity() != null && !getActivity().isFinishing()) {
            if (this.f87772e != null) {
                QLog.e("QFSFollowDialogPart", 1, "[initFollowDialogView] follow dialog is showing");
                return;
            }
            this.f87772e = new com.tencent.biz.qqcircle.widgets.comment.a(getContext());
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.gca, (ViewGroup) null);
            J9();
            this.f87771d = (LinearLayout) inflate.findViewById(R.id.f42061ir);
            this.f87773f = (TextView) inflate.findViewById(R.id.f41971ii);
            this.f87776m = (ImageView) inflate.findViewById(R.id.f41961ih);
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.f42041ip);
            this.f87774h = recyclerView;
            recyclerView.setLayoutManager(new SafeLinearLayoutManager(getContext(), 1, false));
            com.tencent.biz.qqcircle.immersive.adapter.d dVar = new com.tencent.biz.qqcircle.immersive.adapter.d(new a());
            this.f87775i = dVar;
            this.f87774h.setAdapter(dVar);
            this.f87772e.setContentView(inflate);
            this.f87776m.setOnClickListener(this);
            VideoReport.setElementId(this.f87771d, QCircleDaTongConstant.ElementId.EM_XSJ_ZERO_FOLLOW_GUIDE_FOLLOW_POPUP);
            VideoReport.setElementId(this.f87776m, "em_xsj_close_button");
            VideoReport.setElementParams(this.f87771d, new QCircleDTParamBuilder().buildElementParams());
            LinearLayout linearLayout = this.f87771d;
            if (getReportBean() == null) {
                dtPageId = QCircleDaTongConstant.PageId.BASE;
            } else {
                dtPageId = getReportBean().getDtPageId();
            }
            VideoReport.setPageId(linearLayout, dtPageId);
            return;
        }
        QLog.e("QFSFollowDialogPart", 1, "[initFollowDialogView] view == null || getActivity is finish");
    }

    private boolean H9() {
        if (!Cdo.B9() && !QFSTeenModePopWindowPart.T9() && !QFSPersonalRecommendSwitchPanelPart.N9()) {
            return false;
        }
        QLog.d("QFSFollowDialogPart", 1, "[isPriorityPopWindowShowing] QFSPersonalRecommendSwitchPanelPart.isPersonalRecommendSwitchPanelCanShow() = " + QFSPersonalRecommendSwitchPanelPart.N9() + ", QFSNewUserPYMKGuidePart.isShowNewUserPYMKGuide() = " + Cdo.B9() + ", QFSTeenModePopWindowPart.isTeenModePopWindowShow() = " + QFSTeenModePopWindowPart.T9());
        return true;
    }

    private void I9() {
        Window window = this.f87772e.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 17;
            attributes.width = com.tencent.biz.qqcircle.utils.cx.a(295.0f);
            attributes.height = com.tencent.biz.qqcircle.utils.cx.a(506.0f);
            window.setAttributes(attributes);
        }
    }

    private void J9() {
        this.f87772e.setCanceledOnTouchOutside(false);
        this.f87772e.getWindow().requestFeature(1);
        this.f87772e.getWindow().setFlags(1024, 1024);
        this.f87772e.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }

    private void K9() {
        Dialog dialog = this.f87772e;
        if (dialog != null && !dialog.isShowing() && getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
            this.f87772e.show();
            I9();
        }
    }

    private void L9(e30.b bVar) {
        if (bVar == null) {
            return;
        }
        bVar.o("key_follow_dialog_has_showed", Boolean.TRUE);
        QLog.d("QFSFollowDialogPart", 1, "[updateHasShowedFollowDialog] true");
    }

    private void z9() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        e30.b bVar = this.C;
        if (bVar != null && bVar.g() != null) {
            FeedCloudMeta$StFeed g16 = this.C.g();
            buildElementParams.put("xsj_feed_id", g16.f398449id.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, g16.poster.f398463id.get());
        }
        if (getReportBean() != null) {
            buildElementParams.put("xsj_custom_pgid", getReportBean().getDtPageId());
        }
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_ZERO_FOLLOW_GUIDE_FOLLOW_POPUP);
        VideoReport.reportEvent("ev_xsj_abnormal_imp", buildElementParams);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSFollowDialogPart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if ("layer_notify_part_update_feed".equals(str)) {
            E9(obj);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        if (!((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch() && !FontSettingManager.isFontSizeLarge()) {
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f41961ih) {
            D9();
            B9();
            L9(this.C);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        D9();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        this.E = false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        this.E = true;
    }
}
