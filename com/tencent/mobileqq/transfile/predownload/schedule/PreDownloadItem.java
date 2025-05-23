package com.tencent.mobileqq.transfile.predownload.schedule;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;

/* loaded from: classes19.dex */
public class PreDownloadItem {
    static IPatchRedirector $redirector_;
    public String businessEngName;
    public int businessID;
    public String businessName;
    public int businessPriority;
    public String department;
    public String downNetWork;
    public long downloadSize;
    public long downloadTime;
    public String downloadUrl;
    public String fileKey;
    public String filePath;
    public int innerPriority;
    public int reqCondition;
    public int reqNetWork;
    public long reqTime;
    public boolean saveOnSD;
    public int startCondition;
    public long startTime;
    public int state;
    public AbsPreDownloadTask task;

    public PreDownloadItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.reqTime = 0L;
        this.reqNetWork = 0;
        this.startTime = 0L;
        this.downloadTime = 0L;
        this.downloadSize = 0L;
        this.businessPriority = 0;
        this.innerPriority = 0;
        this.state = 0;
        this.reqCondition = 0;
        this.startCondition = 0;
    }
}
