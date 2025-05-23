package com.tencent.mobileqq.msf.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.msf.core.net.t.g;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MonitorSocketInputStream extends InputStream {
    static IPatchRedirector $redirector_;
    private Context context;
    private boolean isFirstReadBuffer;
    private InputStream mInputStream;
    private c monitorSocketImpl;

    public MonitorSocketInputStream(InputStream inputStream, c cVar, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, inputStream, cVar, context);
            return;
        }
        this.isFirstReadBuffer = true;
        this.mInputStream = inputStream;
        this.monitorSocketImpl = cVar;
        this.context = context;
    }

    private static String bytesToHex(byte[] bArr, int i3, int i16) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i17 = i3; i17 < i3 + i16; i17++) {
            String hexString = Integer.toHexString(bArr[i17] & 255);
            if (hexString.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x005a, code lost:
    
        if ((r10 + 16) >= r7) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x005e, code lost:
    
        r7 = bytesToHex(r17, r10, 16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x006a, code lost:
    
        if (r7.toUpperCase().startsWith("504B0304") == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x006c, code lost:
    
        r16.monitorSocketImpl.f250755i.setFileType(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0073, code lost:
    
        r16.monitorSocketImpl.f250755i.setResponseBodyHex(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x007e, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0080, code lost:
    
        com.tencent.qphone.base.util.QLog.d(com.tencent.mobileqq.msf.sdk.utils.MonitorSocketImplFactory.tag, 2, "Read Head=", r7, " String=", new java.lang.String(r17, r10, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00d0, code lost:
    
        if (r16.monitorSocketImpl.f250755i.getUrl() == null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00de, code lost:
    
        if (r16.monitorSocketImpl.f250755i.getUrl().contains(".apk") == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00e8, code lost:
    
        if (r16.monitorSocketImpl.f250755i.getFileType() != 1) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00f2, code lost:
    
        if (r16.monitorSocketImpl.f250755i.getFileType() == 2) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00f4, code lost:
    
        r0 = r16.monitorSocketImpl.f250755i;
        r0.responseHeaderGuessInfo.add(r0.getUrl());
        r16.monitorSocketImpl.f250755i.setFileType(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0093, code lost:
    
        r7 = r7 - r10;
        r0 = bytesToHex(r17, r10, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00a0, code lost:
    
        if (r0.toUpperCase().startsWith("504B0304") == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00a2, code lost:
    
        r16.monitorSocketImpl.f250755i.setFileType(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00a9, code lost:
    
        r16.monitorSocketImpl.f250755i.setResponseBodyHex(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00b4, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00b6, code lost:
    
        com.tencent.qphone.base.util.QLog.d(com.tencent.mobileqq.msf.sdk.utils.MonitorSocketImplFactory.tag, 2, "Read Head=", r0, " String=", new java.lang.String(r17, r10, r7));
     */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void getHttpResponseInfo(byte[] bArr, int i3, int i16) {
        int i17;
        int i18 = i3;
        int i19 = i18;
        int i26 = 0;
        while (true) {
            int i27 = i3 + i16;
            if (i19 < i27) {
                try {
                } catch (Exception e16) {
                    if (!QLog.isColorLevel()) {
                    }
                }
                if (bArr[i19] == 13 && (i17 = i19 + 1) < i27 && bArr[i17] == 10) {
                    String str = new String(bArr, i18, i19 - i18);
                    int i28 = i19 + 2;
                    i26++;
                    if (i26 == 1) {
                        String[] split = str.split(" ");
                        if (split.length >= 2) {
                            this.monitorSocketImpl.f250755i.setResponseCode(split[1]);
                        }
                    } else {
                        if (TextUtils.isEmpty(str)) {
                            break;
                        }
                        int indexOf = str.indexOf(":");
                        if (indexOf > 0) {
                            try {
                                String substring = str.substring(0, indexOf);
                                String substring2 = str.substring(indexOf + 2);
                                if ("Content-Type".equals(substring)) {
                                    this.monitorSocketImpl.f250755i.setMimeType(substring2);
                                    if ("application/vnd.android.package-archive".equals(substring2)) {
                                        this.monitorSocketImpl.f250755i.setFileType(1);
                                    }
                                } else if ("Content-Length".equals(substring)) {
                                    this.monitorSocketImpl.f250755i.setResponseLength(substring2);
                                } else if (substring2.indexOf(".apk") > 0 && this.monitorSocketImpl.f250755i.getFileType() != 1) {
                                    this.monitorSocketImpl.f250755i.responseHeaderGuessInfo.add(str);
                                    this.monitorSocketImpl.f250755i.setFileType(2);
                                }
                            } catch (StringIndexOutOfBoundsException e17) {
                                if (QLog.isColorLevel()) {
                                    QLog.d(MonitorSocketImplFactory.tag, 2, "header parse error, index=", Integer.valueOf(indexOf), " line=", str, " error info=", e17);
                                }
                            }
                        }
                        if (!QLog.isColorLevel()) {
                            QLog.d(MonitorSocketImplFactory.tag, 2, "getHttpResponseInfo ERROR=", e16);
                            return;
                        }
                        return;
                    }
                    i18 = i28;
                }
                i19++;
            } else {
                return;
            }
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.mInputStream.close();
        }
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.mInputStream.hashCode();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this.mInputStream.read() : ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? read(bArr, 0, bArr.length) : ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bArr)).intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0270 A[Catch: OutOfMemoryError -> 0x027d, Exception -> 0x0284, TRY_LEAVE, TryCatch #3 {Exception -> 0x0284, OutOfMemoryError -> 0x027d, blocks: (B:24:0x0062, B:27:0x006b, B:29:0x0071, B:31:0x007c, B:33:0x008f, B:36:0x0097, B:39:0x009e, B:41:0x00a4, B:43:0x00aa, B:48:0x0270, B:51:0x00b8, B:53:0x00c4, B:55:0x00da, B:56:0x012b, B:58:0x012f, B:59:0x0138, B:61:0x013e, B:62:0x0115, B:63:0x0187, B:65:0x019d, B:66:0x01ed, B:68:0x01f2, B:69:0x01d7, B:70:0x01fd, B:72:0x0203, B:74:0x0217, B:75:0x0257, B:77:0x0263, B:78:0x024b, B:79:0x0076), top: B:23:0x0062 }] */
    @Override // java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        int systemNetworkType;
        String str;
        b bVar;
        NetworkInfo activeNetworkInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        try {
            int read = this.mInputStream.read(bArr, i3, i16);
            if (this.isFirstReadBuffer) {
                this.isFirstReadBuffer = false;
                if (!BaseApplication.httpMonitorBan && this.monitorSocketImpl.f250755i != null) {
                    getHttpResponseInfo(bArr, i3, i16);
                }
            }
            if (read == -1 || MonitorSocketImplFactory.isServerSocket(toString())) {
                return read;
            }
            try {
                String str2 = this.monitorSocketImpl.f250752f;
                if (str2 != null && str2.contains(":MSF")) {
                    systemNetworkType = NetConnInfoCenter.getSystemNetworkType();
                } else {
                    systemNetworkType = AppNetConnInfo.getSystemNetworkType();
                }
                if (systemNetworkType == 0 && (activeNetworkInfo = ((ConnectivityManager) BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo()) != null) {
                    systemNetworkType = NetworkMonitor.getType(activeNetworkInfo);
                    if (systemNetworkType == 1) {
                        systemNetworkType = 2;
                    } else if (MonitorSocketImplFactory.isNetworkTypeMobile(systemNetworkType)) {
                        systemNetworkType = 1;
                    }
                }
                str = this.monitorSocketImpl.f250752f;
            } catch (Exception e16) {
                QLog.d(MonitorSocketImplFactory.tag, 1, "analyze netflow failed.", e16);
            } catch (OutOfMemoryError unused) {
                QLog.d(MonitorSocketImplFactory.tag, 1, "read OOM.");
            }
            if (str != null && str.contains(":MSF")) {
                if (n.f248797a0.contains(toString())) {
                    bVar = null;
                    if (bVar != null) {
                    }
                    return read;
                }
                if (g.f249398f.contains(toString())) {
                    bVar = c.f250738q.get(Integer.valueOf(this.monitorSocketImpl.f250753g.hashCode()));
                    if (bVar == null) {
                        c cVar = this.monitorSocketImpl;
                        bVar = new b(cVar.f250750d, null, cVar.f250751e, c.f250737p, read, systemNetworkType);
                        bVar.f250730h = "QualityTest";
                        bVar.f250731i = BaseApplication.monitor.getSTATUS();
                        bVar.f250732j = this.monitorSocketImpl.f250753g.hashCode();
                        c.f250738q.put(Integer.valueOf(this.monitorSocketImpl.f250753g.hashCode()), bVar);
                    } else {
                        c.f250738q.put(Integer.valueOf(this.monitorSocketImpl.f250753g.hashCode()), bVar.a(read));
                    }
                    if (bVar.f250734l == null) {
                        this.monitorSocketImpl.a(bVar.f250732j, c.f250737p);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(MonitorSocketImplFactory.tag, 2, "qualityTest|" + this.monitorSocketImpl.f250753g + "|read|" + read + "|" + systemNetworkType + "|" + BaseConstants.CMD_QUALITYTEST + "|" + ((int) BaseApplication.monitor.getSTATUS()) + "|" + bVar.toString());
                    }
                } else {
                    b bVar2 = c.f250738q.get(Integer.valueOf(this.monitorSocketImpl.f250753g.hashCode()));
                    if (bVar2 == null) {
                        c cVar2 = this.monitorSocketImpl;
                        bVar2 = new b(cVar2.f250750d, null, cVar2.f250751e, c.f250737p, read, systemNetworkType);
                        bVar2.f250731i = BaseApplication.monitor.getSTATUS();
                        c cVar3 = this.monitorSocketImpl;
                        bVar2.f250730h = cVar3.f250758l;
                        bVar2.f250732j = cVar3.f250753g.hashCode();
                        c.f250738q.put(Integer.valueOf(this.monitorSocketImpl.f250753g.hashCode()), bVar2);
                    } else {
                        c.f250738q.put(Integer.valueOf(this.monitorSocketImpl.f250753g.hashCode()), bVar2.a(read));
                    }
                    bVar = bVar2;
                    if (bVar.f250734l == null) {
                        this.monitorSocketImpl.a(bVar.f250732j, c.f250737p);
                    }
                }
                if (bVar != null) {
                }
                return read;
            }
            c cVar4 = this.monitorSocketImpl;
            if (cVar4.f250758l != null) {
                b bVar3 = c.f250738q.get(Integer.valueOf(cVar4.f250753g.hashCode()));
                if (bVar3 == null) {
                    c cVar5 = this.monitorSocketImpl;
                    b bVar4 = new b(cVar5.f250750d, cVar5.f250749c, cVar5.f250751e, c.f250737p, read, systemNetworkType);
                    c cVar6 = this.monitorSocketImpl;
                    bVar4.f250730h = cVar6.f250758l;
                    bVar4.f250732j = cVar6.f250753g.hashCode();
                    c.f250738q.put(Integer.valueOf(this.monitorSocketImpl.f250753g.hashCode()), bVar4);
                    bVar = bVar4;
                } else {
                    b a16 = bVar3.a(read);
                    a16.f250730h = this.monitorSocketImpl.f250758l;
                    bVar = a16;
                }
                bVar.f250731i = BaseApplication.monitor.getSTATUS();
                if (bVar.f250734l == null) {
                    this.monitorSocketImpl.a(bVar.f250732j, c.f250737p);
                }
                if (bVar != null) {
                    bVar.f250723a = this.monitorSocketImpl.f250752f;
                    bVar.f250733k = System.currentTimeMillis();
                }
                return read;
            }
            bVar = null;
            if (bVar != null) {
            }
            return read;
        } catch (SocketException e17) {
            QLog.e(MonitorSocketImplFactory.tag, 1, "SocketException!", e17);
            throw e17;
        } catch (SocketTimeoutException e18) {
            throw e18;
        }
    }
}
