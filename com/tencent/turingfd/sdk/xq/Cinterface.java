package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.huawei.hms.hihealth.HiHealthStatusCodes;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.turingfd.sdk.xq.Aquila;
import com.tencent.turingfd.sdk.xq.Bennet;
import com.tencent.turingfd.sdk.xq.CanisMinor;
import com.tencent.turingfd.sdk.xq.Filbert;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import javax.crypto.Cipher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* renamed from: com.tencent.turingfd.sdk.xq.interface, reason: invalid class name */
/* loaded from: classes27.dex */
public class Cinterface implements Callable<Aquila> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final Aquila f383374a;

    /* renamed from: b, reason: collision with root package name */
    public final int f383375b;

    /* renamed from: c, reason: collision with root package name */
    public final String f383376c;

    /* renamed from: d, reason: collision with root package name */
    public final Pitaya f383377d;

    public Cinterface(int i3, String str, Aquila aquila, Pitaya pitaya) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, aquila, pitaya);
            return;
        }
        this.f383375b = i3;
        this.f383376c = str;
        this.f383374a = aquila;
        this.f383377d = pitaya;
    }

    public final void a(Aquila.Cif cif, int i3, String str) throws JSONException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, cif, Integer.valueOf(i3), str);
            return;
        }
        if (cif != null) {
            cif.a(i3, str);
        }
        Pitaya pitaya = this.f383377d;
        pitaya.a("EId_UId_GUrl_End", pitaya.f383023e, i3, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:153:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x00d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0115 A[Catch: all -> 0x011d, TRY_ENTER, TryCatch #13 {all -> 0x011d, blocks: (B:207:0x0115, B:210:0x0119), top: B:205:0x0113 }] */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0119 A[Catch: all -> 0x011d, TRY_LEAVE, TryCatch #13 {all -> 0x011d, blocks: (B:207:0x0115, B:210:0x0119), top: B:205:0x0113 }] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x017e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v95, types: [com.tencent.turingfd.sdk.xq.Aquila, java.lang.Object] */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Aquila call() throws Exception {
        Context context;
        String str;
        Context context2;
        Boolean bool;
        Boolean bool2;
        int i3;
        AtomicReference atomicReference;
        int i16;
        Context context3;
        Bennet.Cdo cdo;
        Network network;
        int i17;
        boolean isDataEnabled;
        Context context4;
        Aquila aquila;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Aquila.Cif a16 = this.f383374a.a();
        Pitaya pitaya = this.f383377d;
        pitaya.getClass();
        long currentTimeMillis = System.currentTimeMillis();
        pitaya.f383023e = currentTimeMillis;
        pitaya.a("EId_UId_GUrl_Start", currentTimeMillis);
        synchronized (Celse.class) {
            context = Celse.f383328a;
        }
        try {
            str = DeviceInfoMonitor.getSimOperator((TelephonyManager) context.getSystemService("phone"));
        } catch (Throwable unused) {
            str = null;
        }
        synchronized (Celse.class) {
            context2 = Celse.f383328a;
        }
        byte b16 = Bennet.b(context2);
        if (b16 != -1) {
            if (b16 != 0) {
                if (b16 != 1 && b16 != 2) {
                    if (b16 != 3) {
                        a(a16, -50019, (String) null);
                        return this.f383374a;
                    }
                } else {
                    network = null;
                    cdo = null;
                    i17 = 0;
                    try {
                        synchronized (Celse.class) {
                            context4 = Celse.f383328a;
                        }
                        Gemini a17 = i.a(context4);
                        if (((Sultana) a17).f383115c != 0) {
                            a(a16, ((Sultana) a17).f383115c, (String) null);
                            aquila = this.f383374a;
                            if (cdo == null) {
                                return aquila;
                            }
                        } else {
                            String str2 = ((Sultana) a17).f383113a;
                            if (a16.f382572f != null) {
                                synchronized (a16.f382567a) {
                                    a16.f382572f.put("device_ticket", str2);
                                }
                            }
                            String a18 = a(str2, str, i17, network, this.f383377d.f383025g);
                            if (a18 == null) {
                                a(a16, -50020, (String) null);
                                aquila = this.f383374a;
                                if (cdo == null) {
                                    return aquila;
                                }
                            } else {
                                try {
                                    Filbert.Cdo a19 = new Filbert.Cdo("https://tdid.m.qq.com/gw_urls/get").a(a18);
                                    a19.f382762f = 10000;
                                    a19.f382764h = network;
                                    a19.f382763g = 10000;
                                    a19.f382766j = true;
                                    Ginkgo a26 = Crux.a(new Filbert(a19));
                                    int i18 = a26.f382780a;
                                    if (i18 != 200) {
                                        a(a16, (-51000) - i18, (String) null);
                                        aquila = this.f383374a;
                                        if (cdo == null) {
                                            return aquila;
                                        }
                                    } else if (a26.f382783d) {
                                        a(a16, -50022, "redirected location: " + a26.f382782c);
                                        aquila = this.f383374a;
                                        if (cdo == null) {
                                            return aquila;
                                        }
                                    } else {
                                        CanisMinor a27 = CanisMinor.a(a26.f382781b);
                                        if (a27 == null) {
                                            a(a16, HiHealthStatusCodes.NO_SAVED_DEVICE_ERROR, (String) null);
                                            aquila = this.f383374a;
                                            if (cdo == null) {
                                                return aquila;
                                            }
                                        } else {
                                            int i19 = a27.f382624a;
                                            if (i19 != 0) {
                                                a(a16, i19 - 70000, (String) null);
                                                aquila = this.f383374a;
                                                if (cdo == null) {
                                                    return aquila;
                                                }
                                            } else {
                                                Pitaya pitaya2 = this.f383377d;
                                                pitaya2.a("EId_UId_GUrl_End", pitaya2.f383023e, 0, null);
                                                a16.a(a27.f382626c);
                                                ArrayList arrayList = new ArrayList();
                                                for (CanisMinor.Cdo cdo2 : a27.f382625b) {
                                                    Aquila.Cdo a28 = a16.a();
                                                    arrayList.add(new Pair(Cstrictfp.f383431a.submit(new Cvolatile(this, network, cdo2, a28)), a28));
                                                }
                                                Iterator it = arrayList.iterator();
                                                while (it.hasNext()) {
                                                    Pair pair = (Pair) it.next();
                                                    try {
                                                        ((Future) pair.first).get();
                                                    } catch (InterruptedException unused2) {
                                                        ((Aquila.Cdo) pair.second).a("action interrupted");
                                                    } catch (ExecutionException e16) {
                                                        ((Aquila.Cdo) pair.second).a("action exception: " + e16.getCause());
                                                    }
                                                }
                                                if (cdo != null) {
                                                    cdo.a();
                                                }
                                                return this.f383374a;
                                            }
                                        }
                                    }
                                } catch (SocketTimeoutException e17) {
                                    a(a16, HiHealthStatusCodes.NO_MONITOR_ERROR, e17.toString());
                                    aquila = this.f383374a;
                                    if (cdo == null) {
                                        return aquila;
                                    }
                                } catch (UnknownHostException e18) {
                                    a(a16, -50004, e18.toString());
                                    aquila = this.f383374a;
                                    if (cdo == null) {
                                        return aquila;
                                    }
                                } catch (IOException e19) {
                                    a(a16, HiHealthStatusCodes.EXISTED_RECORDER_ERROR, e19.toString());
                                    aquila = this.f383374a;
                                    if (cdo == null) {
                                        return aquila;
                                    }
                                }
                            }
                        }
                        cdo.a();
                        return aquila;
                    } catch (Throwable th5) {
                        if (cdo != null) {
                            cdo.a();
                        }
                        throw th5;
                    }
                }
            }
            if (TextUtils.isEmpty(str)) {
                a(a16, -50011, (String) null);
                return this.f383374a;
            }
            synchronized (Celse.class) {
                Context context5 = Celse.f383328a;
                int i26 = Build.VERSION.SDK_INT;
                TelephonyManager telephonyManager = (TelephonyManager) context5.getSystemService("phone");
                if (telephonyManager != null) {
                    if (i26 >= 26) {
                        isDataEnabled = telephonyManager.isDataEnabled();
                        bool = Boolean.valueOf(isDataEnabled);
                    } else {
                        Method declaredMethod = Class.forName(telephonyManager.getClass().getName()).getDeclaredMethod("getDataEnabled", new Class[0]);
                        declaredMethod.setAccessible(true);
                        bool = (Boolean) declaredMethod.invoke(telephonyManager, new Object[0]);
                    }
                    if (bool == null) {
                    }
                    bool2 = bool;
                    i3 = Build.VERSION.SDK_INT;
                    atomicReference = new AtomicReference(null);
                    if (!bool2.booleanValue()) {
                    }
                    synchronized (Celse.class) {
                    }
                } else {
                    bool = null;
                    if (bool == null) {
                        bool = Boolean.TRUE;
                    }
                    bool2 = bool;
                    i3 = Build.VERSION.SDK_INT;
                    atomicReference = new AtomicReference(null);
                    if (!bool2.booleanValue()) {
                        i16 = 10000;
                    } else {
                        i16 = 1000;
                    }
                    synchronized (Celse.class) {
                        context3 = Celse.f383328a;
                    }
                    ConnectivityManager connectivityManager = (ConnectivityManager) Celse.f383328a.getSystemService("connectivity");
                    NetworkRequest build = new NetworkRequest.Builder().addTransportType(0).addCapability(12).build();
                    cdo = new Bennet.Cdo(i16);
                    try {
                        if (i3 < 26) {
                            connectivityManager.requestNetwork(build, cdo, i16);
                        } else {
                            connectivityManager.requestNetwork(build, cdo);
                        }
                    } catch (Throwable th6) {
                        atomicReference.set(th6.toString());
                    }
                    if (cdo == null) {
                        a(a16, -50010, (String) atomicReference.get());
                        return this.f383374a;
                    }
                    synchronized (cdo) {
                        if (cdo.f382586a == null) {
                            if (cdo.f382587b - ((int) (SystemClock.elapsedRealtime() - cdo.f382588c)) > 0) {
                                try {
                                    cdo.wait(cdo.f382587b);
                                } catch (InterruptedException unused3) {
                                }
                            }
                        }
                    }
                    if (cdo.f382586a instanceof Network) {
                        network = (Network) cdo.f382586a;
                    } else {
                        network = null;
                    }
                    if (network == null) {
                        if (!bool2.booleanValue()) {
                            a(a16, -50008, (String) null);
                        } else {
                            a(a16, -50009, (String) null);
                        }
                        return this.f383374a;
                    }
                    if (b16 == 0) {
                        i17 = 1;
                    } else {
                        i17 = 2;
                    }
                    synchronized (Celse.class) {
                    }
                }
            }
            if (Bryony.a(context3, "android.permission.CHANGE_NETWORK_STATE") != 0) {
                atomicReference.set("no permission");
            } else {
                synchronized (Celse.class) {
                    ConnectivityManager connectivityManager2 = (ConnectivityManager) Celse.f383328a.getSystemService("connectivity");
                    NetworkRequest build2 = new NetworkRequest.Builder().addTransportType(0).addCapability(12).build();
                    cdo = new Bennet.Cdo(i16);
                    if (i3 < 26) {
                    }
                    if (cdo == null) {
                    }
                }
            }
            cdo = null;
            if (cdo == null) {
            }
        } else {
            a(a16, -50007, (String) null);
            return this.f383374a;
        }
    }

    public final JSONObject a() throws JSONException {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (JSONObject) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", 3);
        jSONObject.put(WadlProxyConsts.CHANNEL, Nectarine.f382928a);
        jSONObject.put(AudienceReportConst.CLIENT_TYPE, 30100);
        jSONObject.put("biz_flags", this.f383375b);
        jSONObject.put("platform", 2);
        try {
            str = TNative$aa.j89_A931D6BEC30CD812();
        } catch (Throwable unused) {
            str = null;
        }
        int i3 = Plum.f383026a;
        if (str == null) {
            str = "";
        }
        jSONObject.put("uuid", str);
        return jSONObject;
    }

    public final String a(String str, String str2, int i3, Network network, String str3) throws JSONException {
        String str4;
        Context context;
        String a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, this, str, str2, Integer.valueOf(i3), network, str3);
        }
        JSONObject a17 = a();
        a17.put("seq", str3);
        a17.put("device_ticket", str);
        if (!TextUtils.isEmpty(str2)) {
            a17.put(JsonRuleKey.OPERATOR, str2);
        }
        String str5 = null;
        try {
            byte[] bytes = Plum.a(16).getBytes();
            byte[] k89_A931D6BEC30CD812 = TNative$aa.k89_A931D6BEC30CD812(bytes);
            if (k89_A931D6BEC30CD812 == null) {
                return null;
            }
            a17.put("ext_data", Base64.encodeToString(k89_A931D6BEC30CD812, 2));
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqw7BR7j7bwK6hD/0ceKNOrvHMO63K/3hWgMFoAfYbJuBamJCZLsa1hCfnk9KZtPjFv5tJJ2T6VjSQWc4zqx0O5E4FH+DuBGR809nJ/uLKfDOFl3YDTVYti1cWPfEaz/R+spkHxtko6Rx73oPhdo8ei099Y6sd3O3q47qHAgJT5L8AGTenxFdMDJnVY0Q4RzZuk7qAiLmSMXgOGOOZiphxy5jfk48s2PO6eg27iz6bxNkzfLVtz6D1fhjycE7t/INX3G8NUYH8VB1woU9fP450w8qcJdj0PPaYStJaVv5dJxf0zNHOCWpl8+4A4ugq1fS9RNTCNnZ27+3Q5++nEKBrQIDAQAB", 0)));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, generatePublic);
            a17.put("ext_key", Base64.encodeToString(cipher.doFinal(bytes), 2));
            a17.put("net_type", i3);
            if (!TextUtils.isEmpty(this.f383376c)) {
                a17.put("biz_session_id", this.f383376c);
            }
            StringBuilder sb5 = new StringBuilder();
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkMonitor.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    if (!nextElement.getName().toLowerCase().contains("wlan")) {
                        Enumeration<InetAddress> inetAddresses = NetworkMonitor.getInetAddresses(nextElement);
                        while (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement2 = inetAddresses.nextElement();
                            if (!nextElement2.isLoopbackAddress() && !nextElement2.isLinkLocalAddress()) {
                                if (sb5.length() > 0) {
                                    sb5.append(",");
                                }
                                sb5.append(nextElement2.getHostAddress());
                            }
                        }
                    }
                }
                str4 = Base64.encodeToString(Cdefault.b(sb5.toString().getBytes(), Cdefault.a()), 2);
            } catch (Throwable unused) {
                str4 = "";
            }
            a17.put("ifa", str4);
            try {
                synchronized (Celse.class) {
                    context = Celse.f383328a;
                }
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (network == null && i3 == 0) {
                    network = connectivityManager.getActiveNetwork();
                }
                if (network != null && (a16 = Bennet.a(network)) != null && !a16.isEmpty()) {
                    str5 = Base64.encodeToString(Cdefault.b(a16.getBytes(), Cdefault.a()), 2);
                }
            } catch (Throwable unused2) {
            }
            if (!TextUtils.isEmpty(str5)) {
                a17.put("c_props", str5);
            }
            return a17.toString();
        } catch (Throwable unused3) {
            return null;
        }
    }

    public final String a(String str, String str2) throws JSONException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
        }
        JSONObject a16 = a();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("action_session", str);
        jSONObject.put("data", str2);
        JSONArray jSONArray = new JSONArray();
        jSONArray.mo162put(jSONObject);
        a16.put("action_results", jSONArray);
        return a16.toString();
    }

    public final void a(Network network, CanisMinor.Cdo cdo, Aquila.Cdo cdo2) throws JSONException {
        Filbert.Cdo a16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, network, cdo, cdo2);
            return;
        }
        String str2 = cdo.f382632f;
        synchronized (cdo2.f382565a) {
            cdo2.f382566b.put("action_session", str2);
        }
        if ("trans".equals(cdo.f382628b)) {
            return;
        }
        if (com.tencent.ams.dynamicwidget.http.Method.POST.equals(cdo.f382628b)) {
            try {
                a16 = new Filbert.Cdo(cdo.f382629c).a(cdo.f382630d);
                if (!TextUtils.isEmpty(cdo.f382631e)) {
                    a16.f382760d.put("Content-Type", cdo.f382631e);
                }
            } catch (MalformedURLException unused) {
                StringBuilder a17 = Flat.a("carrier invalid url:");
                a17.append(cdo.f382629c);
                cdo2.a(a17.toString());
                return;
            }
        } else if ("get".equals(cdo.f382628b)) {
            try {
                a16 = new Filbert.Cdo(cdo.f382629c);
                a16.f382759c = "GET";
            } catch (MalformedURLException unused2) {
                StringBuilder a18 = Flat.a("carrier invalid url:");
                a18.append(cdo.f382629c);
                cdo2.a(a18.toString());
                return;
            }
        } else {
            StringBuilder a19 = Flat.a("unsupported method: ");
            a19.append(cdo.f382628b);
            cdo2.a(a19.toString());
            return;
        }
        a16.f382766j = true;
        a16.f382762f = 10000;
        a16.f382763g = 10000;
        a16.f382765i = cdo.f382635i;
        if (cdo.f382634h) {
            a16.f382764h = network;
        }
        try {
            Ginkgo a26 = Crux.a(new Filbert(a16));
            if (!cdo.f382635i && a26.f382783d) {
                str = a26.f382782c;
            } else if (a26.f382780a != 200) {
                StringBuilder a27 = Flat.a("http code:");
                a27.append(a26.f382780a);
                cdo2.a(a27.toString());
                return;
            } else {
                try {
                    str = new String(a26.f382781b, "utf-8");
                } catch (UnsupportedEncodingException unused3) {
                    cdo2.a("carrier body decode fail");
                    return;
                }
            }
            if (!cdo.f382627a) {
                synchronized (cdo2.f382565a) {
                    cdo2.f382566b.put("data", str);
                }
                return;
            }
            String[] strArr = cdo.f382633g;
            if (strArr != null) {
                for (String str3 : strArr) {
                    if (str.contains(str3)) {
                        synchronized (cdo2.f382565a) {
                            cdo2.f382566b.put("data", str);
                        }
                        return;
                    }
                }
            }
            try {
                Filbert.Cdo a28 = new Filbert.Cdo("https://tdid.m.qq.com/gw_urls/get").a(a(cdo.f382632f, str));
                a28.f382762f = 10000;
                a28.f382764h = network;
                a28.f382763g = 10000;
                Ginkgo a29 = Crux.a(new Filbert(a28));
                if (a29.f382780a != 200) {
                    StringBuilder a36 = Flat.a("next url code:");
                    a36.append(a29.f382780a);
                    cdo2.a(a36.toString());
                    return;
                }
                if (a29.f382783d) {
                    StringBuilder a37 = Flat.a("next url redirected, location: ");
                    a37.append(a29.f382782c);
                    cdo2.a(a37.toString());
                    return;
                }
                CanisMinor a38 = CanisMinor.a(a29.f382781b);
                if (a38 == null) {
                    cdo2.a("invalid next url resp");
                    return;
                }
                if (a38.f382624a != 0) {
                    StringBuilder a39 = Flat.a("next url ret: ");
                    a39.append(a38.f382624a);
                    cdo2.a(a39.toString());
                    return;
                }
                CanisMinor.Cdo[] cdoArr = a38.f382625b;
                if (cdoArr.length != 1) {
                    StringBuilder a46 = Flat.a("next url length: ");
                    a46.append(a38.f382625b.length);
                    cdo2.a(a46.toString());
                    return;
                }
                a(network, cdoArr[0], cdo2);
            } catch (SocketTimeoutException unused4) {
                cdo2.a("next url timeout");
            } catch (IOException e16) {
                cdo2.a("next url exception:" + e16);
            }
        } catch (SocketTimeoutException unused5) {
            cdo2.a("carrier timeout");
        } catch (IOException e17) {
            cdo2.a("carrier exception: " + e17);
        }
    }
}
