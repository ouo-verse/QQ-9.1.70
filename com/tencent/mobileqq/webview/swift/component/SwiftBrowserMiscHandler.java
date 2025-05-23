package com.tencent.mobileqq.webview.swift.component;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.ScreenShotUtil;
import com.tencent.mobileqq.vastrash.ColorRingPlayer;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.b;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SwiftBrowserMiscHandler extends b.C8976b implements Handler.Callback {
    static IPatchRedirector $redirector_;
    public Handler C;

    /* renamed from: e, reason: collision with root package name */
    private ViewGroup f314256e;

    /* renamed from: f, reason: collision with root package name */
    private ColorRingPlayer f314257f;

    /* renamed from: h, reason: collision with root package name */
    private QQBrowserActivity f314258h;

    /* renamed from: i, reason: collision with root package name */
    private WebViewProvider f314259i;

    /* renamed from: m, reason: collision with root package name */
    boolean f314260m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SwiftBrowserMiscHandler.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface b {
        void a(String str);
    }

    public SwiftBrowserMiscHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f314256e = null;
        this.f314257f = null;
        this.f314258h = null;
        this.f314259i = null;
        this.f314260m = false;
        this.C = new WeakReferenceHandler(Looper.getMainLooper(), this);
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.C8976b
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else if (this.f314441d.getActivity() instanceof QQBrowserActivity) {
            this.f314258h = (QQBrowserActivity) this.f314441d.getActivity();
            this.f314259i = this.f314441d.getWebViewProvider();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.C8976b
    public void f(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) bundle);
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    ColorRingPlayer colorRingPlayer = this.f314257f;
                    if (colorRingPlayer != null) {
                        colorRingPlayer.k();
                    }
                    if (this.f314260m) {
                        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler.2
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SwiftBrowserMiscHandler.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                com.tencent.mobileqq.filemanager.util.q.e(new File(VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory() + "/tencent/MobileQQ/ShareScreenShots")));
                            }
                        });
                        this.f314260m = false;
                        return;
                    }
                    return;
                }
                return;
            }
            ColorRingPlayer colorRingPlayer2 = this.f314257f;
            if (colorRingPlayer2 != null) {
                colorRingPlayer2.m();
                return;
            }
            return;
        }
        ColorRingPlayer colorRingPlayer3 = this.f314257f;
        if (colorRingPlayer3 != null) {
            colorRingPlayer3.l();
        }
    }

    public void g(int i3, int i16, b bVar) {
        WebViewProvider webViewProvider;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), bVar);
            return;
        }
        if (i3 > 0 && i16 > 0 && (webViewProvider = this.f314259i) != null) {
            CustomWebView webView = webViewProvider.getWebView();
            if (webView == null) {
                if (bVar != null) {
                    bVar.a("");
                    return;
                }
                return;
            }
            ThreadManagerV2.post(new Runnable(ScreenShotUtil.d(webView, i3, i16), bVar) { // from class: com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Bitmap f314261d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ b f314262e;

                {
                    this.f314261d = r8;
                    this.f314262e = bVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, SwiftBrowserMiscHandler.this, r8, bVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (this.f314261d != null) {
                        str = ScreenShotUtil.c(this.f314261d, new File(VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory() + "/tencent/MobileQQ/ShareScreenShots")), "ShareScreenShot_" + System.currentTimeMillis() + ".jpg");
                        SwiftBrowserMiscHandler.this.f314260m = true;
                    } else {
                        str = "";
                    }
                    b bVar2 = this.f314262e;
                    if (bVar2 != null) {
                        bVar2.a(str);
                    }
                }
            }, 8, null, true);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        boolean z16;
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 0) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        return false;
                    }
                    ColorRingPlayer colorRingPlayer = this.f314257f;
                    if (colorRingPlayer != null) {
                        colorRingPlayer.h(((Bundle) message.obj).getString("callbackId"));
                    }
                } else {
                    Bundle bundle = (Bundle) message.obj;
                    ColorRingPlayer colorRingPlayer2 = this.f314257f;
                    if (colorRingPlayer2 != null) {
                        colorRingPlayer2.p(bundle.getLong("id"), bundle.getString("type"), bundle.getInt("status"), bundle.getString("callbackId"));
                    }
                }
            } else {
                WebViewProvider webViewProvider = this.f314259i;
                if (webViewProvider == null || webViewProvider.getComponentProvider() == null) {
                    return false;
                }
                v vVar = (v) this.f314259i.getComponentProvider().a(2);
                if (vVar != null && (viewGroup = vVar.V) != null) {
                    if (this.f314256e == null) {
                        RelativeLayout relativeLayout = (RelativeLayout) viewGroup.findViewById(R.id.ae8);
                        this.f314256e = (ViewGroup) LayoutInflater.from(BaseApplication.getContext()).inflate(R.layout.bbm, (ViewGroup) null);
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                        layoutParams.addRule(12);
                        relativeLayout.addView(this.f314256e, layoutParams);
                        this.f314256e.setOnTouchListener(new a());
                    }
                    if (this.f314257f == null) {
                        this.f314257f = new ColorRingPlayer(this.f314258h, this.f314256e);
                    }
                    this.f314257f.q();
                    Bundle bundle2 = (Bundle) message.obj;
                    this.f314257f.s(bundle2.getLong("id"), bundle2.getString("type"), bundle2.getString("callbackId"));
                }
            }
        } else {
            WebViewProvider webViewProvider2 = this.f314259i;
            if (webViewProvider2 != null) {
                if ((message.arg1 & 2) == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                v vVar2 = (v) webViewProvider2.getComponentProvider().a(2);
                if (z16) {
                    vVar2.C.E.setVisibility(0);
                } else {
                    vVar2.C.E.setVisibility(8);
                }
            }
        }
        return true;
    }
}
