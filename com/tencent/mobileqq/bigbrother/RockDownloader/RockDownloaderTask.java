package com.tencent.mobileqq.bigbrother.RockDownloader;

import com.tencent.mobileqq.data.RockDownloadInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class RockDownloaderTask implements Serializable {
    static IPatchRedirector $redirector_;
    private RockDownloadInfo downloadInfo;
    private boolean isMainProcess;
    private int processID;
    private a queryAPKListener;
    private RockDownloadListener rockDownloadListener;
    private AppRuntime runtime;
    private int taskCheckLevel;

    public RockDownloaderTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.isMainProcess = false;
            this.taskCheckLevel = -1;
        }
    }

    public RockDownloadInfo getDownloadInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RockDownloadInfo) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.downloadInfo;
    }

    public int getProcessID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.processID;
    }

    public a getQueryAPKListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (a) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.queryAPKListener;
    }

    public RockDownloadListener getRockDownloadListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (RockDownloadListener) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.rockDownloadListener;
    }

    public AppRuntime getRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.runtime;
    }

    public int getTaskCheckLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.taskCheckLevel;
    }

    public boolean isMainProcess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.isMainProcess;
    }

    public void setDownloadInfo(RockDownloadInfo rockDownloadInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rockDownloadInfo);
        } else {
            this.downloadInfo = rockDownloadInfo;
        }
    }

    public void setMainProcess(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            this.isMainProcess = z16;
        }
    }

    public void setProcessID(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.processID = i3;
        }
    }

    public void setQueryAPKListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) aVar);
        } else {
            this.queryAPKListener = aVar;
        }
    }

    public void setRockDownloadListener(RockDownloadListener rockDownloadListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) rockDownloadListener);
        } else {
            this.rockDownloadListener = rockDownloadListener;
        }
    }

    public void setRuntime(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) appRuntime);
        } else {
            this.runtime = appRuntime;
        }
    }

    public void setTaskCheckLevel(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.taskCheckLevel = i3;
        }
    }
}
