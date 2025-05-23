package com.tencent.luggage.wxa.m6;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Toast;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.luggage.wxa.hn.e9;
import com.tencent.luggage.wxa.hn.h0;
import com.tencent.luggage.wxa.hn.n2;
import com.tencent.luggage.wxa.hn.qg;
import com.tencent.luggage.wxa.hn.rg;
import com.tencent.luggage.wxa.hn.w8;
import com.tencent.luggage.wxa.tn.r0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xo.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.out.nativePlugins.SmsPlugin;
import com.tencent.smtt.sdk.WebView;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d {

    /* renamed from: j, reason: collision with root package name */
    public static final b f134163j = new b(null);

    /* renamed from: k, reason: collision with root package name */
    public static final Pattern f134164k = Pattern.compile(".*#.*wechat_redirect");

    /* renamed from: l, reason: collision with root package name */
    public static final List f134165l;

    /* renamed from: m, reason: collision with root package name */
    public static final Function3 f134166m;

    /* renamed from: n, reason: collision with root package name */
    public static Function3 f134167n;

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.k6.f f134168a;

    /* renamed from: b, reason: collision with root package name */
    public String f134169b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f134170c;

    /* renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap f134171d;

    /* renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap f134172e;

    /* renamed from: f, reason: collision with root package name */
    public volatile w8 f134173f;

    /* renamed from: g, reason: collision with root package name */
    public final l f134174g;

    /* renamed from: h, reason: collision with root package name */
    public Function2 f134175h;

    /* renamed from: i, reason: collision with root package name */
    public final ConcurrentSkipListSet f134176i;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function3 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f134177a = new a();

        public a() {
            super(3);
        }

        public final void a(String str, String url, View view) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(view, "view");
            Intent intent = new Intent("android.intent.action.DIAL");
            intent.setData(Uri.parse(url));
            Context context = view.getContext();
            com.tencent.luggage.wxa.fa.b.a(context, intent);
            context.startActivity(intent);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            a((String) obj, (String) obj2, (View) obj3);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0058, code lost:
        
            if (r2 == false) goto L38;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean a(String str) {
            boolean z16;
            boolean z17;
            boolean z18 = false;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                if (!URLUtil.isAboutUrl(str) && !URLUtil.isFileUrl(str)) {
                    b bVar = d.f134163j;
                    if (!bVar.e(str) && !URLUtil.isAssetUrl(str) && !Intrinsics.areEqual("file:///android_asset/jsapi/wxjs.js", str)) {
                        if (!bVar.d(str) && !bVar.c(str)) {
                            try {
                                String host = Uri.parse(str).getHost();
                                if (host != null) {
                                    if (host.length() != 0) {
                                        z17 = false;
                                    }
                                }
                                z17 = true;
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
                w.d("Luggage.HTMLWebViewUrlCheckLogic", "checkCanLoadUrl url:" + str + ", canLoad:" + z18);
                return z18;
            }
            z18 = true;
            w.d("Luggage.HTMLWebViewUrlCheckLogic", "checkCanLoadUrl url:" + str + ", canLoad:" + z18);
            return z18;
        }

        public final String b(String str) {
            int indexOf$default;
            Intrinsics.checkNotNullParameter(str, "<this>");
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, '#', 0, false, 6, (Object) null);
            if (indexOf$default >= 0) {
                String substring = str.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                return substring;
            }
            return str;
        }

        public final boolean c(String str) {
            boolean startsWith$default;
            boolean startsWith$default2;
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "sms:", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(str, SmsPlugin.KEY_SYSTEM_SMS_URI, false, 2, null);
                if (!startsWith$default2) {
                    return false;
                }
            }
            return true;
        }

        public final boolean d(String str) {
            boolean startsWith$default;
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, WebView.SCHEME_TEL, false, 2, null);
            return startsWith$default;
        }

        public final boolean e(String str) {
            boolean contains$default;
            try {
                String host = Uri.parse(str).getHost();
                if (host == null) {
                    host = "";
                }
                String a16 = com.tencent.luggage.wxa.h6.j.a();
                Intrinsics.checkNotNullExpressionValue(a16, "getSelfIp()");
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) host, (CharSequence) a16, false, 2, (Object) null);
                return contains$default;
            } catch (Throwable th5) {
                w.b("Luggage.HTMLWebViewUrlCheckLogic", "isUrlContainsLocalIP(" + str + ") exception=" + th5);
                return false;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements e.c {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.m6.k f134179b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function2 f134180c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f134181d;

        public c(com.tencent.luggage.wxa.m6.k kVar, Function2 function2, boolean z16) {
            this.f134179b = kVar;
            this.f134180c = function2;
            this.f134181d = z16;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public final void a(n2 n2Var) {
            d.this.a(n2Var, this.f134179b, this.f134180c, this.f134181d);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.m6.d$d, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6461d implements e.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.m6.k f134183b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function2 f134184c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f134185d;

        public C6461d(com.tencent.luggage.wxa.m6.k kVar, Function2 function2, boolean z16) {
            this.f134183b = kVar;
            this.f134184c = function2;
            this.f134185d = z16;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            d.this.a(null, this.f134183b, this.f134184c, this.f134185d);
            w.b("Luggage.HTMLWebViewUrlCheckLogic", "getA8Key error " + obj);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements e.c {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ qg f134187b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f134188c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function2 f134189d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f134190e;

        public e(qg qgVar, String str, Function2 function2, int i3) {
            this.f134187b = qgVar;
            this.f134188c = str;
            this.f134189d = function2;
            this.f134190e = i3;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public final void a(rg rgVar) {
            Function2 function2;
            h0 e16;
            d.this.f134176i.remove(this.f134187b);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("doAsyncCheckUrl url(");
            sb5.append(this.f134188c);
            sb5.append(") outerUrl(");
            sb5.append(this.f134187b.f128540g);
            sb5.append("), get resp.ret:");
            sb5.append((rgVar == null || (e16 = rgVar.e()) == null) ? -1 : e16.f127731d);
            sb5.append(", resp.open_url:");
            sb5.append(rgVar != null ? rgVar.f128629e : null);
            w.d("Luggage.HTMLWebViewUrlCheckLogic", sb5.toString());
            String str = rgVar != null ? rgVar.f128629e : null;
            if (!(str == null || str.length() == 0)) {
                Function2 function22 = this.f134189d;
                if (function22 != null) {
                    String str2 = this.f134188c;
                    Intrinsics.checkNotNull(rgVar);
                    String str3 = rgVar.f128629e;
                    Intrinsics.checkNotNullExpressionValue(str3, "resp!!.open_url");
                    function22.invoke(str2, str3);
                    return;
                }
                return;
            }
            if (this.f134190e != 0 || (function2 = this.f134189d) == null) {
                return;
            }
            String str4 = this.f134188c;
            function2.invoke(str4, str4);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements e.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ qg f134192b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f134193c;

        public f(qg qgVar, String str) {
            this.f134192b = qgVar;
            this.f134193c = str;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            d.this.f134176i.remove(this.f134192b);
            d.this.f134168a.a();
            w.b("Luggage.HTMLWebViewUrlCheckLogic", "doAsyncCheckUrl url(" + this.f134193c + ") outerUrl(" + this.f134192b.f128540g + ") interrupted by " + obj);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2 f134194a;

        public g(Function2 function2) {
            this.f134194a = function2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Function2 function2 = this.f134194a;
            if (function2 != null) {
                function2.invoke("", "");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2 f134195a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.m6.k f134196b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f134197c;

        public h(Function2 function2, com.tencent.luggage.wxa.m6.k kVar, String str) {
            this.f134195a = function2;
            this.f134196b = kVar;
            this.f134197c = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Function2 function2 = this.f134195a;
            if (function2 != null) {
                com.tencent.luggage.wxa.m6.k kVar = this.f134196b;
                String str = this.f134197c;
                String f16 = kVar.f128118j.f();
                Intrinsics.checkNotNullExpressionValue(f16, "req.ReqUrl.string");
                function2.invoke(f16, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class i implements Comparator {

        /* renamed from: a, reason: collision with root package name */
        public static final i f134198a = new i();

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final int compare(qg qgVar, qg qgVar2) {
            String str;
            String str2;
            String str3;
            Object[] objArr = new Object[2];
            String str4 = null;
            if (qgVar != null) {
                str = qgVar.f128539f;
            } else {
                str = null;
            }
            objArr[0] = str;
            if (qgVar != null) {
                str2 = qgVar.f128540g;
            } else {
                str2 = null;
            }
            objArr[1] = str2;
            int hash = Objects.hash(objArr);
            Object[] objArr2 = new Object[2];
            if (qgVar2 != null) {
                str3 = qgVar2.f128539f;
            } else {
                str3 = null;
            }
            objArr2[0] = str3;
            if (qgVar2 != null) {
                str4 = qgVar2.f128540g;
            }
            objArr2[1] = str4;
            return hash - Objects.hash(objArr2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class j extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.xweb.WebView f134199a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(com.tencent.xweb.WebView webView) {
            super(0);
            this.f134199a = webView;
        }

        public final void a() {
            Toast.makeText(this.f134199a.getContext(), R.string.f242247u2, 0).show();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class k extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.xweb.WebView f134200a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(com.tencent.xweb.WebView webView) {
            super(0);
            this.f134200a = webView;
        }

        public final void a() {
            Toast.makeText(this.f134200a.getContext(), R.string.f242247u2, 0).show();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static {
        List split$default;
        split$default = StringsKt__StringsKt.split$default((CharSequence) "mp.weixin.qq.com/s;mp.weixin.qq.com/mp/appmsg/show", new char[]{';'}, false, 0, 6, (Object) null);
        f134165l = split$default;
        a aVar = a.f134177a;
        f134166m = aVar;
        f134167n = aVar;
    }

    public d(com.tencent.luggage.wxa.k6.f viewController) {
        Intrinsics.checkNotNullParameter(viewController, "viewController");
        this.f134168a = viewController;
        this.f134170c = new AtomicBoolean(true);
        this.f134171d = new ConcurrentHashMap();
        this.f134172e = new ConcurrentHashMap();
        this.f134174g = new l();
        this.f134176i = new ConcurrentSkipListSet(i.f134198a);
    }

    public static final boolean a(String str) {
        return f134163j.a(str);
    }

    public final boolean c(String str) {
        boolean startsWith$default;
        if ((str == null || str.length() == 0) || Intrinsics.areEqual("about:blank", str)) {
            return false;
        }
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "data:text/html;charset=utf-8", false, 2, null);
        return !startsWith$default;
    }

    public final boolean d(com.tencent.xweb.WebView view, String str, Function2 function2) {
        boolean z16;
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        boolean startsWith$default4;
        boolean startsWith$default5;
        boolean z17;
        Intrinsics.checkNotNullParameter(view, "view");
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "file:///android_asset", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(str, WebView.SCHEME_TEL, false, 2, null);
                if (!startsWith$default2) {
                    startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(str, "sms:", false, 2, null);
                    if (!startsWith$default3) {
                        startsWith$default4 = StringsKt__StringsJVMKt.startsWith$default(str, SmsPlugin.KEY_SYSTEM_SMS_URI, false, 2, null);
                        if (!startsWith$default4) {
                            startsWith$default5 = StringsKt__StringsJVMKt.startsWith$default(str, "weixin://", false, 2, null);
                            if (startsWith$default5 && !(z17 = r0.f141702c)) {
                                if (z17) {
                                    try {
                                        Context context = view.getContext();
                                        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str));
                                        com.tencent.luggage.wxa.fa.b.a(context, intent);
                                        context.startActivity(intent);
                                    } catch (ActivityNotFoundException unused) {
                                        com.tencent.luggage.wxa.h6.d.a((Function0) new j(view));
                                    }
                                } else {
                                    com.tencent.luggage.wxa.h6.d.a((Function0) new k(view));
                                }
                                return true;
                            }
                            if (!URLUtil.isNetworkUrl(str)) {
                                return true;
                            }
                            int a16 = a(this, str, -1, false, 4, (Object) null);
                            if (b(str) && a16 != 2) {
                                return false;
                            }
                            a(str, function2, a16);
                            if (a16 != 0 && a16 != 2 && a16 != 8) {
                                return false;
                            }
                            return true;
                        }
                    }
                    Intent intent2 = new Intent("android.intent.action.SENDTO");
                    intent2.setData(Uri.parse(str));
                    Context context2 = view.getContext();
                    com.tencent.luggage.wxa.fa.b.a(context2, intent2);
                    context2.startActivity(intent2);
                    return true;
                }
                f134167n.invoke(this.f134168a.d(), str, view);
                return true;
            }
            w.h("Luggage.HTMLWebViewUrlCheckLogic", "shouldOverrideUrlLoading found %s", str);
            return true;
        }
        return true;
    }

    public final boolean b(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return this.f134172e.containsKey(f134163j.b(url)) || URLUtil.isAboutUrl(url) || !URLUtil.isNetworkUrl(url);
    }

    public final void b(com.tencent.xweb.WebView view, String str, Function2 function2) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (f134163j.a(str) && c(str)) {
            this.f134169b = str;
        }
    }

    public final void a(Function2 function2) {
        this.f134175h = function2;
    }

    public final void c(com.tencent.xweb.WebView view, String str, Function2 function2) {
        Intrinsics.checkNotNullParameter(view, "view");
        if ((str == null || str.length() == 0) || b(str)) {
            return;
        }
        a(this, str, function2, 0, 4, (Object) null);
    }

    public final void a(String str, Function2 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (f134163j.a(str)) {
            a(str, callback, 0);
        }
    }

    public final void b(com.tencent.xweb.WebView view, String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (c(str)) {
            this.f134169b = str;
        }
    }

    public final void a(com.tencent.xweb.WebView view, String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (c(str)) {
            this.f134169b = str;
        }
    }

    public final void c(String str, Function2 function2, int i3) {
        qg qgVar = new qg();
        qgVar.f128538e = this.f134168a.d();
        qgVar.f128539f = str;
        qgVar.f128541h = this.f134168a.e().ordinal();
        if (i3 == 5) {
            String str2 = this.f134169b;
            if (str2 == null) {
                str2 = this.f134168a.g();
            }
            qgVar.f128540g = str2;
        }
        if (this.f134176i.add(qgVar)) {
            com.tencent.luggage.wxa.n3.g.f135175b.a(this.f134168a.d(), qgVar, rg.class).a(new e(qgVar, str, function2, i3)).a(new f(qgVar, str));
            return;
        }
        w.d("Luggage.HTMLWebViewUrlCheckLogic", "doAsyncCheckUrl url(" + str + ") outerUrl(" + qgVar.f128540g + ") is requested");
    }

    public final void b(String str, Function2 function2, int i3) {
        String d16 = this.f134168a.d();
        if (d16 == null) {
            d16 = "";
        }
        com.tencent.luggage.wxa.m6.k kVar = new com.tencent.luggage.wxa.m6.k();
        kVar.f();
        kVar.f128121m = this.f134168a.c();
        kVar.f128118j = new e9().a(str);
        kVar.f128125q = a(this, str, i3, false, 4, (Object) null);
        kVar.f128127s = 0;
        kVar.f128115g = new e9().a(d16);
        kVar.f128113e = 2;
        kVar.f128134z = this.f134173f;
        if (i3 == 5) {
            String str2 = this.f134169b;
            if (str2 == null) {
                str2 = this.f134168a.g();
            }
            kVar.A = str2;
        }
        Object[] objArr = new Object[8];
        objArr[0] = Integer.valueOf(kVar.f128125q);
        objArr[1] = kVar.f128128t;
        objArr[2] = Integer.valueOf(kVar.f128121m);
        objArr[3] = kVar.f128115g;
        objArr[4] = Integer.valueOf(kVar.f128113e);
        w8 w8Var = kVar.f128134z;
        byte[] f16 = w8Var != null ? w8Var.f() : null;
        if (f16 == null) {
            f16 = new byte[0];
        }
        String a16 = w0.a(f16);
        if (a16 == null) {
            a16 = "null";
        }
        objArr[5] = a16;
        objArr[6] = Integer.valueOf(kVar.f128131w);
        objArr[7] = kVar.f128118j;
        w.d("Luggage.HTMLWebViewUrlCheckLogic", "doAsyncCheckUrlByA8Key: req: reason = [%d], netType = [%s], scene = [%d], appId = [%s], opCode = [%d], cookie = [%s], reqId = [%s], reqUrl = [%s]", objArr);
        int i16 = kVar.f128125q;
        boolean z16 = (i16 == 1 || i16 == 5) ? false : true;
        if (this.f134171d.put(kVar, 0) == null) {
            l lVar = this.f134174g;
            String f17 = kVar.f128118j.f();
            Intrinsics.checkNotNullExpressionValue(f17, "req.ReqUrl.string");
            lVar.a(f17, kVar.f128125q).a(kVar, n2.class).a(new c(kVar, function2, z16)).a(new C6461d(kVar, function2, z16));
            return;
        }
        w.d("Luggage.HTMLWebViewUrlCheckLogic", "doAsyncCheckUrl this url is requested");
    }

    public final void a(com.tencent.xweb.WebView view, String str, Function2 function2) {
        Intrinsics.checkNotNullParameter(view, "view");
        if ((str == null || str.length() == 0) || URLUtil.isAboutUrl(str) || !URLUtil.isNetworkUrl(str) || b(str)) {
            return;
        }
        a(str, function2, 5);
    }

    public static /* synthetic */ void a(d dVar, String str, Function2 function2, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = -1;
        }
        dVar.a(str, function2, i3);
    }

    public final void a(String str, Function2 function2, int i3) {
        if ((str == null || str.length() == 0) || URLUtil.isAboutUrl(str) || !URLUtil.isNetworkUrl(str)) {
            return;
        }
        if (com.tencent.luggage.wxa.o3.l.f136139a.c()) {
            b(str, function2, i3);
        } else {
            c(str, function2, i3);
        }
    }

    public final void a(n2 n2Var, com.tencent.luggage.wxa.m6.k kVar, Function2 function2, boolean z16) {
        if (n2Var == null) {
            this.f134171d.remove(kVar);
            com.tencent.luggage.wxa.zp.h.f146825d.a(new g(function2));
            this.f134168a.a();
            w.f("Luggage.HTMLWebViewUrlCheckLogic", "doAsyncCheckUrlByA8Key: fail:resp is null");
            return;
        }
        this.f134173f = n2Var.f128251y;
        String d16 = w0.d(n2Var.f128231e);
        Intrinsics.checkNotNullExpressionValue(d16, "nullAsNil(resp.FullURL)");
        int length = d16.length() - 1;
        int i3 = 0;
        boolean z17 = false;
        while (i3 <= length) {
            boolean z18 = Intrinsics.compare((int) d16.charAt(!z17 ? i3 : length), 32) <= 0;
            if (z17) {
                if (!z18) {
                    break;
                } else {
                    length--;
                }
            } else if (z18) {
                i3++;
            } else {
                z17 = true;
            }
        }
        String replace = new Regex(" ").replace(d16.subSequence(i3, length + 1).toString(), "%20");
        ConcurrentHashMap concurrentHashMap = this.f134172e;
        b bVar = f134163j;
        concurrentHashMap.put(bVar.b(replace), 1);
        if (!a(n2Var)) {
            this.f134172e.put(bVar.b(a(kVar)), 1);
        }
        Function2 function22 = this.f134175h;
        if (function22 != null) {
            function22.invoke(replace, n2Var);
        }
        com.tencent.luggage.wxa.k6.f fVar = this.f134168a;
        w8 w8Var = n2Var.f128246t;
        Intrinsics.checkNotNullExpressionValue(w8Var, "resp.JSAPIControlBytes");
        fVar.a(replace, w8Var);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("doAsyncCheckUrlByA8Key: resp actionCode = [");
        sb5.append(n2Var.f128233g);
        sb5.append("], (ret, msg) = [");
        sb5.append(n2Var.f128743d.f127731d);
        sb5.append("][");
        sb5.append(n2Var.f128743d.f127732e.f());
        sb5.append("], A8Key = [");
        sb5.append(n2Var.f128232f);
        sb5.append("], cookie = [");
        w8 w8Var2 = n2Var.f128251y;
        sb5.append(w8Var2 != null ? a(w8Var2) : null);
        sb5.append("], fullUrl = [");
        sb5.append(replace);
        sb5.append("], force = [");
        sb5.append(z16);
        sb5.append("], controlBytes = [");
        w8 w8Var3 = n2Var.f128246t;
        Intrinsics.checkNotNullExpressionValue(w8Var3, "resp.JSAPIControlBytes");
        sb5.append(a(w8Var3));
        sb5.append(']');
        w.d("Luggage.HTMLWebViewUrlCheckLogic", sb5.toString());
        if (z16 || a(n2Var)) {
            com.tencent.luggage.wxa.zp.h.f146825d.a(new h(function2, kVar, replace));
        }
    }

    public final String a(w8 w8Var) {
        return w0.a(w8Var.f());
    }

    public final String a(com.tencent.luggage.wxa.m6.k kVar) {
        String f16 = kVar.f128118j.f();
        Intrinsics.checkNotNullExpressionValue(f16, "this.ReqUrl.string");
        return f16;
    }

    public final boolean a(n2 n2Var) {
        h0 e16 = n2Var.e();
        return e16 != null && e16.f127731d == -2005;
    }

    public static /* synthetic */ int a(d dVar, String str, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        return dVar.a(str, i3, z16);
    }

    public final int a(String str, int i3, boolean z16) {
        if (i3 != -1) {
            return i3;
        }
        if (this.f134170c.getAndSet(false)) {
            return 0;
        }
        Matcher matcher = f134164k.matcher(str);
        Intrinsics.checkNotNullExpressionValue(matcher, "weChatRedirectPattern.matcher(url)");
        if (matcher.find()) {
            return 2;
        }
        if (z16) {
            return 1;
        }
        Iterator it = f134165l.iterator();
        while (it.hasNext()) {
            if (com.tencent.luggage.wxa.h6.d.a(str, (String) it.next(), false)) {
                return 8;
            }
        }
        return 1;
    }

    public final void a() {
        this.f134171d.clear();
        this.f134172e.clear();
        this.f134170c.set(true);
        this.f134173f = null;
    }
}
