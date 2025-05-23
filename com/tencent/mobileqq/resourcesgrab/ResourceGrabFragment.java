package com.tencent.mobileqq.resourcesgrab;

import android.os.Bundle;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mvvm.LifeCycleFragment;
import com.tencent.mobileqq.mvvm.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.util.WeakReference;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ResourceGrabFragment extends LifeCycleFragment {
    static IPatchRedirector $redirector_;
    private WeakReference<ResourceGrabView> D;
    private d E;
    private boolean F;

    public ResourceGrabFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.F = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void th() {
        if (QLog.isColorLevel()) {
            QLog.d("ResourceGrabFragment", 2, "doGrabResourceName");
        }
        this.E.R1(getBaseActivity().getWindow().getDecorView(), true);
        this.F = true;
    }

    @Override // com.tencent.mobileqq.mvvm.LifeCycleFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
        } else {
            super.onCreate(bundle);
            this.E = (d) h.b(this, d.f281280m).get(d.class);
        }
    }

    @Override // com.tencent.mobileqq.mvvm.LifeCycleFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onDestroy();
        wh();
        if (QLog.isColorLevel()) {
            QLog.d("ResourceGrabFragment", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void rh(ResourceGrabView resourceGrabView) {
        this.D = new WeakReference<>(resourceGrabView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sh() {
        this.E.R1(getBaseActivity().getWindow().getDecorView(), false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void uh() {
        if (!this.F) {
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.resourcesgrab.ResourceGrabFragment.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ResourceGrabFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        ResourceGrabFragment.this.th();
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            }, 200L);
        } else {
            th();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean vh() {
        ResourceGrabView resourceGrabView = this.D.get();
        if (resourceGrabView != null && resourceGrabView.f281255e) {
            return true;
        }
        return false;
    }

    void wh() {
        this.E.R1(getBaseActivity().getWindow().getDecorView(), false);
        ResourceGrabView resourceGrabView = this.D.get();
        if (resourceGrabView != null) {
            resourceGrabView.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xh(List<c> list) {
        ResourceGrabView resourceGrabView = this.D.get();
        if (resourceGrabView != null) {
            resourceGrabView.F.setText(this.E.M1(list));
        }
    }
}
