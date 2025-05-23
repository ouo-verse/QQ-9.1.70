package com.tencent.mobileqq.transfile.quic.internal;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QuicDownloadRequest {
    static IPatchRedirector $redirector_ = null;
    private static final int PORT_QUIC = 443;
    private static final int PORT_TCP = 80;
    private static final String SCHEME_HTTPS = "https";
    protected Map<String, String> headers;
    protected String host;

    /* renamed from: ip, reason: collision with root package name */
    public String f293471ip;
    protected boolean isFinish;
    protected String method;
    protected String path;
    protected int port;
    protected String scheme;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QuicDownloadRequest(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2);
            return;
        }
        this.method = "GET";
        this.port = 443;
        this.scheme = "https";
        this.isFinish = false;
        this.headers = new LinkedHashMap();
        init(str, i3, str2);
    }

    private void init(String str, int i3, String str2) {
        this.path = str2;
        this.host = str;
        this.f293471ip = str;
        this.port = i3;
        if (str == null || TextUtils.isEmpty(str)) {
            this.f293471ip = "";
        }
    }

    public void addHeader(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
        } else {
            this.headers.put(str, str2);
        }
    }

    public byte[] getRequestData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (byte[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.method);
        sb5.append(TokenParser.SP);
        sb5.append(this.path);
        sb5.append(" HTTP/1.1");
        sb5.append("\r\n");
        for (String str : this.headers.keySet()) {
            sb5.append(str);
            sb5.append(MsgSummary.STR_COLON);
            sb5.append(this.headers.get(str));
            sb5.append("\r\n");
        }
        sb5.append("\r\n");
        this.isFinish = true;
        return sb5.toString().getBytes();
    }

    public void setHeader(Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) map);
        } else {
            if (map == null) {
                return;
            }
            this.headers = map;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "QuicDownloadRequest{method='" + this.method + "', SCHEME_HTTPS='https', PORT_QUIC=443, PORT_TCP=80, host='" + this.host + "', ip='" + this.f293471ip + "', port=" + this.port + ", scheme='" + this.scheme + "', path='" + this.path + "', isFinish=" + this.isFinish + ", headers=" + this.headers + '}';
    }
}
