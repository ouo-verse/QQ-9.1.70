package com.tencent.qimei.av;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.qimei.aw.a;
import com.tencent.qimei.foundation.net.protocol.CMD;
import com.tencent.qimei.uin.U;
import com.tencent.qimei.webview.util.X5StateController;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class f implements Runnable, a.d, b {

    /* renamed from: l, reason: collision with root package name */
    public static final String f343155l = "f";

    /* renamed from: m, reason: collision with root package name */
    public static final Map<String, f> f343156m = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final String f343157a;

    /* renamed from: b, reason: collision with root package name */
    public int f343158b;

    /* renamed from: c, reason: collision with root package name */
    public int f343159c;

    /* renamed from: d, reason: collision with root package name */
    public int f343160d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f343161e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f343162f;

    /* renamed from: g, reason: collision with root package name */
    public Context f343163g;

    /* renamed from: h, reason: collision with root package name */
    public b f343164h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f343165i;

    /* renamed from: j, reason: collision with root package name */
    public volatile m f343166j;

    /* renamed from: k, reason: collision with root package name */
    public volatile p f343167k;

    public f(String str) {
        this.f343157a = str;
    }

    public static synchronized f a(String str) {
        f fVar;
        synchronized (f.class) {
            Map<String, f> map = f343156m;
            fVar = map.get(str);
            if (fVar == null) {
                fVar = new f(str);
                map.put(str, fVar);
            }
        }
        return fVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00b1  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        boolean z16;
        boolean z17;
        com.tencent.qimei.aw.a aVar = new com.tencent.qimei.aw.a(this.f343163g, this.f343157a, this);
        boolean z18 = true;
        if (new File(aVar.f343193d + "tun-cos-1258344701.html").exists()) {
            if (new File(aVar.f343193d + "tun-cos-1258344701.js").exists()) {
                z16 = true;
                if (z16) {
                    aVar.a(true);
                    aVar.b(true);
                } else if (a("lc_fe_tm", "")) {
                    boolean equals = com.tencent.qimei.ab.a.a(com.tencent.qimei.ab.c.a(aVar.f343193d, "tun-cos-1258344701.html")).equals(com.tencent.qimei.aa.f.b(aVar.f343192c).d("lc_fe_st_hm"));
                    boolean equals2 = com.tencent.qimei.ab.a.a(com.tencent.qimei.ab.c.a(aVar.f343193d, "tun-cos-1258344701.js")).equals(com.tencent.qimei.aa.f.b(aVar.f343192c).d("lc_fe_st_js"));
                    if (equals && equals2) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!z17) {
                        aVar.a(true);
                        aVar.b(true);
                    } else {
                        aVar.a(false);
                        aVar.b(false);
                    }
                } else {
                    z18 = false;
                }
                if (z18) {
                    a();
                    return;
                }
                return;
            }
        }
        z16 = false;
        if (z16) {
        }
        if (z18) {
        }
    }

    public final boolean a(String str, String str2) {
        return com.tencent.qimei.ab.d.a(com.tencent.qimei.aa.f.b(this.f343157a).c(str + str2), 24L);
    }

    public static void a(f fVar) {
        synchronized (fVar) {
            if (!fVar.f343165i) {
                com.tencent.qimei.t.a.a().a(fVar);
                fVar.f343165i = true;
            }
        }
    }

    public final void a() {
        boolean z16;
        this.f343164h.getClass();
        boolean z17 = false;
        Object a16 = com.tencent.qimei.f.a.a(null, "com.tencent.smtt.sdk.QbSdk", "isTbsCoreInited", new Class[0], new Object[0]);
        Object a17 = com.tencent.qimei.f.a.a(null, "com.tencent.smtt.sdk.QbSdk", "getTbsVersion", new Class[]{Context.class}, new Object[]{this.f343163g});
        if (a17 == null) {
            com.tencent.qimei.ad.c.a(f343155l, "Qbsdk not install", new Object[0]);
        } else {
            int intValue = ((Integer) a17).intValue();
            if (a16 != null) {
                z16 = ((Boolean) a16).booleanValue();
            } else {
                X5StateController.X5Controller controller = X5StateController.getInstance().getController();
                z16 = controller != null && controller.detectX5InitFinished();
            }
            if (!z16 || intValue == 0) {
                com.tencent.qimei.ad.c.a(f343155l, "x5 not ready,isInited: %b x5Version: %d", Boolean.valueOf(z16), a17);
            } else {
                z17 = true;
            }
        }
        if (z17) {
            if (this.f343158b != 0) {
                this.f343161e = true;
                f fVar = (f) this.f343164h;
                if (fVar.f343167k == null) {
                    fVar.f343167k = new p(fVar.f343163g);
                }
                p pVar = fVar.f343167k;
                pVar.getClass();
                new Handler(Looper.getMainLooper()).post(new o(pVar));
                pVar.f343189c.a();
                a(fVar.f343167k.f343189c.f343173c);
            }
        } else {
            int i3 = Build.VERSION.SDK_INT;
            if ((i3 < 26 || i3 > 28) && this.f343159c != 0) {
                this.f343162f = true;
                if (this.f343166j == null) {
                    this.f343166j = new m(this.f343163g);
                }
                m mVar = this.f343166j;
                mVar.getClass();
                new Handler(Looper.getMainLooper()).post(new l(mVar));
                mVar.f343184c.a();
                a(this.f343166j.f343184c.f343173c);
            }
        }
        com.tencent.qimei.t.a.a().a((this.f343161e ? this.f343158b : this.f343162f ? this.f343159c : 600) * 1000, this);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(i iVar) {
        boolean z16;
        String str;
        String str2;
        if (iVar == null) {
            return;
        }
        String str3 = iVar.f343175a;
        String str4 = iVar.f343176b;
        String str5 = iVar.f343177c;
        String str6 = iVar.f343178d;
        String str7 = iVar.f343179e;
        if (TextUtils.isEmpty(str5) || TextUtils.isEmpty(str6) || "null".equals(str5) || str5.length() != 32) {
            com.tencent.qimei.ad.c.a(f343155l, "%s hid is invalid, len = %d", str4, Integer.valueOf(str5.length()));
            return;
        }
        if (!a("h_s_t", str4)) {
            if (str5.equals(com.tencent.qimei.aa.f.b(this.f343157a).d("hi" + str4))) {
                z16 = false;
                if (z16) {
                    com.tencent.qimei.ad.c.b(f343155l, "%s hid same and in 24h", str4);
                    return;
                }
                com.tencent.qimei.aa.f.b(this.f343157a).a("hi" + str4, str5);
                com.tencent.qimei.aa.f.b(this.f343157a).a("h_s_t" + str4, System.currentTimeMillis());
                g gVar = g.f343169c;
                gVar.f343170a.put("5", str6);
                gVar.f343170a.put("6", str5);
                gVar.f343170a.put("7", str4);
                gVar.f343170a.put("8", str3);
                gVar.f343170a.put("9", str7);
                String str8 = this.f343157a;
                JSONObject jSONObject = new JSONObject();
                if (U.e()) {
                    str = "";
                    str2 = str;
                } else {
                    com.tencent.qimei.ae.a a16 = com.tencent.qimei.ae.a.a(str8);
                    str2 = a16.a();
                    str = a16.c();
                }
                String str9 = null;
                try {
                    jSONObject.put("1", str);
                    jSONObject.put("2", str2);
                    jSONObject.put("5", gVar.f343170a.get("5"));
                    jSONObject.put("6", gVar.f343170a.get("6"));
                    jSONObject.put("7", gVar.f343170a.get("7"));
                    jSONObject.put("8", gVar.f343170a.get("8"));
                    jSONObject.put("9", gVar.f343170a.get("9"));
                    str9 = jSONObject.toString();
                    com.tencent.qimei.ad.c.b(g.f343168b, "H5ID data assembly is complete,%s", str9);
                } catch (JSONException e16) {
                    com.tencent.qimei.ad.c.a(e16);
                }
                String str10 = str9 != null ? str9 : "";
                String str11 = this.f343157a;
                CMD cmd = CMD.H5_BIND;
                com.tencent.qimei.x.c cVar = new com.tencent.qimei.x.c(U.a(str11, cmd.b(), str10, cmd.a()));
                if (cVar.c()) {
                    com.tencent.qimei.ad.c.b(f343155l, "H5ID has been reported over,h5id = %s", str5);
                    return;
                } else {
                    com.tencent.qimei.ad.c.b(f343155l, "H5ID report error,errCode = %s", cVar.b());
                    return;
                }
            }
        }
        z16 = true;
        if (z16) {
        }
    }
}
