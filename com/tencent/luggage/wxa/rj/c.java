package com.tencent.luggage.wxa.rj;

import android.text.TextUtils;
import com.tencent.luggage.wxa.so.c;
import com.tencent.luggage.wxa.tj.b;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.yf.a0;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang.StringUtils;
import org.joor.Reflect;
import org.joor.ReflectException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c {

    /* renamed from: n, reason: collision with root package name */
    public static final Map f139778n = new ConcurrentHashMap();

    /* renamed from: o, reason: collision with root package name */
    public static final Map f139779o = new ConcurrentHashMap();

    /* renamed from: p, reason: collision with root package name */
    public static final String[] f139780p = {com.tencent.luggage.wxa.nf.f.NAME, com.tencent.luggage.wxa.of.b.NAME, com.tencent.luggage.wxa.pf.b.NAME, com.tencent.luggage.wxa.qf.b.NAME, com.tencent.luggage.wxa.qf.c.NAME, com.tencent.luggage.wxa.pf.c.NAME, com.tencent.luggage.wxa.qf.c.NAME};

    /* renamed from: a, reason: collision with root package name */
    public final o f139781a;

    /* renamed from: b, reason: collision with root package name */
    public final int f139782b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f139783c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedList f139784d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f139785e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.rj.b f139786f;

    /* renamed from: g, reason: collision with root package name */
    public final byte[] f139787g;

    /* renamed from: h, reason: collision with root package name */
    public HashMap f139788h;

    /* renamed from: i, reason: collision with root package name */
    public final Object f139789i;

    /* renamed from: j, reason: collision with root package name */
    public HashMap f139790j;

    /* renamed from: k, reason: collision with root package name */
    public final List f139791k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f139792l;

    /* renamed from: m, reason: collision with root package name */
    public final com.tencent.luggage.wxa.so.c f139793m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends HashMap {
        public a() {
            putAll(c.this.f139788h);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements b.j {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f139795a;

        public b(e eVar) {
            this.f139795a = eVar;
        }

        @Override // com.tencent.luggage.wxa.tj.b.j
        public /* synthetic */ void a(String str) {
            e41.a.a(this, str);
        }

        @Override // com.tencent.luggage.wxa.tj.b.j
        public void onCancel() {
            e eVar = this.f139795a;
            if (eVar != null) {
                eVar.a(d.f139799e);
            }
        }

        @Override // com.tencent.luggage.wxa.tj.b.j
        public void a() {
            e eVar = this.f139795a;
            if (eVar != null) {
                eVar.a(d.f139803i);
            }
        }

        @Override // com.tencent.luggage.wxa.tj.b.j
        public void a(int i3, String str) {
            if (this.f139795a != null) {
                if (TextUtils.isEmpty(str)) {
                    this.f139795a.a(new d(-1, "fail:auth denied", new com.tencent.luggage.wxa.af.c(i3)));
                    return;
                }
                this.f139795a.a(new d(-1, "fail " + str, new com.tencent.luggage.wxa.af.c(i3)));
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.rj.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C6688c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f139797a;

        static {
            int[] iArr = new int[com.tencent.luggage.wxa.qc.b.values().length];
            f139797a = iArr;
            try {
                iArr[com.tencent.luggage.wxa.qc.b.SUSPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f139797a[com.tencent.luggage.wxa.qc.b.DESTROYED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f139797a[com.tencent.luggage.wxa.qc.b.BACKGROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f139797a[com.tencent.luggage.wxa.qc.b.FOREGROUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d {

        /* renamed from: d, reason: collision with root package name */
        public static final com.tencent.luggage.wxa.af.c f139798d;

        /* renamed from: e, reason: collision with root package name */
        public static final d f139799e;

        /* renamed from: f, reason: collision with root package name */
        public static final d f139800f;

        /* renamed from: g, reason: collision with root package name */
        public static final d f139801g;

        /* renamed from: h, reason: collision with root package name */
        public static final d f139802h;

        /* renamed from: i, reason: collision with root package name */
        public static final d f139803i;

        /* renamed from: a, reason: collision with root package name */
        public final int f139804a;

        /* renamed from: b, reason: collision with root package name */
        public final String f139805b;

        /* renamed from: c, reason: collision with root package name */
        public final com.tencent.luggage.wxa.af.c f139806c;

        static {
            com.tencent.luggage.wxa.af.c cVar = new com.tencent.luggage.wxa.af.c(-1, "");
            f139798d = cVar;
            f139799e = new d(-1, "fail:auth canceled", com.tencent.luggage.wxa.af.e.f121318n);
            f139800f = new d(-1, "fail:auth denied", com.tencent.luggage.wxa.af.e.f121317m);
            f139801g = new d(-2, "", cVar);
            f139802h = new d(-1, "fail:access denied", com.tencent.luggage.wxa.af.e.f121316l);
            f139803i = new d(0, "", com.tencent.luggage.wxa.af.e.f121305a);
        }

        public d(int i3, String str, com.tencent.luggage.wxa.af.c cVar) {
            this.f139804a = i3;
            this.f139805b = str;
            this.f139806c = cVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface e {
        void a(int i3);

        void a(d dVar);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface f {
        void a(HashMap hashMap);

        void a(byte[] bArr, byte[] bArr2, byte[] bArr3);
    }

    public c(com.tencent.luggage.wxa.ic.g gVar, int i3, boolean z16) {
        this(new n(gVar), i3, z16);
    }

    public static int b(Object obj) {
        String a16 = a(obj);
        if (TextUtils.isEmpty(a16)) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlIndex invalid apiNAme, api:%s", obj.toString());
            return 6;
        }
        Map map = f139778n;
        Integer num = (Integer) map.get(a16);
        if (num != null) {
            return num.intValue();
        }
        int i3 = -1;
        try {
            if (obj instanceof Class) {
                i3 = ((Integer) Reflect.on((Class<?>) obj).get("CTRL_INDEX")).intValue();
            } else {
                i3 = ((Integer) Reflect.on(obj).get("CTRL_INDEX")).intValue();
            }
            map.put(a16, Integer.valueOf(i3));
        } catch (ReflectException e16) {
            String name = obj instanceof Class ? ((Class) obj).getName() : obj.toString();
            if (com.tencent.luggage.wxa.tn.e.f141559a) {
                com.tencent.luggage.wxa.er.a.a("Must declare CTRL_INDEX in JsApi Class: " + name);
            } else {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlIndex class:%s, reflect failed %s", name, e16);
            }
        }
        return i3;
    }

    public static /* synthetic */ j f() {
        j jVar = (j) com.tencent.luggage.wxa.eo.g.a(j.class);
        if (jVar == null) {
            return new l();
        }
        return jVar;
    }

    public void c() {
        LinkedList linkedList;
        synchronized (this.f139784d) {
            linkedList = new LinkedList(this.f139784d);
            this.f139784d.clear();
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((e) it.next()).a(d.f139803i);
        }
    }

    public final com.tencent.luggage.wxa.rj.b d() {
        com.tencent.luggage.wxa.rj.b bVar;
        synchronized (this.f139785e) {
            bVar = this.f139786f;
        }
        return bVar;
    }

    public final Map e() {
        synchronized (this.f139787g) {
            HashMap hashMap = this.f139788h;
            if (hashMap != null && !hashMap.isEmpty()) {
                return new a();
            }
            return null;
        }
    }

    public final void g() {
        if (this.f139788h == null) {
            return;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppRuntimeApiPermissionController[permission]", "notifyNodeOnPluginUpdate");
        for (int i3 = 0; i3 < this.f139791k.size(); i3++) {
            ((f) this.f139791k.get(i3)).a(this.f139788h);
        }
    }

    public final void h() {
        if (this.f139788h == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppRuntimeApiPermissionController[permission]", "pluginUpdateNotifyWxCommLib mPluginPermission null");
            return;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppRuntimeApiPermissionController[permission]", "pluginUpdateNotifyWxCommLib");
        HashMap hashMap = new HashMap();
        for (String str : this.f139788h.keySet()) {
            HashMap hashMap2 = new HashMap();
            com.tencent.luggage.wxa.rj.b bVar = (com.tencent.luggage.wxa.rj.b) this.f139788h.get(str);
            if (bVar != null) {
                hashMap2.put("fg", bVar.f139775a);
                hashMap2.put(VasProfileTemplatePreloadHelper.BACKGROUND, bVar.f139776b);
                hashMap2.put("sp", bVar.f139777c);
                hashMap.put(str, hashMap2);
            }
        }
        com.tencent.luggage.wxa.h6.f.a((Map) hashMap);
        this.f139781a.a("onPluginPermissionUpdate", new JSONObject(hashMap));
    }

    public c(o oVar, int i3, boolean z16) {
        this.f139784d = new LinkedList();
        this.f139790j = new HashMap();
        this.f139791k = new ArrayList();
        this.f139793m = com.tencent.luggage.wxa.so.c.a(new c.a() { // from class: com.tencent.luggage.wxa.rj.t
            @Override // com.tencent.luggage.wxa.so.c.a
            public final Object a() {
                return c.f();
            }
        });
        this.f139781a = oVar;
        this.f139785e = new byte[0];
        this.f139787g = new byte[0];
        this.f139789i = new byte[0];
        this.f139782b = i3;
        this.f139783c = z16;
        com.tencent.luggage.wxa.rj.b a16 = oVar.a();
        if (a16 == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppRuntimeApiPermissionController[permission]", "<init> get NULL permission from runtime");
        }
        b(a16);
        com.tencent.luggage.wxa.rj.d e16 = oVar.e();
        HashMap a17 = e16 == null ? null : e16.a();
        this.f139788h = a17;
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(a17 == null ? 0 : a17.size());
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppRuntimeApiPermissionController[permission]", "<init> mPluginPermission size:%d", objArr);
        HashMap hashMap = this.f139788h;
        if (hashMap != null && hashMap.size() > 0) {
            com.tencent.luggage.wxa.rc.q c16 = oVar.c();
            Objects.requireNonNull(c16);
            this.f139792l = Boolean.parseBoolean(c16.h("supportInvokeWithAppId"));
        } else {
            this.f139792l = false;
        }
        com.tencent.luggage.wxa.sj.b b16 = oVar.b();
        if (b16 != null) {
            HashMap a18 = b16.a();
            this.f139790j = a18;
            Object[] objArr2 = new Object[1];
            objArr2[0] = Integer.valueOf(a18 == null ? 0 : a18.size());
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppRuntimeApiPermissionController[permission]", "mAppidPermission size:%d", objArr2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0089, code lost:
    
        if (android.text.TextUtils.isEmpty(r11) != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a9, code lost:
    
        r11 = r18.getAppId();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a7, code lost:
    
        if (android.text.TextUtils.isEmpty(r11) == false) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int a(com.tencent.luggage.wxa.xd.d dVar, Object obj, String str, String str2, int i3, boolean z16) {
        int i16 = this.f139782b;
        String appId = dVar.getAppId();
        if (i16 == -1) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlByte, appId = %s, ctrlIndex = %d, hard code perm on", appId, Integer.valueOf(i3));
            return 1;
        }
        if (i16 == -2) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlByte, appId = %s, ctrlIndex = %d, hard code perm off", appId, Integer.valueOf(i3));
            return 0;
        }
        if (((obj instanceof a0) || ((obj instanceof Class) && ((Class) obj).isAssignableFrom(a0.class))) && (dVar instanceof com.tencent.luggage.wxa.kj.v)) {
            return 1;
        }
        String a16 = a(obj);
        int a17 = com.tencent.luggage.wxa.rj.a.a(dVar, a16, str);
        if (a17 != Integer.MIN_VALUE) {
            return a17;
        }
        String appId2 = dVar.getAppId();
        if (this.f139792l && !TextUtils.isEmpty(str2)) {
            try {
                try {
                    appId2 = new JSONObject(str2).optString("appId");
                } catch (Exception e16) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppRuntimeApiPermissionController[permission]", "getApiCtrlByte(appId:%s, api:%s, privateData:%s), parse invokeAppId failed %s", dVar.getAppId(), a16, str2, e16);
                }
            } catch (Throwable th5) {
                if (TextUtils.isEmpty(appId2)) {
                    dVar.getAppId();
                }
                throw th5;
            }
        }
        com.tencent.luggage.wxa.qc.b[] bVarArr = new com.tencent.luggage.wxa.qc.b[1];
        byte[] a18 = a(dVar, appId2, bVarArr);
        int a19 = com.tencent.luggage.wxa.qc.b.DESTROYED == bVarArr[0] ? 0 : a(a18, i3);
        if (z16) {
            k a26 = w.a();
            if (a26 == null || ((obj instanceof com.tencent.luggage.wxa.xd.c) && !a26.a((com.tencent.luggage.wxa.xd.c) obj)) || ((obj instanceof Class) && !a26.a((Class) obj))) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlByte, appId = %s, invokeAppId = %s, apiName = %s, state = %s, ctrlIndex = %d, ctrlIndexLength %d, checkRet %d", appId, appId2, a16, bVarArr[0], Integer.valueOf(i3), Integer.valueOf(a18.length), Integer.valueOf(a19));
            }
        }
        return a19;
    }

    public void b(com.tencent.luggage.wxa.rj.b bVar) {
        if (bVar == null) {
            return;
        }
        synchronized (this.f139785e) {
            com.tencent.luggage.wxa.rj.b bVar2 = this.f139786f;
            if (bVar2 != null && bVar2.f139775a.length > bVar.f139775a.length) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppRuntimeApiPermissionController[permission]", "updatePermission, old %s, new %s, ignore", bVar2, bVar);
                return;
            }
            this.f139786f = bVar;
            a(bVar);
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppRuntimeApiPermissionController[permission]", "updatePermission old %s, updated %s", bVar2, bVar);
        }
    }

    public void b(f fVar) {
        synchronized (this.f139785e) {
            this.f139791k.remove(fVar);
        }
    }

    public final void b() {
        synchronized (this.f139784d) {
            this.f139784d.clear();
        }
    }

    public byte[] a(com.tencent.luggage.wxa.xd.d dVar) {
        return a(dVar, dVar.getAppId(), null);
    }

    public final byte[] a(com.tencent.luggage.wxa.xd.d dVar, String str, com.tencent.luggage.wxa.qc.b[] bVarArr) {
        com.tencent.luggage.wxa.rj.b d16;
        byte[] bArr;
        int i3 = this.f139782b;
        if (i3 == -1) {
            return new byte[]{1};
        }
        if (i3 == -2) {
            return new byte[]{0};
        }
        if (!TextUtils.isEmpty(str) && !StringUtils.equals(dVar.getAppId(), str)) {
            d16 = a(str);
        } else {
            d16 = d();
        }
        if (d16 == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlBytes(appId:%s, invokeAppId:%s) get NULL bundle", dVar.getAppId(), str);
            return new byte[]{0};
        }
        if (dVar instanceof com.tencent.luggage.wxa.ic.l) {
            int[] iArr = C6688c.f139797a;
            com.tencent.luggage.wxa.qc.b d17 = this.f139781a.d();
            int i16 = iArr[d17.ordinal()];
            if (i16 != 1 && i16 != 2 && i16 != 3) {
                bArr = d16.f139775a;
            } else {
                bArr = d16.f139776b;
            }
            if (bVarArr == null || bVarArr.length < 1) {
                return bArr;
            }
            bVarArr[0] = d17;
            return bArr;
        }
        return d16.f139775a;
    }

    public final void b(com.tencent.luggage.wxa.xd.d dVar, String str) {
        ((j) this.f139793m.b()).b(dVar, str);
    }

    public byte[] a(com.tencent.luggage.wxa.xd.d dVar, String str) {
        com.tencent.luggage.wxa.rj.b a16;
        int i3 = this.f139782b;
        if (i3 == -1) {
            return new byte[]{1};
        }
        if (i3 == -2) {
            return new byte[]{0};
        }
        if (w0.c(str) || (a16 = a(str)) == null) {
            return null;
        }
        if (dVar instanceof com.tencent.luggage.wxa.ic.l) {
            int i16 = C6688c.f139797a[this.f139781a.d().ordinal()];
            if (i16 != 1 && i16 != 2 && i16 != 3) {
                return a16.f139775a;
            }
            return a16.f139776b;
        }
        return a16.f139775a;
    }

    public int a(byte[] bArr, int i3) {
        int i16 = this.f139782b;
        if (i16 == -1) {
            return 1;
        }
        if (i16 == -2) {
            return 0;
        }
        if (i3 == -2) {
            return 1;
        }
        if (i3 == -1) {
            return this.f139783c ? 1 : 0;
        }
        if (i3 >= bArr.length || i3 < 0) {
            return 0;
        }
        return bArr[i3];
    }

    public boolean a(com.tencent.luggage.wxa.xd.d dVar, Class cls) {
        int a16 = a(dVar, (Object) cls, (String) null, (String) null, b(cls), false);
        if (a16 == 1) {
            return true;
        }
        if (a16 == 6) {
            b(dVar, a(cls));
            return false;
        }
        if (a16 != 7) {
            return a16 == 8;
        }
        return this.f139781a.f();
    }

    public static String a(Object obj) {
        if (obj instanceof com.tencent.luggage.wxa.xd.c) {
            return ((com.tencent.luggage.wxa.xd.c) obj).getName();
        }
        if (obj instanceof Class) {
            Class cls = (Class) obj;
            if (com.tencent.luggage.wxa.xd.c.class.isAssignableFrom(cls)) {
                Map map = f139779o;
                String str = (String) map.get(cls);
                if (!w0.c(str)) {
                    return str;
                }
                try {
                    String str2 = (String) Reflect.on((Class<?>) cls).get("NAME");
                    map.put(cls, str2);
                    return str2;
                } catch (ReflectException e16) {
                    if (com.tencent.luggage.wxa.tn.e.f141559a) {
                        com.tencent.luggage.wxa.er.a.a("Must declare NAME in JsApi Class: " + cls.getName());
                    } else {
                        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppRuntimeApiPermissionController[permission]", "getApiNameByClass class:%s, reflect failed %s", cls.getName(), e16);
                    }
                    return cls.getSimpleName();
                }
            }
        }
        if (!com.tencent.luggage.wxa.tn.e.f141559a) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppRuntimeApiPermissionController[permission]", "Unrecognized api type:" + obj.getClass().getName());
            return obj.toString();
        }
        throw new IllegalArgumentException("Unrecognized api type:" + obj.getClass().getName());
    }

    public void a() {
        b();
    }

    public void a(HashMap hashMap) {
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(hashMap == null ? -1 : hashMap.size());
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppRuntimeApiPermissionController[permission]", "updatePluginPermission size:%d", objArr);
        if (hashMap == null || hashMap.isEmpty()) {
            return;
        }
        synchronized (this.f139787g) {
            if (this.f139788h == null) {
                this.f139788h = new HashMap();
            }
            this.f139788h.putAll(hashMap);
            h();
            g();
        }
    }

    public void a(f fVar) {
        synchronized (this.f139785e) {
            this.f139791k.add(fVar);
        }
    }

    public final void a(com.tencent.luggage.wxa.rj.b bVar) {
        byte[] bArr = bVar.f139775a;
        byte[] bArr2 = bVar.f139776b;
        byte[] bArr3 = bVar.f139777c;
        for (int i3 = 0; i3 < this.f139791k.size(); i3++) {
            ((f) this.f139791k.get(i3)).a(bArr, bArr2, bArr3);
        }
    }

    public final com.tencent.luggage.wxa.rj.b a(String str) {
        com.tencent.luggage.wxa.rj.b bVar;
        synchronized (this.f139787g) {
            bVar = (com.tencent.luggage.wxa.rj.b) this.f139788h.get(str);
        }
        return bVar;
    }

    public final void a(e eVar) {
        if (eVar == null) {
            return;
        }
        synchronized (this.f139784d) {
            this.f139784d.addLast(eVar);
        }
    }

    public d a(com.tencent.luggage.wxa.xd.d dVar, com.tencent.luggage.wxa.xd.c cVar, String str, String str2, int i3, e eVar) {
        if (cVar == null || dVar == null) {
            return d.f139802h;
        }
        com.tencent.luggage.wxa.qc.b d16 = this.f139781a.d();
        int a16 = a(dVar, (Object) cVar, str, str2, b(cVar), true);
        String appId = dVar.getAppId();
        if (eVar != null) {
            eVar.a(a16);
        }
        if (a16 == 6) {
            b(dVar, cVar.getName());
            return d.f139802h;
        }
        if (a16 == 1) {
            if (!(dVar instanceof com.tencent.luggage.wxa.ic.l) || d16 != com.tencent.luggage.wxa.qc.b.SUSPEND || !com.tencent.luggage.wxa.u9.a.a(f139780p, cVar.getName())) {
                return d.f139803i;
            }
            return new d(-1, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", cVar.getName(), d16.b(), "permission ok", "network api interrupted in suspend state"), com.tencent.luggage.wxa.af.e.f121319o);
        }
        if (a16 == 4) {
            if (!com.tencent.luggage.wxa.tj.b.a(appId, cVar.getName()) && !com.tencent.luggage.wxa.tj.b.a((com.tencent.luggage.wxa.xd.i) dVar, cVar.getName())) {
                com.tencent.luggage.wxa.tj.b.a(new com.tencent.luggage.wxa.tj.e((com.tencent.luggage.wxa.ic.d) dVar, cVar.getName(), str, str2, i3), new b(eVar));
                return d.f139801g;
            }
            return d.f139803i;
        }
        if (a16 == 7) {
            if (this.f139781a.f()) {
                return d.f139803i;
            }
            return new d(-1, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", cVar.getName(), d16.b(), "permission ok", "jsapi permission required playing audio but current not playing audio in background state"), com.tencent.luggage.wxa.af.e.f121319o);
        }
        if (a16 != 8) {
            return d.f139802h;
        }
        a(eVar);
        return d.f139801g;
    }
}
