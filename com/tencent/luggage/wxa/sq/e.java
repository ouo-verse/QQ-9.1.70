package com.tencent.luggage.wxa.sq;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import com.tencent.luggage.wxa.ar.g0;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.wq.q;
import com.tencent.xweb.CommandCfg;
import com.tencent.xweb.WebView;
import com.tencent.xweb.internal.ConstValue;
import com.tencent.xweb.pinus.PSContextWrapper;
import com.tencent.xweb.pinus.PSCoreWrapper;
import com.tencent.xweb.pinus.PinusStandAloneChannel;
import com.tencent.xweb.xwalk.plugin.XWalkPlugin;
import com.tencent.xweb.xwalk.plugin.XWalkPluginManager;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ boolean f140700a = true;

    public static com.tencent.luggage.wxa.sq.a a(WebView.WebViewKind webViewKind, Context context, WebView webView, View view, String str) {
        a a16;
        boolean fullscreenVideoEnableSysTryRuntime = webViewKind == WebView.WebViewKind.WV_KIND_SYS ? CommandCfg.getInstance().getFullscreenVideoEnableSysTryRuntime() : true;
        x0.d("XWebNativeInterfaceFactory", "createXWebNativeInterface, webCoreType:" + webViewKind + ", tryRuntimeVideoNativeInterface:" + fullscreenVideoEnableSysTryRuntime);
        if (fullscreenVideoEnableSysTryRuntime) {
            if (PSCoreWrapper.getInstance() != null) {
                a16 = b(context, webView, view, str);
            } else {
                a16 = a(context, webView, view, str);
            }
            if (a16 != null) {
                x0.d("XWebNativeInterfaceFactory", "createXWebNativeInterface, use [runtime] class XWebNativeInterfaceInternal");
                q.a(webViewKind, 2, 1, false, null);
                return a16;
            }
        }
        x0.d("XWebNativeInterfaceFactory", "createXWebNativeInterface, use [sdk] class XWebNativeInterface");
        d dVar = new d();
        dVar.a(null, webView, view, view.getContext(), str);
        dVar.a(a());
        n0.a(1749L, 15L, 1L);
        q.a(webViewKind, 1, 1, fullscreenVideoEnableSysTryRuntime, null);
        return dVar;
    }

    public static a b(Context context, WebView webView, View view, String str) {
        Class<?> cls;
        try {
            if (!f140700a && PSCoreWrapper.getInstance() == null) {
                throw new AssertionError();
            }
            cls = PSCoreWrapper.getInstance().getClass("org.xwalk.core.internal.videofullscreen.XWebNativeInterfaceInternal");
        } catch (Throwable th5) {
            x0.c("XWebNativeInterfaceFactory", "createXWebNativeInterfaceByPinus, error:" + Log.getStackTraceString(th5));
        }
        if (cls != null) {
            x0.d("XWebNativeInterfaceFactory", "createXWebNativeInterfaceByPinus, try use [runtime] class XWebNativeInterfaceInternal");
            if (!(context instanceof PSContextWrapper)) {
                context = new PSContextWrapper(webView.getContext(), XWalkEnvironment.getAvailableVersion());
            }
            Context context2 = context;
            a aVar = new a(cls.newInstance());
            try {
                aVar.a(null, webView, view, context2, str);
                aVar.a(a());
                n0.a(1749L, 18L, 1L);
                return aVar;
            } catch (Exception e16) {
                x0.a("XWebNativeInterfaceFactory", "createXWebNativeInterfaceByPinus, init interface error", e16);
                n0.a(1749L, 65L, 1L);
                return null;
            }
        }
        x0.d("XWebNativeInterfaceFactory", "createXWebNativeInterfaceByPinus, try use runtime class XWebNativeInterfaceInternal but bot found");
        return null;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements com.tencent.luggage.wxa.sq.a {

        /* renamed from: a, reason: collision with root package name */
        public final g0 f140701a;

        /* renamed from: b, reason: collision with root package name */
        public final g0 f140702b;

        /* renamed from: c, reason: collision with root package name */
        public final g0 f140703c;

        /* renamed from: d, reason: collision with root package name */
        public final g0 f140704d;

        /* renamed from: e, reason: collision with root package name */
        public final g0 f140705e;

        /* renamed from: f, reason: collision with root package name */
        public final g0 f140706f;

        /* renamed from: g, reason: collision with root package name */
        public final g0 f140707g;

        /* renamed from: h, reason: collision with root package name */
        public final g0 f140708h;

        /* renamed from: i, reason: collision with root package name */
        public final g0 f140709i;

        /* renamed from: j, reason: collision with root package name */
        public final g0 f140710j;

        /* renamed from: k, reason: collision with root package name */
        public final g0 f140711k;

        /* renamed from: l, reason: collision with root package name */
        public final g0 f140712l;

        /* renamed from: m, reason: collision with root package name */
        public final g0 f140713m;

        /* renamed from: n, reason: collision with root package name */
        public final g0 f140714n;

        /* renamed from: o, reason: collision with root package name */
        public final g0 f140715o;

        /* renamed from: p, reason: collision with root package name */
        public final g0 f140716p;

        /* renamed from: q, reason: collision with root package name */
        public final g0 f140717q;

        /* renamed from: r, reason: collision with root package name */
        public final Object f140718r;

        public a(Object obj) {
            this.f140718r = obj;
            this.f140701a = new g0(obj, "init", Activity.class, View.class, View.class, Context.class, String.class);
            this.f140702b = new g0(obj, "initConfigs", Bundle.class);
            Class cls = Boolean.TYPE;
            this.f140703c = new g0(obj, "evaluteJavascript", cls, cls);
            this.f140704d = new g0(obj, "onShowCustomView", View.class, WebChromeClient.CustomViewCallback.class);
            this.f140705e = new g0(obj, "onHideCustomView", new Class[0]);
            this.f140706f = new g0(obj, "hasEnteredFullscreen", new Class[0]);
            this.f140707g = new g0(obj, "registerJavascriptInterface", Object.class);
            this.f140708h = new g0(obj, "disableJsCallback", cls);
            this.f140709i = new g0(obj, "setVideoJsCallback", Object.class);
            this.f140712l = new g0(obj, "videoChangeStatus", new Class[0]);
            this.f140710j = new g0(obj, "videoPlay", new Class[0]);
            this.f140711k = new g0(obj, "videoPause", new Class[0]);
            this.f140713m = new g0(obj, "videoSeek", Double.TYPE);
            this.f140714n = new g0(obj, "videoMute", cls);
            this.f140715o = new g0(obj, "videoPlaybackRate", Double.TYPE);
            this.f140716p = new g0(obj, "videoExitFullscreen", new Class[0]);
            this.f140717q = new g0(obj, "supportSetRequestedOrientationCallback", new Class[0]);
        }

        public void a(Activity activity, View view, View view2, Context context, String str) {
            try {
                this.f140701a.a(activity, view, view2, context, str);
            } catch (Throwable th5) {
                x0.c("VideoNativeInterfaceRuntime", "init error:" + th5);
                throw new Exception(th5);
            }
        }

        @Override // com.tencent.luggage.wxa.sq.a
        public void b(Object obj) {
            try {
                this.f140707g.a(obj);
            } catch (Throwable th5) {
                x0.c("VideoNativeInterfaceRuntime", "registerJavascriptInterface error:" + th5);
            }
        }

        @Override // com.tencent.xweb.VideoControl
        public boolean supportSetRequestedOrientationCallback() {
            try {
                return ((Boolean) this.f140717q.a(new Object[0])).booleanValue();
            } catch (Throwable th5) {
                x0.d("VideoNativeInterfaceRuntime", "supportSetRequestedOrientationCallback invoke error:" + th5);
                return false;
            }
        }

        @Override // com.tencent.xweb.VideoControl
        public void videoChangeStatus() {
            try {
                this.f140712l.a(new Object[0]);
            } catch (Throwable th5) {
                x0.d("VideoNativeInterfaceRuntime", "videoChangeStatus invoke error:" + th5);
            }
        }

        @Override // com.tencent.xweb.VideoControl
        public void videoExitFullscreen() {
            try {
                this.f140716p.a(new Object[0]);
            } catch (Throwable th5) {
                x0.d("VideoNativeInterfaceRuntime", "videoExitFullscreenMethod invoke error:" + th5);
            }
        }

        @Override // com.tencent.xweb.VideoControl
        public void videoMute(boolean z16) {
            try {
                this.f140714n.a(Boolean.valueOf(z16));
            } catch (Throwable th5) {
                x0.d("VideoNativeInterfaceRuntime", "videoMute invoke error:" + th5);
            }
        }

        @Override // com.tencent.xweb.VideoControl
        public void videoPause() {
            try {
                this.f140711k.a(new Object[0]);
            } catch (Throwable th5) {
                x0.d("VideoNativeInterfaceRuntime", "videoPause invoke error:" + th5);
            }
        }

        @Override // com.tencent.xweb.VideoControl
        public void videoPlay() {
            try {
                this.f140710j.a(new Object[0]);
            } catch (Throwable th5) {
                x0.d("VideoNativeInterfaceRuntime", "videoPlay invoke error:" + th5);
            }
        }

        @Override // com.tencent.xweb.VideoControl
        public void videoPlaybackRate(double d16) {
            try {
                this.f140715o.a(Double.valueOf(d16));
            } catch (Throwable th5) {
                x0.d("VideoNativeInterfaceRuntime", "videoPlaybackRate invoke error:" + th5);
            }
        }

        @Override // com.tencent.xweb.VideoControl
        public void videoSeek(double d16) {
            try {
                this.f140713m.a(Double.valueOf(d16));
            } catch (Throwable th5) {
                x0.d("VideoNativeInterfaceRuntime", "videoSeek invoke error:" + th5);
            }
        }

        public void a(Bundle bundle) {
            try {
                this.f140702b.a(bundle);
            } catch (Throwable th5) {
                x0.a("VideoNativeInterfaceRuntime", "initConfigs error", th5);
            }
        }

        @Override // com.tencent.luggage.wxa.sq.a
        public void a(boolean z16, boolean z17) {
            try {
                this.f140703c.a(Boolean.valueOf(z16), Boolean.valueOf(z17));
            } catch (Throwable th5) {
                x0.c("VideoNativeInterfaceRuntime", "evaluteJavascript error:" + th5);
            }
        }

        @Override // com.tencent.luggage.wxa.sq.a
        public void a(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            try {
                this.f140704d.a(view, customViewCallback);
            } catch (Throwable th5) {
                x0.c("VideoNativeInterfaceRuntime", "onShowCustomView error:" + th5);
            }
        }

        @Override // com.tencent.luggage.wxa.sq.a
        public void a(boolean z16) {
            try {
                this.f140708h.a(Boolean.valueOf(z16));
            } catch (Throwable th5) {
                x0.c("VideoNativeInterfaceRuntime", "disableJsCallback error:" + th5);
            }
        }

        @Override // com.tencent.luggage.wxa.sq.a
        public void a() {
            try {
                this.f140705e.a(new Object[0]);
            } catch (Throwable th5) {
                x0.c("VideoNativeInterfaceRuntime", "onHideCustomView error:" + th5);
            }
        }

        @Override // com.tencent.luggage.wxa.sq.a
        public boolean a(Object obj) {
            XWalkPlugin plugin = XWalkPluginManager.getPlugin(XWalkPluginManager.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO);
            if (plugin == null || plugin.getAvailableVersion() < 10) {
                if (plugin != null) {
                    x0.d("VideoNativeInterfaceRuntime", "setVideoJsCallback return false, fullScreenVideoPlugin is not available, version:" + plugin.getAvailableVersion());
                } else {
                    x0.d("VideoNativeInterfaceRuntime", "setVideoJsCallback return false, fullScreenVideoPlugin is not available");
                }
                return false;
            }
            try {
                return ((Boolean) this.f140709i.a(obj)).booleanValue();
            } catch (Throwable th5) {
                x0.d("VideoNativeInterfaceRuntime", "setVideoJsCallback invoke error:" + th5);
                return false;
            }
        }
    }

    public static a a(Context context, WebView webView, View view, String str) {
        ClassLoader classLoader;
        if (XWalkEnvironment.getAvailableVersion() != 2852 && XWalkEnvironment.getAvailableVersion() != 2853) {
            boolean isPinusWebViewCoreFromAvailableVersion = XWalkEnvironment.isPinusWebViewCoreFromAvailableVersion();
            x0.d("XWebNativeInterfaceFactory", "createXWebNativeInterfaceByOthers, get class by sys");
            if (XWalkEnvironment.getInitConfig(ConstValue.INIT_CONFIG_KEY_ISGPVERSION, false)) {
                x0.c("XWebNativeInterfaceFactory", "createXWebNativeInterfaceByOthers, gpversion can not load dex");
                return null;
            }
            if (isPinusWebViewCoreFromAvailableVersion) {
                try {
                    classLoader = PinusStandAloneChannel.getInstance().getClassLoader();
                } catch (ClassNotFoundException e16) {
                    x0.a("XWebNativeInterfaceFactory", "createXWebNativeInterfaceByOthers, class not found, error", e16);
                    return null;
                }
            } else {
                classLoader = null;
            }
            if (classLoader != null) {
                Class<?> loadClass = classLoader.loadClass("org.xwalk.core.internal.videofullscreen.XWebNativeInterfaceInternal");
                try {
                    if (loadClass != null) {
                        x0.d("XWebNativeInterfaceFactory", "createXWebNativeInterfaceByOthers, try use [runtime] class XWebNativeInterfaceInternal");
                        if (PinusStandAloneChannel.getInstance().initChannels(true, CommandCfg.getInstance().getFullscreenVideoEnableInitChannelsTryRuntime())) {
                            boolean z16 = context instanceof PSContextWrapper;
                            Context context2 = context;
                            if (!z16) {
                                PSContextWrapper pSContextWrapper = new PSContextWrapper(webView.getContext(), XWalkEnvironment.getAvailableVersion());
                                pSContextWrapper.setClassLoader(classLoader);
                                context2 = pSContextWrapper;
                            }
                            return a(context2, webView, view, str, loadClass);
                        }
                        x0.d("XWebNativeInterfaceFactory", "createXWebNativeInterfaceByOthers, init pinus standalone channel failed");
                        n0.a(1749L, 19L, 1L);
                    } else {
                        x0.d("XWebNativeInterfaceFactory", "createXWebNativeInterfaceByOthers, try use runtime class XWebNativeInterfaceInternal but bot found");
                    }
                } catch (Throwable th5) {
                    x0.c("XWebNativeInterfaceFactory", "createXWebNativeInterfaceByOthers, error:" + Log.getStackTraceString(th5));
                }
                return null;
            }
            x0.c("XWebNativeInterfaceFactory", "createXWebNativeInterfaceByOthers, classloader is null");
            return null;
        }
        x0.d("XWebNativeInterfaceFactory", "createXWebNativeInterfaceByOthers, ignore because of runtime bug");
        return null;
    }

    public static a a(Context context, WebView webView, View view, String str, Class cls) {
        a aVar = new a(cls.newInstance());
        try {
            aVar.a(null, webView, view, context, str);
            aVar.a(a());
            n0.a(1749L, 16L, 1L);
            return aVar;
        } catch (Exception e16) {
            x0.a("XWebNativeInterfaceFactory", "createXWebNativeInterfaceByOthers, init interface error", e16);
            n0.a(1749L, 63L, 1L);
            return null;
        }
    }

    public static Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("fullscreen_video_enable_mute", CommandCfg.getInstance().getFullscreenVideoEnableMute());
        bundle.putBoolean("fullscreen_video_enable_speed", CommandCfg.getInstance().getFullscreenVideoEnableSpeed());
        return bundle;
    }
}
