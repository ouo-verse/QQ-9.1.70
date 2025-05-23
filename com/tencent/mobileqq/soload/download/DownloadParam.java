package com.tencent.mobileqq.soload.download;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.ISoLoadTempApi;
import com.tencent.util.Pair;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes18.dex */
public class DownloadParam implements Serializable {
    static IPatchRedirector $redirector_;
    public int downloadPriority;
    public int downloaderType;
    public String filePath;
    public List<Pair<String, String>> headers;
    public boolean isForceUnzip;
    public String md5;
    public String md5ForChecked;
    public long md5Time;
    public String url;

    public DownloadParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.md5 = "";
        this.md5Time = 0L;
        this.isForceUnzip = false;
        this.md5ForChecked = "";
        this.downloaderType = ((ISoLoadTempApi) QRoute.api(ISoLoadTempApi.class)).getQueueDownloaderType();
        this.downloadPriority = 1;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "DownloadParam{url='" + this.url + "', md5='" + this.md5 + "', md5Time=" + this.md5Time + ", isForceUnzip=" + this.isForceUnzip + ", headers=" + this.headers + ", filePath='" + this.filePath + "', md5ForChecked='" + this.md5ForChecked + "', downloaderType=" + this.downloaderType + ", downloadPriority=" + this.downloadPriority + '}';
    }
}
