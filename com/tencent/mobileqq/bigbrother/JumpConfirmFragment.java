package com.tencent.mobileqq.bigbrother;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes11.dex */
public class JumpConfirmFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;
    private String C;
    private int D;
    private String E;
    private int F;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) JumpConfirmFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                JefsClass.getInstance().runAndRemoveTodo(JumpConfirmFragment.this.D, JumpConfirmFragment.this.E, JumpConfirmFragment.this.F);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) JumpConfirmFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            JefsClass.getInstance().removeTodo(JumpConfirmFragment.this.D, JumpConfirmFragment.this.E, JumpConfirmFragment.this.F);
            if (JumpConfirmFragment.this.C != null) {
                str = JumpConfirmFragment.this.C;
            } else {
                str = "";
            }
            ReportController.o(null, "dc00898", "", "", "0X8009C5A", "0X8009C5A", 0, 0, "1", "", str, "");
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class c implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) JumpConfirmFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            JefsClass.getInstance().removeTodo(JumpConfirmFragment.this.D, JumpConfirmFragment.this.E, JumpConfirmFragment.this.F);
            if (JumpConfirmFragment.this.getActivity() != null) {
                JumpConfirmFragment.this.getActivity().finish();
                JumpConfirmFragment.this.getActivity().overridePendingTransition(0, 0);
            }
        }
    }

    public JumpConfirmFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void setStatusBarImmersive() {
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null && ImmersiveUtils.isSupporImmersive() == 1) {
            if (SystemBarActivityModule.getSystemBarComp(qBaseActivity) == null) {
                SystemBarActivityModule.setImmersiveStatus(qBaseActivity, 0);
                return;
            }
            SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusBarDrawable(null);
            SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusBarColor(0);
            SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusColor(0);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            return;
        }
        super.initWindowStyleAndAnimation(activity);
        activity.getWindow().setFlags(1024, 1024);
        activity.overridePendingTransition(0, 0);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            onCreateView = (View) iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
        } else {
            Bundle arguments = getArguments();
            this.C = arguments.getString("big_brother_source_key");
            this.D = arguments.getInt("key_id");
            this.E = arguments.getString("key_process_id");
            this.F = arguments.getInt("key_callback_id", 0);
            try {
                Intent intent = getActivity().getIntent();
                String string = getString(R.string.f213195pj);
                String string2 = getString(R.string.cancel);
                String string3 = getString(R.string.igh);
                if (intent != null && intent.getBooleanExtra(JefsClass.EXTRA_KEY_IS_CUSTOM_DIALOG_TEXT, false)) {
                    string = intent.getStringExtra(JefsClass.EXTRA_KEY_DIALOG_CONTENT_TEXT);
                    string2 = intent.getStringExtra(JefsClass.EXTRA_KEY_DIALOG_CANCEL_TEXT);
                    string3 = intent.getStringExtra(JefsClass.EXTRA_KEY_DIALOG_CONFIRM_TEXT);
                }
                QQCustomDialog createCenterTextDialog = DialogUtil.createCenterTextDialog(getActivity(), 0, null, string, string2, string3, new a(), new b());
                createCenterTextDialog.setOnDismissListener(new c());
                getQBaseActivity().setJumpDialog(createCenterTextDialog);
                createCenterTextDialog.show();
            } catch (Throwable th5) {
                QLog.e("JumpConfirmFragment", 1, th5, new Object[0]);
                JefsClass.getInstance().runAndRemoveTodo(this.D, this.E, this.F);
                getActivity().finish();
            }
            setStatusBarImmersive();
            onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }
}
