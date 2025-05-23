package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.kuikly.core.render.android.c;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h;
import com.tencent.mobileqq.webview.swift.y;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.TbsShareManager;
import i01.c;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 O2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001#B\u0011\b\u0016\u0012\u0006\u0010F\u001a\u00020\b\u00a2\u0006\u0004\bG\u0010HB\u001b\b\u0016\u0012\u0006\u0010F\u001a\u00020\b\u0012\b\u0010J\u001a\u0004\u0018\u00010I\u00a2\u0006\u0004\bG\u0010KB#\b\u0016\u0012\u0006\u0010F\u001a\u00020\b\u0012\b\u0010J\u001a\u0004\u0018\u00010I\u0012\u0006\u0010M\u001a\u00020L\u00a2\u0006\u0004\bG\u0010NJ\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u0013\u001a\u00020\nH\u0016J\u0010\u0010\u0016\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J*\u0010\u001e\u001a\u00020\n2\"\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00180\u001bj\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0018`\u001cJ*\u0010\u001f\u001a\u00020\n2\"\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00180\u001bj\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0018`\u001cJ*\u0010 \u001a\u00020\n2\"\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00180\u001bj\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0018`\u001cJ*\u0010!\u001a\u00020\n2\"\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00180\u001bj\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0018`\u001cJ\b\u0010#\u001a\u0004\u0018\u00010\"J\"\u0010)\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u000f2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010(\u001a\u00020'H\u0016J\n\u0010*\u001a\u0004\u0018\u00010\u0018H\u0016R\u0018\u0010-\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010,R;\u00105\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0018\u00a2\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\n\u0018\u00010.j\u0004\u0018\u0001`28\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R;\u00107\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0018\u00a2\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\n\u0018\u00010.j\u0004\u0018\u0001`28\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00104R;\u00109\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0018\u00a2\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\n\u0018\u00010.j\u0004\u0018\u0001`28\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00104R;\u0010:\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0018\u00a2\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\n\u0018\u00010.j\u0004\u0018\u0001`28\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u00104R\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010;R\u0016\u0010=\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010;R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010A\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010;R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010D\u00a8\u0006P"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/QQKuiklyWebView;", "Landroid/widget/FrameLayout;", "Li01/c;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "Lcom/tencent/kuikly/core/render/android/c;", "Lcom/tencent/comic/api/a;", "Landroid/content/Intent;", "intent", "Landroid/content/Context;", "viewContext", "", "c", "Lcom/tencent/biz/ui/TouchWebView;", "webView", "o", "", OpenHippyInfo.EXTRA_KEY_IS_TRANSPARENT, "setBackgroundTransparent", "l", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "url", "d", "propKey", "", "propValue", "b", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "eventData", "i", "g", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/webview/swift/y;", "a", "isSucceed", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "onPageLoadComplete", "getShareHelper", "Lrf2/a;", "Lrf2/a;", "webViewModule", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "e", "Lkotlin/jvm/functions/Function1;", "loadStartCallback", "f", "loadEndCallback", tl.h.F, "loadSuccessCallback", "receivedErrorCallback", "Z", BdhLogUtil.LogTag.Tag_Conn, OpenHippyInfo.EXTRA_KEY_IS_CUSTOM_NIGHT_MODE, "D", "Ljava/lang/String;", "E", "isWebViewInitialized", "Lcom/tencent/share/a;", UserInfo.SEX_FEMALE, "Lcom/tencent/share/a;", "shareHelper", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "G", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQKuiklyWebView extends FrameLayout implements i01.c, com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h, com.tencent.kuikly.core.render.android.c, com.tencent.comic.api.a {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isCustomNightMode;

    /* renamed from: D, reason: from kotlin metadata */
    private String url;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isWebViewInitialized;

    /* renamed from: F, reason: from kotlin metadata */
    private com.tencent.share.a shareHelper;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private rf2.a webViewModule;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> loadStartCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> loadEndCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> loadSuccessCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> receivedErrorCallback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isTransparent;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QQKuiklyWebView(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void c(Intent intent, Context viewContext) {
        try {
            rf2.a aVar = new rf2.a(intent, viewContext, this);
            this.webViewModule = aVar;
            aVar.onCreate();
        } catch (Exception e16) {
            QLog.e("QQKuiklyWebView", 1, "initWebViewModuleSafety error", e16);
        }
    }

    private final void o(TouchWebView webView) {
        ViewGroup.LayoutParams layoutParams = webView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        } else {
            layoutParams.width = -1;
            layoutParams.height = -1;
        }
        webView.setLayoutParams(layoutParams);
    }

    public final y a() {
        rf2.a aVar = this.webViewModule;
        if (aVar != null) {
            return aVar.a();
        }
        return null;
    }

    @Override // i01.c
    public boolean b(String propKey, Object propValue) {
        rf2.a aVar;
        TouchWebView touchWebView;
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        switch (propKey.hashCode()) {
            case 116079:
                if (propKey.equals("url")) {
                    String str = (String) propValue;
                    this.url = str;
                    if (this.isWebViewInitialized) {
                        d(str);
                    }
                    QLog.d("QQKuiklyWebView", 1, "setProp url:", this.url);
                    return true;
                }
                break;
            case 336615957:
                if (propKey.equals("loadEnd")) {
                    this.loadEndCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    return true;
                }
                break;
            case 631020256:
                if (propKey.equals(OpenHippyInfo.EXTRA_KEY_IS_CUSTOM_NIGHT_MODE)) {
                    Boolean bool = propValue instanceof Boolean ? (Boolean) propValue : null;
                    boolean booleanValue = bool != null ? bool.booleanValue() : false;
                    this.isCustomNightMode = booleanValue;
                    if (this.isWebViewInitialized && booleanValue && (aVar = this.webViewModule) != null && (touchWebView = aVar.webView) != null) {
                        touchWebView.setMask(false);
                    }
                    QLog.d("QQKuiklyWebView", 1, "setProp isCustomNightMode:", Boolean.valueOf(this.isCustomNightMode), " isWebViewInitialized:", Boolean.valueOf(this.isWebViewInitialized));
                    return true;
                }
                break;
            case 1158740424:
                if (propKey.equals(OpenHippyInfo.EXTRA_KEY_IS_TRANSPARENT)) {
                    String str2 = (String) propValue;
                    boolean areEqual = Intrinsics.areEqual("true", str2);
                    this.isTransparent = areEqual;
                    if (this.isWebViewInitialized) {
                        setBackgroundTransparent(areEqual);
                    }
                    QLog.d("QQKuiklyWebView", 1, "setProp isTransparent:", str2);
                    return true;
                }
                break;
            case 1378496284:
                if (propKey.equals("loadStart")) {
                    this.loadStartCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    return true;
                }
                break;
            case 1915020349:
                if (propKey.equals("loadSuccess")) {
                    this.loadSuccessCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    return true;
                }
                break;
            case 1949432999:
                if (propKey.equals("receivedError")) {
                    this.receivedErrorCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    return true;
                }
                break;
        }
        return c.a.p(this, propKey, propValue);
    }

    @Override // i01.a
    public Object call(String str, Object obj, Function1<Object, Unit> function1) {
        return c.a.a(this, str, obj, function1);
    }

    public final void d(String url) {
        TouchWebView touchWebView;
        rf2.a aVar = this.webViewModule;
        if (aVar == null || (touchWebView = aVar.webView) == null) {
            return;
        }
        touchWebView.loadUrl(url);
    }

    @Override // i01.c
    public void e(ViewGroup viewGroup) {
        c.a.l(this, viewGroup);
    }

    @Override // i01.c
    public View f() {
        return c.a.r(this);
    }

    public final void g(HashMap<String, Object> eventData) {
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        Function1<Object, Unit> function1 = this.loadEndCallback;
        if (function1 != null) {
            function1.invoke(eventData);
        }
        QLog.d("QQKuiklyWebView", 1, "onLoadWebViewEnd data:", eventData);
    }

    @Override // i01.c, i01.a
    public Activity getActivity() {
        return c.a.e(this);
    }

    @Override // i01.c, i01.a
    /* renamed from: getKuiklyRenderContext */
    public com.tencent.kuikly.core.render.android.a get_kuiklyRenderContext() {
        return c.a.f(this);
    }

    @Override // com.tencent.comic.api.a
    public Object getShareHelper() {
        return this.shareHelper;
    }

    @Override // i01.c
    public void h() {
        c.a.n(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideErrorView() {
        h.a.a(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideLoadingView() {
        h.a.b(this);
    }

    public final void i(HashMap<String, Object> eventData) {
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        Function1<Object, Unit> function1 = this.loadStartCallback;
        if (function1 != null) {
            function1.invoke(eventData);
        }
        QLog.d("QQKuiklyWebView", 1, "onLoadWebViewStart data:", eventData);
    }

    public final void j(HashMap<String, Object> eventData) {
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        Function1<Object, Unit> function1 = this.loadSuccessCallback;
        if (function1 != null) {
            function1.invoke(eventData);
        }
        QLog.d("QQKuiklyWebView", 1, "onLoadWebViewSuccess data:", eventData);
    }

    @Override // i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return c.a.g(this);
    }

    public final void l(TouchWebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        addView(webView);
        o(webView);
        webView.onResume();
        this.isWebViewInitialized = true;
        boolean z16 = this.isTransparent;
        if (z16) {
            setBackgroundTransparent(z16);
        }
        if (this.isCustomNightMode) {
            webView.setMask(false);
        }
        if (this.url.length() > 0) {
            d(this.url);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQKuiklyWebView", 2, "onWebViewInited webView");
        }
    }

    public final void m(HashMap<String, Object> eventData) {
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        Function1<Object, Unit> function1 = this.receivedErrorCallback;
        if (function1 != null) {
            function1.invoke(eventData);
        }
        QLog.d("QQKuiklyWebView", 1, "onWebViewReceivedError data:", eventData);
    }

    @Override // i01.c
    public void n(ViewGroup viewGroup) {
        c.a.i(this, viewGroup);
    }

    @Override // com.tencent.kuikly.core.render.android.c
    public void onActivityResult(int i3, int i16, Intent intent) {
        c.a.a(this, i3, i16, intent);
    }

    @Override // i01.a
    public void onCreate() {
        c.a.j(this);
    }

    @Override // i01.c, i01.a
    public void onDestroy() {
        c.a.k(this);
        rf2.a aVar = this.webViewModule;
        if (aVar != null) {
            aVar.onPause();
        }
        rf2.a aVar2 = this.webViewModule;
        if (aVar2 != null) {
            aVar2.onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void onPageLoadComplete(boolean isSucceed, ErrorReason errorReason, KuiklyRenderCoreExecuteMode executeMode) {
        Intrinsics.checkNotNullParameter(executeMode, "executeMode");
    }

    @Override // i01.c
    public boolean s(String str) {
        return c.a.m(this, str);
    }

    @Override // i01.c, i01.a
    public void setKuiklyRenderContext(com.tencent.kuikly.core.render.android.a aVar) {
        c.a.o(this, aVar);
    }

    @Override // i01.c
    public void setShadow(i01.b bVar) {
        c.a.q(this, bVar);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showErrorView() {
        h.a.c(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showLoadingView() {
        h.a.d(this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QQKuiklyWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // i01.c, i01.a
    public Object call(String str, String str2, Function1<Object, Unit> function1) {
        return c.a.b(this, str, str2, function1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQKuiklyWebView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.url = "";
        Intent intent = new Intent();
        intent.putExtra("web_view_module_from", 2);
        Activity activity = getActivity();
        context = activity != null ? activity : context;
        TbsShareManager.isThirdPartyApp(context);
        c(intent, context);
        this.shareHelper = new com.tencent.share.a(context);
        QLog.d("QQKuiklyWebView", 1, "onCreate end.");
    }

    public final void setBackgroundTransparent(boolean isTransparent) {
        rf2.a aVar;
        TouchWebView touchWebView;
        if (!isTransparent || (aVar = this.webViewModule) == null || (touchWebView = aVar.webView) == null) {
            return;
        }
        touchWebView.setBackgroundColor(0);
    }
}
