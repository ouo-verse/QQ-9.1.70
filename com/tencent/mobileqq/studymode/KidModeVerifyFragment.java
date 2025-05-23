package com.tencent.mobileqq.studymode;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.pwdverify.StudyPwdSetFragment;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class KidModeVerifyFragment extends IphoneTitleBarFragment implements View.OnClickListener, TextWatcher {
    static IPatchRedirector $redirector_;
    public static int L;
    public static long M;
    private QQAppInterface C;
    private ClearableEditText D;
    private Button E;
    private TextView F;
    private TextView G;
    public boolean H;
    private KidModeObserver I;
    private Runnable J;
    private Handler K;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends KidModeObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) KidModeVerifyFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver
        public void f(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
                return;
            }
            BaseActivity baseActivity = KidModeVerifyFragment.this.getBaseActivity();
            if (baseActivity != null && !baseActivity.isFinishing()) {
                int i3 = bundle.getInt("REQ_RESULT");
                if (i3 != 0) {
                    KidModeVerifyFragment.this.F.setEnabled(true);
                    if (i3 == 85) {
                        f.a(baseActivity, HardCodeUtil.qqStr(R.string.wmv), 1);
                        return;
                    } else if (i3 == 84) {
                        KidModeVerifyFragment.this.restartTimer(bundle.getInt("RESENT_INTERVAL_TIMEOUT", 0));
                        return;
                    } else {
                        f.a(baseActivity, HardCodeUtil.qqStr(R.string.g0j), 1);
                        return;
                    }
                }
                ea.y2("sp_key_count_time", Long.valueOf(NetConnInfoCenter.getServerTime()));
                QLog.i("KidModeVerifyFragment", 1, "onSendSmsCodeSuccess res=" + i3);
                int i16 = bundle.getInt("RESENT_INTERVAL_TIMEOUT", 0);
                if (i16 <= 0) {
                    i16 = 60;
                }
                KidModeVerifyFragment.this.G.setVisibility(0);
                KidModeVerifyFragment.this.restartTimer(i16);
            }
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver
        public void g(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), bundle);
                return;
            }
            BaseActivity baseActivity = KidModeVerifyFragment.this.getBaseActivity();
            if (baseActivity != null && !baseActivity.isFinishing()) {
                QLog.i("KidModeVerifyFragment", 1, "onVerifySmsCodeSuccess activity isSuccess=" + z16 + ",isSendSmsTokenRequest=" + KidModeVerifyFragment.this.H);
                KidModeVerifyFragment kidModeVerifyFragment = KidModeVerifyFragment.this;
                if (!kidModeVerifyFragment.H) {
                    return;
                }
                kidModeVerifyFragment.H = false;
                if (!z16) {
                    f.a(baseActivity, HardCodeUtil.qqStr(R.string.ibz), 1);
                    return;
                } else {
                    kidModeVerifyFragment.Ah();
                    return;
                }
            }
            QLog.i("KidModeVerifyFragment", 1, "onSendSmsTokenSuccess activity is finishing.");
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver
        public void k(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), bundle);
                return;
            }
            BaseActivity baseActivity = KidModeVerifyFragment.this.getBaseActivity();
            if (baseActivity != null && !baseActivity.isFinishing()) {
                if (!z16) {
                    QLog.i("KidModeVerifyFragment", 1, "onVerifySmsCodeSuccess is not success.");
                    f.a(baseActivity, HardCodeUtil.qqStr(R.string.ibz), 1);
                    return;
                }
                int i3 = bundle.getInt("SMS_TOKEN_TYPE");
                byte[] byteArray = bundle.getByteArray("SMS_TOKEN");
                if (byteArray == null) {
                    QLog.i("KidModeVerifyFragment", 1, "onVerifySmsCodeSuccess bytes == null");
                    f.a(baseActivity, HardCodeUtil.qqStr(R.string.ibz), 1);
                    return;
                } else {
                    QLog.i("KidModeVerifyFragment", 1, "onVerifySmsCodeSuccess sendSmsTokenRequest");
                    KidModeVerifyFragment kidModeVerifyFragment = KidModeVerifyFragment.this;
                    kidModeVerifyFragment.H = true;
                    KidModeServlet.u(kidModeVerifyFragment.C, "86", "", i3, byteArray);
                    return;
                }
            }
            QLog.i("KidModeVerifyFragment", 1, "onVerifySmsCodeSuccess activity is finishing.");
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements Handler.Callback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) KidModeVerifyFragment.this);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75686);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            L = 1;
        }
    }

    public KidModeVerifyFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.H = false;
        this.I = new a();
        this.J = new Runnable() { // from class: com.tencent.mobileqq.studymode.KidModeVerifyFragment.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KidModeVerifyFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                int i3 = KidModeVerifyFragment.L;
                if (i3 <= 1) {
                    KidModeVerifyFragment.this.F.setText(R.string.f171060wn2);
                    KidModeVerifyFragment.this.F.setEnabled(true);
                    KidModeVerifyFragment.this.F.setClickable(true);
                } else {
                    KidModeVerifyFragment.L = i3 - 1;
                    KidModeVerifyFragment.this.F.setText(KidModeVerifyFragment.this.yh(KidModeVerifyFragment.L));
                    if (KidModeVerifyFragment.this.getBaseActivity() != null && !KidModeVerifyFragment.this.getBaseActivity().isFinishing()) {
                        KidModeVerifyFragment.this.K.postDelayed(this, 1000L);
                    }
                }
            }
        };
        this.K = new Handler(Looper.getMainLooper(), new b());
    }

    private void Bh() {
        if (!NetworkUtil.isNetSupport(getBaseActivity())) {
            f.a(getBaseActivity(), getString(R.string.b3j), 1);
        } else {
            QLog.i("KidModeVerifyFragment", 1, "startGetVerifyCode");
            KidModeServlet.t(this.C, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restartTimer(int i3) {
        this.F.setEnabled(false);
        this.F.setClickable(false);
        L = i3;
        M = System.currentTimeMillis();
        this.F.setText(yh(i3));
        this.K.postDelayed(this.J, 1000L);
    }

    private void xh() {
        String str;
        if (!NetworkUtil.isNetSupport(getBaseActivity())) {
            f.a(getBaseActivity(), getString(R.string.b3j), 1);
            return;
        }
        Editable text = this.D.getText();
        if (text != null) {
            str = text.toString().trim();
        } else {
            str = "";
        }
        if (str.length() > 0) {
            QLog.i("KidModeVerifyFragment", 1, "commitSmsCode smsCode=" + str);
            KidModeServlet.v(this.C, str);
            return;
        }
        f.a(getBaseActivity(), HardCodeUtil.qqStr(R.string.fz6), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String yh(int i3) {
        return HardCodeUtil.qqStr(R.string.f171060wn2) + "(" + i3 + ")";
    }

    private void zh(int i3) {
        this.G = (TextView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.kes);
        ClearableEditText clearableEditText = (ClearableEditText) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.fcb);
        this.D = clearableEditText;
        clearableEditText.addTextChangedListener(this);
        this.D.setHint(R.string.wn5);
        Button button = (Button) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.b7p);
        this.E = button;
        button.setText(R.string.f171058wn1);
        this.E.setOnClickListener(this);
        this.G.setText(getString(R.string.wmw, StudyModeManager.r()));
        TextView textView = (TextView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.aji);
        this.F = textView;
        textView.setOnClickListener(this);
        if (i3 != 0 && i3 != 84) {
            this.F.setText(getString(R.string.f171059wn3));
        } else {
            this.F.setText(getString(R.string.f171060wn2));
        }
        if (AppSetting.f99565y) {
            this.E.setContentDescription(getString(R.string.f171151ok));
            this.F.setContentDescription(getString(R.string.f171060wn2));
        }
    }

    protected void Ah() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            QLog.i("KidModeVerifyFragment", 1, "jumpToKidModelSetPwd activity == null");
            return;
        }
        Intent intent = baseActivity.getIntent();
        if (intent == null) {
            QLog.i("KidModeVerifyFragment", 1, "jumpToKidModelSetPwd intent == null");
            return;
        }
        int intExtra = intent.getIntExtra("ExtraTargetAction", -1);
        QLog.i("KidModeVerifyFragment", 1, "jumpToKidModelSetPwd action=" + intExtra);
        if (intExtra == -1) {
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("ExtraTargetAction", intExtra);
        if (intExtra == 1) {
            QPublicFragmentActivity.start(baseActivity, intent2, StudyPwdSetFragment.class);
            baseActivity.finish();
        } else {
            QPublicFragmentActivity.startForResult(baseActivity, intent2, (Class<? extends QPublicBaseFragment>) StudyPwdSetFragment.class, 2);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) editable);
        } else if (editable.toString().length() >= 4) {
            this.E.setEnabled(true);
        } else {
            this.E.setEnabled(false);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    protected void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        if (this.C != null) {
            Intent intent = getBaseActivity().getIntent();
            int intExtra = intent.getIntExtra("FIRST_TIME_RES", 0);
            zh(intExtra);
            if (intExtra == 0 || intExtra == 84) {
                restartTimer(intent.getIntExtra("COUNT_TIME", 0));
            }
        }
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    protected int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.layout.f168798au3;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @androidx.annotation.Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        QLog.i("KidModeVerifyFragment", 1, "doOnActivityResult requestCode=" + i3 + ",resultCode=" + i16);
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null && !baseActivity.isFinishing()) {
            if (i3 == 2) {
                baseActivity.setResult(i16, new Intent());
                baseActivity.finish();
                return;
            }
            return;
        }
        QLog.i("KidModeVerifyFragment", 1, "onActivityResult activity == null || activity.isFinishing()");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.b7p) {
                xh();
            } else if (id5 == R.id.aji && L <= 1) {
                Bh();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        Intent intent = getBaseActivity().getIntent();
        if (getBaseActivity().getAppRuntime() instanceof QQAppInterface) {
            QQAppInterface qQAppInterface = (QQAppInterface) getBaseActivity().getAppRuntime();
            this.C = qQAppInterface;
            qQAppInterface.registObserver(this.I);
        }
        long longValue = ((Long) ea.j("sp_key_count_time", -1L)).longValue();
        long serverTime = NetConnInfoCenter.getServerTime();
        if (longValue != -1) {
            long j3 = serverTime - longValue;
            if (j3 < 60) {
                int i3 = 60 - ((int) j3);
                L = i3;
                intent.putExtra("COUNT_TIME", i3);
                intent.putExtra("FIRST_TIME_RES", 84);
                ReportController.o(this.C, "dc00898", "", "", "0X800B3D3", "0X800B3D3", 0, 0, "", "", "", "");
            }
        }
        L = 0;
        ReportController.o(this.C, "dc00898", "", "", "0X800B3D3", "0X800B3D3", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    protected View onCreateCenterView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        View onCreateCenterView = super.onCreateCenterView();
        setTitle(HardCodeUtil.qqStr(R.string.f171061wn4));
        return onCreateCenterView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onDestroy();
            this.C.unRegistObserver(this.I);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            super.onResume();
            this.K.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.studymode.KidModeVerifyFragment.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KidModeVerifyFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    BaseActivity baseActivity = KidModeVerifyFragment.this.getBaseActivity();
                    if (baseActivity != null) {
                        ((InputMethodManager) baseActivity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(KidModeVerifyFragment.this.D, 0);
                    }
                }
            }, 100L);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }
}
