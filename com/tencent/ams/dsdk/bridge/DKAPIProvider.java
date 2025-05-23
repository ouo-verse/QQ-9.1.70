package com.tencent.ams.dsdk.bridge;

import com.tencent.ams.dsdk.core.hippy.DKHippyEngine;
import com.tencent.ams.dsdk.event.DKMethodDispatcher;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DKAPIProvider implements HippyAPIProvider {
    static IPatchRedirector $redirector_;
    private HippyMap adParams;
    private HippyMap globalParams;
    private DKMethodDispatcher mMethodDispatcher;
    private WeakReference<DKHippyEngine> mWeakHippyEngine;

    public DKAPIProvider(Map<String, String> map, Map<String, String> map2, DKMethodDispatcher dKMethodDispatcher, WeakReference<DKHippyEngine> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, map, map2, dKMethodDispatcher, weakReference);
            return;
        }
        this.mMethodDispatcher = null;
        if (map != null && !map.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(map);
                HippyMap hippyMap = new HippyMap();
                this.globalParams = hippyMap;
                hippyMap.pushJSONObject(jSONObject);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        if (map2 != null && !map2.isEmpty()) {
            try {
                JSONObject jSONObject2 = new JSONObject(map2);
                HippyMap hippyMap2 = new HippyMap();
                this.adParams = hippyMap2;
                hippyMap2.pushJSONObject(jSONObject2);
            } catch (Throwable th6) {
                th6.printStackTrace();
            }
        }
        this.mMethodDispatcher = dKMethodDispatcher;
        this.mWeakHippyEngine = weakReference;
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    public List<Class<? extends HippyViewController>> getControllers() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        Class<? extends HippyViewController>[] clsArr = DKHippyComponentConstant.sComponentList;
        if (clsArr != null && clsArr.length > 0) {
            for (Class<? extends HippyViewController> cls : clsArr) {
                arrayList.add(cls);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    public List<Class<? extends HippyJavaScriptModule>> getJavaScriptModules() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    public Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getNativeModules(HippyEngineContext hippyEngineContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Map) iPatchRedirector.redirect((short) 2, (Object) this, (Object) hippyEngineContext);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(DKHippyBridge.class, new Provider<HippyNativeModuleBase>(hippyEngineContext) { // from class: com.tencent.ams.dsdk.bridge.DKAPIProvider.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ HippyEngineContext val$context;

            {
                this.val$context = hippyEngineContext;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DKAPIProvider.this, (Object) hippyEngineContext);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.mtt.hippy.common.Provider
            public HippyNativeModuleBase get() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new DKHippyBridge(this.val$context, DKAPIProvider.this.mMethodDispatcher) : (HippyNativeModuleBase) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        hashMap.put(DKDeviceBridge.class, new Provider<HippyNativeModuleBase>(hippyEngineContext) { // from class: com.tencent.ams.dsdk.bridge.DKAPIProvider.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ HippyEngineContext val$context;

            {
                this.val$context = hippyEngineContext;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DKAPIProvider.this, (Object) hippyEngineContext);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.mtt.hippy.common.Provider
            public HippyNativeModuleBase get() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new DKDeviceBridge(this.val$context, DKAPIProvider.this.mWeakHippyEngine) : (HippyNativeModuleBase) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        return hashMap;
    }
}
