package com.tencent.tuxmetersdk.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuxUseState {
    static IPatchRedirector $redirector_ = null;
    public static final int INIT_SDK_STATE_FAIL = 2;
    public static final int INIT_SDK_STATE_INIT = 0;
    public static final int INIT_SDK_STATE_SUCCESS = 1;
    public static final int SDK_DATA_READY_STATE_FAIL = 2;
    public static final int SDK_DATA_READY_STATE_INIT = 0;
    public static final int SDK_DATA_READY_STATE_SUCCESS = 1;
    private final AtomicInteger initSDKState;
    private final AtomicBoolean isReadyToUse;
    private final AtomicInteger sdkDataReadyState;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TuxUseState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isReadyToUse = new AtomicBoolean(false);
        this.initSDKState = new AtomicInteger(0);
        this.sdkDataReadyState = new AtomicInteger(0);
    }

    int getInitSDKState() {
        return this.initSDKState.get();
    }

    int getSDKDataReadyState() {
        return this.sdkDataReadyState.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInitSDKFail() {
        if (this.initSDKState.get() == 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInitSDKSuccess() {
        if (this.initSDKState.get() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isReadyToUse() {
        return this.isReadyToUse.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isSDKDataReadyFail() {
        if (this.sdkDataReadyState.get() == 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isSDKDataReadyInit() {
        if (this.sdkDataReadyState.get() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isSDKDataReadySuccess() {
        if (this.sdkDataReadyState.get() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInitSDKStateFail() {
        this.initSDKState.compareAndSet(0, 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInitSDKStateSuccess() {
        this.initSDKState.compareAndSet(0, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setReadyToUse() {
        this.isReadyToUse.set(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void setSDKDataReadyStateFail() {
        this.sdkDataReadyState.set(2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void setSDKDataReadyStateSuccess() {
        this.sdkDataReadyState.set(1);
    }
}
