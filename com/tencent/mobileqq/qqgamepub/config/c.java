package com.tencent.mobileqq.qqgamepub.config;

import com.google.gson.annotations.SerializedName;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c implements IConfigData {
    static IPatchRedirector $redirector_;

    @SerializedName("checkIntervalTime")
    public long mCheckIntervalTime;

    @SerializedName("cleanIntervalTime")
    public long mCleanIntervalTime;

    @SerializedName("cleanResFolderMaxSize")
    public long mCleanResFolderMaxSize;

    @SerializedName("downOfflineSwitch")
    public int mDownOfflineSwitch;

    @SerializedName("preDownloadNetType")
    public String mPreDownloadNetType;

    @SerializedName("preDownloadSwitch")
    public int mPreDownloadSwitch;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mPreDownloadSwitch = 0;
        this.mDownOfflineSwitch = 0;
        this.mCleanResFolderMaxSize = -1L;
        this.mCleanIntervalTime = -1L;
        this.mCheckIntervalTime = -1L;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "QQGamePreDownloadConfigBean{mPreDownloadSwitch=" + this.mPreDownloadSwitch + ", mPreDownloadNetType='" + this.mPreDownloadNetType + "', mCleanResFolderMaxSize=" + this.mCleanResFolderMaxSize + ", mCleanIntervalTime=" + this.mCleanIntervalTime + ", mCheckIntervalTime=" + this.mCheckIntervalTime + ", mDownOfflineSwitch=" + this.mDownOfflineSwitch + '}';
    }
}
