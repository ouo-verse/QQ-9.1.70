package com.qq.e.comm.plugin.router;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class BasePresenter {
    private Map<Class<? extends ModuleApi>, ModuleApi> map;

    public BasePresenter() {
        if (this.map == null) {
            this.map = getModuleApi();
        }
        Map<Class<? extends ModuleApi>, ModuleApi> map = this.map;
        if (map != null && !map.isEmpty()) {
            PublicApiHelper.registerAll(this.map);
        }
    }

    public abstract Map<Class<? extends ModuleApi>, ModuleApi> getModuleApi();

    public void onDestroy() {
        if (this.map == null) {
            this.map = getModuleApi();
        }
        Map<Class<? extends ModuleApi>, ModuleApi> map = this.map;
        if (map != null && !map.isEmpty()) {
            Iterator<Class<? extends ModuleApi>> it = this.map.keySet().iterator();
            if (it.hasNext()) {
                PublicApiHelper.unregister(it.next());
            }
        }
    }
}
