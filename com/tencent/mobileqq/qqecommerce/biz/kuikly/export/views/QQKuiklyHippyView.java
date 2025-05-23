package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.fragment.BaseHippyContainer;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.kuikly.core.render.android.c;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.minispecial.kuikly.IMiniKuiklyApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import i01.c;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 =2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001\u0015B\u000f\u0012\u0006\u0010:\u001a\u000209\u00a2\u0006\u0004\b;\u0010<J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J5\u0010\u0012\u001a\u00020\u000f2+\u0010\u0011\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nj\u0004\u0018\u0001`\u0010H\u0002J5\u0010\u0013\u001a\u00020\u000f2+\u0010\u0011\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nj\u0004\u0018\u0001`\u0010H\u0002J?\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062+\u0010\u0011\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nj\u0004\u0018\u0001`\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\b\u0010\u0016\u001a\u00020\u000fH\u0002J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u000bH\u0016JI\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001a\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062+\u0010\u0011\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nj\u0004\u0018\u0001`\u0010H\u0016J\b\u0010\u001c\u001a\u00020\u000fH\u0016J\"\u0010\"\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\"\u0010(\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010'\u001a\u00020&H\u0016J\b\u0010)\u001a\u00020\u000fH\u0016J\b\u0010*\u001a\u00020\u000fH\u0016J\b\u0010+\u001a\u00020\u000fH\u0016R\u0018\u0010.\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R;\u00105\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nj\u0004\u0018\u0001`\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R;\u00107\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nj\u0004\u0018\u0001`\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00104R;\u00108\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nj\u0004\u0018\u0001`\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u00104\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/QQKuiklyHippyView;", "Landroid/widget/FrameLayout;", "Li01/c;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "Lcom/tencent/hippy/qq/fragment/BaseHippyContainer$LoadListener;", "Lcom/tencent/kuikly/core/render/android/c;", "", "params", "", "i", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "j", "c", "g", "a", "d", "propKey", "propValue", "b", "method", "call", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "isSucceed", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "onPageLoadComplete", "onLoadingStart", "onLoadingComplete", HippyQQPagView.EventName.ON_LOAD_ERROR, "Lcom/tencent/hippy/qq/fragment/BaseHippyContainer;", "Lcom/tencent/hippy/qq/fragment/BaseHippyContainer;", "mHippyContainer", "Lcom/tencent/hippy/qq/api/OpenHippyInfo;", "e", "Lcom/tencent/hippy/qq/api/OpenHippyInfo;", "openHippyInfo", "f", "Lkotlin/jvm/functions/Function1;", "loadSuccessCallback", tl.h.F, "loadStartCallback", "loadFailCallback", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQKuiklyHippyView extends FrameLayout implements i01.c, com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h, BaseHippyContainer.LoadListener, com.tencent.kuikly.core.render.android.c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private BaseHippyContainer mHippyContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private OpenHippyInfo openHippyInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> loadSuccessCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> loadStartCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> loadFailCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQKuiklyHippyView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a() {
        BaseHippyContainer baseHippyContainer = this.mHippyContainer;
        if (baseHippyContainer != null) {
            baseHippyContainer.onResume();
        }
    }

    private final void c(Function1<Object, Unit> callback) {
        Map mapOf;
        BaseHippyContainer baseHippyContainer = this.mHippyContainer;
        if (baseHippyContainer != null) {
            Intrinsics.checkNotNull(baseHippyContainer);
            HippyRootView rootView = baseHippyContainer.getRootView();
            if (rootView != null) {
                removeView(rootView);
            }
            BaseHippyContainer baseHippyContainer2 = this.mHippyContainer;
            Intrinsics.checkNotNull(baseHippyContainer2);
            baseHippyContainer2.onDestroy();
            this.mHippyContainer = null;
        }
        if (callback != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("errCode", 0));
            callback.invoke(mapOf);
        }
    }

    private final void d() {
        BaseHippyContainer baseHippyContainer = this.mHippyContainer;
        if (baseHippyContainer != null) {
            baseHippyContainer.onPause();
        }
    }

    private final boolean i(String params) {
        this.openHippyInfo = new OpenHippyInfo(new JSONObject(params));
        return true;
    }

    private final void j(Function1<Object, Unit> callback) {
        Map mapOf;
        QBaseFragment miniKuiklyBaseFragment;
        com.tencent.kuikly.core.render.android.d O0;
        Map mapOf2;
        Map mapOf3;
        OpenHippyInfo openHippyInfo = this.openHippyInfo;
        if (openHippyInfo == null) {
            if (callback != null) {
                mapOf3 = MapsKt__MapsKt.mapOf(TuplesKt.to("errCode", -3), TuplesKt.to("errMsg", "openHippyInfo is not illegal"));
                callback.invoke(mapOf3);
                return;
            }
            return;
        }
        QLog.i("QQKuiklyHippyView", 1, "showContent openHippyInfo:" + openHippyInfo);
        BaseHippyContainer baseHippyContainer = new BaseHippyContainer(this.openHippyInfo);
        this.mHippyContainer = baseHippyContainer;
        Intrinsics.checkNotNull(baseHippyContainer);
        baseHippyContainer.setLoadListener(this);
        if (!(getActivity() instanceof QBaseActivity)) {
            if (callback != null) {
                mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to("errCode", -3), TuplesKt.to("errMsg", "not QPublicFragmentActivity"));
                callback.invoke(mapOf2);
                return;
            }
            return;
        }
        if (getActivity() instanceof QPublicFragmentActivity) {
            Activity activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.tencent.mobileqq.activity.QPublicFragmentActivity");
            miniKuiklyBaseFragment = ((QPublicFragmentActivity) activity).getFragment();
            Intrinsics.checkNotNullExpressionValue(miniKuiklyBaseFragment, "{\n            (activity \u2026ivity).fragment\n        }");
        } else {
            if (!((IMiniKuiklyApi) QRoute.api(IMiniKuiklyApi.class)).isLaunchByMiniApp(getActivity())) {
                if (callback != null) {
                    mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("errCode", -3), TuplesKt.to("errMsg", "not QBaseFragment"));
                    callback.invoke(mapOf);
                    return;
                }
                return;
            }
            IMiniKuiklyApi iMiniKuiklyApi = (IMiniKuiklyApi) QRoute.api(IMiniKuiklyApi.class);
            Activity activity2 = getActivity();
            Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
            miniKuiklyBaseFragment = iMiniKuiklyApi.getMiniKuiklyBaseFragment((QBaseActivity) activity2);
            Intrinsics.checkNotNullExpressionValue(miniKuiklyBaseFragment, "{\n            QRoute.api\u2026 QBaseActivity)\n        }");
        }
        BaseHippyContainer baseHippyContainer2 = this.mHippyContainer;
        Intrinsics.checkNotNull(baseHippyContainer2);
        Activity activity3 = getActivity();
        Intrinsics.checkNotNull(activity3, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        baseHippyContainer2.onCreateView((QBaseActivity) activity3, miniKuiklyBaseFragment, this);
        com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
        if (aVar == null || (O0 = aVar.O0()) == null) {
            return;
        }
        O0.g(this);
    }

    @Override // i01.c
    public boolean b(String propKey, Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        switch (propKey.hashCode()) {
            case -1599351356:
                if (propKey.equals("loadFailure")) {
                    this.loadFailCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    return true;
                }
                break;
            case -377785597:
                if (propKey.equals("dataParam")) {
                    return i((String) propValue);
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
        }
        return c.a.p(this, propKey, propValue);
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

    @Override // com.tencent.kuikly.core.render.android.c
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        c.a.a(this, requestCode, resultCode, data);
        BaseHippyContainer baseHippyContainer = this.mHippyContainer;
        if (baseHippyContainer != null) {
            baseHippyContainer.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // i01.a
    public void onCreate() {
        c.a.j(this);
    }

    @Override // i01.c, i01.a
    public void onDestroy() {
        c.a.k(this);
        BaseHippyContainer baseHippyContainer = this.mHippyContainer;
        if (baseHippyContainer != null) {
            baseHippyContainer.onDestroy();
        }
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyContainer.LoadListener
    public void onLoadError() {
        Map mapOf;
        Function1<Object, Unit> function1 = this.loadFailCallback;
        if (function1 != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("errCode", -1));
            function1.invoke(mapOf);
        }
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyContainer.LoadListener
    public void onLoadingComplete() {
        Map mapOf;
        Function1<Object, Unit> function1 = this.loadSuccessCallback;
        if (function1 != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("errCode", 0));
            function1.invoke(mapOf);
        }
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyContainer.LoadListener
    public void onLoadingStart() {
        Map mapOf;
        Function1<Object, Unit> function1 = this.loadStartCallback;
        if (function1 != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("errCode", 0));
            function1.invoke(mapOf);
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

    @Override // i01.c, i01.a
    public Object call(String method, String params, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -2140931520:
                if (method.equals("dispatchEvent")) {
                    g(params, callback);
                    break;
                }
                break;
            case -1696650594:
                if (method.equals("viewDisAppear")) {
                    d();
                    break;
                }
                break;
            case 927716716:
                if (method.equals("clearContent")) {
                    c(callback);
                    break;
                }
                break;
            case 1339689660:
                if (method.equals("showContent")) {
                    j(callback);
                    break;
                }
                break;
            case 1913758874:
                if (method.equals("viewAppear")) {
                    a();
                    break;
                }
                break;
        }
        return c.a.b(this, method, params, callback);
    }

    private final void g(String params, Function1<Object, Unit> callback) {
        Map mapOf;
        if (params == null || params.length() == 0) {
            if (callback != null) {
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("errCode", -3), TuplesKt.to("errMsg", "not QPublicFragmentActivity"));
                callback.invoke(mapOf);
                return;
            }
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        String optString = jSONObject.optString(AdMetricTag.EVENT_NAME);
        JSONObject optJSONObject = jSONObject.optJSONObject("eventData");
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushJSONObject(optJSONObject);
        BaseHippyContainer baseHippyContainer = this.mHippyContainer;
        if (baseHippyContainer != null) {
            baseHippyContainer.sendHippyNativeEvent(optString, hippyMap);
        }
    }
}
