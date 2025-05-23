package com.tencent.mobileqq.vas.adv.base.support.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.vas.adv.base.support.app.c;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.WebViewWrapper;
import com.tencent.mobileqq.webview.swift.utils.p;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebAccelerator;
import com.tencent.util.QQDeviceInfo;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J \u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J(\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u001a\u0010\"\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010#\u001a\u00020\u0002H\u0016J\n\u0010$\u001a\u0004\u0018\u00010\bH\u0016R\u0014\u0010&\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/base/support/app/VasAdvAppImpl;", "Lcom/tencent/mobileqq/vas/adv/base/support/app/c;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/concurrent/atomic/AtomicBoolean;", "atomic", "", DomainData.DOMAIN_NAME, "Landroid/view/View;", "webView", "j", "Lmqq/app/AppRuntime;", h.F, "Landroid/content/Context;", "f", "", "i", "Ljava/lang/Runnable;", "runnable", "networkJob", "autoRetrieve", "a", "delay", "d", "", "cmd", "cmdKey", "", "reqBytes", "Lcom/tencent/mobileqq/vas/adv/base/support/app/d;", "callback", "c", "context", PushClientConstants.TAG_PKG_NAME, "isAppInstalled", "initTbsEnvironment", "g", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isTbsInitialized", "<init>", "()V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasAdvAppImpl implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean isTbsInitialized = new AtomicBoolean(false);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/vas/adv/base/support/app/VasAdvAppImpl$a", "Lcom/tencent/mobileqq/webview/swift/a;", "", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "getCommonJsPlugin", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a extends com.tencent.mobileqq.webview.swift.a {
        a() {
        }

        @Override // com.tencent.mobileqq.webview.swift.a
        @Nullable
        public List<WebViewPlugin> getCommonJsPlugin() {
            return new ArrayList();
        }
    }

    private final AppRuntime h() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        Intrinsics.checkNotNullExpressionValue(waitAppRuntime, "sMobileQQ.waitAppRuntime(null)");
        return waitAppRuntime;
    }

    private final void j(View webView) {
        final TouchWebView touchWebView;
        if (webView instanceof TouchWebView) {
            touchWebView = (TouchWebView) webView;
        } else {
            touchWebView = null;
        }
        c.a.a(this, new Runnable() { // from class: com.tencent.mobileqq.vas.adv.base.support.app.b
            @Override // java.lang.Runnable
            public final void run() {
                VasAdvAppImpl.k(TouchWebView.this, this);
            }
        }, false, false, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(TouchWebView touchWebView, VasAdvAppImpl this$0) {
        List<WebViewPlugin> mutableListOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (touchWebView != null) {
            WebViewPluginEngine sPreloadEngine = WebViewPluginEngine.I;
            if (sPreloadEngine != null) {
                Intrinsics.checkNotNullExpressionValue(sPreloadEngine, "sPreloadEngine");
                WebViewPluginEngine.I = null;
            } else {
                AppRuntime h16 = this$0.h();
                Intrinsics.checkNotNull(h16, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
                a aVar = new a();
                mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new com.tencent.mobileqq.vas.adv.web.b());
                sPreloadEngine = WebAccelerateHelper.getInstance().createWebViewPluginEngine((AppInterface) h16, null, touchWebView, aVar, mutableListOf);
                Intrinsics.checkNotNullExpressionValue(sPreloadEngine, "getInstance().createWebV\u2026is, commonJs, bizPlugins)");
            }
            touchWebView.setPluginEngine(sPreloadEngine);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(VasAdvAppImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m();
    }

    private final void m() {
        Activity activity;
        Map mutableMapOf;
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        Bundle bundle = new Bundle();
        String c16 = o.c();
        String str = "";
        if (c16 == null) {
            c16 = "";
        }
        bundle.putString("qimei36", c16);
        String F = ah.F();
        if (F == null) {
            F = "";
        }
        bundle.putString("model", F);
        if (Foreground.getTopActivity() != null) {
            activity = Foreground.getTopActivity();
        } else {
            activity = null;
        }
        String serial = QQDeviceInfo.getSerial(activity);
        if (serial != null) {
            str = serial;
        }
        bundle.putString(SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL, str);
        QbSdk.setUserID(applicationContext, bundle);
        Boolean bool = Boolean.TRUE;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER, bool), TuplesKt.to(TbsCoreSettings.TBS_SETTINGS_USE_PRIVATE_CLASSLOADER, bool), TuplesKt.to(TbsCoreSettings.TBS_SETTINGS_USE_DEXLOADER_SERVICE, bool));
        QbSdk.initTbsSettings(mutableMapOf);
        p.a(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.adv.base.support.app.VasAdvAppImpl$initTbsEnvironmentImpl$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WebAccelerator.initTbsEnvironment(VasAdvAppImpl.this.f(), 2);
            }
        });
    }

    private final boolean n(AtomicBoolean atomic) {
        return atomic.compareAndSet(false, true);
    }

    @Override // com.tencent.mobileqq.vas.adv.base.support.app.c
    public void a(@NotNull Runnable runnable, boolean networkJob, boolean autoRetrieve) {
        int i3;
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (networkJob) {
            i3 = 128;
        } else {
            i3 = 16;
        }
        ThreadManagerV2.excute(runnable, i3, null, autoRetrieve);
    }

    @Override // com.tencent.mobileqq.vas.adv.base.support.app.c
    public void c(@NotNull String cmd, @NotNull String cmdKey, @NotNull byte[] reqBytes, @NotNull d callback) {
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(cmdKey, "cmdKey");
        Intrinsics.checkNotNullParameter(reqBytes, "reqBytes");
        Intrinsics.checkNotNullParameter(callback, "callback");
        cz2.a.INSTANCE.a(cmd, cmdKey, reqBytes, callback);
    }

    @Override // com.tencent.mobileqq.vas.adv.base.support.app.c
    public void d(@NotNull Runnable runnable, long delay) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        ThreadManager.getUIHandler().postDelayed(runnable, delay);
    }

    @Override // com.tencent.mobileqq.vas.adv.base.support.app.c
    @NotNull
    public Context f() {
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return context;
    }

    @Override // com.tencent.mobileqq.vas.adv.base.support.app.c
    @Nullable
    public View g() {
        AppRuntime h16 = h();
        Intrinsics.checkNotNull(h16, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        Intent intent = new Intent();
        intent.putExtra("ignoreLoginWeb", true);
        TouchWebView n3 = new WebViewWrapper(null, intent, f(), true).n();
        j(n3);
        n3.setBackgroundColor(0);
        n3.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        n3.setVisibility(8);
        return n3;
    }

    @Override // com.tencent.mobileqq.vas.adv.base.support.app.c
    public long i() {
        return h().getLongAccountUin();
    }

    @Override // com.tencent.mobileqq.vas.adv.base.support.app.c
    public void initTbsEnvironment() {
        if (n(this.isTbsInitialized)) {
            c.a.a(this, new Runnable() { // from class: com.tencent.mobileqq.vas.adv.base.support.app.a
                @Override // java.lang.Runnable
                public final void run() {
                    VasAdvAppImpl.l(VasAdvAppImpl.this);
                }
            }, false, false, 6, null);
        }
    }

    @Override // com.tencent.mobileqq.vas.adv.base.support.app.c
    public boolean isAppInstalled(@NotNull Context context, @Nullable String pkgName) {
        Intrinsics.checkNotNullParameter(context, "context");
        return PackageUtil.isAppInstalled(context, pkgName);
    }
}
