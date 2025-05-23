package com.tencent.gcloud.dolphin;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes6.dex */
public class UpdateInterface {
    static IPatchRedirector $redirector_;
    private UpdateCallBack updateCallBack;
    private int updateHandle;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class DataVersion {
        static IPatchRedirector $redirector_;
        public short dataVersion;

        public DataVersion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UpdateInterface.this);
            } else {
                this.dataVersion = (short) 0;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20053);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            System.loadLibrary("gcloudcore");
            System.loadLibrary("gcloud");
        }
    }

    public UpdateInterface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.updateHandle = 0;
            this.updateCallBack = null;
        }
    }

    private native void cancelUpdateNative(int i3);

    private native boolean checkAppUpdateNative(int i3);

    private native int createUpdateHandleNative();

    private native boolean deleteUpdateHandleNative(int i3);

    private native long getCurrentDownloadSpeedNative(int i3);

    private native long getLastErrorNative(int i3);

    private native boolean initUpdateHandleNative(int i3, UpdateCallBack updateCallBack, String str);

    private native boolean pollCallBackNative(int i3);

    private native boolean sentMsgToCurrentActionNative(int i3, String str);

    private native boolean setNextStageNative(int i3, boolean z16);

    private native boolean uninitUpdateHandleNative(int i3);

    public void cancelUpdate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        int i3 = this.updateHandle;
        if (i3 == 0) {
            return;
        }
        cancelUpdateNative(i3);
    }

    public boolean checkAppUpdate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        int i3 = this.updateHandle;
        if (i3 == 0) {
            return false;
        }
        return checkAppUpdateNative(i3);
    }

    public boolean createUpdateHandle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.updateHandle != 0) {
            return false;
        }
        this.updateHandle = createUpdateHandleNative();
        Log.i("IIPSUpdateInterface", "create value:" + this.updateHandle);
        return true;
    }

    public boolean deleteUpdateHandle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        int i3 = this.updateHandle;
        if (i3 == 0) {
            return false;
        }
        boolean deleteUpdateHandleNative = deleteUpdateHandleNative(i3);
        this.updateHandle = 0;
        return deleteUpdateHandleNative;
    }

    public long getCurrentDownloadSpeed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this)).longValue();
        }
        int i3 = this.updateHandle;
        if (i3 == 0) {
            return 0L;
        }
        return getCurrentDownloadSpeedNative(i3);
    }

    public long getLastError() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        int i3 = this.updateHandle;
        if (i3 == 0) {
            return 0L;
        }
        return getLastErrorNative(i3);
    }

    public boolean initUpdateHandle(UpdateCallBack updateCallBack, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) updateCallBack, (Object) str)).booleanValue();
        }
        int i3 = this.updateHandle;
        if (i3 == 0) {
            return false;
        }
        this.updateCallBack = updateCallBack;
        return initUpdateHandleNative(i3, updateCallBack, str);
    }

    public boolean pollCallBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        int i3 = this.updateHandle;
        if (i3 == 0) {
            return false;
        }
        return pollCallBackNative(i3);
    }

    public boolean sentMsgToCurrentAction(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str)).booleanValue();
        }
        int i3 = this.updateHandle;
        if (i3 == 0) {
            return false;
        }
        return sentMsgToCurrentActionNative(i3, str);
    }

    public boolean setNextStage(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, z16)).booleanValue();
        }
        int i3 = this.updateHandle;
        if (i3 == 0) {
            return false;
        }
        return setNextStageNative(i3, z16);
    }

    public boolean uninitUpdateHandle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        int i3 = this.updateHandle;
        if (i3 == 0) {
            return false;
        }
        return uninitUpdateHandleNative(i3);
    }
}
