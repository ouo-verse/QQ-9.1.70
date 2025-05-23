package com.qzone.reborn.feedx.widget.homepage;

import android.app.Activity;
import android.content.Intent;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.qzone.common.account.LoginData;
import com.qzone.misc.web.webview.QzoneWebViewPluginManager;
import com.qzone.reborn.feedx.viewmodel.w;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.qzone.util.ar;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.webview.m;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.utils.m;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import s7.b;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneMessageBoardView extends QZoneBaseWidgetView {
    private TouchWebView C;
    private s7.b D;
    private boolean E;
    private boolean F;

    /* renamed from: e, reason: collision with root package name */
    private final LifecycleOwner f56396e;

    /* renamed from: f, reason: collision with root package name */
    private final com.qzone.reborn.feedx.viewmodel.c f56397f;

    /* renamed from: h, reason: collision with root package name */
    private final w f56398h;

    /* renamed from: i, reason: collision with root package name */
    private String f56399i;

    /* renamed from: m, reason: collision with root package name */
    private FrameLayout f56400m;

    public QZoneMessageBoardView(Activity activity, LifecycleOwner lifecycleOwner, com.qzone.reborn.feedx.viewmodel.c cVar) {
        super(activity);
        this.f56399i = "";
        this.E = false;
        setHostActivity(activity);
        this.f56396e = lifecycleOwner;
        this.f56397f = cVar;
        this.f56398h = (w) cVar.W(w.class);
        q0();
    }

    private String p0() {
        String replace = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_USERHOME_MESSAGE_BOARD_URL, QzoneConfig.DefaultValue.USERHOME_MESSAGE_BOARD_URL).replace("{uin}", this.f56398h.F2()).replace("{loginuin}", LoginData.getInstance().getUinString());
        if (QQTheme.isNowThemeIsNightForQzone()) {
            replace = replace + "&darkMode=1";
        }
        String str = ((replace + "&view_height=260.0") + "&density=" + ar.i()) + "&densityDpi=" + ar.j();
        if (QZLog.isColorLevel()) {
            QZLog.i("BaseWidgetView", 2, "message board url:" + str);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        if (!this.E) {
            this.f56400m.setBackgroundResource(R.drawable.f15113i);
            TouchWebView touchWebView = new TouchWebView(BaseApplicationImpl.getApplication());
            this.C = touchWebView;
            touchWebView.setBackgroundColor(getResources().getColor(R.color.qzone_skin_common_page_background_color));
            this.f56400m.addView(this.C, -1, ar.c(260.0f));
            s7.b bVar = new s7.b(getContext(), getHostActivity(), null, QzoneWebViewPluginManager.getInstance().getRuntime(), false);
            this.D = bVar;
            bVar.setWebView(this.C);
            this.D.a(new b.InterfaceC11212b() { // from class: com.qzone.reborn.feedx.widget.homepage.k
                @Override // s7.b.InterfaceC11212b
                public final void onPageFinished() {
                    QZoneMessageBoardView.this.u0();
                }
            });
            new m(this.D).a(null, QzoneWebViewPluginManager.getInstance().getRuntime(), null);
            this.E = true;
            QZLog.i("BaseWidgetView", 1, "MessageBoard WebView init finished");
        }
        w0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0() {
        TouchWebView touchWebView = this.C;
        if (touchWebView == null || touchWebView.getVisibility() == 0) {
            return;
        }
        this.C.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0() {
        TouchWebView touchWebView = this.C;
        if (touchWebView != null) {
            touchWebView.loadUrl(this.f56399i);
        }
    }

    private void w0() {
        TouchWebView touchWebView = this.C;
        if (touchWebView != null) {
            if (!this.F) {
                touchWebView.loadUrl(this.f56399i);
                this.F = true;
            }
            this.f56400m.setVisibility(0);
        }
        pl.a.f426446a.b(this.f56400m);
    }

    private void y0(boolean z16) {
        FrameLayout frameLayout = this.f56400m;
        if (frameLayout == null) {
            QZLog.w("BaseWidgetView", "showMessageBoard mMessageBoardContainer=null");
            return;
        }
        if (z16) {
            if (this.E) {
                return;
            }
            if (!com.tencent.mobileqq.webview.swift.utils.m.e() && !com.qzone.reborn.configx.g.f53821a.b().r0()) {
                com.tencent.mobileqq.webview.swift.utils.m.h(new m.a() { // from class: com.qzone.reborn.feedx.widget.homepage.j
                    @Override // com.tencent.mobileqq.webview.swift.utils.m.a
                    public final void a() {
                        QZoneMessageBoardView.this.s0();
                    }
                });
                return;
            } else {
                s0();
                return;
            }
        }
        frameLayout.setVisibility(8);
    }

    public void A0() {
        if (this.C != null) {
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.feedx.widget.homepage.i
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneMessageBoardView.this.v0();
                }
            }, 500L);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cob;
    }

    public void onDestroy() {
        TouchWebView touchWebView;
        if (this.D == null || (touchWebView = this.C) == null) {
            return;
        }
        com.tencent.open.appcommon.js.d.b(touchWebView);
        FrameLayout frameLayout = this.f56400m;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.D.onDestroy();
        this.C = null;
        this.D = null;
        if (com.qzone.reborn.configx.g.f53821a.b().W1()) {
            AuthorizeConfig.y().t0();
        }
    }

    public void q0() {
        this.f56399i = p0();
        r0();
        this.f56398h.C2().observe(this.f56396e, new Observer() { // from class: com.qzone.reborn.feedx.widget.homepage.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneMessageBoardView.this.z0((x6.a) obj);
            }
        });
    }

    public void x0(int i3, int i16, Intent intent) {
        WebViewPluginEngine pluginEngine;
        WebViewPlugin m3;
        TouchWebView touchWebView = this.C;
        if (touchWebView == null || (pluginEngine = touchWebView.getPluginEngine()) == null || (m3 = pluginEngine.m("Qzone")) == null) {
            return;
        }
        QZLog.i("BaseWidgetView", 2, "MessageBoardPanel call onActivityResult for WebViewPlugin:Qzone");
        m3.onActivityResult(intent, (byte) i3, i16);
    }

    public void z0(x6.a aVar) {
        if (aVar != null) {
            try {
                y0(aVar.isOpenMsgBoard && com.qzone.reborn.feedx.util.k.G(aVar));
            } catch (Throwable th5) {
                FrameLayout frameLayout = this.f56400m;
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                }
                RFWLog.fatal("BaseWidgetView", RFWLog.USR, th5);
            }
        }
    }

    private void r0() {
        this.f56400m = (FrameLayout) findViewById(R.id.ncp);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
    }
}
