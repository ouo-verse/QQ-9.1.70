package com.tencent.mobileqq.msgbackup.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.util.d;
import com.tencent.mobileqq.msgbackup.util.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes15.dex */
public class MsgBackupPcBaseFragment extends MsgBackupBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: o0, reason: collision with root package name */
    protected String f251227o0;

    /* renamed from: p0, reason: collision with root package name */
    protected boolean f251228p0;

    /* renamed from: q0, reason: collision with root package name */
    protected boolean f251229q0;

    /* loaded from: classes15.dex */
    class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupPcBaseFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            f.D("MsgBackup_MsgBackupPcBaseFragment", "showDisConnDialog mextra is not null! %b, isFromPcHandle = %b", Boolean.valueOf(TextUtils.isEmpty(MsgBackupPcBaseFragment.this.f251227o0)), Boolean.valueOf(MsgBackupPcBaseFragment.this.f251228p0));
            MsgBackupManager.x().z().n();
            MsgBackupManager.x().I();
            MsgBackupPcBaseFragment msgBackupPcBaseFragment = MsgBackupPcBaseFragment.this;
            if (msgBackupPcBaseFragment.f251176h0) {
                if (!msgBackupPcBaseFragment.f251228p0 && msgBackupPcBaseFragment.Y == 1) {
                    msgBackupPcBaseFragment.uh(msgBackupPcBaseFragment.getActivity());
                    return;
                } else {
                    msgBackupPcBaseFragment.Ih();
                    return;
                }
            }
            if (msgBackupPcBaseFragment.f251228p0) {
                if (msgBackupPcBaseFragment.getActivity() != null) {
                    MsgBackupPcBaseFragment.this.getActivity().setResult(1001);
                    MsgBackupPcBaseFragment.this.getActivity().finish();
                    return;
                }
                return;
            }
            msgBackupPcBaseFragment.uh(msgBackupPcBaseFragment.getActivity());
        }
    }

    /* loaded from: classes15.dex */
    class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupPcBaseFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            f.D("MsgBackup_MsgBackupPcBaseFragment", "showStopMigrateDialog mextra is not null! %b, isFromPcHandle = %b", Boolean.valueOf(TextUtils.isEmpty(MsgBackupPcBaseFragment.this.f251227o0)), Boolean.valueOf(MsgBackupPcBaseFragment.this.f251228p0));
            MsgBackupManager.x().z().n();
            MsgBackupManager.x().z().Q0(null);
            MsgBackupPcBaseFragment msgBackupPcBaseFragment = MsgBackupPcBaseFragment.this;
            if (msgBackupPcBaseFragment.f251176h0) {
                if (!msgBackupPcBaseFragment.f251228p0 && msgBackupPcBaseFragment.Y == 1) {
                    msgBackupPcBaseFragment.uh(msgBackupPcBaseFragment.getActivity());
                } else {
                    msgBackupPcBaseFragment.Ih();
                }
                MsgBackupPcBaseFragment msgBackupPcBaseFragment2 = MsgBackupPcBaseFragment.this;
                if (!msgBackupPcBaseFragment2.f251229q0) {
                    int i16 = msgBackupPcBaseFragment2.Y;
                    if (i16 == 1) {
                        if (msgBackupPcBaseFragment2.f251228p0) {
                            d.f("0X800A267", 2);
                        }
                    } else if (i16 == 2) {
                        d.f("0X800A289", 1);
                    }
                }
            } else {
                if (msgBackupPcBaseFragment.f251228p0) {
                    if (msgBackupPcBaseFragment.getActivity() != null) {
                        MsgBackupPcBaseFragment.this.getActivity().setResult(1001);
                        MsgBackupPcBaseFragment.this.getActivity().finish();
                    }
                } else {
                    msgBackupPcBaseFragment.uh(msgBackupPcBaseFragment.getActivity());
                }
                MsgBackupPcBaseFragment msgBackupPcBaseFragment3 = MsgBackupPcBaseFragment.this;
                if (!msgBackupPcBaseFragment3.f251229q0 && msgBackupPcBaseFragment3.Y == 1 && msgBackupPcBaseFragment3.f251228p0) {
                    d.f("0X800A267", 1);
                }
            }
            MsgBackupPcBaseFragment msgBackupPcBaseFragment4 = MsgBackupPcBaseFragment.this;
            if (msgBackupPcBaseFragment4.f251229q0) {
                int i17 = msgBackupPcBaseFragment4.Y;
                if (i17 == 1) {
                    if (msgBackupPcBaseFragment4.f251228p0) {
                        d.f("0X800A267", 3);
                    }
                } else if (i17 == 2) {
                    d.f("0X800A289", 2);
                }
            }
        }
    }

    /* loaded from: classes15.dex */
    class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupPcBaseFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    public MsgBackupPcBaseFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f251228p0 = false;
            this.f251229q0 = false;
        }
    }

    private void Gh() {
        if (getActivity() != null && this.f251171c0 != null) {
            getQBaseActivity().addObserver(this.f251171c0);
        }
    }

    public static void Hh(Context context, int i3) {
        Intent intent = new Intent();
        intent.putExtra("param_start", 5);
        intent.putExtra("BIZ_TYPE", i3);
        QPublicFragmentActivity.start(context, intent, MsgBackupPCTransportFragment.class);
    }

    private void Jh() {
        if (getActivity() != null && this.f251171c0 != null) {
            getQBaseActivity().removeObserver(this.f251171c0);
        }
    }

    protected void Ih() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        int i3 = this.Y;
        if (i3 == 1) {
            MsgBackupCompleteFragment.Eh(getActivity(), this.f251174f0, this.f251175g0, this.f251228p0);
        } else if (i3 == 2) {
            MsgBackupCompleteFragment.Gh(getActivity(), this.f251174f0, this.f251175g0);
        }
    }

    public void Kh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            String qqStr = HardCodeUtil.qqStr(R.string.f171151ok);
            this.Y = com.tencent.mobileqq.msgbackup.authentication.a.d().b();
            String qqStr2 = HardCodeUtil.qqStr(R.string.o_m);
            if (this.Y == 1) {
                qqStr2 = HardCodeUtil.qqStr(R.string.o_c);
            }
            DialogUtil.createCenterTextDialog(activity, 0, null, qqStr2, null, qqStr, new a(), null).show();
        }
    }

    public void Lh() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            String qqStr = HardCodeUtil.qqStr(R.string.o_p);
            String qqStr2 = HardCodeUtil.qqStr(R.string.o_b);
            int b16 = com.tencent.mobileqq.msgbackup.authentication.a.d().b();
            this.Y = b16;
            if (b16 == 2) {
                qqStr = HardCodeUtil.qqStr(R.string.o_8);
            }
            String str2 = qqStr;
            if (this.Y == 2) {
                str = HardCodeUtil.qqStr(R.string.o_d);
            } else {
                str = qqStr2;
            }
            String qqStr3 = HardCodeUtil.qqStr(R.string.o_l);
            if (this.Y == 1) {
                qqStr3 = HardCodeUtil.qqStr(R.string.o_9);
            }
            QQCustomDialog createCenterTextDialog = DialogUtil.createCenterTextDialog(activity, 0, str2, qqStr3, activity.getString(R.string.f170554ij4), str, new b(), new c());
            if (activity.isFinishing()) {
                return;
            }
            createCenterTextDialog.show();
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
    protected void initListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.initListener();
        this.J.setOnClickListener(this);
        this.V.setOnClickListener(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
            return;
        }
        super.initWindowStyleAndAnimation(activity);
        if (activity != null) {
            Intent intent = activity.getIntent();
            boolean z16 = true;
            if (intent != null) {
                this.C = intent.getIntExtra("param_start", -1);
                this.Y = intent.getIntExtra("BIZ_TYPE", 1);
                this.f251227o0 = intent.getStringExtra("0x11bpush_extra");
                if (QLog.isColorLevel()) {
                    QLog.d("MsgBackup_MsgBackupPcBaseFragment", 2, "toPage = " + this.C + "; mBizType = " + this.Y);
                }
            }
            if (TextUtils.isEmpty(this.f251227o0) && !MsgBackupManager.N) {
                z16 = false;
            }
            this.f251228p0 = z16;
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.onDestroyView();
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupPcBaseFragment", 2, "onDestroyView topage = " + this.C + ", bizType = " + com.tencent.mobileqq.msgbackup.authentication.a.d().b() + ", sIsShouQiBtnClick = " + MsgBackupManager.C);
        }
        Jh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
    public void qh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.qh();
            Gh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
    public void rh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.rh();
            f.D("MsgBackup_MsgBackupPcBaseFragment", "MsgBackupPcBaseFragment bindview is called! biztype = %d, isFromPcHandle = %b", Integer.valueOf(this.Y), Boolean.valueOf(this.f251228p0));
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
    protected void xh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.xh();
        setTitle(getActivity().getString(R.string.iiu));
        if (com.tencent.mobileqq.msgbackup.authentication.a.d().b() == 2) {
            setTitle(getActivity().getString(R.string.iir));
        }
    }
}
