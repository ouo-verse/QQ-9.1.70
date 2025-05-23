package com.tencent.mobileqq.remoteweb.view;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.remoteweb.RemoteBusinessEvent;
import com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCClient;
import com.tencent.mobileqq.remoteweb.RemoteWebTimeCost;
import com.tencent.mobileqq.remoteweb.RemoteWebViewEvent;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001.\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0001\u001cB!\u0012\b\b\u0002\u0010&\u001a\u00020\f\u0012\u0006\u0010)\u001a\u00020'\u0012\u0006\u0010+\u001a\u00020#\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0016J0\u0010\"\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020 H\u0016J\n\u0010$\u001a\u0004\u0018\u00010#H\u0016R\u0014\u0010&\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010%R\u0016\u0010)\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010(R\u0016\u0010+\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010*R\u0014\u0010-\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010,R\u0014\u00100\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010/R\u001c\u00105\u001a\n 2*\u0004\u0018\u000101018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/remoteweb/view/f;", "Lcom/tencent/mobileqq/remoteweb/view/b;", "", "i", "Landroid/util/DisplayMetrics;", QCircleDaTongConstant.ElementParamValue.XSJ_SHARE_PANEL_STYLE_OLD, QCircleDaTongConstant.ElementParamValue.NEW, "", h.F, "dismiss", "Lcom/tencent/mobileqq/remoteweb/RemoteBusinessEvent;", "type", "Landroid/os/Bundle;", "extraInfo", "d", "Landroid/view/MotionEvent;", "event", "dispatchTouchEvent", "init", "useSystemMetrics", "j", "", "width", "height", "c", "", "url", "urlExtraInfo", "a", "show", "Landroid/view/Surface;", "newSurface", "Lkotlin/Function0;", "callback", "b", "Lcom/tencent/mobileqq/remoteweb/view/BaseRemoteViewPresentation;", "e", "Landroid/os/Bundle;", "extra", "Landroid/hardware/display/VirtualDisplay;", "Landroid/hardware/display/VirtualDisplay;", "display", "Lcom/tencent/mobileqq/remoteweb/view/BaseRemoteViewPresentation;", "presentation", "Ljava/lang/String;", "webPageId", "com/tencent/mobileqq/remoteweb/view/f$b", "Lcom/tencent/mobileqq/remoteweb/view/f$b;", "displayListener", "Landroid/hardware/display/DisplayManager;", "kotlin.jvm.PlatformType", "f", "Landroid/hardware/display/DisplayManager;", "displayManager", "Landroid/os/Handler;", "g", "Landroid/os/Handler;", "handler", "<init>", "(Landroid/os/Bundle;Landroid/hardware/display/VirtualDisplay;Lcom/tencent/mobileqq/remoteweb/view/BaseRemoteViewPresentation;)V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class f implements com.tencent.mobileqq.remoteweb.view.b {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Bundle extra;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private VirtualDisplay display;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private BaseRemoteViewPresentation presentation;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String webPageId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b displayListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final DisplayManager displayManager;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler handler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/remoteweb/view/f$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.remoteweb.view.f$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/remoteweb/view/f$b", "Landroid/hardware/display/DisplayManager$DisplayListener;", "", "displayId", "", "onDisplayAdded", "onDisplayRemoved", "changedDisplayId", "onDisplayChanged", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements DisplayManager.DisplayListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int displayId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, displayId);
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int changedDisplayId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, changedDisplayId);
            } else if (changedDisplayId == f.this.display.getDisplay().getDisplayId()) {
                f.this.i();
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int displayId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, displayId);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39839);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public f(@NotNull Bundle extra, @NotNull VirtualDisplay display, @NotNull BaseRemoteViewPresentation presentation) {
        Intrinsics.checkNotNullParameter(extra, "extra");
        Intrinsics.checkNotNullParameter(display, "display");
        Intrinsics.checkNotNullParameter(presentation, "presentation");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, extra, display, presentation);
            return;
        }
        this.extra = extra;
        this.display = display;
        this.presentation = presentation;
        this.displayListener = new b();
        this.displayManager = (DisplayManager) this.presentation.getContext().getSystemService(DisplayManager.class);
        this.handler = new Handler(Looper.getMainLooper());
        String string = extra.getString("key_web_page_id", "");
        Intrinsics.checkNotNullExpressionValue(string, "extra.getString(RemoteWe\u2026ants.KEY_WEB_PAGE_ID, \"\")");
        this.webPageId = string;
    }

    private final boolean h(DisplayMetrics old, DisplayMetrics r65) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (old.widthPixels != r65.widthPixels || old.heightPixels != r65.heightPixels) {
            return false;
        }
        if (old.density == r65.density) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 || old.densityDpi != r65.densityDpi) {
            return false;
        }
        if (old.xdpi == r65.xdpi) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            return false;
        }
        if (old.ydpi == r65.ydpi) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (!z18) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        com.tencent.mobileqq.log.a aVar = com.tencent.mobileqq.log.a.f241755a;
        aVar.a().d("RemoteWeb.RemoteWebRenderViewWrapper", 1, "[handleDisplayChanged] ");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.presentation.getDisplay().getMetrics(displayMetrics);
        DisplayMetrics currentDM = this.presentation.getContext().getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(currentDM, "currentDM");
        if (h(displayMetrics, currentDM)) {
            return;
        }
        aVar.a().d("RemoteWeb.RemoteWebRenderViewWrapper", 1, "[handleDisplayChanged] displayDM[" + displayMetrics + "], currentDM[" + currentDM + "]");
        j(true);
    }

    @Override // com.tencent.mobileqq.remoteweb.view.b
    public void a(@NotNull String url, @NotNull Bundle urlExtraInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) url, (Object) urlExtraInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(urlExtraInfo, "urlExtraInfo");
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderViewWrapper", 1, "[loadUrl] url " + url);
        RemoteWebRenderIPCClient.Companion companion = RemoteWebRenderIPCClient.INSTANCE;
        companion.a().Z(this.webPageId, RemoteWebTimeCost.BEFORE_LOAD_URL);
        RemoteWebRenderIPCClient.T(companion.a(), this.webPageId, RemoteWebViewEvent.ON_BEFORE_LOAD_URL, null, 4, null);
        this.presentation.n(url, urlExtraInfo);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009a  */
    @Override // com.tencent.mobileqq.remoteweb.view.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(@Nullable Surface newSurface, int width, int height, @NotNull Function0<Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, newSurface, Integer.valueOf(width), Integer.valueOf(height), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderViewWrapper", 1, "[updateSurface] newSurface " + newSurface + " width " + width + ", height " + height);
        if (this.extra.containsKey("key_surface")) {
            Surface surface = (Surface) this.extra.getParcelable("key_surface");
            if (surface != null || newSurface == null) {
                if (surface != null && newSurface == null) {
                    z17 = false;
                    z16 = true;
                }
            }
            this.extra.putParcelable("key_surface", newSurface);
            this.display.setSurface(newSurface);
            if (width > 0 && height > 0) {
                c(width, height);
            }
            if (!z16) {
                this.presentation.o();
            } else if (z17) {
                this.presentation.p();
            }
            callback.invoke();
        }
        z17 = false;
        this.extra.putParcelable("key_surface", newSurface);
        this.display.setSurface(newSurface);
        if (width > 0) {
            c(width, height);
        }
        if (!z16) {
        }
        callback.invoke();
    }

    @Override // com.tencent.mobileqq.remoteweb.view.b
    public void c(int width, int height) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(width), Integer.valueOf(height));
            return;
        }
        com.tencent.mobileqq.log.a aVar = com.tencent.mobileqq.log.a.f241755a;
        aVar.a().d("RemoteWeb.RemoteWebRenderViewWrapper", 1, "[resizeSurface] [" + width + ", " + height + "]");
        int i3 = this.extra.getInt("key_web_view_width");
        if (this.extra.getInt("key_web_view_height") == height && i3 == width) {
            aVar.a().d("RemoteWeb.RemoteWebRenderViewWrapper", 1, "[resizeSurface] size is same!");
            return;
        }
        this.extra.putInt("key_web_view_width", width);
        this.extra.putInt("key_web_view_height", height);
        j(false);
    }

    @Override // com.tencent.mobileqq.remoteweb.view.b
    public void d(@NotNull RemoteBusinessEvent type, @NotNull Bundle extraInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) type, (Object) extraInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        this.presentation.f(type, extraInfo);
    }

    @Override // com.tencent.mobileqq.remoteweb.view.b
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderViewWrapper", 1, "[dismiss] ");
        this.display.setSurface(null);
        this.presentation.d();
        this.display.release();
        this.displayManager.unregisterDisplayListener(this.displayListener);
    }

    @Override // com.tencent.mobileqq.remoteweb.view.b
    public void dispatchTouchEvent(@NotNull MotionEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) event);
        } else {
            Intrinsics.checkNotNullParameter(event, "event");
            this.presentation.dispatchTouchEvent(event);
        }
    }

    @Override // com.tencent.mobileqq.remoteweb.view.b
    @Nullable
    public BaseRemoteViewPresentation e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (BaseRemoteViewPresentation) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.presentation;
    }

    @Override // com.tencent.mobileqq.remoteweb.view.b
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderViewWrapper", 1, "[init] ");
        SwiftWebAccelerator.h().f314720b = true;
        this.presentation.create();
        this.displayManager.registerDisplayListener(this.displayListener, this.handler);
    }

    public void j(boolean useSystemMetrics) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, useSystemMetrics);
            return;
        }
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderViewWrapper", 1, "[reBuildRenderView] useSystemMetrics " + useSystemMetrics);
        View q16 = this.presentation.q();
        dismiss();
        RemoteWebRenderIPCClient.Companion companion = RemoteWebRenderIPCClient.INSTANCE;
        companion.a().Z(this.webPageId, RemoteWebTimeCost.REBUILD_WEB_VIEW);
        this.extra.putLong("key_click_start", System.currentTimeMillis());
        companion.a().N(System.currentTimeMillis());
        Context context = this.presentation.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "presentation.context");
        RemoteRenderViewBuilder remoteRenderViewBuilder = RemoteRenderViewBuilder.f281216a;
        VirtualDisplay b16 = remoteRenderViewBuilder.b(context, this.extra, useSystemMetrics);
        this.display = b16;
        g a16 = remoteRenderViewBuilder.a(context, this.extra, b16);
        this.presentation = a16;
        if (q16 != null) {
            a16.t(q16);
        }
        init();
        String str = "";
        String string = this.extra.getString("key_remote_web_url", "");
        if (string != null) {
            str = string;
        }
        a(str, this.extra);
        show();
    }

    @Override // com.tencent.mobileqq.remoteweb.view.b
    public void show() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderViewWrapper", 1, "[show] ");
        RemoteWebRenderIPCClient.INSTANCE.a().Z(this.webPageId, RemoteWebTimeCost.SHOW_PRESENTATION);
        this.presentation.show();
    }
}
