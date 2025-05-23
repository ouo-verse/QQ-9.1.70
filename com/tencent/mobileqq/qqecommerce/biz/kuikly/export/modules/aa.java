package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.container.QQKuiklyFragment;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.container.QQKuiklyRenderView;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.aa;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ=\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u000f\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002JQ\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\r2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u00112+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002JI\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\r2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/aa;", "Li01/e;", "", QzoneIPCModule.RESULT_CODE, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "i", "", "jsonParams", "l", "pageName", "", "params", "j", "method", "call", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/QQKuiklyRenderView;", "d", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/QQKuiklyRenderView;", "preloadKuiklyView", "<init>", "()V", "e", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class aa extends i01.e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QQKuiklyRenderView preloadKuiklyView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/aa$b", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "", "isSucceed", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "", "onPageLoadComplete", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f262952e;

        b(Function1<Object, Unit> function1) {
            this.f262952e = function1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(aa this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            QLog.d("KRSSRModule", 1, "createKuiklyRenderView remove view:" + com.tencent.mobileqq.qqecommerce.biz.kuikly.export.g.c(this$0));
            QQKuiklyRenderView c16 = com.tencent.mobileqq.qqecommerce.biz.kuikly.export.g.c(this$0);
            ViewParent parent = c16 != null ? c16.getParent() : null;
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(com.tencent.mobileqq.qqecommerce.biz.kuikly.export.g.c(this$0));
            }
            QQKuiklyRenderView c17 = com.tencent.mobileqq.qqecommerce.biz.kuikly.export.g.c(this$0);
            if (c17 != null) {
                c17.onDetach();
            }
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
        public void hideErrorView() {
            h.a.a(this);
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
        public void hideLoadingView() {
            h.a.b(this);
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
        public void onPageLoadComplete(boolean isSucceed, ErrorReason errorReason, KuiklyRenderCoreExecuteMode executeMode) {
            Intrinsics.checkNotNullParameter(executeMode, "executeMode");
            QLog.d("KRSSRModule", 1, "createKuiklyRenderView onPageLoadComplete", " isSucceed5:" + isSucceed + " qqRenderView:" + com.tencent.mobileqq.qqecommerce.biz.kuikly.export.g.c(aa.this) + " preloadKuiklyView:" + aa.this.preloadKuiklyView);
            if (isSucceed && aa.this.getActivity() != null && aa.this.preloadKuiklyView != null && com.tencent.mobileqq.qqecommerce.biz.kuikly.export.g.c(aa.this) != null) {
                QQKuiklyRenderView c16 = com.tencent.mobileqq.qqecommerce.biz.kuikly.export.g.c(aa.this);
                Intrinsics.checkNotNull(c16);
                if (!c16.getHadDetach()) {
                    QQKuiklyRenderView c17 = com.tencent.mobileqq.qqecommerce.biz.kuikly.export.g.c(aa.this);
                    Intrinsics.checkNotNull(c17);
                    if (c17.getParent() != null) {
                        QQKuiklyRenderView qQKuiklyRenderView = aa.this.preloadKuiklyView;
                        Intrinsics.checkNotNull(qQKuiklyRenderView);
                        QQKuiklyRenderView c18 = com.tencent.mobileqq.qqecommerce.biz.kuikly.export.g.c(aa.this);
                        Intrinsics.checkNotNull(c18);
                        qQKuiklyRenderView.setQQKuiklyRenderViewDelegate(c18.getDelegate());
                        aa.this.i(0, this.f262952e);
                        QQKuiklyRenderView c19 = com.tencent.mobileqq.qqecommerce.biz.kuikly.export.g.c(aa.this);
                        Intrinsics.checkNotNull(c19);
                        com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h delegate = c19.getDelegate();
                        QQKuiklyFragment qQKuiklyFragment = delegate instanceof QQKuiklyFragment ? (QQKuiklyFragment) delegate : null;
                        if (qQKuiklyFragment != null) {
                            qQKuiklyFragment.uh(aa.this.preloadKuiklyView);
                        }
                        QQKuiklyRenderView qQKuiklyRenderView2 = aa.this.preloadKuiklyView;
                        Intrinsics.checkNotNull(qQKuiklyRenderView2);
                        final aa aaVar = aa.this;
                        qQKuiklyRenderView2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.ab
                            @Override // java.lang.Runnable
                            public final void run() {
                                aa.b.b(aa.this);
                            }
                        }, 100L);
                        aa.this.preloadKuiklyView = null;
                        return;
                    }
                }
            }
            aa.this.i(-1, this.f262952e);
            if (aa.this.preloadKuiklyView != null) {
                QLog.d("KRSSRModule", 1, "createKuiklyRenderView destory preloadKuiklyView");
                QQKuiklyRenderView qQKuiklyRenderView3 = aa.this.preloadKuiklyView;
                Intrinsics.checkNotNull(qQKuiklyRenderView3);
                qQKuiklyRenderView3.onDetach();
            }
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
        public void showErrorView() {
            h.a.c(this);
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
        public void showLoadingView() {
            h.a.d(this);
        }
    }

    private final void l(String jsonParams, final Function1<Object, Unit> callback) {
        QLog.i("KRSSRModule", 1, "hydrate return json:" + jsonParams);
        if (this.preloadKuiklyView != null) {
            i(-3, callback);
            return;
        }
        if (getActivity() != null && com.tencent.mobileqq.qqecommerce.biz.kuikly.export.g.c(this) != null && jsonParams != null) {
            try {
                JSONObject jSONObject = new JSONObject(jsonParams);
                final String optString = jSONObject.optString("pageName");
                Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"pageName\")");
                String optString2 = jSONObject.optString("bundleName");
                Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(\"bundleName\")");
                int optInt = jSONObject.optInt("minVersion");
                int optInt2 = jSONObject.optInt("updateType");
                String syncRendering = jSONObject.optString("syncRendering", "0");
                JSONObject optJSONObject = jSONObject.optJSONObject("params");
                if (TextUtils.isEmpty(optString)) {
                    i(-2, callback);
                    return;
                }
                final LinkedHashMap linkedHashMap = new LinkedHashMap();
                QQKuiklyRenderView c16 = com.tencent.mobileqq.qqecommerce.biz.kuikly.export.g.c(this);
                Intrinsics.checkNotNull(c16);
                linkedHashMap.putAll(c16.O());
                Intrinsics.checkNotNullExpressionValue(syncRendering, "syncRendering");
                linkedHashMap.put(KuiklyLaunchParams.PARAM_SYNC_RENDERING, syncRendering);
                linkedHashMap.put("page_name", optString);
                linkedHashMap.put("bundle_name", optString2);
                linkedHashMap.put("update_type", Integer.valueOf(optInt2));
                linkedHashMap.put(KuiklyLaunchParams.PARAM_MIN_RES_VERSION, Integer.valueOf(optInt));
                if (optJSONObject != null) {
                    linkedHashMap.putAll(com.tencent.kuikly.core.render.android.css.ktx.b.G(optJSONObject));
                }
                QQKuiklyRenderView c17 = com.tencent.mobileqq.qqecommerce.biz.kuikly.export.g.c(this);
                Intrinsics.checkNotNull(c17);
                c17.post(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.z
                    @Override // java.lang.Runnable
                    public final void run() {
                        aa.m(aa.this, optString, linkedHashMap, callback);
                    }
                });
                return;
            } catch (Exception e16) {
                QLog.e("KRSSRModule", 1, "hydrate e:", e16);
                i(-1, callback);
                return;
            }
        }
        i(-2, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(aa this$0, String pageName, Map params, Function1 function1) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(pageName, "$pageName");
        Intrinsics.checkNotNullParameter(params, "$params");
        this$0.j(pageName, params, function1);
    }

    @Override // i01.e, i01.a
    public Object call(String method, String params, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (Intrinsics.areEqual(method, "hydrate")) {
            l(params, callback);
        }
        return Unit.INSTANCE;
    }

    @Override // i01.e, i01.a
    public void onDestroy() {
        super.onDestroy();
        this.preloadKuiklyView = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(int resultCode, Function1<Object, Unit> callback) {
        Map mapOf;
        if (callback != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("retCode", Integer.valueOf(resultCode)));
            callback.invoke(mapOf);
        }
    }

    private final void j(String pageName, Map<String, Object> params, Function1<Object, Unit> callback) {
        if (getActivity() != null && com.tencent.mobileqq.qqecommerce.biz.kuikly.export.g.c(this) != null) {
            QQKuiklyRenderView c16 = com.tencent.mobileqq.qqecommerce.biz.kuikly.export.g.c(this);
            Intrinsics.checkNotNull(c16);
            if (c16.getParent() != null) {
                b bVar = new b(callback);
                QLog.d("KRSSRModule", 1, "createKuiklyRenderView start");
                QQKuiklyRenderView c17 = com.tencent.mobileqq.qqecommerce.biz.kuikly.export.g.c(this);
                Intrinsics.checkNotNull(c17);
                ViewParent parent = c17.getParent();
                ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup == null) {
                    return;
                }
                int indexOfChild = viewGroup.indexOfChild(c17);
                int i3 = indexOfChild > 0 ? indexOfChild - 1 : 0;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(c17.getLayoutParams().width, c17.getLayoutParams().height);
                Intrinsics.checkNotNull(c17);
                ViewGroup.LayoutParams layoutParams2 = c17.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                layoutParams.gravity = ((FrameLayout.LayoutParams) layoutParams2).gravity;
                Activity activity = getActivity();
                Intrinsics.checkNotNull(activity);
                QQKuiklyRenderView qQKuiklyRenderView = new QQKuiklyRenderView(activity, bVar, false, 4, null);
                this.preloadKuiklyView = qQKuiklyRenderView;
                viewGroup.addView(qQKuiklyRenderView, i3, layoutParams);
                g.a.b(qQKuiklyRenderView, pageName, params, null, 4, null);
                return;
            }
        }
        i(-2, callback);
    }
}
