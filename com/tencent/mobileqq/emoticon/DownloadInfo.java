package com.tencent.mobileqq.emoticon;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import java.io.File;
import java.net.HttpURLConnection;

/* compiled from: P */
/* loaded from: classes12.dex */
public class DownloadInfo {
    static IPatchRedirector $redirector_ = null;
    public static final String XERR_NO = "X-ErrNo";
    public static final String XFAIL_NO = "X-FailNo";
    public final int action;
    public HttpURLConnection conn;
    public byte[] data;
    public int domainType;
    public String emosmEPId;
    public String errorDetail;
    public String extra;
    public final File file;
    public String host;
    public int httpRespCode;

    /* renamed from: ip, reason: collision with root package name */
    public String f204570ip;
    public boolean isHttps;
    public boolean isIPUrl;
    public boolean isOpen304;
    public String reqUrl;
    public String respContentEncoding;
    public int respContentLength;
    public String respContentRead;
    public String respContentType;
    public String respVerifyString;
    public String respXErrNo;
    public String respXFailNo;
    public int resultCode;
    public final String urlOriginal;

    public DownloadInfo(String str, File file, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, file, Integer.valueOf(i3));
            return;
        }
        this.host = null;
        this.resultCode = -1;
        this.httpRespCode = -1;
        this.data = null;
        this.respVerifyString = "";
        this.reqUrl = str;
        this.urlOriginal = str;
        if (!TextUtils.isEmpty(str) && str.startsWith(HttpDownloadUtil.PROTOCOL_HTTPS)) {
            this.isHttps = true;
        }
        this.file = file;
        this.action = i3;
    }

    public void clearParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.reqUrl = this.urlOriginal;
        this.host = null;
        this.errorDetail = "";
        this.data = null;
        this.httpRespCode = -1;
        this.respContentLength = 0;
        this.respContentType = null;
        this.respContentEncoding = null;
        this.respContentRead = null;
        this.respXErrNo = null;
        this.respXFailNo = null;
        this.f204570ip = null;
        this.isIPUrl = false;
    }

    public String getLoadingTmpPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.file.getAbsolutePath() + ".tmp";
    }
}
