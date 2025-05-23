package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.jf.dexlib2.analysis.RegisterType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class bb {

    /* renamed from: j, reason: collision with root package name */
    protected static Context f388238j;

    /* renamed from: k, reason: collision with root package name */
    private static bb f388239k;

    /* renamed from: l, reason: collision with root package name */
    private static c f388240l;

    /* renamed from: m, reason: collision with root package name */
    private static String f388241m;

    /* renamed from: n, reason: collision with root package name */
    private static String f388242n;

    /* renamed from: a, reason: collision with root package name */
    protected final Map<String, ay> f388244a;

    /* renamed from: b, reason: collision with root package name */
    private ba f388245b;

    /* renamed from: c, reason: collision with root package name */
    protected d f388246c;

    /* renamed from: d, reason: collision with root package name */
    private String f388247d;

    /* renamed from: e, reason: collision with root package name */
    private long f388248e;

    /* renamed from: f, reason: collision with root package name */
    private final long f388249f;

    /* renamed from: g, reason: collision with root package name */
    private long f388250g;

    /* renamed from: h, reason: collision with root package name */
    private String f388251h;

    /* renamed from: i, reason: collision with root package name */
    protected static final Map<String, ax> f388237i = new HashMap();

    /* renamed from: o, reason: collision with root package name */
    protected static boolean f388243o = false;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a implements ba {
        a() {
        }

        @Override // com.xiaomi.push.ba
        public boolean a(String str) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b extends ax {

        /* renamed from: o, reason: collision with root package name */
        ax f388253o;

        /* renamed from: p, reason: collision with root package name */
        final /* synthetic */ ax f388254p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, ax axVar) {
            super(str);
            this.f388254p = axVar;
            this.f388253o = axVar;
            this.f388221d = this.f388221d;
            if (axVar != null) {
                this.f388225h = axVar.f388225h;
            }
        }

        @Override // com.xiaomi.push.ax
        public synchronized ArrayList<String> e(boolean z16) {
            ArrayList<String> arrayList;
            arrayList = new ArrayList<>();
            ax axVar = this.f388253o;
            if (axVar != null) {
                arrayList.addAll(axVar.e(true));
            }
            Map<String, ax> map = bb.f388237i;
            synchronized (map) {
                ax axVar2 = map.get(this.f388221d);
                if (axVar2 != null) {
                    Iterator<String> it = axVar2.e(true).iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (arrayList.indexOf(next) == -1) {
                            arrayList.add(next);
                        }
                    }
                    arrayList.remove(this.f388221d);
                    arrayList.add(this.f388221d);
                }
            }
            return arrayList;
        }

        @Override // com.xiaomi.push.ax
        public synchronized void n(String str, aw awVar) {
            ax axVar = this.f388253o;
            if (axVar != null) {
                axVar.n(str, awVar);
            }
        }

        @Override // com.xiaomi.push.ax
        public boolean u() {
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface c {
        bb a(Context context, ba baVar, d dVar, String str);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface d {
        String a(String str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public bb(Context context, ba baVar, d dVar, String str) {
        this(context, baVar, dVar, str, null, null);
    }

    private String D() {
        return "host_fallbacks";
    }

    private String E() {
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(f388238j.getPackageManager(), f388238j.getPackageName(), 16384);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return "0";
        } catch (Exception unused) {
            return "0";
        }
    }

    public static synchronized bb c() {
        bb bbVar;
        synchronized (bb.class) {
            bbVar = f388239k;
            if (bbVar == null) {
                throw new IllegalStateException("the host manager is not initialized yet.");
            }
        }
        return bbVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d() {
        if (f388238j == null) {
            return "unknown";
        }
        try {
            x e16 = au.e();
            if (e16 == null) {
                return "unknown";
            }
            if (e16.a() == 1) {
                return "WIFI-UNKNOWN";
            }
            return e16.e() + "-" + e16.h();
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    static String e(String str) {
        try {
            int length = str.length();
            byte[] bytes = str.getBytes("UTF-8");
            for (int i3 = 0; i3 < bytes.length; i3++) {
                byte b16 = bytes[i3];
                int i16 = b16 & 240;
                if (i16 != 240) {
                    bytes[i3] = (byte) (((b16 & RegisterType.DOUBLE_HI) ^ ((byte) (((b16 >> 4) + length) & 15))) | i16);
                }
            }
            return new String(bytes);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    private ArrayList<ax> g(ArrayList<String> arrayList) {
        String str;
        long j3;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        C();
        synchronized (this.f388244a) {
            o();
            for (String str2 : this.f388244a.keySet()) {
                if (!arrayList.contains(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        Map<String, ax> map = f388237i;
        synchronized (map) {
            for (Object obj : map.values().toArray()) {
                ax axVar = (ax) obj;
                if (!axVar.u()) {
                    f388237i.remove(axVar.f388221d);
                }
            }
        }
        if (!arrayList.contains(r())) {
            arrayList.add(r());
        }
        ArrayList<ax> arrayList2 = new ArrayList<>(arrayList.size());
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            arrayList2.add(null);
        }
        try {
            if (au.x(f388238j)) {
                str = "wifi";
            } else {
                str = "wap";
            }
            String f16 = f(arrayList, str, this.f388247d, true);
            if (!TextUtils.isEmpty(f16)) {
                JSONObject jSONObject3 = new JSONObject(f16);
                jz4.c.w(f16);
                if ("OK".equalsIgnoreCase(jSONObject3.getString(ExifInterface.LATITUDE_SOUTH))) {
                    JSONObject jSONObject4 = jSONObject3.getJSONObject(BdhLogUtil.LogTag.Tag_Req);
                    String string = jSONObject4.getString("province");
                    String string2 = jSONObject4.getString("city");
                    String string3 = jSONObject4.getString("isp");
                    String string4 = jSONObject4.getString("ip");
                    String string5 = jSONObject4.getString("country");
                    JSONObject jSONObject5 = jSONObject4.getJSONObject(str);
                    jz4.c.z("get bucket: net=" + string3 + ", hosts=" + jSONObject5.toString());
                    int i16 = 0;
                    while (i16 < arrayList.size()) {
                        String str3 = arrayList.get(i16);
                        JSONArray optJSONArray = jSONObject5.optJSONArray(str3);
                        if (optJSONArray == null) {
                            jz4.c.m("no bucket found for " + str3);
                            jSONObject = jSONObject5;
                        } else {
                            ax axVar2 = new ax(str3);
                            int i17 = 0;
                            while (i17 < optJSONArray.length()) {
                                String string6 = optJSONArray.getString(i17);
                                if (!TextUtils.isEmpty(string6)) {
                                    jSONObject2 = jSONObject5;
                                    axVar2.i(new be(string6, optJSONArray.length() - i17));
                                } else {
                                    jSONObject2 = jSONObject5;
                                }
                                i17++;
                                jSONObject5 = jSONObject2;
                            }
                            jSONObject = jSONObject5;
                            arrayList2.set(i16, axVar2);
                            axVar2.f388226i = string5;
                            axVar2.f388222e = string;
                            axVar2.f388224g = string3;
                            axVar2.f388225h = string4;
                            axVar2.f388223f = string2;
                            if (jSONObject4.has("stat-percent")) {
                                axVar2.g(jSONObject4.getDouble("stat-percent"));
                            }
                            if (jSONObject4.has("stat-domain")) {
                                axVar2.r(jSONObject4.getString("stat-domain"));
                            }
                            if (jSONObject4.has(RemoteMessageConst.TTL)) {
                                axVar2.h(jSONObject4.getInt(RemoteMessageConst.TTL) * 1000);
                            }
                            l(axVar2.b());
                        }
                        i16++;
                        jSONObject5 = jSONObject;
                    }
                    JSONObject optJSONObject = jSONObject4.optJSONObject("reserved");
                    if (optJSONObject != null) {
                        if (jSONObject4.has("reserved-ttl")) {
                            j3 = jSONObject4.getInt("reserved-ttl") * 1000;
                        } else {
                            j3 = 604800000;
                        }
                        Iterator keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String str4 = (String) keys.next();
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray(str4);
                            if (optJSONArray2 == null) {
                                jz4.c.m("no bucket found for " + str4);
                            } else {
                                ax axVar3 = new ax(str4);
                                axVar3.h(j3);
                                for (int i18 = 0; i18 < optJSONArray2.length(); i18++) {
                                    String string7 = optJSONArray2.getString(i18);
                                    if (!TextUtils.isEmpty(string7)) {
                                        axVar3.i(new be(string7, optJSONArray2.length() - i18));
                                    }
                                }
                                Map<String, ax> map2 = f388237i;
                                synchronized (map2) {
                                    if (this.f388245b.a(str4)) {
                                        map2.put(str4, axVar3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e16) {
            jz4.c.m("failed to get bucket " + e16.getMessage());
        }
        for (int i19 = 0; i19 < arrayList.size(); i19++) {
            ax axVar4 = arrayList2.get(i19);
            if (axVar4 != null) {
                m(arrayList.get(i19), axVar4);
            }
        }
        w();
        return arrayList2;
    }

    public static synchronized void j(Context context, ba baVar, d dVar, String str, String str2, String str3) {
        synchronized (bb.class) {
            Context applicationContext = context.getApplicationContext();
            f388238j = applicationContext;
            if (applicationContext == null) {
                f388238j = context;
            }
            if (f388239k == null) {
                c cVar = f388240l;
                if (cVar == null) {
                    f388239k = new bb(context, baVar, dVar, str, str2, str3);
                } else {
                    f388239k = cVar.a(context, baVar, dVar, str);
                }
            }
        }
    }

    public static synchronized void k(c cVar) {
        synchronized (bb.class) {
            f388240l = cVar;
            f388239k = null;
        }
    }

    public static void n(String str, String str2) {
        Map<String, ax> map = f388237i;
        ax axVar = map.get(str);
        synchronized (map) {
            if (axVar == null) {
                ax axVar2 = new ax(str);
                axVar2.h(604800000L);
                axVar2.j(str2);
                map.put(str, axVar2);
            } else {
                axVar.j(str2);
            }
        }
    }

    private byte[] p() {
        return ad.c(f388238j.getPackageName() + "_key_salt");
    }

    protected ax A(String str) {
        if (System.currentTimeMillis() - this.f388250g > this.f388248e * 60 * 1000) {
            this.f388250g = System.currentTimeMillis();
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            ax axVar = g(arrayList).get(0);
            if (axVar != null) {
                this.f388248e = 0L;
                return axVar;
            }
            long j3 = this.f388248e;
            if (j3 < 15) {
                this.f388248e = j3 + 1;
                return null;
            }
            return null;
        }
        return null;
    }

    protected String B() {
        if ("com.xiaomi.xmsf".equals(f388241m)) {
            return f388241m;
        }
        return f388241m + ":pushservice";
    }

    public void C() {
        String next;
        synchronized (this.f388244a) {
            Iterator<ay> it = this.f388244a.values().iterator();
            while (it.hasNext()) {
                it.next().g(true);
            }
            while (true) {
                for (boolean z16 = false; !z16; z16 = true) {
                    Iterator<String> it5 = this.f388244a.keySet().iterator();
                    while (it5.hasNext()) {
                        next = it5.next();
                        if (this.f388244a.get(next).d().isEmpty()) {
                            break;
                        }
                    }
                }
                this.f388244a.remove(next);
            }
        }
    }

    public ax a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return b(new URL(str).getHost(), true);
        }
        throw new IllegalArgumentException("the url is empty");
    }

    public ax b(String str, boolean z16) {
        ax A;
        jz4.c.y("HostManager", "-->getFallbacksByHost(): host=", str, ", fetchRemoteIfNeed=", Boolean.valueOf(z16));
        if (!TextUtils.isEmpty(str)) {
            if (!this.f388245b.a(str)) {
                return null;
            }
            ax u16 = u(str);
            if (u16 != null && u16.u()) {
                return u16;
            }
            if (z16 && au.t(f388238j) && (A = A(str)) != null) {
                return A;
            }
            return new b(str, u16);
        }
        throw new IllegalArgumentException("the host is empty");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String f(ArrayList<String> arrayList, String str, String str2, boolean z16) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<w> arrayList3 = new ArrayList();
        arrayList3.add(new t("type", str));
        if (str.equals("wap")) {
            arrayList3.add(new t("conpt", e(au.j(f388238j))));
        }
        if (z16) {
            arrayList3.add(new t("reserved", "1"));
        }
        arrayList3.add(new t("uuid", str2));
        arrayList3.add(new t("list", ag.d(arrayList, ",")));
        arrayList3.add(new t("countrycode", com.xiaomi.push.service.ag.a(f388238j).f()));
        arrayList3.add(new t("push_sdk_vc", String.valueOf(50909)));
        String r16 = r();
        ax u16 = u(r16);
        String format = String.format(Locale.US, "https://%1$s/gslb/?ver=5.0", r16);
        if (u16 == null) {
            arrayList2.add(format);
            Map<String, ax> map = f388237i;
            synchronized (map) {
                ax axVar = map.get(r16);
                if (axVar != null) {
                    Iterator<String> it = axVar.e(true).iterator();
                    while (it.hasNext()) {
                        arrayList2.add(String.format(Locale.US, "https://%1$s/gslb/?ver=5.0", it.next()));
                    }
                }
            }
        } else {
            arrayList2 = u16.d(format);
        }
        Iterator<String> it5 = arrayList2.iterator();
        IOException e16 = null;
        while (it5.hasNext()) {
            Uri.Builder buildUpon = Uri.parse(it5.next()).buildUpon();
            for (w wVar : arrayList3) {
                buildUpon.appendQueryParameter(wVar.a(), wVar.b());
            }
            try {
                d dVar = this.f388246c;
                if (dVar == null) {
                    return au.k(f388238j, new URL(buildUpon.toString()));
                }
                return dVar.a(buildUpon.toString());
            } catch (IOException e17) {
                e16 = e17;
            }
        }
        if (e16 == null) {
            return null;
        }
        jz4.c.m("network exception: " + e16.getMessage());
        throw e16;
    }

    protected JSONObject h() {
        JSONObject jSONObject;
        synchronized (this.f388244a) {
            jSONObject = new JSONObject();
            jSONObject.put("ver", 2);
            JSONArray jSONArray = new JSONArray();
            Iterator<ay> it = this.f388244a.values().iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(it.next().e());
            }
            jSONObject.put("data", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            Iterator<ax> it5 = f388237i.values().iterator();
            while (it5.hasNext()) {
                jSONArray2.mo162put(it5.next().f());
            }
            jSONObject.put("reserved", jSONArray2);
        }
        return jSONObject;
    }

    public void i() {
        synchronized (this.f388244a) {
            this.f388244a.clear();
        }
    }

    public void l(String str) {
        this.f388251h = str;
    }

    public void m(String str, ax axVar) {
        if (!TextUtils.isEmpty(str) && axVar != null) {
            if (this.f388245b.a(str)) {
                synchronized (this.f388244a) {
                    o();
                    if (this.f388244a.containsKey(str)) {
                        this.f388244a.get(str).f(axVar);
                    } else {
                        ay ayVar = new ay(str);
                        ayVar.f(axVar);
                        this.f388244a.put(str, ayVar);
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("the argument is invalid " + str + ", " + axVar);
    }

    protected boolean o() {
        synchronized (this.f388244a) {
            if (f388243o) {
                return true;
            }
            f388243o = true;
            this.f388244a.clear();
            try {
                String y16 = y();
                if (!TextUtils.isEmpty(y16)) {
                    t(y16);
                    jz4.c.w("loading the new hosts succeed");
                    return true;
                }
            } catch (Throwable th5) {
                jz4.c.m("load bucket failure: " + th5.getMessage());
            }
            return false;
        }
    }

    public ax q(String str) {
        return b(str, true);
    }

    protected String r() {
        return "resolver.msg.xiaomi.net";
    }

    public void s() {
        ArrayList<String> arrayList;
        synchronized (this.f388244a) {
            o();
            arrayList = new ArrayList<>(this.f388244a.keySet());
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ay ayVar = this.f388244a.get(arrayList.get(size));
                if (ayVar != null && ayVar.a() != null) {
                    arrayList.remove(size);
                }
            }
        }
        ArrayList<ax> g16 = g(arrayList);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (g16.get(i3) != null) {
                m(arrayList.get(i3), g16.get(i3));
            }
        }
    }

    protected void t(String str) {
        synchronized (this.f388244a) {
            this.f388244a.clear();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("ver") == 2) {
                JSONArray optJSONArray = jSONObject.optJSONArray("data");
                if (optJSONArray != null) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        ay b16 = new ay().b(optJSONArray.getJSONObject(i3));
                        this.f388244a.put(b16.c(), b16);
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("reserved");
                if (optJSONArray2 != null) {
                    for (int i16 = 0; i16 < optJSONArray2.length(); i16++) {
                        JSONObject jSONObject2 = optJSONArray2.getJSONObject(i16);
                        String optString = jSONObject2.optString("host");
                        if (!TextUtils.isEmpty(optString)) {
                            try {
                                ax a16 = new ax(optString).a(jSONObject2);
                                f388237i.put(a16.f388221d, a16);
                                jz4.c.m("load local reserved host for " + a16.f388221d);
                            } catch (JSONException unused) {
                                jz4.c.m("parse reserved host fail.");
                            }
                        }
                    }
                }
            } else {
                throw new JSONException("Bad version");
            }
        }
    }

    protected ax u(String str) {
        ay ayVar;
        ax a16;
        synchronized (this.f388244a) {
            o();
            ayVar = this.f388244a.get(str);
        }
        if (ayVar != null && (a16 = ayVar.a()) != null) {
            return a16;
        }
        return null;
    }

    public String v() {
        StringBuilder sb5 = new StringBuilder();
        synchronized (this.f388244a) {
            for (Map.Entry<String, ay> entry : this.f388244a.entrySet()) {
                sb5.append(entry.getKey());
                sb5.append(":\n");
                sb5.append(entry.getValue().toString());
                sb5.append("\n");
            }
        }
        return sb5.toString();
    }

    public void w() {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        Throwable th5;
        Exception e16;
        synchronized (this.f388244a) {
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                String jSONObject = h().toString();
                jz4.c.w("persist host fallbacks = " + jSONObject);
                if (!TextUtils.isEmpty(jSONObject)) {
                    fileOutputStream = f388238j.openFileOutput(D(), 0);
                    try {
                        bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    } catch (Exception e17) {
                        e = e17;
                        bufferedOutputStream = null;
                        e16 = e;
                        jz4.c.m("persist bucket failure: " + e16.getMessage());
                        in.b(bufferedOutputStream);
                        in.b(fileOutputStream);
                    } catch (Throwable th6) {
                        th = th6;
                        bufferedOutputStream = null;
                        th5 = th;
                        in.b(bufferedOutputStream);
                        in.b(fileOutputStream);
                        throw th5;
                    }
                    try {
                        try {
                            bufferedOutputStream.write(fu.c(p(), jSONObject.getBytes(StandardCharsets.UTF_8)));
                            bufferedOutputStream.flush();
                            bufferedOutputStream2 = bufferedOutputStream;
                        } catch (Throwable th7) {
                            th5 = th7;
                            in.b(bufferedOutputStream);
                            in.b(fileOutputStream);
                            throw th5;
                        }
                    } catch (Exception e18) {
                        e16 = e18;
                        jz4.c.m("persist bucket failure: " + e16.getMessage());
                        in.b(bufferedOutputStream);
                        in.b(fileOutputStream);
                    }
                } else {
                    fileOutputStream = null;
                }
                in.b(bufferedOutputStream2);
            } catch (Exception e19) {
                e = e19;
                fileOutputStream = null;
                bufferedOutputStream = null;
            } catch (Throwable th8) {
                th = th8;
                fileOutputStream = null;
                bufferedOutputStream = null;
            }
            in.b(fileOutputStream);
        }
    }

    public ax x(String str) {
        ax axVar;
        Map<String, ax> map = f388237i;
        synchronized (map) {
            axVar = map.get(str);
        }
        return axVar;
    }

    protected String y() {
        BufferedInputStream bufferedInputStream;
        FileInputStream fileInputStream;
        File file;
        try {
            file = new File(f388238j.getFilesDir(), D());
        } catch (Throwable th5) {
            th = th5;
            bufferedInputStream = null;
            fileInputStream = null;
        }
        if (file.isFile()) {
            fileInputStream = new FileInputStream(file);
            try {
                bufferedInputStream = new BufferedInputStream(fileInputStream);
                try {
                    String str = new String(fu.b(p(), in.g(bufferedInputStream)), StandardCharsets.UTF_8);
                    jz4.c.w("load host fallbacks = " + str);
                    return str;
                } catch (Throwable th6) {
                    th = th6;
                    try {
                        jz4.c.m("load host exception " + th.getMessage());
                        return null;
                    } finally {
                        in.b(bufferedInputStream);
                        in.b(fileInputStream);
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                bufferedInputStream = null;
            }
        } else {
            in.b(null);
            in.b(null);
            return null;
        }
    }

    public void z() {
        String str;
        String B = B();
        try {
            File file = new File(f388238j.getFilesDir(), B);
            if (file.exists()) {
                boolean delete = file.delete();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Delete old host fallbacks file ");
                sb5.append(B);
                if (delete) {
                    str = " successful.";
                } else {
                    str = " failed.";
                }
                sb5.append(str);
                jz4.c.m(sb5.toString());
            } else {
                jz4.c.w("Old host fallbacks file " + B + " does not exist.");
            }
        } catch (Exception e16) {
            jz4.c.m("Delete old host fallbacks file " + B + " error: " + e16.getMessage());
        }
    }

    protected bb(Context context, ba baVar, d dVar, String str, String str2, String str3) {
        this.f388244a = new HashMap();
        this.f388247d = "0";
        this.f388248e = 0L;
        this.f388249f = 15L;
        this.f388250g = 0L;
        this.f388251h = "isp_prov_city_country_ip";
        this.f388246c = dVar;
        if (baVar == null) {
            this.f388245b = new a();
        } else {
            this.f388245b = baVar;
        }
        this.f388247d = str;
        f388241m = str2 == null ? context.getPackageName() : str2;
        f388242n = str3 == null ? E() : str3;
    }
}
