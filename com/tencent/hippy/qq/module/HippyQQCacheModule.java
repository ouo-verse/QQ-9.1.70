package com.tencent.hippy.qq.module;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import org.json.JSONObject;

/* compiled from: P */
@HippyNativeModule(name = "cache")
/* loaded from: classes7.dex */
public class HippyQQCacheModule extends HippyNativeModuleBase {
    static final String CLASSNAME = "cache";
    private QQCacheModule mCacheModule;

    public HippyQQCacheModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        this.mCacheModule = new QQCacheModule();
    }

    @HippyMethod(name = "cacheBody")
    public void cacheBody(String str) {
        this.mCacheModule.cacheBody(str);
    }

    public void getItem(String str, Promise promise) {
        this.mCacheModule.getItem(str, promise);
    }

    @HippyMethod(name = "multiGet")
    public void multiGet(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        this.mCacheModule.multiGet(jSONObject, promise);
    }

    @HippyMethod(name = "multiRemove")
    public void multiRemove(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        this.mCacheModule.multiRemove(jSONObject, "");
    }

    @HippyMethod(name = "multiSet")
    public void multiSet(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        this.mCacheModule.multiSet(jSONObject, "");
    }

    @HippyMethod(name = "remove")
    public void remove(String str) {
        this.mCacheModule.remove(str);
    }

    @HippyMethod(name = "setItem")
    public void setItem(String str, String str2) {
        this.mCacheModule.setItem(str, str2);
    }
}
