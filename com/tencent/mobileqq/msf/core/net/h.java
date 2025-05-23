package com.tencent.mobileqq.msf.core.net;

import android.net.Network;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Random;
import org.apache.http.util.ByteArrayBuffer;
import wns_proxy.HttpRsp;

/* compiled from: P */
/* loaded from: classes15.dex */
public class h implements c {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: m, reason: collision with root package name */
    public static final String f248755m = "LightTcpEngine";

    /* renamed from: a, reason: collision with root package name */
    private Object f248756a;

    /* renamed from: b, reason: collision with root package name */
    private Socket f248757b;

    /* renamed from: c, reason: collision with root package name */
    private InetSocketAddress f248758c;

    /* renamed from: d, reason: collision with root package name */
    String f248759d;

    /* renamed from: e, reason: collision with root package name */
    int f248760e;

    /* renamed from: f, reason: collision with root package name */
    OutputStream f248761f;

    /* renamed from: g, reason: collision with root package name */
    InputStream f248762g;

    /* renamed from: h, reason: collision with root package name */
    BufferedReader f248763h;

    /* renamed from: i, reason: collision with root package name */
    boolean f248764i;

    /* renamed from: j, reason: collision with root package name */
    private String f248765j;

    /* renamed from: k, reason: collision with root package name */
    private int f248766k;

    /* renamed from: l, reason: collision with root package name */
    private int f248767l;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f248764i = false;
        this.f248766k = 10000;
        this.f248767l = 30000;
    }

    @Override // com.tencent.mobileqq.msf.core.net.c
    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f248766k = i3;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.net.c
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.msf.core.net.c
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        Socket socket = this.f248757b;
        if (socket != null && socket.isConnected() && !this.f248757b.isClosed()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.msf.core.net.c
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.f248757b = null;
        this.f248756a = null;
        this.f248758c = null;
    }

    public Object e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f248756a;
    }

    public Socket f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Socket) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f248757b;
    }

    @Override // com.tencent.mobileqq.msf.core.net.c
    public void a(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.f248756a = obj;
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, obj);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.net.c
    public boolean a(String str, int i3, String str2, com.tencent.mobileqq.msf.core.quicksend.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, str, Integer.valueOf(i3), str2, dVar)).booleanValue();
        }
        this.f248759d = str;
        this.f248760e = i3;
        try {
            this.f248767l = com.tencent.mobileqq.msf.core.x.b.L();
            this.f248758c = new InetSocketAddress(this.f248759d, i3);
            Socket socket = new Socket();
            socket.setSoTimeout(this.f248767l);
            socket.setTcpNoDelay(true);
            socket.setKeepAlive(true);
            socket.setReuseAddress(true);
            Object obj = this.f248756a;
            if (obj != null) {
                Network network = (Network) obj;
                network.bindSocket(socket);
                this.f248764i = m.a(BaseApplication.getContext(), network, 0);
            }
            String name = Thread.currentThread().getName();
            MsfCore msfCore = MsfCore.sCore;
            if (msfCore != null && msfCore.mMsfMonitorCallback != null && !TextUtils.isEmpty(name) && name.contains(com.tencent.mobileqq.msf.core.q.f249791f)) {
                MsfCore.sCore.mMsfMonitorCallback.handleEnd(3);
            }
            socket.connect(this.f248758c, this.f248766k);
            MsfCore msfCore2 = MsfCore.sCore;
            if (msfCore2 != null && msfCore2.mMsfMonitorCallback != null && name.contains(com.tencent.mobileqq.msf.core.q.f249791f)) {
                MsfCore.sCore.mMsfMonitorCallback.handleStart(3);
            }
            this.f248761f = socket.getOutputStream();
            this.f248762g = socket.getInputStream();
            this.f248763h = new BufferedReader(new InputStreamReader(this.f248762g));
            this.f248757b = socket;
            return true;
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d(f248755m, 2, th5.getMessage(), th5);
            }
            th5.printStackTrace();
            String a16 = f.a(th5.toString().toLowerCase());
            dVar.f249913m += "|" + a16;
            QLog.d(f248755m, 1, "connect fail costtime:" + (SystemClock.elapsedRealtime() - 0) + " reason:" + a16);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.msf.core.net.c
    public byte[] a(ToServiceMsg toServiceMsg, byte[] bArr, String str, com.tencent.mobileqq.msf.core.quicksend.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (byte[]) iPatchRedirector.redirect((short) 9, this, toServiceMsg, bArr, str, dVar);
        }
        int requestSsoSeq = toServiceMsg.getRequestSsoSeq();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String str2 = "http://" + this.f248759d + ":" + this.f248760e;
        String str3 = str2 + a(str2, requestSsoSeq);
        this.f248765j = str3;
        this.f248765j = MsfSdkUtils.insertMtype(str, str3);
        QLog.d(f248755m, 1, "try connect " + this.f248765j + " timeout:" + this.f248766k + " ssoseq:" + requestSsoSeq + " sendByXG:" + this.f248764i);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("/");
        String str4 = this.f248765j;
        sb5.append(str4.substring(str4.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)));
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
        stringBuffer.append(this.f248759d);
        stringBuffer.append("\r\n");
        stringBuffer.append("Content-Length: ");
        stringBuffer.append(bArr.length);
        stringBuffer.append(HttpRsp.HTTP_HEADER_END);
        byte[] bytes = stringBuffer.toString().getBytes();
        try {
            this.f248761f.write(bytes, 0, bytes.length);
            this.f248761f.write(bArr, 0, bArr.length);
            this.f248761f.flush();
            QLog.d(f248755m, 1, "httpSend sendByXG:" + this.f248764i + " ssoseq:" + requestSsoSeq + " len:" + bArr.length);
            int i3 = 0;
            while (true) {
                String readLine = this.f248763h.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.startsWith("Content-Length")) {
                    String[] split = readLine.split(":");
                    if (split != null && split.length == 2) {
                        i3 = Integer.parseInt(split[1].trim());
                    }
                } else if (TextUtils.isEmpty(readLine)) {
                    break;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d(f248755m, 2, readLine);
                }
            }
            if (i3 > 0) {
                int min = Math.min(i3, 512);
                byte[] bArr2 = new byte[min];
                ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(i3);
                String name = Thread.currentThread().getName();
                int i16 = i3;
                while (i16 > 0) {
                    MsfCore msfCore = MsfCore.sCore;
                    if (msfCore != null && msfCore.mMsfMonitorCallback != null && !TextUtils.isEmpty(name) && name.contains(com.tencent.mobileqq.msf.core.q.f249791f)) {
                        MsfCore.sCore.mMsfMonitorCallback.handleEnd(3);
                    }
                    int read = this.f248762g.read(bArr2, 0, Math.min(i16, min));
                    MsfCore msfCore2 = MsfCore.sCore;
                    if (msfCore2 != null && msfCore2.mMsfMonitorCallback != null && !TextUtils.isEmpty(name) && name.contains(com.tencent.mobileqq.msf.core.q.f249791f)) {
                        MsfCore.sCore.mMsfMonitorCallback.handleStart(3);
                    }
                    if (read <= 0) {
                        break;
                    }
                    i16 -= read;
                    byteArrayBuffer.append(bArr2, 0, read);
                }
                QLog.d(f248755m, 1, "httpRecv ssoseq:" + requestSsoSeq + " len:" + i3 + " costtime:" + (SystemClock.elapsedRealtime() - elapsedRealtime));
                return byteArrayBuffer.toByteArray();
            }
            throw new IOException("Content-Length: " + i3 + " exception");
        } catch (IOException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f248755m, 2, e16.getMessage(), e16);
            }
            a();
            d();
            e16.printStackTrace();
            return null;
        } catch (Exception e17) {
            e17.printStackTrace();
            return null;
        }
    }

    @Override // com.tencent.mobileqq.msf.core.net.c
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        try {
            Socket socket = this.f248757b;
            if (socket != null) {
                socket.close();
                this.f248757b = null;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        try {
            OutputStream outputStream = this.f248761f;
            if (outputStream != null) {
                outputStream.close();
                this.f248761f = null;
            }
        } catch (Exception unused) {
        }
        try {
            BufferedReader bufferedReader = this.f248763h;
            if (bufferedReader != null) {
                bufferedReader.close();
                this.f248763h = null;
            }
        } catch (Exception unused2) {
        }
        try {
            InputStream inputStream = this.f248762g;
            if (inputStream != null) {
                inputStream.close();
                this.f248762g = null;
            }
        } catch (Exception unused3) {
        }
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
