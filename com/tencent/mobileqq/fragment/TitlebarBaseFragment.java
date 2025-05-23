package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.ap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class TitlebarBaseFragment extends BaseFragment {
    static IPatchRedirector $redirector_;
    protected IphoneTitleBarActivity C;
    protected boolean D;
    protected af E;
    protected boolean F;
    protected boolean G;
    protected View H;
    protected ap I;

    public TitlebarBaseFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.D = false;
        this.F = false;
        this.G = false;
        if (QLog.isColorLevel()) {
            QLog.i("Fragment", 2, "new BaseFragment:" + getClass().getSimpleName() + " " + hashCode());
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bundle);
            return;
        }
        super.onActivityCreated(bundle);
        if (QLog.isColorLevel()) {
            QLog.d("Fragment", 2, "onActivityCreated() " + getClass().getSimpleName() + " " + hashCode());
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (QLog.isColorLevel()) {
            QLog.d("NBase", 2, "onActivityResult() BaseFragment");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
            return;
        }
        super.onAttach(activity);
        if (QLog.isColorLevel()) {
            QLog.d("Fragment", 2, "onAttach() " + getClass().getSimpleName() + " " + hashCode());
        }
        if (this.E == null) {
            this.E = new af(this);
        }
        this.C = (IphoneTitleBarActivity) getActivity();
        this.D = true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        if (QLog.isColorLevel()) {
            QLog.d("Fragment", 2, "onCreate() " + getClass().getSimpleName() + " " + hashCode());
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            onCreateView = (View) iPatchRedirector.redirect((short) 6, this, layoutInflater, viewGroup, bundle);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("Fragment", 2, "onCreateView() " + getClass().getSimpleName() + " " + hashCode());
            }
            onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        super.onDestroy();
        if (QLog.isColorLevel()) {
            QLog.d("Fragment", 2, "onDestroy() " + getClass().getSimpleName() + " " + hashCode());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        super.onDestroyView();
        this.F = false;
        if (QLog.isColorLevel()) {
            QLog.d("Fragment", 2, "onDestroyView() " + getClass().getSimpleName() + " " + hashCode());
        }
        ap apVar = this.I;
        if (apVar != null) {
            apVar.b();
        }
        View view = this.H;
        if (view != null && (viewGroup = (ViewGroup) view.getParent()) != null) {
            viewGroup.removeView(this.H);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        super.onDetach();
        this.D = false;
        if (QLog.isColorLevel()) {
            QLog.d("Fragment", 2, "onDetach() " + getClass().getSimpleName() + " " + hashCode());
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        super.onHiddenChanged(z16);
        if (QLog.isColorLevel()) {
            QLog.d("Fragment", 2, "onHiddenChanged() " + getClass().getSimpleName() + " " + hashCode() + " hidden=" + z16);
        }
        if (z16) {
            onPause();
        } else {
            onResume();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.onPause();
        this.G = false;
        if (QLog.isColorLevel()) {
            QLog.d("Fragment", 2, "onPause() " + getClass().getSimpleName() + " " + hashCode());
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.onResume();
        this.G = true;
        if (QLog.isColorLevel()) {
            QLog.d("Fragment", 2, "onResume() " + getClass().getSimpleName() + " " + hashCode());
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onStart();
        if (QLog.isColorLevel()) {
            QLog.d("Fragment", 2, "onStart() " + getClass().getSimpleName() + " " + hashCode());
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.onStop();
        if (QLog.isColorLevel()) {
            QLog.d("Fragment", 2, "onStop() " + getClass().getSimpleName() + " " + hashCode());
        }
    }
}
