package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

/* compiled from: P */
/* loaded from: classes12.dex */
public class NearbyBaseFragment extends TitlebarBaseFragment implements Handler.Callback {
    static IPatchRedirector $redirector_;
    INearbyAppInterface J;
    Handler K;
    int L;
    protected boolean M;
    private boolean N;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.fragment.NearbyBaseFragment$1, reason: invalid class name */
    /* loaded from: classes12.dex */
    class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AbsWebView f211169d;
        final /* synthetic */ NearbyBaseFragment this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f211169d.mWebview.flingScroll(0, -this.this$0.L);
            }
        }
    }

    public NearbyBaseFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.L = 5000;
        this.M = false;
        this.N = false;
        this.K = new WeakReferenceHandler(Looper.getMainLooper(), this);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) message)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.TitlebarBaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            return;
        }
        super.onAttach(activity);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(activity);
        int scaledMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        int scaledMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.L = scaledMaximumFlingVelocity / 4;
        if (QLog.isColorLevel()) {
            QLog.d("NearbyBaseFragment", 2, "onAttach: maxVelocity=" + scaledMaximumFlingVelocity + ", minVelocity=" + scaledMinimumFlingVelocity);
        }
        Object obj = null;
        if (this.D) {
            if (activity instanceof BaseActivity) {
                obj = ((BaseActivity) activity).getAppInterface();
            }
            if (obj instanceof INearbyAppInterface) {
                this.J = (INearbyAppInterface) obj;
                return;
            }
            return;
        }
        this.J = null;
    }

    @Override // com.tencent.mobileqq.fragment.TitlebarBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            super.onHiddenChanged(z16);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bundle);
            return;
        }
        super.onSaveInstanceState(bundle);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onSaveInstanceState: outState==null?");
            if (bundle == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append(", this=");
            sb5.append(this);
            QLog.d("NearbyBaseFragment", 2, sb5.toString());
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
            return;
        }
        super.setUserVisibleHint(z16);
        if (QLog.isColorLevel()) {
            QLog.d("NearbyBaseFragment", 2, "setUserVisibleHint: isVisibleToUser=" + z16);
        }
        this.N = z16;
    }
}
