package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.view.View;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleAvatarLayerBean;
import com.tencent.biz.qqcircle.immersive.personal.data.w;
import com.tencent.biz.qqcircle.immersive.personal.utils.QFSMagicAvatarModifyUtils;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.widgets.QFSBaseBottomSheetDialog;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;

/* loaded from: classes4.dex */
public class QFSPersonalDecorateBottomSheet extends QFSBaseBottomSheetDialog implements View.OnClickListener {
    private w E;
    private final View F;
    private a G;
    private View H;
    private boolean I;

    /* loaded from: classes4.dex */
    public interface a {
        void a();
    }

    private void P(View view, String str) {
        if (this.E == null) {
            QLog.d("QFSPersonalDecorateBottomSheet", 1, "[dtReportButtonClick] mUserInfoData == null");
            return;
        }
        VideoReport.setLogicParent(view, this.F);
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_AVATAR_PANEL);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PROFILE_HOST, this.E.L());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AVATAR_PANEL_BUTTON, str);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PENDANT_ID, this.E.c().iconDecorate.f398453id.get());
        VideoReport.reportEvent("ev_xsj_abnormal_clck", view, buildElementParams);
    }

    private void Q() {
        com.tencent.biz.qqcircle.launcher.c.g(getContext(), com.tencent.biz.qqcircle.f.x());
    }

    private void R() {
        if (com.tencent.biz.qqcircle.helpers.d.a(3, true)) {
            QLog.d("QFSPersonalDecorateBottomSheet", 1, "[handleChangeMagicAvatarClick] forbid because of sencebeat");
            return;
        }
        View view = this.H;
        if (view != null) {
            view.setVisibility(8);
        }
        if (this.I) {
            uq3.k.a().j("magic_avatar_first_read", false);
        }
        QLog.d("QFSPersonalDecorateBottomSheet", 1, "[handleChangeMagicAvatarClick] click magic avatar modify.");
        QFSMagicAvatarModifyUtils.f89040a.h(this.C, this.E);
    }

    private void S() {
        w wVar = this.E;
        if (wVar == null) {
            return;
        }
        if (!wVar.z() && !QCirclePluginUtil.canJumpToQQProfile(this.E.e().opMask.get())) {
            QCircleToast.l(QCircleToast.f91644d, com.tencent.biz.qqcircle.utils.h.a(R.string.f184473lz), 0, false, false);
        } else if (!this.E.z() && QCirclePluginUtil.isJumpToQQProfileBeated(this.E.e().opMask.get())) {
            QCircleToast.j(QCircleToast.f91644d, uq3.c.i2(), 0);
        } else {
            QCircleHostLauncher.startProfileCardActivity(getContext(), this.E.L());
        }
    }

    private void U() {
        if (this.E == null) {
            QLog.d("QFSPersonalDecorateBottomSheet", 1, "[handleLookUpAuthorAvatarDecorateClick] mUserInfoData == null");
        } else {
            com.tencent.biz.qqcircle.launcher.c.p(getContext(), new QCircleAvatarLayerBean(this.E.c(), true));
        }
    }

    public void W(w wVar) {
        this.E = wVar;
        QFSMagicAvatarModifyUtils.f89040a.i(wVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!fb0.a.a("QFSPersonalDecorateBottomSheet")) {
            int id5 = view.getId();
            if (id5 == R.id.f108916ee) {
                S();
                P(view, QCircleDaTongConstant.ElementParamValue.ENTER_QQPROFILE);
            } else if (id5 == R.id.f109116ey) {
                U();
                P(view, QCircleDaTongConstant.ElementParamValue.VIEW_AUTHOR_AVATAR_PENDANT);
            } else if (id5 == R.id.f10659695) {
                Q();
                P(view, QCircleDaTongConstant.ElementParamValue.CHANGE_AVATAR_PENDANT);
            } else if (id5 == R.id.f167033k60) {
                P(view, "cancel");
            } else if (id5 == R.id.f107616aw) {
                a aVar = this.G;
                if (aVar != null) {
                    aVar.a();
                }
                P(view, QCircleDaTongConstant.ElementParamValue.AVATAR_EDIT);
            } else if (id5 == R.id.f109136f0) {
                R();
                P(view, QCircleDaTongConstant.ElementParamValue.MAGIC_AVATAR);
            }
            dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
