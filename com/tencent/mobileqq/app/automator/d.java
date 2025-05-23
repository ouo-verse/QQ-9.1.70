package com.tencent.mobileqq.app.automator;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface d {

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static abstract class a implements d {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.app.automator.d
        public AsyncStep S1(b bVar, String str) {
            AsyncStep asyncStep;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AsyncStep) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar, (Object) str);
            }
            if (str != null) {
                str = str.trim();
            }
            if (!TextUtils.isEmpty(str)) {
                int i3 = -1;
                if (str.startsWith("{")) {
                    LinearGroup linearGroup = new LinearGroup();
                    linearGroup.f195314e = str;
                    linearGroup.mName = str;
                    asyncStep = linearGroup;
                } else if (str.startsWith("[")) {
                    ParallGroup parallGroup = new ParallGroup();
                    parallGroup.f195314e = str;
                    parallGroup.mName = str;
                    asyncStep = parallGroup;
                } else {
                    i3 = Integer.parseInt(str);
                    try {
                        asyncStep = a(i3);
                    } catch (Exception e16) {
                        QLog.e("Example", 1, e16, new Object[0]);
                        asyncStep = null;
                    }
                }
                if (asyncStep != null) {
                    asyncStep.mAutomator = bVar;
                    asyncStep.mStepId = i3;
                }
                return asyncStep;
            }
            throw new RuntimeException("createStepGroup: " + str);
        }

        public abstract AsyncStep a(int i3);
    }

    AsyncStep S1(b bVar, String str);
}
