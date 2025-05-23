package com.tencent.timi.game.web.business.impl.plugin;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.module.QQBaseModule;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.timi.game.api.ITimiGameApi;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.jump.api.impl.b;
import com.tencent.timi.game.jump.api.impl.i;
import com.tencent.timi.game.jump.api.impl.n;
import java.util.HashMap;
import vf4.a;

/* compiled from: P */
@HippyNativeModule(name = ESportsModule.TAG)
/* loaded from: classes26.dex */
public class ESportsModule extends QQBaseModule {
    private static final String METHOD_CREATE = "createTeam";
    private static final String METHOD_JOIN = "joinTeam";
    private static final String METHOD_NEARBY_PROFILE = "nearbyProfile";
    private static final String METHOD_OPEN = "open";
    public static final String TAG = "ESportsModule";

    public ESportsModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    private boolean isParamInvalid(HippyMap hippyMap, Promise promise) {
        if (hippyMap != null && hippyMap.size() > 0) {
            HippyQQEngine engineInstance = HippyQQEngine.getEngineInstance(this.mContext.getEngineId());
            if (engineInstance == null) {
                promise.reject("engine is null");
                return true;
            }
            if (TextUtils.isEmpty(engineInstance.getModuleName())) {
                promise.reject("moduleName is empty");
                return true;
            }
            return false;
        }
        promise.reject("params is empty");
        return true;
    }

    private HashMap<String, String> transformData(HippyMap hippyMap) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str : hippyMap.keySet()) {
            hashMap.put(str, String.valueOf(hippyMap.get(str)));
        }
        return hashMap;
    }

    @HippyMethod(name = METHOD_CREATE)
    public void create(HippyMap hippyMap, Promise promise) {
        if (isParamInvalid(hippyMap, promise)) {
            return;
        }
        if (a.b() == null) {
            promise.reject("has no top qActivity");
        } else {
            i.INSTANCE.i(transformData(hippyMap), "");
        }
    }

    @HippyMethod(name = METHOD_JOIN)
    public void join(HippyMap hippyMap, Promise promise) {
        if (isParamInvalid(hippyMap, promise)) {
            return;
        }
        if (a.b() == null) {
            promise.reject("has no top qActivity");
        } else {
            n.INSTANCE.g(transformData(hippyMap));
        }
    }

    @HippyMethod(name = METHOD_NEARBY_PROFILE)
    public void nearbyProfile(HippyMap hippyMap, Promise promise) {
        if (hippyMap != null && hippyMap.size() > 0) {
            if (QBaseActivity.sTopActivity instanceof QBaseActivity) {
                qf4.a aVar = new qf4.a();
                String string = hippyMap.getString("yesId");
                aVar.g(Integer.valueOf(hippyMap.getInt(VirtualAppProxy.KEY_GAME_ID)));
                aVar.j(string);
                aVar.f(hippyMap.getString("currentYesUid"));
                aVar.i(Integer.valueOf(hippyMap.getInt("subSourceId")));
                aVar.h(Integer.valueOf(hippyMap.getInt(WadlProxyConsts.SCENE_ID)));
                ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).openNearbyProfile(aVar);
                return;
            }
            promise.reject("has no top qActivity");
            return;
        }
        promise.reject("params is empty");
    }

    @HippyMethod(name = "open")
    public void open(HippyMap hippyMap, Promise promise) {
        if (isParamInvalid(hippyMap, promise)) {
            return;
        }
        QBaseActivity b16 = a.b();
        if (b16 == null) {
            promise.reject("has no top qActivity");
            return;
        }
        ExpandHallLaunchParam expandHallLaunchParam = new ExpandHallLaunchParam();
        b.INSTANCE.b(transformData(hippyMap), expandHallLaunchParam);
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).openExpandHall(b16, expandHallLaunchParam);
    }
}
