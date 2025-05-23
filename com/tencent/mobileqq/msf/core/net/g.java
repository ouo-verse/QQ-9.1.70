package com.tencent.mobileqq.msf.core.net;

import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.msf.core.quic.QuicWrapper;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;
import java.util.Random;
import org.apache.http.util.ByteArrayBuffer;
import wns_proxy.HttpRsp;

/* compiled from: P */
/* loaded from: classes15.dex */
public class g implements c {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: k, reason: collision with root package name */
    private static final String f248744k = "LightQuicEngine";

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.msf.core.quic.a f248745a;

    /* renamed from: b, reason: collision with root package name */
    private long f248746b;

    /* renamed from: c, reason: collision with root package name */
    private String f248747c;

    /* renamed from: d, reason: collision with root package name */
    private int f248748d;

    /* renamed from: e, reason: collision with root package name */
    private int f248749e;

    /* renamed from: f, reason: collision with root package name */
    private int f248750f;

    /* renamed from: g, reason: collision with root package name */
    private String f248751g;

    /* renamed from: h, reason: collision with root package name */
    boolean f248752h;

    /* renamed from: i, reason: collision with root package name */
    boolean f248753i;

    /* renamed from: j, reason: collision with root package name */
    Object f248754j;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f248745a = null;
        this.f248746b = -1L;
        this.f248749e = 10000;
        this.f248750f = 10000;
        this.f248752h = false;
        this.f248753i = false;
        this.f248754j = null;
        this.f248745a = new com.tencent.mobileqq.msf.core.quic.a();
    }

    @Override // com.tencent.mobileqq.msf.core.net.c
    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f248749e = i3;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.net.c
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.msf.core.net.c
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f248753i;
    }

    @Override // com.tencent.mobileqq.msf.core.net.c
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.net.c
    public void a(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.f248754j = obj;
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, obj);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.net.c
    public boolean a(String str, int i3, String str2, com.tencent.mobileqq.msf.core.quicksend.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), str2, dVar)).booleanValue();
        }
        this.f248747c = str;
        this.f248748d = i3;
        long currentTimeMillis = System.currentTimeMillis();
        long a16 = this.f248745a.a();
        this.f248746b = a16;
        this.f248753i = this.f248745a.a(a16, this.f248747c, this.f248748d, this.f248749e);
        dVar.f249910j = System.currentTimeMillis() - currentTimeMillis;
        QLog.d(f248744k, 1, "connect " + this.f248747c + ":" + this.f248748d + " " + this.f248753i);
        return this.f248753i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x01e8, code lost:
    
        r8 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x017b, code lost:
    
        r22.f248753i = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0279  */
    @Override // com.tencent.mobileqq.msf.core.net.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] a(ToServiceMsg toServiceMsg, byte[] bArr, String str, com.tencent.mobileqq.msf.core.quicksend.d dVar) {
        String str2;
        int i3;
        String str3;
        String str4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (byte[]) iPatchRedirector.redirect((short) 7, this, toServiceMsg, bArr, str, dVar);
        }
        int requestSsoSeq = toServiceMsg.getRequestSsoSeq();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String str5 = "http://" + this.f248747c + ":" + this.f248748d;
        String str6 = str5 + a(str5, requestSsoSeq);
        this.f248751g = str6;
        this.f248751g = MsfSdkUtils.insertMtype(str, str6);
        String str7 = "try connect " + this.f248751g + " timeout:" + this.f248749e + " ssoseq:" + requestSsoSeq + " sendByXG:" + this.f248752h;
        String str8 = f248744k;
        QLog.d(f248744k, 1, str7);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("/");
        String str9 = this.f248751g;
        sb5.append(str9.substring(str9.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)));
        String sb6 = sb5.toString();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("POST ");
        stringBuffer.append(sb6);
        stringBuffer.append(" HTTP/1.1\r\n");
        stringBuffer.append("User-Agent: aqq\r\n");
        stringBuffer.append("content-type: oct\r\n");
        stringBuffer.append("Connection: Keep-Alive\r\n");
        stringBuffer.append("Accept-Encoding: \r\n");
        stringBuffer.append("Host: ");
        stringBuffer.append(this.f248747c);
        stringBuffer.append("\r\n");
        stringBuffer.append("Content-Length: ");
        stringBuffer.append(bArr.length);
        stringBuffer.append(HttpRsp.HTTP_HEADER_END);
        byte[] bytes = stringBuffer.toString().getBytes();
        try {
            QLog.d(f248744k, 1, "httpSend sendByXG:" + this.f248752h + " ssoseq:" + requestSsoSeq + " len:" + (this.f248745a.a(this.f248746b, bytes, bytes.length, this.f248750f) + this.f248745a.a(this.f248746b, bArr, bArr.length, this.f248750f)));
            ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(512);
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            while (true) {
                QuicWrapper.QuicBundle a16 = this.f248745a.a(this.f248746b, 512, this.f248750f);
                i3 = a16.retcode;
                if (i3 <= 0) {
                    break;
                }
                int i19 = a16.data_len;
                i16 += i19;
                byteArrayBuffer.append(a16.data, 0, i19);
                int[] a17 = a(new String(byteArrayBuffer.toByteArray()));
                i18 = a17[0];
                i17 = a17[1];
                if (i18 > 0 && i17 > 0) {
                    int length = i18 - (byteArrayBuffer.length() - i17);
                    if (QLog.isColorLevel()) {
                        QLog.d(str8, 2, "parseHttpHeader contentLen=" + i18 + " bodyOffset=" + i17 + " remainBytes=" + length);
                    }
                    if (length <= 0) {
                        break;
                    }
                    str3 = str8;
                    try {
                        QuicWrapper.QuicBundle a18 = this.f248745a.a(this.f248746b, length, this.f248750f);
                        int i26 = a18.retcode;
                        if (i26 <= 0) {
                            this.f248753i = false;
                            break;
                        }
                        int i27 = a18.data_len;
                        i16 += i27;
                        byteArrayBuffer.append(a18.data, 0, i27);
                        int i28 = a18.data_len;
                        if (i28 > 0) {
                            length -= i28;
                        }
                        if (length <= 0) {
                            break;
                        }
                        str4 = str3;
                    } catch (Exception e16) {
                        e = e16;
                        str2 = str3;
                        if (QLog.isColorLevel()) {
                            QLog.d(str2, 2, e.getMessage(), e);
                        }
                        a();
                        e.printStackTrace();
                        return null;
                    }
                } else {
                    str4 = str8;
                }
                str8 = str4;
            }
            str3 = str8;
            if (QLog.isDevelopLevel()) {
                byte[] bArr2 = new byte[i17];
                System.arraycopy(byteArrayBuffer.toByteArray(), 0, bArr2, 0, i17);
                str2 = str3;
                try {
                    QLog.d(str2, 2, new String(bArr2));
                } catch (Exception e17) {
                    e = e17;
                    if (QLog.isColorLevel()) {
                    }
                    a();
                    e.printStackTrace();
                    return null;
                }
            } else {
                str2 = str3;
            }
            QLog.d(str2, 1, "httpRecv ssoseq:" + requestSsoSeq + " content_len:" + i18 + " costtime:" + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ret=" + i3 + " data_len=" + i16);
            byte[] bArr3 = new byte[i18];
            System.arraycopy(byteArrayBuffer.toByteArray(), i17, bArr3, 0, i18);
            return bArr3;
        } catch (Exception e18) {
            e = e18;
            str2 = str8;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0045, code lost:
    
        r8 = r8.indexOf(wns_proxy.HttpRsp.HTTP_HEADER_END) + 4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int[] a(String str) throws IOException {
        int i3;
        BufferedReader bufferedReader = new BufferedReader(new CharArrayReader(str.toCharArray()));
        int i16 = 0;
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    i3 = 0;
                    break;
                }
                if (readLine.startsWith("Content-Length")) {
                    String[] split = readLine.split(":");
                    if (split != null && split.length == 2) {
                        i16 = Integer.parseInt(split[1].trim());
                    }
                } else if (TextUtils.isEmpty(readLine)) {
                    break;
                }
            } catch (Throwable th5) {
                bufferedReader.close();
                throw th5;
            }
        }
        bufferedReader.close();
        return new int[]{i16, i3};
    }

    @Override // com.tencent.mobileqq.msf.core.net.c
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.f248753i = false;
        this.f248745a.a(this.f248746b);
        this.f248745a.b(this.f248746b);
    }

    private String a(String str, int i3) {
        String str2 = "r=" + i3 + "_" + String.valueOf(new Random(System.currentTimeMillis()).nextInt(100000));
        if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            if (str.endsWith(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                return str + str2;
            }
            return str2 + ContainerUtils.FIELD_DELIMITER + str2;
        }
        return QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str2;
    }
}
