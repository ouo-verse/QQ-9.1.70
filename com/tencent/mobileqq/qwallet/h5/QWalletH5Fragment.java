package com.tencent.mobileqq.qwallet.h5;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qwallet.h5.QWalletH5Step;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.ak;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\bH\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Fragment;", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "doOnCreate", "Landroid/view/View;", "view", "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/mobileqq/webview/swift/utils/t;", "getWebViewKernelCallBack", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/qwallet/h5/d;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qwallet/h5/d;", "techReporter", "<init>", "()V", "D", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletH5Fragment extends WebViewFragment {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private d techReporter;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J>\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0018\u0010\u0007\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J$\u0010\f\u001a\u0004\u0018\u00010\u00042\u0018\u0010\u0007\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0006H\u0002J>\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0018\u0010\u0007\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u001a\u0010\u0011\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fR\u0014\u0010\u0012\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Fragment$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "url", "", "urlParams", "Landroid/content/Intent;", "baseIntent", "", "d", "b", "", "c", "Landroid/os/Bundle;", "bundle", "a", "KEY_FRAGMENT_CLASS", "Ljava/lang/String;", "TAG", "URL_ENTRY_KEY", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.h5.QWalletH5Fragment$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String b(Map<String, String> urlParams) {
            String str;
            if (urlParams != null && (str = urlParams.get("_bid")) != null) {
                return HtmlOffline.z(str);
            }
            return null;
        }

        private final void d(Activity activity, String url, Map<String, String> urlParams, Intent baseIntent) {
            String str;
            Bundle extras;
            if (activity == null) {
                return;
            }
            Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
            if (baseIntent != null && (extras = baseIntent.getExtras()) != null) {
                intent.putExtras(extras);
            }
            intent.putExtra("big_brother_source_key", "biz_src_zf_qianbao");
            intent.putExtra("isTransparentTitle", true);
            intent.putExtra("fragmentClass", QWalletH5Fragment.class);
            intent.putExtra("url", url);
            String b16 = QWalletH5Fragment.INSTANCE.b(urlParams);
            long currentTimeMillis = System.currentTimeMillis();
            if (urlParams != null) {
                str = urlParams.get("qwallet_h5_tag");
            } else {
                str = null;
            }
            intent.putExtra("KEY_CLICK_ENTRY_BEAN", new QWalletH5Step.ClickAction(currentTimeMillis, str, QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool"), QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:privileged_process0"), b16, url));
            QLog.i("QWalletH5Fragment", 1, "start QWalletH5Fragment: " + url);
            activity.startActivity(intent);
        }

        public final boolean a(@Nullable Activity activity, @Nullable Bundle bundle) {
            Intent intent;
            Bundle extras;
            if (activity == null || (intent = activity.getIntent()) == null || (extras = intent.getExtras()) == null || !Intrinsics.areEqual(extras.get("fragmentClass"), QWalletH5Fragment.class)) {
                return false;
            }
            if (bundle != null) {
                bundle.remove("isTransparentTitle");
            }
            if (bundle != null) {
                bundle.remove("fragmentClass");
            }
            if (bundle != null) {
                bundle.remove("url");
                return true;
            }
            return true;
        }

        public final boolean c(@Nullable Activity activity, @Nullable String url, @Nullable Map<String, String> urlParams, @Nullable Intent baseIntent) {
            String str;
            if (url != null) {
                if (urlParams != null) {
                    str = urlParams.get("qwallet_h5");
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(str, "1")) {
                    d(activity, url, urlParams, baseIntent);
                    return true;
                }
                return false;
            }
            return false;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u001c\u0010\u000b\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u000e\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\fH\u0016J&\u0010\u0012\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0013\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0016J.\u0010\u0017\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\u0018"}, d2 = {"com/tencent/mobileqq/qwallet/h5/QWalletH5Fragment$b", "Lcom/tencent/mobileqq/webview/swift/proxy/a;", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "", "onX5Init", "loadUrlFinish", "Lcom/tencent/smtt/sdk/WebView;", "view", "", "title", "onReceivedTitle", "", "newProgress", "onProgressChanged", "url", "Landroid/graphics/Bitmap;", "favicon", "onPageStarted", "onPageFinished", "errorCode", "description", "failingUrl", "onReceivedError", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b extends com.tencent.mobileqq.webview.swift.proxy.a {
        b(ak akVar) {
            super(akVar);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void loadUrlFinish() {
            super.loadUrlFinish();
            d dVar = QWalletH5Fragment.this.techReporter;
            if (dVar != null) {
                dVar.i();
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onPageFinished(@Nullable WebView view, @Nullable String url) {
            super.onPageFinished(view, url);
            d dVar = QWalletH5Fragment.this.techReporter;
            if (dVar != null) {
                dVar.g();
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onPageStarted(@Nullable WebView view, @Nullable String url, @Nullable Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            d dVar = QWalletH5Fragment.this.techReporter;
            if (dVar != null) {
                dVar.h();
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onProgressChanged(@Nullable WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            d dVar = QWalletH5Fragment.this.techReporter;
            if (dVar != null) {
                dVar.f();
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onReceivedError(@Nullable WebView view, int errorCode, @Nullable String description, @Nullable String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            QLog.i("QWalletH5Fragment", 1, "QWalletH5Fragment onReceivedError, description=" + description + " failingUrl=" + failingUrl);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onReceivedTitle(@Nullable WebView view, @Nullable String title) {
            super.onReceivedTitle(view, title);
            d dVar = QWalletH5Fragment.this.techReporter;
            if (dVar != null) {
                dVar.j(title);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onX5Init(@Nullable Bundle extraData) {
            super.onX5Init(extraData);
            d dVar = QWalletH5Fragment.this.techReporter;
            if (dVar != null) {
                dVar.l();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
    public boolean doOnCreate(@Nullable Bundle savedInstanceState) {
        QLog.i("QWalletH5Fragment", 1, "QWalletH5Fragment doOnCreate");
        boolean doOnCreate = super.doOnCreate(savedInstanceState);
        boolean d16 = com.tencent.mobileqq.qwallet.h5.b.f277185a.d(getUrl());
        String url = getUrl();
        Intrinsics.checkNotNullExpressionValue(url, "url");
        d dVar = new d(url);
        this.techReporter = dVar;
        dVar.d(this, d16);
        return doOnCreate;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    @NotNull
    public t getWebViewKernelCallBack() {
        return new b(this.webViewSurface);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.tencent.mobileqq.qwallet.h5.b bVar = com.tencent.mobileqq.qwallet.h5.b.f277185a;
        String url = getUrl();
        Intrinsics.checkNotNullExpressionValue(url, "url");
        boolean c16 = bVar.c(url);
        d dVar = this.techReporter;
        if (dVar != null) {
            dVar.e(this, c16);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        d dVar = this.techReporter;
        if (dVar != null) {
            dVar.k();
        }
    }
}
