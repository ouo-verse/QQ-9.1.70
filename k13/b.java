package k13;

import com.tencent.mobileqq.vas.hippy.api.impl.ZPlanParadiseHippyApiImpl;
import com.tencent.mobileqq.vas.hippy.api.module.ZPlanParadiseHippyModule;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ.\u0010\b\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00070\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\u000b\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0005\u0018\u00010\tH\u0016J\u001c\u0010\r\u001a\u0016\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\f0\u0005\u0018\u00010\tH\u0016\u00a8\u0006\u0011"}, d2 = {"Lk13/b;", "Lcom/tencent/mtt/hippy/HippyAPIProvider;", "Lcom/tencent/mtt/hippy/HippyEngineContext;", "hippyEngineContext", "", "Ljava/lang/Class;", "Lcom/tencent/mtt/hippy/modules/nativemodules/HippyNativeModuleBase;", "Lcom/tencent/mtt/hippy/common/Provider;", "getNativeModules", "", "Lcom/tencent/mtt/hippy/modules/javascriptmodules/HippyJavaScriptModule;", "getJavaScriptModules", "Lcom/tencent/mtt/hippy/uimanager/HippyViewController;", "getControllers", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b implements HippyAPIProvider {
    /* JADX INFO: Access modifiers changed from: private */
    public static final ZPlanParadiseHippyModule b(HippyEngineContext hippyEngineContext) {
        return new ZPlanParadiseHippyModule(hippyEngineContext);
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    public List<Class<? extends HippyViewController<?>>> getControllers() {
        return Collections.emptyList();
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    public List<Class<? extends HippyJavaScriptModule>> getJavaScriptModules() {
        return Collections.emptyList();
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    public Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getNativeModules(final HippyEngineContext hippyEngineContext) {
        Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> mutableMapOf;
        QLog.i(ZPlanParadiseHippyApiImpl.TAG, 1, "getNativeModules");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(ZPlanParadiseHippyModule.class, new Provider() { // from class: k13.a
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                ZPlanParadiseHippyModule b16;
                b16 = b.b(HippyEngineContext.this);
                return b16;
            }
        }));
        return mutableMapOf;
    }
}
