package com.tencent.mobileqq.msgbackup.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.controller.i;
import com.tencent.mobileqq.msgbackup.data.j;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.mobileqq.msgbackup.util.d;
import com.tencent.mobileqq.msgbackup.util.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes15.dex */
public class MsgBackupPCTransportFragment extends MsgBackupPcBaseFragment {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class a implements com.tencent.mobileqq.widget.navbar.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupPCTransportFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.navbar.a
        public void onItemSelect(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            int b16 = com.tencent.mobileqq.msgbackup.authentication.a.d().b();
            if (i3 != 2) {
                if (i3 == 8) {
                    MsgBackupManager.C = true;
                    if (QLog.isColorLevel()) {
                        QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "backup is going, page is in link page! click \u6536\u8d77\u6309\u94ae! sIsShouQiBtnClick= " + MsgBackupManager.C + ", curSpeed = " + MsgBackupPCTransportFragment.this.f251173e0 + ", hasFinishedCount = " + MsgBackupPCTransportFragment.this.f251175g0);
                    }
                    MsgBackupManager.x().z().Q0(null);
                    MsgBackupManager x16 = MsgBackupManager.x();
                    MsgBackupPCTransportFragment msgBackupPCTransportFragment = MsgBackupPCTransportFragment.this;
                    x16.a0(msgBackupPCTransportFragment.f251173e0, msgBackupPCTransportFragment.f251175g0, b16, msgBackupPCTransportFragment.getQBaseActivity());
                    MsgBackupPCTransportFragment msgBackupPCTransportFragment2 = MsgBackupPCTransportFragment.this;
                    if (msgBackupPCTransportFragment2.Y == 1) {
                        if (msgBackupPCTransportFragment2.f251228p0) {
                            d.e("0X800A260");
                            return;
                        }
                        return;
                    }
                    d.e("0X800A284");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "page is in pc Link page! click cancel! bizType = " + b16 + ", pcHandler = " + MsgBackupPCTransportFragment.this.f251228p0);
            }
            MsgBackupPCTransportFragment.this.Lh();
        }
    }

    public MsgBackupPCTransportFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void Mh() {
        this.f211174vg.setLeftBackVisible(8);
        this.f211174vg.setLeftButton(R.string.ijr);
        this.f211174vg.setRightButton(R.string.f170554ij4);
        this.f211174vg.setOnItemSelectListener(new a());
        if (this.C == 2) {
            this.f211174vg.hideLeft();
        }
    }

    private void Oh() {
        TextView textView;
        this.f251229q0 = false;
        if (getActivity() != null && !getActivity().isFinishing() && (textView = this.U) != null) {
            textView.setVisibility(0);
            this.U.setTextColor(getResources().getColor(R.color.aml));
            this.U.setText(R.string.ijo);
        }
    }

    private void Ph() {
        this.f251229q0 = true;
        if (getActivity() != null && !getActivity().isFinishing()) {
            TextView textView = this.U;
            if (textView != null) {
                textView.setVisibility(0);
                this.U.setTextColor(getResources().getColor(R.color.amk));
                this.U.setText(R.string.ijl);
            }
            if (this.Y == 1) {
                d.f("0X800A264", 1);
            } else {
                d.f("0X800A287", 1);
            }
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment, com.tencent.mobileqq.msgbackup.controller.e
    public void C8(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "pc\u9000\u51fa\u4e86\uff01------------------>exit called! ");
        }
        this.W.sendMessage(this.W.obtainMessage(10008));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
    public void Fh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        super.Fh();
        if (getActivity() != null) {
            ImageView imageView = this.S;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.msg_back_up_error);
            }
            TextView textView = this.T;
            if (textView != null) {
                textView.setText(getString(R.string.ikd));
            }
            TextView textView2 = this.U;
            if (textView2 != null) {
                textView2.setTextColor(getResources().getColor(R.color.aml));
                if (this.Y == 2) {
                    this.U.setText(getString(R.string.ijp));
                } else {
                    this.U.setText(getString(R.string.iit));
                }
            }
            ViewUtils.setVisible(this.Z, 8);
            ViewUtils.setVisible(this.f251169a0, 8);
            this.f211174vg.hideLeftText();
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment, com.tencent.mobileqq.msgbackup.controller.e
    public void K8(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, j3);
            return;
        }
        super.K8(j3);
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "speedState!!! increment = " + j3 + " , isStart = " + this.f251176h0 + ", MsgBackupManager.isTransportStart = " + MsgBackupManager.P);
        }
        if (this.f251176h0 || MsgBackupManager.P) {
            this.f251173e0 = j3;
            this.W.sendMessage(this.W.obtainMessage(10002));
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupPcBaseFragment
    public void Lh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.Lh();
        if (this.f251228p0 && this.Y == 1) {
            if (this.f251229q0) {
                d.f("0X800A266", 3);
            } else if (!this.f251176h0) {
                d.f("0X800A266", 1);
            } else {
                d.f("0X800A266", 2);
            }
        }
        if (this.Y == 2) {
            if (!this.f251229q0) {
                d.f("0X800A288", 1);
            } else {
                d.f("0X800A288", 2);
            }
        }
    }

    protected void Nh(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        f.B("MsgBackup_MsgBackupPCTransportFragment", "refreshProgress is called! finishedCount = %d, total = %d", Integer.valueOf(i3), Integer.valueOf(i16));
        if (i16 == 0) {
            return;
        }
        int i17 = (i3 * 100) / i16;
        ProgressBar progressBar = this.Z;
        if (progressBar != null) {
            if (progressBar.getVisibility() != 0) {
                this.Z.setVisibility(0);
            }
            this.Z.setProgress(i17);
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment, com.tencent.mobileqq.msgbackup.controller.e
    public void cb(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        super.cb(this.f251176h0);
        this.f251176h0 = z16;
        int i3 = this.Y;
        if (i3 == 1) {
            if (this.f251228p0) {
                d.e("0X800A25F");
            }
        } else if (i3 == 2) {
            d.e("0X800A283");
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (i3 == 4) {
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "doOnKeyDown is called! KEYCODE_BACK");
            }
            Lh();
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment, android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        String string;
        int i3;
        String string2;
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) message)).booleanValue();
        }
        int i16 = message.what;
        if (i16 != 10002) {
            if (i16 != 10003) {
                if (i16 != 10007) {
                    if (i16 != 10008) {
                        if (i16 == 10014 && (textView = this.T) != null && textView.getVisibility() == 0 && !this.f251176h0) {
                            String string3 = getActivity().getString(R.string.il_);
                            int i17 = this.f251182n0 + 1;
                            this.f251182n0 = i17;
                            this.T.setText(string3.substring(0, string3.length() - (2 - (i17 % 3))));
                            this.W.removeMessages(10014);
                            this.W.sendEmptyMessageDelayed(10014, 800L);
                        }
                    } else {
                        Kh();
                    }
                } else if (message.arg1 == 1) {
                    Oh();
                } else {
                    Ph();
                }
            } else if (this.f251176h0 || MsgBackupManager.P) {
                if (this.f251180l0) {
                    this.f251180l0 = false;
                    int i18 = this.Y;
                    if (i18 == 1) {
                        this.S.setImageResource(R.drawable.msg_back_up_phone_to_pc);
                    } else if (i18 == 2) {
                        this.S.setImageResource(R.drawable.msg_back_up_pc_to_phone);
                    }
                }
                this.f211174vg.setLeftButton(R.string.ijr);
                String p16 = f.p(this.f251173e0);
                int i19 = message.arg1;
                int i26 = message.arg2;
                Nh(i19, i26);
                if (i19 != i26) {
                    i3 = i19 + 1;
                } else {
                    i3 = i19;
                }
                if (MsgBackupTransportProcessor.u().x() == 1) {
                    string2 = getActivity().getResources().getString(R.string.ilb);
                } else {
                    string2 = getActivity().getResources().getString(R.string.ila);
                }
                TextView textView2 = this.T;
                if (textView2 != null) {
                    textView2.setText(String.format(string2, Integer.valueOf(i3), Integer.valueOf(i26), p16 + "B/s"));
                }
                TextView textView3 = this.U;
                if (textView3 != null) {
                    textView3.setText(R.string.ijo);
                }
                if (i19 == i26) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "sessionCompleted->>>>>>>>");
                    }
                    MsgBackupManager.x().z().Q0(null);
                    if (MsgBackupTransportProcessor.u().x() == 1) {
                        MsgBackupCompleteFragment.yh(getActivity(), this.f251174f0, this.f251175g0);
                    } else {
                        MsgBackupCompleteFragment.Eh(getActivity(), this.f251174f0, this.f251175g0, this.f251228p0);
                    }
                }
            }
        } else if (this.f251176h0 || MsgBackupManager.P) {
            if (this.f251180l0) {
                this.f251180l0 = false;
                int i27 = this.Y;
                if (i27 == 1) {
                    this.S.setImageResource(R.drawable.msg_back_up_phone_to_pc);
                } else if (i27 == 2) {
                    this.S.setImageResource(R.drawable.msg_back_up_pc_to_phone);
                }
            }
            this.f211174vg.setLeftButton(R.string.ijr);
            String p17 = f.p(this.f251173e0);
            f.B("MsgBackup_MsgBackupPCTransportFragment", "transport speed ...xp.increaseLen = %d,compute result = %s", Long.valueOf(this.f251173e0), p17);
            int i28 = this.f251175g0;
            if (i28 != MsgBackupManager.K) {
                i28++;
            }
            if (MsgBackupTransportProcessor.u().x() == 1) {
                string = getActivity().getResources().getString(R.string.ilb);
            } else {
                string = getActivity().getResources().getString(R.string.ila);
            }
            TextView textView4 = this.T;
            if (textView4 != null) {
                textView4.setText(String.format(string, Integer.valueOf(i28), Integer.valueOf(MsgBackupManager.K), p17 + "B/s"));
            }
            TextView textView5 = this.U;
            if (textView5 != null) {
                textView5.setText(R.string.ijo);
            }
        }
        return super.handleMessage(message);
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment, com.tencent.mobileqq.msgbackup.controller.e
    public void hd(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.hd(i3, i16);
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "sessionProgress finishedSessions = " + i3 + ", totalSession = " + i16 + ", isStart = " + this.f251176h0);
        }
        if (this.f251176h0 && !this.f251177i0) {
            if (i3 == i16) {
                this.f251177i0 = true;
            }
            this.f251174f0 = i16;
            this.f251175g0 = i3;
            Message obtainMessage = this.W.obtainMessage(10003);
            obtainMessage.arg1 = i3;
            obtainMessage.arg2 = i16;
            this.W.sendMessage(obtainMessage);
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupPcBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
            return;
        }
        super.initWindowStyleAndAnimation(activity);
        if (activity != null) {
            if (this.Y != 2 && !this.f251228p0) {
                activity.overridePendingTransition(R.anim.f154724iv, R.anim.f154723iu);
            } else {
                activity.overridePendingTransition(0, 0);
            }
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupPcBaseFragment, com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        super.onDestroyView();
        if (!MsgBackupManager.C) {
            MsgBackupManager.x().I();
            MsgBackupManager.x().z().Q0(null);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.onPause();
            MsgBackupManager.x().O(getActivity());
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onResume();
        MsgBackupManager.x().D(getActivity());
        MsgBackupManager.Q = true;
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            Dh();
            super.onStop();
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment, com.tencent.mobileqq.msgbackup.controller.e
    public void qc(boolean z16) {
        Runnable runnable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
            return;
        }
        super.qc(z16);
        if (!z16 && (runnable = this.f251181m0) != null) {
            this.X.post(runnable);
        }
        Message obtainMessage = this.W.obtainMessage(10007);
        obtainMessage.arg1 = z16 ? 1 : 0;
        this.W.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupPcBaseFragment, com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
    public void qh() {
        int i3;
        long j3;
        long j16;
        Intent intent;
        String string;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.qh();
        f.b();
        this.f251174f0 = MsgBackupManager.K;
        boolean z16 = true;
        if (MsgBackupTransportProcessor.u().x() == 1) {
            this.X.postDelayed(this.f251172d0, 15000L);
        }
        int i16 = this.C;
        if (i16 != 2) {
            if (i16 == 5) {
                this.f251176h0 = true;
                this.f251173e0 = MsgBackupManager.x().v();
                MsgBackupManager.C = false;
                int w3 = MsgBackupManager.x().w();
                this.f251175g0 = w3;
                Nh(w3, this.f251174f0);
                if (w3 != MsgBackupManager.K) {
                    w3++;
                }
                if (MsgBackupTransportProcessor.u().x() == 1) {
                    string = getActivity().getResources().getString(R.string.ilb);
                } else {
                    string = getActivity().getResources().getString(R.string.ila);
                }
                if (this.T != null) {
                    String p16 = f.p(this.f251173e0);
                    this.T.setText(String.format(string, Integer.valueOf(w3), Integer.valueOf(this.f251174f0), p16 + "B/s"));
                }
                if (MsgBackupTransportProcessor.u().J()) {
                    Oh();
                } else {
                    Ph();
                }
                MsgBackupManager.x().z().Q0(this);
                if (MsgBackupTransportProcessor.u().x() == 2) {
                    if (this.f251228p0) {
                        d.e("0X800A261");
                        return;
                    }
                    return;
                }
                d.e("0X800A285");
                return;
            }
            return;
        }
        if (MsgBackupManager.x().y().b() == 1) {
            MsgBackupManager.x().z().Q0(this);
            if (this.f251228p0) {
                MsgBackupManager.x().q(this.Y, this.f251227o0);
            }
            MsgBackupManager.K = MsgBackupManager.x().f251037a.size();
            d.b();
            d.f251402a.f251377g = MsgBackupManager.K;
            i iVar = new i();
            HashSet<j> hashSet = new HashSet<>(MsgBackupManager.x().f251037a.size());
            hashSet.addAll(MsgBackupManager.x().f251037a);
            iVar.f251073a = hashSet;
            iVar.f251074b = 0;
            if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
                j3 = intent.getLongExtra("session_start_time", 0L);
                j16 = intent.getLongExtra("session_end_time", 0L);
                i3 = intent.getIntExtra("session_content_type", 1);
            } else {
                i3 = 1;
                j3 = 0;
                j16 = 0;
            }
            f.B("MsgBackup_MsgBackupPCTransportFragment", "select params startTime = %d ,endTime = %d,contentType = %d ", Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3));
            if (j3 != 0 && j16 != 0 && j3 < j16) {
                iVar.f251075c = j3;
                iVar.f251076d = j16;
                if (i3 != 2) {
                    z16 = false;
                }
                iVar.f251077e = z16;
            } else {
                iVar.f251075c = 0L;
                iVar.f251076d = Long.MAX_VALUE;
                if (i3 != 2) {
                    z16 = false;
                }
                iVar.f251077e = z16;
            }
            MsgBackupManager.x().U(iVar);
            return;
        }
        MsgBackupManager.x().z().Q0(this);
        MsgBackupManager.x().z().I0(4);
        if (this.f251228p0) {
            MsgBackupManager.x().q(this.Y, this.f251227o0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupPcBaseFragment, com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
    public void rh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.rh();
        ViewUtils.setVisible(this.D, 8);
        ViewUtils.setVisible(this.E, 8);
        ViewUtils.setVisible(this.F, 8);
        ViewUtils.setVisible(this.G, 0);
        int i3 = this.Y;
        if (i3 == 1) {
            this.S.setImageResource(R.drawable.msg_back_up_phone_to_pc);
        } else if (i3 == 2) {
            this.S.setImageResource(R.drawable.msg_back_up_pc_to_phone);
        }
        int i16 = this.C;
        if (i16 != 2) {
            if (i16 == 5) {
                Mh();
                boolean J = MsgBackupTransportProcessor.u().J();
                this.f251179k0 = J;
                if (J) {
                    Oh();
                    return;
                } else {
                    Ph();
                    return;
                }
            }
            return;
        }
        this.T.setText(R.string.il_);
        this.W.removeMessages(10014);
        this.W.sendEmptyMessageDelayed(10014, 800L);
        this.U.setText(R.string.ijo);
        Mh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
    public void yh(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Boolean.valueOf(z16), obj);
            return;
        }
        super.yh(z16, obj);
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "mBizType = " + this.Y);
        }
        if (z16) {
            com.tencent.mobileqq.msgbackup.data.a aVar = (com.tencent.mobileqq.msgbackup.data.a) obj;
            int i3 = this.Y;
            if (i3 == 1) {
                if (obj == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "processConfirmQRRsp: backup data is null!");
                        return;
                    }
                    return;
                }
                String b16 = aVar.b();
                String c16 = aVar.c();
                int a16 = aVar.a();
                List<Integer> f16 = aVar.d().f();
                if (f16.size() == 2) {
                    String b17 = aVar.d().b();
                    int intValue = f16.get(0).intValue();
                    int intValue2 = f16.get(1).intValue();
                    if (QLog.isColorLevel()) {
                        QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "processConfirmQRRsp: backup client ip = " + b17 + ", udpport = " + intValue2 + ", tcpport = " + intValue);
                    }
                    MsgBackupTransportProcessor z17 = MsgBackupManager.x().z();
                    z17.P0(b16);
                    com.tencent.mobileqq.msgbackup.authentication.a d16 = com.tencent.mobileqq.msgbackup.authentication.a.d();
                    d16.j(c16);
                    d16.h(a16);
                    z17.L0(b17);
                    z17.M0(intValue);
                    z17.N0(intValue2);
                    z17.O0(2);
                    z17.R0(2);
                    return;
                }
                return;
            }
            if (i3 == 2) {
                if (obj == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "processConfirmQRRsp: restore data is null!");
                        return;
                    }
                    return;
                }
                String b18 = aVar.b();
                String c17 = aVar.c();
                int a17 = aVar.a();
                List<Integer> f17 = aVar.d().f();
                if (f17.size() == 2) {
                    String b19 = aVar.d().b();
                    int intValue3 = f17.get(0).intValue();
                    int intValue4 = f17.get(1).intValue();
                    if (QLog.isColorLevel()) {
                        QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "processConfirmRsp: restore server ip = " + b19 + ", udpport = " + intValue4 + ", tcpport = " + intValue3);
                    }
                    MsgBackupTransportProcessor z18 = MsgBackupManager.x().z();
                    z18.P0(b18);
                    com.tencent.mobileqq.msgbackup.authentication.a d17 = com.tencent.mobileqq.msgbackup.authentication.a.d();
                    d17.j(c17);
                    d17.h(a17);
                    z18.S0(b19);
                    z18.T0(intValue3);
                    z18.U0(intValue4);
                    z18.O0(1);
                    z18.R0(1);
                }
            }
        }
    }
}
