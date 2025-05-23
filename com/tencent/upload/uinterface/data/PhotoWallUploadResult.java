package com.tencent.upload.uinterface.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.uinterface.AbstractUploadResult;

/* loaded from: classes27.dex */
public class PhotoWallUploadResult extends AbstractUploadResult {
    static IPatchRedirector $redirector_;
    public String burl;
    public int ctime;
    public String filekey;
    public String murl;
    public int publish_code;
    public String stackMsg;
    public String surl;
    public String url;

    public PhotoWallUploadResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.url = "";
        this.burl = "";
        this.murl = "";
        this.surl = "";
        this.filekey = "";
        this.stackMsg = "";
        this.publish_code = 0;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "url=" + this.url + ",ctime=" + this.ctime + ",filekey=" + this.filekey + ",publish_code=" + this.publish_code + ",burl=" + this.burl + ",murl=" + this.murl + ",surl=" + this.surl;
    }
}
