package com.tencent.apkupdate.logic.protocol;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.text.TextUtils;
import android.util.Log;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.apkupdate.logic.protocol.jce.JceCmd;
import com.tencent.apkupdate.logic.protocol.jce.Net;
import com.tencent.apkupdate.logic.protocol.jce.ReqHead;
import com.tencent.apkupdate.logic.protocol.jce.Request;
import com.tencent.apkupdate.logic.protocol.jce.Response;
import com.tencent.apkupdate.logic.protocol.jce.Terminal;
import com.tencent.apkupdate.obfuscated.a;
import com.tencent.apkupdate.obfuscated.k;
import com.tencent.apkupdate.obfuscated.l;
import com.tencent.apkupdate.obfuscated.p;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.tmassistant.common.ProtocolPackage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.zip.Deflater;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class BaseHttpRequest implements Runnable {
    static IPatchRedirector $redirector_ = null;
    public static String REQUEST_SERVER_URL = "https://masdkv6.3g.qq.com";
    private static String TAG = "BaseHttpRequest";
    private boolean isCancel;
    private JceStruct sendRequest;

    public BaseHttpRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.sendRequest = null;
            this.isCancel = false;
        }
    }

    public boolean isCancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isCancel;
    }

    public abstract void onDataReceiveFailed();

    public abstract void onFinished(JceStruct jceStruct, JceStruct jceStruct2);

    public void prepareData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0269 A[LOOP:1: B:102:0x0265->B:104:0x0269, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0279 A[EDGE_INSN: B:105:0x0279->B:106:0x0279 BREAK  A[LOOP:1: B:102:0x0265->B:104:0x0269], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x027f A[LOOP:2: B:107:0x027d->B:108:0x027f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02ea A[EDGE_INSN: B:150:0x02ea->B:151:0x02ea BREAK  A[LOOP:5: B:138:0x02ce->B:148:0x02ce], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0396 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0105 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01cb  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        String str;
        int i3;
        int i16;
        Terminal terminal;
        String str2;
        int i17;
        byte[] byteArray;
        k kVar;
        int length;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream;
        NetworkInfo activeNetworkInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (isCancel()) {
            return;
        }
        prepareData();
        JceStruct jceStruct = this.sendRequest;
        if (jceStruct == null) {
            return;
        }
        Request request = new Request();
        l a16 = l.a();
        Context context = a16.f72549a;
        if (context != null && context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != -1 && (activeNetworkInfo = ((ConnectivityManager) a16.f72549a.getSystemService("connectivity")).getActiveNetworkInfo()) != null) {
            if (NetworkMonitor.getType(activeNetworkInfo) == 1) {
                str = Global.TRACKING_WIFI;
            } else {
                String netGetExInfo = NetworkMonitor.netGetExInfo(activeNetworkInfo);
                if (netGetExInfo != null) {
                    str = netGetExInfo.toUpperCase();
                }
            }
            if (!TextUtils.isEmpty(str)) {
                if (str.equals(Global.TRACKING_WIFI)) {
                    i3 = 1;
                } else if (str.equals("UN_DETECT")) {
                    i3 = 0;
                } else if (str.equals("CMWAP")) {
                    i3 = 2;
                } else if (str.equals("CMNET")) {
                    i3 = 3;
                } else if (str.equals("UNIWAP")) {
                    i3 = 4;
                } else if (str.equals("UNINET")) {
                    i3 = 5;
                } else if (str.equals("WAP3G")) {
                    i3 = 6;
                } else if (str.equals("NET3G")) {
                    i3 = 7;
                } else if (str.equals("CTWAP")) {
                    i3 = 8;
                } else if (str.equals("CTNET")) {
                    i3 = 9;
                }
                l.a().getClass();
                Net net = new Net((byte) i3, "", 0, (byte) (!TextUtils.isEmpty(Proxy.getDefaultHost()) ? 1 : 0));
                ReqHead reqHead = new ReqHead();
                synchronized (l.class) {
                    i16 = l.f72547d;
                    l.f72547d = i16 + 1;
                }
                reqHead.requestId = i16;
                String simpleName = jceStruct.getClass().getSimpleName();
                reqHead.cmdId = JceCmd.convert(simpleName.substring(0, simpleName.length() - 7)).value();
                l.a().getClass();
                reqHead.qua = l.f72546c;
                reqHead.phoneGuid = l.a().b();
                l a17 = l.a();
                synchronized (a17) {
                    if (l.f72548e == null) {
                        String b16 = a17.b();
                        synchronized (l.class) {
                            Terminal terminal2 = new Terminal();
                            l.f72548e = terminal2;
                            terminal2.androidId = "";
                            terminal2.androidIdSdCard = b16;
                            terminal2.imei = "";
                            terminal2.imsi = "";
                            terminal2.macAdress = "";
                        }
                    }
                    terminal = l.f72548e;
                }
                reqHead.terminal = terminal;
                reqHead.assistantAPILevel = 0;
                reqHead.assistantVersionCode = 0;
                reqHead.net = net;
                Context context2 = l.a().f72549a;
                if (context2 != null) {
                    str2 = context2.getPackageName();
                } else {
                    str2 = "";
                }
                reqHead.hostPackageName = str2;
                Context context3 = l.a().f72549a;
                try {
                    if (context3 != null) {
                        try {
                            i17 = InstalledAppListMonitor.getPackageInfo(context3.getPackageManager(), context3.getPackageName(), 0).versionCode;
                        } catch (PackageManager.NameNotFoundException e16) {
                            e16.printStackTrace();
                        }
                        reqHead.hostVersionCode = i17;
                        request.head = reqHead;
                        JceOutputStream jceOutputStream = new JceOutputStream();
                        jceOutputStream.setServerEncoding("utf-8");
                        jceStruct.writeTo(jceOutputStream);
                        byteArray = jceOutputStream.toByteArray();
                        request.body = byteArray;
                        request.head.encryptWithPack = (byte) 0;
                        ByteArrayOutputStream byteArrayOutputStream2 = null;
                        if (byteArray.length > 256) {
                            Deflater deflater = new Deflater();
                            try {
                                byteArrayOutputStream = new ByteArrayOutputStream(byteArray.length);
                            } catch (Throwable th5) {
                                th = th5;
                            }
                            try {
                                deflater.setLevel(9);
                                deflater.setInput(byteArray);
                                deflater.finish();
                                byte[] bArr2 = new byte[1024];
                                while (!deflater.finished()) {
                                    byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
                                }
                                deflater.end();
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e17) {
                                    e17.printStackTrace();
                                }
                                request.body = byteArrayOutputStream.toByteArray();
                                ReqHead reqHead2 = request.head;
                                reqHead2.encryptWithPack = (byte) (reqHead2.encryptWithPack | 1);
                            } catch (Throwable th6) {
                                th = th6;
                                byteArrayOutputStream2 = byteArrayOutputStream;
                                Throwable th7 = th;
                                deflater.end();
                                if (byteArrayOutputStream2 != null) {
                                    try {
                                        byteArrayOutputStream2.close();
                                        throw th7;
                                    } catch (IOException e18) {
                                        e18.printStackTrace();
                                        throw th7;
                                    }
                                }
                                throw th7;
                            }
                        }
                        byte[] bArr3 = request.body;
                        byte[] bytes = ProtocolPackage.CRYPT_KEY.getBytes();
                        kVar = new k();
                        length = bArr3.length;
                        byte[] bArr4 = new byte[8];
                        kVar.f72534a = bArr4;
                        kVar.f72535b = new byte[8];
                        kVar.f72539f = 1;
                        kVar.f72540g = 0;
                        kVar.f72538e = 0;
                        kVar.f72537d = 0;
                        kVar.f72541h = bytes;
                        kVar.f72542i = true;
                        i18 = (length + 10) % 8;
                        kVar.f72539f = i18;
                        if (i18 != 0) {
                            kVar.f72539f = 8 - i18;
                        }
                        kVar.f72536c = new byte[kVar.f72539f + length + 10];
                        bArr4[0] = (byte) ((kVar.f72544k.nextInt() & 248) | kVar.f72539f);
                        i19 = 1;
                        while (true) {
                            i26 = kVar.f72539f;
                            if (i19 <= i26) {
                                break;
                            }
                            kVar.f72534a[i19] = (byte) (kVar.f72544k.nextInt() & 255);
                            i19++;
                        }
                        kVar.f72539f = i26 + 1;
                        for (i27 = 0; i27 < 8; i27++) {
                            kVar.f72535b[i27] = 0;
                        }
                        kVar.f72540g = 1;
                        while (kVar.f72540g <= 2) {
                            int i29 = kVar.f72539f;
                            if (i29 < 8) {
                                byte[] bArr5 = kVar.f72534a;
                                kVar.f72539f = i29 + 1;
                                bArr5[i29] = (byte) (kVar.f72544k.nextInt() & 255);
                                kVar.f72540g++;
                            }
                            if (kVar.f72539f == 8) {
                                kVar.a();
                            }
                        }
                        int i36 = 0;
                        while (length > 0) {
                            int i37 = kVar.f72539f;
                            if (i37 < 8) {
                                byte[] bArr6 = kVar.f72534a;
                                kVar.f72539f = i37 + 1;
                                bArr6[i37] = bArr3[i36];
                                length--;
                                i36++;
                            }
                            if (kVar.f72539f == 8) {
                                kVar.a();
                            }
                        }
                        kVar.f72540g = 1;
                        while (true) {
                            i28 = kVar.f72540g;
                            if (i28 <= 7) {
                                break;
                            }
                            int i38 = kVar.f72539f;
                            if (i38 < 8) {
                                byte[] bArr7 = kVar.f72534a;
                                kVar.f72539f = i38 + 1;
                                bArr7[i38] = 0;
                                kVar.f72540g = i28 + 1;
                            }
                            if (kVar.f72539f == 8) {
                                kVar.a();
                            }
                        }
                        request.body = kVar.f72536c;
                        ReqHead reqHead3 = request.head;
                        reqHead3.encryptWithPack = (byte) (reqHead3.encryptWithPack | 2);
                        JceOutputStream jceOutputStream2 = new JceOutputStream();
                        jceOutputStream2.setServerEncoding("utf-8");
                        request.writeTo(jceOutputStream2);
                        byte[] byteArray2 = jceOutputStream2.toByteArray();
                        URL url = new URL(REQUEST_SERVER_URL);
                        Log.i(TAG, ">run serverUrl=" + url);
                        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                        SSLContext sSLContext = SSLContext.getInstance("SSL");
                        sSLContext.init(null, null, null);
                        httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                        httpsURLConnection.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                        httpsURLConnection.setRequestMethod("POST");
                        httpsURLConnection.setDoOutput(true);
                        httpsURLConnection.setDoInput(true);
                        httpsURLConnection.setUseCaches(false);
                        httpsURLConnection.addRequestProperty("User-Agent", "AssistantDownloader");
                        httpsURLConnection.addRequestProperty("Content-Type", "application/octet-stream");
                        httpsURLConnection.setConnectTimeout(30000);
                        httpsURLConnection.setReadTimeout(30000);
                        OutputStream outputStream = httpsURLConnection.getOutputStream();
                        outputStream.write(byteArray2);
                        outputStream.flush();
                        int responseCode = httpsURLConnection.getResponseCode();
                        p.a(TAG, ">run rspCode:" + responseCode);
                        if (!isCancel()) {
                            return;
                        }
                        if (responseCode == 200) {
                            InputStream inputStream = httpsURLConnection.getInputStream();
                            if (inputStream != null) {
                                ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                                byte[] bArr8 = new byte[2048];
                                while (true) {
                                    int read = inputStream.read(bArr8);
                                    if (read == -1) {
                                        break;
                                    } else {
                                        byteArrayOutputStream3.write(bArr8, 0, read);
                                    }
                                }
                                byteArrayOutputStream3.flush();
                                byte[] byteArray3 = byteArrayOutputStream3.toByteArray();
                                if (byteArray3 != null && byteArray3.length > 4) {
                                    Log.i(TAG, ">run data.length:" + byteArray3.length);
                                    Response c16 = a.c(byteArray3);
                                    if (c16 != null && (bArr = c16.body) != null) {
                                        JceStruct b17 = a.b(this.sendRequest, bArr);
                                        if (b17 != null) {
                                            Log.i(TAG, ">run unpageageJceResponse succ");
                                            onFinished(this.sendRequest, b17);
                                            return;
                                        }
                                        Log.e(TAG, ">run unpageageJceResponse failed, jceResponse is null");
                                    } else {
                                        Log.e(TAG, ">run unpageageJceResponse failed,jceResp or jceResp.body null");
                                    }
                                } else {
                                    Log.e(TAG, ">run data maybe null:" + byteArray3);
                                }
                            } else {
                                Log.e(TAG, ">run inputStream == null");
                            }
                        }
                        onDataReceiveFailed();
                        return;
                    }
                    URL url2 = new URL(REQUEST_SERVER_URL);
                    Log.i(TAG, ">run serverUrl=" + url2);
                    HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url2.openConnection();
                    SSLContext sSLContext2 = SSLContext.getInstance("SSL");
                    sSLContext2.init(null, null, null);
                    httpsURLConnection2.setSSLSocketFactory(sSLContext2.getSocketFactory());
                    httpsURLConnection2.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                    httpsURLConnection2.setRequestMethod("POST");
                    httpsURLConnection2.setDoOutput(true);
                    httpsURLConnection2.setDoInput(true);
                    httpsURLConnection2.setUseCaches(false);
                    httpsURLConnection2.addRequestProperty("User-Agent", "AssistantDownloader");
                    httpsURLConnection2.addRequestProperty("Content-Type", "application/octet-stream");
                    httpsURLConnection2.setConnectTimeout(30000);
                    httpsURLConnection2.setReadTimeout(30000);
                    OutputStream outputStream2 = httpsURLConnection2.getOutputStream();
                    outputStream2.write(byteArray2);
                    outputStream2.flush();
                    int responseCode2 = httpsURLConnection2.getResponseCode();
                    p.a(TAG, ">run rspCode:" + responseCode2);
                    if (!isCancel()) {
                    }
                } catch (Throwable th8) {
                    Log.e(TAG, ">run error:", th8);
                    onDataReceiveFailed();
                    return;
                }
                i17 = 0;
                reqHead.hostVersionCode = i17;
                request.head = reqHead;
                JceOutputStream jceOutputStream3 = new JceOutputStream();
                jceOutputStream3.setServerEncoding("utf-8");
                jceStruct.writeTo(jceOutputStream3);
                byteArray = jceOutputStream3.toByteArray();
                request.body = byteArray;
                request.head.encryptWithPack = (byte) 0;
                ByteArrayOutputStream byteArrayOutputStream22 = null;
                if (byteArray.length > 256) {
                }
                byte[] bArr32 = request.body;
                byte[] bytes2 = ProtocolPackage.CRYPT_KEY.getBytes();
                kVar = new k();
                length = bArr32.length;
                byte[] bArr42 = new byte[8];
                kVar.f72534a = bArr42;
                kVar.f72535b = new byte[8];
                kVar.f72539f = 1;
                kVar.f72540g = 0;
                kVar.f72538e = 0;
                kVar.f72537d = 0;
                kVar.f72541h = bytes2;
                kVar.f72542i = true;
                i18 = (length + 10) % 8;
                kVar.f72539f = i18;
                if (i18 != 0) {
                }
                kVar.f72536c = new byte[kVar.f72539f + length + 10];
                bArr42[0] = (byte) ((kVar.f72544k.nextInt() & 248) | kVar.f72539f);
                i19 = 1;
                while (true) {
                    i26 = kVar.f72539f;
                    if (i19 <= i26) {
                    }
                    kVar.f72534a[i19] = (byte) (kVar.f72544k.nextInt() & 255);
                    i19++;
                }
                kVar.f72539f = i26 + 1;
                while (i27 < 8) {
                }
                kVar.f72540g = 1;
                while (kVar.f72540g <= 2) {
                }
                int i362 = 0;
                while (length > 0) {
                }
                kVar.f72540g = 1;
                while (true) {
                    i28 = kVar.f72540g;
                    if (i28 <= 7) {
                    }
                }
                request.body = kVar.f72536c;
                ReqHead reqHead32 = request.head;
                reqHead32.encryptWithPack = (byte) (reqHead32.encryptWithPack | 2);
                JceOutputStream jceOutputStream22 = new JceOutputStream();
                jceOutputStream22.setServerEncoding("utf-8");
                request.writeTo(jceOutputStream22);
                byte[] byteArray22 = jceOutputStream22.toByteArray();
            }
            i3 = 10;
            l.a().getClass();
            Net net2 = new Net((byte) i3, "", 0, (byte) (!TextUtils.isEmpty(Proxy.getDefaultHost()) ? 1 : 0));
            ReqHead reqHead4 = new ReqHead();
            synchronized (l.class) {
            }
        }
        str = "";
        if (!TextUtils.isEmpty(str)) {
        }
        i3 = 10;
        l.a().getClass();
        Net net22 = new Net((byte) i3, "", 0, (byte) (!TextUtils.isEmpty(Proxy.getDefaultHost()) ? 1 : 0));
        ReqHead reqHead42 = new ReqHead();
        synchronized (l.class) {
        }
    }

    public void setCancel(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.isCancel = z16;
        }
    }

    public void setData(JceStruct jceStruct) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) jceStruct);
        } else {
            this.sendRequest = jceStruct;
        }
    }
}
