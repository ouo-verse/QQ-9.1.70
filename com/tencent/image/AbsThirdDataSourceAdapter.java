package com.tencent.image;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class AbsThirdDataSourceAdapter {
    static IPatchRedirector $redirector_ = null;
    public static final int STATUS_NOT_PREPARED = 0;
    public static final int STATUS_PREPARED = 2;
    public static final int STATUS_PREPARING = 1;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface OnPreparedCallback {
        void onPrepared();
    }

    public AbsThirdDataSourceAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract int getPlayType();

    public abstract int getStaus();

    public abstract String getURL();

    public abstract void requestPrepare(String str, OnPreparedCallback onPreparedCallback);
}
