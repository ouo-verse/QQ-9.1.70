package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import android.util.Pair;
import com.tencent.ads.data.AdParam;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ar implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    int f98087a;

    /* renamed from: b, reason: collision with root package name */
    int f98088b;

    /* renamed from: c, reason: collision with root package name */
    final int f98089c;

    /* renamed from: d, reason: collision with root package name */
    final byte[] f98090d;

    /* renamed from: e, reason: collision with root package name */
    final ak f98091e;

    /* renamed from: f, reason: collision with root package name */
    final an f98092f;

    /* renamed from: g, reason: collision with root package name */
    String f98093g;

    /* renamed from: h, reason: collision with root package name */
    final String f98094h;

    /* renamed from: i, reason: collision with root package name */
    protected int f98095i;

    /* renamed from: j, reason: collision with root package name */
    protected long f98096j;

    /* renamed from: k, reason: collision with root package name */
    protected long f98097k;

    /* renamed from: l, reason: collision with root package name */
    private final Context f98098l;

    /* renamed from: m, reason: collision with root package name */
    private final ai f98099m;

    /* renamed from: n, reason: collision with root package name */
    private final aq f98100n;

    /* renamed from: o, reason: collision with root package name */
    private final int f98101o;

    /* renamed from: p, reason: collision with root package name */
    private final ap f98102p;

    /* renamed from: q, reason: collision with root package name */
    private final ap f98103q;

    /* renamed from: r, reason: collision with root package name */
    private final Map<String, String> f98104r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f98105s;

    public ar(Context context, int i3, int i16, byte[] bArr, String str, String str2, ap apVar, boolean z16) {
        this(context, i3, i16, bArr, str, str2, apVar, 2, 30000, z16);
    }

    private Pair<Boolean, Boolean> b(byte[] bArr, Map<String, String> map) {
        if (bArr == null) {
            a("Failed to upload for no response!");
            return new Pair<>(Boolean.FALSE, Boolean.TRUE);
        }
        av.c("[Upload] Received %d bytes", Integer.valueOf(bArr.length));
        if (bArr.length == 0) {
            a(null, false, 1, "response data from server is empty");
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    av.c("[Upload] HTTP headers from server: key = %s, value = %s", entry.getKey(), entry.getValue());
                }
            }
            Boolean bool = Boolean.FALSE;
            return new Pair<>(bool, bool);
        }
        Boolean bool2 = Boolean.TRUE;
        return new Pair<>(bool2, bool2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        if (ai.c().f97995ad) {
            return;
        }
        this.f98100n.a(this.f98101o, System.currentTimeMillis());
        ap apVar = this.f98102p;
        if (apVar != null) {
            apVar.a(this.f98089c);
        }
        ap apVar2 = this.f98103q;
        if (apVar2 != null) {
            apVar2.a(this.f98089c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String c() {
        ak akVar;
        if (aj.b(this.f98098l) == null) {
            return "network is not available";
        }
        byte[] bArr = this.f98090d;
        if (bArr != null && bArr.length != 0) {
            if (this.f98098l != null && this.f98099m != null && (akVar = this.f98091e) != null && this.f98092f != null) {
                if (akVar.c() == null) {
                    return "illegal local strategy";
                }
                return null;
            }
            return "illegal access error";
        }
        return "request package is empty!";
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f98095i = 0;
            this.f98096j = 0L;
            this.f98097k = 0L;
            String c16 = c();
            if (c16 != null) {
                a(null, false, 0, c16);
                return;
            }
            byte[] a16 = ba.a(this.f98090d);
            if (a16 == null) {
                a(null, false, 0, "failed to zip request body");
                return;
            }
            Map<String, String> b16 = b();
            a();
            String str = this.f98093g;
            this.f98091e.c();
            int i3 = 0;
            int i16 = 0;
            while (true) {
                int i17 = i3 + 1;
                if (i3 < this.f98087a) {
                    i16 = 1;
                    if (i17 > 1) {
                        av.d("[Upload] Failed to upload last time, wait and try(%d) again.", Integer.valueOf(i17));
                        ba.b(this.f98088b);
                        if (i17 == this.f98087a) {
                            av.d("[Upload] Use the back-up url at the last time: %s", this.f98094h);
                            str = this.f98094h;
                        }
                    }
                    av.c("[Upload] Send %d bytes", Integer.valueOf(a16.length));
                    str = b(str);
                    av.c("[Upload] Upload to %s with cmd %d (pid=%d | tid=%d).", str, Integer.valueOf(this.f98089c), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                    if (a(this.f98092f.a(str, a16, this, b16), this.f98092f.f98054c)) {
                        i3 = i17;
                    } else {
                        return;
                    }
                } else {
                    a(null, false, i16, "failed after many attempts");
                    return;
                }
            }
        } catch (Throwable th5) {
            if (!av.a(th5)) {
                th5.printStackTrace();
            }
        }
    }

    public ar(Context context, int i3, int i16, byte[] bArr, String str, String str2, ap apVar, int i17, int i18, boolean z16) {
        this.f98087a = 2;
        this.f98088b = 30000;
        this.f98093g = null;
        this.f98095i = 0;
        this.f98096j = 0L;
        this.f98097k = 0L;
        this.f98105s = false;
        this.f98098l = context;
        this.f98099m = ai.a(context);
        this.f98090d = bArr;
        this.f98091e = ak.a();
        if (an.f98052a == null) {
            an.f98052a = new an(context);
        }
        this.f98092f = an.f98052a;
        aq a16 = aq.a();
        this.f98100n = a16;
        this.f98101o = i3;
        this.f98093g = str;
        this.f98094h = str2;
        this.f98102p = apVar;
        this.f98103q = a16.f98072b;
        this.f98089c = i16;
        if (i17 > 0) {
            this.f98087a = i17;
        }
        if (i18 > 0) {
            this.f98088b = i18;
        }
        this.f98105s = z16;
        this.f98104r = null;
    }

    private static void a(String str) {
        av.e("[Upload] Failed to upload(%d): %s", 1, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(ck ckVar, boolean z16, int i3, String str) {
        String str2;
        int i16 = this.f98089c;
        if (i16 != 630) {
            if (i16 != 640) {
                if (i16 != 830) {
                    if (i16 != 840) {
                        str2 = String.valueOf(i16);
                        if (z16) {
                            av.a("[Upload] Success: %s", str2);
                        } else {
                            av.e("[Upload] Failed to upload(%d) %s: %s", Integer.valueOf(i3), str2, str);
                        }
                        if (ai.c().f97995ad) {
                            return;
                        }
                        if (this.f98096j + this.f98097k > 0) {
                            this.f98100n.a(this.f98100n.a(this.f98105s) + this.f98096j + this.f98097k, this.f98105s);
                        }
                        ap apVar = this.f98102p;
                        if (apVar != null) {
                            apVar.a(this.f98089c, ckVar, this.f98096j, this.f98097k, z16, str, "userinfo", System.currentTimeMillis());
                        }
                        ap apVar2 = this.f98103q;
                        if (apVar2 != null) {
                            apVar2.a(this.f98089c, ckVar, this.f98096j, this.f98097k, z16, str, "userinfo", System.currentTimeMillis());
                            return;
                        }
                        return;
                    }
                }
            }
            str2 = "userinfo";
            if (z16) {
            }
            if (ai.c().f97995ad) {
            }
        }
        str2 = "crash";
        if (z16) {
        }
        if (ai.c().f97995ad) {
        }
    }

    public final void b(long j3) {
        this.f98097k += j3;
    }

    private static String b(String str) {
        if (ba.b(str)) {
            return str;
        }
        try {
            return String.format("%s?aid=%s", str, UUID.randomUUID().toString());
        } catch (Throwable th5) {
            av.a(th5);
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<String, String> b() {
        HashMap hashMap = new HashMap(10);
        hashMap.put("tls", "1");
        hashMap.put("prodId", this.f98099m.f());
        hashMap.put("bundleId", this.f98099m.f98015c);
        hashMap.put(AdParam.APPVER, this.f98099m.f98032t);
        Map<String, String> map = this.f98104r;
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put("cmd", Integer.toString(this.f98089c));
        hashMap.put(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, Byte.toString((byte) 1));
        hashMap.put("sdkVer", this.f98099m.f98020h);
        hashMap.put("strategylastUpdateTime", Long.toString(this.f98091e.c().f97850o));
        return hashMap;
    }

    private static boolean a(ck ckVar, ai aiVar, ak akVar) {
        if (ckVar == null) {
            av.d("resp == null!", new Object[0]);
            return false;
        }
        byte b16 = ckVar.f98453a;
        if (b16 != 0) {
            av.e("resp result error %d", Byte.valueOf(b16));
            return false;
        }
        try {
            if (!ba.b(ckVar.f98459g) && !ai.c().j().equals(ckVar.f98459g)) {
                ae.a().a(ak.f98042a, "device", ckVar.f98459g.getBytes("UTF-8"), true);
                aiVar.e(ckVar.f98459g);
            }
        } catch (Throwable th5) {
            av.a(th5);
        }
        aiVar.f98026n = ckVar.f98457e;
        int i3 = ckVar.f98454b;
        if (i3 == 510) {
            byte[] bArr = ckVar.f98455c;
            if (bArr == null) {
                av.e("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(i3));
                return false;
            }
            cm cmVar = (cm) am.a(bArr, cm.class);
            if (cmVar == null) {
                av.e("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(ckVar.f98454b));
                return false;
            }
            akVar.a(cmVar);
        }
        return true;
    }

    private Pair<Boolean, Boolean> a(byte[] bArr) {
        byte[] b16 = ba.b(bArr);
        if (b16 != null) {
            bArr = b16;
        }
        ck a16 = am.a(bArr);
        if (a16 == null) {
            a(null, false, 1, "failed to decode response package");
            Boolean bool = Boolean.FALSE;
            return new Pair<>(bool, bool);
        }
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(a16.f98454b);
        byte[] bArr2 = a16.f98455c;
        objArr[1] = Integer.valueOf(bArr2 == null ? 0 : bArr2.length);
        av.c("[Upload] Response cmd is: %d, length of sBuffer is: %d", objArr);
        if (!a(a16, this.f98099m, this.f98091e)) {
            a(a16, false, 2, "failed to process response package");
            Boolean bool2 = Boolean.FALSE;
            return new Pair<>(bool2, bool2);
        }
        a(a16, true, 2, "successfully uploaded");
        Boolean bool3 = Boolean.TRUE;
        return new Pair<>(bool3, bool3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(byte[] bArr, Map<String, String> map) {
        Pair<Boolean, Boolean> b16 = b(bArr, map);
        if (!((Boolean) b16.first).booleanValue()) {
            return ((Boolean) b16.second).booleanValue();
        }
        Pair<Boolean, Boolean> a16 = a(map);
        if (!((Boolean) a16.first).booleanValue()) {
            return ((Boolean) a16.second).booleanValue();
        }
        Pair<Boolean, Boolean> a17 = a(bArr);
        if (((Boolean) a17.first).booleanValue()) {
            return false;
        }
        return ((Boolean) a17.second).booleanValue();
    }

    public final void a(long j3) {
        this.f98095i++;
        this.f98096j += j3;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Pair<Boolean, Boolean> a(Map<String, String> map) {
        boolean z16;
        int i3;
        if (map != null && map.size() != 0) {
            if (!map.containsKey("status")) {
                av.d("[Upload] Headers does not contain %s", "status");
            } else if (!map.containsKey("Bugly-Version")) {
                av.d("[Upload] Headers does not contain %s", "Bugly-Version");
            } else {
                String str = map.get("Bugly-Version");
                if (!str.contains("bugly")) {
                    av.d("[Upload] Bugly version is not valid: %s", str);
                } else {
                    av.c("[Upload] Bugly version from headers is: %s", str);
                    z16 = true;
                    if (z16) {
                        av.c("[Upload] Headers from server is not valid, just try again (pid=%d | tid=%d).", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                        a("[Upload] Failed to upload for no status header.");
                        if (map != null) {
                            for (Map.Entry<String, String> entry : map.entrySet()) {
                                av.c(String.format("[key]: %s, [value]: %s", entry.getKey(), entry.getValue()), new Object[0]);
                            }
                        }
                        av.c("[Upload] Failed to upload for no status header.", new Object[0]);
                        return new Pair<>(Boolean.FALSE, Boolean.TRUE);
                    }
                    try {
                        i3 = Integer.parseInt(map.get("status"));
                        try {
                            av.c("[Upload] Status from server is %d (pid=%d | tid=%d).", Integer.valueOf(i3), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                            if (i3 != 0) {
                                a(null, false, 1, "status of server is ".concat(String.valueOf(i3)));
                                Boolean bool = Boolean.FALSE;
                                return new Pair<>(bool, bool);
                            }
                            Boolean bool2 = Boolean.TRUE;
                            return new Pair<>(bool2, bool2);
                        } catch (Throwable unused) {
                            a("[Upload] Failed to upload for format of status header is invalid: " + Integer.toString(i3));
                            return new Pair<>(Boolean.FALSE, Boolean.TRUE);
                        }
                    } catch (Throwable unused2) {
                        i3 = -1;
                    }
                }
            }
        } else {
            av.d("[Upload] Headers is empty.", new Object[0]);
        }
        z16 = false;
        if (z16) {
        }
    }
}
