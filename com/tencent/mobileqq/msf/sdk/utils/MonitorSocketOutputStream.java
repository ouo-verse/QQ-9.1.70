package com.tencent.mobileqq.msf.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.msf.core.net.t.g;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.IOException;
import java.io.OutputStream;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MonitorSocketOutputStream extends OutputStream {
    static IPatchRedirector $redirector_;
    private Context context;
    private OutputStream mOutputStream;
    private c monitorSocketImpl;
    private String refer;
    private String urlTag;

    public MonitorSocketOutputStream(OutputStream outputStream, c cVar, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, outputStream, cVar, context);
            return;
        }
        this.refer = null;
        this.urlTag = "";
        this.mOutputStream = outputStream;
        this.monitorSocketImpl = cVar;
        this.context = context;
    }

    public static String getMType(byte[] bArr, int i3, int i16) {
        String str = c.f250735n;
        int i17 = i3;
        int i18 = i17;
        while (i17 < i16 + i3) {
            int i19 = i17 + 1;
            if (i19 == i16) {
                return str;
            }
            if (bArr[i17] == 13 && bArr[i19] == 10) {
                String str2 = new String(bArr, i18, i17 - i18);
                int indexOf = str2.indexOf("mType=");
                if (indexOf == -1) {
                    i18 = i17 + 2;
                } else {
                    int i26 = indexOf + 6;
                    int indexOf2 = str2.indexOf(ContainerUtils.FIELD_DELIMITER, i26);
                    if (indexOf2 == -1) {
                        int indexOf3 = str2.indexOf(" ", i26);
                        if (indexOf3 != -1) {
                            return str2.substring(i26, indexOf3);
                        }
                        return str;
                    }
                    return str2.substring(i26, indexOf2);
                }
            }
            i17 = i19;
        }
        return str;
    }

    public static String getRefer(byte[] bArr, int i3) {
        String str;
        int i16 = i3;
        while (true) {
            if (i16 < bArr.length) {
                if (bArr[i16] == 13 && bArr[i16 + 1] == 10) {
                    String[] split = new String(bArr, i3, i16 - i3).trim().split(" ");
                    if (split.length == 2) {
                        str = split[0];
                    } else {
                        str = "";
                    }
                } else {
                    i16++;
                }
            } else {
                str = null;
                break;
            }
        }
        if (str == null) {
            for (int length = bArr.length - 1; length >= i3; length--) {
                if (bArr[length] == 32) {
                    str = new String(bArr, i3, length - i3);
                    String[] split2 = str.trim().split(" ");
                    if (split2.length == 2) {
                        str = split2[0];
                    }
                }
            }
        }
        if (str == null) {
            str = new String(bArr, i3, bArr.length - i3);
        }
        if (str.length() > 100) {
            return str.substring(0, 42);
        }
        return str;
    }

    private void initKnownMType() {
        if (!this.monitorSocketImpl.f250754h.contains("beacon") && !this.monitorSocketImpl.f250754h.contains("feedback")) {
            if (this.monitorSocketImpl.f250754h.contains("map")) {
                this.monitorSocketImpl.f250758l = "Map";
                return;
            }
            if (!this.monitorSocketImpl.f250754h.toLowerCase().contains("tmassistant") && !this.monitorSocketImpl.f250754h.contains("apkupdate")) {
                if (this.monitorSocketImpl.f250754h.contains("smtt")) {
                    this.monitorSocketImpl.f250758l = GdtLog.WEB_TAG;
                    return;
                }
                if (this.monitorSocketImpl.f250754h.contains(ProcessConstant.READINJOY)) {
                    this.monitorSocketImpl.f250758l = "Readinjoy";
                    return;
                }
                if (!this.monitorSocketImpl.f250754h.contains("biz") && !this.monitorSocketImpl.f250754h.contains("troop")) {
                    if (this.monitorSocketImpl.f250754h.contains("highway") && TextUtils.isEmpty(this.refer)) {
                        this.monitorSocketImpl.f250758l = "highway";
                        return;
                    }
                    if (!TextUtils.isEmpty(this.refer)) {
                        if (this.refer.contains("beacon")) {
                            this.monitorSocketImpl.f250758l = "beacon";
                            this.refer = "/mType=beacon";
                            return;
                        } else if (this.refer.contains("mstat/report")) {
                            this.monitorSocketImpl.f250758l = "MTA";
                            return;
                        } else {
                            if (this.refer.contains("comdata")) {
                                this.monitorSocketImpl.f250758l = "comdata";
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                this.monitorSocketImpl.f250758l = "AppDepart";
                return;
            }
            this.monitorSocketImpl.f250758l = "yingyongbao";
            return;
        }
        this.monitorSocketImpl.f250758l = "beacon";
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.mOutputStream.close();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.mOutputStream.flush();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0112 A[Catch: Exception -> 0x0242, TRY_LEAVE, TryCatch #1 {Exception -> 0x0242, blocks: (B:10:0x0043, B:14:0x005d, B:17:0x0112, B:20:0x0120, B:22:0x0126, B:23:0x012d, B:25:0x0136, B:26:0x014b, B:27:0x0153, B:30:0x0162, B:32:0x016c, B:34:0x017c, B:36:0x0188, B:39:0x01c2, B:41:0x01ce, B:43:0x01d8, B:44:0x01e7, B:46:0x01f4, B:48:0x0201, B:50:0x0209, B:56:0x0235, B:58:0x023b, B:63:0x0192, B:65:0x019a, B:67:0x01a5, B:68:0x01b0, B:70:0x01ba, B:71:0x0179, B:72:0x00ae, B:74:0x00bc, B:52:0x0220), top: B:9:0x0043, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01d8 A[Catch: Exception -> 0x0242, TryCatch #1 {Exception -> 0x0242, blocks: (B:10:0x0043, B:14:0x005d, B:17:0x0112, B:20:0x0120, B:22:0x0126, B:23:0x012d, B:25:0x0136, B:26:0x014b, B:27:0x0153, B:30:0x0162, B:32:0x016c, B:34:0x017c, B:36:0x0188, B:39:0x01c2, B:41:0x01ce, B:43:0x01d8, B:44:0x01e7, B:46:0x01f4, B:48:0x0201, B:50:0x0209, B:56:0x0235, B:58:0x023b, B:63:0x0192, B:65:0x019a, B:67:0x01a5, B:68:0x01b0, B:70:0x01ba, B:71:0x0179, B:72:0x00ae, B:74:0x00bc, B:52:0x0220), top: B:9:0x0043, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01e7 A[Catch: Exception -> 0x0242, TryCatch #1 {Exception -> 0x0242, blocks: (B:10:0x0043, B:14:0x005d, B:17:0x0112, B:20:0x0120, B:22:0x0126, B:23:0x012d, B:25:0x0136, B:26:0x014b, B:27:0x0153, B:30:0x0162, B:32:0x016c, B:34:0x017c, B:36:0x0188, B:39:0x01c2, B:41:0x01ce, B:43:0x01d8, B:44:0x01e7, B:46:0x01f4, B:48:0x0201, B:50:0x0209, B:56:0x0235, B:58:0x023b, B:63:0x0192, B:65:0x019a, B:67:0x01a5, B:68:0x01b0, B:70:0x01ba, B:71:0x0179, B:72:0x00ae, B:74:0x00bc, B:52:0x0220), top: B:9:0x0043, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0209 A[Catch: Exception -> 0x0242, TRY_LEAVE, TryCatch #1 {Exception -> 0x0242, blocks: (B:10:0x0043, B:14:0x005d, B:17:0x0112, B:20:0x0120, B:22:0x0126, B:23:0x012d, B:25:0x0136, B:26:0x014b, B:27:0x0153, B:30:0x0162, B:32:0x016c, B:34:0x017c, B:36:0x0188, B:39:0x01c2, B:41:0x01ce, B:43:0x01d8, B:44:0x01e7, B:46:0x01f4, B:48:0x0201, B:50:0x0209, B:56:0x0235, B:58:0x023b, B:63:0x0192, B:65:0x019a, B:67:0x01a5, B:68:0x01b0, B:70:0x01ba, B:71:0x0179, B:72:0x00ae, B:74:0x00bc, B:52:0x0220), top: B:9:0x0043, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01a5 A[Catch: Exception -> 0x0242, TryCatch #1 {Exception -> 0x0242, blocks: (B:10:0x0043, B:14:0x005d, B:17:0x0112, B:20:0x0120, B:22:0x0126, B:23:0x012d, B:25:0x0136, B:26:0x014b, B:27:0x0153, B:30:0x0162, B:32:0x016c, B:34:0x017c, B:36:0x0188, B:39:0x01c2, B:41:0x01ce, B:43:0x01d8, B:44:0x01e7, B:46:0x01f4, B:48:0x0201, B:50:0x0209, B:56:0x0235, B:58:0x023b, B:63:0x0192, B:65:0x019a, B:67:0x01a5, B:68:0x01b0, B:70:0x01ba, B:71:0x0179, B:72:0x00ae, B:74:0x00bc, B:52:0x0220), top: B:9:0x0043, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01b0 A[Catch: Exception -> 0x0242, TryCatch #1 {Exception -> 0x0242, blocks: (B:10:0x0043, B:14:0x005d, B:17:0x0112, B:20:0x0120, B:22:0x0126, B:23:0x012d, B:25:0x0136, B:26:0x014b, B:27:0x0153, B:30:0x0162, B:32:0x016c, B:34:0x017c, B:36:0x0188, B:39:0x01c2, B:41:0x01ce, B:43:0x01d8, B:44:0x01e7, B:46:0x01f4, B:48:0x0201, B:50:0x0209, B:56:0x0235, B:58:0x023b, B:63:0x0192, B:65:0x019a, B:67:0x01a5, B:68:0x01b0, B:70:0x01ba, B:71:0x0179, B:72:0x00ae, B:74:0x00bc, B:52:0x0220), top: B:9:0x0043, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void getSocketInfo(byte[] bArr, int i3, int i16) {
        boolean z16;
        int indexOf;
        int indexOf2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.monitorSocketImpl.f250758l = c.f250735n;
        MonitorHttpInfo monitorHttpInfo = new MonitorHttpInfo();
        try {
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, 0, bArr2, 0, 4);
            if (new String(bArr2).equals("POST")) {
                this.refer = getRefer(bArr, 5);
                this.urlTag = "http://" + this.monitorSocketImpl.f250750d + ":" + this.monitorSocketImpl.f250751e + this.refer;
                monitorHttpInfo.setMethod("POST");
                monitorHttpInfo.setHost(this.monitorSocketImpl.f250750d);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(this.monitorSocketImpl.f250751e);
                sb5.append("");
                monitorHttpInfo.setPort(sb5.toString());
                monitorHttpInfo.setUrl(this.refer);
            } else if (new String(bArr2).equals("GET ")) {
                this.refer = getRefer(bArr, 4);
                this.urlTag = "http://" + this.monitorSocketImpl.f250750d + ":" + this.monitorSocketImpl.f250751e + this.refer;
                monitorHttpInfo.setMethod("GET");
                monitorHttpInfo.setHost(this.monitorSocketImpl.f250750d);
                StringBuilder sb6 = new StringBuilder();
                sb6.append(this.monitorSocketImpl.f250751e);
                sb6.append("");
                monitorHttpInfo.setPort(sb6.toString());
                monitorHttpInfo.setUrl(this.refer);
            } else {
                z16 = false;
                if (z16) {
                    String str = new String(bArr, i3, i16);
                    if (QLog.isColorLevel() && (indexOf2 = str.indexOf("\r\n")) > 0) {
                        QLog.d(MonitorSocketImplFactory.tag, 2, str.substring(0, indexOf2));
                    }
                    int indexOf3 = str.indexOf("Host: ");
                    if (indexOf3 >= 0) {
                        this.monitorSocketImpl.f250749c = str.substring(indexOf3 + 6, str.indexOf("\r\n", indexOf3));
                        monitorHttpInfo.setHost(this.monitorSocketImpl.f250749c);
                    }
                    this.monitorSocketImpl.f250758l = getMType(bArr, i3, i16);
                }
                if (!this.monitorSocketImpl.f250758l.equals(c.f250735n) || this.monitorSocketImpl.f250758l.equals("Other") || this.monitorSocketImpl.f250758l.contains("beacon?")) {
                    initKnownMType();
                }
                if ((!this.monitorSocketImpl.f250758l.equals(c.f250735n) || this.monitorSocketImpl.f250758l.equals("Other")) && !TextUtils.isEmpty(this.refer)) {
                    indexOf = this.refer.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                    if (indexOf <= 0) {
                        this.monitorSocketImpl.f250758l = this.refer.substring(0, indexOf);
                    } else if (this.refer.length() < 20) {
                        this.monitorSocketImpl.f250758l = this.refer;
                    }
                }
                if (z16 && this.monitorSocketImpl.f250758l.equals(c.f250735n)) {
                    if (!this.monitorSocketImpl.f250749c.contains(QQWinkConstants.VALID_HOST)) {
                        c cVar = this.monitorSocketImpl;
                        String str2 = cVar.f250749c;
                        cVar.f250758l = str2.substring(0, str2.indexOf(QQWinkConstants.VALID_HOST));
                    } else if (this.monitorSocketImpl.f250749c.contains(".com") || this.monitorSocketImpl.f250749c.contains(".cn")) {
                        c cVar2 = this.monitorSocketImpl;
                        cVar2.f250758l = cVar2.f250749c;
                    }
                }
                if (!z16) {
                    StringBuilder sb7 = new StringBuilder();
                    c cVar3 = this.monitorSocketImpl;
                    sb7.append(cVar3.f250749c);
                    sb7.append(this.refer);
                    cVar3.f250749c = sb7.toString();
                    try {
                        monitorHttpInfo.setType(this.monitorSocketImpl.f250758l);
                        byte[] bArr3 = new byte[i16];
                        System.arraycopy(bArr, i3, bArr3, 0, i16);
                        monitorHttpInfo.setRequestBuffer(bArr3);
                        this.monitorSocketImpl.f250755i = monitorHttpInfo;
                        return;
                    } catch (Throwable th5) {
                        if (QLog.isColorLevel()) {
                            QLog.d(MonitorSocketImplFactory.tag, 2, "array copy exception!", th5);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            z16 = true;
            if (z16) {
            }
            if (!this.monitorSocketImpl.f250758l.equals(c.f250735n)) {
            }
            initKnownMType();
            if (!this.monitorSocketImpl.f250758l.equals(c.f250735n)) {
            }
            indexOf = this.refer.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
            if (indexOf <= 0) {
            }
            if (z16) {
                if (!this.monitorSocketImpl.f250749c.contains(QQWinkConstants.VALID_HOST)) {
                }
            }
            if (!z16) {
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(MonitorSocketImplFactory.tag, 2, "getSocketInfo exception!", e16);
            }
        }
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.mOutputStream.hashCode();
    }

    @Override // java.io.OutputStream
    public void write(int i3) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.mOutputStream.write(i3);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            write(bArr, 0, bArr.length);
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bArr);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0292 A[Catch: OutOfMemoryError -> 0x029f, Exception -> 0x02a6, TRY_LEAVE, TryCatch #2 {Exception -> 0x02a6, OutOfMemoryError -> 0x029f, blocks: (B:12:0x0041, B:15:0x004a, B:17:0x0050, B:19:0x005b, B:21:0x006e, B:24:0x0076, B:27:0x007d, B:29:0x0083, B:30:0x0086, B:32:0x008c, B:34:0x0092, B:39:0x0292, B:43:0x00a0, B:46:0x00b2, B:48:0x00b8, B:49:0x00eb, B:51:0x00f7, B:53:0x010d, B:54:0x015f, B:56:0x0163, B:57:0x016c, B:59:0x0172, B:60:0x0149, B:61:0x01ab, B:63:0x01c1, B:64:0x0212, B:66:0x0216, B:67:0x01fc, B:68:0x0220, B:70:0x0226, B:72:0x023a, B:73:0x0279, B:75:0x0285, B:76:0x026e, B:77:0x0055), top: B:11:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    @Override // java.io.OutputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void write(byte[] bArr, int i3, int i16) throws IOException {
        int systemNetworkType;
        b a16;
        NetworkInfo activeNetworkInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.mOutputStream.write(bArr, i3, i16);
        if (MonitorSocketImplFactory.isServerSocket(toString())) {
            return;
        }
        try {
            String str = this.monitorSocketImpl.f250752f;
            if (str != null && str.contains(":MSF")) {
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
            if (this.monitorSocketImpl.f250758l == null) {
                getSocketInfo(bArr, i3, i16);
            }
            String str2 = this.monitorSocketImpl.f250752f;
            if (str2 != null && str2.contains(":MSF")) {
                if (!n.f248797a0.contains(toString())) {
                    if (BaseApplication.exclusiveStreamList.contains(toString())) {
                        if (QLog.isColorLevel()) {
                            QLog.d(MonitorSocketImplFactory.tag, 2, "|" + this.monitorSocketImpl.f250753g + "|write|" + i16 + "|" + systemNetworkType + "|BigData|" + ((int) BaseApplication.monitor.getSTATUS()));
                        }
                    } else {
                        if (g.f249399g.contains(toString())) {
                            a16 = c.f250739r.get(Integer.valueOf(this.monitorSocketImpl.f250753g.hashCode()));
                            if (a16 == null) {
                                c cVar = this.monitorSocketImpl;
                                a16 = new b(cVar.f250750d, null, cVar.f250751e, c.f250736o, i16, systemNetworkType);
                                a16.f250730h = "QualityTest";
                                a16.f250731i = BaseApplication.monitor.getSTATUS();
                                a16.f250732j = this.monitorSocketImpl.f250753g.hashCode();
                                c.f250739r.put(Integer.valueOf(this.monitorSocketImpl.f250753g.hashCode()), a16);
                            } else {
                                c.f250739r.put(Integer.valueOf(this.monitorSocketImpl.f250753g.hashCode()), a16.a(i16));
                            }
                            if (a16.f250734l == null) {
                                this.monitorSocketImpl.a(a16.f250732j, c.f250736o);
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d(MonitorSocketImplFactory.tag, 2, "|" + this.monitorSocketImpl.f250753g + "|write|" + i16 + "|" + systemNetworkType + "|" + BaseConstants.CMD_QUALITYTEST + "|" + ((int) BaseApplication.monitor.getSTATUS()));
                            }
                        } else {
                            a16 = c.f250739r.get(Integer.valueOf(this.monitorSocketImpl.f250753g.hashCode()));
                            if (a16 == null) {
                                c cVar2 = this.monitorSocketImpl;
                                a16 = new b(cVar2.f250750d, null, cVar2.f250751e, c.f250736o, i16, systemNetworkType);
                                a16.f250731i = BaseApplication.monitor.getSTATUS();
                                c cVar3 = this.monitorSocketImpl;
                                a16.f250730h = cVar3.f250758l;
                                a16.f250732j = cVar3.f250753g.hashCode();
                                c.f250739r.put(Integer.valueOf(this.monitorSocketImpl.f250753g.hashCode()), a16);
                            } else {
                                c.f250739r.put(Integer.valueOf(this.monitorSocketImpl.f250753g.hashCode()), a16.a(i16));
                            }
                            if (a16.f250734l == null) {
                                this.monitorSocketImpl.a(a16.f250732j, c.f250736o);
                            }
                        }
                        if (a16 == null) {
                        }
                    }
                }
                a16 = null;
                if (a16 == null) {
                }
            } else {
                c cVar4 = this.monitorSocketImpl;
                if (cVar4.f250758l != null) {
                    b bVar = c.f250739r.get(Integer.valueOf(cVar4.f250753g.hashCode()));
                    if (bVar == null) {
                        c cVar5 = this.monitorSocketImpl;
                        a16 = new b(cVar5.f250750d, cVar5.f250749c, cVar5.f250751e, c.f250736o, i16, systemNetworkType);
                        c cVar6 = this.monitorSocketImpl;
                        a16.f250730h = cVar6.f250758l;
                        a16.f250732j = cVar6.f250753g.hashCode();
                        c.f250739r.put(Integer.valueOf(this.monitorSocketImpl.f250753g.hashCode()), a16);
                    } else {
                        a16 = bVar.a(i16);
                        a16.f250730h = this.monitorSocketImpl.f250758l;
                    }
                    a16.f250731i = BaseApplication.monitor.getSTATUS();
                    if (a16.f250734l == null) {
                        this.monitorSocketImpl.a(a16.f250732j, c.f250736o);
                    }
                    if (a16 == null) {
                        a16.f250723a = this.monitorSocketImpl.f250752f;
                        a16.f250733k = System.currentTimeMillis();
                        return;
                    }
                    return;
                }
                a16 = null;
                if (a16 == null) {
                }
            }
        } catch (Exception e16) {
            QLog.d(MonitorSocketImplFactory.tag, 1, "analyze netflow failed.", e16);
        } catch (OutOfMemoryError unused) {
            QLog.d(MonitorSocketImplFactory.tag, 1, "write OOM.");
        }
    }
}
