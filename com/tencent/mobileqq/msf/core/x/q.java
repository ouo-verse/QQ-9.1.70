package com.tencent.mobileqq.msf.core.x;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceInputStream;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.net.NetContants;
import com.tencent.mobileqq.msf.core.net.t.c;
import com.tencent.mobileqq.msf.core.t;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.measure.utils.MeasureConst;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.fileupload.MultipartStream;

/* compiled from: P */
/* loaded from: classes15.dex */
public class q {
    static IPatchRedirector $redirector_ = null;
    public static final int A = 1;
    public static final int B = 2;
    private static final String C = "policyId";
    private static final String D = "DualConnTime";
    private static final String E = "__loginSdk_ssoWifilist";
    private static final String F = "__loginSdk_ssoMobilelist";
    private static final String G = "__loginSdk_ssoHttpWifilist";
    private static final String H = "__loginSdk_ssoHttpMobilelist";
    private static final String I = "__loginSdk_ssoQuicHttpList";
    private static final String J = "wifiused";
    private static final String K = "wifiname";
    private static final String L = "wifitime";
    private static final String M = "wifiUsedCount";
    private static final int N = 10;
    private static final long O = 604800000;
    public static final String P = "__loginSdk_checkmobilessotime";
    public static final String Q = "__loginSdk_checkwifissotime";
    public static final String R = "__loginSdk_mobilessotime";
    public static final String S = "__loginSdk_wifissotime";
    private static final String T = "delay_ap_race";
    private static final long U = 100;
    private static final long V = 1000;
    private static final long W = -1000;
    private static final String X = "https://configsvr.sparta.html5.qq.com/configsvr/";
    private static final byte[] Y;
    private static final String[] Z;

    /* renamed from: a0, reason: collision with root package name */
    private static final String[] f250377a0;

    /* renamed from: b0, reason: collision with root package name */
    private static final String[] f250378b0;

    /* renamed from: c0, reason: collision with root package name */
    private static final String[] f250379c0;

    /* renamed from: d0, reason: collision with root package name */
    private static final String[] f250380d0;

    /* renamed from: e0, reason: collision with root package name */
    private static final String[] f250381e0;

    /* renamed from: f0, reason: collision with root package name */
    private static final String[] f250382f0;

    /* renamed from: g0, reason: collision with root package name */
    private static final String[] f250383g0;

    /* renamed from: h0, reason: collision with root package name */
    private static final String[] f250384h0;

    /* renamed from: i0, reason: collision with root package name */
    private static final String[] f250385i0;

    /* renamed from: r, reason: collision with root package name */
    public static final String f250386r = "MSF.C.SsoListManager";

    /* renamed from: s, reason: collision with root package name */
    public static final String f250387s = "sso";

    /* renamed from: t, reason: collision with root package name */
    public static final String f250388t = "Socket";

    /* renamed from: u, reason: collision with root package name */
    public static final String f250389u = "Http";

    /* renamed from: v, reason: collision with root package name */
    public static final String f250390v = "Quic";

    /* renamed from: w, reason: collision with root package name */
    public static final String f250391w = "Wifi";

    /* renamed from: x, reason: collision with root package name */
    public static final String f250392x = "Mobile";

    /* renamed from: y, reason: collision with root package name */
    public static final String f250393y = "Ipv4";

    /* renamed from: z, reason: collision with root package name */
    public static final String f250394z = "Ipv6";

    /* renamed from: a, reason: collision with root package name */
    private boolean f250395a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f250396b;

    /* renamed from: c, reason: collision with root package name */
    private b f250397c;

    /* renamed from: d, reason: collision with root package name */
    private int f250398d;

    /* renamed from: e, reason: collision with root package name */
    private long f250399e;

    /* renamed from: f, reason: collision with root package name */
    private long f250400f;

    /* renamed from: g, reason: collision with root package name */
    private long f250401g;

    /* renamed from: h, reason: collision with root package name */
    private long f250402h;

    /* renamed from: i, reason: collision with root package name */
    private long f250403i;

    /* renamed from: j, reason: collision with root package name */
    private long f250404j;

    /* renamed from: k, reason: collision with root package name */
    private ConcurrentHashMap<c, CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d>> f250405k;

    /* renamed from: l, reason: collision with root package name */
    private ConcurrentHashMap<c, CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d>> f250406l;

    /* renamed from: m, reason: collision with root package name */
    private ConcurrentHashMap<String, Long> f250407m;

    /* renamed from: n, reason: collision with root package name */
    public AtomicLong f250408n;

    /* renamed from: o, reason: collision with root package name */
    private final com.tencent.mobileqq.msf.core.f0.d.a f250409o;

    /* renamed from: p, reason: collision with root package name */
    private final ArrayList<HashMap> f250410p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f250411q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a extends BaseThread {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f250412a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f250413b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f250414c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f250415d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f250416e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f250417f;

        a(boolean z16, String str, int i3, long j3, boolean z17, String str2) {
            this.f250412a = z16;
            this.f250413b = str;
            this.f250414c = i3;
            this.f250415d = j3;
            this.f250416e = z17;
            this.f250417f = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, q.this, Boolean.valueOf(z16), str, Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z17), str2);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:153:0x040c A[Catch: Exception -> 0x0567, all -> 0x058a, TryCatch #3 {all -> 0x058a, blocks: (B:109:0x01fe, B:111:0x0204, B:112:0x0232, B:114:0x0236, B:116:0x0247, B:118:0x0261, B:120:0x0274, B:122:0x0281, B:124:0x029b, B:126:0x02b5, B:127:0x02c2, B:128:0x0362, B:130:0x0370, B:132:0x0374, B:133:0x038e, B:134:0x0395, B:136:0x0399, B:139:0x039c, B:141:0x03a2, B:142:0x03a9, B:144:0x03c9, B:145:0x03ea, B:147:0x03f0, B:149:0x03f5, B:151:0x0406, B:153:0x040c, B:154:0x0413, B:156:0x0422, B:157:0x0438, B:159:0x043e, B:161:0x0486, B:162:0x04c0, B:164:0x04c4, B:165:0x04d5, B:167:0x04db, B:168:0x0511, B:178:0x0569, B:180:0x0573, B:183:0x05d3, B:186:0x05ef, B:188:0x05fa, B:210:0x04cd, B:213:0x03fc, B:216:0x0402, B:221:0x02cd, B:223:0x02de, B:225:0x02f8, B:227:0x030b, B:229:0x0318, B:231:0x0332, B:233:0x034c, B:234:0x0359), top: B:108:0x01fe }] */
        /* JADX WARN: Removed duplicated region for block: B:156:0x0422 A[Catch: Exception -> 0x0567, all -> 0x058a, TryCatch #3 {all -> 0x058a, blocks: (B:109:0x01fe, B:111:0x0204, B:112:0x0232, B:114:0x0236, B:116:0x0247, B:118:0x0261, B:120:0x0274, B:122:0x0281, B:124:0x029b, B:126:0x02b5, B:127:0x02c2, B:128:0x0362, B:130:0x0370, B:132:0x0374, B:133:0x038e, B:134:0x0395, B:136:0x0399, B:139:0x039c, B:141:0x03a2, B:142:0x03a9, B:144:0x03c9, B:145:0x03ea, B:147:0x03f0, B:149:0x03f5, B:151:0x0406, B:153:0x040c, B:154:0x0413, B:156:0x0422, B:157:0x0438, B:159:0x043e, B:161:0x0486, B:162:0x04c0, B:164:0x04c4, B:165:0x04d5, B:167:0x04db, B:168:0x0511, B:178:0x0569, B:180:0x0573, B:183:0x05d3, B:186:0x05ef, B:188:0x05fa, B:210:0x04cd, B:213:0x03fc, B:216:0x0402, B:221:0x02cd, B:223:0x02de, B:225:0x02f8, B:227:0x030b, B:229:0x0318, B:231:0x0332, B:233:0x034c, B:234:0x0359), top: B:108:0x01fe }] */
        /* JADX WARN: Removed duplicated region for block: B:159:0x043e A[Catch: Exception -> 0x0567, all -> 0x058a, TryCatch #3 {all -> 0x058a, blocks: (B:109:0x01fe, B:111:0x0204, B:112:0x0232, B:114:0x0236, B:116:0x0247, B:118:0x0261, B:120:0x0274, B:122:0x0281, B:124:0x029b, B:126:0x02b5, B:127:0x02c2, B:128:0x0362, B:130:0x0370, B:132:0x0374, B:133:0x038e, B:134:0x0395, B:136:0x0399, B:139:0x039c, B:141:0x03a2, B:142:0x03a9, B:144:0x03c9, B:145:0x03ea, B:147:0x03f0, B:149:0x03f5, B:151:0x0406, B:153:0x040c, B:154:0x0413, B:156:0x0422, B:157:0x0438, B:159:0x043e, B:161:0x0486, B:162:0x04c0, B:164:0x04c4, B:165:0x04d5, B:167:0x04db, B:168:0x0511, B:178:0x0569, B:180:0x0573, B:183:0x05d3, B:186:0x05ef, B:188:0x05fa, B:210:0x04cd, B:213:0x03fc, B:216:0x0402, B:221:0x02cd, B:223:0x02de, B:225:0x02f8, B:227:0x030b, B:229:0x0318, B:231:0x0332, B:233:0x034c, B:234:0x0359), top: B:108:0x01fe }] */
        /* JADX WARN: Removed duplicated region for block: B:182:0x05d2  */
        /* JADX WARN: Removed duplicated region for block: B:192:0x0679 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0699 A[Catch: all -> 0x074b, TryCatch #4 {all -> 0x074b, blocks: (B:35:0x068c, B:37:0x0699, B:38:0x06b3), top: B:34:0x068c }] */
        /* JADX WARN: Removed duplicated region for block: B:43:0x06cb  */
        /* JADX WARN: Removed duplicated region for block: B:56:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:57:0x06bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            Throwable th5;
            HttpURLConnection httpURLConnection;
            int i3;
            String str;
            Throwable th6;
            String str2;
            URL url;
            long currentTimeMillis;
            HttpURLConnection httpURLConnection2;
            int responseCode;
            int i16;
            byte[] bArr;
            Throwable th7;
            Exception exc;
            c.d dVar;
            c.d dVar2;
            String i17;
            URL url2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(q.f250386r, 2, "entry getSsoListByHttp getspeedtest " + this.f250412a);
            }
            com.tencent.msf.service.protocol.serverconfig.d dVar3 = new com.tencent.msf.service.protocol.serverconfig.d();
            long j3 = 0;
            try {
                dVar3.f336762a = Long.parseLong(this.f250413b);
            } catch (Exception unused) {
                dVar3.f336762a = 0L;
            }
            dVar3.f336764c = (byte) 1;
            dVar3.f336765d = com.tencent.mobileqq.msf.core.o.f();
            dVar3.f336767f = this.f250414c;
            dVar3.f336763b = this.f250415d / 1000;
            dVar3.f336768g = com.tencent.mobileqq.msf.core.o.e();
            dVar3.f336769h = com.tencent.mobileqq.msf.core.o.c();
            if (this.f250416e) {
                dVar3.f336766e = 100;
            } else {
                dVar3.f336766e = 1;
            }
            int i18 = 0;
            if (this.f250412a) {
                dVar3.f336772k = (byte) 1;
            } else {
                dVar3.f336772k = (byte) 0;
            }
            dVar3.f336773l = (byte) NetConnInfoCenter.getActiveNetIpFamily(false);
            dVar3.f336774m = t.Z & 4294967295L;
            UniPacket uniPacket = new UniPacket(true);
            uniPacket.setRequestId(0);
            uniPacket.setServantName("HttpServerListReq");
            uniPacket.setFuncName("HttpServerListReq");
            uniPacket.put("HttpServerListReq", dVar3);
            byte[] encrypt = new Cryptor().encrypt(uniPacket.encode(), q.Y);
            try {
                if (BaseConstants.isUseDebugSso) {
                    try {
                        url = new URL("https://configsvr.sparta.html5.qq.com/configsvr/serverlist.jsp?mType=getssolist");
                    } catch (Throwable th8) {
                        th5 = th8;
                        httpURLConnection = null;
                        try {
                            str = th5.toString();
                            th5.printStackTrace();
                            if (QLog.isColorLevel()) {
                            }
                            q.this.f250398d = 0;
                            if (httpURLConnection != null) {
                            }
                            i3 = i18;
                            str2 = this.f250417f;
                            if (str2 == null) {
                            }
                        } finally {
                        }
                    }
                } else {
                    url = new URL("https://configsvr.msf.3g.qq.com/configsvr/serverlist.jsp?mType=getssolist");
                }
                if (QLog.isColorLevel()) {
                    try {
                        QLog.d(q.f250386r, 2, "get ssolist use url:" + url.toString());
                    } catch (Throwable th9) {
                        th5 = th9;
                        j3 = 0;
                        httpURLConnection = null;
                        str = th5.toString();
                        th5.printStackTrace();
                        if (QLog.isColorLevel()) {
                        }
                        q.this.f250398d = 0;
                        if (httpURLConnection != null) {
                        }
                        i3 = i18;
                        str2 = this.f250417f;
                        if (str2 == null) {
                        }
                    }
                }
                currentTimeMillis = System.currentTimeMillis();
                if (QLog.isColorLevel()) {
                    QLog.d(q.f250386r, 2, "start send checkSso msg");
                }
                httpURLConnection2 = (HttpURLConnection) url.openConnection();
            } catch (Throwable th10) {
                th5 = th10;
                j3 = 0;
                httpURLConnection = null;
            }
            try {
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setConnectTimeout(20000);
                httpURLConnection2.setReadTimeout(20000);
                httpURLConnection2.getOutputStream().write(encrypt);
                httpURLConnection2.getOutputStream().flush();
                httpURLConnection2.getOutputStream().close();
                responseCode = httpURLConnection2.getResponseCode();
                if (QLog.isColorLevel()) {
                    try {
                        QLog.d(q.f250386r, 2, "http rsp code " + responseCode);
                    } catch (Throwable th11) {
                        th5 = th11;
                        httpURLConnection = httpURLConnection2;
                        j3 = 0;
                        str = th5.toString();
                        th5.printStackTrace();
                        if (QLog.isColorLevel()) {
                        }
                        q.this.f250398d = 0;
                        if (httpURLConnection != null) {
                        }
                        i3 = i18;
                        str2 = this.f250417f;
                        if (str2 == null) {
                        }
                    }
                }
            } catch (Throwable th12) {
                th5 = th12;
                httpURLConnection = httpURLConnection2;
                j3 = 0;
                i18 = 0;
                str = th5.toString();
                th5.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.d(q.f250386r, 2, "getssolisthttp error_ocurr_result: " + str.toString());
                }
                q.this.f250398d = 0;
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable th13) {
                        th6 = th13;
                        i3 = i18;
                        th6.printStackTrace();
                        str2 = this.f250417f;
                        if (str2 == null) {
                        }
                    }
                }
                i3 = i18;
                str2 = this.f250417f;
                if (str2 == null) {
                }
            }
            if (responseCode == 200) {
                byte[] bArr2 = new byte[128];
                ArrayList arrayList = new ArrayList();
                int i19 = 0;
                while (true) {
                    int read = httpURLConnection2.getInputStream().read(bArr2);
                    if (read == -1) {
                        break;
                    }
                    byte[] bArr3 = new byte[read];
                    System.arraycopy(bArr2, 0, bArr3, 0, read);
                    arrayList.add(bArr3);
                    i19 += read;
                }
                if (arrayList.size() == 1) {
                    bArr = (byte[]) arrayList.get(0);
                } else {
                    bArr = new byte[i19];
                    Iterator it = arrayList.iterator();
                    int i26 = 0;
                    while (it.hasNext()) {
                        byte[] bArr4 = (byte[]) it.next();
                        System.arraycopy(bArr4, 0, bArr, i26, bArr4.length);
                        i26 += bArr4.length;
                    }
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d(q.f250386r, 4, "send checkSso msg , costTime " + (System.currentTimeMillis() - currentTimeMillis) + " allData len is " + bArr.length);
                }
                byte[] decrypt = new Cryptor().decrypt(bArr, q.Y);
                UniPacket uniPacket2 = new UniPacket(true);
                try {
                    uniPacket2.decode(decrypt);
                    com.tencent.msf.service.protocol.serverconfig.e eVar = (com.tencent.msf.service.protocol.serverconfig.e) uniPacket2.getByClass("HttpServerListRes", new com.tencent.msf.service.protocol.serverconfig.e());
                    if (eVar != null) {
                        j3 = eVar.f336790j;
                        try {
                            i3 = eVar.f336791k;
                            try {
                                if (QLog.isColorLevel()) {
                                    QLog.d(q.f250386r, 2, "getSsoListByHttp nettype=" + ((int) eVar.f336798r) + ", he_threshold=" + eVar.f336799s + ", policy_id=" + eVar.f336800t);
                                }
                                if (this.f250416e) {
                                    String currentSSID = NetConnInfoCenter.getCurrentSSID();
                                    q.this.a(eVar.f336783c, q.f250388t, q.f250391w, q.f250393y, currentSSID, eVar.f336800t);
                                    q.this.a(eVar.f336793m, q.f250389u, q.f250391w, q.f250393y, currentSSID, eVar.f336800t);
                                    if ((eVar.f336798r & 1) == 1) {
                                        q.this.a(eVar.f336795o, q.f250388t, q.f250391w, q.f250394z, currentSSID, eVar.f336800t);
                                        q.this.a(eVar.f336796p, q.f250389u, q.f250391w, q.f250394z, currentSSID, eVar.f336800t);
                                        q.this.a(eVar.f336797q, q.f250390v, q.f250391w, q.f250394z, currentSSID, eVar.f336800t);
                                    }
                                    q.this.f250399e = System.currentTimeMillis();
                                } else {
                                    String currentAPN = NetConnInfoCenter.getCurrentAPN();
                                    q.this.a(eVar.f336782b, q.f250388t, q.f250392x, q.f250393y, currentAPN, eVar.f336800t);
                                    q.this.a(eVar.f336792l, q.f250389u, q.f250392x, q.f250393y, currentAPN, eVar.f336800t);
                                    if ((eVar.f336798r & 2) == 2) {
                                        q.this.a(eVar.f336795o, q.f250388t, q.f250392x, q.f250394z, currentAPN, eVar.f336800t);
                                        q.this.a(eVar.f336796p, q.f250389u, q.f250392x, q.f250394z, currentAPN, eVar.f336800t);
                                        q.this.a(eVar.f336797q, q.f250390v, q.f250392x, q.f250394z, currentAPN, eVar.f336800t);
                                    }
                                    q.this.f250400f = System.currentTimeMillis();
                                }
                                q.this.a(eVar.f336799s);
                                if (QLog.isColorLevel()) {
                                    if (eVar.f336794n != null) {
                                        QLog.d(q.f250386r, 2, "begin_to_parse_speedtest info len " + eVar.f336794n.length);
                                    } else {
                                        QLog.d(q.f250386r, 2, "begin_to_parse_speedtest info, but vCesuInfo null");
                                    }
                                }
                                byte[] bArr5 = eVar.f336794n;
                                if (bArr5 != null && bArr5.length > 0) {
                                    try {
                                        if (QLog.isColorLevel()) {
                                            QLog.d(q.f250386r, 2, "begin, get speed test list");
                                        }
                                        UniPacket uniPacket3 = new UniPacket(true);
                                        uniPacket3.decode(eVar.f336794n);
                                        String funcName = uniPacket3.getFuncName();
                                        com.tencent.msf.service.protocol.push.h.d dVar4 = (com.tencent.msf.service.protocol.push.h.d) uniPacket3.getByClass("QualityTest", new com.tencent.msf.service.protocol.push.h.d());
                                        if (QLog.isColorLevel()) {
                                            QLog.d(q.f250386r, 2, "stQualityTest funcname: (" + funcName + ")  cProtoType=" + ((int) dVar4.f336591a));
                                        }
                                        if (funcName.equals("QualityTest")) {
                                            short s16 = dVar4.f336591a;
                                            if (1 == s16) {
                                                dVar2 = c.d.f249175a;
                                            } else if (2 == s16) {
                                                dVar2 = c.d.f249176b;
                                            } else if (3 == s16) {
                                                dVar2 = c.d.f249177c;
                                            } else {
                                                dVar = null;
                                                if (QLog.isColorLevel()) {
                                                    QLog.d(q.f250386r, 2, "start to triggler speedtest action");
                                                }
                                                i17 = new com.tencent.mobileqq.msf.core.net.t.c(dVar4, dVar).i();
                                                if (QLog.isColorLevel()) {
                                                    QLog.d(q.f250386r, 2, "speed_test result: " + i17);
                                                }
                                                if (!i17.isEmpty()) {
                                                    com.tencent.msf.service.protocol.serverconfig.c cVar = new com.tencent.msf.service.protocol.serverconfig.c();
                                                    cVar.f336759b = this.f250414c;
                                                    cVar.f336758a = Long.parseLong(this.f250413b);
                                                    cVar.f336760c = com.tencent.mobileqq.msf.core.o.e();
                                                    cVar.f336761d = i17.getBytes("utf-8");
                                                    UniPacket uniPacket4 = new UniPacket(true);
                                                    uniPacket4.setRequestId(0);
                                                    uniPacket4.setServantName("HttpCesuResultReport");
                                                    uniPacket4.setFuncName("HttpCesuResultReport");
                                                    uniPacket4.put("HttpCesuResultReport", cVar);
                                                    byte[] encrypt2 = new Cryptor().encrypt(uniPacket4.encode(), q.Y);
                                                    if (QLog.isColorLevel()) {
                                                        QLog.d(q.f250386r, 2, "stSpeedTestResult appid=" + cVar.f336759b + "uin=" + cVar.f336758a);
                                                        StringBuilder sb5 = new StringBuilder();
                                                        sb5.append("upload speed test result to httpsvr: enry_bufferlen : ");
                                                        sb5.append(encrypt2.length);
                                                        QLog.d(q.f250386r, 2, sb5.toString());
                                                    }
                                                    if (BaseConstants.isUseDebugSso) {
                                                        url2 = new URL("https://configsvr.sparta.html5.qq.com/configsvr/cesureport.jsp");
                                                    } else {
                                                        url2 = new URL("https://configsvr.msf.3g.qq.com/configsvr/cesureport.jsp");
                                                    }
                                                    if (QLog.isColorLevel()) {
                                                        QLog.d(q.f250386r, 2, "upload result using url: " + url2.toString());
                                                        QLog.d(q.f250386r, 2, "start http upload speedtest msg:  " + Arrays.toString(cVar.f336761d));
                                                    }
                                                    HttpURLConnection httpURLConnection3 = (HttpURLConnection) url2.openConnection();
                                                    try {
                                                        httpURLConnection3.setDoOutput(true);
                                                        httpURLConnection3.setRequestMethod("POST");
                                                        httpURLConnection3.setConnectTimeout(20000);
                                                        httpURLConnection3.setReadTimeout(20000);
                                                        httpURLConnection3.getOutputStream().write(encrypt2);
                                                        httpURLConnection3.getOutputStream().flush();
                                                        httpURLConnection3.getOutputStream().close();
                                                        int responseCode2 = httpURLConnection3.getResponseCode();
                                                        if (QLog.isColorLevel()) {
                                                            QLog.d(q.f250386r, 2, "send speedtest result sucess, code4upload " + responseCode2);
                                                        }
                                                        httpURLConnection2 = httpURLConnection3;
                                                    } catch (Exception e16) {
                                                        exc = e16;
                                                        httpURLConnection2 = httpURLConnection3;
                                                        str = exc.toString();
                                                        if (QLog.isDevelopLevel()) {
                                                            QLog.w(q.f250386r, 4, "upload speed_test result error: " + exc, exc);
                                                        }
                                                        if (eVar != null) {
                                                        }
                                                        if (httpURLConnection2 != null) {
                                                        }
                                                        str2 = this.f250417f;
                                                        if (str2 == null) {
                                                        }
                                                    } catch (Throwable th14) {
                                                        th7 = th14;
                                                        httpURLConnection = httpURLConnection3;
                                                        try {
                                                            str = th7.toString();
                                                            if (QLog.isDevelopLevel()) {
                                                                QLog.w(q.f250386r, 4, "getSsoListByHttp error " + th7, th7);
                                                            }
                                                            q.this.f250398d = 0;
                                                            i16 = i3;
                                                            httpURLConnection2 = httpURLConnection;
                                                            i3 = i16;
                                                            if (httpURLConnection2 != null) {
                                                            }
                                                        } catch (Throwable th15) {
                                                            th5 = th15;
                                                            i18 = i3;
                                                            str = th5.toString();
                                                            th5.printStackTrace();
                                                            if (QLog.isColorLevel()) {
                                                            }
                                                            q.this.f250398d = 0;
                                                            if (httpURLConnection != null) {
                                                            }
                                                            i3 = i18;
                                                            str2 = this.f250417f;
                                                            if (str2 == null) {
                                                            }
                                                        }
                                                        str2 = this.f250417f;
                                                        if (str2 == null) {
                                                        }
                                                    }
                                                }
                                            }
                                            dVar = dVar2;
                                            if (QLog.isColorLevel()) {
                                            }
                                            i17 = new com.tencent.mobileqq.msf.core.net.t.c(dVar4, dVar).i();
                                            if (QLog.isColorLevel()) {
                                            }
                                            if (!i17.isEmpty()) {
                                            }
                                        }
                                    } catch (Exception e17) {
                                        exc = e17;
                                    }
                                }
                            } catch (Throwable th16) {
                                th7 = th16;
                                httpURLConnection = httpURLConnection2;
                            }
                        } catch (Throwable th17) {
                            th7 = th17;
                            httpURLConnection = httpURLConnection2;
                            i3 = 0;
                        }
                    } else {
                        if (QLog.isDevelopLevel()) {
                            QLog.d(q.f250386r, 4, "received sso list is null.");
                        }
                        long j16 = 3600000;
                        q.this.f250403i = System.currentTimeMillis() + j16;
                        q.this.t();
                        q.this.f250404j = System.currentTimeMillis() + j16;
                        q.this.u();
                        q.this.f250398d = 1;
                        i3 = 0;
                        j3 = 0;
                    }
                    str = MeasureConst.SLI_TYPE_SUCCESS;
                    if (eVar != null) {
                        boolean z16 = true;
                        QLog.d(q.f250386r, 1, "[getSsoListByHttp] bNewConn, ", Byte.valueOf(eVar.f336801u));
                        q qVar = q.this;
                        if (eVar.f336801u != 1) {
                            z16 = false;
                        }
                        qVar.f250396b = z16;
                        if (q.this.f250397c != null) {
                            q.this.f250397c.a(q.this.f250396b);
                        }
                    }
                } catch (Throwable th18) {
                    th7 = th18;
                    httpURLConnection = httpURLConnection2;
                    i3 = 0;
                    j3 = 0;
                }
                if (httpURLConnection2 != null) {
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Throwable th19) {
                        th6 = th19;
                        th6.printStackTrace();
                        str2 = this.f250417f;
                        if (str2 == null) {
                        }
                    }
                }
                str2 = this.f250417f;
                if (str2 == null || str2.length() <= 0) {
                }
                ArrayList arrayList2 = new ArrayList();
                String str3 = MsfService.getCore().timeFormatter.format(Long.valueOf(System.currentTimeMillis())) + "|" + j3 + "|" + i3 + "|" + this.f250417f + "|" + str;
                if (QLog.isColorLevel()) {
                    QLog.d(q.f250386r, 2, "add waitReportData " + str3);
                }
                try {
                    arrayList2.add(str3.getBytes("utf-8"));
                } catch (UnsupportedEncodingException e18) {
                    e18.printStackTrace();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("CHECKSSOLISTBYHTTP", arrayList2);
                q.this.a((HashMap<String, ArrayList<byte[]>>) hashMap);
                return;
            }
            String str4 = "respCode is " + responseCode;
            if (QLog.isDevelopLevel()) {
                QLog.d(q.f250386r, 4, "send checkSso msg , resp code is " + responseCode);
            }
            q.this.f250398d = 0;
            str = str4;
            j3 = 0;
            i16 = 0;
            i3 = i16;
            if (httpURLConnection2 != null) {
            }
            str2 = this.f250417f;
            if (str2 == null) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface b {
        void a(boolean z16);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27056);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        Y = new byte[]{-16, 68, 31, 95, -12, MultipartStream.DASH, -91, -113, -36, -9, -108, -102, -70, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, -44, 17};
        Z = new String[]{"socket://msfxg.3g.qq.com:8080#46000_46002_46007_46001_46003:0:1", "socket://14.22.9.53:80#46003:0:1", "socket://120.232.65.165:14000#46000_46002_46007:0:1", "socket://120.232.31.250:8080#46000_46002_46007:0:1", "socket://157.148.55.96:443#46001:0:1", "socket://43.154.240.21:8080#46000_46002_46007_46001_46003:0:1"};
        f250377a0 = new String[]{"socket://120.232.31.250:14000#46000_46002_46007:0:1", "socket://msfxg.3g.qq.com:80#46000_46002_46007:0:1", "socket://39.156.126.178:443#46000_46002_46007:0:1", "socket://36.155.163.66:8080#46000_46002_46007:0:1", "socket://120.232.65.165:8080#46000_46002_46007:0:1", "socket://111.30.182.254:443#46000_46002_46007:0:1", "socket://36.155.187.225:443#46000_46002_46007:0:1", "socket://111.30.182.254:443#46000_46002_46007:0:1"};
        f250378b0 = new String[]{"socket://157.148.54.249:14000#46001:0:1", "socket://msfxg.3g.qq.com:80#46001:0:1", "socket://157.148.55.96:8080#46001:0:1", "socket://220.194.118.224:8080#46001:0:1", "socket://59.83.207.254:14000#46001:0:1", "socket://60.29.238.126:443#46001:0:1", "socket://112.86.230.80:8080#46001:0:1"};
        f250379c0 = new String[]{"socket://14.22.9.53:14000#46003:0:1", "socket://msfxg.3g.qq.com:80#46003:0:1", "socket://14.22.9.53:443#46003:0:1", "socket://42.81.193.250:8080#46003:0:1", "socket://222.94.109.78:443#46003:0:1", "socket://42.81.193.250:80#46003:0:1", "socket://114.221.149.227:14000#46003:0:1"};
        f250380d0 = new String[]{"socket://43.154.240.21:443#46000_46002_46007_46001_46003:0:1", "socket://msfxg.3g.qq.com:80#46000_46002_46007_46001_46003:0:1", "socket://43.154.240.194:443#46000_46002_46007_46001_46003:0:1", "socket://14.22.9.53:8080#46000_46002_46007_46001_46003:0:1", "socket://157.148.54.249:8080#46000_46002_46007_46001_46003:0:1", "socket://120.232.65.165:443#46000_46002_46007_46001_46003:0:1"};
        f250381e0 = new String[]{"socket://msfwifi.3g.qq.com:8080#00000:0:1", "socket://183.47.101.221:8080#00000:0:1", "socket://14.22.9.53:8080#00000:0:1", "socket://157.148.55.96:14000#00000:0:1", "socket://120.232.31.250:443#00000:0:1", "socket://14.22.9.53:14000#00000:0:1", "socket://157.148.54.249:443#00000:0:1", "socket://120.232.65.165:80#00000:0:1", "socket://43.154.240.21:8080#00000:0:1", "socket://43.154.240.194:8080#00000:0:1"};
        f250382f0 = new String[]{"https://msfhttp.3g.qq.com:80#00000:0:1"};
        f250383g0 = new String[]{"quic://58.251.106.174:443#00000:0:1"};
        f250384h0 = new String[]{"socket://[240e:928:1400:1002::7]:8080#00000:0:1", "socket://[2408:8711:10:105::51]:8080#00000:0:1", "socket://[2409:8702:4860:1000::18]:8080#00000:0:1", "socket://[240e:97c:2f:3000::4b]:8080#00000:0:1", "socket://[2408:8756:f50:1003::2f]:8080#00000:0:1", "socket://[2409:8c54:871:1003::21]:8080#00000:0:1", "socket://[240e:e1:a800:120::13]:8080#00000:0:1", "socket://[2408:80f1:21:c121::32]:8080#00000:0:1", "socket://[2409:8c1e:75b0:1120::23]:8080#00000:0:1", "socket://msfwifiv6.3g.qq.com:8080#00000:0:1"};
        f250385i0 = new String[]{"socket://[240e:928:1400:1000::5e]:8080#00000:0:1", "socket://[2408:8711:10:1002::2a]:8080#00000:0:1", "socket://[2409:8702:4860:1002::2e]:8080#00000:0:1", "socket://[240e:97c:2f:3000::38]:8080#00000:0:1", "socket://[2408:8756:f50:1002::13]:8080#00000:0:1", "socket://[2409:8c54:871:3001::4]:8080#00000:0:1", "socket://[240e:e1:a800:121::2c]:8080#00000:0:1", "socket://[2408:80f1:21:b8::3e]:8080#00000:0:1", "socket://[2409:8c1e:75b0:1120::21]:8080#00000:0:1", "socket://msfxgv6.3g.qq.com:8080#00000:0:1"};
    }

    public q(com.tencent.mobileqq.msf.core.f0.d.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            return;
        }
        this.f250395a = false;
        this.f250396b = false;
        this.f250398d = 2;
        this.f250399e = 0L;
        this.f250400f = 0L;
        this.f250401g = 0L;
        this.f250402h = 0L;
        this.f250403i = 0L;
        this.f250404j = 0L;
        this.f250405k = new ConcurrentHashMap<>();
        this.f250406l = new ConcurrentHashMap<>();
        this.f250407m = new ConcurrentHashMap<>();
        this.f250408n = new AtomicLong(100L);
        this.f250410p = new ArrayList<>();
        this.f250411q = false;
        this.f250409o = aVar;
    }

    public static String a(int i3) {
        if (i3 == 1) {
            return f250393y;
        }
        if (i3 != 2) {
            return null;
        }
        return f250394z;
    }

    private void l() {
        String config = MsfStore.getNativeConfigStore().getConfig(P);
        String str = "0";
        if (config == null || config.length() == 0) {
            config = "0";
        }
        this.f250401g = Long.parseLong(config);
        String config2 = MsfStore.getNativeConfigStore().getConfig(Q);
        if (config2 == null || config2.length() == 0) {
            config2 = "0";
        }
        this.f250402h = Long.parseLong(config2);
        String config3 = MsfStore.getNativeConfigStore().getConfig(R);
        if (config3 == null || config3.length() == 0) {
            config3 = "0";
        }
        this.f250403i = Long.parseLong(config3);
        String config4 = MsfStore.getNativeConfigStore().getConfig(S);
        if (config4 != null && config4.length() != 0) {
            str = config4;
        }
        this.f250404j = Long.parseLong(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x015e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m() {
        CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> copyOnWriteArrayList;
        boolean z16;
        this.f250405k.clear();
        String f16 = com.tencent.mobileqq.msf.core.o.f();
        if (QLog.isColorLevel()) {
            QLog.d(f250386r, 2, "getIMSI " + f16);
        }
        if (f16 != null && f16 != "") {
            z16 = false;
            if (!f16.startsWith("460") && !f16.startsWith("461")) {
                copyOnWriteArrayList = a(f250380d0);
            } else if (!f16.startsWith("46000") && !f16.startsWith("46002") && !f16.startsWith("46007")) {
                if (f16.startsWith("46001")) {
                    copyOnWriteArrayList = a(f250378b0);
                } else if (f16.startsWith("46003")) {
                    copyOnWriteArrayList = a(f250379c0);
                }
            } else {
                copyOnWriteArrayList = a(f250377a0);
            }
            if (z16) {
                copyOnWriteArrayList = a(Z);
            }
            if (QLog.isColorLevel()) {
                QLog.d(f250386r, 2, "init default mobile sso list result:");
                Iterator<com.tencent.mobileqq.msf.core.d> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    QLog.d(f250386r, 2, it.next().n());
                }
            }
            this.f250405k.put(c.a(f250388t, f250392x, f250393y), copyOnWriteArrayList);
            this.f250405k.put(c.a(f250388t, f250391w, f250393y), a(f250381e0));
            CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> a16 = a(f250382f0);
            this.f250405k.put(c.a(f250389u, f250392x, f250393y), a16);
            this.f250405k.put(c.a(f250389u, f250391w, f250393y), a16);
            CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> a17 = a(f250383g0);
            this.f250405k.put(c.a(f250390v, f250392x, f250393y), a17);
            this.f250405k.put(c.a(f250390v, f250391w, f250393y), a17);
            CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> a18 = a(f250384h0);
            Collections.shuffle(a18);
            if (QLog.isColorLevel()) {
                QLog.d(f250386r, 2, "init default WIFI IPV6 sso list result: ");
                Iterator<com.tencent.mobileqq.msf.core.d> it5 = a18.iterator();
                while (it5.hasNext()) {
                    QLog.d(f250386r, 2, it5.next().n());
                }
            }
            this.f250405k.put(c.a(f250388t, f250391w, f250394z), a18);
            CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> a19 = a(f250385i0);
            Collections.shuffle(a19);
            if (QLog.isColorLevel()) {
                QLog.d(f250386r, 2, "init default mobile IPV6 sso list result: ");
                Iterator<com.tencent.mobileqq.msf.core.d> it6 = a19.iterator();
                while (it6.hasNext()) {
                    QLog.d(f250386r, 2, it6.next().n());
                }
            }
            this.f250405k.put(c.a(f250388t, f250392x, f250394z), a19);
        }
        copyOnWriteArrayList = null;
        z16 = true;
        if (z16) {
        }
        if (QLog.isColorLevel()) {
        }
        this.f250405k.put(c.a(f250388t, f250392x, f250393y), copyOnWriteArrayList);
        this.f250405k.put(c.a(f250388t, f250391w, f250393y), a(f250381e0));
        CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> a162 = a(f250382f0);
        this.f250405k.put(c.a(f250389u, f250392x, f250393y), a162);
        this.f250405k.put(c.a(f250389u, f250391w, f250393y), a162);
        CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> a172 = a(f250383g0);
        this.f250405k.put(c.a(f250390v, f250392x, f250393y), a172);
        this.f250405k.put(c.a(f250390v, f250391w, f250393y), a172);
        CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> a182 = a(f250384h0);
        Collections.shuffle(a182);
        if (QLog.isColorLevel()) {
        }
        this.f250405k.put(c.a(f250388t, f250391w, f250394z), a182);
        CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> a192 = a(f250385i0);
        Collections.shuffle(a192);
        if (QLog.isColorLevel()) {
        }
        this.f250405k.put(c.a(f250388t, f250392x, f250394z), a192);
    }

    private void n() {
        SharedPreferences sharedPreferences = MsfService.getCore().getSharedPreferences(NetContants.SharePref.SP_MSF_COMMON, 0);
        AtomicLong atomicLong = this.f250408n;
        atomicLong.set(sharedPreferences.getLong(T, atomicLong.get()));
    }

    private synchronized void o() {
        this.f250395a = false;
        String currentSSID = NetConnInfoCenter.getCurrentSSID(true);
        if (!TextUtils.isEmpty(currentSSID)) {
            b(currentSSID, false);
        }
        String currentAPN = NetConnInfoCenter.getCurrentAPN(true);
        if (!TextUtils.isEmpty(currentAPN)) {
            a(currentAPN, false);
        }
        QLog.d(f250386r, 2, "loadAllSsoListMapFromStore strSSID = " + currentSSID + ", strApn" + currentAPN);
    }

    private synchronized void r() {
        SharedPreferences sharedPreferences = MsfService.getCore().getSharedPreferences(J, 0);
        int i3 = sharedPreferences.getInt(M, 0);
        for (int i16 = 0; i16 < i3; i16++) {
            String string = sharedPreferences.getString(K + i16, "");
            long j3 = sharedPreferences.getLong(L + i16, 0L);
            if (!TextUtils.isEmpty(string) && j3 > 0) {
                this.f250407m.put(string, Long.valueOf(j3));
                if (QLog.isColorLevel()) {
                    QLog.d(f250386r, 2, "get a ssid " + string + " time = " + j3);
                }
            }
        }
    }

    private synchronized void v() {
        int i3 = 0;
        SharedPreferences.Editor edit = MsfService.getCore().getSharedPreferences(J, 0).edit();
        edit.putInt(M, this.f250407m.size());
        for (Map.Entry<String, Long> entry : this.f250407m.entrySet()) {
            if (entry != null) {
                long longValue = entry.getValue().longValue();
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    edit.putString(K + i3, key);
                    edit.putLong(L + i3, longValue);
                    i3++;
                }
            }
        }
        edit.apply();
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return this.f250395a;
    }

    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        com.tencent.mobileqq.msf.core.d h16 = this.f250409o.h();
        if (h16 != null) {
            String a16 = a(h16.c());
            if (!TextUtils.isEmpty(a16)) {
                if (NetConnInfoCenter.isWifiConn()) {
                    String currentSSID = NetConnInfoCenter.getCurrentSSID();
                    if (!TextUtils.isEmpty(currentSSID)) {
                        String str = C + (c.a(com.tencent.mobileqq.msf.core.o.b(h16.e()), f250391w, a16).a() + currentSSID);
                        String config = MsfStore.getNativeConfigStore().getConfig(str);
                        QLog.d(f250386r, 1, "[SSOPolicyID] get k: ", str, ", v: ", config);
                        return config;
                    }
                } else if (NetConnInfoCenter.isMobileConn()) {
                    String currentAPN = NetConnInfoCenter.getCurrentAPN();
                    if (!TextUtils.isEmpty(currentAPN)) {
                        String str2 = C + (c.a(com.tencent.mobileqq.msf.core.o.b(h16.e()), f250392x, a16).a() + currentAPN);
                        String config2 = MsfStore.getNativeConfigStore().getConfig(str2);
                        QLog.d(f250386r, 1, "[SSOPolicyID] get k: ", str2, ", v: ", config2);
                        return config2;
                    }
                }
            }
        }
        return null;
    }

    public long g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this)).longValue();
        }
        return this.f250408n.get();
    }

    public int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f250398d;
    }

    public long i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this)).longValue();
        }
        return this.f250400f;
    }

    public long j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.f250399e;
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        n();
        m();
        r();
        c();
        o();
        c(NetConnInfoCenter.getCurrentSSID());
    }

    public synchronized void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        String currentAPN = NetConnInfoCenter.getCurrentAPN();
        if (TextUtils.isEmpty(currentAPN)) {
            return;
        }
        a(currentAPN, true);
    }

    public synchronized void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        String currentSSID = NetConnInfoCenter.getCurrentSSID();
        if (TextUtils.isEmpty(currentSSID)) {
            return;
        }
        b(currentSSID, true);
        c(currentSSID);
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        Iterator<Map.Entry<c, CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d>>> it = this.f250406l.entrySet().iterator();
        while (it.hasNext()) {
            Iterator<com.tencent.mobileqq.msf.core.d> it5 = it.next().getValue().iterator();
            while (it5.hasNext()) {
                it5.next().a(0L);
            }
        }
        QLog.d(f250386r, 1, "revertAbilityOfCurrentSsoList");
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        MsfStore.getNativeConfigStore().n_setConfig(R, String.valueOf(this.f250403i));
        if (QLog.isColorLevel()) {
            QLog.d(f250386r, 2, "save next get mobile sso time is " + MsfService.getCore().timeFormatter.format(Long.valueOf(this.f250403i)));
        }
    }

    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        MsfStore.getNativeConfigStore().n_setConfig(S, String.valueOf(this.f250404j));
        if (QLog.isColorLevel()) {
            QLog.d(f250386r, 2, "save next get Wifi sso time is " + MsfService.getCore().timeFormatter.format(Long.valueOf(this.f250404j)));
        }
    }

    public boolean w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (NetConnInfoCenter.isMobileConn()) {
            long j3 = this.f250401g;
            if (j3 == 0) {
                return true;
            }
            long j16 = this.f250403i;
            if (j16 == 0) {
                if (currentTimeMillis - j3 < 43200000) {
                    return false;
                }
                return true;
            }
            if (currentTimeMillis < j16) {
                return false;
            }
            return true;
        }
        if (!NetConnInfoCenter.isWifiConn()) {
            return false;
        }
        long j17 = this.f250402h;
        if (j17 == 0) {
            return true;
        }
        long j18 = this.f250404j;
        if (j18 == 0) {
            if (currentTimeMillis - j17 < 43200000) {
                return false;
            }
            return true;
        }
        if (currentTimeMillis < j18) {
            return false;
        }
        return true;
    }

    public void c(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            this.f250399e = j3;
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, j3);
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        ArrayList arrayList = new ArrayList();
        b(arrayList, f250388t, f250392x, f250394z, "", "");
        b(arrayList, f250389u, f250392x, f250394z, "", "");
        b(arrayList, f250390v, f250392x, f250394z, "", "");
        b(arrayList, f250388t, f250391w, f250394z, "", "");
        b(arrayList, f250389u, f250391w, f250394z, "", "");
        b(arrayList, f250390v, f250391w, f250394z, "", "");
    }

    private void c() {
        long currentTimeMillis = System.currentTimeMillis();
        for (Map.Entry<String, Long> entry : this.f250407m.entrySet()) {
            if (entry != null) {
                long longValue = entry.getValue().longValue();
                if (longValue > 0 && currentTimeMillis - longValue > 604800000) {
                    String key = entry.getKey();
                    this.f250407m.remove(key);
                    b(key);
                    QLog.d(f250386r, 1, "wifi: " + key + " sso list expire");
                }
            }
        }
        v();
    }

    public void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.f250398d = i3;
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
    }

    public void b(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            this.f250400f = j3;
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this, j3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private static ConcurrentHashMap<String, c> f250419d;

        /* renamed from: a, reason: collision with root package name */
        private String f250420a;

        /* renamed from: b, reason: collision with root package name */
        private String f250421b;

        /* renamed from: c, reason: collision with root package name */
        private String f250422c;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15106);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f250419d = new ConcurrentHashMap<>();
            }
        }

        c(String str, String str2, String str3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, str3);
                return;
            }
            this.f250420a = str;
            this.f250421b = str2;
            this.f250422c = str3;
        }

        public static c a(String str, String str2, String str3) {
            String str4 = str + str2 + str3;
            if (f250419d.containsKey(str4)) {
                return f250419d.get(str4);
            }
            c cVar = new c(str, str2, str3);
            f250419d.put(str4, cVar);
            return cVar;
        }

        public boolean equals(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, obj)).booleanValue();
            }
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            String str = this.f250420a;
            if (str == null ? cVar.f250420a != null : !str.equals(cVar.f250420a)) {
                return false;
            }
            String str2 = this.f250421b;
            if (str2 == null ? cVar.f250421b != null : !str2.equals(cVar.f250421b)) {
                return false;
            }
            String str3 = this.f250422c;
            String str4 = cVar.f250422c;
            if (str3 == null ? str4 == null : str3.equals(str4)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i3;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            String str = this.f250420a;
            int i17 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (i3 + 527) * 31;
            String str2 = this.f250421b;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i19 = (i18 + i16) * 31;
            String str3 = this.f250422c;
            if (str3 != null) {
                i17 = str3.hashCode();
            }
            return i19 + i17;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f250420a + this.f250421b + this.f250422c;
        }

        public String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return q.f250387s + toString() + "_";
        }
    }

    private void b(String str, boolean z16) {
        String str2;
        c a16 = c.a(f250388t, f250391w, f250393y);
        String str3 = a16.a() + str;
        if (TextUtils.isEmpty(str)) {
            str2 = E;
        } else {
            str2 = "__loginSdk_ssoWifilist_" + str;
        }
        a(a16, str3, str2, z16);
        c a17 = c.a(f250389u, f250391w, f250393y);
        a(a17, a17.a() + str, G, z16);
        c a18 = c.a(f250390v, f250391w, f250393y);
        a(a18, a18.a() + str, I, z16);
        c a19 = c.a(f250388t, f250391w, f250394z);
        this.f250395a = a(a19, a19.a() + str, null, z16) | this.f250395a;
        c a26 = c.a(f250389u, f250391w, f250394z);
        this.f250395a = a(a26, a26.a() + str, null, z16) | this.f250395a;
        c a27 = c.a(f250390v, f250391w, f250394z);
        this.f250395a = a(a27, a27.a() + str, null, z16) | this.f250395a;
        if (QLog.isColorLevel()) {
            QLog.d(f250386r, 2, "loadWifiSsoListMapFromStore mCurSsoListMap=" + this.f250406l.size());
        }
    }

    public void a(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            this.f250397c = bVar;
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bVar);
        }
    }

    public void a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, j3);
            return;
        }
        if (j3 < -1000 || j3 > 1000) {
            j3 = 100;
        }
        this.f250408n.set(j3);
        MsfService.getCore().getSharedPreferences(NetContants.SharePref.SP_MSF_COMMON, 0).edit().putLong(T, j3).apply();
    }

    private synchronized void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f250407m.containsKey(str)) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f250407m.put(str, Long.valueOf(currentTimeMillis));
            if (QLog.isColorLevel()) {
                QLog.d(f250386r, 2, "find ssid: " + str + " update time = " + currentTimeMillis);
            }
        } else {
            if (this.f250407m.size() >= 10) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250386r, 2, "too much ssid need to delete one find Least Recently Used now...");
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                String str2 = null;
                for (Map.Entry<String, Long> entry : this.f250407m.entrySet()) {
                    if (entry != null) {
                        long longValue = entry.getValue().longValue();
                        if (longValue < currentTimeMillis2) {
                            str2 = entry.getKey();
                            currentTimeMillis2 = longValue;
                        }
                    }
                }
                if (str2 != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f250386r, 2, "Least Recently Used ssid find delete now: " + str2);
                    }
                    this.f250407m.remove(str2);
                    b(str2);
                }
            }
            this.f250407m.put(str, Long.valueOf(System.currentTimeMillis()));
        }
        v();
    }

    private CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> a(String[] strArr) {
        CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        for (String str : strArr) {
            com.tencent.mobileqq.msf.core.d a16 = com.tencent.mobileqq.msf.core.d.a(str);
            a16.b(true);
            copyOnWriteArrayList.add(a16);
        }
        return copyOnWriteArrayList;
    }

    private void a(String str, boolean z16) {
        String str2;
        String str3;
        c a16 = c.a(f250388t, f250392x, f250393y);
        String str4 = a16.a() + str;
        if (TextUtils.isEmpty(str)) {
            str2 = F;
        } else {
            str2 = "__loginSdk_ssoMobilelist_" + str;
        }
        a(a16, str4, str2, z16);
        c a17 = c.a(f250389u, f250392x, f250393y);
        String str5 = a17.a() + str;
        if (TextUtils.isEmpty(str)) {
            str3 = H;
        } else {
            str3 = "__loginSdk_ssoHttpMobilelist_" + str;
        }
        a(a17, str5, str3, z16);
        c a18 = c.a(f250390v, f250392x, f250393y);
        a(a18, a18.a() + str, I, z16);
        c a19 = c.a(f250388t, f250392x, f250394z);
        this.f250395a = a(a19, a19.a() + str, null, z16) | this.f250395a;
        c a26 = c.a(f250389u, f250392x, f250394z);
        this.f250395a = a(a26, a26.a() + str, null, z16) | this.f250395a;
        c a27 = c.a(f250390v, f250392x, f250394z);
        this.f250395a = a(a27, a27.a() + str, null, z16) | this.f250395a;
        if (QLog.isColorLevel()) {
            QLog.d(f250386r, 2, "loadMobileSsoListMapFromStore mCurSsoListMap=" + this.f250406l.size());
        }
    }

    private synchronized void b(String str) {
        MsfStore.getNativeConfigStore().n_removeConfig("__loginSdk_ssoWifilist_" + str);
        MsfStore.getNativeConfigStore().n_removeConfig(c.a(f250388t, f250391w, f250393y).a() + str);
        MsfStore.getNativeConfigStore().n_removeConfig(c.a(f250389u, f250391w, f250393y).a() + str);
        MsfStore.getNativeConfigStore().n_removeConfig(c.a(f250390v, f250391w, f250393y).a() + str);
        MsfStore.getNativeConfigStore().n_removeConfig(c.a(f250388t, f250391w, f250394z).a() + str);
        MsfStore.getNativeConfigStore().n_removeConfig(c.a(f250389u, f250391w, f250394z).a() + str);
        MsfStore.getNativeConfigStore().n_removeConfig(c.a(f250390v, f250391w, f250394z).a() + str);
    }

    private boolean b(List<com.tencent.msf.service.protocol.serverconfig.k> list, String str, String str2, String str3, String str4, String str5) {
        ArrayList<com.tencent.mobileqq.msf.core.d> arrayList = new ArrayList<>();
        if (list != null) {
            Iterator<com.tencent.msf.service.protocol.serverconfig.k> it = list.iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.msf.core.d a16 = com.tencent.mobileqq.msf.core.d.a(it.next(), str2, f250394z.equals(str3) ? 2 : 1);
                if (a16 != null && a16.i()) {
                    if (f250390v.equals(str)) {
                        a16.c("quic");
                    }
                    arrayList.add(a16);
                }
            }
        }
        return a(c.a(str, str2, str3), str4, arrayList, true, str5);
    }

    private boolean a(c cVar, String str, String str2, boolean z16) {
        ArrayList<com.tencent.mobileqq.msf.core.d> a16;
        String config = MsfStore.getNativeConfigStore().getConfig(str);
        if (QLog.isColorLevel()) {
            QLog.d(f250386r, 2, "loadSsoListMapFromStore ssoTypeKey=" + cVar + ", storeKey=" + str + ", oldStoreKey=" + str2 + ", isChange=" + z16 + ", ssoListStr=" + config);
        }
        boolean z17 = false;
        if (TextUtils.isEmpty(config)) {
            if (TextUtils.isEmpty(str2)) {
                a16 = null;
            } else {
                String config2 = MsfStore.getNativeConfigStore().getConfig(str2);
                if (QLog.isColorLevel()) {
                    QLog.d(f250386r, 2, "loadSsoListMapFromStore oldSsoListStr=" + config2);
                }
                a16 = a(config2);
            }
            if (z16 && this.f250405k.get(cVar) != null && this.f250405k.get(cVar).size() > 0) {
                if (a16 == null) {
                    a16 = new ArrayList<>();
                }
                if (a16.isEmpty()) {
                    a16.addAll(this.f250405k.get(cVar));
                }
            }
        } else {
            a16 = a(config);
            z16 = false;
        }
        if (a16 != null && !a16.isEmpty()) {
            this.f250406l.put(cVar, new CopyOnWriteArrayList<>(a16));
            z17 = true;
        }
        if (z16) {
            StringBuffer stringBuffer = new StringBuffer();
            if (a16 != null) {
                Iterator<com.tencent.mobileqq.msf.core.d> it = a16.iterator();
                while (it.hasNext()) {
                    stringBuffer.append(it.next().toString() + ";");
                }
            }
            MsfStore.getNativeConfigStore().n_setConfig(str, stringBuffer.toString());
        }
        return z17;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        try {
            if (this.f250411q) {
                Iterator<HashMap> it = this.f250410p.iterator();
                while (it.hasNext()) {
                    try {
                        MsfService.getCore().configManager.a(it.next(), "");
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d(f250386r, 2, "report waitReportData succ " + this.f250410p.size());
                }
                this.f250410p.clear();
                this.f250411q = false;
            }
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.d(f250386r, 2, "report waitReportData error " + e17);
            }
        }
    }

    private synchronized ArrayList<com.tencent.mobileqq.msf.core.d> a(String str) {
        ArrayList<com.tencent.mobileqq.msf.core.d> arrayList;
        arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split(";")) {
                if (!TextUtils.isEmpty(str2)) {
                    com.tencent.mobileqq.msf.core.d a16 = com.tencent.mobileqq.msf.core.d.a(str2);
                    if (a16 != null && a16.i()) {
                        if (QLog.isColorLevel()) {
                            QLog.d(f250386r, 2, "add valid endpoint=" + a16.toString());
                        }
                        a16.a(false);
                        arrayList.add(a16);
                    } else if (a16 == null) {
                        if (QLog.isColorLevel()) {
                            QLog.d(f250386r, 2, "found invalid endpoint: null");
                        }
                    } else if (QLog.isColorLevel()) {
                        QLog.d(f250386r, 2, "found invalid endpoint: " + a16.toString());
                    }
                }
            }
        }
        return arrayList;
    }

    private synchronized boolean a(c cVar, String str, ArrayList<com.tencent.mobileqq.msf.core.d> arrayList, boolean z16, String str2) {
        boolean z17;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("updateSsoListAndStore ssoTypeKey=");
            sb5.append(cVar.toString());
            sb5.append(", keyPostfix=");
            sb5.append(str);
            sb5.append(", ssoList size=");
            sb5.append(arrayList == null ? "null" : Integer.valueOf(arrayList.size()));
            sb5.append(", isPush=");
            sb5.append(z16);
            QLog.d(f250386r, 2, sb5.toString());
        }
        if (arrayList != null && arrayList.size() > 0) {
            this.f250406l.put(cVar, new CopyOnWriteArrayList<>(arrayList));
            z17 = true;
        } else {
            this.f250406l.remove(cVar);
            z17 = false;
        }
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            if (TextUtils.isEmpty(str)) {
                return z17;
            }
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<com.tencent.mobileqq.msf.core.d> it = arrayList.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next().toString() + ";");
            }
            String str3 = cVar.a() + str;
            MsfStore.getNativeConfigStore().n_setConfig(str3, stringBuffer.toString());
            if (!TextUtils.isEmpty(str2)) {
                MsfStore.getNativeConfigStore().n_setConfig(C + str3, str2);
                QLog.d(f250386r, 1, "[SSOPolicyID] set k: ", C + str3, ", v: ", str2);
            }
            if (QLog.isColorLevel()) {
                if (z16) {
                    QLog.d(f250386r, 2, "[SSOListPush] set configKey = " + str3 + " ssoTypeKey = " + cVar + " ssoListStr = " + ((Object) stringBuffer));
                } else {
                    QLog.d(f250386r, 2, "[SSOListHttpGet] set configKey = " + str3 + " ssoTypeKey = " + cVar + " ssoListStr = " + ((Object) stringBuffer));
                }
            }
            return z17;
        }
        return z17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(List<com.tencent.msf.service.protocol.serverconfig.i> list, String str, String str2, String str3, String str4, String str5) {
        ArrayList<com.tencent.mobileqq.msf.core.d> arrayList = new ArrayList<>();
        if (list != null) {
            Iterator<com.tencent.msf.service.protocol.serverconfig.i> it = list.iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.msf.core.d a16 = com.tencent.mobileqq.msf.core.d.a(it.next(), str2, f250394z.equals(str3) ? 2 : 1);
                QLog.d(f250386r, 1, "[updateSsoListByHttpGet], keyString = " + a16.toString());
                if (a16.i()) {
                    if (f250390v.equals(str)) {
                        a16.c("quic");
                    }
                    arrayList.add(a16);
                }
            }
        }
        return a(c.a(str, str2, str3), str4, arrayList, false, str5);
    }

    public void a(com.tencent.msf.service.protocol.serverconfig.f fVar) {
        boolean b16;
        boolean b17;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) fVar);
            return;
        }
        byte[] bArr = fVar.f336804b;
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        JceInputStream jceInputStream = new JceInputStream(bArr);
        com.tencent.msf.service.protocol.serverconfig.j jVar = new com.tencent.msf.service.protocol.serverconfig.j();
        jVar.readFrom(jceInputStream);
        if (QLog.isColorLevel()) {
            QLog.d(f250386r, 2, "recv ssoList Push nettype=" + ((int) jVar.f336852m) + ", he_threshold=" + jVar.f336853n + ", policy_id=" + jVar.f336854o);
        }
        if (NetConnInfoCenter.isWifiConn()) {
            String currentSSID = NetConnInfoCenter.getCurrentSSID();
            b(jVar.f336841b, f250388t, f250391w, f250393y, currentSSID, jVar.f336854o);
            b(jVar.f336847h, f250389u, f250391w, f250393y, currentSSID, jVar.f336854o);
            b(jVar.f336848i, f250390v, f250391w, f250393y, currentSSID, jVar.f336854o);
            if ((jVar.f336852m & 1) == 1) {
                b16 = b(jVar.f336849j, f250388t, f250391w, f250394z, currentSSID, jVar.f336854o) | false | b(jVar.f336850k, f250389u, f250391w, f250394z, currentSSID, jVar.f336854o);
                b17 = b(jVar.f336851l, f250390v, f250391w, f250394z, currentSSID, jVar.f336854o);
                z16 = b17 | b16;
            }
            z16 = false;
        } else {
            String currentAPN = NetConnInfoCenter.getCurrentAPN();
            b(jVar.f336840a, f250388t, f250392x, f250393y, currentAPN, jVar.f336854o);
            b(jVar.f336846g, f250389u, f250392x, f250393y, currentAPN, jVar.f336854o);
            b(jVar.f336848i, f250390v, f250392x, f250393y, currentAPN, jVar.f336854o);
            if ((jVar.f336852m & 2) == 2) {
                b16 = b(jVar.f336849j, f250388t, f250392x, f250394z, currentAPN, jVar.f336854o) | false | b(jVar.f336850k, f250389u, f250392x, f250394z, currentAPN, jVar.f336854o);
                b17 = b(jVar.f336851l, f250390v, f250392x, f250394z, currentAPN, jVar.f336854o);
                z16 = b17 | b16;
            }
            z16 = false;
        }
        this.f250395a = z16;
        a(jVar.f336853n);
        if (jVar.f336842c == 1) {
            QLog.w(f250386r, 1, "set sso reconnect is true.");
            MsfService.getCore().isReconnectSso.set(true);
        }
        QLog.d(f250386r, 1, "[handleSsoListPush] bNewConn, ", Byte.valueOf(jVar.f336855p));
        this.f250396b = jVar.f336855p == 1;
        b bVar = this.f250397c;
        if (bVar != null) {
            bVar.a(this.f250396b);
        }
    }

    public CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> a(c cVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (CopyOnWriteArrayList) iPatchRedirector.redirect((short) 19, this, cVar, Boolean.valueOf(z16));
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(" getAvailableSsoList ssoTypeKey = ");
        sb5.append(cVar);
        sb5.append(", curr size ");
        sb5.append(this.f250406l.get(cVar) == null ? "null" : Integer.valueOf(this.f250406l.get(cVar).size()));
        QLog.d(f250386r, 1, sb5.toString());
        if (this.f250406l.containsKey(cVar) && this.f250406l.get(cVar) != null && this.f250406l.get(cVar).size() > 0) {
            return this.f250406l.get(cVar);
        }
        if (z16) {
            return this.f250405k.get(cVar);
        }
        return null;
    }

    public synchronized void a(com.tencent.mobileqq.msf.core.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) dVar);
            return;
        }
        if (dVar == null) {
            QLog.d(f250386r, 1, "[sortList] endpoint is null.");
            return;
        }
        if (NetConnInfoCenter.isWifiConn()) {
            if (!a(dVar, c.a(f250388t, f250391w, f250393y))) {
                a(dVar, c.a(f250388t, f250392x, f250393y));
            }
        } else if (NetConnInfoCenter.isMobileConn()) {
            if (!a(dVar, c.a(f250388t, f250392x, f250393y))) {
                a(dVar, c.a(f250388t, f250391w, f250393y));
            }
        } else {
            a(dVar, c.a(f250388t, f250391w, f250393y));
            a(dVar, c.a(f250388t, f250392x, f250393y));
        }
    }

    private boolean a(com.tencent.mobileqq.msf.core.d dVar, c cVar) {
        CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> copyOnWriteArrayList = this.f250406l.get(cVar);
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.remove(dVar)) {
            copyOnWriteArrayList.add(dVar);
            QLog.d(f250386r, 1, " set " + dVar + " at ssoList last.");
            return true;
        }
        QLog.d(f250386r, 1, " not found " + dVar + " at ssoList.");
        return false;
    }

    public void a(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, str, Long.valueOf(j3));
            return;
        }
        if (w()) {
            if (NetConnInfoCenter.isMobileConn()) {
                this.f250401g = j3;
                MsfStore.getNativeConfigStore().n_setConfig(P, String.valueOf(this.f250401g));
                this.f250403i = this.f250401g + 3600000;
                t();
            } else if (NetConnInfoCenter.isWifiConn()) {
                this.f250402h = j3;
                MsfStore.getNativeConfigStore().n_setConfig(Q, String.valueOf(this.f250402h));
                this.f250404j = this.f250402h + 3600000;
                u();
            }
            try {
                a(BaseApplication.getContext().getAppId(), str, 60000L, NetConnInfoCenter.isWifiConn(), "", false);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250386r, 2, e16.toString(), e16);
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void a(int i3, String str, long j3, boolean z16, String str2, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Integer.valueOf(i3), str, Long.valueOf(j3), Boolean.valueOf(z16), str2, Boolean.valueOf(z17));
            return;
        }
        a aVar = new a(z17, str, i3, j3, z16, str2);
        aVar.setName("checkSsoByHttpThread");
        aVar.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HashMap<String, ArrayList<byte[]>> hashMap) {
        this.f250410p.add(hashMap);
        this.f250411q = true;
        if (QLog.isColorLevel()) {
            QLog.d(f250386r, 2, "add waitReportData " + this.f250410p.size());
        }
    }
}
