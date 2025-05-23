package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.tencent.qimei.webview.QmX5Webview;
import com.tencent.qqmini.miniapp.util.DebugUtils;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes23.dex */
public class X5JsCore {

    /* renamed from: a, reason: collision with root package name */
    private static a f369274a;

    /* renamed from: b, reason: collision with root package name */
    private static a f369275b;

    /* renamed from: c, reason: collision with root package name */
    private static a f369276c;

    /* renamed from: d, reason: collision with root package name */
    private final Context f369277d;

    /* renamed from: e, reason: collision with root package name */
    private Object f369278e;

    /* renamed from: f, reason: collision with root package name */
    private WebView f369279f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public enum a {
        UNINITIALIZED,
        UNAVAILABLE,
        AVAILABLE
    }

    static {
        a aVar = a.UNINITIALIZED;
        f369274a = aVar;
        f369275b = aVar;
        f369276c = aVar;
    }

    @Deprecated
    public X5JsCore(Context context) {
        Object a16;
        this.f369278e = null;
        this.f369279f = null;
        this.f369277d = context;
        if (canUseX5JsCore(context) && (a16 = a("createX5JavaBridge", new Class[]{Context.class}, context)) != null) {
            this.f369278e = a16;
            return;
        }
        Log.e("X5JsCore", "X5JsCore create X5JavaBridge failure, use fallback!");
        QmX5Webview qmX5Webview = new QmX5Webview(context);
        this.f369279f = qmX5Webview;
        qmX5Webview.getSettings().setJavaScriptEnabled(true);
    }

    private static Object a(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            p a16 = p.a();
            if (a16 != null && a16.b()) {
                return a16.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", str, clsArr, objArr);
            }
            Log.e("X5JsCore", "X5Jscore#" + str + " - x5CoreEngine is null or is not x5core.");
            return null;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static boolean canUseX5JsCore(Context context) {
        if (f369274a != a.UNINITIALIZED) {
            if (f369274a != a.AVAILABLE) {
                return false;
            }
            return true;
        }
        f369274a = a.UNAVAILABLE;
        Object a16 = a("canUseX5JsCore", new Class[]{Context.class}, context);
        if (a16 == null || !(a16 instanceof Boolean) || !((Boolean) a16).booleanValue()) {
            return false;
        }
        a("setJsValueFactory", new Class[]{Object.class}, JsValue.a());
        f369274a = a.AVAILABLE;
        return true;
    }

    public static boolean canUseX5JsCoreNewAPI(Context context) {
        if (f369276c != a.UNINITIALIZED) {
            if (f369276c != a.AVAILABLE) {
                return false;
            }
            return true;
        }
        f369276c = a.UNAVAILABLE;
        Object a16 = a("canUseX5JsCoreNewAPI", new Class[]{Context.class}, context);
        if (a16 == null || !(a16 instanceof Boolean) || !((Boolean) a16).booleanValue()) {
            return false;
        }
        f369276c = a.AVAILABLE;
        return true;
    }

    public static boolean canX5JsCoreUseNativeBuffer(Context context) {
        Object a16;
        if (f369275b != a.UNINITIALIZED) {
            if (f369275b == a.AVAILABLE) {
                return true;
            }
            return false;
        }
        f369275b = a.UNAVAILABLE;
        if (!canUseX5JsCore(context) || (a16 = a("canX5JsCoreUseBuffer", new Class[]{Context.class}, context)) == null || !(a16 instanceof Boolean) || !((Boolean) a16).booleanValue()) {
            return false;
        }
        f369275b = a.AVAILABLE;
        return true;
    }

    @Deprecated
    public void addJavascriptInterface(Object obj, String str) {
        Object obj2 = this.f369278e;
        if (obj2 != null) {
            a("addJavascriptInterface", new Class[]{Object.class, String.class, Object.class}, obj, str, obj2);
            return;
        }
        WebView webView = this.f369279f;
        if (webView != null) {
            webView.addJavascriptInterface(obj, str);
            this.f369279f.loadUrl("about:blank");
        }
    }

    @Deprecated
    public void destroy() {
        Object obj = this.f369278e;
        if (obj != null) {
            a("destroyX5JsCore", new Class[]{Object.class}, obj);
            this.f369278e = null;
            return;
        }
        WebView webView = this.f369279f;
        if (webView != null) {
            webView.clearHistory();
            this.f369279f.clearCache(true);
            this.f369279f.loadUrl("about:blank");
            this.f369279f.freeMemory();
            this.f369279f.pauseTimers();
            this.f369279f.destroy();
            this.f369279f = null;
        }
    }

    @Deprecated
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        Object obj = this.f369278e;
        if (obj != null) {
            a(DebugUtils.Command.EVALUATE_JAVASCRIPT, new Class[]{String.class, android.webkit.ValueCallback.class, Object.class}, str, valueCallback, obj);
            return;
        }
        WebView webView = this.f369279f;
        if (webView != null) {
            webView.evaluateJavascript(str, valueCallback);
        }
    }

    @Deprecated
    public ByteBuffer getNativeBuffer(int i3) {
        Object a16;
        if (this.f369278e != null && canX5JsCoreUseNativeBuffer(this.f369277d) && (a16 = a("getNativeBuffer", new Class[]{Object.class, Integer.TYPE}, this.f369278e, Integer.valueOf(i3))) != null && (a16 instanceof ByteBuffer)) {
            return (ByteBuffer) a16;
        }
        return null;
    }

    @Deprecated
    public int getNativeBufferId() {
        Object a16;
        if (this.f369278e != null && canX5JsCoreUseNativeBuffer(this.f369277d) && (a16 = a("getNativeBufferId", new Class[]{Object.class}, this.f369278e)) != null && (a16 instanceof Integer)) {
            return ((Integer) a16).intValue();
        }
        return -1;
    }

    @Deprecated
    public void pause() {
        Object obj = this.f369278e;
        if (obj != null) {
            a("pause", new Class[]{Object.class}, obj);
        }
    }

    @Deprecated
    public void pauseTimers() {
        Object obj = this.f369278e;
        if (obj != null) {
            a("pauseTimers", new Class[]{Object.class}, obj);
        }
    }

    @Deprecated
    public void removeJavascriptInterface(String str) {
        Object obj = this.f369278e;
        if (obj != null) {
            a("removeJavascriptInterface", new Class[]{String.class, Object.class}, str, obj);
            return;
        }
        WebView webView = this.f369279f;
        if (webView != null) {
            webView.removeJavascriptInterface(str);
        }
    }

    @Deprecated
    public void resume() {
        Object obj = this.f369278e;
        if (obj != null) {
            a("resume", new Class[]{Object.class}, obj);
        }
    }

    @Deprecated
    public void resumeTimers() {
        Object obj = this.f369278e;
        if (obj != null) {
            a("resumeTimers", new Class[]{Object.class}, obj);
        }
    }

    @Deprecated
    public void setNativeBuffer(int i3, ByteBuffer byteBuffer) {
        if (this.f369278e != null && canX5JsCoreUseNativeBuffer(this.f369277d)) {
            a("setNativeBuffer", new Class[]{Object.class, Integer.TYPE, ByteBuffer.class}, this.f369278e, Integer.valueOf(i3), byteBuffer);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static IX5JsVirtualMachine a(Context context, Looper looper) {
        Object a16;
        if (canUseX5JsCore(context) && (a16 = a("createX5JsVirtualMachine", new Class[]{Context.class, Looper.class}, context, looper)) != null) {
            return (IX5JsVirtualMachine) a16;
        }
        Log.e("X5JsCore", "X5JsCore#createVirtualMachine failure!");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object a() {
        return a("currentContextData", new Class[0], new Object[0]);
    }
}
