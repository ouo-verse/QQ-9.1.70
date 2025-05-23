package com.tencent.mobileqq.remoteweb.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.log.a;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.remoteweb.RemoteBusinessEvent;
import com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCClient;
import com.tencent.mobileqq.remoteweb.RemoteWebTimeCost;
import com.tencent.mobileqq.remoteweb.RemoteWebViewEvent;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.IntSpreadBuilder;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 L2\u00020\u0001:\u0001MB!\u0012\u0006\u0010G\u001a\u00020F\u0012\u0006\u0010I\u001a\u00020H\u0012\b\b\u0002\u0010#\u001a\u00020\u0014\u00a2\u0006\u0004\bJ\u0010KJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\fH\u0016J\u0018\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0014H\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u001f\u001a\u00020\nH\u0016J\u0010\u0010 \u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010#\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R$\u0010)\u001a\u0004\u0018\u00010\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u00100\u001a\u0004\u0018\u00010\u00068\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00107\u001a\u00020\b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010;\u001a\u00020\b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b8\u00102\u001a\u0004\b9\u00104\"\u0004\b:\u00106R$\u0010B\u001a\u0004\u0018\u00010\u00198\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010E\u001a\u00020\u00198\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bC\u0010=\u001a\u0004\bD\u0010?\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/remoteweb/view/g;", "Lcom/tencent/mobileqq/remoteweb/view/BaseRemoteViewPresentation;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/biz/ui/TouchWebView;", "webView", "Lcom/tencent/mobileqq/remoteweb/view/e;", "B", "", "isVisible", "", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "containerView", "c", "o", "p", "d", "Lcom/tencent/mobileqq/remoteweb/RemoteBusinessEvent;", "type", "Landroid/os/Bundle;", "extraInfo", "f", "view", "r", "", "url", "urlExtraInfo", DomainData.DOMAIN_NAME, "u", "v", "w", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "Lcom/tencent/biz/ui/TouchWebView;", "y", "()Lcom/tencent/biz/ui/TouchWebView;", "setMWebView", "(Lcom/tencent/biz/ui/TouchWebView;)V", "mWebView", "D", "Lcom/tencent/mobileqq/remoteweb/view/e;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Lcom/tencent/mobileqq/remoteweb/view/e;", "setMWebViewBuilder", "(Lcom/tencent/mobileqq/remoteweb/view/e;)V", "mWebViewBuilder", "E", "Z", "getMIsDestroy", "()Z", "setMIsDestroy", "(Z)V", "mIsDestroy", UserInfo.SEX_FEMALE, "getMIsReuse", "setMIsReuse", "mIsReuse", "G", "Ljava/lang/String;", "getMUrl", "()Ljava/lang/String;", "setMUrl", "(Ljava/lang/String;)V", "mUrl", "H", HippyTKDListViewAdapter.X, "mWebPageId", "Landroid/content/Context;", "context", "Landroid/view/Display;", "display", "<init>", "(Landroid/content/Context;Landroid/view/Display;Landroid/os/Bundle;)V", "I", "a", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public class g extends BaseRemoteViewPresentation {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TouchWebView mWebView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private e mWebViewBuilder;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mIsDestroy;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mIsReuse;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private String mUrl;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final String mWebPageId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Bundle extraData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/remoteweb/view/g$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.remoteweb.view.g$a, reason: from kotlin metadata */
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
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f281233a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39858);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[RemoteBusinessEvent.values().length];
            try {
                iArr[RemoteBusinessEvent.ON_PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RemoteBusinessEvent.ON_RESUME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f281233a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J2\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/remoteweb/view/g$c", "Lcom/tencent/biz/ui/TouchWebView$OnScrollChangedListener;", "", "arg0", "arg1", "arg2", "arg3", "Landroid/view/View;", "arg4", "", "onScrollChanged", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c implements TouchWebView.OnScrollChangedListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TouchWebView f281234a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f281235b;

        c(TouchWebView touchWebView, g gVar) {
            this.f281234a = touchWebView;
            this.f281235b = gVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) touchWebView, (Object) gVar);
            }
        }

        @Override // com.tencent.biz.ui.TouchWebView.OnScrollChangedListener
        public void onScrollChanged(int arg0, int arg1, int arg2, int arg3, @Nullable View arg4) {
            int[] intArray;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(arg0), Integer.valueOf(arg1), Integer.valueOf(arg2), Integer.valueOf(arg3), arg4);
                return;
            }
            boolean[] zArr = {this.f281234a.canScrollVertically(-1), this.f281234a.canScrollVertically(1), this.f281234a.canScrollHorizontally(-1), this.f281234a.canScrollHorizontally(1)};
            ArrayList arrayList = new ArrayList(4);
            for (int i3 = 0; i3 < 4; i3++) {
                arrayList.add(Integer.valueOf(zArr[i3] ? 1 : 0));
            }
            intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList);
            com.tencent.mobileqq.log.a aVar = com.tencent.mobileqq.log.a.f241755a;
            if (QLog.isDevelopLevel()) {
                String arrays = Arrays.toString(intArray);
                Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
                Log.d("RemoteWeb.WebViewPresentation", "onScrollChanged " + arg0 + " " + arg1 + " " + arg2 + " " + arg3 + " " + arg4 + " " + arrays);
            }
            RemoteWebRenderIPCClient a16 = RemoteWebRenderIPCClient.INSTANCE.a();
            String x16 = this.f281235b.x();
            RemoteWebViewEvent remoteWebViewEvent = RemoteWebViewEvent.ON_PAGE_SCROLL_EVENT;
            Bundle bundle = new Bundle();
            IntSpreadBuilder intSpreadBuilder = new IntSpreadBuilder(5);
            intSpreadBuilder.add(arg0);
            intSpreadBuilder.add(arg1);
            intSpreadBuilder.add(arg2);
            intSpreadBuilder.add(arg3);
            intSpreadBuilder.addSpread(intArray);
            bundle.putIntArray(RemoteWebViewEvent.SCROLL_VALUES, intSpreadBuilder.toArray());
            Unit unit = Unit.INSTANCE;
            a16.S(x16, remoteWebViewEvent, bundle);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39877);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ g(Context context, Display display, Bundle bundle, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, display, (i3 & 4) != 0 ? new Bundle() : bundle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, display, bundle, Integer.valueOf(i3), defaultConstructorMarker);
    }

    private final e B(Activity activity, TouchWebView webView) {
        return v(activity, webView);
    }

    private final void C(boolean isVisible) {
        if (this.mWebView == null) {
            return;
        }
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.WebViewPresentation", 1, "[notifyWebVisible] isVisible " + isVisible);
        TouchWebView touchWebView = this.mWebView;
        if (touchWebView != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("~function(d,e){try{e=d.createEvent('Event');e.initEvent('qbrowserVisibilityChange');e.hidden=");
            sb5.append(!isVisible);
            sb5.append(";d.dispatchEvent(e)}catch(err){}}(document);");
            touchWebView.callJs(sb5.toString());
        }
        if (isVisible) {
            TouchWebView touchWebView2 = this.mWebView;
            if (touchWebView2 != null) {
                touchWebView2.onResume();
                return;
            }
            return;
        }
        TouchWebView touchWebView3 = this.mWebView;
        if (touchWebView3 != null) {
            touchWebView3.onPause();
        }
    }

    public void A(@NotNull TouchWebView webView) {
        QQTranslucentBrowserActivity qQTranslucentBrowserActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) webView);
            return;
        }
        Intrinsics.checkNotNullParameter(webView, "webView");
        Activity b16 = RemoteWebRenderIPCClient.INSTANCE.b();
        if (b16 == null) {
            return;
        }
        webView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.mWebView = webView;
        e B = B(b16, webView);
        this.mWebViewBuilder = B;
        if (b16 instanceof QQTranslucentBrowserActivity) {
            qQTranslucentBrowserActivity = (QQTranslucentBrowserActivity) b16;
        } else {
            qQTranslucentBrowserActivity = null;
        }
        if (qQTranslucentBrowserActivity != null) {
            qQTranslucentBrowserActivity.attachRemoteWebView(B);
        }
    }

    @Override // com.tencent.mobileqq.remoteweb.view.BaseRemoteViewPresentation
    @Nullable
    public View c(@NotNull View containerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (View) iPatchRedirector.redirect((short) 14, (Object) this, (Object) containerView);
        }
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        long currentTimeMillis = System.currentTimeMillis();
        RemoteWebRenderIPCClient.Companion companion = RemoteWebRenderIPCClient.INSTANCE;
        RemoteWebRenderIPCClient.T(companion.a(), this.mWebPageId, RemoteWebViewEvent.ON_BEFORE_INIT_WEB_VIEW, null, 4, null);
        Activity b16 = companion.b();
        if (b16 == null) {
            return null;
        }
        companion.a().Z(this.mWebPageId, RemoteWebTimeCost.BEFORE_CREATE_WEB_VIEW);
        A(u(b16));
        companion.a().Z(this.mWebPageId, RemoteWebTimeCost.CREATE_WEB_VIEW);
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.WebViewPresentation", 1, "createWebView, cost=" + (System.currentTimeMillis() - currentTimeMillis));
        return this.mWebView;
    }

    @Override // com.tencent.mobileqq.remoteweb.view.BaseRemoteViewPresentation
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            if (this.mIsDestroy) {
                return;
            }
            com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.WebViewPresentation", 1, "destroy");
            this.mIsDestroy = true;
            w();
            super.d();
        }
    }

    @Override // com.tencent.mobileqq.remoteweb.view.BaseRemoteViewPresentation
    public void f(@NotNull RemoteBusinessEvent type, @NotNull Bundle extraInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) type, (Object) extraInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        super.f(type, extraInfo);
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.WebViewPresentation", 1, "[dispatchEvent] type " + type);
        int i3 = b.f281233a[type.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                a.b bVar = new a.b();
                String str = "unSupport type " + type;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    com.tencent.mobileqq.log.a.f241755a.a().e("RemoteWeb.WebViewPresentation", 1, (String) it.next(), null);
                }
                return;
            }
            C(true);
            return;
        }
        C(false);
    }

    @Override // com.tencent.mobileqq.remoteweb.view.BaseRemoteViewPresentation
    public void n(@NotNull String url, @NotNull Bundle urlExtraInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) url, (Object) urlExtraInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(urlExtraInfo, "urlExtraInfo");
        if (this.mIsReuse) {
            com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.WebViewPresentation", 1, "[loadUrl] mIsReuse no need loadUrl " + url);
            this.mIsReuse = false;
            return;
        }
        long j3 = this.extraData.getLong("key_click_start");
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.WebViewPresentation", 1, "beforeLoadUrl, timeCost= " + (System.currentTimeMillis() - j3) + "ms, url " + url);
        this.mUrl = url;
        this.extraData.putString("key_remote_web_url", url);
        TouchWebView touchWebView = this.mWebView;
        if (touchWebView != null) {
            touchWebView.loadUrl(url);
        }
    }

    @Override // com.tencent.mobileqq.remoteweb.view.BaseRemoteViewPresentation
    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        super.o();
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.WebViewPresentation", 1, "[onPause] ");
        TouchWebView touchWebView = this.mWebView;
        if (touchWebView != null) {
            touchWebView.onPause();
        }
    }

    @Override // com.tencent.mobileqq.remoteweb.view.BaseRemoteViewPresentation
    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        super.p();
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.WebViewPresentation", 1, "[onResume] ");
        TouchWebView touchWebView = this.mWebView;
        if (touchWebView != null) {
            touchWebView.onResume();
        }
    }

    @Override // com.tencent.mobileqq.remoteweb.view.BaseRemoteViewPresentation
    public boolean r(@NotNull View view) {
        TouchWebView touchWebView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) view)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof TouchWebView) {
            touchWebView = (TouchWebView) view;
        } else {
            touchWebView = null;
        }
        if (touchWebView != null) {
            A(touchWebView);
            this.mIsReuse = true;
            return true;
        }
        return false;
    }

    @NotNull
    public TouchWebView u(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (TouchWebView) iPatchRedirector.redirect((short) 21, (Object) this, (Object) activity);
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        return new TouchWebView(activity);
    }

    @NotNull
    public e v(@NotNull Activity activity, @NotNull TouchWebView webView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (e) iPatchRedirector.redirect((short) 22, (Object) this, (Object) activity, (Object) webView);
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(webView, "webView");
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.WebViewPresentation", 1, "createWebViewBuilder");
        webView.setOnScrollChangedListener(new c(webView, this));
        return new e(activity, webView, this.extraData);
    }

    public void w() {
        ViewParent viewParent;
        ViewParent viewParent2;
        ViewGroup viewGroup;
        WebViewPluginEngine pluginEngine;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.WebViewPresentation", 1, "destroyWebView");
        TouchWebView touchWebView = this.mWebView;
        if (touchWebView != null) {
            viewParent = touchWebView.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent != null && Intrinsics.areEqual(this.mWebView, i().a())) {
            TouchWebView touchWebView2 = this.mWebView;
            if (touchWebView2 != null && (pluginEngine = touchWebView2.getPluginEngine()) != null) {
                pluginEngine.H();
            }
            TouchWebView touchWebView3 = this.mWebView;
            if (touchWebView3 != null) {
                touchWebView3.setPluginEngine(null);
            }
            try {
                TouchWebView touchWebView4 = this.mWebView;
                if (touchWebView4 != null) {
                    viewParent2 = touchWebView4.getParent();
                } else {
                    viewParent2 = null;
                }
                if (viewParent2 instanceof ViewGroup) {
                    viewGroup = (ViewGroup) viewParent2;
                } else {
                    viewGroup = null;
                }
                if (viewGroup != null) {
                    viewGroup.removeView(this.mWebView);
                }
                TouchWebView touchWebView5 = this.mWebView;
                if (touchWebView5 != null) {
                    touchWebView5.stopLoading();
                }
            } catch (Exception e16) {
                com.tencent.mobileqq.log.a aVar = com.tencent.mobileqq.log.a.f241755a;
                a.b bVar = new a.b();
                String str = "destroyWebView error " + e16;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    com.tencent.mobileqq.log.a.f241755a.a().e("RemoteWeb.WebViewPresentation", 1, (String) it.next(), e16);
                }
            }
            TouchWebView touchWebView6 = this.mWebView;
            if (touchWebView6 != null) {
                touchWebView6.setWebChromeClient(null);
            }
            TouchWebView touchWebView7 = this.mWebView;
            if (touchWebView7 != null) {
                touchWebView7.setWebViewClient(null);
            }
            TouchWebView touchWebView8 = this.mWebView;
            if (touchWebView8 != null) {
                touchWebView8.destroy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.mWebPageId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final TouchWebView y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TouchWebView) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mWebView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final e z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (e) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mWebViewBuilder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull Context context, @NotNull Display display, @NotNull Bundle extraData) {
        super(context, display);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(display, "display");
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, display, extraData);
            return;
        }
        this.extraData = extraData;
        this.mUrl = extraData.getString("key_remote_web_url", "");
        String string = extraData.getString("key_web_page_id", "");
        Intrinsics.checkNotNullExpressionValue(string, "extraData.getString(Remo\u2026ants.KEY_WEB_PAGE_ID, \"\")");
        this.mWebPageId = string;
    }
}
