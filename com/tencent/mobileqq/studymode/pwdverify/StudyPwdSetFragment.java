package com.tencent.mobileqq.studymode.pwdverify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.studymode.p;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes18.dex */
public class StudyPwdSetFragment extends StudyPwdBaseFragment {
    static IPatchRedirector $redirector_;
    private int V;
    private int W;
    private int X;
    private int Y;
    private int Z;

    /* renamed from: a0, reason: collision with root package name */
    private FragmentActivity f291021a0;

    public StudyPwdSetFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void Xh(String str) {
        Intent intent = this.f291021a0.getIntent();
        intent.putExtra("key_previous_pwd", str);
        QPublicFragmentActivity.startForResult(getActivity(), intent, (Class<? extends QPublicBaseFragment>) StudyPwdSetConfirmFragment.class, 1);
    }

    private void Yh() {
        FragmentActivity fragmentActivity = this.f291021a0;
        if (fragmentActivity != null) {
            Intent intent = fragmentActivity.getIntent();
            if (p.f(this.Y)) {
                intent.putExtra("msg", "StudyPwdSetFragment: set password failed, reason: back");
            }
            this.f291021a0.setResult(0, intent);
        }
    }

    @Override // com.tencent.mobileqq.studymode.pwdverify.StudyPwdBaseFragment
    @Nullable
    protected View Dh(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (View) iPatchRedirector.redirect((short) 8, (Object) this, (Object) viewGroup);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.studymode.pwdverify.StudyPwdBaseFragment
    protected String Eh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return BaseApplication.getContext().getString(R.string.f2051654v);
    }

    @Override // com.tencent.mobileqq.studymode.pwdverify.StudyPwdBaseFragment
    protected String Fh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return BaseApplication.getContext().getString(R.string.f2051854x);
    }

    @Override // com.tencent.mobileqq.studymode.pwdverify.StudyPwdBaseFragment
    protected void Nh(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), str);
        } else if (z16) {
            Xh(str);
        }
    }

    protected void Wh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            Ah();
            Uh();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void beforeFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (p.f(this.Y)) {
            Mh();
        }
        super.beforeFinish();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (getActivity() != null && i3 == 1) {
            if (intent == null) {
                Wh();
                return;
            }
            int intExtra = intent.getIntExtra("extra_source", -1);
            boolean booleanExtra = intent.getBooleanExtra("key_is_jump_to_next", false);
            QLog.d("StudyPwdSetFragment", 1, "src: " + intExtra + ", isJumpToNext:" + booleanExtra);
            if (p.f(intExtra)) {
                if (i16 != 0 && booleanExtra) {
                    if (i16 == -1) {
                        Intent intent2 = this.f291021a0.getIntent();
                        intent2.putExtra("msg", "StudyPwdSetFragment: first set password success");
                        this.f291021a0.setResult(-1, intent2);
                        this.S = 2;
                        this.f291021a0.finish();
                        return;
                    }
                    return;
                }
                Wh();
                return;
            }
            if (i16 != 0 && booleanExtra) {
                if (i16 == -1 && booleanExtra) {
                    this.f291021a0.setResult(-1, intent);
                    this.f291021a0.finish();
                    return;
                }
                return;
            }
            Wh();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        this.f291021a0 = activity;
        if (activity != null) {
            Intent intent = activity.getIntent();
            this.V = intent.getIntExtra("ExtraTargetAction", -1);
            this.W = intent.getIntExtra("extra_target_mode", -1);
            this.X = intent.getIntExtra("extra_old_mode", -1);
            this.Y = intent.getIntExtra("extra_source", -1);
            this.Z = intent.getIntExtra("extra_source_for_report", -1);
            Yh();
        }
        int i3 = this.Z;
        if (i3 != -1) {
            Rh("0X800BD3F", i3);
        } else {
            Sh("0X800BD3F", this.V);
        }
    }

    @Override // com.tencent.mobileqq.studymode.pwdverify.StudyPwdBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) bundle);
        } else {
            super.onViewCreated(view, bundle);
        }
    }

    @Override // com.tencent.mobileqq.studymode.StudyModeBaseFragment
    protected void uh() {
        FragmentActivity fragmentActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (p.f(this.Y) && (fragmentActivity = this.f291021a0) != null) {
            Intent intent = fragmentActivity.getIntent();
            intent.putExtra("msg", "StudyPwdSetFragment: set password failed, reason: back button");
            this.f291021a0.setResult(0, intent);
            return;
        }
        super.uh();
    }
}
