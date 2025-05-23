package com.tencent.mobileqq.msf.core.net;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MsfHttpResp {
    static IPatchRedirector $redirector_;
    private String connDirective;
    private InputStream content;
    private String contentEncoding;
    private int contentLen;
    private String contentType;
    private Header[] headers;
    private final MsfSocketInputBuffer sessionBuffer;
    private StatusLine statusline;
    private String transferEncoding;

    public MsfHttpResp(MsfSocketInputBuffer msfSocketInputBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msfSocketInputBuffer);
        } else {
            this.contentLen = -1;
            this.sessionBuffer = msfSocketInputBuffer;
        }
    }

    public String getConnDirective() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.connDirective;
    }

    public InputStream getContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (InputStream) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.content;
    }

    public String getContentEncoding() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.contentEncoding;
    }

    public int getContentLen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.contentLen;
    }

    public String getContentType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.contentType;
    }

    public Header[] getHeaders() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Header[]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.headers;
    }

    public ProtocolVersion getProtocolVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ProtocolVersion) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.statusline.getProtocolVersion();
    }

    public MsfSocketInputBuffer getSessionBuffer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (MsfSocketInputBuffer) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.sessionBuffer;
    }

    public StatusLine getStatusLine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (StatusLine) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.statusline;
    }

    public StatusLine getStatusline() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (StatusLine) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.statusline;
    }

    public String getTransferEncoding() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.transferEncoding;
    }

    public void setContent(InputStream inputStream) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) inputStream);
        } else {
            this.content = inputStream;
        }
    }

    public void setHeaders(Header[] headerArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) headerArr);
            return;
        }
        this.headers = headerArr;
        for (int length = headerArr.length - 1; length >= 0; length--) {
            Header header = headerArr[length];
            if (header.getName().equalsIgnoreCase("Transfer-Encoding")) {
                this.transferEncoding = header.getValue();
            } else if (header.getName().equalsIgnoreCase("Content-Length")) {
                this.contentLen = Integer.parseInt(header.getValue());
            } else if (header.getName().equalsIgnoreCase("Connection")) {
                this.connDirective = header.getValue();
            } else if (header.getName().equalsIgnoreCase("Content-Encoding")) {
                this.contentEncoding = header.getValue();
            } else if (header.getName().equalsIgnoreCase("Content-Type")) {
                this.contentType = header.getValue();
            }
        }
    }

    public void setStatusline(StatusLine statusLine) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) statusLine);
        } else {
            this.statusline = statusLine;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return getStatusLine() + " contentLen:" + getContentLen() + " transfer:" + this.transferEncoding;
    }
}
