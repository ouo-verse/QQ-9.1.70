package com.tencent.mobileqq.msgbackup.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.mobileqq.msgbackup.util.d;
import com.tencent.mobileqq.msgbackup.util.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes15.dex */
public class MsgBackupPCConfirmFragment extends MsgBackupPcBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: r0, reason: collision with root package name */
    public static MsgBackupPCConfirmFragment f251224r0;

    /* loaded from: classes15.dex */
    class a implements com.tencent.mobileqq.widget.navbar.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupPCConfirmFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.navbar.a
        public void onItemSelect(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (i3 == 1 || i3 == 2) {
                f.D("MsgBackupMsgBackupPCConfirmFragment", "click cancel btn bizType = %d, pcHandler %b", Integer.valueOf(MsgBackupPCConfirmFragment.this.Y), Boolean.valueOf(MsgBackupManager.N));
                MsgBackupTransportProcessor.u().n();
                if (TextUtils.isEmpty(MsgBackupPCConfirmFragment.this.f251227o0)) {
                    MsgBackupPCConfirmFragment msgBackupPCConfirmFragment = MsgBackupPCConfirmFragment.this;
                    msgBackupPCConfirmFragment.uh(msgBackupPCConfirmFragment.getActivity());
                } else {
                    MsgBackupPCConfirmFragment.this.onBackEvent();
                }
                if (MsgBackupPCConfirmFragment.this.Y == 2) {
                    d.e("0X800A282");
                } else if (MsgBackupManager.N) {
                    d.f("0X800A266", 4);
                }
            }
        }
    }

    public MsgBackupPCConfirmFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment, com.tencent.mobileqq.msgbackup.controller.e
    public void C8(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.W.sendMessage(this.W.obtainMessage(10001));
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (i3 == 4) {
            MsgBackupTransportProcessor.u().n();
            int b16 = com.tencent.mobileqq.msgbackup.authentication.a.d().b();
            if (b16 == 2) {
                onBackEvent();
            } else if (b16 == 1) {
                if (this.f251228p0) {
                    onBackEvent();
                } else {
                    uh(getActivity());
                }
            }
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment, android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) message)).booleanValue();
        }
        if (getActivity() == null) {
            f.D("MsgBackupMsgBackupPCConfirmFragment", "activity is null------------->", new Object[0]);
            return false;
        }
        if (message.what == 10001) {
            int b16 = com.tencent.mobileqq.msgbackup.authentication.a.d().b();
            if (b16 == 2) {
                onBackEvent();
            } else if (b16 == 1) {
                if (this.f251228p0) {
                    onBackEvent();
                } else {
                    uh(getActivity());
                }
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupPcBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
            return;
        }
        super.initWindowStyleAndAnimation(activity);
        if (activity != null && this.f251228p0) {
            activity.overridePendingTransition(R.anim.f154724iv, R.anim.f154723iu);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        super.onAttach(activity);
        MsgBackupPCConfirmFragment msgBackupPCConfirmFragment = f251224r0;
        if (msgBackupPCConfirmFragment != null && msgBackupPCConfirmFragment.getActivity() != null) {
            f251224r0.getActivity().finish();
        } else {
            f.B("MsgBackupMsgBackupPCConfirmFragment", "fight1111.onAttach getActivity = null,sInstance = null", new Object[0]);
        }
        f251224r0 = this;
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            super.onClick(view);
            if (view.getId() == R.id.ls9) {
                if (this.Y == 1) {
                    Intent intent = new Intent();
                    intent.putExtra("backup_select_from", 1);
                    intent.putExtra("0x11bpush_extra", this.f251227o0);
                    QPublicFragmentActivity.startForResult(getActivity(), intent, (Class<? extends QPublicBaseFragment>) MsgBackupSelectionFragment.class, 1000);
                    f.D("MsgBackupMsgBackupPCConfirmFragment", "migrate_btn onclick BIZ_TYPE_BACKUP", new Object[0]);
                    if (this.f251228p0) {
                        d.e("0X800A255");
                    }
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("param_start", 2);
                    intent2.putExtra("0x11bpush_extra", this.f251227o0);
                    QPublicFragmentActivity.startForResult(getActivity(), intent2, (Class<? extends QPublicBaseFragment>) MsgBackupPCTransportFragment.class, 1000);
                    f.D("MsgBackupMsgBackupPCConfirmFragment", "migrate_btn onclick BIZ_TYPE_RESTORE", new Object[0]);
                    d.e("0X800A281");
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.onDestroy();
        if (!MsgBackupManager.C) {
            MsgBackupManager.x().z().Q0(null);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.onDetach();
        if (f251224r0 == this) {
            f251224r0 = null;
        }
        f.B("MsgBackupMsgBackupPCConfirmFragment", "fight1111.onDetach l", new Object[0]);
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupPcBaseFragment, com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
    protected void qh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.qh();
            MsgBackupManager.x().z().Q0(this);
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupPcBaseFragment, com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
    protected void rh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.rh();
        ViewUtils.setVisible(this.F, 0);
        ViewUtils.setVisible(this.G, 8);
        ViewUtils.setVisible(this.V, 8);
        ViewUtils.setVisible(this.J, 0);
        ViewUtils.setVisible(this.V, 8);
        this.L.setText(R.string.ijf);
        this.M.setText(R.string.f170559il0);
        this.K.setImageResource(R.drawable.msg_back_up_phone_to_pc);
        this.J.setText(R.string.iis);
        if (AppSetting.f99565y) {
            this.J.setContentDescription(getString(R.string.iis));
        }
        if (this.Y == 2) {
            this.K.setImageResource(R.drawable.msg_back_up_pc_to_phone);
            this.L.setText(getActivity().getString(R.string.il9));
            this.M.setVisibility(8);
            if (AppSetting.f99565y) {
                this.J.setContentDescription(getString(R.string.il8));
            }
            this.J.setText(getActivity().getString(R.string.il8));
            d.e("0X800A280");
        }
        if (this.f251228p0) {
            this.f211174vg.setLeftBackVisible(8);
            this.f211174vg.setRightButton(R.string.f170554ij4);
        }
        this.f211174vg.setOnItemSelectListener(new a());
        if (MsgBackupManager.N) {
            d.e("0X800A254");
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
    protected void yh(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), obj);
            return;
        }
        super.yh(z16, obj);
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackupMsgBackupPCConfirmFragment", 2, "mBizType = " + this.Y);
        }
        if (z16) {
        }
    }
}
