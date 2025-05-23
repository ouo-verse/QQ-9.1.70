package com.tencent.mobileqq.mqsafeedit;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class CodecWarpper {
    static IPatchRedirector $redirector_ = null;
    public static final String NATIVE_LIB_NAME = "codecwrapperV2";
    private static AtomicBoolean isSoLoaded;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9416);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            isSoLoaded = new AtomicBoolean(false);
            loadSo();
        }
    }

    public CodecWarpper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public static void loadSo() {
        if (!isSoLoaded.get()) {
            try {
                if (CoreUtil.loadLibrary("codecwrapperV2", BaseApplication.getContext())) {
                    isSoLoaded.set(true);
                } else {
                    String replace = BaseApplication.getContext().getPackageName().replace(".", "_");
                    isSoLoaded.set(CoreUtil.loadLibrary(String.valueOf(replace) + "_codecwrapperV2", BaseApplication.getContext()));
                }
            } catch (Exception unused) {
            }
        }
    }
}
