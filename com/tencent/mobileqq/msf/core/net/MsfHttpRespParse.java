package com.tencent.mobileqq.msf.core.net;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpVersion;
import org.apache.http.NoHttpResponseException;
import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.LineParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;
import org.apache.httpcore.message.TokenParser;

/* loaded from: classes15.dex */
public class MsfHttpRespParse {
    static IPatchRedirector $redirector_;
    private final CharArrayBuffer lineBuf;
    protected final LineParser lineParser;
    private final int maxHeaderCount;
    private final int maxLineLen;
    private MsfHttpResp msfHttpResp;

    public MsfHttpRespParse(MsfSocketInputBuffer msfSocketInputBuffer, LineParser lineParser, int i3, int i16) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msfSocketInputBuffer, lineParser, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.msfHttpResp = new MsfHttpResp(msfSocketInputBuffer);
        this.maxHeaderCount = i3;
        this.maxLineLen = i16;
        this.lineParser = BasicLineParser.DEFAULT;
        this.lineBuf = new CharArrayBuffer(128);
    }

    public static boolean canResponseHaveBody(MsfHttpResp msfHttpResp) {
        int statusCode = msfHttpResp.getStatusLine().getStatusCode();
        if (statusCode >= 200 && statusCode != 204 && statusCode != 304 && statusCode != 205) {
            return true;
        }
        return false;
    }

    public static MsfSocketInputBuffer createSesssionBuffer(Socket socket, int i3) throws IOException {
        return new MsfSocketInputBuffer(socket, i3, "US-ASCII", -1);
    }

    private void parseHead() throws IOException, HttpException, ParseException {
        this.lineBuf.clear();
        if (this.msfHttpResp.getSessionBuffer().readLine(this.lineBuf) != -1) {
            this.msfHttpResp.setStatusline(this.lineParser.parseStatusLine(this.lineBuf, new ParserCursor(0, this.lineBuf.length())));
            return;
        }
        throw new NoHttpResponseException("The target server failed to respond");
    }

    public boolean isParseHeadFinished() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return false;
    }

    public MsfHttpResp parse() throws IOException, HttpException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MsfHttpResp) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        try {
            parseHead();
            this.msfHttpResp.setHeaders(parseHeaders(this.maxHeaderCount, this.maxLineLen, this.lineParser));
            return this.msfHttpResp;
        } catch (ParseException e16) {
            throw new ProtocolException(e16.getMessage(), e16);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b6, code lost:
    
        r11 = new org.apache.http.Header[r0.size()];
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c0, code lost:
    
        if (r2 >= r0.size()) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00c8, code lost:
    
        r11[r2] = r13.parseHeader((org.apache.http.util.CharArrayBuffer) r0.get(r2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ce, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d1, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00db, code lost:
    
        throw new org.apache.http.ProtocolException(r11.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00dc, code lost:
    
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected Header[] parseHeaders(int i3, int i16, LineParser lineParser) throws HttpException, IOException {
        char charAt;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Header[]) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), lineParser);
        }
        if (lineParser == null) {
            lineParser = BasicLineParser.DEFAULT;
        }
        ArrayList arrayList = new ArrayList();
        CharArrayBuffer charArrayBuffer = null;
        CharArrayBuffer charArrayBuffer2 = null;
        while (true) {
            if (charArrayBuffer == null) {
                charArrayBuffer = new CharArrayBuffer(64);
            } else {
                charArrayBuffer.clear();
            }
            if (this.msfHttpResp.getSessionBuffer().readLine(charArrayBuffer) == -1 || charArrayBuffer.length() < 1) {
                break;
            }
            if ((charArrayBuffer.charAt(0) == ' ' || charArrayBuffer.charAt(0) == '\t') && charArrayBuffer2 != null) {
                int i18 = 0;
                while (i18 < charArrayBuffer.length() && ((charAt = charArrayBuffer.charAt(i18)) == ' ' || charAt == '\t')) {
                    i18++;
                }
                if (i16 > 0 && ((charArrayBuffer2.length() + 1) + charArrayBuffer.length()) - i18 > i16) {
                    throw new IOException("Maximum line length limit exceeded");
                }
                charArrayBuffer2.append(TokenParser.SP);
                charArrayBuffer2.append(charArrayBuffer, i18, charArrayBuffer.length() - i18);
            } else {
                arrayList.add(charArrayBuffer);
                charArrayBuffer2 = charArrayBuffer;
                charArrayBuffer = null;
            }
            if (i3 > 0 && arrayList.size() >= i3) {
                throw new IOException("Maximum header count exceeded");
            }
        }
    }

    public MsfHttpRespParse(MsfSocketInputBuffer msfSocketInputBuffer) throws IOException {
        this(msfSocketInputBuffer, new BasicLineParser(HttpVersion.HTTP_1_1), -1, -1);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) msfSocketInputBuffer);
    }
}
