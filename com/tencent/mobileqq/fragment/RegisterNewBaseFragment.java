package com.tencent.mobileqq.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LoadingUtil;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes12.dex */
public class RegisterNewBaseFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;
    protected QBaseActivity C;
    AppRuntime D;
    protected View E;
    public String F;
    public String G;
    public MqqHandler H;
    protected Dialog I;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.fragment.RegisterNewBaseFragment$3, reason: invalid class name */
    /* loaded from: classes12.dex */
    class AnonymousClass3 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f211219d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f211220e;
        final /* synthetic */ RegisterNewBaseFragment this$0;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.fragment.RegisterNewBaseFragment$3$a */
        /* loaded from: classes12.dex */
        class a implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                } else {
                    dialogInterface.dismiss();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.this$0.C, 230);
            createCustomDialog.setTitle(this.f211219d);
            createCustomDialog.setMessage(this.f211220e);
            createCustomDialog.setPositiveButton(R.string.f211255kb, new a());
            createCustomDialog.show();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends MqqHandler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RegisterNewBaseFragment.this);
            }
        }

        @Override // mqq.os.MqqHandler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            } else if (message.what == 2004) {
                RegisterNewBaseFragment.this.rh();
                RegisterNewBaseFragment.this.finishActivity();
            }
        }
    }

    public RegisterNewBaseFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.F = "";
        this.G = "86";
        this.H = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void xh(int i3) {
        try {
            Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(this.C, HardCodeUtil.qqStr(i3), false);
            this.I = showLoadingDialog;
            if (showLoadingDialog != null) {
                showLoadingDialog.show();
            }
        } catch (OutOfMemoryError e16) {
            QLog.e(QPublicBaseFragment.TAG, 1, "createWaitingDialog error", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ah(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
            return;
        }
        ProgressBar progressBar = (ProgressBar) th(R.id.i6i);
        if (progressBar == null) {
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        progressBar.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (TextUtils.isEmpty(this.F)) {
            QLog.e(QPublicBaseFragment.TAG, 1, "setTitleHint error: phoneNum is empty, set phone number before calling this method!");
            return;
        }
        TextView textView = (TextView) this.E.findViewById(R.id.kes);
        String vh5 = vh();
        String string = getString(R.string.g1s, vh5);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.C, R.color.qui_common_feedback_warning)), string.indexOf(vh5), string.indexOf(vh5) + vh5.length(), 33);
        textView.setText(spannableString);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ch(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        TextView textView = (TextView) th(R.id.ke5);
        if (textView == null) {
            return;
        }
        textView.setText(getResources().getString(i3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finishActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        QBaseActivity qBaseActivity = this.C;
        if (qBaseActivity == null) {
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) qBaseActivity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.C.getWindow().getDecorView().getWindowToken(), 0);
        }
        this.C.finish();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        AppRuntime appRuntime = this.D;
        if (appRuntime != null) {
            com.tencent.mobileqq.loginregister.z.s(appRuntime, getClass());
        }
        super.onDestroyView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean qh(Editable editable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) editable)).booleanValue();
        }
        if (TextUtils.isEmpty(editable)) {
            return false;
        }
        String str = this.G;
        if ((str == null || str.equals("86")) && editable.length() != 11) {
            return false;
        }
        return true;
    }

    public void rh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            this.H.post(new Runnable() { // from class: com.tencent.mobileqq.fragment.RegisterNewBaseFragment.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RegisterNewBaseFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        Dialog dialog = RegisterNewBaseFragment.this.I;
                        if (dialog != null && dialog.isShowing()) {
                            RegisterNewBaseFragment.this.I.dismiss();
                        }
                        RegisterNewBaseFragment.this.I = null;
                    } catch (Exception e16) {
                        QLog.e(QPublicBaseFragment.TAG, 1, "dialog dismiss exception", e16);
                    }
                }
            });
        }
    }

    public void sh(final int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
            return;
        }
        try {
            this.H.post(new Runnable() { // from class: com.tencent.mobileqq.fragment.ae
                @Override // java.lang.Runnable
                public final void run() {
                    RegisterNewBaseFragment.this.xh(i3);
                }
            });
        } catch (Exception e16) {
            QLog.e(QPublicBaseFragment.TAG, 1, "createWaitingDialog exception", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public <T extends View> T th(@IdRes int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (T) iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
        View view = this.E;
        if (view == null) {
            return null;
        }
        return (T) view.findViewById(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String uh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (this.F == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.F.substring(0, 3));
        sb5.append("******");
        sb5.append(this.F.substring(r1.length() - 2));
        return sb5.toString();
    }

    protected String vh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        String uh5 = uh();
        String str = this.G;
        if (str != null && str.contains(Marker.ANY_NON_NULL_MARKER)) {
            return " " + this.G + " " + uh5 + " ";
        }
        return " +" + this.G + " " + uh5 + " ";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean wh() {
        AppRuntime appRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        QBaseActivity qBaseActivity = getQBaseActivity();
        this.C = qBaseActivity;
        if (qBaseActivity == null) {
            QLog.e(QPublicBaseFragment.TAG, 1, "initContext activity is null");
            return false;
        }
        if (qBaseActivity == null) {
            appRuntime = null;
        } else {
            appRuntime = qBaseActivity.getAppRuntime();
        }
        this.D = appRuntime;
        if (appRuntime == null) {
            QLog.e(QPublicBaseFragment.TAG, 1, "onCreateView appRuntime is null");
            this.C.finish();
            return false;
        }
        com.tencent.mobileqq.loginregister.z.v(appRuntime, getClass(), this.H);
        return true;
    }

    public void yh(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            new QQToastNotifier(this.C).notifyUser(i3, this.C.getTitleBarHeight(), 1, i16);
        }
    }

    public void zh(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str, i3);
        } else if (str != null && str.length() != 0) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            new QQToastNotifier(this.C).notifyUser(str, this.C.getTitleBarHeight(), 0, i3);
        }
    }
}
