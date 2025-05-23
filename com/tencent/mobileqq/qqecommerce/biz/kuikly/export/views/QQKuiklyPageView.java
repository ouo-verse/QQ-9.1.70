package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.minispecial.kuikly.IMiniKuiklyApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.container.QQKuiklyFragment;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.container.QQKuiklyRenderView;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.utils.QQKuiklyCommUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import i01.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 G2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001HB\u000f\u0012\u0006\u0010D\u001a\u00020C\u00a2\u0006\u0004\bE\u0010FJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0016\u0010\u0011\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fH\u0002J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u0012H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016JI\u0010\u001d\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062+\u0010\u0010\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018j\u0004\u0018\u0001`\u001cH\u0016J\"\u0010#\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020!H\u0016J\u0012\u0010%\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010$H\u0016J0\u0010,\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\f2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020'H\u0014J\b\u0010-\u001a\u00020\u0004H\u0016R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00103R;\u00109\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018j\u0004\u0018\u0001`\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R;\u0010:\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018j\u0004\u0018\u0001`\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u00108R'\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000f0;8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010<\u001a\u0004\b/\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010A\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/QQKuiklyPageView;", "Landroid/widget/FrameLayout;", "Li01/c;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "", "g", "", "params", "o", "l", "", "propValue", "", "j", "i", "Lkotlin/Function0;", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "c", "p", "propKey", "b", "method", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "call", "isSucceed", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "onPageLoadComplete", "Landroid/view/ViewGroup$LayoutParams;", "setLayoutParams", "changed", "", "left", "top", "right", "bottom", "onLayout", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/QQKuiklyRenderView;", "d", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/QQKuiklyRenderView;", "qqKuiklyRenderView", "e", "Ljava/lang/String;", "pageName", "f", ISchemeApi.KEY_PAGE_DATA, tl.h.F, "Lkotlin/jvm/functions/Function1;", "loadSuccessCallback", "loadFailureCallback", "", "Lkotlin/Lazy;", "()Ljava/util/List;", "lazyEvents", "Landroid/util/Size;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/util/Size;", "currentSize", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "D", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQKuiklyPageView extends FrameLayout implements i01.c, com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h {

    /* renamed from: C, reason: from kotlin metadata */
    private Size currentSize;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QQKuiklyRenderView qqKuiklyRenderView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String pageName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String pageData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> loadSuccessCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> loadFailureCallback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy lazyEvents;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQKuiklyPageView(Context context) {
        super(context);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.pageName = "";
        this.pageData = "{}";
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<List<Function0<? extends Unit>>>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.QQKuiklyPageView$lazyEvents$2
            @Override // kotlin.jvm.functions.Function0
            public final List<Function0<? extends Unit>> invoke() {
                return new ArrayList();
            }
        });
        this.lazyEvents = lazy;
        this.currentSize = new Size(0, 0);
    }

    private final Map<String, Object> c() {
        Map<String, Object> emptyMap;
        Map<String, Object> emptyMap2;
        Map<String, Object> sh5;
        Map<String, Object> emptyMap3;
        Map<String, Object> emptyMap4;
        Map<String, Object> sh6;
        Activity activity = getActivity();
        if (activity instanceof QPublicFragmentActivity) {
            QPublicBaseFragment fragment = ((QPublicFragmentActivity) activity).getFragment();
            QQKuiklyFragment qQKuiklyFragment = fragment instanceof QQKuiklyFragment ? (QQKuiklyFragment) fragment : null;
            if (qQKuiklyFragment != null && (sh6 = qQKuiklyFragment.sh()) != null) {
                return sh6;
            }
            emptyMap4 = MapsKt__MapsKt.emptyMap();
            return emptyMap4;
        }
        if (((IMiniKuiklyApi) QRoute.api(IMiniKuiklyApi.class)).isLaunchByMiniApp(getActivity())) {
            IMiniKuiklyApi iMiniKuiklyApi = (IMiniKuiklyApi) QRoute.api(IMiniKuiklyApi.class);
            Activity activity2 = getActivity();
            Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
            Map<String, Object> kuiklyPageData = iMiniKuiklyApi.getKuiklyPageData((QBaseActivity) activity2);
            if (kuiklyPageData != null) {
                return kuiklyPageData;
            }
            emptyMap3 = MapsKt__MapsKt.emptyMap();
            return emptyMap3;
        }
        if (!(activity instanceof SplashActivity)) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
        QQKuiklyFragment b16 = QQKuiklyCommUtil.INSTANCE.b(get_kuiklyRenderContext());
        if (b16 != null && (sh5 = b16.sh()) != null) {
            return sh5;
        }
        emptyMap2 = MapsKt__MapsKt.emptyMap();
        return emptyMap2;
    }

    private final List<Function0<Unit>> d() {
        return (List) this.lazyEvents.getValue();
    }

    private final void g() {
        if (this.qqKuiklyRenderView != null) {
            return;
        }
        Rect f16 = com.tencent.kuikly.core.render.android.css.ktx.b.f(this);
        if (f16.right <= 0 || f16.bottom <= 0) {
            return;
        }
        if (this.pageName.length() > 0) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.putAll(c());
            linkedHashMap.putAll(com.tencent.kuikly.core.render.android.css.ktx.b.G(KRCSSViewExtensionKt.k0(this.pageData)));
            this.currentSize = new Size(com.tencent.kuikly.core.render.android.css.ktx.b.j(f16), com.tencent.kuikly.core.render.android.css.ktx.b.i(f16));
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            QQKuiklyRenderView qQKuiklyRenderView = new QQKuiklyRenderView(context, this, false, 4, null);
            addView(qQKuiklyRenderView);
            qQKuiklyRenderView.b(this.pageName, linkedHashMap, new Size(f16.right, f16.bottom));
            l();
            this.qqKuiklyRenderView = qQKuiklyRenderView;
        }
    }

    private final boolean i(Object propValue) {
        Intrinsics.checkNotNull(propValue, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'result')] kotlin.Any?, kotlin.Unit>{ com.tencent.kuikly.core.render.android.export.IKuiklyRenderModuleExportKt.KuiklyRenderCallback }");
        this.loadFailureCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
        return true;
    }

    private final boolean j(Object propValue) {
        Intrinsics.checkNotNull(propValue, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'result')] kotlin.Any?, kotlin.Unit>{ com.tencent.kuikly.core.render.android.export.IKuiklyRenderModuleExportKt.KuiklyRenderCallback }");
        this.loadSuccessCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
        return true;
    }

    private final void l() {
        Iterator<T> it = d().iterator();
        while (it.hasNext()) {
            ((Function0) it.next()).invoke();
        }
        d().clear();
    }

    private final void m(Function0<Unit> callback) {
        if (this.qqKuiklyRenderView != null) {
            callback.invoke();
        } else {
            d().add(callback);
        }
    }

    private final void o(String params) {
        JSONObject k06 = KRCSSViewExtensionKt.k0(params);
        final String optString = k06.optString("event");
        final JSONObject optJSONObject = k06.optJSONObject("data");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        m(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.QQKuiklyPageView$sendEventWithParams$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                QQKuiklyRenderView qQKuiklyRenderView;
                QLog.i("QQKuiklyPageView", 1, "sendEventWithParams: " + optString + ", data: " + optJSONObject);
                qQKuiklyRenderView = this.qqKuiklyRenderView;
                if (qQKuiklyRenderView != null) {
                    String event = optString;
                    Intrinsics.checkNotNullExpressionValue(event, "event");
                    qQKuiklyRenderView.sentEvent(event, com.tencent.kuikly.core.render.android.css.ktx.b.G(optJSONObject));
                }
            }
        });
    }

    private final void p(Object propValue) {
        Map<String, ? extends Object> mapOf;
        QQKuiklyRenderView qQKuiklyRenderView = this.qqKuiklyRenderView;
        if (qQKuiklyRenderView == null) {
            return;
        }
        Rect rect = propValue instanceof Rect ? (Rect) propValue : null;
        if (rect == null) {
            return;
        }
        if (com.tencent.kuikly.core.render.android.css.ktx.b.j(rect) == this.currentSize.getWidth() && com.tencent.kuikly.core.render.android.css.ktx.b.i(rect) == this.currentSize.getHeight()) {
            return;
        }
        this.currentSize = new Size(com.tencent.kuikly.core.render.android.css.ktx.b.j(rect), com.tencent.kuikly.core.render.android.css.ktx.b.i(rect));
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("width", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(get_kuiklyRenderContext(), this.currentSize.getWidth()))), TuplesKt.to("height", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(get_kuiklyRenderContext(), this.currentSize.getHeight()))));
        qQKuiklyRenderView.sentEvent(Pager.PAGER_EVENT_ROOT_VIEW_SIZE_CHANGED, mapOf);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0011. Please report as an issue. */
    @Override // i01.c
    public boolean b(String propKey, Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        switch (propKey.hashCode()) {
            case -1599351356:
                if (propKey.equals("loadFailure")) {
                    return i(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 97692013:
                if (propKey.equals(AIInput.KEY_FRAME)) {
                    p(propValue);
                    return c.a.p(this, propKey, propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 858973913:
                if (propKey.equals(ISchemeApi.KEY_PAGE_DATA)) {
                    this.pageData = (String) propValue;
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case 859271610:
                if (propKey.equals("pageName")) {
                    this.pageName = (String) propValue;
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case 1915020349:
                if (propKey.equals("loadSuccess")) {
                    return j(propValue);
                }
                return c.a.p(this, propKey, propValue);
            default:
                return c.a.p(this, propKey, propValue);
        }
    }

    @Override // i01.a
    public Object call(String str, Object obj, Function1<Object, Unit> function1) {
        return c.a.a(this, str, obj, function1);
    }

    @Override // i01.c
    public void e(ViewGroup viewGroup) {
        c.a.l(this, viewGroup);
    }

    @Override // i01.c
    public View f() {
        return c.a.r(this);
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

    @Override // i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return c.a.g(this);
    }

    @Override // i01.c
    public void n(ViewGroup viewGroup) {
        c.a.i(this, viewGroup);
    }

    @Override // i01.a
    public void onCreate() {
        c.a.j(this);
    }

    @Override // i01.c, i01.a
    public void onDestroy() {
        c.a.k(this);
        QQKuiklyRenderView qQKuiklyRenderView = this.qqKuiklyRenderView;
        if (qQKuiklyRenderView != null) {
            qQKuiklyRenderView.onDetach();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        g();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void onPageLoadComplete(boolean isSucceed, ErrorReason errorReason, KuiklyRenderCoreExecuteMode executeMode) {
        Function1<Object, Unit> function1;
        Map emptyMap;
        Function1<Object, Unit> function12;
        Map emptyMap2;
        Intrinsics.checkNotNullParameter(executeMode, "executeMode");
        if (isSucceed && (function12 = this.loadSuccessCallback) != null && function12 != null) {
            emptyMap2 = MapsKt__MapsKt.emptyMap();
            function12.invoke(emptyMap2);
        }
        if (isSucceed || this.loadFailureCallback == null || (function1 = this.loadSuccessCallback) == null) {
            return;
        }
        emptyMap = MapsKt__MapsKt.emptyMap();
        function1.invoke(emptyMap);
    }

    @Override // i01.c
    public boolean s(String str) {
        return c.a.m(this, str);
    }

    @Override // i01.c, i01.a
    public void setKuiklyRenderContext(com.tencent.kuikly.core.render.android.a aVar) {
        c.a.o(this, aVar);
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        QQKuiklyRenderView qQKuiklyRenderView;
        super.setLayoutParams(params);
        if (params == null || (qQKuiklyRenderView = this.qqKuiklyRenderView) == null) {
            return;
        }
        qQKuiklyRenderView.setLayoutParams(new FrameLayout.LayoutParams(params.width, params.height));
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

    @Override // i01.c, i01.a
    public Object call(String method, String params, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (!Intrinsics.areEqual(method, "sendEvent")) {
            return c.a.b(this, method, params, callback);
        }
        o(params);
        return Unit.INSTANCE;
    }
}
