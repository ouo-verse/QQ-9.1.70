package n60;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleEditProfileBean;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.personal.bean.v;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.af;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.mobileqq.R;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class s extends n60.b implements View.OnClickListener {
    private ViewStub C;
    private LinearLayout D;
    private TextView E;
    private TextView F;
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.t G;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f418475f;

    /* renamed from: h, reason: collision with root package name */
    private ViewStub f418476h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f418477i;

    /* renamed from: m, reason: collision with root package name */
    private QFSFollowView f418478m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends v.a {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.bean.v.a
        public void d(@NonNull com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
            s.this.E(wVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.biz.qqcircle.immersive.personal.data.w f418480d;

        b(com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
            this.f418480d = wVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ClipboardMonitor.setPrimaryClip((ClipboardManager) s.this.b().getSystemService("clipboard"), ClipData.newPlainText("Label", this.f418480d.b().penguinModifyGuideURL.get()));
            QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f1925547t), 0);
            dialogInterface.dismiss();
            s.this.x(QCircleDaTongConstant.ElementId.EM_XSJ_GO_PENGUIN, "ev_xsj_abnormal_clck");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            s.this.x(QCircleDaTongConstant.ElementId.EM_XSJ_CANCEL_BUTTON_PENGUIN, "ev_xsj_abnormal_clck");
        }
    }

    public s(@NonNull n60.a aVar) {
        super(aVar);
    }

    private void A() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.G;
        if (tVar != null && tVar.N1() != null) {
            com.tencent.biz.qqcircle.immersive.personal.data.w N1 = this.G.N1();
            if (!N1.z()) {
                return;
            }
            String s16 = N1.s("followListUrl");
            Intent intent = new Intent();
            intent.putExtra(QCirclePublishQualityReporter.KEY_CLICK_WEB_TIME, System.currentTimeMillis());
            intent.putExtra(QCirclePublishQualityReporter.KEY_H5_TYPE, "follow");
            QLog.d("QFSPersonalInfoTeenagerViewCompact", 1, "jumpFollowList: = " + s16);
            com.tencent.biz.qqcircle.launcher.c.o0(b(), s16, intent, -1);
        }
    }

    private void B(com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        boolean z16;
        QCircleEditProfileBean qCircleEditProfileBean = new QCircleEditProfileBean();
        qCircleEditProfileBean.setHostUin(wVar.L());
        qCircleEditProfileBean.setAvatarUrl(wVar.c().icon.iconUrl.get());
        qCircleEditProfileBean.setNick(wVar.c().nick.get());
        qCircleEditProfileBean.setGender(wVar.c().sex.get());
        qCircleEditProfileBean.setConstellation(wVar.c().constellation.get());
        qCircleEditProfileBean.setLocation(af.c(wVar.c().location.get()));
        qCircleEditProfileBean.setLocationCode(wVar.c().locationCode.get());
        qCircleEditProfileBean.setDesc(wVar.c().desc.get());
        if (wVar.g() != null) {
            qCircleEditProfileBean.setGroup(af.b(wVar.g().bindGroupStatus.get(), wVar.g().bind_groups.get()));
        }
        boolean z17 = false;
        if (wVar.a().schoolInfos.size() > 0) {
            qCircleEditProfileBean.setSchool(wVar.a().schoolInfos.get(0).name.get());
        }
        if (wVar.a().companyInfos.size() > 0) {
            qCircleEditProfileBean.setCompany(wVar.a().companyInfos.get(0).name.get());
        }
        qCircleEditProfileBean.setBindChannel(wVar.b().guildInfo.name.get());
        qCircleEditProfileBean.setBindChannelID(wVar.b().guildInfo.guildId.get() + "");
        qCircleEditProfileBean.setBindChannelStatus(wVar.g().bindGuildStatus.get());
        if (wVar.g().hideSchool.get() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        qCircleEditProfileBean.setShowSchool(z16);
        qCircleEditProfileBean.setUpdateSchoolNum(wVar.g().updateSchoolNum.get());
        if (wVar.b().redPoint.pendantManage.get() == 1) {
            z17 = true;
        }
        qCircleEditProfileBean.setHasDecorateRedPoint(z17);
        qCircleEditProfileBean.setStProfileBizData(wVar.g().toByteArray());
        com.tencent.biz.qqcircle.launcher.c.f0(b(), qCircleEditProfileBean);
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(wVar.L()).setActionType(11).setSubActionType(24).setThrActionType(2).setPageId(e()).setfPageId(f()));
    }

    private void C(com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        QCircleCustomDialog P = QCircleCustomDialog.P(b(), com.tencent.biz.qqcircle.utils.h.a(R.string.f19263481), com.tencent.biz.qqcircle.utils.h.a(R.string.f19262480), R.string.cancel, R.string.f19266484, new b(wVar), new c());
        x(QCircleDaTongConstant.ElementId.EM_XSJ_GO_PENGUIN, "ev_xsj_abnormal_imp");
        x(QCircleDaTongConstant.ElementId.EM_XSJ_CANCEL_BUTTON_PENGUIN, "ev_xsj_abnormal_imp");
        P.show();
    }

    private void D(@NonNull com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        TextView textView = this.f418477i;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
        if (!wVar.x()) {
            this.f418477i.setText(wVar.a().completionDesc.get());
            QCircleLpReportDc05504.report(w().setSubActionType(24).setThrActionType(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SetTextI18n"})
    public void E(@NonNull com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        if (wVar.z()) {
            this.f418477i.setVisibility(8);
            this.f418478m.setVisibility(8);
            D(wVar);
            this.D.setClickable(true);
            this.E.setText(com.tencent.biz.qqcircle.immersive.utils.r.f(wVar.c().followCount.get()));
            this.F.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f19049429));
            return;
        }
        this.f418478m.setVisibility(8);
        this.f418477i.setVisibility(8);
        this.f418478m.setUserData(wVar.c());
        this.f418478m.setShowQQProfile(wVar.e().opMask.get().contains(3));
        this.f418478m.setProfilePage(true);
        this.D.setClickable(false);
        this.E.setText(com.tencent.biz.qqcircle.immersive.utils.r.f(wVar.c().fansCount.get()));
        this.F.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f183163if));
    }

    private void v() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.G;
        if (tVar != null && tVar.N1() != null) {
            com.tencent.biz.qqcircle.immersive.personal.data.w N1 = this.G.N1();
            if (N1.z() && !N1.x()) {
                if (N1.b().isPenguinUser.get() == 1) {
                    C(N1);
                } else {
                    B(N1);
                }
            }
        }
    }

    private QCircleLpReportDc05504.DataBuilder w() {
        String L;
        QCircleLpReportDc05504.DataBuilder dataBuilder = new QCircleLpReportDc05504.DataBuilder();
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.G;
        if (tVar == null) {
            L = "";
        } else {
            L = tVar.N1().L();
        }
        return dataBuilder.setToUin(L).setActionType(11).setPageId(e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, String str2) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_custom_pgid", "pg_xsj_profile_page");
        buildElementParams.put("xsj_eid", str);
        VideoReport.reportEvent(str2, buildElementParams);
    }

    private void y() {
        if (this.C.getParent() == null) {
            return;
        }
        View inflate = this.C.inflate();
        this.D = (LinearLayout) inflate.findViewById(R.id.f46261u4);
        this.E = (TextView) inflate.findViewById(R.id.f56652l7);
        this.F = (TextView) inflate.findViewById(R.id.f56642l6);
        this.D.setOnClickListener(this);
    }

    private void z() {
        if (this.f418476h.getParent() == null) {
            return;
        }
        View inflate = this.f418476h.inflate();
        this.f418477i = (TextView) inflate.findViewById(R.id.f56632l5);
        this.f418478m = (QFSFollowView) inflate.findViewById(R.id.f55532i6);
        this.f418477i.setOnClickListener(this);
    }

    @Override // n60.b
    public void j(@NonNull QFSBaseFragment qFSBaseFragment) {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.t) qFSBaseFragment.getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.t.class);
        this.G = tVar;
        tVar.O1().c(qFSBaseFragment, new a());
    }

    @Override // n60.b
    public boolean k() {
        return !com.tencent.biz.qqcircle.manager.i.a("qfs_personal_entrance_show");
    }

    @Override // n60.b
    public void o() {
        LinearLayout linearLayout = (LinearLayout) a(R.id.f46241u2);
        this.f418475f = linearLayout;
        linearLayout.setVisibility(8);
        this.f418476h = (ViewStub) a(R.id.f57512ni);
        this.C = (ViewStub) a(R.id.f57502nh);
        z();
        y();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f56632l5) {
            v();
        } else if (id5 == R.id.f46261u4) {
            A();
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
