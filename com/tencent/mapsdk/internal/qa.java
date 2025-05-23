package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.annotation.RequiresApi;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.ac;
import com.tencent.mapsdk.internal.gn;
import com.tencent.mapsdk.internal.gu;
import com.tencent.mapsdk.internal.lb;
import com.tencent.mapsdk.internal.qb;
import com.tencent.mapsdk.internal.qc;
import com.tencent.mapsdk.internal.qf;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class qa implements qb.c, qc.a {

    /* renamed from: c, reason: collision with root package name */
    public static final String f149734c = "AUTH_MARKER";

    /* renamed from: a, reason: collision with root package name */
    public final bm f149735a;

    /* renamed from: b, reason: collision with root package name */
    public List<AsyncTask> f149736b;

    /* renamed from: d, reason: collision with root package name */
    public final tr f149737d;

    /* renamed from: e, reason: collision with root package name */
    private final sp f149738e;

    /* renamed from: f, reason: collision with root package name */
    private final rr f149739f;

    /* renamed from: g, reason: collision with root package name */
    private final qh f149740g;

    /* renamed from: h, reason: collision with root package name */
    private final qu f149741h;

    /* renamed from: i, reason: collision with root package name */
    private final ne f149742i;

    /* renamed from: j, reason: collision with root package name */
    private final qf f149743j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f149744k;

    /* renamed from: l, reason: collision with root package name */
    private WeakReference<TencentMap.OnAuthResultCallback> f149745l;

    /* renamed from: m, reason: collision with root package name */
    private final Map<b, Boolean> f149746m = new ConcurrentHashMap();

    /* renamed from: n, reason: collision with root package name */
    private final b f149747n;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        void a(Bitmap bitmap, int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface b {
        void a(int i3, String str);

        void a(qb.b bVar);
    }

    public qa(bi biVar) {
        String str;
        String str2;
        b bVar = new b() { // from class: com.tencent.mapsdk.internal.qa.1
            @Override // com.tencent.mapsdk.internal.qa.b
            public final void a(qb.b bVar2) {
            }

            @Override // com.tencent.mapsdk.internal.qa.b
            public final void a(int i3, String str3) {
                ne neVar;
                tr trVar = qa.this.f149737d;
                if (trVar == null || (neVar = trVar.aC) == null) {
                    return;
                }
                gu s16 = neVar.f147918e.s();
                String str4 = i3 + str3;
                gu.a aVar = s16.f148594a.get(str4);
                if (aVar == null) {
                    aVar = new gu.a();
                    s16.f148594a.put(str4, aVar);
                }
                aVar.f148598b = i3;
                aVar.f148599c = str3;
                aVar.f148597a++;
                go goVar = neVar.f147919f;
                gn.a.EnumC7040a enumC7040a = gn.a.EnumC7040a.AUTH;
                gn.b bVar2 = new gn.b(goVar.f148528a);
                bVar2.f148515a = new gn.a(enumC7040a, i3, str3, 1);
                goVar.f148529b.a(bVar2);
            }
        };
        this.f149747n = bVar;
        Context context = biVar.f147820c;
        this.f149737d = biVar.f147819b;
        this.f149738e = biVar.f147819b.f151054k;
        bm bmVar = biVar.f147821d;
        this.f149735a = bmVar;
        this.f149739f = biVar.f147822e;
        this.f149740g = biVar.f147823f;
        this.f149741h = biVar.f147824g;
        this.f149742i = biVar.f147819b.aC;
        this.f149736b = new CopyOnWriteArrayList();
        if (biVar.f147819b != null && biVar.f147819b.L() != null) {
            String subKey = biVar.f147819b.L().getSubKey();
            String subId = biVar.f147819b.L().getSubId();
            this.f149745l = new WeakReference<>(biVar.f147819b.L().getOnAuthCallback());
            str = subKey;
            str2 = subId;
        } else {
            str = "";
            str2 = str;
        }
        this.f149743j = new qf(context, biVar, str);
        this.f149736b.add(new qb(bmVar.f147900i, str, str2, this, this.f149736b));
        this.f149736b.add(new qc(biVar, this));
        a(bVar);
    }

    private void d() {
        ne neVar;
        lc.a(lb.Y, b());
        Iterator<AsyncTask> it = this.f149736b.iterator();
        while (it.hasNext()) {
            it.next().execute(new Object[0]);
        }
        tr trVar = this.f149737d;
        if (trVar != null && (neVar = trVar.aC) != null) {
            neVar.f147918e.s().a();
        }
    }

    public final void b(b bVar) {
        this.f149746m.remove(bVar);
    }

    @Override // com.tencent.mapsdk.internal.qb.c
    public final void c() {
        ne neVar;
        tr trVar = this.f149737d;
        if (trVar != null && (neVar = trVar.aC) != null) {
            neVar.f147918e.s().a();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnAuthResultCallback
    public final void onAuthFail(int i3, String str) {
        WeakReference<TencentMap.OnAuthResultCallback> weakReference = this.f149745l;
        if (weakReference != null && weakReference.get() != null) {
            this.f149745l.get().onAuthFail(i3, str);
        }
        Iterator<b> it = this.f149746m.keySet().iterator();
        while (it.hasNext()) {
            it.next().a(i3, str);
        }
        int i16 = 0;
        for (int i17 = 0; i17 < this.f149736b.size(); i17++) {
            if (this.f149736b.get(i17) instanceof qb) {
                i16++;
            }
        }
        LogUtil.a(b()).e(lb.a.f149157d, "retry count: " + i16 + ", code: " + i3 + ", message: " + str);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnAuthResultCallback
    public final void onAuthSuccess() {
        WeakReference<TencentMap.OnAuthResultCallback> weakReference = this.f149745l;
        if (weakReference != null && weakReference.get() != null) {
            this.f149745l.get().onAuthSuccess();
        }
        LogUtil.a(b()).c(lb.a.f149157d, "onAuthSuccess");
    }

    private void a(a aVar, TencentMapOptions tencentMapOptions) {
        this.f149735a.a(aVar, tencentMapOptions);
    }

    public final int b() {
        ne neVar = this.f149742i;
        if (neVar != null) {
            return neVar.N;
        }
        return -1;
    }

    public final void a(b bVar) {
        this.f149746m.put(bVar, Boolean.TRUE);
    }

    private void a(qb.b bVar) {
        Iterator<b> it = this.f149746m.keySet().iterator();
        while (it.hasNext()) {
            it.next().a(bVar);
        }
    }

    private void a(int i3, String str) {
        Iterator<b> it = this.f149746m.keySet().iterator();
        while (it.hasNext()) {
            it.next().a(i3, str);
        }
    }

    private void a(JSONArray jSONArray, fz fzVar) {
        List<rq> a16;
        rr rrVar = this.f149739f;
        if (rrVar == null) {
            return;
        }
        String a17 = rrVar.f150125e.a(et.A);
        if (jSONArray != null && (a16 = rr.a(jSONArray)) != null) {
            synchronized (rrVar.f150124d) {
                rrVar.f150123c.clear();
                rrVar.f150123c.addAll(a16);
            }
            if (!jSONArray.toString().equals(a17)) {
                rrVar.f150125e.a();
                rrVar.f150125e.a(et.A, jSONArray.toString());
            }
        }
        ac acVar = this.f149737d.f151058o;
        if (acVar != null) {
            if (fzVar != null) {
                acVar.f147689b = fzVar;
                LogUtil.b(ky.f149101g, "IndoorAuth:".concat(String.valueOf(fzVar)));
                acVar.f147688a.a(et.B, fzVar.f148412c);
                acVar.f147688a.a(et.C, fzVar.f148413d);
                JSONArray jSONArray2 = fzVar.f148414e;
                if (jSONArray2 != null) {
                    acVar.f147688a.a(et.D, jSONArray2.toString());
                }
                VectorMap vectorMap = acVar.f147691d;
                if (vectorMap != null) {
                    vectorMap.a(acVar.a());
                    if (acVar.a() == 1) {
                        acVar.f147691d.a(acVar.b());
                    }
                }
            } else {
                acVar.f147688a.a(new String[]{et.B, et.C, et.D});
            }
            if (acVar.f147689b == null) {
                acVar.f147689b = new fz();
            }
            kp.a(new ac.AnonymousClass2());
        }
        qf qfVar = this.f149743j;
        String a18 = this.f149739f.a();
        String a19 = qfVar.a();
        if (qf.f149785e.containsKey(a19)) {
            qfVar.a(a19, qfVar.f149790f);
            return;
        }
        qfVar.a(a19, qfVar.f149790f);
        WeakReference<bi> weakReference = qfVar.f149790f;
        if (weakReference != null && weakReference.get() != null && qfVar.f149790f.get().f147819b != null) {
            int i3 = qfVar.f149790f.get().f147819b.f147934f;
            LogUtil.a(i3).b(lb.a.f149158e, "map config check update, styleIds: " + a18 + ", indoorAuth: " + fzVar);
            lc.a(lb.Z, i3);
        }
        kp.b(new qf.a(qfVar, a18, fzVar));
    }

    public final void a() {
        if (this.f149736b != null) {
            for (int i3 = 0; i3 < this.f149736b.size(); i3++) {
                AsyncTask asyncTask = this.f149736b.get(i3);
                if (asyncTask instanceof qb) {
                    ((qb) asyncTask).f149750b.removeCallbacksAndMessages(null);
                }
                asyncTask.cancel(true);
            }
            this.f149736b.clear();
        }
        b(this.f149747n);
        this.f149736b = null;
        this.f149744k = true;
        if (this.f149737d.L() != null) {
            this.f149737d.L().setOnAuthCallback(null);
        }
    }

    @Override // com.tencent.mapsdk.internal.qc.a
    public final void a(boolean z16, so soVar) {
        tr trVar = this.f149737d;
        if (trVar == null || soVar == null) {
            return;
        }
        trVar.a(z16, soVar.c());
        if (z16) {
            this.f149738e.a();
        }
        this.f149738e.f150371d = true;
    }

    @Override // com.tencent.mapsdk.internal.qb.c
    @RequiresApi(api = 21)
    public final void a(qb.b bVar, JSONObject jSONObject) {
        JSONArray jSONArray;
        fz fzVar;
        List<rq> a16;
        if (this.f149744k) {
            return;
        }
        LogUtil.a(b()).c(lb.a.f149157d, "onAuthResult: ".concat(String.valueOf(jSONObject)));
        if (ho.f148706i == 0) {
            Iterator<b> it = this.f149746m.keySet().iterator();
            while (it.hasNext()) {
                it.next().a(bVar);
            }
        }
        if (bVar != null) {
            jSONArray = bVar.f149766b;
            fzVar = bVar.f149765a;
            qg qgVar = bVar.f149768d;
            if (qgVar != null) {
                qh qhVar = this.f149740g;
                if (qgVar != null && qgVar.f149799a) {
                    qhVar.f149805b.clear();
                    qhVar.f149805b.addAll(qgVar.f149800b);
                    qhVar.a();
                }
            }
        } else {
            jSONArray = null;
            fzVar = null;
        }
        rr rrVar = this.f149739f;
        if (rrVar != null) {
            String a17 = rrVar.f150125e.a(et.A);
            if (jSONArray != null && (a16 = rr.a(jSONArray)) != null) {
                synchronized (rrVar.f150124d) {
                    rrVar.f150123c.clear();
                    rrVar.f150123c.addAll(a16);
                }
                if (!jSONArray.toString().equals(a17)) {
                    rrVar.f150125e.a();
                    rrVar.f150125e.a(et.A, jSONArray.toString());
                }
            }
            ac acVar = this.f149737d.f151058o;
            if (acVar != null) {
                if (fzVar != null) {
                    acVar.f147689b = fzVar;
                    LogUtil.b(ky.f149101g, "IndoorAuth:".concat(String.valueOf(fzVar)));
                    acVar.f147688a.a(et.B, fzVar.f148412c);
                    acVar.f147688a.a(et.C, fzVar.f148413d);
                    JSONArray jSONArray2 = fzVar.f148414e;
                    if (jSONArray2 != null) {
                        acVar.f147688a.a(et.D, jSONArray2.toString());
                    }
                    VectorMap vectorMap = acVar.f147691d;
                    if (vectorMap != null) {
                        vectorMap.a(acVar.a());
                        if (acVar.a() == 1) {
                            acVar.f147691d.a(acVar.b());
                        }
                    }
                } else {
                    acVar.f147688a.a(new String[]{et.B, et.C, et.D});
                }
                if (acVar.f147689b == null) {
                    acVar.f147689b = new fz();
                }
                kp.a(new ac.AnonymousClass2());
            }
            qf qfVar = this.f149743j;
            String a18 = this.f149739f.a();
            String a19 = qfVar.a();
            if (qf.f149785e.containsKey(a19)) {
                qfVar.a(a19, qfVar.f149790f);
            } else {
                qfVar.a(a19, qfVar.f149790f);
                WeakReference<bi> weakReference = qfVar.f149790f;
                if (weakReference != null && weakReference.get() != null && qfVar.f149790f.get().f147819b != null) {
                    int i3 = qfVar.f149790f.get().f147819b.f147934f;
                    LogUtil.a(i3).b(lb.a.f149158e, "map config check update, styleIds: " + a18 + ", indoorAuth: " + fzVar);
                    lc.a(lb.Z, i3);
                }
                kp.b(new qf.a(qfVar, a18, fzVar));
            }
        }
        ne neVar = this.f149742i;
        if (neVar != null && bVar != null) {
            int i16 = bVar.f149769e;
            if (i16 != sa.f150169d && i16 != sa.f150170e) {
                neVar.i(false);
            } else {
                neVar.i(true);
            }
            qu quVar = this.f149741h;
            boolean z16 = bVar.f149770f;
            if (qu.a()) {
                quVar.f149936b = z16;
                quVar.f149935a.a(et.E, z16);
                quVar.f149937c.g().c(quVar.f149936b);
            } else {
                quVar.f149937c.g().c(false);
            }
            eg egVar = (eg) this.f149742i.getMapComponent(eg.class);
            if (egVar != null) {
                egVar.a(bVar.f149767c);
            }
        }
        lc.c(lb.Y, b());
    }
}
