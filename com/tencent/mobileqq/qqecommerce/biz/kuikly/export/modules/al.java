package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules;

import android.app.Activity;
import android.content.Intent;
import android.widget.FrameLayout;
import com.tencent.av.utils.ba;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.fragment.BaseHippyContainer;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.kuikly.core.render.android.c;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.minispecial.kuikly.IMiniKuiklyApi;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.container.RenderBridge;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.IDomOperate;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001\u0010B\u0007\u00a2\u0006\u0004\b!\u0010\"J?\u0010\f\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0004\u0018\u0001`\nH\u0002J?\u0010\u000e\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\r2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0004\u0018\u0001`\nH\u0002J\u0012\u0010\u000f\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\rH\u0002J?\u0010\u0010\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\r2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0004\u0018\u0001`\nH\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002JI\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0015\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\r2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0004\u0018\u0001`\nH\u0016J\"\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016R2\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001d0\u001cj\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001d`\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/al;", "Li01/e;", "Lcom/tencent/kuikly/core/render/android/c;", "", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "g", "", "i", "c", "a", "", "viewId", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/RenderBridge;", "d", "method", "call", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Ljava/util/HashMap;", "Lcom/tencent/hippy/qq/fragment/BaseHippyContainer;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mHippyContainers", "<init>", "()V", "e", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class al extends i01.e implements com.tencent.kuikly.core.render.android.c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private HashMap<Integer, BaseHippyContainer> mHippyContainers = new HashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/al$b", "Lcom/tencent/hippy/qq/fragment/BaseHippyContainer$LoadListener;", "", "onLoadingStart", "onLoadingComplete", HippyQQPagView.EventName.ON_LOAD_ERROR, "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements BaseHippyContainer.LoadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f262977d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<OpenHippyInfo> f262978e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<BaseHippyContainer> f262979f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ al f262980h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ float f262981i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ float f262982m;

        b(Function1<Object, Unit> function1, Ref.ObjectRef<OpenHippyInfo> objectRef, Ref.ObjectRef<BaseHippyContainer> objectRef2, al alVar, float f16, float f17) {
            this.f262977d = function1;
            this.f262978e = objectRef;
            this.f262979f = objectRef2;
            this.f262980h = alVar;
            this.f262981i = f16;
            this.f262982m = f17;
        }

        @Override // com.tencent.hippy.qq.fragment.BaseHippyContainer.LoadListener
        public void onLoadError() {
            Map mapOf;
            Function1<Object, Unit> function1 = this.f262977d;
            if (function1 != null) {
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("errCode", -1), TuplesKt.to("errMsg", "load err."));
                function1.invoke(mapOf);
            }
        }

        @Override // com.tencent.hippy.qq.fragment.BaseHippyContainer.LoadListener
        public void onLoadingComplete() {
            Map mapOf;
            QLog.d("VueModule", 2, "onLoadingComplete");
            OpenHippyInfo openHippyInfo = this.f262978e.element;
            IDomOperate domOperateInterceptor = openHippyInfo != null ? openHippyInfo.getDomOperateInterceptor() : null;
            Intrinsics.checkNotNull(domOperateInterceptor, "null cannot be cast to non-null type com.tencent.mobileqq.qqecommerce.biz.kuikly.container.RenderBridge");
            HippyEngine hippyEngine = this.f262979f.element.getHippyEngine();
            Intrinsics.checkNotNullExpressionValue(hippyEngine, "container.hippyEngine");
            ((RenderBridge) domOperateInterceptor).f(hippyEngine);
            OpenHippyInfo openHippyInfo2 = this.f262978e.element;
            IDomOperate domOperateInterceptor2 = openHippyInfo2 != null ? openHippyInfo2.getDomOperateInterceptor() : null;
            Intrinsics.checkNotNull(domOperateInterceptor2, "null cannot be cast to non-null type com.tencent.mobileqq.qqecommerce.biz.kuikly.container.RenderBridge");
            ((RenderBridge) domOperateInterceptor2).e((int) ba.dp2px(this.f262980h.getContext(), this.f262981i), (int) ba.dp2px(this.f262980h.getContext(), this.f262982m));
            Function1<Object, Unit> function1 = this.f262977d;
            if (function1 != null) {
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("errCode", 0), TuplesKt.to("errMsg", "load suc."));
                function1.invoke(mapOf);
            }
        }

        @Override // com.tencent.hippy.qq.fragment.BaseHippyContainer.LoadListener
        public void onLoadingStart() {
            Map mapOf;
            QLog.d("VueModule", 2, "onLoadingStart");
            Function1<Object, Unit> function1 = this.f262977d;
            if (function1 != null) {
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("errCode", 0), TuplesKt.to("errMsg", "load start."));
                function1.invoke(mapOf);
            }
        }
    }

    private final void a(String params, Function1<Object, Unit> callback) {
        JSONObject jSONObject = new JSONObject(params);
        int optInt = jSONObject.optInt("viewId");
        String module = jSONObject.optString("module");
        String method = jSONObject.optString("method");
        JSONObject optJSONObject = jSONObject.optJSONObject("params");
        RenderBridge d16 = d(optInt);
        if (d16 != null) {
            Intrinsics.checkNotNullExpressionValue(module, "module");
            Intrinsics.checkNotNullExpressionValue(method, "method");
            d16.a(module, method, optJSONObject, callback);
        }
    }

    private final void c(String params) {
        BaseHippyContainer baseHippyContainer = this.mHippyContainers.get(Integer.valueOf(new JSONObject(params).optInt("viewId")));
        if (baseHippyContainer != null) {
            baseHippyContainer.onDestroy();
        }
    }

    private final RenderBridge d(int viewId) {
        OpenHippyInfo openHippyInfo;
        BaseHippyContainer baseHippyContainer = this.mHippyContainers.get(Integer.valueOf(viewId));
        IDomOperate domOperateInterceptor = (baseHippyContainer == null || (openHippyInfo = baseHippyContainer.getOpenHippyInfo()) == null) ? null : openHippyInfo.getDomOperateInterceptor();
        if (domOperateInterceptor instanceof RenderBridge) {
            return (RenderBridge) domOperateInterceptor;
        }
        return null;
    }

    private final void g(Object params, Function1<Object, Unit> callback) {
        QLog.d("VueModule", 2, "[init] params:" + params);
        if (callback != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ret", 1);
            callback.invoke(jSONObject);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.tencent.hippy.qq.api.OpenHippyInfo, T] */
    /* JADX WARN: Type inference failed for: r3v4, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v7, types: [com.tencent.hippy.qq.fragment.BaseHippyContainer, T] */
    private final void i(String params, Function1<Object, Unit> callback) {
        Map mapOf;
        QBaseFragment miniKuiklyBaseFragment;
        com.tencent.kuikly.core.render.android.d O0;
        Map mapOf2;
        QLog.d("VueModule", 2, "[load] params:" + params);
        JSONObject jSONObject = new JSONObject(params);
        int optInt = jSONObject.optInt("viewId");
        float optInt2 = (float) jSONObject.optInt("width", -1);
        float optInt3 = jSONObject.optInt("height", -1);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? openHippyInfo = new OpenHippyInfo(jSONObject);
        openHippyInfo.isDisablePreload = true;
        openHippyInfo.groupId = 100;
        objectRef.element = openHippyInfo;
        Intrinsics.checkNotNull(callback);
        openHippyInfo.setDomOperateInterceptor(new RenderBridge(callback, optInt));
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        ?? r36 = this.mHippyContainers.get(Integer.valueOf(optInt));
        objectRef2.element = r36;
        if (r36 == 0) {
            objectRef2.element = new BaseHippyContainer((OpenHippyInfo) objectRef.element);
            this.mHippyContainers.put(Integer.valueOf(optInt), objectRef2.element);
        }
        ((BaseHippyContainer) objectRef2.element).setLoadListener(new b(callback, objectRef, objectRef2, this, optInt2, optInt3));
        if (!(getActivity() instanceof QBaseActivity)) {
            mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to("errCode", -1), TuplesKt.to("errMsg", "not QPublicFragmentActivity"));
            callback.invoke(mapOf2);
            return;
        }
        Activity activity = getActivity();
        if (activity instanceof QPublicFragmentActivity) {
            miniKuiklyBaseFragment = ((QPublicFragmentActivity) activity).getFragment();
            Intrinsics.checkNotNullExpressionValue(miniKuiklyBaseFragment, "{\n            currentActivity.fragment\n        }");
        } else if (!((IMiniKuiklyApi) QRoute.api(IMiniKuiklyApi.class)).isLaunchByMiniApp(activity)) {
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("errCode", -1), TuplesKt.to("errMsg", "not QBaseFragment"));
            callback.invoke(mapOf);
            return;
        } else {
            IMiniKuiklyApi iMiniKuiklyApi = (IMiniKuiklyApi) QRoute.api(IMiniKuiklyApi.class);
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
            miniKuiklyBaseFragment = iMiniKuiklyApi.getMiniKuiklyBaseFragment((QBaseActivity) activity);
            Intrinsics.checkNotNullExpressionValue(miniKuiklyBaseFragment, "{\n            QRoute.api\u2026 QBaseActivity)\n        }");
        }
        BaseHippyContainer baseHippyContainer = (BaseHippyContainer) objectRef2.element;
        if (baseHippyContainer != null) {
            baseHippyContainer.onCreateView((QBaseActivity) activity, miniKuiklyBaseFragment, new FrameLayout(activity));
        }
        com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
        if (aVar == null || (O0 = aVar.O0()) == null) {
            return;
        }
        O0.g(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x002c. Please report as an issue. */
    @Override // i01.e, i01.a
    public Object call(String method, String params, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        QLog.d("VueModule", 2, "[call] method: " + method + ", params: " + params);
        switch (method.hashCode()) {
            case -1367776185:
                if (method.equals("callJs")) {
                    a(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 3237136:
                if (method.equals("init")) {
                    g(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 3327206:
                if (method.equals("load")) {
                    i(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1557372922:
                if (method.equals("destroy")) {
                    c(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            default:
                return super.call(method, params, callback);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.c
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        c.a.a(this, requestCode, resultCode, data);
        Collection<BaseHippyContainer> values = this.mHippyContainers.values();
        Intrinsics.checkNotNullExpressionValue(values, "mHippyContainers.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((BaseHippyContainer) it.next()).onActivityResult(requestCode, resultCode, data);
        }
    }
}
