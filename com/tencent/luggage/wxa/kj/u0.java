package com.tencent.luggage.wxa.kj;

import android.util.Base64;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.apache.commons.lang.StringUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public class u0 implements q0 {

    /* renamed from: b, reason: collision with root package name */
    public static final a f132426b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.kj.a f132427a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public u0(com.tencent.luggage.wxa.kj.a renderer) {
        Intrinsics.checkNotNullParameter(renderer, "renderer");
        this.f132427a = renderer;
    }

    public final com.tencent.luggage.wxa.c5.e a() {
        return this.f132427a.w();
    }

    @Override // com.tencent.luggage.wxa.kj.q0
    public /* synthetic */ String b(String str) {
        return b31.s.a(this, str);
    }

    @Override // com.tencent.luggage.wxa.kj.q0
    public String a(String str) {
        boolean contains;
        String c16;
        boolean contains2;
        String str2;
        com.tencent.luggage.wxa.j4.g j06;
        if (str == null || str.length() == 0) {
            return null;
        }
        String[] SCRIPTS_LIB_FOR_WEBVIEW = com.tencent.luggage.wxa.m4.c.f134093v;
        Intrinsics.checkNotNullExpressionValue(SCRIPTS_LIB_FOR_WEBVIEW, "SCRIPTS_LIB_FOR_WEBVIEW");
        contains = ArraysKt___ArraysKt.contains(SCRIPTS_LIB_FOR_WEBVIEW, str);
        if (contains) {
            Object a16 = this.f132427a.a(com.tencent.luggage.wxa.rc.q.class);
            Intrinsics.checkNotNull(a16);
            c16 = ((com.tencent.luggage.wxa.rc.q) a16).g(str);
        } else if (Intrinsics.areEqual(str, "app-wxss.js")) {
            com.tencent.luggage.wxa.c5.e a17 = a();
            Intrinsics.checkNotNull(a17);
            c16 = com.tencent.luggage.wxa.mc.k0.c(a17, "app-wxss.js");
        } else if (Intrinsics.areEqual(str, "page-frame.html")) {
            com.tencent.luggage.wxa.c5.e a18 = a();
            Intrinsics.checkNotNull(a18);
            c16 = w.b(com.tencent.luggage.wxa.mc.k0.c(a18, "page-frame.html"));
        } else if (Intrinsics.areEqual(str, this.f132427a.F())) {
            com.tencent.luggage.wxa.c5.e a19 = a();
            Intrinsics.checkNotNull(a19);
            String c17 = com.tencent.luggage.wxa.mc.k0.c(a19, str);
            StringBuilder sb5 = new StringBuilder();
            String style = StringUtils.trim(w.c(c17));
            String page = StringUtils.trim(w.a(c17));
            String b16 = w.b(c17);
            if (!(style == null || style.length() == 0)) {
                sb5.append("var style = document.createElement('style');");
                StringBuilder sb6 = new StringBuilder();
                sb6.append("style.innerHTML = atob(\"");
                Intrinsics.checkNotNullExpressionValue(style, "style");
                byte[] bytes = style.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                sb6.append(Base64.encodeToString(bytes, 2));
                sb6.append("\");");
                sb5.append(sb6.toString());
                sb5.append("document.head.appendChild(style);");
            }
            if (!(page == null || page.length() == 0)) {
                sb5.append("var page = document.createElement('page');");
                StringBuilder sb7 = new StringBuilder();
                sb7.append("page.innerHTML = atob(\"");
                Intrinsics.checkNotNullExpressionValue(page, "page");
                byte[] bytes2 = page.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
                sb7.append(Base64.encodeToString(bytes2, 2));
                sb7.append("\");");
                sb5.append(sb7.toString());
                sb5.append("document.body.appendChild(page);");
            }
            if (!(b16 == null || b16.length() == 0)) {
                sb5.append(b16);
                sb5.append(';');
            }
            c16 = sb5.toString();
        } else {
            c16 = com.tencent.luggage.wxa.mc.k0.c(a(), str);
        }
        StringBuilder sb8 = new StringBuilder();
        sb8.append("provideScript name[");
        sb8.append(str);
        sb8.append("] source.length[");
        sb8.append(c16 != null ? c16.length() : -1);
        sb8.append(']');
        com.tencent.luggage.wxa.tn.w.d("Luggage.WXA.MPPageScriptProviderDefaultImpl", sb8.toString());
        if (c16 == null || c16.length() == 0) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(SCRIPTS_LIB_FOR_WEBVIEW, "SCRIPTS_LIB_FOR_WEBVIEW");
        contains2 = ArraysKt___ArraysKt.contains(SCRIPTS_LIB_FOR_WEBVIEW, str);
        if (contains2) {
            str2 = com.tencent.luggage.wxa.m4.c.f134091t + "lib/" + str;
        } else {
            com.tencent.luggage.wxa.c5.e a26 = a();
            if ((a26 == null || (j06 = a26.j0()) == null || !j06.F) ? false : true) {
                StringBuilder sb9 = new StringBuilder(com.tencent.luggage.wxa.m4.c.f134091t);
                if (a() == null) {
                    sb9.append("preload/");
                } else {
                    com.tencent.luggage.wxa.c5.e a27 = a();
                    Intrinsics.checkNotNull(a27);
                    sb9.append(a27.getAppId());
                    sb9.append("/");
                    com.tencent.luggage.wxa.c5.e a28 = a();
                    Intrinsics.checkNotNull(a28);
                    sb9.append(a28.j0().f125966l.getPkgAppVersion());
                    sb9.append("/");
                }
                sb9.append(str);
                str2 = sb9.toString();
                Intrinsics.checkNotNullExpressionValue(str2, "builder.append(resourceName).toString()");
            } else {
                str2 = "";
            }
        }
        if (str2.length() == 0) {
            return c16;
        }
        return c16 + "\n//# sourceURL=" + com.tencent.luggage.wxa.uk.w.a(str2);
    }
}
