package com.tencent.luggage.wxa.r4;

import android.content.res.AssetFileDescriptor;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseIntArray;
import android.webkit.JavascriptInterface;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.b9.t;
import com.tencent.luggage.wxa.bf.t;
import com.tencent.luggage.wxa.m4.c;
import com.tencent.luggage.wxa.mc.k0;
import com.tencent.luggage.wxa.mc.m;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.uk.x;
import com.tencent.luggage.wxa.uk.y;
import com.tencent.luggage.wxa.xd.i1;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJni;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Callable;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b implements com.tencent.luggage.wxa.m4.c {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.r4.d f139096a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ei.t f139097b;

    /* renamed from: c, reason: collision with root package name */
    public final i f139098c;

    /* renamed from: d, reason: collision with root package name */
    public final SparseIntArray f139099d = new SparseIntArray();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.ei.i {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ei.h f139100a;

        public a(com.tencent.luggage.wxa.ei.h hVar) {
            this.f139100a = hVar;
        }

        @Override // com.tencent.luggage.wxa.ei.i
        public void a(String str, String str2) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "hy: on exception! message: %s, stacktrace %s", str, str2);
            i1.b(this.f139100a, "onError", String.format("{'message':'%s', 'stack': '%s'}", com.tencent.luggage.wxa.uk.w.a(str), com.tencent.luggage.wxa.uk.w.a(str2)), 0);
            com.tencent.luggage.wxa.hk.c.a().a("WeAppLaunch", str, str2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements t.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f139112a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f139113b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f139114c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f139115d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ long f139116e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f139117f;

        public c(int i3, String str, String str2, boolean z16, long j3, int i16) {
            this.f139112a = i3;
            this.f139113b = str;
            this.f139114c = str2;
            this.f139115d = z16;
            this.f139116e = j3;
            this.f139117f = i16;
        }

        @Override // com.tencent.luggage.wxa.bf.t.b
        public void a(String str, c.a[] aVarArr, boolean[] zArr, Object[] objArr, long j3, long j16) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadJsFileWithOptions appId[%s] contextId[%d] paths[%s] options[%s] results[%s]", b.this.f139096a.getAppId(), Integer.valueOf(this.f139112a), this.f139113b, this.f139114c, Arrays.toString(zArr));
            if (this.f139115d && this.f139116e > 0) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadJsFileWithOptions, appId[%s] initialScript[%s] inject done, cost[%d]ms", b.this.f139096a.getAppId(), str, Long.valueOf(j16 - this.f139116e));
            }
            b.this.a(str, this.f139115d, aVarArr, zArr, objArr, j3, j16);
            com.tencent.luggage.wxa.lk.j.b(b.this.f139096a.getComponentId() + "", this.f139117f);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements x.f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.tk.i f139119a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.dn.a f139120b;

        public d(com.tencent.luggage.wxa.tk.i iVar, com.tencent.luggage.wxa.dn.a aVar) {
            this.f139119a = iVar;
            this.f139120b = aVar;
        }

        @Override // com.tencent.luggage.wxa.uk.x.f
        public void a(t.C6044t c6044t) {
            this.f139119a.f141499a = c6044t;
        }

        @Override // com.tencent.luggage.wxa.uk.x.e
        public void b(String str) {
            this.f139120b.f124395a = false;
        }

        @Override // com.tencent.luggage.wxa.uk.x.e
        public void a(String str) {
            this.f139120b.f124395a = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements x.f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.dn.a f139122a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.tk.i f139123b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.dn.c f139124c;

        public e(com.tencent.luggage.wxa.dn.a aVar, com.tencent.luggage.wxa.tk.i iVar, com.tencent.luggage.wxa.dn.c cVar) {
            this.f139122a = aVar;
            this.f139123b = iVar;
            this.f139124c = cVar;
        }

        @Override // com.tencent.luggage.wxa.uk.x.e
        public void a(String str) {
            this.f139122a.f124395a = true;
        }

        @Override // com.tencent.luggage.wxa.uk.x.e
        public void b(String str) {
            this.f139122a.f124395a = false;
        }

        @Override // com.tencent.luggage.wxa.uk.x.f
        public void a(t.C6044t c6044t) {
            this.f139123b.f141499a = c6044t;
            this.f139124c.f124397a = c6044t.sourceLength;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements x.f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.tk.i f139126a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.dn.a f139127b;

        public f(com.tencent.luggage.wxa.tk.i iVar, com.tencent.luggage.wxa.dn.a aVar) {
            this.f139126a = iVar;
            this.f139127b = aVar;
        }

        @Override // com.tencent.luggage.wxa.uk.x.f
        public void a(t.C6044t c6044t) {
            this.f139126a.f141499a = c6044t;
        }

        @Override // com.tencent.luggage.wxa.uk.x.e
        public void b(String str) {
            this.f139127b.f124395a = false;
        }

        @Override // com.tencent.luggage.wxa.uk.x.e
        public void a(String str) {
            this.f139127b.f124395a = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g implements x.f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.tk.i f139129a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.dn.a f139130b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ei.h f139131c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f139132d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.dn.e f139133e;

        public g(com.tencent.luggage.wxa.tk.i iVar, com.tencent.luggage.wxa.dn.a aVar, com.tencent.luggage.wxa.ei.h hVar, String str, com.tencent.luggage.wxa.dn.e eVar) {
            this.f139129a = iVar;
            this.f139130b = aVar;
            this.f139131c = hVar;
            this.f139132d = str;
            this.f139133e = eVar;
        }

        @Override // com.tencent.luggage.wxa.uk.x.f
        public void a(t.C6044t c6044t) {
            this.f139129a.f141499a = c6044t;
        }

        @Override // com.tencent.luggage.wxa.uk.x.e
        public void b(String str) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "injectSdkScript-injectWithFd, contextId:%d, path:%s, onFailure:%s", Integer.valueOf(this.f139131c.q()), this.f139132d, str);
            this.f139133e.f124399a = str;
            this.f139130b.f124395a = false;
        }

        @Override // com.tencent.luggage.wxa.uk.x.e
        public void a(String str) {
            this.f139130b.f124395a = true;
        }
    }

    public b(com.tencent.luggage.wxa.r4.d dVar, com.tencent.luggage.wxa.ei.t tVar) {
        this.f139096a = dVar;
        this.f139097b = tVar;
        this.f139098c = k.f139215a.a(dVar, tVar);
    }

    @JavascriptInterface
    public final int alloc() {
        int allocEmpty = allocEmpty();
        if (allocEmpty <= 0) {
            return allocEmpty;
        }
        com.tencent.luggage.wxa.ei.h a16 = a(allocEmpty);
        com.tencent.luggage.wxa.rc.q i3 = this.f139096a.i();
        if (i3 == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "alloc get NULL LibReader, id[%d], appId[%s]", Integer.valueOf(allocEmpty), this.f139096a.getAppId());
            return 0;
        }
        a(allocEmpty, d());
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        try {
            try {
                try {
                    Pair a17 = a(a16, d(), i3);
                    linkedList.add((Boolean) a17.first);
                    linkedList2.add((t.C6044t) a17.second);
                    a(allocEmpty, d(), linkedList, linkedList2);
                    return a16.q();
                } catch (Exception e16) {
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandJSContextInterface[multicontext]", e16, "alloc::injectSdkScript::" + d(), new Object[0]);
                    throw new RuntimeException(e16);
                }
            } catch (com.tencent.luggage.wxa.mc.s unused) {
                a(d());
                a(allocEmpty, d(), linkedList, linkedList2);
                return 0;
            }
        } catch (Throwable th5) {
            a(allocEmpty, d(), linkedList, linkedList2);
            throw th5;
        }
    }

    @JavascriptInterface
    public final int allocEmpty() {
        boolean z16 = false;
        try {
            e();
            com.tencent.luggage.wxa.ei.h a16 = a();
            if (a16 == null) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "alloc with appID(%s), allocJsContext failed", this.f139096a.getAppId());
                a(false);
                return -2;
            }
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandJSContextInterface[multicontext]", "hy: created context id is %d", Integer.valueOf(a16.q()));
            a16.setJsExceptionHandler(new a(a16));
            b(a16);
            a16.evaluateJavascript(String.format(Locale.US, "var __wxConfig = %s;", this.f139096a.x().toString()), null);
            try {
                int q16 = a16.q();
                a(true);
                return q16;
            } catch (Throwable th5) {
                th = th5;
                z16 = true;
                a(z16);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    @JavascriptInterface
    public int allocFromSnapshot(@Nullable final String str, int i3) {
        boolean z16 = false;
        try {
            b(str, i3);
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandJSContextInterface[multicontext]", "allocFromSnapshot, contextName: %s, snapshotContextIndex: %d", str, Integer.valueOf(i3));
            final com.tencent.luggage.wxa.ei.h a16 = a(str, i3);
            if (a16 == null) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "alloc with appID(%s), allocJsContext failed", this.f139096a.getAppId());
                a(str, i3, false);
                return -2;
            }
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandJSContextInterface[multicontext]", "hy: created context id is %d", Integer.valueOf(a16.q()));
            a16.setJsExceptionHandler(new com.tencent.luggage.wxa.ei.i() { // from class: com.tencent.luggage.wxa.r4.v
                @Override // com.tencent.luggage.wxa.ei.i
                public final void a(String str2, String str3) {
                    b.this.a(a16, str, str2, str3);
                }
            });
            b(a16);
            d(str, i3);
            a16.evaluateJavascript(String.format(Locale.US, ";globalThis.__wxConfig=%s;WeixinSnapshot.snapshotContextReady();", this.f139096a.x()), null);
            c(str, i3);
            try {
                int q16 = a16.q();
                a(str, i3, true);
                return q16;
            } catch (Throwable th5) {
                th = th5;
                z16 = true;
                a(str, i3, z16);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public void c(String str, int i3) {
    }

    @JavascriptInterface
    public final int create(String str) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s) appScriptPath(%s)", this.f139096a.getAppId(), str);
        if (w0.c(str)) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), nil appScriptPath", this.f139096a.getAppId());
            return -1;
        }
        int alloc = alloc();
        if (alloc <= 0) {
            return alloc;
        }
        com.tencent.luggage.wxa.ei.h f16 = this.f139097b.f(alloc);
        com.tencent.luggage.wxa.lk.j.a(this.f139096a.getAppId(), "public:inject", "\u4ee3\u7801\u6ce8\u5165-" + str);
        int evaluateScriptFile = evaluateScriptFile(alloc, str);
        com.tencent.luggage.wxa.lk.j.c(this.f139096a.getAppId());
        if (evaluateScriptFile != 1) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), appScriptPath(%s), eval ret = %d", this.f139096a.getAppId(), str, Integer.valueOf(evaluateScriptFile));
            return -1;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s) appScriptPath(%s), success with contextId(%d)", this.f139096a.getAppId(), str, Integer.valueOf(f16.q()));
        return f16.q();
    }

    public abstract String d();

    @JavascriptInterface
    public final void destroy(int i3) {
        this.f139097b.c(i3);
    }

    @JavascriptInterface
    public final int evaluateScriptFile(int i3, String str) {
        boolean z16;
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) contextId(%d) appScriptPath(%s)", this.f139096a.getAppId(), Integer.valueOf(i3), str);
        if (i3 > 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.luggage.wxa.er.a.b(z16);
        com.tencent.luggage.wxa.ei.h f16 = this.f139097b.f(i3);
        if (f16 == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) contextId(%d), appScriptPath(%s), get null context", this.f139096a.getAppId(), Integer.valueOf(i3), str);
            return -1;
        }
        if (f16.n()) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) scriptPath(%s), but want to inject main-context", this.f139096a.getAppId(), str);
            return -1;
        }
        if (this.f139099d.get(i3, 0) <= 0) {
            a(this.f139096a, f16);
            this.f139099d.put(i3, 1);
        }
        if (this.f139096a.getJsRuntime().a(com.tencent.luggage.wxa.ei.v.class) == null) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile without v8, appID(%s) contextId(%s) scriptPath(%s)", this.f139096a.getAppId(), Integer.valueOf(i3), str);
            try {
                try {
                    a(f16, str, a(this.f139096a, str));
                    return 1;
                } catch (Exception e16) {
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandJSContextInterface[multicontext]", e16, "evaluateScriptFile::injectAppScript::" + str, new Object[0]);
                    throw e16;
                }
            } catch (com.tencent.luggage.wxa.mc.s e17) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile without v8, with appID(%s) contextId(%d), appScriptPath(%s), %s", this.f139096a.getAppId(), Integer.valueOf(i3), str, e17.getMessage());
                return 0;
            } catch (Exception e18) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandJSContextInterface[multicontext]", e18, "getSubContextAppScript", new Object[0]);
                throw e18;
            }
        }
        try {
            if (a(f16, str) <= 0) {
                return 0;
            }
            return 1;
        } catch (Exception e19) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandJSContextInterface[multicontext]", e19, "evaluateScriptFile::injectWxaScript::" + str, new Object[0]);
            throw e19;
        }
    }

    public void f() {
        this.f139098c.a();
    }

    public boolean g() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0266  */
    @JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadJsFilesWithOptions(int i3, String str, String str2) {
        boolean z16;
        JSONObject jSONObject;
        String optString;
        boolean z17;
        String str3;
        String str4;
        Object[] objArr;
        JSONArray jSONArray;
        String str5;
        String str6;
        int i16;
        char c16;
        char c17;
        char c18;
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadJsFiles appId[%s] contextId[%d] paths[%s] options[%s]", this.f139096a.getAppId(), Integer.valueOf(i3), str, str2);
        if (i3 > 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.luggage.wxa.er.a.b(z16);
        com.tencent.luggage.wxa.ei.h f16 = this.f139097b.f(i3);
        if (f16 == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadJsFiles appId[%s] contextId[%d] get NULL context", this.f139096a.getAppId(), Integer.valueOf(i3));
            return;
        }
        if (this.f139099d.get(i3, 0) <= 0) {
            a(this.f139096a, f16);
            this.f139099d.put(i3, 1);
        }
        try {
            JSONArray jSONArray2 = new JSONArray(str);
            if (jSONArray2.length() <= 0) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadJsFiles get EMPTY paths appId[%s] context[%d] e=%s", this.f139096a.getAppId(), Integer.valueOf(i3));
                return;
            }
            try {
            } catch (JSONException e16) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadJsFiles parse options appId[%s] contextId[%d] options[%s] e=%s", this.f139096a.getAppId(), Integer.valueOf(i3), str2, e16);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject = new JSONObject(str2);
                if (jSONObject != null) {
                    optString = null;
                } else {
                    optString = jSONObject.optString("key");
                }
                if (TextUtils.isEmpty(optString)) {
                    if (jSONArray2.length() == 1) {
                        optString = jSONArray2.optString(0);
                    } else {
                        optString = com.tencent.luggage.wxa.tn.y.a(str);
                    }
                }
                String str7 = optString;
                if (jSONObject == null && jSONObject.optBoolean("initialScript", false)) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                long j3 = -1;
                if (z17) {
                    j3 = jSONObject.optLong("initialScriptStartTime", -1L);
                }
                if (f16.a(com.tencent.luggage.wxa.ei.v.class) == null) {
                    LinkedList linkedList = new LinkedList();
                    for (int i17 = 0; i17 < jSONArray2.length(); i17++) {
                        String optString2 = jSONArray2.optString(i17);
                        if (!TextUtils.isEmpty(optString2)) {
                            linkedList.add(optString2);
                        }
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    int b16 = com.tencent.luggage.wxa.lk.j.b(this.f139096a.getComponentId() + "", "public:inject", "\u4ee3\u7801\u6ce8\u5165-" + str);
                    try {
                        Object[] objArr2 = new Object[3];
                        try {
                            objArr2[0] = this.f139096a.getAppId();
                            try {
                                objArr2[1] = Integer.valueOf(i3);
                                try {
                                    objArr2[2] = Integer.valueOf(linkedList.size());
                                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandJSContextInterface[multicontext]", "start invoke batchInjectUsrJsFiles for appId[%s] contextId[%d] paths.size[%d]", objArr2);
                                    try {
                                        jSONArray = jSONArray2;
                                        c16 = 2;
                                        c17 = 0;
                                        c18 = 1;
                                        i16 = 4;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        jSONArray = jSONArray2;
                                        c17 = 0;
                                        c18 = 1;
                                        str6 = "loadJsFiles, by batch eval appId[%s] contextId[%d], paths.size[%d], cost[%d]";
                                        c16 = 2;
                                        i16 = 4;
                                        str5 = "MicroMsg.AppBrandJSContextInterface[multicontext]";
                                        try {
                                            Object[] objArr3 = new Object[i16];
                                            objArr3[c17] = this.f139096a.getAppId();
                                            objArr3[c18] = Integer.valueOf(i3);
                                            objArr3[c16] = Integer.valueOf(jSONArray.length());
                                            objArr3[3] = th;
                                            com.tencent.luggage.wxa.tn.w.d(str5, "loadJsFiles, by batch eval appId[%s] contextId[%d], paths.size[%d], exception[%s]", objArr3);
                                            throw th;
                                        } catch (Throwable th6) {
                                            Object[] objArr4 = new Object[i16];
                                            objArr4[c17] = this.f139096a.getAppId();
                                            objArr4[c18] = Integer.valueOf(i3);
                                            objArr4[c16] = Integer.valueOf(jSONArray.length());
                                            objArr4[3] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                                            com.tencent.luggage.wxa.tn.w.d(str5, str6, objArr4);
                                            throw th6;
                                        }
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    jSONArray = jSONArray2;
                                    c18 = 1;
                                    str6 = "loadJsFiles, by batch eval appId[%s] contextId[%d], paths.size[%d], cost[%d]";
                                    c16 = 2;
                                    i16 = 4;
                                    c17 = 0;
                                    str5 = "MicroMsg.AppBrandJSContextInterface[multicontext]";
                                    Object[] objArr32 = new Object[i16];
                                    objArr32[c17] = this.f139096a.getAppId();
                                    objArr32[c18] = Integer.valueOf(i3);
                                    objArr32[c16] = Integer.valueOf(jSONArray.length());
                                    objArr32[3] = th;
                                    com.tencent.luggage.wxa.tn.w.d(str5, "loadJsFiles, by batch eval appId[%s] contextId[%d], paths.size[%d], exception[%s]", objArr32);
                                    throw th;
                                }
                                try {
                                    com.tencent.luggage.wxa.uk.y.a(this.f139096a, f16, str7, (String[]) linkedList.toArray(new String[0]), new C6670b(str7, z17, j3, currentTimeMillis, b16));
                                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadJsFiles, by batch eval appId[%s] contextId[%d], paths.size[%d], cost[%d]", this.f139096a.getAppId(), Integer.valueOf(i3), Integer.valueOf(jSONArray.length()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    return;
                                } catch (Throwable th8) {
                                    th = th8;
                                    str6 = "loadJsFiles, by batch eval appId[%s] contextId[%d], paths.size[%d], cost[%d]";
                                    str5 = "MicroMsg.AppBrandJSContextInterface[multicontext]";
                                    Object[] objArr322 = new Object[i16];
                                    objArr322[c17] = this.f139096a.getAppId();
                                    objArr322[c18] = Integer.valueOf(i3);
                                    objArr322[c16] = Integer.valueOf(jSONArray.length());
                                    objArr322[3] = th;
                                    com.tencent.luggage.wxa.tn.w.d(str5, "loadJsFiles, by batch eval appId[%s] contextId[%d], paths.size[%d], exception[%s]", objArr322);
                                    throw th;
                                }
                            } catch (Throwable th9) {
                                th = th9;
                                jSONArray = jSONArray2;
                                c18 = 1;
                                str6 = "loadJsFiles, by batch eval appId[%s] contextId[%d], paths.size[%d], cost[%d]";
                                i16 = 4;
                                c16 = 2;
                            }
                        } catch (Throwable th10) {
                            th = th10;
                            jSONArray = jSONArray2;
                            c17 = 0;
                            str6 = "loadJsFiles, by batch eval appId[%s] contextId[%d], paths.size[%d], cost[%d]";
                            i16 = 4;
                            c16 = 2;
                            c18 = 1;
                        }
                    } catch (Throwable th11) {
                        th = th11;
                        jSONArray = jSONArray2;
                        str5 = "MicroMsg.AppBrandJSContextInterface[multicontext]";
                        str6 = "loadJsFiles, by batch eval appId[%s] contextId[%d], paths.size[%d], cost[%d]";
                        i16 = 4;
                        c16 = 2;
                        c17 = 0;
                        c18 = 1;
                    }
                } else {
                    long a16 = w0.a();
                    try {
                    } catch (Throwable th12) {
                        th = th12;
                        str3 = "loadJsFiles, appId[%s] contextId[%d], paths.size[%d], cost[%d]";
                    }
                    try {
                        com.tencent.luggage.wxa.bf.t.a(this.f139096a.getRuntime(), jSONArray2, f16, this.f139096a.C(), str7, new c(i3, str, str2, z17, j3, com.tencent.luggage.wxa.lk.j.b(this.f139096a.getComponentId() + "", "public:inject", "\u4ee3\u7801\u6ce8\u5165-" + str)));
                        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadJsFiles, appId[%s] contextId[%d], paths.size[%d], cost[%d]", this.f139096a.getAppId(), Integer.valueOf(i3), Integer.valueOf(jSONArray2.length()), Long.valueOf(w0.a() - a16));
                        return;
                    } catch (Throwable th13) {
                        th = th13;
                        str3 = "loadJsFiles, appId[%s] contextId[%d], paths.size[%d], cost[%d]";
                        try {
                            objArr = new Object[5];
                            objArr[0] = this.f139096a.getAppId();
                            objArr[1] = Integer.valueOf(i3);
                            objArr[2] = str;
                            str4 = "MicroMsg.AppBrandJSContextInterface[multicontext]";
                        } catch (Throwable th14) {
                            th = th14;
                            str4 = "MicroMsg.AppBrandJSContextInterface[multicontext]";
                        }
                        try {
                            objArr[3] = str2;
                            objArr[4] = th;
                            com.tencent.luggage.wxa.tn.w.b(str4, "loadJsFileWithOptions appId[%s] contextId[%d] paths[%s] options[%s], get exception %s", objArr);
                            com.tencent.luggage.wxa.tn.w.d(str4, str3, this.f139096a.getAppId(), Integer.valueOf(i3), Integer.valueOf(jSONArray2.length()), Long.valueOf(w0.a() - a16));
                            return;
                        } catch (Throwable th15) {
                            th = th15;
                            com.tencent.luggage.wxa.tn.w.d(str4, str3, this.f139096a.getAppId(), Integer.valueOf(i3), Integer.valueOf(jSONArray2.length()), Long.valueOf(w0.a() - a16));
                            throw th;
                        }
                    }
                }
            }
            jSONObject = null;
            if (jSONObject != null) {
            }
            if (TextUtils.isEmpty(optString)) {
            }
            String str72 = optString;
            if (jSONObject == null) {
            }
            z17 = false;
            long j36 = -1;
            if (z17) {
            }
            if (f16.a(com.tencent.luggage.wxa.ei.v.class) == null) {
            }
        } catch (JSONException e17) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadJsFiles parse json appId[%s] context[%d] e=%s", this.f139096a.getAppId(), Integer.valueOf(i3), e17);
        }
    }

    @JavascriptInterface
    public void loadLibFiles(int i3, String str) {
        ArrayList arrayList;
        boolean z16;
        ArrayList arrayList2 = null;
        try {
            a(i3, str);
            com.tencent.luggage.wxa.lk.j.a(this.f139096a.getComponentId() + "", "public:inject", "\u4ee3\u7801\u6ce8\u5165-" + str);
            int i16 = 3;
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadLibFiles appId:%s, contextId:%d, paths:%s", this.f139096a.getAppId(), Integer.valueOf(i3), str);
            if (i3 >= 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            com.tencent.luggage.wxa.er.a.b(z16);
            com.tencent.luggage.wxa.ei.h a16 = a(i3);
            if (a16 == null) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadLibFiles get NULL context by id[%d], appId[%s]", Integer.valueOf(i3), this.f139096a.getAppId());
                com.tencent.luggage.wxa.lk.j.c(this.f139096a.getComponentId() + "");
                a(i3, str, (List) null, (List) null);
                return;
            }
            try {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    com.tencent.luggage.wxa.rc.q i17 = this.f139096a.i();
                    if (i17 == null) {
                        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadLibFiles get NULL LibReader, id[%d], appId[%s]", Integer.valueOf(i3), this.f139096a.getAppId());
                        com.tencent.luggage.wxa.lk.j.c(this.f139096a.getComponentId() + "");
                        a(i3, str, (List) null, (List) null);
                        return;
                    }
                    int length = jSONArray.length();
                    ArrayList arrayList3 = new ArrayList(length);
                    try {
                        ArrayList arrayList4 = new ArrayList(length);
                        int i18 = 0;
                        while (i18 < length) {
                            try {
                                arrayList3.add(arrayList2);
                                arrayList4.add(arrayList2);
                                String optString = jSONArray.optString(i18);
                                if (TextUtils.isEmpty(optString)) {
                                    Object[] objArr = new Object[i16];
                                    objArr[0] = Integer.valueOf(i18);
                                    objArr[1] = Integer.valueOf(i3);
                                    objArr[2] = this.f139096a.getAppId();
                                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadLibFiles get EMPTY name by index[%d] id[%d] appId[%s]", objArr);
                                } else {
                                    try {
                                        Objects.requireNonNull(optString);
                                        Pair a17 = a(a16, optString, i17);
                                        arrayList3.set(i18, (Boolean) a17.first);
                                        arrayList4.set(i18, (t.C6044t) a17.second);
                                    } catch (com.tencent.luggage.wxa.mc.s unused) {
                                        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadLibFiles get EMPTY script by name[%s] index[%d] id[%d] appId[%s]", optString, Integer.valueOf(i18), Integer.valueOf(i3), this.f139096a.getAppId());
                                    } catch (Exception e16) {
                                        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandJSContextInterface[multicontext]", e16, "loadLibFiles::injectSdkScript::" + optString, new Object[0]);
                                        throw new RuntimeException(e16);
                                    }
                                }
                                i18++;
                                arrayList2 = null;
                                i16 = 3;
                            } catch (Throwable th5) {
                                th = th5;
                                arrayList2 = arrayList3;
                                arrayList = arrayList4;
                                com.tencent.luggage.wxa.lk.j.c(this.f139096a.getComponentId() + "");
                                a(i3, str, arrayList2, arrayList);
                                throw th;
                            }
                        }
                        com.tencent.luggage.wxa.lk.j.c(this.f139096a.getComponentId() + "");
                        a(i3, str, arrayList3, arrayList4);
                    } catch (Throwable th6) {
                        th = th6;
                        arrayList2 = arrayList3;
                        arrayList = null;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    arrayList = null;
                    arrayList2 = null;
                }
            } catch (JSONException e17) {
                try {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadLibFiles parse paths failed, id[%d] appId[%s] e=%s", Integer.valueOf(i3), this.f139096a.getAppId(), e17);
                    com.tencent.luggage.wxa.lk.j.c(this.f139096a.getComponentId() + "");
                    a(i3, str, (List) null, (List) null);
                } catch (Throwable th8) {
                    th = th8;
                    arrayList = null;
                    arrayList2 = null;
                    com.tencent.luggage.wxa.lk.j.c(this.f139096a.getComponentId() + "");
                    a(i3, str, arrayList2, arrayList);
                    throw th;
                }
            }
        } catch (Throwable th9) {
            th = th9;
            arrayList = null;
        }
    }

    public void a(int i3, Object obj) {
    }

    public int b() {
        return 1;
    }

    public final com.tencent.luggage.wxa.r4.d c() {
        return this.f139096a;
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.r4.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6670b implements x.f {

        /* renamed from: a, reason: collision with root package name */
        public final c.a[] f139102a;

        /* renamed from: b, reason: collision with root package name */
        public final Object[] f139103b = new Object[1];

        /* renamed from: c, reason: collision with root package name */
        public final boolean[] f139104c = new boolean[1];

        /* renamed from: d, reason: collision with root package name */
        public int f139105d = 2;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f139106e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f139107f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ long f139108g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ long f139109h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ int f139110i;

        public C6670b(String str, boolean z16, long j3, long j16, int i3) {
            this.f139106e = str;
            this.f139107f = z16;
            this.f139108g = j3;
            this.f139109h = j16;
            this.f139110i = i3;
            this.f139102a = r3;
            c.a aVar = new c.a();
            c.a[] aVarArr = {aVar};
            aVar.f134095i = str;
        }

        @Override // com.tencent.luggage.wxa.uk.x.f
        public void a(t.C6044t c6044t) {
            this.f139103b[0] = c6044t;
            this.f139102a[0].f134097k = c6044t.sourceLength;
            a();
        }

        @Override // com.tencent.luggage.wxa.uk.x.e
        public void b(String str) {
            this.f139104c[0] = false;
            a();
        }

        @Override // com.tencent.luggage.wxa.uk.x.e
        public void a(String str) {
            this.f139104c[0] = true;
            a();
        }

        public final void a() {
            int i3 = this.f139105d - 1;
            this.f139105d = i3;
            if (i3 == 0) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f139107f && this.f139108g > 0) {
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadJsFileWithOptions, appId[%s] initialScript[%s] inject done, cost[%d]ms", b.this.f139096a.getAppId(), this.f139106e, Long.valueOf(currentTimeMillis - this.f139108g));
                }
                b.this.a(this.f139106e, this.f139107f, this.f139102a, this.f139104c, this.f139103b, this.f139109h, currentTimeMillis);
                com.tencent.luggage.wxa.lk.j.b(b.this.f139096a.getComponentId() + "", this.f139110i);
            }
        }
    }

    public void a(int i3, String str) {
    }

    public Object b(int i3) {
        return null;
    }

    public void a(int i3, String str, List list, List list2) {
    }

    public void b(String str, int i3) {
    }

    public void a(c.a aVar, boolean z16, long j3, long j16, Object obj) {
    }

    public final void b(com.tencent.luggage.wxa.ei.h hVar, String str) {
        if (hVar == null) {
            return;
        }
        com.tencent.luggage.wxa.r4.f h06 = c().h0();
        if (h06.H()) {
            com.tencent.luggage.wxa.ei.v vVar = (com.tencent.luggage.wxa.ei.v) hVar.a(com.tencent.luggage.wxa.ei.v.class);
            if (vVar == null) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "notifySubContextCreated, contextV8 is null");
                return;
            }
            com.tencent.luggage.wxa.r4.a y16 = h06.y();
            if (y16 == null) {
                return;
            }
            AppBrandCommonBindingJni c16 = y16.c();
            if (TextUtils.isEmpty(str)) {
                str = "SubContext-" + hVar.q();
            }
            String str2 = str;
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandJSContextInterface[multicontext]", "notifySubContextCreated, contextName: %s", str2);
            c16.notifyContextCreated(vVar.f(), vVar.B(), str2);
        }
    }

    public void a(String str) {
    }

    public void a(String str, int i3, boolean z16) {
    }

    public void a(String str, String str2, String str3) {
    }

    public void a(String str, boolean z16, c.a[] aVarArr, boolean[] zArr, Object[] objArr, long j3, long j16) {
    }

    public void a(boolean z16) {
    }

    public com.tencent.luggage.wxa.ei.h a() {
        com.tencent.luggage.wxa.ei.h o16 = this.f139097b.o();
        a(o16);
        b(o16, (String) null);
        return o16;
    }

    public void a(com.tencent.luggage.wxa.ei.h hVar) {
        if (com.tencent.luggage.wxa.b9.t.d()) {
            return;
        }
        com.tencent.luggage.wxa.ei.m mVar = (com.tencent.luggage.wxa.ei.m) hVar.a(com.tencent.luggage.wxa.ei.m.class);
        if (mVar == null || mVar.w()) {
            com.tencent.luggage.wxa.ei.v vVar = (com.tencent.luggage.wxa.ei.v) hVar.a(com.tencent.luggage.wxa.ei.v.class);
            com.tencent.luggage.wxa.r4.d dVar = this.f139096a;
            com.tencent.luggage.wxa.r4.a y16 = dVar instanceof com.tencent.luggage.wxa.r4.d ? dVar.h0().y() : null;
            if (vVar == null || y16 == null) {
                return;
            }
            y16.c().notifyBindConsoleTo(vVar.f(), vVar.B(), vVar.j());
        }
    }

    public final void b(com.tencent.luggage.wxa.ei.h hVar) {
        this.f139098c.a(hVar);
    }

    public final void a(com.tencent.luggage.wxa.ei.h hVar, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.luggage.wxa.dn.a aVar = new com.tencent.luggage.wxa.dn.a();
        com.tencent.luggage.wxa.tk.i iVar = new com.tencent.luggage.wxa.tk.i();
        com.tencent.luggage.wxa.lk.j.a(this.f139096a.getComponentId() + "", "public:inject", "\u4ee3\u7801\u6ce8\u5165-" + str);
        com.tencent.luggage.wxa.uk.y.a(c().getRuntime(), hVar, str, str.replace('/', util.base64_pad_url) + "_" + this.f139096a.getAppId(), this.f139096a.getRuntime().j0().f125966l.md5, 0, str2, y.e.USR, new d(iVar, aVar));
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandJSContextInterface[multicontext]", "injectAppScript with appID(%s), contextId(%d), appScriptPath(%s), succeed(%b)", this.f139096a.getAppId(), Integer.valueOf(hVar.q()), str, Boolean.valueOf(aVar.f124395a));
        long currentTimeMillis2 = System.currentTimeMillis();
        com.tencent.luggage.wxa.lk.j.c(this.f139096a.getComponentId() + "");
        c.a aVar2 = new c.a();
        aVar2.f134095i = str;
        aVar2.f134096j = str2;
        aVar2.f134097k = w0.d(str2).length();
        a(aVar2, aVar.f124395a, currentTimeMillis, currentTimeMillis2, iVar.f141499a);
    }

    public void e() {
    }

    public final String a(m.a aVar) {
        return String.format(Locale.ENGLISH, "FileEntry{providerId:%s, appVersion:%d, appVersionStr:%s, fileName:%s, fileOffset:%d, fileLength:%d}", aVar.f134335a, Integer.valueOf(aVar.f134336b), aVar.f134337c, aVar.f134340f, Integer.valueOf(aVar.f134341g), Integer.valueOf(aVar.f134342h));
    }

    public int a(com.tencent.luggage.wxa.ei.h hVar, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.luggage.wxa.lk.j.a(this.f139096a.getComponentId() + "", "public:inject", "\u4ee3\u7801\u6ce8\u5165-" + str);
        com.tencent.luggage.wxa.dn.a aVar = new com.tencent.luggage.wxa.dn.a();
        com.tencent.luggage.wxa.dn.c cVar = new com.tencent.luggage.wxa.dn.c();
        com.tencent.luggage.wxa.mc.n b16 = k0.b(c().getRuntime());
        if (b16 == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "injectWxaScript pkgListReader is null, err, appId(%s) scriptPath(%s)", this.f139096a.getAppId(), str);
            return 0;
        }
        m.a openReadPartialInfo = b16.openReadPartialInfo(str);
        if (openReadPartialInfo == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "injectWxaScript, scriptFileInfo is null, appId(%s) scriptPath(%s)", this.f139096a.getAppId(), str);
            return 0;
        }
        com.tencent.luggage.wxa.tk.i iVar = new com.tencent.luggage.wxa.tk.i();
        com.tencent.luggage.wxa.uk.y.a(c(), hVar, str, new String[]{str}, new e(aVar, iVar, cVar));
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandJSContextInterface[multicontext]", "injectWxaScript with appID(%s), contextId(%d), appScriptPath(%s), succeed(%b), entry(%s)", this.f139096a.getAppId(), Integer.valueOf(hVar.q()), str, Boolean.valueOf(aVar.f124395a), a(openReadPartialInfo));
        long currentTimeMillis2 = System.currentTimeMillis();
        com.tencent.luggage.wxa.lk.j.c(this.f139096a.getComponentId() + "");
        c.a aVar2 = new c.a();
        aVar2.f134095i = str;
        aVar2.f134096j = null;
        aVar2.f134097k = cVar.f124397a;
        aVar2.f134335a = openReadPartialInfo.f134335a;
        aVar2.f134336b = openReadPartialInfo.f134336b;
        a(aVar2, aVar.f124395a, currentTimeMillis, currentTimeMillis2, iVar.f141499a);
        return cVar.f124397a;
    }

    public final Pair a(final com.tencent.luggage.wxa.ei.h hVar, final String str, final com.tencent.luggage.wxa.rc.q qVar) {
        com.tencent.luggage.wxa.dn.d dVar;
        com.tencent.luggage.wxa.tk.i iVar;
        com.tencent.luggage.wxa.dn.a aVar;
        String str2;
        String str3;
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.luggage.wxa.lk.j.a(this.f139096a.getComponentId() + "", "public:inject", "\u4ee3\u7801\u6ce8\u5165-" + str);
        final com.tencent.luggage.wxa.dn.a aVar2 = new com.tencent.luggage.wxa.dn.a();
        final com.tencent.luggage.wxa.tk.i iVar2 = new com.tencent.luggage.wxa.tk.i();
        final com.tencent.luggage.wxa.dn.d dVar2 = new com.tencent.luggage.wxa.dn.d();
        Callable callable = new Callable() { // from class: com.tencent.luggage.wxa.r4.w
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Void a16;
                a16 = b.this.a(qVar, str, dVar2, hVar, iVar2, aVar2);
                return a16;
            }
        };
        AssetFileDescriptor d16 = g() ? qVar.d(str) : null;
        if (d16 == null) {
            callable.call();
            dVar = dVar2;
            iVar = iVar2;
            aVar = aVar2;
            str2 = "";
            str3 = str;
        } else {
            com.tencent.luggage.wxa.dn.e eVar = new com.tencent.luggage.wxa.dn.e();
            dVar2.f124398a = d16.getLength();
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandJSContextInterface[multicontext]", "injectSdkScript-injectWithFd, contextId:%d, path:%s", Integer.valueOf(hVar.q()), str);
            dVar = dVar2;
            iVar = iVar2;
            aVar = aVar2;
            str2 = "";
            str3 = str;
            com.tencent.luggage.wxa.uk.y.a(c(), hVar, str, str, "v" + a(c()), b(), d16, y.e.LIB, new g(iVar2, aVar2, hVar, str, eVar));
            if (!aVar.f124395a && "Abort for empty source".equals(eVar.f124399a)) {
                callable.call();
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        com.tencent.luggage.wxa.lk.j.c(this.f139096a.getComponentId() + str2);
        c.a aVar3 = new c.a();
        aVar3.f134095i = str3;
        aVar3.f134096j = null;
        aVar3.f134097k = dVar.f124398a;
        a(aVar3, aVar.f124395a, currentTimeMillis, currentTimeMillis2, iVar.f141499a);
        return new Pair(Boolean.valueOf(aVar.f124395a), (t.C6044t) iVar.f141499a);
    }

    public void d(String str, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void a(com.tencent.luggage.wxa.rc.q qVar, String str, com.tencent.luggage.wxa.dn.d dVar, com.tencent.luggage.wxa.ei.h hVar, com.tencent.luggage.wxa.tk.i iVar, com.tencent.luggage.wxa.dn.a aVar) {
        String b16 = com.tencent.luggage.wxa.tk.c.b(qVar.a(str));
        if (!TextUtils.isEmpty(b16)) {
            dVar.f124398a = b16.length();
            com.tencent.luggage.wxa.uk.y.a(c(), hVar, str, str, "v" + a(c()), b(), b16, y.e.LIB, new f(iVar, aVar));
            return null;
        }
        throw new com.tencent.luggage.wxa.mc.s(str);
    }

    public final com.tencent.luggage.wxa.ei.h a(int i3) {
        return this.f139097b.f(i3);
    }

    public final int a(com.tencent.luggage.wxa.ic.l lVar) {
        return lVar.i().e().getPkgAppVersion();
    }

    public void a(com.tencent.luggage.wxa.r4.d dVar, com.tencent.luggage.wxa.ei.h hVar) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandJSContextInterface[multicontext]", "beforeEvaluateScriptFile appId:%s, contextId:%d", dVar.getAppId(), Integer.valueOf(hVar.q()));
    }

    public String a(com.tencent.luggage.wxa.r4.d dVar, String str) {
        String c16 = k0.c(dVar.getRuntime(), str);
        if (TextUtils.isEmpty(c16)) {
            throw new com.tencent.luggage.wxa.mc.s(str);
        }
        return c16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.tencent.luggage.wxa.ei.h hVar, String str, String str2, String str3) {
        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "hy: on exception! message: %s, stacktrace %s", str2, str3);
        i1.b(hVar, "onError", String.format("{'message':'%s', 'stack': '%s'}", com.tencent.luggage.wxa.uk.w.a(str2), com.tencent.luggage.wxa.uk.w.a(str3)), 0);
        com.tencent.luggage.wxa.hk.c.a().a("WeAppLaunch", str2, str3);
        a(str, str2, str3);
    }

    public com.tencent.luggage.wxa.ei.h a(String str, int i3) {
        Object b16 = b(i3);
        com.tencent.luggage.wxa.ei.h d16 = this.f139097b.d(i3);
        if (d16 == null) {
            return null;
        }
        a(d16);
        a(i3, b16);
        b(d16, str);
        return d16;
    }
}
