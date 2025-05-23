package com.tencent.biz.qqcircle.immersive;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.beans.QFSIdentityBean;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSIdentityAuthenticationShowEvent;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSIdentityAuthenticationFragment extends QFSBaseFragment {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f84699d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f84700e;

        a(int i3, Context context) {
            this.f84699d = i3;
            this.f84700e = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (i3 != 1) {
                QFSIdentityAuthenticationFragment.this.Ch(this.f84699d);
                QFSIdentityAuthenticationFragment.this.zh();
                QLog.d(QFSIdentityAuthenticationFragment.this.getTAG(), 1, "handleIdentityAuthentication  dialog click cancel");
                return;
            }
            com.tencent.biz.qqcircle.f v3 = com.tencent.biz.qqcircle.f.v();
            if (v3 != null) {
                String l3 = v3.l();
                com.tencent.biz.qqcircle.launcher.c.o0(this.f84700e, l3, null, -1);
                QLog.d(QFSIdentityAuthenticationFragment.this.getTAG(), 1, "handleIdentityAuthentication  dialog click confirm ==> url : " + l3);
            }
            QFSIdentityAuthenticationFragment.this.Ah(this.f84699d);
            QFSIdentityAuthenticationFragment.this.xh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements DialogInterface.OnDismissListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            FragmentActivity activity = QFSIdentityAuthenticationFragment.this.getActivity();
            if (activity == null) {
                return;
            }
            activity.finish();
            activity.overridePendingTransition(0, 0);
            r.O0(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ah(int i3) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        buildElementParams.put("xsj_action_type", "setting");
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SCENE, wh(i3));
        VideoReport.reportEvent("ev_xsj_abnormal_clck", null, buildElementParams);
    }

    private void Bh(int i3) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        buildElementParams.put("xsj_action_type", "exp");
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SCENE, wh(i3));
        VideoReport.reportEvent("ev_xsj_abnormal_clck", null, buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ch(int i3) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        buildElementParams.put("xsj_action_type", QCircleDaTongConstant.ElementParamValue.LATER_ON);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SCENE, wh(i3));
        VideoReport.reportEvent("ev_xsj_abnormal_clck", null, buildElementParams);
    }

    private void Dh(int i3) {
        DialogInterface.OnClickListener vh5 = vh(getActivity(), i3);
        QCircleCustomDialog P = QCircleCustomDialog.P(getActivity(), getString(R.string.f181673ee), com.tencent.biz.qqcircle.utils.h.a(R.string.f181653ec), R.string.f181643eb, R.string.f181663ed, vh5, vh5);
        P.setCancelable(false);
        yh(i3);
        Bh(i3);
        P.setOnDismissListener(new b());
        P.show();
        r.O0(true);
        if (i3 == 2 || i3 == 3) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSIdentityAuthenticationShowEvent(true, 1));
        }
    }

    @NotNull
    private DialogInterface.OnClickListener vh(Context context, int i3) {
        return new a(i3, context);
    }

    private String wh(int i3) {
        switch (i3) {
            case 1:
                return "publish";
            case 2:
                return "comment";
            case 3:
                return "reply";
            case 4:
                return QCircleDaTongConstant.ElementParamValue.BARRAGE;
            case 5:
                return QCircleDaTongConstant.ElementParamValue.PERSONAL_INTRODUCTION;
            case 6:
                return QCircleDaTongConstant.ElementParamValue.PERSONAL_QQ_GROUP;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xh() {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(53).setSubActionType(2).setThrActionType(0));
    }

    private void yh(int i3) {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(53).setSubActionType(1).setThrActionType(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh() {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(53).setSubActionType(3).setThrActionType(0));
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gdh;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSIdentityAuthenticationFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 0;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Serializable serializableExtra = getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
        if (!(serializableExtra instanceof QFSIdentityBean)) {
            return;
        }
        Dh(((QFSIdentityBean) serializableExtra).getSource());
    }
}
