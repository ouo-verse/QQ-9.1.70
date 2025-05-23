package com.tencent.gcloud.dolphin;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface UpdateCallBack {

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class AppVersion {
        static IPatchRedirector $redirector_;
        public short versionNumberFour;
        public short versionNumberOne;
        public short versionNumberThree;
        public short versionNumberTwo;

        public AppVersion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.versionNumberOne = (short) 0;
            this.versionNumberTwo = (short) 0;
            this.versionNumberThree = (short) 0;
            this.versionNumberFour = (short) 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class VersionInfo {
        static IPatchRedirector $redirector_;
        public boolean isAppUpdating;
        public boolean isForcedUpdating;
        public boolean isNeedUpdating;
        public long needDownloadSize;
        public AppVersion newAppVersion;

        public VersionInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.isAppUpdating = false;
            this.isNeedUpdating = false;
            this.isForcedUpdating = false;
            this.needDownloadSize = 0L;
        }
    }

    boolean onActionMsgArrive(String str);

    void onError(int i3, int i16);

    boolean onGetNewVersionInfo(VersionInfo versionInfo);

    boolean onNoticeInstallAPK(String str);

    void onProgress(int i3, long j3, long j16);

    void onSuccess();
}
