package com.tencent.mobileqq.zplan.cloudmod.impl.container;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.ak;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.mobileqq.webview.view.WebBrowserViewContainerKt;
import com.tencent.mobileqq.zootopia.FragmentSource;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.ue.UEActivityViewManager;
import com.tencent.mobileqq.zootopia.utils.m;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.cloudmod.impl.cloudgame.data.CloudModEvent;
import com.tencent.mobileqq.zplan.cloudmod.impl.cloudgame.data.CloudUpdateProgressEvent;
import com.tencent.mobileqq.zplan.cloudmod.impl.plugin.CloudPluginManager;
import com.tencent.mobileqq.zplan.mod.impl.silent.ModSilentDownloadHelper;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mobileqq.zplan.smallhome.floatwindow.ZPlanFloatWindowManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.sdk.WebView;
import com.tencent.sqshow.zootopia.utils.ag;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ^2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001_B\u0007\u00a2\u0006\u0004\b\\\u0010]J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u0006H\u0002J\b\u0010\u001e\u001a\u00020\rH\u0002J&\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010 \u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010)\u001a\u00020\u00062\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J\b\u0010*\u001a\u00020\u0006H\u0016J\b\u0010+\u001a\u00020\u0006H\u0016J\b\u0010,\u001a\u00020\u0006H\u0016J\u0006\u0010-\u001a\u00020\u0006J\b\u0010/\u001a\u00020.H\u0016J\u0012\u00101\u001a\u00020\u00062\b\u00100\u001a\u0004\u0018\u00010\nH\u0016J\b\u00102\u001a\u00020\rH\u0016J(\u00106\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000304\u0018\u000103j\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000304\u0018\u0001`5H\u0016J\u0012\u00107\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0016R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010IR\u0016\u0010M\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010IR\u0016\u0010N\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010IR\u001b\u0010T\u001a\u00020O8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u001b\u0010W\u001a\u00020O8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bU\u0010Q\u001a\u0004\bV\u0010SR\u0014\u0010[\u001a\u00020X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010Z\u00a8\u0006`"}, d2 = {"Lcom/tencent/mobileqq/zplan/cloudmod/impl/container/ZPlanCloudModFragment;", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/zootopia/FragmentSource;", "Bh", "", "initReport", "Jh", "Vh", "Lcom/tencent/biz/ui/TouchWebView;", "touchWebView", "Kh", "", "Mh", "Ih", "Gh", "showLoadingView", "hideLoadingView", "Uh", "Lcom/tencent/mobileqq/zplan/cloudmod/impl/cloudgame/data/CloudUpdateProgressEvent;", "event", "Fh", "Nh", "Lcom/tencent/mobileqq/zplan/cloudmod/impl/cloudgame/data/CloudModEvent;", "Eh", "", "msg", "Hh", "Ph", "Lh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "Landroid/content/Intent;", "newIntent", "onNewIntent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Oh", "Lcom/tencent/mobileqq/webview/swift/utils/t;", "getWebViewKernelCallBack", "webView", "setWebView", "onBackEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "onReceiveEvent", "Lcom/tencent/mobileqq/zplan/cloudmod/impl/plugin/CloudPluginManager;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/zplan/cloudmod/impl/plugin/CloudPluginManager;", "cloudPluginManger", "Landroid/widget/ImageView;", "D", "Landroid/widget/ImageView;", "loadingView", "", "E", "I", "modId", "", UserInfo.SEX_FEMALE, "J", "enterTime", "G", "Z", "isX5Kernel", "H", "isReceiveFirstFrame", "isVideoReady", "isErrorStatus", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "K", "Lkotlin/Lazy;", "Dh", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", GetAdInfoRequest.SOURCE_FROM, "L", "Ch", "sourceCurrent", "Ljava/lang/Runnable;", "M", "Ljava/lang/Runnable;", "timeoutRunnable", "<init>", "()V", "N", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanCloudModFragment extends WebViewFragment implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private CloudPluginManager cloudPluginManger;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView loadingView;

    /* renamed from: E, reason: from kotlin metadata */
    private int modId = -1;

    /* renamed from: F, reason: from kotlin metadata */
    private long enterTime = -1;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isX5Kernel;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isReceiveFirstFrame;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isVideoReady;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isErrorStatus;

    /* renamed from: K, reason: from kotlin metadata */
    private final Lazy sourceFrom;

    /* renamed from: L, reason: from kotlin metadata */
    private final Lazy sourceCurrent;

    /* renamed from: M, reason: from kotlin metadata */
    private final Runnable timeoutRunnable;

    @Metadata(d1 = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u001a\u0010\r\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0010\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J$\u0010\u0016\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J.\u0010\u001a\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0016\u00a8\u0006\u001b"}, d2 = {"com/tencent/mobileqq/zplan/cloudmod/impl/container/ZPlanCloudModFragment$b", "Lcom/tencent/mobileqq/webview/swift/proxy/a;", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "", "onShowPreview", "onFinalState", "onInitUIContent", "loadUrlFinish", "Lcom/tencent/smtt/sdk/WebView;", "view", "", "newProgress", "onProgressChanged", "", "url", "onPageFinished", "Lcom/tencent/smtt/export/external/interfaces/SslErrorHandler;", "handler", "Lcom/tencent/smtt/export/external/interfaces/SslError;", "error", "", "onReceivedSslError", "errorCode", "description", "failingUrl", "onReceivedError", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends com.tencent.mobileqq.webview.swift.proxy.a {
        b(ak akVar) {
            super(akVar);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void loadUrlFinish() {
            super.loadUrlFinish();
            ZPlanCloudModFragment.this.getUIStyleHandler().f314512m.A = true;
            ZPlanCloudModFragment.this.getUIStyleHandler().f314512m.f314619b = true;
            kg3.a aVar = kg3.a.f412316a;
            int i3 = ZPlanCloudModFragment.this.modId;
            String currentUrl = ZPlanCloudModFragment.this.getCurrentUrl();
            Intrinsics.checkNotNullExpressionValue(currentUrl, "currentUrl");
            aVar.j(i3, currentUrl, System.currentTimeMillis() - ZPlanCloudModFragment.this.enterTime);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onFinalState(Bundle extraData) {
            super.onFinalState(extraData);
            QLog.d("ZPlanCloudModFragment_", 1, "onFinalState");
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onInitUIContent(Bundle extraData) {
            super.onInitUIContent(extraData);
            ZPlanCloudModFragment zPlanCloudModFragment = ZPlanCloudModFragment.this;
            TouchWebView webView = ((WebViewFragment) zPlanCloudModFragment).webView;
            Intrinsics.checkNotNullExpressionValue(webView, "webView");
            zPlanCloudModFragment.Kh(webView);
            ZPlanCloudModFragment.this.Ih();
            QLog.d("ZPlanCloudModFragment_", 1, "initUiContent " + extraData);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            QLog.d("ZPlanCloudModFragment_", 1, "onPageFinished, url = " + url);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            QLog.d("ZPlanCloudModFragment_", 1, "onProgressChanged, progress: " + newProgress + " , url = " + ZPlanCloudModFragment.this.getUrl());
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            QLog.e("ZPlanCloudModFragment_", 1, "onReceivedError:  " + errorCode);
            ZPlanCloudModFragment.this.Hh(errorCode + ProgressTracer.SEPARATOR + description);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public boolean onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            boolean onReceivedSslError = super.onReceivedSslError(view, handler, error);
            QLog.e("ZPlanCloudModFragment_", 1, "onReceivedSslError:  ", error);
            ZPlanCloudModFragment.this.Hh("onReceivedSslError");
            return onReceivedSslError;
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onShowPreview(Bundle extraData) {
            super.onShowPreview(extraData);
            QLog.d("ZPlanCloudModFragment_", 1, "onShowPreview");
        }
    }

    public ZPlanCloudModFragment() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaSource>() { // from class: com.tencent.mobileqq.zplan.cloudmod.impl.container.ZPlanCloudModFragment$sourceFrom$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaSource invoke() {
                FragmentSource Bh;
                ZootopiaSource from;
                Bh = ZPlanCloudModFragment.this.Bh();
                return (Bh == null || (from = Bh.getFrom()) == null) ? ZootopiaSource.INSTANCE.i() : from;
            }
        });
        this.sourceFrom = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaSource>() { // from class: com.tencent.mobileqq.zplan.cloudmod.impl.container.ZPlanCloudModFragment$sourceCurrent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaSource invoke() {
                FragmentSource Bh;
                Source source;
                ZootopiaSource Dh;
                ZootopiaSource.Companion companion = ZootopiaSource.INSTANCE;
                Bh = ZPlanCloudModFragment.this.Bh();
                if (Bh == null || (source = Bh.getCurrent()) == null) {
                    source = Source.UnSet;
                }
                Dh = ZPlanCloudModFragment.this.Dh();
                return companion.c(source, "em_zplan_entrance_cloud_mod", Dh);
            }
        });
        this.sourceCurrent = lazy2;
        this.timeoutRunnable = new Runnable() { // from class: com.tencent.mobileqq.zplan.cloudmod.impl.container.d
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanCloudModFragment.Th(ZPlanCloudModFragment.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentSource Bh() {
        Intent intent;
        ZootopiaSource.Companion companion = ZootopiaSource.INSTANCE;
        FragmentSource f16 = companion.f(getArguments());
        if (f16 != null) {
            return f16;
        }
        FragmentActivity activity = getActivity();
        return companion.f((activity == null || (intent = activity.getIntent()) == null) ? null : intent.getExtras());
    }

    private final ZootopiaSource Ch() {
        return (ZootopiaSource) this.sourceCurrent.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ZootopiaSource Dh() {
        return (ZootopiaSource) this.sourceFrom.getValue();
    }

    private final void Eh(CloudModEvent event) {
        int cmd = event.getCmd();
        if (cmd == 1) {
            this.isReceiveFirstFrame = true;
            kg3.a aVar = kg3.a.f412316a;
            int i3 = this.modId;
            String currentUrl = getCurrentUrl();
            Intrinsics.checkNotNullExpressionValue(currentUrl, "currentUrl");
            aVar.l(i3, currentUrl);
            return;
        }
        if (cmd != 2) {
            return;
        }
        kg3.a aVar2 = kg3.a.f412316a;
        int i16 = this.modId;
        String currentUrl2 = getCurrentUrl();
        Intrinsics.checkNotNullExpressionValue(currentUrl2, "currentUrl");
        aVar2.p(i16, currentUrl2);
    }

    private final void Fh(CloudUpdateProgressEvent event) {
        String status = event.getStatus();
        if (Intrinsics.areEqual(status, "device-ready")) {
            kg3.a aVar = kg3.a.f412316a;
            int i3 = this.modId;
            String currentUrl = getCurrentUrl();
            Intrinsics.checkNotNullExpressionValue(currentUrl, "currentUrl");
            aVar.i(i3, currentUrl, event.getDeviceId(), event.getGmUid());
            QLog.i("ZPlanCloudModFragment_", 1, "onReceiveEvent :: device-ready");
            return;
        }
        if (Intrinsics.areEqual(status, "video-ready")) {
            Gh();
            mg3.a.f416730a.a(this.modId);
            kg3.a aVar2 = kg3.a.f412316a;
            int i16 = this.modId;
            String currentUrl2 = getCurrentUrl();
            Intrinsics.checkNotNullExpressionValue(currentUrl2, "currentUrl");
            aVar2.k(i16, currentUrl2, event.getDeviceId(), event.getGmUid());
            this.isVideoReady = true;
            QLog.i("ZPlanCloudModFragment_", 1, "onReceiveEvent :: video-ready");
            return;
        }
        this.isErrorStatus = true;
        hideLoadingView();
        Nh();
        QLog.i("ZPlanCloudModFragment_", 1, "onReceiveEvent :: error , msg == " + event.getMsg());
        if (Intrinsics.areEqual(event.getStatus(), "error")) {
            mg3.a.f416730a.b(this.modId, event.getMsg());
        }
    }

    private final void Gh() {
        hideLoadingView();
        lg3.a.f414537a.b();
        ng3.a.f420127a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Hh(String msg2) {
        QLog.e("ZPlanCloudModFragment_", 1, "load url error");
        QQToastUtil.showQQToast(1, R.string.xmq);
        mg3.a.f416730a.b(this.modId, msg2);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ih() {
        if (this.loadingView != null) {
            return;
        }
        WebBrowserViewContainerKt webBrowserViewContainerKt = this.contentView;
        if (webBrowserViewContainerKt != null) {
            ImageView imageView = new ImageView(webBrowserViewContainerKt.getContext());
            this.loadingView = imageView;
            imageView.setImageResource(R.drawable.ofc);
            ImageView imageView2 = this.loadingView;
            if (imageView2 != null) {
                imageView2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            ImageView imageView3 = this.loadingView;
            if (imageView3 != null) {
                imageView3.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            webBrowserViewContainerKt.addView(this.loadingView);
            showLoadingView();
        }
        ImageView imageView4 = this.loadingView;
        if (imageView4 != null) {
            imageView4.postDelayed(this.timeoutRunnable, 10000L);
        }
    }

    private final void Jh() {
        ux4.b.f440566e.e(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Kh(TouchWebView touchWebView) {
        getWebTitleBarInterface().u5(false);
        getSwiftTitleUI().f314047e.f314630m = false;
        getSwiftTitleUI().f314047e.Q = true;
        getUIStyleHandler().T.setVisibility(8);
        getUIStyleHandler().f314499a0 = true;
        getUIStyleHandler().U.l(false);
        getUIStyleHandler().f314500b0.setVisibility(8);
        ViewGroup viewGroup = getUIStyleHandler().S;
        Intrinsics.checkNotNullExpressionValue(viewGroup, "uiStyleHandler.webviewWrapper");
        if (viewGroup instanceof RefreshView) {
            ((RefreshView) viewGroup).a(false);
        }
        if (Mh(touchWebView)) {
            try {
                View view = touchWebView.getView();
                if (view != null) {
                    view.setBackgroundColor(0);
                }
                View view2 = touchWebView.getView();
                Drawable background = view2 != null ? view2.getBackground() : null;
                if (background != null) {
                    background.setAlpha(0);
                }
            } catch (Exception e16) {
                QLog.e("ZPlanCloudModFragment_", 1, "initView setX5WebView error", e16);
            }
        } else {
            kg3.a.f412316a.q();
        }
        touchWebView.setBackgroundColor(0);
        Drawable background2 = touchWebView.getBackground();
        if (background2 != null) {
            background2.setAlpha(0);
        }
        WebBrowserViewContainerKt webBrowserViewContainerKt = this.contentView;
        if (webBrowserViewContainerKt != null) {
            webBrowserViewContainerKt.setBackgroundColor(0);
        }
    }

    private final boolean Lh() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100344", false);
    }

    private final boolean Mh(TouchWebView touchWebView) {
        boolean z16 = touchWebView.getX5WebViewExtension() != null;
        this.isX5Kernel = z16;
        return z16;
    }

    private final void Nh() {
        Context context = getContext();
        if (context != null) {
            IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
            ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
            ZootopiaSource b16 = ag.f373258a.b();
            if (b16 == null) {
                b16 = ZootopiaSource.INSTANCE.g();
            }
            Bundle bundle = new Bundle();
            bundle.putInt("mapId", AdMetricID.Click.SUCCESS);
            bundle.putBoolean("openDetailNotReady", true);
            bundle.putBoolean(FavEmoConstant.ROAMING_TYPE_PANEL, true);
            bundle.putBoolean("openCloudWhenNotReady", false);
            Unit unit = Unit.INSTANCE;
            iZPlanApi.launchScheme(context, iSchemeApi.buildPageScheme(b16, 1, bundle));
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void Ph() {
        boolean z16 = Lh() && m.f329564a.c() && ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBoolean("cloud_alert_show", true);
        QLog.i("ZPlanCloudModFragment_", 1, "showMobileNetworkAlertIfNeed needShow = " + z16);
        if (z16) {
            String string = getString(R.string.xmo);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.zplan\u2026bile_network_alert_title)");
            String string2 = getString(R.string.xmm);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.zplan\u2026le_network_alert_content)");
            String string3 = getString(R.string.xmn);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.zplan\u2026e_network_alert_nolonger)");
            String string4 = getString(R.string.xmk);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.zplan\u2026ile_network_alert_cancel)");
            String string5 = getString(R.string.xml);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(R.string.zplan\u2026le_network_alert_confirm)");
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            DialogUtil.createDialogWithCheckBox(getContext(), 0, string, string2, string3, false, string4, string5, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zplan.cloudmod.impl.container.c
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ZPlanCloudModFragment.Sh(Ref.BooleanRef.this, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zplan.cloudmod.impl.container.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ZPlanCloudModFragment.Rh(Ref.BooleanRef.this, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zplan.cloudmod.impl.container.a
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ZPlanCloudModFragment.Qh(Ref.BooleanRef.this, this, dialogInterface, i3);
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(Ref.BooleanRef isChecked, ZPlanCloudModFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(isChecked, "$isChecked");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setBoolean("cloud_alert_show", !isChecked.element);
        dialogInterface.dismiss();
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(Ref.BooleanRef isChecked, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(isChecked, "$isChecked");
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setBoolean("cloud_alert_show", !isChecked.element);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(Ref.BooleanRef isChecked, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(isChecked, "$isChecked");
        Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type com.tencent.mobileqq.utils.QQCustomDialog");
        isChecked.element = ((QQCustomDialog) dialogInterface).getCheckBoxState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(ZPlanCloudModFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("ZPlanCloudModFragment_", 1, "timeoutRunnable");
        this$0.Gh();
    }

    private final void Uh() {
        if (ModSilentDownloadHelper.f334775a.w() && pk3.a.a(BaseApplication.context) && !this.isErrorStatus) {
            ZPlanFloatWindowManager.d(ZPlanFloatWindowManager.f335646d, Integer.valueOf(AdMetricID.Click.SUCCESS), null, null, 6, null);
        }
    }

    private final void Vh() {
        CloudPluginManager cloudPluginManager = this.cloudPluginManger;
        if (cloudPluginManager != null) {
            cloudPluginManager.z();
        }
    }

    private final void hideLoadingView() {
        TouchWebView touchWebView = this.webView;
        if (touchWebView != null) {
            touchWebView.setVisibility(0);
        }
        ImageView imageView = this.loadingView;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        ImageView imageView2 = this.loadingView;
        if (imageView2 != null) {
            imageView2.removeCallbacks(this.timeoutRunnable);
        }
        QLog.d("ZPlanCloudModFragment_", 1, "hideLoadingView");
    }

    private final void initReport() {
        this.enterTime = System.currentTimeMillis();
        int intExtra = this.intent.getIntExtra("modId", -1);
        this.modId = intExtra;
        kg3.a.f412316a.h(intExtra, getCurrentUrl());
    }

    private final void showLoadingView() {
        TouchWebView touchWebView = this.webView;
        if (touchWebView != null) {
            touchWebView.setVisibility(4);
        }
        ImageView imageView = this.loadingView;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        QLog.d("ZPlanCloudModFragment_", 1, "showLoadingView");
    }

    public final void Oh() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            UEActivityViewManager uEActivityViewManager = new UEActivityViewManager(activity);
            uEActivityViewManager.s();
            CloudPluginManager cloudPluginManager = new CloudPluginManager(activity, uEActivityViewManager);
            this.cloudPluginManger = cloudPluginManager;
            cloudPluginManager.y();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(CloudUpdateProgressEvent.class);
        arrayList.add(CloudModEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    public t getWebViewKernelCallBack() {
        return new b(this.webViewSurface);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        FragmentActivity activity;
        QLog.i("ZPlanCloudModFragment_", 1, "onBackEvent");
        if ((((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100379", false) || !this.isX5Kernel || this.isErrorStatus) && (activity = getActivity()) != null) {
            new og3.d(activity, this.modId, this.isReceiveFirstFrame, this.isVideoReady).show();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        ux4.b.f440566e.i(true);
        SimpleEventBus.getInstance().registerReceiver(this);
        initReport();
        Jh();
        Ih();
        Oh();
        QLog.d("ZPlanCloudModFragment_", 1, "onCreateView");
        Ph();
        ZPlanFloatWindowManager.h(ZPlanFloatWindowManager.f335646d, this.modId, null, false, false, 8, null);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QLog.d("ZPlanCloudModFragment_", 1, "onDestroy_");
        ux4.b.f440566e.i(false);
        lg3.a.f414537a.a();
        lg3.c.f414549a.a();
        Uh();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        Vh();
        ImageView imageView = this.loadingView;
        if (imageView != null) {
            imageView.removeCallbacks(this.timeoutRunnable);
        }
        kg3.a.f412316a.c();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent newIntent) {
        super.onNewIntent(newIntent);
        QLog.d("ZPlanCloudModFragment_", 1, "onNewIntent_");
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ag.f373258a.f(null);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        QLog.d("ZPlanCloudModFragment_", 1, "onReceiveEvent " + event);
        if (event instanceof CloudUpdateProgressEvent) {
            Fh((CloudUpdateProgressEvent) event);
        } else if (event instanceof CloudModEvent) {
            Eh((CloudModEvent) event);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ag.f373258a.f(Ch());
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webview.swift.WebViewProvider
    public void setWebView(TouchWebView webView) {
        if (webView != null) {
            webView.setVisibility(4);
        }
        super.setWebView(webView);
        QLog.d("ZPlanCloudModFragment_", 1, "setWebView");
    }
}
