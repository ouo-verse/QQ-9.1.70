package com.tencent.mobileqq.troopmanage.base;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troopmanage.api.ITroopManageService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class TroopManageBaseFragment extends QIphoneTitleBarFragment {
    static IPatchRedirector $redirector_;
    protected QQAppInterface C;
    protected ITroopManageService D;

    public TroopManageBaseFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getTitleBarHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return getQBaseActivity().getTitleBarHeight();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        this.C = qQAppInterface;
        this.D = (ITroopManageService) qQAppInterface.getRuntimeService(ITroopManageService.class, "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ph() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return NetworkUtil.isNetworkAvailable(BaseApplication.getContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qh(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            QQToast.makeText(getContext(), 1, str, 0).show(getTitleBarHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rh(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            QQToast.makeText(getContext(), 2, str, 0).show(getTitleBarHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showToast(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            QQToast.makeText(getContext(), str, 0).show(getTitleBarHeight());
        }
    }
}
