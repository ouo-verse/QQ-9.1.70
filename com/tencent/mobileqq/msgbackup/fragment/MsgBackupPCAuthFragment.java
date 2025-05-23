package com.tencent.mobileqq.msgbackup.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.qui.quisecnavbar.e;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.data.d;
import com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qui.quiblurview.c;

/* loaded from: classes15.dex */
public class MsgBackupPCAuthFragment extends MsgBackupPcBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: r0, reason: collision with root package name */
    private int f251217r0;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f251218s0;

    /* renamed from: t0, reason: collision with root package name */
    private int f251219t0;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f251220u0;

    /* renamed from: v0, reason: collision with root package name */
    private Handler f251221v0;

    /* loaded from: classes15.dex */
    class a implements Handler.Callback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupPCAuthFragment.this);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
            }
            if (message.what != 1) {
                return false;
            }
            if (MsgBackupPCAuthFragment.this.getActivity() == null) {
                return true;
            }
            if (MsgBackupPCAuthFragment.this.f251217r0 > 0) {
                if (MsgBackupPCAuthFragment.this.f251217r0 == 60) {
                    MsgBackupPCAuthFragment.this.Vh(1);
                }
                MsgBackupPCAuthFragment.Oh(MsgBackupPCAuthFragment.this);
                MsgBackupPCAuthFragment msgBackupPCAuthFragment = MsgBackupPCAuthFragment.this;
                msgBackupPCAuthFragment.V.setText(msgBackupPCAuthFragment.getString(R.string.ilg, Integer.valueOf(msgBackupPCAuthFragment.f251217r0)));
                if (AppSetting.f99565y) {
                    MsgBackupPCAuthFragment msgBackupPCAuthFragment2 = MsgBackupPCAuthFragment.this;
                    msgBackupPCAuthFragment2.V.setContentDescription(msgBackupPCAuthFragment2.getString(R.string.ilg));
                }
                MsgBackupPCAuthFragment.this.f251221v0.sendEmptyMessageDelayed(1, 1000L);
            } else {
                MsgBackupPCAuthFragment.this.f251221v0.removeCallbacksAndMessages(null);
                MsgBackupPCAuthFragment.this.f251217r0 = 60;
                MsgBackupPCAuthFragment.this.f251220u0 = false;
                if (NetworkUtil.getSystemNetwork(MsgBackupPCAuthFragment.this.getActivity()) == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                MsgBackupPCAuthFragment msgBackupPCAuthFragment3 = MsgBackupPCAuthFragment.this;
                if (z16) {
                    i3 = 0;
                }
                msgBackupPCAuthFragment3.Vh(i3);
                MsgBackupPCAuthFragment.this.V.setText(R.string.il5);
                if (AppSetting.f99565y) {
                    MsgBackupPCAuthFragment msgBackupPCAuthFragment4 = MsgBackupPCAuthFragment.this;
                    msgBackupPCAuthFragment4.V.setContentDescription(msgBackupPCAuthFragment4.getString(R.string.il5));
                }
            }
            return true;
        }
    }

    /* loaded from: classes15.dex */
    class b implements com.tencent.mobileqq.msgbackup.controller.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupPCAuthFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.msgbackup.controller.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                MsgBackupPCAuthFragment msgBackupPCAuthFragment = MsgBackupPCAuthFragment.this;
                msgBackupPCAuthFragment.Ch(msgBackupPCAuthFragment.L, msgBackupPCAuthFragment.getString(R.string.ili));
            }
        }
    }

    public MsgBackupPCAuthFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f251217r0 = 60;
        this.f251218s0 = false;
        this.f251219t0 = 0;
        this.f251220u0 = false;
        this.f251221v0 = new Handler(new a());
    }

    static /* synthetic */ int Oh(MsgBackupPCAuthFragment msgBackupPCAuthFragment) {
        int i3 = msgBackupPCAuthFragment.f251217r0;
        msgBackupPCAuthFragment.f251217r0 = i3 - 1;
        return i3;
    }

    private void Th() {
        ((IMsgBackupTempApi) QRoute.api(IMsgBackupTempApi.class)).gotoWebViewBrowser(BaseApplication.getContext(), "https://qzs.qzone.qq.com/qzone/qzact/act/external/qzone-platform/qq-web/pcqq_version_upgrade_919.html", true, true, true, false, null, "biz_src_msg_backup");
    }

    private void Uh() {
        View view;
        boolean z16;
        View view2;
        if (!needBlur() || this.quiSecNavBar == null || (view = ((QIphoneTitleBarFragment) this).mContentView) == null) {
            return;
        }
        boolean z17 = false;
        ((QIphoneTitleBarFragment) this).mContentView.setPadding(0, e.b(view.getContext()), 0, 0);
        if (!QQTheme.isDefaultTheme() && !QQTheme.isNowThemeDefaultNight()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (c.f363628c.b(BaseApplication.context) && z16) {
            z17 = true;
        }
        QUISecNavBar qUISecNavBar = this.quiSecNavBar;
        if (z17) {
            view2 = ((QIphoneTitleBarFragment) this).mContentView;
        } else {
            view2 = null;
        }
        qUISecNavBar.setBlur(z17, view2);
        if (!z16) {
            return;
        }
        if (z17) {
            this.quiSecNavBar.setTitleBlurAlpha(0.0f);
        } else {
            this.quiSecNavBar.setTitleAlpha(0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vh(int i3) {
        this.f251219t0 = i3;
        if (i3 == 0) {
            this.V.setEnabled(true);
        } else {
            this.V.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
    public void Ah(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) dVar);
            return;
        }
        super.Ah(dVar);
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackupMsgBackupPCAuthFragment", 2, "processGetQrRsp data = " + dVar);
        }
        if (dVar != null) {
            com.tencent.mobileqq.msgbackup.authentication.a.d().h(dVar.a());
            com.tencent.mobileqq.msgbackup.authentication.a.d().i(dVar.c());
        }
    }

    protected void Sh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            MsgBackupManager.x().z().n();
            MsgBackupTransportProcessor.u().O();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment, com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable @android.support.annotation.Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, layoutInflater, viewGroup, bundle);
        } else {
            super.doOnCreateView(layoutInflater, viewGroup, bundle);
            Uh();
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment, android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 10012) {
            int i3 = 0;
            if (message.arg1 == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (this.V != null) {
                if (this.f251220u0) {
                    Vh(1);
                } else {
                    if (!z16) {
                        i3 = 2;
                    }
                    Vh(i3);
                }
            }
            if (!z16) {
                if (this.L != null && !isDetached()) {
                    this.L.setTextColor(getResources().getColor(R.color.amk));
                    this.L.setText(getActivity().getString(R.string.ijg));
                }
                if (this.M != null && !isDetached()) {
                    this.M.setText(getActivity().getString(R.string.f170560il1));
                }
            } else {
                if (this.L != null && !isDetached()) {
                    this.L.setTextColor(getResources().getColor(R.color.skin_black));
                    this.L.setText(getActivity().getString(R.string.iky));
                }
                if (this.M != null && !isDetached()) {
                    this.M.setText(getActivity().getString(R.string.f170560il1));
                }
            }
        }
        return super.handleMessage(message);
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupPcBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
        } else {
            MsgBackupManager.N = false;
            super.initWindowStyleAndAnimation(activity);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean needBlur() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else {
            super.onActivityResult(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (this.f251218s0) {
            Sh();
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) view);
        } else {
            super.onClick(view);
            if (view.getId() == R.id.lsj) {
                int i3 = this.f251219t0;
                if (i3 == 0) {
                    this.f251220u0 = true;
                    this.f251218s0 = true;
                    this.f251221v0.sendEmptyMessage(1);
                    if (QLog.isColorLevel()) {
                        QLog.d("MsgBackupMsgBackupPCAuthFragment", 2, "migrate_sure onclick phone request backup!");
                    }
                    MsgBackupManager.x().b0(true);
                    com.tencent.mobileqq.msgbackup.util.d.e("0X800A26A");
                } else if (i3 == 1 && !this.f251228p0) {
                    com.tencent.mobileqq.msgbackup.util.d.e("0X800A26B");
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            super.onDestroy();
            MsgBackupManager.x().W(null);
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupPcBaseFragment, com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        super.onDestroyView();
        this.f251221v0.removeMessages(1);
        MsgBackupManager.x().W(null);
        Runnable runnable = this.f251170b0;
        if (runnable != null) {
            this.X.removeCallbacks(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupPcBaseFragment, com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
    public void rh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.rh();
        ViewUtils.setVisible(this.F, 0);
        ViewUtils.setVisible(this.G, 8);
        ViewUtils.setVisible(this.V, 0);
        ViewUtils.setVisible(this.J, 8);
        ViewUtils.setVisible(this.V, 0);
        this.K.setImageResource(R.drawable.msg_back_up_phone_to_pc);
        this.L.setText(R.string.iky);
        this.M.setText(R.string.f170560il1);
        this.V.setText(R.string.il5);
        if (AppSetting.f99565y) {
            this.V.setContentDescription(getString(R.string.il5));
        }
        MsgBackupManager.x().W(new b());
        this.X.post(this.f251170b0);
        this.V.setOnClickListener(this);
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupPcBaseFragment, com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
    protected void xh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            setTitle(getActivity().getString(R.string.iiu));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
    public void zh(Integer num) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) num);
            return;
        }
        super.zh(num);
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackupMsgBackupPCAuthFragment", 2, "processGetQrError result = " + num);
        }
        if (num.intValue() == 1028) {
            Th();
        }
    }
}
