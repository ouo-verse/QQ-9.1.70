package com.tencent.luggage.wxa.uk;

import NS_COMM.COMM;
import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.eclipsesource.mmv8.V8ScriptEvaluateRequest;
import com.eclipsesource.mmv8.V8ScriptFileDescriptor;
import com.tencent.luggage.wxa.b9.t;
import com.tencent.luggage.wxa.ic.r0;
import com.tencent.luggage.wxa.mc.m;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.uk.x;
import com.tencent.mm.appbrand.commonjni.BatchRequestWxaFileDescriptorsResponse;
import com.tencent.mm.appbrand.commonjni.V8ScriptWxaFileDescriptor;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Objects;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class y {

    /* renamed from: a, reason: collision with root package name */
    public static String f142798a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements t.s {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f142799a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ x.e f142800b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f142801c;

        public a(String str, x.e eVar, long j3) {
            this.f142799a = str;
            this.f142800b = eVar;
            this.f142801c = j3;
        }

        @Override // com.tencent.luggage.wxa.b9.t.s
        public void a(String str, t.C6044t c6044t) {
            x.a(this.f142799a, this.f142800b, str, this.f142801c);
            x.e eVar = this.f142800b;
            if (eVar instanceof x.f) {
                ((x.f) eVar).a(c6044t);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements t.s {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f142802a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ x.e f142803b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f142804c;

        public b(String str, x.e eVar, long j3) {
            this.f142802a = str;
            this.f142803b = eVar;
            this.f142804c = j3;
        }

        @Override // com.tencent.luggage.wxa.b9.t.s
        public void a(String str, t.C6044t c6044t) {
            x.a(this.f142802a, this.f142803b, str, this.f142804c);
            x.e eVar = this.f142803b;
            if (eVar instanceof x.f) {
                ((x.f) eVar).a(c6044t);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements t.s {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f142805a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ x.e f142806b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f142807c;

        public c(String str, x.e eVar, long j3) {
            this.f142805a = str;
            this.f142806b = eVar;
            this.f142807c = j3;
        }

        @Override // com.tencent.luggage.wxa.b9.t.s
        public void a(String str, t.C6044t c6044t) {
            x.a(this.f142805a, this.f142806b, str, this.f142807c);
            x.e eVar = this.f142806b;
            if (eVar instanceof x.f) {
                ((x.f) eVar).a(c6044t);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements ValueCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x.e f142808a;

        public d(x.e eVar) {
            this.f142808a = eVar;
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
            if (str != null && str.contains("11111")) {
                x.e eVar = this.f142808a;
                if (eVar != null) {
                    eVar.a(str);
                    return;
                }
                return;
            }
            x.e eVar2 = this.f142808a;
            if (eVar2 != null) {
                eVar2.b(str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum e {
        LIB,
        USR
    }

    public static BatchRequestWxaFileDescriptorsResponse a(com.tencent.luggage.wxa.ic.d dVar, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        BatchRequestWxaFileDescriptorsResponse batchRequestWxaFileDescriptorsResponse = new BatchRequestWxaFileDescriptorsResponse();
        batchRequestWxaFileDescriptorsResponse.keyPath = a();
        ArrayList arrayList = new ArrayList(strArr.length);
        com.tencent.luggage.wxa.mc.m C = dVar.C();
        Objects.requireNonNull(C);
        com.tencent.luggage.wxa.mc.m mVar = C;
        for (String str : strArr) {
            m.a openReadPartialInfo = mVar.openReadPartialInfo(str);
            if (openReadPartialInfo != null) {
                V8ScriptWxaFileDescriptor v8ScriptWxaFileDescriptor = new V8ScriptWxaFileDescriptor();
                v8ScriptWxaFileDescriptor.wxaFileName = openReadPartialInfo.f134340f;
                v8ScriptWxaFileDescriptor.wxaPkgPath = openReadPartialInfo.f134339e;
                arrayList.add(v8ScriptWxaFileDescriptor);
            }
        }
        batchRequestWxaFileDescriptorsResponse.fds = (V8ScriptWxaFileDescriptor[]) arrayList.toArray(new V8ScriptWxaFileDescriptor[0]);
        return batchRequestWxaFileDescriptorsResponse;
    }

    public static V8ScriptEvaluateRequest b() {
        V8ScriptEvaluateRequest v8ScriptEvaluateRequest = new V8ScriptEvaluateRequest();
        v8ScriptEvaluateRequest.scriptType = 3;
        v8ScriptEvaluateRequest.scriptText = String.format(Locale.ENGLISH, "\n;(function(){return %d;})();", Integer.valueOf(COMM.hexlog));
        return v8ScriptEvaluateRequest;
    }

    public static void a(com.tencent.luggage.wxa.ic.l lVar, com.tencent.luggage.wxa.ei.j jVar, String str, String[] strArr, x.e eVar) {
        com.tencent.luggage.wxa.mc.m mVar;
        int i3;
        if (lVar == null || jVar == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String appId = lVar.getAppId();
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        com.tencent.luggage.wxa.ei.v vVar = (com.tencent.luggage.wxa.ei.v) jVar.a(com.tencent.luggage.wxa.ei.v.class);
        Objects.requireNonNull(vVar);
        com.tencent.luggage.wxa.ei.v vVar2 = vVar;
        com.tencent.luggage.wxa.mc.m C = lVar.C();
        Objects.requireNonNull(C);
        com.tencent.luggage.wxa.mc.m mVar2 = C;
        int i16 = 0;
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsValidationInjectorWC", "batchInjectUsrJsFiles start assemble requests, appId:%s, key:%s, paths.size:%d", appId, str, Integer.valueOf(strArr.length));
        String a16 = a(lVar, e.USR);
        boolean a17 = r0.a(lVar.getRuntime());
        int length = strArr.length;
        while (i16 < length) {
            String str2 = strArr[i16];
            if (TextUtils.isEmpty(str2)) {
                mVar = mVar2;
            } else {
                m.a openReadPartialInfo = mVar2.openReadPartialInfo(str2);
                if (openReadPartialInfo == null) {
                    mVar = mVar2;
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsValidationInjectorWC", "batchInjectUsrJsFiles for appId(%s) path(%s) not found", appId, str2);
                } else {
                    mVar = mVar2;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(a16);
                    i3 = length;
                    sb5.append(com.tencent.luggage.wxa.rc.m.c(str2));
                    String sb6 = sb5.toString();
                    if (!a17) {
                        String a18 = r0.a(lVar.getRuntime(), str2, a16);
                        if (!TextUtils.isEmpty(a18)) {
                            linkedList.addLast(a(a18));
                        }
                    }
                    linkedList2.addLast(a(str2, openReadPartialInfo, sb6));
                    i16++;
                    mVar2 = mVar;
                    length = i3;
                }
            }
            i3 = length;
            i16++;
            mVar2 = mVar;
            length = i3;
        }
        ArrayList arrayList = new ArrayList(linkedList.size() + linkedList2.size() + 1);
        arrayList.addAll(linkedList);
        arrayList.addAll(linkedList2);
        arrayList.add(b());
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsValidationInjectorWC", "batchInjectUsrJsFiles start invoke batchEvaluateJavascript, appId:%s, key:%s, paths.size:%d", appId, str, Integer.valueOf(strArr.length));
        vVar2.a(arrayList, a(), new a(str, eVar, currentTimeMillis));
    }

    public static V8ScriptEvaluateRequest a(String str, m.a aVar, String str2) {
        String str3 = com.tencent.luggage.wxa.ki.a.b(aVar.f134340f).replace('/', util.base64_pad_url) + "_" + aVar.f134335a;
        String str4 = aVar.f134337c;
        V8ScriptEvaluateRequest v8ScriptEvaluateRequest = new V8ScriptEvaluateRequest();
        v8ScriptEvaluateRequest.scriptType = 2;
        com.eclipsesource.mmv8.V8ScriptWxaFileDescriptor v8ScriptWxaFileDescriptor = new com.eclipsesource.mmv8.V8ScriptWxaFileDescriptor();
        v8ScriptEvaluateRequest.scriptWxaFd = v8ScriptWxaFileDescriptor;
        v8ScriptWxaFileDescriptor.wxaPkgPath = aVar.f134339e;
        v8ScriptWxaFileDescriptor.wxaFileName = aVar.f134340f;
        v8ScriptEvaluateRequest.scriptName = str2;
        v8ScriptEvaluateRequest.lineNumber = 0;
        v8ScriptEvaluateRequest.cacheCategory = str3;
        v8ScriptEvaluateRequest.cacheKey = str4;
        v8ScriptEvaluateRequest.cacheType = 0;
        return v8ScriptEvaluateRequest;
    }

    public static V8ScriptEvaluateRequest a(String str) {
        V8ScriptEvaluateRequest v8ScriptEvaluateRequest = new V8ScriptEvaluateRequest();
        v8ScriptEvaluateRequest.scriptText = str;
        v8ScriptEvaluateRequest.scriptType = 3;
        return v8ScriptEvaluateRequest;
    }

    public static V8ScriptEvaluateRequest a(AssetFileDescriptor assetFileDescriptor) {
        V8ScriptEvaluateRequest v8ScriptEvaluateRequest = new V8ScriptEvaluateRequest();
        v8ScriptEvaluateRequest.scriptType = 1;
        try {
            ParcelFileDescriptor parcelFileDescriptor = assetFileDescriptor.getParcelFileDescriptor();
            try {
                V8ScriptFileDescriptor v8ScriptFileDescriptor = new V8ScriptFileDescriptor();
                v8ScriptEvaluateRequest.scriptFd = v8ScriptFileDescriptor;
                v8ScriptFileDescriptor.f32584fd = parcelFileDescriptor.detachFd();
                v8ScriptEvaluateRequest.scriptFd.startOffset = assetFileDescriptor.getStartOffset();
                v8ScriptEvaluateRequest.scriptFd.length = assetFileDescriptor.getLength();
                parcelFileDescriptor.close();
                return v8ScriptEvaluateRequest;
            } finally {
            }
        } catch (IOException e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsValidationInjectorWC", "createEvalRequestForAssetFd, convert scriptFd to v8Fd, get exception:%s", e16);
            return null;
        }
    }

    public static void a(com.tencent.luggage.wxa.ic.l lVar, com.tencent.luggage.wxa.ei.j jVar, String str, String str2, String str3, int i3, AssetFileDescriptor assetFileDescriptor, e eVar, x.e eVar2) {
        String str4 = str;
        if (lVar == null || jVar == null) {
            return;
        }
        String a16 = a(lVar, eVar);
        String e16 = lVar.e(str);
        com.tencent.luggage.wxa.ei.v vVar = (com.tencent.luggage.wxa.ei.v) jVar.a(com.tencent.luggage.wxa.ei.v.class);
        if (TextUtils.isEmpty(e16) && vVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList(2);
            URL url = null;
            if (!TextUtils.isEmpty(a16) && !TextUtils.isEmpty(str)) {
                try {
                    url = new URL(a16 + str);
                } catch (MalformedURLException unused) {
                }
            }
            V8ScriptEvaluateRequest a17 = a(assetFileDescriptor);
            if (a17 == null) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsValidationInjectorWC", "injectWithFd, convert scriptFd to v8Fd, get null");
                eVar2.b("");
                return;
            }
            a17.scriptType = 1;
            if (url != null) {
                str4 = url.toString();
                a17.scriptName = str4;
            }
            a17.cacheCategory = str2;
            a17.cacheKey = str3;
            a17.cacheType = i3;
            arrayList.add(arrayList.size(), a17);
            arrayList.add(arrayList.size(), b());
            vVar.a(arrayList, a(), new b(str4, eVar2, currentTimeMillis));
            return;
        }
        a(lVar, jVar, str, str2, str3, i3, com.tencent.luggage.wxa.tk.c.a(assetFileDescriptor), eVar, eVar2);
    }

    public static void a(com.tencent.luggage.wxa.ic.l lVar, com.tencent.luggage.wxa.ei.j jVar, String str, String str2, String str3, int i3, String str4, e eVar, x.e eVar2) {
        if (lVar == null) {
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.JsValidationInjectorWC", "hy: service is null! abort");
            return;
        }
        String a16 = a(lVar, eVar);
        x.a(jVar, a16 + str, str2, str3, i3, str4, lVar.e(str), eVar2);
    }

    public static void a(com.tencent.luggage.wxa.ic.g gVar, com.tencent.luggage.wxa.ei.j jVar, String str, String str2, String str3, int i3, String str4, e eVar, x.e eVar2) {
        if (gVar != null && gVar.h0() != null) {
            String a16 = r0.a(gVar, str, a(gVar.h0(), eVar));
            if (!w0.c(a16)) {
                x.a(jVar, a16, null);
            }
            a(gVar.h0(), jVar, str, str2, str3, i3, str4, eVar, eVar2);
            return;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsValidationInjectorWC", "hy: runtime or service is null!");
    }

    public static String a() {
        if (w0.c(f142798a)) {
            f142798a = com.tencent.luggage.wxa.gd.a.a(com.tencent.luggage.wxa.tn.z.c());
        }
        return f142798a;
    }

    public static void a(com.tencent.luggage.wxa.ic.g gVar, com.tencent.luggage.wxa.ei.j jVar, String str, String str2, String str3, String str4, e eVar, x.e eVar2) {
        if (gVar != null && gVar.h0() != null) {
            String a16 = com.tencent.luggage.wxa.rc.m.a(str2);
            if (a16.startsWith("/__APP__")) {
                a16 = com.tencent.luggage.wxa.rc.m.a(a16.substring(8));
            }
            String a17 = a(gVar.h0(), eVar);
            ArrayList arrayList = new ArrayList();
            String a18 = r0.a(gVar, str2, a17);
            if (!TextUtils.isEmpty(a18)) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsValidationInjectorWC", "inject sourceMap appId[%s] filePath[%s]", gVar.getAppId(), str2);
                arrayList.add(a(a18));
            }
            V8ScriptEvaluateRequest v8ScriptEvaluateRequest = new V8ScriptEvaluateRequest();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(a17);
            sb5.append(a17.endsWith("/") ? com.tencent.luggage.wxa.rc.m.c(a16) : a16);
            v8ScriptEvaluateRequest.scriptName = sb5.toString();
            v8ScriptEvaluateRequest.scriptType = 2;
            com.eclipsesource.mmv8.V8ScriptWxaFileDescriptor v8ScriptWxaFileDescriptor = new com.eclipsesource.mmv8.V8ScriptWxaFileDescriptor();
            v8ScriptEvaluateRequest.scriptWxaFd = v8ScriptWxaFileDescriptor;
            v8ScriptWxaFileDescriptor.wxaPkgPath = str;
            v8ScriptWxaFileDescriptor.wxaFileName = a16;
            v8ScriptEvaluateRequest.cacheCategory = str3;
            v8ScriptEvaluateRequest.cacheKey = str4;
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.luggage.wxa.ei.v vVar = (com.tencent.luggage.wxa.ei.v) jVar.a(com.tencent.luggage.wxa.ei.v.class);
            Objects.requireNonNull(vVar);
            vVar.a(arrayList, a(), new c(str2, eVar2, currentTimeMillis));
            return;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsValidationInjectorWC", "hy: runtime or service is null!");
    }

    public static String a(com.tencent.luggage.wxa.ic.l lVar, e eVar) {
        if (eVar == e.LIB) {
            return lVar.K();
        }
        return eVar == e.USR ? lVar.M() : "";
    }

    public static void a(com.tencent.luggage.wxa.ei.j jVar, String str, boolean z16) {
        com.tencent.luggage.wxa.ei.m mVar = (com.tencent.luggage.wxa.ei.m) jVar.a(com.tencent.luggage.wxa.ei.m.class);
        if (mVar == null) {
            return;
        }
        mVar.a(str, z16);
    }

    public static void a(com.tencent.luggage.wxa.ei.j jVar) {
        com.tencent.luggage.wxa.ei.m mVar = (com.tencent.luggage.wxa.ei.m) jVar.a(com.tencent.luggage.wxa.ei.m.class);
        if (mVar == null) {
            return;
        }
        mVar.h();
    }

    public static void a(com.tencent.luggage.wxa.ic.l lVar, com.tencent.luggage.wxa.ei.j jVar, String str, String str2, e eVar, x.e eVar2) {
        if (w0.c(str2)) {
            if (eVar2 != null) {
                eVar2.b("isNullOrNil script");
                return;
            }
            return;
        }
        com.tencent.luggage.wxa.ei.m mVar = (com.tencent.luggage.wxa.ei.m) jVar.a(com.tencent.luggage.wxa.ei.m.class);
        if (mVar == null) {
            return;
        }
        try {
            mVar.a(str2 + String.format(Locale.ENGLISH, "\n;(function(){return %d;})();", Integer.valueOf(COMM.hexlog)), new URL(a(lVar, eVar) + str).toString(), new d(eVar2));
        } catch (MalformedURLException unused) {
        }
    }

    public static void a(com.tencent.luggage.wxa.ei.j jVar, String str) {
        try {
            jVar.a(new URL(str + "break.js"), "breakprogram();", null);
        } catch (MalformedURLException unused) {
        }
    }
}
