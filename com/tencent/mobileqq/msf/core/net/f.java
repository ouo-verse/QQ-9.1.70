package com.tencent.mobileqq.msf.core.net;

import android.os.SystemClock;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import org.apache.http.util.ByteArrayBuffer;

/* compiled from: P */
@Deprecated
/* loaded from: classes15.dex */
public class f implements c {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: k, reason: collision with root package name */
    private static final String f248733k = "LightHttpEngine";

    /* renamed from: a, reason: collision with root package name */
    private String f248734a;

    /* renamed from: b, reason: collision with root package name */
    private URL f248735b;

    /* renamed from: c, reason: collision with root package name */
    private int f248736c;

    /* renamed from: d, reason: collision with root package name */
    private int f248737d;

    /* renamed from: e, reason: collision with root package name */
    private int f248738e;

    /* renamed from: f, reason: collision with root package name */
    private Object f248739f;

    /* renamed from: g, reason: collision with root package name */
    boolean f248740g;

    /* renamed from: h, reason: collision with root package name */
    private HttpURLConnection f248741h;

    /* renamed from: i, reason: collision with root package name */
    private int f248742i;

    /* renamed from: j, reason: collision with root package name */
    private String f248743j;

    public f(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.f248736c = 10000;
        this.f248737d = 30000;
        this.f248740g = false;
        this.f248738e = i3;
    }

    @Override // com.tencent.mobileqq.msf.core.net.c
    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f248736c = i3;
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
        return false;
    }

    @Override // com.tencent.mobileqq.msf.core.net.c
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f248740g;
    }

    @Override // com.tencent.mobileqq.msf.core.net.c
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.f248734a = null;
        this.f248735b = null;
        this.f248736c = 10000;
        this.f248741h = null;
        this.f248742i = 0;
        this.f248743j = null;
    }

    @Override // com.tencent.mobileqq.msf.core.net.c
    public void a(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.f248739f = obj;
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
        this.f248740g = false;
        long j3 = 0;
        try {
            this.f248737d = com.tencent.mobileqq.msf.core.x.b.L();
            String str3 = "http://" + str + ":" + i3;
            String str4 = str3 + a(str3, this.f248738e);
            this.f248734a = str4;
            this.f248734a = MsfSdkUtils.insertMtype(str2, str4);
            QLog.d(f248733k, 1, "LightHttpEngine try connect " + this.f248734a + " timeout:" + this.f248736c + " ssoseq:" + this.f248738e);
            j3 = SystemClock.elapsedRealtime();
            System.setProperty("http.keepAlive", "false");
            URL url = new URL(this.f248734a);
            this.f248735b = url;
            HttpURLConnection httpURLConnection = (HttpURLConnection) a(url);
            this.f248741h = httpURLConnection;
            httpURLConnection.setDoOutput(true);
            this.f248741h.setDoInput(true);
            this.f248741h.setUseCaches(false);
            this.f248741h.setReadTimeout(this.f248737d);
            this.f248741h.setRequestMethod("POST");
            this.f248741h.setRequestProperty("User-Agent", "aqq");
            this.f248741h.setRequestProperty("content-type", "oct");
            this.f248741h.setConnectTimeout(this.f248736c);
            this.f248741h.setRequestProperty("Connection", "close");
            this.f248741h.setRequestProperty("Accept-Encoding", "");
            this.f248741h.connect();
            long elapsedRealtime = SystemClock.elapsedRealtime() - j3;
            this.f248740g = true;
            QLog.d(f248733k, 1, "LightHttpEngine connect " + this.f248734a + " succ costtime:" + elapsedRealtime + " ssoseq:" + this.f248738e + " readTimeout:" + this.f248737d);
        } catch (Throwable th5) {
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - j3;
            this.f248740g = false;
            try {
                HttpURLConnection httpURLConnection2 = this.f248741h;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (Throwable th6) {
                th6.printStackTrace();
            }
            th5.printStackTrace();
            String a16 = a(th5.toString().toLowerCase());
            dVar.f249913m += "|" + a16;
            QLog.d(f248733k, 1, "LightHttpEngine connect " + this.f248734a + " fail costtime:" + elapsedRealtime2 + " ssoseq:" + this.f248738e + " reason:" + a16);
        }
        return this.f248740g;
    }

    private URLConnection a(URL url) {
        URLConnection uRLConnection;
        try {
            uRLConnection = url.openConnection();
        } catch (Throwable th5) {
            th = th5;
            uRLConnection = null;
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.i(f248733k, 2, "openConnection by default wifi=" + NetConnInfoCenter.isWifiConn() + " " + uRLConnection);
            }
        } catch (Throwable th6) {
            th = th6;
            if (QLog.isColorLevel()) {
                QLog.w(f248733k, 1, "openConnection error: wifi=" + NetConnInfoCenter.isWifiConn());
            }
            th.printStackTrace();
            return uRLConnection;
        }
        return uRLConnection;
    }

    public static String a(String str) {
        if (NetConnInfoCenter.getSystemNetworkType() == 0) {
            return q.f248935m.toString();
        }
        if (str.indexOf("illegal") > -1) {
            return q.f248929g.toString();
        }
        if (str.indexOf("route to host") > -1) {
            return q.f248939q.toString();
        }
        if (str.indexOf("unreachable") > -1) {
            return q.f248935m.toString();
        }
        if (str.indexOf(QCircleDaTongConstant.ElementParamValue.PERMISSION) > -1) {
            return q.f248931i.toString();
        }
        if (str.indexOf("refused") > -1) {
            return q.f248941s.toString();
        }
        if (str.indexOf("reset") > -1) {
            return q.f248940r.toString();
        }
        if (str.indexOf("timeoutexception") <= -1 && str.indexOf(") after") <= -1) {
            if (str.indexOf("unknownhost") > -1) {
                return q.f248938p.toString();
            }
            if (str.indexOf("unresolved") > -1) {
                return q.f248937o.toString();
            }
            if (str.indexOf("enotsock") > -1) {
                return q.f248930h.toString();
            }
            if (str.indexOf("enobufs") > -1) {
                return q.f248934l.toString();
            }
            if (str.indexOf("ebadf") > -1) {
                return q.f248932j.toString();
            }
            if (str.indexOf(QCircleDaTongConstant.ElementParamValue.OPERATION) > -1) {
                return q.f248942t.toString();
            }
            if (str.indexOf(HippyReporter.RemoveEngineReason.INVALID) > -1) {
                return q.f248936n.toString();
            }
            return q.f248943u.toString();
        }
        return q.f248942t.toString();
    }

    @Override // com.tencent.mobileqq.msf.core.net.c
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QLog.d(f248733k, 1, "LightHttpEngine disconn " + this.f248734a + " ssoseq:" + this.f248738e);
        this.f248740g = false;
        HttpURLConnection httpURLConnection = this.f248741h;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            this.f248741h = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x011f A[Catch: all -> 0x0138, TRY_LEAVE, TryCatch #2 {all -> 0x0138, blocks: (B:33:0x00e1, B:35:0x011f), top: B:32:0x00e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x012f A[Catch: all -> 0x012b, TRY_LEAVE, TryCatch #5 {all -> 0x012b, blocks: (B:48:0x0127, B:39:0x012f), top: B:47:0x0127 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0127 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.msf.core.net.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] a(ToServiceMsg toServiceMsg, byte[] bArr, String str, com.tencent.mobileqq.msf.core.quicksend.d dVar) {
        long j3;
        OutputStream outputStream;
        InputStream inputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (byte[]) iPatchRedirector.redirect((short) 8, this, toServiceMsg, bArr, str, dVar);
        }
        try {
            j3 = SystemClock.elapsedRealtime();
        } catch (Throwable th5) {
            th = th5;
            j3 = 0;
        }
        try {
            outputStream = this.f248741h.getOutputStream();
        } catch (Throwable th6) {
            th = th6;
            outputStream = null;
            inputStream = null;
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                th.printStackTrace();
                dVar.f249908h = th.toString();
                QLog.d(f248733k, 1, "LightHttpEngine httpSend fail ssoseq:" + this.f248738e + " costtime:" + (elapsedRealtime - j3) + " reason:" + th.toString());
                if (QLog.isColorLevel()) {
                }
                if (outputStream != null) {
                }
                if (inputStream == null) {
                }
            } finally {
            }
        }
        try {
            outputStream.write(bArr);
            outputStream.flush();
            QLog.d(f248733k, 1, "LightHttpEngine httpSend ssoseq:" + this.f248738e + " len:" + bArr.length);
            this.f248742i = this.f248741h.getResponseCode();
            this.f248743j = this.f248741h.getURL().getHost();
            inputStream = this.f248741h.getInputStream();
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            th.printStackTrace();
            dVar.f249908h = th.toString();
            QLog.d(f248733k, 1, "LightHttpEngine httpSend fail ssoseq:" + this.f248738e + " costtime:" + (elapsedRealtime2 - j3) + " reason:" + th.toString());
            if (QLog.isColorLevel()) {
            }
            if (outputStream != null) {
            }
            if (inputStream == null) {
            }
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(1024);
            byte[] bArr2 = new byte[50];
            while (true) {
                int read = bufferedInputStream.read(bArr2);
                if (read == -1) {
                    break;
                }
                byteArrayBuffer.append(bArr2, 0, read);
            }
            QLog.d(f248733k, 1, "LightHttpEngine httpRecv ssoseq:" + this.f248738e + " len:" + byteArrayBuffer.length() + " costtime:" + (SystemClock.elapsedRealtime() - j3));
            byte[] byteArray = byteArrayBuffer.toByteArray();
            try {
                outputStream.close();
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Throwable th8) {
                th8.printStackTrace();
            }
            return byteArray;
        } catch (Throwable th9) {
            th = th9;
            long elapsedRealtime22 = SystemClock.elapsedRealtime();
            th.printStackTrace();
            dVar.f249908h = th.toString();
            QLog.d(f248733k, 1, "LightHttpEngine httpSend fail ssoseq:" + this.f248738e + " costtime:" + (elapsedRealtime22 - j3) + " reason:" + th.toString());
            if (QLog.isColorLevel()) {
                QLog.d(f248733k, 2, th, new Object[0]);
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Throwable th10) {
                    th10.printStackTrace();
                    return null;
                }
            }
            if (inputStream == null) {
                return null;
            }
            inputStream.close();
            return null;
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
