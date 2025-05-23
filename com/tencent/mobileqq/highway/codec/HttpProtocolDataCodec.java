package com.tencent.mobileqq.highway.codec;

import com.tencent.mobileqq.highway.segment.HwRequest;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.msf.core.net.MsfHttpResp;
import com.tencent.mobileqq.msf.core.net.MsfHttpRespParse;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.impl.io.ChunkedInputStream;
import org.apache.http.impl.io.ContentLengthInputStream;
import org.apache.http.impl.io.IdentityInputStream;
import wns_proxy.HttpRsp;

/* loaded from: classes9.dex */
public class HttpProtocolDataCodec extends TcpProtocolDataCodec {
    static IPatchRedirector $redirector_ = null;
    public static final int HTTP_DEFAULT_PORT = 80;

    public HttpProtocolDataCodec() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private byte[] createHttpReqData(EndPoint endPoint, byte[] bArr) {
        byte[] bytes = ("POST /cgi-bin/httpconn?htcmd=0x6ff0082 HTTP/1.1\r\nConnection: Keep-Alive\r\nHost: " + endPoint.host + ":" + endPoint.port + "\r\nAccept: */*\r\nUser-Agent: javaMsfClient\r\nContent-Type: application/x-www-form-urlencoded\r\nContent-Length: " + bArr.length + HttpRsp.HTTP_HEADER_END).getBytes();
        byte[] bArr2 = new byte[bytes.length + bArr.length];
        System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
        System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
        return bArr2;
    }

    @Override // com.tencent.mobileqq.highway.codec.TcpProtocolDataCodec
    public byte[] encodeC2SData(EndPoint endPoint, HwRequest hwRequest, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (byte[]) iPatchRedirector.redirect((short) 4, this, endPoint, hwRequest, bArr);
        }
        return createHttpReqData(endPoint, super.encodeC2SData(endPoint, hwRequest, bArr));
    }

    @Override // com.tencent.mobileqq.highway.codec.TcpProtocolDataCodec
    public void onRecvData(MsfSocketInputBuffer msfSocketInputBuffer) throws IOException, HttpException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) msfSocketInputBuffer);
            return;
        }
        do {
            MsfHttpResp parse = new MsfHttpRespParse(msfSocketInputBuffer).parse();
            if (MsfHttpRespParse.canResponseHaveBody(parse)) {
                if (parse.getContentLen() != -1) {
                    parse.setContent(new ContentLengthInputStream(msfSocketInputBuffer, parse.getContentLen()));
                } else if (parse.getTransferEncoding().equalsIgnoreCase("chunked")) {
                    parse.setContent(new ChunkedInputStream(msfSocketInputBuffer));
                } else {
                    parse.setContent(new IdentityInputStream(msfSocketInputBuffer));
                }
            }
            if (parse.getStatusLine().getStatusCode() >= 200) {
                byte[] bArr = new byte[20480];
                byte[] bArr2 = null;
                while (true) {
                    int read = parse.getContent().read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    bArr2 = new byte[read];
                    System.arraycopy(bArr, 0, bArr2, 0, read);
                }
                decodeS2CData(bArr2);
            }
        } while (msfSocketInputBuffer.hasBufferedData());
    }

    @Override // com.tencent.mobileqq.highway.codec.TcpProtocolDataCodec
    public void setProtocolCodecListener(IProtocolCodecListener iProtocolCodecListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iProtocolCodecListener);
        } else {
            super.setProtocolCodecListener(iProtocolCodecListener);
        }
    }
}
