package com.tencent.luggage.wxa.k6;

import android.webkit.JavascriptInterface;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.xweb.WebView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    public static final a f131667b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final b f131668a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public d(b env) {
        Intrinsics.checkNotNullParameter(env, "env");
        this.f131668a = env;
        b().addJavascriptInterface(this, "WeixinJSCore");
    }

    public final void a(int i3, String str) {
        b().evaluateJavascript("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.invokeCallbackHandler(" + i3 + ", " + w0.b(str, "{}") + ')', null);
    }

    public final WebView b() {
        return this.f131668a.q();
    }

    @JavascriptInterface
    @Nullable
    public final String invokeHandler(@Nullable String str, @Nullable String str2, int i3) {
        boolean z16;
        if (str == null) {
            return "";
        }
        w.a("Luggage.STANDALONE.HTMLWebViewJsBridgeDelegate", "invokeHandler api:" + str + ", data.size:" + w0.d(str2).length() + ", callbackId:" + i3);
        String b16 = this.f131668a.b(str, str2, i3);
        if (b16 != null && b16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            w.a("Luggage.STANDALONE.HTMLWebViewJsBridgeDelegate", "invokeHandler with api:" + str + " callbackId:" + i3 + ", return " + b16);
        }
        return b16;
    }

    public final void a(String str, String str2) {
        if (str == null) {
            return;
        }
        String str3 = "typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler('" + str + "', " + w0.b(str2, "{}") + ')';
        w.a("Luggage.STANDALONE.HTMLWebViewJsBridgeDelegate", "dispatch with script:" + str3);
        b().evaluateJavascript(str3, null);
    }

    public final void a() {
        try {
            b().removeJavascriptInterface("WeixinJSCore");
        } catch (Throwable unused) {
        }
    }
}
