package com.tencent.luggage.wxa.uk;

import NS_COMM.COMM;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.b9.t;
import com.tencent.luggage.wxa.tn.w0;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class x {

    /* renamed from: a, reason: collision with root package name */
    public static final LinkedList f142786a = new LinkedList();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements ValueCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f142787a;

        public a(e eVar) {
            this.f142787a = eVar;
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
            if (str != null && str.contains("11111")) {
                e eVar = this.f142787a;
                if (eVar != null) {
                    eVar.a(str);
                    return;
                }
                return;
            }
            e eVar2 = this.f142787a;
            if (eVar2 != null) {
                eVar2.b(str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements t.s {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f142788a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f142789b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f142790c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f142791d;

        public b(long j3, String str, e eVar, long j16) {
            this.f142788a = j3;
            this.f142789b = str;
            this.f142790c = eVar;
            this.f142791d = j16;
        }

        @Override // com.tencent.luggage.wxa.b9.t.s
        public void a(String str, t.C6044t c6044t) {
            if (c6044t.sourceLength <= 0) {
                c6044t.sourceLength = (int) this.f142788a;
            }
            x.a(this.f142789b, this.f142790c, str, this.f142791d);
            e eVar = this.f142790c;
            if (eVar instanceof f) {
                ((f) eVar).a(c6044t);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements ValueCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f142792a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f142793b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f142794c;

        public c(String str, e eVar, long j3) {
            this.f142792a = str;
            this.f142793b = eVar;
            this.f142794c = j3;
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
            x.a(this.f142792a, this.f142793b, str, this.f142794c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements ValueCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f142795a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f142796b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f142797c;

        public d(String str, e eVar, long j3) {
            this.f142795a = str;
            this.f142796b = eVar;
            this.f142797c = j3;
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
            x.a(this.f142795a, this.f142796b, str, this.f142797c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface e {
        void a(String str);

        void b(String str);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface f extends e {
        void a(t.C6044t c6044t);
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LinkedList linkedList = f142786a;
        synchronized (linkedList) {
            linkedList.add(str);
        }
    }

    public static String a() {
        return String.format(Locale.ENGLISH, "\n;(function(){return %d;})();", Integer.valueOf(COMM.hexlog));
    }

    public static void a(com.tencent.luggage.wxa.ei.j jVar, String str, e eVar) {
        a(jVar, (URL) null, str, eVar);
    }

    public static void a(com.tencent.luggage.wxa.ei.j jVar, URL url, String str, e eVar) {
        boolean z16;
        if (w0.c(str)) {
            if (eVar != null) {
                eVar.b("isNullOrNil script");
                return;
            }
            return;
        }
        if (jVar == null) {
            if (eVar != null) {
                eVar.b("wv is null");
                return;
            }
            return;
        }
        LinkedList linkedList = f142786a;
        synchronized (linkedList) {
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z16 = true;
                    break;
                } else if (str.startsWith((String) it.next())) {
                    z16 = false;
                    break;
                }
            }
        }
        if (z16) {
            str = str + a();
        }
        a aVar = new a(eVar);
        if (url == null) {
            jVar.evaluateJavascript(str, aVar);
        } else {
            jVar.a(url, str, aVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(com.tencent.luggage.wxa.ei.j jVar, String str, String str2, String str3, int i3, String str4, String str5, e eVar) {
        URL url;
        com.tencent.luggage.wxa.ei.v vVar;
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsValidationInjector", "hy: injecting file %s", str);
        long currentTimeMillis = System.currentTimeMillis();
        if (w0.c(str4)) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsValidationInjector", "hy: empty script!");
            if (eVar != null) {
                eVar.b("isNullOrNil script");
                return;
            }
            return;
        }
        String str6 = (str4 + String.format("\n;(function(){return %d;})();", Integer.valueOf(COMM.hexlog))) + w0.d(str5);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    url = new URL(str);
                    URL url2 = url;
                    long length = str6.length();
                    vVar = (com.tencent.luggage.wxa.ei.v) jVar.a(com.tencent.luggage.wxa.ei.v.class);
                    if (vVar == null) {
                        vVar.a(url2, str2, str3, i3, str6, new b(length, str, eVar, currentTimeMillis));
                        return;
                    } else if (!w0.c(str2) && !w0.c(str3)) {
                        jVar.a(url2, str2, str3, i3, str6, new d(str, eVar, currentTimeMillis));
                        return;
                    } else {
                        jVar.a(url2, str6, new c(str, eVar, currentTimeMillis));
                        return;
                    }
                }
            } catch (MalformedURLException unused) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsValidationInjector", "hy: MalformedURLException");
                eVar.b("MalformedURLException");
                return;
            }
        }
        url = null;
        URL url22 = url;
        long length2 = str6.length();
        vVar = (com.tencent.luggage.wxa.ei.v) jVar.a(com.tencent.luggage.wxa.ei.v.class);
        if (vVar == null) {
        }
    }

    public static void a(String str, e eVar, String str2, long j3) {
        if (str2 == null || !str2.contains("11111")) {
            if (eVar != null) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsValidationInjector", "hy: file %s inject failed!", str);
                eVar.b(str2);
                return;
            }
            return;
        }
        if (eVar != null) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsValidationInjector", "hy: file %s inject success! cost:%d", str, Long.valueOf(System.currentTimeMillis() - j3));
            eVar.a(str2);
        }
    }
}
