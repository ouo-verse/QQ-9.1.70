package m13;

import com.tencent.hippy.qq.module.QQJsbModule;
import com.tencent.hippy.qq.module.vas.QQTenPayModule;
import com.tencent.hippy.qq.module.vas.VasJSIModule;
import com.tencent.hippy.qq.module.vas.VasModule;
import com.tencent.hippy.qq.module.vas.VasPersonalizedModule;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a implements HippyAPIProvider {

    /* compiled from: P */
    /* renamed from: m13.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    class C10756a implements Provider<HippyNativeModuleBase> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HippyEngineContext f415997a;

        C10756a(HippyEngineContext hippyEngineContext) {
            this.f415997a = hippyEngineContext;
        }

        @Override // com.tencent.mtt.hippy.common.Provider
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HippyNativeModuleBase get() {
            return new QQTenPayModule(this.f415997a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements Provider<HippyNativeModuleBase> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HippyEngineContext f415999a;

        b(HippyEngineContext hippyEngineContext) {
            this.f415999a = hippyEngineContext;
        }

        @Override // com.tencent.mtt.hippy.common.Provider
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HippyNativeModuleBase get() {
            return new VasModule(this.f415999a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class c implements Provider<HippyNativeModuleBase> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HippyEngineContext f416001a;

        c(HippyEngineContext hippyEngineContext) {
            this.f416001a = hippyEngineContext;
        }

        @Override // com.tencent.mtt.hippy.common.Provider
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HippyNativeModuleBase get() {
            return new VasPersonalizedModule(this.f416001a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class d implements Provider<HippyNativeModuleBase> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HippyEngineContext f416003a;

        d(HippyEngineContext hippyEngineContext) {
            this.f416003a = hippyEngineContext;
        }

        @Override // com.tencent.mtt.hippy.common.Provider
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HippyNativeModuleBase get() {
            return new VasJSIModule(this.f416003a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class e implements Provider<HippyNativeModuleBase> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HippyEngineContext f416005a;

        e(HippyEngineContext hippyEngineContext) {
            this.f416005a = hippyEngineContext;
        }

        @Override // com.tencent.mtt.hippy.common.Provider
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HippyNativeModuleBase get() {
            return new QQJsbModule(this.f416005a);
        }
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    public List<Class<? extends HippyViewController>> getControllers() {
        return new ArrayList();
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    public List<Class<? extends HippyJavaScriptModule>> getJavaScriptModules() {
        return null;
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    public Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getNativeModules(HippyEngineContext hippyEngineContext) {
        HashMap hashMap = new HashMap();
        hashMap.put(QQTenPayModule.class, new C10756a(hippyEngineContext));
        hashMap.put(VasModule.class, new b(hippyEngineContext));
        hashMap.put(VasPersonalizedModule.class, new c(hippyEngineContext));
        hashMap.put(VasJSIModule.class, new d(hippyEngineContext));
        hashMap.put(QQJsbModule.class, new e(hippyEngineContext));
        return hashMap;
    }
}
