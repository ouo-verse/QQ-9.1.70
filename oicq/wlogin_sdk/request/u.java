package oicq.wlogin_sdk.request;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Array;
import java.net.Socket;
import java.nio.BufferOverflowException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import oicq.wlogin_sdk.report.Reporter;
import oicq.wlogin_sdk.report.event.EventConstant;
import oicq.wlogin_sdk.report.report_t;
import oicq.wlogin_sdk.sharemem.WloginLoginInfo;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tlv_type.tlv_t150;
import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class u {
    public static int A;
    public static int B;
    public static int C;
    public static byte[] D;
    public static byte[] E;
    public static int F;
    public static byte[] G;
    public static byte[] H;
    public static byte[] I;
    public static byte[] J;
    public static byte[] K;
    public static byte[] L;
    public static byte[] M;
    public static byte[] N;
    public static byte[] O;
    public static byte[] P;
    public static byte[] Q;
    public static byte[] R;
    public static int S;
    public static int T;
    public static int U;
    public static int V;
    public static int W;
    public static int X;
    public static int Y;
    public static boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    public static byte[] f422924a0;

    /* renamed from: b0, reason: collision with root package name */
    public static long f422925b0;

    /* renamed from: c0, reason: collision with root package name */
    public static long f422926c0;

    /* renamed from: d0, reason: collision with root package name */
    public static byte[] f422927d0;

    /* renamed from: e0, reason: collision with root package name */
    public static boolean f422928e0;

    /* renamed from: f0, reason: collision with root package name */
    public static int f422929f0;

    /* renamed from: g0, reason: collision with root package name */
    public static byte[] f422930g0;

    /* renamed from: h0, reason: collision with root package name */
    public static byte[] f422931h0;

    /* renamed from: i0, reason: collision with root package name */
    public static byte[] f422932i0;

    /* renamed from: j0, reason: collision with root package name */
    public static byte[] f422933j0;

    /* renamed from: k0, reason: collision with root package name */
    public static c f422934k0;

    /* renamed from: l0, reason: collision with root package name */
    public static String f422935l0;

    /* renamed from: m0, reason: collision with root package name */
    public static Reporter f422936m0;

    /* renamed from: n0, reason: collision with root package name */
    public static long f422937n0;

    /* renamed from: o0, reason: collision with root package name */
    public static TreeMap<Long, async_context> f422938o0;

    /* renamed from: p0, reason: collision with root package name */
    public static final Object f422939p0;

    /* renamed from: q0, reason: collision with root package name */
    public static boolean f422940q0;

    /* renamed from: r0, reason: collision with root package name */
    public static String f422941r0;

    /* renamed from: s0, reason: collision with root package name */
    public static int f422942s0;

    /* renamed from: t, reason: collision with root package name */
    public static SecureRandom f422943t;

    /* renamed from: t0, reason: collision with root package name */
    public static String f422944t0;

    /* renamed from: u, reason: collision with root package name */
    public static Boolean f422945u;

    /* renamed from: u0, reason: collision with root package name */
    public static String f422946u0;

    /* renamed from: v, reason: collision with root package name */
    public static boolean f422947v;

    /* renamed from: v0, reason: collision with root package name */
    public static int f422948v0;

    /* renamed from: w, reason: collision with root package name */
    public static Context f422949w;

    /* renamed from: w0, reason: collision with root package name */
    public static String f422950w0;

    /* renamed from: x, reason: collision with root package name */
    public static int f422951x;

    /* renamed from: y, reason: collision with root package name */
    public static String f422952y;

    /* renamed from: z, reason: collision with root package name */
    public static int f422953z;

    /* renamed from: h, reason: collision with root package name */
    public WFastLoginInfo f422961h;

    /* renamed from: s, reason: collision with root package name */
    public int f422972s;

    /* renamed from: a, reason: collision with root package name */
    public byte[] f422954a = null;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f422955b = new byte[16];

    /* renamed from: c, reason: collision with root package name */
    public tlv_t150 f422956c = null;

    /* renamed from: d, reason: collision with root package name */
    public long f422957d = 0;

    /* renamed from: e, reason: collision with root package name */
    public String f422958e = "";

    /* renamed from: f, reason: collision with root package name */
    public long f422959f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f422960g = 0;

    /* renamed from: i, reason: collision with root package name */
    public int f422962i = 0;

    /* renamed from: j, reason: collision with root package name */
    public int f422963j = 5000;

    /* renamed from: k, reason: collision with root package name */
    public int f422964k = 0;

    /* renamed from: l, reason: collision with root package name */
    public byte[] f422965l = new byte[16];

    /* renamed from: m, reason: collision with root package name */
    public byte[] f422966m = new byte[16];

    /* renamed from: n, reason: collision with root package name */
    public int f422967n = 1;

    /* renamed from: o, reason: collision with root package name */
    public byte[] f422968o = new byte[0];

    /* renamed from: p, reason: collision with root package name */
    public int f422969p = 0;

    /* renamed from: q, reason: collision with root package name */
    public Socket f422970q = null;

    /* renamed from: r, reason: collision with root package name */
    public Socket f422971r = null;

    static {
        SecureRandom secureRandom;
        try {
            secureRandom = new SecureRandom();
        } catch (Throwable unused) {
            secureRandom = null;
        }
        f422943t = secureRandom;
        f422945u = Boolean.FALSE;
        f422947v = true;
        f422949w = null;
        f422951x = 2052;
        f422952y = "";
        f422953z = 0;
        A = 1;
        B = 0;
        C = 0;
        D = new byte[0];
        E = new byte[0];
        F = 0;
        G = new byte[0];
        H = new byte[0];
        I = new byte[0];
        J = new byte[0];
        K = new byte[0];
        L = "android".getBytes();
        M = new byte[0];
        N = new byte[0];
        O = new byte[0];
        P = new byte[0];
        Q = new byte[0];
        R = new byte[0];
        S = 0;
        T = 0;
        U = 0;
        V = 0;
        W = 0;
        X = 0;
        Y = 0;
        Z = false;
        f422924a0 = new byte[0];
        f422925b0 = 0L;
        f422926c0 = 0L;
        f422927d0 = new byte[4];
        f422928e0 = false;
        f422929f0 = 1;
        f422931h0 = new byte[0];
        f422932i0 = new byte[0];
        f422933j0 = new byte[0];
        f422934k0 = null;
        f422935l0 = "";
        f422936m0 = new Reporter();
        f422937n0 = 0L;
        f422938o0 = new TreeMap<>();
        f422939p0 = new Object();
        f422940q0 = false;
        f422942s0 = 0;
    }

    public static void a() {
        String format = new SimpleDateFormat(DateUtil.DATE_FORMAT_8).format(new Date());
        if (format.compareTo(f422952y) != 0) {
            f422952y = format;
            new f(f422949w).start();
        }
    }

    public static long e() {
        return System.currentTimeMillis() / 1000;
    }

    @SuppressLint({"NewApi"})
    public static String f() {
        String str = f422935l0;
        if (str != null && str.length() > 0) {
            return f422935l0;
        }
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses((ActivityManager) f422949w.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) {
                if (runningAppProcessInfo.pid == myPid) {
                    String str2 = runningAppProcessInfo.processName;
                    f422935l0 = str2;
                    return str2;
                }
            }
        } catch (Throwable th5) {
            util.printThrowable(th5, "");
        }
        return "";
    }

    public static void h() {
        boolean z16;
        boolean z17;
        util.LOGI("init start", "");
        int i3 = 0;
        X = 0;
        b(f422949w);
        byte[] guidFromFile = util.getGuidFromFile(f422949w);
        util.LOGI("get saved guid " + util.buf_to_string(guidFromFile), "");
        byte[] generateGuid = util.generateGuid(f422949w);
        util.LOGI("get current guid " + util.buf_to_string(generateGuid), "");
        byte[] bytes = new String("%4;7t>;28<fc.5*6").getBytes();
        if (guidFromFile != null && guidFromFile.length > 0) {
            if (generateGuid != null && generateGuid.length > 0) {
                if (Arrays.equals(bytes, guidFromFile) && f422947v) {
                    String f16 = f();
                    if (!TextUtils.isEmpty(f16) && f16.endsWith(":MSF")) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17 && util.needChangeGuid(f422949w)) {
                        util.LOGI("reset guid :" + util.buf_to_string(guidFromFile) + "|" + util.buf_to_string(generateGuid), "");
                        Context context = f422949w;
                        byte[] b16 = c.b(context, "tk_file");
                        if (b16 != null) {
                            try {
                                byte[] decrypt = cryptor.decrypt(b16, 0, b16.length, guidFromFile);
                                if (decrypt != null) {
                                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(decrypt);
                                    ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                                    TreeMap treeMap = (TreeMap) objectInputStream.readObject();
                                    objectInputStream.close();
                                    byteArrayInputStream.close();
                                    if (treeMap != null) {
                                        for (Object obj : treeMap.keySet()) {
                                            util.LOGI(obj + " change guid allsig: " + ((WloginAllSigInfo) treeMap.get(obj))._tk_map, "" + obj);
                                        }
                                        c.a(context, treeMap, "tk_file", generateGuid);
                                    }
                                }
                            } catch (Throwable unused) {
                            }
                        }
                        byte[] b17 = c.b(context, "name_file");
                        if (b17 != null) {
                            try {
                                byte[] decrypt2 = cryptor.decrypt(b17, 0, b17.length, guidFromFile);
                                if (decrypt2 != null) {
                                    ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(decrypt2);
                                    ObjectInputStream objectInputStream2 = new ObjectInputStream(byteArrayInputStream2);
                                    TreeMap treeMap2 = (TreeMap) objectInputStream2.readObject();
                                    objectInputStream2.close();
                                    byteArrayInputStream2.close();
                                    if (treeMap2 != null) {
                                        c.a(context, treeMap2, "name_file", generateGuid);
                                    }
                                }
                            } catch (Throwable unused2) {
                            }
                        }
                        util.saveGuidToFile(f422949w, generateGuid);
                        guidFromFile = generateGuid;
                    }
                }
            } else {
                generateGuid = bytes;
            }
            f422947v = false;
            if (Arrays.equals(generateGuid, guidFromFile)) {
                U = 0;
            } else {
                U = 1;
            }
            T = 1;
            S = 0;
            V = 1;
        } else {
            if (generateGuid != null && generateGuid.length > 0) {
                T = 1;
                V = 17;
            } else {
                T = 0;
                V = 20;
                generateGuid = bytes;
            }
            util.saveGuidToFile(f422949w, generateGuid);
            U = 0;
            S = 1;
            guidFromFile = generateGuid;
        }
        byte[] bArr = util.get_mac_addr(f422949w);
        if (bArr != null && bArr.length > 0) {
            bArr = MD5.toMD5Byte(bArr);
        }
        byte[] a16 = oicq.wlogin_sdk.utils.a.a(f422949w);
        byte[] generateGuid2 = util.generateGuid(f422949w);
        if (generateGuid2 != null && generateGuid2.length > 0) {
            generateGuid2 = MD5.toMD5Byte(generateGuid2);
        }
        if (util.get_last_flag(f422949w) != 0) {
            byte[] bArr2 = util.get_last_mac(f422949w);
            byte[] bArr3 = new byte[0];
            try {
                bArr3 = util.string_to_buf(((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(f422949w, "WLOGIN_DEVICE_INFO")).f422789b.getString("last_android_id", ""));
            } catch (Exception e16) {
                util.printException(e16, "");
            }
            if (bArr3 == null || bArr3.length <= 0) {
                bArr3 = new byte[0];
            }
            byte[] bArr4 = util.get_last_guid(f422949w);
            if (!Arrays.equals(bArr, bArr2)) {
                W |= 1;
            }
            if (!Arrays.equals(a16, bArr3)) {
                W |= 2;
            }
            if (!Arrays.equals(generateGuid2, bArr4)) {
                W |= 4;
            }
        }
        util.save_cur_flag(f422949w, 1);
        util.save_cur_mac(f422949w, bArr);
        Context context2 = f422949w;
        if (context2 != null && a16 != null && a16.length > 0) {
            oicq.wlogin_sdk.persistence.d dVar = (oicq.wlogin_sdk.persistence.d) ((oicq.wlogin_sdk.persistence.c) oicq.wlogin_sdk.persistence.a.a(context2, "WLOGIN_DEVICE_INFO")).edit();
            dVar.putString("last_android_id", util.buf_to_string(a16));
            dVar.f422793b.commit();
        }
        util.save_cur_guid(f422949w, generateGuid2);
        X = X | ((V << 24) & (-16777216)) | ((W << 8) & 65280);
        D = (byte[]) guidFromFile.clone();
        E = (byte[]) guidFromFile.clone();
        util.LOGI("guid src " + V, "");
        byte[] bArr5 = util.get_mac_addr(f422949w);
        N = bArr5;
        if (bArr5 != null && bArr5.length > 0) {
            N = MD5.toMD5Byte(bArr5);
        }
        byte[] bArr6 = util.get_bssid_addr(f422949w);
        Q = bArr6;
        if (bArr6 != null && bArr6.length > 0) {
            Q = MD5.toMD5Byte(bArr6);
        }
        R = util.get_ssid_addr(f422949w);
        byte[] _imsi = util.get_IMSI(f422949w);
        M = _imsi;
        if (_imsi != null && _imsi.length > 0) {
            M = MD5.toMD5Byte(_imsi);
        }
        F = util.get_network_type(f422949w);
        if (util.get_saved_network_type(f422949w) != F) {
            util.set_net_retry_type(f422949w, 0);
            util.save_network_type(f422949w, F);
        }
        H = util.get_apn_string(f422949w).getBytes();
        f422924a0 = util.get_ksid(f422949w);
        byte[] bArr7 = util.get_apk_id(f422949w);
        G = bArr7;
        I = util.get_apk_v(f422949w, new String(bArr7));
        Context context3 = f422949w;
        J = util.getPkgSigFromApkName(context3, context3.getPackageName());
        P = util.getAppName(f422949w);
        String str = Build.VERSION.RELEASE;
        if (str == null) {
            str = "";
        }
        if (16 < str.length()) {
            str = str.substring(0, 16);
        }
        K = str.getBytes();
        String str2 = Build.BRAND;
        if (str2 == null) {
            O = new byte[0];
        } else {
            O = str2.getBytes();
        }
        if (!util.isFileExist("/system/bin/su") && !util.isFileExist("/system/xbin/su") && !util.isFileExist("/sbin/su")) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            i3 = 1;
        }
        Y = i3;
        f422934k0 = new c(f422949w);
        Reporter read_fromfile = report_t.read_fromfile(f422949w);
        f422936m0 = read_fromfile;
        if (read_fromfile == null) {
            f422936m0 = new Reporter();
        }
        if (util.need_pow_test(f422933j0)) {
            try {
                new BaseThread(new oicq.wlogin_sdk.pow.b(1, null), "Wtlogin_asynCalcPow").start();
                util.LOGI("asyncGetPerformance started", "");
            } catch (Throwable th5) {
                util.LOGI("asyncGetPerformance error " + Log.getStackTraceString(th5), "");
            }
        }
        util.LOGI("init ok os ver:" + new String(K) + " cur_guid:" + util.buf_to_string(D) + " svn " + util.SVN_VER + " at " + f(), "");
    }

    public synchronized long b(String str) {
        UinInfo a16 = f422934k0.a(str, true);
        if (a16 == null || a16._uin.longValue() == 0) {
            return 0L;
        }
        return a16._uin.longValue();
    }

    public void c() {
        Socket socket = this.f422971r;
        if (socket != null) {
            try {
                util.LOGD("close_transport_connect", socket.toString());
                this.f422971r.close();
            } catch (Exception e16) {
                util.printException(e16, "");
            }
            this.f422971r = null;
        }
    }

    public synchronized String d(long j3) {
        return f422934k0.a(Long.valueOf(j3));
    }

    public Context g() {
        return f422949w;
    }

    public synchronized void i() {
        c cVar = f422934k0;
        synchronized (cVar) {
            util.LOGI("refresh_all_siginfo ...", "");
            TreeMap<Long, WloginAllSigInfo> a16 = c.a(cVar.f422875a, "tk_file", 0L);
            cVar.f422876b = a16;
            if (a16 == null) {
                cVar.f422876b = new TreeMap<>();
            }
        }
    }

    public static async_context b(long j3) {
        async_context async_contextVar;
        async_context async_contextVar2;
        Exception e16;
        synchronized (f422939p0) {
            async_contextVar = f422938o0.get(Long.valueOf(j3));
            if (async_contextVar == null) {
                try {
                    async_contextVar2 = new async_context();
                } catch (Exception e17) {
                    async_contextVar2 = async_contextVar;
                    e16 = e17;
                }
                try {
                    f422938o0.put(Long.valueOf(j3), async_contextVar2);
                } catch (Exception e18) {
                    e16 = e18;
                    util.printException(e16, "");
                    async_contextVar = async_contextVar2;
                    util.LOGI("get_async_data sequence = " + j3 + " async_context = " + async_contextVar, "");
                    return async_contextVar;
                }
                async_contextVar = async_contextVar2;
            }
            util.LOGI("get_async_data sequence = " + j3 + " async_context = " + async_contextVar, "");
        }
        return async_contextVar;
    }

    public static void e(long j3) {
        synchronized (f422939p0) {
            try {
                f422938o0.remove(Long.valueOf(j3));
            } catch (Exception e16) {
                util.printException(e16, "");
            }
        }
    }

    public void a(Context context) {
        f422949w = context;
        byte[] bArr = util.get_rand_16byte(f422943t);
        System.arraycopy(bArr, 0, this.f422955b, 0, bArr.length);
    }

    public synchronized void c(long j3, long j16) {
        WloginAllSigInfo wloginAllSigInfo;
        c cVar = f422934k0;
        Long valueOf = Long.valueOf(j3);
        Long valueOf2 = Long.valueOf(j16);
        synchronized (cVar) {
            util.LOGI("start clear_sig", "" + valueOf);
            WloginAllSigInfo wloginAllSigInfo2 = cVar.f422876b.get(valueOf);
            if (wloginAllSigInfo2 != null) {
                wloginAllSigInfo2._tk_map.remove(valueOf2);
                util.LOGI("uin " + valueOf + " appid " + valueOf2 + " sig has been cleared");
            }
            if (cVar.f422875a != null) {
                synchronized (c.f422871e) {
                    TreeMap a16 = c.a(cVar.f422875a, "tk_file", valueOf.longValue());
                    if (a16 != null && (wloginAllSigInfo = (WloginAllSigInfo) a16.get(valueOf)) != null) {
                        wloginAllSigInfo._tk_map.remove(valueOf2);
                        cVar.a(a16, "tk_file");
                    }
                }
            }
        }
    }

    public synchronized List<WloginLoginInfo> d() {
        ArrayList arrayList;
        TreeMap a16;
        c cVar = f422934k0;
        synchronized (cVar) {
            arrayList = new ArrayList();
            Context context = cVar.f422875a;
            if (context != null && (a16 = c.a(context, "tk_file", 0L)) != null) {
                Iterator it = a16.keySet().iterator();
                while (it.hasNext()) {
                    Long l3 = (Long) it.next();
                    WloginAllSigInfo wloginAllSigInfo = cVar.f422876b.get(l3);
                    if (wloginAllSigInfo == null) {
                        wloginAllSigInfo = (WloginAllSigInfo) a16.get(l3);
                        if (wloginAllSigInfo != null) {
                            cVar.f422876b.put(l3, wloginAllSigInfo);
                        }
                    }
                    for (Long l16 : wloginAllSigInfo._tk_map.keySet()) {
                        WloginSigInfo wloginSigInfo = wloginAllSigInfo._tk_map.get(l16);
                        if (wloginSigInfo != null) {
                            String a17 = cVar.a(l3);
                            if (a17 == null) {
                                a17 = String.valueOf(l3);
                            }
                            String str = a17;
                            WloginSimpleInfo wloginSimpleInfo = wloginAllSigInfo._useInfo;
                            if (wloginSimpleInfo == null) {
                                util.LOGI("get_all_logined_account useInfo is null");
                            } else {
                                if (wloginSimpleInfo._img_url == null) {
                                    wloginSimpleInfo._img_url = new byte[0];
                                }
                                TreeMap treeMap = a16;
                                Iterator it5 = it;
                                arrayList.add(new WloginLoginInfo(str, l3.longValue(), l16.longValue(), new String(wloginAllSigInfo._useInfo._img_url), wloginSigInfo._create_time, WloginLoginInfo.TYPE_LOACL, wloginSigInfo._login_bitmap));
                                a16 = treeMap;
                                it = it5;
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized void a(String str, Long l3) {
        f422934k0.a(str, l3, true);
    }

    public void b() {
        util.LOGD("close_connect", "close_connect");
        Socket socket = this.f422970q;
        if (socket != null) {
            try {
                util.LOGD("close_connect", socket.toString());
                this.f422970q.close();
            } catch (Exception e16) {
                util.printException(e16, "");
            }
            this.f422970q = null;
        }
    }

    public synchronized WloginSimpleInfo c(long j3) {
        WloginSimpleInfo wloginSimpleInfo;
        c cVar = f422934k0;
        synchronized (cVar) {
            util.LOGI("start get_simpleinfo", "uin=" + j3);
            WloginAllSigInfo a16 = cVar.a(j3);
            wloginSimpleInfo = a16 == null ? null : a16._useInfo.get_clone();
        }
        return wloginSimpleInfo;
    }

    public synchronized WloginSigInfo d(long j3, long j16) {
        WloginSigInfo wloginSigInfo;
        c cVar = f422934k0;
        synchronized (cVar) {
            WloginAllSigInfo a16 = cVar.a(j3);
            if (a16 != null) {
                WloginSigInfo wloginSigInfo2 = a16._tk_map.get(Long.valueOf(j16));
                wloginSigInfo = wloginSigInfo2 != null ? wloginSigInfo2 : null;
            }
        }
        return wloginSigInfo;
    }

    public static byte[] b(Context context) {
        try {
            String str = (String) Class.forName("com.tencent.mobileqq.utils.KidInfoUtil").getMethod("getGuid", new Class[0]).invoke(null, new Object[0]);
            if (str == null) {
                util.LOGI("get watch guid null", "");
                return null;
            }
            util.saveGuidToFile(context, util.string_to_buf(str));
            f422930g0 = util.string_to_buf(str);
            util.LOGI("get watch guid " + str, "");
            return f422930g0;
        } catch (Exception unused) {
            return null;
        }
    }

    public synchronized void a(String str, Long l3, boolean z16) {
        f422934k0.a(str, l3, z16);
    }

    public synchronized void c(String str) {
        c cVar = f422934k0;
        synchronized (cVar) {
            cVar.f422877c.remove(str);
            if (cVar.f422875a != null) {
                synchronized (c.f422872f) {
                    TreeMap a16 = c.a(cVar.f422875a, "name_file", 0L);
                    if (a16 == null) {
                        a16 = new TreeMap();
                    }
                    a16.remove(str);
                    cVar.a(a16, "name_file");
                }
            }
        }
    }

    public void a(byte[] bArr, byte[] bArr2) {
        long buf_to_int32 = (util.buf_to_int32(bArr, 0) & 4294967295L) - (System.currentTimeMillis() / 1000);
        f422925b0 = buf_to_int32;
        f422926c0 = buf_to_int32;
        f422927d0 = bArr2;
    }

    public void b(long j3, long j16) {
        WloginSigInfo wloginSigInfo;
        c cVar = f422934k0;
        synchronized (cVar) {
            util.LOGI("clear_pskey " + j16, "" + j3);
            WloginAllSigInfo wloginAllSigInfo = cVar.f422876b.get(Long.valueOf(j3));
            if (wloginAllSigInfo != null && (wloginSigInfo = wloginAllSigInfo._tk_map.get(Long.valueOf(j16))) != null) {
                wloginSigInfo._pt4Token = new byte[0];
                wloginSigInfo._psKey = new byte[0];
                wloginSigInfo.cacheTickets = null;
                wloginSigInfo.cacheUpdateStamp = 0L;
                wloginAllSigInfo._tk_map.put(Long.valueOf(j3), wloginSigInfo);
                if (cVar.f422875a != null) {
                    synchronized (c.f422871e) {
                        TreeMap<Long, WloginAllSigInfo> a16 = c.a(cVar.f422875a, "tk_file", j3);
                        if (a16 != null) {
                            a16.put(Long.valueOf(j3), wloginAllSigInfo);
                            cVar.a(a16, "tk_file");
                            cVar.f422876b = a16;
                        }
                    }
                }
            }
        }
    }

    public synchronized void a(WTLoginRecordSnapshot wTLoginRecordSnapshot) {
        c cVar = f422934k0;
        synchronized (cVar) {
            WloginAllSigInfo wloginAllSigInfo = cVar.f422876b.get(Long.valueOf(wTLoginRecordSnapshot.getUin()));
            if (wloginAllSigInfo == null) {
                wloginAllSigInfo = new WloginAllSigInfo();
            }
            byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 16, 0);
            bArr[2] = wTLoginRecordSnapshot.f422866d2;
            bArr[3] = wTLoginRecordSnapshot.d2Key;
            long[] jArr = new long[7];
            jArr[5] = wTLoginRecordSnapshot.expireTime - wTLoginRecordSnapshot.a2GenerateTime;
            long appid = wTLoginRecordSnapshot.getAppid();
            long j3 = wTLoginRecordSnapshot.a2GenerateTime;
            long j16 = wTLoginRecordSnapshot.expireTime;
            wloginAllSigInfo.put_siginfo(appid, 4294967295L, j3, j16, j16, wTLoginRecordSnapshot.getA2(), wTLoginRecordSnapshot.a2Key, null, null, null, null, null, null, null, null, null, null, bArr, jArr, 0);
            byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 5, 0);
            bArr2[0] = oicq_request.a(wTLoginRecordSnapshot.f422864a1, wTLoginRecordSnapshot.a1Key);
            bArr2[1] = wTLoginRecordSnapshot.noPicSig;
            wloginAllSigInfo.put_siginfo(wTLoginRecordSnapshot.getAppid(), bArr2, wTLoginRecordSnapshot.a2GenerateTime);
            if (cVar.f422875a != null) {
                synchronized (c.f422871e) {
                    TreeMap<Long, WloginAllSigInfo> a16 = c.a(cVar.f422875a, "tk_file", wTLoginRecordSnapshot.getUin());
                    if (a16 != null) {
                        a16.put(Long.valueOf(wTLoginRecordSnapshot.getUin()), wloginAllSigInfo);
                        cVar.a(a16, "tk_file");
                    } else {
                        a16 = new TreeMap<>();
                        a16.put(Long.valueOf(wTLoginRecordSnapshot.getUin()), wloginAllSigInfo);
                        c.a(cVar.f422875a, a16, "tk_file", E);
                    }
                    cVar.f422876b = a16;
                }
            }
        }
    }

    public synchronized void a(String str) {
        c cVar = f422934k0;
        synchronized (cVar) {
            cVar.f422877c.remove(str);
            util.LOGI("clear_account " + str, "");
            if (cVar.f422875a != null) {
                synchronized (c.f422872f) {
                    TreeMap a16 = c.a(cVar.f422875a, "name_file", 0L);
                    if (a16 != null) {
                        a16.remove(str);
                        cVar.a(a16, "name_file");
                    }
                }
            }
        }
    }

    public synchronized int a(long j3, long j16) {
        int i3;
        c cVar = f422934k0;
        synchronized (cVar) {
            util.LOGI("start clear_da2 " + j16, "" + j3);
            int i16 = 0;
            if (cVar.f422875a != null) {
                synchronized (c.f422871e) {
                    TreeMap<Long, WloginAllSigInfo> a16 = c.a(cVar.f422875a, "tk_file", j3);
                    if (a16 != null) {
                        WloginAllSigInfo wloginAllSigInfo = a16.get(Long.valueOf(j3));
                        if (wloginAllSigInfo == null) {
                            i3 = -1;
                        } else {
                            util.LOGI("clear_da2 clear DA2 in file", "" + j3);
                            wloginAllSigInfo.put_da2(j16, new byte[0]);
                            int a17 = cVar.a(a16, "tk_file");
                            cVar.f422876b = a16;
                            i16 = a17;
                        }
                    }
                }
            }
            util.LOGI("end clear_da2 ret " + i16, "" + j3);
            i3 = i16;
        }
        return i3;
    }

    public u a(long j3) {
        long j16;
        u uVar = new u();
        uVar.f422962i = this.f422962i;
        uVar.f422963j = this.f422963j;
        byte[] bArr = this.f422955b;
        if (bArr != null) {
            uVar.f422955b = (byte[]) bArr.clone();
        }
        byte[] bArr2 = this.f422965l;
        if (bArr2 != null && this.f422966m != null) {
            uVar.f422965l = (byte[]) bArr2.clone();
            uVar.f422966m = (byte[]) this.f422966m.clone();
            uVar.f422967n = this.f422967n;
        }
        if (j3 <= 0) {
            synchronized (u.class) {
                if (f422937n0 > 200) {
                    f422937n0 = 0L;
                }
                j16 = f422937n0 + 1;
                f422937n0 = j16;
            }
            uVar.f422959f = j16;
        } else {
            uVar.f422959f = j3;
        }
        f422949w = f422949w;
        return uVar;
    }

    public synchronized int a(long j3, long j16, long j17, long j18, byte[] bArr, byte[] bArr2) {
        int i3;
        c cVar = f422934k0;
        synchronized (cVar) {
            util.LOGI("start put_siginfo " + j16, "" + j3);
            WloginAllSigInfo wloginAllSigInfo = cVar.f422876b.get(Long.valueOf(j3));
            if (wloginAllSigInfo == null) {
                i3 = -1;
            } else {
                int put_siginfo = wloginAllSigInfo.put_siginfo(j16, j17, j18, bArr, bArr2);
                if (cVar.f422875a != null) {
                    synchronized (c.f422871e) {
                        TreeMap a16 = c.a(cVar.f422875a, "tk_file", j3);
                        if (a16 == null) {
                            a16 = new TreeMap();
                        }
                        a16.put(Long.valueOf(j3), wloginAllSigInfo.get_clone());
                        cVar.a(a16, "tk_file");
                    }
                }
                i3 = put_siginfo;
            }
        }
        return i3;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public synchronized int a(long j3, long j16, byte[][] bArr, long j17, long j18, long j19, long j26, long j27, WloginSimpleInfo wloginSimpleInfo, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8, byte[] bArr9, byte[] bArr10, byte[] bArr11, byte[] bArr12, byte[] bArr13, byte[][] bArr14, long[] jArr, int i3, byte[] bArr15) {
        int i16;
        c cVar;
        oicq.wlogin_sdk.report.c.a aVar;
        int i17;
        byte[] bArr16;
        byte[] bArr17;
        byte[] bArr18;
        byte[] bArr19;
        byte[] bArr20;
        long j28;
        byte[] bArr21;
        TreeMap treeMap;
        long j29;
        byte[] bArr22;
        WloginAllSigInfo wloginAllSigInfo;
        byte[] bArr23;
        WloginSigInfo wloginSigInfo;
        String str;
        c cVar2 = f422934k0;
        cVar2.f422878d = this.f422972s;
        synchronized (cVar2) {
            try {
                util.LOGI("start put_siginfo skey " + util.getMaskBytes(bArr10, 2, 2), "" + j3);
                i16 = 0;
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                if (cVar2.f422875a != null) {
                    synchronized (c.f422871e) {
                        try {
                            try {
                                util.LOGI("put_siginfo load file", "" + j3);
                                TreeMap a16 = c.a(cVar2.f422875a, "tk_file", j3);
                                if (a16 == null) {
                                    a16 = new TreeMap();
                                }
                                WloginAllSigInfo wloginAllSigInfo2 = cVar2.f422876b.get(Long.valueOf(j3));
                                if (wloginAllSigInfo2 == null && (wloginAllSigInfo2 = (WloginAllSigInfo) a16.get(Long.valueOf(j3))) == null) {
                                    wloginAllSigInfo2 = new WloginAllSigInfo();
                                }
                                WloginAllSigInfo wloginAllSigInfo3 = wloginAllSigInfo2;
                                util.LOGI("put_siginfo mainSigMap 0x" + Integer.toHexString(cVar2.f422878d), "" + j3);
                                wloginAllSigInfo3.mainSigMap = cVar2.f422878d;
                                byte[] bArr24 = new byte[0];
                                byte[] bArr25 = new byte[0];
                                byte[] bArr26 = new byte[0];
                                byte[] bArr27 = new byte[0];
                                byte[] bArr28 = new byte[0];
                                byte[] bArr29 = new byte[0];
                                byte[] bArr30 = new byte[0];
                                WloginSigInfo wloginSigInfo2 = wloginAllSigInfo3._tk_map.get(Long.valueOf(j16));
                                long j36 = 0;
                                if (wloginSigInfo2 != null) {
                                    byte[] bArr31 = wloginSigInfo2._en_A1;
                                    if (bArr31 != null) {
                                        byte[] bArr32 = (byte[]) bArr31.clone();
                                        long j37 = wloginSigInfo2._A1_version;
                                        byte[] bArr33 = wloginSigInfo2._noPicSig;
                                        bArr25 = bArr33 != null ? (byte[]) bArr33.clone() : bArr25;
                                        bArr24 = bArr32;
                                        j36 = j37;
                                    }
                                    byte[] bArr34 = wloginSigInfo2._G;
                                    if (bArr34 != null) {
                                        bArr26 = (byte[]) bArr34.clone();
                                    }
                                    byte[] bArr35 = wloginSigInfo2._dpwd;
                                    if (bArr35 != null) {
                                        bArr27 = (byte[]) bArr35.clone();
                                    }
                                    byte[] bArr36 = wloginSigInfo2._randseed;
                                    if (bArr36 != null) {
                                        bArr28 = (byte[]) bArr36.clone();
                                    }
                                    byte[] bArr37 = wloginSigInfo2._psKey;
                                    bArr30 = wloginSigInfo2._pt4Token;
                                    bArr16 = bArr26;
                                    bArr17 = bArr27;
                                    bArr18 = bArr28;
                                    bArr20 = bArr37;
                                    j28 = j36;
                                    bArr21 = bArr24;
                                    bArr19 = bArr25;
                                } else {
                                    bArr16 = bArr26;
                                    bArr17 = bArr27;
                                    bArr18 = bArr28;
                                    bArr19 = bArr25;
                                    bArr20 = bArr29;
                                    j28 = 0;
                                    bArr21 = bArr24;
                                }
                                byte[] bArr38 = bArr14[6];
                                if (bArr38 == null || bArr38.length <= 2) {
                                    treeMap = a16;
                                    j29 = j28;
                                    bArr22 = bArr19;
                                    wloginAllSigInfo = wloginAllSigInfo3;
                                } else {
                                    HashMap hashMap = new HashMap();
                                    HashMap hashMap2 = new HashMap();
                                    byte[] bArr39 = bArr19;
                                    HashMap hashMap3 = new HashMap();
                                    HashMap hashMap4 = new HashMap();
                                    HashMap hashMap5 = hashMap;
                                    j29 = j28;
                                    bArr22 = bArr39;
                                    HashMap hashMap6 = hashMap3;
                                    Ticket.parsePsBuf(bArr20, j19, hashMap5, hashMap2, true);
                                    Ticket.parsePsBuf(bArr30, j19, hashMap6, hashMap4, false);
                                    util.LOGI("put_siginfo current pskey size:" + hashMap5.size() + ":" + hashMap2.size(), "");
                                    Iterator it = hashMap2.entrySet().iterator();
                                    while (it.hasNext()) {
                                        Map.Entry entry = (Map.Entry) it.next();
                                        String str2 = (String) entry.getKey();
                                        if (Ticket.isPskeyStorageExpired(((Long) entry.getValue()).longValue())) {
                                            it.remove();
                                            HashMap hashMap7 = hashMap5;
                                            hashMap7.remove(str2);
                                            util.LOGI("put_siginfo delete expired pskey from file,key:" + str2, "");
                                            hashMap5 = hashMap7;
                                        }
                                    }
                                    HashMap hashMap8 = hashMap5;
                                    Iterator it5 = hashMap4.entrySet().iterator();
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("put_siginfo current pt4token size:");
                                    sb5.append(hashMap6.size());
                                    sb5.append(":");
                                    sb5.append(hashMap4.size());
                                    loop1: while (true) {
                                        util.LOGI(sb5.toString(), "");
                                        while (it5.hasNext()) {
                                            Map.Entry entry2 = (Map.Entry) it5.next();
                                            str = (String) entry2.getKey();
                                            if (Ticket.isPskeyStorageExpired(((Long) entry2.getValue()).longValue())) {
                                                break;
                                            }
                                        }
                                        it5.remove();
                                        HashMap hashMap9 = hashMap6;
                                        hashMap9.remove(str);
                                        sb5 = new StringBuilder();
                                        sb5.append("put_siginfo delete expired pt4token from file,key:");
                                        sb5.append(str);
                                        hashMap6 = hashMap9;
                                    }
                                    HashMap hashMap10 = hashMap6;
                                    treeMap = a16;
                                    wloginAllSigInfo = wloginAllSigInfo3;
                                    Ticket.parseSvrPs(bArr14[6], j19, hashMap8, hashMap2, hashMap10, hashMap4);
                                    try {
                                        bArr14[6] = Ticket.packPsBuf(hashMap8, j19, hashMap2);
                                        bArr14[12] = Ticket.packPsBuf(hashMap10, j19, hashMap4);
                                    } catch (BufferOverflowException e16) {
                                        util.LOGI("map size " + hashMap8.size() + "is too large", String.valueOf(j3));
                                        oicq.wlogin_sdk.report.c.a aVar2 = new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_ALARM, "pskey_buffer_overflow", Log.getStackTraceString(e16));
                                        aVar2.f422860f = String.valueOf(j3);
                                        aVar2.f422858d = true;
                                        aVar2.f422859e = true;
                                        oicq.wlogin_sdk.report.c.b.a(aVar2);
                                        i17 = -1023;
                                        return i17;
                                    } catch (Exception e17) {
                                        util.printException(e17, String.valueOf(j3));
                                        oicq.wlogin_sdk.report.c.a aVar3 = new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_ALARM, "pskey_other_exception", Log.getStackTraceString(e17));
                                        aVar3.f422860f = String.valueOf(j3);
                                        aVar3.f422858d = true;
                                        aVar3.f422859e = true;
                                        oicq.wlogin_sdk.report.c.b.a(aVar3);
                                        i17 = -2006;
                                        return i17;
                                    }
                                }
                                wloginAllSigInfo.put_simpleinfo(wloginSimpleInfo);
                                byte[] bArr40 = bArr21;
                                try {
                                    wloginAllSigInfo.put_siginfo(j17, j18, j19, j26, j27, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7, bArr8, bArr9, bArr10, bArr11, bArr12, bArr13, bArr14, jArr, i3);
                                    byte[] bArr41 = bArr[0];
                                    if (bArr41 != null && bArr41.length > 0) {
                                        util.LOGI("A1_INFO: update A1 form ser : " + MD5.getMD5String(bArr[0]), "" + j3);
                                    }
                                    cVar2.a(j3, j16, bArr, j19, bArr15, wloginAllSigInfo);
                                    TreeMap treeMap2 = treeMap;
                                    treeMap2.put(Long.valueOf(j3), wloginAllSigInfo.get_clone());
                                    Object obj = c.f422871e;
                                    try {
                                        synchronized (obj) {
                                            cVar = cVar2;
                                            i16 = cVar.a(treeMap2, "tk_file");
                                            util.LOGI("put_siginfo save key result:tk_file:" + i16, "");
                                        }
                                        if (i16 == 0 || (wloginSigInfo = wloginAllSigInfo._tk_map.get(Long.valueOf(j16))) == null) {
                                            bArr23 = bArr40;
                                        } else {
                                            wloginSigInfo._A1_version = j29;
                                            bArr23 = bArr40;
                                            if (bArr23.length != 0) {
                                                wloginSigInfo._en_A1 = (byte[]) bArr23.clone();
                                            } else {
                                                util.LOGI("sappid_enA1 is null", "" + j3);
                                                oicq.wlogin_sdk.report.c.a aVar4 = new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_A1_SIG_LOSE, "2", "");
                                                aVar4.f422860f = String.valueOf(j3);
                                                oicq.wlogin_sdk.report.c.b.a(aVar4);
                                            }
                                            byte[] bArr42 = bArr22;
                                            if (bArr42.length != 0) {
                                                wloginSigInfo._noPicSig = (byte[]) bArr42.clone();
                                            }
                                            wloginSigInfo._G = (byte[]) bArr16.clone();
                                            wloginSigInfo._dpwd = (byte[]) bArr17.clone();
                                            wloginSigInfo._randseed = (byte[]) bArr18.clone();
                                        }
                                        aVar = cVar.a(wloginAllSigInfo._tk_map.get(Long.valueOf(j16)), i16, bArr23, j3, j16);
                                        util.LOGI("put_siginfo sig in memory changed", "" + j3);
                                        cVar.f422876b.put(Long.valueOf(j3), wloginAllSigInfo.get_clone());
                                    } catch (Throwable th6) {
                                        throw th6;
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    throw th;
                                }
                            } catch (Throwable th8) {
                                th = th8;
                            }
                        } catch (Throwable th9) {
                            th = th9;
                        }
                    }
                } else {
                    cVar = cVar2;
                    aVar = null;
                }
                if (aVar != null) {
                    oicq.wlogin_sdk.report.c.b.a(aVar);
                }
                i17 = i16;
            } catch (Throwable th10) {
                th = th10;
                throw th;
            }
        }
        return i17;
    }
}
