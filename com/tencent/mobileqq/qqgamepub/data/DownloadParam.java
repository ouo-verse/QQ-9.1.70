package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgamepub.api.IQQGameResService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.util.Pair;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes16.dex */
public class DownloadParam implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final int FILE_POS_INNER = 1;
    public static final int FILE_POS_SDCARD = 0;
    public String filePath;
    public int filePos;
    public List<Pair<String, String>> headers;
    public boolean isFlowControl;
    public boolean isForceUnzip;
    public boolean isPreDownload;
    public String md5;
    public String md5ForChecked;
    public long md5Time;
    public String url;
    public boolean useQWalletConfig;

    public DownloadParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.md5 = "";
        this.md5Time = 0L;
        this.useQWalletConfig = false;
        this.isForceUnzip = false;
        this.isPreDownload = false;
        this.filePos = 0;
        this.md5ForChecked = "";
        this.isFlowControl = false;
    }

    public void standardlize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (((IQQGameResService) QRoute.api(IQQGameResService.class)).isOnlySupportInnerFilePos()) {
            this.filePos = 1;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "DownloadParam{url='" + this.url + "', md5='" + this.md5 + "', md5Time=" + this.md5Time + ", useQWalletConfig=" + this.useQWalletConfig + ", isForceUnzip=" + this.isForceUnzip + ", headers=" + this.headers + ", filePath='" + this.filePath + "', isPreDownload=" + this.isPreDownload + ", filePos=" + this.filePos + ", md5ForChecked='" + this.md5ForChecked + "', isFlowControl=" + this.isFlowControl + '}';
    }
}
