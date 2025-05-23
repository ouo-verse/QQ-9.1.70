package com.tencent.mobileqq.msf.core.net;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.t;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.ProtocolException;
import org.apache.http.impl.io.ChunkedInputStream;
import org.apache.http.impl.io.ContentLengthInputStream;
import org.apache.http.impl.io.IdentityInputStream;
import wns_proxy.HttpRsp;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d implements e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    MsfCore f248731a;

    /* renamed from: b, reason: collision with root package name */
    private t f248732b;

    public d(MsfCore msfCore, t tVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msfCore, (Object) tVar);
        } else {
            this.f248731a = msfCore;
            this.f248732b = tVar;
        }
    }

    @Override // com.tencent.mobileqq.msf.core.net.e
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f248732b.h();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    protected byte[] b(com.tencent.mobileqq.msf.core.d dVar, String str, String str2, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (byte[]) iPatchRedirector.redirect((short) 6, this, dVar, str, str2, bArr);
        }
        byte[] bytes = ("POST / HTTP/1.1\r\nConnection: Keep-Alive\r\nHost: " + dVar.b() + ":" + dVar.d() + "\r\nAccept: */*\r\nUser-Agent: javaMsfClient\r\nContent-Type: application/x-www-form-urlencoded\r\nContent-Length: " + bArr.length + HttpRsp.HTTP_HEADER_END).getBytes();
        byte[] bArr2 = new byte[bytes.length + bArr.length];
        System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
        System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
        return bArr2;
    }

    @Override // com.tencent.mobileqq.msf.core.net.e
    public void a(MsfSocketInputBuffer msfSocketInputBuffer, int i3) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) msfSocketInputBuffer, i3);
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
            int statusCode = parse.getStatusLine().getStatusCode();
            if (statusCode >= 200) {
                byte[] bArr = new byte[20480];
                ArrayList arrayList = new ArrayList();
                int i16 = 0;
                while (true) {
                    int read = parse.getContent().read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    i16 += read;
                    byte[] bArr2 = new byte[read];
                    System.arraycopy(bArr, 0, bArr2, 0, read);
                    arrayList.add(bArr2);
                    if (QLog.isColorLevel()) {
                        QLog.d("MSF.C.NetConnTag.", 2, " read " + read);
                    }
                }
                if (arrayList.size() == 1) {
                    this.f248732b.a((byte[]) arrayList.get(0), i3);
                } else {
                    byte[] bArr3 = new byte[i16];
                    Iterator it = arrayList.iterator();
                    int i17 = 0;
                    while (it.hasNext()) {
                        byte[] bArr4 = (byte[]) it.next();
                        System.arraycopy(bArr4, 0, bArr3, i17, bArr4.length);
                        i17 += bArr4.length;
                    }
                    this.f248732b.a(bArr3, i3);
                }
            } else if (statusCode != 100) {
                throw new ProtocolException("Unexpected response: " + parse.getStatusLine());
            }
        } while (msfSocketInputBuffer.hasBufferedData());
    }

    @Override // com.tencent.mobileqq.msf.core.net.e
    public byte[] a(com.tencent.mobileqq.msf.core.d dVar, String str, String str2, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (byte[]) iPatchRedirector.redirect((short) 4, this, dVar, str, str2, bArr);
        }
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        int a16 = a(bArr2);
        if (bArr.length > a16) {
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            int i16 = 0;
            while (bArr.length >= a16) {
                byte[] bArr3 = new byte[a16];
                System.arraycopy(bArr, i3, bArr3, 0, a16);
                byte[] b16 = b(dVar, str, str2, bArr3);
                i16 += b16.length;
                arrayList.add(b16);
                i3 += a16;
                if (i3 >= bArr.length) {
                    break;
                }
                System.arraycopy(bArr, i3, bArr2, 0, 4);
                a16 = a(bArr2);
            }
            byte[] bArr4 = new byte[i16];
            Iterator it = arrayList.iterator();
            int i17 = 0;
            while (it.hasNext()) {
                byte[] bArr5 = (byte[]) it.next();
                System.arraycopy(bArr5, 0, bArr4, i17, bArr5.length);
                i17 += bArr5.length;
            }
            return bArr4;
        }
        return b(dVar, str, str2, bArr);
    }

    protected int a(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bArr)).intValue();
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.put(bArr).flip();
        return allocate.getInt();
    }
}
