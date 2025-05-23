package com.tencent.luggage.wxa.fd;

import android.database.Cursor;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.luggage.wxa.hn.r0;
import com.tencent.luggage.wxa.hn.re;
import com.tencent.luggage.wxa.hn.se;
import com.tencent.luggage.wxa.hn.ue;
import com.tencent.luggage.wxa.tn.w0;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class k0 extends com.tencent.luggage.wxa.xn.c {

    /* renamed from: g, reason: collision with root package name */
    public final com.tencent.luggage.wxa.xn.b f125834g;

    public k0(com.tencent.luggage.wxa.xn.b bVar, String str, String[] strArr) {
        super(bVar, n0.V0, str, strArr);
        this.f125834g = bVar;
    }

    public long e() {
        if (com.tencent.luggage.wxa.tn.e.f141559a && Thread.currentThread() == Looper.getMainLooper().getThread()) {
            throw new RuntimeException("Can not do transaction in main thread!");
        }
        return this.f125834g.b(Thread.currentThread().getId());
    }

    public String f(String str) {
        n0 a16;
        if (w0.c(str) || (a16 = a(str, "username")) == null) {
            return null;
        }
        return a16.f138465d;
    }

    public static com.tencent.luggage.wxa.fn.c b(n0 n0Var) {
        return new com.tencent.luggage.wxa.fn.c(n0Var == null ? new byte[0] : w0.a(w0.d(n0Var.P)));
    }

    public int a(long j3) {
        return this.f125834g.a(j3);
    }

    public n0 b(String str, String... strArr) {
        n0 n0Var;
        if (w0.c(str) || !str.endsWith("@app")) {
            return null;
        }
        try {
            Cursor a16 = this.f125834g.a(d(), w0.a(strArr) ? null : strArr, String.format(Locale.US, "%s=?", "usernameHash"), new String[]{String.valueOf(str.hashCode())}, null, null, null, 2);
            if (a16 == null) {
                if (a16 != null) {
                    a16.close();
                }
                return null;
            }
            try {
                if (a16.moveToFirst()) {
                    n0Var = new n0();
                    n0Var.a(a16);
                    n0Var.f138465d = str;
                } else {
                    n0Var = null;
                }
                a16.close();
                return n0Var;
            } finally {
            }
        } catch (RuntimeException e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.WxaAttrStorage", e16, "queryWithUsername", new Object[0]);
            return null;
        }
    }

    public n0 a(String str, String... strArr) {
        n0 n0Var = null;
        if (w0.c(str)) {
            return null;
        }
        Cursor a16 = this.f125834g.a(d(), w0.a(strArr) ? null : strArr, String.format(Locale.US, "%s=?", "appId"), new String[]{str}, null, null, null, 2);
        if (a16 == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.WxaAttrStorage", "queryWithAppId(%s) null==cursor", str);
            return null;
        }
        if (a16.moveToFirst()) {
            n0Var = new n0();
            n0Var.a(a16);
            n0Var.f138467f = str;
        } else {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.WxaAttrStorage", "queryWithAppId(%s) !cursor.moveToFirst()", str);
        }
        a16.close();
        return n0Var;
    }

    public boolean a(int i3, r0 r0Var) {
        return a(i3, r0Var, (List) null);
    }

    public boolean a(String str, se seVar) {
        if (TextUtils.isEmpty(str)) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.WxaAttrStorage", "updateAttrsByUsernameWithProto username EMPTY");
            return false;
        }
        return a(str, seVar.f128687e, seVar.f128688f);
    }

    public boolean b(String str, se seVar) {
        String f16 = f(str);
        if (TextUtils.isEmpty(f16)) {
            Iterator it = seVar.f128688f.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                re reVar = (re) it.next();
                if ("UserName".equalsIgnoreCase(reVar.f128625d)) {
                    f16 = reVar.f128626e;
                    break;
                }
            }
            if (TextUtils.isEmpty(f16)) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.WxaAttrStorage", "updateAttrsWithProto appId=%s, username EMPTY", str);
                return false;
            }
        }
        return a(f16, seVar.f128687e, seVar.f128688f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0063, code lost:
    
        if (r8 != (-1)) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0081, code lost:
    
        if (r4.size() <= 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0083, code lost:
    
        if (r19 == null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0085, code lost:
    
        r19.addAll(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0088, code lost:
    
        a("batch", 3, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008f, code lost:
    
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(int i3, r0 r0Var, List list) {
        boolean z16;
        long e16 = r0Var.f128550e.size() <= 1 ? -1L : e();
        LinkedList linkedList = new LinkedList();
        try {
            try {
                Iterator it = r0Var.f128550e.iterator();
                z16 = false;
                while (it.hasNext()) {
                    try {
                        ue ueVar = (ue) it.next();
                        com.tencent.luggage.wxa.tn.w.d("MicroMsg.WxaAttrStorage", "batchSyncInGroup, scene(%d), flushAttrs(%s)", Integer.valueOf(i3), ueVar.f128842d);
                        z16 |= a(ueVar.f128842d, ueVar.f128843e, ueVar.f128844f, false);
                        if (z16 && !TextUtils.isEmpty(ueVar.f128842d)) {
                            linkedList.add(ueVar.f128842d);
                        }
                    } catch (Exception e17) {
                        e = e17;
                        com.tencent.luggage.wxa.tn.w.b("MicroMsg.WxaAttrStorage", "batchUpdateWithProto fail: %s", e);
                    }
                }
            } finally {
                if (e16 != -1) {
                    a(e16);
                }
            }
        } catch (Exception e18) {
            e = e18;
            z16 = false;
        }
    }

    @Override // com.tencent.luggage.wxa.xn.c
    public final boolean b(n0 n0Var, boolean z16, String... strArr) {
        if (!w0.a(strArr)) {
            int i3 = 0;
            while (true) {
                if (i3 >= strArr.length) {
                    break;
                }
                if (strArr[i3].equals("username")) {
                    strArr[i3] = "usernameHash";
                    n0Var.f138463b = n0Var.f138465d.hashCode();
                    break;
                }
                i3++;
            }
        }
        boolean b16 = super.b((com.tencent.luggage.wxa.xn.a) n0Var, false, strArr);
        if (b16 && z16 && !TextUtils.isEmpty(n0Var.f138465d)) {
            a("single", 3, n0Var.f138465d);
        }
        return b16;
    }

    public final boolean a(String str, com.tencent.luggage.wxa.fn.c cVar, List list) {
        return a(str, cVar, list, true);
    }

    public boolean a(String str, com.tencent.luggage.wxa.fn.c cVar, List list, boolean z16) {
        if (w0.a(list)) {
            return false;
        }
        if (!z16) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.WxaAttrStorage", "flushAttrs username:%s, list.size:%d", str, Integer.valueOf(list.size()));
        }
        n0 n0Var = new n0();
        n0Var.f138465d = str;
        boolean z17 = !a(n0Var, "username");
        if (!z16) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.WxaAttrStorage", "flushAttrs username:%s, list.size:%d, doInsert:%b", str, Integer.valueOf(list.size()), Boolean.valueOf(z17));
        }
        Iterator it = list.iterator();
        boolean z18 = false;
        while (it.hasNext()) {
            re reVar = (re) it.next();
            if (reVar != null) {
                z18 |= a(n0Var, reVar);
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.WxaAttrStorage", "flushAttrs username:%s, list.size:%d, doInsert:%b, applyFieldChange(%s):%b", str, Integer.valueOf(list.size()), Boolean.valueOf(z17), reVar.f128625d, Boolean.valueOf(z18));
            }
        }
        n0Var.N = w0.d();
        n0Var.P = w0.a(cVar == null ? new byte[0] : cVar.a());
        if (!z16) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.WxaAttrStorage", "flushAttrs username:%s, list.size:%d, doInsert:%b, apply:%b", str, Integer.valueOf(list.size()), Boolean.valueOf(z17), Boolean.valueOf(z18));
        }
        if (!z18) {
            b(n0Var, false, "username");
        } else if (z17) {
            a(n0Var, z16);
        } else {
            b(n0Var, z16, "username");
        }
        if (!z16) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.WxaAttrStorage", "flushAttrs username:%s, list.size:%d, doInsert:%b, apply:%b, complete", str, Integer.valueOf(list.size()), Boolean.valueOf(z17), Boolean.valueOf(z18));
        }
        return z18;
    }

    public boolean a(n0 n0Var, re reVar) {
        int a16;
        if ("NickName".equals(reVar.f128625d) && !a(reVar.f128626e, n0Var.f138469h)) {
            n0Var.f138469h = w0.d(reVar.f128626e);
            return true;
        }
        if ("BrandIconURL".equals(reVar.f128625d) && !a(reVar.f128626e, n0Var.f138473l)) {
            n0Var.f138473l = reVar.f128626e;
            return true;
        }
        if ("BigHeadImgUrl".equals(reVar.f128625d) && !a(reVar.f128626e, n0Var.f138477p)) {
            n0Var.f138477p = reVar.f128626e;
            return true;
        }
        if ("SmallHeadImgUrl".equals(reVar.f128625d) && !a(reVar.f128626e, n0Var.f138479r)) {
            n0Var.f138479r = reVar.f128626e;
            return true;
        }
        if ("Signature".equals(reVar.f128625d) && !a(reVar.f128626e, n0Var.f138481t)) {
            n0Var.f138481t = reVar.f128626e;
            return true;
        }
        if ("WxAppOpt".equals(reVar.f128625d) && (a16 = w0.a(reVar.f128626e, 0)) != n0Var.f138483v) {
            n0Var.f138483v = a16;
            return true;
        }
        if ("RegisterSource".equals(reVar.f128625d) && !a(reVar.f128626e, n0Var.f138485x)) {
            n0Var.f138485x = reVar.f128626e;
            return true;
        }
        if ("WxaAppInfo".equals(reVar.f128625d) && !a(reVar.f128626e, n0Var.f138487z)) {
            n0Var.f138487z = reVar.f128626e;
            try {
                JSONObject jSONObject = new JSONObject(reVar.f128626e);
                n0Var.f138467f = jSONObject.getString("Appid");
                n0Var.f138475n = jSONObject.getString("RoundedSquareIconUrl");
                n0Var.f138471j = jSONObject.optString("ShortNickName");
            } catch (Exception unused) {
            }
            return true;
        }
        if ("WxaAppVersionInfo".equalsIgnoreCase(reVar.f128625d) && !a(reVar.f128626e, n0Var.B)) {
            n0Var.B = reVar.f128626e;
            return true;
        }
        if ("BindWxaInfo".equals(reVar.f128625d) && !a(reVar.f128626e, n0Var.H)) {
            n0Var.H = reVar.f128626e;
            return true;
        }
        if ("WxaAppDynamic".equals(reVar.f128625d) && !a(reVar.f128626e, n0Var.J)) {
            n0Var.J = reVar.f128626e;
            return true;
        }
        if ("MMBizMenu".equals(reVar.f128625d) && !a(reVar.f128626e, n0Var.R)) {
            n0Var.R = reVar.f128626e;
            return true;
        }
        if ("PassThroughInfo".equals(reVar.f128625d) && !a(reVar.f128626e, n0Var.D)) {
            n0Var.D = reVar.f128626e;
            return true;
        }
        if (!"StablePassThroughInfo".equals(reVar.f128625d) || a(reVar.f128626e, n0Var.F)) {
            return false;
        }
        n0Var.F = reVar.f128626e;
        return true;
    }

    public static boolean a(String str, String str2) {
        return w0.d(str).equals(w0.d(str2));
    }

    public boolean a(n0 n0Var, String... strArr) {
        if (!w0.a(strArr)) {
            int i3 = 0;
            while (true) {
                if (i3 >= strArr.length) {
                    break;
                }
                if (strArr[i3].equals("username")) {
                    strArr[i3] = "usernameHash";
                    n0Var.f138463b = n0Var.f138465d.hashCode();
                    break;
                }
                i3++;
            }
        }
        return super.b(n0Var, strArr);
    }

    @Override // com.tencent.luggage.wxa.xn.c
    public final boolean a(n0 n0Var, boolean z16) {
        n0Var.f138463b = n0Var.f138465d.hashCode();
        super.a((com.tencent.luggage.wxa.xn.a) n0Var, false);
        boolean z17 = b(n0Var.f138465d, "appId") != null;
        if (z17 && z16 && !TextUtils.isEmpty(n0Var.f138465d)) {
            a("single", 2, n0Var.f138465d);
            a("single", 3, n0Var.f138465d);
        }
        return z17;
    }

    @Override // com.tencent.luggage.wxa.xn.c
    public boolean a(n0 n0Var, boolean z16, String... strArr) {
        if (!w0.c(n0Var.f138465d)) {
            n0Var.f138463b = n0Var.f138465d.hashCode();
        }
        boolean a16 = super.a((com.tencent.luggage.wxa.xn.a) n0Var, false, strArr);
        if (a16 && z16 && !TextUtils.isEmpty(n0Var.f138465d)) {
            a("single", 5, n0Var.f138465d);
        }
        return a16;
    }

    @Override // com.tencent.luggage.wxa.xn.d
    public void a(String str, int i3, Object obj) {
        super.a(str, i3, obj);
        new l0(str, i3, obj).c();
    }
}
