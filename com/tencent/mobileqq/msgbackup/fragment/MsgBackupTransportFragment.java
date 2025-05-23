package com.tencent.mobileqq.msgbackup.fragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.mobileqq.msgbackup.util.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MsgBackupTransportFragment extends MsgBackupBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: o0, reason: collision with root package name */
    private int f251251o0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f251252p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f251253q0;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements com.tencent.mobileqq.widget.navbar.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupTransportFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.navbar.a
        public void onItemSelect(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (i3 == 2) {
                MsgBackupTransportFragment.this.Lh();
                if (QLog.isColorLevel()) {
                    QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "transfer is going, page is in link page! click cancel btn! sIsShouQiBtnClick= " + MsgBackupManager.C + ", isStart = " + MsgBackupTransportFragment.this.f251176h0);
                }
                if (MsgBackupTransportFragment.this.f251251o0 == 2) {
                    if (MsgBackupTransportFragment.this.f251180l0) {
                        com.tencent.mobileqq.msgbackup.util.d.f("0X800A243", 2);
                    } else {
                        com.tencent.mobileqq.msgbackup.util.d.f("0X800A243", 1);
                    }
                }
                MsgBackupTransportFragment msgBackupTransportFragment = MsgBackupTransportFragment.this;
                if (msgBackupTransportFragment.f251176h0) {
                    msgBackupTransportFragment.Ph();
                    return;
                } else if (msgBackupTransportFragment.f251251o0 == 1) {
                    MsgBackupTransportFragment.this.onBackEvent();
                    return;
                } else {
                    MsgBackupTransportFragment msgBackupTransportFragment2 = MsgBackupTransportFragment.this;
                    msgBackupTransportFragment2.uh(msgBackupTransportFragment2.getActivity());
                    return;
                }
            }
            if (i3 == 8) {
                MsgBackupManager.C = true;
                if (QLog.isColorLevel()) {
                    QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "transfer is going, page is in link page! click \u6536\u8d77\u6309\u94ae! sIsShouQiBtnClick= " + MsgBackupManager.C + ", curSpeed = " + MsgBackupTransportFragment.this.f251173e0 + ", hasFinishedCount = " + MsgBackupTransportFragment.this.f251175g0);
                }
                MsgBackupManager x16 = MsgBackupManager.x();
                MsgBackupTransportFragment msgBackupTransportFragment3 = MsgBackupTransportFragment.this;
                x16.a0(msgBackupTransportFragment3.f251173e0, msgBackupTransportFragment3.f251175g0, 3, msgBackupTransportFragment3.getQBaseActivity());
                com.tencent.mobileqq.msgbackup.util.d.e("0X800A249");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupTransportFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            int x16 = MsgBackupTransportProcessor.u().x();
            if (1 == x16) {
                MsgBackupTransportFragment.this.Ih();
                if (MsgBackupTransportFragment.this.f251176h0) {
                    com.tencent.mobileqq.msgbackup.util.d.f("0X800A253", 3);
                    return;
                } else {
                    com.tencent.mobileqq.msgbackup.util.d.f("0X800A253", 1);
                    return;
                }
            }
            if (2 == x16) {
                if (MsgBackupTransportFragment.this.f251180l0) {
                    com.tencent.mobileqq.msgbackup.util.d.f("0X800A244", 2);
                } else {
                    com.tencent.mobileqq.msgbackup.util.d.f("0X800A244", 1);
                }
                MsgBackupTransportFragment.this.Ih();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupTransportFragment.this);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupTransportFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            MsgBackupManager.x().z().n();
            MsgBackupManager.x().I();
            MsgBackupTransportFragment msgBackupTransportFragment = MsgBackupTransportFragment.this;
            if (msgBackupTransportFragment.f251176h0) {
                msgBackupTransportFragment.sh();
            } else {
                msgBackupTransportFragment.uh(msgBackupTransportFragment.getActivity());
            }
        }
    }

    public MsgBackupTransportFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f251253q0 = true;
        }
    }

    private void Jh(com.tencent.mobileqq.msgbackup.data.a aVar) {
        if (aVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "processConfirmRsp confim qr, data is null!");
                return;
            }
            return;
        }
        String b16 = aVar.b();
        String b17 = aVar.b();
        int a16 = aVar.a();
        String b18 = aVar.d().b();
        List<Integer> f16 = aVar.d().f();
        if (f16.size() == 2) {
            int intValue = f16.get(0).intValue();
            int intValue2 = f16.get(1).intValue();
            QLog.d("MsgBackup.MsgBackupTransportFragment", 1, "processConfirmRsp: server ip = " + b18 + ", udpport = " + intValue2 + ", tcpport = " + intValue);
            QLog.d("MsgBackup.MsgBackupTransportFragment", 1, "\u626b\u7801\u6210\u529f\u4e86\uff0c\u53ef\u4ee5\u53d1\u8d77\u76f4\u8fde\u4e86\uff01");
            MsgBackupManager x16 = MsgBackupManager.x();
            if (x16 != null) {
                MsgBackupTransportProcessor z16 = x16.z();
                z16.P0(b16);
                x16.y().h(a16);
                x16.y().j(b17);
                z16.S0(b18);
                z16.T0(intValue);
                z16.U0(intValue2);
                z16.O0(1);
                z16.R0(1);
                z16.I0(1);
                return;
            }
            QLog.e("MsgBackup.MsgBackupTransportFragment", 2, "processConfirmRsp: MsgBackupManager is null!", new Throwable());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lh() {
        int i3 = 1;
        if (this.f251251o0 == 1) {
            if (!this.f251253q0) {
                i3 = 6;
            } else if (this.f251176h0) {
                i3 = 3;
            }
            com.tencent.mobileqq.msgbackup.util.d.f("0X800A252", i3);
        }
    }

    private void Mh() {
        TextView textView;
        if (getActivity() != null && !getActivity().isFinishing() && (textView = this.U) != null) {
            textView.setVisibility(0);
            this.U.setTextColor(getResources().getColor(R.color.aml));
            this.U.setText(R.string.ijo);
        }
    }

    private void Oh() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            TextView textView = this.U;
            if (textView != null) {
                textView.setVisibility(0);
                this.U.setTextColor(getResources().getColor(R.color.amk));
                this.U.setText(R.string.ijl);
            }
            if (this.f251251o0 == 2) {
                com.tencent.mobileqq.msgbackup.util.d.f("0X800A241", 1);
            } else {
                com.tencent.mobileqq.msgbackup.util.d.f("0X800A250", 1);
            }
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment, com.tencent.mobileqq.msgbackup.controller.e
    public void C8(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
            return;
        }
        super.C8(z16);
        this.W.sendMessage(this.W.obtainMessage(10008));
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
    protected void Eh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        super.Eh();
        if (this.f251251o0 == 1) {
            com.tencent.mobileqq.msgbackup.util.d.f("0X800A250", 6);
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
    protected void Fh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
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
                this.U.setText(getString(R.string.ikc));
            }
            ViewUtils.setVisible(this.Z, 8);
            ViewUtils.setVisible(this.f251169a0, 8);
            this.f211174vg.hideLeftText();
            if (this.f251251o0 == 1 && !this.f251176h0) {
                com.tencent.mobileqq.msgbackup.util.d.f("0X800A241", 2);
            }
        }
    }

    protected void Ih() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        MsgBackupManager.x().z().n();
        MsgBackupManager.x().z().Q0(null);
        vh();
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment, com.tencent.mobileqq.msgbackup.controller.e
    public void K8(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, j3);
            return;
        }
        super.K8(j3);
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "speedState!!! increment = " + j3 + " , isStart = " + this.f251176h0 + ", MsgBackupManager.isTransportStart = " + MsgBackupManager.P);
        }
        if (this.f251176h0 || MsgBackupManager.P) {
            this.f251173e0 = j3;
            this.W.sendMessage(this.W.obtainMessage(10002));
        }
    }

    protected void Kh(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        f.B("MsgBackup.MsgBackupTransportFragment", "refreshProgress is called! finishedCount = %d, total = %d", Integer.valueOf(i3), Integer.valueOf(i16));
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

    public void Nh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            DialogUtil.createCenterTextDialog(activity, 0, null, HardCodeUtil.qqStr(R.string.o_2), null, HardCodeUtil.qqStr(R.string.o_a), new d(), null).show();
        }
    }

    protected void Ph() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            DialogUtil.createCenterTextDialog(activity, 0, activity.getString(R.string.ik7), activity.getString(R.string.f170558ik3), activity.getString(R.string.ik5), activity.getString(R.string.ik6), new b(), new c()).show();
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment, com.tencent.mobileqq.msgbackup.controller.e
    public void cb(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
            return;
        }
        super.cb(z16);
        this.f251176h0 = z16;
        if (this.f251251o0 == 2) {
            com.tencent.mobileqq.msgbackup.util.d.e("0X800A23D");
        } else {
            com.tencent.mobileqq.msgbackup.util.d.e("0X800A248");
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (i3 == 4) {
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "doOnKeyDown! ------>KEYCODE_BACK");
            }
            if (this.f251176h0) {
                Ph();
            } else if (this.f251251o0 == 1) {
                onBackEvent();
            } else {
                uh(getActivity());
            }
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment, android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        String string;
        String str;
        int i3;
        String string2;
        String str2;
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) message)).booleanValue();
        }
        int i16 = message.what;
        if (i16 != 10002) {
            if (i16 != 10003) {
                if (i16 != 10007) {
                    if (i16 != 10008) {
                        if (i16 == 10014 && (textView = this.T) != null && textView.getVisibility() == 0 && !this.f251176h0) {
                            String string3 = getActivity().getString(R.string.f170557ik2);
                            int i17 = this.f251182n0 + 1;
                            this.f251182n0 = i17;
                            String substring = string3.substring(0, string3.length() - (2 - (i17 % 3)));
                            f.B("MsgBackup.MsgBackupTransportFragment", "refreshThreeDot text = %s,threeIdottime = %d", substring, Integer.valueOf(this.f251182n0));
                            this.T.setText(substring);
                            this.W.removeMessages(10014);
                            this.W.sendEmptyMessageDelayed(10014, 800L);
                        }
                    } else {
                        Nh();
                    }
                } else if (message.arg1 == 1) {
                    Mh();
                } else {
                    Oh();
                }
            } else {
                if (this.f251176h0 && MsgBackupManager.x().z().x() != 2) {
                    this.f211174vg.setLeftButton(R.string.ijr);
                }
                if (this.f251176h0 || MsgBackupManager.P) {
                    if (this.f251180l0) {
                        this.f251180l0 = false;
                        ImageView imageView = this.S;
                        if (imageView != null) {
                            if (this.f251251o0 == 1) {
                                imageView.setImageResource(R.drawable.msg_back_up_migrate_receive);
                            } else {
                                imageView.setImageResource(R.drawable.msg_back_up_migrate_send);
                            }
                        }
                    }
                    String p16 = f.p(this.f251173e0);
                    int i18 = message.arg1;
                    int i19 = message.arg2;
                    Kh(i18, i19);
                    if (i18 != i19) {
                        i3 = i18 + 1;
                    } else {
                        i3 = i18;
                    }
                    if (MsgBackupTransportProcessor.u().x() == 1) {
                        string2 = getString(R.string.ikb);
                        str2 = i3 + "/" + MsgBackupManager.K;
                    } else {
                        string2 = getString(R.string.ike);
                        str2 = i3 + "/" + MsgBackupManager.K;
                    }
                    TextView textView2 = this.T;
                    if (textView2 != null) {
                        textView2.setText(String.format(string2, str2, p16 + "B/s"));
                    }
                    TextView textView3 = this.U;
                    if (textView3 != null) {
                        textView3.setVisibility(0);
                        this.U.setText(R.string.ijo);
                    }
                    if (i18 == i19) {
                        if (QLog.isColorLevel()) {
                            QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "sessionCompleted!!!>>>>>>>>>>>");
                        }
                        if (MsgBackupTransportProcessor.u().x() == 2) {
                            MsgBackupCompleteFragment.Ah(getActivity(), this.f251174f0, this.f251175g0);
                        } else {
                            MsgBackupCompleteFragment.wh(getActivity(), this.f251174f0, this.f251175g0);
                        }
                    }
                }
            }
        } else {
            if (this.f251176h0 && MsgBackupManager.x().z().x() != 2) {
                this.f211174vg.setLeftButton(R.string.ijr);
            }
            if (this.f251176h0 || MsgBackupManager.P) {
                if (this.f251180l0) {
                    this.f251180l0 = false;
                    ImageView imageView2 = this.S;
                    if (imageView2 != null) {
                        if (this.f251251o0 == 1) {
                            imageView2.setImageResource(R.drawable.msg_back_up_migrate_receive);
                        } else {
                            imageView2.setImageResource(R.drawable.msg_back_up_migrate_send);
                        }
                    }
                }
                String p17 = f.p(this.f251173e0);
                f.B("MsgBackup.MsgBackupTransportFragment", "transport speed ...xp.increaseLen = %d,compute result = %s", Long.valueOf(this.f251173e0), p17);
                int i26 = this.f251175g0;
                if (i26 != MsgBackupManager.K) {
                    i26++;
                }
                if (MsgBackupTransportProcessor.u().x() == 1) {
                    string = getString(R.string.ikb);
                    str = i26 + "/" + MsgBackupManager.K;
                } else {
                    string = getString(R.string.ike);
                    str = i26 + "/" + MsgBackupManager.K;
                }
                String format = String.format(string, str, p17 + "B/s");
                TextView textView4 = this.T;
                if (textView4 != null) {
                    textView4.setText(format);
                }
                TextView textView5 = this.U;
                if (textView5 != null) {
                    textView5.setVisibility(0);
                    this.U.setText(R.string.ijo);
                }
            }
        }
        return super.handleMessage(message);
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment, com.tencent.mobileqq.msgbackup.controller.e
    public void hd(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.hd(i3, i16);
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "sessionProgress!!! finishedSessions = " + i3 + ", totalSession" + i16 + ", start = " + this.f251176h0);
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

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
            return;
        }
        super.initWindowStyleAndAnimation(activity);
        if (activity != null) {
            activity.overridePendingTransition(R.anim.f154724iv, R.anim.f154723iu);
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
            QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "onDestroyView");
        }
        if (getActivity() != null && this.f251171c0 != null) {
            ((BaseQQAppInterface) getQBaseActivity().getAppRuntime()).removeObserver(this.f251171c0);
        }
        MsgBackupManager x16 = MsgBackupManager.x();
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "onDestroy called! MsgBackupManager.sIsShouQiBtnClick = " + MsgBackupManager.C + ", topage = " + this.C);
        }
        if (!MsgBackupManager.C) {
            x16.I();
            MsgBackupManager.O = false;
            if (MsgBackupTransportProcessor.u().x() == 2) {
                if (QLog.isColorLevel()) {
                    QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "onDestroyView: MBR ROLE_SERVER");
                }
                x16.G();
            }
            x16.z().Q0(null);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            super.onPause();
            MsgBackupManager.x().O(getActivity());
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        super.onResume();
        f.B("MsgBackup.MsgBackupTransportFragment", "onResume is called!", new Object[0]);
        MsgBackupManager.x().D(getActivity());
        MsgBackupManager.Q = true;
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else {
            Dh();
            super.onStop();
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment, com.tencent.mobileqq.msgbackup.controller.e
    public void qc(boolean z16) {
        Runnable runnable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
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

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
    protected void qh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.qh();
        this.f251174f0 = MsgBackupManager.K;
        f.b();
        if (MsgBackupTransportProcessor.u().x() == 1) {
            this.X.postDelayed(this.f251172d0, 15000L);
        }
        f.C("MsgBackup.MsgBackupTransportFragment-loadData ..start toPage = %d", Integer.valueOf(this.C));
        int i3 = this.C;
        if (i3 == 4) {
            if (this.f251171c0 != null) {
                ((BaseQQAppInterface) getQBaseActivity().getAppRuntime()).removeObserver(this.f251171c0);
            }
            MsgBackupManager x16 = MsgBackupManager.x();
            x16.z().Q0(this);
            ((BaseQQAppInterface) getQBaseActivity().getAppRuntime()).addObserver(this.f251171c0);
            String stringExtra = getActivity().getIntent().getStringExtra("msgbackup_qr_sig");
            if (!TextUtils.isEmpty(stringExtra)) {
                String[] split = stringExtra.split("qr_sig=");
                if (QLog.isColorLevel()) {
                    QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "scan QRCode sig = " + split[1]);
                }
                x16.y().i(split[1]);
                x16.y().h(3);
                x16.r();
                MsgBackupManager.H = true;
                if (QLog.isColorLevel()) {
                    QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "MsgBackupManager.sIsTranferingStatus = " + MsgBackupManager.H);
                }
                this.f251252p0 = false;
                if (NetworkUtil.getSystemNetwork(getActivity()) != 1) {
                    com.tencent.mobileqq.msgbackup.util.d.f("0X800A245", 2);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("MsgBackup.MsgBackupTransportFragment", 2, "server recv  qrCode callback page status....!");
            }
            TextView textView = this.T;
            if (textView != null) {
                textView.setText(getActivity().getString(R.string.f170557ik2));
                this.W.removeMessages(10014);
                this.W.sendEmptyMessageDelayed(10014, 800L);
            }
            this.f251252p0 = true;
            return;
        }
        if (i3 == 5) {
            this.f251176h0 = true;
            this.f251173e0 = MsgBackupManager.x().v();
            Kh(this.f251175g0, this.f251174f0);
            if (this.f251171c0 != null) {
                ((BaseQQAppInterface) getQBaseActivity().getAppRuntime()).removeObserver(this.f251171c0);
            }
            if (MsgBackupTransportProcessor.u().J()) {
                Mh();
            } else {
                Oh();
            }
            MsgBackupManager.x().z().Q0(this);
            ((BaseQQAppInterface) getQBaseActivity().getAppRuntime()).addObserver(this.f251171c0);
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
    protected void rh() {
        String string;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.rh();
        this.G.setVisibility(0);
        if (this.C == 4) {
            ImageView imageView = this.S;
            if (imageView != null) {
                if (this.f251251o0 == 1) {
                    imageView.setImageResource(R.drawable.msg_back_up_migrate_receive);
                } else {
                    imageView.setImageResource(R.drawable.msg_back_up_migrate_send);
                }
            }
            TextView textView = this.T;
            if (textView != null) {
                textView.setText(getActivity().getResources().getString(R.string.f170557ik2));
                this.W.removeMessages(10014);
                this.W.sendEmptyMessageDelayed(10014, 800L);
            }
            TextView textView2 = this.U;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            if (this.f251251o0 == 1) {
                com.tencent.mobileqq.msgbackup.util.d.e("0X800A246");
            }
        }
        if (this.C == 5) {
            ImageView imageView2 = this.S;
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.msg_back_up_migrate_receive);
            }
            MsgBackupManager.C = false;
            int w3 = MsgBackupManager.x().w();
            this.f251175g0 = w3;
            if (w3 != MsgBackupManager.K) {
                w3++;
            }
            if (MsgBackupTransportProcessor.u().x() == 1) {
                string = getActivity().getResources().getString(R.string.ikb);
                str = w3 + "/" + MsgBackupManager.K;
            } else {
                string = getActivity().getResources().getString(R.string.ike);
                str = w3 + "/" + MsgBackupManager.K;
            }
            if (this.T != null) {
                String p16 = f.p(this.f251173e0);
                this.T.setText(String.format(string, str, p16 + "/S"));
            }
            TextView textView3 = this.U;
            if (textView3 != null) {
                textView3.setText(R.string.ijo);
            }
            com.tencent.mobileqq.msgbackup.util.d.e("0X800A24A");
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
        String stringExtra = getActivity().getIntent().getStringExtra("msgbackup_qr_sig");
        this.f251251o0 = MsgBackupTransportProcessor.u().x();
        if (!TextUtils.isEmpty(stringExtra)) {
            this.f251251o0 = 1;
        }
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.C = intent.getIntExtra("param_start", -1);
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "toPage = " + this.C + "; mBizType = " + this.Y);
            }
        }
        int i3 = this.C;
        if (i3 == 4 || i3 == 5) {
            setTitle(getActivity().getString(R.string.ijj));
            this.f211174vg.setLeftBackVisible(8);
            this.f211174vg.setRightButton(R.string.f170554ij4);
            this.f211174vg.setLeftButton(R.string.ijr);
            if (this.C == 4 || MsgBackupManager.x().z().x() == 2) {
                this.f211174vg.hideLeft();
            }
            this.f211174vg.setOnItemSelectListener(new a());
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment
    protected void yh(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 3;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), obj);
            return;
        }
        super.yh(z16, obj);
        this.f251253q0 = true;
        this.f251251o0 = MsgBackupTransportProcessor.u().x();
        if (z16) {
            com.tencent.mobileqq.msgbackup.data.a aVar = (com.tencent.mobileqq.msgbackup.data.a) obj;
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "onConfirmQrResponse: " + aVar + ", isSuccess: " + z16);
            }
            Jh(aVar);
            return;
        }
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            f.B("MsgBackup.MsgBackupTransportFragment", "processConfirmQRRsp  result = %d", Integer.valueOf(intValue));
            if (intValue == 1006) {
                Ch(this.T, getString(R.string.ijs));
                ViewUtils.setVisible(this.f251169a0, 8);
                this.f251253q0 = false;
            } else {
                i3 = 6;
                if (intValue == 1021) {
                    Ch(this.T, getString(R.string.ijt));
                    ViewUtils.setVisible(this.f251169a0, 8);
                } else if (intValue == 1022) {
                    Ch(this.T, getString(R.string.ijv));
                    ViewUtils.setVisible(this.f251169a0, 8);
                    i3 = 1;
                }
            }
            ImageView imageView = this.S;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.msg_back_up_warning);
            }
            this.W.removeMessages(10014);
            if (this.f251251o0 == 1) {
                com.tencent.mobileqq.msgbackup.util.d.f("0X800A245", i3);
            }
        }
    }
}
