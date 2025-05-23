package com.tencent.luggage.wxa.z5;

import android.os.SystemClock;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.kj.u0;
import com.tencent.luggage.wxa.mc.e;
import com.tencent.luggage.wxa.q5.d;
import com.tencent.luggage.wxa.rc.q;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.xweb.XWebScript;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class b extends u0 {

    /* renamed from: d, reason: collision with root package name */
    public static final a f146337d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f146338e = {"app-wxss.js", "page-frame.html"};

    /* renamed from: c, reason: collision with root package name */
    public final c f146339c;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            String str = d.f137858a.a() + "/page_scripts";
            x.m(str);
            return str;
        }

        public final String a(int i3) {
            return "LIB-v" + i3;
        }

        public final String a(q reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            return a(reader.w());
        }

        public final String a(String appId, int i3) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            return appId + "-v" + i3;
        }
    }

    static {
        com.tencent.luggage.wxa.uk.x.a("//XWEB_SCRIPT:");
        String str = d.f137858a.a() + "/page";
        if (x.d(str)) {
            x.a(str, true);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c renderer) {
        super(renderer);
        Intrinsics.checkNotNullParameter(renderer, "renderer");
        this.f146339c = renderer;
    }

    @Override // com.tencent.luggage.wxa.kj.u0, com.tencent.luggage.wxa.kj.q0
    public final String a(String str) {
        String a16;
        if ((str == null || str.length() == 0) || (a16 = super.a(str)) == null) {
            return null;
        }
        String a17 = a(str, a16);
        if (a17 == null) {
            return a16;
        }
        w.d("Luggage.WXA.MPPageScriptProviderXWebCodeCacheImpl", "provideScript use XWEBScript appId[" + this.f146339c.u() + "] name[" + str + "], path[" + f(a17) + ']');
        XWebScript xWebScript = new XWebScript(3, 0, this.f146339c.b0());
        xWebScript.setJsSrcAsPath(a17, com.tencent.luggage.wxa.uk.x.a());
        xWebScript.setFallBackLogic(a16);
        return xWebScript.toString();
    }

    public final String c(String str) {
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        try {
            String a16 = com.tencent.luggage.wxa.y8.c.a(byteArrayInputStream, 16384);
            Intrinsics.checkNotNullExpressionValue(a16, "getMD5(inputStream, 16*1024)");
            CloseableKt.closeFinally(byteArrayInputStream, null);
            return a16;
        } finally {
        }
    }

    public final String d(String str) {
        v vVar;
        String str2 = null;
        try {
            vVar = new v(str);
        } catch (IOException unused) {
        }
        if (vVar.e() && !vVar.p()) {
            str2 = com.tencent.mm.plugin.appbrand.appcache.a.a(vVar);
            return str2;
        }
        w.b("Luggage.WXA.MPPageScriptProviderXWebCodeCacheImpl", "wxPkg invalid, path = %s ", str);
        return str2;
    }

    public abstract void e(String str);

    public final String f(String str) {
        int lastIndexOf$default;
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) str, '/', 0, false, 6, (Object) null);
        if (lastIndexOf$default > 0) {
            String substring = str.substring(lastIndexOf$default, str.length());
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            return substring;
        }
        return str;
    }

    public final String g(String str) {
        String encode = URLEncoder.encode(str, "UTF-8");
        Intrinsics.checkNotNullExpressionValue(encode, "encode(this, \"UTF-8\")");
        return encode;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01da A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String a(String str, String str2) {
        boolean contains;
        boolean contains2;
        String sb5;
        boolean endsWith$default;
        String str3;
        v[] u16;
        int length;
        int i3;
        v vVar;
        boolean startsWith$default;
        String c16 = c(str2);
        String[] SCRIPTS_LIB_FOR_WEBVIEW = com.tencent.luggage.wxa.m4.c.f134093v;
        Intrinsics.checkNotNullExpressionValue(SCRIPTS_LIB_FOR_WEBVIEW, "SCRIPTS_LIB_FOR_WEBVIEW");
        contains = ArraysKt___ArraysKt.contains(SCRIPTS_LIB_FOR_WEBVIEW, str);
        if (contains) {
            if (!Intrinsics.areEqual(str, "WAWebview.js")) {
                return null;
            }
            StringBuilder sb6 = new StringBuilder();
            a aVar = f146337d;
            sb6.append(aVar.a());
            sb6.append('/');
            q a06 = this.f146339c.a0();
            Intrinsics.checkNotNullExpressionValue(a06, "renderer.libReader");
            sb6.append(aVar.a(a06));
            sb5 = sb6.toString();
            x.m(sb5);
        } else {
            if (!e.a.b(this.f146339c.w().l0())) {
                return null;
            }
            contains2 = ArraysKt___ArraysKt.contains(f146338e, str);
            if (!contains2) {
                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str, "page-frame.js", false, 2, null);
                if (!endsWith$default) {
                    return null;
                }
            }
            StringBuilder sb7 = new StringBuilder();
            a aVar2 = f146337d;
            sb7.append(aVar2.a());
            sb7.append('/');
            String u17 = this.f146339c.u();
            Intrinsics.checkNotNullExpressionValue(u17, "renderer.appId");
            sb7.append(aVar2.a(u17, this.f146339c.Z()));
            sb5 = sb7.toString();
            x.m(sb5);
        }
        String str4 = sb5 + '/' + c16 + '-' + g(str);
        try {
            if (x.d(str4)) {
                String str5 = "check serialized file md5 script[" + str + "] appId[" + this.f146339c.u() + ']';
                long elapsedRealtime = SystemClock.elapsedRealtime();
                String d16 = d(str4);
                StringBuilder sb8 = new StringBuilder();
                sb8.append("runProfiled:");
                sb8.append(str5);
                sb8.append(" cost ");
                str3 = "] appId[";
                sb8.append(SystemClock.elapsedRealtime() - elapsedRealtime);
                sb8.append("ms");
                w.d("Luggage.WXA.MPPageScriptProviderXWebCodeCacheImpl", sb8.toString());
                if (!Intrinsics.areEqual(d16, c16)) {
                }
                u16 = new v(sb5).u();
                if (u16 == null) {
                    u16 = new v[0];
                }
                length = u16.length;
                i3 = 0;
                while (true) {
                    if (i3 < length) {
                        vVar = null;
                        break;
                    }
                    v vVar2 = u16[i3];
                    String g16 = vVar2.g();
                    Intrinsics.checkNotNullExpressionValue(g16, "file.absolutePath");
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(g16, str4 + ".cachedata", false, 2, null);
                    if (startsWith$default) {
                        vVar = vVar2;
                        break;
                    }
                    i3++;
                }
                if (vVar != null) {
                    e(str);
                }
                return str4;
            }
            str3 = "] appId[";
            String str6 = "serialize script[" + str + str3 + this.f146339c.u() + ']';
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            x.c(str4 + ".utf16");
            byte[] bytes = str2.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            x.b(str4, bytes);
            w.d("Luggage.WXA.MPPageScriptProviderXWebCodeCacheImpl", "runProfiled:" + str6 + " cost " + (SystemClock.elapsedRealtime() - elapsedRealtime2) + "ms");
            u16 = new v(sb5).u();
            if (u16 == null) {
            }
            length = u16.length;
            i3 = 0;
            while (true) {
                if (i3 < length) {
                }
                i3++;
            }
            if (vVar != null) {
            }
            return str4;
        } catch (FileNotFoundException e16) {
            w.b("Luggage.WXA.MPPageScriptProviderXWebCodeCacheImpl", "checkScriptSerialized appId[" + this.f146339c.u() + "] scriptName[" + str + "] e=" + e16);
            return null;
        }
    }
}
