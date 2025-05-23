package com.tencent.mobileqq.qqecommerce.biz.hippy;

import androidx.fragment.app.Fragment;
import com.tencent.ecommerce.biz.hippy.api.IECHippyEngine;
import com.tencent.ecommerce.biz.hippy.api.IECHippyProxy;
import com.tencent.hippy.qq.api.IHippyModules;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.api.IUpdateListener;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.qqecommerce.biz.hippy.module.TKDAccountModule;
import com.tencent.mobileqq.qqecommerce.biz.hippy.module.TKDDebugModule;
import com.tencent.mobileqq.qqecommerce.biz.hippy.module.TKDToastModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ,\u0010\b\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00070\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J:\u0010\u0015\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/hippy/g;", "Lcom/tencent/ecommerce/biz/hippy/api/IECHippyProxy;", "Lcom/tencent/mtt/hippy/HippyEngineContext;", "context", "", "Ljava/lang/Class;", "Lcom/tencent/mtt/hippy/modules/nativemodules/HippyNativeModuleBase;", "Lcom/tencent/mtt/hippy/common/Provider;", "getPublicModules", "Landroidx/fragment/app/Fragment;", "fragment", "", "moduleName", "hippyUrl", "Lcom/tencent/mtt/hippy/HippyAPIProvider;", "provider", "Lcom/tencent/mtt/hippy/uimanager/HippyCustomViewCreator;", "customViewCreator", "", "minModuleVersion", "Lcom/tencent/mobileqq/qqecommerce/biz/hippy/a;", "i", "engineId", "Lcom/tencent/ecommerce/biz/hippy/api/IECHippyEngine;", "getEngine", "", "preloadJsBundle", "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class g implements IECHippyProxy {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JB\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042&\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0007H\u0016JT\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042&\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0007H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/hippy/g$b", "Lcom/tencent/hippy/qq/api/IUpdateListener;", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "", "bundleName", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "updateJSCosts", "", "onUpdateSuccess", "retCode", "errMsg", "onUpdateFailed", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements IUpdateListener {
        b() {
        }

        @Override // com.tencent.hippy.qq.api.IUpdateListener
        public void onUpdateFailed(int requestId, int retCode, String errMsg, String bundleName, HashMap<String, String> updateJSCosts) {
            QLog.e("ECHippyProxy", 1, "#preloadJsBundle: failed. retCode=" + retCode + ", bundleName=" + bundleName + ", errMsg=" + errMsg);
        }

        @Override // com.tencent.hippy.qq.api.IUpdateListener
        public void onUpdateSuccess(int requestId, String bundleName, HashMap<String, String> updateJSCosts) {
            QLog.i("ECHippyProxy", 1, "#preloadJsBundle: success");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HippyNativeModuleBase e(HippyEngineContext context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        return new ECToastModule(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HippyNativeModuleBase f(HippyEngineContext context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        return new TKDAccountModule(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HippyNativeModuleBase g(HippyEngineContext context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        return new TKDDebugModule(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HippyNativeModuleBase h(HippyEngineContext context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        return new TKDToastModule(context);
    }

    @Override // com.tencent.ecommerce.biz.hippy.api.IECHippyProxy
    public IECHippyEngine getEngine(int engineId) {
        Object engineInstance = HippyQQEngine.getEngineInstance(engineId);
        if (engineInstance == null) {
            return null;
        }
        if (!(engineInstance instanceof IECHippyEngine)) {
            QLog.w("ECHippyProxy", 1, "#getEngine: " + engineInstance + " is not instance of IECHippyEngine");
            return null;
        }
        return (IECHippyEngine) engineInstance;
    }

    @Override // com.tencent.ecommerce.biz.hippy.api.IECHippyProxy
    public Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getPublicModules(final HippyEngineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        HashMap hashMap = new HashMap();
        Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> releaseModules = ((IHippyModules) QRoute.api(IHippyModules.class)).getReleaseModules(context);
        Intrinsics.checkNotNullExpressionValue(releaseModules, "api(IHippyModules::class\u2026etReleaseModules(context)");
        hashMap.putAll(releaseModules);
        hashMap.put(ECToastModule.class, new Provider() { // from class: com.tencent.mobileqq.qqecommerce.biz.hippy.c
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase e16;
                e16 = g.e(HippyEngineContext.this);
                return e16;
            }
        });
        hashMap.put(TKDAccountModule.class, new Provider() { // from class: com.tencent.mobileqq.qqecommerce.biz.hippy.d
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase f16;
                f16 = g.f(HippyEngineContext.this);
                return f16;
            }
        });
        hashMap.put(TKDDebugModule.class, new Provider() { // from class: com.tencent.mobileqq.qqecommerce.biz.hippy.e
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase g16;
                g16 = g.g(HippyEngineContext.this);
                return g16;
            }
        });
        hashMap.put(TKDToastModule.class, new Provider() { // from class: com.tencent.mobileqq.qqecommerce.biz.hippy.f
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase h16;
                h16 = g.h(HippyEngineContext.this);
                return h16;
            }
        });
        return hashMap;
    }

    @Override // com.tencent.ecommerce.biz.hippy.api.IECHippyProxy
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public a newEngine(Fragment fragment, String moduleName, String hippyUrl, HippyAPIProvider provider, HippyCustomViewCreator customViewCreator, int minModuleVersion) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(hippyUrl, "hippyUrl");
        Intrinsics.checkNotNullParameter(provider, "provider");
        return new a(fragment, af2.b.f25996a.a(fragment.getContext()), moduleName, hippyUrl, provider, customViewCreator, minModuleVersion);
    }

    @Override // com.tencent.ecommerce.biz.hippy.api.IECHippyProxy
    public void preloadJsBundle(String moduleName) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        QLog.i("ECHippyProxy", 1, "#preloadJsBundle: moduleName=" + moduleName);
        if (moduleName.length() == 0) {
            QLog.e("ECHippyProxy", 1, "#getModuleName: module name is null! ");
        } else {
            ((IHippyUpdate) QRoute.api(IHippyUpdate.class)).commonUpdateJsBundle(moduleName, "oldUpdate", new b());
        }
    }
}
