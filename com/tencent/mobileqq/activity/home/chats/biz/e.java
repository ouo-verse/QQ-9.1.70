package com.tencent.mobileqq.activity.home.chats.biz;

import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public class e extends d {
    static IPatchRedirector $redirector_;

    public e(com.tencent.mobileqq.activity.home.chats.callbcak.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    private void ma() {
        try {
            AppRuntime X9 = X9();
            if (X9 == null || !((IFeatureRuntimeService) X9.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("android_conversation_check_windows", false)) {
                return;
            }
            if (com.tencent.mobileqq.litelivesdk.utils.ui.a.a(getActivity())) {
                ViewGroup viewGroup = (ViewGroup) getActivity().getWindow().getDecorView();
                int height = viewGroup.getHeight();
                int height2 = viewGroup.getChildAt(0).getHeight();
                QLog.i("FitsWindowsPart", 1, "navigate check exist, contentHeight: " + height2 + "screenHeight: " + height);
                if (height2 == height) {
                    if ((getActivity().getWindow().getAttributes().flags & 134217728) != 0) {
                        QLog.i("FitsWindowsPart", 1, "navigate check exist, added wrong flags");
                        if (((IFeatureRuntimeService) X9.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("android_conversation_fits_windows", false)) {
                            QLog.i("FitsWindowsPart", 1, "navigate check fits systemWindows");
                            getActivity().getWindow().clearFlags(134217728);
                        }
                    } else {
                        QLog.i("FitsWindowsPart", 1, "navigate check exist, set wrong layoutParams");
                    }
                }
            } else {
                QLog.i("FitsWindowsPart", 1, "navigate check not exist");
            }
        } catch (Exception e16) {
            QLog.e("FitsWindowsPart", 1, "check navigation wrong: " + e16);
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void T9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            ma();
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d
    public String ea() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "FitsWindowsPart";
    }
}
