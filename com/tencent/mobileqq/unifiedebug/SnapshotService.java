package com.tencent.mobileqq.unifiedebug;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.api.IJsApi;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.util.p;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes19.dex */
public class SnapshotService extends IphoneTitleBarActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: i0, reason: collision with root package name */
    private static String f305709i0;

    /* renamed from: j0, reason: collision with root package name */
    private static boolean f305710j0;

    /* renamed from: k0, reason: collision with root package name */
    public static String f305711k0;

    /* renamed from: a0, reason: collision with root package name */
    private AppInterface f305712a0;

    /* renamed from: b0, reason: collision with root package name */
    private RelativeLayout f305713b0;

    /* renamed from: c0, reason: collision with root package name */
    public Handler f305714c0;

    /* renamed from: d0, reason: collision with root package name */
    private d f305715d0;

    /* renamed from: e0, reason: collision with root package name */
    private d f305716e0;

    /* renamed from: f0, reason: collision with root package name */
    private Queue<b> f305717f0;

    /* renamed from: g0, reason: collision with root package name */
    private long f305718g0;

    /* renamed from: h0, reason: collision with root package name */
    private BroadcastReceiver f305719h0;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SnapshotService.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            long longExtra = intent.getLongExtra("id", -1L);
            int intExtra = intent.getIntExtra("action", -1);
            if (longExtra == 0 && intExtra == 1 && SnapshotService.this.f305718g0 > 0) {
                if (QLog.isColorLevel()) {
                    QLog.i(SnapshotService.f305709i0, 2, "receive broadcast: destroy snapshot service");
                }
                SnapshotService.f305710j0 = false;
                SnapshotService.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f305729a;

        /* renamed from: b, reason: collision with root package name */
        public String f305730b;

        /* renamed from: c, reason: collision with root package name */
        public int f305731c;

        /* renamed from: d, reason: collision with root package name */
        public int f305732d;

        /* renamed from: e, reason: collision with root package name */
        public ArrayList<String> f305733e;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class c extends AbsWebView {
        static IPatchRedirector $redirector_;

        public c(Context context, Activity activity, AppInterface appInterface) {
            super(context, activity, appInterface);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, context, activity, appInterface);
                return;
            }
            super.preInitPluginEngine();
            this.mWebview = new TouchWebView(this.mContext);
            buildBaseWebView(appInterface);
        }

        public void a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            p.b(this.mWebview, p.f314878b);
            this.mUrl = str;
            this.mWebview.loadUrl(str);
        }

        public void b(Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            } else {
                super.doOnCreate(intent);
            }
        }

        @Override // com.tencent.mobileqq.webview.AbsWebView
        public void bindJavaScript(ArrayList<WebViewPlugin> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) arrayList);
            } else if (arrayList != null) {
                arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getWebViewJumpPlugin());
            }
        }

        public void onDestroy() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            } else {
                super.doOnDestroy();
            }
        }

        @Override // com.tencent.mobileqq.webview.AbsWebView
        public void onPageFinished(WebView webView, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) webView, (Object) str);
                return;
            }
            super.onPageFinished(webView, str);
            webView.loadUrl(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.JAVASCRIPT_PREFIX + SnapshotService.f305711k0);
        }

        public void onPause() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                super.doOnPause();
            }
        }

        public void onResume() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                super.doOnResume();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private long f305734a;

        /* renamed from: b, reason: collision with root package name */
        c f305735b;

        /* renamed from: c, reason: collision with root package name */
        ResultReceiver f305736c;

        /* renamed from: d, reason: collision with root package name */
        String f305737d;

        /* renamed from: e, reason: collision with root package name */
        long f305738e;

        /* renamed from: f, reason: collision with root package name */
        long f305739f;

        /* renamed from: g, reason: collision with root package name */
        String f305740g;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SnapshotService.this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77106);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        f305709i0 = "SnapshotService";
        f305710j0 = false;
        f305711k0 = "try{document.querySelectorAll('video,audio').forEach(function(item){item.autoplay=false;item.pause();});[HTMLAudioElement, HTMLVideoElement].forEach(function(i){i.prototype.play=function(){}})}catch(err){console.log(err.message)}";
    }

    public SnapshotService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f305714c0 = new Handler();
            this.f305719h0 = new a();
        }
    }

    private boolean M2(Intent intent) {
        b bVar = new b();
        bVar.f305729a = intent.getLongExtra("seq", -1L);
        bVar.f305730b = intent.getStringExtra("seqKey");
        bVar.f305732d = intent.getIntExtra("maxSnapshotCount", 5);
        bVar.f305731c = 0;
        bVar.f305733e = new ArrayList<>();
        if (QLog.isColorLevel()) {
            QLog.i(f305709i0, 2, "new Command seq=" + bVar.f305729a);
        }
        if (bVar.f305729a == -1) {
            return false;
        }
        synchronized (this.f305717f0) {
            if (this.f305717f0.isEmpty()) {
                this.f305717f0.offer(bVar);
                W2(this.f305715d0);
            } else {
                this.f305717f0.offer(bVar);
            }
        }
        return true;
    }

    private void N2(b bVar, d dVar) {
        int i3;
        if (QLog.isColorLevel()) {
            QLog.i(f305709i0, 2, "finish once debug, webview id =" + dVar.f305734a + ", seq=" + bVar.f305729a);
        }
        if (dVar.f305736c != null) {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("snapshotPaths", bVar.f305733e);
            bundle.putLong("seq", bVar.f305729a);
            bundle.putString("seqKey", bVar.f305730b);
            ResultReceiver resultReceiver = dVar.f305736c;
            if (dVar.f305734a > 0) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            resultReceiver.send(i3, bundle);
        }
        synchronized (this.f305717f0) {
            if (!this.f305717f0.isEmpty()) {
                this.f305717f0.remove();
            }
        }
        if (this.f305718g0 > 0) {
            W2(dVar);
        } else {
            finish();
        }
    }

    private boolean P2(Intent intent, d dVar) {
        dVar.f305734a = intent.getLongExtra("id", -1L);
        dVar.f305736c = (ResultReceiver) intent.getParcelableExtra("callback");
        dVar.f305738e = intent.getLongExtra("delay", 10000L);
        dVar.f305739f = 3000L;
        String stringExtra = intent.getStringExtra("debugUrl");
        dVar.f305737d = stringExtra;
        if (!TextUtils.isEmpty(stringExtra)) {
            dVar.f305740g = dVar.f305734a + MD5Utils.toMD5(dVar.f305737d);
            return true;
        }
        return false;
    }

    public static boolean Q2() {
        return f305710j0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R2(b bVar, d dVar) {
        boolean z16;
        boolean pageDown;
        boolean z17;
        boolean z18 = true;
        if (dVar.f305735b.mWebview.getX5WebViewExtension() != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            int height = dVar.f305735b.mWebview.getHeight();
            if (QLog.isColorLevel()) {
                QLog.i(f305709i0, 2, "webview width =" + dVar.f305735b.mWebview.getWidth() + ", height=" + dVar.f305735b.mWebview.getHeight());
                String str = f305709i0;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("webview scroll height =");
                sb5.append(height);
                QLog.i(str, 2, sb5.toString());
            }
            dVar.f305735b.mWebview.loadUrl("javascript:window.scrollBy(0, " + height + " / window.devicePixelRatio)");
            pageDown = false;
        } else {
            pageDown = dVar.f305735b.mWebview.pageDown(false);
        }
        int i3 = bVar.f305732d;
        if (!z16) {
            i3++;
        }
        int i16 = bVar.f305731c;
        if (i16 < i3) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16) {
            z18 = z17;
        } else if (i16 > 1 && (!pageDown || !z17)) {
            z18 = false;
        }
        if (z18) {
            this.f305714c0.postDelayed(new Runnable(bVar, dVar) { // from class: com.tencent.mobileqq.unifiedebug.SnapshotService.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ b f305726d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ d f305727e;

                {
                    this.f305726d = bVar;
                    this.f305727e = dVar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, SnapshotService.this, bVar, dVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        SnapshotService.this.T2(this.f305726d, this.f305727e);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            }, dVar.f305739f);
        } else {
            N2(bVar, dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S2(Bitmap bitmap, b bVar, d dVar) {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), "/tencent/MobileQQ/unifiedebug");
            if (!file.exists()) {
                file.mkdirs();
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("/Snapshot_");
            sb5.append(dVar.f305740g);
            sb5.append("_");
            int i3 = bVar.f305731c;
            bVar.f305731c = i3 + 1;
            sb5.append(i3);
            sb5.append(".png");
            File file2 = new File(file, sb5.toString());
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            bitmap.recycle();
            bVar.f305733e.add(file2.getAbsolutePath());
            if (QLog.isColorLevel()) {
                QLog.d(f305709i0, 2, "saveSnapshotBitmap file path = " + file2.getAbsolutePath());
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(f305709i0, 2, e16.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T2(b bVar, d dVar) {
        if (dVar.f305735b.mWebview.getWidth() > 0 && dVar.f305735b.mWebview.getHeight() > 0) {
            Bitmap createBitmap = Bitmap.createBitmap(dVar.f305735b.mWebview.getWidth(), dVar.f305735b.mWebview.getHeight(), Bitmap.Config.ARGB_8888);
            if (dVar.f305735b.mWebview.getX5WebViewExtension() != null) {
                if (QLog.isColorLevel()) {
                    QLog.i(f305709i0, 2, "start x5 snapshot");
                }
                U2(createBitmap, bVar, dVar);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i(f305709i0, 2, "start webview snapshot");
            }
            dVar.f305735b.mWebview.draw(new Canvas(createBitmap));
            int i3 = bVar.f305731c;
            if (i3 == 0) {
                bVar.f305731c = i3 + 1;
            } else {
                S2(createBitmap, bVar, dVar);
            }
            R2(bVar, dVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(f305709i0, 2, "webview width =" + dVar.f305735b.mWebview.getWidth() + ", height=" + dVar.f305735b.mWebview.getHeight());
        }
        if (this.f305718g0 > 0 && dVar.f305736c != null) {
            Bundle bundle = new Bundle();
            bundle.putString("debugUrl", dVar.f305737d);
            bundle.putInt("maxCount", bVar.f305732d);
            bundle.putLong("delay", dVar.f305738e);
            bundle.putLong("seq", bVar.f305729a);
            bundle.putString("seqKey", bVar.f305730b);
            dVar.f305736c.send(2, bundle);
            if (QLog.isColorLevel()) {
                QLog.d(f305709i0, 2, "WebView is invalid and send to restart alive webview.");
            }
        }
        finish();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void U2(Bitmap bitmap, b bVar, d dVar) {
        c cVar;
        if (dVar != null && (cVar = dVar.f305735b) != null && cVar.mWebview.getX5WebViewExtension() != null) {
            Class<?>[] interfaces = dVar.f305735b.mWebview.getX5WebViewExtension().getClass().getInterfaces();
            int length = interfaces.length;
            boolean z16 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                Class<?> cls = interfaces[i3];
                if ("com.tencent.smtt.export.internal.interfaces.IX5WebView".equals(cls.getName())) {
                    try {
                        Class<?> cls2 = Boolean.TYPE;
                        Class<?> cls3 = Float.TYPE;
                        Method declaredMethod = cls.getDeclaredMethod("snapshotVisibleWithBitmap", Bitmap.class, cls2, cls2, cls2, cls2, cls3, cls3, Runnable.class);
                        if (QLog.isColorLevel()) {
                            QLog.i(f305709i0, 2, "call snapshotVisibleWithBitmap");
                        }
                        IX5WebViewExtension x5WebViewExtension = dVar.f305735b.mWebview.getX5WebViewExtension();
                        Object[] objArr = new Object[8];
                        objArr[0] = bitmap;
                        Boolean bool = Boolean.TRUE;
                        objArr[1] = bool;
                        objArr[2] = bool;
                        objArr[3] = bool;
                        objArr[4] = bool;
                        objArr[5] = 1;
                        objArr[6] = 1;
                        try {
                            objArr[7] = new Runnable(bitmap, bVar, dVar) { // from class: com.tencent.mobileqq.unifiedebug.SnapshotService.2
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ Bitmap f305722d;

                                /* renamed from: e, reason: collision with root package name */
                                final /* synthetic */ b f305723e;

                                /* renamed from: f, reason: collision with root package name */
                                final /* synthetic */ d f305724f;

                                {
                                    this.f305722d = bitmap;
                                    this.f305723e = bVar;
                                    this.f305724f = dVar;
                                    IPatchRedirector iPatchRedirector = $redirector_;
                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                        iPatchRedirector.redirect((short) 1, this, SnapshotService.this, bitmap, bVar, dVar);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector = $redirector_;
                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                        iPatchRedirector.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    if (QLog.isColorLevel()) {
                                        QLog.i(SnapshotService.f305709i0, 2, "ScreenShot Finish Callback");
                                    }
                                    SnapshotService.this.S2(this.f305722d, this.f305723e, this.f305724f);
                                    SnapshotService.this.f305714c0.post(new Runnable() { // from class: com.tencent.mobileqq.unifiedebug.SnapshotService.2.1
                                        static IPatchRedirector $redirector_;

                                        {
                                            IPatchRedirector iPatchRedirector2 = $redirector_;
                                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                                            }
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            IPatchRedirector iPatchRedirector2 = $redirector_;
                                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                            } else {
                                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                                SnapshotService.this.R2(anonymousClass2.f305723e, anonymousClass2.f305724f);
                                            }
                                        }
                                    });
                                }
                            };
                            declaredMethod.invoke(x5WebViewExtension, objArr);
                            z16 = true;
                        } catch (Exception e16) {
                            e = e16;
                            if (QLog.isColorLevel()) {
                                QLog.i(f305709i0, 2, "call snapshotVisibleWithBitmap failed: " + e.getMessage());
                            }
                            if (z16) {
                            }
                        }
                    } catch (Exception e17) {
                        e = e17;
                    }
                } else {
                    i3++;
                }
            }
            if (z16) {
                if (dVar.f305736c != null) {
                    Bundle bundle = new Bundle();
                    bundle.putLong("seq", bVar.f305729a);
                    dVar.f305736c.send(3, bundle);
                }
                finish();
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(f305709i0, 2, "snapshotVisibleWithBitmap: null");
        }
    }

    private void V2(b bVar, d dVar) {
        this.f305714c0.postDelayed(new Runnable(dVar, bVar) { // from class: com.tencent.mobileqq.unifiedebug.SnapshotService.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ d f305720d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ b f305721e;

            {
                this.f305720d = dVar;
                this.f305721e = bVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, SnapshotService.this, dVar, bVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i(SnapshotService.f305709i0, 2, "start once debug, webview id =" + this.f305720d.f305734a + ", seq=" + this.f305721e.f305729a);
                }
                this.f305720d.f305735b.mWebview.invalidate();
                if (this.f305720d.f305735b.mWebview.getX5WebViewExtension() != null) {
                    this.f305720d.f305735b.mWebview.loadUrl("javascript:window.scrollTo(0, 0);");
                } else {
                    this.f305720d.f305735b.mWebview.pageUp(true);
                }
                SnapshotService.this.T2(this.f305721e, this.f305720d);
            }
        }, dVar.f305738e);
    }

    private void W2(d dVar) {
        if (QLog.isColorLevel()) {
            QLog.i(f305709i0, 2, "mQueue size = " + this.f305717f0.size());
        }
        b peek = this.f305717f0.peek();
        if (peek != null) {
            if (QLog.isColorLevel()) {
                QLog.i(f305709i0, 2, "current cmd=" + peek.f305729a);
            }
            V2(peek, dVar);
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(f305709i0, 2, "in onDestroy method()");
        }
        if (this.f305718g0 > 0) {
            unregisterReceiver(this.f305719h0);
            f305710j0 = false;
        }
        this.f305714c0.removeCallbacksAndMessages(null);
        this.f305717f0.clear();
        super.doOnDestroy();
        d dVar = this.f305715d0;
        if (dVar != null) {
            dVar.f305735b.onDestroy();
        }
        d dVar2 = this.f305716e0;
        if (dVar2 != null) {
            dVar2.f305735b.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.doOnPause();
        d dVar = this.f305715d0;
        if (dVar != null) {
            dVar.f305735b.onPause();
        }
        d dVar2 = this.f305716e0;
        if (dVar2 != null) {
            dVar2.f305735b.onPause();
        }
    }

    @Override // mqq.app.AppActivity
    public String getModuleId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "modular_web";
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        this.f305713b0 = new RelativeLayout(this);
        AppRuntime appRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
        if (appRuntime instanceof AppInterface) {
            this.f305712a0 = (AppInterface) appRuntime;
        }
        if (this.f305712a0 == null) {
            if (QLog.isColorLevel()) {
                QLog.d(f305709i0, 2, "app == null");
            }
            super.finish();
        }
        p.a();
        this.f305717f0 = new LinkedList();
        long longExtra = getIntent().getLongExtra("id", -1L);
        this.f305718g0 = longExtra;
        if (longExtra > 0) {
            this.f305715d0 = new d();
            if (!P2(getIntent(), this.f305715d0)) {
                finish();
            }
            this.f305715d0.f305735b = new c(getBaseContext(), this, this.f305712a0);
            this.f305715d0.f305735b.b(super.getIntent());
            this.f305713b0.addView(this.f305715d0.f305735b.mWebview, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.f305716e0 = new d();
            if (!P2(getIntent(), this.f305716e0)) {
                finish();
            }
            this.f305716e0.f305735b = new c(getBaseContext(), this, this.f305712a0);
            this.f305716e0.f305735b.b(super.getIntent());
            this.f305713b0.addView(this.f305716e0.f305735b.mWebview, new ViewGroup.LayoutParams(-1, -1));
        }
        super.setContentView(this.f305713b0);
        super.moveTaskToBack(true);
        if (QLog.isColorLevel()) {
            QLog.i(f305709i0, 2, "new Command in onCreate");
        }
        if (this.f305718g0 > 0) {
            registerReceiver(this.f305719h0, new IntentFilter("android.intent.action.ultimatesnapshot"));
            if (QLog.isColorLevel()) {
                QLog.i(f305709i0, 2, "registered receiver: android.intent.action.ultimatesnapshot");
            }
            f305710j0 = true;
            d dVar = this.f305715d0;
            dVar.f305735b.a(dVar.f305737d);
            if (!M2(getIntent())) {
                finish();
                return;
            }
            return;
        }
        d dVar2 = this.f305716e0;
        dVar2.f305735b.a(dVar2.f305737d);
        b bVar = new b();
        bVar.f305729a = getIntent().getLongExtra("seq", -1L);
        bVar.f305730b = getIntent().getStringExtra("seqKey");
        bVar.f305732d = getIntent().getIntExtra("maxSnapshotCount", 5);
        bVar.f305731c = 0;
        bVar.f305733e = new ArrayList<>();
        if (QLog.isColorLevel()) {
            QLog.i(f305709i0, 2, "new Command seq=" + bVar.f305729a);
        }
        if (bVar.f305729a != -1) {
            V2(bVar, this.f305716e0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
            return;
        }
        super.onNewIntent(intent);
        setIntent(intent);
        moveTaskToBack(true);
        long longExtra = intent.getLongExtra("id", -1L);
        if (longExtra < 0) {
            if (this.f305716e0 == null) {
                d dVar = new d();
                this.f305716e0 = dVar;
                dVar.f305735b = new c(getBaseContext(), this, this.f305712a0);
                this.f305716e0.f305735b.b(super.getIntent());
                this.f305713b0.addView(this.f305716e0.f305735b.mWebview, new ViewGroup.LayoutParams(-1, -1));
            }
            P2(intent, this.f305716e0);
            b bVar = new b();
            bVar.f305729a = intent.getLongExtra("seq", -1L);
            bVar.f305730b = intent.getStringExtra("seqKey");
            bVar.f305732d = intent.getIntExtra("maxSnapshotCount", 5);
            bVar.f305731c = 0;
            bVar.f305733e = new ArrayList<>();
            if (QLog.isColorLevel()) {
                QLog.i(f305709i0, 2, "new Command in onNewIntent()");
                QLog.i(f305709i0, 2, "new Command seq=" + bVar.f305729a);
            }
            if (bVar.f305729a != -1) {
                d dVar2 = this.f305716e0;
                dVar2.f305735b.a(dVar2.f305737d);
                V2(bVar, this.f305716e0);
                return;
            }
            return;
        }
        if (this.f305715d0 == null) {
            d dVar3 = new d();
            this.f305715d0 = dVar3;
            dVar3.f305735b = new c(getBaseContext(), this, this.f305712a0);
            this.f305715d0.f305735b.b(super.getIntent());
            this.f305713b0.addView(this.f305715d0.f305735b.mWebview, new ViewGroup.LayoutParams(-1, -1));
        }
        int intExtra = intent.getIntExtra("action", 2);
        if (intExtra != 0) {
            if (intExtra == 2) {
                if (QLog.isColorLevel()) {
                    QLog.i(f305709i0, 2, "onNewIntent(), load url");
                }
                if (!f305710j0) {
                    registerReceiver(this.f305719h0, new IntentFilter("android.intent.action.ultimatesnapshot"));
                    if (QLog.isColorLevel()) {
                        QLog.i(f305709i0, 2, "registered receiver: android.intent.action.ultimatesnapshot");
                    }
                }
                f305710j0 = true;
                if (P2(getIntent(), this.f305715d0) && M2(getIntent())) {
                    d dVar4 = this.f305715d0;
                    dVar4.f305735b.a(dVar4.f305737d);
                    this.f305718g0 = longExtra;
                    return;
                }
                return;
            }
            return;
        }
        if (longExtra == this.f305718g0) {
            if (QLog.isColorLevel()) {
                QLog.i(f305709i0, 2, "onNewIntent(), just snapshot for loaded url");
            }
            d dVar5 = this.f305715d0;
            dVar5.f305738e = 1000L;
            dVar5.f305739f = 1000L;
            M2(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onResume();
        d dVar = this.f305715d0;
        if (dVar != null) {
            dVar.f305735b.onResume();
        }
        d dVar2 = this.f305716e0;
        if (dVar2 != null) {
            dVar2.f305735b.onResume();
        }
    }
}
