package com.tencent.mobileqq.activity;

import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.home.views.embeddable.WebViewFrameLayoutForegroundService;
import com.tencent.mobileqq.guild.media.thirdapp.container.webview.GuildMediaWebForegroundService;
import com.tencent.mobileqq.log.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.remoteweb.IRemoteRenderService;
import com.tencent.mobileqq.teamwork.app.TDocForegroundService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import cooperation.qqcircle.utils.web.QFSWebForegroundService;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@KeepClassConstructor
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\"\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/activity/PreloadWebService;", "Landroid/app/Service;", "Landroid/content/Intent;", "intent", "", "b", "e", "c", "Landroid/os/IBinder;", "onBind", "onLowMemory", "", WadlProxyConsts.FLAGS, "startId", "onStartCommand", "onTaskRemoved", "level", "onTrimMemory", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/remoteweb/IRemoteRenderService;", "d", "Lcom/tencent/mobileqq/remoteweb/IRemoteRenderService;", "businessService", "Lcom/tencent/biz/pubaccount/CustomWebView;", "Lcom/tencent/biz/pubaccount/CustomWebView;", "mWebView", "<init>", "()V", "f", "a", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class PreloadWebService extends Service {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_remoteweb_service_map.yml", version = 1)
    @NotNull
    private static final HashMap<String, Class<? extends IRemoteRenderService>> f176628h;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IRemoteRenderService businessService;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CustomWebView mWebView;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/activity/PreloadWebService$a;", "", "", "BID", "Ljava/lang/String;", "NEED_OFFLINE", "REMOTE_SERVICE_TYPE_MEDIA_WEB", "TAG", Global.TRACKING_URL, "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.PreloadWebService$a, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/activity/PreloadWebService$b", "Lcom/tencent/biz/common/offline/a;", "", "param1", "", "code", "", "loaded", "progress", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class b implements com.tencent.biz.common.offline.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.biz.common.offline.a
        public void loaded(@NotNull String param1, int code) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) param1, code);
                return;
            }
            Intrinsics.checkNotNullParameter(param1, "param1");
            com.tencent.mobileqq.log.a.f241755a.a().d("PreloadWebService", 1, "offline url loaded code = " + code);
        }

        @Override // com.tencent.biz.common.offline.a
        public void progress(int progress) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, progress);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/activity/PreloadWebService$c", "Lcom/tencent/smtt/sdk/WebViewClient;", "Lcom/tencent/smtt/sdk/WebView;", "view", "", "url", "", "shouldOverrideUrlLoading", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class c extends WebViewClient {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            JsInjector.getInstance().onPageStarted(webView);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(@NotNull WebView view, @NotNull String url) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) url)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            return true;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39294);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        INSTANCE = new Companion(null);
        HashMap<String, Class<? extends IRemoteRenderService>> hashMap = new HashMap<>();
        f176628h = hashMap;
        hashMap.put("tDocService", TDocForegroundService.class);
        hashMap.put("qcircle", QFSWebForegroundService.class);
        hashMap.put("GuildWebViewFrameLayout", WebViewFrameLayoutForegroundService.class);
        hashMap.put("guildMedia", GuildMediaWebForegroundService.class);
    }

    public PreloadWebService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b(Intent intent) {
        String str;
        String stringExtra = intent.getStringExtra("key_remote_service_type");
        String str2 = "";
        if (stringExtra == null) {
            stringExtra = "";
        }
        Class<? extends IRemoteRenderService> cls = f176628h.get(stringExtra);
        IRemoteRenderService iRemoteRenderService = this.businessService;
        if (iRemoteRenderService != null) {
            Intrinsics.checkNotNull(iRemoteRenderService);
            str2 = iRemoteRenderService.getClass().getCanonicalName();
        }
        a.InterfaceC7984a a16 = com.tencent.mobileqq.log.a.f241755a.a();
        if (cls != null) {
            str = cls.getCanonicalName();
        } else {
            str = null;
        }
        a16.d("PreloadWebService", 1, "remoteViewTypeClass " + str + ",  currentServiceClass " + str2);
        if (cls != null) {
            if (!str2.equals(cls.getCanonicalName())) {
                try {
                    Constructor<? extends IRemoteRenderService> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
                    Intrinsics.checkNotNullExpressionValue(declaredConstructor, "remoteServiceClass.getDeclaredConstructor()");
                    declaredConstructor.setAccessible(true);
                    this.businessService = declaredConstructor.newInstance(new Object[0]);
                    return;
                } catch (IllegalAccessException e16) {
                    com.tencent.mobileqq.log.a aVar = com.tencent.mobileqq.log.a.f241755a;
                    a.b bVar = new a.b();
                    String str3 = "IllegalAccessException " + e16;
                    if (str3 instanceof String) {
                        bVar.a().add(str3);
                    }
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        com.tencent.mobileqq.log.a.f241755a.a().e("PreloadWebService", 1, (String) it.next(), e16);
                    }
                    return;
                } catch (InstantiationException e17) {
                    com.tencent.mobileqq.log.a aVar2 = com.tencent.mobileqq.log.a.f241755a;
                    a.b bVar2 = new a.b();
                    String str4 = "InstantiationException " + e17;
                    if (str4 instanceof String) {
                        bVar2.a().add(str4);
                    }
                    Iterator<T> it5 = bVar2.a().iterator();
                    while (it5.hasNext()) {
                        com.tencent.mobileqq.log.a.f241755a.a().e("PreloadWebService", 1, (String) it5.next(), e17);
                    }
                    return;
                } catch (NoSuchMethodException e18) {
                    com.tencent.mobileqq.log.a aVar3 = com.tencent.mobileqq.log.a.f241755a;
                    a.b bVar3 = new a.b();
                    String str5 = "NoSuchMethodException " + e18;
                    if (str5 instanceof String) {
                        bVar3.a().add(str5);
                    }
                    Iterator<T> it6 = bVar3.a().iterator();
                    while (it6.hasNext()) {
                        com.tencent.mobileqq.log.a.f241755a.a().e("PreloadWebService", 1, (String) it6.next(), e18);
                    }
                    return;
                } catch (InvocationTargetException e19) {
                    com.tencent.mobileqq.log.a aVar4 = com.tencent.mobileqq.log.a.f241755a;
                    a.b bVar4 = new a.b();
                    String str6 = "InvocationTargetException " + e19;
                    if (str6 instanceof String) {
                        bVar4.a().add(str6);
                    }
                    Iterator<T> it7 = bVar4.a().iterator();
                    while (it7.hasNext()) {
                        com.tencent.mobileqq.log.a.f241755a.a().e("PreloadWebService", 1, (String) it7.next(), e19);
                    }
                    return;
                }
            }
            return;
        }
        this.businessService = null;
    }

    private final void c(Intent intent) {
        final AppRuntime peekAppRuntime;
        final String stringExtra = intent.getStringExtra("bid");
        if (stringExtra == null) {
            stringExtra = "";
        }
        if (TextUtils.isEmpty(stringExtra) || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.el
            @Override // java.lang.Runnable
            public final void run() {
                PreloadWebService.d(stringExtra, peekAppRuntime);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String bid, AppRuntime runtime) {
        Intrinsics.checkNotNullParameter(bid, "$bid");
        Intrinsics.checkNotNullParameter(runtime, "$runtime");
        com.tencent.mobileqq.log.a.f241755a.a().d("PreloadWebService", 1, "offline url:" + bid);
        HtmlOffline.k(bid, runtime, new b(), true, 0, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0054, code lost:
    
        r5 = kotlin.text.StringsKt__StringsKt.lastIndexOf$default((java.lang.CharSequence) r4, ':', 0, false, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void e(Intent intent) {
        WebSettings webSettings;
        String str;
        int lastIndexOf$default;
        String stringExtra = intent.getStringExtra("url");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        if (intent.getBooleanExtra("need_offline", false)) {
            c(intent);
        }
        if (this.mWebView == null) {
            CustomWebView customWebView = new CustomWebView(getBaseContext());
            this.mWebView = customWebView;
            customWebView.setWebViewClient(new c());
            CustomWebView customWebView2 = this.mWebView;
            if (customWebView2 != null) {
                webSettings = customWebView2.getSettings();
            } else {
                webSettings = null;
            }
            if (webSettings == null) {
                return;
            }
            webSettings.setJavaScriptEnabled(true);
            webSettings.setCacheMode(-1);
            webSettings.setDatabaseEnabled(true);
            String qQProcessName = MobileQQ.getMobileQQ().getQQProcessName();
            if (qQProcessName != null && lastIndexOf$default > -1) {
                String substring = qQProcessName.substring(lastIndexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                str = "_" + substring;
            } else {
                str = "";
            }
            webSettings.setDatabasePath(getApplicationContext().getDir("database" + str, 0).getPath());
            webSettings.setAppCachePath(getApplicationContext().getDir("appcache" + str, 0).getPath());
            webSettings.setAppCacheEnabled(true);
        }
        CustomWebView customWebView3 = this.mWebView;
        if (customWebView3 != null) {
            customWebView3.loadUrl(stringExtra);
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(@Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IBinder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        }
        if (intent == null) {
            return null;
        }
        boolean booleanExtra = intent.getBooleanExtra("key_enable_remote_web_render", false);
        if (booleanExtra) {
            b(intent);
        }
        com.tencent.mobileqq.log.a.f241755a.a().d("PreloadWebService", 1, "bind service isEnableWebRemoteRender " + booleanExtra);
        IRemoteRenderService iRemoteRenderService = this.businessService;
        if (iRemoteRenderService == null) {
            return null;
        }
        return iRemoteRenderService.onBind(this, intent);
    }

    @Override // android.app.Service
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDestroy();
        com.tencent.mobileqq.log.a aVar = com.tencent.mobileqq.log.a.f241755a;
        a.b bVar = new a.b();
        bVar.a().add(" onDestroy");
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.log.a.f241755a.a().e("PreloadWebService", 1, (String) it.next(), null);
        }
        IRemoteRenderService iRemoteRenderService = this.businessService;
        if (iRemoteRenderService != null) {
            iRemoteRenderService.onDestroy(this);
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onLowMemory();
        com.tencent.mobileqq.log.a aVar = com.tencent.mobileqq.log.a.f241755a;
        a.b bVar = new a.b();
        bVar.a().add(" onLowMemory");
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.log.a.f241755a.a().e("PreloadWebService", 1, (String) it.next(), null);
        }
        IRemoteRenderService iRemoteRenderService = this.businessService;
        if (iRemoteRenderService != null) {
            iRemoteRenderService.onLowMemory(this);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, intent, Integer.valueOf(flags), Integer.valueOf(startId))).intValue();
        }
        if (intent == null) {
            return flags;
        }
        if (intent.getBooleanExtra("liveSdkBinding", false)) {
            QLog.e("PreloadWebService", 1, "liveSdkBinding");
            return 2;
        }
        if (intent.getBooleanExtra("isPreloadLiveShopping", false)) {
            return 2;
        }
        boolean booleanExtra = intent.getBooleanExtra("key_enable_remote_web_render", false);
        if (!booleanExtra) {
            e(intent);
        } else {
            b(intent);
        }
        com.tencent.mobileqq.log.a.f241755a.a().d("PreloadWebService", 1, "onStartCommand isEnableWebRemoteRender " + booleanExtra);
        IRemoteRenderService iRemoteRenderService = this.businessService;
        if (iRemoteRenderService == null) {
            return 2;
        }
        return iRemoteRenderService.onStartCommand(this, intent, flags, startId);
    }

    @Override // android.app.Service
    public void onTaskRemoved(@NotNull Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onTaskRemoved(intent);
        com.tencent.mobileqq.log.a aVar = com.tencent.mobileqq.log.a.f241755a;
        a.b bVar = new a.b();
        String str = " onTaskRemoved " + intent;
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.log.a.f241755a.a().e("PreloadWebService", 1, (String) it.next(), null);
        }
        IRemoteRenderService iRemoteRenderService = this.businessService;
        if (iRemoteRenderService != null) {
            iRemoteRenderService.onTaskRemoved(this, intent);
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, level);
            return;
        }
        super.onTrimMemory(level);
        com.tencent.mobileqq.log.a.c(com.tencent.mobileqq.log.a.f241755a, "PreloadWebService", " onTrimMemory " + level, null, 4, null);
        IRemoteRenderService iRemoteRenderService = this.businessService;
        if (iRemoteRenderService != null) {
            iRemoteRenderService.onTrimMemory(this, level);
        }
    }
}
